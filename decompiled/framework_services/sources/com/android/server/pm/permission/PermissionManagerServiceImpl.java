package com.android.server.pm.permission;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.IActivityManager;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.doppelganger.DoppelgangerManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.SigningDetails;
import android.content.pm.permission.SplitPermissionInfoParcelable;
import android.metrics.LogMaker;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.Trace;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.permission.IOnPermissionsChangeListener;
import android.permission.PermissionControllerManager;
import android.permission.PermissionManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.EventLog;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.android.internal.compat.IPlatformCompat;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.os.RoSystemProperties;
import com.android.internal.pm.permission.CompatibilityPermissionInfo;
import com.android.internal.pm.pkg.component.ComponentMutateUtils;
import com.android.internal.pm.pkg.component.ParsedPermission;
import com.android.internal.pm.pkg.component.ParsedPermissionGroup;
import com.android.internal.pm.pkg.component.ParsedPermissionUtils;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.IntPair;
import com.android.internal.util.Preconditions;
import com.android.server.BaseZswSystemServiceFactory;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.PermissionThread;
import com.android.server.ServiceThread;
import com.android.server.SystemConfig;
import com.android.server.Watchdog;
import com.android.server.pm.ApexManager;
import com.android.server.pm.PackageInstallerService;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.PackageManagerTracedLock;
import com.android.server.pm.PackageSetting;
import com.android.server.pm.UserManagerInternal;
import com.android.server.pm.UserManagerService;
import com.android.server.pm.parsing.PackageInfoUtils;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.SharedUserApi;
import com.android.server.policy.PermissionPolicyInternal;
import com.android.server.policy.SoftRestrictedPermissionPolicy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionManagerServiceImpl implements PermissionManagerServiceInterface {
    private static final long BACKGROUND_RATIONALE_CHANGE_ID = 147316723;
    private static final long BACKUP_TIMEOUT_MILLIS = 0;
    private static final int BLOCKING_PERMISSION_FLAGS = 52;
    private static final int[] EMPTY_INT_ARRAY = null;
    private static final Map<String, String> FULLER_PERMISSION_MAP = null;
    private static final String LOG_TAG = null;
    private static final int MAX_PERMISSION_TREE_FOOTPRINT = 32768;
    private static final List<String> NEARBY_DEVICES_PERMISSIONS = null;
    private static final List<String> NOTIFICATION_PERMISSIONS = null;
    private static final Set<String> READ_MEDIA_AURAL_PERMISSIONS = null;
    private static final Set<String> READ_MEDIA_VISUAL_PERMISSIONS = null;
    private static final String SKIP_KILL_APP_REASON_NOTIFICATION_TEST = "skip permission revoke app kill for notification test";
    private static final List<String> STORAGE_PERMISSIONS = null;
    private static final String TAG = "PermissionManager";
    private static final int UPDATE_PERMISSIONS_ALL = 1;
    private static final int UPDATE_PERMISSIONS_REPLACE_ALL = 4;
    private static final int UPDATE_PERMISSIONS_REPLACE_PKG = 2;
    private static final int USER_PERMISSION_FLAGS = 3;
    private final ApexManager mApexManager;
    private final Context mContext;
    private final PermissionCallback mDefaultPermissionCallback;
    private final int[] mGlobalGids;
    private final Handler mHandler;
    private final SparseBooleanArray mHasNoDelayedPermBackup;
    private final boolean mIsLeanback;
    private final PackageManagerTracedLock mLock;
    private final MetricsLogger mMetricsLogger;
    private final OnPermissionChangeListeners mOnPermissionChangeListeners;
    private final PackageManagerInternal mPackageManagerInt;
    private PermissionControllerManager mPermissionControllerManager;
    private PermissionPolicyInternal mPermissionPolicyInternal;
    PermissionManagerServiceSmtEx mPermissionSmtEx;
    private final IPlatformCompat mPlatformCompat;
    private ArraySet<String> mPrivappPermissionsViolations;
    private final ArraySet<String> mPrivilegedPermissionAllowlistSourcePackageNames;
    private final PermissionRegistry mRegistry;
    private final DevicePermissionState mState;
    private final SparseArray<ArraySet<String>> mSystemPermissions;
    private boolean mSystemReady;
    private final UserManagerInternal mUserManagerInt;
    private IZswPermissionManagerServiceImpl mZswExt;

    /* JADX INFO: renamed from: com.android.server.pm.permission.PermissionManagerServiceImpl$1, reason: invalid class name */
    class AnonymousClass1 extends PermissionCallback {
        final /* synthetic */ PermissionManagerServiceImpl this$0;

        public static /* synthetic */ Boolean $r8$lambda$51PyhAXpTBmKC14aZHFGOA6gylw(Integer r0) {
            return lambda$isAppBackupAndRestoreRunning$2(r0);
        }

        public static /* synthetic */ void $r8$lambda$OUFt_FudBWilBwxjeGAizHH5UVE(int r0, int r1) {
            lambda$onGidsChanged$0(r0, r1);
        }

        public static /* synthetic */ Boolean $r8$lambda$exRjo3jabclXdvT_gG3_mP8pn18(Integer r0) {
            return lambda$isAppBackupAndRestoreRunning$3(r0);
        }

        public static /* synthetic */ void $r8$lambda$pRCB39sssMj7EShRJOUO1qCT_5g(AnonymousClass1 r0, String r1, int r2, String r3, int r4) {
            r0.lambda$onPermissionRevoked$1(r1, r2, r3, r4);
        }

        AnonymousClass1(PermissionManagerServiceImpl this$0) {
            this.this$0 = this$0;
            super(null);
        }

        private static /* synthetic */ void lambda$onGidsChanged$0(int appId, int userId) {
            PermissionManagerServiceImpl.m7108$$Nest$smkillUid(appId, userId, "permission grant or revoke changed gids");
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceImpl.PermissionCallback
        public void onGidsChanged(final int appId, final int userId) {
            PermissionManagerServiceImpl.m7103$$Nest$fgetmHandler(this.this$0).post(new PermissionManagerServiceImpl$1$$ExternalSyntheticLambda3(appId, userId));
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceImpl.PermissionCallback
        public void onPermissionGranted(int uid, int userId) {
            PermissionManagerServiceImpl.m7104$$Nest$fgetmOnPermissionChangeListeners(this.this$0).onPermissionsChanged(uid);
            PermissionManagerServiceImpl.m7105$$Nest$fgetmPackageManagerInt(this.this$0).writeSettings(true);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceImpl.PermissionCallback
        public void onInstallPermissionGranted() {
            PermissionManagerServiceImpl.m7105$$Nest$fgetmPackageManagerInt(this.this$0).writeSettings(true);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceImpl.PermissionCallback
        public void onPermissionRevoked(final int uid, final int userId, final String reason, boolean overrideKill, final String permissionName) {
            PermissionManagerServiceImpl.m7104$$Nest$fgetmOnPermissionChangeListeners(this.this$0).onPermissionsChanged(uid);
            PermissionManagerServiceImpl.m7105$$Nest$fgetmPackageManagerInt(this.this$0).writeSettings(false);
            if (overrideKill == false) goto L5;
            return;
        L5:
            PermissionManagerServiceImpl.m7103$$Nest$fgetmHandler(this.this$0).post(new PermissionManagerServiceImpl$1$$ExternalSyntheticLambda0(this, permissionName, uid, reason, userId));
        }

        private /* synthetic */ void lambda$onPermissionRevoked$1(String permissionName, int uid, String reason, int userId) {
            if ("android.permission.POST_NOTIFICATIONS".equals(permissionName) == true) goto L5;
        L7:
            int appId = UserHandle.getAppId(uid);
            if (reason != null) goto L10;
            PermissionManagerServiceImpl.m7108$$Nest$smkillUid(appId, userId, "permissions revoked");
            return;
        L10:
            PermissionManagerServiceImpl.m7108$$Nest$smkillUid(appId, userId, reason);
            return;
        L5:
            if (isAppBackupAndRestoreRunning(uid) == false) goto L7;
        }

        private boolean isAppBackupAndRestoreRunning(int uid) {
            if (PermissionManagerServiceImpl.m7106$$Nest$mcheckUidPermission(this.this$0, uid, "android.permission.BACKUP") == 0) goto L5;
            return false;
        L5:
            int userId = UserHandle.getUserId(uid);
            boolean isInSetup = ((Boolean) getSecureInt("user_setup_complete", userId).map(new PermissionManagerServiceImpl$1$$ExternalSyntheticLambda1()).orElse(false)).booleanValue();
            if (isInSetup == false) goto L9;
            return true;
        L9:
            boolean isInDeferredSetup = ((Boolean) getSecureInt("user_setup_personalization_state", userId).map(new PermissionManagerServiceImpl$1$$ExternalSyntheticLambda2()).orElse(false)).booleanValue();
            return isInDeferredSetup;
        }

        private static /* synthetic */ Boolean lambda$isAppBackupAndRestoreRunning$2(Integer setupState) {
            if (setupState.intValue() != 0) goto L5;
            boolean r0 = true;
        L7:
            return Boolean.valueOf(r0);
        L5:
            r0 = false;
            goto L7
        }

        private static /* synthetic */ Boolean lambda$isAppBackupAndRestoreRunning$3(Integer state) {
            boolean r1 = true;
            if (state.intValue() == 1) goto L7;
            r1 = false;
        L7:
            return Boolean.valueOf(r1);
        }

        private Optional<Integer> getSecureInt(String settingName, int userId) {
            return Optional.of(Integer.valueOf(Settings.Secure.getIntForUser(PermissionManagerServiceImpl.m7101$$Nest$fgetmContext(this.this$0).getContentResolver(), settingName, userId)));
        L4:
            e = move-exception;
            Slog.i(PermissionManagerServiceImpl.m7107$$Nest$sfgetLOG_TAG(), "Setting " + settingName + " not found", e);
            return Optional.empty();
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceImpl.PermissionCallback
        public void onInstallPermissionRevoked() {
            PermissionManagerServiceImpl.m7105$$Nest$fgetmPackageManagerInt(this.this$0).writeSettings(true);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceImpl.PermissionCallback
        public void onPermissionUpdated(int[] userIds, boolean sync, int appId) {
            int i = 0;
        L4:
            if (i >= userIds.length) goto L6;
            int uid = UserHandle.getUid(userIds[i], appId);
            PermissionManagerServiceImpl.m7104$$Nest$fgetmOnPermissionChangeListeners(this.this$0).onPermissionsChanged(uid);
            i = i + 1;
            goto L4
        L6:
            PermissionManagerServiceImpl.m7105$$Nest$fgetmPackageManagerInt(this.this$0).writePermissionSettings(userIds, !sync);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceImpl.PermissionCallback
        public void onInstallPermissionUpdated() {
            PermissionManagerServiceImpl.m7105$$Nest$fgetmPackageManagerInt(this.this$0).writeSettings(true);
        }

        @Override // com.android.server.pm.permission.PermissionManagerServiceImpl.PermissionCallback
        public void onPermissionRemoved() {
            PermissionManagerServiceImpl.m7105$$Nest$fgetmPackageManagerInt(this.this$0).writeSettings(false);
        }
    }

    private static final class OnPermissionChangeListeners extends Handler {
        private static final int MSG_ON_PERMISSIONS_CHANGED = 1;
        private final RemoteCallbackList<IOnPermissionsChangeListener> mPermissionListeners;

        OnPermissionChangeListeners(Looper looper) {
            super(looper);
            this.mPermissionListeners = new RemoteCallbackList();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L5;
                default: goto L7;
            };
        L5:
            int uid = msg.arg1;
            handleOnPermissionsChanged(uid);
            return;
        }

        public void addListener(IOnPermissionsChangeListener listener) {
            this.mPermissionListeners.register(listener);
        }

        public void removeListener(IOnPermissionsChangeListener listener) {
            this.mPermissionListeners.unregister(listener);
        }

        public void onPermissionsChanged(int uid) {
            if (this.mPermissionListeners.getRegisteredCallbackCount() <= 0) goto L6;
            obtainMessage(1, uid, 0).sendToTarget();
            return;
        }

        private void handleOnPermissionsChanged(int uid) {
            int count = this.mPermissionListeners.beginBroadcast();
            int i = 0;
        L3:
            if (i >= count) goto L14;
            IOnPermissionsChangeListener callback = this.mPermissionListeners.getBroadcastItem(i);     // Catch: Throwable -> L7
            callback.onPermissionsChanged(uid, "default:0");     // Catch: Throwable -> L7 RemoteException -> L9
        L11:
            i = i + 1;
        L9:
            e = move-exception;
            Log.e(PermissionManagerServiceImpl.TAG, "Permission listener is dead", e);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            this.mPermissionListeners.finishBroadcast();
            throw th;
        L14:
            this.mPermissionListeners.finishBroadcast();
        }
    }

    private static class PermissionCallback {
        /* synthetic */ PermissionCallback(PermissionManagerServiceImplIA r1) {
            this();
        }

        private PermissionCallback() {
        }

        public void onGidsChanged(int appId, int userId) {
        }

        public void onPermissionChanged() {
        }

        public void onPermissionGranted(int uid, int userId) {
        }

        public void onInstallPermissionGranted() {
        }

        public void onPermissionRevoked(int uid, int userId, String reason) {
            onPermissionRevoked(uid, userId, reason, false, null);
        }

        public void onPermissionRevoked(int uid, int userId, String reason, boolean overrideKill, String permissionName) {
        }

        public void onInstallPermissionRevoked() {
        }

        public void onPermissionUpdated(int[] userIds, boolean sync, int appId) {
        }

        public void onPermissionRemoved() {
        }

        public void onInstallPermissionUpdated() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface UpdatePermissionFlags {
    }

    /* JADX INFO: renamed from: $r8$lambda$-fiRUAMMHVhqpJh_JNpXmdQtUj8, reason: not valid java name */
    public static /* synthetic */ void m7094$r8$lambda$fiRUAMMHVhqpJh_JNpXmdQtUj8(PermissionManagerServiceImpl r0, int r1, boolean r2, PermissionCallback r3, AndroidPackage r4) {
        r0.lambda$resetRuntimePermissionsInternal$3(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$8Sme45Qvw9zW2bBrdtvASVYcOVo(PermissionManagerServiceImpl r0, AndroidPackage r1, boolean r2, String r3, String r4, PermissionCallback r5, AndroidPackage r6) {
        r0.lambda$updatePermissions$11(r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$DfvddoHDfyKGCzWx8aYmsFkA5kE(PermissionManagerServiceImpl r0, int[] r1, String r2, boolean r3, int r4, AndroidPackage r5) {
        r0.lambda$revokeRuntimePermissionsIfPermissionDefinitionChangedInternal$7(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$IZGdZLu9IXWwkIE-78RVorfH6ro, reason: not valid java name */
    public static /* synthetic */ void m7095$r8$lambda$IZGdZLu9IXWwkIE78RVorfH6ro(PermissionManagerServiceImpl r0, int r1, Boolean r2) {
        r0.lambda$restoreDelayedRuntimePermissions$5(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$LgrGsOx7VAKdJc4oDshdvCpA0pQ(PermissionManagerServiceImpl r0, int[] r1, PackageSetting r2) {
        r0.lambda$writeLegacyPermissionStateTEMP$16(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$MGC-4_nFjXpM3q4woMu1yIiXTSs, reason: not valid java name */
    public static /* synthetic */ void m7096$r8$lambda$MGC4_nFjXpM3q4woMu1yIiXTSs(PermissionManagerServiceImpl r0, int[] r1, PackageStateInternal r2) {
        r0.lambda$readLegacyPermissionStateTEMP$15(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$TVcfivNHjY7gHyGgY0IQMMyc0DA(PermissionManagerServiceImpl r0, int r1, boolean[] r2, int r3, int r4, AndroidPackage r5) {
        r0.lambda$updatePermissionFlagsForAllApps$2(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$WSkE5PiNBH1FdUtUU2bp3jGFnOc(PermissionManagerServiceImpl r0, int[] r1, String r2, AndroidPackage r3, String r4, String r5, int r6, AndroidPackage r7) {
        r0.lambda$revokeRuntimePermissionsIfGroupChangedInternal$6(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: $r8$lambda$XO0n9wIy3T3IzcC-Y6FduT8bcSY, reason: not valid java name */
    public static /* synthetic */ void m7097$r8$lambda$XO0n9wIy3T3IzcCY6FduT8bcSY(int r0) {
        lambda$revokeSharedUserPermissionsForLeavingPackageInternal$10(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$XR_K49R0rSNeTixW4kIpcd-NnlQ, reason: not valid java name */
    public static /* synthetic */ void m7098$r8$lambda$XR_K49R0rSNeTixW4kIpcdNnlQ(PermissionManagerServiceImpl r0, int r1) {
        r0.lambda$onSystemReady$14(r1);
    }

    public static /* synthetic */ void $r8$lambda$ZvgQQyQrxfZ6zPfSBdxIwcK3hmU(PermissionManagerServiceImpl r0, boolean r1, AndroidPackage r2, AndroidPackage r3, boolean r4, List r5) {
        r0.lambda$onPackageAddedInternal$17(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ boolean $r8$lambda$bgZmqAeD0LQYW4VoaxyUvyEFrhM(PermissionManagerServiceImpl r0, int r1, PackageStateInternal r2, String r3) {
        return r0.lambda$getGrantedPermissionsInternal$8(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$chxVBKurN-nt7lKNd-xdsXYMz9E, reason: not valid java name */
    public static /* synthetic */ boolean m7099$r8$lambda$chxVBKurNnt7lKNdxdsXYMz9E(PermissionManagerServiceImpl r0, int r1, int r2, PermissionGroupInfo r3) {
        return r0.lambda$getAllPermissionGroups$0(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$k2_g4EmAjzmPTbLZVw7_encYyNA(PermissionManagerServiceImpl r0, int r1, int r2, PermissionInfo r3) {
        return r0.lambda$queryPermissionsByGroup$1(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$mKXsRlf-7x5d8JK782Hg-sGYT70, reason: not valid java name */
    public static /* synthetic */ void m7100$r8$lambda$mKXsRlf7x5d8JK782HgsGYT70(PermissionManagerServiceImpl r0, Permission r1, int r2, PermissionCallback r3, AndroidPackage r4) {
        r0.lambda$updatePermissionSourcePackage$12(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$qozdUvGVCPDUPIg8wD0NT0Qxa2A(PermissionManagerServiceImpl r0, Permission r1, AndroidPackage r2) {
        r0.lambda$updatePermissionSourcePackage$13(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$uWRHC5nVKduB4K_FGz2O8nzlqsA(int r0, int r1) {
        lambda$resetRuntimePermissionsInternal$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$yPrF8ewzWaNwnhsFhJAbRXoJvTU(PermissionManagerServiceImpl r0, String r1, int r2, int r3) {
        r0.lambda$grantRequestedPermissionsInternal$9(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7101$$Nest$fgetmContext(PermissionManagerServiceImpl r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDefaultPermissionCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ PermissionCallback m7102$$Nest$fgetmDefaultPermissionCallback(PermissionManagerServiceImpl r0) {
        return r0.mDefaultPermissionCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7103$$Nest$fgetmHandler(PermissionManagerServiceImpl r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOnPermissionChangeListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ OnPermissionChangeListeners m7104$$Nest$fgetmOnPermissionChangeListeners(PermissionManagerServiceImpl r0) {
        return r0.mOnPermissionChangeListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManagerInt, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerInternal m7105$$Nest$fgetmPackageManagerInt(PermissionManagerServiceImpl r0) {
        return r0.mPackageManagerInt;
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckUidPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7106$$Nest$mcheckUidPermission(PermissionManagerServiceImpl r0, int r1, String r2) {
        return r0.checkUidPermission(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetLOG_TAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7107$$Nest$sfgetLOG_TAG() {
        return LOG_TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smkillUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7108$$Nest$smkillUid(int r0, int r1, String r2) {
        killUid(r0, r1, r2);
    }

    static {
        LOG_TAG = PermissionManagerServiceImpl.class.getSimpleName();
        BACKUP_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
        EMPTY_INT_ARRAY = new int[0];
        STORAGE_PERMISSIONS = new ArrayList();
        READ_MEDIA_AURAL_PERMISSIONS = new ArraySet();
        READ_MEDIA_VISUAL_PERMISSIONS = new ArraySet();
        NEARBY_DEVICES_PERMISSIONS = new ArrayList();
        NOTIFICATION_PERMISSIONS = new ArrayList();
        FULLER_PERMISSION_MAP = new HashMap();
        FULLER_PERMISSION_MAP.put("android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");
        FULLER_PERMISSION_MAP.put("android.permission.INTERACT_ACROSS_USERS", "android.permission.INTERACT_ACROSS_USERS_FULL");
        STORAGE_PERMISSIONS.add("android.permission.READ_EXTERNAL_STORAGE");
        STORAGE_PERMISSIONS.add("android.permission.WRITE_EXTERNAL_STORAGE");
        READ_MEDIA_AURAL_PERMISSIONS.add("android.permission.READ_MEDIA_AUDIO");
        READ_MEDIA_VISUAL_PERMISSIONS.add("android.permission.READ_MEDIA_VIDEO");
        READ_MEDIA_VISUAL_PERMISSIONS.add("android.permission.READ_MEDIA_IMAGES");
        READ_MEDIA_VISUAL_PERMISSIONS.add("android.permission.ACCESS_MEDIA_LOCATION");
        READ_MEDIA_VISUAL_PERMISSIONS.add("android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
        NEARBY_DEVICES_PERMISSIONS.add("android.permission.BLUETOOTH_ADVERTISE");
        NEARBY_DEVICES_PERMISSIONS.add("android.permission.BLUETOOTH_CONNECT");
        NEARBY_DEVICES_PERMISSIONS.add("android.permission.BLUETOOTH_SCAN");
        NOTIFICATION_PERMISSIONS.add("android.permission.POST_NOTIFICATIONS");
    }

    public PermissionManagerServiceImpl(Context context, ArrayMap<String, FeatureInfo> availableFeatures) {
        this.mPrivilegedPermissionAllowlistSourcePackageNames = new ArraySet();
        this.mLock = new PackageManagerTracedLock();
        this.mState = new DevicePermissionState();
        this.mMetricsLogger = new MetricsLogger();
        this.mPlatformCompat = IPlatformCompat.Stub.asInterface(ServiceManager.getService("platform_compat"));
        this.mRegistry = new PermissionRegistry();
        this.mHasNoDelayedPermBackup = new SparseBooleanArray();
        this.mDefaultPermissionCallback = new AnonymousClass1(this);
        PackageManager.invalidatePackageInfoCache();
        PermissionManager.disablePackageNamePermissionCache();
        this.mContext = context;
        this.mPackageManagerInt = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mUserManagerInt = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.mIsLeanback = availableFeatures.containsKey("android.software.leanback");
        this.mApexManager = ApexManager.getInstance();
        this.mPrivilegedPermissionAllowlistSourcePackageNames.add(PackageManagerService.PLATFORM_PACKAGE_NAME);
        if (availableFeatures.containsKey("android.hardware.type.automotive") == false) goto L7;
        String carServicePackage = SystemProperties.get("ro.android.car.carservice.package", null);
        if (carServicePackage == null) goto L7;
        this.mPrivilegedPermissionAllowlistSourcePackageNames.add(carServicePackage);
    L7:
        ServiceThread r0 = new ServiceThread(TAG, 10, true);
        r0.start();
        this.mHandler = new Handler(r0.getLooper());
        Watchdog.getInstance().addThread(this.mHandler);
        SystemConfig systemConfig = SystemConfig.getInstance();
        this.mSystemPermissions = systemConfig.getSystemPermissions();
        this.mGlobalGids = systemConfig.getGlobalGids();
        this.mOnPermissionChangeListeners = new OnPermissionChangeListeners(FgThread.get().getLooper());
        ArrayMap<String, SystemConfig.PermissionEntry> permConfig = SystemConfig.getInstance().getPermissions();
        PackageManagerTracedLock r4 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        int i = 0;
    L28:
    L15:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L11:
        if (i >= permConfig.size()) goto L22;
        SystemConfig.PermissionEntry perm = permConfig.valueAt(i);     // Catch: Throwable -> L15
        Permission bp = this.mRegistry.getPermission(perm.name);     // Catch: Throwable -> L15
        if (bp != null) goto L18;
        bp = new Permission(perm.name, PackageManagerService.PLATFORM_PACKAGE_NAME, 1);     // Catch: Throwable -> L15
        this.mRegistry.addPermission(bp);     // Catch: Throwable -> L15
    L18:
        if (perm.gids == null) goto L20;
        bp.setGids(perm.gids, perm.perUser);     // Catch: Throwable -> L15
    L20:
        i = i + 1;     // Catch: Throwable -> L15
        goto L28
    L22:
        monitor-exit(r4);     // Catch: Throwable -> L15
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mZswExt = BaseZswSystemServiceFactory.getZswSystemServiceFactoryImpl().createZswPermissionManagerServiceImpl();
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
    }

    private static void killUid(int appId, int userId, String reason) {
        long identity = Binder.clearCallingIdentity();
        IActivityManager am = ActivityManager.getService();     // Catch: Throwable -> L7
        if (am != null) goto L14;
    L10:
        Binder.restoreCallingIdentity(identity);
        return;
    L14:
        am.killUidForPermissionChange(appId, userId, reason);     // Catch: Throwable -> L7 RemoteException -> L9
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private String[] getAppOpPermissionPackagesInternal(String permissionName) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        ArraySet<String> packageNames = this.mRegistry.getAppOpPermissionPackages(permissionName);     // Catch: Throwable -> L10
        if (packageNames != null) goto L13;
        String[] r2 = EmptyArray.STRING;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r2;
    L13:
        String[] r3 = (String[]) packageNames.toArray(new String[0]);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r3;
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionGroupInfo> getAllPermissionGroups(int flags) {
        final int callingUid = Binder.getCallingUid();
        if (this.mPackageManagerInt.getInstantAppPackageName(callingUid) != null) goto L5;
        List<PermissionGroupInfo> out = new ArrayList();
        PackageManagerTracedLock r2 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        Iterator<ParsedPermissionGroup> r3 = this.mRegistry.getPermissionGroups().iterator();     // Catch: Throwable -> L12
    L10:
        if (r3.hasNext() == false) goto L14;
        ParsedPermissionGroup pg = r3.next();     // Catch: Throwable -> L12
        out.add(PackageInfoUtils.generatePermissionGroupInfo(pg, flags));     // Catch: Throwable -> L12
        goto L10
    L14:
        monitor-exit(r2);     // Catch: Throwable -> L12
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        final int callingUserId = UserHandle.getUserId(callingUid);
        out.removeIf(new PermissionManagerServiceImpl$$ExternalSyntheticLambda8(this, callingUid, callingUserId));
        return out;
    L12:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L5:
        return Collections.emptyList();
    }

    private /* synthetic */ boolean lambda$getAllPermissionGroups$0(int callingUid, int callingUserId, PermissionGroupInfo it) {
        return this.mPackageManagerInt.filterAppAccess(it.packageName, callingUid, callingUserId, false);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public PermissionGroupInfo getPermissionGroupInfo(String groupName, int flags) {
        int callingUid = Binder.getCallingUid();
        if (this.mPackageManagerInt.getInstantAppPackageName(callingUid) == null) goto L5;
        return null;
    L5:
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        ParsedPermissionGroup permissionGroup = this.mRegistry.getPermissionGroup(groupName);     // Catch: Throwable -> L12
        if (permissionGroup != null) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L12
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return null;
    L15:
        PermissionGroupInfo permissionGroupInfo = PackageInfoUtils.generatePermissionGroupInfo(permissionGroup, flags);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        int callingUserId = UserHandle.getUserId(callingUid);
        if (this.mPackageManagerInt.filterAppAccess(permissionGroupInfo.packageName, callingUid, callingUserId, false) == false) goto L21;
        EventLog.writeEvent(1397638484, new Object[]{"186113473", Integer.valueOf(callingUid), groupName});
        return null;
    L21:
        return permissionGroupInfo;
    L12:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public PermissionInfo getPermissionInfo(String permName, int flags, String opPackageName) {
        int callingUid = Binder.getCallingUid();
        if (this.mPackageManagerInt.getInstantAppPackageName(callingUid) == null) goto L5;
        return null;
    L5:
        AndroidPackage opPackage = this.mPackageManagerInt.getPackage(opPackageName);
        int targetSdkVersion = getPermissionInfoCallingTargetSdkVersion(opPackage, callingUid);
        PackageManagerTracedLock r4 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        Permission bp = this.mRegistry.getPermission(permName);     // Catch: Throwable -> L12
        if (bp != null) goto L14;
        monitor-exit(r4);     // Catch: Throwable -> L12
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return null;
    L14:
        PermissionInfo permissionInfo = bp.generatePermissionInfo(flags, targetSdkVersion);     // Catch: Throwable -> L12
        monitor-exit(r4);     // Catch: Throwable -> L12
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        int callingUserId = UserHandle.getUserId(callingUid);
        if (this.mPackageManagerInt.filterAppAccess(permissionInfo.packageName, callingUid, callingUserId, false) == false) goto L20;
        EventLog.writeEvent(1397638484, new Object[]{"183122164", Integer.valueOf(callingUid), permName});
        return null;
    L20:
        return permissionInfo;
    L12:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private int getPermissionInfoCallingTargetSdkVersion(AndroidPackage pkg, int uid) {
        int appId = UserHandle.getAppId(uid);
        if (appId != 0) goto L5;
    L13:
        return 10000;
    L5:
        if (appId == 1000) goto L13;
        if (appId == 2000) goto L13;
        if (pkg != null) goto L12;
        return 10000;
    L12:
        return pkg.getTargetSdkVersion();
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionInfo> queryPermissionsByGroup(String groupName, int flags) {
        final int callingUid = Binder.getCallingUid();
        if (this.mPackageManagerInt.getInstantAppPackageName(callingUid) == null) goto L5;
        return null;
    L5:
        List<PermissionInfo> out = new ArrayList(10);
        PackageManagerTracedLock r3 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r3);
        ParsedPermissionGroup permissionGroup = this.mRegistry.getPermissionGroup(groupName);     // Catch: Throwable -> L13
        if (groupName == null) goto L15;
        if (permissionGroup != null) goto L15;
        monitor-exit(r3);     // Catch: Throwable -> L13
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return null;
    L15:
        Iterator<Permission> r5 = this.mRegistry.getPermissions().iterator();     // Catch: Throwable -> L13
    L17:
        if (r5.hasNext() == false) goto L22;
        Permission bp = r5.next();     // Catch: Throwable -> L13
        if (Objects.equals(bp.getGroup(), groupName) == false) goto L17;
        out.add(bp.generatePermissionInfo(flags));     // Catch: Throwable -> L13
        goto L17
    L22:
        monitor-exit(r3);     // Catch: Throwable -> L13
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        final int callingUserId = UserHandle.getUserId(callingUid);
        if (permissionGroup != null) goto L26;
    L28:
        out.removeIf(new PermissionManagerServiceImpl$$ExternalSyntheticLambda5(this, callingUid, callingUserId));
        return out;
    L26:
        if (this.mPackageManagerInt.filterAppAccess(permissionGroup.getPackageName(), callingUid, callingUserId, false) == false) goto L28;
        return null;
    L13:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private /* synthetic */ boolean lambda$queryPermissionsByGroup$1(int callingUid, int callingUserId, PermissionInfo it) {
        return this.mPackageManagerInt.filterAppAccess(it.packageName, callingUid, callingUserId, false);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean addPermission(PermissionInfo info, boolean async) {
        int callingUid = Binder.getCallingUid();
        if (this.mPackageManagerInt.getInstantAppPackageName(callingUid) != null) goto L38;
        if (info.labelRes == 0) goto L7;
    L11:
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        Permission tree = this.mRegistry.enforcePermissionTree(info.name, callingUid);     // Catch: Throwable -> L20
        Permission bp = this.mRegistry.getPermission(info.name);     // Catch: Throwable -> L20
        if (bp != null) goto L16;
        boolean added = true;
    L17:
        int fixedLevel = PermissionInfo.fixProtectionLevel(info.protectionLevel);     // Catch: Throwable -> L20
        enforcePermissionCapLocked(info, tree);     // Catch: Throwable -> L20
        if (added == false) goto L23;
        bp = new Permission(info.name, tree.getPackageName(), 2);     // Catch: Throwable -> L20
    L24:
        boolean changed = bp.addToTree(fixedLevel, info, tree);     // Catch: Throwable -> L20
        if (added == false) goto L27;
        this.mRegistry.addPermission(bp);     // Catch: Throwable -> L20
    L27:
        monitor-exit(r1);     // Catch: Throwable -> L20
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (changed == false) goto L31;
        this.mPackageManagerInt.writeSettings(async);
    L31:
        return added;
    L23:
        if (bp.isDynamic() == true) goto L24;
        throw new SecurityException("Not allowed to modify non-dynamic permission " + info.name);     // Catch: Throwable -> L20
    L16:
        added = false;
    L20:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L7:
        if (info.nonLocalizedLabel != null) goto L11;
        throw new SecurityException("Label must be specified in permission");
    L38:
        throw new SecurityException("Instant apps can't add permissions");
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void removePermission(String permName) {
        int callingUid = Binder.getCallingUid();
        if (this.mPackageManagerInt.getInstantAppPackageName(callingUid) != null) goto L27;
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        this.mRegistry.enforcePermissionTree(permName, callingUid);     // Catch: Throwable -> L11
        Permission bp = this.mRegistry.getPermission(permName);     // Catch: Throwable -> L11
        if (bp != null) goto L14;
        monitor-exit(r1);     // Catch: Throwable -> L11
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L14:
        if (bp.isDynamic() == true) goto L19;
        Slog.wtf(TAG, "Not allowed to modify non-dynamic permission " + permName);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L19:
        this.mRegistry.removePermission(permName);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mPackageManagerInt.writeSettings(false);
        return;
    L11:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L27:
        throw new SecurityException("Instant applications don't have access to this method");
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int getPermissionFlags(String packageName, String permName, String deviceId, int userId) {
        int callingUid = Binder.getCallingUid();
        return getPermissionFlagsInternal(packageName, permName, callingUid, userId);
    }

    private int getPermissionFlagsInternal(String packageName, String permName, int callingUid, int userId) {
        if (this.mUserManagerInt.exists(userId) == true) goto L5;
        return 0;
    L5:
        enforceGrantRevokeGetRuntimePermissionPermissions("getPermissionFlags");
        enforceCrossUserPermission(callingUid, userId, true, false, "getPermissionFlags");
        AndroidPackage pkg = this.mPackageManagerInt.getPackage(packageName);
        if (pkg != null) goto L9;
        return 0;
    L9:
        if (this.mPackageManagerInt.filterAppAccess(packageName, callingUid, userId, false) == false) goto L11;
        return 0;
    L11:
        PackageManagerTracedLock r12 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r12);
    L18:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L14:
        if (this.mRegistry.getPermission(permName) != null) goto L20;
        monitor-exit(r12);     // Catch: Throwable -> L18
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return 0;
    L20:
        UidPermissionState uidState = getUidStateLocked(pkg, userId);     // Catch: Throwable -> L18
        if (uidState != null) goto L26;
        Slog.e(TAG, "Missing permissions state for " + packageName + " and user " + userId);     // Catch: Throwable -> L18
        monitor-exit(r12);     // Catch: Throwable -> L18
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return 0;
    L26:
        int r1 = uidState.getPermissionFlags(permName);     // Catch: Throwable -> L18
        monitor-exit(r12);     // Catch: Throwable -> L18
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void updatePermissionFlags(String packageName, String permName, int flagMask, int flagValues, boolean checkAdjustPolicyFlagPermission, String deviceId, int userId) {
        int callingUid = Binder.getCallingUid();
        if (callingUid == 1000) goto L14;
        if (callingUid == 0) goto L14;
        if ((flagMask & 4) == 0) goto L14;
        if (checkAdjustPolicyFlagPermission == false) goto L10;
        this.mContext.enforceCallingOrSelfPermission("android.permission.ADJUST_RUNTIME_PERMISSIONS_POLICY", "Need android.permission.ADJUST_RUNTIME_PERMISSIONS_POLICY to change policy flags");
    L11:
        boolean overridePolicy = true;
    L15:
        updatePermissionFlagsInternal(packageName, permName, flagMask, flagValues, callingUid, userId, overridePolicy, this.mDefaultPermissionCallback);
        return;
    L10:
        if (this.mPackageManagerInt.getUidTargetSdkVersion(callingUid) < 29) goto L11;
        throw new IllegalArgumentException("android.permission.ADJUST_RUNTIME_PERMISSIONS_POLICY needs  to be checked for packages targeting 29 or later when changing policy flags");
    L14:
        overridePolicy = false;
        goto L15
    }

    private void updatePermissionFlagsInternal(String packageName, String permName, int flagMask, int flagValues, int callingUid, int userId, boolean overridePolicy, PermissionCallback callback) {
        if (this.mUserManagerInt.exists(userId) == true) goto L5;
        return;
    L5:
        enforceGrantRevokeRuntimePermissionPermissions("updatePermissionFlags");
        enforceCrossUserPermission(callingUid, userId, true, true, "updatePermissionFlags");
        if ((flagMask & 4) == 0) goto L12;
        if (overridePolicy == true) goto L12;
        throw new SecurityException("updatePermissionFlags requires android.permission.ADJUST_RUNTIME_PERMISSIONS_POLICY");
    L12:
        if (callingUid == 1000) goto L14;
        int flagValues2 = (((((flagValues & (-17)) & (-33)) & (-4097)) & (-2049)) & (-8193)) & (-16385);
        int flagValues3 = (flagMask & (-17)) & (-33);
    L15:
        AndroidPackage pkg = this.mPackageManagerInt.getPackage(packageName);
        if (pkg != null) goto L20;
        Log.e(TAG, "Unknown package: " + packageName);
        return;
    L20:
        if (this.mPackageManagerInt.filterAppAccess(packageName, callingUid, userId, false) == true) goto L69;
        boolean isRequested = false;
        if (pkg.getRequestedPermissions().contains(permName) == false) goto L24;
        isRequested = true;
    L24:
        if (isRequested == true) goto L34;
        String[] sharedUserPackageNames = this.mPackageManagerInt.getSharedUserPackagesForPackage(packageName, userId);
        int r12 = sharedUserPackageNames.length;
        int r13 = 0;
    L27:
        if (r13 >= r12) goto L34;
        String sharedUserPackageName = sharedUserPackageNames[r13];
        AndroidPackage sharedUserPkg = this.mPackageManagerInt.getPackage(sharedUserPackageName);
        if (sharedUserPkg == null) goto L33;
        if (sharedUserPkg.getRequestedPermissions().contains(permName) == false) goto L33;
        boolean isRequested2 = true;
    L35:
        PackageManagerTracedLock r11 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r11);
        Permission bp = this.mRegistry.getPermission(permName);     // Catch: Throwable -> L45
        if (bp == null) goto L64;
        boolean isRuntimePermission = bp.isRuntime();     // Catch: Throwable -> L45
        UidPermissionState uidState = getUidStateLocked(pkg, userId);     // Catch: Throwable -> L45
        if (uidState != null) goto L48;
        Slog.e(TAG, "Missing permissions state for " + packageName + " and user " + userId);     // Catch: Throwable -> L45
        monitor-exit(r11);     // Catch: Throwable -> L45
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L48:
        if (uidState.hasPermissionState(permName) == true) goto L54;
        if (isRequested2 == true) goto L54;
        Log.e(TAG, "Permission " + permName + " isn't requested by package " + packageName);     // Catch: Throwable -> L45
        monitor-exit(r11);     // Catch: Throwable -> L45
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L54:
        boolean permissionUpdated = uidState.updatePermissionFlags(bp, flagValues3, flagValues2);     // Catch: Throwable -> L45
        monitor-exit(r11);     // Catch: Throwable -> L45
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (permissionUpdated == false) goto L75;
        if (callback == null) goto L76;
        if (isRuntimePermission == true) goto L61;
        callback.onInstallPermissionUpdated();
        return;
    L61:
        callback.onPermissionUpdated(new int[]{userId}, false, pkg.getUid());
        return;
    L76:
        return;
    L75:
        return;
    L64:
        throw new IllegalArgumentException("Unknown permission: " + permName);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L33:
        r13 = r13 + 1;
    L34:
        isRequested2 = isRequested;
        goto L35
    L69:
        throw new IllegalArgumentException("Unknown package: " + packageName);
    L14:
        flagValues3 = flagMask;
        flagValues2 = flagValues;
        goto L15
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void updatePermissionFlagsForAllApps(int flagMask, int flagValues, final int userId) {
        int callingUid = Binder.getCallingUid();
        if (this.mUserManagerInt.exists(userId) == true) goto L5;
        return;
    L5:
        enforceGrantRevokeRuntimePermissionPermissions("updatePermissionFlagsForAllApps");
        enforceCrossUserPermission(callingUid, userId, true, true, "updatePermissionFlagsForAllApps");
        if (callingUid == 1000) goto L8;
        final int effectiveFlagMask = flagMask;
    L9:
        if (callingUid == 1000) goto L11;
        final int effectiveFlagValues = flagValues;
    L12:
        final boolean[] changed = new boolean[1];
        this.mPackageManagerInt.forEachPackage(new PermissionManagerServiceImpl$$ExternalSyntheticLambda1(this, userId, changed, effectiveFlagMask, effectiveFlagValues));
        if (changed[0] == false) goto L16;
        this.mPackageManagerInt.writePermissionSettings(new int[]{userId}, true);
        return;
    L16:
        return;
    L11:
        effectiveFlagValues = flagValues & (-17);
        goto L12
    L8:
        effectiveFlagMask = flagMask & (-17);
        goto L9
    }

    private /* synthetic */ void lambda$updatePermissionFlagsForAllApps$2(int userId, boolean[] changed, int effectiveFlagMask, int effectiveFlagValues, AndroidPackage pkg) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        UidPermissionState uidState = getUidStateLocked(pkg, userId);     // Catch: Throwable -> L10
        if (uidState != null) goto L13;
        Slog.e(TAG, "Missing permissions state for " + pkg.getPackageName() + " and user " + userId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L13:
        changed[0] = changed[0] | uidState.updatePermissionFlagsForAllPermissions(effectiveFlagMask, effectiveFlagValues);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mOnPermissionChangeListeners.onPermissionsChanged(pkg.getUid());
        return;
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private int checkPermission(String pkgName, String permName, int userId) {
        return checkPermission(pkgName, permName, "default:0", userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int checkPermission(String pkgName, String permName, String deviceId, int userId) {
        if (this.mUserManagerInt.exists(userId) == true) goto L5;
        return -1;
    L5:
        AndroidPackage pkg = this.mPackageManagerInt.getPackage(pkgName);
        if (pkg != null) goto L9;
        return -1;
    L9:
        return checkPermissionInternal(pkg, true, permName, userId);
    }

    private int checkPermissionInternal(AndroidPackage pkg, boolean isPackageExplicit, String permissionName, int userId) {
        int callingUid = Binder.getCallingUid();
        if (isPackageExplicit == true) goto L11;
        if (pkg.getSharedUserId() == null) goto L11;
        if (this.mPackageManagerInt.getInstantAppPackageName(callingUid) == null) goto L13;
        return -1;
    L13:
        int uid = UserHandle.getUid(userId, pkg.getUid());
        if (this.mPackageManagerInt.getInstantAppPackageName(uid) == null) goto L16;
        boolean isInstantApp = true;
    L17:
        PackageManagerTracedLock r5 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        UidPermissionState uidState = getUidStateLocked(pkg, userId);     // Catch: Throwable -> L25
        if (uidState != null) goto L28;
        Slog.e(TAG, "Missing permissions state for " + pkg.getPackageName() + " and user " + userId);     // Catch: Throwable -> L25
        monitor-exit(r5);     // Catch: Throwable -> L25
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return -1;
    L28:
        if (checkSinglePermissionInternalLocked(uidState, permissionName, isInstantApp) == false) goto L32;
        monitor-exit(r5);     // Catch: Throwable -> L25
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return 0;
    L32:
        String fullerPermissionName = FULLER_PERMISSION_MAP.get(permissionName);     // Catch: Throwable -> L25
        if (fullerPermissionName != null) goto L35;
    L39:
        monitor-exit(r5);     // Catch: Throwable -> L25
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return -1;
    L35:
        if (checkSinglePermissionInternalLocked(uidState, fullerPermissionName, isInstantApp) == false) goto L39;
        monitor-exit(r5);     // Catch: Throwable -> L25
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return 0;
    L25:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L16:
        isInstantApp = false;
    L11:
        if (this.mPackageManagerInt.filterAppAccess(pkg.getPackageName(), callingUid, userId, false) == false) goto L13;
        return -1;
    }

    private boolean checkSinglePermissionInternalLocked(UidPermissionState uidState, String permissionName, boolean isInstantApp) {
        if (uidState.isPermissionGranted(permissionName) == true) goto L6;
        return false;
    L6:
        if (isInstantApp == false) goto L13;
        Permission permission = this.mRegistry.getPermission(permissionName);
        if (permission != null) goto L10;
        return false;
    L10:
        if (permission.isInstant() == true) goto L12;
        return false;
    L12:
        return true;
    L13:
        return true;
    }

    private int checkUidPermission(int uid, String permName) {
        return checkUidPermission(uid, permName, "default:0");
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int checkUidPermission(int uid, String permName, String deviceId) {
        int userId = UserHandle.getUserId(uid);
        if (this.mUserManagerInt.exists(userId) == true) goto L6;
        return -1;
    L6:
        AndroidPackage pkg = this.mPackageManagerInt.getPackage(uid);
        return checkUidPermissionInternal(pkg, uid, permName);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int getPermissionRequestState(String packageName, String permName, int deviceId, String persistentDeviceId) {
        throw new IllegalStateException("getPermissionRequestState is not supported.");
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Map<String, PermissionManager.PermissionState> getAllPermissionStates(String packageName, String deviceId, int userId) {
        throw new UnsupportedOperationException("This method is supported in newer implementation only");
    }

    private int checkUidPermissionInternal(AndroidPackage pkg, int uid, String permissionName) {
        if (pkg == null) goto L6;
        int userId = UserHandle.getUserId(uid);
        return checkPermissionInternal(pkg, false, permissionName, userId);
    L6:
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
    L13:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L9:
        if (checkSingleUidPermissionInternalLocked(uid, permissionName) == false) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L13
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return 0;
    L15:
        String fullerPermissionName = FULLER_PERMISSION_MAP.get(permissionName);     // Catch: Throwable -> L13
        if (fullerPermissionName != null) goto L18;
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L13
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return -1;
    L18:
        if (checkSingleUidPermissionInternalLocked(uid, fullerPermissionName) == false) goto L22;
        monitor-exit(r1);     // Catch: Throwable -> L13
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return 0;
    }

    private boolean checkSingleUidPermissionInternalLocked(int uid, String permissionName) {
        ArraySet<String> permissions = this.mSystemPermissions.get(uid);
        if (permissions != null) goto L5;
    L7:
        return false;
    L5:
        if (permissions.contains(permissionName) == false) goto L7;
        return true;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void addOnPermissionsChangeListener(IOnPermissionsChangeListener listener) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.OBSERVE_GRANT_REVOKE_PERMISSIONS", "addOnPermissionsChangeListener");
        this.mOnPermissionChangeListeners.addListener(listener);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void removeOnPermissionsChangeListener(IOnPermissionsChangeListener listener) {
        if (this.mPackageManagerInt.getInstantAppPackageName(Binder.getCallingUid()) != null) goto L7;
        this.mOnPermissionChangeListeners.removeListener(listener);
        return;
    L7:
        throw new SecurityException("Instant applications don't have access to this method");
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<String> getAllowlistedRestrictedPermissions(String packageName, int flags, int userId) {
        packageName.getClass();
        Preconditions.checkFlagsArgument(flags, 7);
        Preconditions.checkArgumentNonNegative(userId, null);
        if (UserHandle.getCallingUserId() == userId) goto L5;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS", "getAllowlistedRestrictedPermissions for user " + userId);
    L5:
        AndroidPackage pkg = this.mPackageManagerInt.getPackage(packageName);
        if (pkg != null) goto L8;
        return null;
    L8:
        int callingUid = Binder.getCallingUid();
        boolean isCallerHeartyService = false;
        if (this.mPackageManagerInt.filterAppAccess(packageName, callingUid, UserHandle.getCallingUserId(), false) == false) goto L12;
        return null;
    L12:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.WHITELIST_RESTRICTED_PERMISSIONS") != 0) goto L14;
        boolean isCallerPrivileged = true;
    L15:
        boolean isCallerInstallerOnRecord = this.mPackageManagerInt.isCallerInstallerOfRecord(pkg, callingUid);
        String callingPkg = this.mPackageManagerInt.getNameForUid(callingUid);
        if (this.mZswExt == null) goto L19;
        isCallerHeartyService = this.mZswExt.isHeartyServicePackage(callingPkg);
    L19:
        if ((flags & 1) == 0) goto L26;
        if (isCallerPrivileged == true) goto L26;
        if (isCallerHeartyService == true) goto L26;
        throw new SecurityException("Querying system allowlist requires android.permission.WHITELIST_RESTRICTED_PERMISSIONS");
    L26:
        if ((flags & 6) == 0) goto L33;
        if (isCallerPrivileged == true) goto L33;
        if (isCallerInstallerOnRecord == true) goto L33;
        if (isCallerHeartyService == true) goto L33;
        throw new SecurityException("Querying upgrade or installer allowlist requires being installer on record or android.permission.WHITELIST_RESTRICTED_PERMISSIONS");
    L33:
        long identity = Binder.clearCallingIdentity();
        List<String> r8 = getAllowlistedRestrictedPermissionsInternal(pkg, flags, userId);     // Catch: Throwable -> L37
        Binder.restoreCallingIdentity(identity);
        return r8;
    L37:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L14:
        isCallerPrivileged = false;
        goto L15
    }

    private List<String> getAllowlistedRestrictedPermissionsInternal(AndroidPackage pkg, int flags, int userId) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        UidPermissionState uidState = getUidStateLocked(pkg, userId);     // Catch: Throwable -> L10
        if (uidState != null) goto L12;
        Slog.e(TAG, "Missing permissions state for " + pkg.getPackageName() + " and user " + userId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return null;
    L12:
        int queryFlags = 0;
        if ((flags & 1) == 0) goto L16;
        queryFlags = 0 | 4096;
    L16:
        if ((flags & 4) == 0) goto L19;
        queryFlags = queryFlags | 8192;
    L19:
        if ((flags & 2) == 0) goto L21;
        queryFlags = queryFlags | 2048;
    L21:
        ArrayList<String> allowlistedPermissions = null;
        Iterator r4 = pkg.getRequestedPermissions().iterator();     // Catch: Throwable -> L10
    L24:
        if (r4.hasNext() == false) goto L31;
        String permissionName = (String) r4.next();     // Catch: Throwable -> L10
        int currentFlags = uidState.getPermissionFlags(permissionName);     // Catch: Throwable -> L10
        if ((currentFlags & queryFlags) == 0) goto L24;
        if (allowlistedPermissions != null) goto L29;
        allowlistedPermissions = new ArrayList();     // Catch: Throwable -> L10
    L29:
        allowlistedPermissions.add(permissionName);     // Catch: Throwable -> L10
        goto L24
    L31:
        monitor-exit(r0);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return allowlistedPermissions;
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean addAllowlistedRestrictedPermission(String packageName, String permName, int flags, int userId) {
        permName.getClass();
        if (checkExistsAndEnforceCannotModifyImmutablyRestrictedPermission(permName) == true) goto L5;
        return false;
    L5:
        List<String> permissions = getAllowlistedRestrictedPermissions(packageName, flags, userId);
        if (permissions != null) goto L9;
        permissions = new ArrayList(1);
    L9:
        if (permissions.indexOf(permName) >= 0) goto L12;
        permissions.add(permName);
        return setAllowlistedRestrictedPermissions(packageName, permissions, flags, userId);
    L12:
        return false;
    }

    private boolean checkExistsAndEnforceCannotModifyImmutablyRestrictedPermission(String permName) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        Permission bp = this.mRegistry.getPermission(permName);     // Catch: Throwable -> L10
        if (bp != null) goto L12;
        Slog.w(TAG, "No such permissions: " + permName);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return false;
    L12:
        String permissionPackageName = bp.getPackageName();     // Catch: Throwable -> L10
        if (bp.isHardOrSoftRestricted() == true) goto L15;
    L17:
        boolean isImmutablyRestrictedPermission = false;
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        if (this.mPackageManagerInt.filterAppAccess(permissionPackageName, callingUid, callingUserId, false) == false) goto L24;
        EventLog.writeEvent(1397638484, new Object[]{"186404356", Integer.valueOf(callingUid), permName});
        return false;
    L24:
        if (isImmutablyRestrictedPermission == true) goto L26;
    L30:
        return true;
    L26:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.WHITELIST_RESTRICTED_PERMISSIONS") == 0) goto L30;
        throw new SecurityException("Cannot modify allowlisting of an immutably restricted permission: " + permName);
    L15:
        if (bp.isImmutablyRestricted() == false) goto L17;
        isImmutablyRestrictedPermission = true;
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean removeAllowlistedRestrictedPermission(String packageName, String permName, int flags, int userId) {
        permName.getClass();
        if (checkExistsAndEnforceCannotModifyImmutablyRestrictedPermission(permName) == true) goto L5;
        return false;
    L5:
        List<String> permissions = getAllowlistedRestrictedPermissions(packageName, flags, userId);
        if (permissions != null) goto L8;
    L11:
        return false;
    L8:
        if (permissions.remove(permName) == false) goto L11;
        return setAllowlistedRestrictedPermissions(packageName, permissions, flags, userId);
    }

    private boolean setAllowlistedRestrictedPermissions(String packageName, List<String> permissions, int flags, int userId) {
        packageName.getClass();
        Preconditions.checkFlagsArgument(flags, 7);
        boolean isCallerPrivileged = false;
        if (Integer.bitCount(flags) != 1) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        Preconditions.checkArgumentNonNegative(userId, null);
        if (UserHandle.getCallingUserId() == userId) goto L9;
        this.mContext.enforceCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS", "setAllowlistedRestrictedPermissions for user " + userId);
    L9:
        AndroidPackage pkg = this.mPackageManagerInt.getPackage(packageName);
        if (pkg != null) goto L12;
        return false;
    L12:
        int callingUid = Binder.getCallingUid();
        if (this.mPackageManagerInt.filterAppAccess(packageName, callingUid, UserHandle.getCallingUserId(), false) == false) goto L16;
        return false;
    L16:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.WHITELIST_RESTRICTED_PERMISSIONS") != 0) goto L18;
        isCallerPrivileged = true;
    L18:
        boolean isCallerInstallerOnRecord = this.mPackageManagerInt.isCallerInstallerOfRecord(pkg, callingUid);
        if ((flags & 1) == 0) goto L25;
        if (isCallerPrivileged == true) goto L25;
        throw new SecurityException("Modifying system allowlist requires android.permission.WHITELIST_RESTRICTED_PERMISSIONS");
    L25:
        if ((flags & 4) == 0) goto L50;
        if (isCallerPrivileged == true) goto L31;
        if (isCallerInstallerOnRecord == true) goto L31;
        throw new SecurityException("Modifying upgrade allowlist requires being installer on record or android.permission.WHITELIST_RESTRICTED_PERMISSIONS");
    L31:
        List<String> allowlistedPermissions = getAllowlistedRestrictedPermissions(pkg.getPackageName(), flags, userId);
        if (permissions != null) goto L34;
    L45:
        if (allowlistedPermissions != null) goto L47;
    L48:
        return true;
    L47:
        if (allowlistedPermissions.isEmpty() == false) goto L50;
    L34:
        if (permissions.isEmpty() == true) goto L45;
        int permissionCount = permissions.size();
        int i = 0;
    L37:
        if (i >= permissionCount) goto L50;
        if (allowlistedPermissions != null) goto L40;
    L41:
        if (isCallerPrivileged == true) goto L42;
        throw new SecurityException("Adding to upgrade allowlist requiresandroid.permission.WHITELIST_RESTRICTED_PERMISSIONS");
    L42:
        i = i + 1;
        goto L37
    L40:
        if (allowlistedPermissions.contains(permissions.get(i)) == true) goto L42;
    L50:
        if ((flags & 2) == 0) goto L56;
        if (isCallerPrivileged == true) goto L56;
        if (isCallerInstallerOnRecord == true) goto L56;
        throw new SecurityException("Modifying installer allowlist requires being installer on record or android.permission.WHITELIST_RESTRICTED_PERMISSIONS");
    L56:
        long identity = Binder.clearCallingIdentity();
        setAllowlistedRestrictedPermissionsInternal(pkg, permissions, flags, userId);     // Catch: Throwable -> L60
        Binder.restoreCallingIdentity(identity);
        return true;
    L60:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void grantRuntimePermission(String packageName, String permName, String deviceId, int userId) {
        int callingUid = Binder.getCallingUid();
        if (checkUidPermission(callingUid, "android.permission.ADJUST_RUNTIME_PERMISSIONS_POLICY") != 0) goto L6;
        boolean r0 = true;
    L5:
        boolean overridePolicy = r0;
        grantRuntimePermissionInternal(packageName, permName, overridePolicy, callingUid, userId, this.mDefaultPermissionCallback);
        return;
    L6:
        r0 = false;
        goto L5
    }

    private void grantRuntimePermissionInternal(String packageName, String permName, boolean overridePolicy, int callingUid, int userId, PermissionCallback callback) {
        if (this.mUserManagerInt.exists(userId) == true) goto L7;
        Log.e(TAG, "No such user:" + userId);
        return;
    L7:
        if (this.mZswExt != null) goto L9;
    L11:
        enforceCrossUserPermission(callingUid, userId, true, true, "grantRuntimePermission");
        AndroidPackage pkg = this.mPackageManagerInt.getPackage(packageName);
        PackageStateInternal ps = this.mPackageManagerInt.getPackageStateInternal(packageName);
        if (pkg == null) goto L188;
        if (ps == null) goto L188;
        boolean mayGrantSoftRestrictedPermission = false;
        if (this.mPackageManagerInt.filterAppAccess(packageName, callingUid, userId, false) == true) goto L186;
        PackageManagerTracedLock r10 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r10);
        Permission permission = this.mRegistry.getPermission(permName);     // Catch: Throwable -> L176
        if (permission == null) goto L180;
        boolean isRolePermission = permission.isRole();     // Catch: Throwable -> L176
        boolean isSoftRestrictedPermission = permission.isSoftRestricted();     // Catch: Throwable -> L176
        monitor-exit(r10);     // Catch: Throwable -> L176
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (isRolePermission == true) goto L26;
    L28:
        boolean r11 = false;
    L29:
        boolean mayGrantRolePermission = r11;
        if (isSoftRestrictedPermission == false) goto L39;
        Context r12 = this.mContext;
        ApplicationInfo r14 = AndroidPackageUtils.generateAppInfoWithoutState(pkg);
        if (userId != 10) goto L34;
        int r15 = 0;
    L36:
        if (SoftRestrictedPermissionPolicy.forPermission(r12, r14, pkg, UserHandle.of(r15), permName).mayGrantPermission() == false) goto L39;
        mayGrantSoftRestrictedPermission = true;
        goto L39
    L34:
        r15 = userId;
    L39:
        PackageManagerTracedLock r16 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r16);
        Permission bp = this.mRegistry.getPermission(permName);     // Catch: Throwable -> L168
        if (bp == null) goto L172;
        boolean isRuntimePermission = bp.isRuntime();     // Catch: Throwable -> L168
        boolean permissionHasGids = bp.hasGids();     // Catch: Throwable -> L168
        if (isRuntimePermission == true) goto L201;
    L58:
        th = th;
    L173:
        monitor-exit(r16);     // Catch: Throwable -> L99
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L46:
        if (bp.isDevelopment() == true) goto L201;
        if (bp.isRole() == false) goto L61;
        if (mayGrantRolePermission == true) goto L201;
        throw new SecurityException("Permission " + permName + " is managed by role");     // Catch: Throwable -> L56
    L61:
        throw new SecurityException("Permission " + permName + " requested by " + pkg.getPackageName() + " is not a changeable permission type");     // Catch: Throwable -> L56
    L56:
        th = th;
    L201:
        UidPermissionState uidState = getUidStateLocked(pkg, userId);     // Catch: Throwable -> L166
        if (uidState != null) goto L194;
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L73
        r13.append("Missing permissions state for ");     // Catch: Throwable -> L71
        r13.append(pkg.getPackageName());     // Catch: Throwable -> L71
        r13.append(" and user ");     // Catch: Throwable -> L71
        r13.append(userId);     // Catch: Throwable -> L71
        Slog.e(TAG, r13.toString());     // Catch: Throwable -> L71
        monitor-exit(r16);     // Catch: Throwable -> L71
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L73:
        th = th;
        goto L173
    L194:
    L101:
        th = th;
        goto L173
    L77:
        if (uidState.hasPermissionState(permName) == true) goto L85;
        if (pkg.getRequestedPermissions().contains(permName) == true) goto L85;
        throw new SecurityException("Package " + pkg.getPackageName() + " has not requested permission " + permName);     // Catch: Throwable -> L71
    L85:
        if (pkg.getTargetSdkVersion() < 23) goto L87;
    L91:
        int flags = uidState.getPermissionFlags(permName);     // Catch: Throwable -> L101
        if ((flags & 16) == 0) goto L104;
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L101
        r17.append("Cannot grant system fixed permission ");     // Catch: Throwable -> L99
        r17.append(permName);     // Catch: Throwable -> L99
        r17.append(" for package ");     // Catch: Throwable -> L99
        r17.append(packageName);     // Catch: Throwable -> L99
        Log.e(TAG, r17.toString());     // Catch: Throwable -> L99
        monitor-exit(r16);     // Catch: Throwable -> L99
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L104:
        if (overridePolicy == true) goto L112;
        if ((flags & 4) == 0) goto L112;
        Log.e(TAG, "Cannot grant policy fixed permission " + permName + " for package " + packageName);     // Catch: Throwable -> L99
        monitor-exit(r16);     // Catch: Throwable -> L99
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L112:
        if (bp.isHardRestricted() == false) goto L120;
        if ((flags & 14336) != 0) goto L120;
        Log.e(TAG, "Cannot grant hard restricted non-exempt permission " + permName + " for package " + packageName);     // Catch: Throwable -> L99
        monitor-exit(r16);     // Catch: Throwable -> L99
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L120:
        if (bp.isSoftRestricted() == false) goto L127;
        if (mayGrantSoftRestrictedPermission == true) goto L127;
        Log.e(TAG, "Cannot grant soft restricted permission " + permName + " for package " + packageName);     // Catch: Throwable -> L99
        monitor-exit(r16);     // Catch: Throwable -> L99
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L127:
        if (bp.isDevelopment() == true) goto L150;
        if (bp.isRole() == true) goto L150;
        if (ps.getUserStateOrDefault(userId).isInstantApp() == false) goto L139;
        if (bp.isInstant() == true) goto L139;
        throw new SecurityException("Cannot grant non-ephemeral permission " + permName + " for package " + packageName);     // Catch: Throwable -> L99
    L139:
        if (pkg.getTargetSdkVersion() >= 23) goto L145;
        Slog.w(TAG, "Cannot grant runtime permission to a legacy app");     // Catch: Throwable -> L99
        monitor-exit(r16);     // Catch: Throwable -> L99
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L145:
        if (uidState.grantPermission(bp) == true) goto L154;
        monitor-exit(r16);     // Catch: Throwable -> L99
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L154:
        monitor-exit(r16);     // Catch: Throwable -> L99
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (isRuntimePermission == 0) goto L158;
        logPermission(1243, permName, packageName);
    L158:
        int uid = UserHandle.getUid(userId, pkg.getUid());
        if (callback == null) goto L204;
        if (isRuntimePermission == false) goto L162;
        callback.onPermissionGranted(uid, userId);
    L163:
        if (permissionHasGids == false) goto L205;
        callback.onGidsChanged(UserHandle.getAppId(pkg.getUid()), userId);
        return;
    L205:
        return;
    L162:
        callback.onInstallPermissionGranted();
        goto L163
    L204:
        return;
    L150:
        if (uidState.grantPermission(bp) == true) goto L154;
        monitor-exit(r16);     // Catch: Throwable -> L99
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L87:
        if (bp.isRuntime() == false) goto L91;
        monitor-exit(r16);     // Catch: Throwable -> L71
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L71:
        th = th;
    L166:
        th = th;
        goto L173
    L172:
        throw new IllegalArgumentException("Unknown permission: " + permName);     // Catch: Throwable -> L99
    L99:
        th = th;
    L168:
        th = th;
        goto L173
    L26:
        if (mayManageRolePermission(callingUid) == false) goto L28;
        r11 = true;
        goto L29
    L180:
        throw new IllegalArgumentException("Unknown permission: " + permName);     // Catch: Throwable -> L181
    L181:
        th = th;
    L182:
        monitor-exit(r10);     // Catch: Throwable -> L181
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L176:
        th = th;
        goto L182
    L186:
        throw new IllegalArgumentException("Unknown package: " + packageName);
    L188:
        Log.e(TAG, "Unknown package: " + packageName);
        return;
    L9:
        if (this.mZswExt.isHSCallingUid(this.mContext, callingUid) == true) goto L11;
        this.mContext.enforceCallingOrSelfPermission("android.permission.GRANT_RUNTIME_PERMISSIONS", "grantRuntimePermission");
        goto L11
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void revokeRuntimePermission(String packageName, String permName, String deviceId, int userId, String reason) {
        int callingUid = Binder.getCallingUid();
        if (checkUidPermission(callingUid, "android.permission.ADJUST_RUNTIME_PERMISSIONS_POLICY", "default:0") != 0) goto L6;
        boolean r0 = true;
    L5:
        boolean overridePolicy = r0;
        revokeRuntimePermissionInternal(packageName, permName, overridePolicy, callingUid, userId, reason, this.mDefaultPermissionCallback);
        return;
    L6:
        r0 = false;
        goto L5
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void revokePostNotificationPermissionWithoutKillForTest(String packageName, int userId) {
        int callingUid = Binder.getCallingUid();
        if (checkUidPermission(callingUid, "android.permission.ADJUST_RUNTIME_PERMISSIONS_POLICY") != 0) goto L6;
        boolean r0 = true;
    L5:
        boolean overridePolicy = r0;
        this.mContext.enforceCallingPermission("android.permission.REVOKE_POST_NOTIFICATIONS_WITHOUT_KILL", "");
        revokeRuntimePermissionInternal(packageName, "android.permission.POST_NOTIFICATIONS", overridePolicy, true, callingUid, userId, SKIP_KILL_APP_REASON_NOTIFICATION_TEST, this.mDefaultPermissionCallback);
        return;
    L6:
        r0 = false;
        goto L5
    }

    private void revokeRuntimePermissionInternal(String packageName, String permName, boolean overridePolicy, int callingUid, int userId, String reason, PermissionCallback callback) {
        revokeRuntimePermissionInternal(packageName, permName, overridePolicy, false, callingUid, userId, reason, callback);
    }

    private void revokeRuntimePermissionInternal(String packageName, String permName, boolean overridePolicy, boolean overrideKill, int callingUid, int userId, String reason, PermissionCallback callback) {
        if (this.mUserManagerInt.exists(userId) == true) goto L7;
        Log.e(TAG, "No such user:" + userId);
        return;
    L7:
        if (this.mZswExt != null) goto L9;
    L11:
        enforceCrossUserPermission(callingUid, userId, true, true, "revokeRuntimePermission");
        AndroidPackage pkg = this.mPackageManagerInt.getPackage(packageName);
        if (pkg != null) goto L15;
        Log.e(TAG, "Unknown package: " + packageName);
        return;
    L15:
        boolean r1 = false;
        if (this.mPackageManagerInt.filterAppAccess(packageName, callingUid, userId, false) == true) goto L111;
        PackageManagerTracedLock r2 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        Permission permission = this.mRegistry.getPermission(permName);     // Catch: Throwable -> L103
        if (permission == null) goto L106;
        boolean isRolePermission = permission.isRole();     // Catch: Throwable -> L103
        monitor-exit(r2);     // Catch: Throwable -> L103
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (isRolePermission == true) goto L26;
    L31:
        boolean mayRevokeRolePermission = r1;
        PackageManagerTracedLock r3 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r3);
        Permission bp = this.mRegistry.getPermission(permName);     // Catch: Throwable -> L46
        if (bp == null) goto L99;
        boolean isRuntimePermission = bp.isRuntime();     // Catch: Throwable -> L46
        if (isRuntimePermission == true) goto L50;
        if (bp.isDevelopment() == true) goto L50;
        if (bp.isRole() == false) goto L49;
        if (mayRevokeRolePermission == true) goto L50;
        throw new SecurityException("Permission " + permName + " is managed by role");     // Catch: Throwable -> L46
    L49:
        throw new SecurityException("Permission " + permName + " requested by " + pkg.getPackageName() + " is not a changeable permission type");     // Catch: Throwable -> L46
    L50:
        UidPermissionState uidState = getUidStateLocked(pkg, userId);     // Catch: Throwable -> L46
        if (uidState != null) goto L57;
        Slog.e(TAG, "Missing permissions state for " + pkg.getPackageName() + " and user " + userId);     // Catch: Throwable -> L46
        monitor-exit(r3);     // Catch: Throwable -> L46
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L57:
        if (uidState.hasPermissionState(permName) == true) goto L64;
        if (pkg.getRequestedPermissions().contains(permName) == true) goto L64;
        throw new SecurityException("Package " + pkg.getPackageName() + " has not requested permission " + permName);     // Catch: Throwable -> L46
    L64:
        if (pkg.getTargetSdkVersion() < 23) goto L66;
    L70:
        int flags = uidState.getPermissionFlags(permName);     // Catch: Throwable -> L46
        if ((flags & 16) != 0) goto L73;
    L77:
        if (overridePolicy == true) goto L84;
        if ((flags & 4) == 0) goto L84;
        throw new SecurityException("Cannot revoke policy fixed permission " + permName + " for package " + packageName);     // Catch: Throwable -> L46
    L84:
        if (uidState.revokePermission(bp) == true) goto L89;
        monitor-exit(r3);     // Catch: Throwable -> L46
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L89:
        monitor-exit(r3);     // Catch: Throwable -> L46
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (isRuntimePermission == false) goto L93;
        logPermission(1245, permName, packageName);
    L93:
        if (callback == null) goto L114;
        if (isRuntimePermission == false) goto L96;
        callback.onPermissionRevoked(UserHandle.getUid(userId, pkg.getUid()), userId, reason, overrideKill, permName);
        return;
    L96:
        this.mDefaultPermissionCallback.onInstallPermissionRevoked();
        return;
    L114:
        return;
    L73:
        if (UserHandle.getCallingAppId() == 1000) goto L77;
        throw new SecurityException("Non-System UID cannot revoke system fixed permission " + permName + " for package " + packageName);     // Catch: Throwable -> L46
    L66:
        if (bp.isRuntime() == false) goto L70;
        monitor-exit(r3);     // Catch: Throwable -> L46
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L99:
        throw new IllegalArgumentException("Unknown permission: " + permName);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L26:
        if (callingUid != Process.myUid()) goto L28;
    L29:
        r1 = true;
        goto L31
    L28:
        if (mayManageRolePermission(callingUid) == false) goto L31;
    L106:
        throw new IllegalArgumentException("Unknown permission: " + permName);     // Catch: Throwable -> L103
    L103:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L111:
        throw new IllegalArgumentException("Unknown package: " + packageName);
    L9:
        if (this.mZswExt.isHSCallingUid(this.mContext, callingUid) == true) goto L11;
        this.mContext.enforceCallingOrSelfPermission("android.permission.REVOKE_RUNTIME_PERMISSIONS", "revokeRuntimePermission");
        goto L11
    }

    private boolean mayManageRolePermission(int uid) {
        PackageManager packageManager = this.mContext.getPackageManager();
        String[] packageNames = packageManager.getPackagesForUid(uid);
        if (packageNames != null) goto L6;
        return false;
    L6:
        String permissionControllerPackageName = packageManager.getPermissionControllerPackageName();
        return Arrays.asList(packageNames).contains(permissionControllerPackageName);
    }

    private void resetRuntimePermissionsInternal(AndroidPackage filterPkg, final int userId, final boolean restorePregrantedPermissions) {
        final boolean[] permissionRemoved = new boolean[1];
        final ArraySet<Long> revokedPermissions = new ArraySet();
        final ArraySet<Integer> syncUpdatedUsers = new ArraySet();
        final ArraySet<Integer> asyncUpdatedUsers = new ArraySet();
        final PermissionCallback delayingPermCallback = new AnonymousClass2(this, revokedPermissions, syncUpdatedUsers, asyncUpdatedUsers, permissionRemoved);
        if (filterPkg == null) goto L5;
        resetRuntimePermissionsInternal(filterPkg, userId, restorePregrantedPermissions, delayingPermCallback);
    L7:
        if (permissionRemoved[0] == false) goto L10;
        this.mDefaultPermissionCallback.onPermissionRemoved();
    L10:
        if (revokedPermissions.isEmpty() == true) goto L14;
        int numRevokedPermissions = revokedPermissions.size();
        int i = 0;
    L12:
        if (i >= numRevokedPermissions) goto L14;
        final int revocationUID = IntPair.first(revokedPermissions.valueAt(i).longValue());
        final int revocationUserId = IntPair.second(revokedPermissions.valueAt(i).longValue());
        this.mOnPermissionChangeListeners.onPermissionsChanged(revocationUID);
        this.mHandler.post(new PermissionManagerServiceImpl$$ExternalSyntheticLambda11(revocationUID, revocationUserId));
        i = i + 1;
    L14:
        this.mPackageManagerInt.writePermissionSettings(ArrayUtils.convertToIntArray(syncUpdatedUsers), false);
        this.mPackageManagerInt.writePermissionSettings(ArrayUtils.convertToIntArray(asyncUpdatedUsers), true);
        return;
    L5:
        this.mPackageManagerInt.forEachPackage(new PermissionManagerServiceImpl$$ExternalSyntheticLambda10(this, userId, restorePregrantedPermissions, delayingPermCallback));
        goto L7
    }

    private /* synthetic */ void lambda$resetRuntimePermissionsInternal$3(int userId, boolean restorePregrantedPermissions, PermissionCallback delayingPermCallback, AndroidPackage pkg) {
        resetRuntimePermissionsInternal(pkg, userId, restorePregrantedPermissions, delayingPermCallback);
    }

    private static /* synthetic */ void lambda$resetRuntimePermissionsInternal$4(int revocationUID, int revocationUserId) {
        killUid(UserHandle.getAppId(revocationUID), revocationUserId, "permissions revoked");
    }

    private void resetRuntimePermissionsInternal(AndroidPackage pkg, int userId, boolean restorePregrantedPermissions, PermissionCallback delayingPermCallback) {
        PermissionManagerServiceImpl r1 = this;
        int r6 = userId;
        int userSettableMask = 589899;
        String packageName = pkg.getPackageName();
        Iterator r12 = pkg.getRequestedPermissions().iterator();
    L4:
        if (r12.hasNext() == false) goto L76;
        String permName = (String) r12.next();
        if (r1.mIsLeanback == false) goto L10;
        if (NOTIFICATION_PERMISSIONS.contains(permName) == true) goto L4;
    L10:
        PackageManagerTracedLock r4 = r1.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        Permission permission = r1.mRegistry.getPermission(permName);     // Catch: Throwable -> L69
        if (permission != null) goto L19;
        monitor-exit(r4);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L16:
        th = th;
    L79:
        monitor-exit(r4);     // Catch: Throwable -> L74
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L74:
        th = th;
        goto L79
    L19:
        if (permission.isRemoved() == true) goto L20;
        boolean isRuntimePermission = permission.isRuntime();     // Catch: Throwable -> L69
        monitor-exit(r4);     // Catch: Throwable -> L69
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        String[] pkgNames = r1.mPackageManagerInt.getSharedUserPackagesForPackage(pkg.getPackageName(), r6);
        int flags = 0;
        if (pkgNames.length <= 0) goto L39;
        boolean used = false;
        int r5 = pkgNames.length;
        int r7 = 0;
    L28:
        if (r7 >= r5) goto L37;
        String sharedPkgName = pkgNames[r7];
        AndroidPackage sharedPkg = r1.mPackageManagerInt.getPackage(sharedPkgName);
        if (sharedPkg == null) goto L36;
        if (sharedPkg.getPackageName().equals(packageName) == true) goto L36;
        if (sharedPkg.getRequestedPermissions().contains(permName) == false) goto L36;
        used = true;
    L36:
        r7 = r7 + 1;
    L37:
        if (used == true) goto L4;
    L39:
        int oldFlags = r1.getPermissionFlagsInternal(packageName, permName, 1000, r6);
        int uid = r1.mPackageManagerInt.getPackageUid(packageName, 0, r6);
        int targetSdk = r1.mPackageManagerInt.getUidTargetSdkVersion(uid);
        if (targetSdk >= 23) goto L44;
        if (isRuntimePermission == false) goto L44;
        flags = 72;
    L44:
        int targetSdk2 = flags;
        int userSettableMask2 = userSettableMask;
        r1.updatePermissionFlagsInternal(packageName, permName, 589899, targetSdk2, 1000, userId, false, delayingPermCallback);
        if (isRuntimePermission == false) goto L46;
        if ((oldFlags & 20) != 0) goto L49;
        if ((oldFlags & 32) == 0) goto L53;
    L62:
        if (restorePregrantedPermissions == false) goto L67;
        grantRuntimePermissionInternal(packageName, permName, false, 1000, userId, delayingPermCallback);
        PermissionManagerServiceImpl r8 = this;
        if (r8.mPermissionSmtEx == null) goto L68;
        String packageName2 = packageName;
        r8.mPermissionSmtEx.setOpsMode(r8.mContext, r8.mHandler, permName, packageName2, userId, pkg.getUid(), true);
        packageName = packageName2;
    L68:
        r6 = userId;
        r1 = r8;
        userSettableMask = userSettableMask2;
        goto L4
    L67:
        r8 = this;
        goto L68
    L53:
        if ((32768 & oldFlags) != 0) goto L62;
        if ((targetSdk2 & 64) == 0) goto L58;
        r8 = this;
        goto L68
    L58:
        if (r1.isPermissionSplitFromNonRuntime(permName, targetSdk) == true) goto L60;
        r1.revokeRuntimePermissionInternal(packageName, permName, false, 1000, userId, null, delayingPermCallback);
        r8 = this;
        goto L68
    L60:
        r8 = this;
        goto L68
    L49:
        r6 = userId;
        userSettableMask = userSettableMask2;
        goto L4
    L46:
        r6 = userId;
        userSettableMask = userSettableMask2;
        goto L4
    L20:
        monitor-exit(r4);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L69:
        th = th;
        goto L79
    }

    private boolean isPermissionSplitFromNonRuntime(String permName, int targetSdk) {
        List<PermissionManager.SplitPermissionInfo> splitPerms = getSplitPermissionInfos();
        int size = splitPerms.size();
        int i = 0;
    L3:
        boolean r3 = false;
        if (i >= size) goto L26;
        PermissionManager.SplitPermissionInfo splitPerm = splitPerms.get(i);
        if (targetSdk >= splitPerm.getTargetSdk()) goto L24;
        if (splitPerm.getNewPermissions().contains(permName) == false) goto L24;
        PackageManagerTracedLock r5 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        Permission perm = this.mRegistry.getPermission(splitPerm.getSplitPermission());     // Catch: Throwable -> L16
        if (perm != null) goto L14;
    L18:
        monitor-exit(r5);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r3;
    L14:
        if (perm.isRuntime() == true) goto L18;
        r3 = true;
    L16:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L24:
        i = i + 1;
        goto L3
    L26:
        return false;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean shouldShowRequestPermissionRationale(String packageName, String permName, String deviceId, int userId) {
        int callingUid = Binder.getCallingUid();
        if (UserHandle.getCallingUserId() == userId) goto L5;
        this.mContext.enforceCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "canShowRequestPermissionRationale for user " + userId);
    L5:
        int uid = this.mPackageManagerInt.getPackageUid(packageName, 268435456, userId);
        if (UserHandle.getAppId(callingUid) == UserHandle.getAppId(uid)) goto L9;
        return false;
    L9:
        if (checkPermission(packageName, permName, userId) != 0) goto L11;
        return false;
    L11:
        long identity = Binder.clearCallingIdentity();
        int flags = getPermissionFlagsInternal(packageName, permName, callingUid, userId);     // Catch: Throwable -> L70
        Binder.restoreCallingIdentity(identity);
        if ((flags & 22) == 0) goto L16;
        return false;
    L16:
        PackageManagerTracedLock r12 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r12);
        Permission permission = this.mRegistry.getPermission(permName);     // Catch: Throwable -> L63
        if (permission != null) goto L26;
        monitor-exit(r12);     // Catch: Throwable -> L23
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return false;
    L26:
        if (permission.isHardRestricted() == true) goto L28;
    L32:
        monitor-exit(r12);     // Catch: Throwable -> L63
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        long token = Binder.clearCallingIdentity();
    L42:
        th = th;
    L61:
        Binder.restoreCallingIdentity(token);
        throw th;
    L48:
        e = e;
    L54:
        Log.e(TAG, "Unable to check if compatibility change is enabled.", e);     // Catch: Throwable -> L42
    L75:
    L52:
        Binder.restoreCallingIdentity(token);
        if ((flags & 1) != 0) goto L88;
        return false;
    L88:
        return true;
    L46:
        th = th;
        goto L61
    L35:
        if (permName.equals("android.permission.ACCESS_BACKGROUND_LOCATION") == false) goto L52;
    L78:
        if (this.mPlatformCompat.isChangeEnabledByPackageName(BACKGROUND_RATIONALE_CHANGE_ID, packageName, userId) == false) goto L75;
        Binder.restoreCallingIdentity(token);
        return true;
    L44:
        e = e;
        goto L54
    L28:
        if ((flags & 14336) != 0) goto L32;
        monitor-exit(r12);     // Catch: Throwable -> L23
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return false;
    L23:
        th = th;
    L83:
        monitor-exit(r12);     // Catch: Throwable -> L68
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L68:
        th = th;
    L63:
        th = th;
    L70:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean isPermissionRevokedByPolicy(String packageName, String permName, String deviceId, int userId) {
        if (UserHandle.getCallingUserId() == userId) goto L5;
        this.mContext.enforceCallingPermission("android.permission.INTERACT_ACROSS_USERS_FULL", "isPermissionRevokedByPolicy for user " + userId);
    L5:
        boolean r1 = false;
        if (checkPermission(packageName, permName, userId) != 0) goto L8;
        return false;
    L8:
        int callingUid = Binder.getCallingUid();
        if (this.mPackageManagerInt.filterAppAccess(packageName, callingUid, userId, false) == false) goto L11;
        return false;
    L11:
        long identity = Binder.clearCallingIdentity();
        int flags = getPermissionFlagsInternal(packageName, permName, callingUid, userId);     // Catch: Throwable -> L18
        if ((flags & 4) == 0) goto L16;
        r1 = true;
    L16:
        Binder.restoreCallingIdentity(identity);
        return r1;
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public byte[] backupRuntimePermissions(int userId) {
        Preconditions.checkArgumentNonNegative(userId, "userId");
        final CompletableFuture<byte[]> backup = new CompletableFuture();
        this.mPermissionControllerManager.getRuntimePermissionBackup(UserHandle.of(userId), PermissionThread.getExecutor(), new PermissionManagerServiceImpl$$ExternalSyntheticLambda12(backup));
        return backup.get(BACKUP_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
    L5:
        e = move-exception;
        Slog.e(TAG, "Cannot create permission backup for user " + userId, e);
        return null;
    }

    public void restoreRuntimePermissions(byte[] backup, int userId) {
        backup.getClass();
        Preconditions.checkArgumentNonNegative(userId, "userId");
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        this.mHasNoDelayedPermBackup.delete(userId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mPermissionControllerManager.stageAndApplyRuntimePermissionsBackup(backup, UserHandle.of(userId));
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void restoreDelayedRuntimePermissions(String packageName, final int userId) {
        packageName.getClass();
        Preconditions.checkArgumentNonNegative(userId, "userId");
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L5:
        if (this.mHasNoDelayedPermBackup.get(userId, false) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mPermissionControllerManager.applyStagedRuntimePermissionBackup(packageName, UserHandle.of(userId), PermissionThread.getExecutor(), new PermissionManagerServiceImpl$$ExternalSyntheticLambda16(this, userId));
    }

    private /* synthetic */ void lambda$restoreDelayedRuntimePermissions$5(int userId, Boolean hasMoreBackup) {
        if (hasMoreBackup.booleanValue() == false) goto L5;
        return;
    L5:
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        this.mHasNoDelayedPermBackup.put(userId, true);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L11:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void revokeStoragePermissionsIfScopeExpandedInternal(AndroidPackage newPackage, AndroidPackage oldPackage) {
        PermissionManagerServiceImpl r1 = this;
        if (oldPackage.getTargetSdkVersion() >= 29) goto L5;
    L7:
        boolean r0 = false;
    L8:
        boolean downgradedSdk = r0;
        if (oldPackage.getTargetSdkVersion() < 29) goto L11;
    L13:
        boolean r2 = false;
    L14:
        boolean upgradedSdk = r2;
        if (upgradedSdk == false) goto L17;
    L21:
        boolean r3 = false;
    L22:
        boolean newlyRequestsLegacy = r3;
        if (newlyRequestsLegacy == true) goto L26;
        if (downgradedSdk == true) goto L26;
        return;
    L26:
        int callingUid = Binder.getCallingUid();
        int[] r14 = r1.getAllUserIds();
        int r15 = r14.length;
        int r4 = 0;
    L27:
        if (r4 >= r15) goto L73;
        int userId = r14[r4];
        Iterator r16 = newPackage.getRequestedPermissions().iterator();
    L30:
        if (r16.hasNext() == false) goto L72;
        String permName = (String) r16.next();
        PermissionInfo permInfo = r1.getPermissionInfo(permName, 0, newPackage.getPackageName());
        if (permInfo == null) goto L30;
        if (STORAGE_PERMISSIONS.contains(permInfo.name) == false) goto L37;
    L42:
        boolean r5 = true;
    L43:
        boolean isStorageOrMedia = r5;
        if (isStorageOrMedia == false) goto L30;
        if ((r1.getPermissionFlags(newPackage.getPackageName(), permInfo.name, "default:0", userId) & 20) == 0) goto L49;
        boolean r6 = true;
    L50:
        boolean isSystemOrPolicyFixed = r6;
        if (isSystemOrPolicyFixed == true) goto L30;
        EventLog.writeEvent(1397638484, new Object[]{"171430330", Integer.valueOf(newPackage.getUid()), "Revoking permission " + permInfo.name + " from package " + newPackage.getPackageName() + " as either the sdk downgraded " + downgradedSdk + " or newly requested legacy full storage " + newlyRequestsLegacy});
        int r7 = r4;
        String r8 = newPackage.getPackageName();     // Catch: Throwable -> L68
        String permName2 = permInfo.name;     // Catch: Throwable -> L66
        int r21 = r7;
        PermissionInfo permInfo2 = permInfo;
        r1.revokeRuntimePermissionInternal(r8, permName2, false, callingUid, userId, null, r1.mDefaultPermissionCallback);     // Catch: Throwable -> L62
    L71:
        r1 = this;
        r4 = r21;
    L62:
        e = e;
    L70:
        Log.e(TAG, "unable to revoke " + permInfo2.name + " for " + newPackage.getPackageName() + " user " + userId, e);
    L64:
        e = e;
        permInfo2 = permInfo;
        r21 = r7;
    L66:
        e = e;
        permInfo2 = permInfo;
        r21 = r7;
    L68:
        e = e;
        permInfo2 = permInfo;
        r21 = r7;
        goto L70
    L49:
        r6 = false;
        goto L50
    L37:
        if (READ_MEDIA_AURAL_PERMISSIONS.contains(permInfo.name) == true) goto L42;
        if (READ_MEDIA_VISUAL_PERMISSIONS.contains(permInfo.name) == true) goto L42;
        r5 = false;
        goto L43
    L72:
        r4 = r4 + 1;
        r1 = this;
        goto L27
    L73:
        return;
    L17:
        if (oldPackage.isRequestLegacyExternalStorage() == true) goto L21;
        if (newPackage.isRequestLegacyExternalStorage() == false) goto L21;
        r3 = true;
        goto L22
    L11:
        if (newPackage.getTargetSdkVersion() < 29) goto L13;
        r2 = true;
        goto L14
    L5:
        if (newPackage.getTargetSdkVersion() >= 29) goto L7;
        r0 = true;
        goto L8
    }

    private void revokeSystemAlertWindowIfUpgradedPast23(AndroidPackage newPackage, AndroidPackage oldPackage) {
        if (oldPackage.getTargetSdkVersion() < 23) goto L5;
        return;
    L5:
        if (newPackage.getTargetSdkVersion() >= 23) goto L7;
        return;
    L7:
        if (newPackage.getRequestedPermissions().contains("android.permission.SYSTEM_ALERT_WINDOW") == false) goto L42;
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        Permission saw = this.mRegistry.getPermission("android.permission.SYSTEM_ALERT_WINDOW");     // Catch: Throwable -> L28
        monitor-exit(r1);     // Catch: Throwable -> L28
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        PackageStateInternal ps = this.mPackageManagerInt.getPackageStateInternal(newPackage.getPackageName());
        if (shouldGrantPermissionByProtectionFlags(newPackage, ps, saw, new ArraySet()) == false) goto L16;
        return;
    L16:
        if (shouldGrantPermissionBySignature(newPackage, saw) == true) goto L40;
        int[] r3 = getAllUserIds();
        int r4 = r3.length;
        int r5 = 0;
    L19:
        if (r5 >= r4) goto L26;
        int userId = r3[r5];
        revokePermissionFromPackageForUser(newPackage.getPackageName(), "android.permission.SYSTEM_ALERT_WINDOW", false, userId, this.mDefaultPermissionCallback);     // Catch: Throwable -> L23
    L25:
        r5 = r5 + 1;
    L23:
        e = move-exception;
        Log.e(TAG, "unable to revoke SYSTEM_ALERT_WINDOW for " + newPackage.getPackageName() + " user " + userId, e);
        goto L25
    L26:
        return;
    L40:
        return;
    L28:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void revokeRuntimePermissionsIfGroupChangedInternal(final AndroidPackage newPackage, AndroidPackage oldPackage) {
        int numOldPackagePermissions = ArrayUtils.size(oldPackage.getPermissions());
        ArrayMap<String, String> oldPermissionNameToGroupName = new ArrayMap(numOldPackagePermissions);
        int i = 0;
    L3:
        if (i >= numOldPackagePermissions) goto L8;
        ParsedPermission permission = (ParsedPermission) oldPackage.getPermissions().get(i);
        if (permission.getParsedPermissionGroup() == null) goto L7;
        oldPermissionNameToGroupName.put(permission.getName(), permission.getParsedPermissionGroup().getName());
    L7:
        i = i + 1;
        goto L3
    L8:
        final int callingUid = Binder.getCallingUid();
        int numNewPackagePermissions = ArrayUtils.size(newPackage.getPermissions());
        int newPermissionNum = 0;
    L9:
        if (newPermissionNum >= numNewPackagePermissions) goto L24;
        ParsedPermission newPermission = (ParsedPermission) newPackage.getPermissions().get(newPermissionNum);
        int newProtection = ParsedPermissionUtils.getProtection(newPermission);
        if ((newProtection & 1) == 0) goto L22;
        final String permissionName = newPermission.getName();
        if (newPermission.getParsedPermissionGroup() != null) goto L16;
        String r3 = null;
    L15:
        final String newPermissionGroupName = r3;
        final String oldPermissionGroupName = oldPermissionNameToGroupName.get(permissionName);
        if (newPermissionGroupName == null) goto L22;
        if (newPermissionGroupName.equals(oldPermissionGroupName) == true) goto L22;
        final int[] userIds = this.mUserManagerInt.getUserIds();
        this.mPackageManagerInt.forEachPackage(new PermissionManagerServiceImpl$$ExternalSyntheticLambda9(this, userIds, permissionName, newPackage, oldPermissionGroupName, newPermissionGroupName, callingUid));
        goto L22
    L16:
        r3 = newPermission.getParsedPermissionGroup().getName();
    L22:
        newPermissionNum = newPermissionNum + 1;
        goto L9
    }

    private /* synthetic */ void lambda$revokeRuntimePermissionsIfGroupChangedInternal$6(int[] userIds, String permissionName, AndroidPackage newPackage, String oldPermissionGroupName, String newPermissionGroupName, int callingUid, AndroidPackage pkg) {
        String packageName = pkg.getPackageName();
        int r10 = userIds.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L14;
        int userId = userIds[r11];
        int permissionState = checkPermission(packageName, permissionName, userId);
        if (permissionState != 0) goto L12;
        EventLog.writeEvent(1397638484, new Object[]{"72710897", Integer.valueOf(newPackage.getUid()), "Revoking permission " + permissionName + " from package " + packageName + " as the group changed from " + oldPermissionGroupName + " to " + newPermissionGroupName});
        revokeRuntimePermissionInternal(packageName, permissionName, false, callingUid, userId, null, this.mDefaultPermissionCallback);     // Catch: IllegalArgumentException -> L9
    L9:
        e = move-exception;
        Slog.e(TAG, "Could not revoke " + permissionName + " from " + packageName, e);
    L12:
        r11 = r11 + 1;
        goto L3
    }

    private void revokeRuntimePermissionsIfPermissionDefinitionChangedInternal(List<String> permissionsToRevoke) {
        final int[] userIds = this.mUserManagerInt.getUserIds();
        int numPermissions = permissionsToRevoke.size();
        final int callingUid = Binder.getCallingUid();
        int permNum = 0;
    L3:
        if (permNum >= numPermissions) goto L25;
        final String permName = permissionsToRevoke.get(permNum);
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        Permission bp = this.mRegistry.getPermission(permName);     // Catch: Throwable -> L13
        if (bp == null) goto L18;
        if (bp.isInternal() == false) goto L11;
    L15:
        final boolean isInternalPermission = bp.isInternal();     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mPackageManagerInt.forEachPackage(new PermissionManagerServiceImpl$$ExternalSyntheticLambda0(this, userIds, permName, isInternalPermission, callingUid));
    L20:
        permNum = permNum + 1;
        goto L3
    L11:
        if (bp.isRuntime() == true) goto L15;
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L13
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L13:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$revokeRuntimePermissionsIfPermissionDefinitionChangedInternal$7(int[] userIds, String permName, boolean isInternalPermission, int callingUid, AndroidPackage pkg) {
        int[] r9 = userIds;
        String packageName = pkg.getPackageName();
        int appId = pkg.getUid();
        if (appId >= 10000) goto L5;
        return;
    L5:
        int r11 = r9.length;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L27;
        int userId = r9[r12];
        int permissionState = checkPermission(packageName, permName, userId);
        int flags = getPermissionFlags(packageName, permName, "default:0", userId);
        if (permissionState != 0) goto L26;
        if ((32820 & flags) != 0) goto L26;
        int uid = UserHandle.getUid(userId, appId);
        if (isInternalPermission == false) goto L14;
        EventLog.writeEvent(1397638484, new Object[]{"195338390", Integer.valueOf(uid), "Revoking permission " + permName + " from package " + packageName + " due to definition change"});
    L15:
        Slog.e(TAG, "Revoking permission " + permName + " from package " + packageName + " due to definition change");
        PermissionCallback r8 = this.mDefaultPermissionCallback;     // Catch: Exception -> L22
        String r10 = TAG;
        revokeRuntimePermissionInternal(packageName, permName, false, callingUid, userId, null, r8);     // Catch: Exception -> L20
    L20:
        e = e;
    L24:
        Slog.e(r10, "Could not revoke " + permName + " from " + packageName, e);
    L22:
        e = e;
        r10 = TAG;
        goto L24
    L14:
        EventLog.writeEvent(1397638484, new Object[]{"154505240", Integer.valueOf(uid), "Revoking permission " + permName + " from package " + packageName + " due to definition change"});
        EventLog.writeEvent(1397638484, new Object[]{"168319670", Integer.valueOf(uid), "Revoking permission " + permName + " from package " + packageName + " due to definition change"});
    L26:
        r12 = r12 + 1;
        r9 = userIds;
        goto L6
    }

    private List<String> addAllPermissionsInternal(PackageState packageState, AndroidPackage pkg) {
        int N = ArrayUtils.size(pkg.getPermissions());
        ArrayList<String> definitionChangedPermissions = new ArrayList();
        int i = 0;
    L3:
        if (i >= N) goto L37;
        ParsedPermission p = (ParsedPermission) pkg.getPermissions().get(i);
        PackageManagerTracedLock r4 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        if (pkg.getTargetSdkVersion() <= 22) goto L11;
        ComponentMutateUtils.setParsedPermissionGroup(p, this.mRegistry.getPermissionGroup(p.getGroup()));     // Catch: Throwable -> L9
    L11:
        PermissionInfo permissionInfo = PackageInfoUtils.generatePermissionInfo(p, 128);     // Catch: Throwable -> L9
        if (p.isTree() == false) goto L14;
        Permission oldPermission = this.mRegistry.getPermissionTree(p.getName());     // Catch: Throwable -> L9
    L16:
        monitor-exit(r4);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        boolean isOverridingSystemPermission = Permission.isOverridingSystemPermission(oldPermission, permissionInfo, this.mPackageManagerInt);
        PackageManagerTracedLock r8 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r8);
        Permission permission = Permission.createOrUpdate(oldPermission, permissionInfo, packageState, this.mRegistry.getPermissionTrees(), isOverridingSystemPermission);     // Catch: Throwable -> L22
        if (p.isTree() == false) goto L24;
        this.mRegistry.addPermissionTree(permission);     // Catch: Throwable -> L22
    L26:
        if (permission.isDefinitionChanged() == false) goto L28;
        definitionChangedPermissions.add(p.getName());     // Catch: Throwable -> L22
        permission.setDefinitionChanged(false);     // Catch: Throwable -> L22
    L28:
        monitor-exit(r8);     // Catch: Throwable -> L22
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        i = i + 1;
        goto L3
    L24:
        this.mRegistry.addPermission(permission);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L14:
        oldPermission = this.mRegistry.getPermission(p.getName());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L37:
        return definitionChangedPermissions;
    }

    private void addAllPermissionGroupsInternal(AndroidPackage pkg) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        int N = ArrayUtils.size(pkg.getPermissionGroups());     // Catch: Throwable -> L15
        int i = 0;
    L5:
        if (i >= N) goto L20;
        ParsedPermissionGroup pg = (ParsedPermissionGroup) pkg.getPermissionGroups().get(i);     // Catch: Throwable -> L15
        ParsedPermissionGroup cur = this.mRegistry.getPermissionGroup(pg.getName());     // Catch: Throwable -> L15
        if (cur != null) goto L9;
        String curPackageName = null;
    L10:
        boolean isPackageUpdate = pg.getPackageName().equals(curPackageName);     // Catch: Throwable -> L15
        if (cur == null) goto L17;
        if (isPackageUpdate == true) goto L17;
        Slog.w(TAG, "Permission group " + pg.getName() + " from package " + pg.getPackageName() + " ignored: original from " + cur.getPackageName());     // Catch: Throwable -> L15
    L18:
        i = i + 1;     // Catch: Throwable -> L15
    L17:
        this.mRegistry.addPermissionGroup(pg);     // Catch: Throwable -> L15
        goto L18
    L9:
        curPackageName = cur.getPackageName();     // Catch: Throwable -> L15
        goto L10
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L15
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L15:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void removeAllPermissionsInternal(AndroidPackage pkg) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        int n = ArrayUtils.size(pkg.getPermissions());     // Catch: Throwable -> L9
        StringBuilder r = null;
        int i = 0;
    L5:
        if (i >= n) goto L24;
        ParsedPermission p = (ParsedPermission) pkg.getPermissions().get(i);     // Catch: Throwable -> L9
        Permission bp = this.mRegistry.getPermission(p.getName());     // Catch: Throwable -> L9
        if (bp != null) goto L11;
        bp = this.mRegistry.getPermissionTree(p.getName());     // Catch: Throwable -> L9
    L11:
        if (bp == null) goto L20;
        if (bp.isPermission(p) == false) goto L20;
        bp.setPermissionInfo(null);     // Catch: Throwable -> L9
        if (r != null) goto L17;
        r = new StringBuilder(256);     // Catch: Throwable -> L9
    L18:
        r.append(p.getName());     // Catch: Throwable -> L9
        goto L20
    L17:
        r.append(' ');     // Catch: Throwable -> L9
    L20:
        if (ParsedPermissionUtils.isAppOp(p) == false) goto L22;
        this.mRegistry.removeAppOpPermissionPackage(p.getName(), pkg.getPackageName());     // Catch: Throwable -> L9
    L22:
        i = i + 1;     // Catch: Throwable -> L9
        goto L5
    L24:
        if (r == null) goto L26;
        Log.d(TAG, "  Permissions: " + r);     // Catch: Throwable -> L9
    L26:
        Iterator r3 = pkg.getRequestedPermissions().iterator();     // Catch: Throwable -> L9
    L28:
        if (r3.hasNext() == false) goto L35;
        String permissionName = (String) r3.next();     // Catch: Throwable -> L9
        Permission permission = this.mRegistry.getPermission(permissionName);     // Catch: Throwable -> L9
        if (permission == null) goto L28;
        if (permission.isAppOp() == false) goto L28;
        this.mRegistry.removeAppOpPermissionPackage(permissionName, pkg.getPackageName());     // Catch: Throwable -> L9
        goto L28
    L35:
        if (0 == 0) goto L37;
        Log.d(TAG, "  Permissions: null");     // Catch: Throwable -> L9
    L37:
        monitor-exit(r0);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L9:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onUserRemoved(int userId) {
        Preconditions.checkArgumentNonNegative(userId, "userId");
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        this.mState.removeUserState(userId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private Set<String> getGrantedPermissionsInternal(String packageName, final int userId) {
        final PackageStateInternal ps = this.mPackageManagerInt.getPackageStateInternal(packageName);
        if (ps == null) goto L5;
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        UidPermissionState uidState = getUidStateLocked(ps, userId);     // Catch: Throwable -> L14
        if (uidState != null) goto L17;
        Slog.e(TAG, "Missing permissions state for " + packageName + " and user " + userId);     // Catch: Throwable -> L14
        Set<String> r3 = Collections.emptySet();     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r3;
    L17:
        if (ps.getUserStateOrDefault(userId).isInstantApp() == true) goto L22;
        Set<String> r4 = uidState.getGrantedPermissions();     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r4;
    L22:
        Set<String> instantPermissions = new ArraySet(uidState.getGrantedPermissions());     // Catch: Throwable -> L14
        instantPermissions.removeIf(new PermissionManagerServiceImpl$$ExternalSyntheticLambda2(this, userId, ps));     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return instantPermissions;
    L14:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L5:
        return Collections.emptySet();
    }

    private /* synthetic */ boolean lambda$getGrantedPermissionsInternal$8(int userId, PackageStateInternal ps, String permissionName) {
        Permission permission = this.mRegistry.getPermission(permissionName);
        if (permission != null) goto L6;
        return true;
    L6:
        if (permission.isInstant() == true) goto L9;
        EventLog.writeEvent(1397638484, new Object[]{"140256621", Integer.valueOf(UserHandle.getUid(userId, ps.getAppId())), permissionName});
        return true;
    L9:
        return false;
    }

    private int[] getPermissionGidsInternal(String permissionName, int userId) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        Permission permission = this.mRegistry.getPermission(permissionName);     // Catch: Throwable -> L10
        if (permission != null) goto L12;
        int[] r2 = EmptyArray.INT;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r2;
    L12:
        int[] r3 = permission.computeGids(userId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r3;
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void restorePermissionState(AndroidPackage pkg, boolean replace, String changingPackageName, PermissionCallback callback, int filterUserId) {
        PermissionManagerServiceImpl r1 = this;
        AndroidPackage r8 = pkg;
        PackageStateInternal ps = r1.mPackageManagerInt.getPackageStateInternal(r8.getPackageName());
        if (ps != null) goto L6;
        return;
    L6:
        if (filterUserId != (-1)) goto L8;
        int[] r0 = r1.getAllUserIds();
    L9:
        int[] userIds = r0;
        boolean installPermissionsChanged = false;
        boolean runtimePermissionsRevoked = false;
        int[] r5 = EMPTY_INT_ARRAY;
        ArraySet<String> shouldGrantPrivilegedPermissionIfWasGranted = new ArraySet();
        Set<String> requestedPermissions = r8.getRequestedPermissions();
        Iterator r18 = r8.getRequestedPermissions().iterator();
        ArraySet<String> shouldGrantInternalPermission = null;
        ArraySet<String> shouldGrantSignaturePermission = null;
        ArraySet<String> isPrivilegedPermissionAllowlisted = null;
    L11:
        if (r18.hasNext() == false) goto L53;
        String permissionName = (String) r18.next();
        installPermissionsChanged = installPermissionsChanged;
        PackageManagerTracedLock r3 = r1.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r3);
        Permission permission = r1.mRegistry.getPermission(permissionName);     // Catch: Throwable -> L46
        monitor-exit(r3);     // Catch: Throwable -> L46
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (permission == null) goto L11;
        if (permission.isPrivileged() == false) goto L27;
        if (r1.checkPrivilegedPermissionAllowlist(r8, ps, permission) == false) goto L27;
        if (isPrivilegedPermissionAllowlisted != null) goto L25;
        isPrivilegedPermissionAllowlisted = new ArraySet();
    L25:
        isPrivilegedPermissionAllowlisted.add(permissionName);
    L27:
        if (permission.isSignature() == true) goto L29;
        ArraySet<String> shouldGrantPrivilegedPermissionIfWasGranted2 = shouldGrantPrivilegedPermissionIfWasGranted;
    L39:
        if (permission.isInternal() == true) goto L41;
    L45:
        shouldGrantPrivilegedPermissionIfWasGranted = shouldGrantPrivilegedPermissionIfWasGranted2;
        goto L11
    L41:
        if (r1.shouldGrantPermissionByProtectionFlags(r8, ps, permission, shouldGrantPrivilegedPermissionIfWasGranted2) == false) goto L45;
        if (shouldGrantInternalPermission != null) goto L44;
        shouldGrantInternalPermission = new ArraySet();
    L44:
        shouldGrantInternalPermission.add(permissionName);
        goto L45
    L29:
        if (r1.shouldGrantPermissionBySignature(r8, permission) == true) goto L33;
        shouldGrantPrivilegedPermissionIfWasGranted2 = shouldGrantPrivilegedPermissionIfWasGranted;
        if (r1.shouldGrantPermissionByProtectionFlags(r8, ps, permission, shouldGrantPrivilegedPermissionIfWasGranted2) == false) goto L39;
    L34:
        if (shouldGrantSignaturePermission != null) goto L36;
        shouldGrantSignaturePermission = new ArraySet();
    L36:
        shouldGrantSignaturePermission.add(permissionName);
        goto L39
    L33:
        shouldGrantPrivilegedPermissionIfWasGranted2 = shouldGrantPrivilegedPermissionIfWasGranted;
    L46:
        th = th;
    L470:
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L51:
        th = th;
        goto L470
    L53:
        boolean installPermissionsChanged2 = installPermissionsChanged;
        ArraySet<String> shouldGrantPrivilegedPermissionIfWasGranted3 = shouldGrantPrivilegedPermissionIfWasGranted;
        SparseBooleanArray isPermissionPolicyInitialized = new SparseBooleanArray();
        if (r1.mPermissionPolicyInternal == null) goto L63;
        int r2 = userIds.length;
        int r4 = 0;
    L57:
        if (r4 >= r2) goto L63;
        int r17 = r2;
        int userId = userIds[r4];
        int r19 = r4;
        if (r1.mPermissionPolicyInternal.isInitialized(userId) == false) goto L61;
        isPermissionPolicyInitialized.put(userId, true);
    L61:
        r4 = r19 + 1;
        r2 = r17;
    L63:
        if (ps.hasSharedUser() == true) goto L65;
        Collection<String> uidRequestedPermissions = r8.getRequestedPermissions();
        Collection<String> uidImplicitPermissions = r8.getImplicitPermissions();
        int uidTargetSdkVersion = r8.getTargetSdkVersion();
        Collection<String> uidRequestedPermissions2 = uidRequestedPermissions;
        Collection<String> uidImplicitPermissions2 = uidImplicitPermissions;
    L73:
        PackageManagerTracedLock r13 = r1.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r13);
        int r6 = userIds.length;     // Catch: Throwable -> L431
        int[] userIds2 = userIds;
        int[] userIds3 = r5;
        int r7 = 0;
    L77:
        if (r7 >= r6) goto L416;
        int userId2 = userIds2[r7];     // Catch: Throwable -> L414
        int r22 = r7;
        int r25 = r6;
        UserPermissionState userState = r1.mState.getOrCreateUserState(userId2);     // Catch: Throwable -> L414
        Collection<String> uidImplicitPermissions3 = uidImplicitPermissions2;
        UidPermissionState uidState = userState.getOrCreateUidState(ps.getAppId());     // Catch: Throwable -> L412
        if (uidState.isMissing() == true) goto L476;
        ArraySet<String> shouldGrantInternalPermission2 = shouldGrantInternalPermission;
        int[] updatedUserIds = userIds3;
    L114:
        boolean installPermissionsChangedForUser = false;
        if (replace == true) goto L482;
        UidPermissionState origState = uidState;
    L126:
        UidPermissionState origState2 = origState;
    L468:
        ArraySet<String> newImplicitPermissions = new ArraySet();     // Catch: Throwable -> L410
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L410
        int uidTargetSdkVersion2 = uidTargetSdkVersion;
        r9.append(r8.getPackageName());     // Catch: Throwable -> L408
        r9.append("(");     // Catch: Throwable -> L408
        r9.append(r8.getUid());     // Catch: Throwable -> L408
        r9.append(")");     // Catch: Throwable -> L408
        String r10 = r9.toString();     // Catch: Throwable -> L408
        Iterator<String> r11 = requestedPermissions.iterator();     // Catch: Throwable -> L408
        int[] updatedUserIds2 = updatedUserIds;
    L438:
        if (r11.hasNext() == false) goto L370;
        String permName = r11.next();     // Catch: Throwable -> L368
        r11 = r11;
        Permission bp = r1.mRegistry.getPermission(permName);     // Catch: Throwable -> L368
        uidRequestedPermissions2 = uidRequestedPermissions2;
        ArraySet<String> shouldGrantPrivilegedPermissionIfWasGranted4 = shouldGrantPrivilegedPermissionIfWasGranted3;
        if (r8.getTargetSdkVersion() < 23) goto L139;
        boolean appSupportsRuntimePermissions = true;
    L140:
        if (bp == null) goto L141;
    L364:
        th = th;
    L490:
        monitor-exit(r13);     // Catch: Throwable -> L436
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L436:
        th = th;
        goto L490
    L147:
        if (origState2.hasPermissionState(permName) == false) goto L149;
        ArraySet<String> newImplicitPermissions2 = newImplicitPermissions;
    L155:
        if (bp.isRuntimeOnly() == false) goto L158;
        if (appSupportsRuntimePermissions == true) goto L158;
    L157:
        newImplicitPermissions = newImplicitPermissions2;
        shouldGrantPrivilegedPermissionIfWasGranted3 = shouldGrantPrivilegedPermissionIfWasGranted4;
    L158:
        String perm = bp.getName();     // Catch: Throwable -> L364
        if (bp.isAppOp() == false) goto L162;
        String perm2 = perm;
        r1.mRegistry.addAppOpPermissionPackage(perm2, r8.getPackageName());     // Catch: Throwable -> L144
    L163:
        boolean shouldGrantNormalPermission = true;
        if (bp.isNormal() == false) goto L176;
        if (origState2.isPermissionGranted(perm2) == true) goto L176;
        if (ps.isSystem() == true) goto L176;
        if (userState.areInstallPermissionsFixed(ps.getPackageName()) == false) goto L176;
        if (isCompatPlatformPermissionForPackage(perm2, r8) == true) goto L176;
        shouldGrantNormalPermission = false;
    L176:
        if (bp.isNormal() == true) goto L290;
        if (bp.isSignature() == true) goto L290;
        if (bp.isInternal() == true) goto L290;
        if (bp.isRuntime() == false) goto L287;
        boolean hardRestricted = bp.isHardRestricted();     // Catch: Throwable -> L260
        boolean softRestricted = bp.isSoftRestricted();     // Catch: Throwable -> L260
        boolean permissionPolicyInitialized = isPermissionPolicyInitialized.get(userId2);     // Catch: Throwable -> L260
        PermissionState origPermState = origState2.getPermissionState(perm2);     // Catch: Throwable -> L260
        if (origPermState != null) goto L492;
        int r39 = 0;
    L191:
        int flags = r39;
        boolean wasChanged = false;
        if ((origState2.getPermissionFlags(bp.getName()) & 14336) == 0) goto L195;
        boolean restrictionExempt = true;
    L196:
        boolean restrictionExempt2 = restrictionExempt;
        if ((origState2.getPermissionFlags(bp.getName()) & 16384) == 0) goto L200;
        boolean restrictionApplied = true;
    L201:
        if (appSupportsRuntimePermissions == 0) goto L253;
        if (permissionPolicyInitialized == false) goto L215;
        if (hardRestricted == false) goto L215;
        if (restrictionExempt2 == true) goto L214;
        if (origPermState != null) goto L207;
    L211:
        if (restrictionApplied == true) goto L213;
        boolean restrictionApplied2 = restrictionApplied;
        wasChanged = true;
        flags = flags | 16384;     // Catch: Throwable -> L188
    L223:
        if (NOTIFICATION_PERMISSIONS.contains(perm2) == true) goto L228;
        if ((flags & 64) == 0) goto L228;
        flags = flags & (-65);     // Catch: Throwable -> L188
        wasChanged = true;
    L228:
        if ((flags & 8) != 0) goto L230;
    L232:
        if (permissionPolicyInitialized == false) goto L235;
        if (hardRestricted == false) goto L235;
        if (restrictionExempt2 == true) goto L235;
    L242:
        if (r1.mIsLeanback == true) goto L244;
    L252:
        int flags2 = flags;
    L275:
        if (permissionPolicyInitialized == false) goto L284;
        if (hardRestricted == true) goto L278;
        if (softRestricted == true) goto L278;
    L279:
        if (restrictionApplied2 == false) goto L284;
        flags2 = flags2 & (-16385);     // Catch: Throwable -> L260
        if (appSupportsRuntimePermissions == true) goto L283;
        flags2 = flags2 | 64;     // Catch: Throwable -> L260
    L283:
        wasChanged = true;
    L278:
        if (restrictionExempt2 == true) goto L279;
    L284:
        if (wasChanged == false) goto L286;
        updatedUserIds2 = ArrayUtils.appendInt(updatedUserIds2, userId2);     // Catch: Throwable -> L260
    L286:
        uidState.updatePermissionFlags(bp, 261119, flags2);     // Catch: Throwable -> L260
        ArraySet<String> shouldGrantInternalPermission3 = shouldGrantInternalPermission2;
        ArraySet<String> shouldGrantPrivilegedPermissionIfWasGranted5 = shouldGrantPrivilegedPermissionIfWasGranted4;
    L363:
        r1 = this;
        changingPackageName = changingPackageName;
        shouldGrantPrivilegedPermissionIfWasGranted3 = shouldGrantPrivilegedPermissionIfWasGranted5;
        origState2 = origState2;
        newImplicitPermissions = newImplicitPermissions2;
        r8 = pkg;
        shouldGrantInternalPermission2 = shouldGrantInternalPermission3;
        goto L438
    L244:
        if (NOTIFICATION_PERMISSIONS.contains(permName) == false) goto L252;
        uidState.grantPermission(bp);     // Catch: Throwable -> L188
        if (origPermState == null) goto L250;
        if (origPermState.isGranted() == true) goto L252;
    L250:
        if (uidState.grantPermission(bp) == false) goto L252;
        wasChanged = true;
        flags2 = flags;
    L235:
        if (origPermState == null) goto L242;
        if (origPermState.isGranted() == false) goto L242;
        if (uidState.grantPermission(bp) == true) goto L242;
        wasChanged = true;
        goto L242
    L230:
        if (r1.isPermissionSplitFromNonRuntime(permName, pkg.getTargetSdkVersion()) == true) goto L232;
        flags = flags & (-9);     // Catch: Throwable -> L188
        wasChanged = true;
        goto L242
    L213:
        restrictionApplied2 = restrictionApplied;
        goto L223
    L207:
        if (origPermState.isGranted() == false) goto L211;
        if (uidState.revokePermission(bp) == false) goto L211;
        wasChanged = true;
        goto L211
    L214:
        restrictionApplied2 = restrictionApplied;
        int flags3 = flags;
    L221:
        flags = flags3;
    L215:
        restrictionApplied2 = restrictionApplied;
        flags3 = flags;
        if (permissionPolicyInitialized == false) goto L221;
        if (softRestricted == false) goto L221;
        if (restrictionExempt2 == true) goto L221;
        if (restrictionApplied2 == true) goto L221;
        wasChanged = true;
        flags = flags3 | 16384;     // Catch: Throwable -> L188
        goto L223
    L253:
        restrictionApplied2 = restrictionApplied;
        if (origPermState != null) goto L262;
        int flags4 = flags;
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(bp.getPackageName()) == true) goto L258;
    L263:
        flags2 = flags4;
    L265:
        if (uidState.isPermissionGranted(bp.getName()) == false) goto L267;
    L269:
        if (permissionPolicyInitialized == false) goto L275;
        if (hardRestricted == true) goto L272;
        if (softRestricted == false) goto L275;
    L272:
        if (restrictionExempt2 == true) goto L275;
        if (restrictionApplied2 == true) goto L275;
        flags2 = flags2 | 16384;     // Catch: Throwable -> L260
        wasChanged = true;
        goto L275
    L267:
        if (uidState.grantPermission(bp) == false) goto L269;
        wasChanged = true;
        goto L269
    L258:
        if (bp.isRemoved() == true) goto L263;
        wasChanged = true;
        flags2 = flags4 | 72;     // Catch: Throwable -> L260
        goto L265
    L262:
        flags4 = flags;
        goto L263
    L200:
        restrictionApplied = false;
        goto L201
    L195:
        restrictionExempt = false;
        goto L196
    L492:
        r39 = origPermState.getFlags();     // Catch: Throwable -> L188
    L188:
        th = th;
        goto L490
    L287:
        Slog.wtf(LOG_TAG, "Unknown permission protection " + bp.getProtection() + " for permission " + bp.getName());     // Catch: Throwable -> L260
        shouldGrantInternalPermission3 = shouldGrantInternalPermission2;
        shouldGrantPrivilegedPermissionIfWasGranted5 = shouldGrantPrivilegedPermissionIfWasGranted4;
    L260:
        th = th;
    L290:
        if (bp.isNormal() == false) goto L294;
        if (shouldGrantNormalPermission == false) goto L294;
        shouldGrantInternalPermission3 = shouldGrantInternalPermission2;
        shouldGrantPrivilegedPermissionIfWasGranted5 = shouldGrantPrivilegedPermissionIfWasGranted4;
    L484:
        if (uidState.grantPermission(bp) == false) goto L358;
        installPermissionsChangedForUser = true;
    L358:
        PermissionState origPermState2 = origState2.getPermissionState(perm2);     // Catch: Throwable -> L341
        if (origPermState2 == null) goto L361;
        int flags5 = origPermState2.getFlags();     // Catch: Throwable -> L341
    L362:
        uidState.updatePermissionFlags(bp, 261119, flags5);     // Catch: Throwable -> L341
        goto L363
    L361:
        flags5 = 0;
    L341:
        th = th;
    L294:
        if (bp.isSignature() == true) goto L480;
        shouldGrantPrivilegedPermissionIfWasGranted5 = shouldGrantPrivilegedPermissionIfWasGranted4;
    L466:
    L352:
        th = th;
        goto L490
    L326:
        if (bp.isInternal() == false) goto L354;
        if (bp.isPrivileged() == true) goto L444;
    L333:
        shouldGrantInternalPermission3 = shouldGrantInternalPermission2;
        if (CollectionUtils.contains(shouldGrantInternalPermission3, permName) == true) goto L484;
        if (bp.isPrivileged() == false) goto L344;
        if (CollectionUtils.contains(shouldGrantPrivilegedPermissionIfWasGranted5, permName) == false) goto L344;
    L348:
        if (origState2.isPermissionGranted(permName) == true) goto L484;
    L356:
        if (uidState.revokePermission(bp) == false) goto L358;
        installPermissionsChangedForUser = true;
    L344:
        if (bp.isDevelopment() == true) goto L348;
        if (bp.isRole() == false) goto L356;
    L444:
        if (CollectionUtils.contains(isPrivilegedPermissionAllowlisted, permName) == true) goto L333;
        shouldGrantInternalPermission3 = shouldGrantInternalPermission2;
    L310:
        th = th;
        goto L490
    L354:
        shouldGrantInternalPermission3 = shouldGrantInternalPermission2;
        goto L356
    L480:
    L321:
        th = th;
        goto L490
    L297:
        if (bp.isPrivileged() == false) goto L303;
        if (CollectionUtils.contains(isPrivilegedPermissionAllowlisted, permName) == true) goto L303;
        shouldGrantPrivilegedPermissionIfWasGranted5 = shouldGrantPrivilegedPermissionIfWasGranted4;
    L303:
        if (CollectionUtils.contains(shouldGrantSignaturePermission, permName) == true) goto L323;
        if (bp.isPrivileged() == false) goto L312;
        shouldGrantPrivilegedPermissionIfWasGranted5 = shouldGrantPrivilegedPermissionIfWasGranted4;
        if (CollectionUtils.contains(shouldGrantPrivilegedPermissionIfWasGranted5, permName) == true) goto L318;
    L314:
        if (bp.isDevelopment() == true) goto L318;
        if (bp.isRole() == false) goto L466;
    L318:
        if (origState2.isPermissionGranted(permName) == false) goto L466;
        shouldGrantInternalPermission3 = shouldGrantInternalPermission2;
        goto L484
    L312:
        shouldGrantPrivilegedPermissionIfWasGranted5 = shouldGrantPrivilegedPermissionIfWasGranted4;
        goto L314
    L323:
        shouldGrantPrivilegedPermissionIfWasGranted5 = shouldGrantPrivilegedPermissionIfWasGranted4;
        shouldGrantInternalPermission3 = shouldGrantInternalPermission2;
        goto L484
    L162:
        perm2 = perm;
        goto L163
    L149:
        if (r8.getImplicitPermissions().contains(permName) == false) goto L152;
        newImplicitPermissions2 = newImplicitPermissions;
        newImplicitPermissions2.add(permName);     // Catch: Throwable -> L144
        goto L155
    L152:
        newImplicitPermissions2 = newImplicitPermissions;
        goto L155
    L141:
        if (changingPackageName != null) goto L446;
    L143:
        newImplicitPermissions2 = newImplicitPermissions;
        goto L157
    L446:
        changingPackageName.equals(r8.getPackageName());     // Catch: Throwable -> L144
    L144:
        th = th;
        goto L490
    L139:
        appSupportsRuntimePermissions = false;
    L366:
        th = th;
    L368:
        th = th;
        goto L490
    L370:
        Collection<String> uidRequestedPermissions3 = uidRequestedPermissions2;
        ArraySet<String> shouldGrantPrivilegedPermissionIfWasGranted6 = shouldGrantPrivilegedPermissionIfWasGranted3;
        ArraySet<String> newImplicitPermissions3 = newImplicitPermissions;
        ArraySet<String> shouldGrantInternalPermission4 = shouldGrantInternalPermission2;
        UidPermissionState origState3 = origState2;
        if (installPermissionsChangedForUser == true) goto L374;
        if (replace == true) goto L374;
    L474:
        if (ps.isUpdatedSystemApp() == false) goto L382;
    L379:
        r27.setInstallPermissionsFixed(ps.getPackageName(), true);     // Catch: Throwable -> L341
    L382:
        if (installPermissionsChangedForUser == true) goto L384;
    L391:
        ArraySet<String> isPrivilegedPermissionAllowlisted2 = isPrivilegedPermissionAllowlisted;
        ArraySet<String> shouldGrantSignaturePermission2 = shouldGrantSignaturePermission;
        int[] userIds4 = userIds2;
        r1 = this;
        userIds3 = r1.setInitialGrantForNewImplicitPermissionsLocked(origState3, uidState, pkg, newImplicitPermissions3, userId2, revokePermissionsNoLongerImplicitLocked(uidState, pkg.getPackageName(), uidImplicitPermissions3, uidTargetSdkVersion2, userId2, updatedUserIds2));     // Catch: Throwable -> L398
        r7 = r22 + 1;
        shouldGrantInternalPermission = shouldGrantInternalPermission4;
        isPrivilegedPermissionAllowlisted = isPrivilegedPermissionAllowlisted2;
        shouldGrantSignaturePermission = shouldGrantSignaturePermission2;
        r6 = r25;
        uidTargetSdkVersion = uidTargetSdkVersion2;
        uidRequestedPermissions2 = uidRequestedPermissions3;
        userIds2 = userIds4;
        shouldGrantPrivilegedPermissionIfWasGranted3 = shouldGrantPrivilegedPermissionIfWasGranted6;
        r8 = pkg;
        uidImplicitPermissions2 = uidImplicitPermissions3;
    L398:
        th = th;
    L400:
        th = th;
    L402:
        th = th;
        goto L490
    L384:
        if (changingPackageName == null) goto L390;
        if (replace == false) goto L390;
        updatedUserIds2 = ArrayUtils.appendInt(updatedUserIds2, userId2);     // Catch: Throwable -> L388
        installPermissionsChanged2 = true;
    L388:
        th = th;
    L390:
        installPermissionsChanged2 = true;
    L404:
        th = th;
    L374:
        if (r27.areInstallPermissionsFixed(ps.getPackageName()) == true) goto L474;
        if (ps.isSystem() == false) goto L379;
    L406:
        th = th;
    L408:
        th = th;
    L410:
        th = th;
        goto L490
    L482:
        origState = uidState;
        r27.setInstallPermissionsFixed(ps.getPackageName(), false);     // Catch: Throwable -> L119
        if (ps.hasSharedUser() == true) goto L122;
        origState2 = new UidPermissionState(uidState);     // Catch: Throwable -> L119
        uidState.reset();     // Catch: Throwable -> L119
        goto L468
    L122:
        if (r1.revokeUnusedSharedUserPermissionsLocked(uidRequestedPermissions2, uidState) == false) goto L126;
        runtimePermissionsRevoked = true;
        updatedUserIds = ArrayUtils.appendInt(updatedUserIds, userId2);     // Catch: Throwable -> L119
        origState2 = origState;
    L119:
        th = th;
        goto L490
    L476:
        Iterator<String> r26 = uidRequestedPermissions2.iterator();     // Catch: Throwable -> L109
    L85:
        if (r26.hasNext() == false) goto L111;
        String permissionName2 = r26.next();     // Catch: Throwable -> L109
        Permission permission2 = r1.mRegistry.getPermission(permissionName2);     // Catch: Throwable -> L109
        if (permission2 == null) goto L85;
        String permissionName3 = permission2.getPackageName();     // Catch: Throwable -> L109
        ArraySet<String> shouldGrantInternalPermission5 = shouldGrantInternalPermission;
        if (Objects.equals(permissionName3, PackageManagerService.PLATFORM_PACKAGE_NAME) == true) goto L94;
    L108:
        shouldGrantInternalPermission = shouldGrantInternalPermission5;
        goto L85
    L94:
        if (permission2.isRuntime() == false) goto L108;
        if (permission2.isRemoved() == true) goto L108;
        if (permission2.isHardOrSoftRestricted() == false) goto L100;
    L104:
        uidState.updatePermissionFlags(permission2, 8192, 8192);     // Catch: Throwable -> L102
    L106:
        if (uidTargetSdkVersion >= 23) goto L108;
        uidState.updatePermissionFlags(permission2, 72, 72);     // Catch: Throwable -> L102
        uidState.grantPermission(permission2);     // Catch: Throwable -> L102
        goto L108
    L100:
        if (permission2.isImmutablyRestricted() == false) goto L106;
    L102:
        th = th;
        goto L490
    L111:
        shouldGrantInternalPermission2 = shouldGrantInternalPermission;
        uidState.setMissing(false);     // Catch: Throwable -> L102
        updatedUserIds = ArrayUtils.appendInt(userIds3, userId2);     // Catch: Throwable -> L102
    L109:
        th = th;
    L412:
        th = th;
    L414:
        th = th;
        goto L490
    L416:
        AndroidPackage r12 = r8;
        int[] userIds5 = userIds2;
        boolean r14 = true;
        monitor-exit(r13);     // Catch: Throwable -> L429
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        int[] updatedUserIds3 = r1.checkIfLegacyStorageOpsNeedToBeUpdated(r12, replace, userIds5, userIds3);
        if (callback == null) goto L428;
        if (changingPackageName == null) goto L423;
        if (replace == false) goto L423;
        if (installPermissionsChanged2 == false) goto L423;
    L426:
        callback.onPermissionUpdated(updatedUserIds3, r14, r12.getUid());
        return;
    L423:
        if (runtimePermissionsRevoked == true) goto L426;
        r14 = false;
        goto L426
    L428:
        return;
    L429:
        th = th;
    L431:
        th = th;
        goto L490
    L65:
        Collection<String> uidRequestedPermissions4 = new ArraySet();
        Collection<String> uidImplicitPermissions4 = new ArraySet();
        ArraySet<PackageStateInternal> packages = r1.mPackageManagerInt.getSharedUserPackages(ps.getSharedUserAppId());
        int packagesSize = packages.size();
        int uidTargetSdkVersion3 = 10000;
        int i = 0;
    L66:
        if (i >= packagesSize) goto L72;
        AndroidPackage sharedUserPackage = packages.valueAt(i).getAndroidPackage();
        if (sharedUserPackage == null) goto L71;
        uidRequestedPermissions4.addAll(sharedUserPackage.getRequestedPermissions());
        uidImplicitPermissions4.addAll(sharedUserPackage.getImplicitPermissions());
        uidTargetSdkVersion3 = Math.min(uidTargetSdkVersion3, sharedUserPackage.getTargetSdkVersion());
    L71:
        i = i + 1;
        packages = packages;
        goto L66
    L72:
        uidTargetSdkVersion = uidTargetSdkVersion3;
        uidRequestedPermissions2 = uidRequestedPermissions4;
        uidImplicitPermissions2 = uidImplicitPermissions4;
        goto L73
    L8:
        r0 = new int[]{filterUserId};
        goto L9
    }

    private int[] getAllUserIds() {
        return UserManagerService.getInstance().getUserIdsIncludingPreCreated();
    }

    private int[] revokePermissionsNoLongerImplicitLocked(UidPermissionState ps, String packageName, Collection<String> uidImplicitPermissions, int uidTargetSdkVersion, int userId, int[] updatedUserIds) {
        if (uidTargetSdkVersion < 23) goto L5;
        boolean supportsRuntimePermissions = true;
    L6:
        Iterator<String> r3 = ps.getGrantedPermissions().iterator();
        int[] updatedUserIds2 = updatedUserIds;
    L8:
        if (r3.hasNext() == false) goto L35;
        String permission = r3.next();
        if (uidImplicitPermissions.contains(permission) == true) goto L8;
        Permission bp = this.mRegistry.getPermission(permission);
        if (bp == null) goto L8;
        if (bp.isRuntime() == false) goto L8;
        int flags = ps.getPermissionFlags(permission);
        if ((flags & 128) == 0) goto L8;
        int flagsToRemove = 128;
        boolean preserveGrant = false;
        if (ArrayUtils.contains(NEARBY_DEVICES_PERMISSIONS, permission) == false) goto L25;
        if (ps.isPermissionGranted("android.permission.ACCESS_BACKGROUND_LOCATION") == false) goto L25;
        if ((ps.getPermissionFlags("android.permission.ACCESS_BACKGROUND_LOCATION") & 136) != 0) goto L25;
        preserveGrant = true;
    L25:
        if ((flags & 52) != 0) goto L29;
        if (supportsRuntimePermissions == false) goto L29;
        if (preserveGrant == true) goto L29;
        ps.revokePermission(bp);
        flagsToRemove = 128 | 3;
    L29:
        ps.updatePermissionFlags(bp, flagsToRemove, 0);
        updatedUserIds2 = ArrayUtils.appendInt(updatedUserIds2, userId);
        goto L8
    L35:
        return updatedUserIds2;
    L5:
        supportsRuntimePermissions = false;
        goto L6
    }

    private void inheritPermissionStateToNewImplicitPermissionLocked(ArraySet<String> sourcePerms, String newPerm, UidPermissionState ps, AndroidPackage pkg) {
        pkg.getPackageName();
        boolean isGranted = false;
        int flags = 0;
        int numSourcePerm = sourcePerms.size();
        int i = 0;
    L3:
        if (i >= numSourcePerm) goto L13;
        String sourcePerm = sourcePerms.valueAt(i);
        if (ps.isPermissionGranted(sourcePerm) == false) goto L9;
        if (isGranted == true) goto L8;
        flags = 0;
    L8:
        isGranted = true;
        flags = flags | ps.getPermissionFlags(sourcePerm);
    L11:
        i = i + 1;
        goto L3
    L9:
        if (isGranted == true) goto L11;
        flags = flags | ps.getPermissionFlags(sourcePerm);
        goto L11
    L13:
        if (isGranted == false) goto L15;
        ps.grantPermission(this.mRegistry.getPermission(newPerm));
    L15:
        ps.updatePermissionFlags(this.mRegistry.getPermission(newPerm), flags, flags);
    }

    private int[] checkIfLegacyStorageOpsNeedToBeUpdated(AndroidPackage pkg, boolean replace, int[] userIds, int[] updatedUserIds) {
        if (replace == true) goto L4;
    L11:
        return updatedUserIds;
    L4:
        if (pkg.isRequestLegacyExternalStorage() == false) goto L11;
        if (pkg.getRequestedPermissions().contains("android.permission.READ_EXTERNAL_STORAGE") == true) goto L10;
        if (pkg.getRequestedPermissions().contains("android.permission.WRITE_EXTERNAL_STORAGE") == false) goto L11;
    L10:
        return (int[]) userIds.clone();
    }

    private int[] setInitialGrantForNewImplicitPermissionsLocked(UidPermissionState origPs, UidPermissionState ps, AndroidPackage pkg, ArraySet<String> newImplicitPermissions, int userId, int[] updatedUserIds) {
        String pkgName = pkg.getPackageName();
        ArrayMap<String, ArraySet<String>> newToSplitPerms = new ArrayMap();
        List<PermissionManager.SplitPermissionInfo> permissionList = getSplitPermissionInfos();
        int numSplitPerms = permissionList.size();
        int splitPermNum = 0;
    L3:
        if (splitPermNum >= numSplitPerms) goto L11;
        PermissionManager.SplitPermissionInfo spi = permissionList.get(splitPermNum);
        List<String> newPerms = spi.getNewPermissions();
        int numNewPerms = newPerms.size();
        int newPermNum = 0;
    L5:
        if (newPermNum >= numNewPerms) goto L10;
        String newPerm = newPerms.get(newPermNum);
        ArraySet<String> splitPerms = newToSplitPerms.get(newPerm);
        if (splitPerms != null) goto L9;
        splitPerms = new ArraySet();
        newToSplitPerms.put(newPerm, splitPerms);
    L9:
        splitPerms.add(spi.getSplitPermission());
        newPermNum = newPermNum + 1;
        goto L5
    L10:
        splitPermNum = splitPermNum + 1;
        goto L3
    L11:
        int numNewImplicitPerms = newImplicitPermissions.size();
        int newImplicitPermNum = 0;
        int[] updatedUserIds2 = updatedUserIds;
    L12:
        if (newImplicitPermNum >= numNewImplicitPerms) goto L50;
        String newPerm2 = newImplicitPermissions.valueAt(newImplicitPermNum);
        ArraySet<String> sourcePerms = newToSplitPerms.get(newPerm2);
        if (sourcePerms == null) goto L47;
        Permission bp = this.mRegistry.getPermission(newPerm2);
        if (bp == null) goto L46;
        if (bp.isRuntime() == true) goto L20;
        String pkgName2 = pkgName;
        ArrayMap<String, ArraySet<String>> newToSplitPerms2 = newToSplitPerms;
        permissionList = permissionList;
        numSplitPerms = numSplitPerms;
    L48:
        newImplicitPermNum = newImplicitPermNum + 1;
        newToSplitPerms = newToSplitPerms2;
        pkgName = pkgName2;
        permissionList = permissionList;
        numSplitPerms = numSplitPerms;
        goto L12
    L20:
        if (newPerm2.equals("android.permission.ACTIVITY_RECOGNITION") == false) goto L22;
    L26:
        updatedUserIds2 = ArrayUtils.appendInt(updatedUserIds2, userId);
        if (origPs.hasPermissionState(sourcePerms) == true) goto L42;
        boolean inheritsFromInstallPerm = false;
        pkgName2 = pkgName;
        int sourcePermNum = 0;
    L29:
        newToSplitPerms2 = newToSplitPerms;
        if (sourcePermNum >= sourcePerms.size()) goto L40;
        String sourcePerm = sourcePerms.valueAt(sourcePermNum);
        int sourcePermNum2 = sourcePermNum;
        Permission sourceBp = this.mRegistry.getPermission(sourcePerm);
        if (sourceBp == null) goto L38;
        if (sourceBp.isRuntime() == false) goto L35;
        sourcePermNum = sourcePermNum2 + 1;
        newToSplitPerms = newToSplitPerms2;
        goto L29
    L35:
        inheritsFromInstallPerm = true;
        goto L40
    L38:
        throw new IllegalStateException("Unknown source permission in split permission: " + sourcePerm);
    L40:
        if (inheritsFromInstallPerm == false) goto L48;
    L43:
        inheritPermissionStateToNewImplicitPermissionLocked(sourcePerms, newPerm2, ps, pkg);
        goto L48
    L42:
        pkgName2 = pkgName;
        newToSplitPerms2 = newToSplitPerms;
        permissionList = permissionList;
        numSplitPerms = numSplitPerms;
        goto L43
    L22:
        if (READ_MEDIA_AURAL_PERMISSIONS.contains(newPerm2) == true) goto L26;
        if (READ_MEDIA_VISUAL_PERMISSIONS.contains(newPerm2) == true) goto L26;
        ps.updatePermissionFlags(bp, 128, 128);
        goto L26
    L46:
        throw new IllegalStateException("Unknown new permission in split permission: " + newPerm2);
    L47:
        pkgName2 = pkgName;
        newToSplitPerms2 = newToSplitPerms;
        permissionList = permissionList;
        numSplitPerms = numSplitPerms;
        goto L48
    L50:
        return updatedUserIds2;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<SplitPermissionInfoParcelable> getSplitPermissions() {
        return PermissionManager.splitPermissionInfoListToParcelableList(getSplitPermissionInfos());
    }

    private List<PermissionManager.SplitPermissionInfo> getSplitPermissionInfos() {
        return SystemConfig.getInstance().getSplitPermissions();
    }

    private static boolean isCompatPlatformPermissionForPackage(String perm, AndroidPackage pkg) {
        int i = 0;
        int size = CompatibilityPermissionInfo.COMPAT_PERMS.length;
    L3:
        if (i >= size) goto L15;
        CompatibilityPermissionInfo info = CompatibilityPermissionInfo.COMPAT_PERMS[i];
        if (info.getName().equals(perm) == false) goto L9;
        if (pkg.getTargetSdkVersion() >= info.getSdkVersion()) goto L9;
        Log.i(TAG, "Auto-granting " + perm + " to old pkg " + pkg.getPackageName());
        return true;
    L9:
        i = i + 1;
        goto L3
    L15:
        return false;
    }

    private boolean checkPrivilegedPermissionAllowlist(AndroidPackage pkg, PackageStateInternal packageSetting, Permission permission) {
        if (RoSystemProperties.CONTROL_PRIVAPP_PERMISSIONS_DISABLE == false) goto L5;
        return true;
    L5:
        String packageName = pkg.getPackageName();
        if (Objects.equals(packageName, PackageManagerService.PLATFORM_PACKAGE_NAME) == false) goto L9;
        return true;
    L9:
        if (packageSetting.isSystem() == true) goto L11;
    L44:
        return true;
    L11:
        if (packageSetting.isPrivileged() == false) goto L44;
        if (this.mPrivilegedPermissionAllowlistSourcePackageNames.contains(permission.getPackageName()) == true) goto L16;
        return true;
    L16:
        String permissionName = permission.getName();
        String containingApexPackageName = this.mApexManager.getActiveApexPackageNameContainingPackage(packageName);
        Boolean allowlistState = getPrivilegedPermissionAllowlistState(packageSetting, permissionName, containingApexPackageName);
        if (allowlistState == null) goto L21;
        return allowlistState.booleanValue();
    L21:
        if (packageSetting.isUpdatedSystemApp() == false) goto L24;
        return true;
    L24:
        if (this.mSystemReady == true) goto L42;
        boolean isInUpdatedApex = packageSetting.isApkInUpdatedApex();
        if (isInUpdatedApex == true) goto L42;
        Slog.w(TAG, "Privileged permission " + permissionName + " for package " + packageName + " (" + pkg.getPath() + ") not in privapp-permissions allowlist");
        if (RoSystemProperties.CONTROL_PRIVAPP_PERMISSIONS_ENFORCE == false) goto L42;
        PackageManagerTracedLock r6 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r6);
    L34:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L32:
        if (this.mPrivappPermissionsViolations != null) goto L36;
        this.mPrivappPermissionsViolations = new ArraySet();     // Catch: Throwable -> L34
    L36:
        this.mPrivappPermissionsViolations.add(packageName + " (" + pkg.getPath() + "): " + permissionName);     // Catch: Throwable -> L34
        monitor-exit(r6);     // Catch: Throwable -> L34
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L42:
        boolean isInUpdatedApex2 = RoSystemProperties.CONTROL_PRIVAPP_PERMISSIONS_ENFORCE;
        return true ^ isInUpdatedApex2;
    }

    private Boolean getPrivilegedPermissionAllowlistState(PackageState packageState, String permissionName, String containingApexPackageName) {
        PermissionAllowlist permissionAllowlist = SystemConfig.getInstance().getPermissionAllowlist();
        String packageName = packageState.getPackageName();
        if (packageState.isVendor() == true) goto L26;
        if (packageState.isOdm() == true) goto L26;
        if (packageState.isProduct() == false) goto L12;
        return permissionAllowlist.getProductPrivilegedAppAllowlistState(packageName, permissionName);
    L12:
        if (packageState.isSystemExt() == true) goto L14;
        if (containingApexPackageName == null) goto L24;
        Boolean nonApexAllowlistState = permissionAllowlist.getPrivilegedAppAllowlistState(packageName, permissionName);
        if (nonApexAllowlistState == null) goto L19;
        Slog.w(TAG, "Package " + packageName + " is an APK in APEX, but has permission allowlist on the system image. Please bundle the allowlist in the " + containingApexPackageName + " APEX instead.");
    L19:
        String moduleName = this.mApexManager.getApexModuleNameForPackageName(containingApexPackageName);
        Boolean apexAllowlistState = permissionAllowlist.getApexPrivilegedAppAllowlistState(moduleName, packageName, permissionName);
        if (apexAllowlistState == null) goto L22;
        return apexAllowlistState;
    L22:
        return nonApexAllowlistState;
    L24:
        return permissionAllowlist.getPrivilegedAppAllowlistState(packageName, permissionName);
    L14:
        return permissionAllowlist.getSystemExtPrivilegedAppAllowlistState(packageName, permissionName);
    L26:
        return permissionAllowlist.getVendorPrivilegedAppAllowlistState(packageName, permissionName);
    }

    private boolean shouldGrantPermissionBySignature(AndroidPackage pkg, Permission bp) {
        String systemPackageName = (String) ArrayUtils.firstOrNull(this.mPackageManagerInt.getKnownPackageNames(0, 0));
        AndroidPackage systemPackage = this.mPackageManagerInt.getPackage(systemPackageName);
        SigningDetails sourceSigningDetails = getSourcePackageSigningDetails(bp);
        if (sourceSigningDetails.hasCommonSignerWithCapability(pkg.getSigningDetails(), 4) == false) goto L5;
    L8:
        return true;
    L5:
        if (pkg.getSigningDetails().hasAncestorOrSelf(systemPackage.getSigningDetails()) == true) goto L8;
        if (systemPackage.getSigningDetails().checkCapability(pkg.getSigningDetails(), 4) == true) goto L8;
        return false;
    }

    private boolean shouldGrantPermissionByProtectionFlags(AndroidPackage pkg, PackageStateInternal pkgSetting, Permission bp, ArraySet<String> shouldGrantPrivilegedPermissionIfWasGranted) {
        boolean allowed = false;
        boolean isPrivilegedPermission = bp.isPrivileged();
        boolean isOemPermission = bp.isOem();
        if (0 != 0) goto L45;
        if (isPrivilegedPermission == true) goto L7;
        if (isOemPermission == false) goto L45;
    L7:
        if (pkgSetting.isSystem() == false) goto L45;
        String permissionName = bp.getName();
        if (pkgSetting.isUpdatedSystemApp() == false) goto L27;
        PackageStateInternal disabledPs = this.mPackageManagerInt.getDisabledSystemPackage(pkg.getPackageName());
        if (disabledPs != null) goto L13;
        AndroidPackage disabledPkg = null;
    L15:
        if (disabledPkg == null) goto L36;
        if (isPrivilegedPermission == true) goto L18;
    L19:
        if (isOemPermission == false) goto L36;
        if (canGrantOemPermission(disabledPs, permissionName) == false) goto L36;
    L23:
        if (disabledPkg.getRequestedPermissions().contains(permissionName) == false) goto L25;
        allowed = true;
        goto L36
    L25:
        shouldGrantPrivilegedPermissionIfWasGranted.add(permissionName);
        goto L36
    L18:
        if (disabledPs.isPrivileged() == true) goto L23;
    L36:
        if (allowed == false) goto L45;
        if (isPrivilegedPermission == false) goto L45;
        if (bp.isVendorPrivileged() == true) goto L45;
        if (pkgSetting.isVendor() == false) goto L43;
    L44:
        Slog.w(TAG, "Permission " + permissionName + " cannot be granted to privileged vendor apk " + pkg.getPackageName() + " because it isn't a 'vendorPrivileged' permission.");
        allowed = false;
        goto L45
    L43:
        if (pkgSetting.isOdm() == false) goto L45;
    L13:
        disabledPkg = disabledPs.getPkg();
        goto L15
    L27:
        if (isPrivilegedPermission == true) goto L29;
    L30:
        if (isOemPermission == true) goto L32;
    L34:
        boolean r6 = false;
    L35:
        allowed = r6;
        goto L36
    L32:
        if (canGrantOemPermission(pkgSetting, permissionName) == false) goto L34;
    L33:
        r6 = true;
        goto L35
    L29:
        if (pkgSetting.isPrivileged() == true) goto L33;
    L45:
        if (allowed == false) goto L47;
    L51:
        if (allowed == false) goto L53;
    L59:
        if (allowed == false) goto L61;
    L65:
        if (allowed == false) goto L67;
    L71:
        if (allowed == false) goto L73;
    L75:
        if (allowed == false) goto L77;
    L81:
        if (allowed == false) goto L83;
    L87:
        if (allowed == false) goto L89;
    L93:
        if (allowed == false) goto L95;
    L99:
        if (allowed == false) goto L101;
    L105:
        if (allowed == false) goto L107;
    L111:
        if (allowed == false) goto L113;
    L119:
        if (allowed == false) goto L121;
    L125:
        if (allowed == false) goto L127;
        return allowed;
    L127:
        if (bp.isModule() == true) goto L129;
        return allowed;
    L129:
        if (this.mApexManager.getActiveApexPackageNameContainingPackage(pkg.getPackageName()) == null) goto L134;
        return true;
    L134:
        return allowed;
    L121:
        if (bp.isRecents() == false) goto L125;
        if (ArrayUtils.contains(this.mPackageManagerInt.getKnownPackageNames(17, 0), pkg.getPackageName()) == false) goto L125;
        allowed = true;
        goto L125
    L113:
        if (bp.isRetailDemo() == false) goto L119;
        if (ArrayUtils.contains(this.mPackageManagerInt.getKnownPackageNames(16, 0), pkg.getPackageName()) == false) goto L119;
        if (isProfileOwner(pkg.getUid()) == false) goto L119;
        allowed = true;
        goto L119
    L107:
        if (bp.isCompanion() == false) goto L111;
        if (ArrayUtils.contains(this.mPackageManagerInt.getKnownPackageNames(15, 0), pkg.getPackageName()) == false) goto L111;
        allowed = true;
        goto L111
    L101:
        if (bp.isAppPredictor() == false) goto L105;
        if (ArrayUtils.contains(this.mPackageManagerInt.getKnownPackageNames(12, 0), pkg.getPackageName()) == false) goto L105;
        allowed = true;
        goto L105
    L95:
        if (bp.isIncidentReportApprover() == false) goto L99;
        if (ArrayUtils.contains(this.mPackageManagerInt.getKnownPackageNames(11, 0), pkg.getPackageName()) == false) goto L99;
        allowed = true;
        goto L99
    L89:
        if (bp.isConfigurator() == false) goto L93;
        if (ArrayUtils.contains(this.mPackageManagerInt.getKnownPackageNames(10, 0), pkg.getPackageName()) == false) goto L93;
        allowed = true;
        goto L93
    L83:
        if (bp.isSystemTextClassifier() == false) goto L87;
        if (ArrayUtils.contains(this.mPackageManagerInt.getKnownPackageNames(6, 0), pkg.getPackageName()) == false) goto L87;
        allowed = true;
        goto L87
    L77:
        if (bp.isSetup() == false) goto L81;
        if (ArrayUtils.contains(this.mPackageManagerInt.getKnownPackageNames(1, 0), pkg.getPackageName()) == false) goto L81;
        allowed = true;
        goto L81
    L73:
        if (bp.isKnownSigner() == false) goto L75;
        allowed = pkg.getSigningDetails().hasAncestorOrSelfWithDigest(bp.getKnownCerts());
        goto L75
    L67:
        if (bp.isPreInstalled() == false) goto L71;
        if (pkgSetting.isSystem() == false) goto L71;
        allowed = true;
        goto L71
    L61:
        if (bp.isVerifier() == false) goto L65;
        if (ArrayUtils.contains(this.mPackageManagerInt.getKnownPackageNames(4, 0), pkg.getPackageName()) == false) goto L65;
        allowed = true;
        goto L65
    L53:
        if (bp.isInstaller() == false) goto L59;
        if (ArrayUtils.contains(this.mPackageManagerInt.getKnownPackageNames(2, 0), pkg.getPackageName()) == false) goto L57;
    L58:
        allowed = true;
        goto L59
    L57:
        if (ArrayUtils.contains(this.mPackageManagerInt.getKnownPackageNames(7, 0), pkg.getPackageName()) == false) goto L59;
    L47:
        if (bp.isPre23() == false) goto L51;
        if (pkg.getTargetSdkVersion() >= 23) goto L51;
        allowed = true;
        goto L51
    }

    private SigningDetails getSourcePackageSigningDetails(Permission bp) {
        PackageStateInternal ps = getSourcePackageSetting(bp);
        if (ps != null) goto L7;
        return SigningDetails.UNKNOWN;
    L7:
        return ps.getSigningDetails();
    }

    private PackageStateInternal getSourcePackageSetting(Permission bp) {
        String sourcePackageName = bp.getPackageName();
        return this.mPackageManagerInt.getPackageStateInternal(sourcePackageName);
    }

    private static boolean canGrantOemPermission(PackageState packageState, String permission) {
        if (packageState.isOem() == true) goto L5;
        return false;
    L5:
        String packageName = packageState.getPackageName();
        Boolean granted = SystemConfig.getInstance().getPermissionAllowlist().getOemAppAllowlistState(packageState.getPackageName(), permission);
        if (granted == null) goto L12;
        if (Boolean.TRUE != granted) goto L13;
        return true;
    L13:
        return false;
    L12:
        throw new IllegalStateException("OEM permission " + permission + " requested by package " + packageName + " must be explicitly declared granted or not");
    }

    private static boolean isProfileOwner(int uid) {
        DevicePolicyManagerInternal dpmInternal = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        if (dpmInternal != null) goto L5;
        return false;
    L5:
        if (dpmInternal.isActiveProfileOwner(uid) == false) goto L7;
    L8:
        return true;
    L7:
        if (dpmInternal.isActiveDeviceOwner(uid) == true) goto L8;
        return false;
    }

    private boolean isPermissionsReviewRequiredInternal(String packageName, int userId) {
        AndroidPackage pkg = this.mPackageManagerInt.getPackage(packageName);
        if (pkg != null) goto L6;
        return false;
    L6:
        if (pkg.getTargetSdkVersion() < 23) goto L8;
        return false;
    L8:
        PackageManagerTracedLock r2 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        UidPermissionState uidState = getUidStateLocked(pkg, userId);     // Catch: Throwable -> L16
        if (uidState != null) goto L18;
        Slog.e(TAG, "Missing permissions state for " + pkg.getPackageName() + " and user " + userId);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return false;
    L18:
        boolean r1 = uidState.isPermissionsReviewRequired();     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L16:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void grantRequestedPermissionsInternal(AndroidPackage pkg, ArrayMap<String, Integer> permissionStates, int userId) {
        int myUid = userId;
        if (pkg.getTargetSdkVersion() < 23) goto L5;
        boolean r0 = true;
    L6:
        boolean supportsRuntimePermissions = r0;
        boolean instantApp = this.mPackageManagerInt.isInstantApp(pkg.getPackageName(), myUid);
        int myUid2 = Process.myUid();
        Iterator r1 = pkg.getRequestedPermissions().iterator();
    L8:
        if (r1.hasNext() == false) goto L65;
        String permission = (String) r1.next();
        Integer permissionState = permissionStates.get(permission);
        if (permissionState == null) goto L8;
        if (permissionState.intValue() == 0) goto L8;
        PackageManagerTracedLock r2 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        Permission bp = this.mRegistry.getPermission(permission);     // Catch: Throwable -> L20
        if (bp == null) goto L18;
        if (bp.isRuntime() == false) goto L25;
    L26:
        if (instantApp == true) goto L28;
    L29:
        if (supportsRuntimePermissions == true) goto L33;
        if (bp.isRuntimeOnly() == false) goto L33;
    L35:
        boolean r7 = false;
    L36:
        boolean shouldGrantRuntimePermission = r7;
        boolean isAppOpPermission = bp.isAppOp();     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        int flags = getPermissionFlagsInternal(pkg.getPackageName(), permission, myUid2, myUid);
        if (shouldGrantRuntimePermission == true) goto L40;
        if (isAppOpPermission == false) goto L8;
        if (PackageInstallerService.INSTALLER_CHANGEABLE_APP_OP_PERMISSIONS.contains(permission) == false) goto L8;
        if ((flags & 1) != 0) goto L8;
        if (permissionState.intValue() != 1) goto L59;
        final int mode = 0;
    L60:
        final int uid = UserHandle.getUid(myUid, pkg.getUid());
        final String appOp = AppOpsManager.permissionToOp(permission);
        this.mHandler.post(new PermissionManagerServiceImpl$$ExternalSyntheticLambda6(this, appOp, uid, mode));
        goto L8
    L59:
        mode = 2;
        goto L60
    L40:
        if (supportsRuntimePermissions == true) goto L42;
        if ((flags & 72) != 0) goto L47;
        myUid = userId;
        goto L8
    L47:
        int myUid3 = myUid2;
        updatePermissionFlagsInternal(pkg.getPackageName(), permission, 72, 0, myUid3, userId, false, this.mDefaultPermissionCallback);
        myUid2 = myUid3;
        myUid = userId;
        goto L8
    L42:
        if ((flags & 20) == 0) goto L43;
        myUid = userId;
        goto L8
    L43:
        grantRuntimePermissionInternal(pkg.getPackageName(), permission, false, myUid2, myUid, this.mDefaultPermissionCallback);
        myUid = userId;
    L33:
        if (permissionState.intValue() != 1) goto L35;
        r7 = true;
        goto L36
    L28:
        if (bp.isInstant() == false) goto L35;
    L25:
        if (bp.isDevelopment() == false) goto L35;
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L20
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L20:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L65:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private /* synthetic */ void lambda$grantRequestedPermissionsInternal$9(String appOp, int uid, int mode) {
        AppOpsManager appOpsManager = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        appOpsManager.setUidMode(appOp, uid, mode);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:? -> B:80:0x013b). Please report as a decompilation issue!!! */
    private void setAllowlistedRestrictedPermissionsInternal(AndroidPackage pkg, List<String> permissions, int allowlistFlags, int userId) {
        int myUid = userId;
        int myUid2 = Process.myUid();
        Iterator r12 = pkg.getRequestedPermissions().iterator();
        ArraySet<String> oldGrantedRestrictedPermissions = null;
        boolean updatePermissions = false;
    L4:
        if (r12.hasNext() == false) goto L85;
        String permissionName = (String) r12.next();
        PackageManagerTracedLock r4 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        Permission bp = this.mRegistry.getPermission(permissionName);     // Catch: Throwable -> L74
        if (bp == null) goto L113;
        if (bp.isHardOrSoftRestricted() == false) goto L113;
        UidPermissionState uidState = getUidStateLocked(pkg, myUid);     // Catch: Throwable -> L74
        if (uidState != null) goto L19;
        Slog.e(TAG, "Missing permissions state for " + pkg.getPackageName() + " and user " + myUid);     // Catch: Throwable -> L17
        monitor-exit(r4);     // Catch: Throwable -> L17
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        myUid2 = myUid2;
    L79:
        myUid = userId;
        myUid2 = myUid2;
    L17:
        th = th;
    L81:
        monitor-exit(r4);     // Catch: Throwable -> L80
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L80:
        th = th;
        goto L81
    L19:
        boolean isGranted = uidState.isPermissionGranted(permissionName);     // Catch: Throwable -> L74
        monitor-exit(r4);     // Catch: Throwable -> L74
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (isGranted == false) goto L26;
        if (oldGrantedRestrictedPermissions != null) goto L25;
        oldGrantedRestrictedPermissions = new ArraySet();
    L25:
        oldGrantedRestrictedPermissions.add(permissionName);
        ArraySet<String> oldGrantedRestrictedPermissions2 = oldGrantedRestrictedPermissions;
    L27:
        int oldFlags = getPermissionFlagsInternal(pkg.getPackageName(), permissionName, myUid2, myUid);
        int newFlags = oldFlags;
        int mask = 0;
        int allowlistFlagsCopy = allowlistFlags;
    L28:
        boolean r7 = true;
        if (allowlistFlagsCopy == 0) goto L52;
        int flag = 1 << Integer.numberOfTrailingZeros(allowlistFlagsCopy);
        allowlistFlagsCopy = allowlistFlagsCopy & (~flag);
        switch(flag) {
            case 1: goto L45;
            case 2: goto L39;
            case 3: goto L28;
            case 4: goto L33;
            default: goto L28;
        };
    L33:
        mask = mask | 8192;
        if (permissions == null) goto L38;
        if (permissions.contains(permissionName) == false) goto L38;
        newFlags = newFlags | 8192;
    L38:
        newFlags = newFlags & (-8193);
        goto L28
    L39:
        mask = mask | 2048;
        if (permissions == null) goto L44;
        if (permissions.contains(permissionName) == false) goto L44;
        newFlags = newFlags | 2048;
    L44:
        newFlags = newFlags & (-2049);
        goto L28
    L45:
        mask = mask | 4096;
        if (permissions == null) goto L50;
        if (permissions.contains(permissionName) == false) goto L50;
        newFlags = newFlags | 4096;
    L50:
        newFlags = newFlags & (-4097);
        goto L28
    L52:
        if (oldFlags == newFlags) goto L53;
        if ((oldFlags & 14336) == 0) goto L57;
        boolean r8 = true;
    L58:
        boolean wasAllowlisted = r8;
        if ((newFlags & 14336) != 0) goto L62;
        r7 = false;
    L62:
        boolean isAllowlisted = r7;
        if ((oldFlags & 4) == 0) goto L68;
        if (isAllowlisted == true) goto L68;
        if (isGranted == false) goto L68;
        mask = mask | 4;
        newFlags = newFlags & (-5);
    L68:
        if (pkg.getTargetSdkVersion() >= 23) goto L73;
        if (wasAllowlisted == true) goto L73;
        if (isAllowlisted == false) goto L73;
        mask = mask | 64;
        newFlags = newFlags | 64;
    L73:
        int mask2 = mask;
        int mask3 = newFlags;
        int myUid3 = myUid2;
        String permissionName2 = pkg.getPackageName();
        updatePermissionFlagsInternal(permissionName2, permissionName, mask2, mask3, myUid3, userId, false, null);
        myUid = userId;
        myUid2 = myUid3;
        oldGrantedRestrictedPermissions = oldGrantedRestrictedPermissions2;
        updatePermissions = true;
        goto L4
    L57:
        r8 = false;
        goto L58
    L53:
        oldGrantedRestrictedPermissions = oldGrantedRestrictedPermissions2;
        goto L4
    L26:
        oldGrantedRestrictedPermissions2 = oldGrantedRestrictedPermissions;
    L113:
        monitor-exit(r4);     // Catch: Throwable -> L80
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L74:
        th = th;
        goto L81
    L85:
        if (updatePermissions == false) goto L110;
        restorePermissionState(pkg, false, pkg.getPackageName(), this.mDefaultPermissionCallback, userId);
        if (oldGrantedRestrictedPermissions != null) goto L89;
        return;
    L89:
        int oldGrantedCount = oldGrantedRestrictedPermissions.size();
        int j = 0;
    L90:
        if (j >= oldGrantedCount) goto L155;
        String permissionName3 = oldGrantedRestrictedPermissions.valueAt(j);
        PackageManagerTracedLock r10 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r10);
        UidPermissionState uidState2 = getUidStateLocked(pkg, userId);     // Catch: Throwable -> L98
        if (uidState2 != null) goto L100;
        Slog.e(TAG, "Missing permissions state for " + pkg.getPackageName() + " and user " + userId);     // Catch: Throwable -> L98
        monitor-exit(r10);     // Catch: Throwable -> L98
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L105:
        j = j + 1;
        goto L90
    L100:
        boolean isGranted2 = uidState2.isPermissionGranted(permissionName3);     // Catch: Throwable -> L98
        monitor-exit(r10);     // Catch: Throwable -> L98
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (isGranted2 == true) goto L105;
        this.mDefaultPermissionCallback.onPermissionRevoked(UserHandle.getUid(userId, pkg.getUid()), userId, null);
        return;
    L98:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L155:
        return;
    }

    private void revokeSharedUserPermissionsForLeavingPackageInternal(AndroidPackage pkg, final int appId, List<AndroidPackage> sharedUserPkgs, int userId) {
        if (pkg != null) goto L6;
        Slog.i(TAG, "Trying to update info for null package. Just ignoring");
        return;
    L6:
        if (sharedUserPkgs.isEmpty() == false) goto L8;
        return;
    L8:
        PackageStateInternal disabledPs = this.mPackageManagerInt.getDisabledSystemPackage(pkg.getPackageName());
        if (disabledPs != null) goto L11;
    L13:
        boolean isShadowingSystemPkg = false;
    L14:
        boolean shouldKillUid = false;
        Iterator r3 = pkg.getRequestedPermissions().iterator();
    L16:
        if (r3.hasNext() == false) goto L57;
        String eachPerm = (String) r3.next();
        boolean used = false;
        Iterator<AndroidPackage> r6 = sharedUserPkgs.iterator();
    L19:
        if (r6.hasNext() == false) goto L28;
        AndroidPackage sharedUserpkg = r6.next();
        if (sharedUserpkg == null) goto L19;
        if (sharedUserpkg.getPackageName().equals(pkg.getPackageName()) == true) goto L19;
        if (sharedUserpkg.getRequestedPermissions().contains(eachPerm) == false) goto L19;
        used = true;
    L28:
        if (used == true) goto L16;
        if (isShadowingSystemPkg == false) goto L34;
        if (disabledPs.getPkg().getRequestedPermissions().contains(eachPerm) == true) goto L16;
    L34:
        PackageManagerTracedLock r7 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r7);
        UidPermissionState uidState = getUidStateLocked(appId, userId);     // Catch: Throwable -> L41
        if (uidState == null) goto L38;
        Permission bp = this.mRegistry.getPermission(eachPerm);     // Catch: Throwable -> L41
        if (bp == null) goto L45;
        if (uidState.removePermissionState(bp.getName()) == true) goto L50;
    L52:
        monitor-exit(r7);     // Catch: Throwable -> L41
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        goto L16
    L50:
        if (bp.hasGids() == false) goto L52;
        shouldKillUid = true;
        goto L52
    L45:
        monitor-exit(r7);     // Catch: Throwable -> L41
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        goto L16
    L38:
        Slog.e(TAG, "Missing permissions state for " + pkg.getPackageName() + " and user " + userId);     // Catch: Throwable -> L41
        monitor-exit(r7);     // Catch: Throwable -> L41
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L41:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L57:
        if (shouldKillUid == false) goto L84;
        this.mHandler.post(new PermissionManagerServiceImpl$$ExternalSyntheticLambda15(appId));
        return;
    L84:
        return;
    L11:
        if (disabledPs.getAppId() != pkg.getUid()) goto L13;
        isShadowingSystemPkg = true;
        goto L14
    }

    private static /* synthetic */ void lambda$revokeSharedUserPermissionsForLeavingPackageInternal$10(int appId) {
        killUid(appId, -1, "permission grant or revoke changed gids");
    }

    private boolean revokeUnusedSharedUserPermissionsLocked(Collection<String> uidRequestedPermissions, UidPermissionState uidState) {
        boolean runtimePermissionChanged = false;
        List<PermissionState> permissionStates = uidState.getPermissionStates();
        int permissionStatesSize = permissionStates.size();
        int i = permissionStatesSize - 1;
    L3:
        if (i < 0) goto L15;
        PermissionState permissionState = permissionStates.get(i);
        if (uidRequestedPermissions.contains(permissionState.getName()) == true) goto L13;
        Permission bp = this.mRegistry.getPermission(permissionState.getName());
        if (bp == null) goto L13;
        if (uidState.removePermissionState(bp.getName()) == false) goto L13;
        if (bp.isRuntime() == false) goto L13;
        runtimePermissionChanged = true;
    L13:
        i = i - 1;
        goto L3
    L15:
        return runtimePermissionChanged;
    }

    private void updatePermissions(String packageName, AndroidPackage pkg) {
        if (pkg != null) goto L4;
        int r0 = 3;
    L5:
        int flags = r0;
        updatePermissions(packageName, pkg, getVolumeUuidForPackage(pkg), flags, this.mDefaultPermissionCallback);
        return;
    L4:
        r0 = 2;
        goto L5
    }

    private void updateAllPermissions(String volumeUuid, boolean fingerprintChanged) {
        PackageManager.corkPackageInfoCache();
        if (fingerprintChanged == false) goto L5;
        int r0 = 6;
    L6:
        int flags = 1 | r0;
        updatePermissions(null, null, volumeUuid, flags, this.mDefaultPermissionCallback);     // Catch: Throwable -> L12
        PackageManager.uncorkPackageInfoCache();
        return;
    L12:
        th = move-exception;
        Throwable r9 = th;
    L16:
        PackageManager.uncorkPackageInfoCache();
        throw r9;
    L14:
        th = move-exception;
        r9 = th;
        goto L16
    L5:
        r0 = 0;
        goto L6
    }

    private void updatePermissions(final String changingPkgName, final AndroidPackage changingPkg, final String replaceVolumeUuid, int flags, final PermissionCallback callback) {
        boolean permissionTreesSourcePackageChanged = updatePermissionTreeSourcePackage(changingPkgName, changingPkg);
        boolean permissionSourcePackageChanged = updatePermissionSourcePackage(changingPkgName, callback);
        if ((permissionTreesSourcePackageChanged | permissionSourcePackageChanged) == false) goto L5;
        Slog.i(TAG, "Permission ownership changed. Updating all permissions.");
        int flags2 = flags | 1;
    L6:
        Trace.traceBegin(262144, "restorePermissionState");
        if ((flags2 & 1) != 0) goto L9;
    L13:
        if (changingPkg == null) goto L23;
        String volumeUuid = getVolumeUuidForPackage(changingPkg);
        if ((flags2 & 2) == 0) goto L20;
        if (Objects.equals(replaceVolumeUuid, volumeUuid) == false) goto L20;
        boolean replace = true;
    L21:
        restorePermissionState(changingPkg, replace, changingPkgName, callback, -1);
    L20:
        replace = false;
    L23:
        Trace.traceEnd(262144);
        return;
    L9:
        if ((flags2 & 4) == 0) goto L11;
        boolean replaceAll = true;
    L12:
        final boolean replaceAll2 = replaceAll;
        this.mPackageManagerInt.forEachPackage(new PermissionManagerServiceImpl$$ExternalSyntheticLambda13(this, changingPkg, replaceAll2, replaceVolumeUuid, changingPkgName, callback));
        goto L13
    L11:
        replaceAll = false;
        goto L12
    L5:
        flags2 = flags;
        goto L6
    }

    private /* synthetic */ void lambda$updatePermissions$11(AndroidPackage changingPkg, boolean replaceAll, String replaceVolumeUuid, String changingPkgName, PermissionCallback callback, AndroidPackage pkg) {
        if (pkg != changingPkg) goto L4;
        return;
    L4:
        String volumeUuid = getVolumeUuidForPackage(pkg);
        if (replaceAll == true) goto L7;
    L9:
        boolean r1 = false;
    L10:
        boolean replace = r1;
        restorePermissionState(pkg, replace, changingPkgName, callback, -1);
        return;
    L7:
        if (Objects.equals(replaceVolumeUuid, volumeUuid) == false) goto L9;
        r1 = true;
        goto L10
    }

    private boolean updatePermissionSourcePackage(String packageName, final PermissionCallback callback) {
        if (packageName != null) goto L5;
        return true;
    L5:
        boolean changed = false;
        Set<Permission> needsUpdate = null;
        PackageManagerTracedLock r2 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        Iterator<Permission> r3 = this.mRegistry.getPermissions().iterator();     // Catch: Throwable -> L13
    L9:
        if (r3.hasNext() == false) goto L22;
        Permission bp = r3.next();     // Catch: Throwable -> L13
        if (bp.isDynamic() == false) goto L16;
        bp.updateDynamicPermission(this.mRegistry.getPermissionTrees());     // Catch: Throwable -> L13
    L16:
        if (packageName.equals(bp.getPackageName()) == false) goto L9;
        changed = true;
        if (needsUpdate != null) goto L21;
        needsUpdate = new ArraySet();     // Catch: Throwable -> L13
    L21:
        needsUpdate.add(bp);     // Catch: Throwable -> L13
        goto L9
    L22:
        monitor-exit(r2);     // Catch: Throwable -> L13
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (needsUpdate == null) goto L65;
        AndroidPackage pkg = this.mPackageManagerInt.getPackage(packageName);
        Iterator<Permission> r4 = needsUpdate.iterator();
    L27:
        if (r4.hasNext() == false) goto L65;
        final Permission bp2 = r4.next();
        if (pkg == null) goto L48;
        if (hasPermission(pkg, bp2.getName()) == false) goto L48;
        AndroidPackage sourcePkg = this.mPackageManagerInt.getPackage(bp2.getPackageName());
        PackageStateInternal sourcePs = this.mPackageManagerInt.getPackageStateInternal(bp2.getPackageName());
        PackageManagerTracedLock r7 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r7);
        if (sourcePkg == null) goto L41;
        if (sourcePs == null) goto L41;
        monitor-exit(r7);     // Catch: Throwable -> L39
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L39:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L41:
        Slog.w(TAG, "Removing dangling permission: " + bp2.getName() + " from package " + bp2.getPackageName());     // Catch: Throwable -> L39
        this.mRegistry.removePermission(bp2.getName());     // Catch: Throwable -> L39
        monitor-exit(r7);     // Catch: Throwable -> L39
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L48:
        if (isPermissionDeclaredByDisabledSystemPkg(bp2) == true) goto L56;
        Slog.i(TAG, "Removing permission " + bp2.getName() + " that used to be declared by " + bp2.getPackageName());
        if (bp2.isRuntime() == false) goto L55;
        int[] userIds = this.mUserManagerInt.getUserIds();
        int numUserIds = userIds.length;
        int userIdNum = 0;
    L52:
        if (userIdNum >= numUserIds) goto L56;
        final int userId = userIds[userIdNum];
        this.mPackageManagerInt.forEachPackage(new PermissionManagerServiceImpl$$ExternalSyntheticLambda3(this, bp2, userId, callback));
        userIdNum = userIdNum + 1;
        goto L52
    L55:
        this.mPackageManagerInt.forEachPackage(new PermissionManagerServiceImpl$$ExternalSyntheticLambda4(this, bp2));
    L56:
        PackageManagerTracedLock r5 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        this.mRegistry.removePermission(bp2.getName());     // Catch: Throwable -> L61
        monitor-exit(r5);     // Catch: Throwable -> L61
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L61:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L65:
        return changed;
    L13:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$updatePermissionSourcePackage$12(Permission bp, int userId, PermissionCallback callback, AndroidPackage p) {
        revokePermissionFromPackageForUser(p.getPackageName(), bp.getName(), true, userId, callback);
    }

    private /* synthetic */ void lambda$updatePermissionSourcePackage$13(Permission bp, AndroidPackage p) {
        int[] userIds = this.mUserManagerInt.getUserIds();
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        int r2 = userIds.length;     // Catch: Throwable -> L9
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L13;
        int userId = userIds[r3];     // Catch: Throwable -> L9
        UidPermissionState uidState = getUidStateLocked(p, userId);     // Catch: Throwable -> L9
        if (uidState != null) goto L11;
        Slog.e(TAG, "Missing permissions state for " + p.getPackageName() + " and user " + userId);     // Catch: Throwable -> L9
    L12:
        r3 = r3 + 1;     // Catch: Throwable -> L9
        goto L5
    L11:
        uidState.removePermissionState(bp.getName());     // Catch: Throwable -> L9
        goto L12
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L9:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private boolean isPermissionDeclaredByDisabledSystemPkg(Permission permission) {
        PackageStateInternal disabledSourcePs = this.mPackageManagerInt.getDisabledSystemPackage(permission.getPackageName());
        if (disabledSourcePs != null) goto L5;
        return false;
    L5:
        if (disabledSourcePs.getPkg() == null) goto L24;
        String permissionName = permission.getName();
        List<ParsedPermission> sourcePerms = disabledSourcePs.getPkg().getPermissions();
        Iterator<ParsedPermission> r3 = sourcePerms.iterator();
    L8:
        if (r3.hasNext() == false) goto L25;
        ParsedPermission sourcePerm = r3.next();
        if (TextUtils.equals(permissionName, sourcePerm.getName()) == false) goto L8;
        if (permission.getProtectionLevel() != sourcePerm.getProtectionLevel()) goto L8;
        return true;
    L25:
        return false;
    L24:
        return false;
    }

    private void revokePermissionFromPackageForUser(String pName, String permissionName, boolean overridePolicy, int userId, PermissionCallback callback) {
        ApplicationInfo appInfo = this.mPackageManagerInt.getApplicationInfo(pName, 0, 1000, 0);
        if (appInfo == null) goto L8;
        if (appInfo.targetSdkVersion >= 23) goto L8;
        return;
    L8:
        if (checkPermission(pName, permissionName, userId) != 0) goto L15;
        revokeRuntimePermissionInternal(pName, permissionName, overridePolicy, 1000, userId, null, callback);     // Catch: IllegalArgumentException -> L12
        return;
    L12:
        e = move-exception;
        Slog.e(TAG, "Failed to revoke " + permissionName + " from " + pName, e);
        return;
    }

    private boolean updatePermissionTreeSourcePackage(String packageName, AndroidPackage pkg) {
        if (packageName != null) goto L5;
        return true;
    L5:
        boolean changed = false;
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        Iterator<Permission> it = this.mRegistry.getPermissionTrees().iterator();     // Catch: Throwable -> L18
    L9:
        if (it.hasNext() == false) goto L23;
        Permission bp = it.next();     // Catch: Throwable -> L18
        if (packageName.equals(bp.getPackageName()) == false) goto L9;
        changed = true;
        if (pkg == null) goto L20;
        if (hasPermission(pkg, bp.getName()) == true) goto L9;
    L20:
        Slog.i(TAG, "Removing permission tree " + bp.getName() + " that used to be declared by " + bp.getPackageName());     // Catch: Throwable -> L18
        it.remove();     // Catch: Throwable -> L18
        goto L9
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L18
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return changed;
    L18:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private void enforceGrantRevokeRuntimePermissionPermissions(String message) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.GRANT_RUNTIME_PERMISSIONS") != 0) goto L5;
        return;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.REVOKE_RUNTIME_PERMISSIONS") != 0) goto L7;
        return;
    L7:
        if (this.mZswExt != null) goto L9;
        return;
    L9:
        if (this.mZswExt.isHSCallingUid(this.mContext, Binder.getCallingUid()) == false) goto L12;
        return;
    L12:
        throw new SecurityException(message + " requires android.permission.GRANT_RUNTIME_PERMISSIONS or android.permission.REVOKE_RUNTIME_PERMISSIONS");
    }

    private void enforceGrantRevokeGetRuntimePermissionPermissions(String message) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.GET_RUNTIME_PERMISSIONS") != 0) goto L5;
        return;
    L5:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.GRANT_RUNTIME_PERMISSIONS") != 0) goto L7;
        return;
    L7:
        if (this.mContext.checkCallingOrSelfPermission("android.permission.REVOKE_RUNTIME_PERMISSIONS") != 0) goto L9;
        return;
    L9:
        if (this.mZswExt != null) goto L11;
        return;
    L11:
        if (this.mZswExt.isHSCallingUid(this.mContext, Binder.getCallingUid()) == false) goto L14;
        return;
    L14:
        throw new SecurityException(message + " requires android.permission.GRANT_RUNTIME_PERMISSIONS or android.permission.REVOKE_RUNTIME_PERMISSIONS or android.permission.GET_RUNTIME_PERMISSIONS");
    }

    private void enforceCrossUserPermission(int callingUid, int userId, boolean requireFullPermission, boolean checkShell, String message) {
        if (userId < 0) goto L14;
        if (checkShell == false) goto L5;
        enforceShellRestriction("no_debugging_features", callingUid, userId);
    L5:
        int callingUserId = UserHandle.getUserId(callingUid);
        if (DoppelgangerManager.allowCrossUser(callingUserId, userId) == false) goto L9;
        return;
    L9:
        if (checkCrossUserPermission(callingUid, callingUserId, userId, requireFullPermission) == false) goto L11;
        return;
    L11:
        String errorMessage = buildInvalidCrossUserPermissionMessage(callingUid, userId, message, requireFullPermission);
        Slog.w(TAG, errorMessage);
        throw new SecurityException(errorMessage);
    L14:
        throw new IllegalArgumentException("Invalid userId " + userId);
    }

    private void enforceShellRestriction(String restriction, int callingUid, int userId) {
        if (callingUid != 2000) goto L13;
        if (userId >= 0) goto L6;
    L10:
        if (userId >= 0) goto L14;
        Slog.e(LOG_TAG, "Unable to check shell permission for user " + userId + "\n\t" + Debug.getCallers(3));
        return;
    L14:
        return;
    L6:
        if (this.mUserManagerInt.hasUserRestriction(restriction, userId) == false) goto L10;
        throw new SecurityException("Shell does not have permission to access user " + userId);
    }

    private boolean checkCrossUserPermission(int callingUid, int callingUserId, int userId, boolean requireFullPermission) {
        if (userId != callingUserId) goto L6;
        return true;
    L6:
        if (callingUid == 1000) goto L21;
        if (callingUid == 0) goto L21;
        if (requireFullPermission == false) goto L14;
        return checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL");
    L14:
        if (checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL") == false) goto L16;
        return true;
    L16:
        if (checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS") == true) goto L23;
        return false;
    L23:
        return true;
    L21:
        return true;
    }

    private boolean checkCallingOrSelfPermission(String permission) {
        if (this.mContext.checkCallingOrSelfPermission(permission) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static String buildInvalidCrossUserPermissionMessage(int callingUid, int userId, String message, boolean requireFullPermission) {
        StringBuilder builder = new StringBuilder();
        if (message == null) goto L5;
        builder.append(message);
        builder.append(": ");
    L5:
        builder.append("UID ");
        builder.append(callingUid);
        builder.append(" requires ");
        builder.append("android.permission.INTERACT_ACROSS_USERS_FULL");
        if (requireFullPermission == true) goto L8;
        builder.append(" or ");
        builder.append("android.permission.INTERACT_ACROSS_USERS");
    L8:
        builder.append(" to access user ");
        builder.append(userId);
        builder.append(".");
        return builder.toString();
    }

    private int calculateCurrentPermissionFootprintLocked(Permission permissionTree) {
        int size = 0;
        Iterator<Permission> r1 = this.mRegistry.getPermissions().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Permission permission = r1.next();
        size = size + permissionTree.calculateFootprint(permission);
        goto L4
    L6:
        return size;
    }

    private void enforcePermissionCapLocked(PermissionInfo info, Permission tree) {
        if (tree.getUid() == 1000) goto L9;
        int curTreeSize = calculateCurrentPermissionFootprintLocked(tree);
        if ((info.calculateFootprint() + curTreeSize) > 32768) goto L8;
        return;
    L8:
        throw new SecurityException("Permission tree size cap exceeded");
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onSystemReady() {
        updateAllPermissions(StorageManager.UUID_PRIVATE_INTERNAL, false);
        PermissionPolicyInternal permissionPolicyInternal = (PermissionPolicyInternal) LocalServices.getService(PermissionPolicyInternal.class);
        permissionPolicyInternal.setOnInitializedCallback(new PermissionManagerServiceImpl$$ExternalSyntheticLambda18(this));
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        this.mSystemReady = true;     // Catch: Throwable -> L10
        if (this.mPrivappPermissionsViolations != null) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mPermissionControllerManager = new PermissionControllerManager(this.mContext, PermissionThread.getHandler());
        this.mPermissionPolicyInternal = (PermissionPolicyInternal) LocalServices.getService(PermissionPolicyInternal.class);
        return;
    L13:
        throw new IllegalStateException("Signature|privileged permissions not in privapp-permissions allowlist: " + this.mPrivappPermissionsViolations);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$onSystemReady$14(int userId) {
        updateAllPermissions(StorageManager.UUID_PRIVATE_INTERNAL, false);
    }

    private static String getVolumeUuidForPackage(AndroidPackage pkg) {
        if (pkg != null) goto L6;
        return StorageManager.UUID_PRIVATE_INTERNAL;
    L6:
        if (pkg.isExternalStorage() == false) goto L14;
        if (TextUtils.isEmpty(pkg.getVolumeUuid()) == false) goto L12;
        return "primary_physical";
    L12:
        return pkg.getVolumeUuid();
    L14:
        return StorageManager.UUID_PRIVATE_INTERNAL;
    }

    private static boolean hasPermission(AndroidPackage pkg, String permName) {
        if (pkg.getPermissions().isEmpty() == false) goto L5;
        return false;
    L5:
        int i = pkg.getPermissions().size() - 1;
    L6:
        if (i < 0) goto L12;
        if (((ParsedPermission) pkg.getPermissions().get(i)).getName().equals(permName) == true) goto L9;
        i = i - 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private void logPermission(int action, String name, String packageName) {
        LogMaker log = new LogMaker(action);
        log.setPackageName(packageName);
        log.addTaggedData(1241, name);
        this.mMetricsLogger.write(log);
    }

    private UidPermissionState getUidStateLocked(PackageStateInternal ps, int userId) {
        return getUidStateLocked(ps.getAppId(), userId);
    }

    private UidPermissionState getUidStateLocked(AndroidPackage pkg, int userId) {
        return getUidStateLocked(pkg.getUid(), userId);
    }

    private UidPermissionState getUidStateLocked(int appId, int userId) {
        UserPermissionState userState = this.mState.getUserState(userId);
        if (userState != null) goto L7;
        return null;
    L7:
        return userState.getUidState(appId);
    }

    private void removeUidStateAndResetPackageInstallPermissionsFixed(int appId, String packageName, int userId) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        UserPermissionState userState = this.mState.getUserState(userId);     // Catch: Throwable -> L9
        if (userState != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L11:
        userState.removeUidState(appId);     // Catch: Throwable -> L9
        userState.setInstallPermissionsFixed(packageName, false);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L9:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void readLegacyPermissionStateTEMP() {
        final int[] userIds = getAllUserIds();
        this.mPackageManagerInt.forEachPackageState(new PermissionManagerServiceImpl$$ExternalSyntheticLambda14(this, userIds));
    }

    private /* synthetic */ void lambda$readLegacyPermissionStateTEMP$15(int[] userIds, PackageStateInternal ps) {
        int appId = ps.getAppId();
        if (ps.hasSharedUser() == false) goto L9;
        int sharedUserId = ps.getSharedUserAppId();
        SharedUserApi sharedUserApi = this.mPackageManagerInt.getSharedUserApi(sharedUserId);
        if (sharedUserApi != null) goto L8;
        Slog.wtf(TAG, "Missing shared user Api for " + sharedUserId);
        return;
    L8:
        LegacyPermissionState legacyState = sharedUserApi.getSharedUserLegacyPermissionState();
    L10:
        PackageManagerTracedLock r2 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        int r3 = userIds.length;     // Catch: Throwable -> L15
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L17;
        int userId = userIds[r4];     // Catch: Throwable -> L15
        UserPermissionState userState = this.mState.getOrCreateUserState(userId);     // Catch: Throwable -> L15
        userState.setInstallPermissionsFixed(ps.getPackageName(), ps.isInstallPermissionsFixed());     // Catch: Throwable -> L15
        UidPermissionState uidState = userState.getOrCreateUidState(appId);     // Catch: Throwable -> L15
        uidState.reset();     // Catch: Throwable -> L15
        uidState.setMissing(legacyState.isMissing(userId));     // Catch: Throwable -> L15
        readLegacyPermissionStatesLocked(uidState, legacyState.getPermissionStates(userId));     // Catch: Throwable -> L15
        r4 = r4 + 1;     // Catch: Throwable -> L15
        goto L13
    L17:
        monitor-exit(r2);     // Catch: Throwable -> L15
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L15:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L9:
        legacyState = ps.getLegacyPermissionState();
        goto L10
    }

    private void readLegacyPermissionStatesLocked(UidPermissionState uidState, Collection<LegacyPermissionState.PermissionState> permissionStates) {
        Iterator<LegacyPermissionState.PermissionState> r0 = permissionStates.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        LegacyPermissionState.PermissionState permissionState = r0.next();
        String permissionName = permissionState.getName();
        Permission permission = this.mRegistry.getPermission(permissionName);
        if (permission == null) goto L7;
        uidState.putPermissionState(permission, permissionState.isGranted(), permissionState.getFlags());
        goto L4
    L7:
        Slog.w(TAG, "Unknown permission: " + permissionName);
        goto L4
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void writeLegacyPermissionStateTEMP() {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        final int[] userIds = this.mState.getUserIds();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        this.mPackageManagerInt.forEachPackageSetting(new PermissionManagerServiceImpl$$ExternalSyntheticLambda17(this, userIds));
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$writeLegacyPermissionStateTEMP$16(int[] userIds, PackageSetting ps) {
        PermissionManagerServiceImpl r1 = this;
        int[] r2 = userIds;
        PackageSetting r3 = ps;
        int r0 = 0;
        r3.setInstallPermissionsFixed(false);
        if (r3.hasSharedUser() == false) goto L9;
        int sharedUserId = r3.getSharedUserAppId();
        SharedUserApi sharedUserApi = r1.mPackageManagerInt.getSharedUserApi(sharedUserId);
        if (sharedUserApi != null) goto L8;
        Slog.wtf(TAG, "Missing shared user Api for " + sharedUserId);
        return;
    L8:
        LegacyPermissionState legacyState = sharedUserApi.getSharedUserLegacyPermissionState();
    L10:
        legacyState.reset();
        int appId = r3.getAppId();
        PackageManagerTracedLock r6 = r1.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r6);
        int r7 = r2.length;     // Catch: Throwable -> L17
    L13:
        if (r0 >= r7) goto L30;
        int userId = r2[r0];     // Catch: Throwable -> L17
        UserPermissionState userState = r1.mState.getUserState(userId);     // Catch: Throwable -> L17
        if (userState != null) goto L20;
        Slog.e(TAG, "Missing user state for " + userId);     // Catch: Throwable -> L17
        int r16 = r0;
    L29:
        r0 = r16 + 1;     // Catch: Throwable -> L17
        r1 = this;
        r2 = userIds;
        r3 = ps;
        goto L13
    L20:
        if (userState.areInstallPermissionsFixed(r3.getPackageName()) == false) goto L22;
        r3.setInstallPermissionsFixed(true);     // Catch: Throwable -> L17
    L22:
        UidPermissionState uidState = userState.getUidState(appId);     // Catch: Throwable -> L17
        if (uidState != null) goto L25;
        Slog.e(TAG, "Missing permission state for " + r3.getPackageName() + " and user " + userId);     // Catch: Throwable -> L17
        r16 = r0;
        goto L29
    L25:
        legacyState.setMissing(uidState.isMissing(), userId);     // Catch: Throwable -> L17
        List<PermissionState> permissionStates = uidState.getPermissionStates();     // Catch: Throwable -> L17
        int permissionStatesSize = permissionStates.size();     // Catch: Throwable -> L17
        int i = 0;
    L26:
        if (i >= permissionStatesSize) goto L28;
        PermissionState permissionState = permissionStates.get(i);     // Catch: Throwable -> L17
        LegacyPermissionState.PermissionState legacyPermissionState = new LegacyPermissionState.PermissionState(permissionState.getName(), permissionState.getPermission().isRuntime(), permissionState.isGranted(), permissionState.getFlags());     // Catch: Throwable -> L17
        legacyState.putPermissionState(legacyPermissionState, userId);     // Catch: Throwable -> L17
        i = i + 1;     // Catch: Throwable -> L17
        r0 = r0;
        goto L26
    L28:
        r16 = r0;
        goto L29
    L30:
        monitor-exit(r6);     // Catch: Throwable -> L17
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L17:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L9:
        legacyState = r3.getLegacyPermissionState();
        goto L10
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void readLegacyPermissionsTEMP(LegacyPermissionSettings legacyPermissionSettings) {
        int readPermissionOrPermissionTree = 0;
    L4:
        if (readPermissionOrPermissionTree >= 2) goto L31;
        if (readPermissionOrPermissionTree != 0) goto L7;
        List<LegacyPermission> legacyPermissions = legacyPermissionSettings.getPermissions();
    L8:
        PackageManagerTracedLock r2 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        int legacyPermissionsSize = legacyPermissions.size();     // Catch: Throwable -> L19
        int i = 0;
    L11:
        if (i >= legacyPermissionsSize) goto L25;
        LegacyPermission legacyPermission = legacyPermissions.get(i);     // Catch: Throwable -> L19
        Permission permission = new Permission(legacyPermission.getPermissionInfo(), legacyPermission.getType());     // Catch: Throwable -> L19
        if (readPermissionOrPermissionTree != 0) goto L22;
        Permission configPermission = this.mRegistry.getPermission(permission.getName());     // Catch: Throwable -> L19
        if (configPermission != null) goto L17;
    L21:
        this.mRegistry.addPermission(permission);     // Catch: Throwable -> L19
    L23:
        i = i + 1;     // Catch: Throwable -> L19
        goto L11
    L17:
        if (configPermission.getType() != 1) goto L21;
        permission.setGids(configPermission.getRawGids(), configPermission.areGidsPerUser());     // Catch: Throwable -> L19
        goto L21
    L22:
        this.mRegistry.addPermissionTree(permission);     // Catch: Throwable -> L19
        goto L23
    L25:
        monitor-exit(r2);     // Catch: Throwable -> L19
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        readPermissionOrPermissionTree = readPermissionOrPermissionTree + 1;
    L19:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L7:
        legacyPermissions = legacyPermissionSettings.getPermissionTrees();
        goto L8
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void writeLegacyPermissionsTEMP(LegacyPermissionSettings legacyPermissionSettings) {
        int writePermissionOrPermissionTree = 0;
    L4:
        if (writePermissionOrPermissionTree >= 2) goto L26;
        List<LegacyPermission> legacyPermissions = new ArrayList();
        PackageManagerTracedLock r2 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        if (writePermissionOrPermissionTree == 0) goto L27;
        Collection<Permission> permissions = this.mRegistry.getPermissionTrees();     // Catch: Throwable -> L9
    L12:
        Iterator<Permission> r4 = permissions.iterator();     // Catch: Throwable -> L9
    L14:
        if (r4.hasNext() == false) goto L16;
        Permission permission = r4.next();     // Catch: Throwable -> L9
        LegacyPermission legacyPermission = new LegacyPermission(permission.getPermissionInfo(), permission.getType(), 0, EmptyArray.INT);     // Catch: Throwable -> L9
        legacyPermissions.add(legacyPermission);     // Catch: Throwable -> L9
        goto L14
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        if (writePermissionOrPermissionTree != 0) goto L20;
        legacyPermissionSettings.replacePermissions(legacyPermissions);
    L21:
        writePermissionOrPermissionTree = writePermissionOrPermissionTree + 1;
        goto L4
    L20:
        legacyPermissionSettings.replacePermissionTrees(legacyPermissions);
        goto L21
    L27:
        permissions = this.mRegistry.getPermissions();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public String getDefaultPermissionGrantFingerprint(int userId) {
        if (this.mPackageManagerInt.isPermissionUpgradeNeeded(userId) == false) goto L6;
        return null;
    L6:
        return Build.FINGERPRINT;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void setDefaultPermissionGrantFingerprint(String fingerprint, int userId) {
    }

    private void onPackageAddedInternal(PackageState packageState, final AndroidPackage pkg, boolean isInstantApp, final AndroidPackage oldPkg) {
        if (pkg.getAdoptPermissions().isEmpty() == true) goto L18;
        int i = pkg.getAdoptPermissions().size() - 1;
    L5:
        if (i < 0) goto L18;
        String origName = (String) pkg.getAdoptPermissions().get(i);
        if (canAdoptPermissionsInternal(origName, pkg) == false) goto L17;
        Slog.i(TAG, "Adopting permissions from " + origName + " to " + pkg.getPackageName());
        PackageManagerTracedLock r4 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        this.mRegistry.transferPermissions(origName, pkg.getPackageName());     // Catch: Throwable -> L13
        monitor-exit(r4);     // Catch: Throwable -> L13
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
    L13:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L17:
        i = i - 1;
    L18:
        if (isInstantApp == false) goto L20;
        Slog.w(TAG, "Permission groups from package " + pkg.getPackageName() + " ignored: instant apps cannot define new permission groups.");
    L21:
        if (isInstantApp == false) goto L23;
        Slog.w(TAG, "Permissions from package " + pkg.getPackageName() + " ignored: instant apps cannot define new permissions.");
        final List<String> permissionsWithChangedDefinition = null;
    L24:
        if (oldPkg == null) goto L26;
        final boolean hasOldPkg = true;
    L27:
        final boolean hasPermissionDefinitionChanges = !CollectionUtils.isEmpty(permissionsWithChangedDefinition);
        if (hasOldPkg == true) goto L32;
        if (hasPermissionDefinitionChanges == true) goto L32;
        return;
    L32:
        AsyncTask.execute(new PermissionManagerServiceImpl$$ExternalSyntheticLambda7(this, hasOldPkg, pkg, oldPkg, hasPermissionDefinitionChanges, permissionsWithChangedDefinition));
        return;
    L26:
        hasOldPkg = false;
        goto L27
    L23:
        List<String> permissionsWithChangedDefinition2 = addAllPermissionsInternal(packageState, pkg);
        permissionsWithChangedDefinition = permissionsWithChangedDefinition2;
        goto L24
    L20:
        addAllPermissionGroupsInternal(pkg);
        goto L21
    }

    private /* synthetic */ void lambda$onPackageAddedInternal$17(boolean hasOldPkg, AndroidPackage pkg, AndroidPackage oldPkg, boolean hasPermissionDefinitionChanges, List permissionsWithChangedDefinition) {
        if (hasOldPkg == false) goto L4;
        revokeRuntimePermissionsIfGroupChangedInternal(pkg, oldPkg);
        revokeStoragePermissionsIfScopeExpandedInternal(pkg, oldPkg);
        revokeSystemAlertWindowIfUpgradedPast23(pkg, oldPkg);
    L4:
        if (hasPermissionDefinitionChanges == false) goto L7;
        revokeRuntimePermissionsIfPermissionDefinitionChangedInternal(permissionsWithChangedDefinition);
        return;
    }

    private boolean canAdoptPermissionsInternal(String oldPackageName, AndroidPackage newPkg) {
        PackageStateInternal oldPs = this.mPackageManagerInt.getPackageStateInternal(oldPackageName);
        if (oldPs != null) goto L6;
        return false;
    L6:
        if (oldPs.isSystem() == true) goto L10;
        Slog.w(TAG, "Unable to update from " + oldPs.getPackageName() + " to " + newPkg.getPackageName() + ": old package not in system partition");
        return false;
    L10:
        if (this.mPackageManagerInt.getPackage(oldPs.getPackageName()) == null) goto L13;
        Slog.w(TAG, "Unable to update from " + oldPs.getPackageName() + " to " + newPkg.getPackageName() + ": old package still exists");
        return false;
    L13:
        return true;
    }

    private boolean isEffectivelyGranted(PermissionState state) {
        int flags = state.getFlags();
        if ((flags & 16) == 0) goto L6;
        return true;
    L6:
        if ((flags & 4) == 0) goto L15;
        if ((flags & 8) != 0) goto L13;
        if (state.isGranted() == false) goto L13;
        return true;
    L13:
        return false;
    L15:
        if ((65608 & flags) == 0) goto L18;
        return false;
    L18:
        return state.isGranted();
    }

    private Pair<Boolean, Integer> mergePermissionState(int appId, PermissionState srcState, PermissionState destState) {
        int destFlags = destState.getFlags();
        boolean destIsGranted = isEffectivelyGranted(destState);
        int srcFlags = srcState.getFlags();
        boolean srcIsGranted = isEffectivelyGranted(srcState);
        int combinedFlags = destFlags | srcFlags;
        int newFlags = (0 | (524291 & destFlags)) | (combinedFlags & 14336);
        if ((newFlags & 14336) != 0) goto L5;
        newFlags = newFlags | 16384;
    L5:
        int newFlags2 = newFlags | (combinedFlags & 32820);
        if ((combinedFlags & 32820) != 0) goto L9;
        newFlags2 = newFlags2 | (combinedFlags & 128);
    L9:
        if ((newFlags2 & 20) != 0) goto L19;
        if ((557091 & newFlags2) != 0) goto L16;
        if (NOTIFICATION_PERMISSIONS.contains(srcState.getName()) == false) goto L16;
        newFlags2 = newFlags2 | (combinedFlags & 64);
    L16:
        if ((32820 & newFlags2) != 0) goto L19;
        newFlags2 = newFlags2 | (destFlags & 64);
    L19:
        if ((newFlags2 & 16) == 0) goto L22;
        boolean effectivelyGranted = true;
    L56:
        if (effectivelyGranted == true) goto L58;
        int newFlags3 = (newFlags2 | (131072 & combinedFlags)) & (-129);
    L59:
        if (effectivelyGranted == destIsGranted) goto L61;
        newFlags3 = newFlags3 & (-524292);
    L61:
        if (effectivelyGranted == true) goto L66;
        if (isPermissionSplitFromNonRuntime(srcState.getName(), this.mPackageManagerInt.getUidTargetSdkVersion(appId)) == false) goto L66;
        newFlags3 = newFlags3 | 8;
        boolean newGrantState = true;
    L68:
        return new Pair(Boolean.valueOf(newGrantState), Integer.valueOf(newFlags3));
    L66:
        newGrantState = effectivelyGranted;
        goto L68
    L58:
        newFlags3 = newFlags2 & (-65);
        goto L59
    L22:
        if ((destFlags & 4) == 0) goto L24;
        effectivelyGranted = destIsGranted;
        goto L56
    L24:
        boolean r14 = true;
        if ((srcFlags & 4) == 0) goto L34;
        if (destIsGranted == true) goto L30;
        if (srcIsGranted == true) goto L30;
        r14 = false;
    L30:
        effectivelyGranted = r14;
        if (destIsGranted == srcIsGranted) goto L56;
        newFlags2 = newFlags2 & (-5);
        goto L56
    L34:
        if ((destFlags & 32800) == 0) goto L37;
        effectivelyGranted = destIsGranted;
        goto L56
    L37:
        if ((32800 & srcFlags) == 0) goto L44;
        if (destIsGranted == true) goto L42;
        if (srcIsGranted == true) goto L42;
        r14 = false;
    L42:
        effectivelyGranted = r14;
        goto L56
    L44:
        if ((destFlags & 128) == 0) goto L47;
        effectivelyGranted = destIsGranted;
        goto L56
    L47:
        if ((srcFlags & 128) == 0) goto L55;
        if (destIsGranted == true) goto L52;
        if (srcIsGranted == true) goto L52;
        r14 = false;
    L52:
        effectivelyGranted = r14;
        if (destIsGranted == false) goto L56;
        newFlags2 = newFlags2 & (-129);
        goto L56
    L55:
        effectivelyGranted = destIsGranted;
        goto L56
    }

    private void handleAppIdMigration(AndroidPackage pkg, int previousAppId) {
        PackageStateInternal ps = this.mPackageManagerInt.getPackageStateInternal(pkg.getPackageName());
        int r4 = 0;
        if (ps.hasSharedUser() == false) goto L39;
        PackageManagerTracedLock r5 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r5);
        int[] r0 = getAllUserIds();     // Catch: Throwable -> L26
        int r6 = r0.length;     // Catch: Throwable -> L26
    L7:
        if (r4 >= r6) goto L34;
        int userId = r0[r4];     // Catch: Throwable -> L26
        UserPermissionState userState = this.mState.getOrCreateUserState(userId);     // Catch: Throwable -> L26
        UidPermissionState uidState = userState.getUidState(previousAppId);     // Catch: Throwable -> L26
        if (uidState != null) goto L11;
        int[] r16 = r0;
        PackageStateInternal ps2 = ps;
        int r18 = r4;
        int r19 = r6;
    L73:
        r4 = r18 + 1;     // Catch: Throwable -> L24
        r0 = r16;
        ps = ps2;
        r6 = r19;
    L24:
        th = th;
    L36:
        monitor-exit(r5);     // Catch: Throwable -> L24
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L11:
        UidPermissionState sharedUidState = userState.getUidState(ps.getAppId());     // Catch: Throwable -> L26
        if (sharedUidState == null) goto L69;
        List<PermissionState> states = uidState.getPermissionStates();     // Catch: Throwable -> L26
        int count = states.size();     // Catch: Throwable -> L26
        int i = 0;
    L18:
        if (i >= count) goto L30;
        PermissionState srcState = states.get(i);     // Catch: Throwable -> L26
        PermissionState destState = sharedUidState.getPermissionState(srcState.getName());     // Catch: Throwable -> L26
        if (destState == null) goto L28;
        Pair<Boolean, Integer> newState = mergePermissionState(ps.getAppId(), srcState, destState);     // Catch: Throwable -> L26
        sharedUidState.putPermissionState(srcState.getPermission(), ((Boolean) newState.first).booleanValue(), ((Integer) newState.second).intValue());     // Catch: Throwable -> L24
    L29:
        i = i + 1;     // Catch: Throwable -> L24
        r0 = r0;
        ps = ps;
        r4 = r4;
        r6 = r6;
        goto L18
    L28:
        sharedUidState.putPermissionState(srcState.getPermission(), srcState.isGranted(), srcState.getFlags());     // Catch: Throwable -> L24
        goto L29
    L30:
        r16 = r0;
        ps2 = ps;
        r18 = r4;
        r19 = r6;
    L31:
        userState.removeUidState(previousAppId);     // Catch: Throwable -> L24
        goto L73
    L69:
        userState.createUidStateWithExisting(ps.getAppId(), uidState);     // Catch: Throwable -> L15
        r16 = r0;
        ps2 = ps;
        r18 = r4;
        r19 = r6;
    L15:
        th = th;
        goto L36
    L34:
        monitor-exit(r5);     // Catch: Throwable -> L24
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L26:
        th = th;
        goto L36
    L39:
        List<AndroidPackage> origSharedUserPackages = this.mPackageManagerInt.getPackagesForAppId(previousAppId);
        PackageManagerTracedLock r7 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r7);
        int[] r1 = getAllUserIds();     // Catch: Throwable -> L53
        int r8 = r1.length;     // Catch: Throwable -> L53
    L42:
        if (r4 >= r8) goto L61;
        int userId2 = r1[r4];     // Catch: Throwable -> L53
        UserPermissionState userState2 = this.mState.getUserState(userId2);     // Catch: Throwable -> L53
        if (userState2 == null) goto L57;
        UidPermissionState prevUidState = userState2.getUidState(previousAppId);     // Catch: Throwable -> L53
        if (prevUidState == null) goto L57;
        userState2.createUidStateWithExisting(ps.getAppId(), prevUidState);     // Catch: Throwable -> L53
        if (origSharedUserPackages.isEmpty() == false) goto L56;
        removeUidStateAndResetPackageInstallPermissionsFixed(previousAppId, pkg.getPackageName(), userId2);     // Catch: Throwable -> L53
        goto L57
    L56:
        revokeSharedUserPermissionsForLeavingPackageInternal(pkg, previousAppId, origSharedUserPackages, userId2);     // Catch: Throwable -> L58
    L57:
        r4 = r4 + 1;     // Catch: Throwable -> L58
        goto L42
    L61:
        monitor-exit(r7);     // Catch: Throwable -> L58
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L58:
        th = th;
    L64:
        monitor-exit(r7);     // Catch: Throwable -> L58
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    L53:
        th = th;
        goto L64
    }

    private void onPackageInstalledInternal(AndroidPackage pkg, int previousAppId, PermissionManagerServiceInternal.PackageInstalledParams params, int[] userIds) {
        if (previousAppId == (-1)) goto L5;
        handleAppIdMigration(pkg, previousAppId);
    L5:
        updatePermissions(pkg.getPackageName(), pkg);
        int r0 = userIds.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        int userId = userIds[r1];
        addAllowlistedRestrictedPermissionsInternal(pkg, params.getAllowlistedRestrictedPermissions(), 2, userId);
        grantRequestedPermissionsInternal(pkg, params.getPermissionStates(), userId);
        r1 = r1 + 1;
        goto L6
    }

    private void addAllowlistedRestrictedPermissionsInternal(AndroidPackage pkg, List<String> allowlistedRestrictedPermissions, int flags, int userId) {
        List<String> permissions = getAllowlistedRestrictedPermissionsInternal(pkg, flags, userId);
        if (permissions == null) goto L5;
        ArraySet<String> permissionSet = new ArraySet(permissions);
        permissionSet.addAll(allowlistedRestrictedPermissions);
        List<String> permissions2 = new ArrayList(permissionSet);
    L6:
        setAllowlistedRestrictedPermissionsInternal(pkg, permissions2, flags, userId);
        return;
    L5:
        permissions2 = allowlistedRestrictedPermissions;
        goto L6
    }

    private void onPackageRemovedInternal(AndroidPackage pkg) {
        removeAllPermissionsInternal(pkg);
    }

    private void onPackageUninstalledInternal(String packageName, int appId, PackageState packageState, AndroidPackage pkg, List<AndroidPackage> sharedUserPkgs, int[] userIds) {
        int r1 = 0;
        if (packageState.isSystem() == false) goto L11;
        if (pkg == null) goto L11;
        if (this.mPackageManagerInt.getPackage(packageName) == null) goto L11;
        int r0 = userIds.length;
    L8:
        if (r1 >= r0) goto L10;
        resetRuntimePermissionsInternal(pkg, userIds[r1], true);
        r1 = r1 + 1;
        goto L8
    L10:
        return;
    L11:
        updatePermissions(packageName, null);
        int r2 = userIds.length;
    L12:
        if (r1 >= r2) goto L18;
        int userId = userIds[r1];
        if (sharedUserPkgs.isEmpty() == false) goto L16;
        removeUidStateAndResetPackageInstallPermissionsFixed(appId, packageName, userId);
    L17:
        r1 = r1 + 1;
        goto L12
    L16:
        revokeSharedUserPermissionsForLeavingPackageInternal(pkg, appId, sharedUserPkgs, userId);
        goto L17
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<LegacyPermission> getLegacyPermissions() {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        List<LegacyPermission> legacyPermissions = new ArrayList();     // Catch: Throwable -> L8
        Iterator<Permission> r2 = this.mRegistry.getPermissions().iterator();     // Catch: Throwable -> L8
    L6:
        if (r2.hasNext() == false) goto L10;
        Permission permission = r2.next();     // Catch: Throwable -> L8
        LegacyPermission legacyPermission = new LegacyPermission(permission.getPermissionInfo(), permission.getType(), permission.getUid(), permission.getRawGids());     // Catch: Throwable -> L8
        legacyPermissions.add(legacyPermission);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return legacyPermissions;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Map<String, Set<String>> getAllAppOpPermissionPackages() {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        ArrayMap<String, ArraySet<String>> appOpPermissionPackages = this.mRegistry.getAllAppOpPermissionPackages();     // Catch: Throwable -> L7
        Map<String, Set<String>> deepClone = new ArrayMap();     // Catch: Throwable -> L7
        int appOpPermissionPackagesSize = appOpPermissionPackages.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= appOpPermissionPackagesSize) goto L10;
        String appOpPermission = appOpPermissionPackages.keyAt(i);     // Catch: Throwable -> L7
        ArraySet<String> packageNames = appOpPermissionPackages.valueAt(i);     // Catch: Throwable -> L7
        deepClone.put(appOpPermission, new ArraySet(packageNames));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return deepClone;
    L7:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public LegacyPermissionState getLegacyPermissionState(int appId) {
        PermissionManagerServiceImpl r1 = this;
        LegacyPermissionState legacyState = new LegacyPermissionState();
        PackageManagerTracedLock r4 = r1.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r4);
        int[] userIds = r1.mState.getUserIds();     // Catch: Throwable -> L9
        int r5 = userIds.length;     // Catch: Throwable -> L9
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L17;
        int userId = userIds[r6];     // Catch: Throwable -> L9
        UidPermissionState uidState = r1.getUidStateLocked(appId, userId);     // Catch: Throwable -> L9
        if (uidState != null) goto L11;
        Slog.e(TAG, "Missing permissions state for app ID " + appId + " and user ID " + userId);     // Catch: Throwable -> L9
        int[] userIds2 = userIds;
    L15:
        r6 = r6 + 1;     // Catch: Throwable -> L9
        r1 = this;
        userIds = userIds2;
        goto L5
    L11:
        List<PermissionState> permissionStates = uidState.getPermissionStates();     // Catch: Throwable -> L9
        int permissionStatesSize = permissionStates.size();     // Catch: Throwable -> L9
        int i = 0;
    L12:
        if (i >= permissionStatesSize) goto L14;
        PermissionState permissionState = permissionStates.get(i);     // Catch: Throwable -> L9
        LegacyPermissionState.PermissionState legacyPermissionState = new LegacyPermissionState.PermissionState(permissionState.getName(), permissionState.getPermission().isRuntime(), permissionState.isGranted(), permissionState.getFlags());     // Catch: Throwable -> L9
        legacyState.putPermissionState(legacyPermissionState, userId);     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        userIds = userIds;
        goto L12
    L14:
        userIds2 = userIds;
        goto L15
    L17:
        monitor-exit(r4);     // Catch: Throwable -> L9
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return legacyState;
    L9:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int[] getGidsForUid(int uid) {
        int appId = UserHandle.getAppId(uid);
        int userId = UserHandle.getUserId(uid);
        PackageManagerTracedLock r2 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r2);
        UidPermissionState uidState = getUidStateLocked(appId, userId);     // Catch: Throwable -> L10
        if (uidState != null) goto L12;
        Slog.e(TAG, "Missing permissions state for app ID " + appId + " and user ID " + userId);     // Catch: Throwable -> L10
        int[] r4 = EMPTY_INT_ARRAY;     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r4;
    L12:
        int[] r5 = uidState.computeGids(this.mGlobalGids, userId);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r5;
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public boolean isPermissionsReviewRequired(String packageName, int userId) {
        packageName.getClass();
        return isPermissionsReviewRequiredInternal(packageName, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Set<String> getInstalledPermissions(String packageName) {
        packageName.getClass();
        Set<String> installedPermissions = new ArraySet();
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        Iterator<Permission> r2 = this.mRegistry.getPermissions().iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        Permission permission = r2.next();     // Catch: Throwable -> L10
        if (Objects.equals(permission.getPackageName(), packageName) == false) goto L6;
        installedPermissions.add(permission.getName());     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return installedPermissions;
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Set<String> getGrantedPermissions(String packageName, int userId) {
        packageName.getClass();
        Preconditions.checkArgumentNonNegative(userId, "userId");
        return getGrantedPermissionsInternal(packageName, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public int[] getPermissionGids(String permissionName, int userId) {
        permissionName.getClass();
        Preconditions.checkArgumentNonNegative(userId, "userId");
        return getPermissionGidsInternal(permissionName, userId);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public String[] getAppOpPermissionPackages(String permissionName) {
        permissionName.getClass();
        return getAppOpPermissionPackagesInternal(permissionName);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onStorageVolumeMounted(String volumeUuid, boolean fingerprintChanged) {
        updateAllPermissions(volumeUuid, fingerprintChanged);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void resetRuntimePermissions(AndroidPackage pkg, int userId, boolean restorePregrantedPermissions) {
        pkg.getClass();
        Preconditions.checkArgumentNonNegative(userId, "userId");
        resetRuntimePermissionsInternal(pkg, userId, restorePregrantedPermissions);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void resetRuntimePermissionsForUser(int userId) {
        Preconditions.checkArgumentNonNegative(userId, "userId");
        resetRuntimePermissionsInternal(null, userId, true);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public Permission getPermissionTEMP(String permName) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        Permission r1 = this.mRegistry.getPermission(permName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionInfo> getAllPermissionsWithProtection(int protection) {
        List<PermissionInfo> matchingPermissions = new ArrayList();
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        Iterator<Permission> r2 = this.mRegistry.getPermissions().iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        Permission permission = r2.next();     // Catch: Throwable -> L10
        if (permission.getProtection() != protection) goto L6;
        matchingPermissions.add(permission.generatePermissionInfo(0));     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return matchingPermissions;
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public List<PermissionInfo> getAllPermissionsWithProtectionFlags(int protectionFlags) {
        List<PermissionInfo> matchingPermissions = new ArrayList();
        PackageManagerTracedLock r1 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r1);
        Iterator<Permission> r2 = this.mRegistry.getPermissions().iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        Permission permission = r2.next();     // Catch: Throwable -> L10
        if ((permission.getProtectionFlags() & protectionFlags) != protectionFlags) goto L6;
        matchingPermissions.add(permission.generatePermissionInfo(0));     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return matchingPermissions;
    L10:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onUserCreated(int userId) {
        Preconditions.checkArgumentNonNegative(userId, "userId");
        updateAllPermissions(StorageManager.UUID_PRIVATE_INTERNAL, true);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageAdded(PackageState packageState, boolean isInstantApp, AndroidPackage oldPkg) {
        packageState.getClass();
        AndroidPackage pkg = packageState.getAndroidPackage();
        pkg.getClass();
        onPackageAddedInternal(packageState, pkg, isInstantApp, oldPkg);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageInstalled(AndroidPackage pkg, int previousAppId, PermissionManagerServiceInternal.PackageInstalledParams params, int userId) {
        pkg.getClass();
        params.getClass();
        if (userId >= 0) goto L7;
        if (userId == (-1)) goto L7;
        boolean r3 = false;
    L8:
        Preconditions.checkArgument(r3, "userId");
        if (userId != (-1)) goto L11;
        int[] userIds = getAllUserIds();
    L12:
        onPackageInstalledInternal(pkg, previousAppId, params, userIds);
        return;
    L11:
        userIds = new int[]{userId};
    L7:
        r3 = true;
        goto L8
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageRemoved(AndroidPackage pkg) {
        pkg.getClass();
        onPackageRemovedInternal(pkg);
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void onPackageUninstalled(String packageName, int appId, PackageState packageState, AndroidPackage pkg, List<AndroidPackage> sharedUserPkgs, int userId) {
        packageState.getClass();
        packageName.getClass();
        sharedUserPkgs.getClass();
        if (userId >= 0) goto L7;
        if (userId == (-1)) goto L7;
        boolean r3 = false;
    L8:
        Preconditions.checkArgument(r3, "userId");
        if (userId != (-1)) goto L11;
        int[] r0 = getAllUserIds();
    L12:
        int[] userIds = r0;
        onPackageUninstalledInternal(packageName, appId, packageState, pkg, sharedUserPkgs, userIds);
        return;
    L11:
        r0 = new int[]{userId};
    L7:
        r3 = true;
        goto L8
    }

    @Override // com.android.server.pm.permission.PermissionManagerServiceInterface
    public void setPermissionManagerServiceSmtEx(PermissionManagerServiceSmtEx smtEx) {
        this.mPermissionSmtEx = smtEx;
    }
}
