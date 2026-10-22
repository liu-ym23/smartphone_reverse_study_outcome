package com.android.server.om;

import android.content.om.CriticalOverlayInfo;
import android.content.om.OverlayConstraint;
import android.content.om.OverlayIdentifier;
import android.content.om.OverlayInfo;
import android.content.pm.UserPackage;
import android.content.pm.overlay.OverlayPaths;
import android.content.pm.parsing.FrameworkParsingPackageUtils;
import android.os.FabricatedOverlayInfo;
import android.os.FabricatedOverlayInternal;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.content.om.OverlayConfig;
import com.android.internal.util.CollectionUtils;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.AndroidPackageSplit;
import com.android.server.pm.pkg.PackageState;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
final class OverlayManagerServiceImpl {
    private static final int FLAG_OVERLAY_IS_BEING_REPLACED = 2;
    private static final int FLAG_SYSTEM_UPDATE_UNINSTALL = 4;

    @Deprecated
    private static final int FLAG_TARGET_IS_BEING_REPLACED = 1;
    private final String[] mDefaultOverlays;
    private final IdmapManager mIdmapManager;
    private final OverlayConfig mOverlayConfig;
    private final PackageManagerHelper mPackageManager;
    private final OverlayManagerSettings mSettings;

    static final class OperationFailedException extends Exception {
        OperationFailedException(String message) {
            super(message);
        }

