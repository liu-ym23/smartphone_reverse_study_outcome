package com.android.server.pm.dex;

import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.os.FileUtils;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.util.EventLog;
import android.util.PackageUtils;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.pm.Installer;
import com.android.server.pm.Settings;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import libcore.util.HexEncoding;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicCodeLogger {
    private static final String DCL_DEX_SUBTAG = "dcl";
    private static final String DCL_NATIVE_SUBTAG = "dcln";
    private static final int SNET_TAG = 1397638484;
    private static final String TAG = "DynamicCodeLogger";
    private final Installer mInstaller;
    private final PackageDynamicCodeLoading mPackageDynamicCodeLoading;
    private IPackageManager mPackageManager;

    public static /* synthetic */ Set $r8$lambda$11aZGEwigi4eqhfsE87EXQLEOD8(String r0) {
        return lambda$load$0(r0);
    }

    public DynamicCodeLogger(Installer installer) {
        this.mInstaller = installer;
        this.mPackageDynamicCodeLoading = new PackageDynamicCodeLoading();
    }

    DynamicCodeLogger(IPackageManager packageManager, Installer installer, PackageDynamicCodeLoading packageDynamicCodeLoading) {
        this.mPackageManager = packageManager;
        this.mInstaller = installer;
        this.mPackageDynamicCodeLoading = packageDynamicCodeLoading;
    }

    private IPackageManager getPackageManager() {
        if (this.mPackageManager != null) goto L6;
        this.mPackageManager = IPackageManager.Stub.asInterface(ServiceManager.getService(Settings.ATTR_PACKAGE));
    L6:
        return this.mPackageManager;
    }

    public Set<String> getAllPackagesWithDynamicCodeLoading() {
        return this.mPackageDynamicCodeLoading.getAllPackagesWithDynamicCodeLoading();
    }

    public void logDynamicCodeLoading(String packageName) {
        PackageDynamicCodeLoading.PackageDynamicCode info = getPackageDynamicCodeInfo(packageName);
        if (info != null) goto L5;
        return;
    L5:
        SparseArray<ApplicationInfo> appInfoByUser = new SparseArray();
        Iterator<Map.Entry<String, PackageDynamicCodeLoading.DynamicCodeFile>> r10 = info.mFileUsageMap.entrySet().iterator();
        boolean needWrite = false;
    L6:
        boolean needWrite2 = r10.hasNext();
        if (needWrite2 == false) goto L74;
        Map.Entry<String, PackageDynamicCodeLoading.DynamicCodeFile> fileEntry = r10.next();
        String filePath = fileEntry.getKey();
        PackageDynamicCodeLoading.DynamicCodeFile fileInfo = fileEntry.getValue();
        int userId = fileInfo.mUserId;
        int index = appInfoByUser.indexOfKey(userId);
        if (index < 0) goto L77;
        boolean needWrite3 = needWrite;
        ApplicationInfo appInfo = appInfoByUser.get(userId);
    L23:
        if (appInfo == null) goto L24;
        if (fileIsUnder(filePath, appInfo.credentialProtectedDataDir) == true) goto L27;
        if (fileIsUnder(filePath, appInfo.deviceProtectedDataDir) == true) goto L30;
        Slog.e(TAG, "Could not infer CE/DE storage for path " + filePath);
        needWrite = needWrite3 | this.mPackageDynamicCodeLoading.removeFile(packageName, filePath, userId);
        info = info;
        goto L6
    L30:
        int storageFlags = 1;
    L83:
        PackageDynamicCodeLoading.PackageDynamicCode info2 = info;
        SparseArray<ApplicationInfo> appInfoByUser2 = appInfoByUser;
        ApplicationInfo appInfo2 = appInfo;
        byte[] hash = this.mInstaller.hashSecondaryDexFile(filePath, packageName, appInfo.uid, appInfo.volumeUuid, storageFlags);     // Catch: Installer.InstallerException -> L36
        byte[] hash2 = hash;
    L42:
        if (fileInfo.mFileType != 'D') goto L44;
        String r0 = DCL_DEX_SUBTAG;
    L45:
        String subtag = r0;
        String fileName = new File(filePath).getName();
        String message = PackageUtils.computeSha256Digest(fileName.getBytes());
        if (hash2 == null) goto L51;
        byte[] hash3 = hash2;
        if (hash2.length != 32) goto L51;
        String message2 = message + ' ' + HexEncoding.encodeToString(hash3);
    L52:
        Iterator<String> r9 = fileInfo.mLoadingPackages.iterator();
    L54:
        if (r9.hasNext() == false) goto L71;
        String loadingPackageName = r9.next();
        if (loadingPackageName.equals(packageName) == false) goto L85;
        int loadingUid = appInfo2.uid;
        String fileName2 = fileName;
        int storageFlags2 = storageFlags;
    L68:
        if (loadingUid == (-1)) goto L70;
        writeDclEvent(subtag, loadingUid, message2);
    L70:
        storageFlags = storageFlags2;
        fileName = fileName2;
        goto L54
    L85:
        fileName2 = fileName;
        storageFlags2 = storageFlags;
        loadingUid = getPackageManager().getPackageUid(loadingPackageName, 0, userId);     // Catch: RemoteException -> L62
    L66:
        loadingUid = -1;
    L65:
        fileName2 = fileName;
        storageFlags2 = storageFlags;
        goto L66
    L71:
        needWrite = needWrite3;
        info = info2;
        appInfoByUser = appInfoByUser2;
    L51:
        Slog.d(TAG, "Got no hash for " + filePath);
        needWrite3 = needWrite3 | this.mPackageDynamicCodeLoading.removeFile(packageName, filePath, userId);
        message2 = message;
        goto L52
    L44:
        r0 = DCL_NATIVE_SUBTAG;
    L36:
        e = e;
    L40:
        Slog.e(TAG, "Got InstallerException when hashing file " + filePath + ": " + e.getMessage());
        hash2 = null;
    L38:
        e = e;
        info2 = info;
        appInfoByUser2 = appInfoByUser;
        appInfo2 = appInfo;
        goto L40
    L27:
        storageFlags = 2;
        goto L83
    L24:
        needWrite = needWrite3;
        goto L6
    L77:
        PackageInfo ownerInfo = getPackageManager().getPackageInfo(packageName, 0, userId);     // Catch: RemoteException -> L17
        if (ownerInfo != null) goto L15;
        ApplicationInfo appInfo3 = null;
    L16:
        ApplicationInfo appInfo4 = appInfo3;
    L19:
        appInfoByUser.put(userId, appInfo4);
        if (appInfo4 != null) goto L22;
        Slog.d(TAG, "Could not find package " + packageName + " for user " + userId);
        needWrite3 = needWrite | this.mPackageDynamicCodeLoading.removeUserPackage(packageName, userId);
        appInfo = appInfo4;
        goto L23
    L22:
        needWrite3 = needWrite;
        appInfo = appInfo4;
        goto L23
    L15:
        appInfo3 = ownerInfo.applicationInfo;     // Catch: RemoteException -> L17
    L18:
        appInfo4 = null;
        goto L19
    L74:
        if (needWrite == false) goto L100;
        this.mPackageDynamicCodeLoading.maybeWriteAsync();
        return;
    }

    private boolean fileIsUnder(String filePath, String directoryPath) {
        if (directoryPath != null) goto L9;
        return false;
    L9:
        return FileUtils.contains(new File(directoryPath).getCanonicalPath(), new File(filePath).getCanonicalPath());
    L8:
        return false;
    }

    PackageDynamicCodeLoading.PackageDynamicCode getPackageDynamicCodeInfo(String packageName) {
        return this.mPackageDynamicCodeLoading.getPackageDynamicCodeInfo(packageName);
    }

    void writeDclEvent(String subtag, int uid, String message) {
        EventLog.writeEvent(SNET_TAG, new Object[]{subtag, Integer.valueOf(uid), message});
    }

    public void recordDex(int loaderUserId, String dexPath, String owningPackageName, String loadingPackageName) {
        if (this.mPackageDynamicCodeLoading.record(owningPackageName, dexPath, 68, loaderUserId, loadingPackageName) == false) goto L6;
        this.mPackageDynamicCodeLoading.maybeWriteAsync();
        return;
    }

    public void recordNative(int loadingUid, String path) {
        String[] packages = getPackageManager().getPackagesForUid(loadingUid);     // Catch: RemoteException -> L11
        if (packages == null) goto L14;
        if (packages.length == 0) goto L20;
        String loadingPackageName = packages[0];
        int loadingUserId = UserHandle.getUserId(loadingUid);
        if (this.mPackageDynamicCodeLoading.record(loadingPackageName, path, 78, loadingUserId, loadingPackageName) == false) goto L19;
        this.mPackageDynamicCodeLoading.maybeWriteAsync();
        return;
    L19:
        return;
    L20:
        return;
    L14:
        return;
    }

    void clear() {
        this.mPackageDynamicCodeLoading.clear();
    }

    void removePackage(String packageName) {
        if (this.mPackageDynamicCodeLoading.removePackage(packageName) == false) goto L6;
        this.mPackageDynamicCodeLoading.maybeWriteAsync();
        return;
    }

    void removeUserPackage(String packageName, int userId) {
        if (this.mPackageDynamicCodeLoading.removeUserPackage(packageName, userId) == false) goto L6;
        this.mPackageDynamicCodeLoading.maybeWriteAsync();
        return;
    }

    void readAndSync(Map<String, Set<Integer>> packageToUsersMap) {
        this.mPackageDynamicCodeLoading.read();
        this.mPackageDynamicCodeLoading.syncData(packageToUsersMap);
    }

    public void writeNow() {
        this.mPackageDynamicCodeLoading.writeNow();
    }

    public void load(Map<Integer, List<PackageInfo>> userToPackagesMap) {
        Map<String, Set<Integer>> packageToUsersMap = new HashMap();
        Iterator<Map.Entry<Integer, List<PackageInfo>>> r1 = userToPackagesMap.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<Integer, List<PackageInfo>> entry = r1.next();
        List<PackageInfo> packageInfoList = entry.getValue();
        int userId = entry.getKey().intValue();
        Iterator<PackageInfo> r5 = packageInfoList.iterator();
    L7:
        if (r5.hasNext() == false) goto L4;
        PackageInfo pi = r5.next();
        Set<Integer> users = packageToUsersMap.computeIfAbsent(pi.packageName, new DynamicCodeLogger$$ExternalSyntheticLambda0());
        users.add(Integer.valueOf(userId));
        goto L7
    L10:
        readAndSync(packageToUsersMap);
    }

    private static /* synthetic */ Set lambda$load$0(String k) {
        return new HashSet();
    }

    public void notifyPackageDataDestroyed(String packageName, int userId) {
        if (userId != (-1)) goto L5;
        removePackage(packageName);
        return;
    L5:
        removeUserPackage(packageName, userId);
    }
}
