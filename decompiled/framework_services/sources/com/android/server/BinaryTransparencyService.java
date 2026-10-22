package com.android.server;

import android.apex.ApexInfo;
import android.apex.IApexService;
import android.app.compat.CompatChanges;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.IBackgroundInstallControlService;
import android.content.pm.IPackageManagerNative;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ParceledListSlice;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.content.pm.parsing.result.ParseResult;
import android.content.pm.parsing.result.ParseTypeImpl;
import android.hardware.biometrics.SensorProperties;
import android.hardware.face.FaceManager;
import android.hardware.fingerprint.FingerprintManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IRemoteCallback;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.ShellCallback;
import android.os.SystemProperties;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.util.PackageUtils;
import android.util.Slog;
import android.util.apk.ApkSignatureVerifier;
import com.android.internal.os.IBinaryTransparencyService;
import com.android.internal.util.FrameworkStatsLog;
import com.android.modules.expresslog.Histogram;
import com.android.server.pm.ApexManager;
import com.android.server.pm.BackgroundInstallControlCallbackHelper;
import com.android.server.pm.Settings;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.AndroidPackageSplit;
import com.android.server.pm.pkg.PackageState;
import com.android.server.pm.pkg.PackageStateInternal;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import libcore.util.HexEncoding;

/* JADX INFO: loaded from: classes.dex */
public class BinaryTransparencyService extends SystemService {
    static final String APEX_PRELOAD_LOCATION_ERROR = "could-not-be-determined";
    static final String BINARY_HASH_ERROR = "SHA256HashError";
    private static final boolean DEBUG = false;
    static final int DIGEST_ALGORITHM_CHUNKED_SHA256 = 1;
    static final int DIGEST_ALGORITHM_CHUNKED_SHA512 = 2;
    static final int DIGEST_ALGORITHM_SHA256 = 4;
    static final int DIGEST_ALGORITHM_UNKNOWN = 0;
    static final int DIGEST_ALGORITHM_VERITY_CHUNKED_SHA256 = 3;
    static final String KEY_ENABLE_BIOMETRIC_PROPERTY_VERIFICATION = "enable_biometric_property_verification";
    public static final long LOG_MBA_INFO = 245692487;
    static final int MBA_STATUS_DOWNGRADED_PRELOADED = 5;
    static final int MBA_STATUS_ERROR = 0;
    static final int MBA_STATUS_NEW_INSTALL = 3;
    static final int MBA_STATUS_PRELOADED = 1;
    static final int MBA_STATUS_UNINSTALLED = 6;
    static final int MBA_STATUS_UPDATED_NEW_INSTALL = 4;
    static final int MBA_STATUS_UPDATED_PRELOAD = 2;
    static final long RECORD_MEASUREMENTS_COOLDOWN_MS = 86400000;
    static final String SYSPROP_NAME_VBETA_DIGEST = "ro.boot.vbmeta.digest";
    private static final String TAG = "TransparencyService";
    static final String VBMETA_DIGEST_UNAVAILABLE = "vbmeta-digest-unavailable";
    static final String VBMETA_DIGEST_UNINITIALIZED = "vbmeta-digest-uninitialized";
    private static final Histogram digestAllPackagesLatency = null;
    private BiometricLogger mBiometricLogger;
    private final Context mContext;
    private long mMeasurementsLastRecordedMs;
    private PackageManagerInternal mPackageManagerInternal;
    private final BinaryTransparencyServiceImpl mServiceImpl;
    private String mVbmetaDigest;

    static class BicCallbackHandler extends IRemoteCallback.Stub {
        private static final String BIC_CALLBACK_HANDLER_TAG = "TransparencyService.BicCallbackHandler";
        private static final int INSTALL_EVENT_TYPE_UNSET = -1;
        private final IBicAppInfoHelper mBicAppInfoHelper;

        public interface IBicAppInfoHelper {
            List<IBinaryTransparencyService.AppInfo> collectAppInfo(PackageState r1, int r2);

            void writeAppInfoToLog(IBinaryTransparencyService.AppInfo r1);
        }

        BicCallbackHandler(IBicAppInfoHelper bicAppInfoHelper) {
            this.mBicAppInfoHelper = bicAppInfoHelper;
        }

        public void sendResult(Bundle data) {
            String packageName = data.getString("packageName");
            int installType = data.getInt(BackgroundInstallControlCallbackHelper.INSTALL_EVENT_TYPE_KEY, -1);
            if (packageName == null) goto L25;
            if (installType == (-1)) goto L25;
            Slog.d(BIC_CALLBACK_HANDLER_TAG, "Detected new bic event for: " + packageName);
            if (installType != 1) goto L21;
            PackageState packageState = ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getPackageStateInternal(packageName);
            if (packageState != null) goto L12;
            Slog.w(BinaryTransparencyService.TAG, "Package state is unavailable, ignoring the package " + packageName);
            return;
        L12:
            int mbaStatus = 3;
            if (packageState.isUpdatedSystemApp() == false) goto L15;
            mbaStatus = 2;
        L15:
            List<IBinaryTransparencyService.AppInfo> mbaInfo = this.mBicAppInfoHelper.collectAppInfo(packageState, mbaStatus);
            Iterator<IBinaryTransparencyService.AppInfo> r5 = mbaInfo.iterator();
        L17:
            if (r5.hasNext() == false) goto L29;
            this.mBicAppInfoHelper.writeAppInfoToLog(r5.next());
            goto L17
        L29:
            return;
        L21:
            if (installType != 2) goto L23;
            IBinaryTransparencyService.AppInfo appInfo = new IBinaryTransparencyService.AppInfo();
            appInfo.packageName = packageName;
            appInfo.mbaStatus = 6;
            this.mBicAppInfoHelper.writeAppInfoToLog(appInfo);
            return;
        L23:
            Slog.w(BIC_CALLBACK_HANDLER_TAG, "Unsupported BIC event: " + installType);
            return;
        L25:
            Slog.w(BIC_CALLBACK_HANDLER_TAG, "Package name or install type is unavailable, ignoring event");
        }
    }

