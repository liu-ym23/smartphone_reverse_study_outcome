package com.android.server;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AlarmManager;
import android.app.BroadcastOptions;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.TriggerEvent;
import android.hardware.TriggerEventListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.net.ConnectivityManager;
import android.net.INetworkPolicyManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IDeviceIdleController;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManagerInternal;
import android.os.PowerSaveState;
import android.os.Process;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.ShellCommand;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.os.WearModeManagerInternal;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.telephony.emergency.EmergencyNumber;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.MutableLong;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.TimeUtils;
import android.util.Xml;
import com.android.internal.app.IBatteryStats;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.jobs.ArrayUtils;
import com.android.internal.util.jobs.DumpUtils;
import com.android.internal.util.jobs.FastXmlSerializer;
import com.android.internal.util.jobs.XmlUtils;
import com.android.modules.expresslog.Counter;
import com.android.server.alarm.HeartbeatStats;
import com.android.server.am.BatteryStatsService;
import com.android.server.am.HostingRecord;
import com.android.server.am.IZswContentProviderHelper;
import com.android.server.companion.association.DisassociationProcessor;
import com.android.server.deviceidle.ConstraintController;
import com.android.server.deviceidle.DeviceIdleConstraintTracker;
import com.android.server.deviceidle.Flags;
import com.android.server.deviceidle.IDeviceIdleConstraint;
import com.android.server.deviceidle.TvConstraintController;
import com.android.server.job.controllers.JobStatus;
import com.android.server.net.NetworkPolicyManagerInternal;
import com.android.server.power.IBytedancePowerAdvisor;
import com.android.server.power.teardown.swteardown.EventTeardownResult;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import com.android.server.utils.UserSettingDeviceConfigMediator;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
public class DeviceIdleController extends SystemService implements AnyMotionDetector.DeviceIdleCallback {
    private static final int ACTIVE_REASON_ALARM = 7;
    private static final int ACTIVE_REASON_CHARGING = 3;
    private static final int ACTIVE_REASON_EMERGENCY_CALL = 8;
    private static final int ACTIVE_REASON_FORCED = 6;
    private static final int ACTIVE_REASON_FROM_BINDER_CALL = 5;
    private static final int ACTIVE_REASON_MODE_MANAGER = 9;
    private static final int ACTIVE_REASON_MOTION = 1;
    private static final int ACTIVE_REASON_ONBODY = 10;
    private static final int ACTIVE_REASON_SCREEN = 2;
    private static final int ACTIVE_REASON_UNKNOWN = 0;
    private static final int ACTIVE_REASON_UNLOCKED = 4;
    private static final boolean COMPRESS_TIME = false;
    private static final boolean DEBUG = false;
    private static final int EVENT_BUFFER_SIZE = 100;
    private static final int EVENT_DEEP_IDLE = 4;
    private static final int EVENT_DEEP_MAINTENANCE = 5;
    private static final int EVENT_LIGHT_IDLE = 2;
    private static final int EVENT_LIGHT_MAINTENANCE = 3;
    private static final int EVENT_NORMAL = 1;
    private static final int EVENT_NULL = 0;
    static final int LIGHT_STATE_ACTIVE = 0;
    static final int LIGHT_STATE_IDLE = 4;
    static final int LIGHT_STATE_IDLE_MAINTENANCE = 6;
    static final int LIGHT_STATE_INACTIVE = 1;
    static final int LIGHT_STATE_OVERRIDE = 7;
    static final int LIGHT_STATE_WAITING_FOR_NETWORK = 5;
    private static final int MSG_FINISH_IDLE_OP = 8;
    private static final int MSG_REPORT_ACTIVE = 5;
    private static final int MSG_REPORT_IDLE_OFF = 4;
    private static final int MSG_REPORT_IDLE_ON = 2;
    private static final int MSG_REPORT_IDLE_ON_LIGHT = 3;
    static final int MSG_REPORT_STATIONARY_STATUS = 7;
    private static final int MSG_REPORT_TEMP_APP_WHITELIST_ADDED_TO_NPMS = 14;
    private static final int MSG_REPORT_TEMP_APP_WHITELIST_CHANGED = 13;
    private static final int MSG_REPORT_TEMP_APP_WHITELIST_REMOVED_TO_NPMS = 15;
    private static final int MSG_SEND_CONSTRAINT_MONITORING = 10;
    static final int MSG_TEMP_APP_WHITELIST_TIMEOUT = 6;
    private static final int MSG_WRITE_CONFIG = 1;
    static final int STATE_ACTIVE = 0;
    static final int STATE_IDLE = 5;
    static final int STATE_IDLE_MAINTENANCE = 6;
    static final int STATE_IDLE_PENDING = 2;
    static final int STATE_INACTIVE = 1;
    static final int STATE_LOCATING = 4;
    static final int STATE_QUICK_DOZE_DELAY = 7;
    static final int STATE_SENSING = 3;
    private static final String TAG = "DeviceIdleController";
    private static final String USER_ALLOWLIST_ADDITION_METRIC_ID = "battery.value_app_added_to_power_allowlist";
    private static final String USER_ALLOWLIST_REMOVAL_METRIC_ID = "battery.value_app_removed_from_power_allowlist";
    private int mActiveIdleOpCount;
    private PowerManager.WakeLock mActiveIdleWakeLock;
    private int mActiveReason;
    private AlarmManager mAlarmManager;
    private boolean mAlarmsActive;
    private AnyMotionDetector mAnyMotionDetector;
    private final AppStateTrackerImpl mAppStateTracker;
    private boolean mBatterySaverEnabled;
    private IBatteryStats mBatteryStats;
    BinderService mBinderService;
    private boolean mCharging;
    public final AtomicFile mConfigFile;
    private Constants mConstants;
    private ConstraintController mConstraintController;
    private final ArrayMap<IDeviceIdleConstraint, DeviceIdleConstraintTracker> mConstraints;
    private long mCurLightIdleBudget;
    final AlarmManager.OnAlarmListener mDeepAlarmListener;
    private boolean mDeepEnabled;
    private final EmergencyCallListener mEmergencyCallListener;
    private final int[] mEventCmds;
    private final String[] mEventReasons;
    private final long[] mEventTimes;
    private boolean mForceIdle;
    private boolean mForceModeManagerOffBodyState;
    private boolean mForceModeManagerQuickDozeRequest;
    private final LocationListener mGenericLocationListener;
    private PowerManager.WakeLock mGoingIdleWakeLock;
    private final LocationListener mGpsLocationListener;
    final MyHandler mHandler;
    private boolean mHasFusedLocation;
    private boolean mHasGps;
    private Intent mIdleIntent;
    private Bundle mIdleIntentOptions;
    private final IIntentReceiver mIdleStartedDoneReceiver;
    private long mInactiveTimeout;
    private final Injector mInjector;
    private final BroadcastReceiver mInteractivityReceiver;
    private final boolean mIsLocationPrefetchEnabled;
    private boolean mIsOffBody;
    private boolean mJobsActive;
    private Location mLastGenericLocation;
    private Location mLastGpsLocation;
    private long mLastMotionEventElapsed;
    private final AlarmManager.OnAlarmListener mLightAlarmListener;
    private boolean mLightEnabled;
    private Intent mLightIdleIntent;
    private Bundle mLightIdleIntentOptions;
    private int mLightState;
    private ActivityManagerInternal mLocalActivityManager;
    private ActivityTaskManagerInternal mLocalActivityTaskManager;
    private AlarmManagerInternal mLocalAlarmManager;
    private PowerManagerInternal mLocalPowerManager;
    private DeviceIdleInternal mLocalService;
    private boolean mLocated;
    private boolean mLocating;
    private LocationRequest mLocationRequest;
    private long mMaintenanceStartTime;
    final ModeManagerOffBodyStateConsumer mModeManagerOffBodyStateConsumer;
    final ModeManagerQuickDozeRequestConsumer mModeManagerQuickDozeRequestConsumer;
    private boolean mModeManagerRequestedQuickDoze;
    final MotionListener mMotionListener;
    private final AlarmManager.OnAlarmListener mMotionRegistrationAlarmListener;
    private Sensor mMotionSensor;
    private final AlarmManager.OnAlarmListener mMotionTimeoutAlarmListener;
    private boolean mNetworkConnected;
    private INetworkPolicyManager mNetworkPolicyManager;
    private NetworkPolicyManagerInternal mNetworkPolicyManagerInternal;
    private long mNextAlarmTime;
    private long mNextIdleDelay;
    private long mNextIdlePendingDelay;
    private long mNextLightAlarmTime;
    private long mNextLightIdleDelay;
    private long mNextLightIdleDelayFlex;
    private long mNextSensingTimeoutAlarmTime;
    private boolean mNotMoving;
    private int mNumBlockingConstraints;
    private PackageManagerInternal mPackageManagerInternal;
    private PowerManager mPowerManager;
    private Bundle mPowerSaveTempWhilelistChangedOptions;
    private Intent mPowerSaveTempWhitelistChangedIntent;
    private int[] mPowerSaveWhitelistAllAppIdArray;
    private final SparseBooleanArray mPowerSaveWhitelistAllAppIds;
    private final ArrayMap<String, Integer> mPowerSaveWhitelistApps;
    private final ArrayMap<String, Integer> mPowerSaveWhitelistAppsExceptIdle;
    private Intent mPowerSaveWhitelistChangedIntent;
    private Bundle mPowerSaveWhitelistChangedOptions;
    private int[] mPowerSaveWhitelistExceptIdleAppIdArray;
    private final SparseBooleanArray mPowerSaveWhitelistExceptIdleAppIds;
    private final SparseBooleanArray mPowerSaveWhitelistSystemAppIds;
    private final SparseBooleanArray mPowerSaveWhitelistSystemAppIdsExceptIdle;
    private int[] mPowerSaveWhitelistUserAppIdArray;
    private final SparseBooleanArray mPowerSaveWhitelistUserAppIds;
    private final ArrayMap<String, Integer> mPowerSaveWhitelistUserApps;
    private final ArraySet<String> mPowerSaveWhitelistUserAppsExceptIdle;
    private boolean mQuickDozeActivated;
    private boolean mQuickDozeActivatedWhileIdling;
    private final BroadcastReceiver mReceiver;
    private ArrayMap<String, Integer> mRemovedFromSystemWhitelistApps;
    private boolean mScreenLocked;
    private ActivityTaskManagerInternal.ScreenObserver mScreenObserver;
    private boolean mScreenOn;
    private final AlarmManager.OnAlarmListener mSensingTimeoutAlarmListener;
    private SensorManager mSensorManager;
    private int mState;
    private final ArraySet<DeviceIdleInternal.StationaryListener> mStationaryListeners;
    private final ArraySet<PowerAllowlistInternal.TempAllowlistChangeListener> mTempAllowlistChangeListeners;
    private int[] mTempWhitelistAppIdArray;
    final SparseArray<Pair<MutableLong, String>> mTempWhitelistAppIdEndTimes;
    private final boolean mUseMotionSensor;

    final class BinderService extends IDeviceIdleController.Stub {
        final /* synthetic */ DeviceIdleController this$0;

        BinderService(DeviceIdleController this$0) {
            this.this$0 = this$0;
        }

        public void addPowerSaveWhitelistApp(String name) {
            addPowerSaveWhitelistApps(Collections.singletonList(name));
        }

