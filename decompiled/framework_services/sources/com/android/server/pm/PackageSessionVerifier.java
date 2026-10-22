package com.android.server.pm;

import android.apex.ApexInfo;
import android.apex.ApexInfoList;
import android.apex.ApexSessionInfo;
import android.apex.ApexSessionParams;
import android.content.Context;
import android.content.pm.IPackageInstallObserver2;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.SigningDetails;
import android.content.pm.parsing.result.ParseResult;
import android.content.pm.parsing.result.ParseTypeImpl;
import android.content.rollback.RollbackInfo;
import android.content.rollback.RollbackManager;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.IntArray;
import android.util.Slog;
import android.util.apk.ApkSignatureVerifier;
import com.android.internal.content.InstallLocationUtils;
import com.android.internal.pm.parsing.PackageParser2;
import com.android.internal.pm.parsing.PackageParserException;
import com.android.internal.pm.parsing.pkg.ParsedPackage;
import com.android.server.LocalServices;
import com.android.server.SystemConfig;
import com.android.server.rollback.RollbackManagerInternal;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
final class PackageSessionVerifier {
    private static final String TAG = "PackageSessionVerifier";
    private final ApexManager mApexManager;
    private final Context mContext;
    private final Handler mHandler;
    private final Supplier<PackageParser2> mPackageParserSupplier;
    private final PackageManagerService mPm;
    private final List<StagingManager.StagedSession> mStagedSessions;

    interface Callback {
        void onResult(int r1, String r2);
    }

