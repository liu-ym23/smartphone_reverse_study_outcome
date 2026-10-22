package com.android.server.om;

import android.content.om.OverlayConstraint;
import android.content.om.OverlayInfo;
import android.content.om.OverlayableInfo;
import android.os.FabricatedOverlayInfo;
import android.os.FabricatedOverlayInternal;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Slog;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.AndroidPackageSplit;
import com.android.server.pm.pkg.PackageState;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class IdmapManager {
    static final int IDMAP_IS_MODIFIED = 2;
    static final int IDMAP_IS_VERIFIED = 1;
    static final int IDMAP_NOT_EXIST = 0;
    private static final boolean VENDOR_IS_Q_OR_LATER = false;
    private final String mConfigSignaturePackage;
    private final IdmapDaemon mIdmapDaemon;
    private final PackageManagerHelper mPackageManager;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IdmapStatus {
    }

    static {
        String value = SystemProperties.get("ro.vndk.version", "29");
        if (Integer.parseInt(value) < 29) goto L7;
        boolean isQOrLater = true;
    L11:
        VENDOR_IS_Q_OR_LATER = isQOrLater;
        return;
    L7:
        isQOrLater = false;
    L10:
        isQOrLater = true;
        goto L11
    }

    IdmapManager(IdmapDaemon idmapDaemon, PackageManagerHelper packageManager) {
        this.mPackageManager = packageManager;
        this.mIdmapDaemon = idmapDaemon;
        this.mConfigSignaturePackage = packageManager.getConfigSignaturePackage();
    }

    int createIdmap(AndroidPackage targetPackage, PackageState overlayPackageState, AndroidPackage overlayPackage, String overlayBasePath, String overlayName, int userId, List<OverlayConstraint> constraints) {
        String targetPath = ((AndroidPackageSplit) targetPackage.getSplits().get(0)).getPath();
        int policies = calculateFulfilledPolicies(targetPackage, overlayPackageState, overlayPackage, userId);     // Catch: Exception -> L13
        boolean enforce = enforceOverlayable(overlayPackageState, overlayPackage);     // Catch: Exception -> L13
        android.os.OverlayConstraint[] idmapConstraints = toIdmapConstraints(constraints);     // Catch: Exception -> L13
        boolean idmapCreated = true;
        if (this.mIdmapDaemon.verifyIdmap(targetPath, overlayBasePath, overlayName, policies, enforce, userId, idmapConstraints) == false) goto L6;
        return 1;
    L6:
        if (this.mIdmapDaemon.createIdmap(targetPath, overlayBasePath, overlayName, policies, enforce, userId, idmapConstraints) != null) goto L10;
        idmapCreated = false;
    L10:
        if (idmapCreated == false) goto L18;
        return 3;
    L18:
        return 0;
    L13:
        e = move-exception;
        Slog.w("OverlayManager", "failed to generate idmap for " + targetPath + " and " + overlayBasePath, e);
        return 0;
    }

    boolean removeIdmap(OverlayInfo oi, int userId) {
        return this.mIdmapDaemon.removeIdmap(oi.baseCodePath, userId);
    L4:
        e = move-exception;
        Slog.w("OverlayManager", "failed to remove idmap for " + oi.baseCodePath, e);
        return false;
    }

    boolean idmapExists(OverlayInfo oi) {
        return this.mIdmapDaemon.idmapExists(oi.baseCodePath, oi.userId);
    }

    List<FabricatedOverlayInfo> getFabricatedOverlayInfos() {
        return this.mIdmapDaemon.getFabricatedOverlayInfos();
    }

    FabricatedOverlayInfo createFabricatedOverlay(FabricatedOverlayInternal overlay) {
        return this.mIdmapDaemon.createFabricatedOverlay(overlay);
    }

    boolean deleteFabricatedOverlay(String path) {
        return this.mIdmapDaemon.deleteFabricatedOverlay(path);
    }

    String dumpIdmap(String overlayPath) {
        return this.mIdmapDaemon.dumpIdmap(overlayPath);
    }

    private boolean enforceOverlayable(PackageState overlayPackageState, AndroidPackage overlayPackage) {
        if (overlayPackage.getTargetSdkVersion() < 29) goto L6;
        return true;
    L6:
        if (overlayPackageState.isVendor() == false) goto L10;
        return VENDOR_IS_Q_OR_LATER;
    L10:
        if (overlayPackageState.isSystem() == false) goto L12;
    L14:
        return false;
    L12:
        if (overlayPackage.isSignedWithPlatformKey() == true) goto L14;
        return true;
    }

    private int calculateFulfilledPolicies(AndroidPackage targetPackage, PackageState overlayPackageState, AndroidPackage overlayPackage, int userId) {
        int fulfilledPolicies = 1;
        if (this.mPackageManager.signaturesMatching(targetPackage.getPackageName(), overlayPackage.getPackageName(), userId) == false) goto L6;
        fulfilledPolicies = 1 | 16;
    L6:
        if (matchesActorSignature(targetPackage, overlayPackage, userId) == false) goto L9;
        fulfilledPolicies = fulfilledPolicies | 128;
    L9:
        if (TextUtils.isEmpty(this.mConfigSignaturePackage) == true) goto L14;
        if (this.mPackageManager.signaturesMatching(this.mConfigSignaturePackage, overlayPackage.getPackageName(), userId) == false) goto L14;
        fulfilledPolicies = fulfilledPolicies | 256;
    L14:
        if (overlayPackageState.isVendor() == false) goto L18;
        return fulfilledPolicies | 4;
    L18:
        if (overlayPackageState.isProduct() == false) goto L22;
        return fulfilledPolicies | 8;
    L22:
        if (overlayPackageState.isOdm() == false) goto L26;
        return fulfilledPolicies | 32;
    L26:
        if (overlayPackageState.isOem() == false) goto L30;
        return fulfilledPolicies | 64;
    L30:
        if (overlayPackageState.isSystem() == true) goto L36;
        if (overlayPackageState.isSystemExt() == true) goto L36;
        return fulfilledPolicies;
    L36:
        return fulfilledPolicies | 2;
    }

    private boolean matchesActorSignature(AndroidPackage targetPackage, AndroidPackage overlayPackage, int userId) {
        String targetOverlayableName = overlayPackage.getOverlayTargetOverlayableName();
        if (targetOverlayableName != null) goto L5;
        return false;
    L5:
        if (this.mPackageManager.getNamedActors().isEmpty() == true) goto L21;
        OverlayableInfo overlayableInfo = this.mPackageManager.getOverlayableForTarget(targetPackage.getPackageName(), targetOverlayableName, userId);     // Catch: IOException -> L14
        if (overlayableInfo != null) goto L9;
        return false;
    L9:
        if (overlayableInfo.actor == null) goto L24;
        String actorPackageName = (String) OverlayActorEnforcer.getPackageNameForActor(overlayableInfo.actor, this.mPackageManager.getNamedActors()).first;     // Catch: IOException -> L14
        if (this.mPackageManager.signaturesMatching(actorPackageName, overlayPackage.getPackageName(), userId) == false) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L22:
        return false;
    L21:
        return false;
    }

    private static android.os.OverlayConstraint[] toIdmapConstraints(List<OverlayConstraint> constraints) {
        android.os.OverlayConstraint[] idmapConstraints = new android.os.OverlayConstraint[constraints.size()];
        int index = 0;
        Iterator<OverlayConstraint> r2 = constraints.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        OverlayConstraint constraint = r2.next();
        android.os.OverlayConstraint idmapConstraint = new android.os.OverlayConstraint();
        idmapConstraint.type = constraint.getType();
        idmapConstraint.value = constraint.getValue();
        idmapConstraints[index] = idmapConstraint;
        index = index + 1;
        goto L4
    L6:
        return idmapConstraints;
    }
}
