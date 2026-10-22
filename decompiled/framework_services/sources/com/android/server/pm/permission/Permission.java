package com.android.server.pm.permission;

import android.content.pm.PackageManagerInternal;
import android.content.pm.PermissionInfo;
import android.os.UserHandle;
import android.util.Slog;
import com.android.internal.pm.pkg.component.ParsedPermission;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.PackageStateInternal;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes2.dex */
public final class Permission {
    private static final String TAG = "Permission";
    public static final int TYPE_CONFIG = 1;
    public static final int TYPE_DYNAMIC = 2;
    public static final int TYPE_MANIFEST = 0;
    private boolean mDefinitionChanged;
    private int[] mGids;
    private boolean mGidsPerUser;
    private PermissionInfo mPermissionInfo;
    private boolean mReconciled;
    private final int mType;
    private int mUid;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProtectionLevel {
    }

    public Permission(String name, String packageName, int type) {
        this.mGids = EmptyArray.INT;
        this.mPermissionInfo = new PermissionInfo();
        this.mPermissionInfo.name = name;
        this.mPermissionInfo.packageName = packageName;
        this.mPermissionInfo.protectionLevel = 2;
        this.mType = type;
    }

    public Permission(PermissionInfo permissionInfo, int type) {
        this.mGids = EmptyArray.INT;
        this.mPermissionInfo = permissionInfo;
        this.mType = type;
    }

    public Permission(PermissionInfo permissionInfo, int type, boolean reconciled, int uid, int[] gids, boolean gidsPerUser) {
        this(permissionInfo, type);
        this.mReconciled = reconciled;
        this.mUid = uid;
        this.mGids = gids;
        this.mGidsPerUser = gidsPerUser;
    }

    public PermissionInfo getPermissionInfo() {
        return this.mPermissionInfo;
    }

    public void setPermissionInfo(PermissionInfo permissionInfo) {
        if (permissionInfo == null) goto L4;
        this.mPermissionInfo = permissionInfo;
    L5:
        if (permissionInfo == null) goto L7;
        boolean r0 = true;
    L8:
        this.mReconciled = r0;
        return;
    L7:
        r0 = false;
        goto L8
    L4:
        PermissionInfo newPermissionInfo = new PermissionInfo();
        newPermissionInfo.name = this.mPermissionInfo.name;
        newPermissionInfo.packageName = this.mPermissionInfo.packageName;
        newPermissionInfo.protectionLevel = this.mPermissionInfo.protectionLevel;
        this.mPermissionInfo = newPermissionInfo;
        goto L5
    }

    public String getName() {
        return this.mPermissionInfo.name;
    }

    public int getProtectionLevel() {
        return this.mPermissionInfo.protectionLevel;
    }

    public String getPackageName() {
        return this.mPermissionInfo.packageName;
    }

    public int getType() {
        return this.mType;
    }

    public int getUid() {
        return this.mUid;
    }

