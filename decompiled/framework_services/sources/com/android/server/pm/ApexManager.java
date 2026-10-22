package com.android.server.pm;

import android.apex.ApexInfo;
import android.apex.ApexInfoList;
import android.apex.ApexSessionInfo;
import android.apex.ApexSessionParams;
import android.apex.CompressedApexInfoList;
import android.apex.IApexService;
import android.content.pm.PackageInfo;
import android.content.pm.SigningDetails;
import android.content.pm.parsing.result.ParseResult;
import android.content.pm.parsing.result.ParseTypeImpl;
import android.os.Binder;
import android.os.Environment;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Singleton;
import android.util.Slog;
import android.util.SparseArray;
import android.util.apk.ApkSignatureVerifier;
import com.android.internal.pm.pkg.component.ParsedApexSystemService;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.modules.utils.build.UnboundedSdkLevel;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.utils.TimingsTraceAndSlog;
import com.google.android.collect.Lists;
import java.io.File;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ApexManager {
    public static final int MATCH_ACTIVE_PACKAGE = 1;
    static final int MATCH_FACTORY_PACKAGE = 2;
    private static final String TAG = "ApexManager";
    private static final Singleton<ApexManager> sApexManagerSingleton = null;

    public static class ActiveApexInfo {
        public final boolean activeApexChanged;
        public final File apexDirectory;
        public final File apexFile;
        public final String apexModuleName;
        public final boolean isFactory;
        public final File preInstalledApexPath;

        private ActiveApexInfo(File apexDirectory, File preInstalledApexPath, File apexFile) {
            this(null, apexDirectory, preInstalledApexPath, true, apexFile, false);
        }

        private ActiveApexInfo(String apexModuleName, File apexDirectory, File preInstalledApexPath, boolean isFactory, File apexFile, boolean activeApexChanged) {
            this.apexModuleName = apexModuleName;
            this.apexDirectory = apexDirectory;
            this.preInstalledApexPath = preInstalledApexPath;
            this.isFactory = isFactory;
            this.apexFile = apexFile;
            this.activeApexChanged = activeApexChanged;
        }

        public ActiveApexInfo(ApexInfo apexInfo) {
            this(apexInfo.moduleName, new File(Environment.getApexDirectory() + File.separator + apexInfo.moduleName), new File(apexInfo.preinstalledModulePath), apexInfo.isFactory, new File(apexInfo.modulePath), apexInfo.activeApexChanged);
        }
    }

    protected static class ApexManagerImpl extends ApexManager {
        private Set<ActiveApexInfo> mActiveApexInfosCache;
        private ArrayMap<String, String> mApexModuleNameToActivePackageName;
        private final List<ApexSystemServiceInfo> mApexSystemServices;
        private final ArrayMap<String, List<String>> mApksInApex;
        private final Map<String, String> mErrorWithApkInApex;
        private final Object mLock;
        private ArrayMap<String, String> mPackageNameToApexModuleName;

        protected ApexManagerImpl() {
            this.mLock = new Object();
            this.mApexSystemServices = new ArrayList();
            this.mApksInApex = new ArrayMap();
            this.mErrorWithApkInApex = new ArrayMap();
        }

        protected IApexService waitForApexService() {
            return IApexService.Stub.asInterface(Binder.allowBlocking(ServiceManager.waitForService("apexservice")));
        }

        @Override // com.android.server.pm.ApexManager
        ApexInfo[] getAllApexInfos() {
            return waitForApexService().getAllPackages();
        L4:
            re = move-exception;
            Slog.e(ApexManager.TAG, "Unable to retrieve packages from apexservice: " + re.toString());
            throw new RuntimeException(re);
        }

        @Override // com.android.server.pm.ApexManager
        void notifyScanResult(List<ScanResult> scanResults) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            notifyScanResultLocked(scanResults);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void notifyScanResultLocked(List<ScanResult> scanResults) {
            this.mPackageNameToApexModuleName = new ArrayMap();
            this.mApexModuleNameToActivePackageName = new ArrayMap();
            Iterator<ScanResult> r0 = scanResults.iterator();
        L4:
            if (r0.hasNext() == false) goto L38;
            ScanResult scanResult = r0.next();
            ApexInfo ai = scanResult.apexInfo;
            String packageName = scanResult.packageName;
            Iterator r4 = scanResult.pkg.getApexSystemServices().iterator();
        L7:
            if (r4.hasNext() == false) goto L30;
            ParsedApexSystemService service = (ParsedApexSystemService) r4.next();
            String minSdkVersion = service.getMinSdkVersion();
            if (minSdkVersion == null) goto L13;
            if (UnboundedSdkLevel.isAtLeast(minSdkVersion) == true) goto L13;
            Slog.d(ApexManager.TAG, String.format("ApexSystemService %s with min_sdk_version=%s is skipped", new Object[]{service.getName(), service.getMinSdkVersion()}));
        L13:
            String maxSdkVersion = service.getMaxSdkVersion();
            if (maxSdkVersion == null) goto L19;
            if (UnboundedSdkLevel.isAtMost(maxSdkVersion) == true) goto L19;
            Slog.d(ApexManager.TAG, String.format("ApexSystemService %s with max_sdk_version=%s is skipped", new Object[]{service.getName(), service.getMaxSdkVersion()}));
        L19:
            if (ai.isActive == false) goto L7;
            String name = service.getName();
            int j = 0;
        L22:
            if (j >= this.mApexSystemServices.size()) goto L28;
            ApexSystemServiceInfo info = this.mApexSystemServices.get(j);
            if (info.getName().equals(name) == true) goto L27;
            j = j + 1;
            goto L22
        L27:
            throw new IllegalStateException(TextUtils.formatSimple("Duplicate apex-system-service %s from %s, %s", new Object[]{name, info.mJarPath, service.getJarPath()}));
        L28:
            this.mApexSystemServices.add(new ApexSystemServiceInfo(service.getName(), service.getJarPath(), service.getInitOrder()));
            goto L7
        L30:
            Collections.sort(this.mApexSystemServices);
            this.mPackageNameToApexModuleName.put(packageName, ai.moduleName);
            if (ai.isActive == false) goto L4;
            if (this.mApexModuleNameToActivePackageName.containsKey(ai.moduleName) == true) goto L36;
            this.mApexModuleNameToActivePackageName.put(ai.moduleName, packageName);
            goto L4
        L36:
            throw new IllegalStateException("Two active packages have the same APEX module name: " + ai.moduleName);
        }

        @Override // com.android.server.pm.ApexManager
        public List<ActiveApexInfo> getActiveApexInfos() {
            TimingsTraceAndSlog t = new TimingsTraceAndSlog("ApexManagerTiming", 262144);
            Object r1 = this.mLock;
            monitor-enter(r1);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mActiveApexInfosCache != null) goto L21;
            t.traceBegin("getActiveApexInfos_noCache");     // Catch: Throwable -> L12
            this.mActiveApexInfosCache = new ArraySet();     // Catch: Throwable -> L12 RemoteException -> L14
            ApexInfo[] activePackages = waitForApexService().getActivePackages();     // Catch: Throwable -> L12 RemoteException -> L14
            int i = 0;
        L9:
            if (i >= activePackages.length) goto L19;
            ApexInfo apexInfo = activePackages[i];     // Catch: Throwable -> L12 RemoteException -> L14
            this.mActiveApexInfosCache.add(new ActiveApexInfo(apexInfo));     // Catch: Throwable -> L12 RemoteException -> L14
            i = i + 1;
            goto L9
        L19:
            t.traceEnd();     // Catch: Throwable -> L12
        L14:
            e = move-exception;
            Slog.e(ApexManager.TAG, "Unable to retrieve packages from apexservice", e);     // Catch: Throwable -> L12
        L21:
            if (this.mActiveApexInfosCache == null) goto L25;
            ArrayList r2 = new ArrayList(this.mActiveApexInfosCache);     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            return r2;
        L25:
            List<ActiveApexInfo> r3 = Collections.emptyList();     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            return r3;
        }

        @Override // com.android.server.pm.ApexManager
        public String getActiveApexPackageNameContainingPackage(String containedPackageName) {
            containedPackageName.getClass();
            Object r0 = this.mLock;
            monitor-enter(r0);
        L19:
            th = move-exception;
            throw th;
        L5:
            if (this.mPackageNameToApexModuleName == null) goto L7;
            boolean r1 = true;
        L8:
            Preconditions.checkState(r1, "APEX packages have not been scanned");     // Catch: Throwable -> L19
            int numApksInApex = this.mApksInApex.size();     // Catch: Throwable -> L19
            int apkInApexNum = 0;
        L9:
            if (apkInApexNum >= numApksInApex) goto L24;
            if (this.mApksInApex.valueAt(apkInApexNum).contains(containedPackageName) == false) goto L22;
            String apexModuleName = this.mApksInApex.keyAt(apkInApexNum);     // Catch: Throwable -> L19
            int numApexPkgs = this.mPackageNameToApexModuleName.size();     // Catch: Throwable -> L19
            int apexPkgNum = 0;
        L13:
            if (apexPkgNum >= numApexPkgs) goto L22;
            if (this.mPackageNameToApexModuleName.valueAt(apexPkgNum).equals(apexModuleName) == true) goto L16;
            apexPkgNum = apexPkgNum + 1;     // Catch: Throwable -> L19
            goto L13
        L16:
            String r6 = this.mPackageNameToApexModuleName.keyAt(apexPkgNum);     // Catch: Throwable -> L19
            monitor-exit(r0);     // Catch: Throwable -> L19
            return r6;
        L22:
            apkInApexNum = apkInApexNum + 1;     // Catch: Throwable -> L19
            goto L9
        L24:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return null;
        L7:
            r1 = false;
            goto L8
        }

        @Override // com.android.server.pm.ApexManager
        ApexSessionInfo getStagedSessionInfo(int sessionId) {
            ApexSessionInfo apexSessionInfo = waitForApexService().getStagedSessionInfo(sessionId);     // Catch: RemoteException -> L7
            if (apexSessionInfo.isUnknown == false) goto L6;
            return null;
        L6:
            return apexSessionInfo;
        L7:
            re = move-exception;
            Slog.e(ApexManager.TAG, "Unable to contact apexservice", re);
            return null;
        }

        @Override // com.android.server.pm.ApexManager
        SparseArray<ApexSessionInfo> getSessions() {
            ApexSessionInfo[] sessions = waitForApexService().getSessions();     // Catch: RemoteException -> L7
            SparseArray<ApexSessionInfo> result = new SparseArray(sessions.length);     // Catch: RemoteException -> L7
            int i = 0;
        L4:
            if (i >= sessions.length) goto L10;
            result.put(sessions[i].sessionId, sessions[i]);     // Catch: RemoteException -> L7
            i = i + 1;
            goto L4
        L10:
            return result;
        L7:
            re = move-exception;
            Slog.e(ApexManager.TAG, "Unable to contact apexservice", re);
            return new SparseArray(0);
        }

        @Override // com.android.server.pm.ApexManager
        ApexInfoList submitStagedSession(ApexSessionParams params) throws PackageManagerException {
            ApexInfoList apexInfoList = new ApexInfoList();     // Catch: Exception -> L5 RemoteException -> L7
            waitForApexService().submitStagedSession(params, apexInfoList);     // Catch: Exception -> L5 RemoteException -> L7
            return apexInfoList;
        L7:
            re = move-exception;
            Slog.e(ApexManager.TAG, "Unable to contact apexservice", re);
            throw new PackageManagerException(-22, "apexd verification failed : " + re.getMessage());
        L5:
            e = move-exception;
            throw new PackageManagerException(-22, "apexd verification failed : " + e.getMessage());
        }

        @Override // com.android.server.pm.ApexManager
        ApexInfo[] getStagedApexInfos(ApexSessionParams params) {
            return waitForApexService().getStagedApexInfos(params);
        L7:
            re = move-exception;
            Slog.w(ApexManager.TAG, "Unable to contact apexservice" + re.getMessage());
            return new ApexInfo[0];
        L5:
            e = move-exception;
            Slog.w(ApexManager.TAG, "Failed to collect staged apex infos" + e.getMessage());
            return new ApexInfo[0];
        }

        @Override // com.android.server.pm.ApexManager
        void markStagedSessionReady(int sessionId) throws PackageManagerException {
            waitForApexService().markStagedSessionReady(sessionId);     // Catch: Exception -> L5 RemoteException -> L7
            return;
        L7:
            re = move-exception;
            Slog.e(ApexManager.TAG, "Unable to contact apexservice", re);
            throw new PackageManagerException(-22, "Failed to mark apexd session as ready : " + re.getMessage());
        L5:
            e = move-exception;
            throw new PackageManagerException(-22, "Failed to mark apexd session as ready : " + e.getMessage());
        }

        @Override // com.android.server.pm.ApexManager
        void markStagedSessionSuccessful(int sessionId) {
            waitForApexService().markStagedSessionSuccessful(sessionId);     // Catch: Exception -> L5 RemoteException -> L7
        L15:
            return;
        L7:
            re = move-exception;
            Slog.e(ApexManager.TAG, "Unable to contact apexservice", re);
            throw new RuntimeException(re);
        L5:
            e = move-exception;
            Slog.e(ApexManager.TAG, "Failed to mark session " + sessionId + " as successful", e);
        }

        @Override // com.android.server.pm.ApexManager
        boolean isApexSupported() {
            return true;
        }

        @Override // com.android.server.pm.ApexManager
        boolean revertActiveSessions() {
            waitForApexService().revertActiveSessions();     // Catch: Exception -> L6 RemoteException -> L8
            return true;
        L8:
            re = move-exception;
            Slog.e(ApexManager.TAG, "Unable to contact apexservice", re);
            return false;
        L6:
            e = move-exception;
            Slog.e(ApexManager.TAG, e.getMessage(), e);
            return false;
        }

        @Override // com.android.server.pm.ApexManager
        boolean abortStagedSession(int sessionId) {
            waitForApexService().abortStagedSession(sessionId);     // Catch: Exception -> L5
            return true;
        L5:
            e = move-exception;
            Slog.e(ApexManager.TAG, e.getMessage(), e);
            return false;
        }

        @Override // com.android.server.pm.ApexManager
        boolean uninstallApex(String apexPackagePath) {
            waitForApexService().unstagePackages(Collections.singletonList(apexPackagePath));     // Catch: Exception -> L5
            return true;
        L6:
            return false;
        }

        @Override // com.android.server.pm.ApexManager
        void registerApkInApex(AndroidPackage pkg) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            Iterator<ActiveApexInfo> r1 = this.mActiveApexInfosCache.iterator();     // Catch: Throwable -> L12
        L6:
            if (r1.hasNext() == false) goto L16;
            ActiveApexInfo aai = r1.next();     // Catch: Throwable -> L12
            if (pkg.getBaseApkPath().startsWith(aai.apexDirectory.getAbsolutePath() + File.separator) == false) goto L6;
            List<String> apks = this.mApksInApex.get(aai.apexModuleName);     // Catch: Throwable -> L12
            if (apks != null) goto L14;
            apks = Lists.newArrayList();     // Catch: Throwable -> L12
            this.mApksInApex.put(aai.apexModuleName, apks);     // Catch: Throwable -> L12
        L14:
            Slog.i(ApexManager.TAG, "Registering " + pkg.getPackageName() + " as apk-in-apex of " + aai.apexModuleName);     // Catch: Throwable -> L12
            apks.add(pkg.getPackageName());     // Catch: Throwable -> L12
            goto L6
        L16:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.ApexManager
        void reportErrorWithApkInApex(String scanDirPath, String errorMsg) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            Iterator<ActiveApexInfo> r1 = this.mActiveApexInfosCache.iterator();     // Catch: Throwable -> L10
        L6:
            if (r1.hasNext() == false) goto L13;
            ActiveApexInfo aai = r1.next();     // Catch: Throwable -> L10
            if (scanDirPath.startsWith(aai.apexDirectory.getAbsolutePath()) == false) goto L6;
            this.mErrorWithApkInApex.put(aai.apexModuleName, errorMsg);     // Catch: Throwable -> L10
            goto L6
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.pm.ApexManager
        String getApkInApexInstallError(String apexPackageName) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.mPackageNameToApexModuleName == null) goto L7;
            boolean r1 = true;
        L8:
            Preconditions.checkState(r1, "APEX packages have not been scanned");     // Catch: Throwable -> L13
            String moduleName = this.mPackageNameToApexModuleName.get(apexPackageName);     // Catch: Throwable -> L13
            if (moduleName != null) goto L15;
            monitor-exit(r0);     // Catch: Throwable -> L13
            return null;
        L15:
            String r2 = this.mErrorWithApkInApex.get(moduleName);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return r2;
        L7:
            r1 = false;
            goto L8
        }

        @Override // com.android.server.pm.ApexManager
        public List<String> getApksInApex(String apexPackageName) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L13:
            th = move-exception;
            throw th;
        L5:
            if (this.mPackageNameToApexModuleName == null) goto L7;
            boolean r1 = true;
        L8:
            Preconditions.checkState(r1, "APEX packages have not been scanned");     // Catch: Throwable -> L13
            String moduleName = this.mPackageNameToApexModuleName.get(apexPackageName);     // Catch: Throwable -> L13
            if (moduleName != null) goto L15;
            List<String> r2 = Collections.emptyList();     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return r2;
        L15:
            List<String> r3 = this.mApksInApex.getOrDefault(moduleName, Collections.emptyList());     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            return r3;
        L7:
            r1 = false;
            goto L8
        }

        @Override // com.android.server.pm.ApexManager
        public String getApexModuleNameForPackageName(String apexPackageName) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mPackageNameToApexModuleName == null) goto L7;
            boolean r1 = true;
        L8:
            Preconditions.checkState(r1, "APEX packages have not been scanned");     // Catch: Throwable -> L11
            String r2 = this.mPackageNameToApexModuleName.get(apexPackageName);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L7:
            r1 = false;
            goto L8
        }

        @Override // com.android.server.pm.ApexManager
        public String getActivePackageNameForApexModuleName(String apexModuleName) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mApexModuleNameToActivePackageName == null) goto L7;
            boolean r1 = true;
        L8:
            Preconditions.checkState(r1, "APEX packages have not been scanned");     // Catch: Throwable -> L11
            String r2 = this.mApexModuleNameToActivePackageName.get(apexModuleName);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L7:
            r1 = false;
            goto L8
        }

        @Override // com.android.server.pm.ApexManager
        public boolean snapshotCeData(int userId, int rollbackId, String apexPackageName) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L18:
            th = move-exception;
            throw th;
        L5:
            if (this.mPackageNameToApexModuleName == null) goto L7;
            boolean r1 = true;
        L8:
            Preconditions.checkState(r1, "APEX packages have not been scanned");     // Catch: Throwable -> L18
            String apexModuleName = this.mPackageNameToApexModuleName.get(apexPackageName);     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
            if (apexModuleName != null) goto L21;
            Slog.e(ApexManager.TAG, "Invalid apex package name: " + apexPackageName);
            return false;
        L21:
            waitForApexService().snapshotCeData(userId, rollbackId, apexModuleName);     // Catch: Exception -> L15
            return true;
        L15:
            e = move-exception;
            Slog.e(ApexManager.TAG, e.getMessage(), e);
            return false;
        L7:
            r1 = false;
            goto L8
        }

        @Override // com.android.server.pm.ApexManager
        public boolean restoreCeData(int userId, int rollbackId, String apexPackageName) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L18:
            th = move-exception;
            throw th;
        L5:
            if (this.mPackageNameToApexModuleName == null) goto L7;
            boolean r1 = true;
        L8:
            Preconditions.checkState(r1, "APEX packages have not been scanned");     // Catch: Throwable -> L18
            String apexModuleName = this.mPackageNameToApexModuleName.get(apexPackageName);     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
            if (apexModuleName != null) goto L21;
            Slog.e(ApexManager.TAG, "Invalid apex package name: " + apexPackageName);
            return false;
        L21:
            waitForApexService().restoreCeData(userId, rollbackId, apexModuleName);     // Catch: Exception -> L15
            return true;
        L15:
            e = move-exception;
            Slog.e(ApexManager.TAG, e.getMessage(), e);
            return false;
        L7:
            r1 = false;
            goto L8
        }

        @Override // com.android.server.pm.ApexManager
        public boolean destroyDeSnapshots(int rollbackId) {
            waitForApexService().destroyDeSnapshots(rollbackId);     // Catch: Exception -> L5
            return true;
        L5:
            e = move-exception;
            Slog.e(ApexManager.TAG, e.getMessage(), e);
            return false;
        }

        @Override // com.android.server.pm.ApexManager
        public boolean destroyCeSnapshots(int userId, int rollbackId) {
            waitForApexService().destroyCeSnapshots(userId, rollbackId);     // Catch: Exception -> L5
            return true;
        L5:
            e = move-exception;
            Slog.e(ApexManager.TAG, e.getMessage(), e);
            return false;
        }

        @Override // com.android.server.pm.ApexManager
        public boolean destroyCeSnapshotsNotSpecified(int userId, int[] retainRollbackIds) {
            waitForApexService().destroyCeSnapshotsNotSpecified(userId, retainRollbackIds);     // Catch: Exception -> L5
            return true;
        L5:
            e = move-exception;
            Slog.e(ApexManager.TAG, e.getMessage(), e);
            return false;
        }

        @Override // com.android.server.pm.ApexManager
        public void markBootCompleted() {
            waitForApexService().markBootCompleted();     // Catch: RemoteException -> L4
            return;
        L4:
            re = move-exception;
            Slog.e(ApexManager.TAG, "Unable to contact apexservice", re);
        }

        @Override // com.android.server.pm.ApexManager
        public long calculateSizeForCompressedApex(CompressedApexInfoList infoList) throws RemoteException {
            return waitForApexService().calculateSizeForCompressedApex(infoList);
        }

        @Override // com.android.server.pm.ApexManager
        public void reserveSpaceForCompressedApex(CompressedApexInfoList infoList) throws RemoteException {
            waitForApexService().reserveSpaceForCompressedApex(infoList);
        }

        private SigningDetails getSigningDetails(PackageInfo pkg) throws PackageManagerException {
            int minSignatureScheme = ApkSignatureVerifier.getMinimumSignatureSchemeVersionForTargetSdk(pkg.applicationInfo.targetSdkVersion);
            ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
            ParseResult<SigningDetails> result = ApkSignatureVerifier.verify(input, pkg.applicationInfo.sourceDir, minSignatureScheme);
            if (result.isError() == true) goto L7;
            return (SigningDetails) result.getResult();
        L7:
            throw new PackageManagerException(result.getErrorCode(), result.getErrorMessage(), result.getException());
        }

        private void checkApexSignature(PackageInfo existingApexPkg, PackageInfo newApexPkg) throws PackageManagerException {
            SigningDetails existingSigningDetails = getSigningDetails(existingApexPkg);
            SigningDetails newSigningDetails = getSigningDetails(newApexPkg);
            if (newSigningDetails.checkCapability(existingSigningDetails, 1) == false) goto L6;
            return;
        L6:
            throw new PackageManagerException(-118, "APK container signature of " + newApexPkg.applicationInfo.sourceDir + " is not compatible with currently installed on device");
        }

        @Override // com.android.server.pm.ApexManager
        ApexInfo installPackage(File apexFile, boolean force) throws PackageManagerException {
            return waitForApexService().installAndActivatePackage(apexFile.getAbsolutePath(), force);
        L5:
            e = move-exception;
            throw new PackageManagerException(-110, e.getMessage());
        L12:
            throw new PackageManagerException(-110, "apexservice not available");
        }

        @Override // com.android.server.pm.ApexManager
        public List<ApexSystemServiceInfo> getApexSystemServices() {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.mApexSystemServices == null) goto L7;
            boolean r1 = true;
        L8:
            Preconditions.checkState(r1, "APEX packages have not been scanned");     // Catch: Throwable -> L11
            List<ApexSystemServiceInfo> r2 = this.mApexSystemServices;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L7:
            r1 = false;
            goto L8
        }

        @Override // com.android.server.pm.ApexManager
        public File getBackingApexFile(File file) {
            Path path = file.toPath();
            if (path.startsWith(Environment.getApexDirectory().toPath()) == true) goto L6;
            return null;
        L6:
            if (path.getNameCount() >= 2) goto L8;
            return null;
        L8:
            String moduleName = file.toPath().getName(1).toString();
            List<ActiveApexInfo> apexes = getActiveApexInfos();
            int i = 0;
        L10:
            if (i >= apexes.size()) goto L17;
            if (apexes.get(i).apexModuleName.equals(moduleName) == true) goto L14;
            i = i + 1;
            goto L10
        L14:
            return apexes.get(i).apexFile;
        L17:
            return null;
        }

        @Override // com.android.server.pm.ApexManager
        void dump(PrintWriter pw) {
            IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ", 120);
            ipw.println();     // Catch: RemoteException -> L8
            ipw.println("APEX session state:");     // Catch: RemoteException -> L8
            ipw.increaseIndent();     // Catch: RemoteException -> L8
            ApexSessionInfo[] sessions = waitForApexService().getSessions();     // Catch: RemoteException -> L8
            int r2 = sessions.length;     // Catch: RemoteException -> L8
            int r3 = 0;
        L4:
            if (r3 >= r2) goto L35;
            ApexSessionInfo si = sessions[r3];     // Catch: RemoteException -> L8
            ipw.println("Session ID: " + si.sessionId);     // Catch: RemoteException -> L8
            ipw.increaseIndent();     // Catch: RemoteException -> L8
            if (si.isUnknown == false) goto L11;
            ipw.println("State: UNKNOWN");     // Catch: RemoteException -> L8
        L34:
            ipw.decreaseIndent();     // Catch: RemoteException -> L8
            r3 = r3 + 1;     // Catch: RemoteException -> L8
            goto L4
        L11:
            if (si.isVerified == false) goto L14;
            ipw.println("State: VERIFIED");     // Catch: RemoteException -> L8
            goto L34
        L14:
            if (si.isStaged == false) goto L17;
            ipw.println("State: STAGED");     // Catch: RemoteException -> L8
            goto L34
        L17:
            if (si.isActivated == false) goto L20;
            ipw.println("State: ACTIVATED");     // Catch: RemoteException -> L8
            goto L34
        L20:
            if (si.isActivationFailed == false) goto L23;
            ipw.println("State: ACTIVATION FAILED");     // Catch: RemoteException -> L8
            goto L34
        L23:
            if (si.isSuccess == false) goto L26;
            ipw.println("State: SUCCESS");     // Catch: RemoteException -> L8
            goto L34
        L26:
            if (si.isRevertInProgress == false) goto L29;
            ipw.println("State: REVERT IN PROGRESS");     // Catch: RemoteException -> L8
            goto L34
        L29:
            if (si.isReverted == false) goto L32;
            ipw.println("State: REVERTED");     // Catch: RemoteException -> L8
            goto L34
        L32:
            if (si.isRevertFailed == false) goto L34;
            ipw.println("State: REVERT FAILED");     // Catch: RemoteException -> L8
            goto L34
        L35:
            ipw.decreaseIndent();     // Catch: RemoteException -> L8
            ipw.println();     // Catch: RemoteException -> L8
            return;
        L37:
            ipw.println("Couldn't communicate with apexd.");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface PackageInfoFlags {
    }

    static class ScanResult {
        public final ApexInfo apexInfo;
        public final String packageName;
        public final AndroidPackage pkg;

        ScanResult(ApexInfo apexInfo, AndroidPackage pkg, String packageName) {
            this.apexInfo = apexInfo;
            this.pkg = pkg;
            this.packageName = packageName;
        }
    }

    abstract boolean abortStagedSession(int r1);

    public abstract long calculateSizeForCompressedApex(CompressedApexInfoList r1) throws RemoteException;

    public abstract boolean destroyCeSnapshots(int r1, int r2);

    public abstract boolean destroyCeSnapshotsNotSpecified(int r1, int[] r2);

    public abstract boolean destroyDeSnapshots(int r1);

    abstract void dump(PrintWriter r1);

    public abstract List<ActiveApexInfo> getActiveApexInfos();

    public abstract String getActiveApexPackageNameContainingPackage(String r1);

    public abstract String getActivePackageNameForApexModuleName(String r1);

    abstract ApexInfo[] getAllApexInfos();

    public abstract String getApexModuleNameForPackageName(String r1);

    public abstract List<ApexSystemServiceInfo> getApexSystemServices();

    abstract String getApkInApexInstallError(String r1);

    public abstract List<String> getApksInApex(String r1);

    public abstract File getBackingApexFile(File r1);

    abstract SparseArray<ApexSessionInfo> getSessions();

    abstract ApexInfo[] getStagedApexInfos(ApexSessionParams r1);

    abstract ApexSessionInfo getStagedSessionInfo(int r1);

    abstract ApexInfo installPackage(File r1, boolean r2) throws PackageManagerException;

    abstract boolean isApexSupported();

    public abstract void markBootCompleted();

    abstract void markStagedSessionReady(int r1) throws PackageManagerException;

    abstract void markStagedSessionSuccessful(int r1);

    abstract void notifyScanResult(List<ScanResult> r1);

    abstract void registerApkInApex(AndroidPackage r1);

    abstract void reportErrorWithApkInApex(String r1, String r2);

    public abstract void reserveSpaceForCompressedApex(CompressedApexInfoList r1) throws RemoteException;

    public abstract boolean restoreCeData(int r1, int r2, String r3);

    abstract boolean revertActiveSessions();

    public abstract boolean snapshotCeData(int r1, int r2, String r3);

    abstract ApexInfoList submitStagedSession(ApexSessionParams r1) throws PackageManagerException;

    abstract boolean uninstallApex(String r1);

    public ApexManager() {
    }

    static {
        sApexManagerSingleton = new AnonymousClass1();
    }

    public static ApexManager getInstance() {
        return (ApexManager) sApexManagerSingleton.get();
    }
}
