package com.android.server.pm;

import android.R;
import android.app.doppelganger.DoppelgangerConfigure;
import android.content.pm.PackageManagerInternal;
import android.content.res.Resources;
import android.os.SystemProperties;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.DebugUtils;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.SparseArrayMap;
import com.android.server.LocalServices;
import com.android.server.SystemConfig;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.mutate.PackageStateMutator;
import com.android.server.pm.pkg.mutate.PackageUserStateWrite;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class UserSystemPackageInstaller {
    private static final boolean DEBUG = false;
    static final String PACKAGE_WHITELIST_MODE_PROP = "persist.debug.user.package_whitelist_mode";
    private static final String TAG = null;
    static final int USER_TYPE_PACKAGE_WHITELIST_MODE_DEVICE_DEFAULT = -1;
    public static final int USER_TYPE_PACKAGE_WHITELIST_MODE_DISABLE = 0;
    public static final int USER_TYPE_PACKAGE_WHITELIST_MODE_ENFORCE = 1;
    public static final int USER_TYPE_PACKAGE_WHITELIST_MODE_IGNORE_OTA = 16;
    public static final int USER_TYPE_PACKAGE_WHITELIST_MODE_IMPLICIT_WHITELIST = 4;
    public static final int USER_TYPE_PACKAGE_WHITELIST_MODE_IMPLICIT_WHITELIST_SYSTEM = 8;
    public static final int USER_TYPE_PACKAGE_WHITELIST_MODE_LOG = 2;
    static final int USER_TYPE_PACKAGE_WHITELIST_MODE_NONE = -1000;
    private final UserManagerService mUm;
    private final String[] mUserTypes;
    private final ArrayMap<String, Long> mWhitelistedPackagesForUserTypes;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PackageWhitelistMode {
    }

    /* JADX INFO: renamed from: $r8$lambda$8ii9Gh9XC-2s-XU40Z0_ZIZOK_A, reason: not valid java name */
    public static /* synthetic */ void m7029$r8$lambda$8ii9Gh9XC2sXU40Z0_ZIZOK_A(UserSystemPackageInstaller r0, Set r1, boolean r2, Set r3, PackageStateInternal r4) {
        r0.lambda$getInstallablePackagesForUserType$3(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$VW5g2pfX_-luq6bZ3VSu7ro0HDo, reason: not valid java name */
    public static /* synthetic */ void m7030$r8$lambda$VW5g2pfX_luq6bZ3VSu7ro0HDo(Set r0, int r1, boolean r2, boolean r3, ArraySet r4, SparseArrayMap r5, PackageStateInternal r6) {
        lambda$installWhitelistedSystemPackages$0(r0, r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: $r8$lambda$cEneswMGVtLmubSsW-mI2ixuNwg, reason: not valid java name */
    public static /* synthetic */ void m7031$r8$lambda$cEneswMGVtLmubSsWmI2ixuNwg(SparseArrayMap r0, PackageStateMutator r1) {
        lambda$installWhitelistedSystemPackages$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$hkayLJbmlEJzOLZn7iRtubkQiVc(Set r0, PackageManagerInternal r1, List r2, PackageStateInternal r3) {
        lambda$getPackagesWhitelistErrors$2(r0, r1, r2, r3);
    }

    static {
        TAG = UserSystemPackageInstaller.class.getSimpleName();
    }

    UserSystemPackageInstaller(UserManagerService um, ArrayMap<String, UserTypeDetails> userTypes) {
        this.mUm = um;
        this.mUserTypes = getAndSortKeysFromMap(userTypes);
        if (this.mUserTypes.length > 64) goto L7;
        this.mWhitelistedPackagesForUserTypes = determineWhitelistedPackagesForUserTypes(SystemConfig.getInstance());
        return;
    L7:
        throw new IllegalArgumentException("Device contains " + userTypes.size() + " user types. However, UserSystemPackageInstaller does not work if there are more than 64 user types.");
    }

    UserSystemPackageInstaller(UserManagerService ums, ArrayMap<String, Long> whitelist, String[] sortedUserTypes) {
        this.mUm = ums;
        this.mUserTypes = sortedUserTypes;
        this.mWhitelistedPackagesForUserTypes = whitelist;
    }

    boolean installWhitelistedSystemPackages(final boolean isFirstBoot, boolean isUpgrade, final ArraySet<String> preExistingPackages) {
        int mode = getWhitelistMode();
        checkWhitelistedSystemPackages(mode);
        int r2 = 0;
        if (isUpgrade == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        final boolean isConsideredUpgrade = r3;
        if (isConsideredUpgrade == true) goto L12;
        if (isFirstBoot == true) goto L12;
        return false;
    L12:
        if (isFirstBoot == true) goto L14;
    L16:
        String r4 = TAG;
        StringBuilder r5 = new StringBuilder();
        r5.append("Reviewing whitelisted packages due to ");
        String r6 = "";
        if (isFirstBoot == false) goto L19;
        String r7 = "[firstBoot]";
    L20:
        r5.append(r7);
        if (isConsideredUpgrade == false) goto L23;
        r6 = "[upgrade]";
    L23:
        r5.append(r6);
        Slog.i(r4, r5.toString());
        PackageManagerInternal pmInt = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        final SparseArrayMap<String, Boolean> changesToCommit = new SparseArrayMap();
        int[] r11 = this.mUm.getUserIds();
        int r12 = r11.length;
    L24:
        if (r2 >= r12) goto L26;
        final int userId = r11[r2];
        final Set<String> userAllowlist = getInstallablePackagesForUserId(userId);
        pmInt.forEachPackageState(new UserSystemPackageInstaller$$ExternalSyntheticLambda1(userAllowlist, userId, isFirstBoot, isConsideredUpgrade, preExistingPackages, changesToCommit));
        r2 = r2 + 1;
        goto L24
    L26:
        pmInt.commitPackageStateMutation(null, new UserSystemPackageInstaller$$ExternalSyntheticLambda2(changesToCommit));
        return true;
    L19:
        r7 = "";
        goto L20
    L14:
        if (isEnforceMode(mode) == true) goto L16;
        return false;
    L5:
        if (isIgnoreOtaMode(mode) == true) goto L7;
        r3 = true;
        goto L8
    }

    private static /* synthetic */ void lambda$installWhitelistedSystemPackages$0(Set userAllowlist, int userId, boolean isFirstBoot, boolean isConsideredUpgrade, ArraySet preExistingPackages, SparseArrayMap changesToCommit, PackageStateInternal packageState) {
        if (packageState.getPkg() == null) goto L22;
        if (packageState.isSystem() == false) goto L25;
        if (userAllowlist == null) goto L11;
        if (userAllowlist.contains(packageState.getPackageName()) == true) goto L11;
    L13:
        boolean r0 = false;
    L14:
        boolean install = r0;
        if (packageState.getUserStateOrDefault(userId).isInstalled() == install) goto L20;
        if (shouldChangeInstallationState(packageState, install, userId, isFirstBoot, isConsideredUpgrade, preExistingPackages) == false) goto L23;
        changesToCommit.add(userId, packageState.getPackageName(), Boolean.valueOf(install));
        return;
    L23:
        return;
    L20:
        return;
    L11:
        if (packageState.getTransientState().isHiddenUntilInstalled() == true) goto L13;
        r0 = true;
        goto L14
    L25:
        return;
    }

    private static /* synthetic */ void lambda$installWhitelistedSystemPackages$1(SparseArrayMap changesToCommit, PackageStateMutator packageStateMutator) {
        int userIndex = 0;
    L4:
        if (userIndex >= changesToCommit.numMaps()) goto L18;
        int userId = changesToCommit.keyAt(userIndex);
        int packagesSize = changesToCommit.numElementsForKey(userId);
        int packageIndex = 0;
    L6:
        if (packageIndex >= packagesSize) goto L16;
        String packageName = (String) changesToCommit.keyAt(userIndex, packageIndex);
        boolean installed = ((Boolean) changesToCommit.valueAt(userIndex, packageIndex)).booleanValue();
        PackageUserStateWrite r6 = packageStateMutator.forPackage(packageName).userState(userId).setInstalled(installed);
        if (installed == false) goto L10;
        int r7 = 0;
    L11:
        r6.setUninstallReason(r7);
        String r8 = TAG + "CommitDebug";
        StringBuilder r9 = new StringBuilder();
        if (installed == false) goto L14;
        String r10 = "Installed ";
    L15:
        r9.append(r10);
        r9.append(packageName);
        r9.append(" for user ");
        r9.append(userId);
        Slog.i(r8, r9.toString());
        packageIndex = packageIndex + 1;
        goto L6
    L14:
        r10 = "Uninstalled ";
        goto L15
    L10:
        r7 = 1;
        goto L11
    L16:
        userIndex = userIndex + 1;
        goto L4
    }

    private static boolean shouldChangeInstallationState(PackageStateInternal packageState, boolean install, int userId, boolean isFirstBoot, boolean isUpgrade, ArraySet<String> preOtaPkgs) {
        if (install == true) goto L5;
        if (isFirstBoot == true) goto L16;
        if (isUpgrade == true) goto L12;
        return false;
    L12:
        if (preOtaPkgs.contains(packageState.getPackageName()) == false) goto L16;
        return false;
    L16:
        return true;
    L5:
        if (packageState.getUserStateOrDefault(userId).getUninstallReason() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void checkWhitelistedSystemPackages(int mode) {
        if (isLogMode(mode) == false) goto L5;
    L7:
        Slog.v(TAG, "Checking that all system packages are whitelisted.");
        List<String> warnings = getPackagesWhitelistWarnings();
        int numberWarnings = warnings.size();
        if (numberWarnings != 0) goto L10;
        Slog.v(TAG, "checkWhitelistedSystemPackages(mode=" + modeToString(mode) + ") has no warnings");
    L14:
        if (isImplicitWhitelistMode(mode) == true) goto L16;
    L18:
        List<String> errors = getPackagesWhitelistErrors(mode);
        int numberErrors = errors.size();
        if (numberErrors != 0) goto L22;
        Slog.v(TAG, "checkWhitelistedSystemPackages(mode=" + modeToString(mode) + ") has no errors");
        return;
    L22:
        Slog.e(TAG, "checkWhitelistedSystemPackages(mode=" + modeToString(mode) + ") has " + numberErrors + " errors:");
        boolean doWtf = isImplicitWhitelistMode(mode) ^ true;
        int i = 0;
    L23:
        if (i >= numberErrors) goto L30;
        String msg = errors.get(i);
        if (doWtf == false) goto L27;
        Slog.wtf(TAG, msg);
    L28:
        i = i + 1;
        goto L23
    L27:
        Slog.e(TAG, msg);
        goto L28
    L30:
        return;
    L16:
        if (isLogMode(mode) == true) goto L18;
        return;
    L10:
        Slog.w(TAG, "checkWhitelistedSystemPackages(mode=" + modeToString(mode) + ") has " + numberWarnings + " warnings:");
        int i2 = 0;
    L11:
        if (i2 >= numberWarnings) goto L14;
        Slog.w(TAG, warnings.get(i2));
        i2 = i2 + 1;
        goto L11
    L5:
        if (isEnforceMode(mode) == true) goto L7;
    }

    private List<String> getPackagesWhitelistWarnings() {
        Set<String> allWhitelistedPackages = getWhitelistedSystemPackages();
        List<String> warnings = new ArrayList();
        PackageManagerInternal pmInt = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        Iterator<String> r6 = allWhitelistedPackages.iterator();
    L4:
        if (r6.hasNext() == false) goto L18;
        String pkgName = r6.next();
        PackageStateInternal packageState = pmInt.getPackageStateInternal(pkgName);
        if (packageState != null) goto L8;
        AndroidPackage pkg = null;
    L9:
        if (pkg == null) goto L10;
        if (packageState.isSystem() == false) goto L13;
        if (shouldUseOverlayTargetName(pkg) == false) goto L4;
        warnings.add(String.format("%s is allowlisted unnecessarily since it's a static overlay.", new Object[]{pkgName}));
        goto L4
    L13:
        warnings.add(String.format("%s is allowlisted and present but not a system package.", new Object[]{pkgName}));
        goto L4
    L10:
        warnings.add(String.format("%s is allowlisted but not present.", new Object[]{pkgName}));
        goto L4
    L8:
        pkg = packageState.getAndroidPackage();
        goto L9
    L18:
        return warnings;
    }

    private List<String> getPackagesWhitelistErrors(int mode) {
        if (isEnforceMode(mode) == false) goto L7;
        if (isImplicitWhitelistMode(mode) == true) goto L7;
    L10:
        final List<String> errors = new ArrayList();
        final Set<String> allWhitelistedPackages = getWhitelistedSystemPackages();
        final PackageManagerInternal pmInt = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        pmInt.forEachPackageState(new UserSystemPackageInstaller$$ExternalSyntheticLambda0(allWhitelistedPackages, pmInt, errors));
        return errors;
    L7:
        if (isLogMode(mode) == true) goto L10;
        return Collections.emptyList();
    }

    private static /* synthetic */ void lambda$getPackagesWhitelistErrors$2(Set allWhitelistedPackages, PackageManagerInternal pmInt, List errors, PackageStateInternal packageState) {
        AndroidPackage pkg = packageState.getAndroidPackage();
        if (pkg != null) goto L5;
        return;
    L5:
        if (packageState.isSystem() == true) goto L7;
        return;
    L7:
        if (pkg.isApex() == true) goto L19;
        String pkgName = pkg.getManifestPackageName();
        if (allWhitelistedPackages.contains(pkgName) == false) goto L12;
        return;
    L12:
        if (shouldUseOverlayTargetName(pmInt.getPackage(pkgName)) == true) goto L17;
        errors.add(String.format("System package %s is not whitelisted using 'install-in-user-type' in SystemConfig for any user types!", new Object[]{pkgName}));
        return;
    L17:
        return;
    }

    boolean isEnforceMode() {
        return isEnforceMode(getWhitelistMode());
    }

    boolean isIgnoreOtaMode() {
        return isIgnoreOtaMode(getWhitelistMode());
    }

    boolean isLogMode() {
        return isLogMode(getWhitelistMode());
    }

    boolean isImplicitWhitelistMode() {
        return isImplicitWhitelistMode(getWhitelistMode());
    }

    boolean isImplicitWhitelistSystemMode() {
        return isImplicitWhitelistSystemMode(getWhitelistMode());
    }

    private static boolean shouldUseOverlayTargetName(AndroidPackage pkg) {
        return pkg.isOverlayIsStatic();
    }

    private static boolean isEnforceMode(int whitelistMode) {
        if ((whitelistMode & 1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isIgnoreOtaMode(int whitelistMode) {
        if ((whitelistMode & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isLogMode(int whitelistMode) {
        if ((whitelistMode & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isImplicitWhitelistMode(int whitelistMode) {
        if ((whitelistMode & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isImplicitWhitelistSystemMode(int whitelistMode) {
        if ((whitelistMode & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int getWhitelistMode() {
        int runtimeMode = SystemProperties.getInt(PACKAGE_WHITELIST_MODE_PROP, -1);
        if (runtimeMode == (-1)) goto L6;
        return runtimeMode;
    L6:
        return getDeviceDefaultWhitelistMode();
    }

    private int getDeviceDefaultWhitelistMode() {
        return Resources.getSystem().getInteger(R.integer.config_whenToStartHubModeDefault);
    }

    static String modeToString(int mode) {
        switch(mode) {
            case -1000: goto L7;
            case -1: goto L5;
            default: goto L4;
        };
    L5:
        return "DEVICE_DEFAULT";
    L7:
        return "NONE";
    L4:
        return DebugUtils.flagsToString(UserSystemPackageInstaller.class, "USER_TYPE_PACKAGE_WHITELIST_MODE_", mode);
    }

    private Set<String> getInstallablePackagesForUserId(int userId) {
        if (userId != 10) goto L7;
        return DoppelgangerConfigure.DOPPELGANGER_NECESSARY_PACKAGES;
    L7:
        return getInstallablePackagesForUserType(this.mUm.getUserInfo(userId).userType);
    }

    Set<String> getInstallablePackagesForUserType(String userType) {
        int mode = getWhitelistMode();
        if (isEnforceMode(mode) == true) goto L7;
        return null;
    L7:
        if (isImplicitWhitelistMode(mode) == false) goto L9;
    L14:
        final boolean implicitlyWhitelist = true;
    L15:
        final Set<String> whitelistedPackages = getWhitelistedPackagesForUserType(userType);
        final Set<String> installPackages = new ArraySet();
        PackageManagerInternal pmInt = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        pmInt.forEachPackageState(new UserSystemPackageInstaller$$ExternalSyntheticLambda3(this, whitelistedPackages, implicitlyWhitelist, installPackages));
        return installPackages;
    L9:
        if (isImplicitWhitelistSystemMode(mode) == true) goto L11;
    L13:
        implicitlyWhitelist = false;
        goto L15
    L11:
        if (this.mUm.isUserTypeSubtypeOfSystem(userType) == false) goto L13;
        goto L13
    }

    private /* synthetic */ void lambda$getInstallablePackagesForUserType$3(Set whitelistedPackages, boolean implicitlyWhitelist, Set installPackages, PackageStateInternal packageState) {
        AndroidPackage pkg = packageState.getAndroidPackage();
        if (pkg != null) goto L5;
        return;
    L5:
        if (packageState.isSystem() == true) goto L8;
        return;
    L8:
        if (shouldInstallPackage(pkg, this.mWhitelistedPackagesForUserTypes, whitelistedPackages, implicitlyWhitelist) == false) goto L12;
        installPackages.add(pkg.getPackageName());
        return;
    }

    static boolean shouldInstallPackage(AndroidPackage sysPkg, ArrayMap<String, Long> userTypeWhitelist, Set<String> userWhitelist, boolean implicitlyWhitelist) {
        if (shouldUseOverlayTargetName(sysPkg) == false) goto L5;
        String pkgName = sysPkg.getOverlayTarget();
    L6:
        if (implicitlyWhitelist == false) goto L10;
        if (userTypeWhitelist.containsKey(pkgName) == true) goto L10;
    L15:
        return true;
    L10:
        if (userWhitelist.contains(pkgName) == true) goto L15;
        if (sysPkg.isApex() == true) goto L15;
        return false;
    L5:
        pkgName = sysPkg.getManifestPackageName();
        goto L6
    }

    Set<String> getWhitelistedPackagesForUserType(String userType) {
        long userTypeMask = getUserTypeMask(userType);
        Set<String> installablePkgs = new ArraySet(this.mWhitelistedPackagesForUserTypes.size());
        int i = 0;
    L4:
        if (i >= this.mWhitelistedPackagesForUserTypes.size()) goto L10;
        String pkgName = this.mWhitelistedPackagesForUserTypes.keyAt(i);
        long whitelistedUserTypes = this.mWhitelistedPackagesForUserTypes.valueAt(i).longValue();
        if ((userTypeMask & whitelistedUserTypes) == 0) goto L8;
        installablePkgs.add(pkgName);
    L8:
        i = i + 1;
        goto L4
    L10:
        return installablePkgs;
    }

    private Set<String> getWhitelistedSystemPackages() {
        return this.mWhitelistedPackagesForUserTypes.keySet();
    }

    ArrayMap<String, Long> determineWhitelistedPackagesForUserTypes(SystemConfig sysConfig) {
        Map<String, Long> baseTypeBitSets = getBaseTypeBitSets();
        ArrayMap<String, Set<String>> whitelist = sysConfig.getAndClearPackageToUserTypeWhitelist();
        ArrayMap<String, Long> result = new ArrayMap(whitelist.size() + 1);
        int i = 0;
    L4:
        if (i >= whitelist.size()) goto L9;
        String pkgName = whitelist.keyAt(i).intern();
        long typesBitSet = getTypesBitSet(whitelist.valueAt(i), baseTypeBitSets);
        if (typesBitSet == 0) goto L8;
        result.put(pkgName, Long.valueOf(typesBitSet));
    L8:
        i = i + 1;
        goto L4
    L9:
        ArrayMap<String, Set<String>> blacklist = sysConfig.getAndClearPackageToUserTypeBlacklist();
        int i2 = 0;
    L11:
        if (i2 >= blacklist.size()) goto L19;
        String pkgName2 = blacklist.keyAt(i2).intern();
        long nonTypesBitSet = getTypesBitSet(blacklist.valueAt(i2), baseTypeBitSets);
        Long typesBitSet2 = result.get(pkgName2);
        if (typesBitSet2 == null) goto L16;
        result.put(pkgName2, Long.valueOf(typesBitSet2.longValue() & (~nonTypesBitSet)));
    L18:
        i2 = i2 + 1;
        goto L11
    L16:
        if (nonTypesBitSet == 0) goto L18;
        result.put(pkgName2, 0L);
        goto L18
    L19:
        result.put(PackageManagerService.PLATFORM_PACKAGE_NAME, -1L);
        return result;
    }

    long getUserTypeMask(String userType) {
        int userTypeIndex = Arrays.binarySearch(this.mUserTypes, userType);
        if (userTypeIndex < 0) goto L5;
        long userTypeMask = 1 << userTypeIndex;
        return userTypeMask;
    L5:
        return 0;
    }

    private Map<String, Long> getBaseTypeBitSets() {
        long typesBitSetFull = 0;
        long typesBitSetSystem = 0;
        long typesBitSetProfile = 0;
        int idx = 0;
    L4:
        if (idx >= this.mUserTypes.length) goto L15;
        if (this.mUm.isUserTypeSubtypeOfFull(this.mUserTypes[idx]) == false) goto L9;
        typesBitSetFull = typesBitSetFull | ((long) (1 << idx));
    L9:
        if (this.mUm.isUserTypeSubtypeOfSystem(this.mUserTypes[idx]) == false) goto L12;
        typesBitSetSystem = typesBitSetSystem | ((long) (1 << idx));
    L12:
        if (this.mUm.isUserTypeSubtypeOfProfile(this.mUserTypes[idx]) == false) goto L14;
        typesBitSetProfile = typesBitSetProfile | ((long) (1 << idx));
    L14:
        idx = idx + 1;
        goto L4
    L15:
        Map<String, Long> result = new ArrayMap(3);
        result.put("FULL", Long.valueOf(typesBitSetFull));
        result.put("SYSTEM", Long.valueOf(typesBitSetSystem));
        result.put("PROFILE", Long.valueOf(typesBitSetProfile));
        return result;
    }

    private long getTypesBitSet(Iterable<String> userTypes, Map<String, Long> baseTypeBitSets) {
        long resultBitSet = 0;
        Iterator<String> r2 = userTypes.iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        String type = r2.next();
        Long baseTypeBitSet = baseTypeBitSets.get(type);
        if (baseTypeBitSet != null) goto L7;
        long userTypeBitSet = getUserTypeMask(type);
        if (userTypeBitSet != 0) goto L10;
        Slog.w(TAG, "SystemConfig contained an invalid user type: " + type);
        goto L4
    L10:
        resultBitSet = resultBitSet | userTypeBitSet;
        goto L4
    L7:
        resultBitSet = resultBitSet | baseTypeBitSet.longValue();
        goto L4
    L12:
        return resultBitSet;
    }

    private static String[] getAndSortKeysFromMap(ArrayMap<String, ?> map) {
        String[] userTypeList = new String[map.size()];
        int i = 0;
    L4:
        if (i >= map.size()) goto L6;
        userTypeList[i] = map.keyAt(i);
        i = i + 1;
        goto L4
    L6:
        Arrays.sort(userTypeList);
        return userTypeList;
    }

    void dump(IndentingPrintWriter pw) {
        int mode = getWhitelistMode();
        pw.println("Whitelisted packages per user type");
        pw.increaseIndent();
        pw.print("Mode: ");
        pw.print(mode);
        String r2 = "";
        if (isEnforceMode(mode) == false) goto L5;
        String r1 = " (enforced)";
    L6:
        pw.print(r1);
        if (isLogMode(mode) == false) goto L9;
        String r3 = " (logged)";
    L10:
        pw.print(r3);
        if (isImplicitWhitelistMode(mode) == false) goto L13;
        String r4 = " (implicit)";
    L14:
        pw.print(r4);
        if (isIgnoreOtaMode(mode) == false) goto L17;
        r2 = " (ignore OTAs)";
    L17:
        pw.print(r2);
        pw.println();
        pw.decreaseIndent();
        pw.increaseIndent();
        pw.println("Legend");
        pw.increaseIndent();
        int idx = 0;
    L19:
        if (idx >= this.mUserTypes.length) goto L21;
        pw.println(idx + " -> " + this.mUserTypes[idx]);
        idx = idx + 1;
        goto L19
    L21:
        pw.decreaseIndent();
        pw.decreaseIndent();
        pw.increaseIndent();
        int size = this.mWhitelistedPackagesForUserTypes.size();
        if (size != 0) goto L25;
        pw.println("No packages");
        pw.decreaseIndent();
        return;
    L25:
        pw.print(size);
        pw.println(" packages:");
        pw.increaseIndent();
        int pkgIdx = 0;
    L27:
        if (pkgIdx >= size) goto L36;
        String pkgName = this.mWhitelistedPackagesForUserTypes.keyAt(pkgIdx);
        pw.print(pkgName);
        pw.print(": ");
        long userTypesBitSet = this.mWhitelistedPackagesForUserTypes.valueAt(pkgIdx).longValue();
        int idx2 = 0;
    L30:
        if (idx2 >= this.mUserTypes.length) goto L35;
        if ((((long) (1 << idx2)) & userTypesBitSet) == 0) goto L34;
        pw.print(idx2);
        pw.print(" ");
    L34:
        idx2 = idx2 + 1;
        goto L30
    L35:
        pw.println();
        pkgIdx = pkgIdx + 1;
        goto L27
    L36:
        pw.decreaseIndent();
        pw.decreaseIndent();
        pw.increaseIndent();
        dumpPackageWhitelistProblems(pw, mode, true, false);
        pw.decreaseIndent();
        return;
    L13:
        r4 = "";
        goto L14
    L9:
        r3 = "";
        goto L10
    L5:
        r1 = "";
        goto L6
    }

    void dumpPackageWhitelistProblems(IndentingPrintWriter pw, int mode, boolean verbose, boolean criticalOnly) {
        if (mode != (-1000)) goto L6;
        mode = getWhitelistMode();
    L8:
        if (criticalOnly == false) goto L10;
        mode = mode & (-3);
    L10:
        Slog.v(TAG, "dumpPackageWhitelistProblems(): using mode " + modeToString(mode));
        List<String> errors = getPackagesWhitelistErrors(mode);
        showIssues(pw, verbose, errors, "errors");
        if (criticalOnly == false) goto L13;
        return;
    L13:
        List<String> warnings = getPackagesWhitelistWarnings();
        showIssues(pw, verbose, warnings, "warnings");
        return;
    L6:
        if (mode != (-1)) goto L8;
        mode = getDeviceDefaultWhitelistMode();
        goto L8
    }

    private static void showIssues(IndentingPrintWriter pw, boolean verbose, List<String> issues, String issueType) {
        int size = issues.size();
        if (size != 0) goto L7;
        if (verbose == false) goto L17;
        pw.print("No ");
        pw.println(issueType);
        return;
    L17:
        return;
    L7:
        if (verbose == false) goto L9;
        pw.print(size);
        pw.print(' ');
        pw.println(issueType);
        pw.increaseIndent();
    L9:
        int i = 0;
    L10:
        if (i >= size) goto L13;
        pw.println(issues.get(i));
        i = i + 1;
        goto L10
    L13:
        if (verbose == false) goto L18;
        pw.decreaseIndent();
        return;
    }
}