    public boolean hasGids() {
        if (this.mGids.length == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int[] getRawGids() {
        return this.mGids;
    }

    public boolean areGidsPerUser() {
        return this.mGidsPerUser;
    }

    public void setGids(int[] gids, boolean gidsPerUser) {
        this.mGids = gids;
        this.mGidsPerUser = gidsPerUser;
    }

    public int[] computeGids(int userId) {
        if (this.mGidsPerUser == false) goto L11;
        int[] userGids = new int[this.mGids.length];
        int i = 0;
    L6:
        if (i >= this.mGids.length) goto L9;
        int gid = this.mGids[i];
        userGids[i] = UserHandle.getUid(userId, gid);
        i = i + 1;
        goto L6
    L9:
        return userGids;
    L11:
        if (this.mGids.length == 0) goto L14;
        return (int[]) this.mGids.clone();
    L14:
        return this.mGids;
    }

    public boolean isDefinitionChanged() {
        return this.mDefinitionChanged;
    }

    public void setDefinitionChanged(boolean definitionChanged) {
        this.mDefinitionChanged = definitionChanged;
    }

    public int calculateFootprint(Permission permission) {
        if (this.mUid == permission.mUid) goto L5;
        return 0;
    L5:
        return permission.mPermissionInfo.name.length() + permission.mPermissionInfo.calculateFootprint();
    }

    public boolean isPermission(ParsedPermission parsedPermission) {
        if (this.mPermissionInfo != null) goto L6;
        return false;
    L6:
        if (Objects.equals(this.mPermissionInfo.packageName, parsedPermission.getPackageName()) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(this.mPermissionInfo.name, parsedPermission.getName()) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public boolean isDynamic() {
        if (this.mType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNormal() {
        if ((this.mPermissionInfo.protectionLevel & 15) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isRuntime() {
        if ((this.mPermissionInfo.protectionLevel & 15) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isRemoved() {
        if ((this.mPermissionInfo.flags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSoftRestricted() {
        if ((this.mPermissionInfo.flags & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isHardRestricted() {
        if ((this.mPermissionInfo.flags & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isHardOrSoftRestricted() {
        if ((this.mPermissionInfo.flags & 12) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isImmutablyRestricted() {
        if ((this.mPermissionInfo.flags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSignature() {
        if ((this.mPermissionInfo.protectionLevel & 15) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInternal() {
        if ((this.mPermissionInfo.protectionLevel & 15) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isAppOp() {
        if ((this.mPermissionInfo.protectionLevel & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isDevelopment() {
        if (isSignature() == true) goto L5;
    L7:
        return false;
    L5:
        if ((this.mPermissionInfo.protectionLevel & 32) == 0) goto L7;
        return true;
    }

    public boolean isInstaller() {
        if ((this.mPermissionInfo.protectionLevel & 256) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInstant() {
        if ((this.mPermissionInfo.protectionLevel & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOem() {
        if ((this.mPermissionInfo.protectionLevel & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPre23() {
        if ((this.mPermissionInfo.protectionLevel & 128) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPreInstalled() {
        if ((this.mPermissionInfo.protectionLevel & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPrivileged() {
        if ((this.mPermissionInfo.protectionLevel & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isRuntimeOnly() {
        if ((this.mPermissionInfo.protectionLevel & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSetup() {
        if ((this.mPermissionInfo.protectionLevel & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isVerifier() {
        if ((this.mPermissionInfo.protectionLevel & 512) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isVendorPrivileged() {
        if ((this.mPermissionInfo.protectionLevel & 32768) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSystemTextClassifier() {
        if ((this.mPermissionInfo.protectionLevel & 65536) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isConfigurator() {
        if ((this.mPermissionInfo.protectionLevel & 524288) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isIncidentReportApprover() {
        if ((this.mPermissionInfo.protectionLevel & 1048576) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isAppPredictor() {
        if ((this.mPermissionInfo.protectionLevel & 2097152) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isCompanion() {
        if ((this.mPermissionInfo.protectionLevel & 8388608) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isModule() {
        if ((this.mPermissionInfo.protectionLevel & 4194304) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isRetailDemo() {
        if ((this.mPermissionInfo.protectionLevel & 16777216) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isRecents() {
        if ((this.mPermissionInfo.protectionLevel & 33554432) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isRole() {
        if ((this.mPermissionInfo.protectionLevel & 67108864) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isKnownSigner() {
        if ((this.mPermissionInfo.protectionLevel & 134217728) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Set<String> getKnownCerts() {
        return this.mPermissionInfo.knownCerts;
    }

    public void transfer(String oldPackageName, String newPackageName) {
        if (oldPackageName.equals(this.mPermissionInfo.packageName) == true) goto L5;
        return;
    L5:
        PermissionInfo newPermissionInfo = new PermissionInfo();
        newPermissionInfo.name = this.mPermissionInfo.name;
        newPermissionInfo.packageName = newPackageName;
        newPermissionInfo.protectionLevel = this.mPermissionInfo.protectionLevel;
        this.mPermissionInfo = newPermissionInfo;
        this.mReconciled = false;
        this.mUid = 0;
        this.mGids = EmptyArray.INT;
        this.mGidsPerUser = false;
    }

    public boolean addToTree(int protectionLevel, PermissionInfo permissionInfo, Permission permissionTree) {
        if (this.mPermissionInfo.protectionLevel == protectionLevel) goto L5;
    L14:
        boolean changed = true;
    L15:
        this.mPermissionInfo = new PermissionInfo(permissionInfo);
        this.mPermissionInfo.packageName = permissionTree.mPermissionInfo.packageName;
        this.mPermissionInfo.protectionLevel = protectionLevel;
        this.mReconciled = true;
        this.mUid = permissionTree.mUid;
        return changed;
    L5:
        if (this.mReconciled == false) goto L14;
        if (this.mUid != permissionTree.mUid) goto L14;
        if (Objects.equals(this.mPermissionInfo.packageName, permissionTree.mPermissionInfo.packageName) == false) goto L14;
        if (comparePermissionInfos(this.mPermissionInfo, permissionInfo) == false) goto L14;
        changed = false;
        goto L15
    }

    public void updateDynamicPermission(Collection<Permission> permissionTrees) {
        if (this.mType != 2) goto L8;
        Permission tree = findPermissionTree(permissionTrees, this.mPermissionInfo.name);
        if (tree == null) goto L9;
        PermissionInfo r1 = this.mPermissionInfo;
        r1.packageName = tree.mPermissionInfo.packageName;
        this.mReconciled = true;
        this.mUid = tree.mUid;
        return;
    L9:
        return;
    }

    public static boolean isOverridingSystemPermission(Permission permission, PermissionInfo permissionInfo, PackageManagerInternal packageManagerInternal) {
        if (permission != null) goto L5;
    L15:
        return false;
    L5:
        if (Objects.equals(permission.mPermissionInfo.packageName, permissionInfo.packageName) == true) goto L15;
        if (permission.mReconciled == true) goto L10;
        return false;
    L10:
        PackageStateInternal currentPackageState = packageManagerInternal.getPackageStateInternal(permission.mPermissionInfo.packageName);
        if (currentPackageState != null) goto L14;
        return false;
    L14:
        return currentPackageState.isSystem();
    }

    public static Permission createOrUpdate(Permission permission, PermissionInfo permissionInfo, PackageState packageState, Collection<Permission> permissionTrees, boolean isOverridingSystemPermission) {
        boolean ownerChanged = false;
        if (permission == null) goto L16;
        if (Objects.equals(permission.mPermissionInfo.packageName, permissionInfo.packageName) == true) goto L16;
        if (packageState.isSystem() == false) goto L16;
        if (permission.mType == 1) goto L11;
    L13:
        if (isOverridingSystemPermission == true) goto L16;
        Slog.w(TAG, "New decl " + packageState + " of permission  " + permissionInfo.name + " is system; overriding " + permission.mPermissionInfo.packageName);
        ownerChanged = true;
        permission = null;
        goto L16
    L11:
        if (permission.mReconciled == true) goto L13;
        permission.mPermissionInfo = permissionInfo;
        permission.mReconciled = true;
        permission.mUid = packageState.getAppId();
    L16:
        if (permission != null) goto L18;
    L22:
        boolean wasNonInternal = false;
    L24:
        if (permission != null) goto L26;
    L30:
        boolean wasNonRuntime = false;
    L32:
        if (permission != null) goto L35;
        permission = new Permission(permissionInfo.name, permissionInfo.packageName, 0);
    L35:
        if (permission.mReconciled == true) goto L51;
        if (permission.mPermissionInfo.packageName != null) goto L39;
    L42:
        Permission tree = findPermissionTree(permissionTrees, permissionInfo.name);
        if (tree != null) goto L45;
    L48:
        permission.mPermissionInfo = permissionInfo;
        permission.mReconciled = true;
        permission.mUid = packageState.getAppId();
        goto L51
    L45:
        if (tree.mPermissionInfo.packageName.equals(permissionInfo.packageName) == true) goto L48;
        Slog.w(TAG, "Permission " + permissionInfo.name + " from package " + permissionInfo.packageName + " ignored: base tree " + tree.mPermissionInfo.name + " is from package " + tree.mPermissionInfo.packageName);
        goto L51
    L39:
        if (permission.mPermissionInfo.packageName.equals(permissionInfo.packageName) == true) goto L42;
        Slog.w(TAG, "Permission " + permissionInfo.name + " from package " + permissionInfo.packageName + " ignored: original from " + permission.mPermissionInfo.packageName);
    L51:
        if (permission.isInternal() == false) goto L55;
        if (ownerChanged == true) goto L58;
        if (wasNonInternal == false) goto L55;
    L58:
        permission.mDefinitionChanged = true;
    L59:
        return permission;
    L55:
        if (permission.isRuntime() == false) goto L59;
        if (ownerChanged == true) goto L58;
        if (wasNonRuntime == false) goto L59;
    L26:
        if (permission.mType == 1) goto L30;
        if (permission.isRuntime() == true) goto L30;
        wasNonRuntime = true;
        goto L32
    L18:
        if (permission.mType == 1) goto L22;
        if (permission.isInternal() == true) goto L22;
        wasNonInternal = true;
        goto L24
    }

    public static Permission enforcePermissionTree(Collection<Permission> permissionTrees, String permissionName, int callingUid) {
        if (permissionName == null) goto L9;
        Permission permissionTree = findPermissionTree(permissionTrees, permissionName);
        if (permissionTree == null) goto L9;
        if (permissionTree.getUid() != UserHandle.getAppId(callingUid)) goto L9;
        return permissionTree;
    L9:
        throw new SecurityException("Calling uid " + callingUid + " is not allowed to add to or remove from the permission tree");
    }

    private static Permission findPermissionTree(Collection<Permission> permissionTrees, String permissionName) {
        Iterator<Permission> r0 = permissionTrees.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Permission permissionTree = r0.next();
        String permissionTreeName = permissionTree.getName();
        if (permissionName.startsWith(permissionTreeName) == false) goto L4;
        if (permissionName.length() <= permissionTreeName.length()) goto L4;
        if (permissionName.charAt(permissionTreeName.length()) != '.') goto L4;
        return permissionTree;
    L13:
        return null;
    }

    public String getBackgroundPermission() {
        return this.mPermissionInfo.backgroundPermission;
    }

    public String getGroup() {
        return this.mPermissionInfo.group;
    }

    public int getProtection() {
        return this.mPermissionInfo.protectionLevel & 15;
    }

    public int getProtectionFlags() {
        return this.mPermissionInfo.protectionLevel & 65520;
    }

    public PermissionInfo generatePermissionInfo(int flags) {
        return generatePermissionInfo(flags, 10000);
    }

    public PermissionInfo generatePermissionInfo(int flags, int targetSdkVersion) {
        if (this.mPermissionInfo == null) goto L7;
        PermissionInfo permissionInfo = new PermissionInfo(this.mPermissionInfo);
        if ((flags & 128) == 128) goto L8;
        permissionInfo.metaData = null;
    L8:
        permissionInfo.flags |= 1073741824;
        if (targetSdkVersion < 26) goto L11;
        permissionInfo.protectionLevel = this.mPermissionInfo.protectionLevel;
    L15:
        return permissionInfo;
    L11:
        int protection = this.mPermissionInfo.protectionLevel & 15;
        if (protection != 2) goto L14;
        permissionInfo.protectionLevel = this.mPermissionInfo.protectionLevel;
        goto L15
    L14:
        permissionInfo.protectionLevel = protection;
        goto L15
    L7:
        permissionInfo = new PermissionInfo();
        permissionInfo.name = this.mPermissionInfo.name;
        permissionInfo.packageName = this.mPermissionInfo.packageName;
        permissionInfo.nonLocalizedLabel = this.mPermissionInfo.name;
        goto L8
    }

    private static boolean comparePermissionInfos(PermissionInfo pi1, PermissionInfo pi2) {
        if (pi1.icon == pi2.icon) goto L6;
        return false;
    L6:
        if (pi1.logo == pi2.logo) goto L9;
        return false;
    L9:
        if (pi1.protectionLevel == pi2.protectionLevel) goto L12;
        return false;
    L12:
        if (Objects.equals(pi1.name, pi2.name) == true) goto L15;
        return false;
    L15:
        if (Objects.equals(pi1.nonLocalizedLabel, pi2.nonLocalizedLabel) == true) goto L18;
        return false;
    L18:
        if (Objects.equals(pi1.packageName, pi2.packageName) == true) goto L20;
        return false;
    L20:
        return true;
    }
}
