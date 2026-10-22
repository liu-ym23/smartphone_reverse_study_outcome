package com.android.server.policy;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import android.os.storage.StorageManagerInternal;
import android.provider.DeviceConfig;
import com.android.server.LocalServices;
import com.android.server.pm.pkg.AndroidPackage;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SoftRestrictedPermissionPolicy {
    private static final SoftRestrictedPermissionPolicy DUMMY_POLICY = null;
    private static final int FLAGS_PERMISSION_RESTRICTION_ANY_EXEMPT = 14336;
    private static final HashSet<String> sForcedScopedStorageAppWhitelist = null;

    public abstract boolean mayGrantPermission();

    public SoftRestrictedPermissionPolicy() {
    }

    static {
        DUMMY_POLICY = new AnonymousClass1();
        sForcedScopedStorageAppWhitelist = new HashSet(Arrays.asList(getForcedScopedStorageAppWhitelist()));
    }

    private static int getMinimumTargetSDK(Context context, ApplicationInfo appInfo, UserHandle user) {
        PackageManager pm = context.getPackageManager();
        int minimumTargetSDK = appInfo.targetSdkVersion;
        String[] uidPkgs = pm.getPackagesForUid(appInfo.uid);
        if (uidPkgs == null) goto L13;
        int r3 = uidPkgs.length;
        int r5 = 0;
    L6:
        if (r5 >= r3) goto L13;
        String uidPkg = uidPkgs[r5];
        if (uidPkg.equals(appInfo.packageName) == true) goto L12;
        ApplicationInfo uidPkgInfo = pm.getApplicationInfoAsUser(uidPkg, 0, user);     // Catch: PackageManager.NameNotFoundException -> L11
        minimumTargetSDK = Integer.min(minimumTargetSDK, uidPkgInfo.targetSdkVersion);
    L12:
        r5 = r5 + 1;
    L13:
        return minimumTargetSDK;
    }

    public static SoftRestrictedPermissionPolicy forPermission(Context context, ApplicationInfo appInfo, AndroidPackage pkg, UserHandle user, String permission) {
        final boolean isWhiteListed = false;
        switch(permission.hashCode()) {
            case -406040016: goto L9;
            case 1365911975: goto L6;
            default: goto L11;
        };
    L11:
        byte r4 = -1;
    L12:
        switch(r4) {
            case 0: goto L23;
            case 1: goto L15;
            default: goto L14;
        };
    L15:
        if (appInfo == null) goto L20;
        int flags = context.getPackageManager().getPermissionFlags(permission, appInfo.packageName, user);
        if ((flags & FLAGS_PERMISSION_RESTRICTION_ANY_EXEMPT) == 0) goto L19;
        isWhiteListed = true;
    L19:
        final int flags2 = getMinimumTargetSDK(context, appInfo, user);
    L22:
        return new AnonymousClass3(isWhiteListed, flags2);
    L20:
        isWhiteListed = false;
        flags2 = 0;
        goto L22
    L23:
        if (appInfo == null) goto L32;
        PackageManager pm = context.getPackageManager();
        StorageManagerInternal smInternal = (StorageManagerInternal) LocalServices.getService(StorageManagerInternal.class);
        int flags3 = pm.getPermissionFlags(permission, appInfo.packageName, user);
        if ((flags3 & FLAGS_PERMISSION_RESTRICTION_ANY_EXEMPT) == 0) goto L27;
        boolean isWhiteListed2 = true;
    L28:
        boolean hasLegacyExternalStorage = smInternal.hasLegacyExternalStorage(appInfo.uid);
        boolean hasRequestedLegacyExternalStorage = hasUidRequestedLegacyExternalStorage(appInfo.uid, context);
        boolean hasWriteMediaStorageGrantedForUid = hasWriteMediaStorageGrantedForUid(appInfo.uid, context);
        boolean hasRequestedPreserveLegacyExternalStorage = pkg.hasPreserveLegacyExternalStorage();
        int targetSDK = getMinimumTargetSDK(context, appInfo, user);
        if (isWhiteListed2 == true) goto L31;
        isWhiteListed = true;
    L31:
        boolean isForcedScopedStorage = sForcedScopedStorageAppWhitelist.contains(appInfo.packageName);
        final boolean isForcedScopedStorage2 = isForcedScopedStorage;
        final boolean shouldApplyRestriction = isWhiteListed;
        final boolean isWhiteListed3 = isWhiteListed2;
        final boolean hasLegacyExternalStorage2 = hasLegacyExternalStorage;
        final boolean hasRequestedLegacyExternalStorage2 = hasRequestedLegacyExternalStorage;
        final boolean hasWriteMediaStorageGrantedForUid2 = hasWriteMediaStorageGrantedForUid;
        final boolean hasRequestedPreserveLegacyExternalStorage2 = hasRequestedPreserveLegacyExternalStorage;
        final int targetSDK2 = targetSDK;
    L34:
        return new AnonymousClass2(isWhiteListed3, targetSDK2, shouldApplyRestriction, isForcedScopedStorage2, hasWriteMediaStorageGrantedForUid2, hasLegacyExternalStorage2, hasRequestedLegacyExternalStorage2, hasRequestedPreserveLegacyExternalStorage2);
    L27:
        isWhiteListed2 = false;
        goto L28
    L32:
        isForcedScopedStorage2 = false;
        shouldApplyRestriction = false;
        isWhiteListed3 = false;
        hasLegacyExternalStorage2 = false;
        hasRequestedLegacyExternalStorage2 = false;
        hasWriteMediaStorageGrantedForUid2 = false;
        hasRequestedPreserveLegacyExternalStorage2 = false;
        targetSDK2 = 0;
        goto L34
    L14:
        return DUMMY_POLICY;
    L6:
        if (permission.equals("android.permission.WRITE_EXTERNAL_STORAGE") == false) goto L11;
        r4 = 1;
        goto L12
    L9:
        if (permission.equals("android.permission.READ_EXTERNAL_STORAGE") == false) goto L11;
        r4 = 0;
        goto L12
    }

    private static boolean hasUidRequestedLegacyExternalStorage(int uid, Context context) {
        PackageManager packageManager = context.getPackageManager();
        String[] packageNames = packageManager.getPackagesForUid(uid);
        if (packageNames != null) goto L5;
        return false;
    L5:
        UserHandle user = UserHandle.getUserHandleForUid(uid);
        int r4 = packageNames.length;
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L15;
        String packageName = packageNames[r5];
        ApplicationInfo applicationInfo = packageManager.getApplicationInfoAsUser(packageName, 0, user);     // Catch: PackageManager.NameNotFoundException -> L13
        if (applicationInfo.hasRequestedLegacyExternalStorage() == false) goto L14;
        return true;
    L14:
        r5 = r5 + 1;
        goto L6
    L15:
        return false;
    }

    private static boolean hasWriteMediaStorageGrantedForUid(int uid, Context context) {
        PackageManager packageManager = context.getPackageManager();
        String[] packageNames = packageManager.getPackagesForUid(uid);
        if (packageNames != null) goto L5;
        return false;
    L5:
        int r3 = packageNames.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L12;
        String packageName = packageNames[r4];
        if (packageManager.checkPermission("android.permission.WRITE_MEDIA_STORAGE", packageName) == 0) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private static String[] getForcedScopedStorageAppWhitelist() {
        String rawList = DeviceConfig.getString("storage_native_boot", "forced_scoped_storage_whitelist", "");
        if (rawList == null) goto L10;
        if (rawList.equals("") == true) goto L10;
        return rawList.split(",");
    L10:
        return new String[0];
    }

    public int getExtraAppOpCode() {
        return -1;
    }

    public boolean mayAllowExtraAppOp() {
        return false;
    }

    public boolean mayDenyExtraAppOpIfGranted() {
        return false;
    }
}
