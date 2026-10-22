package com.android.server.power;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AlarmManager;
import android.app.IActivityManager;
import android.app.IForegroundServiceObserver;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManagerInternal;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.util.proto.ProtoOutputStream;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalServices;
import com.android.server.PowerAllowlistInternal;
import com.android.server.net.NetworkPolicyManagerInternal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class LowPowerStandbyController {
    private static final String ATTR_VALUE = "value";
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_ACTIVE_DURING_MAINTENANCE = false;
    static final PowerManager.LowPowerStandbyPolicy DEFAULT_POLICY = null;
    private static final int MSG_FOREGROUND_SERVICE_STATE_CHANGED = 4;
    private static final int MSG_NOTIFY_ACTIVE_CHANGED = 1;
    private static final int MSG_NOTIFY_ALLOWLIST_CHANGED = 2;
    private static final int MSG_NOTIFY_POLICY_CHANGED = 3;
    private static final int MSG_NOTIFY_STANDBY_PORTS_CHANGED = 5;
    private static final int MSG_STANDBY_TIMEOUT = 0;
    private static final String TAG = "LowPowerStandbyController";
    private static final String TAG_ALLOWED_FEATURES = "allowed-features";
    private static final String TAG_ALLOWED_REASONS = "allowed-reasons";
    private static final String TAG_EXEMPT_PACKAGE = "exempt-package";
    private static final String TAG_IDENTIFIER = "identifier";
    private static final String TAG_ROOT = "low-power-standby-policy";
    private boolean mActiveDuringMaintenance;
    private final Supplier<IActivityManager> mActivityManager;
    private ActivityManagerInternal mActivityManagerInternal;
    private AlarmManager mAlarmManager;
    private final BroadcastReceiver mBroadcastReceiver;
    private final Clock mClock;
    private final Context mContext;
    private final DeviceConfigWrapper mDeviceConfig;
    private boolean mEnableCustomPolicy;
    private boolean mEnableStandbyPorts;
    private boolean mEnabledByDefaultConfig;
    private boolean mForceActive;
    private final Handler mHandler;
    private boolean mIdleSinceNonInteractive;
    private boolean mIsActive;
    private boolean mIsDeviceIdle;
    private boolean mIsEnabled;
    private boolean mIsInteractive;
    private long mLastInteractiveTimeElapsed;
    private final LowPowerStandbyControllerInternal mLocalService;
    private final Object mLock;
    private final List<String> mLowPowerStandbyManagingPackages;
    private final AlarmManager.OnAlarmListener mOnStandbyTimeoutExpired;
    private final BroadcastReceiver mPackageBroadcastReceiver;
    private final PhoneCallServiceTracker mPhoneCallServiceTracker;
    private PowerManager.LowPowerStandbyPolicy mPolicy;
    private final File mPolicyFile;
    private PowerManager mPowerManager;
    private final SettingsObserver mSettingsObserver;
    private final List<StandbyPortsLock> mStandbyPortLocks;
    private int mStandbyTimeoutConfig;
    private boolean mSupportedConfig;
    private final TempAllowlistChangeListener mTempAllowlistChangeListener;
    private final SparseIntArray mUidAllowedReasons;
    private final BroadcastReceiver mUserReceiver;

    interface Clock {
        long elapsedRealtime();

        long uptimeMillis();
    }

    public static class DeviceConfigWrapper {
        public static final String FEATURE_FLAG_ENABLE_POLICY = "enable_policy";
        public static final String FEATURE_FLAG_ENABLE_STANDBY_PORTS = "enable_standby_ports";
        public static final String NAMESPACE = "low_power_standby";

        public DeviceConfigWrapper() {
        }

        public boolean enableCustomPolicy() {
            return DeviceConfig.getBoolean(NAMESPACE, FEATURE_FLAG_ENABLE_POLICY, true);
        }

        public boolean enableStandbyPorts() {
            return DeviceConfig.getBoolean(NAMESPACE, FEATURE_FLAG_ENABLE_STANDBY_PORTS, true);
        }

        public void registerPropertyUpdateListener(Executor executor, DeviceConfig.OnPropertiesChangedListener onPropertiesChangedListener) {
            DeviceConfig.addOnPropertiesChangedListener(NAMESPACE, executor, onPropertiesChangedListener);
        }
    }

    private final class LocalService extends LowPowerStandbyControllerInternal {
        final /* synthetic */ LowPowerStandbyController this$0;

        /* synthetic */ LocalService(LowPowerStandbyController r1, LowPowerStandbyControllerIA r2) {
            this(r1);
        }

        private LocalService(LowPowerStandbyController r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.power.LowPowerStandbyControllerInternal
        public void addToAllowlist(int uid, int allowedReason) {
            LowPowerStandbyController.m7404$$Nest$maddToAllowlistInternal(this.this$0, uid, allowedReason);
        }

        @Override // com.android.server.power.LowPowerStandbyControllerInternal
        public void removeFromAllowlist(int uid, int allowedReason) {
            LowPowerStandbyController.m7414$$Nest$mremoveFromAllowlistInternal(this.this$0, uid, allowedReason);
        }
    }

    private class LowPowerStandbyHandler extends Handler {
        final /* synthetic */ LowPowerStandbyController this$0;

        LowPowerStandbyHandler(LowPowerStandbyController r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0: goto L10;
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L7;
                case 4: goto L6;
                case 5: goto L5;
                default: goto L17;
            };
        L5:
            LowPowerStandbyController.m7409$$Nest$mnotifyStandbyPortsChanged(this.this$0);
            return;
        L6:
            int uid = msg.arg1;
            LowPowerStandbyController.m7403$$Nest$fgetmPhoneCallServiceTracker(this.this$0).foregroundServiceStateChanged(uid);
            return;
        L7:
            LowPowerStandbyController.m7408$$Nest$mnotifyPolicyChanged(this.this$0, (PowerManager.LowPowerStandbyPolicy) msg.obj);
            return;
        L8:
            int[] allowlistUids = (int[]) msg.obj;
            LowPowerStandbyController.m7407$$Nest$mnotifyAllowlistChanged(this.this$0, allowlistUids);
            return;
        L9:
            boolean active = ((Boolean) msg.obj).booleanValue();
            LowPowerStandbyController.m7406$$Nest$mnotifyActiveChanged(this.this$0, active);
            return;
        L10:
            LowPowerStandbyController.m7413$$Nest$monStandbyTimeoutExpired(this.this$0);
            return;
        }
    }

    final class PhoneCallServiceTracker extends IForegroundServiceObserver.Stub {
        private boolean mRegistered;
        private final SparseBooleanArray mUidsWithPhoneCallService;
        final /* synthetic */ LowPowerStandbyController this$0;

        PhoneCallServiceTracker(LowPowerStandbyController this$0) {
            this.this$0 = this$0;
            this.mRegistered = false;
            this.mUidsWithPhoneCallService = new SparseBooleanArray();
        }

        public void register() {
            if (this.mRegistered == false) goto L9;
            return;
        L9:
            ((IActivityManager) LowPowerStandbyController.m7397$$Nest$fgetmActivityManager(this.this$0).get()).registerForegroundServiceObserver(this);     // Catch: RemoteException -> L7
            this.mRegistered = true;     // Catch: RemoteException -> L7
            return;
        }

        public void onForegroundStateChanged(IBinder serviceToken, String packageName, int userId, boolean isForeground) {
            int uid = LowPowerStandbyController.m7400$$Nest$fgetmContext(this.this$0).getPackageManager().getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L4
            Message message = LowPowerStandbyController.m7401$$Nest$fgetmHandler(this.this$0).obtainMessage(4, uid, 0);     // Catch: PackageManager.NameNotFoundException -> L4
            LowPowerStandbyController.m7401$$Nest$fgetmHandler(this.this$0).sendMessageAtTime(message, LowPowerStandbyController.m7399$$Nest$fgetmClock(this.this$0).uptimeMillis());     // Catch: PackageManager.NameNotFoundException -> L4
            return;
        }

        public void foregroundServiceStateChanged(int uid) {
            boolean hadPhoneCallService = this.mUidsWithPhoneCallService.get(uid);
            boolean hasPhoneCallService = LowPowerStandbyController.m7398$$Nest$fgetmActivityManagerInternal(this.this$0).hasRunningForegroundService(uid, 4);
            if (hasPhoneCallService != hadPhoneCallService) goto L5;
            return;
        L5:
            if (hasPhoneCallService == false) goto L7;
            this.mUidsWithPhoneCallService.append(uid, true);
            uidStartedPhoneCallService(uid);
            return;
        L7:
            this.mUidsWithPhoneCallService.delete(uid);
            uidStoppedPhoneCallService(uid);
        }

        private void uidStartedPhoneCallService(int uid) {
            LowPowerStandbyController.m7404$$Nest$maddToAllowlistInternal(this.this$0, uid, 4);
        }

        private void uidStoppedPhoneCallService(int uid) {
            LowPowerStandbyController.m7414$$Nest$mremoveFromAllowlistInternal(this.this$0, uid, 4);
        }
    }

    private static class RealClock implements Clock {
        /* synthetic */ RealClock(LowPowerStandbyControllerIA r1) {
            this();
        }

        private RealClock() {
        }

        @Override // com.android.server.power.LowPowerStandbyController.Clock
        public long elapsedRealtime() {
            return SystemClock.elapsedRealtime();
        }

        @Override // com.android.server.power.LowPowerStandbyController.Clock
        public long uptimeMillis() {
            return SystemClock.uptimeMillis();
        }
    }

    private final class SettingsObserver extends ContentObserver {
        final /* synthetic */ LowPowerStandbyController this$0;

        SettingsObserver(LowPowerStandbyController r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            this.this$0.onSettingsChanged();
        }
    }

    private final class StandbyPortsLock implements IBinder.DeathRecipient {
        private final List<PowerManager.LowPowerStandbyPortDescription> mPorts;
        private final IBinder mToken;
        private final int mUid;
        final /* synthetic */ LowPowerStandbyController this$0;

        StandbyPortsLock(LowPowerStandbyController r1, IBinder token, int uid, List<PowerManager.LowPowerStandbyPortDescription> ports) {
            this.this$0 = r1;
            this.mToken = token;
            this.mUid = uid;
            this.mPorts = ports;
        }

        public boolean linkToDeath() {
            this.mToken.linkToDeath(this, 0);     // Catch: RemoteException -> L6
            return true;
        L7:
            Slog.i(LowPowerStandbyController.TAG, "StandbyPorts token already died");
            return false;
        }

        public void unlinkToDeath() {
            this.mToken.unlinkToDeath(this, 0);
        }

        public IBinder getToken() {
            return this.mToken;
        }

        public int getUid() {
            return this.mUid;
        }

        public List<PowerManager.LowPowerStandbyPortDescription> getPorts() {
            return this.mPorts;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.this$0.releaseStandbyPorts(this.mToken);
        }
    }

    final class TempAllowlistChangeListener implements PowerAllowlistInternal.TempAllowlistChangeListener {
        final /* synthetic */ LowPowerStandbyController this$0;

        TempAllowlistChangeListener(LowPowerStandbyController this$0) {
            this.this$0 = this$0;
        }

        public void onAppAdded(int uid) {
            LowPowerStandbyController.m7404$$Nest$maddToAllowlistInternal(this.this$0, uid, 2);
        }

        public void onAppRemoved(int uid) {
            LowPowerStandbyController.m7414$$Nest$mremoveFromAllowlistInternal(this.this$0, uid, 2);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$EeEPzk3ZTM2BI7CAmcL-4_plZlg, reason: not valid java name */
    public static /* synthetic */ void m7395$r8$lambda$EeEPzk3ZTM2BI7CAmcL4_plZlg(LowPowerStandbyController r0) {
        r0.onStandbyTimeoutExpired();
    }

    public static /* synthetic */ void $r8$lambda$IX7H86JqFnHaBS1I3G468jLAQys(LowPowerStandbyController r0, DeviceConfig.Properties r1) {
        r0.lambda$systemReady$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$VlqmY3NjyBGLQHnrfE-2CDuKs2Y, reason: not valid java name */
    public static /* synthetic */ IActivityManager m7396$r8$lambda$VlqmY3NjyBGLQHnrfE2CDuKs2Y() {
        return lambda$new$0();
    }

    public static /* synthetic */ void $r8$lambda$iJrqlm2fK1cX03M95O66fv_67Zk(LowPowerStandbyController r0, PowerManager.LowPowerStandbyPolicy r1) {
        r0.lambda$enqueueSavePolicy$2(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ Supplier m7397$$Nest$fgetmActivityManager(LowPowerStandbyController r0) {
        return r0.mActivityManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityManagerInternal m7398$$Nest$fgetmActivityManagerInternal(LowPowerStandbyController r0) {
        return r0.mActivityManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Clock m7399$$Nest$fgetmClock(LowPowerStandbyController r0) {
        return r0.mClock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7400$$Nest$fgetmContext(LowPowerStandbyController r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7401$$Nest$fgetmHandler(LowPowerStandbyController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7402$$Nest$fgetmLock(LowPowerStandbyController r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPhoneCallServiceTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ PhoneCallServiceTracker m7403$$Nest$fgetmPhoneCallServiceTracker(LowPowerStandbyController r0) {
        return r0.mPhoneCallServiceTracker;
    }

    /* JADX INFO: renamed from: -$$Nest$maddToAllowlistInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7404$$Nest$maddToAllowlistInternal(LowPowerStandbyController r0, int r1, int r2) {
        r0.addToAllowlistInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$menqueueNotifyAllowlistChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7405$$Nest$menqueueNotifyAllowlistChangedLocked(LowPowerStandbyController r0) {
        r0.enqueueNotifyAllowlistChangedLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyActiveChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7406$$Nest$mnotifyActiveChanged(LowPowerStandbyController r0, boolean r1) {
        r0.notifyActiveChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyAllowlistChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7407$$Nest$mnotifyAllowlistChanged(LowPowerStandbyController r0, int[] r1) {
        r0.notifyAllowlistChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyPolicyChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7408$$Nest$mnotifyPolicyChanged(LowPowerStandbyController r0, PowerManager.LowPowerStandbyPolicy r1) {
        r0.notifyPolicyChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyStandbyPortsChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7409$$Nest$mnotifyStandbyPortsChanged(LowPowerStandbyController r0) {
        r0.notifyStandbyPortsChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$monDeviceIdleModeChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7410$$Nest$monDeviceIdleModeChanged(LowPowerStandbyController r0) {
        r0.onDeviceIdleModeChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$monInteractive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7411$$Nest$monInteractive(LowPowerStandbyController r0) {
        r0.onInteractive();
    }

    /* JADX INFO: renamed from: -$$Nest$monNonInteractive, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7412$$Nest$monNonInteractive(LowPowerStandbyController r0) {
        r0.onNonInteractive();
    }

    /* JADX INFO: renamed from: -$$Nest$monStandbyTimeoutExpired, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7413$$Nest$monStandbyTimeoutExpired(LowPowerStandbyController r0) {
        r0.onStandbyTimeoutExpired();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveFromAllowlistInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7414$$Nest$mremoveFromAllowlistInternal(LowPowerStandbyController r0, int r1, int r2) {
        r0.removeFromAllowlistInternal(r1, r2);
    }

    static {
        DEFAULT_POLICY = new PowerManager.LowPowerStandbyPolicy("DEFAULT_POLICY", Collections.emptySet(), 1, Collections.emptySet());
    }

    public LowPowerStandbyController(Context context, Looper looper) {
        this(context, looper, new RealClock(null), new DeviceConfigWrapper(), new LowPowerStandbyController$$ExternalSyntheticLambda2(), new File(Environment.getDataSystemDirectory(), "low_power_standby_policy.xml"));
    }

    private static /* synthetic */ IActivityManager lambda$new$0() {
        return ActivityManager.getService();
    }

    LowPowerStandbyController(Context context, Looper looper, Clock clock, DeviceConfigWrapper deviceConfig, Supplier<IActivityManager> activityManager, File policyFile) {
        this.mLock = new Object();
        this.mOnStandbyTimeoutExpired = new LowPowerStandbyController$$ExternalSyntheticLambda1(this);
        this.mLocalService = new LocalService(this, null);
        this.mUidAllowedReasons = new SparseIntArray();
        this.mLowPowerStandbyManagingPackages = new ArrayList();
        this.mStandbyPortLocks = new ArrayList();
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mTempAllowlistChangeListener = new TempAllowlistChangeListener(this);
        this.mPhoneCallServiceTracker = new PhoneCallServiceTracker(this);
        this.mPackageBroadcastReceiver = new AnonymousClass2(this);
        this.mUserReceiver = new AnonymousClass3(this);
        this.mContext = context;
        this.mHandler = new LowPowerStandbyHandler(this, looper);
        this.mClock = clock;
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler);
        this.mDeviceConfig = deviceConfig;
        this.mActivityManager = activityManager;
        this.mPolicyFile = policyFile;
    }

    public void systemReady() {
        Resources resources = this.mContext.getResources();
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mSupportedConfig = resources.getBoolean(R.bool.config_matchSecondaryInternalDisplaysOrientationToReverseDefaultDisplay);     // Catch: Throwable -> L9
        if (this.mSupportedConfig == true) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L11:
        List<PackageInfo> manageLowPowerStandbyPackages = this.mContext.getPackageManager().getPackagesHoldingPermissions(new String[]{"android.permission.MANAGE_LOW_POWER_STANDBY"}, 1048576);     // Catch: Throwable -> L9
        Iterator<PackageInfo> r3 = manageLowPowerStandbyPackages.iterator();     // Catch: Throwable -> L9
    L13:
        if (r3.hasNext() == false) goto L15;
        PackageInfo packageInfo = r3.next();     // Catch: Throwable -> L9
        this.mLowPowerStandbyManagingPackages.add(packageInfo.packageName);     // Catch: Throwable -> L9
        goto L13
    L15:
        this.mAlarmManager = (AlarmManager) this.mContext.getSystemService(AlarmManager.class);     // Catch: Throwable -> L9
        this.mPowerManager = (PowerManager) this.mContext.getSystemService(PowerManager.class);     // Catch: Throwable -> L9
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);     // Catch: Throwable -> L9
        this.mStandbyTimeoutConfig = resources.getInteger(R.integer.config_mediaRouter_builtInSpeakerSuitability);     // Catch: Throwable -> L9
        this.mEnabledByDefaultConfig = resources.getBoolean(R.bool.config_maskSecondaryBuiltInDisplayCutout);     // Catch: Throwable -> L9
        this.mIsInteractive = this.mPowerManager.isInteractive();     // Catch: Throwable -> L9
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("low_power_standby_enabled"), false, this.mSettingsObserver, -1);     // Catch: Throwable -> L9
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("low_power_standby_active_during_maintenance"), false, this.mSettingsObserver, -1);     // Catch: Throwable -> L9
        this.mDeviceConfig.registerPropertyUpdateListener(this.mContext.getMainExecutor(), new LowPowerStandbyController$$ExternalSyntheticLambda3(this));     // Catch: Throwable -> L9
        this.mEnableCustomPolicy = this.mDeviceConfig.enableCustomPolicy();     // Catch: Throwable -> L9
        this.mEnableStandbyPorts = this.mDeviceConfig.enableStandbyPorts();     // Catch: Throwable -> L9
        if (this.mEnableCustomPolicy == false) goto L18;
        this.mPolicy = loadPolicy();     // Catch: Throwable -> L9
    L19:
        initSettingsLocked();     // Catch: Throwable -> L9
        updateSettingsLocked();     // Catch: Throwable -> L9
        if (this.mIsEnabled == false) goto L22;
        registerListeners();     // Catch: Throwable -> L9
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L9
        LocalServices.addService(LowPowerStandbyControllerInternal.class, this.mLocalService);
        return;
    L18:
        this.mPolicy = DEFAULT_POLICY;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$systemReady$1(DeviceConfig.Properties properties) {
        onDeviceConfigFlagsChanged();
    }

    private void onDeviceConfigFlagsChanged() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean enableCustomPolicy = this.mDeviceConfig.enableCustomPolicy();     // Catch: Throwable -> L7
        if (this.mEnableCustomPolicy == enableCustomPolicy) goto L9;
        enqueueNotifyPolicyChangedLocked();     // Catch: Throwable -> L7
        enqueueNotifyAllowlistChangedLocked();     // Catch: Throwable -> L7
        this.mEnableCustomPolicy = enableCustomPolicy;     // Catch: Throwable -> L7
    L9:
        this.mEnableStandbyPorts = this.mDeviceConfig.enableStandbyPorts();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void initSettingsLocked() {
        ContentResolver r0 = this.mContext.getContentResolver();
        if (this.mSupportedConfig == true) goto L5;
        return;
    L5:
        if (Settings.Global.getInt(r0, "low_power_standby_enabled", -1) != (-1)) goto L9;
        Settings.Global.putInt(r0, "low_power_standby_enabled", this.mEnabledByDefaultConfig ? 1 : 0);
        return;
    }

    private void updateSettingsLocked() {
        ContentResolver r0 = this.mContext.getContentResolver();
        boolean r2 = true;
        if (this.mSupportedConfig == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.mIsEnabled = r1;
        if (Settings.Global.getInt(r0, "low_power_standby_active_during_maintenance", 0) != 0) goto L12;
        r2 = false;
    L12:
        this.mActiveDuringMaintenance = r2;
        updateActiveLocked();
        return;
    L5:
        if (Settings.Global.getInt(r0, "low_power_standby_enabled", this.mEnabledByDefaultConfig ? 1 : 0) == 0) goto L7;
        r1 = true;
        goto L8
    }

    private PowerManager.LowPowerStandbyPolicy loadPolicy() {
        AtomicFile file = getPolicyFile();
        if (file.exists() == true) goto L70;
        return null;
    L70:
        FileInputStream in = file.openRead();     // Catch: Throwable -> L21 FileNotFoundException -> L23
        String identifier = null;
        Set<String> exemptPackages = new ArraySet();     // Catch: Throwable -> L26
        int allowedReasons = 0;
        Set<String> allowedFeatures = new ArraySet();     // Catch: Throwable -> L26
        TypedXmlPullParser parser = Xml.resolvePullParser(in);     // Catch: Throwable -> L26
    L8:
        int type = parser.next();     // Catch: Throwable -> L26
        byte r11 = 1;
        if (type == 1) goto L52;
        if (type != 2) goto L8;
        int depth = parser.getDepth();     // Catch: Throwable -> L26
        String tag = parser.getName();     // Catch: Throwable -> L26
        if (depth == 1) goto L16;
        switch(tag.hashCode()) {
            case -1618432855: goto L41;
            case -764820798: goto L38;
            case 1342665610: goto L35;
            case 2046809176: goto L32;
            default: goto L43;
        };     // Catch: Throwable -> L26
    L43:
        r11 = -1;
    L45:
        switch(r11) {
            case 0: goto L50;
            case 1: goto L49;
            case 2: goto L48;
            case 3: goto L47;
            default: goto L46;
        };
    L46:
        Slog.e(TAG, "Invalid tag: " + tag);     // Catch: Throwable -> L26
        goto L8
    L47:
        allowedFeatures.add(parser.getAttributeValue(null, ATTR_VALUE));     // Catch: Throwable -> L26
        goto L8
    L48:
        int allowedReasons2 = parser.getAttributeInt(null, ATTR_VALUE);     // Catch: Throwable -> L26
        allowedReasons = allowedReasons2;
        goto L8
    L49:
        exemptPackages.add(parser.getAttributeValue(null, ATTR_VALUE));     // Catch: Throwable -> L26
        goto L8
    L50:
        String identifier2 = parser.getAttributeValue(null, ATTR_VALUE);     // Catch: Throwable -> L26
        identifier = identifier2;
        goto L8
    L32:
        if (tag.equals(TAG_EXEMPT_PACKAGE) == false) goto L43;
    L35:
        if (tag.equals(TAG_ALLOWED_REASONS) == false) goto L43;
        r11 = 2;
        goto L45
    L38:
        if (tag.equals(TAG_ALLOWED_FEATURES) == false) goto L43;
        r11 = 3;
        goto L45
    L41:
        if (tag.equals(TAG_IDENTIFIER) == false) goto L43;
        r11 = 0;
        goto L45
    L16:
        if (TAG_ROOT.equals(tag) == true) goto L8;
        Slog.e(TAG, "Invalid root tag: " + tag);     // Catch: Throwable -> L26
        if (in == null) goto L25;
        in.close();     // Catch: Throwable -> L21 Throwable -> L21 Throwable -> L21 Throwable -> L21 FileNotFoundException -> L23
    L25:
        return null;
    L52:
        PowerManager.LowPowerStandbyPolicy policy = new PowerManager.LowPowerStandbyPolicy(identifier, exemptPackages, allowedReasons, allowedFeatures);     // Catch: Throwable -> L26
        if (in == null) goto L55;
        in.close();     // Catch: Throwable -> L21 Throwable -> L21 Throwable -> L21 Throwable -> L21 FileNotFoundException -> L23
    L55:
        return policy;
    L26:
        th = move-exception;
        if (in != null) goto L67;
    L62:
        throw th;     // Catch: Throwable -> L21 Throwable -> L21 Throwable -> L21 Throwable -> L21 FileNotFoundException -> L23
    L67:
        in.close();     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L21 Throwable -> L21 Throwable -> L21 Throwable -> L21 FileNotFoundException -> L23
    L21:
        e = move-exception;
        Slog.e(TAG, "Failed to read policy file " + file.getBaseFile(), e);
        return null;
    L66:
        return null;
    }

    static void writeTagValue(TypedXmlSerializer out, String tag, String value) throws IOException {
        if (TextUtils.isEmpty(value) == false) goto L5;
        return;
    L5:
        out.startTag(null, tag);
        out.attribute(null, ATTR_VALUE, value);
        out.endTag(null, tag);
    }

    static void writeTagValue(TypedXmlSerializer out, String tag, int value) throws IOException {
        out.startTag(null, tag);
        out.attributeInt(null, ATTR_VALUE, value);
        out.endTag(null, tag);
    }

    private void savePolicy(PowerManager.LowPowerStandbyPolicy policy) {
        AtomicFile file = getPolicyFile();
        if (policy != null) goto L6;
        file.delete();
        return;
    L6:
        FileOutputStream outs = null;
        file.getBaseFile().mkdirs();     // Catch: IOException -> L11
        outs = file.startWrite();     // Catch: IOException -> L11
        TypedXmlSerializer out = Xml.resolveSerializer(outs);     // Catch: IOException -> L11
        out.startDocument(null, true);     // Catch: IOException -> L11
        out.startTag(null, TAG_ROOT);     // Catch: IOException -> L11
        writeTagValue(out, TAG_IDENTIFIER, policy.getIdentifier());     // Catch: IOException -> L11
        Iterator r4 = policy.getExemptPackages().iterator();     // Catch: IOException -> L11
    L9:
        if (r4.hasNext() == false) goto L13;
        String exemptPackage = (String) r4.next();     // Catch: IOException -> L11
        writeTagValue(out, TAG_EXEMPT_PACKAGE, exemptPackage);     // Catch: IOException -> L11
        goto L9
    L13:
        writeTagValue(out, TAG_ALLOWED_REASONS, policy.getAllowedReasons());     // Catch: IOException -> L11
        Iterator r5 = policy.getAllowedFeatures().iterator();     // Catch: IOException -> L11
    L15:
        if (r5.hasNext() == false) goto L17;
        String allowedFeature = (String) r5.next();     // Catch: IOException -> L11
        writeTagValue(out, TAG_ALLOWED_FEATURES, allowedFeature);     // Catch: IOException -> L11
        goto L15
    L17:
        out.endTag(null, TAG_ROOT);     // Catch: IOException -> L11
        out.endDocument();     // Catch: IOException -> L11
        file.finishWrite(outs);     // Catch: IOException -> L11
        return;
    L11:
        e = move-exception;
        Slog.e(TAG, "Failed to write policy to file " + file.getBaseFile(), e);
        file.failWrite(outs);
    }

    private void enqueueSavePolicy(final PowerManager.LowPowerStandbyPolicy policy) {
        this.mHandler.post(new LowPowerStandbyController$$ExternalSyntheticLambda0(this, policy));
    }

    private /* synthetic */ void lambda$enqueueSavePolicy$2(PowerManager.LowPowerStandbyPolicy policy) {
        savePolicy(policy);
    }

    private AtomicFile getPolicyFile() {
        return new AtomicFile(this.mPolicyFile);
    }

    private void updateActiveLocked() {
        long nowElapsed = this.mClock.elapsedRealtime();
        boolean newActive = false;
        if ((nowElapsed - this.mLastInteractiveTimeElapsed) < this.mStandbyTimeoutConfig) goto L5;
        boolean standbyTimeoutExpired = true;
    L7:
        if (this.mIdleSinceNonInteractive == true) goto L9;
    L11:
        boolean maintenanceMode = false;
    L13:
        if (this.mForceActive == false) goto L15;
    L22:
        newActive = true;
    L24:
        if (this.mIsActive == newActive) goto L27;
        this.mIsActive = newActive;
        enqueueNotifyActiveChangedLocked();
        return;
    L27:
        return;
    L15:
        if (this.mIsEnabled == false) goto L24;
        if (this.mIsInteractive == true) goto L24;
        if (standbyTimeoutExpired == false) goto L24;
        if (maintenanceMode == false) goto L22;
        if (this.mActiveDuringMaintenance == false) goto L24;
    L9:
        if (this.mIsDeviceIdle == true) goto L11;
        maintenanceMode = true;
        goto L13
    L5:
        standbyTimeoutExpired = false;
        goto L7
    }

    private void onNonInteractive() {
        long nowElapsed = this.mClock.elapsedRealtime();
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mIsInteractive = false;     // Catch: Throwable -> L8
        this.mIsDeviceIdle = false;     // Catch: Throwable -> L8
        this.mLastInteractiveTimeElapsed = nowElapsed;     // Catch: Throwable -> L8
        if (this.mStandbyTimeoutConfig <= 0) goto L10;
        scheduleStandbyTimeoutAlarmLocked();     // Catch: Throwable -> L8
    L10:
        updateActiveLocked();     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void onInteractive() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        cancelStandbyTimeoutAlarmLocked();     // Catch: Throwable -> L7
        this.mIsInteractive = true;     // Catch: Throwable -> L7
        this.mIsDeviceIdle = false;     // Catch: Throwable -> L7
        this.mIdleSinceNonInteractive = false;     // Catch: Throwable -> L7
        updateActiveLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void scheduleStandbyTimeoutAlarmLocked() {
        long nextAlarmTime = this.mClock.elapsedRealtime() + ((long) this.mStandbyTimeoutConfig);
        this.mAlarmManager.setExact(2, nextAlarmTime, "LowPowerStandbyController.StandbyTimeout", this.mOnStandbyTimeoutExpired, this.mHandler);
    }

    private void cancelStandbyTimeoutAlarmLocked() {
        this.mAlarmManager.cancel(this.mOnStandbyTimeoutExpired);
    }

    private void onDeviceIdleModeChanged() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsDeviceIdle = this.mPowerManager.isDeviceIdleMode();     // Catch: Throwable -> L10
        if (this.mIdleSinceNonInteractive == true) goto L12;
        if (this.mIsDeviceIdle == true) goto L12;
        boolean r1 = false;
    L13:
        this.mIdleSinceNonInteractive = r1;     // Catch: Throwable -> L10
        updateActiveLocked();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        r1 = true;
    L10:
        th = move-exception;
        throw th;
    }

    private void onEnabledLocked() {
        if (this.mPowerManager.isInteractive() == false) goto L5;
        onInteractive();
    L6:
        registerListeners();
        return;
    L5:
        onNonInteractive();
        goto L6
    }

    private void onDisabledLocked() {
        cancelStandbyTimeoutAlarmLocked();
        unregisterListeners();
        updateActiveLocked();
    }

    void onSettingsChanged() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean oldEnabled = this.mIsEnabled;     // Catch: Throwable -> L9
        updateSettingsLocked();     // Catch: Throwable -> L9
        if (this.mIsEnabled != oldEnabled) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mIsEnabled == false) goto L11;
        onEnabledLocked();     // Catch: Throwable -> L9
    L12:
        notifyEnabledChangedLocked();     // Catch: Throwable -> L9
        goto L13
    L11:
        onDisabledLocked();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void registerListeners() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(this.mBroadcastReceiver, intentFilter);
        IntentFilter packageFilter = new IntentFilter();
        packageFilter.addDataScheme(com.android.server.pm.Settings.ATTR_PACKAGE);
        packageFilter.addAction("android.intent.action.PACKAGE_ADDED");
        packageFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        packageFilter.setPriority(1000);
        this.mContext.registerReceiver(this.mPackageBroadcastReceiver, packageFilter);
        IntentFilter userFilter = new IntentFilter();
        userFilter.addAction("android.intent.action.USER_ADDED");
        userFilter.addAction("android.intent.action.USER_REMOVED");
        this.mContext.registerReceiver(this.mUserReceiver, userFilter, null, this.mHandler);
        PowerAllowlistInternal pai = (PowerAllowlistInternal) LocalServices.getService(PowerAllowlistInternal.class);
        pai.registerTempAllowlistChangeListener(this.mTempAllowlistChangeListener);
        this.mPhoneCallServiceTracker.register();
    }

    private void unregisterListeners() {
        this.mContext.unregisterReceiver(this.mBroadcastReceiver);
        this.mContext.unregisterReceiver(this.mPackageBroadcastReceiver);
        this.mContext.unregisterReceiver(this.mUserReceiver);
        PowerAllowlistInternal pai = (PowerAllowlistInternal) LocalServices.getService(PowerAllowlistInternal.class);
        pai.unregisterTempAllowlistChangeListener(this.mTempAllowlistChangeListener);
    }

    private void notifyEnabledChangedLocked() {
        sendExplicitBroadcast("android.os.action.LOW_POWER_STANDBY_ENABLED_CHANGED");
    }

    private void enqueueNotifyPolicyChangedLocked() {
        Message msg = this.mHandler.obtainMessage(3, getPolicy());
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis());
    }

    private void notifyPolicyChanged(PowerManager.LowPowerStandbyPolicy policy) {
        sendExplicitBroadcast("android.os.action.LOW_POWER_STANDBY_POLICY_CHANGED");
    }

    private void onStandbyTimeoutExpired() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        updateActiveLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void sendExplicitBroadcast(String intentType) {
        Intent intent = new Intent(intentType);
        intent.addFlags(1342177280);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL);
        Intent privilegedIntent = new Intent(intentType);
        privilegedIntent.addFlags(268435456);
        Iterator<String> r2 = this.mLowPowerStandbyManagingPackages.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String packageName = r2.next();
        Intent explicitIntent = new Intent(privilegedIntent);
        explicitIntent.setPackage(packageName);
        this.mContext.sendBroadcastAsUser(explicitIntent, UserHandle.ALL, "android.permission.MANAGE_LOW_POWER_STANDBY");
        goto L4
    }

    private void enqueueNotifyActiveChangedLocked() {
        Message msg = this.mHandler.obtainMessage(1, Boolean.valueOf(this.mIsActive));
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis());
    }

    private void notifyActiveChanged(boolean active) {
        PowerManagerInternal pmi = (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);
        NetworkPolicyManagerInternal npmi = (NetworkPolicyManagerInternal) LocalServices.getService(NetworkPolicyManagerInternal.class);
        pmi.setLowPowerStandbyActive(active);
        npmi.setLowPowerStandbyActive(active);
    }

    boolean isActive() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mIsActive;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isSupported() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mSupportedConfig;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSupportedConfig == true) goto L7;
    L11:
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L7:
        if (this.mIsEnabled == false) goto L11;
        r1 = true;
        goto L12
    }

    void setEnabled(boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSupportedConfig == true) goto L11;
        Slog.w(TAG, "Low Power Standby cannot be enabled because it is not supported on this device");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        ContentResolver r1 = this.mContext.getContentResolver();     // Catch: Throwable -> L9
        if (enabled == false) goto L14;
        int r3 = 1;
    L15:
        Settings.Global.putInt(r1, "low_power_standby_enabled", r3);     // Catch: Throwable -> L9
        onSettingsChanged();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        r3 = 0;
        goto L15
    }

    public void setActiveDuringMaintenance(boolean activeDuringMaintenance) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSupportedConfig == true) goto L11;
        Slog.w(TAG, "Low Power Standby settings cannot be changed because it is not supported on this device");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        ContentResolver r1 = this.mContext.getContentResolver();     // Catch: Throwable -> L9
        if (activeDuringMaintenance == false) goto L14;
        int r3 = 1;
    L15:
        Settings.Global.putInt(r1, "low_power_standby_active_during_maintenance", r3);     // Catch: Throwable -> L9
        onSettingsChanged();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        r3 = 0;
        goto L15
    }

    void forceActive(boolean active) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mForceActive = active;     // Catch: Throwable -> L7
        updateActiveLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setPolicy(PowerManager.LowPowerStandbyPolicy policy) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSupportedConfig == true) goto L12;
        Slog.w(TAG, "Low Power Standby policy cannot be changed because it is not supported on this device");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (this.mEnableCustomPolicy == true) goto L17;
        Slog.d(TAG, "Custom policies are not enabled.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L17:
        if (Objects.equals(this.mPolicy, policy) == false) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L20:
        boolean allowlistChanged = policyChangeAffectsAllowlistLocked(this.mPolicy, policy);     // Catch: Throwable -> L9
        this.mPolicy = policy;     // Catch: Throwable -> L9
        enqueueSavePolicy(this.mPolicy);     // Catch: Throwable -> L9
        if (allowlistChanged == false) goto L23;
        enqueueNotifyAllowlistChangedLocked();     // Catch: Throwable -> L9
    L23:
        enqueueNotifyPolicyChangedLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    PowerManager.LowPowerStandbyPolicy getPolicy() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSupportedConfig == true) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L12:
        if (this.mEnableCustomPolicy == false) goto L16;
        PowerManager.LowPowerStandbyPolicy r1 = policyOrDefault(this.mPolicy);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L16:
        PowerManager.LowPowerStandbyPolicy r2 = DEFAULT_POLICY;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    }

    private PowerManager.LowPowerStandbyPolicy policyOrDefault(PowerManager.LowPowerStandbyPolicy policy) {
        if (policy == null) goto L4;
        return policy;
    L4:
        return DEFAULT_POLICY;
    }

    boolean isPackageExempt(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isEnabled() == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    L11:
        boolean r1 = getExemptPackageAppIdsLocked().contains(Integer.valueOf(UserHandle.getAppId(uid)));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    }

    boolean isAllowed(int reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = true;
        if (isEnabled() == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L11:
        if ((getPolicy().getAllowedReasons() & reason) != 0) goto L14;
        r2 = false;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    boolean isAllowed(String feature) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = true;
        if (this.mSupportedConfig == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L11:
        if (isEnabled() == false) goto L16;
        if (getPolicy().getAllowedFeatures().contains(feature) == true) goto L16;
        r2 = false;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    private int findIndexOfStandbyPorts(IBinder token) {
        int i = 0;
    L4:
        if (i >= this.mStandbyPortLocks.size()) goto L9;
        if (this.mStandbyPortLocks.get(i).getToken() == token) goto L7;
        i = i + 1;
        goto L4
    L7:
        return i;
    L9:
        return -1;
    }

    void acquireStandbyPorts(IBinder token, int uid, List<PowerManager.LowPowerStandbyPortDescription> ports) {
        validatePorts(ports);
        StandbyPortsLock standbyPortsLock = new StandbyPortsLock(this, token, uid, ports);
        Object r1 = this.mLock;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (findIndexOfStandbyPorts(token) == (-1)) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L11:
        if (standbyPortsLock.linkToDeath() == false) goto L19;
        this.mStandbyPortLocks.add(standbyPortsLock);     // Catch: Throwable -> L8
        if (this.mEnableStandbyPorts == false) goto L19;
        if (isEnabled() == false) goto L19;
        if (isPackageExempt(uid) == false) goto L19;
        enqueueNotifyStandbyPortsChangedLocked();     // Catch: Throwable -> L8
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L8
    }

    void validatePorts(List<PowerManager.LowPowerStandbyPortDescription> ports) {
        Iterator<PowerManager.LowPowerStandbyPortDescription> r0 = ports.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        PowerManager.LowPowerStandbyPortDescription portDescription = r0.next();
        int port = portDescription.getPortNumber();
        if (port < 0) goto L11;
        if (port <= 65535) goto L4;
    L11:
        throw new IllegalArgumentException("port out of range:" + port);
    }

    void releaseStandbyPorts(IBinder token) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int index = findIndexOfStandbyPorts(token);     // Catch: Throwable -> L8
        if (index != (-1)) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        StandbyPortsLock standbyPortsLock = this.mStandbyPortLocks.remove(index);     // Catch: Throwable -> L8
        standbyPortsLock.unlinkToDeath();     // Catch: Throwable -> L8
        if (this.mEnableStandbyPorts == true) goto L13;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        if (isEnabled() == false) goto L17;
        if (isPackageExempt(standbyPortsLock.getUid()) == false) goto L17;
        enqueueNotifyStandbyPortsChangedLocked();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    List<PowerManager.LowPowerStandbyPortDescription> getActiveStandbyPorts() {
        List<PowerManager.LowPowerStandbyPortDescription> activeStandbyPorts = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (isEnabled() == false) goto L20;
        if (this.mEnableStandbyPorts == false) goto L20;
        List<Integer> exemptPackageAppIds = getExemptPackageAppIdsLocked();     // Catch: Throwable -> L15
        Iterator<StandbyPortsLock> r3 = this.mStandbyPortLocks.iterator();     // Catch: Throwable -> L15
    L11:
        if (r3.hasNext() == false) goto L18;
        StandbyPortsLock standbyPortsLock = r3.next();     // Catch: Throwable -> L15
        int standbyPortsAppid = UserHandle.getAppId(standbyPortsLock.getUid());     // Catch: Throwable -> L15
        if (exemptPackageAppIds.contains(Integer.valueOf(standbyPortsAppid)) == false) goto L11;
        activeStandbyPorts.addAll(standbyPortsLock.getPorts());     // Catch: Throwable -> L15
        goto L11
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return activeStandbyPorts;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return activeStandbyPorts;
    }

    private boolean policyChangeAffectsAllowlistLocked(PowerManager.LowPowerStandbyPolicy oldPolicy, PowerManager.LowPowerStandbyPolicy newPolicy) {
        PowerManager.LowPowerStandbyPolicy policyA = policyOrDefault(oldPolicy);
        PowerManager.LowPowerStandbyPolicy policyB = policyOrDefault(newPolicy);
        int allowedReasonsInUse = 0;
        int i = 0;
    L4:
        if (i >= this.mUidAllowedReasons.size()) goto L6;
        allowedReasonsInUse = allowedReasonsInUse | this.mUidAllowedReasons.valueAt(i);
        i = i + 1;
        goto L4
    L6:
        int i2 = policyA.getAllowedReasons();
        int policyAllowedReasonsChanged = i2 ^ policyB.getAllowedReasons();
        boolean exemptPackagesChanged = !policyA.getExemptPackages().equals(policyB.getExemptPackages());
        if ((policyAllowedReasonsChanged & allowedReasonsInUse) != 0) goto L13;
        if (exemptPackagesChanged == true) goto L14;
        return false;
    L14:
        return true;
    L13:
        return true;
    }

    void dump(PrintWriter pw) {
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");
        ipw.println();
        ipw.println("Low Power Standby Controller:");
        ipw.increaseIndent();
        Object r1 = this.mLock;
        monitor-enter(r1);
        ipw.print("mIsActive=");     // Catch: Throwable -> L9
        ipw.println(this.mIsActive);     // Catch: Throwable -> L9
        ipw.print("mIsEnabled=");     // Catch: Throwable -> L9
        ipw.println(this.mIsEnabled);     // Catch: Throwable -> L9
        ipw.print("mSupportedConfig=");     // Catch: Throwable -> L9
        ipw.println(this.mSupportedConfig);     // Catch: Throwable -> L9
        ipw.print("mEnabledByDefaultConfig=");     // Catch: Throwable -> L9
        ipw.println(this.mEnabledByDefaultConfig);     // Catch: Throwable -> L9
        ipw.print("mStandbyTimeoutConfig=");     // Catch: Throwable -> L9
        ipw.println(this.mStandbyTimeoutConfig);     // Catch: Throwable -> L9
        ipw.print("mEnableCustomPolicy=");     // Catch: Throwable -> L9
        ipw.println(this.mEnableCustomPolicy);     // Catch: Throwable -> L9
        if (this.mIsActive == true) goto L11;
        if (this.mIsEnabled == true) goto L11;
    L12:
        int[] allowlistUids = getAllowlistUidsLocked();     // Catch: Throwable -> L9
        ipw.print("Allowed UIDs=");     // Catch: Throwable -> L9
        ipw.println(Arrays.toString(allowlistUids));     // Catch: Throwable -> L9
        PowerManager.LowPowerStandbyPolicy policy = getPolicy();     // Catch: Throwable -> L9
        if (policy == null) goto L15;
        ipw.println();     // Catch: Throwable -> L9
        ipw.println("mPolicy:");     // Catch: Throwable -> L9
        ipw.increaseIndent();     // Catch: Throwable -> L9
        ipw.print("mIdentifier=");     // Catch: Throwable -> L9
        ipw.println(policy.getIdentifier());     // Catch: Throwable -> L9
        ipw.print("mExemptPackages=");     // Catch: Throwable -> L9
        ipw.println(String.join(",", policy.getExemptPackages()));     // Catch: Throwable -> L9
        ipw.print("mAllowedReasons=");     // Catch: Throwable -> L9
        ipw.println(PowerManager.lowPowerStandbyAllowedReasonsToString(policy.getAllowedReasons()));     // Catch: Throwable -> L9
        ipw.print("mAllowedFeatures=");     // Catch: Throwable -> L9
        ipw.println(String.join(",", policy.getAllowedFeatures()));     // Catch: Throwable -> L9
        ipw.decreaseIndent();     // Catch: Throwable -> L9
    L15:
        ipw.println();     // Catch: Throwable -> L9
        ipw.println("UID allowed reasons:");     // Catch: Throwable -> L9
        ipw.increaseIndent();     // Catch: Throwable -> L9
        int i = 0;
    L17:
        if (i >= this.mUidAllowedReasons.size()) goto L22;
        if (this.mUidAllowedReasons.valueAt(i) <= 0) goto L21;
        ipw.print(this.mUidAllowedReasons.keyAt(i));     // Catch: Throwable -> L9
        ipw.print(": ");     // Catch: Throwable -> L9
        ipw.println(PowerManager.lowPowerStandbyAllowedReasonsToString(this.mUidAllowedReasons.valueAt(i)));     // Catch: Throwable -> L9
    L21:
        i = i + 1;     // Catch: Throwable -> L9
        goto L17
    L22:
        ipw.decreaseIndent();     // Catch: Throwable -> L9
        List<PowerManager.LowPowerStandbyPortDescription> activeStandbyPorts = getActiveStandbyPorts();     // Catch: Throwable -> L9
        if (activeStandbyPorts.isEmpty() == true) goto L29;
        ipw.println();     // Catch: Throwable -> L9
        ipw.println("Active standby ports locks:");     // Catch: Throwable -> L9
        ipw.increaseIndent();     // Catch: Throwable -> L9
        Iterator<PowerManager.LowPowerStandbyPortDescription> r5 = activeStandbyPorts.iterator();     // Catch: Throwable -> L9
    L26:
        if (r5.hasNext() == false) goto L28;
        PowerManager.LowPowerStandbyPortDescription portDescription = r5.next();     // Catch: Throwable -> L9
        ipw.print(portDescription.toString());     // Catch: Throwable -> L9
        goto L26
    L28:
        ipw.decreaseIndent();     // Catch: Throwable -> L9
    L29:
        monitor-exit(r1);     // Catch: Throwable -> L9
        ipw.decreaseIndent();
        return;
    L11:
        ipw.print("mIsInteractive=");     // Catch: Throwable -> L9
        ipw.println(this.mIsInteractive);     // Catch: Throwable -> L9
        ipw.print("mLastInteractiveTime=");     // Catch: Throwable -> L9
        ipw.println(this.mLastInteractiveTimeElapsed);     // Catch: Throwable -> L9
        ipw.print("mIdleSinceNonInteractive=");     // Catch: Throwable -> L9
        ipw.println(this.mIdleSinceNonInteractive);     // Catch: Throwable -> L9
        ipw.print("mIsDeviceIdle=");     // Catch: Throwable -> L9
        ipw.println(this.mIsDeviceIdle);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    void dumpProto(ProtoOutputStream proto, long tag) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long token = proto.start(tag);     // Catch: Throwable -> L7
        proto.write(1133871366145L, this.mIsActive);     // Catch: Throwable -> L7
        proto.write(1133871366146L, this.mIsEnabled);     // Catch: Throwable -> L7
        proto.write(1133871366147L, this.mSupportedConfig);     // Catch: Throwable -> L7
        proto.write(1133871366148L, this.mEnabledByDefaultConfig);     // Catch: Throwable -> L7
        proto.write(1133871366149L, this.mIsInteractive);     // Catch: Throwable -> L7
        proto.write(1112396529670L, this.mLastInteractiveTimeElapsed);     // Catch: Throwable -> L7
        proto.write(1120986464263L, this.mStandbyTimeoutConfig);     // Catch: Throwable -> L7
        proto.write(1133871366152L, this.mIdleSinceNonInteractive);     // Catch: Throwable -> L7
        proto.write(1133871366153L, this.mIsDeviceIdle);     // Catch: Throwable -> L7
        int[] allowlistUids = getAllowlistUidsLocked();     // Catch: Throwable -> L7
        int r4 = allowlistUids.length;     // Catch: Throwable -> L7
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L9;
        int appId = allowlistUids[r5];     // Catch: Throwable -> L7
        proto.write(2220498092042L, appId);     // Catch: Throwable -> L7
        r5 = r5 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        PowerManager.LowPowerStandbyPolicy policy = getPolicy();     // Catch: Throwable -> L7
        if (policy == null) goto L20;
        long policyToken = proto.start(1146756268043L);     // Catch: Throwable -> L7
        proto.write(1138166333441L, policy.getIdentifier());     // Catch: Throwable -> L7
        Iterator r7 = policy.getExemptPackages().iterator();     // Catch: Throwable -> L7
    L13:
        if (r7.hasNext() == false) goto L15;
        String exemptPackage = (String) r7.next();     // Catch: Throwable -> L7
        proto.write(2237677961218L, exemptPackage);     // Catch: Throwable -> L7
        goto L13
    L15:
        proto.write(1120986464259L, policy.getAllowedReasons());     // Catch: Throwable -> L7
        Iterator r8 = policy.getAllowedFeatures().iterator();     // Catch: Throwable -> L7
    L17:
        if (r8.hasNext() == false) goto L19;
        String feature = (String) r8.next();     // Catch: Throwable -> L7
        proto.write(2237677961220L, feature);     // Catch: Throwable -> L7
        goto L17
    L19:
        proto.end(policyToken);     // Catch: Throwable -> L7
    L20:
        proto.end(token);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean hasAllowedReasonLocked(int uid, int allowedReason) {
        int allowedReasons = this.mUidAllowedReasons.get(uid);
        if ((allowedReasons & allowedReason) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean addAllowedReasonLocked(int uid, int allowedReason) {
        int allowedReasons = this.mUidAllowedReasons.get(uid);
        int newAllowReasons = allowedReasons | allowedReason;
        this.mUidAllowedReasons.put(uid, newAllowReasons);
        if (allowedReasons == newAllowReasons) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean removeAllowedReasonLocked(int uid, int allowedReason) {
        int allowedReasons = this.mUidAllowedReasons.get(uid);
        if (allowedReasons != 0) goto L5;
        return false;
    L5:
        int newAllowedReasons = (~allowedReason) & allowedReasons;
        if (newAllowedReasons != 0) goto L8;
        this.mUidAllowedReasons.removeAt(this.mUidAllowedReasons.indexOfKey(uid));
    L9:
        if (allowedReasons == newAllowedReasons) goto L12;
        return true;
    L12:
        return false;
    L8:
        this.mUidAllowedReasons.put(uid, newAllowedReasons);
        goto L9
    }

    private void addToAllowlistInternal(int uid, int allowedReason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mSupportedConfig == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        if (allowedReason != 0) goto L12;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L12:
        if (hasAllowedReasonLocked(uid, allowedReason) == true) goto L16;
        addAllowedReasonLocked(uid, allowedReason);     // Catch: Throwable -> L8
        if ((getPolicy().getAllowedReasons() & allowedReason) == 0) goto L16;
        enqueueNotifyAllowlistChangedLocked();     // Catch: Throwable -> L8
        goto L16
    }

    private void removeFromAllowlistInternal(int uid, int allowedReason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mSupportedConfig == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        if (allowedReason != 0) goto L12;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L12:
        if (hasAllowedReasonLocked(uid, allowedReason) == false) goto L16;
        removeAllowedReasonLocked(uid, allowedReason);     // Catch: Throwable -> L8
        if ((getPolicy().getAllowedReasons() & allowedReason) == 0) goto L16;
        enqueueNotifyAllowlistChangedLocked();     // Catch: Throwable -> L8
        goto L16
    }

    private List<Integer> getExemptPackageAppIdsLocked() {
        PackageManager packageManager = this.mContext.getPackageManager();
        PowerManager.LowPowerStandbyPolicy policy = getPolicy();
        List<Integer> appIds = new ArrayList();
        if (policy != null) goto L5;
        return appIds;
    L5:
        Iterator r3 = policy.getExemptPackages().iterator();
    L7:
        if (r3.hasNext() == false) goto L13;
        String packageName = (String) r3.next();
        int packageUid = packageManager.getPackageUid(packageName, PackageManager.PackageInfoFlags.of(0));     // Catch: PackageManager.NameNotFoundException -> L11
        int appId = UserHandle.getAppId(packageUid);     // Catch: PackageManager.NameNotFoundException -> L11
        appIds.add(Integer.valueOf(appId));     // Catch: PackageManager.NameNotFoundException -> L11
        goto L7
    L13:
        return appIds;
    }

    private int[] getAllowlistUidsLocked() {
        List userHandles = ((UserManager) this.mContext.getSystemService(UserManager.class)).getUserHandles(true);
        ArraySet<Integer> uids = new ArraySet(this.mUidAllowedReasons.size());
        PowerManager.LowPowerStandbyPolicy policy = getPolicy();
        if (policy == null) goto L5;
        int policyAllowedReasons = policy.getAllowedReasons();
        int i = 0;
    L8:
        if (i >= this.mUidAllowedReasons.size()) goto L13;
        Integer uid = Integer.valueOf(this.mUidAllowedReasons.keyAt(i));
        if ((this.mUidAllowedReasons.valueAt(i) & policyAllowedReasons) == 0) goto L12;
        uids.add(uid);
    L12:
        i = i + 1;
        goto L8
    L13:
        Iterator<Integer> r6 = getExemptPackageAppIdsLocked().iterator();
    L15:
        if (r6.hasNext() == false) goto L21;
        int appId = r6.next().intValue();
        int[] r8 = uidsForAppId(appId, userHandles);
        int r9 = r8.length;
        int r10 = 0;
    L18:
        if (r10 >= r9) goto L15;
        int uid2 = r8[r10];
        uids.add(Integer.valueOf(uid2));
        r10 = r10 + 1;
        goto L18
    L21:
        int[] allowlistUids = new int[uids.size()];
        int i2 = 0;
    L23:
        if (i2 >= uids.size()) goto L25;
        allowlistUids[i2] = uids.valueAt(i2).intValue();
        i2 = i2 + 1;
        goto L23
    L25:
        Arrays.sort(allowlistUids);
        return allowlistUids;
    L5:
        return new int[0];
    }

    private int[] uidsForAppId(int appUid, List<UserHandle> userHandles) {
        int appId = UserHandle.getAppId(appUid);
        int[] uids = new int[userHandles.size()];
        int i = 0;
    L4:
        if (i >= userHandles.size()) goto L7;
        uids[i] = userHandles.get(i).getUid(appId);
        i = i + 1;
        goto L4
    L7:
        return uids;
    }

    private void enqueueNotifyAllowlistChangedLocked() {
        int[] allowlistUids = getAllowlistUidsLocked();
        Message msg = this.mHandler.obtainMessage(2, allowlistUids);
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis());
    }

    private void notifyAllowlistChanged(int[] allowlistUids) {
        PowerManagerInternal pmi = (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);
        NetworkPolicyManagerInternal npmi = (NetworkPolicyManagerInternal) LocalServices.getService(NetworkPolicyManagerInternal.class);
        pmi.setLowPowerStandbyAllowlist(allowlistUids);
        npmi.setLowPowerStandbyAllowlist(allowlistUids);
    }

    private void enqueueNotifyStandbyPortsChangedLocked() {
        Message msg = this.mHandler.obtainMessage(5);
        this.mHandler.sendMessageAtTime(msg, this.mClock.uptimeMillis());
    }

    private void notifyStandbyPortsChanged() {
        sendExplicitBroadcast("android.os.action.LOW_POWER_STANDBY_PORTS_CHANGED");
    }
}
