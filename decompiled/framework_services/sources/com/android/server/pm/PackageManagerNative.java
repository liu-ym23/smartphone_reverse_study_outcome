package com.android.server.pm;

import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManagerNative;
import android.content.pm.IStagedApexObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PkgSignForNative;
import android.content.pm.StagedApexInfo;
import android.os.Binder;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Slog;
import com.obric.utils.ObricImplFactory;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class PackageManagerNative extends IPackageManagerNative.Stub {
    private final PackageManagerService mPm;

    PackageManagerNative(PackageManagerService pm) {
        this.mPm = pm;
    }

    public String[] getNamesForUids(int[] uids) throws RemoteException {
        String[] names = null;
        String[] results = null;
        if (uids == null) goto L24;
    L17:
        t = move-exception;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "uids: " + Arrays.toString(uids));
        Slog.e(PackageManagerServiceMonitorEx.TAG, "names: " + Arrays.toString(names));
        Slog.e(PackageManagerServiceMonitorEx.TAG, "results: " + Arrays.toString(results));
        Slog.e(PackageManagerServiceMonitorEx.TAG, "throwing exception", t);
        throw t;
    L5:
        if (uids.length == 0) goto L24;
        names = this.mPm.snapshotComputer().getNamesForUids(uids);     // Catch: Throwable -> L17
        if (names == null) goto L10;
        String[] r2 = names;
    L11:
        results = r2;
        int i = results.length - 1;     // Catch: Throwable -> L17
    L12:
        if (i < 0) goto L21;
        if (results[i] != null) goto L19;
        results[i] = "";     // Catch: Throwable -> L17
    L19:
        i = i - 1;
        goto L12
    L21:
        return results;
    L10:
        r2 = new String[uids.length];     // Catch: Throwable -> L17
    L24:
        return null;
    }

    public int getPackageUid(String packageName, long flags, int userId) throws RemoteException {
        return this.mPm.snapshotComputer().getPackageUid(packageName, flags, userId);
    }

    public String getInstallerForPackage(String packageName) throws RemoteException {
        Computer snapshot = this.mPm.snapshotComputer();
        int callingUser = UserHandle.getUserId(Binder.getCallingUid());
        String installerName = snapshot.getInstallerPackageName(packageName, callingUser);
        if (TextUtils.isEmpty(installerName) == true) goto L5;
        return installerName;
    L5:
        ApplicationInfo appInfo = snapshot.getApplicationInfo(packageName, 0, callingUser);
        if (appInfo != null) goto L8;
        return "";
    L8:
        if ((appInfo.flags & 1) == 0) goto L13;
        return "preload";
    L13:
        return "";
    }

    public long getVersionCodeForPackage(String packageName) throws RemoteException {
        int callingUser = UserHandle.getUserId(Binder.getCallingUid());     // Catch: Exception -> L7
        PackageInfo pInfo = this.mPm.snapshotComputer().getPackageInfo(packageName, 0, callingUser);     // Catch: Exception -> L7
        if (pInfo == null) goto L10;
        return pInfo.getLongVersionCode();
    L10:
        return 0;
    }

    public int getTargetSdkVersionForPackage(String packageName) throws RemoteException {
        int targetSdk = this.mPm.snapshotComputer().getTargetSdkVersion(packageName);
        if (targetSdk == (-1)) goto L6;
        return targetSdk;
    L6:
        throw new RemoteException("Couldn't get targetSdkVersion for package " + packageName);
    }

    public boolean isPackageDebuggable(String packageName) throws RemoteException {
        int callingUser = UserHandle.getCallingUserId();
        ApplicationInfo appInfo = this.mPm.snapshotComputer().getApplicationInfo(packageName, 0, callingUser);
        if (appInfo == null) goto L10;
        if ((appInfo.flags & 2) == 0) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new RemoteException("Couldn't get debug flag for package " + packageName);
    }

    public boolean[] isAudioPlaybackCaptureAllowed(String[] packageNames) throws RemoteException {
        int callingUser = UserHandle.getUserId(Binder.getCallingUid());
        Computer snapshot = this.mPm.snapshotComputer();
        boolean[] results = new boolean[packageNames.length];
        int i = results.length - 1;
    L3:
        if (i < 0) goto L12;
        ApplicationInfo appInfo = snapshot.getApplicationInfo(packageNames[i], 0, callingUser);
        if (appInfo != null) goto L7;
    L9:
        boolean r6 = false;
    L10:
        results[i] = r6;
        i = i - 1;
        goto L3
    L7:
        if (appInfo.isAudioPlaybackCaptureAllowed() == false) goto L9;
        r6 = true;
        goto L10
    L12:
        return results;
    }

    public int getLocationFlags(String r6) throws RemoteException {
        ApplicationInfo r1 = this.mPm.snapshotComputer().getApplicationInfo(r6, 0, UserHandle.getUserId(Binder.getCallingUid()));
        if (r1 == null) goto L14;
        boolean r2 = r1.isSystemApp();
        int r4 = 0;
        if (r1.isVendor() == false) goto L7;
        int r3 = 2;
    L8:
        int r5 = (r2 ? 1 : 0) | r3;
        if (r1.isProduct() == false) goto L12;
        r4 = 4;
    L12:
        return r5 | r4;
    L7:
        r3 = 0;
        goto L8
    L14:
        throw new RemoteException("Couldn't get ApplicationInfo for package " + r6);
    }

    public String getModuleMetadataPackageName() throws RemoteException {
        return this.mPm.getModuleMetadataPackageName();
    }

    public boolean hasSha256SigningCertificate(String packageName, byte[] certificate) throws RemoteException {
        return this.mPm.snapshotComputer().hasSigningCertificate(packageName, certificate, 1);
    }

    public boolean hasSystemFeature(String featureName, int version) {
        return this.mPm.hasSystemFeature(featureName, version);
    }

    public void registerStagedApexObserver(IStagedApexObserver observer) {
        this.mPm.mInstallerService.getStagingManager().registerStagedApexObserver(observer);
    }

    public void unregisterStagedApexObserver(IStagedApexObserver observer) {
        this.mPm.mInstallerService.getStagingManager().unregisterStagedApexObserver(observer);
    }

    public StagedApexInfo[] getStagedApexInfos() {
        return (StagedApexInfo[]) this.mPm.mInstallerService.getStagingManager().getStagedApexInfos().toArray(new StagedApexInfo[0]);
    }

    public int checkSignatures(String pkg1, String pkg2, int userId) {
        return this.mPm.snapshotComputer().checkSignatures(pkg1, pkg2, userId);
    }

    public List<PkgSignForNative> getSignaturesForUid(int uid) throws RemoteException {
        return ((IObricPackageManagerUtils) ObricImplFactory.getImpl(IObricPackageManagerUtils.class, new Object[]{this})).getSignaturesForUid(this.mPm, uid);
    }
}