        public int addPowerSaveWhitelistApps(List<String> packageNames) {
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            long ident = Binder.clearCallingIdentity();
            int r2 = DeviceIdleController.m183$$Nest$maddPowerSaveWhitelistAppsInternal(this.this$0, packageNames);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void removePowerSaveWhitelistApp(String name) {
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            long ident = Binder.clearCallingIdentity();
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L4:
            if (this.this$0.removePowerSaveWhitelistAppInternal(name) == false) goto L6;
        L12:
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            if (DeviceIdleController.m175$$Nest$fgetmPowerSaveWhitelistAppsExceptIdle(this.this$0).containsKey(name) == false) goto L12;
            throw new UnsupportedOperationException("Cannot remove system whitelisted app");     // Catch: Throwable -> L10
        }

        public void removeSystemPowerWhitelistApp(String name) {
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            long ident = Binder.clearCallingIdentity();
            this.this$0.removeSystemPowerWhitelistAppInternal(name);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void restoreSystemPowerWhitelistApp(String name) {
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
            long ident = Binder.clearCallingIdentity();
            this.this$0.restoreSystemPowerWhitelistAppInternal(name);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public String[] getRemovedSystemPowerWhitelistApps() {
            return DeviceIdleController.m187$$Nest$mgetRemovedSystemPowerWhitelistAppsInternal(this.this$0, Binder.getCallingUid(), UserHandle.getCallingUserId());
        }

        public String[] getSystemPowerWhitelistExceptIdle() {
            return DeviceIdleController.m188$$Nest$mgetSystemPowerWhitelistExceptIdleInternal(this.this$0, Binder.getCallingUid(), UserHandle.getCallingUserId());
        }

        public String[] getSystemPowerWhitelist() {
            return DeviceIdleController.m189$$Nest$mgetSystemPowerWhitelistInternal(this.this$0, Binder.getCallingUid(), UserHandle.getCallingUserId());
        }

        public String[] getUserPowerWhitelist() {
            return DeviceIdleController.m191$$Nest$mgetUserPowerWhitelistInternal(this.this$0, Binder.getCallingUid(), UserHandle.getCallingUserId());
        }

        public String[] getFullPowerWhitelistExceptIdle() {
            return DeviceIdleController.m184$$Nest$mgetFullPowerWhitelistExceptIdleInternal(this.this$0, Binder.getCallingUid(), UserHandle.getCallingUserId());
        }

        public String[] getFullPowerWhitelist() {
            return DeviceIdleController.m185$$Nest$mgetFullPowerWhitelistInternal(this.this$0, Binder.getCallingUid(), UserHandle.getCallingUserId());
        }

        public int[] getAppIdWhitelistExceptIdle() {
            return this.this$0.getAppIdWhitelistExceptIdleInternal();
        }

        public int[] getAppIdWhitelist() {
            return this.this$0.getAppIdWhitelistInternal();
        }

        public int[] getAppIdUserWhitelist() {
            return this.this$0.getAppIdUserWhitelistInternal();
        }

        public int[] getAppIdTempWhitelist() {
            return this.this$0.getAppIdTempWhitelistInternal();
        }

        public boolean isPowerSaveWhitelistExceptIdleApp(String name) {
            if (DeviceIdleController.m174$$Nest$fgetmPackageManagerInternal(this.this$0).filterAppAccess(name, Binder.getCallingUid(), UserHandle.getCallingUserId()) == false) goto L7;
            return false;
        L7:
            return this.this$0.isPowerSaveWhitelistExceptIdleAppInternal(name);
        }

        public boolean isPowerSaveWhitelistApp(String name) {
            if (DeviceIdleController.m174$$Nest$fgetmPackageManagerInternal(this.this$0).filterAppAccess(name, Binder.getCallingUid(), UserHandle.getCallingUserId()) == false) goto L7;
            return false;
        L7:
            return this.this$0.isPowerSaveWhitelistAppInternal(name);
        }

        public long whitelistAppTemporarily(String packageName, int userId, int reasonCode, String reason) throws RemoteException {
            long durationMs = Math.max(JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY, DeviceIdleController.m157$$Nest$fgetmConstants(this.this$0).MAX_TEMP_APP_ALLOWLIST_DURATION_MS / 2);
            this.this$0.addPowerSaveTempAllowlistAppChecked(packageName, durationMs, userId, reasonCode, reason);
            return durationMs;
        }

        public void addPowerSaveTempWhitelistApp(String packageName, long duration, int userId, int reasonCode, String reason) throws RemoteException {
            this.this$0.addPowerSaveTempAllowlistAppChecked(packageName, duration, userId, reasonCode, reason);
        }

        public long addPowerSaveTempWhitelistAppForMms(String packageName, int userId, int reasonCode, String reason) throws RemoteException {
            long durationMs = DeviceIdleController.m157$$Nest$fgetmConstants(this.this$0).MMS_TEMP_APP_ALLOWLIST_DURATION_MS;
            this.this$0.addPowerSaveTempAllowlistAppChecked(packageName, durationMs, userId, reasonCode, reason);
            return durationMs;
        }

        public long addPowerSaveTempWhitelistAppForSms(String packageName, int userId, int reasonCode, String reason) throws RemoteException {
            long durationMs = DeviceIdleController.m157$$Nest$fgetmConstants(this.this$0).SMS_TEMP_APP_ALLOWLIST_DURATION_MS;
            this.this$0.addPowerSaveTempAllowlistAppChecked(packageName, durationMs, userId, reasonCode, reason);
            return durationMs;
        }

        public void removePowerSaveTempWhitelistApp(String packageName, int userId) throws RemoteException {
            this.this$0.removePowerSaveTempAllowlistAppChecked(packageName, userId);
        }

        public void exitIdle(String reason) {
            exitIdle_enforcePermission();
            long ident = Binder.clearCallingIdentity();
            this.this$0.exitIdleInternal(reason);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(ident);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            this.this$0.dump(fd, pw, args);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new Shell(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }
    }

    public final class Constants extends ContentObserver implements DeviceConfig.OnPropertiesChangedListener {
        private static final long DEFAULT_IDLE_AFTER_INACTIVE_TIMEOUT_SMALL_BATTERY = 60000;
        private static final long DEFAULT_INACTIVE_TIMEOUT_SMALL_BATTERY = 60000;
        private static final String KEY_FLEX_TIME_SHORT = "flex_time_short";
        private static final String KEY_IDLE_AFTER_INACTIVE_TIMEOUT = "idle_after_inactive_to";
        private static final String KEY_IDLE_FACTOR = "idle_factor";
        private static final String KEY_IDLE_PENDING_FACTOR = "idle_pending_factor";
        private static final String KEY_IDLE_PENDING_TIMEOUT = "idle_pending_to";
        private static final String KEY_IDLE_TIMEOUT = "idle_to";
        private static final String KEY_INACTIVE_TIMEOUT = "inactive_to";
        private static final String KEY_LIGHT_IDLE_AFTER_INACTIVE_TIMEOUT = "light_after_inactive_to";
        private static final String KEY_LIGHT_IDLE_FACTOR = "light_idle_factor";
        private static final String KEY_LIGHT_IDLE_FLEX_LINEAR_INCREASE_FACTOR_MS = "light_idle_flex_linear_increase_factor_ms";
        private static final String KEY_LIGHT_IDLE_INCREASE_LINEARLY = "light_idle_increase_linearly";
        private static final String KEY_LIGHT_IDLE_LINEAR_INCREASE_FACTOR_MS = "light_idle_linear_increase_factor_ms";
        private static final String KEY_LIGHT_IDLE_MAINTENANCE_MAX_BUDGET = "light_idle_maintenance_max_budget";
        private static final String KEY_LIGHT_IDLE_MAINTENANCE_MIN_BUDGET = "light_idle_maintenance_min_budget";
        private static final String KEY_LIGHT_IDLE_TIMEOUT = "light_idle_to";
        private static final String KEY_LIGHT_IDLE_TIMEOUT_INITIAL_FLEX = "light_idle_to_initial_flex";
        private static final String KEY_LIGHT_IDLE_TIMEOUT_MAX_FLEX = "light_max_idle_to_flex";
        private static final String KEY_LIGHT_MAX_IDLE_TIMEOUT = "light_max_idle_to";
        private static final String KEY_LOCATING_TIMEOUT = "locating_to";
        private static final String KEY_LOCATION_ACCURACY = "location_accuracy";
        private static final String KEY_MAX_IDLE_PENDING_TIMEOUT = "max_idle_pending_to";
        private static final String KEY_MAX_IDLE_TIMEOUT = "max_idle_to";
        private static final String KEY_MAX_TEMP_APP_ALLOWLIST_DURATION_MS = "max_temp_app_allowlist_duration_ms";
        private static final String KEY_MIN_DEEP_MAINTENANCE_TIME = "min_deep_maintenance_time";
        private static final String KEY_MIN_LIGHT_MAINTENANCE_TIME = "min_light_maintenance_time";
        private static final String KEY_MIN_TIME_TO_ALARM = "min_time_to_alarm";
        private static final String KEY_MMS_TEMP_APP_ALLOWLIST_DURATION_MS = "mms_temp_app_allowlist_duration_ms";
        private static final String KEY_MOTION_INACTIVE_TIMEOUT = "motion_inactive_to";
        private static final String KEY_MOTION_INACTIVE_TIMEOUT_FLEX = "motion_inactive_to_flex";
        private static final String KEY_NOTIFICATION_ALLOWLIST_DURATION_MS = "notification_allowlist_duration_ms";
        private static final String KEY_QUICK_DOZE_DELAY_TIMEOUT = "quick_doze_delay_to";
        private static final String KEY_SENSING_TIMEOUT = "sensing_to";
        private static final String KEY_SMS_TEMP_APP_ALLOWLIST_DURATION_MS = "sms_temp_app_allowlist_duration_ms";
        private static final String KEY_USE_MODE_MANAGER = "use_mode_manager";
        private static final String KEY_USE_WINDOW_ALARMS = "use_window_alarms";
        private static final String KEY_WAIT_FOR_UNLOCK = "wait_for_unlock";
        public long FLEX_TIME_SHORT;
        public long IDLE_AFTER_INACTIVE_TIMEOUT;
        public float IDLE_FACTOR;
        public float IDLE_PENDING_FACTOR;
        public long IDLE_PENDING_TIMEOUT;
        public long IDLE_TIMEOUT;
        public long INACTIVE_TIMEOUT;
        public long LIGHT_IDLE_AFTER_INACTIVE_TIMEOUT;
        public float LIGHT_IDLE_FACTOR;
        public long LIGHT_IDLE_FLEX_LINEAR_INCREASE_FACTOR_MS;
        public boolean LIGHT_IDLE_INCREASE_LINEARLY;
        public long LIGHT_IDLE_LINEAR_INCREASE_FACTOR_MS;
        public long LIGHT_IDLE_MAINTENANCE_MAX_BUDGET;
        public long LIGHT_IDLE_MAINTENANCE_MIN_BUDGET;
        public long LIGHT_IDLE_TIMEOUT;
        public long LIGHT_IDLE_TIMEOUT_INITIAL_FLEX;
        public long LIGHT_IDLE_TIMEOUT_MAX_FLEX;
        public long LIGHT_MAX_IDLE_TIMEOUT;
        public long LOCATING_TIMEOUT;
        public float LOCATION_ACCURACY;
        public long MAX_IDLE_PENDING_TIMEOUT;
        public long MAX_IDLE_TIMEOUT;
        public long MAX_TEMP_APP_ALLOWLIST_DURATION_MS;
        public long MIN_DEEP_MAINTENANCE_TIME;
        public long MIN_LIGHT_MAINTENANCE_TIME;
        public long MIN_TIME_TO_ALARM;
        public long MMS_TEMP_APP_ALLOWLIST_DURATION_MS;
        public long MOTION_INACTIVE_TIMEOUT;
        public long MOTION_INACTIVE_TIMEOUT_FLEX;
        public long NOTIFICATION_ALLOWLIST_DURATION_MS;
        public long QUICK_DOZE_DELAY_TIMEOUT;
        public long SENSING_TIMEOUT;
        public long SMS_TEMP_APP_ALLOWLIST_DURATION_MS;
        public boolean USE_MODE_MANAGER;
        public boolean USE_WINDOW_ALARMS;
        public boolean WAIT_FOR_UNLOCK;
        private long mDefaultFlexTimeShort;
        private long mDefaultIdleAfterInactiveTimeout;
        private float mDefaultIdleFactor;
        private float mDefaultIdlePendingFactor;
        private long mDefaultIdlePendingTimeout;
        private long mDefaultIdleTimeout;
        private long mDefaultInactiveTimeout;
        private long mDefaultLightIdleAfterInactiveTimeout;
        private float mDefaultLightIdleFactor;
        private long mDefaultLightIdleFlexLinearIncreaseFactorMs;
        private boolean mDefaultLightIdleIncreaseLinearly;
        private long mDefaultLightIdleLinearIncreaseFactorMs;
        private long mDefaultLightIdleMaintenanceMaxBudget;
        private long mDefaultLightIdleMaintenanceMinBudget;
        private long mDefaultLightIdleTimeout;
        private long mDefaultLightIdleTimeoutInitialFlex;
        private long mDefaultLightIdleTimeoutMaxFlex;
        private long mDefaultLightMaxIdleTimeout;
        private long mDefaultLocatingTimeout;
        private float mDefaultLocationAccuracy;
        private long mDefaultMaxIdlePendingTimeout;
        private long mDefaultMaxIdleTimeout;
        private long mDefaultMaxTempAppAllowlistDurationMs;
        private long mDefaultMinDeepMaintenanceTime;
        private long mDefaultMinLightMaintenanceTime;
        private long mDefaultMinTimeToAlarm;
        private long mDefaultMmsTempAppAllowlistDurationMs;
        private long mDefaultMotionInactiveTimeout;
        private long mDefaultMotionInactiveTimeoutFlex;
        private long mDefaultNotificationAllowlistDurationMs;
        private long mDefaultQuickDozeDelayTimeout;
        private long mDefaultSensingTimeout;
        private long mDefaultSmsTempAppAllowlistDurationMs;
        private boolean mDefaultUseModeManager;
        private boolean mDefaultUseWindowAlarms;
        private boolean mDefaultWaitForUnlock;
        private final ContentResolver mResolver;
        private final boolean mSmallBatteryDevice;
        private final UserSettingDeviceConfigMediator mUserSettingDeviceConfigMediator;
        final /* synthetic */ DeviceIdleController this$0;

        public Constants(DeviceIdleController this$0, Handler handler, ContentResolver resolver) {
            this.this$0 = this$0;
            super(handler);
            this.mDefaultFlexTimeShort = 60000;
            this.mDefaultLightIdleAfterInactiveTimeout = 240000;
            this.mDefaultLightIdleTimeout = 300000;
            this.mDefaultLightIdleTimeoutInitialFlex = 60000;
            this.mDefaultLightIdleTimeoutMaxFlex = HeartbeatStats.MAX_NAT_TIME_MS;
            this.mDefaultLightIdleFactor = 2.0f;
            this.mDefaultLightIdleLinearIncreaseFactorMs = this.mDefaultLightIdleTimeout;
            this.mDefaultLightIdleFlexLinearIncreaseFactorMs = this.mDefaultLightIdleTimeoutInitialFlex;
            this.mDefaultLightMaxIdleTimeout = HeartbeatStats.MAX_NAT_TIME_MS;
            this.mDefaultLightIdleMaintenanceMinBudget = 60000;
            this.mDefaultLightIdleMaintenanceMaxBudget = 300000;
            this.mDefaultMinLightMaintenanceTime = 5000;
            this.mDefaultMinDeepMaintenanceTime = 30000;
            this.mDefaultInactiveTimeout = 825000;
            this.mDefaultSensingTimeout = 120000;
            this.mDefaultLocatingTimeout = 30000;
            this.mDefaultLocationAccuracy = 20.0f;
            this.mDefaultMotionInactiveTimeout = 600000;
            this.mDefaultMotionInactiveTimeoutFlex = 60000;
            this.mDefaultIdleAfterInactiveTimeout = 825000;
            this.mDefaultIdlePendingTimeout = 300000;
            this.mDefaultMaxIdlePendingTimeout = 300000;
            this.mDefaultIdlePendingFactor = 2.0f;
            this.mDefaultQuickDozeDelayTimeout = 60000;
            this.mDefaultIdleTimeout = 3600000;
            this.mDefaultMaxIdleTimeout = 21600000;
            this.mDefaultIdleFactor = 2.0f;
            this.mDefaultMinTimeToAlarm = 1800000;
            this.mDefaultMaxTempAppAllowlistDurationMs = 300000;
            this.mDefaultMmsTempAppAllowlistDurationMs = 60000;
            this.mDefaultSmsTempAppAllowlistDurationMs = 20000;
            this.mDefaultNotificationAllowlistDurationMs = 30000;
            this.mDefaultWaitForUnlock = true;
            this.mDefaultUseWindowAlarms = true;
            this.mDefaultUseModeManager = false;
            this.FLEX_TIME_SHORT = this.mDefaultFlexTimeShort;
            this.LIGHT_IDLE_AFTER_INACTIVE_TIMEOUT = this.mDefaultLightIdleAfterInactiveTimeout;
            this.LIGHT_IDLE_TIMEOUT = this.mDefaultLightIdleTimeout;
            this.LIGHT_IDLE_TIMEOUT_INITIAL_FLEX = this.mDefaultLightIdleTimeoutInitialFlex;
            this.LIGHT_IDLE_TIMEOUT_MAX_FLEX = this.mDefaultLightIdleTimeoutMaxFlex;
            this.LIGHT_IDLE_FACTOR = this.mDefaultLightIdleFactor;
            this.LIGHT_IDLE_INCREASE_LINEARLY = this.mDefaultLightIdleIncreaseLinearly;
            this.LIGHT_IDLE_LINEAR_INCREASE_FACTOR_MS = this.mDefaultLightIdleLinearIncreaseFactorMs;
            this.LIGHT_IDLE_FLEX_LINEAR_INCREASE_FACTOR_MS = this.mDefaultLightIdleFlexLinearIncreaseFactorMs;
            this.LIGHT_MAX_IDLE_TIMEOUT = this.mDefaultLightMaxIdleTimeout;
            this.LIGHT_IDLE_MAINTENANCE_MIN_BUDGET = this.mDefaultLightIdleMaintenanceMinBudget;
            this.LIGHT_IDLE_MAINTENANCE_MAX_BUDGET = this.mDefaultLightIdleMaintenanceMaxBudget;
            this.MIN_LIGHT_MAINTENANCE_TIME = this.mDefaultMinLightMaintenanceTime;
            this.MIN_DEEP_MAINTENANCE_TIME = this.mDefaultMinDeepMaintenanceTime;
            this.INACTIVE_TIMEOUT = this.mDefaultInactiveTimeout;
            this.SENSING_TIMEOUT = this.mDefaultSensingTimeout;
            this.LOCATING_TIMEOUT = this.mDefaultLocatingTimeout;
            this.LOCATION_ACCURACY = this.mDefaultLocationAccuracy;
            this.MOTION_INACTIVE_TIMEOUT = this.mDefaultMotionInactiveTimeout;
            this.MOTION_INACTIVE_TIMEOUT_FLEX = this.mDefaultMotionInactiveTimeoutFlex;
            this.IDLE_AFTER_INACTIVE_TIMEOUT = this.mDefaultIdleAfterInactiveTimeout;
            this.IDLE_PENDING_TIMEOUT = this.mDefaultIdlePendingTimeout;
            this.MAX_IDLE_PENDING_TIMEOUT = this.mDefaultMaxIdlePendingTimeout;
            this.IDLE_PENDING_FACTOR = this.mDefaultIdlePendingFactor;
            this.QUICK_DOZE_DELAY_TIMEOUT = this.mDefaultQuickDozeDelayTimeout;
            this.IDLE_TIMEOUT = this.mDefaultIdleTimeout;
            this.MAX_IDLE_TIMEOUT = this.mDefaultMaxIdleTimeout;
            this.IDLE_FACTOR = this.mDefaultIdleFactor;
            this.MIN_TIME_TO_ALARM = this.mDefaultMinTimeToAlarm;
            this.MAX_TEMP_APP_ALLOWLIST_DURATION_MS = this.mDefaultMaxTempAppAllowlistDurationMs;
            this.MMS_TEMP_APP_ALLOWLIST_DURATION_MS = this.mDefaultMmsTempAppAllowlistDurationMs;
            this.SMS_TEMP_APP_ALLOWLIST_DURATION_MS = this.mDefaultSmsTempAppAllowlistDurationMs;
            this.NOTIFICATION_ALLOWLIST_DURATION_MS = this.mDefaultNotificationAllowlistDurationMs;
            this.WAIT_FOR_UNLOCK = this.mDefaultWaitForUnlock;
            this.USE_WINDOW_ALARMS = this.mDefaultUseWindowAlarms;
            this.USE_MODE_MANAGER = this.mDefaultUseModeManager;
            this.mUserSettingDeviceConfigMediator = new UserSettingDeviceConfigMediator.SettingsOverridesIndividualMediator(',');
            this.mResolver = resolver;
            initDefault();
            this.mSmallBatteryDevice = ActivityManager.isSmallBatteryDevice();
            if (this.mSmallBatteryDevice == false) goto L5;
            this.INACTIVE_TIMEOUT = 60000;
            this.IDLE_AFTER_INACTIVE_TIMEOUT = 60000;
        L5:
            DeviceConfig.addOnPropertiesChangedListener("device_idle", AppSchedulingModuleThread.getExecutor(), this);
            this.mResolver.registerContentObserver(Settings.Global.getUriFor("device_idle_constants"), false, this);
            updateSettingsConstantLocked();
            this.mUserSettingDeviceConfigMediator.setDeviceConfigProperties(DeviceConfig.getProperties("device_idle", new String[0]));
            updateConstantsLocked();
        }

        private void initDefault() {
            Resources res = this.this$0.getContext().getResources();
            this.mDefaultFlexTimeShort = getTimeout(res.getInteger(R.integer.device_idle_location_accuracy), this.mDefaultFlexTimeShort);
            this.mDefaultLightIdleAfterInactiveTimeout = getTimeout(res.getInteger(R.integer.device_idle_mms_temp_app_allowlist_duration_ms), this.mDefaultLightIdleAfterInactiveTimeout);
            this.mDefaultLightIdleTimeout = getTimeout(res.getInteger(R.integer.dock_enter_exit_duration), this.mDefaultLightIdleTimeout);
            this.mDefaultLightIdleTimeoutInitialFlex = getTimeout(res.getInteger(R.integer.device_idle_sms_temp_app_allowlist_duration_ms), this.mDefaultLightIdleTimeoutInitialFlex);
            this.mDefaultLightIdleTimeoutMaxFlex = getTimeout(res.getInteger(R.integer.disabled_alpha_animation_duration), this.mDefaultLightIdleTimeoutMaxFlex);
            this.mDefaultLightIdleFactor = res.getFloat(R.integer.device_idle_motion_inactive_to_flex_ms);
            this.mDefaultLightIdleIncreaseLinearly = res.getBoolean(R.bool.kg_top_align_page_shrink_on_bouncer_visible);
            this.mDefaultLightIdleLinearIncreaseFactorMs = getTimeout(res.getInteger(R.integer.device_idle_notification_allowlist_duration_ms), this.mDefaultLightIdleLinearIncreaseFactorMs);
            this.mDefaultLightIdleFlexLinearIncreaseFactorMs = getTimeout(res.getInteger(R.integer.device_idle_motion_inactive_to_ms), this.mDefaultLightIdleFlexLinearIncreaseFactorMs);
            this.mDefaultLightMaxIdleTimeout = getTimeout(res.getInteger(R.integer.kg_carousel_angle), this.mDefaultLightMaxIdleTimeout);
            this.mDefaultLightIdleMaintenanceMinBudget = getTimeout(res.getInteger(R.integer.device_idle_sensing_to_ms), this.mDefaultLightIdleMaintenanceMinBudget);
            this.mDefaultLightIdleMaintenanceMaxBudget = getTimeout(res.getInteger(R.integer.device_idle_quick_doze_delay_to_ms), this.mDefaultLightIdleMaintenanceMaxBudget);
            this.mDefaultMinLightMaintenanceTime = getTimeout(res.getInteger(R.integer.leanback_setup_alpha_activity_out_bkg_delay), this.mDefaultMinLightMaintenanceTime);
            this.mDefaultMinDeepMaintenanceTime = getTimeout(res.getInteger(R.integer.leanback_setup_alpha_activity_in_bkg_duration), this.mDefaultMinDeepMaintenanceTime);
            this.mDefaultInactiveTimeout = getTimeout(res.getInteger(R.integer.device_idle_min_time_to_alarm_ms), this.mDefaultInactiveTimeout);
            this.mDefaultSensingTimeout = getTimeout(res.getInteger(R.integer.leanback_setup_alpha_forward_in_content_duration), this.mDefaultSensingTimeout);
            this.mDefaultLocatingTimeout = getTimeout(res.getInteger(R.integer.kg_glowpad_rotation_offset), this.mDefaultLocatingTimeout);
            this.mDefaultLocationAccuracy = res.getFloat(R.integer.kg_security_flipper_weight);
            this.mDefaultMotionInactiveTimeout = getTimeout(res.getInteger(R.integer.leanback_setup_alpha_backward_out_content_delay), this.mDefaultMotionInactiveTimeout);
            this.mDefaultMotionInactiveTimeoutFlex = getTimeout(res.getInteger(R.integer.leanback_setup_alpha_backward_in_content_duration), this.mDefaultMotionInactiveTimeoutFlex);
            this.mDefaultIdleAfterInactiveTimeout = getTimeout(res.getInteger(R.integer.device_idle_max_idle_pending_to_ms), this.mDefaultIdleAfterInactiveTimeout);
            this.mDefaultIdlePendingTimeout = getTimeout(res.getInteger(R.integer.device_idle_min_deep_maintenance_time_ms), this.mDefaultIdlePendingTimeout);
            this.mDefaultMaxIdlePendingTimeout = getTimeout(res.getInteger(R.integer.kg_selector_gravity), this.mDefaultMaxIdlePendingTimeout);
            this.mDefaultIdlePendingFactor = res.getFloat(R.integer.device_idle_max_temp_app_allowlist_duration_ms);
            this.mDefaultQuickDozeDelayTimeout = getTimeout(res.getInteger(R.integer.leanback_setup_alpha_forward_in_content_delay), this.mDefaultQuickDozeDelayTimeout);
            this.mDefaultIdleTimeout = getTimeout(res.getInteger(R.integer.device_idle_min_light_maintenance_time_ms), this.mDefaultIdleTimeout);
            this.mDefaultMaxIdleTimeout = getTimeout(res.getInteger(R.integer.kg_widget_region_weight), this.mDefaultMaxIdleTimeout);
            this.mDefaultIdleFactor = res.getFloat(R.integer.device_idle_max_idle_to_ms);
            this.mDefaultMinTimeToAlarm = getTimeout(res.getInteger(R.integer.leanback_setup_alpha_activity_out_bkg_duration), this.mDefaultMinTimeToAlarm);
            this.mDefaultMaxTempAppAllowlistDurationMs = res.getInteger(R.integer.leanback_setup_alpha_activity_in_bkg_delay);
            this.mDefaultMmsTempAppAllowlistDurationMs = res.getInteger(R.integer.leanback_setup_alpha_backward_in_content_delay);
            this.mDefaultSmsTempAppAllowlistDurationMs = res.getInteger(R.integer.leanback_setup_alpha_forward_out_content_delay);
            this.mDefaultNotificationAllowlistDurationMs = res.getInteger(R.integer.leanback_setup_alpha_backward_out_content_duration);
            this.mDefaultWaitForUnlock = res.getBoolean(R.bool.reset_geo_fencing_check_after_boot_or_apm);
            this.mDefaultUseWindowAlarms = res.getBoolean(R.bool.preferences_prefer_dual_pane);
            this.mDefaultUseModeManager = res.getBoolean(R.bool.lockscreen_isPortrait);
            this.FLEX_TIME_SHORT = this.mDefaultFlexTimeShort;
            this.LIGHT_IDLE_AFTER_INACTIVE_TIMEOUT = this.mDefaultLightIdleAfterInactiveTimeout;
            this.LIGHT_IDLE_TIMEOUT = this.mDefaultLightIdleTimeout;
            this.LIGHT_IDLE_TIMEOUT_INITIAL_FLEX = this.mDefaultLightIdleTimeoutInitialFlex;
            this.LIGHT_IDLE_TIMEOUT_MAX_FLEX = this.mDefaultLightIdleTimeoutMaxFlex;
            this.LIGHT_IDLE_FACTOR = this.mDefaultLightIdleFactor;
            this.LIGHT_IDLE_INCREASE_LINEARLY = this.mDefaultLightIdleIncreaseLinearly;
            this.LIGHT_IDLE_LINEAR_INCREASE_FACTOR_MS = this.mDefaultLightIdleLinearIncreaseFactorMs;
            this.LIGHT_IDLE_FLEX_LINEAR_INCREASE_FACTOR_MS = this.mDefaultLightIdleFlexLinearIncreaseFactorMs;
            this.LIGHT_MAX_IDLE_TIMEOUT = this.mDefaultLightMaxIdleTimeout;
            this.LIGHT_IDLE_MAINTENANCE_MIN_BUDGET = this.mDefaultLightIdleMaintenanceMinBudget;
            this.LIGHT_IDLE_MAINTENANCE_MAX_BUDGET = this.mDefaultLightIdleMaintenanceMaxBudget;
            this.MIN_LIGHT_MAINTENANCE_TIME = this.mDefaultMinLightMaintenanceTime;
            this.MIN_DEEP_MAINTENANCE_TIME = this.mDefaultMinDeepMaintenanceTime;
            this.INACTIVE_TIMEOUT = this.mDefaultInactiveTimeout;
            this.SENSING_TIMEOUT = this.mDefaultSensingTimeout;
            this.LOCATING_TIMEOUT = this.mDefaultLocatingTimeout;
            this.LOCATION_ACCURACY = this.mDefaultLocationAccuracy;
            this.MOTION_INACTIVE_TIMEOUT = this.mDefaultMotionInactiveTimeout;
            this.MOTION_INACTIVE_TIMEOUT_FLEX = this.mDefaultMotionInactiveTimeoutFlex;
            this.IDLE_AFTER_INACTIVE_TIMEOUT = this.mDefaultIdleAfterInactiveTimeout;
            this.IDLE_PENDING_TIMEOUT = this.mDefaultIdlePendingTimeout;
            this.MAX_IDLE_PENDING_TIMEOUT = this.mDefaultMaxIdlePendingTimeout;
            this.IDLE_PENDING_FACTOR = this.mDefaultIdlePendingFactor;
            this.QUICK_DOZE_DELAY_TIMEOUT = this.mDefaultQuickDozeDelayTimeout;
            this.IDLE_TIMEOUT = this.mDefaultIdleTimeout;
            this.MAX_IDLE_TIMEOUT = this.mDefaultMaxIdleTimeout;
            this.IDLE_FACTOR = this.mDefaultIdleFactor;
            this.MIN_TIME_TO_ALARM = this.mDefaultMinTimeToAlarm;
            this.MAX_TEMP_APP_ALLOWLIST_DURATION_MS = this.mDefaultMaxTempAppAllowlistDurationMs;
            this.MMS_TEMP_APP_ALLOWLIST_DURATION_MS = this.mDefaultMmsTempAppAllowlistDurationMs;
            this.SMS_TEMP_APP_ALLOWLIST_DURATION_MS = this.mDefaultSmsTempAppAllowlistDurationMs;
            this.NOTIFICATION_ALLOWLIST_DURATION_MS = this.mDefaultNotificationAllowlistDurationMs;
            this.WAIT_FOR_UNLOCK = this.mDefaultWaitForUnlock;
            this.USE_WINDOW_ALARMS = this.mDefaultUseWindowAlarms;
            this.USE_MODE_MANAGER = this.mDefaultUseModeManager;
        }

        private long getTimeout(long defTimeout, long compTimeout) {
            return defTimeout;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            DeviceIdleController r0 = this.this$0;
            monitor-enter(r0);
            updateSettingsConstantLocked();     // Catch: Throwable -> L7
            updateConstantsLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void updateSettingsConstantLocked() {
            this.mUserSettingDeviceConfigMediator.setSettingsString(Settings.Global.getString(this.mResolver, "device_idle_constants"));     // Catch: IllegalArgumentException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(DeviceIdleController.TAG, "Bad device idle settings", e);
        }

        public void onPropertiesChanged(DeviceConfig.Properties properties) {
            DeviceIdleController r0 = this.this$0;
            monitor-enter(r0);
            this.mUserSettingDeviceConfigMediator.setDeviceConfigProperties(properties);     // Catch: Throwable -> L7
            updateConstantsLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void updateConstantsLocked() {
            if (this.mSmallBatteryDevice == false) goto L5;
            return;
        L5:
            this.FLEX_TIME_SHORT = this.mUserSettingDeviceConfigMediator.getLong(KEY_FLEX_TIME_SHORT, this.mDefaultFlexTimeShort);
            this.LIGHT_IDLE_AFTER_INACTIVE_TIMEOUT = this.mUserSettingDeviceConfigMediator.getLong(KEY_LIGHT_IDLE_AFTER_INACTIVE_TIMEOUT, this.mDefaultLightIdleAfterInactiveTimeout);
            this.LIGHT_IDLE_TIMEOUT = this.mUserSettingDeviceConfigMediator.getLong(KEY_LIGHT_IDLE_TIMEOUT, this.mDefaultLightIdleTimeout);
            this.LIGHT_IDLE_TIMEOUT_INITIAL_FLEX = this.mUserSettingDeviceConfigMediator.getLong(KEY_LIGHT_IDLE_TIMEOUT_INITIAL_FLEX, this.mDefaultLightIdleTimeoutInitialFlex);
            this.LIGHT_IDLE_TIMEOUT_MAX_FLEX = this.mUserSettingDeviceConfigMediator.getLong(KEY_LIGHT_IDLE_TIMEOUT_MAX_FLEX, this.mDefaultLightIdleTimeoutMaxFlex);
            this.LIGHT_IDLE_FACTOR = Math.max(1.0f, this.mUserSettingDeviceConfigMediator.getFloat(KEY_LIGHT_IDLE_FACTOR, this.mDefaultLightIdleFactor));
            this.LIGHT_IDLE_INCREASE_LINEARLY = this.mUserSettingDeviceConfigMediator.getBoolean(KEY_LIGHT_IDLE_INCREASE_LINEARLY, this.mDefaultLightIdleIncreaseLinearly);
            this.LIGHT_IDLE_LINEAR_INCREASE_FACTOR_MS = this.mUserSettingDeviceConfigMediator.getLong(KEY_LIGHT_IDLE_LINEAR_INCREASE_FACTOR_MS, this.mDefaultLightIdleLinearIncreaseFactorMs);
            this.LIGHT_IDLE_FLEX_LINEAR_INCREASE_FACTOR_MS = this.mUserSettingDeviceConfigMediator.getLong(KEY_LIGHT_IDLE_FLEX_LINEAR_INCREASE_FACTOR_MS, this.mDefaultLightIdleFlexLinearIncreaseFactorMs);
            this.LIGHT_MAX_IDLE_TIMEOUT = this.mUserSettingDeviceConfigMediator.getLong(KEY_LIGHT_MAX_IDLE_TIMEOUT, this.mDefaultLightMaxIdleTimeout);
            this.LIGHT_IDLE_MAINTENANCE_MIN_BUDGET = this.mUserSettingDeviceConfigMediator.getLong(KEY_LIGHT_IDLE_MAINTENANCE_MIN_BUDGET, this.mDefaultLightIdleMaintenanceMinBudget);
            this.LIGHT_IDLE_MAINTENANCE_MAX_BUDGET = this.mUserSettingDeviceConfigMediator.getLong(KEY_LIGHT_IDLE_MAINTENANCE_MAX_BUDGET, this.mDefaultLightIdleMaintenanceMaxBudget);
            this.MIN_LIGHT_MAINTENANCE_TIME = this.mUserSettingDeviceConfigMediator.getLong(KEY_MIN_LIGHT_MAINTENANCE_TIME, this.mDefaultMinLightMaintenanceTime);
            this.MIN_DEEP_MAINTENANCE_TIME = this.mUserSettingDeviceConfigMediator.getLong(KEY_MIN_DEEP_MAINTENANCE_TIME, this.mDefaultMinDeepMaintenanceTime);
            long defaultIdleAfterInactiveTimeout = 60000;
            if (this.mSmallBatteryDevice == false) goto L8;
            long defaultInactiveTimeout = 60000;
        L9:
            this.INACTIVE_TIMEOUT = this.mUserSettingDeviceConfigMediator.getLong(KEY_INACTIVE_TIMEOUT, defaultInactiveTimeout);
            this.SENSING_TIMEOUT = this.mUserSettingDeviceConfigMediator.getLong(KEY_SENSING_TIMEOUT, this.mDefaultSensingTimeout);
            this.LOCATING_TIMEOUT = this.mUserSettingDeviceConfigMediator.getLong(KEY_LOCATING_TIMEOUT, this.mDefaultLocatingTimeout);
            this.LOCATION_ACCURACY = this.mUserSettingDeviceConfigMediator.getFloat(KEY_LOCATION_ACCURACY, this.mDefaultLocationAccuracy);
            this.MOTION_INACTIVE_TIMEOUT = this.mUserSettingDeviceConfigMediator.getLong(KEY_MOTION_INACTIVE_TIMEOUT, this.mDefaultMotionInactiveTimeout);
            this.MOTION_INACTIVE_TIMEOUT_FLEX = this.mUserSettingDeviceConfigMediator.getLong(KEY_MOTION_INACTIVE_TIMEOUT_FLEX, this.mDefaultMotionInactiveTimeoutFlex);
            if (this.mSmallBatteryDevice == true) goto L13;
            defaultIdleAfterInactiveTimeout = this.mDefaultIdleAfterInactiveTimeout;
        L13:
            this.IDLE_AFTER_INACTIVE_TIMEOUT = this.mUserSettingDeviceConfigMediator.getLong(KEY_IDLE_AFTER_INACTIVE_TIMEOUT, defaultIdleAfterInactiveTimeout);
            this.IDLE_PENDING_TIMEOUT = this.mUserSettingDeviceConfigMediator.getLong(KEY_IDLE_PENDING_TIMEOUT, this.mDefaultIdlePendingTimeout);
            this.MAX_IDLE_PENDING_TIMEOUT = this.mUserSettingDeviceConfigMediator.getLong(KEY_MAX_IDLE_PENDING_TIMEOUT, this.mDefaultMaxIdlePendingTimeout);
            this.IDLE_PENDING_FACTOR = this.mUserSettingDeviceConfigMediator.getFloat(KEY_IDLE_PENDING_FACTOR, this.mDefaultIdlePendingFactor);
            this.QUICK_DOZE_DELAY_TIMEOUT = this.mUserSettingDeviceConfigMediator.getLong(KEY_QUICK_DOZE_DELAY_TIMEOUT, this.mDefaultQuickDozeDelayTimeout);
            this.IDLE_TIMEOUT = this.mUserSettingDeviceConfigMediator.getLong(KEY_IDLE_TIMEOUT, this.mDefaultIdleTimeout);
            this.MAX_IDLE_TIMEOUT = this.mUserSettingDeviceConfigMediator.getLong(KEY_MAX_IDLE_TIMEOUT, this.mDefaultMaxIdleTimeout);
            this.IDLE_FACTOR = this.mUserSettingDeviceConfigMediator.getFloat(KEY_IDLE_FACTOR, this.mDefaultIdleFactor);
            this.MIN_TIME_TO_ALARM = this.mUserSettingDeviceConfigMediator.getLong(KEY_MIN_TIME_TO_ALARM, this.mDefaultMinTimeToAlarm);
            this.MAX_TEMP_APP_ALLOWLIST_DURATION_MS = this.mUserSettingDeviceConfigMediator.getLong(KEY_MAX_TEMP_APP_ALLOWLIST_DURATION_MS, this.mDefaultMaxTempAppAllowlistDurationMs);
            this.MMS_TEMP_APP_ALLOWLIST_DURATION_MS = this.mUserSettingDeviceConfigMediator.getLong(KEY_MMS_TEMP_APP_ALLOWLIST_DURATION_MS, this.mDefaultMmsTempAppAllowlistDurationMs);
            this.SMS_TEMP_APP_ALLOWLIST_DURATION_MS = this.mUserSettingDeviceConfigMediator.getLong(KEY_SMS_TEMP_APP_ALLOWLIST_DURATION_MS, this.mDefaultSmsTempAppAllowlistDurationMs);
            this.NOTIFICATION_ALLOWLIST_DURATION_MS = this.mUserSettingDeviceConfigMediator.getLong(KEY_NOTIFICATION_ALLOWLIST_DURATION_MS, this.mDefaultNotificationAllowlistDurationMs);
            this.WAIT_FOR_UNLOCK = this.mUserSettingDeviceConfigMediator.getBoolean(KEY_WAIT_FOR_UNLOCK, this.mDefaultWaitForUnlock);
            this.USE_WINDOW_ALARMS = this.mUserSettingDeviceConfigMediator.getBoolean(KEY_USE_WINDOW_ALARMS, this.mDefaultUseWindowAlarms);
            this.USE_MODE_MANAGER = this.mUserSettingDeviceConfigMediator.getBoolean(KEY_USE_MODE_MANAGER, this.mDefaultUseModeManager);
            return;
        L8:
            defaultInactiveTimeout = this.mDefaultInactiveTimeout;
            goto L9
        }

        void dump(PrintWriter pw) {
            pw.println("  Settings:");
            pw.print("    ");
            pw.print(KEY_FLEX_TIME_SHORT);
            pw.print("=");
            TimeUtils.formatDuration(this.FLEX_TIME_SHORT, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_LIGHT_IDLE_AFTER_INACTIVE_TIMEOUT);
            pw.print("=");
            TimeUtils.formatDuration(this.LIGHT_IDLE_AFTER_INACTIVE_TIMEOUT, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_LIGHT_IDLE_TIMEOUT);
            pw.print("=");
            TimeUtils.formatDuration(this.LIGHT_IDLE_TIMEOUT, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_LIGHT_IDLE_TIMEOUT_INITIAL_FLEX);
            pw.print("=");
            TimeUtils.formatDuration(this.LIGHT_IDLE_TIMEOUT_INITIAL_FLEX, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_LIGHT_IDLE_TIMEOUT_MAX_FLEX);
            pw.print("=");
            TimeUtils.formatDuration(this.LIGHT_IDLE_TIMEOUT_MAX_FLEX, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_LIGHT_IDLE_FACTOR);
            pw.print("=");
            pw.print(this.LIGHT_IDLE_FACTOR);
            pw.println();
            pw.print("    ");
            pw.print(KEY_LIGHT_IDLE_INCREASE_LINEARLY);
            pw.print("=");
            pw.print(this.LIGHT_IDLE_INCREASE_LINEARLY);
            pw.println();
            pw.print("    ");
            pw.print(KEY_LIGHT_IDLE_LINEAR_INCREASE_FACTOR_MS);
            pw.print("=");
            pw.print(this.LIGHT_IDLE_LINEAR_INCREASE_FACTOR_MS);
            pw.println();
            pw.print("    ");
            pw.print(KEY_LIGHT_IDLE_FLEX_LINEAR_INCREASE_FACTOR_MS);
            pw.print("=");
            pw.print(this.LIGHT_IDLE_FLEX_LINEAR_INCREASE_FACTOR_MS);
            pw.println();
            pw.print("    ");
            pw.print(KEY_LIGHT_MAX_IDLE_TIMEOUT);
            pw.print("=");
            TimeUtils.formatDuration(this.LIGHT_MAX_IDLE_TIMEOUT, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_LIGHT_IDLE_MAINTENANCE_MIN_BUDGET);
            pw.print("=");
            TimeUtils.formatDuration(this.LIGHT_IDLE_MAINTENANCE_MIN_BUDGET, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_LIGHT_IDLE_MAINTENANCE_MAX_BUDGET);
            pw.print("=");
            TimeUtils.formatDuration(this.LIGHT_IDLE_MAINTENANCE_MAX_BUDGET, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_MIN_LIGHT_MAINTENANCE_TIME);
            pw.print("=");
            TimeUtils.formatDuration(this.MIN_LIGHT_MAINTENANCE_TIME, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_MIN_DEEP_MAINTENANCE_TIME);
            pw.print("=");
            TimeUtils.formatDuration(this.MIN_DEEP_MAINTENANCE_TIME, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_INACTIVE_TIMEOUT);
            pw.print("=");
            TimeUtils.formatDuration(this.INACTIVE_TIMEOUT, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_SENSING_TIMEOUT);
            pw.print("=");
            TimeUtils.formatDuration(this.SENSING_TIMEOUT, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_LOCATING_TIMEOUT);
            pw.print("=");
            TimeUtils.formatDuration(this.LOCATING_TIMEOUT, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_LOCATION_ACCURACY);
            pw.print("=");
            pw.print(this.LOCATION_ACCURACY);
            pw.print("m");
            pw.println();
            pw.print("    ");
            pw.print(KEY_MOTION_INACTIVE_TIMEOUT);
            pw.print("=");
            TimeUtils.formatDuration(this.MOTION_INACTIVE_TIMEOUT, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_MOTION_INACTIVE_TIMEOUT_FLEX);
            pw.print("=");
            TimeUtils.formatDuration(this.MOTION_INACTIVE_TIMEOUT_FLEX, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_IDLE_AFTER_INACTIVE_TIMEOUT);
            pw.print("=");
            TimeUtils.formatDuration(this.IDLE_AFTER_INACTIVE_TIMEOUT, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_IDLE_PENDING_TIMEOUT);
            pw.print("=");
            TimeUtils.formatDuration(this.IDLE_PENDING_TIMEOUT, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_MAX_IDLE_PENDING_TIMEOUT);
            pw.print("=");
            TimeUtils.formatDuration(this.MAX_IDLE_PENDING_TIMEOUT, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_IDLE_PENDING_FACTOR);
            pw.print("=");
            pw.println(this.IDLE_PENDING_FACTOR);
            pw.print("    ");
            pw.print(KEY_QUICK_DOZE_DELAY_TIMEOUT);
            pw.print("=");
            TimeUtils.formatDuration(this.QUICK_DOZE_DELAY_TIMEOUT, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_IDLE_TIMEOUT);
            pw.print("=");
            TimeUtils.formatDuration(this.IDLE_TIMEOUT, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_MAX_IDLE_TIMEOUT);
            pw.print("=");
            TimeUtils.formatDuration(this.MAX_IDLE_TIMEOUT, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_IDLE_FACTOR);
            pw.print("=");
            pw.println(this.IDLE_FACTOR);
            pw.print("    ");
            pw.print(KEY_MIN_TIME_TO_ALARM);
            pw.print("=");
            TimeUtils.formatDuration(this.MIN_TIME_TO_ALARM, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_MAX_TEMP_APP_ALLOWLIST_DURATION_MS);
            pw.print("=");
            TimeUtils.formatDuration(this.MAX_TEMP_APP_ALLOWLIST_DURATION_MS, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_MMS_TEMP_APP_ALLOWLIST_DURATION_MS);
            pw.print("=");
            TimeUtils.formatDuration(this.MMS_TEMP_APP_ALLOWLIST_DURATION_MS, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_SMS_TEMP_APP_ALLOWLIST_DURATION_MS);
            pw.print("=");
            TimeUtils.formatDuration(this.SMS_TEMP_APP_ALLOWLIST_DURATION_MS, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_NOTIFICATION_ALLOWLIST_DURATION_MS);
            pw.print("=");
            TimeUtils.formatDuration(this.NOTIFICATION_ALLOWLIST_DURATION_MS, pw);
            pw.println();
            pw.print("    ");
            pw.print(KEY_WAIT_FOR_UNLOCK);
            pw.print("=");
            pw.println(this.WAIT_FOR_UNLOCK);
            pw.print("    ");
            pw.print(KEY_USE_WINDOW_ALARMS);
            pw.print("=");
            pw.println(this.USE_WINDOW_ALARMS);
            pw.print("    ");
            pw.print(KEY_USE_MODE_MANAGER);
            pw.print("=");
            pw.println(this.USE_MODE_MANAGER);
        }
    }

    private class EmergencyCallListener extends TelephonyCallback implements TelephonyCallback.OutgoingEmergencyCallListener, TelephonyCallback.CallStateListener {
        private volatile boolean mIsEmergencyCallActive;
        final /* synthetic */ DeviceIdleController this$0;

        /* synthetic */ EmergencyCallListener(DeviceIdleController r1, DeviceIdleControllerIA r2) {
            this(r1);
        }

        private EmergencyCallListener(DeviceIdleController r1) {
            this.this$0 = r1;
        }

        public void onOutgoingEmergencyCall(EmergencyNumber placedEmergencyNumber, int subscriptionId) {
            this.mIsEmergencyCallActive = true;
            DeviceIdleController r0 = this.this$0;
            monitor-enter(r0);
            DeviceIdleController.m180$$Nest$fputmActiveReason(this.this$0, 8);     // Catch: Throwable -> L7
            this.this$0.becomeActiveLocked("emergency call", Process.myUid());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.telephony.TelephonyCallback.CallStateListener
        public void onCallStateChanged(int state) {
            if (state == 0) goto L4;
            return;
        L4:
            if (this.mIsEmergencyCallActive == false) goto L16;
            this.mIsEmergencyCallActive = false;
            DeviceIdleController r0 = this.this$0;
            monitor-enter(r0);
            this.this$0.becomeInactiveIfAppropriateLocked();     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        boolean isEmergencyCallActive() {
            return this.mIsEmergencyCallActive;
        }
    }

    static class Injector {
        private ConnectivityManager mConnectivityManager;
        private Constants mConstants;
        private final Context mContext;
        private LocationManager mLocationManager;

        Injector(Context ctx) {
            this.mContext = ctx.createAttributionContext(DeviceIdleController.TAG);
        }

        AlarmManager getAlarmManager() {
            return (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
        }

        AnyMotionDetector getAnyMotionDetector(Handler handler, SensorManager sm, AnyMotionDetector.DeviceIdleCallback callback, float angleThreshold) {
            return new AnyMotionDetector(getPowerManager(), handler, sm, callback, angleThreshold);
        }

        AppStateTrackerImpl getAppStateTracker(Context ctx, Looper looper) {
            return new AppStateTrackerImpl(ctx, looper);
        }

        ConnectivityManager getConnectivityManager() {
            if (this.mConnectivityManager != null) goto L6;
            this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
        L6:
            return this.mConnectivityManager;
        }

        Constants getConstants(DeviceIdleController controller, Handler handler, ContentResolver resolver) {
            if (this.mConstants != null) goto L6;
            controller.getClass();
            this.mConstants = new Constants(controller, handler, resolver);
        L6:
            return this.mConstants;
        }

        long getElapsedRealtime() {
            return SystemClock.elapsedRealtime();
        }

        long getUptimeMillis() {
            return SystemClock.uptimeMillis();
        }

        LocationManager getLocationManager() {
            if (this.mLocationManager != null) goto L6;
            this.mLocationManager = (LocationManager) this.mContext.getSystemService(LocationManager.class);
        L6:
            return this.mLocationManager;
        }

        MyHandler getHandler(DeviceIdleController controller) {
            controller.getClass();
            return new MyHandler(controller, AppSchedulingModuleThread.getHandler().getLooper());
        }

        Sensor getMotionSensor() {
            SensorManager sensorManager = getSensorManager();
            Sensor motionSensor = null;
            int sigMotionSensorId = this.mContext.getResources().getInteger(R.integer.config_bg_current_drain_types_to_bg_restricted);
            if (sigMotionSensorId <= 0) goto L5;
            motionSensor = sensorManager.getDefaultSensor(sigMotionSensorId, true);
        L5:
            if (motionSensor == null) goto L7;
        L9:
            if (motionSensor != null) goto L12;
            Sensor motionSensor2 = sensorManager.getDefaultSensor(17, true);
            return motionSensor2;
        L12:
            return motionSensor;
        L7:
            if (this.mContext.getResources().getBoolean(R.bool.config_autoResetAirplaneMode) == false) goto L9;
            motionSensor = sensorManager.getDefaultSensor(26, true);
            goto L9
        }

        PowerManager getPowerManager() {
            return (PowerManager) this.mContext.getSystemService(PowerManager.class);
        }

        SensorManager getSensorManager() {
            return (SensorManager) this.mContext.getSystemService(SensorManager.class);
        }

        TelephonyManager getTelephonyManager() {
            return (TelephonyManager) this.mContext.getSystemService(TelephonyManager.class);
        }

        ConstraintController getConstraintController(Handler handler, DeviceIdleInternal localService) {
            if (this.mContext.getPackageManager().hasSystemFeature("android.software.leanback_only") == true) goto L5;
            return null;
        L5:
            return new TvConstraintController(this.mContext, handler);
        }

        boolean isLocationPrefetchEnabled() {
            return false;
        }

        boolean useMotionSensor() {
            return this.mContext.getResources().getBoolean(R.bool.config_automatic_brightness_available);
        }
    }

    private class LocalPowerAllowlistService implements PowerAllowlistInternal {
        final /* synthetic */ DeviceIdleController this$0;

        /* synthetic */ LocalPowerAllowlistService(DeviceIdleController r1, DeviceIdleControllerIA r2) {
            this(r1);
        }

        private LocalPowerAllowlistService(DeviceIdleController r1) {
            this.this$0 = r1;
        }

        public void registerTempAllowlistChangeListener(PowerAllowlistInternal.TempAllowlistChangeListener listener) {
            DeviceIdleController.m196$$Nest$mregisterTempAllowlistChangeListener(this.this$0, listener);
        }

        public void unregisterTempAllowlistChangeListener(PowerAllowlistInternal.TempAllowlistChangeListener listener) {
            DeviceIdleController.m199$$Nest$munregisterTempAllowlistChangeListener(this.this$0, listener);
        }
    }

    private class LocalService implements DeviceIdleInternal {
        final /* synthetic */ DeviceIdleController this$0;

        /* synthetic */ LocalService(DeviceIdleController r1, DeviceIdleControllerIA r2) {
            this(r1);
        }

        private LocalService(DeviceIdleController r1) {
            this.this$0 = r1;
        }

        public void onConstraintStateChanged(IDeviceIdleConstraint constraint, boolean active) {
            DeviceIdleController r0 = this.this$0;
            monitor-enter(r0);
            DeviceIdleController.m194$$Nest$monConstraintStateChangedLocked(this.this$0, constraint, active);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void registerDeviceIdleConstraint(IDeviceIdleConstraint constraint, String name, int minState) {
            DeviceIdleController.m195$$Nest$mregisterDeviceIdleConstraintInternal(this.this$0, constraint, name, minState);
        }

        public void unregisterDeviceIdleConstraint(IDeviceIdleConstraint constraint) {
            DeviceIdleController.m197$$Nest$munregisterDeviceIdleConstraintInternal(this.this$0, constraint);
        }

        public void exitIdle(String reason) {
            this.this$0.exitIdleInternal(reason);
        }

        public void addPowerSaveTempWhitelistApp(int callingUid, String packageName, long durationMs, int userId, boolean sync, int reasonCode, String reason) {
            this.this$0.addPowerSaveTempAllowlistAppInternal(callingUid, packageName, durationMs, 0, userId, sync, reasonCode, reason);
        }

        public void addPowerSaveTempWhitelistApp(int callingUid, String packageName, long durationMs, int tempAllowListType, int userId, boolean sync, int reasonCode, String reason) {
            this.this$0.addPowerSaveTempAllowlistAppInternal(callingUid, packageName, durationMs, tempAllowListType, userId, sync, reasonCode, reason);
        }

        public void addPowerSaveTempWhitelistAppDirect(int uid, long durationMs, int tempAllowListType, boolean sync, int reasonCode, String reason, int callingUid) {
            this.this$0.addPowerSaveTempWhitelistAppDirectInternal(callingUid, uid, durationMs, tempAllowListType, sync, reasonCode, reason);
        }

        public long getNotificationAllowlistDuration() {
            return DeviceIdleController.m157$$Nest$fgetmConstants(this.this$0).NOTIFICATION_ALLOWLIST_DURATION_MS;
        }

        public void setJobsActive(boolean active) {
            this.this$0.setJobsActive(active);
        }

        public void setAlarmsActive(boolean active) {
            this.this$0.setAlarmsActive(active);
        }

        public boolean isAppOnWhitelist(int appid) {
            return this.this$0.isAppOnWhitelistInternal(appid);
        }

        public String[] getFullPowerWhitelistExceptIdle() {
            return DeviceIdleController.m186$$Nest$mgetFullPowerWhitelistInternalUnchecked(this.this$0);
        }

        public int[] getPowerSaveWhitelistUserAppIds() {
            return this.this$0.getPowerSaveWhitelistUserAppIds();
        }

        public int[] getPowerSaveTempWhitelistAppIds() {
            return this.this$0.getAppIdTempWhitelistInternal();
        }

        public void registerStationaryListener(DeviceIdleInternal.StationaryListener listener) {
            this.this$0.registerStationaryListener(listener);
        }

        public void unregisterStationaryListener(DeviceIdleInternal.StationaryListener listener) {
            DeviceIdleController.m198$$Nest$munregisterStationaryListener(this.this$0, listener);
        }

        public int getTempAllowListType(int reasonCode, int defaultType) {
            return DeviceIdleController.m190$$Nest$mgetTempAllowListType(this.this$0, reasonCode, defaultType);
        }
    }

    class ModeManagerOffBodyStateConsumer implements Consumer<Boolean> {
        final /* synthetic */ DeviceIdleController this$0;

        /* JADX INFO: renamed from: -$$Nest$monModeManagerOffBodyChangedLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m201$$Nest$monModeManagerOffBodyChangedLocked(ModeManagerOffBodyStateConsumer r0) {
            r0.onModeManagerOffBodyChangedLocked();
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Boolean r1) {
            accept2(r1);
        }

        ModeManagerOffBodyStateConsumer(DeviceIdleController this$0) {
            this.this$0 = this$0;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Boolean isOffBody) {
            Slog.i(DeviceIdleController.TAG, "Offbody event from mode manager: " + isOffBody);
            DeviceIdleController r0 = this.this$0;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (DeviceIdleController.m158$$Nest$fgetmForceModeManagerOffBodyState(this.this$0) == false) goto L7;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L7:
            if (DeviceIdleController.m165$$Nest$fgetmIsOffBody(this.this$0) == isOffBody.booleanValue()) goto L11;
            DeviceIdleController.m181$$Nest$fputmIsOffBody(this.this$0, isOffBody.booleanValue());     // Catch: Throwable -> L9
            onModeManagerOffBodyChangedLocked();     // Catch: Throwable -> L9
            goto L11
        }

        private void onModeManagerOffBodyChangedLocked() {
            DeviceIdleController.m193$$Nest$mmaybeBecomeActiveOnModeManagerEventsLocked(this.this$0);
        }
    }

    class ModeManagerQuickDozeRequestConsumer implements Consumer<Boolean> {
        final /* synthetic */ DeviceIdleController this$0;

        /* JADX INFO: renamed from: -$$Nest$monModeManagerRequestChangedLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m202$$Nest$monModeManagerRequestChangedLocked(ModeManagerQuickDozeRequestConsumer r0) {
            r0.onModeManagerRequestChangedLocked();
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Boolean r1) {
            accept2(r1);
        }

        ModeManagerQuickDozeRequestConsumer(DeviceIdleController this$0) {
            this.this$0 = this$0;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(Boolean enabled) {
            Slog.i(DeviceIdleController.TAG, "Mode manager quick doze request: " + enabled);
            DeviceIdleController r0 = this.this$0;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (DeviceIdleController.m159$$Nest$fgetmForceModeManagerQuickDozeRequest(this.this$0) == false) goto L7;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L7:
            if (DeviceIdleController.m170$$Nest$fgetmModeManagerRequestedQuickDoze(this.this$0) == enabled.booleanValue()) goto L11;
            DeviceIdleController.m182$$Nest$fputmModeManagerRequestedQuickDoze(this.this$0, enabled.booleanValue());     // Catch: Throwable -> L9
            onModeManagerRequestChangedLocked();     // Catch: Throwable -> L9
            goto L11
        }

        private void onModeManagerRequestChangedLocked() {
            DeviceIdleController.m193$$Nest$mmaybeBecomeActiveOnModeManagerEventsLocked(this.this$0);
            DeviceIdleController.m200$$Nest$mupdateQuickDozeFlagLocked(this.this$0);
        }
    }

    final class MotionListener extends TriggerEventListener implements SensorEventListener {
        long activatedTimeElapsed;
        boolean active;
        final /* synthetic */ DeviceIdleController this$0;

        MotionListener(DeviceIdleController this$0) {
            this.this$0 = this$0;
            this.active = false;
        }

        public boolean isActive() {
            return this.active;
        }

        @Override // android.hardware.TriggerEventListener
        public void onTrigger(TriggerEvent event) {
            DeviceIdleController r0 = this.this$0;
            monitor-enter(r0);
            this.active = false;     // Catch: Throwable -> L8
            this.this$0.motionLocked();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent event) {
            DeviceIdleController r0 = this.this$0;
            monitor-enter(r0);
            DeviceIdleController.m176$$Nest$fgetmSensorManager(this.this$0).unregisterListener(this, DeviceIdleController.m171$$Nest$fgetmMotionSensor(this.this$0));     // Catch: Throwable -> L7
            this.active = false;     // Catch: Throwable -> L7
            this.this$0.motionLocked();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        public boolean registerLocked() {
            if (DeviceIdleController.m171$$Nest$fgetmMotionSensor(this.this$0).getReportingMode() != 2) goto L5;
            boolean success = DeviceIdleController.m176$$Nest$fgetmSensorManager(this.this$0).requestTriggerSensor(this.this$0.mMotionListener, DeviceIdleController.m171$$Nest$fgetmMotionSensor(this.this$0));
        L6:
            if (success == false) goto L8;
            this.active = true;
            this.activatedTimeElapsed = DeviceIdleController.m164$$Nest$fgetmInjector(this.this$0).getElapsedRealtime();
        L9:
            return success;
        L8:
            Slog.e(DeviceIdleController.TAG, "Unable to register for " + DeviceIdleController.m171$$Nest$fgetmMotionSensor(this.this$0));
            goto L9
        L5:
            success = DeviceIdleController.m176$$Nest$fgetmSensorManager(this.this$0).registerListener(this.this$0.mMotionListener, DeviceIdleController.m171$$Nest$fgetmMotionSensor(this.this$0), 3);
            goto L6
        }

        public void unregisterLocked() {
            if (DeviceIdleController.m171$$Nest$fgetmMotionSensor(this.this$0).getReportingMode() != 2) goto L5;
            DeviceIdleController.m176$$Nest$fgetmSensorManager(this.this$0).cancelTriggerSensor(this.this$0.mMotionListener, DeviceIdleController.m171$$Nest$fgetmMotionSensor(this.this$0));
        L6:
            this.active = false;
            return;
        L5:
            DeviceIdleController.m176$$Nest$fgetmSensorManager(this.this$0).unregisterListener(this.this$0.mMotionListener);
            goto L6
        }
    }

    final class MyHandler extends Handler {
        final /* synthetic */ DeviceIdleController this$0;

        MyHandler(DeviceIdleController this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            int r2 = 1;
            int r3 = 0;
            switch(msg.what) {
                case 1: goto L98;
                case 2: goto L77;
                case 3: goto L77;
                case 4: goto L68;
                case 5: goto L55;
                case 6: goto L54;
                case 7: goto L36;
                case 8: goto L35;
                case 9: goto L123;
                case 10: goto L27;
                case 11: goto L123;
                case 12: goto L123;
                case 13: goto L7;
                case 14: goto L6;
                case 15: goto L5;
                default: goto L123;
            };
        L5:
            int appId = msg.arg1;
            DeviceIdleController.m173$$Nest$fgetmNetworkPolicyManagerInternal(this.this$0).onTempPowerSaveWhitelistChange(appId, false, 0, null);
            return;
        L6:
            int appId2 = msg.arg1;
            int reasonCode = msg.arg2;
            String reason = (String) msg.obj;
            DeviceIdleController.m173$$Nest$fgetmNetworkPolicyManagerInternal(this.this$0).onTempPowerSaveWhitelistChange(appId2, true, reasonCode, reason);
            return;
        L7:
            int uid = msg.arg1;
            if (msg.arg2 == 1) goto L11;
            r2 = 0;
        L11:
            int r4 = r2;
            DeviceIdleController r5 = this.this$0;
            monitor-enter(r5);
            PowerAllowlistInternal.TempAllowlistChangeListener[] listeners = (PowerAllowlistInternal.TempAllowlistChangeListener[]) DeviceIdleController.m179$$Nest$fgetmTempAllowlistChangeListeners(this.this$0).toArray(new PowerAllowlistInternal.TempAllowlistChangeListener[DeviceIdleController.m179$$Nest$fgetmTempAllowlistChangeListeners(this.this$0).size()]);     // Catch: Throwable -> L24
            monitor-exit(r5);     // Catch: Throwable -> L24
            int r6 = listeners.length;
        L17:
            if (r3 >= r6) goto L126;
            PowerAllowlistInternal.TempAllowlistChangeListener listener = listeners[r3];
            if (r4 == 0) goto L21;
            listener.onAppAdded(uid);
        L22:
            r3 = r3 + 1;
            goto L17
        L21:
            listener.onAppRemoved(uid);
            goto L22
        L126:
            return;
        L24:
            th = move-exception;
            throw th;
        L27:
            IDeviceIdleConstraint constraint = (IDeviceIdleConstraint) msg.obj;
            if (msg.arg1 == 1) goto L31;
            r2 = 0;
        L31:
            if (r2 == 0) goto L33;
            constraint.startMonitoring();
            return;
        L33:
            constraint.stopMonitoring();
            return;
        L35:
            this.this$0.decActiveIdleOps();
            return;
        L36:
            DeviceIdleInternal.StationaryListener newListener = (DeviceIdleInternal.StationaryListener) msg.obj;
            DeviceIdleController r7 = this.this$0;
            monitor-enter(r7);
            boolean isStationary = DeviceIdleController.m192$$Nest$misStationaryLocked(this.this$0);     // Catch: Throwable -> L41
            if (newListener != null) goto L43;
            DeviceIdleInternal.StationaryListener[] listeners2 = (DeviceIdleInternal.StationaryListener[]) DeviceIdleController.m178$$Nest$fgetmStationaryListeners(this.this$0).toArray(new DeviceIdleInternal.StationaryListener[DeviceIdleController.m178$$Nest$fgetmStationaryListeners(this.this$0).size()]);     // Catch: Throwable -> L41
        L44:
            monitor-exit(r7);     // Catch: Throwable -> L41
            if (listeners2 == null) goto L50;
            int r8 = listeners2.length;
        L48:
            if (r3 >= r8) goto L50;
            listeners2[r3].onDeviceStationaryChanged(isStationary);
            r3 = r3 + 1;
        L50:
            if (newListener == null) goto L117;
            newListener.onDeviceStationaryChanged(isStationary);
            return;
        L117:
            return;
        L43:
            listeners2 = null;
        L41:
            th = move-exception;
            throw th;
        L54:
            this.this$0.checkTempAppWhitelistTimeout(msg.arg1);
            return;
        L55:
            String activeReason = (String) msg.obj;
            int activeUid = msg.arg1;
            if (activeReason == null) goto L58;
            String r0 = activeReason;
        L59:
            EventLogTags.writeDeviceIdleOffStart(r0);
            boolean deepChanged = DeviceIdleController.m169$$Nest$fgetmLocalPowerManager(this.this$0).setDeviceIdleMode(false);
            boolean lightChanged = DeviceIdleController.m169$$Nest$fgetmLocalPowerManager(this.this$0).setLightDeviceIdleMode(false);
            DeviceIdleController.m172$$Nest$fgetmNetworkPolicyManager(this.this$0).setDeviceIdleMode(false);     // Catch: RemoteException -> L62
            DeviceIdleController.m156$$Nest$fgetmBatteryStats(this.this$0).noteDeviceIdleMode(0, activeReason, activeUid);     // Catch: RemoteException -> L62
        L63:
            if (deepChanged == false) goto L65;
            this.this$0.getContext().sendBroadcastAsUser(DeviceIdleController.m161$$Nest$fgetmIdleIntent(this.this$0), UserHandle.ALL, null, DeviceIdleController.m162$$Nest$fgetmIdleIntentOptions(this.this$0));
        L65:
            if (lightChanged == false) goto L67;
            this.this$0.getContext().sendBroadcastAsUser(DeviceIdleController.m166$$Nest$fgetmLightIdleIntent(this.this$0), UserHandle.ALL, null, DeviceIdleController.m167$$Nest$fgetmLightIdleIntentOptions(this.this$0));
        L67:
            EventLogTags.writeDeviceIdleOffComplete();
            return;
        L58:
            r0 = "unknown";
            goto L59
        L68:
            EventLogTags.writeDeviceIdleOffStart("unknown");
            boolean deepChanged2 = DeviceIdleController.m169$$Nest$fgetmLocalPowerManager(this.this$0).setDeviceIdleMode(false);
            boolean lightChanged2 = DeviceIdleController.m169$$Nest$fgetmLocalPowerManager(this.this$0).setLightDeviceIdleMode(false);
            DeviceIdleController.m172$$Nest$fgetmNetworkPolicyManager(this.this$0).setDeviceIdleMode(false);     // Catch: RemoteException -> L71
            DeviceIdleController.m156$$Nest$fgetmBatteryStats(this.this$0).noteDeviceIdleMode(0, null, Process.myUid());     // Catch: RemoteException -> L71
        L72:
            if (deepChanged2 == false) goto L74;
            this.this$0.incActiveIdleOps();
            DeviceIdleController.m168$$Nest$fgetmLocalActivityManager(this.this$0).broadcastIntentWithCallback(DeviceIdleController.m161$$Nest$fgetmIdleIntent(this.this$0), DeviceIdleController.m163$$Nest$fgetmIdleStartedDoneReceiver(this.this$0), null, -1, null, null, DeviceIdleController.m162$$Nest$fgetmIdleIntentOptions(this.this$0));
        L74:
            if (lightChanged2 == false) goto L76;
            this.this$0.incActiveIdleOps();
            DeviceIdleController.m168$$Nest$fgetmLocalActivityManager(this.this$0).broadcastIntentWithCallback(DeviceIdleController.m166$$Nest$fgetmLightIdleIntent(this.this$0), DeviceIdleController.m163$$Nest$fgetmIdleStartedDoneReceiver(this.this$0), null, -1, null, null, DeviceIdleController.m167$$Nest$fgetmLightIdleIntentOptions(this.this$0));
        L76:
            this.this$0.decActiveIdleOps();
            EventLogTags.writeDeviceIdleOffComplete();
            return;
        L77:
            EventLogTags.writeDeviceIdleOnStart();
            if (msg.what != 2) goto L80;
            boolean deepChanged3 = DeviceIdleController.m169$$Nest$fgetmLocalPowerManager(this.this$0).setDeviceIdleMode(true);
            boolean lightChanged3 = DeviceIdleController.m169$$Nest$fgetmLocalPowerManager(this.this$0).setLightDeviceIdleMode(false);
            boolean deepChanged4 = deepChanged3;
        L104:
            DeviceIdleController.m172$$Nest$fgetmNetworkPolicyManager(this.this$0).setDeviceIdleMode(true);     // Catch: RemoteException -> L87
            IBatteryStats r1 = DeviceIdleController.m156$$Nest$fgetmBatteryStats(this.this$0);     // Catch: RemoteException -> L87
            if (msg.what != 2) goto L84;
            int r9 = 2;
        L85:
            r1.noteDeviceIdleMode(r9, null, Process.myUid());     // Catch: RemoteException -> L87
            goto L88
        L84:
            r9 = 1;
        L88:
            IBytedancePowerAdvisor r10 = SysOptBridge.getFactory().getBytedancePowerAdvisorInstance();
            if (msg.what != 2) goto L92;
            r2 = 2;
        L92:
            r10.noteIdleMaintenance(r2, -1, false);
            if (deepChanged4 == false) goto L95;
            this.this$0.getContext().sendBroadcastAsUser(DeviceIdleController.m161$$Nest$fgetmIdleIntent(this.this$0), UserHandle.ALL, null, DeviceIdleController.m162$$Nest$fgetmIdleIntentOptions(this.this$0));
        L95:
            if (lightChanged3 == false) goto L97;
            this.this$0.getContext().sendBroadcastAsUser(DeviceIdleController.m166$$Nest$fgetmLightIdleIntent(this.this$0), UserHandle.ALL, null, DeviceIdleController.m167$$Nest$fgetmLightIdleIntentOptions(this.this$0));
        L97:
            EventLogTags.writeDeviceIdleOnComplete();
            DeviceIdleController.m160$$Nest$fgetmGoingIdleWakeLock(this.this$0).release();
            return;
        L80:
            boolean deepChanged5 = DeviceIdleController.m169$$Nest$fgetmLocalPowerManager(this.this$0).setDeviceIdleMode(false);
            lightChanged3 = DeviceIdleController.m169$$Nest$fgetmLocalPowerManager(this.this$0).setLightDeviceIdleMode(true);
            deepChanged4 = deepChanged5;
            goto L104
        L98:
            this.this$0.handleWriteConfigFile();
            return;
        }
    }

    class Shell extends ShellCommand {
        final /* synthetic */ DeviceIdleController this$0;
        int userId;

        Shell(DeviceIdleController this$0) {
            this.this$0 = this$0;
            this.userId = 0;
        }

        public int onCommand(String cmd) {
            return this.this$0.onShellCommand(this, cmd);
        }

        public void onHelp() {
            PrintWriter pw = getOutPrintWriter();
            DeviceIdleController.dumpHelp(pw);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$694bTna1bH7vRR_Ohet__F-by9Y, reason: not valid java name */
    public static /* synthetic */ boolean m149$r8$lambda$694bTna1bH7vRR_Ohet__Fby9Y(DeviceIdleController r0, int r1, int r2, String r3) {
        return r0.lambda$getSystemPowerWhitelistExceptIdleInternal$5(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$6uHOhnHLc0kVwfhR_HDe8Sgrkmw(DeviceIdleController r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: $r8$lambda$8f-L1Z9VLBRTA3lw6dlCovov5UM, reason: not valid java name */
    public static /* synthetic */ boolean m150$r8$lambda$8fL1Z9VLBRTA3lw6dlCovov5UM(DeviceIdleController r0, int r1, int r2, String r3) {
        return r0.lambda$getRemovedSystemPowerWhitelistAppsInternal$9(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$B3mwOYollydoqGAjKgaRuKDRXbY(DeviceIdleController r0, int r1, int r2, String r3) {
        return r0.lambda$getFullPowerWhitelistInternal$15(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$Bf-TWIxavXmKQlvKX4M7CujZyyw, reason: not valid java name */
    public static /* synthetic */ String[] m151$r8$lambda$BfTWIxavXmKQlvKX4M7CujZyyw(int r0) {
        return lambda$getSystemPowerWhitelistExceptIdleInternal$4(r0);
    }

    public static /* synthetic */ void $r8$lambda$HbKHCjd7r3eyYzFkQ9diEiiOutM(DeviceIdleController r0) {
        r0.lambda$new$1();
    }

    public static /* synthetic */ String[] $r8$lambda$KsjctppymTuHJswibGuiTxxHh94(int r0) {
        return lambda$getFullPowerWhitelistExceptIdleInternal$12(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Nb6qzQ-wbsvpO1xF-ouqFyr4C8s, reason: not valid java name */
    public static /* synthetic */ String[] m152$r8$lambda$Nb6qzQwbsvpO1xFouqFyr4C8s(int r0) {
        return lambda$getFullPowerWhitelistInternal$14(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$VryGon2WbufBV8coyL0a-t1CmeI, reason: not valid java name */
    public static /* synthetic */ String[] m153$r8$lambda$VryGon2WbufBV8coyL0at1CmeI(int r0) {
        return lambda$getRemovedSystemPowerWhitelistAppsInternal$8(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$WZVyBLU9ZNH8oFYr4rU2-69iV8M, reason: not valid java name */
    public static /* synthetic */ void m154$r8$lambda$WZVyBLU9ZNH8oFYr4rU269iV8M(DeviceIdleController r0, PowerSaveState r1) {
        r0.lambda$onBootPhase$3(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$aNkRWECW9WeDkUwaGny7VNmedfc(DeviceIdleController r0, int r1, int r2, String r3) {
        return r0.lambda$getFullPowerWhitelistExceptIdleInternal$13(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$b6vrJq__ZfKgQkRKbVVlfCTepFs(DeviceIdleController r0) {
        r0.lambda$new$2();
    }

    public static /* synthetic */ String[] $r8$lambda$bsSiqPqs0uZuCwseGHscwYcwZcg(int r0) {
        return lambda$getSystemPowerWhitelistInternal$6(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$eLokaYgRQzP6lZm5UfCVsKk0ZWA(DeviceIdleController r0, int r1, int r2, String r3) {
        return r0.lambda$getUserPowerWhitelistInternal$11(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$sOOBa1bT6tNh7SEjB7ZZ_zMGrnY(DeviceIdleController r0, int r1, int r2, String r3) {
        return r0.lambda$getSystemPowerWhitelistInternal$7(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$zi1_DlblE_I-Yz5Tu0wrvOWkbEQ, reason: not valid java name */
    public static /* synthetic */ String[] m155$r8$lambda$zi1_DlblE_IYz5Tu0wrvOWkbEQ(int r0) {
        return lambda$getUserPowerWhitelistInternal$10(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatteryStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBatteryStats m156$$Nest$fgetmBatteryStats(DeviceIdleController r0) {
        return r0.mBatteryStats;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConstants, reason: not valid java name */
    static /* bridge */ /* synthetic */ Constants m157$$Nest$fgetmConstants(DeviceIdleController r0) {
        return r0.mConstants;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmForceModeManagerOffBodyState, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m158$$Nest$fgetmForceModeManagerOffBodyState(DeviceIdleController r0) {
        return r0.mForceModeManagerOffBodyState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmForceModeManagerQuickDozeRequest, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m159$$Nest$fgetmForceModeManagerQuickDozeRequest(DeviceIdleController r0) {
        return r0.mForceModeManagerQuickDozeRequest;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGoingIdleWakeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManager.WakeLock m160$$Nest$fgetmGoingIdleWakeLock(DeviceIdleController r0) {
        return r0.mGoingIdleWakeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIdleIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ Intent m161$$Nest$fgetmIdleIntent(DeviceIdleController r0) {
        return r0.mIdleIntent;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIdleIntentOptions, reason: not valid java name */
    static /* bridge */ /* synthetic */ Bundle m162$$Nest$fgetmIdleIntentOptions(DeviceIdleController r0) {
        return r0.mIdleIntentOptions;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIdleStartedDoneReceiver, reason: not valid java name */
    static /* bridge */ /* synthetic */ IIntentReceiver m163$$Nest$fgetmIdleStartedDoneReceiver(DeviceIdleController r0) {
        return r0.mIdleStartedDoneReceiver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m164$$Nest$fgetmInjector(DeviceIdleController r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsOffBody, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m165$$Nest$fgetmIsOffBody(DeviceIdleController r0) {
        return r0.mIsOffBody;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLightIdleIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ Intent m166$$Nest$fgetmLightIdleIntent(DeviceIdleController r0) {
        return r0.mLightIdleIntent;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLightIdleIntentOptions, reason: not valid java name */
    static /* bridge */ /* synthetic */ Bundle m167$$Nest$fgetmLightIdleIntentOptions(DeviceIdleController r0) {
        return r0.mLightIdleIntentOptions;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLocalActivityManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerInternal m168$$Nest$fgetmLocalActivityManager(DeviceIdleController r0) {
        return r0.mLocalActivityManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLocalPowerManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManagerInternal m169$$Nest$fgetmLocalPowerManager(DeviceIdleController r0) {
        return r0.mLocalPowerManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmModeManagerRequestedQuickDoze, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m170$$Nest$fgetmModeManagerRequestedQuickDoze(DeviceIdleController r0) {
        return r0.mModeManagerRequestedQuickDoze;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMotionSensor, reason: not valid java name */
    static /* bridge */ /* synthetic */ Sensor m171$$Nest$fgetmMotionSensor(DeviceIdleController r0) {
        return r0.mMotionSensor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNetworkPolicyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ INetworkPolicyManager m172$$Nest$fgetmNetworkPolicyManager(DeviceIdleController r0) {
        return r0.mNetworkPolicyManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNetworkPolicyManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ NetworkPolicyManagerInternal m173$$Nest$fgetmNetworkPolicyManagerInternal(DeviceIdleController r0) {
        return r0.mNetworkPolicyManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerInternal m174$$Nest$fgetmPackageManagerInternal(DeviceIdleController r0) {
        return r0.mPackageManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerSaveWhitelistAppsExceptIdle, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m175$$Nest$fgetmPowerSaveWhitelistAppsExceptIdle(DeviceIdleController r0) {
        return r0.mPowerSaveWhitelistAppsExceptIdle;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSensorManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ SensorManager m176$$Nest$fgetmSensorManager(DeviceIdleController r0) {
        return r0.mSensorManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m177$$Nest$fgetmState(DeviceIdleController r0) {
        return r0.mState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStationaryListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m178$$Nest$fgetmStationaryListeners(DeviceIdleController r0) {
        return r0.mStationaryListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTempAllowlistChangeListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m179$$Nest$fgetmTempAllowlistChangeListeners(DeviceIdleController r0) {
        return r0.mTempAllowlistChangeListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmActiveReason, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m180$$Nest$fputmActiveReason(DeviceIdleController r0, int r1) {
        r0.mActiveReason = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsOffBody, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m181$$Nest$fputmIsOffBody(DeviceIdleController r0, boolean r1) {
        r0.mIsOffBody = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmModeManagerRequestedQuickDoze, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m182$$Nest$fputmModeManagerRequestedQuickDoze(DeviceIdleController r0, boolean r1) {
        r0.mModeManagerRequestedQuickDoze = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddPowerSaveWhitelistAppsInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m183$$Nest$maddPowerSaveWhitelistAppsInternal(DeviceIdleController r0, List r1) {
        return r0.addPowerSaveWhitelistAppsInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetFullPowerWhitelistExceptIdleInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m184$$Nest$mgetFullPowerWhitelistExceptIdleInternal(DeviceIdleController r0, int r1, int r2) {
        return r0.getFullPowerWhitelistExceptIdleInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetFullPowerWhitelistInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m185$$Nest$mgetFullPowerWhitelistInternal(DeviceIdleController r0, int r1, int r2) {
        return r0.getFullPowerWhitelistInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetFullPowerWhitelistInternalUnchecked, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m186$$Nest$mgetFullPowerWhitelistInternalUnchecked(DeviceIdleController r0) {
        return r0.getFullPowerWhitelistInternalUnchecked();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetRemovedSystemPowerWhitelistAppsInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m187$$Nest$mgetRemovedSystemPowerWhitelistAppsInternal(DeviceIdleController r0, int r1, int r2) {
        return r0.getRemovedSystemPowerWhitelistAppsInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSystemPowerWhitelistExceptIdleInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m188$$Nest$mgetSystemPowerWhitelistExceptIdleInternal(DeviceIdleController r0, int r1, int r2) {
        return r0.getSystemPowerWhitelistExceptIdleInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSystemPowerWhitelistInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m189$$Nest$mgetSystemPowerWhitelistInternal(DeviceIdleController r0, int r1, int r2) {
        return r0.getSystemPowerWhitelistInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTempAllowListType, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m190$$Nest$mgetTempAllowListType(DeviceIdleController r0, int r1, int r2) {
        return r0.getTempAllowListType(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUserPowerWhitelistInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m191$$Nest$mgetUserPowerWhitelistInternal(DeviceIdleController r0, int r1, int r2) {
        return r0.getUserPowerWhitelistInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misStationaryLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m192$$Nest$misStationaryLocked(DeviceIdleController r0) {
        return r0.isStationaryLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeBecomeActiveOnModeManagerEventsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m193$$Nest$mmaybeBecomeActiveOnModeManagerEventsLocked(DeviceIdleController r0) {
        r0.maybeBecomeActiveOnModeManagerEventsLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$monConstraintStateChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m194$$Nest$monConstraintStateChangedLocked(DeviceIdleController r0, IDeviceIdleConstraint r1, boolean r2) {
        r0.onConstraintStateChangedLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterDeviceIdleConstraintInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m195$$Nest$mregisterDeviceIdleConstraintInternal(DeviceIdleController r0, IDeviceIdleConstraint r1, String r2, int r3) {
        r0.registerDeviceIdleConstraintInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterTempAllowlistChangeListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m196$$Nest$mregisterTempAllowlistChangeListener(DeviceIdleController r0, PowerAllowlistInternal.TempAllowlistChangeListener r1) {
        r0.registerTempAllowlistChangeListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$munregisterDeviceIdleConstraintInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m197$$Nest$munregisterDeviceIdleConstraintInternal(DeviceIdleController r0, IDeviceIdleConstraint r1) {
        r0.unregisterDeviceIdleConstraintInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$munregisterStationaryListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m198$$Nest$munregisterStationaryListener(DeviceIdleController r0, DeviceIdleInternal.StationaryListener r1) {
        r0.unregisterStationaryListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$munregisterTempAllowlistChangeListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m199$$Nest$munregisterTempAllowlistChangeListener(DeviceIdleController r0, PowerAllowlistInternal.TempAllowlistChangeListener r1) {
        r0.unregisterTempAllowlistChangeListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateQuickDozeFlagLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m200$$Nest$mupdateQuickDozeFlagLocked(DeviceIdleController r0) {
        r0.updateQuickDozeFlagLocked();
    }

    static String stateToString(int state) {
        switch(state) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L4;
        };
    L5:
        return "QUICK_DOZE_DELAY";
    L7:
        return "IDLE_MAINTENANCE";
    L9:
        return "IDLE";
    L11:
        return "LOCATING";
    L13:
        return "SENSING";
    L15:
        return "IDLE_PENDING";
    L17:
        return "INACTIVE";
    L19:
        return "ACTIVE";
    L4:
        return Integer.toString(state);
    }

    static String lightStateToString(int state) {
        switch(state) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L4;
            case 3: goto L4;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L4;
        };
    L5:
        return "OVERRIDE";
    L7:
        return "IDLE_MAINTENANCE";
    L9:
        return "WAITING_FOR_NETWORK";
    L11:
        return "IDLE";
    L13:
        return "INACTIVE";
    L15:
        return "ACTIVE";
    L4:
        return Integer.toString(state);
    }

    private void addEvent(int cmd, String reason) {
        if (this.mEventCmds[0] == cmd) goto L6;
        System.arraycopy(this.mEventCmds, 0, this.mEventCmds, 1, 99);
        System.arraycopy(this.mEventTimes, 0, this.mEventTimes, 1, 99);
        System.arraycopy(this.mEventReasons, 0, this.mEventReasons, 1, 99);
        this.mEventCmds[0] = cmd;
        this.mEventTimes[0] = SystemClock.elapsedRealtime();
        this.mEventReasons[0] = reason;
        return;
    }

    private /* synthetic */ void lambda$new$0() {
        monitor-enter(this);
        stepLightIdleStateLocked("s:alarm");     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$1() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mStationaryListeners.size() <= 0) goto L8;
        startMonitoringMotionLocked();     // Catch: Throwable -> L6
        scheduleMotionTimeoutAlarmLocked();     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
    }

    private /* synthetic */ void lambda$new$2() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (isStationaryLocked() == true) goto L10;
        Slog.w(TAG, "motion timeout went off and device isn't stationary");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        postStationaryStatusUpdated();
    }

    private void postStationaryStatus(DeviceIdleInternal.StationaryListener listener) {
        this.mHandler.obtainMessage(7, listener).sendToTarget();
    }

    private void postStationaryStatusUpdated() {
        this.mHandler.sendEmptyMessage(7);
    }

    private boolean isStationaryLocked() {
        long now = this.mInjector.getElapsedRealtime();
        if (this.mMotionListener.active == true) goto L5;
    L7:
        return false;
    L5:
        if ((now - Math.max(this.mMotionListener.activatedTimeElapsed, this.mLastMotionEventElapsed)) < this.mConstants.MOTION_INACTIVE_TIMEOUT) goto L7;
        return true;
    }

    void registerStationaryListener(DeviceIdleInternal.StationaryListener listener) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mStationaryListeners.add(listener) == true) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        postStationaryStatus(listener);     // Catch: Throwable -> L7
        if (this.mMotionListener.active == true) goto L12;
        startMonitoringMotionLocked();     // Catch: Throwable -> L7
        scheduleMotionTimeoutAlarmLocked();     // Catch: Throwable -> L7
    L17:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L12:
        if (isStationaryLocked() == true) goto L17;
        if (this.mStationaryListeners.size() != 1) goto L17;
        scheduleMotionTimeoutAlarmLocked();     // Catch: Throwable -> L7
        goto L17
    }

    private void unregisterStationaryListener(DeviceIdleInternal.StationaryListener listener) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mStationaryListeners.remove(listener) == true) goto L6;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L6:
        if (this.mStationaryListeners.size() != 0) goto L17;
        if (this.mState == 0) goto L16;
        if (this.mState == 1) goto L16;
        if (this.mQuickDozeActivated == false) goto L17;
    L16:
        maybeStopMonitoringMotionLocked();     // Catch: Throwable -> L14
        goto L17
    }

    private void registerTempAllowlistChangeListener(PowerAllowlistInternal.TempAllowlistChangeListener listener) {
        monitor-enter(this);
        this.mTempAllowlistChangeListeners.add(listener);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void unregisterTempAllowlistChangeListener(PowerAllowlistInternal.TempAllowlistChangeListener listener) {
        monitor-enter(this);
        this.mTempAllowlistChangeListeners.remove(listener);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void maybeBecomeActiveOnModeManagerEventsLocked() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mQuickDozeActivated == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L10:
        if (this.mIsOffBody == false) goto L12;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L12:
        if (this.mForceIdle == true) goto L14;
        this.mActiveReason = 10;     // Catch: Throwable -> L7
        becomeActiveLocked("on_body", Process.myUid());     // Catch: Throwable -> L7
        goto L14
    }

    @Override // com.android.server.AnyMotionDetector.DeviceIdleCallback
    public void onAnyMotionResult(int result) {
        monitor-enter(this);
        if (result == (-1)) goto L9;
        cancelSensingTimeoutAlarmLocked();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    L9:
        if (result == 1) goto L21;
        if (result == (-1)) goto L21;
        if (result == 0) goto L14;
    L22:
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L14:
        if (this.mState != 3) goto L17;
        this.mNotMoving = true;     // Catch: Throwable -> L6
        stepIdleStateLocked("s:stationary");     // Catch: Throwable -> L6
        goto L22
    L17:
        if (this.mState != 4) goto L22;
        this.mNotMoving = true;     // Catch: Throwable -> L6
        if (this.mLocated == false) goto L22;
        stepIdleStateLocked("s:stationary");     // Catch: Throwable -> L6
    L21:
        handleMotionDetectedLocked(this.mConstants.INACTIVE_TIMEOUT, "non_stationary");     // Catch: Throwable -> L6
        goto L22
    }

    DeviceIdleController(Context context, Injector injector) {
        super(context);
        this.mNumBlockingConstraints = 0;
        this.mConstraints = new ArrayMap();
        this.mPowerSaveWhitelistAppsExceptIdle = new ArrayMap();
        this.mPowerSaveWhitelistUserAppsExceptIdle = new ArraySet();
        this.mPowerSaveWhitelistApps = new ArrayMap();
        this.mPowerSaveWhitelistUserApps = new ArrayMap();
        this.mPowerSaveWhitelistSystemAppIdsExceptIdle = new SparseBooleanArray();
        this.mPowerSaveWhitelistSystemAppIds = new SparseBooleanArray();
        this.mPowerSaveWhitelistExceptIdleAppIds = new SparseBooleanArray();
        this.mPowerSaveWhitelistExceptIdleAppIdArray = new int[0];
        this.mPowerSaveWhitelistAllAppIds = new SparseBooleanArray();
        this.mPowerSaveWhitelistAllAppIdArray = new int[0];
        this.mPowerSaveWhitelistUserAppIds = new SparseBooleanArray();
        this.mPowerSaveWhitelistUserAppIdArray = new int[0];
        this.mTempWhitelistAppIdEndTimes = new SparseArray();
        this.mTempWhitelistAppIdArray = new int[0];
        this.mRemovedFromSystemWhitelistApps = new ArrayMap();
        this.mStationaryListeners = new ArraySet();
        this.mTempAllowlistChangeListeners = new ArraySet();
        this.mEventCmds = new int[100];
        this.mEventTimes = new long[100];
        this.mEventReasons = new String[100];
        this.mReceiver = new AnonymousClass1(this);
        this.mLightAlarmListener = new DeviceIdleController$$ExternalSyntheticLambda2(this);
        this.mMotionRegistrationAlarmListener = new DeviceIdleController$$ExternalSyntheticLambda3(this);
        this.mMotionTimeoutAlarmListener = new DeviceIdleController$$ExternalSyntheticLambda4(this);
        this.mSensingTimeoutAlarmListener = new AnonymousClass2(this);
        this.mDeepAlarmListener = new AnonymousClass3(this);
        this.mIdleStartedDoneReceiver = new AnonymousClass4(this);
        this.mInteractivityReceiver = new AnonymousClass5(this);
        this.mEmergencyCallListener = new EmergencyCallListener(this, null);
        this.mModeManagerQuickDozeRequestConsumer = new ModeManagerQuickDozeRequestConsumer(this);
        this.mModeManagerOffBodyStateConsumer = new ModeManagerOffBodyStateConsumer(this);
        this.mMotionListener = new MotionListener(this);
        this.mGenericLocationListener = new AnonymousClass6(this);
        this.mGpsLocationListener = new AnonymousClass7(this);
        this.mScreenObserver = new AnonymousClass8(this);
        this.mInjector = injector;
        this.mConfigFile = new AtomicFile(new File(getSystemDir(), "deviceidle.xml"));
        this.mHandler = this.mInjector.getHandler(this);
        this.mAppStateTracker = this.mInjector.getAppStateTracker(context, AppSchedulingModuleThread.get().getLooper());
        LocalServices.addService(AppStateTracker.class, this.mAppStateTracker);
        this.mIsLocationPrefetchEnabled = this.mInjector.isLocationPrefetchEnabled();
        this.mUseMotionSensor = this.mInjector.useMotionSensor();
        SysOptApexBridge.getFactory().getDeviceIdleController().init(this, context);
    }

    public DeviceIdleController(Context context) {
        this(context, new Injector(context));
    }

    boolean isAppOnWhitelistInternal(int appid) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (Arrays.binarySearch(this.mPowerSaveWhitelistAllAppIdArray, appid) < 0) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r0;
    L6:
        r0 = false;
        goto L7
    }

    int[] getPowerSaveWhitelistUserAppIds() {
        monitor-enter(this);
        int[] r0 = this.mPowerSaveWhitelistUserAppIdArray;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private static File getSystemDir() {
        return new File(Environment.getDataDirectory(), "system");
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        PackageManager pm = getContext().getPackageManager();
        monitor-enter(this);
        boolean r1 = getContext().getResources().getBoolean(R.bool.config_enableContextSyncInCall);     // Catch: Throwable -> L10
        this.mDeepEnabled = r1;     // Catch: Throwable -> L10
        this.mLightEnabled = r1;     // Catch: Throwable -> L10
        SystemConfig sysConfig = SystemConfig.getInstance();     // Catch: Throwable -> L10
        ArraySet<String> allowPowerExceptIdle = sysConfig.getAllowInPowerSaveExceptIdle();     // Catch: Throwable -> L10
        int i = 0;
    L6:
        if (i >= allowPowerExceptIdle.size()) goto L15;
        String pkg = allowPowerExceptIdle.valueAt(i);     // Catch: Throwable -> L10
        ApplicationInfo ai = pm.getApplicationInfo(pkg, 5242880);     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L12
        int appid = UserHandle.getAppId(ai.uid);     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L12
        this.mPowerSaveWhitelistAppsExceptIdle.put(ai.packageName, Integer.valueOf(appid));     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L12
        this.mPowerSaveWhitelistSystemAppIdsExceptIdle.put(appid, true);     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L12
    L13:
        i = i + 1;
        goto L6
    L15:
        ArraySet<String> allowPower = sysConfig.getAllowInPowerSave();     // Catch: Throwable -> L10
        int i2 = 0;
    L17:
        if (i2 >= allowPower.size()) goto L24;
        String pkg2 = allowPower.valueAt(i2);     // Catch: Throwable -> L10
        ApplicationInfo ai2 = pm.getApplicationInfo(pkg2, 5242880);     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L21
        int appid2 = UserHandle.getAppId(ai2.uid);     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L21
        this.mPowerSaveWhitelistAppsExceptIdle.put(ai2.packageName, Integer.valueOf(appid2));     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L21
        this.mPowerSaveWhitelistSystemAppIdsExceptIdle.put(appid2, true);     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L21
        this.mPowerSaveWhitelistApps.put(ai2.packageName, Integer.valueOf(appid2));     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L21
        this.mPowerSaveWhitelistSystemAppIds.put(appid2, true);     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L21
    L22:
        i2 = i2 + 1;
        goto L17
    L24:
        this.mConstants = this.mInjector.getConstants(this, this.mHandler, getContext().getContentResolver());     // Catch: Throwable -> L10
        readConfigFileLocked();     // Catch: Throwable -> L10
        updateWhitelistAppIdsLocked();     // Catch: Throwable -> L10
        this.mNetworkConnected = true;     // Catch: Throwable -> L10
        this.mScreenOn = true;     // Catch: Throwable -> L10
        this.mScreenLocked = false;     // Catch: Throwable -> L10
        this.mCharging = true;     // Catch: Throwable -> L10
        this.mActiveReason = 0;     // Catch: Throwable -> L10
        moveToStateLocked(0, "boot");     // Catch: Throwable -> L10
        moveToLightStateLocked(0, "boot");     // Catch: Throwable -> L10
        this.mInactiveTimeout = this.mConstants.INACTIVE_TIMEOUT;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        this.mBinderService = new BinderService(this);
        publishBinderService("deviceidle", this.mBinderService);
        DeviceIdleControllerIA r2 = null;
        this.mLocalService = new LocalService(this, r2);
        publishLocalService(DeviceIdleInternal.class, this.mLocalService);
        publishLocalService(PowerAllowlistInternal.class, new LocalPowerAllowlistService(this, r2));
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L26;
        monitor-enter(this);
        this.mAlarmManager = this.mInjector.getAlarmManager();     // Catch: Throwable -> L8
        this.mLocalAlarmManager = (AlarmManagerInternal) getLocalService(AlarmManagerInternal.class);     // Catch: Throwable -> L8
        this.mBatteryStats = BatteryStatsService.getService();     // Catch: Throwable -> L8
        this.mLocalActivityManager = (ActivityManagerInternal) getLocalService(ActivityManagerInternal.class);     // Catch: Throwable -> L8
        this.mLocalActivityTaskManager = (ActivityTaskManagerInternal) getLocalService(ActivityTaskManagerInternal.class);     // Catch: Throwable -> L8
        this.mPackageManagerInternal = (PackageManagerInternal) getLocalService(PackageManagerInternal.class);     // Catch: Throwable -> L8
        this.mLocalPowerManager = (PowerManagerInternal) getLocalService(PowerManagerInternal.class);     // Catch: Throwable -> L8
        this.mPowerManager = this.mInjector.getPowerManager();     // Catch: Throwable -> L8
        this.mActiveIdleWakeLock = this.mPowerManager.newWakeLock(1, "deviceidle_maint");     // Catch: Throwable -> L8
        this.mActiveIdleWakeLock.setReferenceCounted(false);     // Catch: Throwable -> L8
        this.mGoingIdleWakeLock = this.mPowerManager.newWakeLock(1, "deviceidle_going_idle");     // Catch: Throwable -> L8
        this.mGoingIdleWakeLock.setReferenceCounted(true);     // Catch: Throwable -> L8
        this.mNetworkPolicyManager = INetworkPolicyManager.Stub.asInterface(ServiceManager.getService("netpolicy"));     // Catch: Throwable -> L8
        this.mNetworkPolicyManagerInternal = (NetworkPolicyManagerInternal) getLocalService(NetworkPolicyManagerInternal.class);     // Catch: Throwable -> L8
        this.mSensorManager = this.mInjector.getSensorManager();     // Catch: Throwable -> L8
        if (this.mUseMotionSensor == false) goto L11;
        this.mMotionSensor = this.mInjector.getMotionSensor();     // Catch: Throwable -> L8
    L11:
        if (this.mIsLocationPrefetchEnabled == false) goto L13;
        this.mLocationRequest = new LocationRequest.Builder(0).setQuality(100).setMaxUpdates(1).build();     // Catch: Throwable -> L8
    L13:
        this.mConstraintController = this.mInjector.getConstraintController(this.mHandler, (DeviceIdleInternal) getLocalService(LocalService.class));     // Catch: Throwable -> L8
        if (this.mConstraintController == null) goto L16;
        this.mConstraintController.start();     // Catch: Throwable -> L8
    L16:
        float angleThreshold = getContext().getResources().getInteger(R.integer.config_bg_current_drain_types_to_restricted_bucket) / 100.0f;     // Catch: Throwable -> L8
        this.mAnyMotionDetector = this.mInjector.getAnyMotionDetector(this.mHandler, this.mSensorManager, this, angleThreshold);     // Catch: Throwable -> L8
        this.mAppStateTracker.onSystemServicesReady();     // Catch: Throwable -> L8
        Bundle mostRecentDeliveryOptions = BroadcastOptions.makeBasic().setDeliveryGroupPolicy(1).setDeferralPolicy(2).toBundle();     // Catch: Throwable -> L8
        this.mIdleIntent = new Intent("android.os.action.DEVICE_IDLE_MODE_CHANGED");     // Catch: Throwable -> L8
        this.mIdleIntent.addFlags(1342177280);     // Catch: Throwable -> L8
        this.mLightIdleIntent = new Intent("android.os.action.LIGHT_DEVICE_IDLE_MODE_CHANGED");     // Catch: Throwable -> L8
        this.mLightIdleIntent.addFlags(1342177280);     // Catch: Throwable -> L8
        this.mLightIdleIntentOptions = mostRecentDeliveryOptions;     // Catch: Throwable -> L8
        this.mIdleIntentOptions = mostRecentDeliveryOptions;     // Catch: Throwable -> L8
        this.mPowerSaveWhitelistChangedIntent = new Intent("android.os.action.POWER_SAVE_WHITELIST_CHANGED");     // Catch: Throwable -> L8
        this.mPowerSaveWhitelistChangedIntent.addFlags(1073741824);     // Catch: Throwable -> L8
        this.mPowerSaveTempWhitelistChangedIntent = new Intent("android.os.action.POWER_SAVE_TEMP_WHITELIST_CHANGED");     // Catch: Throwable -> L8
        this.mPowerSaveTempWhitelistChangedIntent.addFlags(1073741824);     // Catch: Throwable -> L8
        this.mPowerSaveWhitelistChangedOptions = mostRecentDeliveryOptions;     // Catch: Throwable -> L8
        this.mPowerSaveTempWhilelistChangedOptions = mostRecentDeliveryOptions;     // Catch: Throwable -> L8
        IntentFilter filter = new IntentFilter();     // Catch: Throwable -> L8
        filter.addAction("android.intent.action.BATTERY_CHANGED");     // Catch: Throwable -> L8
        getContext().registerReceiver(this.mReceiver, filter);     // Catch: Throwable -> L8
        IntentFilter filter2 = new IntentFilter();     // Catch: Throwable -> L8
        filter2.addAction("android.intent.action.PACKAGE_REMOVED");     // Catch: Throwable -> L8
        filter2.addDataScheme(com.android.server.pm.Settings.ATTR_PACKAGE);     // Catch: Throwable -> L8
        getContext().registerReceiver(this.mReceiver, filter2);     // Catch: Throwable -> L8
        IntentFilter filter3 = new IntentFilter();     // Catch: Throwable -> L8
        filter3.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Throwable -> L8
        getContext().registerReceiver(this.mReceiver, filter3);     // Catch: Throwable -> L8
        IntentFilter filter4 = new IntentFilter();     // Catch: Throwable -> L8
        filter4.addAction("android.intent.action.SCREEN_OFF");     // Catch: Throwable -> L8
        filter4.addAction("android.intent.action.SCREEN_ON");     // Catch: Throwable -> L8
        getContext().registerReceiver(this.mInteractivityReceiver, filter4);     // Catch: Throwable -> L8
        SysOptApexBridge.getFactory().getDeviceIdleController().registerReceiver(getContext());     // Catch: Throwable -> L8
        this.mHandler.post(new AnonymousClass9(this));     // Catch: Throwable -> L8
        this.mLocalActivityManager.setDeviceIdleAllowlist(this.mPowerSaveWhitelistAllAppIdArray, this.mPowerSaveWhitelistExceptIdleAppIdArray);     // Catch: Throwable -> L8
        this.mLocalPowerManager.setDeviceIdleWhitelist(this.mPowerSaveWhitelistAllAppIdArray);     // Catch: Throwable -> L8
        if (this.mConstants.USE_MODE_MANAGER == false) goto L21;
        WearModeManagerInternal modeManagerInternal = (WearModeManagerInternal) LocalServices.getService(WearModeManagerInternal.class);     // Catch: Throwable -> L8
        if (modeManagerInternal == null) goto L21;
        modeManagerInternal.addActiveStateChangeListener("quick_doze_request", AppSchedulingModuleThread.getExecutor(), this.mModeManagerQuickDozeRequestConsumer);     // Catch: Throwable -> L8
        modeManagerInternal.addActiveStateChangeListener("off_body", AppSchedulingModuleThread.getExecutor(), this.mModeManagerOffBodyStateConsumer);     // Catch: Throwable -> L8
    L21:
        this.mLocalPowerManager.registerLowPowerModeObserver(15, new DeviceIdleController$$ExternalSyntheticLambda13(this));     // Catch: Throwable -> L8
        this.mBatterySaverEnabled = this.mLocalPowerManager.getLowPowerState(15).batterySaverEnabled;     // Catch: Throwable -> L8
        updateQuickDozeFlagLocked();     // Catch: Throwable -> L8
        this.mLocalActivityTaskManager.registerScreenObserver(this.mScreenObserver);     // Catch: Throwable -> L8
        this.mInjector.getTelephonyManager().registerTelephonyCallback(AppSchedulingModuleThread.getExecutor(), this.mEmergencyCallListener);     // Catch: Throwable -> L8
        passWhiteListsToForceAppStandbyTrackerLocked();     // Catch: Throwable -> L8
        updateInteractivityLocked();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        updateConnectivityState(null);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onBootPhase$3(PowerSaveState state) {
        monitor-enter(this);
        this.mBatterySaverEnabled = state.batterySaverEnabled;     // Catch: Throwable -> L6
        updateQuickDozeFlagLocked();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    boolean hasMotionSensor() {
        if (this.mUseMotionSensor == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mMotionSensor == null) goto L7;
        return true;
    }

    private void registerDeviceIdleConstraintInternal(IDeviceIdleConstraint constraint, String name, int type) {
        switch(type) {
            case 0: goto L6;
            case 1: goto L5;
            default: goto L3;
        };
    L3:
        Slog.wtf(TAG, "Registering device-idle constraint with invalid type: " + type);
        return;
    L5:
        int minState = 3;
    L7:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mConstraints.containsKey(constraint) == false) goto L15;
        Slog.e(TAG, "Re-registering device-idle constraint: " + constraint + ".");     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L15:
        DeviceIdleConstraintTracker tracker = new DeviceIdleConstraintTracker(name, minState);     // Catch: Throwable -> L13
        this.mConstraints.put(constraint, tracker);     // Catch: Throwable -> L13
        updateActiveConstraintsLocked();     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L6:
        minState = 0;
        goto L7
    }

    private void unregisterDeviceIdleConstraintInternal(IDeviceIdleConstraint constraint) {
        monitor-enter(this);
        onConstraintStateChangedLocked(constraint, false);     // Catch: Throwable -> L7
        setConstraintMonitoringLocked(constraint, false);     // Catch: Throwable -> L7
        this.mConstraints.remove(constraint);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onConstraintStateChangedLocked(IDeviceIdleConstraint constraint, boolean active) {
        DeviceIdleConstraintTracker tracker = this.mConstraints.get(constraint);
        if (tracker != null) goto L7;
        Slog.e(TAG, "device-idle constraint " + constraint + " has not been registered.");
        return;
    L7:
        if (active != tracker.active) goto L9;
        return;
    L9:
        if (tracker.monitoring == false) goto L26;
        tracker.active = active;
        int r1 = this.mNumBlockingConstraints;
        if (tracker.active == false) goto L13;
        int r2 = 1;
    L14:
        this.mNumBlockingConstraints = r1 + r2;
        if (this.mNumBlockingConstraints == 0) goto L17;
        return;
    L17:
        if (this.mState != 0) goto L20;
        becomeInactiveIfAppropriateLocked();
        return;
    L20:
        if (this.mNextAlarmTime != 0) goto L22;
    L23:
        stepIdleStateLocked("s:" + tracker.name);
        return;
    L22:
        if (this.mNextAlarmTime < SystemClock.elapsedRealtime()) goto L23;
        return;
    L13:
        r2 = -1;
        goto L14
    }

    private void setConstraintMonitoringLocked(IDeviceIdleConstraint r5, boolean r6) {
        DeviceIdleConstraintTracker r0 = this.mConstraints.get(r5);
        if (r0.monitoring == r6) goto L6;
        r0.monitoring = r6;
        updateActiveConstraintsLocked();
        this.mHandler.obtainMessage(10, r6 ? 1 : 0, -1, r5).sendToTarget();
        return;
    }

    private void updateActiveConstraintsLocked() {
        this.mNumBlockingConstraints = 0;
        int i = 0;
    L4:
        if (i >= this.mConstraints.size()) goto L19;
        IDeviceIdleConstraint constraint = this.mConstraints.keyAt(i);
        DeviceIdleConstraintTracker tracker = this.mConstraints.valueAt(i);
        if (tracker.minState != this.mState) goto L8;
        boolean monitoring = true;
    L10:
        if (monitoring == tracker.monitoring) goto L13;
        setConstraintMonitoringLocked(constraint, monitoring);
        tracker.active = monitoring;
    L13:
        if (tracker.monitoring == false) goto L17;
        if (tracker.active == false) goto L17;
        this.mNumBlockingConstraints++;
    L17:
        i = i + 1;
        goto L4
    L8:
        monitoring = false;
        goto L10
    }

    private int addPowerSaveWhitelistAppsInternal(List<String> pkgNames) {
        int numAdded = 0;
        int numErrors = 0;
        monitor-enter(this);
        int i = pkgNames.size() - 1;     // Catch: Throwable -> L13
    L5:
        if (i < 0) goto L22;
        String name = pkgNames.get(i);     // Catch: Throwable -> L13
        if (name != null) goto L29;
        numErrors = numErrors + 1;
    L20:
        i = i - 1;     // Catch: Throwable -> L13
        goto L5
    L29:
        ApplicationInfo ai = getContext().getPackageManager().getApplicationInfo(name, 4194304);     // Catch: Throwable -> L13 PackageManager.NameNotFoundException -> L15
        if (this.mPowerSaveWhitelistUserApps.put(name, Integer.valueOf(UserHandle.getAppId(ai.uid))) != null) goto L20;
        numAdded = numAdded + 1;     // Catch: Throwable -> L13 PackageManager.NameNotFoundException -> L15
        Counter.logIncrement(USER_ALLOWLIST_ADDITION_METRIC_ID);     // Catch: Throwable -> L13 PackageManager.NameNotFoundException -> L15
    L19:
        Slog.e(TAG, "Tried to add unknown package to power save whitelist: " + name);     // Catch: Throwable -> L13
        numErrors = numErrors + 1;     // Catch: Throwable -> L13
        goto L20
    L22:
        if (numAdded <= 0) goto L24;
        reportPowerSaveWhitelistChangedLocked();     // Catch: Throwable -> L13
        updateWhitelistAppIdsLocked();     // Catch: Throwable -> L13
        writeConfigFileLocked();     // Catch: Throwable -> L13
    L24:
        monitor-exit(this);     // Catch: Throwable -> L13
        return pkgNames.size() - numErrors;
    L13:
        th = move-exception;
        throw th;
    }

    public boolean removePowerSaveWhitelistAppInternal(String name) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mPowerSaveWhitelistUserApps.remove(name) == null) goto L11;
        reportPowerSaveWhitelistChangedLocked();     // Catch: Throwable -> L9
        updateWhitelistAppIdsLocked();     // Catch: Throwable -> L9
        writeConfigFileLocked();     // Catch: Throwable -> L9
        Counter.logIncrement(USER_ALLOWLIST_REMOVAL_METRIC_ID);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return true;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L9
        return false;
    }

    public boolean getPowerSaveWhitelistAppInternal(String name) {
        monitor-enter(this);
        boolean r0 = this.mPowerSaveWhitelistUserApps.containsKey(name);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    void resetSystemPowerWhitelistInternal() {
        monitor-enter(this);
        this.mPowerSaveWhitelistApps.putAll(this.mRemovedFromSystemWhitelistApps);     // Catch: Throwable -> L6
        this.mRemovedFromSystemWhitelistApps.clear();     // Catch: Throwable -> L6
        reportPowerSaveWhitelistChangedLocked();     // Catch: Throwable -> L6
        updateWhitelistAppIdsLocked();     // Catch: Throwable -> L6
        writeConfigFileLocked();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean restoreSystemPowerWhitelistAppInternal(String name) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mRemovedFromSystemWhitelistApps.containsKey(name) == true) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return false;
    L10:
        this.mPowerSaveWhitelistApps.put(name, this.mRemovedFromSystemWhitelistApps.remove(name));     // Catch: Throwable -> L8
        reportPowerSaveWhitelistChangedLocked();     // Catch: Throwable -> L8
        updateWhitelistAppIdsLocked();     // Catch: Throwable -> L8
        writeConfigFileLocked();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return true;
    }

    public boolean removeSystemPowerWhitelistAppInternal(String name) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mPowerSaveWhitelistApps.containsKey(name) == true) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return false;
    L10:
        this.mRemovedFromSystemWhitelistApps.put(name, this.mPowerSaveWhitelistApps.remove(name));     // Catch: Throwable -> L8
        reportPowerSaveWhitelistChangedLocked();     // Catch: Throwable -> L8
        updateWhitelistAppIdsLocked();     // Catch: Throwable -> L8
        writeConfigFileLocked();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return true;
    }

    public boolean addPowerSaveWhitelistExceptIdleInternal(String name) {
        monitor-enter(this);
        ApplicationInfo ai = getContext().getPackageManager().getApplicationInfo(name, 4194304);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
        if (this.mPowerSaveWhitelistAppsExceptIdle.put(name, Integer.valueOf(UserHandle.getAppId(ai.uid))) != null) goto L11;
        this.mPowerSaveWhitelistUserAppsExceptIdle.add(name);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
        reportPowerSaveWhitelistChangedLocked();     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
        this.mPowerSaveWhitelistExceptIdleAppIdArray = buildAppIdArray(this.mPowerSaveWhitelistAppsExceptIdle, this.mPowerSaveWhitelistUserApps, this.mPowerSaveWhitelistExceptIdleAppIds);     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
        passWhiteListsToForceAppStandbyTrackerLocked();     // Catch: Throwable -> L7 PackageManager.NameNotFoundException -> L9
    L11:
        monitor-exit(this);     // Catch: Throwable -> L7
        return true;
    L7:
        th = move-exception;
        throw th;
    L16:
        return false;
    }

    public void resetPowerSaveWhitelistExceptIdleInternal() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mPowerSaveWhitelistAppsExceptIdle.removeAll(this.mPowerSaveWhitelistUserAppsExceptIdle) == false) goto L8;
        reportPowerSaveWhitelistChangedLocked();     // Catch: Throwable -> L6
        this.mPowerSaveWhitelistExceptIdleAppIdArray = buildAppIdArray(this.mPowerSaveWhitelistAppsExceptIdle, this.mPowerSaveWhitelistUserApps, this.mPowerSaveWhitelistExceptIdleAppIds);     // Catch: Throwable -> L6
        this.mPowerSaveWhitelistUserAppsExceptIdle.clear();     // Catch: Throwable -> L6
        passWhiteListsToForceAppStandbyTrackerLocked();     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
    }

    public boolean getPowerSaveWhitelistExceptIdleInternal(String name) {
        monitor-enter(this);
        boolean r0 = this.mPowerSaveWhitelistAppsExceptIdle.containsKey(name);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private String[] getSystemPowerWhitelistExceptIdleInternal(final int callingUid, final int callingUserId) {
        monitor-enter(this);
        int size = this.mPowerSaveWhitelistAppsExceptIdle.size();     // Catch: Throwable -> L6
        String[] apps = new String[size];     // Catch: Throwable -> L6
        int i = 0;
    L4:
        if (i >= size) goto L9;
        apps[i] = this.mPowerSaveWhitelistAppsExceptIdle.keyAt(i);     // Catch: Throwable -> L6
        i = i + 1;     // Catch: Throwable -> L6
        goto L4
    L9:
        monitor-exit(this);     // Catch: Throwable -> L6
        return (String[]) ArrayUtils.filter(apps, new DeviceIdleController$$ExternalSyntheticLambda0(), new DeviceIdleController$$ExternalSyntheticLambda1(this, callingUid, callingUserId));
    L6:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ String[] lambda$getSystemPowerWhitelistExceptIdleInternal$4(int x$0) {
        return new String[x$0];
    }

    private /* synthetic */ boolean lambda$getSystemPowerWhitelistExceptIdleInternal$5(int callingUid, int callingUserId, String pkg) {
        return !this.mPackageManagerInternal.filterAppAccess(pkg, callingUid, callingUserId);
    }

    private String[] getSystemPowerWhitelistInternal(final int callingUid, final int callingUserId) {
        monitor-enter(this);
        int size = this.mPowerSaveWhitelistApps.size();     // Catch: Throwable -> L6
        String[] apps = new String[size];     // Catch: Throwable -> L6
        int i = 0;
    L4:
        if (i >= size) goto L9;
        apps[i] = this.mPowerSaveWhitelistApps.keyAt(i);     // Catch: Throwable -> L6
        i = i + 1;     // Catch: Throwable -> L6
        goto L4
    L9:
        monitor-exit(this);     // Catch: Throwable -> L6
        return (String[]) ArrayUtils.filter(apps, new DeviceIdleController$$ExternalSyntheticLambda9(), new DeviceIdleController$$ExternalSyntheticLambda10(this, callingUid, callingUserId));
    L6:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ String[] lambda$getSystemPowerWhitelistInternal$6(int x$0) {
        return new String[x$0];
    }

    private /* synthetic */ boolean lambda$getSystemPowerWhitelistInternal$7(int callingUid, int callingUserId, String pkg) {
        return !this.mPackageManagerInternal.filterAppAccess(pkg, callingUid, callingUserId);
    }

    private String[] getRemovedSystemPowerWhitelistAppsInternal(final int callingUid, final int callingUserId) {
        monitor-enter(this);
        int size = this.mRemovedFromSystemWhitelistApps.size();     // Catch: Throwable -> L6
        String[] apps = new String[size];     // Catch: Throwable -> L6
        int i = 0;
    L4:
        if (i >= size) goto L9;
        apps[i] = this.mRemovedFromSystemWhitelistApps.keyAt(i);     // Catch: Throwable -> L6
        i = i + 1;     // Catch: Throwable -> L6
        goto L4
    L9:
        monitor-exit(this);     // Catch: Throwable -> L6
        return (String[]) ArrayUtils.filter(apps, new DeviceIdleController$$ExternalSyntheticLambda7(), new DeviceIdleController$$ExternalSyntheticLambda8(this, callingUid, callingUserId));
    L6:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ String[] lambda$getRemovedSystemPowerWhitelistAppsInternal$8(int x$0) {
        return new String[x$0];
    }

    private /* synthetic */ boolean lambda$getRemovedSystemPowerWhitelistAppsInternal$9(int callingUid, int callingUserId, String pkg) {
        return !this.mPackageManagerInternal.filterAppAccess(pkg, callingUid, callingUserId);
    }

    private String[] getUserPowerWhitelistInternal(final int callingUid, final int callingUserId) {
        monitor-enter(this);
        int size = this.mPowerSaveWhitelistUserApps.size();     // Catch: Throwable -> L7
        String[] apps = new String[size];     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= this.mPowerSaveWhitelistUserApps.size()) goto L10;
        apps[i] = this.mPowerSaveWhitelistUserApps.keyAt(i);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(this);     // Catch: Throwable -> L7
        return (String[]) ArrayUtils.filter(apps, new DeviceIdleController$$ExternalSyntheticLambda11(), new DeviceIdleController$$ExternalSyntheticLambda12(this, callingUid, callingUserId));
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ String[] lambda$getUserPowerWhitelistInternal$10(int x$0) {
        return new String[x$0];
    }

    private /* synthetic */ boolean lambda$getUserPowerWhitelistInternal$11(int callingUid, int callingUserId, String pkg) {
        return !this.mPackageManagerInternal.filterAppAccess(pkg, callingUid, callingUserId);
    }

    private String[] getFullPowerWhitelistExceptIdleInternal(final int callingUid, final int callingUserId) {
        monitor-enter(this);
        int size = this.mPowerSaveWhitelistAppsExceptIdle.size() + this.mPowerSaveWhitelistUserApps.size();     // Catch: Throwable -> L7
        String[] apps = new String[size];     // Catch: Throwable -> L7
        int cur = 0;
        int i = 0;
    L5:
        if (i >= this.mPowerSaveWhitelistAppsExceptIdle.size()) goto L9;
        apps[cur] = this.mPowerSaveWhitelistAppsExceptIdle.keyAt(i);     // Catch: Throwable -> L7
        cur = cur + 1;     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        int i2 = 0;
    L11:
        if (i2 >= this.mPowerSaveWhitelistUserApps.size()) goto L14;
        apps[cur] = this.mPowerSaveWhitelistUserApps.keyAt(i2);     // Catch: Throwable -> L7
        cur = cur + 1;     // Catch: Throwable -> L7
        i2 = i2 + 1;     // Catch: Throwable -> L7
        goto L11
    L14:
        monitor-exit(this);     // Catch: Throwable -> L7
        return (String[]) ArrayUtils.filter(apps, new DeviceIdleController$$ExternalSyntheticLambda5(), new DeviceIdleController$$ExternalSyntheticLambda6(this, callingUid, callingUserId));
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ String[] lambda$getFullPowerWhitelistExceptIdleInternal$12(int x$0) {
        return new String[x$0];
    }

    private /* synthetic */ boolean lambda$getFullPowerWhitelistExceptIdleInternal$13(int callingUid, int callingUserId, String pkg) {
        return !this.mPackageManagerInternal.filterAppAccess(pkg, callingUid, callingUserId);
    }

    private String[] getFullPowerWhitelistInternal(final int callingUid, final int callingUserId) {
        return (String[]) ArrayUtils.filter(getFullPowerWhitelistInternalUnchecked(), new DeviceIdleController$$ExternalSyntheticLambda14(), new DeviceIdleController$$ExternalSyntheticLambda15(this, callingUid, callingUserId));
    }

    private static /* synthetic */ String[] lambda$getFullPowerWhitelistInternal$14(int x$0) {
        return new String[x$0];
    }

    private /* synthetic */ boolean lambda$getFullPowerWhitelistInternal$15(int callingUid, int callingUserId, String pkg) {
        return !this.mPackageManagerInternal.filterAppAccess(pkg, callingUid, callingUserId);
    }

    private String[] getFullPowerWhitelistInternalUnchecked() {
        monitor-enter(this);
        int size = this.mPowerSaveWhitelistApps.size() + this.mPowerSaveWhitelistUserApps.size();     // Catch: Throwable -> L7
        String[] apps = new String[size];     // Catch: Throwable -> L7
        int cur = 0;
        int i = 0;
    L5:
        if (i >= this.mPowerSaveWhitelistApps.size()) goto L9;
        apps[cur] = this.mPowerSaveWhitelistApps.keyAt(i);     // Catch: Throwable -> L7
        cur = cur + 1;     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        int i2 = 0;
    L11:
        if (i2 >= this.mPowerSaveWhitelistUserApps.size()) goto L14;
        apps[cur] = this.mPowerSaveWhitelistUserApps.keyAt(i2);     // Catch: Throwable -> L7
        cur = cur + 1;     // Catch: Throwable -> L7
        i2 = i2 + 1;     // Catch: Throwable -> L7
        goto L11
    L14:
        monitor-exit(this);     // Catch: Throwable -> L7
        return apps;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isPowerSaveWhitelistExceptIdleAppInternal(String packageName) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mPowerSaveWhitelistAppsExceptIdle.containsKey(packageName) == false) goto L6;
    L11:
        boolean r0 = true;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r0;
    L6:
        if (this.mPowerSaveWhitelistUserApps.containsKey(packageName) == true) goto L11;
        r0 = false;
        goto L12
    }

    public boolean isPowerSaveWhitelistAppInternal(String packageName) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mPowerSaveWhitelistApps.containsKey(packageName) == false) goto L6;
    L11:
        boolean r0 = true;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L9
        return r0;
    L6:
        if (this.mPowerSaveWhitelistUserApps.containsKey(packageName) == true) goto L11;
        r0 = false;
        goto L12
    }

    public int[] getAppIdWhitelistExceptIdleInternal() {
        monitor-enter(this);
        int[] r0 = this.mPowerSaveWhitelistExceptIdleAppIdArray;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int[] getAppIdWhitelistInternal() {
        monitor-enter(this);
        int[] r0 = this.mPowerSaveWhitelistAllAppIdArray;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int[] getAppIdUserWhitelistInternal() {
        monitor-enter(this);
        int[] r0 = this.mPowerSaveWhitelistUserAppIdArray;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int[] getAppIdTempWhitelistInternal() {
        monitor-enter(this);
        int[] r0 = this.mTempWhitelistAppIdArray;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private int getTempAllowListType(int reasonCode, int defaultType) {
        switch(reasonCode) {
            case -1: goto L6;
            case 102: goto L5;
            default: goto L3;
        };
    L3:
        return defaultType;
    L6:
        return -1;
    L5:
        return this.mLocalActivityManager.getPushMessagingOverQuotaBehavior();
    }

    void addPowerSaveTempAllowlistAppChecked(String packageName, long duration, int userId, int reasonCode, String reason) throws RemoteException {
        getContext().enforceCallingOrSelfPermission("android.permission.CHANGE_DEVICE_IDLE_TEMP_WHITELIST", "No permission to change device idle whitelist");
        int callingUid = Binder.getCallingUid();
        int userId2 = ActivityManager.getService().handleIncomingUser(Binder.getCallingPid(), callingUid, userId, false, false, "addPowerSaveTempWhitelistApp", null);
        long token = Binder.clearCallingIdentity();
        int type = getTempAllowListType(reasonCode, 0);     // Catch: Throwable -> L13
        if (type != (-1)) goto L18;
    L11:
        Binder.restoreCallingIdentity(token);
        return;
    L18:
        addPowerSaveTempAllowlistAppInternal(callingUid, packageName, duration, type, userId2, true, reasonCode, reason);     // Catch: Throwable -> L9
    L9:
        th = th;
    L14:
        Binder.restoreCallingIdentity(token);
        throw th;
    L13:
        th = th;
        goto L14
    }

    void removePowerSaveTempAllowlistAppChecked(String packageName, int userId) throws RemoteException {
        getContext().enforceCallingOrSelfPermission("android.permission.CHANGE_DEVICE_IDLE_TEMP_WHITELIST", "No permission to change device idle whitelist");
        int callingUid = Binder.getCallingUid();
        int userId2 = ActivityManager.getService().handleIncomingUser(Binder.getCallingPid(), callingUid, userId, false, false, "removePowerSaveTempWhitelistApp", null);
        long token = Binder.clearCallingIdentity();
        removePowerSaveTempAllowlistAppInternal(packageName, userId2);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    void addPowerSaveTempAllowlistAppInternal(int callingUid, String packageName, long durationMs, int tempAllowListType, int userId, boolean sync, int reasonCode, String reason) {
        int uid = getContext().getPackageManager().getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L6
        addPowerSaveTempWhitelistAppDirectInternal(callingUid, uid, durationMs, tempAllowListType, sync, reasonCode, reason);     // Catch: PackageManager.NameNotFoundException -> L6
        return;
    L16:
        return;
    }

    void addPowerSaveTempWhitelistAppDirectInternal(int callingUid, int uid, long duration, int tempAllowListType, boolean sync, int reasonCode, String reason) {
        long timeNow = this.mInjector.getUptimeMillis();
        boolean informWhitelistChanged = false;
        int appId = UserHandle.getAppId(uid);
        monitor-enter(this);
        long r5 = duration;
        long duration2 = Math.min(r5, this.mConstants.MAX_TEMP_APP_ALLOWLIST_DURATION_MS);     // Catch: Throwable -> L43
        Pair<MutableLong, String> entry = this.mTempWhitelistAppIdEndTimes.get(appId);     // Catch: Throwable -> L15
        if (entry != null) goto L11;
        boolean r3 = true;
    L12:
        boolean newEntry = r3;
        if (newEntry == false) goto L18;
        Pair<MutableLong, String> entry2 = new Pair(new MutableLong(0), reason);     // Catch: Throwable -> L15
        this.mTempWhitelistAppIdEndTimes.put(appId, entry2);     // Catch: Throwable -> L15
        Pair<MutableLong, String> entry3 = entry2;
    L19:
        long r6 = timeNow + duration2;     // Catch: Throwable -> L15
        ((MutableLong) entry3.first).value = r6;     // Catch: Throwable -> L15
        if (newEntry == true) goto L49;
        int r7 = reasonCode;
        DeviceIdleController r15 = this;
        if (r15.mLocalActivityManager == null) goto L39;
        r15.mLocalActivityManager.updateDeviceIdleTempAllowlist(null, uid, true, duration2, tempAllowListType, r7, reason, callingUid);     // Catch: Throwable -> L32
    L39:
        monitor-exit(this);     // Catch: Throwable -> L32
        if (informWhitelistChanged == false) goto L59;
        r15.mNetworkPolicyManagerInternal.onTempPowerSaveWhitelistChange(appId, true, r7, reason);
        return;
    L59:
        return;
    L49:
        this.mBatteryStats.noteEvent(32785, reason, uid);     // Catch: Throwable -> L15 RemoteException -> L23
    L24:
        postTempActiveTimeoutMessage(uid, duration2);     // Catch: Throwable -> L15
        r7 = reasonCode;
        updateTempWhitelistAppIdsLocked(uid, true, duration2, tempAllowListType, r7, reason, callingUid);     // Catch: Throwable -> L34
        r15 = this;
        if (sync == false) goto L30;
        informWhitelistChanged = true;
    L31:
        r15.reportTempWhitelistChangedLocked(uid, true);     // Catch: Throwable -> L32
        goto L39
    L30:
        r15.mHandler.obtainMessage(14, appId, r7, reason).sendToTarget();     // Catch: Throwable -> L32
    L34:
        th = th;
    L47:
        monitor-exit(this);     // Catch: Throwable -> L32
        throw th;
    L18:
        entry3 = entry;
        goto L19
    L11:
        r3 = false;
    L15:
        th = th;
    L43:
        th = th;
    L32:
        th = th;
    L45:
        th = th;
        r5 = duration;
        goto L47
    }

    private void removePowerSaveTempAllowlistAppInternal(String packageName, int userId) {
        int uid = getContext().getPackageManager().getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L4
        removePowerSaveTempWhitelistAppDirectInternal(uid);     // Catch: PackageManager.NameNotFoundException -> L4
        return;
    }

    private void removePowerSaveTempWhitelistAppDirectInternal(int uid) {
        int appId = UserHandle.getAppId(uid);
        monitor-enter(this);
        int idx = this.mTempWhitelistAppIdEndTimes.indexOfKey(appId);     // Catch: Throwable -> L8
        if (idx >= 0) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        String reason = (String) this.mTempWhitelistAppIdEndTimes.valueAt(idx).second;     // Catch: Throwable -> L8
        this.mTempWhitelistAppIdEndTimes.removeAt(idx);     // Catch: Throwable -> L8
        onAppRemovedFromTempWhitelistLocked(uid, reason);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void postTempActiveTimeoutMessage(int uid, long delay) {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(6, uid, 0), delay);
    }

    void checkTempAppWhitelistTimeout(int uid) {
        long timeNow = this.mInjector.getUptimeMillis();
        int appId = UserHandle.getAppId(uid);
        monitor-enter(this);
        Pair<MutableLong, String> entry = this.mTempWhitelistAppIdEndTimes.get(appId);     // Catch: Throwable -> L8
        if (entry != null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L11:
        if (timeNow < ((MutableLong) entry.first).value) goto L13;
        this.mTempWhitelistAppIdEndTimes.delete(appId);     // Catch: Throwable -> L8
        onAppRemovedFromTempWhitelistLocked(uid, (String) entry.second);     // Catch: Throwable -> L8
    L14:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L13:
        postTempActiveTimeoutMessage(uid, ((MutableLong) entry.first).value - timeNow);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private void onAppRemovedFromTempWhitelistLocked(int uid, String reason) {
        if ("obric-app-intent-exec".equals(reason) == false) goto L5;
        Slog.i(TAG, "Removing uid " + uid + " from temp whitelist. reason:" + reason);
    L5:
        int appId = UserHandle.getAppId(uid);
        updateTempWhitelistAppIdsLocked(uid, false, 0, 0, 0, reason, -1);
        this.mHandler.obtainMessage(15, appId, 0).sendToTarget();
        reportTempWhitelistChangedLocked(uid, false);
        this.mBatteryStats.noteEvent(16401, reason, appId);     // Catch: RemoteException -> L8
        return;
    }

    public void exitIdleInternal(String reason) {
        monitor-enter(this);
        this.mActiveReason = 5;     // Catch: Throwable -> L7
        becomeActiveLocked(reason, Binder.getCallingUid());     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isNetworkConnected() {
        monitor-enter(this);
        boolean r0 = this.mNetworkConnected;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    void updateConnectivityState(Intent connIntent) {
        monitor-enter(this);
        ConnectivityManager cm = this.mInjector.getConnectivityManager();     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        if (cm != null) goto L7;
        return;
    L7:
        NetworkInfo ni = cm.getActiveNetworkInfo();
        monitor-enter(this);
        if (ni != null) goto L11;
        boolean conn = false;
    L21:
        if (conn == this.mNetworkConnected) goto L27;
        this.mNetworkConnected = conn;     // Catch: Throwable -> L13
        if (conn == false) goto L27;
        if (this.mLightState != 5) goto L27;
        stepLightIdleStateLocked("network");     // Catch: Throwable -> L13
    L27:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L11:
        if (connIntent != null) goto L15;
        conn = ni.isConnected();     // Catch: Throwable -> L13
        goto L21
    L15:
        int networkType = connIntent.getIntExtra("networkType", -1);     // Catch: Throwable -> L13
        if (ni.getType() == networkType) goto L19;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L19:
        conn = !connIntent.getBooleanExtra("noConnectivity", false);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L31:
        th = move-exception;
        throw th;
    }

    boolean isScreenOn() {
        monitor-enter(this);
        boolean r0 = this.mScreenOn;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    void updateInteractivityLocked() {
        boolean screenOn = this.mPowerManager.isInteractive();
        if (screenOn == false) goto L5;
    L9:
        if (screenOn == false) goto L20;
        this.mScreenOn = true;
        if (this.mForceIdle == false) goto L13;
        return;
    L13:
        if (this.mScreenLocked == true) goto L15;
    L16:
        this.mActiveReason = 2;
        becomeActiveLocked(EventTeardownResult.EVENT_SCREEN, Process.myUid());
        return;
    L15:
        if (this.mConstants.WAIT_FOR_UNLOCK == false) goto L16;
        return;
    L20:
        return;
    L5:
        if (this.mScreenOn == false) goto L9;
        this.mScreenOn = false;
        if (this.mForceIdle == true) goto L18;
        becomeInactiveIfAppropriateLocked();
        return;
    }

    boolean isCharging() {
        monitor-enter(this);
        boolean r0 = this.mCharging;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    void updateChargingLocked(boolean charging) {
        if (charging == false) goto L4;
    L8:
        if (charging == false) goto L15;
        this.mCharging = charging;
        if (this.mForceIdle == true) goto L16;
        this.mActiveReason = 3;
        becomeActiveLocked(EventTeardownResult.EVENT_CHARGING, Process.myUid());
        return;
    L16:
        return;
    L15:
        return;
    L4:
        if (this.mCharging == false) goto L8;
        this.mCharging = false;
        if (this.mForceIdle == true) goto L13;
        becomeInactiveIfAppropriateLocked();
        return;
    }

    boolean isQuickDozeEnabled() {
        monitor-enter(this);
        boolean r0 = this.mQuickDozeActivated;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private void updateQuickDozeFlagLocked() {
        if (this.mConstants.USE_MODE_MANAGER == true) goto L5;
        updateQuickDozeFlagLocked(this.mBatterySaverEnabled);
        return;
    L5:
        if (this.mModeManagerRequestedQuickDoze == false) goto L7;
    L10:
        boolean r0 = true;
    L11:
        updateQuickDozeFlagLocked(r0);
        return;
    L7:
        if (this.mBatterySaverEnabled == true) goto L10;
        r0 = false;
        goto L11
    }

    void updateQuickDozeFlagLocked(boolean enabled) {
        this.mQuickDozeActivated = enabled;
        if (this.mQuickDozeActivated == true) goto L5;
    L9:
        boolean r0 = false;
    L10:
        this.mQuickDozeActivatedWhileIdling = r0;
        if (enabled == false) goto L14;
        becomeInactiveIfAppropriateLocked();
        return;
    L14:
        return;
    L5:
        if (this.mState != 5) goto L7;
    L8:
        r0 = true;
        goto L10
    L7:
        if (this.mState != 6) goto L9;
        goto L8
    }

    boolean isKeyguardShowing() {
        monitor-enter(this);
        boolean r0 = this.mScreenLocked;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    void keyguardShowingLocked(boolean showing) {
        if (this.mScreenLocked == showing) goto L12;
        this.mScreenLocked = showing;
        if (this.mScreenOn == true) goto L7;
        return;
    L7:
        if (this.mForceIdle == false) goto L9;
        return;
    L9:
        if (this.mScreenLocked == true) goto L15;
        this.mActiveReason = 4;
        becomeActiveLocked("unlocked", Process.myUid());
        return;
    L15:
        return;
    }

    void scheduleReportActiveLocked(String activeReason, int activeUid) {
        Message msg = this.mHandler.obtainMessage(5, activeUid, 0, activeReason);
        this.mHandler.sendMessage(msg);
    }

    void becomeActiveLocked(String activeReason, int activeUid) {
        becomeActiveLocked(activeReason, activeUid, this.mConstants.INACTIVE_TIMEOUT, true);
    }

    private void becomeActiveLocked(String activeReason, int activeUid, long newInactiveTimeout, boolean changeLightIdle) {
        if (this.mState == 0) goto L5;
    L6:
        moveToStateLocked(0, activeReason);
        this.mInactiveTimeout = newInactiveTimeout;
        resetIdleManagementLocked();
        if (this.mLightState == 6) goto L9;
        this.mMaintenanceStartTime = 0;
    L9:
        if (changeLightIdle == false) goto L13;
        moveToLightStateLocked(0, activeReason);
        resetLightIdleManagementLocked();
        scheduleReportActiveLocked(activeReason, activeUid);
        addEvent(1, activeReason);
        return;
    L13:
        return;
    L5:
        if (this.mLightState != 0) goto L6;
    }

    void setDeepEnabledForTest(boolean enabled) {
        monitor-enter(this);
        this.mDeepEnabled = enabled;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    void setLightEnabledForTest(boolean enabled) {
        monitor-enter(this);
        this.mLightEnabled = enabled;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void verifyAlarmStateLocked() {
        if (this.mState != 0) goto L8;
        if (this.mNextAlarmTime == 0) goto L8;
        Slog.wtf(TAG, "mState=ACTIVE but mNextAlarmTime=" + this.mNextAlarmTime);
    L8:
        if (this.mState == 5) goto L13;
        if (this.mLocalAlarmManager.isIdling() == false) goto L13;
        Slog.wtf(TAG, "mState=" + stateToString(this.mState) + " but AlarmManager is idling");
    L13:
        if (this.mState != 5) goto L18;
        if (this.mLocalAlarmManager.isIdling() == true) goto L18;
        Slog.wtf(TAG, "mState=IDLE but AlarmManager is not idling");
    L18:
        if (this.mLightState == 0) goto L20;
        return;
    L20:
        if (this.mNextLightAlarmTime == 0) goto L24;
        Slog.wtf(TAG, "mLightState=ACTIVE but mNextLightAlarmTime is " + TimeUtils.formatDuration(this.mNextLightAlarmTime - SystemClock.elapsedRealtime()) + " from now");
        return;
    }

    void becomeInactiveIfAppropriateLocked() {
        verifyAlarmStateLocked();
        if (this.mScreenOn == true) goto L5;
    L9:
        boolean isScreenBlockingInactive = false;
    L10:
        boolean isEmergencyCallActive = this.mEmergencyCallListener.isEmergencyCallActive();
        if (this.mForceIdle == true) goto L18;
        if (this.mCharging == true) goto L16;
        if (isScreenBlockingInactive == true) goto L45;
        if (isEmergencyCallActive == false) goto L18;
        return;
    L45:
        return;
    L16:
        return;
    L18:
        if (this.mDeepEnabled == false) goto L40;
        if (this.mQuickDozeActivated == false) goto L34;
        if (this.mState != 7) goto L24;
        return;
    L24:
        if (this.mState != 5) goto L26;
        return;
    L26:
        if (this.mState == 6) goto L48;
        moveToStateLocked(7, "no activity");
        resetIdleManagementLocked();
        if (isUpcomingAlarmClock() == false) goto L31;
        scheduleAlarmLocked((this.mAlarmManager.getNextWakeFromIdleTime() - this.mInjector.getElapsedRealtime()) + this.mConstants.QUICK_DOZE_DELAY_TIMEOUT);
        goto L40
    L31:
        scheduleAlarmLocked(this.mConstants.QUICK_DOZE_DELAY_TIMEOUT);
        goto L40
    L48:
        return;
    L34:
        if (this.mState != 0) goto L40;
        moveToStateLocked(1, "no activity");
        resetIdleManagementLocked();
        long delay = this.mInactiveTimeout;
        if (isUpcomingAlarmClock() == false) goto L38;
        scheduleAlarmLocked((this.mAlarmManager.getNextWakeFromIdleTime() - this.mInjector.getElapsedRealtime()) + delay);
        goto L40
    L38:
        scheduleAlarmLocked(delay);
    L40:
        if (this.mLightState == 0) goto L42;
        return;
    L42:
        if (this.mLightEnabled == false) goto L50;
        moveToLightStateLocked(1, "no activity");
        resetLightIdleManagementLocked();
        scheduleLightAlarmLocked(this.mConstants.LIGHT_IDLE_AFTER_INACTIVE_TIMEOUT, this.mConstants.FLEX_TIME_SHORT, true);
        return;
    L50:
        return;
    L5:
        if (this.mConstants.WAIT_FOR_UNLOCK == true) goto L7;
    L8:
        isScreenBlockingInactive = true;
        goto L10
    L7:
        if (this.mScreenLocked == true) goto L9;
        goto L8
    }

    private void resetIdleManagementLocked() {
        this.mNextIdlePendingDelay = 0;
        this.mNextIdleDelay = 0;
        this.mQuickDozeActivatedWhileIdling = false;
        cancelAlarmLocked();
        cancelSensingTimeoutAlarmLocked();
        cancelLocatingLocked();
        maybeStopMonitoringMotionLocked();
        this.mAnyMotionDetector.stop();
        updateActiveConstraintsLocked();
    }

    private void resetLightIdleManagementLocked() {
        this.mNextLightIdleDelay = this.mConstants.LIGHT_IDLE_TIMEOUT;
        this.mMaintenanceStartTime = 0;
        this.mNextLightIdleDelayFlex = this.mConstants.LIGHT_IDLE_TIMEOUT_INITIAL_FLEX;
        this.mCurLightIdleBudget = this.mConstants.LIGHT_IDLE_MAINTENANCE_MIN_BUDGET;
        cancelLightAlarmLocked();
    }

    void exitForceIdleLocked() {
        if (this.mForceIdle == false) goto L10;
        this.mForceIdle = false;
        if (this.mScreenOn == false) goto L7;
    L8:
        this.mActiveReason = 6;
        becomeActiveLocked("exit-force", Process.myUid());
        return;
    L7:
        if (this.mCharging == true) goto L8;
        return;
    }

    void setLightStateForTest(int lightState) {
        monitor-enter(this);
        this.mLightState = lightState;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    int getLightState() {
        monitor-enter(this);
        int r0 = this.mLightState;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    void stepLightIdleStateLocked(String reason) {
        if (this.mLightState != 0) goto L5;
        return;
    L5:
        if (this.mLightState == 7) goto L47;
        EventLogTags.writeDeviceIdleLightStep();
        if (this.mEmergencyCallListener.isEmergencyCallActive() == false) goto L14;
        Slog.wtf(TAG, "stepLightIdleStateLocked called when emergency call is active");
        if (this.mLightState == 0) goto L43;
        this.mActiveReason = 8;
        becomeActiveLocked("emergency", Process.myUid());
        return;
    L43:
        return;
    L14:
        switch(this.mLightState) {
            case 1: goto L29;
            case 2: goto L46;
            case 3: goto L46;
            case 4: goto L17;
            case 5: goto L17;
            case 6: goto L31;
            default: goto L46;
        };
    L29:
        this.mCurLightIdleBudget = this.mConstants.LIGHT_IDLE_MAINTENANCE_MIN_BUDGET;
        this.mNextLightIdleDelay = this.mConstants.LIGHT_IDLE_TIMEOUT;
        this.mNextLightIdleDelayFlex = this.mConstants.LIGHT_IDLE_TIMEOUT_INITIAL_FLEX;
        this.mMaintenanceStartTime = 0;
        goto L31
    L46:
        return;
    L17:
        if (this.mNetworkConnected == false) goto L19;
    L22:
        this.mActiveIdleOpCount = 1;
        this.mActiveIdleWakeLock.acquire();
        this.mMaintenanceStartTime = SystemClock.elapsedRealtime();
        if (this.mCurLightIdleBudget >= this.mConstants.LIGHT_IDLE_MAINTENANCE_MIN_BUDGET) goto L26;
        this.mCurLightIdleBudget = this.mConstants.LIGHT_IDLE_MAINTENANCE_MIN_BUDGET;
    L28:
        scheduleLightAlarmLocked(this.mCurLightIdleBudget, this.mConstants.FLEX_TIME_SHORT, true);
        moveToLightStateLocked(6, reason);
        addEvent(3, null);
        SysOptBridge.getFactory().getBytedancePowerAdvisorInstance().noteIdleMaintenance(1, this.mCurLightIdleBudget, true);
        this.mHandler.sendEmptyMessage(4);
        return;
    L26:
        if (this.mCurLightIdleBudget <= this.mConstants.LIGHT_IDLE_MAINTENANCE_MAX_BUDGET) goto L28;
        this.mCurLightIdleBudget = this.mConstants.LIGHT_IDLE_MAINTENANCE_MAX_BUDGET;
        goto L28
    L19:
        if (this.mLightState == 5) goto L22;
        scheduleLightAlarmLocked(this.mNextLightIdleDelay, this.mNextLightIdleDelayFlex / 2, true);
        moveToLightStateLocked(5, reason);
        return;
    L31:
        if (this.mMaintenanceStartTime == 0) goto L36;
        long duration = SystemClock.elapsedRealtime() - this.mMaintenanceStartTime;
        if (duration >= this.mConstants.LIGHT_IDLE_MAINTENANCE_MIN_BUDGET) goto L35;
        this.mCurLightIdleBudget += this.mConstants.LIGHT_IDLE_MAINTENANCE_MIN_BUDGET - duration;
        goto L36
    L35:
        this.mCurLightIdleBudget -= duration - this.mConstants.LIGHT_IDLE_MAINTENANCE_MIN_BUDGET;
    L36:
        this.mMaintenanceStartTime = 0;
        scheduleLightAlarmLocked(this.mNextLightIdleDelay, this.mNextLightIdleDelayFlex, true);
        if (this.mConstants.LIGHT_IDLE_INCREASE_LINEARLY == true) goto L39;
        this.mNextLightIdleDelay = Math.min(this.mConstants.LIGHT_MAX_IDLE_TIMEOUT, (long) (this.mNextLightIdleDelay * this.mConstants.LIGHT_IDLE_FACTOR));
        this.mNextLightIdleDelayFlex = Math.min(this.mConstants.LIGHT_IDLE_TIMEOUT_MAX_FLEX, (long) (this.mNextLightIdleDelayFlex * this.mConstants.LIGHT_IDLE_FACTOR));
    L40:
        moveToLightStateLocked(4, reason);
        addEvent(2, null);
        this.mGoingIdleWakeLock.acquire();
        this.mHandler.sendEmptyMessage(3);
        return;
    L39:
        this.mNextLightIdleDelay = Math.min(this.mConstants.LIGHT_MAX_IDLE_TIMEOUT, this.mNextLightIdleDelay + this.mConstants.LIGHT_IDLE_LINEAR_INCREASE_FACTOR_MS);
        this.mNextLightIdleDelayFlex = Math.min(this.mConstants.LIGHT_IDLE_TIMEOUT_MAX_FLEX, this.mNextLightIdleDelayFlex + this.mConstants.LIGHT_IDLE_FLEX_LINEAR_INCREASE_FACTOR_MS);
        goto L40
    }

    int getState() {
        monitor-enter(this);
        int r0 = this.mState;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private boolean isUpcomingAlarmClock() {
        if ((this.mInjector.getElapsedRealtime() + this.mConstants.MIN_TIME_TO_ALARM) < this.mAlarmManager.getNextWakeFromIdleTime()) goto L5;
        return true;
    L5:
        return false;
    }

    void stepIdleStateLocked(String reason) {
        EventLogTags.writeDeviceIdleStep();
        if (this.mEmergencyCallListener.isEmergencyCallActive() == false) goto L9;
        Slog.wtf(TAG, "stepIdleStateLocked called when emergency call is active");
        if (this.mState == 0) goto L65;
        this.mActiveReason = 8;
        becomeActiveLocked("emergency", Process.myUid());
        return;
    L65:
        return;
    L9:
        if (isUpcomingAlarmClock() == false) goto L15;
        if (this.mState == 0) goto L66;
        this.mActiveReason = 7;
        becomeActiveLocked(HostingRecord.TRIGGER_TYPE_ALARM, Process.myUid());
        becomeInactiveIfAppropriateLocked();
        return;
    L66:
        return;
    L15:
        if (this.mNumBlockingConstraints == 0) goto L20;
        if (this.mForceIdle == true) goto L20;
        return;
    L20:
        switch(this.mState) {
            case 1: goto L63;
            case 2: goto L26;
            case 3: goto L35;
            case 4: goto L54;
            case 5: goto L22;
            case 6: goto L56;
            case 7: goto L55;
            default: goto L71;
        };
    L22:
        this.mActiveIdleOpCount = 1;
        this.mActiveIdleWakeLock.acquire();
        moveToStateLocked(6, reason);
        scheduleAlarmLocked(this.mNextIdlePendingDelay);
        this.mMaintenanceStartTime = SystemClock.elapsedRealtime();
        this.mNextIdlePendingDelay = Math.min(this.mConstants.MAX_IDLE_PENDING_TIMEOUT, (long) (this.mNextIdlePendingDelay * this.mConstants.IDLE_PENDING_FACTOR));
        if (this.mNextIdlePendingDelay >= this.mConstants.IDLE_PENDING_TIMEOUT) goto L25;
        this.mNextIdlePendingDelay = this.mConstants.IDLE_PENDING_TIMEOUT;
    L25:
        addEvent(5, null);
        SysOptBridge.getFactory().getBytedancePowerAdvisorInstance().noteIdleMaintenance(2, this.mNextIdlePendingDelay, true);
        this.mHandler.sendEmptyMessage(4);
        return;
    L26:
        cancelLocatingLocked();
        this.mLocated = false;
        this.mLastGenericLocation = null;
        this.mLastGpsLocation = null;
        moveToStateLocked(3, reason);
        if (this.mUseMotionSensor == false) goto L32;
        if (this.mAnyMotionDetector.hasSensor() == false) goto L32;
        scheduleSensingTimeoutAlarmLocked(this.mConstants.SENSING_TIMEOUT);
        this.mNotMoving = false;
        this.mAnyMotionDetector.checkForAnyMotion();
        return;
    L32:
        if (this.mNumBlockingConstraints == 0) goto L34;
        cancelAlarmLocked();
        return;
    L34:
        this.mNotMoving = true;
    L35:
        cancelSensingTimeoutAlarmLocked();
        moveToStateLocked(4, reason);
        if (this.mIsLocationPrefetchEnabled == false) goto L53;
        scheduleAlarmLocked(this.mConstants.LOCATING_TIMEOUT);
        LocationManager locationManager = this.mInjector.getLocationManager();
        if (locationManager != null) goto L40;
    L42:
        this.mHasFusedLocation = false;
    L44:
        if (locationManager != null) goto L46;
    L48:
        this.mHasGps = false;
    L50:
        if (this.mLocating == false) goto L54;
        return;
    L46:
        if (locationManager.getProvider("gps") == null) goto L48;
        this.mHasGps = true;
        locationManager.requestLocationUpdates("gps", 1000, 5.0f, this.mGpsLocationListener, this.mHandler.getLooper());
        this.mLocating = true;
        goto L50
    L40:
        if (locationManager.getProvider("fused") == null) goto L42;
        this.mHasFusedLocation = true;
        locationManager.requestLocationUpdates("fused", this.mLocationRequest, AppSchedulingModuleThread.getExecutor(), this.mGenericLocationListener);
        this.mLocating = true;
        goto L44
    L53:
        this.mLocating = false;
    L54:
        cancelAlarmLocked();
        cancelLocatingLocked();
        this.mAnyMotionDetector.stop();
    L55:
        this.mNextIdlePendingDelay = this.mConstants.IDLE_PENDING_TIMEOUT;
        this.mNextIdleDelay = this.mConstants.IDLE_TIMEOUT;
    L56:
        moveToStateLocked(5, reason);
        scheduleAlarmLocked(this.mNextIdleDelay);
        this.mNextIdleDelay = (long) (this.mNextIdleDelay * this.mConstants.IDLE_FACTOR);
        this.mNextIdleDelay = Math.min(this.mNextIdleDelay, this.mConstants.MAX_IDLE_TIMEOUT);
        if (this.mNextIdleDelay >= this.mConstants.IDLE_TIMEOUT) goto L60;
        this.mNextIdleDelay = this.mConstants.IDLE_TIMEOUT;
    L60:
        if (this.mLightState == 7) goto L62;
        moveToLightStateLocked(7, "deep");
        cancelLightAlarmLocked();
    L62:
        addEvent(4, null);
        this.mGoingIdleWakeLock.acquire();
        this.mHandler.sendEmptyMessage(2);
        return;
    L63:
        startMonitoringMotionLocked();
        long delay = this.mConstants.IDLE_AFTER_INACTIVE_TIMEOUT;
        scheduleAlarmLocked(delay);
        moveToStateLocked(2, reason);
        return;
    }

    private static /* synthetic */ boolean lambda$stepIdleStateLocked$16(DeviceIdleConstraintTracker x) {
        return x.active;
    }

    private static /* synthetic */ String lambda$stepIdleStateLocked$17(DeviceIdleConstraintTracker x) {
        return x.name;
    }

    private void moveToLightStateLocked(int state, String reason) {
        this.mLightState = state;
        EventLogTags.writeDeviceIdleLight(this.mLightState, reason);
        Trace.traceCounter(524288, "DozeLightState", state);
    }

    private void moveToStateLocked(int state, String reason) {
        this.mState = state;
        EventLogTags.writeDeviceIdle(this.mState, reason);
        Trace.traceCounter(524288, "DozeDeepState", state);
        updateActiveConstraintsLocked();
    }

    void incActiveIdleOps() {
        monitor-enter(this);
        this.mActiveIdleOpCount++;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    void decActiveIdleOps() {
        monitor-enter(this);
        this.mActiveIdleOpCount--;     // Catch: Throwable -> L6
        if (this.mActiveIdleOpCount > 0) goto L8;
        exitMaintenanceEarlyIfNeededLocked();     // Catch: Throwable -> L6
        this.mActiveIdleWakeLock.release();     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    void setActiveIdleOpsForTest(int count) {
        monitor-enter(this);
        this.mActiveIdleOpCount = count;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    void setJobsActive(boolean active) {
        monitor-enter(this);
        this.mJobsActive = active;     // Catch: Throwable -> L6
        if (active == true) goto L8;
        exitMaintenanceEarlyIfNeededLocked();     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    void setAlarmsActive(boolean active) {
        monitor-enter(this);
        this.mAlarmsActive = active;     // Catch: Throwable -> L6
        if (active == true) goto L8;
        exitMaintenanceEarlyIfNeededLocked();     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    long getNextAlarmTime() {
        monitor-enter(this);
        long r0 = this.mNextAlarmTime;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    boolean isEmergencyCallActive() {
        return this.mEmergencyCallListener.isEmergencyCallActive();
    }

    boolean isOpsInactiveLocked() {
        if (this.mActiveIdleOpCount <= 0) goto L5;
    L9:
        return false;
    L5:
        if (this.mJobsActive == true) goto L9;
        if (this.mAlarmsActive == true) goto L9;
        return true;
    }

    void exitMaintenanceEarlyIfNeededLocked() {
        if (this.mState == 6) goto L7;
        if (this.mLightState == 6) goto L7;
        return;
    L7:
        if (isOpsInactiveLocked() == false) goto L14;
        SystemClock.elapsedRealtime();
        if (this.mState != 6) goto L11;
        stepIdleStateLocked("s:early");
        return;
    L11:
        stepLightIdleStateLocked("s:early");
        return;
    }

    void motionLocked() {
        this.mLastMotionEventElapsed = this.mInjector.getElapsedRealtime();
        handleMotionDetectedLocked(this.mConstants.MOTION_INACTIVE_TIMEOUT, "motion");
    }

    void handleMotionDetectedLocked(long timeout, String type) {
        if (this.mStationaryListeners.size() <= 0) goto L6;
        postStationaryStatusUpdated();
        cancelMotionTimeoutAlarmLocked();
        scheduleMotionRegistrationAlarmLocked();
    L6:
        if (this.mQuickDozeActivated == true) goto L8;
    L10:
        maybeStopMonitoringMotionLocked();
        if (this.mState == 0) goto L13;
    L16:
        boolean becomeInactive = true;
    L17:
        int r6 = Process.myUid();
        if (this.mLightState != 7) goto L20;
        boolean r9 = true;
    L21:
        becomeActiveLocked(type, r6, timeout, r9);
        if (becomeInactive == false) goto L25;
        becomeInactiveIfAppropriateLocked();
        return;
    L25:
        return;
    L20:
        r9 = false;
        goto L21
    L13:
        if (this.mLightState == 7) goto L16;
        becomeInactive = false;
        goto L17
    L8:
        if (this.mQuickDozeActivatedWhileIdling == true) goto L10;
    }

    void receivedGenericLocationLocked(Location location) {
        if (this.mState == 4) goto L6;
        cancelLocatingLocked();
        return;
    L6:
        this.mLastGenericLocation = new Location(location);
        if (location.getAccuracy() > this.mConstants.LOCATION_ACCURACY) goto L9;
    L11:
        this.mLocated = true;
        if (this.mNotMoving == false) goto L15;
        stepIdleStateLocked("s:location");
        return;
    L15:
        return;
    L9:
        if (this.mHasGps == false) goto L11;
    }

    void receivedGpsLocationLocked(Location location) {
        if (this.mState == 4) goto L6;
        cancelLocatingLocked();
        return;
    L6:
        this.mLastGpsLocation = new Location(location);
        if (location.getAccuracy() <= this.mConstants.LOCATION_ACCURACY) goto L9;
        return;
    L9:
        this.mLocated = true;
        if (this.mNotMoving == false) goto L13;
        stepIdleStateLocked("s:gps");
        return;
    }

    void startMonitoringMotionLocked() {
        if (this.mMotionSensor != null) goto L5;
        return;
    L5:
        if (this.mMotionListener.active == true) goto L9;
        this.mMotionListener.registerLocked();
        return;
    }

    private void maybeStopMonitoringMotionLocked() {
        if (this.mMotionSensor != null) goto L5;
        return;
    L5:
        if (this.mStationaryListeners.size() == 0) goto L7;
        return;
    L7:
        if (this.mMotionListener.active == false) goto L9;
        this.mMotionListener.unregisterLocked();
        cancelMotionTimeoutAlarmLocked();
    L9:
        cancelMotionRegistrationAlarmLocked();
    }

    void cancelAlarmLocked() {
        if (this.mNextAlarmTime == 0) goto L6;
        this.mNextAlarmTime = 0;
        this.mAlarmManager.cancel(this.mDeepAlarmListener);
        return;
    }

    private void cancelLightAlarmLocked() {
        if (this.mNextLightAlarmTime == 0) goto L6;
        this.mNextLightAlarmTime = 0;
        this.mAlarmManager.cancel(this.mLightAlarmListener);
        return;
    }

    void cancelLocatingLocked() {
        if (this.mLocating == false) goto L6;
        LocationManager locationManager = this.mInjector.getLocationManager();
        locationManager.removeUpdates(this.mGenericLocationListener);
        locationManager.removeUpdates(this.mGpsLocationListener);
        this.mLocating = false;
        return;
    }

    private void cancelMotionTimeoutAlarmLocked() {
        this.mAlarmManager.cancel(this.mMotionTimeoutAlarmListener);
    }

    private void cancelMotionRegistrationAlarmLocked() {
        this.mAlarmManager.cancel(this.mMotionRegistrationAlarmListener);
    }

    void cancelSensingTimeoutAlarmLocked() {
        if (this.mNextSensingTimeoutAlarmTime == 0) goto L6;
        this.mNextSensingTimeoutAlarmTime = 0;
        this.mAlarmManager.cancel(this.mSensingTimeoutAlarmListener);
        return;
    }

    void scheduleAlarmLocked(long delay) {
        if (this.mUseMotionSensor == true) goto L5;
    L13:
        this.mNextAlarmTime = SystemClock.elapsedRealtime() + delay;
        if (this.mState != 5) goto L17;
        this.mAlarmManager.setIdleUntil(2, this.mNextAlarmTime, "DeviceIdleController.deep", this.mDeepAlarmListener, this.mHandler);
        return;
    L17:
        if (this.mState != 4) goto L20;
        this.mAlarmManager.setExact(2, this.mNextAlarmTime, "DeviceIdleController.deep", this.mDeepAlarmListener, this.mHandler);
        return;
    L20:
        if (this.mConstants.USE_WINDOW_ALARMS == false) goto L22;
        this.mAlarmManager.setWindow(2, this.mNextAlarmTime, this.mConstants.FLEX_TIME_SHORT, "DeviceIdleController.deep", this.mDeepAlarmListener, this.mHandler);
        return;
    L22:
        this.mAlarmManager.set(2, this.mNextAlarmTime, "DeviceIdleController.deep", this.mDeepAlarmListener, this.mHandler);
        return;
    L5:
        if (this.mMotionSensor != null) goto L13;
        if (this.mState == 7) goto L13;
        if (this.mState == 5) goto L13;
        if (this.mState == 6) goto L13;
    }

    void scheduleLightAlarmLocked(long delay, long flex, boolean wakeup) {
        this.mNextLightAlarmTime = this.mInjector.getElapsedRealtime() + delay;
        int r1 = 3;
        if (this.mConstants.USE_WINDOW_ALARMS == false) goto L9;
        AlarmManager r3 = this.mAlarmManager;
        if (wakeup == false) goto L7;
        int r4 = 2;
    L8:
        r3.setWindow(r4, this.mNextLightAlarmTime, flex, "DeviceIdleController.light", this.mLightAlarmListener, this.mHandler);
        return;
    L7:
        r4 = 3;
        goto L8
    L9:
        AlarmManager r0 = this.mAlarmManager;
        if (wakeup == false) goto L12;
        r1 = 2;
    L12:
        r0.set(r1, this.mNextLightAlarmTime, "DeviceIdleController.light", this.mLightAlarmListener, this.mHandler);
    }

    long getNextLightAlarmTimeForTesting() {
        monitor-enter(this);
        long r0 = this.mNextLightAlarmTime;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private void scheduleMotionRegistrationAlarmLocked() {
        long nextMotionRegistrationAlarmTime = this.mInjector.getElapsedRealtime() + (this.mConstants.MOTION_INACTIVE_TIMEOUT / 2);
        if (this.mConstants.USE_WINDOW_ALARMS == false) goto L5;
        this.mAlarmManager.setWindow(2, nextMotionRegistrationAlarmTime, this.mConstants.MOTION_INACTIVE_TIMEOUT_FLEX, "DeviceIdleController.motion_registration", this.mMotionRegistrationAlarmListener, this.mHandler);
        return;
    L5:
        this.mAlarmManager.set(2, nextMotionRegistrationAlarmTime, "DeviceIdleController.motion_registration", this.mMotionRegistrationAlarmListener, this.mHandler);
    }

    private void scheduleMotionTimeoutAlarmLocked() {
        long nextMotionTimeoutAlarmTime = this.mInjector.getElapsedRealtime() + this.mConstants.MOTION_INACTIVE_TIMEOUT;
        if (this.mConstants.USE_WINDOW_ALARMS == false) goto L5;
        this.mAlarmManager.setWindow(2, nextMotionTimeoutAlarmTime, this.mConstants.MOTION_INACTIVE_TIMEOUT_FLEX, "DeviceIdleController.motion", this.mMotionTimeoutAlarmListener, this.mHandler);
        return;
    L5:
        this.mAlarmManager.set(2, nextMotionTimeoutAlarmTime, "DeviceIdleController.motion", this.mMotionTimeoutAlarmListener, this.mHandler);
    }

    void scheduleSensingTimeoutAlarmLocked(long delay) {
        this.mNextSensingTimeoutAlarmTime = SystemClock.elapsedRealtime() + delay;
        if (this.mConstants.USE_WINDOW_ALARMS == false) goto L5;
        this.mAlarmManager.setWindow(2, this.mNextSensingTimeoutAlarmTime, this.mConstants.FLEX_TIME_SHORT, "DeviceIdleController.sensing", this.mSensingTimeoutAlarmListener, this.mHandler);
        return;
    L5:
        this.mAlarmManager.set(2, this.mNextSensingTimeoutAlarmTime, "DeviceIdleController.sensing", this.mSensingTimeoutAlarmListener, this.mHandler);
    }

    private static int[] buildAppIdArray(ArrayMap<String, Integer> systemApps, ArrayMap<String, Integer> userApps, SparseBooleanArray outAppIds) {
        outAppIds.clear();
        if (systemApps == null) goto L8;
        int i = 0;
    L6:
        if (i >= systemApps.size()) goto L8;
        outAppIds.put(systemApps.valueAt(i).intValue(), true);
        i = i + 1;
    L8:
        if (userApps == null) goto L13;
        int i2 = 0;
    L11:
        if (i2 >= userApps.size()) goto L13;
        outAppIds.put(userApps.valueAt(i2).intValue(), true);
        i2 = i2 + 1;
    L13:
        int size = outAppIds.size();
        int[] appids = new int[size];
        int i3 = 0;
    L14:
        if (i3 >= size) goto L17;
        appids[i3] = outAppIds.keyAt(i3);
        i3 = i3 + 1;
        goto L14
    L17:
        return appids;
    }

    private void updateWhitelistAppIdsLocked() {
        this.mPowerSaveWhitelistExceptIdleAppIdArray = buildAppIdArray(this.mPowerSaveWhitelistAppsExceptIdle, this.mPowerSaveWhitelistUserApps, this.mPowerSaveWhitelistExceptIdleAppIds);
        this.mPowerSaveWhitelistAllAppIdArray = buildAppIdArray(this.mPowerSaveWhitelistApps, this.mPowerSaveWhitelistUserApps, this.mPowerSaveWhitelistAllAppIds);
        this.mPowerSaveWhitelistUserAppIdArray = buildAppIdArray(null, this.mPowerSaveWhitelistUserApps, this.mPowerSaveWhitelistUserAppIds);
        if (this.mLocalActivityManager == null) goto L6;
        this.mLocalActivityManager.setDeviceIdleAllowlist(this.mPowerSaveWhitelistAllAppIdArray, this.mPowerSaveWhitelistExceptIdleAppIdArray);
    L6:
        if (this.mLocalPowerManager == null) goto L8;
        this.mLocalPowerManager.setDeviceIdleWhitelist(this.mPowerSaveWhitelistAllAppIdArray);
    L8:
        passWhiteListsToForceAppStandbyTrackerLocked();
    }

    private void updateTempWhitelistAppIdsLocked(int uid, boolean adding, long durationMs, int type, int reasonCode, String reason, int callingUid) {
        int size = this.mTempWhitelistAppIdEndTimes.size();
        if (this.mTempWhitelistAppIdArray.length == size) goto L5;
        this.mTempWhitelistAppIdArray = new int[size];
    L5:
        int i = 0;
    L6:
        if (i >= size) goto L9;
        this.mTempWhitelistAppIdArray[i] = this.mTempWhitelistAppIdEndTimes.keyAt(i);
        i = i + 1;
        goto L6
    L9:
        if (this.mLocalActivityManager == null) goto L12;
        this.mLocalActivityManager.updateDeviceIdleTempAllowlist(this.mTempWhitelistAppIdArray, uid, adding, durationMs, type, reasonCode, reason, callingUid);
    L12:
        if (this.mLocalPowerManager == null) goto L14;
        this.mLocalPowerManager.setDeviceIdleTempWhitelist(this.mTempWhitelistAppIdArray);
    L14:
        passWhiteListsToForceAppStandbyTrackerLocked();
    }

    private void reportPowerSaveWhitelistChangedLocked() {
        getContext().sendBroadcastAsUser(this.mPowerSaveWhitelistChangedIntent, UserHandle.SYSTEM, null, this.mPowerSaveWhitelistChangedOptions);
    }

    private void reportTempWhitelistChangedLocked(int r6, boolean r7) {
        this.mHandler.obtainMessage(13, r6, r7 ? 1 : 0).sendToTarget();
        getContext().sendBroadcastAsUser(this.mPowerSaveTempWhitelistChangedIntent, UserHandle.SYSTEM, null, this.mPowerSaveTempWhilelistChangedOptions);
    }

    private void passWhiteListsToForceAppStandbyTrackerLocked() {
        this.mAppStateTracker.setPowerSaveExemptionListAppIds(this.mPowerSaveWhitelistExceptIdleAppIdArray, this.mPowerSaveWhitelistUserAppIdArray, this.mTempWhitelistAppIdArray);
    }

    void readConfigFileLocked() {
        this.mPowerSaveWhitelistUserApps.clear();
        FileInputStream stream = this.mConfigFile.openRead();     // Catch: FileNotFoundException -> L20
        XmlPullParser parser = Xml.newPullParser();     // Catch: Throwable -> L9 XmlPullParserException -> L11
        parser.setInput(stream, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L9 XmlPullParserException -> L11
        readConfigFileLocked(parser);     // Catch: Throwable -> L9 XmlPullParserException -> L11
        stream.close();     // Catch: IOException -> L7
    L26:
        return;
    L9:
        th = move-exception;
        stream.close();     // Catch: IOException -> L15
    L16:
        throw th;
    L17:
        stream.close();     // Catch: IOException -> L7
    L21:
        return;
    }

    private void readConfigFileLocked(XmlPullParser parser) {
        PackageManager pm = getContext().getPackageManager();
    L69:
        int type = parser.next();     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
        if (type == 2) goto L7;
        if (type != 1) goto L69;
    L7:
        if (type != 2) goto L59;
        int outerDepth = parser.getDepth();     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
    L9:
        int type2 = parser.next();     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
        if (type2 == 1) goto L96;
        if (type2 == 3) goto L14;
    L29:
        if (type2 == 3) goto L9;
        if (type2 == 4) goto L9;
        String tagName = parser.getName();     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
        switch(tagName.hashCode()) {
            case 3797: goto L40;
            case 111376009: goto L37;
            default: goto L42;
        };     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
    L42:
        byte r7 = -1;
    L44:
        switch(r7) {
            case 0: goto L49;
            case 1: goto L46;
            default: goto L45;
        };
    L46:
        String packageName = parser.getAttributeValue(null, "n");     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
        if (this.mPowerSaveWhitelistApps.containsKey(packageName) == false) goto L9;
        this.mRemovedFromSystemWhitelistApps.put(packageName, this.mPowerSaveWhitelistApps.remove(packageName));     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
        goto L9
    L49:
        String name = parser.getAttributeValue(null, "n");     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
        if (name == null) goto L9;
        ApplicationInfo ai = pm.getApplicationInfo(name, 4194304);     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26 PackageManager.NameNotFoundException -> L54
        this.mPowerSaveWhitelistUserApps.put(ai.packageName, Integer.valueOf(UserHandle.getAppId(ai.uid)));     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26 PackageManager.NameNotFoundException -> L54
        goto L9
    L45:
        Slog.w(TAG, "Unknown element under <config>: " + parser.getName());     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
        XmlUtils.skipCurrentTag(parser);     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
        goto L9
    L37:
        if (tagName.equals("un-wl") == false) goto L42;
        r7 = 1;
        goto L44
    L40:
        if (tagName.equals("wl") == false) goto L42;
        r7 = 0;
        goto L44
    L14:
        if (parser.getDepth() > outerDepth) goto L29;
        return;
    L96:
        return;
    L59:
        throw new IllegalStateException("no start tag found");     // Catch: IndexOutOfBoundsException -> L16 IOException -> L18 XmlPullParserException -> L20 NumberFormatException -> L22 NullPointerException -> L24 IllegalStateException -> L26
    L18:
        e = move-exception;
        Slog.w(TAG, "Failed parsing config " + e);
        return;
    L26:
        e = move-exception;
        Slog.w(TAG, "Failed parsing config " + e);
        return;
    L16:
        e = move-exception;
        Slog.w(TAG, "Failed parsing config " + e);
        return;
    L24:
        e = move-exception;
        Slog.w(TAG, "Failed parsing config " + e);
        return;
    L22:
        e = move-exception;
        Slog.w(TAG, "Failed parsing config " + e);
        return;
    L20:
        e = move-exception;
        Slog.w(TAG, "Failed parsing config " + e);
    }

    void writeConfigFileLocked() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, 5000);
    }

    void handleWriteConfigFile() {
        ByteArrayOutputStream memStream = new ByteArrayOutputStream();
        monitor-enter(this);     // Catch: IOException -> L10
        XmlSerializer out = new FastXmlSerializer();     // Catch: Throwable -> L7
        out.setOutput(memStream, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L7
        writeConfigFileLocked(out);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;     // Catch: IOException -> L10
    L11:
        AtomicFile r1 = this.mConfigFile;
        monitor-enter(r1);
        FileOutputStream stream = null;
        stream = this.mConfigFile.startWrite();     // Catch: Throwable -> L16 IOException -> L18
        memStream.writeTo(stream);     // Catch: Throwable -> L16 IOException -> L18
        this.mConfigFile.finishWrite(stream);     // Catch: Throwable -> L16 IOException -> L18
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        Slog.w(TAG, "Error writing config file", e);     // Catch: Throwable -> L16
        this.mConfigFile.failWrite(stream);     // Catch: Throwable -> L16
        goto L20
    }

    void writeConfigFileLocked(XmlSerializer out) throws IOException {
        out.startDocument(null, true);
        out.startTag(null, "config");
        int i = 0;
    L4:
        if (i >= this.mPowerSaveWhitelistUserApps.size()) goto L6;
        String name = this.mPowerSaveWhitelistUserApps.keyAt(i);
        out.startTag(null, "wl");
        out.attribute(null, "n", name);
        out.endTag(null, "wl");
        i = i + 1;
        goto L4
    L6:
        int i2 = 0;
    L8:
        if (i2 >= this.mRemovedFromSystemWhitelistApps.size()) goto L10;
        out.startTag(null, "un-wl");
        out.attribute(null, "n", this.mRemovedFromSystemWhitelistApps.keyAt(i2));
        out.endTag(null, "un-wl");
        i2 = i2 + 1;
        goto L8
    L10:
        out.endTag(null, "config");
        out.endDocument();
    }

    static void dumpHelp(PrintWriter pw) {
        pw.println("Device idle controller (deviceidle) commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("  step [light|deep]");
        pw.println("    Immediately step to next state, without waiting for alarm.");
        pw.println("  force-idle [light|deep]");
        pw.println("    Force directly into idle mode, regardless of other device state.");
        pw.println("  force-inactive");
        pw.println("    Force to be inactive, ready to freely step idle states.");
        pw.println("  unforce");
        pw.println("    Resume normal functioning after force-idle or force-inactive or force-modemanager-quickdoze.");
        pw.println("  get [light|deep|force|screen|charging|network|offbody|forceoffbody]");
        pw.println("    Retrieve the current given state.");
        pw.println("  disable [light|deep|all]");
        pw.println("    Completely disable device idle mode.");
        pw.println("  enable [light|deep|all]");
        pw.println("    Re-enable device idle mode after it had previously been disabled.");
        pw.println("  enabled [light|deep|all]");
        pw.println("    Print 1 if device idle mode is currently enabled, else 0.");
        pw.println("  whitelist");
        pw.println("    Print currently whitelisted apps.");
        pw.println("  whitelist [package ...]");
        pw.println("    Add (prefix with +) or remove (prefix with -) packages.");
        pw.println("  sys-whitelist [package ...|reset]");
        pw.println("    Prefix the package with '-' to remove it from the system whitelist or '+' to put it back in the system whitelist.");
        pw.println("    Note that only packages that were earlier removed from the system whitelist can be added back.");
        pw.println("    reset will reset the whitelist to the original state");
        pw.println("    Prints the system whitelist if no arguments are specified");
        pw.println("  except-idle-whitelist [package ...|reset]");
        pw.println("    Prefix the package with '+' to add it to whitelist or '=' to check if it is already whitelisted");
        pw.println("    [reset] will reset the whitelist to it's original state");
        pw.println("    Note that unlike <whitelist> cmd, changes made using this won't be persisted across boots");
        pw.println("  tempwhitelist");
        pw.println("    Print packages that are temporarily whitelisted.");
        pw.println("  tempwhitelist [-u USER] [-d DURATION] [-r] [package]");
        pw.println("    Temporarily place package in whitelist for DURATION milliseconds.");
        pw.println("    If no DURATION is specified, 10 seconds is used");
        pw.println("    If [-r] option is used, then the package is removed from temp whitelist and any [-d] is ignored");
        pw.println("  motion");
        pw.println("    Simulate a motion event to bring the device out of deep doze");
        pw.println("  force-modemanager-quickdoze [true|false]");
        pw.println("    Simulate mode manager request to enable (true) or disable (false) quick doze. Mode manager changes will be ignored until unforce is called.");
        pw.println("  force-modemanager-offbody [true|false]");
        pw.println("    Force mode manager offbody state, this can be used to simulate device being off-body (true) or on-body (false). Mode manager changes will be ignored until unforce is called.");
    }

    int onShellCommand(Shell shell, String cmd) {
        PrintWriter pw = shell.getOutPrintWriter();
        Object r3 = 0;
        if ("step".equals(cmd) == false) goto L28;
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        monitor-enter(this);
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L22
        String arg = shell.getNextArg();     // Catch: Throwable -> L22
        if (arg == null) goto L18;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L10:
        if ("deep".equals(arg) == true) goto L18;
        if ("light".equals(arg) == false) goto L17;
        stepLightIdleStateLocked("s:shell");     // Catch: Throwable -> L15
        pw.print("Stepped to light: ");     // Catch: Throwable -> L15
        pw.println(lightStateToString(this.mLightState));     // Catch: Throwable -> L15
    L19:
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
    L566:
        return 0;
    L17:
        pw.println("Unknown idle mode: " + arg);     // Catch: Throwable -> L15
    L18:
        stepIdleStateLocked("s:shell");     // Catch: Throwable -> L15
        pw.print("Stepped to deep: ");     // Catch: Throwable -> L15
        pw.println(stateToString(this.mState));     // Catch: Throwable -> L15
    L22:
        th = move-exception;
        throw th;
    L28:
        byte r4 = 1;
        if ("force-active".equals(cmd) == false) goto L44;
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        monitor-enter(this);
        long token2 = Binder.clearCallingIdentity();     // Catch: Throwable -> L37
        this.mForceIdle = true;     // Catch: Throwable -> L39
        becomeActiveLocked("force-active", Process.myUid());     // Catch: Throwable -> L39
        pw.print("Light state: ");     // Catch: Throwable -> L39
        pw.print(lightStateToString(this.mLightState));     // Catch: Throwable -> L39
        pw.print(", deep state: ");     // Catch: Throwable -> L39
        pw.println(stateToString(this.mState));     // Catch: Throwable -> L39
        Binder.restoreCallingIdentity(token2);     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        goto L566
    L39:
        th = move-exception;
        Binder.restoreCallingIdentity(token2);     // Catch: Throwable -> L37
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    L44:
        byte r12 = -1;
        if ("force-idle".equals(cmd) == false) goto L95;
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        monitor-enter(this);
        long token3 = Binder.clearCallingIdentity();     // Catch: Throwable -> L64
        String arg2 = shell.getNextArg();     // Catch: Throwable -> L64
        if (arg2 == null) goto L72;
    L66:
        th = move-exception;
        Binder.restoreCallingIdentity(token3);     // Catch: Throwable -> L64
        throw th;     // Catch: Throwable -> L64
    L52:
        if ("deep".equals(arg2) == true) goto L72;
        if ("light".equals(arg2) == false) goto L70;
        this.mForceIdle = true;     // Catch: Throwable -> L66
        becomeInactiveIfAppropriateLocked();     // Catch: Throwable -> L66
        int curLightState = this.mLightState;     // Catch: Throwable -> L66
    L57:
        if (curLightState == 4) goto L69;
        stepLightIdleStateLocked("s:shell");     // Catch: Throwable -> L66
        if (curLightState == this.mLightState) goto L60;
        curLightState = this.mLightState;     // Catch: Throwable -> L66
        goto L57
    L60:
        pw.print("Unable to go light idle; stopped at ");     // Catch: Throwable -> L66
        pw.println(lightStateToString(this.mLightState));     // Catch: Throwable -> L66
        exitForceIdleLocked();     // Catch: Throwable -> L66
        Binder.restoreCallingIdentity(token3);     // Catch: Throwable -> L64
        monitor-exit(this);     // Catch: Throwable -> L64
        return -1;
    L69:
        pw.println("Now forced in to light idle mode");     // Catch: Throwable -> L66
    L87:
        Binder.restoreCallingIdentity(token3);     // Catch: Throwable -> L64
        monitor-exit(this);     // Catch: Throwable -> L64
        goto L566
    L70:
        pw.println("Unknown idle mode: " + arg2);     // Catch: Throwable -> L66
    L72:
        if (this.mDeepEnabled == true) goto L77;
        pw.println("Unable to go deep idle; not enabled");     // Catch: Throwable -> L66
        Binder.restoreCallingIdentity(token3);     // Catch: Throwable -> L64
        monitor-exit(this);     // Catch: Throwable -> L64
        return -1;
    L77:
        this.mForceIdle = true;     // Catch: Throwable -> L66
        becomeInactiveIfAppropriateLocked();     // Catch: Throwable -> L66
        int curState = this.mState;     // Catch: Throwable -> L66
    L78:
        if (curState == 5) goto L86;
        stepIdleStateLocked("s:shell");     // Catch: Throwable -> L66
        if (curState == this.mState) goto L81;
        curState = this.mState;     // Catch: Throwable -> L66
        goto L78
    L81:
        pw.print("Unable to go deep idle; stopped at ");     // Catch: Throwable -> L66
        pw.println(stateToString(this.mState));     // Catch: Throwable -> L66
        exitForceIdleLocked();     // Catch: Throwable -> L66
        Binder.restoreCallingIdentity(token3);     // Catch: Throwable -> L64
        monitor-exit(this);     // Catch: Throwable -> L64
        return -1;
    L86:
        pw.println("Now forced in to deep idle mode");     // Catch: Throwable -> L66
    L64:
        th = move-exception;
        throw th;
    L95:
        if ("force-inactive".equals(cmd) == false) goto L111;
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        monitor-enter(this);
        long token4 = Binder.clearCallingIdentity();     // Catch: Throwable -> L103
        this.mForceIdle = true;     // Catch: Throwable -> L105
        becomeInactiveIfAppropriateLocked();     // Catch: Throwable -> L105
        pw.print("Light state: ");     // Catch: Throwable -> L105
        pw.print(lightStateToString(this.mLightState));     // Catch: Throwable -> L105
        pw.print(", deep state: ");     // Catch: Throwable -> L105
        pw.println(stateToString(this.mState));     // Catch: Throwable -> L105
        Binder.restoreCallingIdentity(token4);     // Catch: Throwable -> L103
        monitor-exit(this);     // Catch: Throwable -> L103
        goto L566
    L105:
        th = move-exception;
        Binder.restoreCallingIdentity(token4);     // Catch: Throwable -> L103
        throw th;     // Catch: Throwable -> L103
    L103:
        th = move-exception;
        throw th;
    L111:
        if ("unforce".equals(cmd) == false) goto L127;
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        monitor-enter(this);
        long token5 = Binder.clearCallingIdentity();     // Catch: Throwable -> L119
        exitForceIdleLocked();     // Catch: Throwable -> L121
        pw.print("Light state: ");     // Catch: Throwable -> L121
        pw.print(lightStateToString(this.mLightState));     // Catch: Throwable -> L121
        pw.print(", deep state: ");     // Catch: Throwable -> L121
        pw.println(stateToString(this.mState));     // Catch: Throwable -> L121
        this.mForceModeManagerQuickDozeRequest = false;     // Catch: Throwable -> L121
        pw.println("mForceModeManagerQuickDozeRequest: " + this.mForceModeManagerQuickDozeRequest);     // Catch: Throwable -> L121
        this.mForceModeManagerOffBodyState = false;     // Catch: Throwable -> L121
        pw.println("mForceModeManagerOffBodyState: " + this.mForceModeManagerOffBodyState);     // Catch: Throwable -> L121
        Binder.restoreCallingIdentity(token5);     // Catch: Throwable -> L119
        monitor-exit(this);     // Catch: Throwable -> L119
        goto L566
    L121:
        th = move-exception;
        Binder.restoreCallingIdentity(token5);     // Catch: Throwable -> L119
        throw th;     // Catch: Throwable -> L119
    L119:
        th = move-exception;
        throw th;
    L127:
        if ("get".equals(cmd) == false) goto L196;
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        monitor-enter(this);
        String arg3 = shell.getNextArg();     // Catch: Throwable -> L186
        if (arg3 == null) goto L190;
        long token6 = Binder.clearCallingIdentity();     // Catch: Throwable -> L186
    L139:
        th = move-exception;
        Binder.restoreCallingIdentity(token6);     // Catch: Throwable -> L186
        throw th;     // Catch: Throwable -> L186
    L134:
        switch(arg3.hashCode()) {
            case -2127754130: goto L169;
            case -1614760061: goto L166;
            case -1548904559: goto L163;
            case -907689876: goto L160;
            case 3079404: goto L157;
            case 97618667: goto L154;
            case 102970646: goto L151;
            case 107947501: goto L148;
            case 1436115569: goto L145;
            case 1587609158: goto L142;
            case 1843485230: goto L137;
            default: goto L171;
        };     // Catch: Throwable -> L139
    L171:
        r4 = -1;
    L172:
        switch(r4) {
            case 0: goto L184;
            case 1: goto L183;
            case 2: goto L182;
            case 3: goto L181;
            case 4: goto L180;
            case 5: goto L179;
            case 6: goto L178;
            case 7: goto L177;
            case 8: goto L176;
            case 9: goto L175;
            case 10: goto L174;
            default: goto L173;
        };     // Catch: Throwable -> L139
    L173:
        pw.println("Unknown get option: " + arg3);     // Catch: Throwable -> L139
    L185:
        Binder.restoreCallingIdentity(token6);     // Catch: Throwable -> L186
    L191:
        monitor-exit(this);     // Catch: Throwable -> L186
        goto L566
    L174:
        pw.println(this.mForceModeManagerOffBodyState);     // Catch: Throwable -> L139
        goto L185
    L175:
        pw.println(this.mIsOffBody);     // Catch: Throwable -> L139
        goto L185
    L176:
        pw.println(this.mForceModeManagerQuickDozeRequest);     // Catch: Throwable -> L139
        goto L185
    L177:
        pw.println(this.mModeManagerRequestedQuickDoze);     // Catch: Throwable -> L139
        goto L185
    L178:
        pw.println(this.mNetworkConnected);     // Catch: Throwable -> L139
        goto L185
    L179:
        pw.println(this.mCharging);     // Catch: Throwable -> L139
        goto L185
    L180:
        pw.println(this.mScreenOn);     // Catch: Throwable -> L139
        goto L185
    L181:
        pw.println(this.mQuickDozeActivated);     // Catch: Throwable -> L139
        goto L185
    L182:
        pw.println(this.mForceIdle);     // Catch: Throwable -> L139
        goto L185
    L183:
        pw.println(stateToString(this.mState));     // Catch: Throwable -> L139
        goto L185
    L184:
        pw.println(lightStateToString(this.mLightState));     // Catch: Throwable -> L139
        goto L185
    L137:
        if (arg3.equals("network") == false) goto L171;
        r4 = 6;
        goto L172
    L142:
        if (arg3.equals("forceoffbody") == false) goto L171;
        r4 = 10;
        goto L172
    L145:
        if (arg3.equals(EventTeardownResult.EVENT_CHARGING) == false) goto L171;
        r4 = 5;
        goto L172
    L148:
        if (arg3.equals("quick") == false) goto L171;
        r4 = 3;
        goto L172
    L151:
        if (arg3.equals("light") == false) goto L171;
        r4 = 0;
        goto L172
    L154:
        if (arg3.equals("force") == false) goto L171;
        r4 = 2;
        goto L172
    L157:
        if (arg3.equals("deep") == false) goto L171;
    L160:
        if (arg3.equals(EventTeardownResult.EVENT_SCREEN) == false) goto L171;
        r4 = 4;
        goto L172
    L163:
        if (arg3.equals("offbody") == false) goto L171;
        r4 = 9;
        goto L172
    L166:
        if (arg3.equals("modemanagerquick") == false) goto L171;
        r4 = 7;
        goto L172
    L169:
        if (arg3.equals("forcemodemanagerquick") == false) goto L171;
        r4 = 8;
        goto L172
    L190:
        pw.println("Argument required");     // Catch: Throwable -> L186
    L186:
        th = move-exception;
        throw th;
    L196:
        if ("disable".equals(cmd) == false) goto L238;
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        monitor-enter(this);
        long token7 = Binder.clearCallingIdentity();     // Catch: Throwable -> L231
        String arg4 = shell.getNextArg();     // Catch: Throwable -> L231
        boolean becomeActive = false;
        boolean valid = false;
        if (arg4 == null) goto L209;
    L207:
        th = move-exception;
        Binder.restoreCallingIdentity(token7);     // Catch: Throwable -> L231
        throw th;     // Catch: Throwable -> L231
    L203:
        if ("deep".equals(arg4) == true) goto L209;
        if (IZswContentProviderHelper.DUMP_ALL.equals(arg4) == true) goto L209;
    L212:
        if (arg4 != null) goto L214;
    L217:
        valid = true;
        if (this.mLightEnabled == false) goto L220;
        this.mLightEnabled = false;     // Catch: Throwable -> L207
        becomeActive = true;
        pw.println("Light idle mode disabled");     // Catch: Throwable -> L207
    L220:
        if (becomeActive == false) goto L226;
        this.mActiveReason = 6;     // Catch: Throwable -> L207
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L207
        if (arg4 != null) goto L224;
        String r7 = IZswContentProviderHelper.DUMP_ALL;
    L225:
        r6.append(r7);     // Catch: Throwable -> L207
        r6.append("-disabled");     // Catch: Throwable -> L207
        becomeActiveLocked(r6.toString(), Process.myUid());     // Catch: Throwable -> L207
        goto L226
    L224:
        r7 = arg4;
    L226:
        if (valid == true) goto L228;
        pw.println("Unknown idle mode: " + arg4);     // Catch: Throwable -> L207
    L228:
        Binder.restoreCallingIdentity(token7);     // Catch: Throwable -> L231
        monitor-exit(this);     // Catch: Throwable -> L231
        goto L566
    L214:
        if ("light".equals(arg4) == true) goto L217;
        if (IZswContentProviderHelper.DUMP_ALL.equals(arg4) == false) goto L220;
    L209:
        valid = true;
        if (this.mDeepEnabled == false) goto L212;
        this.mDeepEnabled = false;     // Catch: Throwable -> L207
        becomeActive = true;
        pw.println("Deep idle mode disabled");     // Catch: Throwable -> L207
    L231:
        th = move-exception;
        throw th;
    L238:
        if ("enable".equals(cmd) == false) goto L276;
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        monitor-enter(this);
        long token8 = Binder.clearCallingIdentity();     // Catch: Throwable -> L269
        String arg5 = shell.getNextArg();     // Catch: Throwable -> L269
        boolean becomeInactive = false;
        boolean valid2 = false;
        if (arg5 == null) goto L251;
    L249:
        th = move-exception;
        Binder.restoreCallingIdentity(token8);     // Catch: Throwable -> L269
        throw th;     // Catch: Throwable -> L269
    L245:
        if ("deep".equals(arg5) == true) goto L251;
        if (IZswContentProviderHelper.DUMP_ALL.equals(arg5) == true) goto L251;
    L254:
        if (arg5 != null) goto L256;
    L259:
        valid2 = true;
        if (this.mLightEnabled == true) goto L262;
        this.mLightEnabled = true;     // Catch: Throwable -> L249
        becomeInactive = true;
        pw.println("Light idle mode enable");     // Catch: Throwable -> L249
    L262:
        if (becomeInactive == false) goto L264;
        becomeInactiveIfAppropriateLocked();     // Catch: Throwable -> L249
    L264:
        if (valid2 == true) goto L266;
        pw.println("Unknown idle mode: " + arg5);     // Catch: Throwable -> L249
    L266:
        Binder.restoreCallingIdentity(token8);     // Catch: Throwable -> L269
        monitor-exit(this);     // Catch: Throwable -> L269
        goto L566
    L256:
        if ("light".equals(arg5) == true) goto L259;
        if (IZswContentProviderHelper.DUMP_ALL.equals(arg5) == false) goto L262;
    L251:
        valid2 = true;
        if (this.mDeepEnabled == true) goto L254;
        this.mDeepEnabled = true;     // Catch: Throwable -> L249
        becomeInactive = true;
        pw.println("Deep idle mode enabled");     // Catch: Throwable -> L249
    L269:
        th = move-exception;
        throw th;
    L276:
        if (ServiceConfigAccessor.PROVIDER_MODE_ENABLED.equals(cmd) == false) goto L309;
        monitor-enter(this);
        String arg6 = shell.getNextArg();     // Catch: Throwable -> L288
        if (arg6 == null) goto L299;
        if (IZswContentProviderHelper.DUMP_ALL.equals(arg6) == true) goto L299;
        if ("deep".equals(arg6) == false) goto L292;
        if (this.mDeepEnabled == false) goto L290;
        r3 = "1";
    L290:
        pw.println(r3);     // Catch: Throwable -> L288
    L304:
        monitor-exit(this);     // Catch: Throwable -> L288
        goto L566
    L292:
        if ("light".equals(arg6) == true) goto L294;
        pw.println("Unknown idle mode: " + arg6);     // Catch: Throwable -> L288
        goto L304
    L294:
        if (this.mLightEnabled == false) goto L296;
        r3 = "1";
    L296:
        pw.println(r3);     // Catch: Throwable -> L288
    L299:
        if (this.mDeepEnabled == true) goto L301;
    L303:
        pw.println(r3);     // Catch: Throwable -> L288
        goto L304
    L301:
        if (this.mLightEnabled == false) goto L303;
        r3 = "1";
    L288:
        th = move-exception;
        throw th;
    L309:
        if ("whitelist".equals(cmd) == false) goto L371;
        String arg7 = shell.getNextArg();
        if (arg7 == null) goto L348;
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        long token9 = Binder.clearCallingIdentity();
    L576:
    L322:
        th = move-exception;
        Binder.restoreCallingIdentity(token9);
        throw th;
    L314:
        if (arg7.length() < 1) goto L342;
        if (arg7.charAt(0) != '-') goto L318;
    L324:
        char op = arg7.charAt(0);     // Catch: Throwable -> L322
        String pkg = arg7.substring(1);     // Catch: Throwable -> L322
        if (op == '+') goto L327;
        byte r16 = r12;
        if (op == '-') goto L333;
        pw.println(getPowerSaveWhitelistAppInternal(pkg));     // Catch: Throwable -> L322
    L336:
        String r0 = shell.getNextArg();     // Catch: Throwable -> L322
        arg7 = r0;
        if (r0 == null) goto L339;
        r12 = r16;
        goto L576
    L339:
        Binder.restoreCallingIdentity(token9);
        goto L566
    L333:
        if (removePowerSaveWhitelistAppInternal(pkg) == false) goto L336;
        pw.println("Removed: " + pkg);     // Catch: Throwable -> L322
        goto L336
    L327:
        if (addPowerSaveWhitelistAppsInternal(Collections.singletonList(pkg)) != 1) goto L329;
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L322
        r16 = r12;
        r15.append("Added: ");     // Catch: Throwable -> L322
        r15.append(pkg);     // Catch: Throwable -> L322
        pw.println(r15.toString());     // Catch: Throwable -> L322
        goto L336
    L329:
        r16 = r12;
        pw.println("Unknown package: " + pkg);     // Catch: Throwable -> L322
        goto L336
    L318:
        if (arg7.charAt(0) == '+') goto L324;
        if (arg7.charAt(0) == '=') goto L324;
    L342:
        pw.println("Package must be prefixed with +, -, or =: " + arg7);     // Catch: Throwable -> L322
        Binder.restoreCallingIdentity(token9);
        return r12;
    L348:
        if (DumpUtils.checkDumpPermission(getContext(), TAG, pw) == true) goto L350;
        return -1;
    L350:
        monitor-enter(this);
        int j = 0;
    L592:
    L355:
        th = move-exception;
        throw th;
    L353:
        if (j >= this.mPowerSaveWhitelistAppsExceptIdle.size()) goto L357;
        pw.print("system-excidle,");     // Catch: Throwable -> L355
        pw.print(this.mPowerSaveWhitelistAppsExceptIdle.keyAt(j));     // Catch: Throwable -> L355
        pw.print(",");     // Catch: Throwable -> L355
        pw.println(this.mPowerSaveWhitelistAppsExceptIdle.valueAt(j));     // Catch: Throwable -> L355
        j = j + 1;     // Catch: Throwable -> L355
        goto L592
    L357:
        int j2 = 0;
    L359:
        if (j2 >= this.mPowerSaveWhitelistApps.size()) goto L361;
        pw.print("system,");     // Catch: Throwable -> L355
        pw.print(this.mPowerSaveWhitelistApps.keyAt(j2));     // Catch: Throwable -> L355
        pw.print(",");     // Catch: Throwable -> L355
        pw.println(this.mPowerSaveWhitelistApps.valueAt(j2));     // Catch: Throwable -> L355
        j2 = j2 + 1;     // Catch: Throwable -> L355
        goto L359
    L361:
        int j3 = 0;
    L363:
        if (j3 >= this.mPowerSaveWhitelistUserApps.size()) goto L366;
        pw.print("user,");     // Catch: Throwable -> L355
        pw.print(this.mPowerSaveWhitelistUserApps.keyAt(j3));     // Catch: Throwable -> L355
        pw.print(",");     // Catch: Throwable -> L355
        pw.println(this.mPowerSaveWhitelistUserApps.valueAt(j3));     // Catch: Throwable -> L355
        j3 = j3 + 1;     // Catch: Throwable -> L355
        goto L363
    L366:
        monitor-exit(this);     // Catch: Throwable -> L355
        goto L566
    L371:
        if ("tempwhitelist".equals(cmd) == false) goto L421;
        boolean removePkg = false;
        long duration = 10000;
    L373:
        String opt = shell.getNextOption();
        if (opt == null) goto L392;
        if ("-u".equals(opt) == true) goto L377;
        if ("-d".equals(opt) == true) goto L384;
        if ("-r".equals(opt) == false) goto L373;
        removePkg = true;
        goto L373
    L384:
        String opt2 = shell.getNextArg();
        if (opt2 == null) goto L386;
        duration = Long.parseLong(opt2);
        goto L373
    L386:
        pw.println("-d requires a duration");
        return -1;
    L377:
        String opt3 = shell.getNextArg();
        if (opt3 == null) goto L379;
        shell.userId = Integer.parseInt(opt3);
        goto L373
    L379:
        pw.println("-u requires a user number");
        return -1;
    L392:
        String arg8 = shell.getNextArg();
        if (arg8 == null) goto L407;
        if (removePkg == true) goto L616;
        addPowerSaveTempAllowlistAppChecked(arg8, duration, shell.userId, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_SHELL, DisassociationProcessor.REASON_SHELL);     // Catch: Exception -> L402
    L402:
        e = e;
    L404:
        pw.println("Failed: " + e);
        return -1;
    L616:
        removePowerSaveTempAllowlistAppChecked(arg8, shell.userId);     // Catch: Exception -> L397
    L397:
        e = e;
        goto L404
    L407:
        if (removePkg == false) goto L411;
        pw.println("[-r] requires a package name");
        return -1;
    L411:
        if (DumpUtils.checkDumpPermission(getContext(), TAG, pw) == true) goto L413;
        return -1;
    L413:
        monitor-enter(this);
        dumpTempWhitelistScheduleLocked(pw, false);     // Catch: Throwable -> L417
        monitor-exit(this);     // Catch: Throwable -> L417
    L417:
        th = move-exception;
        throw th;
    L421:
        if ("except-idle-whitelist".equals(cmd) == false) goto L463;
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        long token10 = Binder.clearCallingIdentity();
        String arg9 = shell.getNextArg();     // Catch: Throwable -> L428
        if (arg9 != null) goto L431;
        pw.println("No arguments given");     // Catch: Throwable -> L428
        Binder.restoreCallingIdentity(token10);
        return -1;
    L431:
        if ("reset".equals(arg9) == false) goto L434;
        resetPowerSaveWhitelistExceptIdleInternal();     // Catch: Throwable -> L428
    L453:
        Binder.restoreCallingIdentity(token10);
    L434:
        if (arg9.length() < 1) goto L457;
        if (arg9.charAt(0) != '-') goto L438;
    L442:
        char op2 = arg9.charAt(0);     // Catch: Throwable -> L428
        String pkg2 = arg9.substring(1);     // Catch: Throwable -> L428
        if (op2 == '+') goto L445;
        if (op2 != '=') goto L454;
        pw.println(getPowerSaveWhitelistExceptIdleInternal(pkg2));     // Catch: Throwable -> L428
    L450:
        String r2 = shell.getNextArg();     // Catch: Throwable -> L428
        arg9 = r2;
        if (r2 != null) goto L434;
    L454:
        pw.println("Unknown argument: " + arg9);     // Catch: Throwable -> L428
        Binder.restoreCallingIdentity(token10);
        return -1;
    L445:
        if (addPowerSaveWhitelistExceptIdleInternal(pkg2) == false) goto L447;
        pw.println("Added: " + pkg2);     // Catch: Throwable -> L428
        goto L450
    L447:
        pw.println("Unknown package: " + pkg2);     // Catch: Throwable -> L428
        goto L450
    L438:
        if (arg9.charAt(0) == '+') goto L442;
        if (arg9.charAt(0) == '=') goto L442;
    L457:
        pw.println("Package must be prefixed with +, -, or =: " + arg9);     // Catch: Throwable -> L428
        Binder.restoreCallingIdentity(token10);
        return -1;
    L428:
        th = move-exception;
        Binder.restoreCallingIdentity(token10);
        throw th;
    L463:
        if ("sys-whitelist".equals(cmd) == false) goto L513;
        String arg10 = shell.getNextArg();
        if (arg10 == null) goto L498;
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        long token11 = Binder.clearCallingIdentity();
    L470:
        th = move-exception;
        Binder.restoreCallingIdentity(token11);
        throw th;
    L468:
        if ("reset".equals(arg10) == false) goto L473;
        resetSystemPowerWhitelistInternal();     // Catch: Throwable -> L470
    L491:
        Binder.restoreCallingIdentity(token11);
    L473:
        if (arg10.length() < 1) goto L492;
        if (arg10.charAt(0) != '-') goto L477;
    L479:
        char op3 = arg10.charAt(0);     // Catch: Throwable -> L470
        String pkg3 = arg10.substring(1);     // Catch: Throwable -> L470
        switch(op3) {
            case 43: goto L486;
            case 44: goto L488;
            case 45: goto L483;
            default: goto L488;
        };     // Catch: Throwable -> L470
    L488:
        String r1 = shell.getNextArg();     // Catch: Throwable -> L470
        arg10 = r1;
        if (r1 != null) goto L473;
    L483:
        if (removeSystemPowerWhitelistAppInternal(pkg3) == false) goto L488;
        pw.println("Removed " + pkg3);     // Catch: Throwable -> L470
        goto L488
    L486:
        if (restoreSystemPowerWhitelistAppInternal(pkg3) == false) goto L488;
        pw.println("Restored " + pkg3);     // Catch: Throwable -> L470
        goto L488
    L477:
        if (arg10.charAt(0) == '+') goto L479;
    L492:
        pw.println("Package must be prefixed with + or - " + arg10);     // Catch: Throwable -> L470
        Binder.restoreCallingIdentity(token11);
        return -1;
    L498:
        if (DumpUtils.checkDumpPermission(getContext(), TAG, pw) == true) goto L500;
        return -1;
    L500:
        monitor-enter(this);
        int j4 = 0;
    L594:
    L505:
        th = move-exception;
        throw th;
    L503:
        if (j4 >= this.mPowerSaveWhitelistApps.size()) goto L508;
        pw.print(this.mPowerSaveWhitelistApps.keyAt(j4));     // Catch: Throwable -> L505
        pw.print(",");     // Catch: Throwable -> L505
        pw.println(this.mPowerSaveWhitelistApps.valueAt(j4));     // Catch: Throwable -> L505
        j4 = j4 + 1;     // Catch: Throwable -> L505
        goto L594
    L508:
        monitor-exit(this);     // Catch: Throwable -> L505
        goto L566
    L513:
        if ("motion".equals(cmd) == false) goto L529;
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        monitor-enter(this);
        long token12 = Binder.clearCallingIdentity();     // Catch: Throwable -> L521
        motionLocked();     // Catch: Throwable -> L523
        pw.print("Light state: ");     // Catch: Throwable -> L523
        pw.print(lightStateToString(this.mLightState));     // Catch: Throwable -> L523
        pw.print(", deep state: ");     // Catch: Throwable -> L523
        pw.println(stateToString(this.mState));     // Catch: Throwable -> L523
        Binder.restoreCallingIdentity(token12);     // Catch: Throwable -> L521
        monitor-exit(this);     // Catch: Throwable -> L521
        goto L566
    L523:
        th = move-exception;
        Binder.restoreCallingIdentity(token12);     // Catch: Throwable -> L521
        throw th;     // Catch: Throwable -> L521
    L521:
        th = move-exception;
        throw th;
    L529:
        if ("force-modemanager-quickdoze".equals(cmd) == false) goto L552;
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        String arg11 = shell.getNextArg();
        if ("true".equalsIgnoreCase(arg11) == false) goto L533;
    L537:
        boolean enabled = Boolean.parseBoolean(arg11);
        monitor-enter(this);
        long token13 = Binder.clearCallingIdentity();     // Catch: Throwable -> L544
        this.mForceModeManagerQuickDozeRequest = true;     // Catch: Throwable -> L546
        pw.println("mForceModeManagerQuickDozeRequest: " + this.mForceModeManagerQuickDozeRequest);     // Catch: Throwable -> L546
        this.mModeManagerRequestedQuickDoze = enabled;     // Catch: Throwable -> L546
        pw.println("mModeManagerRequestedQuickDoze: " + this.mModeManagerRequestedQuickDoze);     // Catch: Throwable -> L546
        ModeManagerQuickDozeRequestConsumer.m202$$Nest$monModeManagerRequestChangedLocked(this.mModeManagerQuickDozeRequestConsumer);     // Catch: Throwable -> L546
        Binder.restoreCallingIdentity(token13);     // Catch: Throwable -> L544
        monitor-exit(this);     // Catch: Throwable -> L544
        goto L566
    L546:
        th = move-exception;
        Binder.restoreCallingIdentity(token13);     // Catch: Throwable -> L544
        throw th;     // Catch: Throwable -> L544
    L544:
        th = move-exception;
        throw th;
    L533:
        if ("false".equalsIgnoreCase(arg11) == true) goto L537;
        pw.println("Provide true or false argument after force-modemanager-quickdoze");
        return -1;
    L552:
        if ("force-modemanager-offbody".equals(cmd) == false) goto L575;
        getContext().enforceCallingOrSelfPermission("android.permission.DEVICE_POWER", null);
        String arg12 = shell.getNextArg();
        if ("true".equalsIgnoreCase(arg12) == false) goto L556;
    L560:
        boolean isOffBody = Boolean.parseBoolean(arg12);
        monitor-enter(this);
        long token14 = Binder.clearCallingIdentity();     // Catch: Throwable -> L567
        this.mForceModeManagerOffBodyState = true;     // Catch: Throwable -> L569
        pw.println("mForceModeManagerOffBodyState: " + this.mForceModeManagerOffBodyState);     // Catch: Throwable -> L569
        this.mIsOffBody = isOffBody;     // Catch: Throwable -> L569
        pw.println("mIsOffBody: " + this.mIsOffBody);     // Catch: Throwable -> L569
        ModeManagerOffBodyStateConsumer.m201$$Nest$monModeManagerOffBodyChangedLocked(this.mModeManagerOffBodyStateConsumer);     // Catch: Throwable -> L569
        Binder.restoreCallingIdentity(token14);     // Catch: Throwable -> L567
        monitor-exit(this);     // Catch: Throwable -> L567
        goto L566
    L569:
        th = move-exception;
        Binder.restoreCallingIdentity(token14);     // Catch: Throwable -> L567
        throw th;     // Catch: Throwable -> L567
    L567:
        th = move-exception;
        throw th;
    L556:
        if ("false".equalsIgnoreCase(arg12) == true) goto L560;
        pw.println("Provide true or false argument after force-modemanager-offbody");
        return -1;
    L575:
        return shell.handleDefaultCommands(cmd);
    }

    void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(getContext(), TAG, pw) == true) goto L5;
        return;
    L5:
        int size = 0;
        if (args == null) goto L30;
        int userId = 0;
        int i = 0;
    L9:
        if (i >= args.length) goto L30;
        String arg = args[i];
        if ("-h".equals(arg) == true) goto L12;
        if ("-u".equals(arg) == false) goto L20;
        i = i + 1;
        if (i >= args.length) goto L21;
        userId = Integer.parseInt(args[i]);
    L21:
        i = i + 1;
        goto L9
    L20:
        if ("-a".equals(arg) == true) goto L21;
        if (arg.length() > 0) goto L25;
    L28:
        Shell shell = new Shell(this);
        shell.userId = userId;
        String[] newArgs = new String[args.length - i];
        System.arraycopy(args, i, newArgs, 0, args.length - i);
        shell.exec(this.mBinderService, null, fd, null, newArgs, null, new ResultReceiver(null));
        return;
    L25:
        if (arg.charAt(0) != '-') goto L28;
        pw.println("Unknown option: " + arg);
        return;
    L12:
        dumpHelp(pw);
        return;
    L30:
        pw.println("  Flags:");
        pw.print("    ");
        pw.print(Flags.FLAG_USE_CPU_TIME_FOR_TEMP_ALLOWLIST);
        pw.print("=");
        pw.println(true);
        pw.print("    ");
        pw.print(Flags.FLAG_REMOVE_IDLE_LOCATION);
        pw.print("=");
        pw.println(true);
        pw.println();
        monitor-enter(this);
        this.mConstants.dump(pw);     // Catch: Throwable -> L42
        if (this.mEventCmds[0] == 0) goto L54;
        pw.println("  Idling history:");     // Catch: Throwable -> L42
        long now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L42
        int i2 = 99;
    L35:
        if (i2 < 0) goto L54;
        int cmd = this.mEventCmds[i2];     // Catch: Throwable -> L42
        if (cmd != 0) goto L40;
    L53:
        i2 = i2 - 1;     // Catch: Throwable -> L42
        goto L35
    L40:
        switch(this.mEventCmds[i2]) {
            case 1: goto L48;
            case 2: goto L47;
            case 3: goto L46;
            case 4: goto L45;
            case 5: goto L44;
            default: goto L41;
        };     // Catch: Throwable -> L42
    L41:
        String label = "         ??";
    L49:
        pw.print("    ");     // Catch: Throwable -> L42
        pw.print(label);     // Catch: Throwable -> L42
        pw.print(": ");     // Catch: Throwable -> L42
        TimeUtils.formatDuration(this.mEventTimes[i2], now, pw);     // Catch: Throwable -> L42
        if (this.mEventReasons[i2] == null) goto L52;
        pw.print(" (");     // Catch: Throwable -> L42
        pw.print(this.mEventReasons[i2]);     // Catch: Throwable -> L42
        pw.print(")");     // Catch: Throwable -> L42
    L52:
        pw.println();     // Catch: Throwable -> L42
        goto L53
    L44:
        label = " deep-maint";
        goto L49
    L45:
        label = "  deep-idle";
        goto L49
    L46:
        label = "light-maint";
        goto L49
    L47:
        label = " light-idle";
        goto L49
    L48:
        label = "     normal";
    L54:
        int size2 = this.mPowerSaveWhitelistAppsExceptIdle.size();     // Catch: Throwable -> L42
        if (size2 <= 0) goto L59;
        pw.println("  Whitelist (except idle) system apps:");     // Catch: Throwable -> L42
        int i3 = 0;
    L57:
        if (i3 >= size2) goto L59;
        pw.print("    ");     // Catch: Throwable -> L42
        pw.println(this.mPowerSaveWhitelistAppsExceptIdle.keyAt(i3));     // Catch: Throwable -> L42
        i3 = i3 + 1;     // Catch: Throwable -> L42
    L59:
        int size3 = this.mPowerSaveWhitelistApps.size();     // Catch: Throwable -> L42
        if (size3 <= 0) goto L64;
        pw.println("  Whitelist system apps:");     // Catch: Throwable -> L42
        int i4 = 0;
    L62:
        if (i4 >= size3) goto L64;
        pw.print("    ");     // Catch: Throwable -> L42
        pw.println(this.mPowerSaveWhitelistApps.keyAt(i4));     // Catch: Throwable -> L42
        i4 = i4 + 1;     // Catch: Throwable -> L42
    L64:
        int size4 = this.mRemovedFromSystemWhitelistApps.size();     // Catch: Throwable -> L42
        if (size4 <= 0) goto L69;
        pw.println("  Removed from whitelist system apps:");     // Catch: Throwable -> L42
        int i5 = 0;
    L67:
        if (i5 >= size4) goto L69;
        pw.print("    ");     // Catch: Throwable -> L42
        pw.println(this.mRemovedFromSystemWhitelistApps.keyAt(i5));     // Catch: Throwable -> L42
        i5 = i5 + 1;     // Catch: Throwable -> L42
    L69:
        int size5 = this.mPowerSaveWhitelistUserApps.size();     // Catch: Throwable -> L42
        if (size5 <= 0) goto L74;
        pw.println("  Whitelist user apps:");     // Catch: Throwable -> L42
        int i6 = 0;
    L72:
        if (i6 >= size5) goto L74;
        pw.print("    ");     // Catch: Throwable -> L42
        pw.println(this.mPowerSaveWhitelistUserApps.keyAt(i6));     // Catch: Throwable -> L42
        i6 = i6 + 1;     // Catch: Throwable -> L42
    L74:
        int size6 = this.mPowerSaveWhitelistExceptIdleAppIds.size();     // Catch: Throwable -> L42
        if (size6 <= 0) goto L79;
        pw.println("  Whitelist (except idle) all app ids:");     // Catch: Throwable -> L42
        int i7 = 0;
    L77:
        if (i7 >= size6) goto L79;
        pw.print("    ");     // Catch: Throwable -> L42
        pw.print(this.mPowerSaveWhitelistExceptIdleAppIds.keyAt(i7));     // Catch: Throwable -> L42
        pw.println();     // Catch: Throwable -> L42
        i7 = i7 + 1;     // Catch: Throwable -> L42
    L79:
        int size7 = this.mPowerSaveWhitelistUserAppIds.size();     // Catch: Throwable -> L42
        if (size7 <= 0) goto L84;
        pw.println("  Whitelist user app ids:");     // Catch: Throwable -> L42
        int i8 = 0;
    L82:
        if (i8 >= size7) goto L84;
        pw.print("    ");     // Catch: Throwable -> L42
        pw.print(this.mPowerSaveWhitelistUserAppIds.keyAt(i8));     // Catch: Throwable -> L42
        pw.println();     // Catch: Throwable -> L42
        i8 = i8 + 1;     // Catch: Throwable -> L42
    L84:
        int size8 = this.mPowerSaveWhitelistAllAppIds.size();     // Catch: Throwable -> L42
        if (size8 <= 0) goto L89;
        pw.println("  Whitelist all app ids:");     // Catch: Throwable -> L42
        int i9 = 0;
    L87:
        if (i9 >= size8) goto L89;
        pw.print("    ");     // Catch: Throwable -> L42
        pw.print(this.mPowerSaveWhitelistAllAppIds.keyAt(i9));     // Catch: Throwable -> L42
        pw.println();     // Catch: Throwable -> L42
        i9 = i9 + 1;     // Catch: Throwable -> L42
    L89:
        dumpTempWhitelistScheduleLocked(pw, true);     // Catch: Throwable -> L42
        if (this.mTempWhitelistAppIdArray == null) goto L93;
        size = this.mTempWhitelistAppIdArray.length;     // Catch: Throwable -> L42
    L93:
        if (size <= 0) goto L97;
        pw.println("  Temp whitelist app ids:");     // Catch: Throwable -> L42
        int i10 = 0;
    L95:
        if (i10 >= size) goto L97;
        pw.print("    ");     // Catch: Throwable -> L42
        pw.print(this.mTempWhitelistAppIdArray[i10]);     // Catch: Throwable -> L42
        pw.println();     // Catch: Throwable -> L42
        i10 = i10 + 1;     // Catch: Throwable -> L42
    L97:
        pw.print("  mLightEnabled=");     // Catch: Throwable -> L42
        pw.print(this.mLightEnabled);     // Catch: Throwable -> L42
        pw.print("  mDeepEnabled=");     // Catch: Throwable -> L42
        pw.println(this.mDeepEnabled);     // Catch: Throwable -> L42
        pw.print("  mForceIdle=");     // Catch: Throwable -> L42
        pw.println(this.mForceIdle);     // Catch: Throwable -> L42
        pw.print("  mUseMotionSensor=");     // Catch: Throwable -> L42
        pw.print(this.mUseMotionSensor);     // Catch: Throwable -> L42
        if (this.mUseMotionSensor == false) goto L100;
        pw.print(" mMotionSensor=");     // Catch: Throwable -> L42
        pw.println(this.mMotionSensor);     // Catch: Throwable -> L42
    L101:
        pw.print("  mScreenOn=");     // Catch: Throwable -> L42
        pw.println(this.mScreenOn);     // Catch: Throwable -> L42
        pw.print("  mScreenLocked=");     // Catch: Throwable -> L42
        pw.println(this.mScreenLocked);     // Catch: Throwable -> L42
        pw.print("  mNetworkConnected=");     // Catch: Throwable -> L42
        pw.println(this.mNetworkConnected);     // Catch: Throwable -> L42
        pw.print("  mCharging=");     // Catch: Throwable -> L42
        pw.println(this.mCharging);     // Catch: Throwable -> L42
        pw.print("  activeEmergencyCall=");     // Catch: Throwable -> L42
        pw.println(this.mEmergencyCallListener.isEmergencyCallActive());     // Catch: Throwable -> L42
        if (this.mConstraints.size() == 0) goto L113;
        pw.println("  mConstraints={");     // Catch: Throwable -> L42
        int i11 = 0;
    L105:
        if (i11 >= this.mConstraints.size()) goto L111;
        DeviceIdleConstraintTracker tracker = this.mConstraints.valueAt(i11);     // Catch: Throwable -> L42
        pw.print("    \"");     // Catch: Throwable -> L42
        pw.print(tracker.name);     // Catch: Throwable -> L42
        pw.print("\"=");     // Catch: Throwable -> L42
        if (tracker.minState != this.mState) goto L109;
        pw.println(tracker.active);     // Catch: Throwable -> L42
    L110:
        i11 = i11 + 1;     // Catch: Throwable -> L42
        goto L105
    L109:
        pw.print("ignored <mMinState=");     // Catch: Throwable -> L42
        pw.print(stateToString(tracker.minState));     // Catch: Throwable -> L42
        pw.println(">");     // Catch: Throwable -> L42
        goto L110
    L111:
        pw.println("  }");     // Catch: Throwable -> L42
    L113:
        if (this.mUseMotionSensor == false) goto L115;
    L116:
        pw.print("  mMotionActive=");     // Catch: Throwable -> L42
        pw.println(this.mMotionListener.active);     // Catch: Throwable -> L42
        pw.print("  mNotMoving=");     // Catch: Throwable -> L42
        pw.println(this.mNotMoving);     // Catch: Throwable -> L42
        pw.print("  mMotionListener.activatedTimeElapsed=");     // Catch: Throwable -> L42
        pw.println(this.mMotionListener.activatedTimeElapsed);     // Catch: Throwable -> L42
        pw.print("  mLastMotionEventElapsed=");     // Catch: Throwable -> L42
        pw.println(this.mLastMotionEventElapsed);     // Catch: Throwable -> L42
        pw.print("  ");     // Catch: Throwable -> L42
        pw.print(this.mStationaryListeners.size());     // Catch: Throwable -> L42
        pw.println(" stationary listeners registered");     // Catch: Throwable -> L42
    L118:
        if (this.mIsLocationPrefetchEnabled == false) goto L125;
        pw.print("  mLocating=");     // Catch: Throwable -> L42
        pw.print(this.mLocating);     // Catch: Throwable -> L42
        pw.print(" mHasGps=");     // Catch: Throwable -> L42
        pw.print(this.mHasGps);     // Catch: Throwable -> L42
        pw.print(" mHasFused=");     // Catch: Throwable -> L42
        pw.print(this.mHasFusedLocation);     // Catch: Throwable -> L42
        pw.print(" mLocated=");     // Catch: Throwable -> L42
        pw.println(this.mLocated);     // Catch: Throwable -> L42
        if (this.mLastGenericLocation == null) goto L123;
        pw.print("  mLastGenericLocation=");     // Catch: Throwable -> L42
        pw.println(this.mLastGenericLocation);     // Catch: Throwable -> L42
    L123:
        if (this.mLastGpsLocation == null) goto L126;
        pw.print("  mLastGpsLocation=");     // Catch: Throwable -> L42
        pw.println(this.mLastGpsLocation);     // Catch: Throwable -> L42
    L126:
        pw.print("  mState=");     // Catch: Throwable -> L42
        pw.print(stateToString(this.mState));     // Catch: Throwable -> L42
        pw.print(" mLightState=");     // Catch: Throwable -> L42
        pw.println(lightStateToString(this.mLightState));     // Catch: Throwable -> L42
        pw.print("  mInactiveTimeout=");     // Catch: Throwable -> L42
        TimeUtils.formatDuration(this.mInactiveTimeout, pw);     // Catch: Throwable -> L42
        pw.println();     // Catch: Throwable -> L42
        if (this.mActiveIdleOpCount == 0) goto L130;
        pw.print("  mActiveIdleOpCount=");     // Catch: Throwable -> L42
        pw.println(this.mActiveIdleOpCount);     // Catch: Throwable -> L42
    L130:
        if (this.mNextAlarmTime == 0) goto L133;
        pw.print("  mNextAlarmTime=");     // Catch: Throwable -> L42
        TimeUtils.formatDuration(this.mNextAlarmTime, SystemClock.elapsedRealtime(), pw);     // Catch: Throwable -> L42
        pw.println();     // Catch: Throwable -> L42
    L133:
        if (this.mNextIdlePendingDelay == 0) goto L136;
        pw.print("  mNextIdlePendingDelay=");     // Catch: Throwable -> L42
        TimeUtils.formatDuration(this.mNextIdlePendingDelay, pw);     // Catch: Throwable -> L42
        pw.println();     // Catch: Throwable -> L42
    L136:
        if (this.mNextIdleDelay == 0) goto L139;
        pw.print("  mNextIdleDelay=");     // Catch: Throwable -> L42
        TimeUtils.formatDuration(this.mNextIdleDelay, pw);     // Catch: Throwable -> L42
        pw.println();     // Catch: Throwable -> L42
    L139:
        if (this.mNextLightIdleDelay == 0) goto L145;
        pw.print("  mNextLightIdleDelay=");     // Catch: Throwable -> L42
        TimeUtils.formatDuration(this.mNextLightIdleDelay, pw);     // Catch: Throwable -> L42
        if (this.mConstants.USE_WINDOW_ALARMS == false) goto L143;
        pw.print(" (flex=");     // Catch: Throwable -> L42
        TimeUtils.formatDuration(this.mNextLightIdleDelayFlex, pw);     // Catch: Throwable -> L42
        pw.println(")");     // Catch: Throwable -> L42
        goto L145
    L143:
        pw.println();     // Catch: Throwable -> L42
    L145:
        if (this.mNextLightAlarmTime == 0) goto L148;
        pw.print("  mNextLightAlarmTime=");     // Catch: Throwable -> L42
        TimeUtils.formatDuration(this.mNextLightAlarmTime, SystemClock.elapsedRealtime(), pw);     // Catch: Throwable -> L42
        pw.println();     // Catch: Throwable -> L42
    L148:
        if (this.mCurLightIdleBudget == 0) goto L151;
        pw.print("  mCurLightIdleBudget=");     // Catch: Throwable -> L42
        TimeUtils.formatDuration(this.mCurLightIdleBudget, pw);     // Catch: Throwable -> L42
        pw.println();     // Catch: Throwable -> L42
    L151:
        if (this.mMaintenanceStartTime == 0) goto L154;
        pw.print("  mMaintenanceStartTime=");     // Catch: Throwable -> L42
        TimeUtils.formatDuration(this.mMaintenanceStartTime, SystemClock.elapsedRealtime(), pw);     // Catch: Throwable -> L42
        pw.println();     // Catch: Throwable -> L42
    L154:
        if (this.mJobsActive == false) goto L157;
        pw.print("  mJobsActive=");     // Catch: Throwable -> L42
        pw.println(this.mJobsActive);     // Catch: Throwable -> L42
    L157:
        if (this.mAlarmsActive == false) goto L160;
        pw.print("  mAlarmsActive=");     // Catch: Throwable -> L42
        pw.println(this.mAlarmsActive);     // Catch: Throwable -> L42
    L160:
        if (this.mConstants.USE_MODE_MANAGER == false) goto L162;
        pw.print("  mModeManagerRequestedQuickDoze=");     // Catch: Throwable -> L42
        pw.println(this.mModeManagerRequestedQuickDoze);     // Catch: Throwable -> L42
        pw.print("  mIsOffBody=");     // Catch: Throwable -> L42
        pw.println(this.mIsOffBody);     // Catch: Throwable -> L42
    L162:
        monitor-exit(this);     // Catch: Throwable -> L42
        return;
    L125:
        pw.println("  Location prefetching disabled");     // Catch: Throwable -> L42
        goto L126
    L115:
        if (this.mStationaryListeners.size() <= 0) goto L118;
    L100:
        pw.println();     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }

    void dumpTempWhitelistScheduleLocked(PrintWriter pw, boolean printTitle) {
        int size = this.mTempWhitelistAppIdEndTimes.size();
        if (size <= 0) goto L10;
        String prefix = "";
        if (printTitle == false) goto L7;
        pw.println("  Temp whitelist schedule:");
        prefix = "    ";
    L7:
        long timeNow = this.mInjector.getUptimeMillis();
        int i = 0;
    L8:
        if (i >= size) goto L12;
        pw.print(prefix);
        pw.print("UID=");
        pw.print(this.mTempWhitelistAppIdEndTimes.keyAt(i));
        pw.print(": ");
        Pair<MutableLong, String> entry = this.mTempWhitelistAppIdEndTimes.valueAt(i);
        TimeUtils.formatDuration(((MutableLong) entry.first).value, timeNow, pw);
        pw.print(" - ");
        pw.println((String) entry.second);
        i = i + 1;
        goto L8
    L12:
        return;
    }

    public boolean isLightEnabled() {
        return this.mLightEnabled;
    }

    public void setLightEnabled(boolean lightEnabled) {
        this.mLightEnabled = lightEnabled;
    }

    public boolean isDeepEnabled() {
        return this.mDeepEnabled;
    }

    public void setDeepEnabled(boolean deepEnabled) {
        this.mDeepEnabled = deepEnabled;
    }
}
