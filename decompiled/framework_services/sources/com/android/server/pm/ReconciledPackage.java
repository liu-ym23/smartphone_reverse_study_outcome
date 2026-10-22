package com.android.server.pm;

import android.content.pm.SharedLibraryInfo;
import android.content.pm.SigningDetails;
import android.util.ArrayMap;
import com.android.server.pm.pkg.AndroidPackage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class ReconciledPackage {
    private final Map<String, AndroidPackage> mAllPackages;
    public final List<SharedLibraryInfo> mAllowedSharedLibraryInfos;
    public ArrayList<SharedLibraryInfo> mCollectedSharedLibraryInfos;
    public final DeletePackageAction mDeletePackageAction;
    public final InstallRequest mInstallRequest;
    private final List<InstallRequest> mInstallRequests;
    public final boolean mRemoveAppKeySetData;
    public final boolean mSharedUserSignaturesChanged;
    public final SigningDetails mSigningDetails;

    ReconciledPackage(List<InstallRequest> installRequests, Map<String, AndroidPackage> allPackages, InstallRequest installRequest, DeletePackageAction deletePackageAction, List<SharedLibraryInfo> allowedSharedLibraryInfos, SigningDetails signingDetails, boolean sharedUserSignaturesChanged, boolean removeAppKeySetData) {
        this.mInstallRequests = installRequests;
        this.mAllPackages = allPackages;
        this.mInstallRequest = installRequest;
        this.mDeletePackageAction = deletePackageAction;
        this.mAllowedSharedLibraryInfos = allowedSharedLibraryInfos;
        this.mSigningDetails = signingDetails;
        this.mSharedUserSignaturesChanged = sharedUserSignaturesChanged;
        this.mRemoveAppKeySetData = removeAppKeySetData;
    }

    Map<String, AndroidPackage> getCombinedAvailablePackages() {
        ArrayMap<String, AndroidPackage> combined = new ArrayMap(this.mAllPackages.size() + this.mInstallRequests.size());
        combined.putAll(this.mAllPackages);
        Iterator<InstallRequest> r1 = this.mInstallRequests.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        InstallRequest installRequest = r1.next();
        combined.put(installRequest.getScannedPackageSetting().getPackageName(), installRequest.getParsedPackage());
        goto L4
    L6:
        return combined;
    }
}
