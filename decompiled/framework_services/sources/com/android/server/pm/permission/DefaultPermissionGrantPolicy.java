package com.android.server.pm.permission;

import android.R;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.permission.PermissionManager;
import android.pico.utils.ExtImplFactory;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.pm.pkg.parsing.ParsingPackageUtils;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.backup.UserBackupManagerService;
import com.android.server.notification.NotificationManagerServiceSmtEx;
import com.obric.utils.ObricImplFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import libcore.util.HexEncoding;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class DefaultPermissionGrantPolicy {
    private static final String ACTION_TRACK = "com.android.fitness.TRACK";
    private static final Set<String> ACTIVITY_RECOGNITION_PERMISSIONS = null;
    private static final Set<String> ALWAYS_LOCATION_PERMISSIONS = null;
    private static final String ATTR_CERT = "cert";
    private static final String ATTR_FIXED = "fixed";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PACKAGE = "package";
    private static final String ATTR_WHITELISTED = "whitelisted";
    private static final String AUDIO_MIME_TYPE = "audio/mpeg";
    private static final Set<String> CALENDAR_PERMISSIONS = null;
    private static final Set<String> CALL_LOG_PERMISSIONS = null;
    private static final Set<String> CAMERA_PERMISSIONS = null;
    private static final Set<String> COARSE_BACKGROUND_LOCATION_PERMISSIONS = null;
    private static final Set<String> CONTACTS_PERMISSIONS = null;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_INTENT_QUERY_FLAGS = 794624;
    protected static final int DEFAULT_PACKAGE_INFO_QUERY_FLAGS = 536915968;
    private static final Set<String> FINE_LOCATION_PERMISSIONS = null;
    private static final Set<String> FOREGROUND_LOCATION_PERMISSIONS = null;
    private static final Set<String> MICROPHONE_PERMISSIONS = null;
    private static final int MSG_READ_DEFAULT_PERMISSION_EXCEPTIONS = 1;
    private static final Set<String> NEARBY_DEVICES_PERMISSIONS = null;
    private static final Set<String> NOTIFICATION_PERMISSIONS = null;
    private static final List<String> NOTIFICATION_PERMISSION_IGNORE_LIST = null;
    private static final Set<String> PHONE_PERMISSIONS = null;
    private static final Set<String> SENSORS_PERMISSIONS = null;
    private static final Set<String> SMS_PERMISSIONS = null;
    private static final Set<String> STORAGE_PERMISSIONS = null;
    private static final String TAG = "DefaultPermGrantPolicy";
    private static final String TAG_EXCEPTION = "exception";
    private static final String TAG_EXCEPTIONS = "exceptions";
    private static final String TAG_PERMISSION = "permission";
    private final PackageManagerWrapper NO_PM_CACHE;
    private final Context mContext;
    private LegacyPermissionManagerInternal.PackagesProvider mDialerAppPackagesProvider;
    private IExtDefaultPermissionGrantPolicy mExt;
    ArrayMap<String, List<DefaultPermissionGrant>> mGrantExceptions;
    private final Handler mHandler;
    private LegacyPermissionManagerInternal.PackagesProvider mLocationExtraPackagesProvider;
    private LegacyPermissionManagerInternal.PackagesProvider mLocationPackagesProvider;
    private final Object mLock;
    private IObricDefaultPermissionGrantPolicy mObricExt;
    private final PackageManagerInternal mServiceInternal;
    private LegacyPermissionManagerInternal.PackagesProvider mSimCallManagerPackagesProvider;
    private LegacyPermissionManagerInternal.PackagesProvider mSmsAppPackagesProvider;
    private DefaultPermissionGrantPolicySmtEx mSmtEx;
    private LegacyPermissionManagerInternal.SyncAdapterPackagesProvider mSyncAdapterPackagesProvider;
    private LegacyPermissionManagerInternal.PackagesProvider mUseOpenWifiAppPackagesProvider;
    private LegacyPermissionManagerInternal.PackagesProvider mVoiceInteractionPackagesProvider;

    static final class DefaultPermissionGrant {
        final boolean fixed;
        final String name;
        final boolean whitelisted;

        public DefaultPermissionGrant(String name, boolean fixed, boolean whitelisted) {
            this.name = name;
            this.fixed = fixed;
            this.whitelisted = whitelisted;
        }
    }

    class DelayingPackageManagerCache extends PackageManagerWrapper {
        private final SparseArray<ArrayMap<String, PermissionState>> mDelayedPermissionState;
        private final ArrayMap<String, PackageInfo> mPackageInfos;
        private final ArrayMap<String, PermissionInfo> mPermissionInfos;
        private final SparseArray<Context> mUserContexts;
        final /* synthetic */ DefaultPermissionGrantPolicy this$0;

        private class PermissionState {
            private Integer mOriginalFlags;
            private Boolean mOriginalGranted;
            private final String mPermission;
            private PackageInfo mPkgRequestingPerm;
            private final UserHandle mUser;
            Integer newFlags;
            Boolean newGranted;
            final /* synthetic */ DelayingPackageManagerCache this$1;

            /* JADX INFO: renamed from: -$$Nest$fgetmPkgRequestingPerm, reason: not valid java name */
            static /* bridge */ /* synthetic */ PackageInfo m7065$$Nest$fgetmPkgRequestingPerm(PermissionState r0) {
                return r0.mPkgRequestingPerm;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmPkgRequestingPerm, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m7066$$Nest$fputmPkgRequestingPerm(PermissionState r0, PackageInfo r1) {
                r0.mPkgRequestingPerm = r1;
            }

            /* synthetic */ PermissionState(DelayingPackageManagerCache r1, String r2, PackageInfo r3, UserHandle r4, DefaultPermissionGrantPolicyIA r5) {
                this(r1, r2, r3, r4);
            }

            private PermissionState(DelayingPackageManagerCache r1, String permission, PackageInfo pkgRequestingPerm, UserHandle user) {
                this.this$1 = r1;
                this.mPermission = permission;
                this.mPkgRequestingPerm = pkgRequestingPerm;
                this.mUser = user;
            }

            void apply() {
                int flagsToAdd = 0;
                if (this.newFlags == null) goto L5;
                flagsToAdd = this.newFlags.intValue() & (~this.mOriginalFlags.intValue());
                int flagsToRemove = this.mOriginalFlags.intValue() & (~this.newFlags.intValue());
                int flagsToRemove2 = flagsToRemove;
            L6:
                if (flagsToRemove2 == 0) goto L9;
                DefaultPermissionGrantPolicy.m7059$$Nest$fgetNO_PM_CACHE(this.this$1.this$0).updatePermissionFlags(this.mPermission, this.mPkgRequestingPerm, flagsToRemove2, 0, this.mUser);
            L9:
                if ((flagsToAdd & 14336) == 0) goto L12;
                int newRestrictionExcemptFlags = flagsToAdd & 14336;
                DefaultPermissionGrantPolicy.m7059$$Nest$fgetNO_PM_CACHE(this.this$1.this$0).updatePermissionFlags(this.mPermission, this.mPkgRequestingPerm, newRestrictionExcemptFlags, -1, this.mUser);
            L12:
                if (this.newGranted == null) goto L22;
                if (Objects.equals(this.newGranted, this.mOriginalGranted) == false) goto L18;
                if (NotificationManagerServiceSmtEx.ASSISTANT_PKG.equals(this.mPkgRequestingPerm.packageName) == false) goto L22;
            L18:
                if (this.newGranted.booleanValue() == false) goto L20;
                DefaultPermissionGrantPolicy.m7059$$Nest$fgetNO_PM_CACHE(this.this$1.this$0).grantPermission(this.mPermission, this.mPkgRequestingPerm, this.mUser);
                goto L22
            L20:
                DefaultPermissionGrantPolicy.m7059$$Nest$fgetNO_PM_CACHE(this.this$1.this$0).revokePermission(this.mPermission, this.mPkgRequestingPerm, this.mUser);
            L22:
                if ((flagsToAdd & (-14337)) == 0) goto L25;
                int newFlags = flagsToAdd & (-14337);
                DefaultPermissionGrantPolicy.m7059$$Nest$fgetNO_PM_CACHE(this.this$1.this$0).updatePermissionFlags(this.mPermission, this.mPkgRequestingPerm, newFlags, -1, this.mUser);
                return;
            L25:
                return;
            L5:
                flagsToRemove2 = 0;
                goto L6
            }

            void initFlags() {
                if (this.newFlags != null) goto L6;
                this.mOriginalFlags = Integer.valueOf(DefaultPermissionGrantPolicy.m7059$$Nest$fgetNO_PM_CACHE(this.this$1.this$0).getPermissionFlags(this.mPermission, this.mPkgRequestingPerm, this.mUser));
                this.newFlags = this.mOriginalFlags;
                return;
            }

            void initGranted() {
                if (this.newGranted == null) goto L5;
                return;
            L5:
                if (DelayingPackageManagerCache.m7064$$Nest$mcreateContextAsUser(this.this$1, this.mUser).getPackageManager().checkPermission(this.mPermission, this.mPkgRequestingPerm.packageName) != 0) goto L7;
                boolean r0 = true;
            L8:
                this.mOriginalGranted = Boolean.valueOf(r0);
                this.newGranted = this.mOriginalGranted;
                return;
            L7:
                r0 = false;
                goto L8
            }
        }

        /* JADX INFO: renamed from: -$$Nest$mcreateContextAsUser, reason: not valid java name */
        static /* bridge */ /* synthetic */ Context m7064$$Nest$mcreateContextAsUser(DelayingPackageManagerCache r0, UserHandle r1) {
            return r0.createContextAsUser(r1);
        }

        DelayingPackageManagerCache(DefaultPermissionGrantPolicy this$0) {
            this.this$0 = this$0;
            super(this$0);
            this.mDelayedPermissionState = new SparseArray();
            this.mUserContexts = new SparseArray();
            this.mPermissionInfos = new ArrayMap();
            this.mPackageInfos = new ArrayMap();
        }

        void apply() {
            PackageManager.corkPackageInfoCache();
            int uidIdx = 0;
        L4:
            if (uidIdx >= this.mDelayedPermissionState.size()) goto L14;
            int permIdx = 0;
        L7:
            if (permIdx >= this.mDelayedPermissionState.valueAt(uidIdx).size()) goto L13;
            this.mDelayedPermissionState.valueAt(uidIdx).valueAt(permIdx).apply();     // Catch: IllegalArgumentException -> L10
        L12:
            permIdx = permIdx + 1;
        L10:
            e = move-exception;
            Slog.w(DefaultPermissionGrantPolicy.TAG, "Cannot set permission " + this.mDelayedPermissionState.valueAt(uidIdx).keyAt(permIdx) + " of uid " + this.mDelayedPermissionState.keyAt(uidIdx), e);
            goto L12
        L13:
            uidIdx = uidIdx + 1;
            goto L4
        L14:
            PackageManager.uncorkPackageInfoCache();
        }

        void addPackageInfo(String packageName, PackageInfo pkg) {
            this.mPackageInfos.put(packageName, pkg);
        }

        private Context createContextAsUser(UserHandle user) {
            int index = this.mUserContexts.indexOfKey(user.getIdentifier());
            if (index >= 0) goto L5;
            Context uc = DefaultPermissionGrantPolicy.m7060$$Nest$fgetmContext(this.this$0).createContextAsUser(user, 0);
            this.mUserContexts.put(user.getIdentifier(), uc);
            return uc;
        L5:
            return this.mUserContexts.valueAt(index);
        }

        private PermissionState getPermissionState(String permission, PackageInfo pkg, UserHandle user) {
            int uid = UserHandle.getUid(user.getIdentifier(), UserHandle.getAppId(pkg.applicationInfo.uid));
            int uidIdx = this.mDelayedPermissionState.indexOfKey(uid);
            if (uidIdx < 0) goto L5;
            ArrayMap<String, PermissionState> uidState = this.mDelayedPermissionState.valueAt(uidIdx);
        L6:
            int permIdx = uidState.indexOfKey(permission);
            if (permIdx < 0) goto L14;
            PermissionState permState = uidState.valueAt(permIdx);
            if (ArrayUtils.contains(PermissionState.m7065$$Nest$fgetmPkgRequestingPerm(permState).requestedPermissions, permission) == true) goto L16;
            if (ArrayUtils.contains(pkg.requestedPermissions, permission) == false) goto L16;
            PermissionState.m7066$$Nest$fputmPkgRequestingPerm(permState, pkg);
        L16:
            return permState;
        L14:
            PermissionState permState2 = new PermissionState(this, permission, pkg, user, null);
            uidState.put(permission, permState2);
            return permState2;
        L5:
            uidState = new ArrayMap();
            this.mDelayedPermissionState.put(uid, uidState);
            goto L6
        }

        @Override // com.android.server.pm.permission.DefaultPermissionGrantPolicy.PackageManagerWrapper
        public int getPermissionFlags(String permission, PackageInfo pkg, UserHandle user) {
            PermissionState state = getPermissionState(permission, pkg, user);
            state.initFlags();
            return state.newFlags.intValue();
        }

        @Override // com.android.server.pm.permission.DefaultPermissionGrantPolicy.PackageManagerWrapper
        public void updatePermissionFlags(String permission, PackageInfo pkg, int flagMask, int flagValues, UserHandle user) {
            PermissionState state = getPermissionState(permission, pkg, user);
            state.initFlags();
            state.newFlags = Integer.valueOf((state.newFlags.intValue() & (~flagMask)) | (flagValues & flagMask));
        }

        @Override // com.android.server.pm.permission.DefaultPermissionGrantPolicy.PackageManagerWrapper
        public void grantPermission(String permission, PackageInfo pkg, UserHandle user) {
            PermissionState state = getPermissionState(permission, pkg, user);
            state.initGranted();
            state.newGranted = true;
        }

        @Override // com.android.server.pm.permission.DefaultPermissionGrantPolicy.PackageManagerWrapper
        public void revokePermission(String permission, PackageInfo pkg, UserHandle user) {
            PermissionState state = getPermissionState(permission, pkg, user);
            state.initGranted();
            state.newGranted = false;
        }

        @Override // com.android.server.pm.permission.DefaultPermissionGrantPolicy.PackageManagerWrapper
        public boolean isGranted(String permission, PackageInfo pkg, UserHandle user) {
            PermissionState state = getPermissionState(permission, pkg, user);
            state.initGranted();
            return state.newGranted.booleanValue();
        }

        @Override // com.android.server.pm.permission.DefaultPermissionGrantPolicy.PackageManagerWrapper
        public PermissionInfo getPermissionInfo(String permissionName) {
            int index = this.mPermissionInfos.indexOfKey(permissionName);
            if (index >= 0) goto L5;
            PermissionInfo pi = DefaultPermissionGrantPolicy.m7059$$Nest$fgetNO_PM_CACHE(this.this$0).getPermissionInfo(permissionName);
            this.mPermissionInfos.put(permissionName, pi);
            return pi;
        L5:
            return this.mPermissionInfos.valueAt(index);
        }

        @Override // com.android.server.pm.permission.DefaultPermissionGrantPolicy.PackageManagerWrapper
        public PackageInfo getPackageInfo(String pkg) {
            int index = this.mPackageInfos.indexOfKey(pkg);
            if (index >= 0) goto L5;
            PackageInfo pi = DefaultPermissionGrantPolicy.m7059$$Nest$fgetNO_PM_CACHE(this.this$0).getPackageInfo(pkg);
            this.mPackageInfos.put(pkg, pi);
            return pi;
        L5:
            return this.mPackageInfos.valueAt(index);
        }
    }

    protected abstract class PackageManagerWrapper {
        final /* synthetic */ DefaultPermissionGrantPolicy this$0;

        abstract PackageInfo getPackageInfo(String r1);

        abstract int getPermissionFlags(String r1, PackageInfo r2, UserHandle r3);

        abstract PermissionInfo getPermissionInfo(String r1);

        abstract void grantPermission(String r1, PackageInfo r2, UserHandle r3);

        abstract boolean isGranted(String r1, PackageInfo r2, UserHandle r3);

        abstract void revokePermission(String r1, PackageInfo r2, UserHandle r3);

        abstract void updatePermissionFlags(String r1, PackageInfo r2, int r3, int r4, UserHandle r5);

        protected PackageManagerWrapper(DefaultPermissionGrantPolicy this$0) {
            this.this$0 = this$0;
        }

        PackageInfo getSystemPackageInfo(String pkg) {
            PackageInfo pi = getPackageInfo(pkg);
            if (pi != null) goto L5;
            return null;
        L5:
            if (pi.applicationInfo.isSystemApp() == false) goto L10;
            return pi;
        L10:
            return null;
        }

        boolean isPermissionRestricted(String name) {
            PermissionInfo pi = getPermissionInfo(name);
            if (pi != null) goto L7;
            return false;
        L7:
            return pi.isRestricted();
        }

        boolean isPermissionDangerous(String name) {
            PermissionInfo pi = getPermissionInfo(name);
            if (pi != null) goto L6;
            return false;
        L6:
            if (pi.getProtection() == 1) goto L8;
            return false;
        L8:
            return true;
        }

        String getBackgroundPermission(String permission) {
            PermissionInfo pi = getPermissionInfo(permission);
            if (pi != null) goto L7;
            return null;
        L7:
            return pi.backgroundPermission;
        }

        boolean isSystemPackage(String packageName) {
            return isSystemPackage(getPackageInfo(packageName));
        }

        boolean isSystemPackage(PackageInfo pkg) {
            if (pkg != null) goto L6;
            return false;
        L6:
            if (pkg.applicationInfo.isSystemApp() == true) goto L8;
            return false;
        L8:
            if (isSysComponentOrPersistentPlatformSignedPrivApp(pkg) == true) goto L13;
            return true;
        L13:
            return false;
        }

        boolean isSysComponentOrPersistentPlatformSignedPrivApp(PackageInfo pkg) {
            if (UserHandle.getAppId(pkg.applicationInfo.uid) >= 10000) goto L7;
            return true;
        L7:
            if (pkg.applicationInfo.isPrivilegedApp() == true) goto L9;
            return false;
        L9:
            PackageInfo disabledPkg = getSystemPackageInfo(DefaultPermissionGrantPolicy.m7062$$Nest$fgetmServiceInternal(this.this$0).getDisabledSystemPackageName(pkg.applicationInfo.packageName));
            if (disabledPkg == null) goto L18;
            ApplicationInfo disabledPackageAppInfo = disabledPkg.applicationInfo;
            if (disabledPackageAppInfo == null) goto L21;
            if ((disabledPackageAppInfo.flags & 8) != 0) goto L21;
            return false;
        L21:
            return DefaultPermissionGrantPolicy.m7062$$Nest$fgetmServiceInternal(this.this$0).isPlatformSigned(pkg.packageName);
        L18:
            if ((pkg.applicationInfo.flags & 8) != 0) goto L21;
            return false;
        }
    }

    public static /* synthetic */ String[] $r8$lambda$Q4LzWikX6zxK3xvemQsgFNMUZL4(int r0) {
        return lambda$grantRuntimePermissions$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetNO_PM_CACHE, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerWrapper m7059$$Nest$fgetNO_PM_CACHE(DefaultPermissionGrantPolicy r0) {
        return r0.NO_PM_CACHE;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7060$$Nest$fgetmContext(DefaultPermissionGrantPolicy r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7061$$Nest$fgetmLock(DefaultPermissionGrantPolicy r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerInternal m7062$$Nest$fgetmServiceInternal(DefaultPermissionGrantPolicy r0) {
        return r0.mServiceInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$mreadDefaultPermissionExceptionsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m7063$$Nest$mreadDefaultPermissionExceptionsLocked(DefaultPermissionGrantPolicy r0, PackageManagerWrapper r1) {
        return r0.readDefaultPermissionExceptionsLocked(r1);
    }

    static {
        PHONE_PERMISSIONS = new ArraySet();
        PHONE_PERMISSIONS.add("android.permission.READ_PHONE_STATE");
        PHONE_PERMISSIONS.add("android.permission.CALL_PHONE");
        PHONE_PERMISSIONS.add("android.permission.READ_CALL_LOG");
        PHONE_PERMISSIONS.add("android.permission.WRITE_CALL_LOG");
        PHONE_PERMISSIONS.add("com.android.voicemail.permission.ADD_VOICEMAIL");
        PHONE_PERMISSIONS.add("android.permission.USE_SIP");
        PHONE_PERMISSIONS.add("android.permission.PROCESS_OUTGOING_CALLS");
        CONTACTS_PERMISSIONS = new ArraySet();
        CONTACTS_PERMISSIONS.add("android.permission.READ_CONTACTS");
        CONTACTS_PERMISSIONS.add("android.permission.WRITE_CONTACTS");
        CONTACTS_PERMISSIONS.add("android.permission.GET_ACCOUNTS");
        CALL_LOG_PERMISSIONS = new ArraySet();
        CALL_LOG_PERMISSIONS.add("android.permission.READ_CALL_LOG");
        CALL_LOG_PERMISSIONS.add("android.permission.WRITE_CALL_LOG");
        ALWAYS_LOCATION_PERMISSIONS = new ArraySet();
        ALWAYS_LOCATION_PERMISSIONS.add("android.permission.ACCESS_FINE_LOCATION");
        ALWAYS_LOCATION_PERMISSIONS.add("android.permission.ACCESS_COARSE_LOCATION");
        ALWAYS_LOCATION_PERMISSIONS.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        FOREGROUND_LOCATION_PERMISSIONS = new ArraySet();
        FOREGROUND_LOCATION_PERMISSIONS.add("android.permission.ACCESS_FINE_LOCATION");
        FOREGROUND_LOCATION_PERMISSIONS.add("android.permission.ACCESS_COARSE_LOCATION");
        COARSE_BACKGROUND_LOCATION_PERMISSIONS = new ArraySet();
        COARSE_BACKGROUND_LOCATION_PERMISSIONS.add("android.permission.ACCESS_COARSE_LOCATION");
        COARSE_BACKGROUND_LOCATION_PERMISSIONS.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        FINE_LOCATION_PERMISSIONS = new ArraySet();
        FINE_LOCATION_PERMISSIONS.add("android.permission.ACCESS_FINE_LOCATION");
        ACTIVITY_RECOGNITION_PERMISSIONS = new ArraySet();
        ACTIVITY_RECOGNITION_PERMISSIONS.add("android.permission.ACTIVITY_RECOGNITION");
        CALENDAR_PERMISSIONS = new ArraySet();
        CALENDAR_PERMISSIONS.add("android.permission.READ_CALENDAR");
        CALENDAR_PERMISSIONS.add("android.permission.WRITE_CALENDAR");
        SMS_PERMISSIONS = new ArraySet();
        SMS_PERMISSIONS.add("android.permission.SEND_SMS");
        SMS_PERMISSIONS.add("android.permission.RECEIVE_SMS");
        SMS_PERMISSIONS.add("android.permission.READ_SMS");
        SMS_PERMISSIONS.add("android.permission.RECEIVE_WAP_PUSH");
        SMS_PERMISSIONS.add("android.permission.RECEIVE_MMS");
        SMS_PERMISSIONS.add("android.permission.READ_CELL_BROADCASTS");
        MICROPHONE_PERMISSIONS = new ArraySet();
        MICROPHONE_PERMISSIONS.add("android.permission.RECORD_AUDIO");
        CAMERA_PERMISSIONS = new ArraySet();
        CAMERA_PERMISSIONS.add("android.permission.CAMERA");
        SENSORS_PERMISSIONS = new ArraySet();
        SENSORS_PERMISSIONS.add("android.permission.BODY_SENSORS");
        SENSORS_PERMISSIONS.add("android.permission.BODY_SENSORS_BACKGROUND");
        SENSORS_PERMISSIONS.add("android.permission.health.READ_HEART_RATE");
        SENSORS_PERMISSIONS.add("android.permission.health.READ_HEALTH_DATA_IN_BACKGROUND");
        STORAGE_PERMISSIONS = new ArraySet();
        STORAGE_PERMISSIONS.add("android.permission.READ_EXTERNAL_STORAGE");
        STORAGE_PERMISSIONS.add("android.permission.WRITE_EXTERNAL_STORAGE");
        STORAGE_PERMISSIONS.add("android.permission.ACCESS_MEDIA_LOCATION");
        STORAGE_PERMISSIONS.add("android.permission.READ_MEDIA_AUDIO");
        STORAGE_PERMISSIONS.add("android.permission.READ_MEDIA_VIDEO");
        STORAGE_PERMISSIONS.add("android.permission.READ_MEDIA_IMAGES");
        STORAGE_PERMISSIONS.add("android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
        NEARBY_DEVICES_PERMISSIONS = new ArraySet();
        NEARBY_DEVICES_PERMISSIONS.add("android.permission.BLUETOOTH_ADVERTISE");
        NEARBY_DEVICES_PERMISSIONS.add("android.permission.BLUETOOTH_CONNECT");
        NEARBY_DEVICES_PERMISSIONS.add("android.permission.BLUETOOTH_SCAN");
        NEARBY_DEVICES_PERMISSIONS.add("android.permission.UWB_RANGING");
        NEARBY_DEVICES_PERMISSIONS.add("android.permission.NEARBY_WIFI_DEVICES");
        NEARBY_DEVICES_PERMISSIONS.add("android.permission.RANGING");
        NOTIFICATION_PERMISSIONS = new ArraySet();
        NOTIFICATION_PERMISSIONS.add("android.permission.POST_NOTIFICATIONS");
        NOTIFICATION_PERMISSION_IGNORE_LIST = Arrays.asList(new String[]{"com.qualcomm.qti.smq"});
    }

    DefaultPermissionGrantPolicy(Context context) {
        this.mLock = new Object();
        this.NO_PM_CACHE = new AnonymousClass1(this);
        this.mObricExt = (IObricDefaultPermissionGrantPolicy) ObricImplFactory.getImpl(IObricDefaultPermissionGrantPolicy.class, new Object[]{this});
        this.mSmtEx = new DefaultPermissionGrantPolicySmtEx(this);
        this.mExt = (IExtDefaultPermissionGrantPolicy) ExtImplFactory.getImpl(IExtDefaultPermissionGrantPolicy.class, new Object[]{this});
        this.mContext = context;
        ServiceThread r0 = new ServiceThread(TAG, 10, true);
        r0.start();
        final Looper r2 = r0.getLooper();
        this.mHandler = new AnonymousClass2(this, r2);
        this.mServiceInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
    }

    public void setLocationPackagesProvider(LegacyPermissionManagerInternal.PackagesProvider provider) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLocationPackagesProvider = provider;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setLocationExtraPackagesProvider(LegacyPermissionManagerInternal.PackagesProvider provider) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLocationExtraPackagesProvider = provider;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setVoiceInteractionPackagesProvider(LegacyPermissionManagerInternal.PackagesProvider provider) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mVoiceInteractionPackagesProvider = provider;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setSmsAppPackagesProvider(LegacyPermissionManagerInternal.PackagesProvider provider) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSmsAppPackagesProvider = provider;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setDialerAppPackagesProvider(LegacyPermissionManagerInternal.PackagesProvider provider) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDialerAppPackagesProvider = provider;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setSimCallManagerPackagesProvider(LegacyPermissionManagerInternal.PackagesProvider provider) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSimCallManagerPackagesProvider = provider;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setUseOpenWifiAppPackagesProvider(LegacyPermissionManagerInternal.PackagesProvider provider) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUseOpenWifiAppPackagesProvider = provider;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setSyncAdapterPackagesProvider(LegacyPermissionManagerInternal.SyncAdapterPackagesProvider provider) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSyncAdapterPackagesProvider = provider;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void grantDefaultPermissions(int userId) {
        DelayingPackageManagerCache pm = new DelayingPackageManagerCache(this);
        grantPermissionsToSysComponentsAndPrivApps(pm, userId);
        grantDefaultSystemHandlerPermissions(pm, userId);
        grantSignatureAppsNotificationPermissions(pm, userId);
        grantDefaultPermissionExceptions(pm, userId);
        getSmtEx().grantSmtDefaultPermissions(this.mServiceInternal, this.mContext, pm, userId);
        pm.apply();
    }

    private void grantSignatureAppsNotificationPermissions(PackageManagerWrapper pm, int userId) {
        Log.i(TAG, "Granting Notification permissions to platform signature apps for user " + userId);
        List<PackageInfo> packages = this.mContext.getPackageManager().getInstalledPackagesAsUser(DEFAULT_PACKAGE_INFO_QUERY_FLAGS, 0);
        Iterator<PackageInfo> r1 = packages.iterator();
    L4:
        if (r1.hasNext() == false) goto L15;
        PackageInfo pkg = r1.next();
        if (pkg == null) goto L4;
        if (pkg.applicationInfo.isSystemApp() == false) goto L4;
        if (pkg.applicationInfo.isSignedWithPlatformKey() == false) goto L4;
        if (NOTIFICATION_PERMISSION_IGNORE_LIST.contains(pkg.packageName) == true) goto L4;
        grantRuntimePermissionsForSystemPackage(pm, userId, pkg, NOTIFICATION_PERMISSIONS);
        goto L4
    }

    private void grantRuntimePermissionsForSystemPackage(PackageManagerWrapper pm, int userId, PackageInfo pkg) {
        grantRuntimePermissionsForSystemPackage(pm, userId, pkg, null);
    }

    private void grantRuntimePermissionsForSystemPackage(PackageManagerWrapper pm, int userId, PackageInfo pkg, Set<String> filterPermissions) {
        if (ArrayUtils.isEmpty(pkg.requestedPermissions) == false) goto L5;
        return;
    L5:
        Set<String> permissions = new ArraySet();
        String[] r0 = pkg.requestedPermissions;
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L18;
        String permission = r0[r2];
        PermissionInfo perm = pm.getPermissionInfo(permission);
        if (perm == null) goto L16;
        if (filterPermissions == null) goto L14;
        if (filterPermissions.contains(permission) == false) goto L16;
    L14:
        if (perm.isRuntime() == false) goto L16;
        permissions.add(permission);
    L16:
        r2 = r2 + 1;
        goto L6
    L18:
        if (permissions.isEmpty() == true) goto L21;
        grantRuntimePermissions(pm, pkg, permissions, true, userId);
        return;
    }

    public void scheduleReadDefaultPermissionExceptions() {
        this.mHandler.sendEmptyMessage(1);
    }

    private void grantPermissionsToSysComponentsAndPrivApps(DelayingPackageManagerCache pm, int userId) {
        Log.i(TAG, "Granting permissions to platform components for user " + userId);
        List<PackageInfo> packages = this.mContext.getPackageManager().getInstalledPackagesAsUser(DEFAULT_PACKAGE_INFO_QUERY_FLAGS, 0);
        Iterator<PackageInfo> r1 = packages.iterator();
    L4:
        if (r1.hasNext() == false) goto L16;
        PackageInfo pkg = r1.next();
        if (pkg == null) goto L4;
        pm.addPackageInfo(pkg.packageName, pkg);
        if (pm.isSysComponentOrPersistentPlatformSignedPrivApp(pkg) == false) goto L4;
        if (doesPackageSupportRuntimePermissions(pkg) == false) goto L4;
        if (ArrayUtils.isEmpty(pkg.requestedPermissions) == true) goto L4;
        grantRuntimePermissionsForSystemPackage(pm, userId, pkg);
        goto L4
    L16:
        Iterator<PackageInfo> r2 = packages.iterator();
    L18:
        if (r2.hasNext() == false) goto L38;
        PackageInfo pkg2 = r2.next();
        if (pkg2 == null) goto L18;
        if (doesPackageSupportRuntimePermissions(pkg2) == false) goto L18;
        if (ArrayUtils.isEmpty(pkg2.requestedPermissions) == true) goto L18;
        if (pm.isGranted("android.permission.READ_PRIVILEGED_PHONE_STATE", pkg2, UserHandle.of(userId)) == false) goto L18;
        if (pm.isGranted("android.permission.READ_PHONE_STATE", pkg2, UserHandle.of(userId)) == false) goto L18;
        if (pm.isSysComponentOrPersistentPlatformSignedPrivApp(pkg2) == true) goto L18;
        pm.updatePermissionFlags("android.permission.READ_PHONE_STATE", pkg2, 16, 0, UserHandle.of(userId));
        goto L18
    }

    @SafeVarargs
    private final void grantIgnoringSystemPackage(PackageManagerWrapper pm, String packageName, int userId, Set<String>... permissionGroups) {
        grantPermissionsToPackage(pm, packageName, userId, true, true, permissionGroups);
    }

    @SafeVarargs
    private final void grantSystemFixedPermissionsToSystemPackage(PackageManagerWrapper pm, String packageName, int userId, Set<String>... permissionGroups) {
        grantPermissionsToSystemPackage(pm, packageName, userId, true, permissionGroups);
    }

    @SafeVarargs
    private final void grantPermissionsToSystemPackage(PackageManagerWrapper pm, String packageName, int userId, Set<String>... permissionGroups) {
        grantPermissionsToSystemPackage(pm, packageName, userId, false, permissionGroups);
    }

    @SafeVarargs
    private final void grantPermissionsToSystemPackage(PackageManagerWrapper pm, String packageName, int userId, boolean systemFixed, Set<String>... permissionGroups) {
        if (pm.isSystemPackage(packageName) == true) goto L5;
        return;
    L5:
        grantPermissionsToPackage(pm, pm.getSystemPackageInfo(packageName), userId, systemFixed, false, true, permissionGroups);
    }

    @SafeVarargs
    private final void grantPermissionsToPackage(PackageManagerWrapper pm, String packageName, int userId, boolean ignoreSystemPackage, boolean whitelistRestrictedPermissions, Set<String>... permissionGroups) {
        grantPermissionsToPackage(pm, pm.getPackageInfo(packageName), userId, false, ignoreSystemPackage, whitelistRestrictedPermissions, permissionGroups);
    }

    @SafeVarargs
    private final void grantPermissionsToPackage(PackageManagerWrapper pm, PackageInfo packageInfo, int userId, boolean systemFixed, boolean ignoreSystemPackage, boolean whitelistRestrictedPermissions, Set<String>... permissionGroups) {
        if (packageInfo != null) goto L6;
        return;
    L6:
        if (doesPackageSupportRuntimePermissions(packageInfo) == false) goto L11;
        int r1 = permissionGroups.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L13;
        Set<String> permissionGroup = permissionGroups[r2];
        grantRuntimePermissions(pm, packageInfo, permissionGroup, systemFixed, ignoreSystemPackage, whitelistRestrictedPermissions, userId);
        r2 = r2 + 1;
        goto L9
    L13:
        return;
    }

    private void grantDefaultSystemHandlerPermissions(PackageManagerWrapper pm, int userId) {
        Log.i(TAG, "Granting permissions to default platform handlers for user " + userId);
        Object r3 = this.mLock;
        monitor-enter(r3);
        LegacyPermissionManagerInternal.PackagesProvider locationPackagesProvider = this.mLocationPackagesProvider;     // Catch: Throwable -> L116
        LegacyPermissionManagerInternal.PackagesProvider locationExtraPackagesProvider = this.mLocationExtraPackagesProvider;     // Catch: Throwable -> L116
        LegacyPermissionManagerInternal.PackagesProvider voiceInteractionPackagesProvider = this.mVoiceInteractionPackagesProvider;     // Catch: Throwable -> L116
        LegacyPermissionManagerInternal.PackagesProvider smsAppPackagesProvider = this.mSmsAppPackagesProvider;     // Catch: Throwable -> L116
        LegacyPermissionManagerInternal.PackagesProvider dialerAppPackagesProvider = this.mDialerAppPackagesProvider;     // Catch: Throwable -> L116
        LegacyPermissionManagerInternal.PackagesProvider simCallManagerPackagesProvider = this.mSimCallManagerPackagesProvider;     // Catch: Throwable -> L116
        LegacyPermissionManagerInternal.PackagesProvider useOpenWifiAppPackagesProvider = this.mUseOpenWifiAppPackagesProvider;     // Catch: Throwable -> L116
        LegacyPermissionManagerInternal.SyncAdapterPackagesProvider syncAdapterPackagesProvider = this.mSyncAdapterPackagesProvider;     // Catch: Throwable -> L116
        monitor-exit(r3);     // Catch: Throwable -> L116
        if (voiceInteractionPackagesProvider == null) goto L8;
        String[] r4 = voiceInteractionPackagesProvider.getPackages(userId);
    L9:
        String[] voiceInteractPackageNames = r4;
        if (locationPackagesProvider == null) goto L12;
        String[] locationPackageNames = locationPackagesProvider.getPackages(userId);
    L13:
        if (locationExtraPackagesProvider == null) goto L15;
        String[] locationExtraPackageNames = locationExtraPackagesProvider.getPackages(userId);
    L16:
        if (smsAppPackagesProvider == null) goto L18;
        String[] smsAppPackageNames = smsAppPackagesProvider.getPackages(userId);
    L19:
        if (dialerAppPackagesProvider == null) goto L21;
        String[] r16 = dialerAppPackagesProvider.getPackages(userId);
    L22:
        String[] dialerAppPackageNames = r16;
        if (simCallManagerPackagesProvider == null) goto L25;
        String[] r17 = simCallManagerPackagesProvider.getPackages(userId);
    L26:
        String[] simCallManagerPackageNames = r17;
        if (useOpenWifiAppPackagesProvider == null) goto L29;
        String[] r18 = useOpenWifiAppPackagesProvider.getPackages(userId);
    L30:
        String[] useOpenWifiAppPackageNames = r18;
        if (syncAdapterPackagesProvider == null) goto L33;
        String[] contactsSyncAdapterPackages = syncAdapterPackagesProvider.getPackages("com.android.contacts", userId);
    L34:
        if (syncAdapterPackagesProvider == null) goto L36;
        String[] calendarSyncAdapterPackages = syncAdapterPackagesProvider.getPackages("com.android.calendar", userId);
    L37:
        String[] locationPackageNames2 = locationPackageNames;
        String[] locationExtraPackageNames2 = locationExtraPackageNames;
        grantSystemFixedPermissionsToSystemPackage(pm, this.mContext.getPackageManager().getPermissionControllerPackageName(), userId, new Set[]{NOTIFICATION_PERMISSIONS});
        grantSystemFixedPermissionsToSystemPackage(pm, (String) ArrayUtils.firstOrNull(getKnownPackages(2, userId)), userId, new Set[]{STORAGE_PERMISSIONS, NOTIFICATION_PERMISSIONS});
        String verifier = (String) ArrayUtils.firstOrNull(getKnownPackages(4, userId));
        grantSystemFixedPermissionsToSystemPackage(pm, verifier, userId, new Set[]{STORAGE_PERMISSIONS});
        grantPermissionsToSystemPackage(pm, verifier, userId, new Set[]{PHONE_PERMISSIONS, SMS_PERMISSIONS, NOTIFICATION_PERMISSIONS});
        String setupWizardPackage = (String) ArrayUtils.firstOrNull(getKnownPackages(1, userId));
        grantPermissionsToSystemPackage(pm, setupWizardPackage, userId, new Set[]{PHONE_PERMISSIONS, CONTACTS_PERMISSIONS, ALWAYS_LOCATION_PERMISSIONS, CAMERA_PERMISSIONS, NEARBY_DEVICES_PERMISSIONS});
        grantSystemFixedPermissionsToSystemPackage(pm, setupWizardPackage, userId, new Set[]{NOTIFICATION_PERMISSIONS});
        grantPermissionsToSystemPackage(pm, getDefaultSearchSelectorPackage(), userId, new Set[]{NOTIFICATION_PERMISSIONS});
        grantPermissionsToSystemPackage(pm, getDefaultCaptivePortalLoginPackage(), userId, new Set[]{NOTIFICATION_PERMISSIONS});
        grantPermissionsToSystemPackage(pm, getDefaultDockManagerPackage(), userId, new Set[]{NOTIFICATION_PERMISSIONS});
        grantPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackage(pm, "android.media.action.IMAGE_CAPTURE", userId), userId, new Set[]{CAMERA_PERMISSIONS, MICROPHONE_PERMISSIONS, STORAGE_PERMISSIONS});
        grantPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackage(pm, "android.provider.MediaStore.RECORD_SOUND", userId), userId, new Set[]{MICROPHONE_PERMISSIONS});
        grantSystemFixedPermissionsToSystemPackage(pm, getDefaultProviderAuthorityPackage("media", userId), userId, new Set[]{STORAGE_PERMISSIONS, NOTIFICATION_PERMISSIONS});
        grantSystemFixedPermissionsToSystemPackage(pm, getDefaultProviderAuthorityPackage("downloads", userId), userId, new Set[]{STORAGE_PERMISSIONS, NOTIFICATION_PERMISSIONS});
        grantSystemFixedPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackage(pm, "android.intent.action.VIEW_DOWNLOADS", userId), userId, new Set[]{STORAGE_PERMISSIONS});
        grantSystemFixedPermissionsToSystemPackage(pm, getDefaultProviderAuthorityPackage("com.android.externalstorage.documents", userId), userId, new Set[]{STORAGE_PERMISSIONS});
        grantSystemFixedPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackage(pm, "android.credentials.INSTALL", userId), userId, new Set[]{STORAGE_PERMISSIONS});
        if (dialerAppPackageNames != null) goto L40;
        String dialerPackage = getDefaultSystemHandlerActivityPackage(pm, "android.intent.action.DIAL", userId);
        grantDefaultPermissionsToDefaultSystemDialerApp(pm, dialerPackage, userId);
        String[] dialerAppPackageNames2 = dialerAppPackageNames;
    L44:
        if (simCallManagerPackageNames == null) goto L50;
        int r5 = simCallManagerPackageNames.length;
        int r6 = 0;
    L47:
        if (r6 >= r5) goto L50;
        int r19 = r6;
        String simCallManagerPackageName = simCallManagerPackageNames[r19];
        grantDefaultPermissionsToDefaultSystemSimCallManager(pm, simCallManagerPackageName, userId);
        r6 = r19 + 1;
    L50:
        if (useOpenWifiAppPackageNames == null) goto L56;
        int r7 = useOpenWifiAppPackageNames.length;
        int r8 = 0;
    L53:
        if (r8 >= r7) goto L56;
        int r110 = r8;
        String useOpenWifiPackageName = useOpenWifiAppPackageNames[r110];
        grantDefaultPermissionsToDefaultSystemUseOpenWifiApp(pm, useOpenWifiPackageName, userId);
        r8 = r110 + 1;
    L56:
        if (smsAppPackageNames != null) goto L58;
        String smsPackage = getDefaultSystemHandlerActivityPackageForCategory(pm, "android.intent.category.APP_MESSAGING", userId);
        grantDefaultPermissionsToDefaultSystemSmsApp(pm, smsPackage, userId);
    L62:
        grantSystemFixedPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackage(pm, "android.provider.Telephony.SMS_CB_RECEIVED", userId), userId, new Set[]{SMS_PERMISSIONS, NEARBY_DEVICES_PERMISSIONS, NOTIFICATION_PERMISSIONS});
        grantPermissionsToSystemPackage(pm, getDefaultSystemHandlerServicePackage(pm, "android.provider.Telephony.SMS_CARRIER_PROVISION", userId), userId, new Set[]{SMS_PERMISSIONS});
        grantPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackageForCategory(pm, "android.intent.category.APP_CALENDAR", userId), userId, new Set[]{CALENDAR_PERMISSIONS, CONTACTS_PERMISSIONS, NOTIFICATION_PERMISSIONS});
        String calendarProvider = getDefaultProviderAuthorityPackage("com.android.calendar", userId);
        grantPermissionsToSystemPackage(pm, calendarProvider, userId, new Set[]{CONTACTS_PERMISSIONS, STORAGE_PERMISSIONS});
        grantSystemFixedPermissionsToSystemPackage(pm, calendarProvider, userId, new Set[]{CALENDAR_PERMISSIONS});
        if (calendarSyncAdapterPackages == null) goto L66;
        grantPermissionToEachSystemPackage(pm, getHeadlessSyncAdapterPackages(pm, calendarSyncAdapterPackages, userId), userId, new Set[]{CALENDAR_PERMISSIONS});
    L66:
        grantPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackageForCategory(pm, "android.intent.category.APP_CONTACTS", userId), userId, new Set[]{CONTACTS_PERMISSIONS, PHONE_PERMISSIONS});
        if (contactsSyncAdapterPackages == null) goto L69;
        grantPermissionToEachSystemPackage(pm, getHeadlessSyncAdapterPackages(pm, contactsSyncAdapterPackages, userId), userId, new Set[]{CONTACTS_PERMISSIONS});
    L69:
        String contactsProviderPackage = getDefaultProviderAuthorityPackage("com.android.contacts", userId);
        grantSystemFixedPermissionsToSystemPackage(pm, contactsProviderPackage, userId, new Set[]{CONTACTS_PERMISSIONS, PHONE_PERMISSIONS, CALL_LOG_PERMISSIONS});
        grantPermissionsToSystemPackage(pm, contactsProviderPackage, userId, new Set[]{STORAGE_PERMISSIONS});
        grantPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackage(pm, "android.app.action.PROVISION_MANAGED_DEVICE", userId), userId, new Set[]{CONTACTS_PERMISSIONS, NOTIFICATION_PERMISSIONS});
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive", 0) == false) goto L72;
        grantPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackageForCategory(pm, "android.intent.category.APP_MAPS", userId), userId, new Set[]{FOREGROUND_LOCATION_PERMISSIONS});
    L72:
        grantPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackageForCategory(pm, "android.intent.category.APP_EMAIL", userId), userId, new Set[]{CONTACTS_PERMISSIONS, CALENDAR_PERMISSIONS});
        String browserPackage = (String) ArrayUtils.firstOrNull(getKnownPackages(5, userId));
        if (browserPackage != null) goto L77;
        browserPackage = getDefaultSystemHandlerActivityPackageForCategory(pm, "android.intent.category.APP_BROWSER", userId);
        if (pm.isSystemPackage(browserPackage) == true) goto L77;
        browserPackage = null;
    L77:
        String[] locationPackageNames3 = locationPackageNames2;
        String browserPackage2 = browserPackage;
        grantPermissionsToPackage(pm, browserPackage2, userId, false, true, new Set[]{FOREGROUND_LOCATION_PERMISSIONS});
        String browserPackage3 = browserPackage2;
        int r9 = 8;
        if (voiceInteractPackageNames == null) goto L87;
        int r10 = voiceInteractPackageNames.length;
        int r35 = 1;
        int r11 = 0;
    L80:
        if (r11 >= r10) goto L86;
        String voiceInteractPackageName = voiceInteractPackageNames[r11];
        int r37 = r10;
        Set<String>[] r12 = new Set[r9];
        r12[0] = CONTACTS_PERMISSIONS;
        r12[1] = CALENDAR_PERMISSIONS;
        r12[2] = MICROPHONE_PERMISSIONS;
        r12[3] = PHONE_PERMISSIONS;
        r12[4] = SMS_PERMISSIONS;
        r12[5] = COARSE_BACKGROUND_LOCATION_PERMISSIONS;
        r12[6] = NEARBY_DEVICES_PERMISSIONS;
        r12[7] = NOTIFICATION_PERMISSIONS;
        grantPermissionsToSystemPackage(pm, voiceInteractPackageName, userId, r12);
        if (this.mObricExt.isObricAssistant(this.mContext, voiceInteractPackageName) == true) goto L84;
        int r38 = 8;
        revokeRuntimePermissions(pm, voiceInteractPackageName, FINE_LOCATION_PERMISSIONS, false, userId);
    L85:
        r11 = r11 + 1;
        browserPackage3 = browserPackage3;
        r10 = r37;
        r9 = r38;
        goto L80
    L84:
        r38 = 8;
        goto L85
    L86:
        int r39 = r9;
        int r13 = 6;
    L89:
        if (ActivityManager.isLowRamDeviceStatic() == false) goto L91;
        String r14 = getDefaultSystemHandlerActivityPackage(pm, "android.search.action.GLOBAL_SEARCH", userId);
        Set<String>[] r15 = new Set[3];
        r15[0] = MICROPHONE_PERMISSIONS;
        r15[r35] = ALWAYS_LOCATION_PERMISSIONS;
        r15[2] = NOTIFICATION_PERMISSIONS;
        grantPermissionsToSystemPackage(pm, r14, userId, r15);
    L91:
        Intent voiceRecoIntent = new Intent("android.speech.RecognitionService").addCategory("android.intent.category.DEFAULT");
        String r20 = getDefaultSystemHandlerServicePackage(pm, voiceRecoIntent, userId);
        Set<String>[] r21 = new Set[r35];
        r21[0] = MICROPHONE_PERMISSIONS;
        grantPermissionsToSystemPackage(pm, r20, userId, r21);
        if (locationPackageNames3 == null) goto L97;
        int r22 = locationPackageNames3.length;
        int r23 = 0;
    L94:
        if (r23 >= r22) goto L96;
        String packageName = locationPackageNames3[r23];
        int r310 = r13;
        Set<String>[] r24 = new Set[10];
        r24[0] = CONTACTS_PERMISSIONS;
        r24[1] = CALENDAR_PERMISSIONS;
        r24[2] = MICROPHONE_PERMISSIONS;
        r24[3] = PHONE_PERMISSIONS;
        r24[4] = SMS_PERMISSIONS;
        r24[5] = CAMERA_PERMISSIONS;
        r24[r310] = SENSORS_PERMISSIONS;
        r24[7] = STORAGE_PERMISSIONS;
        r24[r39] = NEARBY_DEVICES_PERMISSIONS;
        r24[9] = NOTIFICATION_PERMISSIONS;
        grantPermissionsToSystemPackage(pm, packageName, userId, r24);
        grantSystemFixedPermissionsToSystemPackage(pm, packageName, userId, new Set[]{ALWAYS_LOCATION_PERMISSIONS, ACTIVITY_RECOGNITION_PERMISSIONS});
        r23 = r23 + 1;
        r13 = r310;
        locationPackageNames3 = locationPackageNames3;
        goto L94
    L96:
        int r311 = r13;
    L98:
        if (locationExtraPackageNames2 == null) goto L103;
        int r0 = locationExtraPackageNames2.length;
        int r25 = 0;
    L101:
        if (r25 >= r0) goto L103;
        String packageName2 = locationExtraPackageNames2[r25];
        grantPermissionsToSystemPackage(pm, packageName2, userId, new Set[]{ALWAYS_LOCATION_PERMISSIONS, NEARBY_DEVICES_PERMISSIONS});
        grantSystemFixedPermissionsToSystemPackage(pm, packageName2, userId, new Set[]{ACTIVITY_RECOGNITION_PERMISSIONS});
        r25 = r25 + 1;
        r0 = r0;
    L103:
        Intent musicIntent = new Intent("android.intent.action.VIEW").addCategory("android.intent.category.DEFAULT").setDataAndType(Uri.fromFile(new File("foo.mp3")), AUDIO_MIME_TYPE);
        grantPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackage(pm, musicIntent, userId), userId, new Set[]{STORAGE_PERMISSIONS});
        Intent homeIntent = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME").addCategory("android.intent.category.LAUNCHER_APP");
        grantPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackage(pm, homeIntent, userId), userId, new Set[]{ALWAYS_LOCATION_PERMISSIONS, NOTIFICATION_PERMISSIONS});
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.watch", 0) == false) goto L111;
        String wearPackage = getDefaultSystemHandlerActivityPackageForCategory(pm, "android.intent.category.HOME_MAIN", userId);
        grantPermissionsToSystemPackage(pm, wearPackage, userId, new Set[]{CONTACTS_PERMISSIONS, MICROPHONE_PERMISSIONS, ALWAYS_LOCATION_PERMISSIONS});
        grantSystemFixedPermissionsToSystemPackage(pm, wearPackage, userId, new Set[]{PHONE_PERMISSIONS, ACTIVITY_RECOGNITION_PERMISSIONS});
        if (this.mContext.getResources().getBoolean(R.bool.config_useAutoSuspend) == false) goto L108;
        Log.d(TAG, "Wear: Skipping permission grant for Default fitness tracker app : " + wearPackage);
        char r26 = 0;
    L109:
        String voiceSearchPackage = getDefaultSystemHandlerActivityPackage(pm, "android.search.action.GLOBAL_SEARCH", userId);
        Set<String>[] r27 = new Set[5];
        r27[r26] = PHONE_PERMISSIONS;
        r27[1] = CALENDAR_PERMISSIONS;
        r27[2] = NEARBY_DEVICES_PERMISSIONS;
        r27[3] = COARSE_BACKGROUND_LOCATION_PERMISSIONS;
        r27[4] = CONTACTS_PERMISSIONS;
        grantPermissionsToSystemPackage(pm, voiceSearchPackage, userId, r27);
        revokeRuntimePermissions(pm, voiceSearchPackage, FINE_LOCATION_PERMISSIONS, false, userId);
        goto L111
    L108:
        r26 = 0;
        grantPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackage(pm, ACTION_TRACK, userId), userId, new Set[]{SENSORS_PERMISSIONS});
    L111:
        grantSystemFixedPermissionsToSystemPackage(pm, "com.android.printspooler", userId, new Set[]{ALWAYS_LOCATION_PERMISSIONS, NOTIFICATION_PERMISSIONS});
        grantSystemFixedPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackage(pm, "android.telephony.action.EMERGENCY_ASSISTANCE", userId), userId, new Set[]{CONTACTS_PERMISSIONS, PHONE_PERMISSIONS});
        Intent nfcTagIntent = new Intent("android.intent.action.VIEW").setType("vnd.android.cursor.item/ndef_msg");
        grantPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackage(pm, nfcTagIntent, userId), userId, new Set[]{CONTACTS_PERMISSIONS, PHONE_PERMISSIONS});
        grantSystemFixedPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackage(pm, "android.os.storage.action.MANAGE_STORAGE", userId), userId, new Set[]{STORAGE_PERMISSIONS});
        grantSystemFixedPermissionsToSystemPackage(pm, getDefaultCompanionDeviceManagerPackage(), userId, new Set[]{ALWAYS_LOCATION_PERMISSIONS, NEARBY_DEVICES_PERMISSIONS});
        grantSystemFixedPermissionsToSystemPackage(pm, getDefaultSystemHandlerActivityPackage(pm, "android.intent.action.RINGTONE_PICKER", userId), userId, new Set[]{STORAGE_PERMISSIONS});
        String[] r1 = getKnownPackages(r311, userId);
        int r28 = r1.length;
        int r29 = 0;
    L112:
        if (r29 >= r28) goto L114;
        String textClassifierPackage = r1[r29];
        grantPermissionsToSystemPackage(pm, textClassifierPackage, userId, new Set[]{COARSE_BACKGROUND_LOCATION_PERMISSIONS, CONTACTS_PERMISSIONS});
        r29 = r29 + 1;
        r28 = r28;
        r1 = r1;
        goto L112
    L114:
        grantSystemFixedPermissionsToSystemPackage(pm, UserBackupManagerService.SHARED_BACKUP_AGENT_PACKAGE, userId, new Set[]{STORAGE_PERMISSIONS});
        grantSystemFixedPermissionsToSystemPackage(pm, "com.android.bluetoothmidiservice", userId, new Set[]{NEARBY_DEVICES_PERMISSIONS});
        grantPermissionsToSystemPackage(pm, getDefaultSystemHandlerServicePackage(pm, "android.adservices.AD_SERVICES_COMMON_SERVICE", userId), userId, new Set[]{NOTIFICATION_PERMISSIONS});
        return;
    L97:
        r311 = r13;
        goto L98
    L87:
        r39 = 8;
        r35 = 1;
        r13 = 6;
        goto L89
    L58:
        int r30 = smsAppPackageNames.length;
        int r31 = 0;
    L60:
        if (r31 >= r30) goto L62;
        int r111 = r30;
        String smsPackage2 = smsAppPackageNames[r31];
        grantDefaultPermissionsToDefaultSystemSmsApp(pm, smsPackage2, userId);
        r31 = r31 + 1;
        r30 = r111;
        goto L60
    L40:
        dialerAppPackageNames2 = dialerAppPackageNames;
        int r32 = dialerAppPackageNames2.length;
        int r33 = 0;
    L42:
        if (r33 >= r32) goto L44;
        int r112 = r32;
        String dialerAppPackageName = dialerAppPackageNames2[r33];
        grantDefaultPermissionsToDefaultSystemDialerApp(pm, dialerAppPackageName, userId);
        r33 = r33 + 1;
        r32 = r112;
        goto L42
    L36:
        calendarSyncAdapterPackages = null;
        goto L37
    L33:
        contactsSyncAdapterPackages = null;
        goto L34
    L29:
        r18 = null;
        goto L30
    L25:
        r17 = null;
        goto L26
    L21:
        r16 = null;
        goto L22
    L18:
        smsAppPackageNames = null;
        goto L19
    L15:
        locationExtraPackageNames = null;
        goto L16
    L12:
        locationPackageNames = null;
        goto L13
    L8:
        r4 = null;
    L116:
        th = move-exception;
        throw th;
    }

    private String getDefaultSystemHandlerActivityPackageForCategory(PackageManagerWrapper pm, String category, int userId) {
        return getDefaultSystemHandlerActivityPackage(pm, new Intent("android.intent.action.MAIN").addCategory(category), userId);
    }

    private String getDefaultSearchSelectorPackage() {
        return this.mContext.getString(R.string.config_hdmiCecActiveSourceLostActivity);
    }

    private String getDefaultCaptivePortalLoginPackage() {
        return this.mContext.getString(R.string.config_deviceSpecificInputMethodManagerService);
    }

    private String getDefaultDockManagerPackage() {
        return this.mContext.getString(R.string.config_emergency_dialer_package);
    }

    private String getDefaultCompanionDeviceManagerPackage() {
        return this.mContext.getString(R.string.config_defaultRotationResolverService);
    }

    @SafeVarargs
    private final void grantPermissionToEachSystemPackage(PackageManagerWrapper pm, ArrayList<String> packages, int userId, Set<String>... permissions) {
        if (packages != null) goto L4;
        return;
    L4:
        int count = packages.size();
        int i = 0;
    L5:
        if (i >= count) goto L8;
        grantPermissionsToSystemPackage(pm, packages.get(i), userId, permissions);
        i = i + 1;
        goto L5
    }

    private String[] getKnownPackages(int knownPkgId, int userId) {
        return this.mServiceInternal.getKnownPackageNames(knownPkgId, userId);
    }

    private void grantDefaultPermissionsToDefaultSystemDialerApp(PackageManagerWrapper pm, String dialerPackage, int userId) {
        if (dialerPackage != null) goto L4;
        return;
    L4:
        boolean isPhonePermFixed = this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.watch", 0);
        if (isPhonePermFixed == false) goto L7;
        grantSystemFixedPermissionsToSystemPackage(pm, dialerPackage, userId, new Set[]{PHONE_PERMISSIONS, NOTIFICATION_PERMISSIONS});
    L8:
        grantPermissionsToSystemPackage(pm, dialerPackage, userId, new Set[]{CONTACTS_PERMISSIONS, SMS_PERMISSIONS, MICROPHONE_PERMISSIONS, CAMERA_PERMISSIONS, NOTIFICATION_PERMISSIONS});
        boolean isAndroidAutomotive = this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive", 0);
        if (isAndroidAutomotive == false) goto L12;
        grantPermissionsToSystemPackage(pm, dialerPackage, userId, new Set[]{NEARBY_DEVICES_PERMISSIONS});
        return;
    L12:
        return;
    L7:
        grantPermissionsToSystemPackage(pm, dialerPackage, userId, new Set[]{PHONE_PERMISSIONS});
        goto L8
    }

    private void grantDefaultPermissionsToDefaultSystemSmsApp(PackageManagerWrapper pm, String smsPackage, int userId) {
        grantPermissionsToSystemPackage(pm, smsPackage, userId, new Set[]{PHONE_PERMISSIONS, CONTACTS_PERMISSIONS, SMS_PERMISSIONS, STORAGE_PERMISSIONS, MICROPHONE_PERMISSIONS, CAMERA_PERMISSIONS, NOTIFICATION_PERMISSIONS});
    }

    private void grantDefaultPermissionsToDefaultSystemUseOpenWifiApp(PackageManagerWrapper pm, String useOpenWifiPackage, int userId) {
        grantPermissionsToSystemPackage(pm, useOpenWifiPackage, userId, new Set[]{ALWAYS_LOCATION_PERMISSIONS});
    }

    public void grantDefaultPermissionsToDefaultUseOpenWifiApp(String packageName, int userId) {
        Log.i(TAG, "Granting permissions to default Use Open WiFi app for user:" + userId);
        grantIgnoringSystemPackage(this.NO_PM_CACHE, packageName, userId, new Set[]{ALWAYS_LOCATION_PERMISSIONS});
    }

    public void grantDefaultPermissionsToDefaultSimCallManager(String packageName, int userId) {
        grantDefaultPermissionsToDefaultSimCallManager(this.NO_PM_CACHE, packageName, userId);
    }

    private void grantDefaultPermissionsToDefaultSimCallManager(PackageManagerWrapper pm, String packageName, int userId) {
        if (packageName != null) goto L4;
        return;
    L4:
        Log.i(TAG, "Granting permissions to sim call manager for user:" + userId);
        grantPermissionsToPackage(pm, packageName, userId, false, true, new Set[]{PHONE_PERMISSIONS, MICROPHONE_PERMISSIONS});
    }

    private void grantDefaultPermissionsToDefaultSystemSimCallManager(PackageManagerWrapper pm, String packageName, int userId) {
        if (pm.isSystemPackage(packageName) == false) goto L6;
        grantDefaultPermissionsToDefaultSimCallManager(pm, packageName, userId);
        return;
    }

    public void grantDefaultPermissionsToEnabledCarrierApps(String[] packageNames, int userId) {
        Log.i(TAG, "Granting permissions to enabled carrier apps for user:" + userId);
        if (packageNames != null) goto L5;
        return;
    L5:
        int r0 = packageNames.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        String packageName = packageNames[r2];
        grantPermissionsToSystemPackage(this.NO_PM_CACHE, packageName, userId, new Set[]{PHONE_PERMISSIONS, ALWAYS_LOCATION_PERMISSIONS, SMS_PERMISSIONS});
        r2 = r2 + 1;
        goto L6
    }

    public void grantDefaultPermissionsToEnabledImsServices(String[] packageNames, int userId) {
        Log.i(TAG, "Granting permissions to enabled ImsServices for user:" + userId);
        if (packageNames != null) goto L5;
        return;
    L5:
        int r0 = packageNames.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        String packageName = packageNames[r2];
        grantPermissionsToSystemPackage(this.NO_PM_CACHE, packageName, userId, new Set[]{PHONE_PERMISSIONS, MICROPHONE_PERMISSIONS, ALWAYS_LOCATION_PERMISSIONS, CAMERA_PERMISSIONS, CONTACTS_PERMISSIONS});
        r2 = r2 + 1;
        goto L6
    }

    public void grantDefaultPermissionsToEnabledTelephonyDataServices(String[] packageNames, int userId) {
        Log.i(TAG, "Granting permissions to enabled data services for user:" + userId);
        if (packageNames != null) goto L5;
        return;
    L5:
        int r0 = packageNames.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        String packageName = packageNames[r2];
        grantSystemFixedPermissionsToSystemPackage(this.NO_PM_CACHE, packageName, userId, new Set[]{PHONE_PERMISSIONS, ALWAYS_LOCATION_PERMISSIONS});
        r2 = r2 + 1;
        goto L6
    }

    public void revokeDefaultPermissionsFromDisabledTelephonyDataServices(String[] packageNames, int userId) {
        Log.i(TAG, "Revoking permissions from disabled data services for user:" + userId);
        if (packageNames != null) goto L5;
        return;
    L5:
        int r0 = packageNames.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L14;
        String packageName = packageNames[r1];
        PackageInfo pkg = this.NO_PM_CACHE.getSystemPackageInfo(packageName);
        if (this.NO_PM_CACHE.isSystemPackage(pkg) == true) goto L10;
    L12:
        int userId2 = userId;
    L13:
        r1 = r1 + 1;
        userId = userId2;
        goto L6
    L10:
        if (doesPackageSupportRuntimePermissions(pkg) == false) goto L12;
        userId2 = userId;
        revokeRuntimePermissions(this.NO_PM_CACHE, packageName, PHONE_PERMISSIONS, true, userId2);
        revokeRuntimePermissions(this.NO_PM_CACHE, packageName, ALWAYS_LOCATION_PERMISSIONS, true, userId2);
        goto L13
    }

    public void grantDefaultPermissionsToActiveLuiApp(String packageName, int userId) {
        Log.i(TAG, "Granting permissions to active LUI app for user:" + userId);
        grantSystemFixedPermissionsToSystemPackage(this.NO_PM_CACHE, packageName, userId, new Set[]{CAMERA_PERMISSIONS, NOTIFICATION_PERMISSIONS});
    }

    public void revokeDefaultPermissionsFromLuiApps(String[] packageNames, int userId) {
        Log.i(TAG, "Revoke permissions from LUI apps for user:" + userId);
        if (packageNames != null) goto L5;
        return;
    L5:
        int r0 = packageNames.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L14;
        String packageName = packageNames[r1];
        PackageInfo pkg = this.NO_PM_CACHE.getSystemPackageInfo(packageName);
        if (this.NO_PM_CACHE.isSystemPackage(pkg) == true) goto L10;
    L12:
        int userId2 = userId;
    L13:
        r1 = r1 + 1;
        userId = userId2;
        goto L6
    L10:
        if (doesPackageSupportRuntimePermissions(pkg) == false) goto L12;
        userId2 = userId;
        revokeRuntimePermissions(this.NO_PM_CACHE, packageName, CAMERA_PERMISSIONS, true, userId2);
        goto L13
    }

    public void grantDefaultPermissionsToCarrierServiceApp(String packageName, int userId) {
        Log.i(TAG, "Grant permissions to Carrier Service app " + packageName + " for user:" + userId);
        grantPermissionsToPackage(this.NO_PM_CACHE, packageName, userId, false, true, new Set[]{NOTIFICATION_PERMISSIONS});
    }

    private String getDefaultSystemHandlerActivityPackage(PackageManagerWrapper pm, String intentAction, int userId) {
        return getDefaultSystemHandlerActivityPackage(pm, new Intent(intentAction), userId);
    }

    private String getDefaultSystemHandlerActivityPackage(PackageManagerWrapper pm, Intent intent, int userId) {
        ResolveInfo handler = this.mContext.getPackageManager().resolveActivityAsUser(intent, DEFAULT_INTENT_QUERY_FLAGS, userId);
        if (handler != null) goto L5;
    L14:
        return null;
    L5:
        if (handler.activityInfo == null) goto L14;
        if (this.mServiceInternal.isResolveActivityComponent(handler.activityInfo) == false) goto L10;
        return null;
    L10:
        String packageName = handler.activityInfo.packageName;
        if (pm.isSystemPackage(packageName) == true) goto L13;
        return null;
    L13:
        return packageName;
    }

    private String getDefaultSystemHandlerServicePackage(PackageManagerWrapper pm, String intentAction, int userId) {
        return getDefaultSystemHandlerServicePackage(pm, new Intent(intentAction), userId);
    }

    private String getDefaultSystemHandlerServicePackage(PackageManagerWrapper pm, Intent intent, int userId) {
        List<ResolveInfo> handlers = this.mContext.getPackageManager().queryIntentServicesAsUser(intent, DEFAULT_INTENT_QUERY_FLAGS, userId);
        if (handlers != null) goto L5;
        return null;
    L5:
        int handlerCount = handlers.size();
        int i = 0;
    L6:
        if (i >= handlerCount) goto L12;
        ResolveInfo handler = handlers.get(i);
        String handlerPackage = handler.serviceInfo.packageName;
        if (pm.isSystemPackage(handlerPackage) == true) goto L9;
        i = i + 1;
        goto L6
    L9:
        return handlerPackage;
    L12:
        return null;
    }

    private ArrayList<String> getHeadlessSyncAdapterPackages(PackageManagerWrapper pm, String[] syncAdapterPackageNames, int userId) {
        ArrayList<String> syncAdapterPackages = new ArrayList();
        Intent homeIntent = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
        int r2 = syncAdapterPackageNames.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L11;
        String syncAdapterPackageName = syncAdapterPackageNames[r3];
        homeIntent.setPackage(syncAdapterPackageName);
        ResolveInfo homeActivity = this.mContext.getPackageManager().resolveActivityAsUser(homeIntent, DEFAULT_INTENT_QUERY_FLAGS, userId);
        if (homeActivity != null) goto L10;
        if (pm.isSystemPackage(syncAdapterPackageName) == false) goto L10;
        syncAdapterPackages.add(syncAdapterPackageName);
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        return syncAdapterPackages;
    }

    private String getDefaultProviderAuthorityPackage(String authority, int userId) {
        ProviderInfo provider = this.mContext.getPackageManager().resolveContentProviderAsUser(authority, DEFAULT_INTENT_QUERY_FLAGS, userId);
        if (provider != null) goto L5;
        return null;
    L5:
        return provider.packageName;
    }

    protected void grantRuntimePermissions(PackageManagerWrapper pm, PackageInfo pkg, Set<String> permissions, boolean systemFixed, int userId) {
        grantRuntimePermissions(pm, pkg, permissions, systemFixed, false, true, userId);
    }

    private void revokeRuntimePermissions(PackageManagerWrapper pm, String packageName, Set<String> permissions, boolean systemFixed, int userId) {
        PackageInfo pkg = pm.getSystemPackageInfo(packageName);
        if (pkg == null) goto L26;
        if (ArrayUtils.isEmpty(pkg.requestedPermissions) == true) goto L39;
        Set<String> revokablePermissions = new ArraySet(Arrays.asList(pkg.requestedPermissions));
        Iterator<String> r7 = permissions.iterator();
    L9:
        if (r7.hasNext() == false) goto L24;
        String permission = r7.next();
        if (revokablePermissions.contains(permission) == false) goto L9;
        UserHandle user = UserHandle.of(userId);
        int flags = pm.getPermissionFlags(permission, pm.getPackageInfo(packageName), user);
        if ((flags & 32) == 0) goto L9;
        if ((flags & 4) != 0) goto L9;
        if ((flags & 16) == 0) goto L23;
        if (systemFixed == false) goto L9;
    L23:
        pm.revokePermission(permission, pkg, user);
        pm.updatePermissionFlags(permission, pkg, 32, 0, user);
        goto L9
    L24:
        return;
    L39:
        return;
    }

    private boolean isFixedOrUserSet(int flags) {
        if ((65559 & flags) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    void grantRuntimePermissions(PackageManagerWrapper pm, PackageInfo pkg, Set<String> permissionsWithoutSplits, boolean systemFixed, boolean ignoreSystemPackage, boolean whitelistRestrictedPermissions, int userId) {
        DefaultPermissionGrantPolicy r0 = this;
        PackageManagerWrapper r1 = pm;
        PackageInfo r3 = pkg;
        UserHandle user = UserHandle.of(userId);
        if (r3 != null) goto L5;
        return;
    L5:
        String[] requestedPermissions = r3.requestedPermissions;
        if (ArrayUtils.isEmpty(requestedPermissions) == false) goto L8;
        return;
    L8:
        String[] requestedByNonSystemPackage = r1.getPackageInfo(r3.packageName).requestedPermissions;
        int size = requestedPermissions.length;
        int i = 0;
    L9:
        if (i >= size) goto L14;
        if (ArrayUtils.contains(requestedByNonSystemPackage, requestedPermissions[i]) == true) goto L13;
        requestedPermissions[i] = null;
    L13:
        i = i + 1;
        goto L9
    L14:
        String[] requestedPermissions2 = (String[]) ArrayUtils.filterNotNull(requestedPermissions, new DefaultPermissionGrantPolicy$$ExternalSyntheticLambda0());
        ArraySet<String> permissions = new ArraySet(permissionsWithoutSplits);
        ApplicationInfo applicationInfo = r3.applicationInfo;
        int newFlags = 32;
        if (systemFixed == false) goto L17;
        newFlags = 32 | 16;
    L17:
        List<PermissionManager.SplitPermissionInfo> splitPermissions = ((PermissionManager) r0.mContext.getSystemService(PermissionManager.class)).getSplitPermissions();
        int numSplitPerms = splitPermissions.size();
        int splitPermNum = 0;
    L18:
        if (splitPermNum >= numSplitPerms) goto L28;
        PermissionManager.SplitPermissionInfo splitPerm = splitPermissions.get(splitPermNum);
        if (applicationInfo == null) goto L26;
        int r15 = applicationInfo.targetSdkVersion;
        int newFlags2 = newFlags;
        int newFlags3 = splitPerm.getTargetSdk();
        if (r15 >= newFlags3) goto L27;
        if (permissionsWithoutSplits.contains(splitPerm.getSplitPermission()) == false) goto L27;
        permissions.addAll(splitPerm.getNewPermissions());
    L27:
        splitPermNum = splitPermNum + 1;
        newFlags = newFlags2;
        goto L18
    L26:
        newFlags2 = newFlags;
        goto L27
    L28:
        int newFlags4 = newFlags;
        if (ignoreSystemPackage == true) goto L41;
        if (applicationInfo == null) goto L41;
        if (applicationInfo.isUpdatedSystemApp() == false) goto L41;
        PackageInfo disabledPkg = r1.getSystemPackageInfo(r0.mServiceInternal.getDisabledSystemPackageName(r3.packageName));
        if (disabledPkg == null) goto L41;
        if (ArrayUtils.isEmpty(disabledPkg.requestedPermissions) == false) goto L39;
        return;
    L39:
        if (Arrays.equals(requestedPermissions2, disabledPkg.requestedPermissions) == true) goto L41;
        Set<String> grantablePermissions = new ArraySet(Arrays.asList(requestedPermissions2));
        String[] requestedPermissions3 = disabledPkg.requestedPermissions;
        Set<String> grantablePermissions2 = grantablePermissions;
    L42:
        int numRequestedPermissions = requestedPermissions3.length;
        String[] sortedRequestedPermissions = new String[numRequestedPermissions];
        int numForeground = 0;
        int numForeground2 = 0;
        int numOther = 0;
    L43:
        if (numForeground2 >= numRequestedPermissions) goto L49;
        String[] sortedRequestedPermissions2 = sortedRequestedPermissions;
        String permission = requestedPermissions3[numForeground2];
        if (r1.getBackgroundPermission(permission) == null) goto L47;
        sortedRequestedPermissions2[numForeground] = permission;
        numForeground = numForeground + 1;
    L48:
        numForeground2 = numForeground2 + 1;
        sortedRequestedPermissions = sortedRequestedPermissions2;
        goto L43
    L47:
        sortedRequestedPermissions2[(numRequestedPermissions - 1) - numOther] = permission;
        numOther = numOther + 1;
        goto L48
    L49:
        String[] sortedRequestedPermissions3 = sortedRequestedPermissions;
        int requestedPermissionNum = 0;
    L50:
        if (requestedPermissionNum >= numRequestedPermissions) goto L96;
        int numRequestedPermissions2 = numRequestedPermissions;
        String permission2 = sortedRequestedPermissions3[requestedPermissionNum];
        if (grantablePermissions2 == null) goto L57;
        if (grantablePermissions2.contains(permission2) == true) goto L57;
        int requestedPermissionNum2 = requestedPermissionNum;
        numRequestedPermissions2 = numRequestedPermissions2;
    L94:
        requestedPermissionNum = requestedPermissionNum2 + 1;
        r0 = this;
        r1 = pm;
        r3 = pkg;
        numRequestedPermissions = numRequestedPermissions2;
    L57:
        if (permissions.contains(permission2) == false) goto L93;
        requestedPermissionNum2 = requestedPermissionNum;
        int newFlags5 = r1.getPermissionFlags(permission2, r3, user);
        if (systemFixed == true) goto L61;
    L63:
        boolean changingGrantForSystemFixed = false;
    L65:
        if (r0.isFixedOrUserSet(newFlags5) == false) goto L71;
        if (ignoreSystemPackage == true) goto L71;
        if (changingGrantForSystemFixed == true) goto L71;
        numRequestedPermissions2 = numRequestedPermissions2;
        int newFlags6 = newFlags4;
        newFlags5 = newFlags5;
    L87:
        if ((newFlags5 & 32) != 0) goto L89;
    L92:
        newFlags4 = newFlags6;
        goto L94
    L89:
        if ((newFlags5 & 16) == 0) goto L92;
        if (systemFixed == true) goto L92;
        pm.updatePermissionFlags(permission2, pkg, 16, 0, user);
    L71:
        if ((newFlags5 & 4) == 0) goto L73;
        numRequestedPermissions2 = numRequestedPermissions2;
        goto L94
    L73:
        newFlags6 = newFlags4 | (newFlags5 & 14336);
        if (whitelistRestrictedPermissions == false) goto L79;
        if (r1.isPermissionRestricted(permission2) == false) goto L79;
        r1.updatePermissionFlags(permission2, r3, 4096, 4096, user);
    L79:
        if (changingGrantForSystemFixed == false) goto L81;
        PackageManagerWrapper r2 = pm;
        PackageInfo r4 = pkg;
        r2.updatePermissionFlags(permission2, r4, newFlags5, newFlags5 & (-17), user);
    L83:
        if (r2.isGranted(permission2, r4, user) == true) goto L85;
        r2.grantPermission(permission2, r4, user);
    L85:
        int flagMask = newFlags6 | 64;
        r2.updatePermissionFlags(permission2, r4, flagMask, newFlags6, user);
        goto L87
    L81:
        r2 = pm;
        r4 = pkg;
        goto L83
    L61:
        if ((newFlags5 & 16) == 0) goto L63;
        changingGrantForSystemFixed = true;
        goto L65
    L93:
        requestedPermissionNum2 = requestedPermissionNum;
        numRequestedPermissions2 = numRequestedPermissions2;
        goto L94
    L96:
        return;
    L41:
        requestedPermissions3 = requestedPermissions2;
        grantablePermissions2 = null;
        goto L42
    }

    private static /* synthetic */ String[] lambda$grantRuntimePermissions$0(int x$0) {
        return new String[x$0];
    }

    private void grantDefaultPermissionExceptions(PackageManagerWrapper pm, int userId) {
        DefaultPermissionGrantPolicy r1 = this;
        r1.mHandler.removeMessages(1);
        Object r3 = r1.mLock;
        monitor-enter(r3);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (r1.mGrantExceptions != null) goto L9;
        r1.mGrantExceptions = readDefaultPermissionExceptionsLocked(pm);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r3);     // Catch: Throwable -> L7
        Set<String> permissions = null;
        int exceptionCount = r1.mGrantExceptions.size();
        int i = 0;
    L11:
        if (i >= exceptionCount) goto L24;
        String packageName = r1.mGrantExceptions.keyAt(i);
        PackageInfo pkg = pm.getPackageInfo(packageName);
        List<DefaultPermissionGrant> permissionGrants = r1.mGrantExceptions.valueAt(i);
        int permissionGrantCount = permissionGrants.size();
        int j = 0;
    L13:
        if (j >= permissionGrantCount) goto L22;
        DefaultPermissionGrant permissionGrant = permissionGrants.get(j);
        if (pm.isPermissionDangerous(permissionGrant.name) == true) goto L17;
        Log.w(TAG, "Ignoring permission " + permissionGrant.name + " which isn't dangerous");
    L21:
        j = j + 1;
        r1 = this;
        pm = pm;
        goto L13
    L17:
        if (permissions != null) goto L19;
        Set<String> permissions2 = new ArraySet();
    L20:
        permissions2.add(permissionGrant.name);
        r1.grantRuntimePermissions(pm, pkg, permissions2, permissionGrant.fixed, permissionGrant.whitelisted, true, userId);
        permissions = permissions2;
        goto L21
    L19:
        permissions.clear();
        permissions2 = permissions;
        goto L20
    L22:
        i = i + 1;
        r1 = this;
        goto L11
    }

    private File[] getDefaultPermissionFiles() {
        ArrayList<File> ret = new ArrayList();
        File dir = new File(Environment.getRootDirectory(), "etc/default-permissions");
        if (dir.isDirectory() == true) goto L5;
    L7:
        File dir2 = new File(Environment.getVendorDirectory(), "etc/default-permissions");
        if (dir2.isDirectory() == true) goto L10;
    L12:
        File dir3 = new File(Environment.getOdmDirectory(), "etc/default-permissions");
        if (dir3.isDirectory() == true) goto L15;
    L17:
        File dir4 = new File(Environment.getProductDirectory(), "etc/default-permissions");
        if (dir4.isDirectory() == true) goto L20;
    L22:
        File dir5 = new File(Environment.getSystemExtDirectory(), "etc/default-permissions");
        if (dir5.isDirectory() == true) goto L25;
    L27:
        File dir6 = new File(Environment.getOemDirectory(), "etc/default-permissions");
        if (dir6.isDirectory() == false) goto L33;
        if (dir6.canRead() == false) goto L33;
        Collections.addAll(ret, dir6.listFiles());
    L33:
        if (ret.isEmpty() == false) goto L36;
        return null;
    L36:
        return (File[]) ret.toArray(new File[0]);
    L25:
        if (dir5.canRead() == false) goto L27;
        Collections.addAll(ret, dir5.listFiles());
        goto L27
    L20:
        if (dir4.canRead() == false) goto L22;
        Collections.addAll(ret, dir4.listFiles());
        goto L22
    L15:
        if (dir3.canRead() == false) goto L17;
        Collections.addAll(ret, dir3.listFiles());
        goto L17
    L10:
        if (dir2.canRead() == false) goto L12;
        Collections.addAll(ret, dir2.listFiles());
        goto L12
    L5:
        if (dir.canRead() == false) goto L7;
        Collections.addAll(ret, dir.listFiles());
        goto L7
    }

    private ArrayMap<String, List<DefaultPermissionGrant>> readDefaultPermissionExceptionsLocked(PackageManagerWrapper pm) {
        File[] files = getDefaultPermissionFiles();
        int r1 = 0;
        if (files == null) goto L5;
        ArrayMap<String, List<DefaultPermissionGrant>> grantExceptions = new ArrayMap();
        int r3 = files.length;
    L7:
        if (r1 >= r3) goto L28;
        File file = files[r1];
        if (file.getPath().endsWith(".xml") == true) goto L12;
        Slog.i(TAG, "Non-xml file " + file + " in " + file.getParent() + " directory, ignoring");
    L27:
        r1 = r1 + 1;
        goto L7
    L12:
        if (file.canRead() == true) goto L31;
        Slog.w(TAG, "Default permissions file " + file + " cannot be read");
        goto L27
    L31:
        InputStream str = new FileInputStream(file);     // Catch: Throwable -> L18
        TypedXmlPullParser parser = Xml.resolvePullParser(str);     // Catch: Throwable -> L20
        parse(pm, parser, grantExceptions);     // Catch: Throwable -> L20
        str.close();     // Catch: Throwable -> L18 Throwable -> L18
    L20:
        th = move-exception;
        str.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: Throwable -> L18 Throwable -> L18
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L18 Throwable -> L18
    L18:
        e = move-exception;
        Slog.w(TAG, "Error reading default permissions file " + file, e);
        goto L27
    L28:
        return grantExceptions;
    L5:
        return new ArrayMap(0);
    }

    private void parse(PackageManagerWrapper pm, TypedXmlPullParser parser, Map<String, List<DefaultPermissionGrant>> outGrantExceptions) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L18;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        if (TAG_EXCEPTIONS.equals(parser.getName()) == true) goto L16;
        Log.e(TAG, "Unknown tag " + parser.getName());
        goto L3
    L16:
        parseExceptions(pm, parser, outGrantExceptions);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void parseExceptions(PackageManagerWrapper pm, TypedXmlPullParser parser, Map<String, List<DefaultPermissionGrant>> outGrantExceptions) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L22;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        if (TAG_EXCEPTION.equals(parser.getName()) == true) goto L16;
        Log.e(TAG, "Unknown tag " + parser.getName() + "under <exceptions>");
        goto L3
    L16:
        String packageName = parser.getAttributeValue(null, "package");
        parser.getAttributeValue(null, ATTR_CERT);
        List<DefaultPermissionGrant> packageExceptions = outGrantExceptions.get(packageName);
        if (packageExceptions != null) goto L20;
        packageExceptions = new ArrayList();
        outGrantExceptions.put(packageName, packageExceptions);
    L20:
        parsePermission(parser, packageExceptions);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private void parsePermission(TypedXmlPullParser parser, List<DefaultPermissionGrant> outPackageExceptions) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L24;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        if (TAG_PERMISSION.contains(parser.getName()) == true) goto L16;
        Log.e(TAG, "Unknown tag " + parser.getName() + "under <exception>");
        goto L3
    L16:
        String name = parser.getAttributeValue(null, "name");
        if (name == null) goto L18;
        if (ParsingPackageUtils.getAconfigFlags().skipCurrentElement(null, parser, true) == true) goto L21;
        boolean fixed = parser.getAttributeBoolean(null, ATTR_FIXED, false);
        boolean whitelisted = parser.getAttributeBoolean(null, ATTR_WHITELISTED, false);
        DefaultPermissionGrant exception = new DefaultPermissionGrant(name, fixed, whitelisted);
        outPackageExceptions.add(exception);
        goto L3
    L21:
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L18:
        Log.w(TAG, "Mandatory name attribute missing for permission tag");
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    private boolean isSystemOrCertificateMatchingPackage(PackageInfo pi, String cert) {
        if (cert != null) goto L6;
        return pi.applicationInfo.isSystemApp();
    L6:
        if (Objects.equals(cert, "platform") == false) goto L10;
        return this.mServiceInternal.isPlatformSigned(pi.packageName);
    L10:
        return this.mContext.getPackageManager().hasSigningCertificate(pi.packageName, HexEncoding.decode(cert.replace(":", "")), 1);
    }

    protected static boolean doesPackageSupportRuntimePermissions(PackageInfo pkg) {
        if (pkg.applicationInfo != null) goto L5;
    L7:
        return false;
    L5:
        if (pkg.applicationInfo.targetSdkVersion <= 22) goto L7;
        return true;
    }

    public DefaultPermissionGrantPolicySmtEx getSmtEx() {
        return this.mSmtEx;
    }

    public IExtDefaultPermissionGrantPolicy getExt() {
        return this.mExt;
    }

    public IObricDefaultPermissionGrantPolicy getObricExt() {
        return this.mObricExt;
    }
}