    final class BinaryTransparencyServiceImpl extends IBinaryTransparencyService.Stub {
        final /* synthetic */ BinaryTransparencyService this$0;

        public static /* synthetic */ void $r8$lambda$58CMMcIqENiHOUXAvwp4EzIrOIw(BinaryTransparencyServiceImpl r0, Bundle r1, ArrayList r2, PackageStateInternal r3) {
            r0.lambda$collectAllUpdatedPreloadInfo$0(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$mcomputeApkContentDigest, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m136$$Nest$mcomputeApkContentDigest(BinaryTransparencyServiceImpl r0, String r1) {
            return r0.computeApkContentDigest(r1);
        }

        BinaryTransparencyServiceImpl(BinaryTransparencyService this$0) {
            this.this$0 = this$0;
        }

        public String getSignedImageInfo() {
            return BinaryTransparencyService.m122$$Nest$fgetmVbmetaDigest(this.this$0);
        }

        private String[] computePackageSignerSha256Digests(SigningInfo signingInfo) {
            if (signingInfo != null) goto L5;
            Slog.e(BinaryTransparencyService.TAG, "signingInfo is null");
            return null;
        L5:
            Signature[] packageSigners = signingInfo.getApkContentsSigners();
            List<String> resultList = new ArrayList();
            int r2 = packageSigners.length;
            int r4 = 0;
        L6:
            if (r4 >= r2) goto L9;
            Signature packageSigner = packageSigners[r4];
            byte[] digest = PackageUtils.computeSha256DigestBytes(packageSigner.toByteArray());
            String digestHexString = HexEncoding.encodeToString(digest, false);
            resultList.add(digestHexString);
            r4 = r4 + 1;
            goto L6
        L9:
            return (String[]) resultList.toArray(new String[1]);
        }

        List<IBinaryTransparencyService.AppInfo> collectAppInfo(PackageState packageState, int mbaStatus) {
            ArrayList<IBinaryTransparencyService.AppInfo> results = new ArrayList();
            String packageName = packageState.getPackageName();
            long versionCode = packageState.getVersionCode();
            String[] signerDigests = computePackageSignerSha256Digests(packageState.getSigningInfo());
            AndroidPackage pkg = packageState.getAndroidPackage();
            if (pkg == null) goto L9;
            Iterator r6 = pkg.getSplits().iterator();
        L6:
            if (r6.hasNext() == false) goto L10;
            AndroidPackageSplit split = (AndroidPackageSplit) r6.next();
            IBinaryTransparencyService.AppInfo appInfo = new IBinaryTransparencyService.AppInfo();
            appInfo.packageName = packageName;
            appInfo.longVersion = versionCode;
            appInfo.splitName = split.getName();
            appInfo.signerDigests = signerDigests;
            appInfo.mbaStatus = mbaStatus;
            Digest digest = measureApk(split.getPath());
            appInfo.digest = digest.value();
            appInfo.digestAlgorithm = digest.algorithm();
            results.add(appInfo);
        L10:
            IBinaryTransparencyService.AppInfo base = results.get(0);
            InstallSourceInfo installSourceInfo = BinaryTransparencyService.m126$$Nest$mgetInstallSourceInfo(this.this$0, packageState.getPackageName());
            if (installSourceInfo == null) goto L16;
            base.initiator = installSourceInfo.getInitiatingPackageName();
            SigningInfo initiatorSignerInfo = installSourceInfo.getInitiatingPackageSigningInfo();
            if (initiatorSignerInfo == null) goto L15;
            base.initiatorSignerDigests = computePackageSignerSha256Digests(initiatorSignerInfo);
        L15:
            base.installer = installSourceInfo.getInstallingPackageName();
            base.originator = installSourceInfo.getOriginatingPackageName();
        L16:
            return results;
        L9:
            Slog.w(BinaryTransparencyService.TAG, packageName + " APK file is not physically present, skipping split and digest measurement");
            IBinaryTransparencyService.AppInfo appInfo2 = new IBinaryTransparencyService.AppInfo();
            appInfo2.packageName = packageName;
            appInfo2.longVersion = versionCode;
            appInfo2.signerDigests = signerDigests;
            appInfo2.mbaStatus = mbaStatus;
            results.add(appInfo2);
            goto L10
        }

        private Digest measureApk(String apkPath) {
            Map<Integer, byte[]> contentDigests = computeApkContentDigest(apkPath);
            BinaryTransparencyServiceIA r1 = null;
            if (contentDigests != null) goto L5;
            Slog.d(BinaryTransparencyService.TAG, "Failed to compute content digest for " + apkPath);
        L13:
            byte[] digest = PackageUtils.computeSha256DigestForLargeFileAsBytes(apkPath, PackageUtils.createLargeFileBuffer());
            return new Digest(4, digest, r1);
        L5:
            int r2 = 1;
            if (contentDigests.containsKey(1) == true) goto L8;
            int r3 = 2;
            if (contentDigests.containsKey(2) == false) goto L13;
            return new Digest(r3, contentDigests.get(2), r1);
        L8:
            return new Digest(r2, contentDigests.get(1), r1);
        }

        public void recordMeasurementsForAllPackages() {
            long currentTimeMs = System.currentTimeMillis();
            if ((currentTimeMs - BinaryTransparencyService.m119$$Nest$fgetmMeasurementsLastRecordedMs(this.this$0)) >= 86400000) goto L6;
            Slog.d(BinaryTransparencyService.TAG, "Skip measurement since the last measurement was only taken at " + BinaryTransparencyService.m119$$Nest$fgetmMeasurementsLastRecordedMs(this.this$0) + " within the cooldown period");
            return;
        L6:
            Slog.d(BinaryTransparencyService.TAG, "Measurement was last taken at " + BinaryTransparencyService.m119$$Nest$fgetmMeasurementsLastRecordedMs(this.this$0) + " and is now updated to: " + currentTimeMs);
            BinaryTransparencyService.m123$$Nest$fputmMeasurementsLastRecordedMs(this.this$0, currentTimeMs);
            Bundle packagesMeasured = new Bundle();
            List<IBinaryTransparencyService.ApexInfo> allApexInfo = collectAllApexInfo(false);
            Iterator<IBinaryTransparencyService.ApexInfo> r4 = allApexInfo.iterator();
        L8:
            if (r4.hasNext() == false) goto L10;
            IBinaryTransparencyService.ApexInfo apexInfo = r4.next();
            packagesMeasured.putBoolean(apexInfo.packageName, true);
            recordApexInfo(apexInfo);
            goto L8
        L10:
            List<IBinaryTransparencyService.AppInfo> allUpdatedPreloadInfo = collectAllUpdatedPreloadInfo(packagesMeasured);
            Iterator<IBinaryTransparencyService.AppInfo> r5 = allUpdatedPreloadInfo.iterator();
        L12:
            if (r5.hasNext() == false) goto L15;
            IBinaryTransparencyService.AppInfo appInfo = r5.next();
            packagesMeasured.putBoolean(appInfo.packageName, true);
            writeAppInfoToLog(appInfo);
            goto L12
        L15:
            if (CompatChanges.isChangeEnabled(BinaryTransparencyService.LOG_MBA_INFO) == false) goto L20;
            List<IBinaryTransparencyService.AppInfo> allMbaInfo = collectAllSilentInstalledMbaInfo(packagesMeasured);
            Iterator<IBinaryTransparencyService.AppInfo> r7 = allMbaInfo.iterator();
        L18:
            if (r7.hasNext() == false) goto L20;
            IBinaryTransparencyService.AppInfo appInfo2 = r7.next();
            packagesMeasured.putBoolean(appInfo2.packageName, true);
            writeAppInfoToLog(appInfo2);
        L20:
            long timeSpentMeasuring = System.currentTimeMillis() - currentTimeMs;
            BinaryTransparencyService.m135$$Nest$sfgetdigestAllPackagesLatency().logSample(timeSpentMeasuring);
        }

        public List<IBinaryTransparencyService.ApexInfo> collectAllApexInfo(boolean includeTestOnly) {
            ArrayList<IBinaryTransparencyService.ApexInfo> results = new ArrayList();
            Iterator r1 = BinaryTransparencyService.m125$$Nest$mgetCurrentInstalledApexs(this.this$0).iterator();
        L4:
            if (r1.hasNext() == false) goto L18;
            PackageInfo packageInfo = (PackageInfo) r1.next();
            PackageState packageState = BinaryTransparencyService.m120$$Nest$fgetmPackageManagerInternal(this.this$0).getPackageStateInternal(packageInfo.packageName);
            if (packageState == null) goto L7;
            AndroidPackage pkg = packageState.getAndroidPackage();
            if (pkg == null) goto L10;
            Digest apexChecksum = measureApk(pkg.getPath());
            if (apexChecksum == null) goto L13;
            IBinaryTransparencyService.ApexInfo apexInfo = new IBinaryTransparencyService.ApexInfo();
            apexInfo.packageName = packageState.getPackageName();
            apexInfo.longVersion = packageState.getVersionCode();
            apexInfo.digest = apexChecksum.value();
            apexInfo.digestAlgorithm = apexChecksum.algorithm();
            apexInfo.signerDigests = computePackageSignerSha256Digests(packageState.getSigningInfo());
            if (includeTestOnly == false) goto L17;
            apexInfo.moduleName = BinaryTransparencyService.m124$$Nest$mapexPackageNameToModuleName(this.this$0, packageState.getPackageName());
        L17:
            results.add(apexInfo);
            goto L4
        L13:
            Slog.w(BinaryTransparencyService.TAG, "Skipping the missing APEX in " + pkg.getPath());
            goto L4
        L10:
            Slog.w(BinaryTransparencyService.TAG, "Skipping the missing APK in " + pkg.getPath());
            goto L4
        L7:
            Slog.w(BinaryTransparencyService.TAG, "Package state is unavailable, ignoring the APEX " + packageInfo.packageName);
            goto L4
        L18:
            return results;
        }

        public List<IBinaryTransparencyService.AppInfo> collectAllUpdatedPreloadInfo(final Bundle packagesToSkip) {
            final ArrayList<IBinaryTransparencyService.AppInfo> results = new ArrayList();
            BinaryTransparencyService.m118$$Nest$fgetmContext(this.this$0).getPackageManager();
            BinaryTransparencyService.m120$$Nest$fgetmPackageManagerInternal(this.this$0).forEachPackageState(new BinaryTransparencyService$BinaryTransparencyServiceImpl$$ExternalSyntheticLambda0(this, packagesToSkip, results));
            return results;
        }

        private /* synthetic */ void lambda$collectAllUpdatedPreloadInfo$0(Bundle packagesToSkip, ArrayList results, PackageStateInternal packageState) {
            if (packageState.isUpdatedSystemApp() == true) goto L6;
            return;
        L6:
            if (packagesToSkip.containsKey(packageState.getPackageName()) == false) goto L8;
            return;
        L8:
            Slog.d(BinaryTransparencyService.TAG, "Preload " + packageState.getPackageName() + " at " + packageState.getPath() + " has likely been updated.");
            List<IBinaryTransparencyService.AppInfo> resultsForApp = collectAppInfo(packageState, 2);
            results.addAll(resultsForApp);
        }

        public List<IBinaryTransparencyService.AppInfo> collectAllSilentInstalledMbaInfo(Bundle packagesToSkip) {
            ArrayList<IBinaryTransparencyService.AppInfo> results = new ArrayList();
            Iterator r1 = BinaryTransparencyService.m127$$Nest$mgetNewlyInstalledMbas(this.this$0).iterator();
        L4:
            if (r1.hasNext() == false) goto L12;
            PackageInfo packageInfo = (PackageInfo) r1.next();
            if (packagesToSkip.containsKey(packageInfo.packageName) == true) goto L4;
            PackageState packageState = BinaryTransparencyService.m120$$Nest$fgetmPackageManagerInternal(this.this$0).getPackageStateInternal(packageInfo.packageName);
            if (packageState == null) goto L10;
            List<IBinaryTransparencyService.AppInfo> resultsForApp = collectAppInfo(packageState, 3);
            results.addAll(resultsForApp);
            goto L4
        L10:
            Slog.w(BinaryTransparencyService.TAG, "Package state is unavailable, ignoring the package " + packageInfo.packageName);
            goto L4
        L12:
            return results;
        }

        private void recordApexInfo(IBinaryTransparencyService.ApexInfo apexInfo) {
            String r1 = apexInfo.packageName;
            long r2 = apexInfo.longVersion;
            if (apexInfo.digest == null) goto L5;
            String r4 = HexEncoding.encodeToString(apexInfo.digest, false);
        L6:
            FrameworkStatsLog.write(FrameworkStatsLog.APEX_INFO_GATHERED, r1, r2, r4, apexInfo.digestAlgorithm, apexInfo.signerDigests);
            return;
        L5:
            r4 = null;
            goto L6
        }

        void writeAppInfoToLog(IBinaryTransparencyService.AppInfo appInfo) {
            String r1 = appInfo.packageName;
            long r2 = appInfo.longVersion;
            if (appInfo.digest == null) goto L5;
            String r4 = HexEncoding.encodeToString(appInfo.digest, false);
        L6:
            FrameworkStatsLog.write(FrameworkStatsLog.MOBILE_BUNDLED_APP_INFO_GATHERED, r1, r2, r4, appInfo.digestAlgorithm, appInfo.signerDigests, appInfo.mbaStatus, appInfo.initiator, appInfo.initiatorSignerDigests, appInfo.installer, appInfo.originator, appInfo.splitName);
            return;
        L5:
            r4 = null;
            goto L6
        }

        private Map<Integer, byte[]> computeApkContentDigest(String pathToApk) {
            ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
            ParseResult<ApkSignatureVerifier.SigningDetailsWithDigests> parseResult = ApkSignatureVerifier.verifySignaturesInternal(input, pathToApk, 2, false);
            if (parseResult.isError() == false) goto L7;
            Slog.e(BinaryTransparencyService.TAG, "Failed to compute content digest for " + pathToApk + " due to: " + parseResult.getErrorMessage());
            return null;
        L7:
            return ((ApkSignatureVerifier.SigningDetailsWithDigests) parseResult.getResult()).contentDigests;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) throws RemoteException {
            new AnonymousClass1(this).exec(this, in, out, err, args, callback, resultReceiver);
        }
    }

    public static class BiometricLogger {
        private static final String TAG = "BiometricLogger";
        private static final BiometricLogger sInstance = null;

        static {
            sInstance = new BiometricLogger();
        }

        private BiometricLogger() {
        }

        public static BiometricLogger getInstance() {
            return sInstance;
        }

        public void logStats(int sensorId, int modality, int sensorType, int sensorStrength, String componentId, String hardwareVersion, String firmwareVersion, String serialNumber, String softwareVersion) {
            FrameworkStatsLog.write(FrameworkStatsLog.BIOMETRIC_PROPERTIES_COLLECTED, sensorId, modality, sensorType, sensorStrength, componentId, hardwareVersion, firmwareVersion, serialNumber, softwareVersion);
        }
    }

    private static final class Digest extends Record {
        private final int algorithm;
        private final byte[] value;

        private /* synthetic */ boolean $record$equals(Object r3) {
            if ((r3 instanceof Digest) == false) goto L10;
            Digest r4 = (Digest) r3;
            if (this.algorithm == r4.algorithm) goto L7;
            return false;
        L7:
            if (Objects.equals(this.value, r4.value) == false) goto L13;
            return true;
        L13:
            return false;
        L10:
            return false;
        }

        private /* synthetic */ Object[] $record$getFieldsAsObjects() {
            return new Object[]{Integer.valueOf(this.algorithm), this.value};
        }

        /* synthetic */ Digest(int r1, byte[] r2, BinaryTransparencyServiceIA r3) {
            this(r1, r2);
        }

        private Digest(int algorithm, byte[] value) {
            this.algorithm = algorithm;
            this.value = value;
        }

        public int algorithm() {
            return this.algorithm;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return $record$equals(o);
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return BinaryTransparencyService$Digest$$ExternalSyntheticRecord0.m(this.algorithm, this.value);
        }

        @Override // java.lang.Record
        public final String toString() {
            return BinaryTransparencyService$Digest$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), Digest.class, "algorithm;value");
        }