        OperationFailedException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$4_u0zZtyj6jePmGinO-0D6huxCc, reason: not valid java name */
    public static /* synthetic */ boolean m6354$r8$lambda$4_u0zZtyj6jePmGinO0D6huxCc(ArrayMap r0, OverlayInfo r1) {
        return lambda$updateOverlaysForUser$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$5x0NbsvHcQBnmJ0O8BX2HdCnICA(boolean r0, OverlayPaths.Builder r1, OverlayInfo r2) {
        lambda$getEnabledOverlayPaths$4(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$68WS0T3LBeUCaE7FhsFkUclY3gc(Set r0, FabricatedOverlayInfo r1) {
        return lambda$getFabricatedOverlayInfos$3(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$Tz06Z6gMGNWEvNzQgIVBx0FKDBw(int r0, Predicate r1, OverlayInfo r2) {
        return lambda$removeOverlaysForUser$2(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$m7qx04ZFdlPTSNWQUmUUqYHeXjE(String r0, OverlayInfo r1) {
        return lambda$onPackageRemoved$1(r0, r1);
    }

    private boolean mustReinitializeOverlay(AndroidPackage theTruth, OverlayInfo oldSettings) {
        if (oldSettings != null) goto L6;
        return true;
    L6:
        if (Objects.equals(theTruth.getOverlayTarget(), oldSettings.targetPackageName) == true) goto L9;
        return true;
    L9:
        if (Objects.equals(theTruth.getOverlayTargetOverlayableName(), oldSettings.targetOverlayableName) == true) goto L12;
        return true;
    L12:
        if (oldSettings.isFabricated == false) goto L14;
        return true;
    L14:
        boolean isMutable = isPackageConfiguredMutable(theTruth);
        if (isMutable == oldSettings.isMutable) goto L17;
        return true;
    L17:
        if (isMutable == false) goto L19;
        return false;
    L19:
        if (isPackageConfiguredEnabled(theTruth) == oldSettings.isEnabled()) goto L23;
        return true;
    L23:
        return false;
    }

    private boolean mustReinitializeOverlay(FabricatedOverlayInfo theTruth, OverlayInfo oldSettings) {
        if (oldSettings != null) goto L6;
        return true;
    L6:
        if (Objects.equals(theTruth.targetPackageName, oldSettings.targetPackageName) == true) goto L9;
        return true;
    L9:
        if (Objects.equals(theTruth.targetOverlayable, oldSettings.targetOverlayableName) == true) goto L11;
        return true;
    L11:
        return false;
    }

    OverlayManagerServiceImpl(PackageManagerHelper packageManager, IdmapManager idmapManager, OverlayManagerSettings settings, OverlayConfig overlayConfig, String[] defaultOverlays) {
        this.mPackageManager = packageManager;
        this.mIdmapManager = idmapManager;
        this.mSettings = settings;
        this.mOverlayConfig = overlayConfig;
        this.mDefaultOverlays = defaultOverlays;
    }

    ArraySet<UserPackage> updateOverlaysForUser(int newUserId) {
        ArraySet<UserPackage> updatedTargets = new ArraySet();
        final ArrayMap<String, PackageState> userPackages = this.mPackageManager.initializeForUser(newUserId);
        CollectionUtils.addAll(updatedTargets, removeOverlaysForUser(new OverlayManagerServiceImpl$$ExternalSyntheticLambda1(userPackages), newUserId));
        ArraySet<String> overlaidByOthers = new ArraySet();
        Iterator<PackageState> r0 = userPackages.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        AndroidPackage pkg = r0.next().getAndroidPackage();
        if (pkg != null) goto L8;
        String overlayTarget = null;
    L10:
        if (TextUtils.isEmpty(overlayTarget) == true) goto L4;
        overlaidByOthers.add(overlayTarget);
        goto L4
    L8:
        overlayTarget = pkg.getOverlayTarget();
        goto L10
    L13:
        int n = userPackages.size();
        int i = 0;
    L14:
        int r11 = 0;
        if (i >= n) goto L29;
        PackageState packageState = userPackages.valueAt(i);
        AndroidPackage pkg2 = packageState.getAndroidPackage();
        if (pkg2 == null) goto L28;
        String packageName = packageState.getPackageName();
        CollectionUtils.addAll(updatedTargets, updatePackageOverlays(pkg2, newUserId, 0));     // Catch: OperationFailedException -> L24
        if (overlaidByOthers.contains(packageName) == false) goto L28;
        updatedTargets.add(UserPackage.of(newUserId, packageName));     // Catch: OperationFailedException -> L24
    L24:
        e = move-exception;
        Slog.e("OverlayManager", "failed to initialize overlays of '" + packageName + "' for user " + newUserId + "", e);
    L28:
        i = i + 1;
        goto L14
    L29:
        Iterator<FabricatedOverlayInfo> r6 = getFabricatedOverlayInfos().iterator();
    L31:
        if (r6.hasNext() == false) goto L38;
        FabricatedOverlayInfo info = r6.next();
        CollectionUtils.addAll(updatedTargets, registerFabricatedOverlay(info, newUserId));     // Catch: OperationFailedException -> L35
    L35:
        e = move-exception;
        Slog.e("OverlayManager", "failed to initialize fabricated overlay of '" + info.path + "' for user " + newUserId + "", e);
        goto L31
    L38:
        ArraySet<String> enabledCategories = new ArraySet();
        ArrayMap<String, List<OverlayInfo>> userOverlays = this.mSettings.getOverlaysForUser(newUserId);
        int userOverlayTargetCount = userOverlays.size();
        int i2 = 0;
    L39:
        if (i2 >= userOverlayTargetCount) goto L51;
        List<OverlayInfo> overlayList = userOverlays.valueAt(i2);
        if (overlayList == null) goto L43;
        int overlayCount = overlayList.size();
    L44:
        int j = 0;
    L45:
        if (j >= overlayCount) goto L50;
        OverlayInfo oi = overlayList.get(j);
        if (oi.isEnabled() == false) goto L49;
        enabledCategories.add(oi.category);
    L49:
        j = j + 1;
        goto L45
    L50:
        i2 = i2 + 1;
        r11 = 0;
        goto L39
    L43:
        overlayCount = r11;
        goto L44
    L51:
        String[] r12 = this.mDefaultOverlays;
        int r13 = r12.length;
        int r14 = 0;
    L52:
        if (r14 >= r13) goto L74;
        String defaultOverlay = r12[r14];
        OverlayIdentifier overlay = new OverlayIdentifier(defaultOverlay);     // Catch: OverlayManagerSettings.BadKeyException -> L70
        OverlayInfo oi2 = this.mSettings.getOverlayInfo(overlay, newUserId);     // Catch: OverlayManagerSettings.BadKeyException -> L70
        ArrayMap<String, PackageState> userPackages2 = userPackages;
    L66:
        e = e;
        ArraySet<String> overlaidByOthers2 = overlaidByOthers;
    L72:
        Slog.e("OverlayManager", "Failed to set default overlay '" + defaultOverlay + "' for user " + newUserId, e);
    L73:
        r14 = r14 + 1;
        userPackages = userPackages2;
        overlaidByOthers = overlaidByOthers2;
        goto L52
    L57:
        if (enabledCategories.contains(oi2.category) == true) goto L68;
        StringBuilder r4 = new StringBuilder();     // Catch: OverlayManagerSettings.BadKeyException -> L66
        overlaidByOthers2 = overlaidByOthers;
        r4.append("Enabling default overlay '");     // Catch: OverlayManagerSettings.BadKeyException -> L64
        r4.append(defaultOverlay);     // Catch: OverlayManagerSettings.BadKeyException -> L64
        r4.append("' for target '");     // Catch: OverlayManagerSettings.BadKeyException -> L64
        r4.append(oi2.targetPackageName);     // Catch: OverlayManagerSettings.BadKeyException -> L64
        r4.append("' in category '");     // Catch: OverlayManagerSettings.BadKeyException -> L64
        r4.append(oi2.category);     // Catch: OverlayManagerSettings.BadKeyException -> L64
        r4.append("' for user ");     // Catch: OverlayManagerSettings.BadKeyException -> L64
        r4.append(newUserId);     // Catch: OverlayManagerSettings.BadKeyException -> L64
        Slog.w("OverlayManager", r4.toString());     // Catch: OverlayManagerSettings.BadKeyException -> L64
        this.mSettings.setEnabled(overlay, newUserId, true);     // Catch: OverlayManagerSettings.BadKeyException -> L64
        if (updateState(oi2, newUserId, 0, oi2.constraints) == false) goto L73;
        CollectionUtils.add(updatedTargets, UserPackage.of(oi2.userId, oi2.targetPackageName));     // Catch: OverlayManagerSettings.BadKeyException -> L64
    L64:
        e = e;
        goto L72
    L68:
        overlaidByOthers2 = overlaidByOthers;
    L70:
        e = e;
        userPackages2 = userPackages;
        overlaidByOthers2 = overlaidByOthers;
        goto L72
    L74:
        cleanStaleResourceCache();
        return updatedTargets;
    }

    private static /* synthetic */ boolean lambda$updateOverlaysForUser$0(ArrayMap userPackages, OverlayInfo info) {
        return !userPackages.containsKey(info.packageName);
    }

    void onUserRemoved(int userId) {
        this.mSettings.removeUser(userId);
    }

    Set<UserPackage> onPackageAdded(String pkgName, int userId) throws OperationFailedException {
        Set<UserPackage> updatedTargets = new ArraySet();
        updatedTargets.add(UserPackage.of(userId, pkgName));
        updatedTargets.addAll(reconcileSettingsForPackage(pkgName, userId, 0));
        return updatedTargets;
    }

    Set<UserPackage> onPackageChanged(String pkgName, int userId) throws OperationFailedException {
        return reconcileSettingsForPackage(pkgName, userId, 0);
    }

    Set<UserPackage> onPackageReplacing(String pkgName, boolean systemUpdateUninstall, int userId) throws OperationFailedException {
        int flags = 2;
        if (systemUpdateUninstall == false) goto L6;
        flags = 2 | 4;
    L6:
        return reconcileSettingsForPackage(pkgName, userId, flags);
    }

    Set<UserPackage> onPackageReplaced(String pkgName, int userId) throws OperationFailedException {
        return reconcileSettingsForPackage(pkgName, userId, 0);
    }

    Set<UserPackage> onPackageRemoved(final String pkgName, int userId) {
        Set<UserPackage> targets = Collections.emptySet();
        return CollectionUtils.addAll(CollectionUtils.addAll(targets, updateOverlaysForTarget(pkgName, userId, 0)), removeOverlaysForUser(new OverlayManagerServiceImpl$$ExternalSyntheticLambda0(pkgName), userId));
    }

    private static /* synthetic */ boolean lambda$onPackageRemoved$1(String pkgName, OverlayInfo oi) {
        return pkgName.equals(oi.packageName);
    }

    private Set<UserPackage> removeOverlaysForUser(final Predicate<OverlayInfo> condition, final int userId) {
        List<OverlayInfo> overlays = this.mSettings.removeIf(new OverlayManagerServiceImpl$$ExternalSyntheticLambda3(userId, condition));
        Set<UserPackage> targets = Collections.emptySet();
        int i = 0;
        int n = overlays.size();
    L3:
        if (i >= n) goto L6;
        OverlayInfo info = overlays.get(i);
        targets = CollectionUtils.add(targets, UserPackage.of(userId, info.targetPackageName));
        removeIdmapIfPossible(info);
        i = i + 1;
        goto L3
    L6:
        return targets;
    }

    private static /* synthetic */ boolean lambda$removeOverlaysForUser$2(int userId, Predicate condition, OverlayInfo io) {
        if (userId == io.userId) goto L5;
    L7:
        return false;
    L5:
        if (condition.test(io) == false) goto L7;
        return true;
    }

    private Set<UserPackage> updateOverlaysForTarget(String targetPackage, int userId, int flags) {
        boolean modified = false;
        List<OverlayInfo> overlays = this.mSettings.getOverlaysForTarget(targetPackage, userId);
        int i = 0;
        int n = overlays.size();
    L3:
        if (i >= n) goto L11;
        OverlayInfo oi = overlays.get(i);
        modified = modified | updateState(oi, userId, flags, oi.constraints);
    L9:
        i = i + 1;
    L7:
        e = move-exception;
        Slog.e("OverlayManager", "failed to update settings", e);
        modified = modified | this.mSettings.remove(oi.getOverlayIdentifier(), userId);
        goto L9
    L11:
        if (modified == true) goto L15;
        return Collections.emptySet();
    L15:
        return Set.of(UserPackage.of(userId, targetPackage));
    }

    private Set<UserPackage> updatePackageOverlays(AndroidPackage pkg, int userId, int flags) throws OperationFailedException {
        if (pkg.getOverlayTarget() == null) goto L5;
        Set<UserPackage> updatedTargets = Collections.emptySet();
        OverlayIdentifier overlay = new OverlayIdentifier(pkg.getPackageName());
        int priority = getPackageConfiguredPriority(pkg);
        OverlayInfo currentInfo = this.mSettings.getNullableOverlayInfo(overlay, userId);     // Catch: OverlayManagerSettings.BadKeyException -> L34
    L14:
        e = e;
    L37:
        throw new OperationFailedException("failed to update settings", e);
    L10:
        if (mustReinitializeOverlay(pkg, currentInfo) == false) goto L22;
        if (currentInfo != null) goto L13;
        Set<UserPackage> updatedTargets2 = updatedTargets;
    L40:
        currentInfo = this.mSettings.init(overlay, userId, pkg.getOverlayTarget(), pkg.getOverlayTargetOverlayableName(), ((AndroidPackageSplit) pkg.getSplits().get(0)).getPath(), isPackageConfiguredMutable(pkg), isPackageConfiguredEnabled(pkg), getPackageConfiguredPriority(pkg), pkg.getOverlayCategory(), false);     // Catch: OverlayManagerSettings.BadKeyException -> L19
        updatedTargets = updatedTargets2;
    L24:
    L30:
        e = e;
        goto L37
    L27:
        if (updateState(currentInfo, userId, flags, currentInfo.constraints) == false) goto L33;
        return CollectionUtils.add(updatedTargets, UserPackage.of(userId, currentInfo.targetPackageName));
    L33:
        return updatedTargets;
    L19:
        e = e;
        goto L37
    L13:
        updatedTargets2 = CollectionUtils.add(updatedTargets, UserPackage.of(userId, currentInfo.targetPackageName));     // Catch: OverlayManagerSettings.BadKeyException -> L14
        goto L40
    L22:
        if (priority == currentInfo.priority) goto L24;
        this.mSettings.setPriority(overlay, userId, priority);     // Catch: OverlayManagerSettings.BadKeyException -> L14
        updatedTargets = CollectionUtils.add(updatedTargets, UserPackage.of(userId, currentInfo.targetPackageName));     // Catch: OverlayManagerSettings.BadKeyException -> L14
    L34:
        e = e;
        goto L37
    L5:
        return Collections.emptySet();
    }

    private Set<UserPackage> reconcileSettingsForPackage(String pkgName, int userId, int flags) throws OperationFailedException {
        Set<UserPackage> updatedTargets = Collections.emptySet();
        Set<UserPackage> updatedTargets2 = CollectionUtils.addAll(updatedTargets, updateOverlaysForTarget(pkgName, userId, flags));
        PackageState packageState = this.mPackageManager.getPackageStateForUser(pkgName, userId);
        if (packageState != null) goto L5;
        AndroidPackage pkg = null;
    L6:
        if (pkg != null) goto L10;
        return onPackageRemoved(pkgName, userId);
    L10:
        return CollectionUtils.addAll(updatedTargets2, updatePackageOverlays(pkg, userId, flags));
    L5:
        pkg = packageState.getAndroidPackage();
        goto L6
    }

    OverlayInfo getOverlayInfo(OverlayIdentifier packageName, int userId) {
        return this.mSettings.getOverlayInfo(packageName, userId);
    L5:
        return null;
    }

    List<OverlayInfo> getOverlayInfosForTarget(String targetPackageName, int userId) {
        return this.mSettings.getOverlaysForTarget(targetPackageName, userId);
    }

    Map<String, List<OverlayInfo>> getOverlaysForUser(int userId) {
        return this.mSettings.getOverlaysForUser(userId);
    }

    Set<UserPackage> setEnabled(OverlayIdentifier overlay, boolean enable, int userId, List<OverlayConstraint> constraints) throws OperationFailedException {
        if (constraints != null) goto L5;
    L7:
        boolean hasConstraints = false;
    L8:
        if (hasConstraints == true) goto L29;
        if (enable == true) goto L30;
        if (hasConstraints == false) goto L30;
        throw new OperationFailedException("Constraints can only be set when enabling an overlay");
    L30:
        OverlayInfo oi = this.mSettings.getOverlayInfo(overlay, userId);     // Catch: OverlayManagerSettings.BadKeyException -> L20
        if (oi.isMutable == false) goto L25;
        boolean modified = this.mSettings.setEnabled(overlay, userId, enable);     // Catch: OverlayManagerSettings.BadKeyException -> L20
        if ((updateState(oi, userId, 0, constraints) | modified) == false) goto L23;
        return Set.of(UserPackage.of(userId, oi.targetPackageName));
    L23:
        return Set.of();
    L25:
        throw new OperationFailedException("cannot enable immutable overlay packages in runtime");     // Catch: OverlayManagerSettings.BadKeyException -> L20
    L20:
        e = move-exception;
        throw new OperationFailedException("failed to update settings", e);
    L29:
        throw new OperationFailedException("RRO constraints are not supported");
    L5:
        if (constraints.isEmpty() == true) goto L7;
        hasConstraints = true;
        goto L8
    }

    Optional<UserPackage> setEnabledExclusive(OverlayIdentifier overlay, boolean withinCategory, int userId) throws OperationFailedException {
        OverlayInfo enabledInfo = this.mSettings.getOverlayInfo(overlay, userId);     // Catch: OverlayManagerSettings.BadKeyException -> L14
        if (enabledInfo.isMutable == false) goto L25;
        List<OverlayInfo> allOverlays = getOverlayInfosForTarget(enabledInfo.targetPackageName, userId);     // Catch: OverlayManagerSettings.BadKeyException -> L14
        allOverlays.remove(enabledInfo);     // Catch: OverlayManagerSettings.BadKeyException -> L14
        boolean modified = false;
        int i = 0;
    L6:
        if (i >= allOverlays.size()) goto L19;
        OverlayInfo disabledInfo = allOverlays.get(i);     // Catch: OverlayManagerSettings.BadKeyException -> L14
        OverlayIdentifier disabledOverlay = disabledInfo.getOverlayIdentifier();     // Catch: OverlayManagerSettings.BadKeyException -> L14
        if (disabledInfo.isMutable == false) goto L17;
        if (withinCategory == true) goto L12;
    L16:
        modified = (modified | this.mSettings.setEnabled(disabledOverlay, userId, false)) | updateState(disabledInfo, userId, 0, Collections.emptyList());     // Catch: OverlayManagerSettings.BadKeyException -> L14
        goto L17
    L12:
        if (Objects.equals(disabledInfo.category, enabledInfo.category) == true) goto L16;
    L17:
        i = i + 1;     // Catch: OverlayManagerSettings.BadKeyException -> L14
        goto L6
    L19:
        if (((modified | this.mSettings.setEnabled(overlay, userId, true)) | updateState(enabledInfo, userId, 0, Collections.emptyList())) == false) goto L23;
        return Optional.of(UserPackage.of(userId, enabledInfo.targetPackageName));
    L23:
        return Optional.empty();
    L25:
        throw new OperationFailedException("cannot enable immutable overlay packages in runtime");     // Catch: OverlayManagerSettings.BadKeyException -> L14
    L14:
        e = move-exception;
        throw new OperationFailedException("failed to update settings", e);
    }

    Set<UserPackage> registerFabricatedOverlay(FabricatedOverlayInternal overlay) throws OperationFailedException {
        int r2 = 0;
        if (FrameworkParsingPackageUtils.validateName(overlay.overlayName, false, true) != null) goto L13;
        FabricatedOverlayInfo info = this.mIdmapManager.createFabricatedOverlay(overlay);
        if (info == null) goto L11;
        Set<UserPackage> updatedTargets = new ArraySet();
        int[] r3 = this.mSettings.getUsers();
        int r4 = r3.length;
    L7:
        if (r2 >= r4) goto L9;
        int userId = r3[r2];
        updatedTargets.addAll(registerFabricatedOverlay(info, userId));
        r2 = r2 + 1;
        goto L7
    L9:
        return updatedTargets;
    L11:
        throw new OperationFailedException("failed to create fabricated overlay");
    L13:
        throw new OperationFailedException("overlay name can only consist of alphanumeric characters, '_', and '.'");
    }

    private Set<UserPackage> registerFabricatedOverlay(FabricatedOverlayInfo info, int userId) throws OperationFailedException {
        OverlayIdentifier overlayIdentifier = new OverlayIdentifier(info.packageName, info.overlayName);
        Set<UserPackage> updatedTargets = new ArraySet();
        CriticalOverlayInfo r15 = this.mSettings.getNullableOverlayInfo(overlayIdentifier, userId);
        if (r15 != null) goto L5;
    L24:
    L13:
        e = move-exception;
        throw new OperationFailedException("failed to update settings", e);
    L10:
        if (mustReinitializeOverlay(info, r15) == false) goto L16;
        if (r15 == null) goto L15;
        updatedTargets.add(UserPackage.of(userId, ((OverlayInfo) r15).targetPackageName));     // Catch: OverlayManagerSettings.BadKeyException -> L13
    L15:
        r15 = this.mSettings.init(overlayIdentifier, userId, info.targetPackageName, info.targetOverlayable, info.path, true, false, Integer.MAX_VALUE, null, true);     // Catch: OverlayManagerSettings.BadKeyException -> L13
    L18:
        if (updateState(r15, userId, 0, Collections.emptyList()) == false) goto L21;
        updatedTargets.add(UserPackage.of(userId, ((OverlayInfo) r15).targetPackageName));     // Catch: OverlayManagerSettings.BadKeyException -> L13
    L21:
        return updatedTargets;
    L16:
        this.mSettings.setBaseCodePath(overlayIdentifier, userId, info.path);     // Catch: OverlayManagerSettings.BadKeyException -> L13
        goto L18
    L5:
        if (((OverlayInfo) r15).isFabricated == true) goto L24;
        throw new OperationFailedException("non-fabricated overlay with name '" + ((OverlayInfo) r15).overlayName + "' already present in '" + ((OverlayInfo) r15).packageName + "'");
    }

    Set<UserPackage> unregisterFabricatedOverlay(OverlayIdentifier overlay) {
        Set<UserPackage> updatedTargets = new ArraySet();
        int[] r1 = this.mSettings.getUsers();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        int userId = r1[r3];
        updatedTargets.addAll(unregisterFabricatedOverlay(overlay, userId));
        r3 = r3 + 1;
        goto L3
    L5:
        return updatedTargets;
    }

    private Set<UserPackage> unregisterFabricatedOverlay(OverlayIdentifier overlay, int userId) {
        OverlayInfo oi = this.mSettings.getNullableOverlayInfo(overlay, userId);
        if (oi == null) goto L9;
        this.mSettings.remove(overlay, userId);
        if (oi.isEnabled() == false) goto L9;
        return Set.of(UserPackage.of(userId, oi.targetPackageName));
    L9:
        return Set.of();
    }

    private void cleanStaleResourceCache() {
        Set<String> fabricatedPaths = this.mSettings.getAllBaseCodePaths();
        Iterator<FabricatedOverlayInfo> r1 = this.mIdmapManager.getFabricatedOverlayInfos().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        FabricatedOverlayInfo info = r1.next();
        if (fabricatedPaths.contains(info.path) == true) goto L4;
        this.mIdmapManager.deleteFabricatedOverlay(info.path);
        goto L4
    }

    private List<FabricatedOverlayInfo> getFabricatedOverlayInfos() {
        final Set<String> fabricatedPaths = this.mSettings.getAllBaseCodePaths();
        ArrayList<FabricatedOverlayInfo> infos = new ArrayList(this.mIdmapManager.getFabricatedOverlayInfos());
        infos.removeIf(new OverlayManagerServiceImpl$$ExternalSyntheticLambda2(fabricatedPaths));
        return infos;
    }

    private static /* synthetic */ boolean lambda$getFabricatedOverlayInfos$3(Set fabricatedPaths, FabricatedOverlayInfo info) {
        return !fabricatedPaths.contains(info.path);
    }

    private boolean isPackageConfiguredMutable(AndroidPackage overlay) {
        return this.mOverlayConfig.isMutable(overlay.getPackageName());
    }

    private int getPackageConfiguredPriority(AndroidPackage overlay) {
        return this.mOverlayConfig.getPriority(overlay.getPackageName());
    }

    private boolean isPackageConfiguredEnabled(AndroidPackage overlay) {
        return this.mOverlayConfig.isEnabled(overlay.getPackageName());
    }

    Optional<UserPackage> setPriority(OverlayIdentifier overlay, OverlayIdentifier newParentOverlay, int userId) throws OperationFailedException {
        OverlayInfo overlayInfo = this.mSettings.getOverlayInfo(overlay, userId);     // Catch: OverlayManagerSettings.BadKeyException -> L8
        if (overlayInfo.isMutable == false) goto L13;
        if (this.mSettings.setPriority(overlay, newParentOverlay, userId) == false) goto L11;
        return Optional.of(UserPackage.of(userId, overlayInfo.targetPackageName));
    L11:
        return Optional.empty();
    L13:
        throw new OperationFailedException("cannot change priority of an immutable overlay package at runtime");     // Catch: OverlayManagerSettings.BadKeyException -> L8
    L8:
        e = move-exception;
        throw new OperationFailedException("failed to update settings", e);
    }

    Set<UserPackage> setHighestPriority(OverlayIdentifier overlay, int userId) throws OperationFailedException {
        OverlayInfo overlayInfo = this.mSettings.getOverlayInfo(overlay, userId);     // Catch: OverlayManagerSettings.BadKeyException -> L8
        if (overlayInfo.isMutable == false) goto L13;
        if (this.mSettings.setHighestPriority(overlay, userId) == false) goto L11;
        return Set.of(UserPackage.of(userId, overlayInfo.targetPackageName));
    L11:
        return Set.of();
    L13:
        throw new OperationFailedException("cannot change priority of an immutable overlay package at runtime");     // Catch: OverlayManagerSettings.BadKeyException -> L8
    L8:
        e = move-exception;
        throw new OperationFailedException("failed to update settings", e);
    }

    Optional<UserPackage> setLowestPriority(OverlayIdentifier overlay, int userId) throws OperationFailedException {
        OverlayInfo overlayInfo = this.mSettings.getOverlayInfo(overlay, userId);     // Catch: OverlayManagerSettings.BadKeyException -> L8
        if (overlayInfo.isMutable == false) goto L13;
        if (this.mSettings.setLowestPriority(overlay, userId) == false) goto L11;
        return Optional.of(UserPackage.of(userId, overlayInfo.targetPackageName));
    L11:
        return Optional.empty();
    L13:
        throw new OperationFailedException("cannot change priority of an immutable overlay package at runtime");     // Catch: OverlayManagerSettings.BadKeyException -> L8
    L8:
        e = move-exception;
        throw new OperationFailedException("failed to update settings", e);
    }

    void dump(PrintWriter pw, DumpState dumpState) {
        this.mSettings.dump(pw, dumpState);
        Pair<OverlayIdentifier, String> overlayIdmap = this.mSettings.getIdentifierAndBaseCodePath(dumpState);
        if (dumpState.getField() != null) goto L21;
        if (overlayIdmap == null) goto L6;
        Set<Pair<OverlayIdentifier, String>> allIdmaps = Set.of(overlayIdmap);
    L7:
        Iterator<Pair<OverlayIdentifier, String>> r2 = allIdmaps.iterator();
    L9:
        if (r2.hasNext() == false) goto L21;
        Pair<OverlayIdentifier, String> pair = r2.next();
        pw.println("IDMAP OF " + pair.first);
        String dump = this.mIdmapManager.dumpIdmap((String) pair.second);
        if (dump != null) goto L12;
        OverlayInfo oi = this.mSettings.getNullableOverlayInfo((OverlayIdentifier) pair.first, 0);
        if (oi != null) goto L16;
    L18:
        String r6 = "<internal error>";
    L19:
        pw.println(r6);
        goto L9
    L16:
        if (this.mIdmapManager.idmapExists(oi) == true) goto L18;
        r6 = "<missing idmap>";
        goto L19
    L12:
        pw.println(dump);
        goto L9
    L6:
        allIdmaps = this.mSettings.getAllIdentifiersAndBaseCodePaths();
    L21:
        if (overlayIdmap != null) goto L24;
        pw.println("Default overlays: " + TextUtils.join(";", this.mDefaultOverlays));
    L24:
        if (dumpState.getPackageName() != null) goto L33;
        this.mOverlayConfig.dump(pw);
        return;
    }

    String[] getDefaultOverlayPackages() {
        return this.mDefaultOverlays;
    }

    void removeIdmapForOverlay(OverlayIdentifier overlay, int userId) throws OperationFailedException {
        OverlayInfo oi = this.mSettings.getOverlayInfo(overlay, userId);     // Catch: OverlayManagerSettings.BadKeyException -> L4
        removeIdmapIfPossible(oi);     // Catch: OverlayManagerSettings.BadKeyException -> L4
        return;
    L4:
        e = move-exception;
        throw new OperationFailedException("failed to update settings", e);
    }

    OverlayPaths getEnabledOverlayPaths(String targetPackageName, int userId, final boolean includeImmutableOverlays) {
        final OverlayPaths.Builder paths = new OverlayPaths.Builder();
        this.mSettings.forEachMatching(userId, null, targetPackageName, new OverlayManagerServiceImpl$$ExternalSyntheticLambda4(includeImmutableOverlays, paths));
        return paths.build();
    }

    private static /* synthetic */ void lambda$getEnabledOverlayPaths$4(boolean includeImmutableOverlays, OverlayPaths.Builder paths, OverlayInfo oi) {
        if (oi.isEnabled() == true) goto L5;
        return;
    L5:
        if (includeImmutableOverlays == true) goto L10;
        if (oi.isMutable == true) goto L10;
        return;
    L10:
        if (oi.isFabricated() == false) goto L12;
        paths.addNonApkPath(oi.baseCodePath);
        return;
    L12:
        paths.addApkPath(oi.baseCodePath);
    }

    private boolean updateState(CriticalOverlayInfo info, int userId, int flags, List<OverlayConstraint> constraints) throws OverlayManagerSettings.BadKeyException {
        int r3 = userId;
        OverlayIdentifier overlay = info.getOverlayIdentifier();
        PackageState targetPackageState = this.mPackageManager.getPackageStateForUser(info.getTargetPackageName(), r3);
        AndroidPackage overlayPackage = null;
        if (targetPackageState != null) goto L5;
        AndroidPackage targetPackage = null;
    L6:
        PackageState overlayPackageState = this.mPackageManager.getPackageStateForUser(info.getPackageName(), r3);
        if (overlayPackageState == null) goto L11;
        overlayPackage = overlayPackageState.getAndroidPackage();
    L11:
        if (overlayPackage != null) goto L14;
        removeIdmapIfPossible(this.mSettings.getOverlayInfo(overlay, r3));
        return this.mSettings.remove(overlay, r3);
    L14:
        boolean modified = (false | this.mSettings.setCategory(overlay, r3, overlayPackage.getOverlayCategory())) | this.mSettings.setConstraints(overlay, r3, constraints);
        boolean r12 = false;
        if (info.isFabricated() == true) goto L17;
        boolean modified2 = modified | this.mSettings.setBaseCodePath(overlay, r3, ((AndroidPackageSplit) overlayPackage.getSplits().get(0)).getPath());
    L18:
        OverlayInfo updatedOverlayInfo = this.mSettings.getOverlayInfo(overlay, r3);
        if (targetPackage == null) goto L31;
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(info.getTargetPackageName()) == true) goto L23;
    L26:
        int idmapStatus = this.mIdmapManager.createIdmap(targetPackage, overlayPackageState, overlayPackage, updatedOverlayInfo.baseCodePath, overlay.getOverlayName(), userId, updatedOverlayInfo.constraints);
        r3 = userId;
        if ((idmapStatus & 2) == 0) goto L29;
        r12 = true;
    L29:
        modified2 = modified2 | r12;
        int idmapStatus2 = idmapStatus;
    L32:
        int currentState = this.mSettings.getState(overlay, r3);
        int newState = calculateNewState(updatedOverlayInfo, targetPackage, r3, flags, idmapStatus2);
        if (currentState != newState) goto L35;
        return modified2;
    L35:
        return modified2 | this.mSettings.setState(overlay, r3, newState);
    L23:
        if (isPackageConfiguredMutable(overlayPackage) == true) goto L26;
    L31:
        idmapStatus2 = 0;
        goto L32
    L17:
        modified2 = modified;
        goto L18
    L5:
        targetPackage = targetPackageState.getAndroidPackage();
        goto L6
    }

    private int calculateNewState(OverlayInfo info, AndroidPackage targetPackage, int userId, int flags, int idmapStatus) throws OverlayManagerSettings.BadKeyException {
        if ((flags & 1) == 0) goto L7;
        return 4;
    L7:
        if ((flags & 2) == 0) goto L11;
        return 5;
    L11:
        if ((flags & 4) == 0) goto L14;
        return 7;
    L14:
        if (targetPackage != null) goto L18;
        return 0;
    L18:
        if ((idmapStatus & 1) == 0) goto L20;
    L23:
        boolean enabled = this.mSettings.getEnabled(info.getOverlayIdentifier(), userId);
        if (enabled == false) goto L26;
        return 3;
    L26:
        return 2;
    L20:
        if (this.mIdmapManager.idmapExists(info) == true) goto L23;
        return 1;
    }

    private void removeIdmapIfPossible(OverlayInfo oi) {
        if (this.mIdmapManager.idmapExists(oi) == true) goto L5;
        return;
    L5:
        int[] userIds = this.mSettings.getUsers();
        int r1 = userIds.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L17;
        int userId = userIds[r2];
        OverlayInfo tmp = this.mSettings.getOverlayInfo(oi.getOverlayIdentifier(), userId);     // Catch: OverlayManagerSettings.BadKeyException -> L13
        if (tmp == null) goto L16;
        if (tmp.isEnabled() == false) goto L16;
        return;
    L16:
        r2 = r2 + 1;
        goto L6
    L17:
        this.mIdmapManager.removeIdmap(oi, oi.userId);
    }

    OverlayConfig getOverlayConfig() {
        return this.mOverlayConfig;
    }
}
