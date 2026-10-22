package com.android.server.vr;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AppOpsManager;
import android.app.INotificationManager;
import android.app.NotificationManager;
import android.app.Vr2dDisplayProperties;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.hardware.display.DisplayManager;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PackageTagsList;
import android.os.RemoteCallbackList;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.vr.IPersistentVrStateCallbacks;
import android.service.vr.IVrManager;
import android.service.vr.IVrStateCallbacks;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.SystemConfig;
import com.android.server.SystemService;
import com.android.server.am.ProcessList;
import com.android.server.input.KeyboardMetricsCollector;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import com.android.server.utils.LazyJniRegistrar;
import com.android.server.utils.ManagedApplicationService;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.WindowManagerInternal;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class VrManagerService extends SystemService implements EnabledComponentsObserver.EnabledComponentChangeListener, ActivityTaskManagerInternal.ScreenObserver {
    static final boolean DBG = false;
    private static final int EVENT_LOG_SIZE = 64;
    private static final int FLAG_ALL = 7;
    private static final int FLAG_AWAKE = 1;
    private static final int FLAG_KEYGUARD_UNLOCKED = 4;
    private static final int FLAG_NONE = 0;
    private static final int FLAG_SCREEN_ON = 2;
    private static final int INVALID_APPOPS_MODE = -1;
    private static final int MSG_PENDING_VR_STATE_CHANGE = 1;
    private static final int MSG_PERSISTENT_VR_MODE_STATE_CHANGE = 2;
    private static final int MSG_VR_STATE_CHANGE = 0;
    private static final int PENDING_STATE_DELAY_MS = 300;
    public static final String TAG = "VrManagerService";
    private static final ManagedApplicationService.BinderChecker sBinderChecker = null;
    private boolean mBootsToVr;
    private EnabledComponentsObserver mComponentObserver;
    private Context mContext;
    private ManagedApplicationService mCurrentVrCompositorService;
    private ComponentName mCurrentVrModeComponent;
    private int mCurrentVrModeUser;
    private ManagedApplicationService mCurrentVrService;
    private ComponentName mDefaultVrService;
    private final ManagedApplicationService.EventCallback mEventCallback;
    private boolean mGuard;
    private final Handler mHandler;
    private final Object mLock;
    private boolean mLogLimitHit;
    private final ArrayDeque<ManagedApplicationService.LogFormattable> mLoggingDeque;
    private final NotificationAccessManager mNotifAccessManager;
    private INotificationManager mNotificationManager;
    private final IBinder mOverlayToken;
    private VrState mPendingState;
    private boolean mPersistentVrModeEnabled;
    private final RemoteCallbackList<IPersistentVrStateCallbacks> mPersistentVrStateRemoteCallbacks;
    private int mPreviousCoarseLocationMode;
    private int mPreviousManageOverlayMode;
    private boolean mRunning2dInVr;
    private boolean mStandby;
    private int mSystemSleepFlags;
    private boolean mUseStandbyToExitVrMode;
    private boolean mUserUnlocked;
    private Vr2dDisplay mVr2dDisplay;
    private int mVrAppProcessId;
    private final IVrManager mVrManager;
    private boolean mVrModeAllowed;
    private boolean mVrModeEnabled;
    private final RemoteCallbackList<IVrStateCallbacks> mVrStateRemoteCallbacks;
    private boolean mWasDefaultGranted;

    private final class LocalService extends VrManagerInternal {
        final /* synthetic */ VrManagerService this$0;

        /* synthetic */ LocalService(VrManagerService r1, VrManagerServiceIA r2) {
            this(r1);
        }

        private LocalService(VrManagerService r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.vr.VrManagerInternal
        public void setVrMode(boolean enabled, ComponentName packageName, int userId, int processId, ComponentName callingPackage) {
            VrManagerService.m9497$$Nest$msetVrMode(this.this$0, enabled, packageName, userId, processId, callingPackage);
        }

        @Override // com.android.server.vr.VrManagerInternal
        public void onScreenStateChanged(boolean isScreenOn) {
            VrManagerService.m9494$$Nest$msetScreenOn(this.this$0, isScreenOn);
        }

        @Override // com.android.server.vr.VrManagerInternal
        public boolean isCurrentVrListener(String packageName, int userId) {
            return VrManagerService.m9485$$Nest$misCurrentVrListener(this.this$0, packageName, userId);
        }

        @Override // com.android.server.vr.VrManagerInternal
        public int hasVrPackage(ComponentName packageName, int userId) {
            return VrManagerService.m9484$$Nest$mhasVrPackage(this.this$0, packageName, userId);
        }

        @Override // com.android.server.vr.VrManagerInternal
        public void setPersistentVrModeEnabled(boolean enabled) {
            VrManagerService.m9493$$Nest$msetPersistentVrModeEnabled(this.this$0, enabled);
        }

        @Override // com.android.server.vr.VrManagerInternal
        public void setVr2dDisplayProperties(Vr2dDisplayProperties compatDisplayProp) {
            this.this$0.setVr2dDisplayProperties(compatDisplayProp);
        }

        @Override // com.android.server.vr.VrManagerInternal
        public int getVr2dDisplayId() {
            return VrManagerService.m9479$$Nest$mgetVr2dDisplayId(this.this$0);
        }

        @Override // com.android.server.vr.VrManagerInternal
        public void addPersistentVrModeStateListener(IPersistentVrStateCallbacks listener) {
            VrManagerService.m9472$$Nest$maddPersistentStateCallback(this.this$0, listener);
        }
    }

    private final class NotificationAccessManager {
        private final SparseArray<ArraySet<String>> mAllowedPackages;
        private final ArrayMap<String, Integer> mNotificationAccessPackageToUserId;
        final /* synthetic */ VrManagerService this$0;

        /* synthetic */ NotificationAccessManager(VrManagerService r1, VrManagerServiceIA r2) {
            this(r1);
        }

        private NotificationAccessManager(VrManagerService r1) {
            this.this$0 = r1;
            this.mAllowedPackages = new SparseArray();
            this.mNotificationAccessPackageToUserId = new ArrayMap();
        }

        public void update(Collection<String> packageNames) {
            int currentUserId = ActivityManager.getCurrentUser();
            ArraySet<String> allowed = this.mAllowedPackages.get(currentUserId);
            if (allowed != null) goto L5;
            allowed = new ArraySet();
        L5:
            int listenerCount = this.mNotificationAccessPackageToUserId.size();
            int i = listenerCount - 1;
        L6:
            if (i < 0) goto L11;
            int grantUserId = this.mNotificationAccessPackageToUserId.valueAt(i).intValue();
            if (grantUserId == currentUserId) goto L10;
            String packageName = this.mNotificationAccessPackageToUserId.keyAt(i);
            VrManagerService.m9490$$Nest$mrevokeNotificationListenerAccess(this.this$0, packageName, grantUserId);
            VrManagerService.m9491$$Nest$mrevokeNotificationPolicyAccess(this.this$0, packageName);
            VrManagerService.m9489$$Nest$mrevokeCoarseLocationPermissionIfNeeded(this.this$0, packageName, grantUserId);
            this.mNotificationAccessPackageToUserId.removeAt(i);
        L10:
            i = i - 1;
            goto L6
        L11:
            Iterator<String> r3 = allowed.iterator();
        L13:
            if (r3.hasNext() == false) goto L18;
            String pkg = r3.next();
            if (packageNames.contains(pkg) == true) goto L13;
            VrManagerService.m9490$$Nest$mrevokeNotificationListenerAccess(this.this$0, pkg, currentUserId);
            VrManagerService.m9491$$Nest$mrevokeNotificationPolicyAccess(this.this$0, pkg);
            VrManagerService.m9489$$Nest$mrevokeCoarseLocationPermissionIfNeeded(this.this$0, pkg, currentUserId);
            this.mNotificationAccessPackageToUserId.remove(pkg);
            goto L13
        L18:
            Iterator<String> r4 = packageNames.iterator();
        L20:
            if (r4.hasNext() == false) goto L25;
            String pkg2 = r4.next();
            if (allowed.contains(pkg2) == true) goto L20;
            VrManagerService.m9483$$Nest$mgrantNotificationPolicyAccess(this.this$0, pkg2);
            VrManagerService.m9482$$Nest$mgrantNotificationListenerAccess(this.this$0, pkg2, currentUserId);
            VrManagerService.m9481$$Nest$mgrantCoarseLocationPermissionIfNeeded(this.this$0, pkg2, currentUserId);
            this.mNotificationAccessPackageToUserId.put(pkg2, Integer.valueOf(currentUserId));
            goto L20
        L25:
            allowed.clear();
            allowed.addAll(packageNames);
            this.mAllowedPackages.put(currentUserId, allowed);
        }
    }

    private static class SettingEvent implements ManagedApplicationService.LogFormattable {
        public final long timestamp;
        public final String what;

        SettingEvent(String what) {
            this.timestamp = System.currentTimeMillis();
            this.what = what;
        }

        @Override // com.android.server.utils.ManagedApplicationService.LogFormattable
        public String toLogString(SimpleDateFormat dateFormat) {
            return dateFormat.format(new Date(this.timestamp)) + "   " + this.what;
        }
    }

    private static class VrState implements ManagedApplicationService.LogFormattable {
        final ComponentName callingPackage;
        final boolean defaultPermissionsGranted;
        final boolean enabled;
        final int processId;
        final boolean running2dInVr;
        final ComponentName targetPackageName;
        final long timestamp;
        final int userId;

        VrState(boolean enabled, boolean running2dInVr, ComponentName targetPackageName, int userId, int processId, ComponentName callingPackage) {
            this.enabled = enabled;
            this.running2dInVr = running2dInVr;
            this.userId = userId;
            this.processId = processId;
            this.targetPackageName = targetPackageName;
            this.callingPackage = callingPackage;
            this.defaultPermissionsGranted = false;
            this.timestamp = System.currentTimeMillis();
        }

        VrState(boolean enabled, boolean running2dInVr, ComponentName targetPackageName, int userId, int processId, ComponentName callingPackage, boolean defaultPermissionsGranted) {
            this.enabled = enabled;
            this.running2dInVr = running2dInVr;
            this.userId = userId;
            this.processId = processId;
            this.targetPackageName = targetPackageName;
            this.callingPackage = callingPackage;
            this.defaultPermissionsGranted = defaultPermissionsGranted;
            this.timestamp = System.currentTimeMillis();
        }

        @Override // com.android.server.utils.ManagedApplicationService.LogFormattable
        public String toLogString(SimpleDateFormat dateFormat) {
            StringBuilder sb = new StringBuilder(dateFormat.format(new Date(this.timestamp)));
            sb.append("  ");
            sb.append("State changed to:");
            sb.append("  ");
            if (this.enabled == false) goto L5;
            String r3 = "ENABLED";
        L6:
            sb.append(r3);
            sb.append("\n");
            if (this.enabled == false) goto L20;
            sb.append("  ");
            sb.append("User=");
            sb.append(this.userId);
            sb.append("\n");
            sb.append("  ");
            sb.append("Current VR Activity=");
            ComponentName r4 = this.callingPackage;
            String r5 = KeyboardMetricsCollector.DEFAULT_LANGUAGE_TAG;
            if (r4 != null) goto L11;
            String r6 = KeyboardMetricsCollector.DEFAULT_LANGUAGE_TAG;
        L12:
            sb.append(r6);
            sb.append("\n");
            sb.append("  ");
            sb.append("Bound VrListenerService=");
            if (this.targetPackageName == null) goto L16;
            r5 = this.targetPackageName.flattenToString();
        L16:
            sb.append(r5);
            sb.append("\n");
            if (this.defaultPermissionsGranted == false) goto L20;
            sb.append("  ");
            sb.append("Default permissions granted to the bound VrListenerService.");
            sb.append("\n");
            goto L20
        L11:
            r6 = this.callingPackage.flattenToString();
        L20:
            return sb.toString();
        L5:
            r3 = "DISABLED";
            goto L6
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$TQK-SAtMJvQ7m-NEIVB6BwOxL2g, reason: not valid java name */
    public static /* synthetic */ void m9460$r8$lambda$TQKSAtMJvQ7mNEIVB6BwOxL2g(VrManagerService r0) {
        r0.lambda$onUserSwitching$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBootsToVr, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9461$$Nest$fgetmBootsToVr(VrManagerService r0) {
        return r0.mBootsToVr;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmComponentObserver, reason: not valid java name */
    static /* bridge */ /* synthetic */ EnabledComponentsObserver m9462$$Nest$fgetmComponentObserver(VrManagerService r0) {
        return r0.mComponentObserver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m9463$$Nest$fgetmContext(VrManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentVrCompositorService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ManagedApplicationService m9464$$Nest$fgetmCurrentVrCompositorService(VrManagerService r0) {
        return r0.mCurrentVrCompositorService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentVrModeUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9465$$Nest$fgetmCurrentVrModeUser(VrManagerService r0) {
        return r0.mCurrentVrModeUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentVrService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ManagedApplicationService m9466$$Nest$fgetmCurrentVrService(VrManagerService r0) {
        return r0.mCurrentVrService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9467$$Nest$fgetmLock(VrManagerService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPersistentVrModeEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9468$$Nest$fgetmPersistentVrModeEnabled(VrManagerService r0) {
        return r0.mPersistentVrModeEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPersistentVrStateRemoteCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m9469$$Nest$fgetmPersistentVrStateRemoteCallbacks(VrManagerService r0) {
        return r0.mPersistentVrStateRemoteCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVrModeAllowed, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9470$$Nest$fgetmVrModeAllowed(VrManagerService r0) {
        return r0.mVrModeAllowed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVrStateRemoteCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ RemoteCallbackList m9471$$Nest$fgetmVrStateRemoteCallbacks(VrManagerService r0) {
        return r0.mVrStateRemoteCallbacks;
    }

    /* JADX INFO: renamed from: -$$Nest$maddPersistentStateCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9472$$Nest$maddPersistentStateCallback(VrManagerService r0, IPersistentVrStateCallbacks r1) {
        r0.addPersistentStateCallback(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$maddStateCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9473$$Nest$maddStateCallback(VrManagerService r0, IVrStateCallbacks r1) {
        r0.addStateCallback(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcallFocusedActivityChangedLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9474$$Nest$mcallFocusedActivityChangedLocked(VrManagerService r0) {
        r0.callFocusedActivityChangedLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mconsumeAndApplyPendingStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9475$$Nest$mconsumeAndApplyPendingStateLocked(VrManagerService r0) {
        r0.consumeAndApplyPendingStateLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpStateTransitions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9476$$Nest$mdumpStateTransitions(VrManagerService r0, PrintWriter r1) {
        r0.dumpStateTransitions(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceCallerPermissionAnyOf, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9477$$Nest$menforceCallerPermissionAnyOf(VrManagerService r0, String[] r1) {
        r0.enforceCallerPermissionAnyOf(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPersistentVrMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9478$$Nest$mgetPersistentVrMode(VrManagerService r0) {
        return r0.getPersistentVrMode();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetVr2dDisplayId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9479$$Nest$mgetVr2dDisplayId(VrManagerService r0) {
        return r0.getVr2dDisplayId();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetVrMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9480$$Nest$mgetVrMode(VrManagerService r0) {
        return r0.getVrMode();
    }

    /* JADX INFO: renamed from: -$$Nest$mgrantCoarseLocationPermissionIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9481$$Nest$mgrantCoarseLocationPermissionIfNeeded(VrManagerService r0, String r1, int r2) {
        r0.grantCoarseLocationPermissionIfNeeded(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgrantNotificationListenerAccess, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9482$$Nest$mgrantNotificationListenerAccess(VrManagerService r0, String r1, int r2) {
        r0.grantNotificationListenerAccess(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgrantNotificationPolicyAccess, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9483$$Nest$mgrantNotificationPolicyAccess(VrManagerService r0, String r1) {
        r0.grantNotificationPolicyAccess(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhasVrPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9484$$Nest$mhasVrPackage(VrManagerService r0, ComponentName r1, int r2) {
        return r0.hasVrPackage(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misCurrentVrListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9485$$Nest$misCurrentVrListener(VrManagerService r0, String r1, int r2) {
        return r0.isCurrentVrListener(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mlogEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9486$$Nest$mlogEvent(VrManagerService r0, ManagedApplicationService.LogFormattable r1) {
        r0.logEvent(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremovePersistentStateCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9487$$Nest$mremovePersistentStateCallback(VrManagerService r0, IPersistentVrStateCallbacks r1) {
        r0.removePersistentStateCallback(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveStateCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9488$$Nest$mremoveStateCallback(VrManagerService r0, IVrStateCallbacks r1) {
        r0.removeStateCallback(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mrevokeCoarseLocationPermissionIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9489$$Nest$mrevokeCoarseLocationPermissionIfNeeded(VrManagerService r0, String r1, int r2) {
        r0.revokeCoarseLocationPermissionIfNeeded(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mrevokeNotificationListenerAccess, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9490$$Nest$mrevokeNotificationListenerAccess(VrManagerService r0, String r1, int r2) {
        r0.revokeNotificationListenerAccess(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mrevokeNotificationPolicyAccess, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9491$$Nest$mrevokeNotificationPolicyAccess(VrManagerService r0, String r1) {
        r0.revokeNotificationPolicyAccess(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetAndBindCompositor, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9492$$Nest$msetAndBindCompositor(VrManagerService r0, ComponentName r1) {
        r0.setAndBindCompositor(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetPersistentVrModeEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9493$$Nest$msetPersistentVrModeEnabled(VrManagerService r0, boolean r1) {
        r0.setPersistentVrModeEnabled(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetScreenOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9494$$Nest$msetScreenOn(VrManagerService r0, boolean r1) {
        r0.setScreenOn(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetStandbyEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9495$$Nest$msetStandbyEnabled(VrManagerService r0, boolean r1) {
        r0.setStandbyEnabled(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetUserUnlocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9496$$Nest$msetUserUnlocked(VrManagerService r0) {
        r0.setUserUnlocked();
    }

    /* JADX INFO: renamed from: -$$Nest$msetVrMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9497$$Nest$msetVrMode(VrManagerService r0, boolean r1, ComponentName r2, int r3, int r4, ComponentName r5) {
        r0.setVrMode(r1, r2, r3, r4, r5);
    }

    private static native void initializeNative();

    private static native void setVrModeNative(boolean r0);

    static {
        LazyJniRegistrar.registerVrManagerService();
        sBinderChecker = new AnonymousClass3();
    }

    private void updateVrModeAllowedLocked() {
        if (this.mBootsToVr == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        boolean ignoreSleepFlags = r1;
        if (this.mStandby == true) goto L11;
    L13:
        boolean r2 = false;
    L14:
        boolean disallowedByStandby = r2;
        if (this.mSystemSleepFlags == 7) goto L18;
        if (ignoreSleepFlags == true) goto L18;
    L21:
        boolean r3 = false;
    L22:
        boolean allowed = r3;
        if (this.mVrModeAllowed == allowed) goto L42;
        this.mVrModeAllowed = allowed;
        if (this.mVrModeAllowed == true) goto L27;
        setPersistentModeAndNotifyListenersLocked(false);
        if (this.mVrModeEnabled == true) goto L37;
    L39:
        VrState r10 = null;
    L40:
        this.mPendingState = r10;
        updateCurrentVrServiceLocked(false, false, null, 0, -1, null);
        return;
    L37:
        if (this.mCurrentVrService == null) goto L39;
        r10 = new VrState(this.mVrModeEnabled, this.mRunning2dInVr, this.mCurrentVrService.getComponent(), this.mCurrentVrService.getUserId(), this.mVrAppProcessId, this.mCurrentVrModeComponent);
        goto L40
    L27:
        if (this.mBootsToVr == false) goto L30;
        setPersistentVrModeEnabled(true);
    L30:
        if (this.mBootsToVr == true) goto L32;
        return;
    L32:
        if (this.mVrModeEnabled == true) goto L44;
        setVrMode(true, this.mDefaultVrService, 0, -1, null);
        return;
    L44:
        return;
    L42:
        return;
    L18:
        if (this.mUserUnlocked == false) goto L21;
        if (disallowedByStandby == true) goto L21;
        r3 = true;
        goto L22
    L11:
        if (this.mUseStandbyToExitVrMode == false) goto L13;
        r2 = true;
        goto L14
    L5:
        if (this.mUseStandbyToExitVrMode == false) goto L7;
        r1 = true;
        goto L8
    }

    private void setScreenOn(boolean isScreenOn) {
        setSystemState(2, isScreenOn);
    }

    @Override // com.android.server.wm.ActivityTaskManagerInternal.ScreenObserver
    public void onAwakeStateChanged(boolean isAwake) {
        setSystemState(1, isAwake);
    }

    @Override // com.android.server.wm.ActivityTaskManagerInternal.ScreenObserver
    public void onKeyguardStateChanged(boolean isShowing) {
        setSystemState(4, !isShowing);
    }

    private void setSystemState(int flags, boolean isOn) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int oldState = this.mSystemSleepFlags;     // Catch: Throwable -> L7
        if (isOn == false) goto L9;
        this.mSystemSleepFlags |= flags;     // Catch: Throwable -> L7
    L11:
        if (oldState == this.mSystemSleepFlags) goto L13;
        updateVrModeAllowedLocked();     // Catch: Throwable -> L7
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        this.mSystemSleepFlags &= ~flags;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private String getStateAsString() {
        StringBuilder r0 = new StringBuilder();
        String r2 = "";
        if ((this.mSystemSleepFlags & 1) == 0) goto L5;
        String r1 = "awake, ";
    L6:
        r0.append(r1);
        if ((this.mSystemSleepFlags & 2) == 0) goto L9;
        String r3 = "screen_on, ";
    L10:
        r0.append(r3);
        if ((this.mSystemSleepFlags & 4) == 0) goto L13;
        r2 = "keyguard_off";
    L13:
        r0.append(r2);
        return r0.toString();
    L9:
        r3 = "";
        goto L10
    L5:
        r1 = "";
        goto L6
    }

    private void setUserUnlocked() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUserUnlocked = true;     // Catch: Throwable -> L8
        updateVrModeAllowedLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void setStandbyEnabled(boolean standby) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mBootsToVr == true) goto L11;
        Slog.e(TAG, "Attempting to set standby mode on a non-standalone device");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mStandby = standby;     // Catch: Throwable -> L9
        updateVrModeAllowedLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    @Override // com.android.server.vr.EnabledComponentsObserver.EnabledComponentChangeListener
    public void onEnabledComponentChanged() {
        Object r1 = this.mLock;
        monitor-enter(r1);
        int currentUser = ActivityManager.getCurrentUser();     // Catch: Throwable -> L10
        ArraySet<ComponentName> enabledListeners = this.mComponentObserver.getEnabled(currentUser);     // Catch: Throwable -> L10
        ArraySet<String> enabledPackages = new ArraySet();     // Catch: Throwable -> L10
        Iterator<ComponentName> r4 = enabledListeners.iterator();     // Catch: Throwable -> L10
    L6:
        if (r4.hasNext() == false) goto L13;
        ComponentName n = r4.next();     // Catch: Throwable -> L10
        String pkg = n.getPackageName();     // Catch: Throwable -> L10
        if (isDefaultAllowed(pkg) == false) goto L6;
        enabledPackages.add(n.getPackageName());     // Catch: Throwable -> L10
        goto L6
    L13:
        this.mNotifAccessManager.update(enabledPackages);     // Catch: Throwable -> L10
        if (this.mVrModeAllowed == true) goto L17;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L17:
        consumeAndApplyPendingStateLocked(false);     // Catch: Throwable -> L10
        if (this.mCurrentVrService != null) goto L21;
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L21:
        updateCurrentVrServiceLocked(this.mVrModeEnabled, this.mRunning2dInVr, this.mCurrentVrService.getComponent(), this.mCurrentVrService.getUserId(), this.mVrAppProcessId, this.mCurrentVrModeComponent);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void enforceCallerPermissionAnyOf(String... permissions) {
        int r0 = permissions.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        String permission = permissions[r1];
        if (this.mContext.checkCallingOrSelfPermission(permission) == 0) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return;
    L9:
        throw new SecurityException("Caller does not hold at least one of the permissions: " + Arrays.toString(permissions));
    }

    public VrManagerService(Context context) {
        super(context);
        this.mLock = new Object();
        this.mOverlayToken = new Binder();
        this.mVrStateRemoteCallbacks = new RemoteCallbackList();
        this.mPersistentVrStateRemoteCallbacks = new RemoteCallbackList();
        this.mPreviousCoarseLocationMode = -1;
        this.mPreviousManageOverlayMode = -1;
        this.mLoggingDeque = new ArrayDeque(64);
        this.mNotifAccessManager = new NotificationAccessManager(this, null);
        this.mSystemSleepFlags = 5;
        this.mEventCallback = new AnonymousClass1(this);
        this.mHandler = new AnonymousClass2(this);
        this.mVrManager = new AnonymousClass4(this);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        initializeNative();     // Catch: Throwable -> L14
        this.mContext = getContext();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        boolean r1 = false;
        this.mBootsToVr = SystemProperties.getBoolean("ro.boot.vr", false);
        if (this.mBootsToVr == true) goto L9;
    L12:
        this.mUseStandbyToExitVrMode = r1;
        publishLocalService(VrManagerInternal.class, new LocalService(this, null));
        publishBinderService("vrmanager", this.mVrManager.asBinder());
        return;
    L9:
        if (SystemProperties.getBoolean("persist.vr.use_standby_to_exit_vr_mode", true) == false) goto L12;
        r1 = true;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L16;
        ((ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class)).registerScreenObserver(this);
        this.mNotificationManager = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        Object r1 = this.mLock;
        monitor-enter(r1);
        Looper looper = Looper.getMainLooper();     // Catch: Throwable -> L13
        Handler handler = new Handler(looper);     // Catch: Throwable -> L13
        ArrayList<EnabledComponentsObserver.EnabledComponentChangeListener> listeners = new ArrayList();     // Catch: Throwable -> L13
        listeners.add(this);     // Catch: Throwable -> L13
        this.mComponentObserver = EnabledComponentsObserver.build(this.mContext, handler, "enabled_vr_listeners", looper, "android.permission.BIND_VR_LISTENER_SERVICE", "android.service.vr.VrListenerService", this.mLock, listeners);     // Catch: Throwable -> L13
        this.mComponentObserver.rebuildAll();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        ArraySet<ComponentName> defaultVrComponents = SystemConfig.getInstance().getDefaultVrComponents();
        if (defaultVrComponents.size() <= 0) goto L11;
        this.mDefaultVrService = defaultVrComponents.valueAt(0);
    L12:
        DisplayManager dm = (DisplayManager) getContext().getSystemService("display");
        this.mVr2dDisplay = new Vr2dDisplay(dm, (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class), (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class), this.mVrManager);
        this.mVr2dDisplay.init(getContext(), this.mBootsToVr);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_UNLOCKED");
        getContext().registerReceiver(new AnonymousClass5(this), intentFilter);
        return;
    L11:
        Slog.i(TAG, "No default vr listener service found.");
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onUserStarting(SystemService.TargetUser user) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mComponentObserver.onUsersChanged();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        FgThread.getHandler().post(new VrManagerService$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$onUserSwitching$0() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mComponentObserver.onUsersChanged();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onUserStopping(SystemService.TargetUser user) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mComponentObserver.onUsersChanged();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onUserStopped(SystemService.TargetUser user) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mComponentObserver.onUsersChanged();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateOverlayStateLocked(String exemptedPackage, int newUserId, int oldUserId) {
        AppOpsManager appOpsManager = (AppOpsManager) getContext().getSystemService(AppOpsManager.class);
        if (oldUserId == newUserId) goto L6;
        appOpsManager.setUserRestrictionForUser(24, false, this.mOverlayToken, null, oldUserId);
    L6:
        if (exemptedPackage == null) goto L8;
        PackageTagsList exemptions = new PackageTagsList.Builder(1).add(exemptedPackage).build();
        PackageTagsList exemptions2 = exemptions;
    L9:
        appOpsManager.setUserRestrictionForUser(24, this.mVrModeEnabled, this.mOverlayToken, exemptions2, newUserId);
        return;
    L8:
        exemptions2 = null;
        goto L9
    }

    private void updateDependentAppOpsLocked(String newVrServicePackage, int newUserId, String oldVrServicePackage, int oldUserId) {
        if (Objects.equals(newVrServicePackage, oldVrServicePackage) == false) goto L5;
        return;
    L5:
        long identity = Binder.clearCallingIdentity();
        updateOverlayStateLocked(newVrServicePackage, newUserId, oldUserId);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(identity);
        return;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private boolean updateCurrentVrServiceLocked(boolean enabled, boolean running2dInVr, ComponentName component, int userId, int processId, ComponentName calling) {
        boolean sendUpdatedCaller = false;
        long identity = Binder.clearCallingIdentity();
        boolean goingIntoVrMode = false;
        if (this.mComponentObserver.isValid(component, userId) != 0) goto L6;
        boolean validUserComponent = true;
    L7:
        if (validUserComponent == false) goto L11;
        if (enabled == false) goto L11;
        goingIntoVrMode = true;
    L11:
        if (this.mVrModeEnabled == true) goto L16;
        if (goingIntoVrMode == true) goto L16;
        Binder.restoreCallingIdentity(identity);
        return validUserComponent;
    L16:
        if (this.mCurrentVrService == null) goto L20;
        String oldVrServicePackage = this.mCurrentVrService.getComponent().getPackageName();     // Catch: Throwable -> L18
    L21:
        int oldUserId = this.mCurrentVrModeUser;     // Catch: Throwable -> L18
        changeVrModeLocked(goingIntoVrMode);     // Catch: Throwable -> L18
        boolean nothingChanged = false;
        if (goingIntoVrMode == false) goto L25;
        boolean validUserComponent2 = validUserComponent;
        if (this.mCurrentVrService != null) goto L31;
        String newVrServicePackage = null;
        createAndConnectService(component, userId);     // Catch: Throwable -> L18
        sendUpdatedCaller = true;
    L35:
        if (calling != null) goto L39;
        if (this.mPersistentVrModeEnabled == true) goto L39;
    L41:
        if (this.mRunning2dInVr == running2dInVr) goto L43;
    L42:
        sendUpdatedCaller = true;
    L43:
        this.mCurrentVrModeComponent = calling;     // Catch: Throwable -> L18
        this.mRunning2dInVr = running2dInVr;     // Catch: Throwable -> L18
        this.mVrAppProcessId = processId;     // Catch: Throwable -> L48
        if (this.mCurrentVrModeUser == userId) goto L51;
        this.mCurrentVrModeUser = userId;     // Catch: Throwable -> L48
        sendUpdatedCaller = true;
    L51:
        if (this.mCurrentVrService == null) goto L54;
        newVrServicePackage = this.mCurrentVrService.getComponent().getPackageName();     // Catch: Throwable -> L48
    L54:
        int newUserId = this.mCurrentVrModeUser;     // Catch: Throwable -> L48
        updateDependentAppOpsLocked(newVrServicePackage, newUserId, oldVrServicePackage, oldUserId);     // Catch: Throwable -> L48
        if (this.mCurrentVrService == null) goto L58;
        if (sendUpdatedCaller == false) goto L58;
        callFocusedActivityChangedLocked();     // Catch: Throwable -> L48
    L58:
        if (nothingChanged == true) goto L60;
        logStateLocked();     // Catch: Throwable -> L48
    L60:
        Binder.restoreCallingIdentity(identity);
        return validUserComponent2;
    L48:
        th = th;
    L62:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L39:
        if (Objects.equals(calling, this.mCurrentVrModeComponent) == false) goto L42;
    L31:
        if (this.mCurrentVrService.disconnectIfNotMatching(component, userId) == false) goto L33;
        Slog.i(TAG, "VR mode component changed to " + component + ", disconnecting " + this.mCurrentVrService.getComponent() + " for user " + this.mCurrentVrService.getUserId());     // Catch: Throwable -> L18
        newVrServicePackage = null;
        updateCompositorServiceLocked(ProcessList.INVALID_ADJ, null);     // Catch: Throwable -> L18
        createAndConnectService(component, userId);     // Catch: Throwable -> L18
        sendUpdatedCaller = true;
        goto L35
    L33:
        newVrServicePackage = null;
        nothingChanged = true;
        goto L35
    L25:
        if (this.mCurrentVrService == null) goto L27;
        StringBuilder r14 = new StringBuilder();     // Catch: Throwable -> L18
        validUserComponent2 = validUserComponent;
        r14.append("Leaving VR mode, disconnecting ");     // Catch: Throwable -> L18
        r14.append(this.mCurrentVrService.getComponent());     // Catch: Throwable -> L18
        r14.append(" for user ");     // Catch: Throwable -> L18
        r14.append(this.mCurrentVrService.getUserId());     // Catch: Throwable -> L18
        Slog.i(TAG, r14.toString());     // Catch: Throwable -> L18
        this.mCurrentVrService.disconnect();     // Catch: Throwable -> L18
        updateCompositorServiceLocked(ProcessList.INVALID_ADJ, null);     // Catch: Throwable -> L18
        this.mCurrentVrService = null;     // Catch: Throwable -> L18
        newVrServicePackage = null;
        goto L35
    L27:
        validUserComponent2 = validUserComponent;
        nothingChanged = true;
        newVrServicePackage = null;
        goto L35
    L20:
        oldVrServicePackage = null;
        goto L21
    L6:
        validUserComponent = false;
    L18:
        th = th;
        goto L62
    }

    private void callFocusedActivityChangedLocked() {
        final ComponentName c = this.mCurrentVrModeComponent;
        final boolean b = this.mRunning2dInVr;
        final int pid = this.mVrAppProcessId;
        this.mCurrentVrService.sendEvent(new AnonymousClass6(this, c, b, pid));
    }

    private boolean isDefaultAllowed(String packageName) {
        PackageManager pm = this.mContext.getPackageManager();
        ApplicationInfo info = null;
        info = pm.getApplicationInfo(packageName, 128);     // Catch: PackageManager.NameNotFoundException -> L5
    L6:
        if (info != null) goto L8;
        return false;
    L8:
        if (info.isSystemApp() == false) goto L10;
        return true;
    L10:
        if (info.isUpdatedSystemApp() == false) goto L19;
        return true;
    L19:
        return false;
    }

    private void grantNotificationPolicyAccess(String pkg) {
        NotificationManager nm = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        nm.setNotificationPolicyAccessGranted(pkg, true);
    }

    private void revokeNotificationPolicyAccess(String pkg) {
        NotificationManager nm = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        nm.removeAutomaticZenRules(pkg);
        nm.setNotificationPolicyAccessGranted(pkg, false);
    }

    private void grantNotificationListenerAccess(String pkg, int userId) {
        NotificationManager nm = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        PackageManager pm = this.mContext.getPackageManager();
        ArraySet<ComponentName> possibleServices = EnabledComponentsObserver.loadComponentNames(pm, userId, "android.service.notification.NotificationListenerService", "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE");
        Iterator<ComponentName> r3 = possibleServices.iterator();
    L4:
        if (r3.hasNext() == false) goto L13;
        ComponentName c = r3.next();
        if (Objects.equals(c.getPackageName(), pkg) == false) goto L4;
        nm.setNotificationListenerAccessGrantedForUser(c, userId, true);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Slog.w(TAG, "Could not grant NLS access to package " + pkg, e);
        goto L4
    }

    private void revokeNotificationListenerAccess(String pkg, int userId) {
        NotificationManager nm = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        List<ComponentName> current = nm.getEnabledNotificationListeners(userId);
        Iterator<ComponentName> r2 = current.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        ComponentName component = r2.next();
        if (component == null) goto L4;
        if (component.getPackageName().equals(pkg) == false) goto L4;
        nm.setNotificationListenerAccessGrantedForUser(component, userId, false);
        goto L4
    }

    private void grantCoarseLocationPermissionIfNeeded(String pkg, int userId) {
        if (isPermissionUserUpdated("android.permission.ACCESS_COARSE_LOCATION", pkg, userId) == true) goto L11;
        this.mContext.getPackageManager().grantRuntimePermission(pkg, "android.permission.ACCESS_COARSE_LOCATION", new UserHandle(userId));     // Catch: IllegalArgumentException -> L6
        return;
    L7:
        Slog.w(TAG, "Could not grant coarse location permission, package " + pkg + " was removed.");
        return;
    }

    private void revokeCoarseLocationPermissionIfNeeded(String pkg, int userId) {
        if (isPermissionUserUpdated("android.permission.ACCESS_COARSE_LOCATION", pkg, userId) == true) goto L11;
        this.mContext.getPackageManager().revokeRuntimePermission(pkg, "android.permission.ACCESS_COARSE_LOCATION", new UserHandle(userId));     // Catch: IllegalArgumentException -> L6
        return;
    L7:
        Slog.w(TAG, "Could not revoke coarse location permission, package " + pkg + " was removed.");
        return;
    }

    private boolean isPermissionUserUpdated(String permission, String pkg, int userId) {
        int flags = this.mContext.getPackageManager().getPermissionFlags(permission, pkg, new UserHandle(userId));
        if ((flags & 3) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private ArraySet<String> getNotificationListeners(ContentResolver resolver, int userId) {
        String flat = Settings.Secure.getStringForUser(resolver, "enabled_notification_listeners", userId);
        ArraySet<String> current = new ArraySet();
        if (flat == null) goto L11;
        String[] allowed = flat.split(":");
        int r3 = allowed.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L11;
        String s = allowed[r4];
        if (TextUtils.isEmpty(s) == true) goto L10;
        current.add(s);
    L10:
        r4 = r4 + 1;
    L11:
        return current;
    }

    private static String formatSettings(Collection<String> c) {
        if (c != null) goto L5;
    L18:
        return "";
    L5:
        if (c.isEmpty() == true) goto L18;
        StringBuilder b = new StringBuilder();
        boolean start = true;
        Iterator<String> r3 = c.iterator();
    L9:
        if (r3.hasNext() == false) goto L17;
        String s = r3.next();
        if ("".equals(s) == true) goto L9;
        if (start == true) goto L15;
        b.append(':');
    L15:
        b.append(s);
        start = false;
        goto L9
    L17:
        return b.toString();
    }

    private void createAndConnectService(ComponentName component, int userId) {
        this.mCurrentVrService = createVrListenerService(component, userId);
        this.mCurrentVrService.connect();
        Slog.i(TAG, "Connecting " + component + " for user " + userId);
    }

    private void changeVrModeLocked(boolean enabled) {
        if (this.mVrModeEnabled == enabled) goto L10;
        this.mVrModeEnabled = enabled;
        StringBuilder r0 = new StringBuilder();
        r0.append("VR mode ");
        if (this.mVrModeEnabled == false) goto L7;
        String r1 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L8:
        r0.append(r1);
        Slog.i(TAG, r0.toString());
        setVrModeNative(this.mVrModeEnabled);
        onVrModeChangedLocked();
        return;
    L7:
        r1 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
        goto L8
    }

    private void onVrModeChangedLocked() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, this.mVrModeEnabled ? 1 : 0, 0));
    }

    private ManagedApplicationService createVrListenerService(ComponentName component, int userId) {
        if (this.mBootsToVr == false) goto L5;
        int r0 = 1;
    L6:
        int retryType = r0;
        return ManagedApplicationService.build(this.mContext, component, userId, 17042359, "android.settings.VR_LISTENER_SETTINGS", sBinderChecker, true, retryType, this.mHandler, this.mEventCallback);
    L5:
        r0 = 2;
        goto L6
    }

    private ManagedApplicationService createVrCompositorService(ComponentName component, int userId) {
        if (this.mBootsToVr == false) goto L5;
        int r0 = 1;
    L6:
        int retryType = r0;
        return ManagedApplicationService.build(this.mContext, component, userId, 0, null, null, true, retryType, this.mHandler, this.mEventCallback);
    L5:
        r0 = 3;
        goto L6
    }

    private void consumeAndApplyPendingStateLocked() {
        consumeAndApplyPendingStateLocked(true);
    }

    private void consumeAndApplyPendingStateLocked(boolean disconnectIfNoPendingState) {
        if (this.mPendingState == null) goto L5;
        updateCurrentVrServiceLocked(this.mPendingState.enabled, this.mPendingState.running2dInVr, this.mPendingState.targetPackageName, this.mPendingState.userId, this.mPendingState.processId, this.mPendingState.callingPackage);
        this.mPendingState = null;
        return;
    L5:
        if (disconnectIfNoPendingState == false) goto L9;
        updateCurrentVrServiceLocked(false, false, null, 0, -1, null);
        return;
    }

    private void logStateLocked() {
        if (this.mCurrentVrService != null) goto L5;
        ComponentName r0 = null;
    L6:
        ComponentName currentBoundService = r0;
        logEvent(new VrState(this.mVrModeEnabled, this.mRunning2dInVr, currentBoundService, this.mCurrentVrModeUser, this.mVrAppProcessId, this.mCurrentVrModeComponent, this.mWasDefaultGranted));
        return;
    L5:
        r0 = this.mCurrentVrService.getComponent();
        goto L6
    }

    private void logEvent(ManagedApplicationService.LogFormattable event) {
        ArrayDeque<ManagedApplicationService.LogFormattable> r0 = this.mLoggingDeque;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mLoggingDeque.size() != 64) goto L9;
        this.mLoggingDeque.removeFirst();     // Catch: Throwable -> L7
        this.mLogLimitHit = true;     // Catch: Throwable -> L7
    L9:
        this.mLoggingDeque.add(event);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void dumpStateTransitions(PrintWriter pw) {
        SimpleDateFormat d = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
        ArrayDeque<ManagedApplicationService.LogFormattable> r1 = this.mLoggingDeque;
        monitor-enter(r1);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mLoggingDeque.size() != 0) goto L10;
        pw.print("  ");     // Catch: Throwable -> L7
        pw.println(KeyboardMetricsCollector.DEFAULT_LANGUAGE_TAG);     // Catch: Throwable -> L7
    L10:
        if (this.mLogLimitHit == false) goto L12;
        pw.println("...");     // Catch: Throwable -> L7
    L12:
        Iterator<ManagedApplicationService.LogFormattable> r2 = this.mLoggingDeque.iterator();     // Catch: Throwable -> L7
    L14:
        if (r2.hasNext() == false) goto L16;
        ManagedApplicationService.LogFormattable event = r2.next();     // Catch: Throwable -> L7
        pw.println(event.toLogString(d));     // Catch: Throwable -> L7
        goto L14
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L7
    }

    private void setVrMode(boolean enabled, ComponentName targetPackageName, int userId, int processId, ComponentName callingPackage) {
        Object r8 = this.mLock;
        monitor-enter(r8);
        if (enabled == true) goto L12;
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.mPersistentVrModeEnabled == true) goto L12;
        boolean r3 = false;
    L13:
        boolean targetEnabledState = r3;
        if (enabled == false) goto L16;
    L18:
        boolean running2dInVr = false;
    L20:
        if (running2dInVr == false) goto L22;
        ComponentName targetListener = this.mDefaultVrService;     // Catch: Throwable -> L10
    L23:
        VrState pending = new VrState(targetEnabledState, running2dInVr, targetListener, userId, processId, callingPackage);     // Catch: Throwable -> L10
        if (this.mVrModeAllowed == true) goto L28;
        this.mPendingState = pending;     // Catch: Throwable -> L10
        monitor-exit(r8);     // Catch: Throwable -> L10
        return;
    L28:
        if (targetEnabledState == false) goto L30;
    L37:
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L10
        this.mPendingState = null;     // Catch: Throwable -> L10
        updateCurrentVrServiceLocked(targetEnabledState, running2dInVr, targetListener, userId, processId, callingPackage);     // Catch: Throwable -> L10
        monitor-exit(r8);     // Catch: Throwable -> L10
        return;
    L30:
        if (this.mCurrentVrService == null) goto L37;
        if (this.mPendingState != null) goto L34;
        this.mHandler.sendEmptyMessageDelayed(1, 300);     // Catch: Throwable -> L10
    L34:
        this.mPendingState = pending;     // Catch: Throwable -> L10
        monitor-exit(r8);     // Catch: Throwable -> L10
        return;
    L22:
        targetListener = targetPackageName;
        goto L23
    L16:
        if (this.mPersistentVrModeEnabled == false) goto L18;
        running2dInVr = true;
    L12:
        r3 = true;
        goto L13
    }

    private void setPersistentVrModeEnabled(boolean enabled) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        setPersistentModeAndNotifyListenersLocked(enabled);     // Catch: Throwable -> L7
        if (enabled == true) goto L9;
        setVrMode(false, null, 0, -1, null);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setVr2dDisplayProperties(Vr2dDisplayProperties compatDisplayProp) {
        long token = Binder.clearCallingIdentity();
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L4:
        if (this.mVr2dDisplay == null) goto L10;
        this.mVr2dDisplay.setVirtualDisplayProperties(compatDisplayProp);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(token);
        return;
    L10:
        Binder.restoreCallingIdentity(token);
        Slog.w(TAG, "Vr2dDisplay is null!");
    }

    private int getVr2dDisplayId() {
        if (this.mVr2dDisplay != null) goto L5;
        Slog.w(TAG, "Vr2dDisplay is null!");
        return -1;
    L5:
        return this.mVr2dDisplay.getVirtualDisplayId();
    }

    private void setAndBindCompositor(ComponentName componentName) {
        int userId = UserHandle.getCallingUserId();
        long token = Binder.clearCallingIdentity();
        Object r3 = this.mLock;     // Catch: Throwable -> L12
        monitor-enter(r3);     // Catch: Throwable -> L12
        updateCompositorServiceLocked(userId, componentName);     // Catch: Throwable -> L9
        monitor-exit(r3);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(token);
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void updateCompositorServiceLocked(int userId, ComponentName componentName) {
        if (this.mCurrentVrCompositorService != null) goto L5;
    L7:
        if (componentName != null) goto L9;
        return;
    L9:
        if (this.mCurrentVrCompositorService != null) goto L13;
        Slog.i(TAG, "Connecting compositor service: " + componentName);
        this.mCurrentVrCompositorService = createVrCompositorService(componentName, userId);
        this.mCurrentVrCompositorService.connect();
        return;
    L13:
        return;
    L5:
        if (this.mCurrentVrCompositorService.disconnectIfNotMatching(componentName, userId) == false) goto L7;
        Slog.i(TAG, "Disconnecting compositor service: " + this.mCurrentVrCompositorService.getComponent());
        this.mCurrentVrCompositorService = null;
        goto L7
    }

    private void setPersistentModeAndNotifyListenersLocked(boolean r7) {
        if (this.mPersistentVrModeEnabled != r7) goto L5;
        return;
    L5:
        StringBuilder r0 = new StringBuilder();
        r0.append("Persistent VR mode ");
        if (r7 == false) goto L8;
        String r1 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L9:
        r0.append(r1);
        String r2 = r0.toString();
        Slog.i(TAG, r2);
        logEvent(new SettingEvent(r2));
        this.mPersistentVrModeEnabled = r7;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, this.mPersistentVrModeEnabled ? 1 : 0, 0));
        return;
    L8:
        r1 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
        goto L9
    }

    private int hasVrPackage(ComponentName targetPackageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mComponentObserver.isValid(targetPackageName, userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isCurrentVrListener(String packageName, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = false;
        if (this.mCurrentVrService != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L11:
        if (this.mCurrentVrService.getComponent().getPackageName().equals(packageName) == true) goto L13;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L13:
        if (userId != this.mCurrentVrService.getUserId()) goto L16;
        r2 = true;
    L8:
        th = move-exception;
        throw th;
    }

    private void addStateCallback(IVrStateCallbacks cb) {
        this.mVrStateRemoteCallbacks.register(cb);
    }

    private void removeStateCallback(IVrStateCallbacks cb) {
        this.mVrStateRemoteCallbacks.unregister(cb);
    }

    private void addPersistentStateCallback(IPersistentVrStateCallbacks cb) {
        this.mPersistentVrStateRemoteCallbacks.register(cb);
    }

    private void removePersistentStateCallback(IPersistentVrStateCallbacks cb) {
        this.mPersistentVrStateRemoteCallbacks.unregister(cb);
    }

    private boolean getVrMode() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mVrModeEnabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean getPersistentVrMode() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mPersistentVrModeEnabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
