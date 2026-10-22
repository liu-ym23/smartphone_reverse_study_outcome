package com.android.server.pm;

import com.android.internal.util.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class InstallSource {
    static final InstallSource EMPTY = null;
    private static final InstallSource EMPTY_ORPHANED = null;
    final String mInitiatingPackageName;
    final PackageSignatures mInitiatingPackageSignatures;
    final String mInstallerAttributionTag;
    final String mInstallerPackageName;
    final int mInstallerPackageUid;
    final boolean mIsInitiatingPackageUninstalled;
    final boolean mIsOrphaned;
    final String mOriginatingPackageName;
    final int mPackageSource;
    final String mUpdateOwnerPackageName;

    static {
        EMPTY = new InstallSource(null, null, null, -1, null, null, false, false, null, 0);
        EMPTY_ORPHANED = new InstallSource(null, null, null, -1, null, null, true, false, null, 0);
    }

    static InstallSource create(String initiatingPackageName, String originatingPackageName, String installerPackageName, int installerPackageUid, String updateOwnerPackageName, String installerAttributionTag, boolean isOrphaned, boolean isInitiatingPackageUninstalled) {
        return create(initiatingPackageName, originatingPackageName, installerPackageName, installerPackageUid, updateOwnerPackageName, installerAttributionTag, 0, isOrphaned, isInitiatingPackageUninstalled);
    }

    static InstallSource create(String initiatingPackageName, String originatingPackageName, String installerPackageName, int installerPackageUid, String updateOwnerPackageName, String installerAttributionTag, int packageSource) {
        return create(initiatingPackageName, originatingPackageName, installerPackageName, installerPackageUid, updateOwnerPackageName, installerAttributionTag, packageSource, false, false);
    }

    static InstallSource create(String initiatingPackageName, String originatingPackageName, String installerPackageName, int installerPackageUid, String updateOwnerPackageName, String installerAttributionTag, int packageSource, boolean isOrphaned, boolean isInitiatingPackageUninstalled) {
        return createInternal(intern(initiatingPackageName), intern(originatingPackageName), intern(installerPackageName), installerPackageUid, intern(updateOwnerPackageName), installerAttributionTag, packageSource, isOrphaned, isInitiatingPackageUninstalled, null);
    }

    private static InstallSource createInternal(String initiatingPackageName, String originatingPackageName, String installerPackageName, int installerPackageUid, String updateOwnerPackageName, String installerAttributionTag, int packageSource, boolean isOrphaned, boolean isInitiatingPackageUninstalled, PackageSignatures initiatingPackageSignatures) {
        if (initiatingPackageName != null) goto L14;
        if (originatingPackageName != null) goto L14;
        if (installerPackageName != null) goto L14;
        if (updateOwnerPackageName != null) goto L14;
        if (initiatingPackageSignatures != null) goto L14;
        if (isInitiatingPackageUninstalled == true) goto L14;
        if (packageSource != 0) goto L14;
        if (isOrphaned == false) goto L12;
        return EMPTY_ORPHANED;
    L12:
        return EMPTY;
    L14:
        return new InstallSource(initiatingPackageName, originatingPackageName, installerPackageName, installerPackageUid, updateOwnerPackageName, installerAttributionTag, isOrphaned, isInitiatingPackageUninstalled, initiatingPackageSignatures, packageSource);
    }

    private InstallSource(String initiatingPackageName, String originatingPackageName, String installerPackageName, int installerPackageUid, String updateOwnerPackageName, String installerAttributionTag, boolean isOrphaned, boolean isInitiatingPackageUninstalled, PackageSignatures initiatingPackageSignatures, int packageSource) {
        if (initiatingPackageName != null) goto L8;
        if (initiatingPackageSignatures != null) goto L6;
        boolean r0 = true;
    L7:
        Preconditions.checkArgument(r0);
        Preconditions.checkArgument(!isInitiatingPackageUninstalled);
        goto L8
    L6:
        r0 = false;
    L8:
        this.mInitiatingPackageName = initiatingPackageName;
        this.mOriginatingPackageName = originatingPackageName;
        this.mInstallerPackageName = installerPackageName;
        this.mInstallerPackageUid = installerPackageUid;
        this.mUpdateOwnerPackageName = updateOwnerPackageName;
        this.mInstallerAttributionTag = installerAttributionTag;
        this.mIsOrphaned = isOrphaned;
        this.mIsInitiatingPackageUninstalled = isInitiatingPackageUninstalled;
        this.mInitiatingPackageSignatures = initiatingPackageSignatures;
        this.mPackageSource = packageSource;
    }

    InstallSource setInstallerPackage(String installerPackageName, int installerPackageUid) {
        if (Objects.equals(installerPackageName, this.mInstallerPackageName) == false) goto L6;
        return this;
    L6:
        return createInternal(this.mInitiatingPackageName, this.mOriginatingPackageName, intern(installerPackageName), installerPackageUid, this.mUpdateOwnerPackageName, this.mInstallerAttributionTag, this.mPackageSource, this.mIsOrphaned, this.mIsInitiatingPackageUninstalled, this.mInitiatingPackageSignatures);
    }

    InstallSource setUpdateOwnerPackageName(String updateOwnerPackageName) {
        if (Objects.equals(updateOwnerPackageName, this.mUpdateOwnerPackageName) == false) goto L6;
        return this;
    L6:
        return createInternal(this.mInitiatingPackageName, this.mOriginatingPackageName, this.mInstallerPackageName, this.mInstallerPackageUid, intern(updateOwnerPackageName), this.mInstallerAttributionTag, this.mPackageSource, this.mIsOrphaned, this.mIsInitiatingPackageUninstalled, this.mInitiatingPackageSignatures);
    }

    InstallSource setIsOrphaned(boolean isOrphaned) {
        if (isOrphaned != this.mIsOrphaned) goto L6;
        return this;
    L6:
        return createInternal(this.mInitiatingPackageName, this.mOriginatingPackageName, this.mInstallerPackageName, this.mInstallerPackageUid, this.mUpdateOwnerPackageName, this.mInstallerAttributionTag, this.mPackageSource, isOrphaned, this.mIsInitiatingPackageUninstalled, this.mInitiatingPackageSignatures);
    }

    InstallSource setInitiatingPackageSignatures(PackageSignatures signatures) {
        if (signatures != this.mInitiatingPackageSignatures) goto L6;
        return this;
    L6:
        return createInternal(this.mInitiatingPackageName, this.mOriginatingPackageName, this.mInstallerPackageName, this.mInstallerPackageUid, this.mUpdateOwnerPackageName, this.mInstallerAttributionTag, this.mPackageSource, this.mIsOrphaned, this.mIsInitiatingPackageUninstalled, signatures);
    }

    InstallSource removeInstallerPackage(String packageName) {
        if (packageName != null) goto L5;
        return this;
    L5:
        boolean modified = false;
        boolean isInitiatingPackageUninstalled = this.mIsInitiatingPackageUninstalled;
        String originatingPackageName = this.mOriginatingPackageName;
        String installerPackageName = this.mInstallerPackageName;
        String updateOwnerPackageName = this.mUpdateOwnerPackageName;
        int installerPackageUid = this.mInstallerPackageUid;
        boolean isOrphaned = this.mIsOrphaned;
        if (packageName.equals(this.mInitiatingPackageName) == false) goto L9;
        if (isInitiatingPackageUninstalled == true) goto L9;
        modified = true;
        boolean isInitiatingPackageUninstalled2 = true;
    L11:
        if (packageName.equals(originatingPackageName) == false) goto L13;
        modified = true;
        String originatingPackageName2 = null;
    L15:
        if (packageName.equals(installerPackageName) == false) goto L17;
        modified = true;
        String installerPackageName2 = null;
        int installerPackageUid2 = -1;
        boolean isOrphaned2 = true;
    L19:
        if (packageName.equals(updateOwnerPackageName) == false) goto L21;
        modified = true;
        String updateOwnerPackageName2 = null;
    L22:
        if (modified == true) goto L25;
        return this;
    L25:
        return createInternal(this.mInitiatingPackageName, originatingPackageName2, installerPackageName2, installerPackageUid2, updateOwnerPackageName2, null, this.mPackageSource, isOrphaned2, isInitiatingPackageUninstalled2, this.mInitiatingPackageSignatures);
    L21:
        updateOwnerPackageName2 = updateOwnerPackageName;
        goto L22
    L17:
        installerPackageName2 = installerPackageName;
        installerPackageUid2 = installerPackageUid;
        isOrphaned2 = isOrphaned;
        goto L19
    L13:
        originatingPackageName2 = originatingPackageName;
    L9:
        isInitiatingPackageUninstalled2 = isInitiatingPackageUninstalled;
        goto L11
    }

    private static String intern(String packageName) {
        if (packageName != null) goto L5;
        return null;
    L5:
        return packageName.intern();
    }
}
