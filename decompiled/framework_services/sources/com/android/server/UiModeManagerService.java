package com.android.server;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.app.ActivityThread;
import android.app.AlarmManager;
import android.app.IOnProjectionStateChangedListener;
import android.app.IUiModeManager;
import android.app.IUiModeManagerCallback;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.StatusBarManager;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.PermissionEnforcer;
import android.os.PowerManager;
import android.os.PowerManagerInternal;
import android.os.PowerSaveState;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.ShellCommand;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.dreams.DreamManagerInternal;
import android.service.dreams.Sandman;
import android.service.vr.IVrManager;
import android.service.vr.IVrStateCallbacks;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TimeUtils;
import com.android.internal.app.DisableCarModeActivity;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FunctionalUtils;
import com.android.server.am.HostingRecord;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import com.android.server.pm.UserManagerService;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.twilight.TwilightListener;
import com.android.server.twilight.TwilightManager;
import com.android.server.twilight.TwilightState;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.WindowManagerInternal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class UiModeManagerService extends SystemService {
    private static final boolean ENABLE_LAUNCH_DESK_DOCK_APP = true;
    private static final boolean LOG = false;
    public static final Set<Integer> SUPPORTED_NIGHT_MODE_CUSTOM_TYPES = null;
    private static final String SYSTEM_PROPERTY_DEVICE_THEME = "persist.sys.theme";
    private static final String TAG = null;
    private final LocalTime DEFAULT_CUSTOM_NIGHT_END_TIME;
    private final LocalTime DEFAULT_CUSTOM_NIGHT_START_TIME;
    private ActivityTaskManagerInternal mActivityTaskManager;
    private AlarmManager mAlarmManager;
    private int mAttentionModeThemeOverlay;
    private final BroadcastReceiver mBatteryReceiver;
    private boolean mCar;
    private int mCarModeEnableFlags;
    private boolean mCarModeEnabled;
    private boolean mCarModeKeepsScreenOn;
    private Map<Integer, String> mCarModePackagePriority;
    private boolean mCharging;
    private boolean mComputedNightMode;
    private Configuration mConfiguration;
    private final ContentObserver mContrastObserver;
    private final SparseArray<Float> mContrasts;
    private final IntProperty mCurUiMode;
    private int mCurrentUser;
    private LocalTime mCustomAutoNightModeEndMilliseconds;
    private LocalTime mCustomAutoNightModeStartMilliseconds;
    private final AlarmManager.OnAlarmListener mCustomTimeListener;
    private final ContentObserver mDarkThemeObserver;
    private int mDefaultUiModeType;
    private boolean mDeskModeKeepsScreenOn;
    private final BroadcastReceiver mDeviceInactiveListener;
    private final BroadcastReceiver mDockModeReceiver;
    private int mDockState;
    private DreamManagerInternal mDreamManagerInternal;
    private boolean mDreamsDisabledByAmbientModeSuppression;
    private boolean mEnableCarDockLaunch;
    private final ContentObserver mForceInvertStateObserver;
    private final SparseIntArray mForceInvertStates;
    private final Handler mHandler;
    private boolean mHoldingConfiguration;
    private final Injector mInjector;
    private KeyguardManager mKeyguardManager;
    private boolean mLastBedtimeRequestedNightMode;
    private int mLastBroadcastState;
    private PowerManagerInternal mLocalPowerManager;
    private final LocalService mLocalService;
    private final Object mLock;
    private final IntProperty mNightMode;
    private int mNightModeCustomType;
    private boolean mNightModeLocked;
    private NotificationManager mNotificationManager;
    private final BroadcastReceiver mOnShutdown;
    private final BroadcastReceiver mOnTimeChangedHandler;
    private boolean mOverrideNightModeOff;
    private boolean mOverrideNightModeOn;
    private int mOverrideNightModeUser;
    private boolean mPendingResetNightModeOverrideByAutoBoundary;
    private int mPendingResetNightModeOverrideUser;
    private PowerManager mPowerManager;
    private boolean mPowerSave;
    private SparseArray<List<ProjectionHolder>> mProjectionHolders;
    private SparseArray<RemoteCallbackList<IOnProjectionStateChangedListener>> mProjectionListeners;
    private final BroadcastReceiver mResultReceiver;
    private final IUiModeManager.Stub mService;
    private int mSetUiMode;
    private final BroadcastReceiver mSettingsRestored;
    private boolean mSetupWizardComplete;
    private final ContentObserver mSetupWizardObserver;
    private boolean mStartDreamImmediatelyOnDock;
    private StatusBarManager mStatusBarManager;
    boolean mSystemReady;
    private boolean mTelevision;
    private final TwilightListener mTwilightListener;
    private TwilightManager mTwilightManager;
    private boolean mUiModeLocked;
    private final SparseArray<RemoteCallbackList<IUiModeManagerCallback>> mUiModeManagerCallbacks;
    private boolean mVrHeadset;
    private final IVrStateCallbacks mVrStateCallbacks;
    private boolean mWaitForDeviceInactive;
    private PowerManager.WakeLock mWakeLock;
    private boolean mWatch;
    private WindowManagerInternal mWindowManager;

    /* JADX INFO: renamed from: com.android.server.UiModeManagerService$13, reason: invalid class name */
    class AnonymousClass13 extends ContentObserver {
        final /* synthetic */ UiModeManagerService this$0;

        public static /* synthetic */ void $r8$lambda$ys18d2agJvlqFbRzoCxb7TIjBdM(float r0, IUiModeManagerCallback r1) {
            lambda$onChange$0(r0, r1);
        }

        AnonymousClass13(UiModeManagerService this$0, Handler handler) {
            this.this$0 = this$0;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            Object r0 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (UiModeManagerService.m487$$Nest$mupdateContrastLocked(this.this$0) == false) goto L9;
            final float contrast = UiModeManagerService.m471$$Nest$mgetContrastLocked(this.this$0);     // Catch: Throwable -> L7
            ((RemoteCallbackList) UiModeManagerService.m451$$Nest$fgetmUiModeManagerCallbacks(this.this$0).get(UiModeManagerService.m438$$Nest$fgetmCurrentUser(this.this$0), new RemoteCallbackList())).broadcast(FunctionalUtils.ignoreRemoteException(new UiModeManagerService$13$$ExternalSyntheticLambda0(contrast)));     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        private static /* synthetic */ void lambda$onChange$0(float contrast, IUiModeManagerCallback callback) throws RemoteException {
            callback.notifyContrastChanged(contrast);
        }
    }

    public static class Injector {
        public Injector() {
        }

        public int getCallingUid() {
            return Binder.getCallingUid();
        }

        public void startDreamWhenDockedIfAppropriate(Context context) {
            Sandman.startDreamWhenDockedIfAppropriate(context);
        }
    }

    private interface IntProperty {
        int get();

        void set(int r1);
    }

    public final class LocalService extends UiModeManagerInternal {
        final /* synthetic */ UiModeManagerService this$0;

        public LocalService(UiModeManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.UiModeManagerInternal
        public boolean isNightMode() {
            Object r0 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if ((UiModeManagerService.m436$$Nest$fgetmConfiguration(this.this$0).uiMode & 32) == 0) goto L7;
            boolean isIt = true;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return isIt;
        L7:
            isIt = false;
            goto L8
        }
    }

    private static class ProjectionHolder implements IBinder.DeathRecipient {
        private final IBinder mBinder;
        private final String mPackageName;
        private final ProjectionReleaser mProjectionReleaser;
        private final int mProjectionType;

        private interface ProjectionReleaser {
            boolean release(int r1, String r2);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPackageName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m497$$Nest$fgetmPackageName(ProjectionHolder r0) {
            return r0.mPackageName;
        }

        /* JADX INFO: renamed from: -$$Nest$mlinkToDeath, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m498$$Nest$mlinkToDeath(ProjectionHolder r0) {
            return r0.linkToDeath();
        }

        /* JADX INFO: renamed from: -$$Nest$munlinkToDeath, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m499$$Nest$munlinkToDeath(ProjectionHolder r0) {
            r0.unlinkToDeath();
        }

        /* synthetic */ ProjectionHolder(String r1, int r2, IBinder r3, ProjectionReleaser r4, UiModeManagerServiceIA r5) {
            this(r1, r2, r3, r4);
        }

        private ProjectionHolder(String packageName, int projectionType, IBinder binder, ProjectionReleaser projectionReleaser) {
            this.mPackageName = packageName;
            this.mProjectionType = projectionType;
            this.mBinder = binder;
            this.mProjectionReleaser = projectionReleaser;
        }

        private boolean linkToDeath() {
            this.mBinder.linkToDeath(this, 0);     // Catch: RemoteException -> L6
            return true;
        L6:
            e = move-exception;
            Slog.e(UiModeManagerService.m493$$Nest$sfgetTAG(), "linkToDeath failed for projection requester: " + this.mPackageName + ".", e);
            return false;
        }

        private void unlinkToDeath() {
            this.mBinder.unlinkToDeath(this, 0);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Slog.w(UiModeManagerService.m493$$Nest$sfgetTAG(), "Projection holder " + this.mPackageName + " died. Releasing projection type " + this.mProjectionType + ".");
            this.mProjectionReleaser.release(this.mProjectionType, this.mPackageName);
        }
    }

    private static class Shell extends ShellCommand {
        public static final String NIGHT_MODE_STR_AUTO = "auto";
        public static final String NIGHT_MODE_STR_CUSTOM_BEDTIME = "custom_bedtime";
        public static final String NIGHT_MODE_STR_CUSTOM_SCHEDULE = "custom_schedule";
        public static final String NIGHT_MODE_STR_NO = "no";
        public static final String NIGHT_MODE_STR_UNKNOWN = "unknown";
        public static final String NIGHT_MODE_STR_YES = "yes";
        private final IUiModeManager mInterface;

        /* JADX INFO: renamed from: -$$Nest$smnightModeToStr, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m500$$Nest$smnightModeToStr(int r0, int r1) {
            return nightModeToStr(r0, r1);
        }

        Shell(IUiModeManager iface) {
            this.mInterface = iface;
        }

        public void onHelp() {
            PrintWriter pw = getOutPrintWriter();
            pw.println("UiModeManager service (uimode) commands:");
            pw.println("  help");
            pw.println("    Print this help text.");
            pw.println("  night [yes|no|auto|custom_schedule|custom_bedtime]");
            pw.println("    Set or read night mode.");
            pw.println("  car [yes|no]");
            pw.println("    Set or read car mode.");
            pw.println("  time [start|end] <ISO time>");
            pw.println("    Set custom start/end schedule time (night mode must be set to custom to apply).");
        }

        public int onCommand(String cmd) {
            if (cmd != null) goto L32;
            return handleDefaultCommands(cmd);
        L32:
        L12:
            e = move-exception;
            PrintWriter err = getErrPrintWriter();
            err.println("Remote exception: " + e);
            return -1;
        L7:
            switch(cmd.hashCode()) {
                case 98260: goto L18;
                case 3560141: goto L15;
                case 104817688: goto L10;
                default: goto L20;
            };     // Catch: RemoteException -> L12
        L20:
            byte r1 = -1;
        L21:
            switch(r1) {
                case 0: goto L29;
                case 1: goto L27;
                case 2: goto L25;
                default: goto L23;
            };     // Catch: RemoteException -> L12
        L23:
            return handleDefaultCommands(cmd);
        L25:
            return handleCustomTime();
        L27:
            return handleCarMode();
        L29:
            return handleNightMode();
        L10:
            if (cmd.equals("night") == false) goto L20;
            r1 = 0;
            goto L21
        L15:
            if (cmd.equals("time") == false) goto L20;
            r1 = 2;
            goto L21
        L18:
            if (cmd.equals("car") == false) goto L20;
            r1 = 1;
            goto L21
        }

        private int handleCustomTime() throws RemoteException {
            String modeStr = getNextArg();
            if (modeStr != null) goto L7;
            printCustomTime();
            return 0;
        L7:
            switch(modeStr.hashCode()) {
                case 100571: goto L13;
                case 109757538: goto L10;
                default: goto L15;
            };
        L15:
            byte r2 = -1;
        L16:
            switch(r2) {
                case 0: goto L21;
                case 1: goto L19;
                default: goto L17;
            };
        L17:
            getErrPrintWriter().println("command must be in [start|end]");
            return -1;
        L19:
            String end = getNextArg();
            this.mInterface.setCustomNightModeEnd(UiModeManagerService.m496$$Nest$smtoMilliSeconds(LocalTime.parse(end)));
            return 0;
        L21:
            String start = getNextArg();
            this.mInterface.setCustomNightModeStart(UiModeManagerService.m496$$Nest$smtoMilliSeconds(LocalTime.parse(start)));
            return 0;
        L10:
            if (modeStr.equals(IMediaProjectionManagerServiceExt.NODE_START) == false) goto L23;
            r2 = 0;
            goto L16
        L23:
            r2 = -1;
            goto L16
        L13:
            if (modeStr.equals("end") == false) goto L24;
            r2 = 1;
            goto L16
        L24:
            r2 = -1;
            goto L16
        }

        private void printCustomTime() throws RemoteException {
            getOutPrintWriter().println("start " + UiModeManagerService.m495$$Nest$smfromMilliseconds(this.mInterface.getCustomNightModeStart()).toString());
            getOutPrintWriter().println("end " + UiModeManagerService.m495$$Nest$smfromMilliseconds(this.mInterface.getCustomNightModeEnd()).toString());
        }

        private int handleNightMode() throws RemoteException {
            PrintWriter err = getErrPrintWriter();
            String modeStr = getNextArg();
            if (modeStr != null) goto L6;
            printCurrentNightMode();
            return 0;
        L6:
            int mode = strToNightMode(modeStr);
            int customType = strToNightModeCustomType(modeStr);
            if (mode < 0) goto L13;
            this.mInterface.setNightMode(mode);
            if (mode != 3) goto L11;
            this.mInterface.setNightModeCustomType(customType);
        L11:
            printCurrentNightMode();
            return 0;
        L13:
            err.println("Error: mode must be 'yes', 'no', or 'auto', or 'custom_schedule', or 'custom_bedtime'");
            return -1;
        }

        private void printCurrentNightMode() throws RemoteException {
            PrintWriter pw = getOutPrintWriter();
            int currMode = this.mInterface.getNightMode();
            int customType = this.mInterface.getNightModeCustomType();
            String currModeStr = nightModeToStr(currMode, customType);
            pw.println("Night mode: " + currModeStr);
        }

        private static String nightModeToStr(int mode, int customType) {
            switch(mode) {
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L13;
                case 3: goto L4;
                default: goto L19;
            };
        L4:
            if (customType != 0) goto L8;
            return NIGHT_MODE_STR_CUSTOM_SCHEDULE;
        L8:
            if (customType != 1) goto L11;
            return NIGHT_MODE_STR_CUSTOM_BEDTIME;
        L11:
            return "unknown";
        L13:
            return NIGHT_MODE_STR_YES;
        L15:
            return NIGHT_MODE_STR_NO;
        L17:
            return NIGHT_MODE_STR_AUTO;
        L19:
            return "unknown";
        }

        private static int strToNightMode(String modeStr) {
            switch(modeStr.hashCode()) {
                case -757868544: goto L18;
                case 3521: goto L15;
                case 119527: goto L12;
                case 3005871: goto L9;
                case 164399013: goto L6;
                default: goto L20;
            };
        L20:
            byte r0 = -1;
        L21:
            switch(r0) {
                case 0: goto L26;
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L23;
                default: goto L22;
            };
        L22:
            return -1;
        L23:
            return 3;
        L24:
            return 0;
        L25:
            return 1;
        L26:
            return 2;
        L6:
            if (modeStr.equals(NIGHT_MODE_STR_CUSTOM_SCHEDULE) == false) goto L27;
            r0 = 3;
            goto L21
        L27:
            r0 = -1;
            goto L21
        L9:
            if (modeStr.equals(NIGHT_MODE_STR_AUTO) == false) goto L28;
            r0 = 2;
            goto L21
        L28:
            r0 = -1;
            goto L21
        L12:
            if (modeStr.equals(NIGHT_MODE_STR_YES) == false) goto L29;
            r0 = 0;
            goto L21
        L29:
            r0 = -1;
            goto L21
        L15:
            if (modeStr.equals(NIGHT_MODE_STR_NO) == false) goto L30;
            r0 = 1;
            goto L21
        L30:
            r0 = -1;
            goto L21
        L18:
            if (modeStr.equals(NIGHT_MODE_STR_CUSTOM_BEDTIME) == false) goto L31;
            r0 = 4;
            goto L21
        L31:
            r0 = -1;
            goto L21
        }

        private static int strToNightModeCustomType(String customTypeStr) {
            switch(customTypeStr.hashCode()) {
                case -757868544: goto L9;
                case 164399013: goto L6;
                default: goto L11;
            };
        L11:
            byte r0 = -1;
        L12:
            switch(r0) {
                case 0: goto L15;
                case 1: goto L14;
                default: goto L13;
            };
        L13:
            return -1;
        L14:
            return 0;
        L15:
            return 1;
        L6:
            if (customTypeStr.equals(NIGHT_MODE_STR_CUSTOM_SCHEDULE) == false) goto L16;
            r0 = 1;
            goto L12
        L16:
            r0 = -1;
            goto L12
        L9:
            if (customTypeStr.equals(NIGHT_MODE_STR_CUSTOM_BEDTIME) == false) goto L17;
            r0 = 0;
            goto L12
        L17:
            r0 = -1;
            goto L12
        }

        private int handleCarMode() throws RemoteException {
            PrintWriter err = getErrPrintWriter();
            String modeStr = getNextArg();
            if (modeStr != null) goto L7;
            printCurrentCarMode();
            return 0;
        L7:
            if (modeStr.equals(NIGHT_MODE_STR_YES) == false) goto L11;
            this.mInterface.enableCarMode(0, 0, "");
            printCurrentCarMode();
            return 0;
        L11:
            if (modeStr.equals(NIGHT_MODE_STR_NO) == false) goto L14;
            this.mInterface.disableCarMode(0);
            printCurrentCarMode();
            return 0;
        L14:
            err.println("Error: mode must be 'yes', or 'no'");
            return -1;
        }

        private void printCurrentCarMode() throws RemoteException {
            PrintWriter pw = getOutPrintWriter();
            int currMode = this.mInterface.getCurrentModeType();
            StringBuilder r2 = new StringBuilder();
            r2.append("Car mode: ");
            if (currMode != 3) goto L5;
            String r3 = NIGHT_MODE_STR_YES;
        L6:
            r2.append(r3);
            pw.println(r2.toString());
            return;
        L5:
            r3 = NIGHT_MODE_STR_NO;
            goto L6
        }
    }

    private final class Stub extends IUiModeManager.Stub {
        final /* synthetic */ UiModeManagerService this$0;

        /* JADX INFO: renamed from: $r8$lambda$TV9EAceiCXd-6xqembbbA6h2_RM, reason: not valid java name */
        public static /* synthetic */ void m501$r8$lambda$TV9EAceiCXd6xqembbbA6h2_RM(Stub r0) {
            r0.lambda$setAttentionModeThemeOverlay$1();
        }

        public static /* synthetic */ boolean $r8$lambda$kEKw_iOiu7UZa8ZrwTxGXSouA2s(UiModeManagerService r0, int r1, String r2) {
            return UiModeManagerService.m480$$Nest$mreleaseProjectionUnchecked(r0, r1, r2);
        }

        public static /* synthetic */ boolean $r8$lambda$u2YdeWTEr_oQCDXr0OTTzC4ztdY(String r0, Map.Entry r1) {
            return lambda$disableCarModeByCallingPackage$0(r0, r1);
        }

        Stub(UiModeManagerService r1, Context context) {
            this.this$0 = r1;
            super(PermissionEnforcer.fromContext(context));
        }

        public void addCallback(IUiModeManagerCallback callback) {
            int userId = UserHandle.getCallingUserId();
            Object r1 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (UiModeManagerService.m451$$Nest$fgetmUiModeManagerCallbacks(this.this$0).contains(userId) == true) goto L9;
            UiModeManagerService.m451$$Nest$fgetmUiModeManagerCallbacks(this.this$0).put(userId, new RemoteCallbackList());     // Catch: Throwable -> L7
        L9:
            ((RemoteCallbackList) UiModeManagerService.m451$$Nest$fgetmUiModeManagerCallbacks(this.this$0).get(userId)).register(callback);     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
        }

        public void enableCarMode(int flags, int priority, String callingPackage) {
            if (isUiModeLocked() == false) goto L7;
            Slog.e(UiModeManagerService.m493$$Nest$sfgetTAG(), "enableCarMode while UI mode is locked");
            return;
        L7:
            if (priority == 0) goto L14;
            if (this.this$0.getContext().checkCallingOrSelfPermission("android.permission.ENTER_CAR_MODE_PRIORITIZED") == 0) goto L14;
            throw new SecurityException("Enabling car mode with a priority requires permission ENTER_CAR_MODE_PRIORITIZED");
        L14:
            if (UiModeManagerService.m441$$Nest$fgetmInjector(this.this$0).getCallingUid() != 2000) goto L16;
            boolean isShellCaller = true;
        L17:
            if (isShellCaller == true) goto L19;
            UiModeManagerService.m468$$Nest$massertLegit(this.this$0, callingPackage);
        L19:
            long ident = Binder.clearCallingIdentity();
            Object r1 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L32
            monitor-enter(r1);     // Catch: Throwable -> L32
            this.this$0.setCarModeLocked(true, flags, priority, callingPackage);     // Catch: Throwable -> L25
            if (this.this$0.mSystemReady == false) goto L27;
            this.this$0.updateLocked(flags, 0);     // Catch: Throwable -> L25
        L27:
            monitor-exit(r1);     // Catch: Throwable -> L25
            Binder.restoreCallingIdentity(ident);
            return;
        L25:
            th = move-exception;
            throw th;     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L16:
            isShellCaller = false;
            goto L17
        }

        public void disableCarMode(int flags) {
            disableCarModeByCallingPackage(flags, null);
        }

        public void disableCarModeByCallingPackage(int flags, final String callingPackage) {
            if (isUiModeLocked() == false) goto L6;
            Slog.e(UiModeManagerService.m493$$Nest$sfgetTAG(), "disableCarMode while UI mode is locked");
            return;
        L6:
            int callingUid = UiModeManagerService.m441$$Nest$fgetmInjector(this.this$0).getCallingUid();
            boolean isShellCaller = true;
            if (callingUid != 1000) goto L9;
            boolean isSystemCaller = true;
        L11:
            if (callingUid == 2000) goto L14;
            isShellCaller = false;
        L14:
            if (isSystemCaller == true) goto L17;
            if (isShellCaller == true) goto L17;
            UiModeManagerService.m468$$Nest$massertLegit(this.this$0, callingPackage);
        L17:
            if (isSystemCaller == false) goto L19;
            int carModeFlags = flags;
        L20:
            long ident = Binder.clearCallingIdentity();
            Object r7 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L33
            monitor-enter(r7);     // Catch: Throwable -> L33
            int priority = ((Integer) UiModeManagerService.m435$$Nest$fgetmCarModePackagePriority(this.this$0).entrySet().stream().filter(new UiModeManagerService$Stub$$ExternalSyntheticLambda2(callingPackage)).findFirst().map(new UiModeManagerService$Stub$$ExternalSyntheticLambda3()).orElse(0)).intValue();     // Catch: Throwable -> L26
            this.this$0.setCarModeLocked(false, carModeFlags, priority, callingPackage);     // Catch: Throwable -> L26
            if (this.this$0.mSystemReady == false) goto L28;
            this.this$0.updateLocked(0, flags);     // Catch: Throwable -> L26
        L28:
            monitor-exit(r7);     // Catch: Throwable -> L26
            Binder.restoreCallingIdentity(ident);
            return;
        L26:
            th = move-exception;
            throw th;     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L19:
            carModeFlags = flags & (-3);
            goto L20
        L9:
            isSystemCaller = false;
            goto L11
        }

        private static /* synthetic */ boolean lambda$disableCarModeByCallingPackage$0(String callingPackage, Map.Entry e) {
            return ((String) e.getValue()).equals(callingPackage);
        }

        public int getCurrentModeType() {
            long ident = Binder.clearCallingIdentity();
            Object r2 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L12
            monitor-enter(r2);     // Catch: Throwable -> L12
            int r3 = UiModeManagerService.m437$$Nest$fgetmCurUiMode(this.this$0).get() & 15;     // Catch: Throwable -> L9
            monitor-exit(r2);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);
            return r3;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }

        public void setNightMode(int mode) {
            if (mode != 3) goto L5;
            int customModeType = 0;
        L6:
            setNightModeInternal(mode, customModeType);
            return;
        L5:
            customModeType = -1;
            goto L6
        }

        private void setNightModeInternal(int mode, int customModeType) {
            if (isNightModeLocked() == true) goto L5;
        L8:
            switch(mode) {
                case 0: goto L17;
                case 1: goto L17;
                case 2: goto L17;
                case 3: goto L12;
                default: goto L10;
            };
        L17:
            UserManagerService.enforceCurrentUserIfVisibleBackgroundEnabled();
            int user = UserHandle.getCallingUserId();
            long ident = Binder.clearCallingIdentity();
            Object r3 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L49
            monitor-enter(r3);     // Catch: Throwable -> L49
        L25:
            th = move-exception;
            throw th;     // Catch: Throwable -> L49
        L21:
            if (UiModeManagerService.m443$$Nest$fgetmNightMode(this.this$0).get() != mode) goto L28;
            if (UiModeManagerService.m444$$Nest$fgetmNightModeCustomType(this.this$0) != customModeType) goto L28;
        L44:
            monitor-exit(r3);     // Catch: Throwable -> L25
            Binder.restoreCallingIdentity(ident);
            return;
        L28:
            if (UiModeManagerService.m443$$Nest$fgetmNightMode(this.this$0).get() != 0) goto L30;
        L31:
            UiModeManagerService.m484$$Nest$munregisterDeviceInactiveListenerLocked(this.this$0);     // Catch: Throwable -> L25
            UiModeManagerService.m469$$Nest$mcancelCustomAlarm(this.this$0);     // Catch: Throwable -> L25
        L32:
            UiModeManagerService r4 = this.this$0;     // Catch: Throwable -> L25
            if (mode != 3) goto L35;
            int r6 = customModeType;
        L36:
            UiModeManagerService.m457$$Nest$fputmNightModeCustomType(r4, r6);     // Catch: Throwable -> L25
            UiModeManagerService.m443$$Nest$fgetmNightMode(this.this$0).set(mode);     // Catch: Throwable -> L25
            UiModeManagerService.m481$$Nest$mresetNightModeOverrideLocked(this.this$0);     // Catch: Throwable -> L25
            UiModeManagerService.m476$$Nest$mpersistNightMode(this.this$0, user);     // Catch: Throwable -> L25
            if (UiModeManagerService.m443$$Nest$fgetmNightMode(this.this$0).get() == 0) goto L41;
            if (UiModeManagerService.m443$$Nest$fgetmNightMode(this.this$0).get() == 3) goto L41;
        L42:
            UiModeManagerService.m484$$Nest$munregisterDeviceInactiveListenerLocked(this.this$0);     // Catch: Throwable -> L25
            this.this$0.updateLocked(0, 0);     // Catch: Throwable -> L25
        L41:
            if (UiModeManagerService.m483$$Nest$mshouldApplyAutomaticChangesImmediately(this.this$0) == true) goto L42;
            UiModeManagerService.m479$$Nest$mregisterDeviceInactiveListenerLocked(this.this$0);     // Catch: Throwable -> L25
            goto L44
        L35:
            r6 = -1;
            goto L36
        L30:
            if (UiModeManagerService.m443$$Nest$fgetmNightMode(this.this$0).get() != 3) goto L32;
        L49:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L10:
            throw new IllegalArgumentException("Unknown mode: " + mode);
        L12:
            if (UiModeManagerService.SUPPORTED_NIGHT_MODE_CUSTOM_TYPES.contains(Integer.valueOf(customModeType)) == true) goto L17;
            throw new IllegalArgumentException("Can't set the custom type to " + customModeType);
        L5:
            if (this.this$0.getContext().checkCallingOrSelfPermission("android.permission.MODIFY_DAY_NIGHT_MODE") == 0) goto L8;
            Slog.e(UiModeManagerService.m493$$Nest$sfgetTAG(), "Night mode locked, requires MODIFY_DAY_NIGHT_MODE permission");
        }

        public int getNightMode() {
            Object r0 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int r1 = UiModeManagerService.m443$$Nest$fgetmNightMode(this.this$0).get();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void setNightModeCustomType(int nightModeCustomType) {
            setNightModeCustomType_enforcePermission();
            setNightModeInternal(3, nightModeCustomType);
        }

        public int getNightModeCustomType() {
            getNightModeCustomType_enforcePermission();
            Object r0 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int r1 = UiModeManagerService.m444$$Nest$fgetmNightModeCustomType(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void setAttentionModeThemeOverlay(int attentionModeThemeOverlayType) {
            setAttentionModeThemeOverlay_enforcePermission();
            UserManagerService.enforceCurrentUserIfVisibleBackgroundEnabled();
            Object r0 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (UiModeManagerService.m434$$Nest$fgetmAttentionModeThemeOverlay(this.this$0) == attentionModeThemeOverlayType) goto L9;
            UiModeManagerService.m452$$Nest$fputmAttentionModeThemeOverlay(this.this$0, attentionModeThemeOverlayType);     // Catch: Throwable -> L7
            Binder.withCleanCallingIdentity(new UiModeManagerService$Stub$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        private /* synthetic */ void lambda$setAttentionModeThemeOverlay$1() throws Exception {
            this.this$0.updateLocked(0, 0);
        }

        public int getAttentionModeThemeOverlay() {
            getAttentionModeThemeOverlay_enforcePermission();
            Object r0 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int r1 = UiModeManagerService.m434$$Nest$fgetmAttentionModeThemeOverlay(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void setApplicationNightMode(int mode) {
            switch(mode) {
                case 0: goto L6;
                case 1: goto L6;
                case 2: goto L6;
                case 3: goto L6;
                default: goto L4;
            };
        L6:
            switch(mode) {
                case 1: goto L9;
                case 2: goto L8;
                default: goto L7;
            };
        L7:
            int configNightMode = 0;
        L10:
            ActivityTaskManagerInternal.PackageConfigurationUpdater updater = UiModeManagerService.m433$$Nest$fgetmActivityTaskManager(this.this$0).createPackageConfigurationUpdater();
            updater.setNightMode(configNightMode);
            updater.commit();
            return;
        L8:
            configNightMode = 32;
            goto L10
        L9:
            configNightMode = 16;
            goto L10
        L4:
            throw new IllegalArgumentException("Unknown mode: " + mode);
        }

        public boolean isUiModeLocked() {
            Object r0 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = UiModeManagerService.m450$$Nest$fgetmUiModeLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean isNightModeLocked() {
            Object r0 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = UiModeManagerService.m445$$Nest$fgetmNightModeLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new Shell(UiModeManagerService.m448$$Nest$fgetmService(this.this$0)).exec(UiModeManagerService.m448$$Nest$fgetmService(this.this$0), in, out, err, args, callback, resultReceiver);
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), UiModeManagerService.m493$$Nest$sfgetTAG(), pw) == true) goto L5;
            return;
        L5:
            this.this$0.dumpImpl(pw);
        }

        public boolean setNightModeActivatedForCustomMode(int modeNightCustomType, boolean active) {
            return setNightModeActivatedForModeInternal(modeNightCustomType, active, false);
        }

        public boolean setNightModeActivated(boolean active) {
            return setNightModeActivatedForModeInternal(UiModeManagerService.m444$$Nest$fgetmNightModeCustomType(this.this$0), active, true);
        }

        private boolean setNightModeActivatedForModeInternal(int modeCustomType, boolean active, boolean isUserInteraction) {
            boolean r1 = false;
            if (this.this$0.getContext().checkCallingOrSelfPermission("android.permission.MODIFY_DAY_NIGHT_MODE") == 0) goto L6;
            Slog.e(UiModeManagerService.m493$$Nest$sfgetTAG(), "Night mode locked, requires MODIFY_DAY_NIGHT_MODE permission");
            return false;
        L6:
            int user = Binder.getCallingUserHandle().getIdentifier();
            if (user != UiModeManagerService.m438$$Nest$fgetmCurrentUser(this.this$0)) goto L9;
        L12:
            UserManagerService.enforceCurrentUserIfVisibleBackgroundEnabled();
            if (modeCustomType != 1) goto L16;
            UiModeManagerService.m456$$Nest$fputmLastBedtimeRequestedNightMode(this.this$0, active);
        L16:
            if (modeCustomType == UiModeManagerService.m444$$Nest$fgetmNightModeCustomType(this.this$0)) goto L18;
            return false;
        L18:
            Object r3 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r3);
            long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L48
            if (isUserInteraction == false) goto L26;
            UiModeManagerService.m461$$Nest$fputmPendingResetNightModeOverrideByAutoBoundary(this.this$0, false);     // Catch: Throwable -> L23
            UiModeManagerService.m462$$Nest$fputmPendingResetNightModeOverrideUser(this.this$0, 0);     // Catch: Throwable -> L23
        L23:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L48
            throw th;     // Catch: Throwable -> L48
        L26:
            if (UiModeManagerService.m443$$Nest$fgetmNightMode(this.this$0).get() != 0) goto L28;
        L38:
            UiModeManagerService.m484$$Nest$munregisterDeviceInactiveListenerLocked(this.this$0);     // Catch: Throwable -> L23
            UiModeManagerService r6 = this.this$0;     // Catch: Throwable -> L23
            if (active == true) goto L41;
            r1 = true;
        L41:
            UiModeManagerService.m458$$Nest$fputmOverrideNightModeOff(r6, r1);     // Catch: Throwable -> L23
            UiModeManagerService.m459$$Nest$fputmOverrideNightModeOn(this.this$0, active);     // Catch: Throwable -> L23
            UiModeManagerService.m460$$Nest$fputmOverrideNightModeUser(this.this$0, UiModeManagerService.m438$$Nest$fgetmCurrentUser(this.this$0));     // Catch: Throwable -> L23
            UiModeManagerService.m477$$Nest$mpersistNightModeOverrides(this.this$0, UiModeManagerService.m438$$Nest$fgetmCurrentUser(this.this$0));     // Catch: Throwable -> L23
        L42:
            if (isUserInteraction == false) goto L44;
            UiModeManagerService.m452$$Nest$fputmAttentionModeThemeOverlay(this.this$0, 1000);     // Catch: Throwable -> L23
        L44:
            UiModeManagerService.m486$$Nest$mupdateConfigurationLocked(this.this$0);     // Catch: Throwable -> L23
            UiModeManagerService.m467$$Nest$mapplyConfigurationExternallyLocked(this.this$0);     // Catch: Throwable -> L23
            UiModeManagerService.m476$$Nest$mpersistNightMode(this.this$0, UiModeManagerService.m438$$Nest$fgetmCurrentUser(this.this$0));     // Catch: Throwable -> L23
            Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L48
            monitor-exit(r3);     // Catch: Throwable -> L48
            return true;
        L28:
            if (UiModeManagerService.m443$$Nest$fgetmNightMode(this.this$0).get() == 3) goto L38;
            if (UiModeManagerService.m443$$Nest$fgetmNightMode(this.this$0).get() != 1) goto L35;
            if (active == false) goto L35;
            UiModeManagerService.m443$$Nest$fgetmNightMode(this.this$0).set(2);     // Catch: Throwable -> L23
        L35:
            if (UiModeManagerService.m443$$Nest$fgetmNightMode(this.this$0).get() != 2) goto L42;
            if (active == true) goto L42;
            UiModeManagerService.m443$$Nest$fgetmNightMode(this.this$0).set(1);     // Catch: Throwable -> L23
        L48:
            th = move-exception;
            throw th;
        L9:
            if (this.this$0.getContext().checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS") == 0) goto L12;
            Slog.e(UiModeManagerService.m493$$Nest$sfgetTAG(), "Target user is not current user, INTERACT_ACROSS_USERS permission is required");
            return false;
        }

        public long getCustomNightModeStart() {
            return UiModeManagerService.m440$$Nest$fgetmCustomAutoNightModeStartMilliseconds(this.this$0).toNanoOfDay() / 1000;
        }

        public void setCustomNightModeStart(long time) {
            if (isNightModeLocked() == true) goto L5;
        L8:
            UserManagerService.enforceCurrentUserIfVisibleBackgroundEnabled();
            int user = UserHandle.getCallingUserId();
            long ident = Binder.clearCallingIdentity();
            LocalTime newTime = LocalTime.ofNanoOfDay(1000 * time);     // Catch: Throwable -> L15 DateTimeException -> L17
            if (newTime != null) goto L13;
            Binder.restoreCallingIdentity(ident);
            return;
        L13:
            UiModeManagerService.m455$$Nest$fputmCustomAutoNightModeStartMilliseconds(this.this$0, newTime);     // Catch: Throwable -> L15 DateTimeException -> L17
            UiModeManagerService.m476$$Nest$mpersistNightMode(this.this$0, user);     // Catch: Throwable -> L15 DateTimeException -> L17
            UiModeManagerService.m473$$Nest$monCustomTimeUpdated(this.this$0, user);     // Catch: Throwable -> L15 DateTimeException -> L17
        L14:
            Binder.restoreCallingIdentity(ident);
            return;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L18:
            UiModeManagerService.m484$$Nest$munregisterDeviceInactiveListenerLocked(this.this$0);     // Catch: Throwable -> L15
            goto L14
        L5:
            if (this.this$0.getContext().checkCallingOrSelfPermission("android.permission.MODIFY_DAY_NIGHT_MODE") == 0) goto L8;
            Slog.e(UiModeManagerService.m493$$Nest$sfgetTAG(), "Set custom time start, requires MODIFY_DAY_NIGHT_MODE permission");
        }

        public long getCustomNightModeEnd() {
            return UiModeManagerService.m439$$Nest$fgetmCustomAutoNightModeEndMilliseconds(this.this$0).toNanoOfDay() / 1000;
        }

        public void setCustomNightModeEnd(long time) {
            if (isNightModeLocked() == true) goto L5;
        L8:
            UserManagerService.enforceCurrentUserIfVisibleBackgroundEnabled();
            int user = UserHandle.getCallingUserId();
            long ident = Binder.clearCallingIdentity();
            LocalTime newTime = LocalTime.ofNanoOfDay(1000 * time);     // Catch: Throwable -> L15 DateTimeException -> L17
            if (newTime != null) goto L13;
            Binder.restoreCallingIdentity(ident);
            return;
        L13:
            UiModeManagerService.m454$$Nest$fputmCustomAutoNightModeEndMilliseconds(this.this$0, newTime);     // Catch: Throwable -> L15 DateTimeException -> L17
            UiModeManagerService.m473$$Nest$monCustomTimeUpdated(this.this$0, user);     // Catch: Throwable -> L15 DateTimeException -> L17
        L14:
            Binder.restoreCallingIdentity(ident);
            return;
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        L18:
            UiModeManagerService.m484$$Nest$munregisterDeviceInactiveListenerLocked(this.this$0);     // Catch: Throwable -> L15
            goto L14
        L5:
            if (this.this$0.getContext().checkCallingOrSelfPermission("android.permission.MODIFY_DAY_NIGHT_MODE") == 0) goto L8;
            Slog.e(UiModeManagerService.m493$$Nest$sfgetTAG(), "Set custom time end, requires MODIFY_DAY_NIGHT_MODE permission");
        }

        public boolean requestProjection(IBinder binder, int projectionType, String callingPackage) {
            UiModeManagerService.m468$$Nest$massertLegit(this.this$0, callingPackage);
            UiModeManagerService.m494$$Nest$smassertSingleProjectionType(projectionType);
            UiModeManagerService.m470$$Nest$menforceProjectionTypePermissions(this.this$0, projectionType);
            UserManagerService.enforceCurrentUserIfVisibleBackgroundEnabled();
            Object r1 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L34:
            th = th;
        L41:
            monitor-exit(r1);     // Catch: Throwable -> L34
            throw th;
        L39:
            th = th;
            goto L41
        L6:
            if (UiModeManagerService.m446$$Nest$fgetmProjectionHolders(this.this$0) != null) goto L12;
            UiModeManagerService.m463$$Nest$fputmProjectionHolders(this.this$0, new SparseArray(1));     // Catch: Throwable -> L9
        L9:
            th = th;
        L12:
            if (UiModeManagerService.m446$$Nest$fgetmProjectionHolders(this.this$0).contains(projectionType) == true) goto L14;
            UiModeManagerService.m446$$Nest$fgetmProjectionHolders(this.this$0).put(projectionType, new ArrayList(1));     // Catch: Throwable -> L9
        L14:
            List<ProjectionHolder> currentHolders = (List) UiModeManagerService.m446$$Nest$fgetmProjectionHolders(this.this$0).get(projectionType);     // Catch: Throwable -> L39
            int i = 0;
        L16:
            if (i >= currentHolders.size()) goto L23;
            if (callingPackage.equals(ProjectionHolder.m497$$Nest$fgetmPackageName(currentHolders.get(i))) == true) goto L19;
            i = i + 1;     // Catch: Throwable -> L9
            goto L16
        L19:
            monitor-exit(r1);     // Catch: Throwable -> L9
            return true;
        L23:
            if (projectionType == 1) goto L25;
        L28:
            final UiModeManagerService r5 = this.this$0;     // Catch: Throwable -> L39
            ProjectionHolder projectionHolder = new ProjectionHolder(callingPackage, projectionType, binder, new UiModeManagerService$Stub$$ExternalSyntheticLambda1(r5), null);     // Catch: Throwable -> L34
            if (ProjectionHolder.m498$$Nest$mlinkToDeath(projectionHolder) == true) goto L36;
            monitor-exit(r1);     // Catch: Throwable -> L34
            return false;
        L36:
            currentHolders.add(projectionHolder);     // Catch: Throwable -> L34
            Slog.d(UiModeManagerService.m493$$Nest$sfgetTAG(), "Package " + callingPackage + " set projection type " + projectionType + ".");     // Catch: Throwable -> L34
            UiModeManagerService.m474$$Nest$monProjectionStateChangedLocked(this.this$0, projectionType);     // Catch: Throwable -> L34
            monitor-exit(r1);     // Catch: Throwable -> L34
            return true;
        L25:
            if (currentHolders.isEmpty() == true) goto L28;
            monitor-exit(r1);     // Catch: Throwable -> L9
            return false;
        }

        public boolean releaseProjection(int projectionType, String callingPackage) {
            UiModeManagerService.m468$$Nest$massertLegit(this.this$0, callingPackage);
            UiModeManagerService.m494$$Nest$smassertSingleProjectionType(projectionType);
            UiModeManagerService.m470$$Nest$menforceProjectionTypePermissions(this.this$0, projectionType);
            UserManagerService.enforceCurrentUserIfVisibleBackgroundEnabled();
            return UiModeManagerService.m480$$Nest$mreleaseProjectionUnchecked(this.this$0, projectionType, callingPackage);
        }

        public int getActiveProjectionTypes() {
            getActiveProjectionTypes_enforcePermission();
            int projectionTypeFlag = 0;
            Object r1 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (UiModeManagerService.m446$$Nest$fgetmProjectionHolders(this.this$0) == null) goto L15;
            int i = 0;
        L8:
            if (i >= UiModeManagerService.m446$$Nest$fgetmProjectionHolders(this.this$0).size()) goto L15;
            if (((List) UiModeManagerService.m446$$Nest$fgetmProjectionHolders(this.this$0).valueAt(i)).isEmpty() == true) goto L14;
            projectionTypeFlag = projectionTypeFlag | UiModeManagerService.m446$$Nest$fgetmProjectionHolders(this.this$0).keyAt(i);     // Catch: Throwable -> L12
        L14:
            i = i + 1;     // Catch: Throwable -> L12
        L15:
            monitor-exit(r1);     // Catch: Throwable -> L12
            return projectionTypeFlag;
        }

        public List<String> getProjectingPackages(int projectionType) {
            getProjectingPackages_enforcePermission();
            Object r0 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            List<String> packageNames = new ArrayList();     // Catch: Throwable -> L7
            UiModeManagerService.m478$$Nest$mpopulateWithRelevantActivePackageNames(this.this$0, projectionType, packageNames);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return packageNames;
        L7:
            th = move-exception;
            throw th;
        }

        public void addOnProjectionStateChangedListener(IOnProjectionStateChangedListener listener, int projectionType) {
            addOnProjectionStateChangedListener_enforcePermission();
            if (projectionType != 0) goto L5;
            return;
        L5:
            UserManagerService.enforceCurrentUserIfVisibleBackgroundEnabled();
            Object r0 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L8:
            if (UiModeManagerService.m447$$Nest$fgetmProjectionListeners(this.this$0) != null) goto L13;
            UiModeManagerService.m464$$Nest$fputmProjectionListeners(this.this$0, new SparseArray(1));     // Catch: Throwable -> L10
        L13:
            if (UiModeManagerService.m447$$Nest$fgetmProjectionListeners(this.this$0).contains(projectionType) == true) goto L16;
            UiModeManagerService.m447$$Nest$fgetmProjectionListeners(this.this$0).put(projectionType, new RemoteCallbackList());     // Catch: Throwable -> L10
        L16:
            if (((RemoteCallbackList) UiModeManagerService.m447$$Nest$fgetmProjectionListeners(this.this$0).get(projectionType)).register(listener) == false) goto L23;
            List<String> packageNames = new ArrayList();     // Catch: Throwable -> L10
            int activeProjectionTypes = UiModeManagerService.m478$$Nest$mpopulateWithRelevantActivePackageNames(this.this$0, projectionType, packageNames);     // Catch: Throwable -> L10
            if (packageNames.isEmpty() == true) goto L23;
            listener.onProjectionStateChanged(activeProjectionTypes, packageNames);     // Catch: Throwable -> L10 RemoteException -> L21
        L22:
            Slog.w(UiModeManagerService.m493$$Nest$sfgetTAG(), "Failed a call to onProjectionStateChanged() during listener registration.");     // Catch: Throwable -> L10
        L23:
            monitor-exit(r0);     // Catch: Throwable -> L10
        }

        public void removeOnProjectionStateChangedListener(IOnProjectionStateChangedListener listener) {
            removeOnProjectionStateChangedListener_enforcePermission();
            Object r0 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (UiModeManagerService.m447$$Nest$fgetmProjectionListeners(this.this$0) == null) goto L12;
            int i = 0;
        L8:
            if (i >= UiModeManagerService.m447$$Nest$fgetmProjectionListeners(this.this$0).size()) goto L12;
            ((RemoteCallbackList) UiModeManagerService.m447$$Nest$fgetmProjectionListeners(this.this$0).valueAt(i)).unregister(listener);     // Catch: Throwable -> L10
            i = i + 1;     // Catch: Throwable -> L10
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L10
        }

        public float getContrast() {
            Object r0 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            float r1 = UiModeManagerService.m471$$Nest$mgetContrastLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public int getForceInvertState() {
            Object r0 = UiModeManagerService.m442$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int r1 = UiModeManagerService.m472$$Nest$mgetForceInvertStateLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$HlG0VphU0KZZMTsWRcLyW73-oBI, reason: not valid java name */
    public static /* synthetic */ void m432$r8$lambda$HlG0VphU0KZZMTsWRcLyW73oBI(UiModeManagerService r0, PowerSaveState r1) {
        r0.lambda$initPowerSave$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$W3U0TL5VpA2BWPy1nV7tKwkzrdg(UiModeManagerService r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ void $r8$lambda$wkgOeTYssVTGq4UHm4XgyzmKPPA(UiModeManagerService r0, Context r1, Resources r2) {
        r0.lambda$onStart$2(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityTaskManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerInternal m433$$Nest$fgetmActivityTaskManager(UiModeManagerService r0) {
        return r0.mActivityTaskManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAttentionModeThemeOverlay, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m434$$Nest$fgetmAttentionModeThemeOverlay(UiModeManagerService r0) {
        return r0.mAttentionModeThemeOverlay;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCarModePackagePriority, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m435$$Nest$fgetmCarModePackagePriority(UiModeManagerService r0) {
        return r0.mCarModePackagePriority;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConfiguration, reason: not valid java name */
    static /* bridge */ /* synthetic */ Configuration m436$$Nest$fgetmConfiguration(UiModeManagerService r0) {
        return r0.mConfiguration;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurUiMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ IntProperty m437$$Nest$fgetmCurUiMode(UiModeManagerService r0) {
        return r0.mCurUiMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m438$$Nest$fgetmCurrentUser(UiModeManagerService r0) {
        return r0.mCurrentUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCustomAutoNightModeEndMilliseconds, reason: not valid java name */
    static /* bridge */ /* synthetic */ LocalTime m439$$Nest$fgetmCustomAutoNightModeEndMilliseconds(UiModeManagerService r0) {
        return r0.mCustomAutoNightModeEndMilliseconds;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCustomAutoNightModeStartMilliseconds, reason: not valid java name */
    static /* bridge */ /* synthetic */ LocalTime m440$$Nest$fgetmCustomAutoNightModeStartMilliseconds(UiModeManagerService r0) {
        return r0.mCustomAutoNightModeStartMilliseconds;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m441$$Nest$fgetmInjector(UiModeManagerService r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m442$$Nest$fgetmLock(UiModeManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNightMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ IntProperty m443$$Nest$fgetmNightMode(UiModeManagerService r0) {
        return r0.mNightMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNightModeCustomType, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m444$$Nest$fgetmNightModeCustomType(UiModeManagerService r0) {
        return r0.mNightModeCustomType;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNightModeLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m445$$Nest$fgetmNightModeLocked(UiModeManagerService r0) {
        return r0.mNightModeLocked;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProjectionHolders, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m446$$Nest$fgetmProjectionHolders(UiModeManagerService r0) {
        return r0.mProjectionHolders;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProjectionListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m447$$Nest$fgetmProjectionListeners(UiModeManagerService r0) {
        return r0.mProjectionListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ IUiModeManager.Stub m448$$Nest$fgetmService(UiModeManagerService r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSetupWizardObserver, reason: not valid java name */
    static /* bridge */ /* synthetic */ ContentObserver m449$$Nest$fgetmSetupWizardObserver(UiModeManagerService r0) {
        return r0.mSetupWizardObserver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUiModeLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m450$$Nest$fgetmUiModeLocked(UiModeManagerService r0) {
        return r0.mUiModeLocked;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUiModeManagerCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m451$$Nest$fgetmUiModeManagerCallbacks(UiModeManagerService r0) {
        return r0.mUiModeManagerCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAttentionModeThemeOverlay, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m452$$Nest$fputmAttentionModeThemeOverlay(UiModeManagerService r0, int r1) {
        r0.mAttentionModeThemeOverlay = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCharging, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m453$$Nest$fputmCharging(UiModeManagerService r0, boolean r1) {
        r0.mCharging = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCustomAutoNightModeEndMilliseconds, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m454$$Nest$fputmCustomAutoNightModeEndMilliseconds(UiModeManagerService r0, LocalTime r1) {
        r0.mCustomAutoNightModeEndMilliseconds = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCustomAutoNightModeStartMilliseconds, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m455$$Nest$fputmCustomAutoNightModeStartMilliseconds(UiModeManagerService r0, LocalTime r1) {
        r0.mCustomAutoNightModeStartMilliseconds = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastBedtimeRequestedNightMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m456$$Nest$fputmLastBedtimeRequestedNightMode(UiModeManagerService r0, boolean r1) {
        r0.mLastBedtimeRequestedNightMode = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNightModeCustomType, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m457$$Nest$fputmNightModeCustomType(UiModeManagerService r0, int r1) {
        r0.mNightModeCustomType = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmOverrideNightModeOff, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m458$$Nest$fputmOverrideNightModeOff(UiModeManagerService r0, boolean r1) {
        r0.mOverrideNightModeOff = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmOverrideNightModeOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m459$$Nest$fputmOverrideNightModeOn(UiModeManagerService r0, boolean r1) {
        r0.mOverrideNightModeOn = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmOverrideNightModeUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m460$$Nest$fputmOverrideNightModeUser(UiModeManagerService r0, int r1) {
        r0.mOverrideNightModeUser = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPendingResetNightModeOverrideByAutoBoundary, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m461$$Nest$fputmPendingResetNightModeOverrideByAutoBoundary(UiModeManagerService r0, boolean r1) {
        r0.mPendingResetNightModeOverrideByAutoBoundary = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPendingResetNightModeOverrideUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m462$$Nest$fputmPendingResetNightModeOverrideUser(UiModeManagerService r0, int r1) {
        r0.mPendingResetNightModeOverrideUser = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmProjectionHolders, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m463$$Nest$fputmProjectionHolders(UiModeManagerService r0, SparseArray r1) {
        r0.mProjectionHolders = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmProjectionListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m464$$Nest$fputmProjectionListeners(UiModeManagerService r0, SparseArray r1) {
        r0.mProjectionListeners = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSetupWizardComplete, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m465$$Nest$fputmSetupWizardComplete(UiModeManagerService r0, boolean r1) {
        r0.mSetupWizardComplete = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmVrHeadset, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m466$$Nest$fputmVrHeadset(UiModeManagerService r0, boolean r1) {
        r0.mVrHeadset = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mapplyConfigurationExternallyLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m467$$Nest$mapplyConfigurationExternallyLocked(UiModeManagerService r0) {
        r0.applyConfigurationExternallyLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$massertLegit, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m468$$Nest$massertLegit(UiModeManagerService r0, String r1) {
        r0.assertLegit(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelCustomAlarm, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m469$$Nest$mcancelCustomAlarm(UiModeManagerService r0) {
        r0.cancelCustomAlarm();
    }

    /* JADX INFO: renamed from: -$$Nest$menforceProjectionTypePermissions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m470$$Nest$menforceProjectionTypePermissions(UiModeManagerService r0, int r1) {
        r0.enforceProjectionTypePermissions(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetContrastLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m471$$Nest$mgetContrastLocked(UiModeManagerService r0) {
        return r0.getContrastLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetForceInvertStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m472$$Nest$mgetForceInvertStateLocked(UiModeManagerService r0) {
        return r0.getForceInvertStateLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$monCustomTimeUpdated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m473$$Nest$monCustomTimeUpdated(UiModeManagerService r0, int r1) {
        r0.onCustomTimeUpdated(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monProjectionStateChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m474$$Nest$monProjectionStateChangedLocked(UiModeManagerService r0, int r1) {
        r0.onProjectionStateChangedLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpersistComputedNightMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m475$$Nest$mpersistComputedNightMode(UiModeManagerService r0, int r1) {
        r0.persistComputedNightMode(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpersistNightMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m476$$Nest$mpersistNightMode(UiModeManagerService r0, int r1) {
        r0.persistNightMode(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpersistNightModeOverrides, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m477$$Nest$mpersistNightModeOverrides(UiModeManagerService r0, int r1) {
        r0.persistNightModeOverrides(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpopulateWithRelevantActivePackageNames, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m478$$Nest$mpopulateWithRelevantActivePackageNames(UiModeManagerService r0, int r1, List r2) {
        return r0.populateWithRelevantActivePackageNames(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterDeviceInactiveListenerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m479$$Nest$mregisterDeviceInactiveListenerLocked(UiModeManagerService r0) {
        r0.registerDeviceInactiveListenerLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mreleaseProjectionUnchecked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m480$$Nest$mreleaseProjectionUnchecked(UiModeManagerService r0, int r1, String r2) {
        return r0.releaseProjectionUnchecked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mresetNightModeOverrideLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m481$$Nest$mresetNightModeOverrideLocked(UiModeManagerService r0) {
        return r0.resetNightModeOverrideLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$msetupWizardCompleteForCurrentUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m482$$Nest$msetupWizardCompleteForCurrentUser(UiModeManagerService r0) {
        return r0.setupWizardCompleteForCurrentUser();
    }

    /* JADX INFO: renamed from: -$$Nest$mshouldApplyAutomaticChangesImmediately, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m483$$Nest$mshouldApplyAutomaticChangesImmediately(UiModeManagerService r0) {
        return r0.shouldApplyAutomaticChangesImmediately();
    }

    /* JADX INFO: renamed from: -$$Nest$munregisterDeviceInactiveListenerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m484$$Nest$munregisterDeviceInactiveListenerLocked(UiModeManagerService r0) {
        r0.unregisterDeviceInactiveListenerLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateAfterBroadcastLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m485$$Nest$mupdateAfterBroadcastLocked(UiModeManagerService r0, String r1, int r2, int r3) {
        r0.updateAfterBroadcastLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateConfigurationLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m486$$Nest$mupdateConfigurationLocked(UiModeManagerService r0) {
        r0.updateConfigurationLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateContrastLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m487$$Nest$mupdateContrastLocked(UiModeManagerService r0) {
        return r0.updateContrastLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateCustomTimeLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m488$$Nest$mupdateCustomTimeLocked(UiModeManagerService r0) {
        r0.updateCustomTimeLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateDockState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m489$$Nest$mupdateDockState(UiModeManagerService r0, int r1) {
        r0.updateDockState(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateForceInvertStates, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m490$$Nest$mupdateForceInvertStates(UiModeManagerService r0) {
        r0.updateForceInvertStates();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateNightModeFromSettingsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m491$$Nest$mupdateNightModeFromSettingsLocked(UiModeManagerService r0, Context r1, Resources r2, int r3) {
        r0.updateNightModeFromSettingsLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateSystemProperties, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m492$$Nest$mupdateSystemProperties(UiModeManagerService r0) {
        r0.updateSystemProperties();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m493$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smassertSingleProjectionType, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m494$$Nest$smassertSingleProjectionType(int r0) {
        assertSingleProjectionType(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smfromMilliseconds, reason: not valid java name */
    static /* bridge */ /* synthetic */ LocalTime m495$$Nest$smfromMilliseconds(long r0) {
        return fromMilliseconds(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smtoMilliSeconds, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m496$$Nest$smtoMilliSeconds(LocalTime r2) {
        return toMilliSeconds(r2);
    }

    static {
        TAG = UiModeManager.class.getSimpleName();
        SUPPORTED_NIGHT_MODE_CUSTOM_TYPES = new ArraySet(new Integer[]{0, 1});
    }

    public UiModeManagerService(Context context) {
        this(context, false, null, new Injector());
    }

    protected UiModeManagerService(Context context, boolean setupWizardComplete, TwilightManager tm, Injector injector) {
        super(context);
        this.mLock = new Object();
        this.mDockState = 0;
        this.mLastBroadcastState = 0;
        this.mNightMode = new AnonymousClass1(this);
        this.mNightModeCustomType = -1;
        this.mAttentionModeThemeOverlay = 1000;
        this.DEFAULT_CUSTOM_NIGHT_START_TIME = LocalTime.of(22, 0);
        this.DEFAULT_CUSTOM_NIGHT_END_TIME = LocalTime.of(6, 0);
        this.mCustomAutoNightModeStartMilliseconds = this.DEFAULT_CUSTOM_NIGHT_START_TIME;
        this.mCustomAutoNightModeEndMilliseconds = this.DEFAULT_CUSTOM_NIGHT_END_TIME;
        this.mCarModePackagePriority = new HashMap();
        this.mCarModeEnabled = false;
        this.mCharging = false;
        this.mPowerSave = false;
        this.mWaitForDeviceInactive = false;
        this.mLastBedtimeRequestedNightMode = false;
        this.mStartDreamImmediatelyOnDock = true;
        this.mDreamsDisabledByAmbientModeSuppression = false;
        this.mEnableCarDockLaunch = true;
        this.mUiModeLocked = false;
        this.mNightModeLocked = false;
        this.mCurUiMode = new AnonymousClass2(this);
        this.mSetUiMode = 0;
        this.mHoldingConfiguration = false;
        this.mConfiguration = new Configuration();
        this.mHandler = new Handler();
        this.mOverrideNightModeUser = 0;
        this.mPendingResetNightModeOverrideUser = 0;
        this.mLocalService = new LocalService(this);
        this.mUiModeManagerCallbacks = new SparseArray();
        this.mContrasts = new SparseArray();
        this.mForceInvertStates = new SparseIntArray();
        this.mResultReceiver = new AnonymousClass3(this);
        this.mDockModeReceiver = new AnonymousClass4(this);
        this.mBatteryReceiver = new AnonymousClass5(this);
        this.mTwilightListener = new AnonymousClass6(this);
        this.mDeviceInactiveListener = new AnonymousClass7(this);
        this.mOnTimeChangedHandler = new AnonymousClass8(this);
        this.mCustomTimeListener = new UiModeManagerService$$ExternalSyntheticLambda2(this);
        this.mVrStateCallbacks = new AnonymousClass9(this);
        final Handler r1 = this.mHandler;
        this.mSetupWizardObserver = new AnonymousClass10(this, r1);
        final Handler r2 = this.mHandler;
        this.mDarkThemeObserver = new AnonymousClass11(this, r2);
        final Handler r3 = this.mHandler;
        this.mForceInvertStateObserver = new AnonymousClass12(this, r3);
        this.mContrastObserver = new AnonymousClass13(this, this.mHandler);
        this.mOnShutdown = new AnonymousClass14(this);
        this.mSettingsRestored = new AnonymousClass15(this);
        this.mService = new Stub(this, context);
        this.mConfiguration.setToDefaults();
        this.mSetupWizardComplete = setupWizardComplete;
        this.mTwilightManager = tm;
        this.mInjector = injector;
    }

    private static Intent buildHomeIntent(String category) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory(category);
        intent.setFlags(270532608);
        return intent;
    }

    private /* synthetic */ void lambda$new$0() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mNightMode.get() == 3) goto L7;
    L13:
        updateCustomTimeLocked();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (this.mNightModeCustomType != 0) goto L13;
        if (this.mSystemReady == false) goto L13;
        this.mPendingResetNightModeOverrideByAutoBoundary = true;     // Catch: Throwable -> L11
        this.mPendingResetNightModeOverrideUser = this.mCurrentUser;     // Catch: Throwable -> L11
        goto L13
    }

    private void updateForceInvertStates() {
    }

    private static /* synthetic */ void lambda$updateForceInvertStates$1(int forceInvertState, IUiModeManagerCallback callback) throws RemoteException {
        callback.notifyForceInvertStateChanged(forceInvertState);
    }

    private void updateSystemProperties() {
        int mode = Settings.Secure.getIntForUser(getContext().getContentResolver(), "ui_night_mode", this.mNightMode.get(), 0);
        if (mode != 0) goto L5;
    L6:
        mode = 2;
    L7:
        SystemProperties.set(SYSTEM_PROPERTY_DEVICE_THEME, Integer.toString(mode));
        return;
    L5:
        if (mode != 3) goto L7;
        goto L6
    }

    void setStartDreamImmediatelyOnDock(boolean startDreamImmediatelyOnDock) {
        this.mStartDreamImmediatelyOnDock = startDreamImmediatelyOnDock;
    }

    void setDreamsDisabledByAmbientModeSuppression(boolean disabledByAmbientModeSuppression) {
        this.mDreamsDisabledByAmbientModeSuppression = disabledByAmbientModeSuppression;
    }

    void setCurrentUser(int currentUserId) {
        this.mCurrentUser = currentUserId;
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        this.mCurrentUser = to.getUserIdentifier();
        if (this.mNightMode.get() != 0) goto L5;
        persistComputedNightMode(from.getUserIdentifier());
    L5:
        getContext().getContentResolver().unregisterContentObserver(this.mSetupWizardObserver);
        verifySetupWizardCompleted();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPendingResetNightModeOverrideByAutoBoundary = false;     // Catch: Throwable -> L11
        this.mPendingResetNightModeOverrideUser = 0;     // Catch: Throwable -> L11
        updateNightModeFromSettingsLocked(getContext(), getContext().getResources(), to.getUserIdentifier());     // Catch: Throwable -> L11
        updateLocked(0, 0);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L20;
        Object r0 = this.mLock;
        monitor-enter(r0);
        Context context = getContext();     // Catch: Throwable -> L9
        boolean r2 = true;
        this.mSystemReady = true;     // Catch: Throwable -> L9
        this.mKeyguardManager = (KeyguardManager) context.getSystemService(KeyguardManager.class);     // Catch: Throwable -> L9
        this.mPowerManager = (PowerManager) context.getSystemService("power");     // Catch: Throwable -> L9
        this.mWakeLock = this.mPowerManager.newWakeLock(26, TAG);     // Catch: Throwable -> L9
        this.mWindowManager = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);     // Catch: Throwable -> L9
        this.mActivityTaskManager = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);     // Catch: Throwable -> L9
        this.mAlarmManager = (AlarmManager) getContext().getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);     // Catch: Throwable -> L9
        TwilightManager twilightManager = (TwilightManager) getLocalService(TwilightManager.class);     // Catch: Throwable -> L9
        if (twilightManager == null) goto L11;
        this.mTwilightManager = twilightManager;     // Catch: Throwable -> L9
    L11:
        this.mLocalPowerManager = (PowerManagerInternal) LocalServices.getService(PowerManagerInternal.class);     // Catch: Throwable -> L9
        this.mDreamManagerInternal = (DreamManagerInternal) LocalServices.getService(DreamManagerInternal.class);     // Catch: Throwable -> L9
        initPowerSave();     // Catch: Throwable -> L9
        if (this.mDockState == 2) goto L15;
        r2 = false;
    L15:
        this.mCarModeEnabled = r2;     // Catch: Throwable -> L9
        registerVrStateListener();     // Catch: Throwable -> L9
        context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("ui_night_mode"), false, this.mDarkThemeObserver, 0);     // Catch: Throwable -> L9
        context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("contrast_level"), false, this.mContrastObserver, -1);     // Catch: Throwable -> L9
        context.registerReceiver(this.mDockModeReceiver, new IntentFilter("android.intent.action.DOCK_EVENT"));     // Catch: Throwable -> L9
        IntentFilter batteryFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");     // Catch: Throwable -> L9
        context.registerReceiver(this.mBatteryReceiver, batteryFilter);     // Catch: Throwable -> L9
        context.registerReceiver(this.mSettingsRestored, new IntentFilter("android.os.action.SETTING_RESTORED"));     // Catch: Throwable -> L9
        context.registerReceiver(this.mOnShutdown, new IntentFilter("android.intent.action.ACTION_SHUTDOWN"));     // Catch: Throwable -> L9
        updateConfigurationLocked();     // Catch: Throwable -> L9
        applyConfigurationExternallyLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        final Context context = getContext();
        verifySetupWizardCompleted();
        final Resources res = context.getResources();
        this.mNightMode.set(res.getInteger(R.integer.config_defaultRingVibrationIntensity));
        this.mStartDreamImmediatelyOnDock = res.getBoolean(R.bool.config_supportMicNearUltrasound);
        this.mDreamsDisabledByAmbientModeSuppression = res.getBoolean(R.bool.config_dreamsOnlyEnabledForDockUser);
        this.mDefaultUiModeType = res.getInteger(R.integer.config_displayWhiteBalanceBrightnessFilterHorizon);
        boolean r3 = false;
        if (res.getInteger(R.integer.config_datause_threshold_bytes) != 1) goto L5;
        boolean r2 = true;
    L6:
        this.mCarModeKeepsScreenOn = r2;
        if (res.getInteger(R.integer.config_displayWhiteBalanceDecreaseDebounce) != 1) goto L9;
        boolean r4 = true;
    L10:
        this.mDeskModeKeepsScreenOn = r4;
        this.mEnableCarDockLaunch = res.getBoolean(R.bool.config_enableDefaultHdrConversionPassthrough);
        this.mUiModeLocked = res.getBoolean(R.bool.config_mainBuiltInDisplayIsRound);
        this.mNightModeLocked = res.getBoolean(R.bool.config_magnification_keep_zoom_level_when_context_changed);
        PackageManager pm = context.getPackageManager();
        if (pm.hasSystemFeature("android.hardware.type.television") == false) goto L13;
    L14:
        r3 = true;
    L15:
        this.mTelevision = r3;
        this.mCar = pm.hasSystemFeature("android.hardware.type.automotive");
        this.mWatch = pm.hasSystemFeature("android.hardware.type.watch");
        SystemServerInitThreadPool.submit(new UiModeManagerService$$ExternalSyntheticLambda0(this, context, res), TAG + ".onStart");
        publishBinderService("uimode", this.mService);
        publishLocalService(UiModeManagerInternal.class, this.mLocalService);
        return;
    L13:
        if (pm.hasSystemFeature("android.software.leanback") == false) goto L15;
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private /* synthetic */ void lambda$onStart$2(Context context, Resources res) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        TwilightManager twilightManager = (TwilightManager) getLocalService(TwilightManager.class);     // Catch: Throwable -> L7
        if (twilightManager == null) goto L9;
        this.mTwilightManager = twilightManager;     // Catch: Throwable -> L7
    L9:
        updateNightModeFromSettingsLocked(context, res, UserHandle.getCallingUserId());     // Catch: Throwable -> L7
        updateSystemProperties();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void persistComputedNightMode(int r4) {
        Settings.Secure.putIntForUser(getContext().getContentResolver(), "ui_night_mode_last_computed", this.mComputedNightMode ? 1 : 0, r4);
    }

    private void initPowerSave() {
        this.mPowerSave = this.mLocalPowerManager.getLowPowerState(16).batterySaverEnabled;
        this.mLocalPowerManager.registerLowPowerModeObserver(16, new UiModeManagerService$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$initPowerSave$3(PowerSaveState state) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPowerSave != state.batterySaverEnabled) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPowerSave = state.batterySaverEnabled;     // Catch: Throwable -> L8
        if (this.mSystemReady == false) goto L13;
        updateLocked(0, 0);     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    protected IUiModeManager getService() {
        return this.mService;
    }

    protected Configuration getConfiguration() {
        return this.mConfiguration;
    }

    private void verifySetupWizardCompleted() {
        Context context = getContext();
        int userId = UserHandle.getCallingUserId();
        if (setupWizardCompleteForCurrentUser() == true) goto L5;
        this.mSetupWizardComplete = false;
        context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("user_setup_complete"), false, this.mSetupWizardObserver, userId);
        return;
    L5:
        this.mSetupWizardComplete = true;
    }

    private boolean setupWizardCompleteForCurrentUser() {
        if (Settings.Secure.getIntForUser(getContext().getContentResolver(), "user_setup_complete", 0, UserHandle.getCallingUserId()) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void updateCustomTimeLocked() {
        if (this.mNightMode.get() == 3) goto L6;
        return;
    L6:
        if (shouldApplyAutomaticChangesImmediately() == false) goto L8;
        updateLocked(0, 0);
    L9:
        scheduleNextCustomTimeListener();
        return;
    L8:
        registerDeviceInactiveListenerLocked();
        goto L9
    }

    private void updateNightModeFromSettingsLocked(Context context, Resources res, int userId) {
        if (this.mCarModeEnabled == false) goto L5;
        return;
    L5:
        if (this.mCar == false) goto L8;
        return;
    L8:
        if (this.mSetupWizardComplete == false) goto L25;
        this.mNightMode.set(Settings.Secure.getIntForUser(context.getContentResolver(), "ui_night_mode", res.getInteger(R.integer.config_defaultRingVibrationIntensity), userId));
        this.mNightModeCustomType = Settings.Secure.getIntForUser(context.getContentResolver(), "ui_night_mode_custom_type", -1, userId);
        boolean r2 = false;
        if (Settings.Secure.getIntForUser(context.getContentResolver(), "ui_night_mode_override_on", 0, userId) == 0) goto L12;
        boolean r0 = true;
    L13:
        this.mOverrideNightModeOn = r0;
        if (Settings.Secure.getIntForUser(context.getContentResolver(), "ui_night_mode_override_off", 0, userId) == 0) goto L16;
        boolean r1 = true;
    L17:
        this.mOverrideNightModeOff = r1;
        this.mCustomAutoNightModeStartMilliseconds = LocalTime.ofNanoOfDay(Settings.Secure.getLongForUser(context.getContentResolver(), "dark_theme_custom_start_time", this.DEFAULT_CUSTOM_NIGHT_START_TIME.toNanoOfDay() / 1000, userId) * 1000);
        this.mCustomAutoNightModeEndMilliseconds = LocalTime.ofNanoOfDay(Settings.Secure.getLongForUser(context.getContentResolver(), "dark_theme_custom_end_time", this.DEFAULT_CUSTOM_NIGHT_END_TIME.toNanoOfDay() / 1000, userId) * 1000);
        if (this.mNightMode.get() == 0) goto L20;
        return;
    L20:
        if (Settings.Secure.getIntForUser(context.getContentResolver(), "ui_night_mode_last_computed", 0, userId) == 0) goto L22;
        r2 = true;
    L22:
        this.mComputedNightMode = r2;
        return;
    L16:
        r1 = false;
        goto L17
    L12:
        r0 = false;
        goto L13
    }

    private static long toMilliSeconds(LocalTime t) {
        return t.toNanoOfDay() / 1000;
    }

    private static LocalTime fromMilliseconds(long t) {
        return LocalTime.ofNanoOfDay(1000 * t);
    }

    private void registerDeviceInactiveListenerLocked() {
        if (this.mPowerSave == false) goto L5;
        return;
    L5:
        this.mWaitForDeviceInactive = true;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.DREAMING_STARTED");
        getContext().registerReceiver(this.mDeviceInactiveListener, intentFilter);
    }

    private void cancelCustomAlarm() {
        this.mAlarmManager.cancel(this.mCustomTimeListener);
    }

    private void unregisterDeviceInactiveListenerLocked() {
        this.mWaitForDeviceInactive = false;
        getContext().unregisterReceiver(this.mDeviceInactiveListener);     // Catch: IllegalArgumentException -> L5
        return;
    }

    private void registerTimeChangeEvent() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        getContext().registerReceiver(this.mOnTimeChangedHandler, intentFilter);
    }

    private void unregisterTimeChangeEvent() {
        getContext().unregisterReceiver(this.mOnTimeChangedHandler);     // Catch: IllegalArgumentException -> L4
        return;
    }

    private void enforceProjectionTypePermissions(int p) {
        if ((p & 1) == 0) goto L6;
        getContext().enforceCallingPermission("android.permission.TOGGLE_AUTOMOTIVE_PROJECTION", "toggleProjection");
        return;
    }

    private static void assertSingleProjectionType(int p) {
        if (((p - 1) & p) != 0) goto L5;
        boolean projectionTypeIsPowerOfTwoOrZero = true;
    L6:
        if (p == 0) goto L10;
        if (projectionTypeIsPowerOfTwoOrZero == false) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("Must specify exactly one projection type.");
    L5:
        projectionTypeIsPowerOfTwoOrZero = false;
        goto L6
    }

    private static List<String> toPackageNameList(Collection<ProjectionHolder> c) {
        List<String> packageNames = new ArrayList();
        Iterator<ProjectionHolder> r1 = c.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ProjectionHolder p = r1.next();
        packageNames.add(ProjectionHolder.m497$$Nest$fgetmPackageName(p));
        goto L4
    L6:
        return packageNames;
    }

    private int populateWithRelevantActivePackageNames(int projectionType, List<String> packageNames) {
        packageNames.clear();
        int projectionTypeFlag = 0;
        if (this.mProjectionHolders == null) goto L13;
        int i = 0;
    L6:
        if (i >= this.mProjectionHolders.size()) goto L13;
        int key = this.mProjectionHolders.keyAt(i);
        List<ProjectionHolder> holders = this.mProjectionHolders.valueAt(i);
        if ((projectionType & key) == 0) goto L12;
        if (packageNames.addAll(toPackageNameList(holders)) == false) goto L12;
        projectionTypeFlag = projectionTypeFlag | key;
    L12:
        i = i + 1;
    L13:
        return projectionTypeFlag;
    }

    private boolean releaseProjectionUnchecked(int projectionType, String pkg) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean removed = false;
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.mProjectionHolders == null) goto L17;
        List<ProjectionHolder> holders = this.mProjectionHolders.get(projectionType);     // Catch: Throwable -> L14
        if (holders == null) goto L17;
        int i = holders.size() - 1;     // Catch: Throwable -> L14
    L10:
        if (i < 0) goto L17;
        ProjectionHolder holder = holders.get(i);     // Catch: Throwable -> L14
        if (pkg.equals(ProjectionHolder.m497$$Nest$fgetmPackageName(holder)) == false) goto L16;
        ProjectionHolder.m499$$Nest$munlinkToDeath(holder);     // Catch: Throwable -> L14
        Slog.d(TAG, "Projection type " + projectionType + " released by " + pkg + ".");     // Catch: Throwable -> L14
        holders.remove(i);     // Catch: Throwable -> L14
        removed = true;
    L16:
        i = i - 1;     // Catch: Throwable -> L14
    L17:
        if (removed == false) goto L19;
        onProjectionStateChangedLocked(projectionType);     // Catch: Throwable -> L14
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return removed;
    L19:
        Slog.w(TAG, pkg + " tried to release projection type " + projectionType + " but was not set by that package.");     // Catch: Throwable -> L14
        goto L20
    }

    private int getForceInvertStateLocked() {
        if (this.mForceInvertStates.indexOfKey(this.mCurrentUser) >= 0) goto L8;
        if (this.mSystemReady == false) goto L8;
        updateForceInvertStateLocked();
    L8:
        return this.mForceInvertStates.get(this.mCurrentUser, 0);
    }

    private boolean updateForceInvertStateLocked() {
        int forceInvertState = getForceInvertStateInternal();
        if (this.mForceInvertStates.get(this.mCurrentUser, Integer.MIN_VALUE) == forceInvertState) goto L6;
        this.mForceInvertStates.put(this.mCurrentUser, forceInvertState);
        return true;
    L6:
        return false;
    }

    private int getForceInvertStateInternal() {
        return 0;
    }

    private boolean isSystemInDarkTheme() {
        Context sysUiContext = ActivityThread.currentActivityThread().getSystemUiContext();
        int sysUiNightMode = sysUiContext.getResources().getConfiguration().uiMode & 48;
        if (sysUiNightMode != 32) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isForceInvert() {
        if (Settings.Secure.getIntForUser(getContext().getContentResolver(), "accessibility_force_invert_color_enabled", 0, this.mCurrentUser) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private float getContrastLocked() {
        if (this.mContrasts.contains(this.mCurrentUser) == true) goto L6;
        updateContrastLocked();
    L6:
        return this.mContrasts.get(this.mCurrentUser).floatValue();
    }

    private boolean updateContrastLocked() {
        float contrast = Settings.Secure.getFloatForUser(getContext().getContentResolver(), "contrast_level", 0.0f, this.mCurrentUser);
        if (Math.abs(this.mContrasts.get(this.mCurrentUser, Float.valueOf(Float.MAX_VALUE)).floatValue() - contrast) < 1.0E-10d) goto L6;
        this.mContrasts.put(this.mCurrentUser, Float.valueOf(contrast));
        return true;
    L6:
        return false;
    }

    private void assertLegit(String packageName) {
        if (doesPackageHaveCallingUid(packageName) == false) goto L6;
        return;
    L6:
        throw new SecurityException("Caller claimed bogus packageName: " + packageName + ".");
    }

    private boolean doesPackageHaveCallingUid(String packageName) {
        int callingUid = this.mInjector.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        long ident = Binder.clearCallingIdentity();
        boolean r4 = false;
        if (getContext().getPackageManager().getPackageUidAsUser(packageName, callingUserId) != callingUid) goto L6;
        r4 = true;
    L6:
        Binder.restoreCallingIdentity(ident);
        return r4;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L14:
        Binder.restoreCallingIdentity(ident);
        return false;
    }

    private void onProjectionStateChangedLocked(int changedProjectionType) {
        if (this.mProjectionListeners != null) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= this.mProjectionListeners.size()) goto L20;
        int listenerProjectionType = this.mProjectionListeners.keyAt(i);
        if ((changedProjectionType & listenerProjectionType) == 0) goto L18;
        RemoteCallbackList<IOnProjectionStateChangedListener> listeners = this.mProjectionListeners.valueAt(i);
        List<String> packageNames = new ArrayList();
        int activeProjectionTypes = populateWithRelevantActivePackageNames(listenerProjectionType, packageNames);
        int listenerCount = listeners.beginBroadcast();
        int j = 0;
    L11:
        if (j >= listenerCount) goto L17;
        listeners.getBroadcastItem(j).onProjectionStateChanged(activeProjectionTypes, packageNames);     // Catch: RemoteException -> L14
    L16:
        j = j + 1;
    L15:
        Slog.w(TAG, "Failed a call to onProjectionStateChanged().");
        goto L16
    L17:
        listeners.finishBroadcast();
    L18:
        i = i + 1;
        goto L7
    }

    private void onCustomTimeUpdated(int user) {
        persistNightMode(user);
        if (this.mNightMode.get() == 3) goto L6;
        return;
    L6:
        if (shouldApplyAutomaticChangesImmediately() == false) goto L8;
        unregisterDeviceInactiveListenerLocked();
        updateLocked(0, 0);
        return;
    L8:
        registerDeviceInactiveListenerLocked();
    }

    void dumpImpl(PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("Current UI Mode Service state:");     // Catch: Throwable -> L8
        pw.print("  mDockState=");     // Catch: Throwable -> L8
        pw.print(this.mDockState);     // Catch: Throwable -> L8
        pw.print(" mLastBroadcastState=");     // Catch: Throwable -> L8
        pw.println(this.mLastBroadcastState);     // Catch: Throwable -> L8
        pw.print(" mStartDreamImmediatelyOnDock=");     // Catch: Throwable -> L8
        pw.print(this.mStartDreamImmediatelyOnDock);     // Catch: Throwable -> L8
        pw.print("  mNightMode=");     // Catch: Throwable -> L8
        pw.print(this.mNightMode.get());     // Catch: Throwable -> L8
        pw.print(" (");     // Catch: Throwable -> L8
        pw.print(Shell.m500$$Nest$smnightModeToStr(this.mNightMode.get(), this.mNightModeCustomType));     // Catch: Throwable -> L8
        pw.print(") ");     // Catch: Throwable -> L8
        pw.print(" mOverrideOn/Off=");     // Catch: Throwable -> L8
        pw.print(this.mOverrideNightModeOn);     // Catch: Throwable -> L8
        pw.print(SliceClientPermissions.SliceAuthority.DELIMITER);     // Catch: Throwable -> L8
        pw.print(this.mOverrideNightModeOff);     // Catch: Throwable -> L8
        pw.print("  mAttentionModeThemeOverlay=");     // Catch: Throwable -> L8
        pw.print(this.mAttentionModeThemeOverlay);     // Catch: Throwable -> L8
        pw.print(" mNightModeLocked=");     // Catch: Throwable -> L8
        pw.println(this.mNightModeLocked);     // Catch: Throwable -> L8
        pw.print("  mCarModeEnabled=");     // Catch: Throwable -> L8
        pw.print(this.mCarModeEnabled);     // Catch: Throwable -> L8
        pw.print(" (carModeApps=");     // Catch: Throwable -> L8
        Iterator<Map.Entry<Integer, String>> r1 = this.mCarModePackagePriority.entrySet().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<Integer, String> entry = r1.next();     // Catch: Throwable -> L8
        pw.print(entry.getKey());     // Catch: Throwable -> L8
        pw.print(":");     // Catch: Throwable -> L8
        pw.print(entry.getValue());     // Catch: Throwable -> L8
        pw.print(" ");     // Catch: Throwable -> L8
        goto L6
    L10:
        pw.println("");     // Catch: Throwable -> L8
        pw.print(" mWaitForDeviceInactive=");     // Catch: Throwable -> L8
        pw.print(this.mWaitForDeviceInactive);     // Catch: Throwable -> L8
        pw.print(" mComputedNightMode=");     // Catch: Throwable -> L8
        pw.print(this.mComputedNightMode);     // Catch: Throwable -> L8
        pw.print(" customStart=");     // Catch: Throwable -> L8
        pw.print(this.mCustomAutoNightModeStartMilliseconds);     // Catch: Throwable -> L8
        pw.print(" customEnd");     // Catch: Throwable -> L8
        pw.print(this.mCustomAutoNightModeEndMilliseconds);     // Catch: Throwable -> L8
        pw.print(" mCarModeEnableFlags=");     // Catch: Throwable -> L8
        pw.print(this.mCarModeEnableFlags);     // Catch: Throwable -> L8
        pw.print(" mEnableCarDockLaunch=");     // Catch: Throwable -> L8
        pw.println(this.mEnableCarDockLaunch);     // Catch: Throwable -> L8
        pw.print("  mCurUiMode=0x");     // Catch: Throwable -> L8
        pw.print(Integer.toHexString(this.mCurUiMode.get()));     // Catch: Throwable -> L8
        pw.print(" mUiModeLocked=");     // Catch: Throwable -> L8
        pw.print(this.mUiModeLocked);     // Catch: Throwable -> L8
        pw.print(" mSetUiMode=0x");     // Catch: Throwable -> L8
        pw.println(Integer.toHexString(this.mSetUiMode));     // Catch: Throwable -> L8
        pw.print("  mHoldingConfiguration=");     // Catch: Throwable -> L8
        pw.print(this.mHoldingConfiguration);     // Catch: Throwable -> L8
        pw.print(" mSystemReady=");     // Catch: Throwable -> L8
        pw.println(this.mSystemReady);     // Catch: Throwable -> L8
        if (this.mTwilightManager == null) goto L13;
        pw.print("  mTwilightService.getLastTwilightState()=");     // Catch: Throwable -> L8
        pw.println(this.mTwilightManager.getLastTwilightState());     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void setCarModeLocked(boolean enabled, int flags, int priority, String packageName) {
        if (enabled == false) goto L4;
        enableCarMode(priority, packageName);
    L5:
        boolean isCarModeNowEnabled = isCarModeEnabled();
        if (this.mCarModeEnabled == isCarModeNowEnabled) goto L10;
        this.mCarModeEnabled = isCarModeNowEnabled;
        if (isCarModeNowEnabled == true) goto L10;
        Context context = getContext();
        updateNightModeFromSettingsLocked(context, context.getResources(), UserHandle.getCallingUserId());
    L10:
        this.mCarModeEnableFlags = flags;
        return;
    L4:
        disableCarMode(flags, priority, packageName);
        goto L5
    }

    private void disableCarMode(int flags, int priority, String packageName) {
        boolean isChangeAllowed = false;
        if ((flags & 2) == 0) goto L5;
        boolean isDisableAll = true;
    L6:
        boolean isPriorityTracked = this.mCarModePackagePriority.keySet().contains(Integer.valueOf(priority));
        if (priority != 0) goto L9;
        boolean isDefaultPriority = true;
    L11:
        if (isDefaultPriority == true) goto L16;
        if (isPriorityTracked == true) goto L14;
    L15:
        if (isDisableAll == true) goto L16;
    L17:
        if (isChangeAllowed == false) goto L28;
        Slog.d(TAG, "disableCarMode: disabling, priority=" + priority + ", packageName=" + packageName);
        if (isDisableAll == false) goto L25;
        Set<Map.Entry<Integer, String>> entries = new ArraySet(this.mCarModePackagePriority.entrySet());
        this.mCarModePackagePriority.clear();
        Iterator<Map.Entry<Integer, String>> r5 = entries.iterator();
    L22:
        if (r5.hasNext() == false) goto L29;
        Map.Entry<Integer, String> entry = r5.next();
        notifyCarModeDisabled(entry.getKey().intValue(), entry.getValue());
        goto L22
    L29:
        return;
    L25:
        this.mCarModePackagePriority.remove(Integer.valueOf(priority));
        notifyCarModeDisabled(priority, packageName);
        return;
    L28:
        return;
    L14:
        if (this.mCarModePackagePriority.get(Integer.valueOf(priority)).equals(packageName) == false) goto L15;
    L16:
        isChangeAllowed = true;
        goto L17
    L9:
        isDefaultPriority = false;
        goto L11
    L5:
        isDisableAll = false;
        goto L6
    }

    private void enableCarMode(int priority, String packageName) {
        boolean isPriorityTracked = this.mCarModePackagePriority.containsKey(Integer.valueOf(priority));
        boolean isPackagePresent = this.mCarModePackagePriority.containsValue(packageName);
        if (isPriorityTracked == true) goto L6;
        if (isPackagePresent == true) goto L6;
        Slog.d(TAG, "enableCarMode: enabled at priority=" + priority + ", packageName=" + packageName);
        this.mCarModePackagePriority.put(Integer.valueOf(priority), packageName);
        notifyCarModeEnabled(priority, packageName);
        return;
    L6:
        Slog.d(TAG, "enableCarMode: car mode at priority " + priority + " already enabled.");
    }

    private void notifyCarModeEnabled(int priority, String packageName) {
        Intent intent = new Intent("android.app.action.ENTER_CAR_MODE_PRIORITIZED");
        intent.putExtra("android.app.extra.CALLING_PACKAGE", packageName);
        intent.putExtra("android.app.extra.PRIORITY", priority);
        getContext().sendBroadcastAsUser(intent, UserHandle.ALL, "android.permission.HANDLE_CAR_MODE_CHANGES");
    }

    private void notifyCarModeDisabled(int priority, String packageName) {
        Intent intent = new Intent("android.app.action.EXIT_CAR_MODE_PRIORITIZED");
        intent.putExtra("android.app.extra.CALLING_PACKAGE", packageName);
        intent.putExtra("android.app.extra.PRIORITY", priority);
        getContext().sendBroadcastAsUser(intent, UserHandle.ALL, "android.permission.HANDLE_CAR_MODE_CHANGES");
    }

    private boolean isCarModeEnabled() {
        if (this.mCarModePackagePriority.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateDockState(int newState) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (newState == this.mDockState) goto L15;
        this.mDockState = newState;     // Catch: Throwable -> L13
        if (this.mDockState != 2) goto L9;
        boolean r1 = true;
    L10:
        setCarModeLocked(r1, 0, 0, "");     // Catch: Throwable -> L13
        if (this.mSystemReady == false) goto L15;
        updateLocked(1, 0);     // Catch: Throwable -> L13
        goto L15
    L9:
        r1 = false;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    private static boolean isDeskDockState(int state) {
        switch(state) {
            case 1: goto L5;
            case 2: goto L3;
            case 3: goto L5;
            case 4: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    private void persistNightMode(int user) {
        if (this.mCarModeEnabled == false) goto L5;
        return;
    L5:
        if (this.mCar == true) goto L10;
        Settings.Secure.putIntForUser(getContext().getContentResolver(), "ui_night_mode", this.mNightMode.get(), user);
        Settings.Secure.putLongForUser(getContext().getContentResolver(), "ui_night_mode_custom_type", this.mNightModeCustomType, user);
        Settings.Secure.putLongForUser(getContext().getContentResolver(), "dark_theme_custom_start_time", this.mCustomAutoNightModeStartMilliseconds.toNanoOfDay() / 1000, user);
        Settings.Secure.putLongForUser(getContext().getContentResolver(), "dark_theme_custom_end_time", this.mCustomAutoNightModeEndMilliseconds.toNanoOfDay() / 1000, user);
        return;
    }

    private void persistNightModeOverrides(int r4) {
        if (this.mCarModeEnabled == false) goto L5;
        return;
    L5:
        if (this.mCar == true) goto L10;
        Settings.Secure.putIntForUser(getContext().getContentResolver(), "ui_night_mode_override_on", this.mOverrideNightModeOn ? 1 : 0, r4);
        Settings.Secure.putIntForUser(getContext().getContentResolver(), "ui_night_mode_override_off", this.mOverrideNightModeOff ? 1 : 0, r4);
        return;
    }

    private void updateConfigurationLocked() {
        int uiMode = this.mDefaultUiModeType;
        if (this.mUiModeLocked == false) goto L6;
    L20:
        boolean r3 = false;
        if (this.mPendingResetNightModeOverrideByAutoBoundary == false) goto L41;
        if (this.mPendingResetNightModeOverrideUser != this.mCurrentUser) goto L25;
        boolean userMatch = true;
    L27:
        if (this.mNightMode.get() != 0) goto L29;
    L34:
        boolean modeMatch = true;
    L36:
        if (userMatch == false) goto L39;
        if (modeMatch == false) goto L39;
        resetNightModeOverrideLocked();
    L39:
        this.mPendingResetNightModeOverrideByAutoBoundary = false;
        this.mPendingResetNightModeOverrideUser = 0;
        goto L41
    L29:
        if (this.mNightMode.get() == 3) goto L31;
    L33:
        modeMatch = false;
        goto L36
    L31:
        if (this.mNightModeCustomType != 0) goto L33;
    L25:
        userMatch = false;
    L41:
        if (this.mNightMode.get() == 2) goto L45;
        if (this.mNightMode.get() == 1) goto L45;
    L49:
        if (this.mNightMode.get() != 0) goto L59;
        boolean activateNightMode = this.mComputedNightMode;
        if (this.mTwilightManager == null) goto L57;
        this.mTwilightManager.registerListener(this.mTwilightListener, this.mHandler);
        TwilightState lastState = this.mTwilightManager.getLastTwilightState();
        if (lastState != null) goto L55;
        boolean r5 = this.mComputedNightMode;
    L56:
        activateNightMode = r5;
        goto L57
    L55:
        r5 = lastState.isNight();
    L57:
        updateComputedNightModeLocked(activateNightMode);
    L62:
        if (this.mNightMode.get() == 3) goto L64;
        unregisterTimeChangeEvent();
    L69:
        if (this.mPowerSave == true) goto L71;
    L75:
        int uiMode2 = getComputedUiModeConfiguration(uiMode);
    L76:
        this.mCurUiMode.set(uiMode2);
        if (this.mHoldingConfiguration == false) goto L79;
        return;
    L79:
        if (this.mWaitForDeviceInactive == true) goto L81;
    L82:
        this.mConfiguration.uiMode = uiMode2;
        return;
    L81:
        if (this.mPowerSave == true) goto L82;
        return;
    L71:
        if (this.mCarModeEnabled == true) goto L75;
        if (this.mCar == true) goto L75;
        uiMode2 = (uiMode & (-17)) | 32;
        goto L76
    L64:
        if (this.mNightModeCustomType != 1) goto L66;
        updateComputedNightModeLocked(this.mLastBedtimeRequestedNightMode);
        goto L69
    L66:
        registerTimeChangeEvent();
        boolean activate = computeCustomNightMode();
        updateComputedNightModeLocked(activate);
        scheduleNextCustomTimeListener();
        goto L69
    L59:
        if (this.mTwilightManager == null) goto L62;
        this.mTwilightManager.unregisterListener(this.mTwilightListener);
    L45:
        if (this.mNightMode.get() != 2) goto L47;
        r3 = true;
    L47:
        updateComputedNightModeLocked(r3);
        goto L49
    L6:
        if (this.mTelevision == false) goto L9;
        uiMode = 4;
        goto L20
    L9:
        if (this.mWatch == false) goto L12;
        uiMode = 6;
        goto L20
    L12:
        if (this.mCarModeEnabled == false) goto L15;
        uiMode = 3;
        goto L20
    L15:
        if (isDeskDockState(this.mDockState) == false) goto L18;
        uiMode = 2;
        goto L20
    L18:
        if (this.mVrHeadset == false) goto L20;
        uiMode = 7;
        goto L20
    }

    private int getComputedUiModeConfiguration(int uiMode) {
        if (this.mComputedNightMode == false) goto L5;
        int r0 = 32;
    L6:
        int uiMode2 = uiMode | r0;
        if (this.mComputedNightMode == false) goto L9;
        int r1 = -17;
    L11:
        return uiMode2 & r1;
    L9:
        r1 = -33;
        goto L11
    L5:
        r0 = 16;
        goto L6
    }

    private boolean computeCustomNightMode() {
        return TimeUtils.isTimeBetween(LocalTime.now(), this.mCustomAutoNightModeStartMilliseconds, this.mCustomAutoNightModeEndMilliseconds);
    }

    private void applyConfigurationExternallyLocked() {
        if (this.mSetUiMode == this.mConfiguration.uiMode) goto L13;
        this.mSetUiMode = this.mConfiguration.uiMode;
        this.mWindowManager.clearSnapshotCache();
        ActivityTaskManager.getService().updateConfiguration(this.mConfiguration);     // Catch: SecurityException -> L7 RemoteException -> L9
    L17:
        return;
    L9:
        e = move-exception;
        Slog.w(TAG, "Failure communicating with activity manager", e);
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "Activity does not have the ", e);
        return;
    }

    private boolean shouldApplyAutomaticChangesImmediately() {
        if (this.mCar == false) goto L5;
        return true;
    L5:
        if (this.mPowerManager.isInteractive() == true) goto L7;
        return true;
    L7:
        if (this.mNightModeCustomType != 1) goto L9;
        return true;
    L9:
        if (this.mDreamManagerInternal.isDreaming() == true) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.time.ZonedDateTime] */
    private void scheduleNextCustomTimeListener() {
        cancelCustomAlarm();
        LocalDateTime now = LocalDateTime.now();
        boolean active = computeCustomNightMode();
        if (active == false) goto L5;
        LocalDateTime next = getDateTimeAfter(this.mCustomAutoNightModeEndMilliseconds, now);
    L6:
        long millis = next.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        this.mAlarmManager.setExact(1, millis, TAG, this.mCustomTimeListener, null);
        return;
    L5:
        next = getDateTimeAfter(this.mCustomAutoNightModeStartMilliseconds, now);
        goto L6
    }

    private LocalDateTime getDateTimeAfter(LocalTime localTime, LocalDateTime compareTime) {
        LocalDateTime ldt = LocalDateTime.of(compareTime.toLocalDate(), localTime);
        if (ldt.isBefore(compareTime) == false) goto L6;
        return ldt.plusDays(1);
    L6:
        return ldt;
    }

    void updateLocked(int enableFlags, int disableFlags) {
        String action = null;
        String oldAction = null;
        if (this.mLastBroadcastState != 2) goto L6;
        adjustStatusBarCarModeLocked();
        oldAction = UiModeManager.ACTION_EXIT_CAR_MODE;
    L8:
        boolean keepScreenOn = false;
        if (this.mCarModeEnabled == false) goto L17;
        if (this.mLastBroadcastState == 2) goto L25;
        adjustStatusBarCarModeLocked();
        if (oldAction == null) goto L15;
        sendForegroundBroadcastToAllUsers(oldAction);
    L15:
        this.mLastBroadcastState = 2;
        action = UiModeManager.ACTION_ENTER_CAR_MODE;
    L25:
        if (action == null) goto L27;
        Intent intent = new Intent(action);
        intent.putExtra("enableFlags", enableFlags);
        intent.putExtra("disableFlags", disableFlags);
        intent.addFlags(268435456);
        getContext().sendOrderedBroadcastAsUser(intent, UserHandle.CURRENT, null, this.mResultReceiver, null, -1, null, null);
        this.mHoldingConfiguration = true;
        updateConfigurationLocked();
    L44:
        if (this.mCharging == false) goto L58;
        if (this.mCarModeEnabled == false) goto L52;
        if (this.mCarModeKeepsScreenOn == false) goto L52;
        if ((this.mCarModeEnableFlags & 2) != 0) goto L52;
    L55:
        keepScreenOn = true;
    L52:
        if (this.mCurUiMode.get() != 2) goto L58;
        if (this.mDeskModeKeepsScreenOn == true) goto L55;
    L58:
        if (keepScreenOn == this.mWakeLock.isHeld()) goto L63;
        if (keepScreenOn == false) goto L61;
        this.mWakeLock.acquire();
        return;
    L61:
        this.mWakeLock.release();
        return;
    L63:
        return;
    L27:
        String category = null;
        if (this.mCarModeEnabled == false) goto L35;
        if (this.mEnableCarDockLaunch == true) goto L32;
    L42:
        sendConfigurationAndStartDreamOrDockAppLocked(category);
        goto L44
    L32:
        if ((enableFlags & 1) == 0) goto L42;
        category = "android.intent.category.CAR_DOCK";
        goto L42
    L35:
        if (isDeskDockState(this.mDockState) == false) goto L40;
        if ((enableFlags & 1) == 0) goto L42;
        category = "android.intent.category.DESK_DOCK";
        goto L42
    L40:
        if ((disableFlags & 1) == 0) goto L42;
        category = "android.intent.category.HOME";
        goto L42
    L17:
        if (isDeskDockState(this.mDockState) == true) goto L19;
        this.mLastBroadcastState = 0;
        action = oldAction;
        goto L25
    L19:
        if (isDeskDockState(this.mLastBroadcastState) == true) goto L25;
        if (oldAction == null) goto L22;
        sendForegroundBroadcastToAllUsers(oldAction);
    L22:
        this.mLastBroadcastState = this.mDockState;
        action = UiModeManager.ACTION_ENTER_DESK_MODE;
        goto L25
    L6:
        if (isDeskDockState(this.mLastBroadcastState) == false) goto L8;
        oldAction = UiModeManager.ACTION_EXIT_DESK_MODE;
        goto L8
    }

    private void sendForegroundBroadcastToAllUsers(String action) {
        getContext().sendBroadcastAsUser(new Intent(action).addFlags(268435456), UserHandle.ALL);
    }

    private void updateAfterBroadcastLocked(String action, int enableFlags, int disableFlags) {
        String category = null;
        if (UiModeManager.ACTION_ENTER_CAR_MODE.equals(action) == false) goto L10;
        if (this.mEnableCarDockLaunch == true) goto L7;
    L17:
        sendConfigurationAndStartDreamOrDockAppLocked(category);
        return;
    L7:
        if ((enableFlags & 1) == 0) goto L17;
        category = "android.intent.category.CAR_DOCK";
        goto L17
    L10:
        if (UiModeManager.ACTION_ENTER_DESK_MODE.equals(action) == false) goto L15;
        if ((enableFlags & 1) == 0) goto L17;
        category = "android.intent.category.DESK_DOCK";
        goto L17
    L15:
        if ((disableFlags & 1) == 0) goto L17;
        category = "android.intent.category.HOME";
        goto L17
    }

    private boolean shouldStartDockApp(Context context, Intent homeIntent) {
        if (this.mWatch == false) goto L9;
        if (this.mSetupWizardComplete == true) goto L9;
        return false;
    L9:
        return Sandman.shouldStartDockApp(context, homeIntent);
    }

    private void sendConfigurationAndStartDreamOrDockAppLocked(String category) {
        boolean dreamsSuppressed = false;
        this.mHoldingConfiguration = false;
        updateConfigurationLocked();
        boolean dockAppStarted = false;
        if (category == null) goto L17;
        Intent homeIntent = buildHomeIntent(category);
        if (shouldStartDockApp(getContext(), homeIntent) == false) goto L17;
        int result = ActivityTaskManager.getService().startActivityWithConfig(null, getContext().getBasePackageName(), getContext().getAttributionTag(), homeIntent, null, null, null, 0, 0, this.mConfiguration, null, -2);     // Catch: RemoteException -> L13
        if (ActivityManager.isStartResultSuccessful(result) == false) goto L10;
        dockAppStarted = true;
        goto L17
    L10:
        if (result == (-91)) goto L17;
        Slog.e(TAG, "Could not start dock app: " + homeIntent + ", startActivityWithConfig result " + result);     // Catch: RemoteException -> L13
    L13:
        ex = move-exception;
        Slog.e(TAG, "Could not start dock app: " + homeIntent, ex);
    L17:
        applyConfigurationExternallyLocked();
        if (this.mDreamsDisabledByAmbientModeSuppression == true) goto L20;
    L24:
        if (category == null) goto L37;
        if (dockAppStarted == true) goto L38;
        if (dreamsSuppressed == false) goto L28;
        return;
    L28:
        if (this.mStartDreamImmediatelyOnDock == false) goto L30;
    L33:
        this.mInjector.startDreamWhenDockedIfAppropriate(getContext());
        return;
    L30:
        if (this.mWindowManager.isKeyguardShowingAndNotOccluded() == true) goto L33;
        if (this.mPowerManager.isInteractive() == false) goto L33;
        return;
    L38:
        return;
    L37:
        return;
    L20:
        if (this.mLocalPowerManager.isAmbientDisplaySuppressed() == false) goto L24;
        dreamsSuppressed = true;
        goto L24
    }

    private void adjustStatusBarCarModeLocked() {
        Context context = getContext();
        if (this.mStatusBarManager != null) goto L6;
        this.mStatusBarManager = (StatusBarManager) context.getSystemService("statusbar");
    L6:
        if (this.mStatusBarManager == null) goto L13;
        StatusBarManager r1 = this.mStatusBarManager;
        if (this.mCarModeEnabled == false) goto L10;
        int r2 = 524288;
    L11:
        r1.disable(r2);
        goto L13
    L10:
        r2 = 0;
    L13:
        if (this.mNotificationManager != null) goto L16;
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
    L16:
        if (this.mNotificationManager != null) goto L18;
        return;
    L18:
        if (this.mCarModeEnabled == false) goto L20;
        Intent carModeOffIntent = new Intent(context, DisableCarModeActivity.class);
        Notification.Builder n = new Notification.Builder(context, "CAR_MODE").setSmallIcon(17305164).setDefaults(4).setOngoing(true).setWhen(0).setColor(context.getColor(R.color.system_notification_accent_color)).setContentTitle(context.getString(R.string.config_bodyFontFamily)).setContentText(context.getString(R.string.config_biometric_prompt_ui_package)).setContentIntent(PendingIntent.getActivityAsUser(context, 0, carModeOffIntent, 33554432, null, UserHandle.CURRENT));
        this.mNotificationManager.notifyAsUser(null, 10, n.build(), UserHandle.ALL);
        return;
    L20:
        this.mNotificationManager.cancelAsUser(null, 10, UserHandle.ALL);
    }

    private void updateComputedNightModeLocked(boolean activate) {
        boolean appliedOverrides = false;
        boolean r4 = false;
        if (this.mNightMode.get() == 2) goto L18;
        if (this.mNightMode.get() == 1) goto L18;
        if (this.mOverrideNightModeOn == false) goto L12;
        if (activate == true) goto L12;
        this.mComputedNightMode = true;
        return;
    L12:
        if (this.mOverrideNightModeOff == false) goto L16;
        if (activate == false) goto L16;
        this.mComputedNightMode = false;
        return;
    L16:
        appliedOverrides = true;
    L18:
        switch(this.mAttentionModeThemeOverlay) {
            case 1001: goto L21;
            case 1002: goto L22;
            default: goto L19;
        };
    L19:
        r4 = activate;
        goto L22
    L21:
        r4 = true;
    L22:
        this.mComputedNightMode = r4;
        if (appliedOverrides == false) goto L26;
        return;
    L26:
        if (this.mNightMode.get() == 0) goto L28;
    L31:
        resetNightModeOverrideLocked();
        return;
    L28:
        if (this.mTwilightManager != null) goto L30;
        return;
    L30:
        if (this.mTwilightManager.getLastTwilightState() != null) goto L31;
    }

    private boolean resetNightModeOverrideLocked() {
        if (this.mOverrideNightModeOff == false) goto L5;
    L8:
        this.mOverrideNightModeOff = false;
        this.mOverrideNightModeOn = false;
        persistNightModeOverrides(this.mOverrideNightModeUser);
        this.mOverrideNightModeUser = 0;
        return true;
    L5:
        if (this.mOverrideNightModeOn == true) goto L8;
        return false;
    }

    private void registerVrStateListener() {
        IVrManager vrManager = IVrManager.Stub.asInterface(ServiceManager.getService("vrmanager"));
        if (vrManager == null) goto L12;
        vrManager.registerListener(this.mVrStateCallbacks);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Failed to register VR mode state listener: " + e);
        return;
    }
}