    public static /* synthetic */ void $r8$lambda$08MqprYAvf5Emies8ndlG5KBsmE(PackageSessionVerifier r0, PackageInstallerSession r1, Callback r2) {
        r0.lambda$verify$0(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$5qzBrZDe9VdeZP59aei1tUOsPiM(String r0, StagingManager.StagedSession r1) {
        return lambda$checkRebootlessApex$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$MksuqjzWsvOfGiAd6wRwvGZrPnA(PackageSessionVerifier r0, StagingManager.StagedSession r1, Callback r2) {
        r0.lambda$verifyStaged$1(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$PsteoPuJoQ6z6lwP6GuX91TAuK0(String r0, StagingManager.StagedSession r1) {
        return lambda$checkOverlaps$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$YtRBpJoUX-7iRsWdzvGwhFarAI8, reason: not valid java name */
    public static /* synthetic */ void m6876$r8$lambda$YtRBpJoUX7iRsWdzvGwhFarAI8(PackageSessionVerifier r0, StagingManager.StagedSession r1, Callback r2) {
        r0.lambda$dispatchVerifyApex$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$l8hW4UAzKCDs1Kd_iczowHyOg6M(PackageSessionVerifier r0, StagingManager.StagedSession r1, Callback r2) {
        r0.lambda$dispatchEndVerification$3(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mverifyStaged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6877$$Nest$mverifyStaged(PackageSessionVerifier r0, StagingManager.StagedSession r1, Callback r2) {
        r0.verifyStaged(r1, r2);
    }

    PackageSessionVerifier(Context context, PackageManagerService pm, ApexManager apexManager, Supplier<PackageParser2> packageParserSupplier, Looper looper) {
        this.mStagedSessions = new ArrayList();
        this.mContext = context;
        this.mPm = pm;
        this.mApexManager = apexManager;
        this.mPackageParserSupplier = packageParserSupplier;
        this.mHandler = new Handler(looper);
    }

    PackageSessionVerifier() {
        this.mStagedSessions = new ArrayList();
        this.mContext = null;
        this.mPm = null;
        this.mApexManager = null;
        this.mPackageParserSupplier = null;
        this.mHandler = null;
    }

    public void verify(final PackageInstallerSession session, final Callback callback) {
        this.mHandler.post(new PackageSessionVerifier$$ExternalSyntheticLambda3(this, session, callback));
    }

    private /* synthetic */ void lambda$verify$0(PackageInstallerSession session, Callback callback) {
        storeSession(session.mStagedSession);     // Catch: PackageManagerException -> L8
        if (session.isMultiPackage() == false) goto L11;
        Iterator<PackageInstallerSession> r0 = session.getChildSessions().iterator();     // Catch: PackageManagerException -> L8
    L6:
        if (r0.hasNext() == false) goto L12;
        PackageInstallerSession child = r0.next();     // Catch: PackageManagerException -> L8
        checkApexUpdateAllowed(child);     // Catch: PackageManagerException -> L8
        checkRebootlessApex(child);     // Catch: PackageManagerException -> L8
        checkApexSignature(child);     // Catch: PackageManagerException -> L8
    L12:
        verifyAPK(session, callback);     // Catch: PackageManagerException -> L8
        return;
    L11:
        checkApexUpdateAllowed(session);     // Catch: PackageManagerException -> L8
        checkRebootlessApex(session);     // Catch: PackageManagerException -> L8
        checkApexSignature(session);     // Catch: PackageManagerException -> L8
    L8:
        e = move-exception;
        String errorMessage = PackageManager.installStatusToString(e.error, e.getMessage());
        session.setSessionFailed(e.error, errorMessage);
        callback.onResult(e.error, e.getMessage());
    }

    private SigningDetails getSigningDetails(PackageInfo apexPkg) throws PackageManagerException {
        String apexPath = apexPkg.applicationInfo.sourceDir;
        int minSignatureScheme = ApkSignatureVerifier.getMinimumSignatureSchemeVersionForTargetSdk(apexPkg.applicationInfo.targetSdkVersion);
        ParseTypeImpl input = ParseTypeImpl.forDefaultParsing();
        ParseResult<SigningDetails> result = ApkSignatureVerifier.verify(input, apexPath, minSignatureScheme);
        if (result.isError() == true) goto L7;
        return (SigningDetails) result.getResult();
    L7:
        throw new PackageManagerException(-22, "Failed to verify APEX package " + apexPath + " : " + result.getException(), result.getException());
    }

    private void checkApexSignature(PackageInstallerSession session) throws PackageManagerException {
        if (session.isApexSession() == true) goto L5;
        return;
    L5:
        String packageName = session.getPackageName();
        PackageInfo existingApexPkg = this.mPm.snapshotComputer().getPackageInfo(session.getPackageName(), 1073741824, 0);
        if (existingApexPkg == null) goto L16;
        SigningDetails existingSigningDetails = getSigningDetails(existingApexPkg);
        SigningDetails newSigningDetails = session.getSigningDetails();
        if (newSigningDetails.checkCapability(existingSigningDetails, 1) == false) goto L10;
        return;
    L10:
        if (existingSigningDetails.checkCapability(newSigningDetails, 8) == false) goto L13;
        return;
    L13:
        throw new PackageManagerException(-22, "APK container signature of APEX package " + packageName + " is not compatible with the one currently installed on device");
    L16:
        throw new PackageManagerException(-23, "Attempting to install new APEX package " + packageName);
    }

    private void verifyAPK(final PackageInstallerSession session, final Callback callback) throws PackageManagerException {
        VerifyingSession verifyingSession = createVerifyingSession(session, new AnonymousClass1(this, session, callback));
        if (session.isMultiPackage() == false) goto L9;
        List<PackageInstallerSession> childSessions = session.getChildSessions();
        List<VerifyingSession> verifyingChildSessions = new ArrayList(childSessions.size());
        Iterator<PackageInstallerSession> r4 = childSessions.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        PackageInstallerSession child = r4.next();
        verifyingChildSessions.add(createVerifyingSession(child, null));
        goto L6
    L8:
        verifyingSession.verifyStage(verifyingChildSessions);
        return;
    L9:
        verifyingSession.verifyStage();
    }

    private VerifyingSession createVerifyingSession(PackageInstallerSession session, IPackageInstallObserver2 observer) {
        if ((session.params.installFlags & 64) == 0) goto L5;
        UserHandle user = UserHandle.ALL;
    L7:
        return new VerifyingSession(user, session.stageDir, observer, session.params, session.getInstallSource(), session.getInstallerUid(), session.getSigningDetails(), session.sessionId, session.getPackageLite(), session.getUserActionRequired(), this.mPm);
    L5:
        user = new UserHandle(session.userId);
        goto L7
    }

    private void verifyStaged(final StagingManager.StagedSession session, final Callback callback) {
        Slog.d(TAG, "Starting preRebootVerification for session " + session.sessionId());
        this.mHandler.post(new PackageSessionVerifier$$ExternalSyntheticLambda0(this, session, callback));
    }

    private /* synthetic */ void lambda$verifyStaged$1(StagingManager.StagedSession session, Callback callback) {
        checkActiveSessions();     // Catch: PackageManagerException -> L8
        checkRollbacks(session);     // Catch: PackageManagerException -> L8
        if (session.isMultiPackage() == false) goto L11;
        Iterator<StagingManager.StagedSession> r0 = session.getChildSessions().iterator();     // Catch: PackageManagerException -> L8
    L6:
        if (r0.hasNext() == false) goto L12;
        StagingManager.StagedSession child = r0.next();     // Catch: PackageManagerException -> L8
        checkOverlaps(session, child);     // Catch: PackageManagerException -> L8
    L12:
        dispatchVerifyApex(session, callback);     // Catch: PackageManagerException -> L8
        return;
    L11:
        checkOverlaps(session, session);     // Catch: PackageManagerException -> L8
    L8:
        e = move-exception;
        onVerificationFailure(session, callback, e.error, e.getMessage());
    }

    void storeSession(StagingManager.StagedSession session) {
        if (session == null) goto L5;
        this.mStagedSessions.add(session);
        return;
    }

    private void onVerificationSuccess(StagingManager.StagedSession session, Callback callback) {
        callback.onResult(1, null);
    }

    private void onVerificationFailure(StagingManager.StagedSession session, Callback callback, int errorCode, String errorMessage) {
        if (ensureActiveApexSessionIsAborted(session) == true) goto L5;
        Slog.e(TAG, "Failed to abort apex session " + session.sessionId());
    L5:
        session.setSessionFailed(errorCode, errorMessage);
        callback.onResult(-22, errorMessage);
    }

    private void dispatchVerifyApex(final StagingManager.StagedSession session, final Callback callback) {
        this.mHandler.post(new PackageSessionVerifier$$ExternalSyntheticLambda1(this, session, callback));
    }

    private /* synthetic */ void lambda$dispatchVerifyApex$2(StagingManager.StagedSession session, Callback callback) {
        verifyApex(session);     // Catch: PackageManagerException -> L4
        dispatchEndVerification(session, callback);     // Catch: PackageManagerException -> L4
        return;
    L4:
        e = move-exception;
        onVerificationFailure(session, callback, e.error, e.getMessage());
    }

    private void dispatchEndVerification(final StagingManager.StagedSession session, final Callback callback) {
        this.mHandler.post(new PackageSessionVerifier$$ExternalSyntheticLambda5(this, session, callback));
    }

    private /* synthetic */ void lambda$dispatchEndVerification$3(StagingManager.StagedSession session, Callback callback) {
        endVerification(session);     // Catch: PackageManagerException -> L4
        onVerificationSuccess(session, callback);     // Catch: PackageManagerException -> L4
        return;
    L4:
        e = move-exception;
        onVerificationFailure(session, callback, e.error, e.getMessage());
    }

    private void verifyApex(StagingManager.StagedSession session) throws PackageManagerException {
        int rollbackId = -1;
        if ((session.sessionParams().installFlags & 262144) == 0) goto L11;
        RollbackManagerInternal rm = (RollbackManagerInternal) LocalServices.getService(RollbackManagerInternal.class);
        rollbackId = rm.notifyStagedSession(session.sessionId());     // Catch: RuntimeException -> L7
    L13:
        boolean hasApex = session.containsApexSession();
        if (hasApex == false) goto L19;
        submitSessionToApexService(session, rollbackId);
        return;
    L19:
        return;
    L7:
        re = move-exception;
        Slog.e(TAG, "Failed to notifyStagedSession for session: " + session.sessionId(), re);
        goto L13
    L11:
        if (isRollback(session) == false) goto L13;
        rollbackId = retrieveRollbackIdForCommitSession(session.sessionId());
        goto L13
    }

    private void endVerification(StagingManager.StagedSession session) throws PackageManagerException {
    L7:
        e = move-exception;
        Slog.e(TAG, "Failed to get hold of StorageManager", e);
        throw new PackageManagerException(-110, "Failed to get hold of StorageManager");
    L4:
        if (InstallLocationUtils.getStorageManager().supportsCheckpoint() == false) goto L9;
        InstallLocationUtils.getStorageManager().startCheckpoint(2);     // Catch: Exception -> L7
    L9:
        Slog.d(TAG, "Marking session " + session.sessionId() + " as ready");
        session.setSessionReady();
        if (session.isSessionReady() == false) goto L19;
        boolean hasApex = session.containsApexSession();
        if (hasApex == false) goto L20;
        this.mApexManager.markStagedSessionReady(session.sessionId());
        return;
    L20:
        return;
    }

    private void submitSessionToApexService(StagingManager.StagedSession session, int rollbackId) throws PackageManagerException {
        IntArray childSessionIds = new IntArray();
        if (session.isMultiPackage() == false) goto L11;
        Iterator<StagingManager.StagedSession> r1 = session.getChildSessions().iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        StagingManager.StagedSession s = r1.next();
        if (s.isApexSession() == false) goto L6;
        childSessionIds.add(s.sessionId());
    L11:
        ApexSessionParams apexSessionParams = new ApexSessionParams();
        apexSessionParams.sessionId = session.sessionId();
        apexSessionParams.childSessionIds = childSessionIds.toArray();
        if (session.sessionParams().installReason != 5) goto L15;
        apexSessionParams.isRollback = true;
        apexSessionParams.rollbackId = rollbackId;
    L17:
        ApexInfoList apexInfoList = this.mApexManager.submitStagedSession(apexSessionParams);
        List<String> apexPackageNames = new ArrayList();
        ApexInfo[] r4 = apexInfoList.apexInfos;
        int r5 = r4.length;
        int r7 = 0;
    L18:
        if (r7 >= r5) goto L36;
        ApexInfo apexInfo = r4[r7];
        PackageParser2 packageParser = this.mPackageParserSupplier.get();     // Catch: PackageParserException -> L24
        File apexFile = new File(apexInfo.modulePath);     // Catch: Throwable -> L26
        ParsedPackage parsedPackage = packageParser.parsePackage(apexFile, 1024, false);     // Catch: Throwable -> L26
        packageParser.close();     // Catch: PackageParserException -> L24
        apexPackageNames.add(parsedPackage.getPackageName());
        r7 = r7 + 1;
        goto L18
    L26:
        th = move-exception;
        if (packageParser != null) goto L38;
    L33:
        throw th;     // Catch: PackageParserException -> L24
    L38:
        packageParser.close();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: PackageParserException -> L24
    L24:
        e = move-exception;
        throw new PackageManagerException(-22, "Failed to parse APEX package " + apexInfo.modulePath + " : " + e, e);
    L36:
        Slog.d(TAG, "Session " + session.sessionId() + " has following APEX packages: " + apexPackageNames);
        return;
    L15:
        if (rollbackId == (-1)) goto L17;
        apexSessionParams.hasRollbackEnabled = true;
        apexSessionParams.rollbackId = rollbackId;
        goto L17
    }

    private int retrieveRollbackIdForCommitSession(int sessionId) throws PackageManagerException {
        RollbackManager rm = (RollbackManager) this.mContext.getSystemService(RollbackManager.class);
        List<RollbackInfo> rollbacks = rm.getRecentlyCommittedRollbacks();
        int i = 0;
        int size = rollbacks.size();
    L3:
        if (i >= size) goto L10;
        RollbackInfo rollback = rollbacks.get(i);
        if (rollback.getCommittedSessionId() == sessionId) goto L7;
        i = i + 1;
        goto L3
    L7:
        return rollback.getRollbackId();
    L10:
        throw new PackageManagerException(-22, "Could not find rollback id for commit session: " + sessionId);
    }

    private static boolean isRollback(StagingManager.StagedSession session) {
        if (session.sessionParams().installReason != 5) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isApexSessionFinalized(ApexSessionInfo info) {
        if (info.isUnknown == false) goto L5;
    L12:
        return true;
    L5:
        if (info.isActivationFailed == true) goto L12;
        if (info.isSuccess == true) goto L12;
        if (info.isReverted == true) goto L12;
        return false;
    }

    private boolean ensureActiveApexSessionIsAborted(StagingManager.StagedSession session) {
        if (session.containsApexSession() == true) goto L5;
        return true;
    L5:
        int sessionId = session.sessionId();
        ApexSessionInfo apexSession = this.mApexManager.getStagedSessionInfo(sessionId);
        if (apexSession != null) goto L8;
    L12:
        return true;
    L8:
        if (isApexSessionFinalized(apexSession) == true) goto L12;
        return this.mApexManager.abortStagedSession(sessionId);
    }

    private boolean isApexUpdateAllowed(String apexPackageName, String installerPackageName) {
        if (this.mPm.getModuleInfo(apexPackageName, 0) == null) goto L10;
        String modulesInstaller = SystemConfig.getInstance().getModulesInstallerPackageName();
        if (modulesInstaller != null) goto L9;
        Slog.w(TAG, "No modules installer defined");
        return false;
    L9:
        return modulesInstaller.equals(installerPackageName);
    L10:
        String vendorApexInstaller = SystemConfig.getInstance().getAllowedVendorApexes().get(apexPackageName);
        if (vendorApexInstaller != null) goto L15;
        Slog.w(TAG, apexPackageName + " is not allowed to be updated");
        return false;
    L15:
        return vendorApexInstaller.equals(installerPackageName);
    }

    private void checkApexUpdateAllowed(PackageInstallerSession session) throws PackageManagerException {
        if (session.isApexSession() == true) goto L5;
        return;
    L5:
        int installFlags = session.params.installFlags;
        if ((8388608 & installFlags) == 0) goto L8;
        return;
    L8:
        String packageName = session.getPackageName();
        String installerPackageName = session.getInstallSource().mInstallerPackageName;
        if (isApexUpdateAllowed(packageName, installerPackageName) == false) goto L12;
        return;
    L12:
        throw new PackageManagerException(-22, "Update of APEX package " + packageName + " is not allowed for " + installerPackageName);
    }

    void checkRebootlessApex(PackageInstallerSession session) throws PackageManagerException {
        if (session.isStaged() == false) goto L5;
        return;
    L5:
        if (session.isApexSession() == false) goto L34;
        final String packageName = session.getPackageName();
        if (packageName == null) goto L24;
        Iterator<StagingManager.StagedSession> r2 = this.mStagedSessions.iterator();
    L11:
        if (r2.hasNext() == false) goto L22;
        StagingManager.StagedSession stagedSession = r2.next();
        if (stagedSession.isDestroyed() == true) goto L11;
        if (stagedSession.isInTerminalState() == true) goto L11;
        if (stagedSession.sessionContains(new PackageSessionVerifier$$ExternalSyntheticLambda4(packageName)) == false) goto L11;
        throw new PackageManagerException(-22, "Staged session " + stagedSession.sessionId() + " already contains " + packageName);
    L22:
        return;
    L24:
        throw new PackageManagerException(-22, "Invalid session " + session.sessionId + " with package name null");
    }

    private static /* synthetic */ boolean lambda$checkRebootlessApex$4(String packageName, StagingManager.StagedSession s) {
        return packageName.equals(s.getPackageName());
    }

    private void checkActiveSessions() throws PackageManagerException {
        checkActiveSessions(InstallLocationUtils.getStorageManager().supportsCheckpoint());     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new PackageManagerException(-110, "Can't query fs-checkpoint status : " + e);
    }

    void checkActiveSessions(boolean supportsCheckpoint) throws PackageManagerException {
        int activeSessions = 0;
        Iterator<StagingManager.StagedSession> r1 = this.mStagedSessions.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        StagingManager.StagedSession stagedSession = r1.next();
        if (stagedSession.isDestroyed() == true) goto L4;
        if (stagedSession.isInTerminalState() == true) goto L4;
        activeSessions = activeSessions + 1;
        goto L4
    L11:
        if (supportsCheckpoint == false) goto L13;
        return;
    L13:
        if (activeSessions > 1) goto L16;
        return;
    L16:
        throw new PackageManagerException(-119, "Cannot stage multiple sessions without checkpoint support");
    }

    void checkRollbacks(StagingManager.StagedSession session) throws PackageManagerException {
        if (session.isDestroyed() == false) goto L5;
        return;
    L5:
        if (session.isInTerminalState() == true) goto L47;
        Iterator<StagingManager.StagedSession> r0 = this.mStagedSessions.iterator();
    L9:
        if (r0.hasNext() == false) goto L31;
        StagingManager.StagedSession stagedSession = r0.next();
        if (stagedSession.isDestroyed() == true) goto L9;
        if (stagedSession.isInTerminalState() == true) goto L9;
        if (isRollback(session) == false) goto L24;
        if (isRollback(stagedSession) == true) goto L24;
        if (ensureActiveApexSessionIsAborted(stagedSession) == true) goto L22;
        Slog.e(TAG, "Failed to abort apex session " + stagedSession.sessionId());
    L22:
        stagedSession.setSessionFailed(-119, "Session was failed by rollback session: " + session.sessionId());
        Slog.i(TAG, "Session " + stagedSession.sessionId() + " is marked failed due to rollback session: " + session.sessionId());
    L24:
        if (isRollback(session) == true) goto L9;
        if (isRollback(stagedSession) == false) goto L9;
        throw new PackageManagerException(-119, "Session was failed by rollback session: " + stagedSession.sessionId());
    L31:
        return;
    }

    void checkOverlaps(StagingManager.StagedSession parent, StagingManager.StagedSession child) throws PackageManagerException {
        if (parent.isDestroyed() == false) goto L5;
        return;
    L5:
        if (parent.isInTerminalState() == true) goto L43;
        final String packageName = child.getPackageName();
        if (packageName == null) goto L29;
        Iterator<StagingManager.StagedSession> r1 = this.mStagedSessions.iterator();
    L11:
        if (r1.hasNext() == false) goto L27;
        StagingManager.StagedSession stagedSession = r1.next();
        if (stagedSession.isDestroyed() == true) goto L11;
        if (stagedSession.isInTerminalState() == true) goto L11;
        if (stagedSession.sessionId() == parent.sessionId()) goto L11;
        if (stagedSession.sessionContains(new PackageSessionVerifier$$ExternalSyntheticLambda2(packageName)) == false) goto L11;
        if (stagedSession.getCommittedMillis() < parent.getCommittedMillis()) goto L25;
        stagedSession.setSessionFailed(-119, "Package: " + packageName + " in session: " + stagedSession.sessionId() + " has been staged already by session: " + child.sessionId());
        goto L11
    L25:
        throw new PackageManagerException(-119, "Package: " + packageName + " in session: " + child.sessionId() + " has been staged already by session: " + stagedSession.sessionId());
    L27:
        return;
    L29:
        throw new PackageManagerException(-22, "Cannot stage session " + child.sessionId() + " with package name null");
    }

    private static /* synthetic */ boolean lambda$checkOverlaps$5(String packageName, StagingManager.StagedSession s) {
        return packageName.equals(s.getPackageName());
    }
}