        public byte[] value() {
            return this.value;
        }
    }

    private class PackageUpdatedReceiver extends BroadcastReceiver {
        final /* synthetic */ BinaryTransparencyService this$0;

        /* synthetic */ PackageUpdatedReceiver(BinaryTransparencyService r1, BinaryTransparencyServiceIA r2) {
            this(r1);
        }

        private PackageUpdatedReceiver(BinaryTransparencyService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction()) == true) goto L5;
            return;
        L5:
            Uri data = intent.getData();
            if (data != null) goto L9;
            Slog.e(BinaryTransparencyService.TAG, "Shouldn't happen: intent data is null!");
            return;
        L9:
            boolean shouldMeasureMba = false;
            if (intent.getBooleanExtra("android.intent.extra.REPLACING", false) == true) goto L13;
            Slog.d(BinaryTransparencyService.TAG, "Not an update. Skipping...");
            return;
        L13:
            String packageName = data.getSchemeSpecificPart();
            if (BinaryTransparencyService.m130$$Nest$misPackagePreloaded(this.this$0, packageName) == false) goto L16;
            shouldMeasureMba = true;
        L16:
            if (shouldMeasureMba == false) goto L18;
        L19:
            Slog.d(BinaryTransparencyService.TAG, packageName + " was updated. Scheduling measurement...");
            UpdateMeasurementsJobService.scheduleBinaryMeasurements(BinaryTransparencyService.m118$$Nest$fgetmContext(this.this$0), this.this$0);
            return;
        L18:
            if (BinaryTransparencyService.m129$$Nest$misPackageAnApex(this.this$0, packageName) == true) goto L19;
        }
    }

    public static class UpdateMeasurementsJobService extends JobService {
        private static final int DO_BINARY_MEASUREMENTS_JOB_ID = 1740526926;
        private static long sTimeLastRanMs;

        public static /* synthetic */ void $r8$lambda$tt6_rfanEtJkinms88SYTnJk44E(UpdateMeasurementsJobService r0, JobParameters r1) {
            r0.lambda$onStartJob$0(r1);
        }

        public UpdateMeasurementsJobService() {
        }

        static {
            sTimeLastRanMs = 0;
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(final JobParameters params) {
            Slog.d(BinaryTransparencyService.TAG, "Job to update binary measurements started.");
            if (params.getJobId() == DO_BINARY_MEASUREMENTS_JOB_ID) goto L6;
            return false;
        L6:
            Executors.defaultThreadFactory().newThread(new BinaryTransparencyService$UpdateMeasurementsJobService$$ExternalSyntheticLambda0(this, params)).start();
            return true;
        }

        private /* synthetic */ void lambda$onStartJob$0(JobParameters params) {
            IBinder b = ServiceManager.getService("transparency");
            IBinaryTransparencyService iBtsService = IBinaryTransparencyService.Stub.asInterface(b);
            iBtsService.recordMeasurementsForAllPackages();     // Catch: RemoteException -> L6
            sTimeLastRanMs = System.currentTimeMillis();
            jobFinished(params, false);
            return;
        L6:
            e = move-exception;
            Slog.e(BinaryTransparencyService.TAG, "Taking binary measurements was interrupted.", e);
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters params) {
            return false;
        }

        static void scheduleBinaryMeasurements(Context context, BinaryTransparencyService service) {
            Slog.i(BinaryTransparencyService.TAG, "Scheduling binary content-digest computation job");
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService(JobScheduler.class);
            if (jobScheduler != null) goto L7;
            Slog.e(BinaryTransparencyService.TAG, "Failed to obtain an instance of JobScheduler.");
            return;
        L7:
            if (jobScheduler.getPendingJob(DO_BINARY_MEASUREMENTS_JOB_ID) == null) goto L10;
            Slog.d(BinaryTransparencyService.TAG, "A measurement job has already been scheduled.");
            return;
        L10:
            long minWaitingPeriodMs = 0;
            if (sTimeLastRanMs == 0) goto L13;
            long minWaitingPeriodMs2 = 86400000 - (System.currentTimeMillis() - sTimeLastRanMs);
            minWaitingPeriodMs = Math.max(0, Math.min(minWaitingPeriodMs2, 86400000));
            Slog.d(BinaryTransparencyService.TAG, "Scheduling the next measurement to be done at least " + minWaitingPeriodMs + "ms from now.");
        L13:
            JobInfo jobInfo = new JobInfo.Builder(DO_BINARY_MEASUREMENTS_JOB_ID, new ComponentName(context, UpdateMeasurementsJobService.class)).setRequiresDeviceIdle(true).setRequiresCharging(true).setMinimumLatency(minWaitingPeriodMs).build();
            if (jobScheduler.schedule(jobInfo) == 1) goto L17;
            Slog.e(BinaryTransparencyService.TAG, "Failed to schedule job to measure binaries.");
            return;
        L17:
            Slog.d(BinaryTransparencyService.TAG, TextUtils.formatSimple("Job %d to measure binaries was scheduled successfully.", new Object[]{Integer.valueOf(DO_BINARY_MEASUREMENTS_JOB_ID)}));
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$e2eFFQ4jadgx-pDFIBv7RiSb2IE, reason: not valid java name */
    public static /* synthetic */ void m117$r8$lambda$e2eFFQ4jadgxpDFIBv7RiSb2IE(BinaryTransparencyService r0) {
        r0.lambda$collectBootIntegrityInfo$0();
    }

    public static /* synthetic */ boolean $r8$lambda$flMmp8UseBbIcDrF5oc9FDN2ITM(PackageInfo r0) {
        return lambda$getCurrentInstalledApexs$1(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m118$$Nest$fgetmContext(BinaryTransparencyService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMeasurementsLastRecordedMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m119$$Nest$fgetmMeasurementsLastRecordedMs(BinaryTransparencyService r2) {
        return r2.mMeasurementsLastRecordedMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerInternal m120$$Nest$fgetmPackageManagerInternal(BinaryTransparencyService r0) {
        return r0.mPackageManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ BinaryTransparencyServiceImpl m121$$Nest$fgetmServiceImpl(BinaryTransparencyService r0) {
        return r0.mServiceImpl;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVbmetaDigest, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m122$$Nest$fgetmVbmetaDigest(BinaryTransparencyService r0) {
        return r0.mVbmetaDigest;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMeasurementsLastRecordedMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m123$$Nest$fputmMeasurementsLastRecordedMs(BinaryTransparencyService r0, long r1) {
        r0.mMeasurementsLastRecordedMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mapexPackageNameToModuleName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m124$$Nest$mapexPackageNameToModuleName(BinaryTransparencyService r0, String r1) {
        return r0.apexPackageNameToModuleName(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCurrentInstalledApexs, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m125$$Nest$mgetCurrentInstalledApexs(BinaryTransparencyService r0) {
        return r0.getCurrentInstalledApexs();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetInstallSourceInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ InstallSourceInfo m126$$Nest$mgetInstallSourceInfo(BinaryTransparencyService r0, String r1) {
        return r0.getInstallSourceInfo(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetNewlyInstalledMbas, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m127$$Nest$mgetNewlyInstalledMbas(BinaryTransparencyService r0) {
        return r0.getNewlyInstalledMbas();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetOriginalApexPreinstalledLocation, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m128$$Nest$mgetOriginalApexPreinstalledLocation(BinaryTransparencyService r0, String r1) {
        return r0.getOriginalApexPreinstalledLocation(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misPackageAnApex, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m129$$Nest$misPackageAnApex(BinaryTransparencyService r0, String r1) {
        return r0.isPackageAnApex(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misPackagePreloaded, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m130$$Nest$misPackagePreloaded(BinaryTransparencyService r0, String r1) {
        return r0.isPackagePreloaded(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mlogBiometricProperties, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m131$$Nest$mlogBiometricProperties(BinaryTransparencyService r0, SensorProperties r1, int r2, int r3) {
        r0.logBiometricProperties(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mtoFaceSensorType, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m132$$Nest$mtoFaceSensorType(BinaryTransparencyService r0, int r1) {
        return r0.toFaceSensorType(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mtoFingerprintSensorType, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m133$$Nest$mtoFingerprintSensorType(BinaryTransparencyService r0, int r1) {
        return r0.toFingerprintSensorType(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mtranslateContentDigestAlgorithmIdToString, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m134$$Nest$mtranslateContentDigestAlgorithmIdToString(BinaryTransparencyService r0, int r1) {
        return r0.translateContentDigestAlgorithmIdToString(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetdigestAllPackagesLatency, reason: not valid java name */
    static /* bridge */ /* synthetic */ Histogram m135$$Nest$sfgetdigestAllPackagesLatency() {
        return digestAllPackagesLatency;
    }

    static {
        digestAllPackagesLatency = new Histogram("binary_transparency.value_digest_all_packages_latency_uniform", new Histogram.UniformOptions(50, 0.0f, 500.0f));
    }

    public BinaryTransparencyService(Context context) {
        this(context, BiometricLogger.getInstance());
    }

    BinaryTransparencyService(Context context, BiometricLogger biometricLogger) {
        super(context);
        this.mContext = context;
        this.mServiceImpl = new BinaryTransparencyServiceImpl(this);
        this.mVbmetaDigest = VBMETA_DIGEST_UNINITIALIZED;
        this.mMeasurementsLastRecordedMs = 0;
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mBiometricLogger = biometricLogger;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("transparency", this.mServiceImpl);     // Catch: Throwable -> L5
        Slog.i(TAG, "Started BinaryTransparencyService");     // Catch: Throwable -> L5
        return;
    L5:
        t = move-exception;
        Slog.e(TAG, "Failed to start BinaryTransparencyService.", t);
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 1000) goto L6;
        Slog.i(TAG, "Boot completed. Getting boot integrity data.");
        collectBootIntegrityInfo();
        Slog.i(TAG, "Boot completed. Collecting biometric system properties.");
        collectBiometricProperties();
        Slog.i(TAG, "Scheduling measurements to be taken.");
        UpdateMeasurementsJobService.scheduleBinaryMeasurements(this.mContext, this);
        registerAllPackageUpdateObservers();
        return;
    }

    private int toFingerprintSensorType(int sensorType) {
        switch(sensorType) {
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 5;
    L7:
        return 4;
    L9:
        return 3;
    L11:
        return 2;
    L13:
        return 1;
    }

    private int toFaceSensorType(int sensorType) {
        switch(sensorType) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 7;
    L7:
        return 6;
    }

    private int toSensorStrength(int sensorStrength) {
        switch(sensorStrength) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 3;
    L7:
        return 2;
    L9:
        return 1;
    }

    private void logBiometricProperties(SensorProperties prop, int modality, int sensorType) {
        int sensorId = prop.getSensorId();
        int sensorStrength = toSensorStrength(prop.getSensorStrength());
        Iterator r10 = prop.getComponentInfo().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        SensorProperties.ComponentInfo componentInfo = (SensorProperties.ComponentInfo) r10.next();
        this.mBiometricLogger.logStats(sensorId, modality, sensorType, sensorStrength, componentInfo.getComponentId().trim(), componentInfo.getHardwareVersion().trim(), componentInfo.getFirmwareVersion().trim(), componentInfo.getSerialNumber().trim(), componentInfo.getSoftwareVersion().trim());
        goto L4
    }

    void collectBiometricProperties() {
        if (DeviceConfig.getBoolean("biometrics", KEY_ENABLE_BIOMETRIC_PROPERTY_VERIFICATION, true) == true) goto L5;
        return;
    L5:
        PackageManager pm = this.mContext.getPackageManager();
        FingerprintManager fpManager = null;
        FaceManager faceManager = null;
        if (pm != null) goto L8;
    L10:
        if (pm != null) goto L12;
    L14:
        if (fpManager == null) goto L16;
        fpManager.addAuthenticatorsRegisteredCallback(new AnonymousClass1(this));
    L16:
        if (faceManager == null) goto L19;
        faceManager.addAuthenticatorsRegisteredCallback(new AnonymousClass2(this));
        return;
    L19:
        return;
    L12:
        if (pm.hasSystemFeature("android.hardware.biometrics.face") == false) goto L14;
        faceManager = (FaceManager) this.mContext.getSystemService(FaceManager.class);
        goto L14
    L8:
        if (pm.hasSystemFeature("android.hardware.fingerprint") == false) goto L10;
        fpManager = (FingerprintManager) this.mContext.getSystemService(FingerprintManager.class);
        goto L10
    }

    private void collectBootIntegrityInfo() {
        this.mVbmetaDigest = SystemProperties.get(SYSPROP_NAME_VBETA_DIGEST, VBMETA_DIGEST_UNAVAILABLE);
        Slog.d(TAG, String.format("VBMeta Digest: %s", new Object[]{this.mVbmetaDigest}));
        FrameworkStatsLog.write(420, this.mVbmetaDigest);
        IoThread.getExecutor().execute(new BinaryTransparencyService$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$collectBootIntegrityInfo$0() {
        byte[] sepolicyHash = PackageUtils.computeSha256DigestForLargeFileAsBytes("/sys/fs/selinux/policy", PackageUtils.createLargeFileBuffer());
        String sepolicyHashEncoded = null;
        if (sepolicyHash == null) goto L5;
        sepolicyHashEncoded = HexEncoding.encodeToString(sepolicyHash, false);
        Slog.d(TAG, "sepolicy hash: " + sepolicyHashEncoded);
    L5:
        FrameworkStatsLog.write(775, sepolicyHashEncoded, this.mVbmetaDigest);
    }

    private void registerApkAndNonStagedApexUpdateListener() {
        Slog.d(TAG, "Registering APK & Non-Staged APEX updates...");
        IntentFilter filter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mContext.registerReceiver(new PackageUpdatedReceiver(this, null), filter);
    }

    private void registerStagedApexUpdateObserver() {
        Slog.d(TAG, "Registering APEX updates...");
        IPackageManagerNative iPackageManagerNative = IPackageManagerNative.Stub.asInterface(ServiceManager.getService("package_native"));
        if (iPackageManagerNative != null) goto L11;
        Slog.e(TAG, "IPackageManagerNative is null");
        return;
    L11:
        iPackageManagerNative.registerStagedApexObserver(new AnonymousClass3(this));     // Catch: RemoteException -> L8
        return;
    L9:
        Slog.e(TAG, "Failed to register a StagedApexObserver.");
    }

    private void registerBicCallback() {
        IBackgroundInstallControlService iBics = IBackgroundInstallControlService.Stub.asInterface(ServiceManager.getService("background_install_control"));
        if (iBics != null) goto L11;
        Slog.e(TAG, "Failed to register BackgroundInstallControl callback, either background install control service does not exist or disabled on this build.");
        return;
    L11:
        iBics.registerBackgroundInstallCallback(new BicCallbackHandler(new AnonymousClass4(this)));     // Catch: RemoteException -> L8
        return;
    L9:
        Slog.e(TAG, "Failed to register BackgroundInstallControl callback.");
    }

    private boolean isPackagePreloaded(String packageName) {
        PackageManager pm = this.mContext.getPackageManager();
        pm.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(2097152));     // Catch: PackageManager.NameNotFoundException -> L6
        return true;
    L7:
        return false;
    }

    private boolean isPackageAnApex(String packageName) {
        PackageManager pm = this.mContext.getPackageManager();
        PackageInfo packageInfo = pm.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(1073741824));     // Catch: PackageManager.NameNotFoundException -> L5
        return packageInfo.isApex;
    L6:
        return false;
    }

    private void registerAllPackageUpdateObservers() {
        registerApkAndNonStagedApexUpdateListener();
        registerStagedApexUpdateObserver();
    }

    private String translateContentDigestAlgorithmIdToString(int algorithmId) {
        switch(algorithmId) {
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L4;
        };
    L5:
        return "SHA256";
    L7:
        return "VERITY_CHUNKED_SHA256";
    L9:
        return "CHUNKED_SHA512";
    L11:
        return "CHUNKED_SHA256";
    L4:
        return "UNKNOWN_ALGO_ID(" + algorithmId + ")";
    }

    private List<PackageInfo> getCurrentInstalledApexs() {
        List<PackageInfo> results = new ArrayList();
        PackageManager pm = this.mContext.getPackageManager();
        if (pm != null) goto L6;
        Slog.e(TAG, "Error obtaining an instance of PackageManager.");
        return results;
    L6:
        List<PackageInfo> allPackages = pm.getInstalledPackages(PackageManager.PackageInfoFlags.of(1207959552));
        if (allPackages != null) goto L11;
        Slog.e(TAG, "Error obtaining installed packages (including APEX)");
        return results;
    L11:
        return (List) allPackages.stream().filter(new BinaryTransparencyService$$ExternalSyntheticLambda0()).collect(Collectors.toList());
    }

    private static /* synthetic */ boolean lambda$getCurrentInstalledApexs$1(PackageInfo p) {
        return p.isApex;
    }

    private InstallSourceInfo getInstallSourceInfo(String packageName) {
        PackageManager pm = this.mContext.getPackageManager();
        if (pm != null) goto L11;
        Slog.e(TAG, "Error obtaining an instance of PackageManager.");
        return null;
    L11:
        return pm.getInstallSourceInfo(packageName);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private String getOriginalApexPreinstalledLocation(String packageName) {
        String moduleName = apexPackageNameToModuleName(packageName);     // Catch: RemoteException -> L8
        IApexService apexService = IApexService.Stub.asInterface(Binder.allowBlocking(ServiceManager.waitForService("apexservice")));     // Catch: RemoteException -> L8
        ApexInfo[] r2 = apexService.getAllPackages();     // Catch: RemoteException -> L8
        int r3 = r2.length;     // Catch: RemoteException -> L8
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L19;
        ApexInfo info = r2[r4];     // Catch: RemoteException -> L8
        if (moduleName.equals(info.moduleName) == true) goto L6;
        r4 = r4 + 1;
        goto L3
    L6:
        return info.preinstalledModulePath;
    L19:
        return APEX_PRELOAD_LOCATION_ERROR;
    L8:
        e = move-exception;
        Slog.e(TAG, "Unable to get package list from apexservice", e);
        return APEX_PRELOAD_LOCATION_ERROR;
    }

    private String apexPackageNameToModuleName(String packageName) {
        return ApexManager.getInstance().getApexModuleNameForPackageName(packageName);
    }

    private List<PackageInfo> getNewlyInstalledMbas() {
        List<PackageInfo> result = new ArrayList();
        IBackgroundInstallControlService iBics = IBackgroundInstallControlService.Stub.asInterface(ServiceManager.getService("background_install_control"));
        if (iBics != null) goto L13;
        Slog.e(TAG, "Failed to obtain an IBinder instance of IBackgroundInstallControlService");
        return result;
    L13:
        ParceledListSlice<PackageInfo> slice = iBics.getBackgroundInstalledPackages(134348800, 0);     // Catch: RemoteException -> L10
        return slice.getList();
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to get a list of MBAs.", e);
        return result;
    }
}
