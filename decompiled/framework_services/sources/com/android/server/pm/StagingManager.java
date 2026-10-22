package com.android.server.pm;

import android.apex.ApexInfo;
import android.apex.ApexSessionInfo;
import android.apex.ApexSessionParams;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApexStagedEvent;
import android.content.pm.IStagedApexObserver;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManagerInternal;
import android.content.pm.StagedApexInfo;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimingsTraceLog;
import com.android.internal.content.InstallLocationUtils;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.Preconditions;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.SystemServiceManager;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageStateUtils;
import com.android.server.rollback.ApexdRevertLogger;
import com.android.server.rollback.RollbackManagerInternal;
import com.android.server.usb.descriptors.UsbEndpointDescriptor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public class StagingManager {
    private static final String TAG = "StagingManager";
    private final ApexManager mApexManager;
    private final CompletableFuture<Void> mBootCompleted;
    private final Context mContext;
    private final List<String> mFailedPackageNames;
    private String mFailureReason;
    private final File mFailureReasonFile;
    private String mNativeFailureReason;
    private final PowerManager mPowerManager;
    private final List<IStagedApexObserver> mStagedApexObservers;
    private final SparseArray<StagedSession> mStagedSessions;
    private final List<Integer> mSuccessfulStagedSessionIds;

    public static final class Lifecycle extends SystemService {
        private static StagingManager sStagingManager;

        public Lifecycle(Context context) {
            super(context);
        }

        void startService(StagingManager stagingManager) {
            sStagingManager = stagingManager;
            ((SystemServiceManager) LocalServices.getService(SystemServiceManager.class)).startService(this);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase == 1000) goto L5;
            return;
        L5:
            if (sStagingManager == null) goto L9;
            StagingManager.m6967$$Nest$mmarkStagedSessionsAsSuccessful(sStagingManager);
            StagingManager.m6966$$Nest$mmarkBootCompleted(sStagingManager);
            return;
        }
    }

    interface StagedSession {
        void abandon();

        boolean containsApexSession();

        boolean containsApkSession();

        List<StagedSession> getChildSessions();

        long getCommittedMillis();

        String getPackageName();

        int getParentSessionId();

        boolean hasParentSessionId();

        CompletableFuture<Void> installSession();

        boolean isApexSession();

        boolean isCommitted();

        boolean isDestroyed();

        boolean isInTerminalState();

        boolean isMultiPackage();

        boolean isSessionApplied();

        boolean isSessionFailed();

        boolean isSessionReady();

        boolean sessionContains(Predicate<StagedSession> r1);

        int sessionId();

        PackageInstaller.SessionParams sessionParams();

        void setSessionApplied();

        void setSessionFailed(int r1, String r2);

        void setSessionReady();

        void verifySession();
    }

    public static /* synthetic */ StagedApexInfo $r8$lambda$Ldle5dZCHLvvxS28rKveGkH5GoQ(ApexInfo r0) {
        return lambda$getStagedApexInfos$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$Tc-8JeWCdIuusiZU02QNaF3RrX8, reason: not valid java name */
    public static /* synthetic */ void m6964$r8$lambda$Tc8JeWCdIuusiZU02QNaF3RrX8(StagingManager r0) {
        r0.lambda$onBootCompletedBroadcastReceived$1();
    }

    public static /* synthetic */ void $r8$lambda$axgArnItf5JtFcCgzNksy5jg12Y(StagedSession r0) {
        lambda$handleNonReadyAndDestroyedSessions$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStagedApexObservers, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m6965$$Nest$fgetmStagedApexObservers(StagingManager r0) {
        return r0.mStagedApexObservers;
    }

    /* JADX INFO: renamed from: -$$Nest$mmarkBootCompleted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6966$$Nest$mmarkBootCompleted(StagingManager r0) {
        r0.markBootCompleted();
    }

    /* JADX INFO: renamed from: -$$Nest$mmarkStagedSessionsAsSuccessful, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6967$$Nest$mmarkStagedSessionsAsSuccessful(StagingManager r0) {
        r0.markStagedSessionsAsSuccessful();
    }

    StagingManager(Context context) {
        this(context, ApexManager.getInstance());
    }

    StagingManager(Context context, ApexManager apexManager) {
        this.mFailureReasonFile = new File("/metadata/staged-install/failure_reason.txt");
        this.mStagedSessions = new SparseArray();
        this.mFailedPackageNames = new ArrayList();
        this.mSuccessfulStagedSessionIds = new ArrayList();
        this.mStagedApexObservers = new ArrayList();
        this.mBootCompleted = new CompletableFuture();
        this.mContext = context;
        this.mApexManager = apexManager;
        this.mPowerManager = (PowerManager) context.getSystemService("power");
        if (this.mFailureReasonFile.exists() == true) goto L19;
        return;
    L19:
        BufferedReader reader = new BufferedReader(new FileReader(this.mFailureReasonFile));     // Catch: Exception -> L8
        this.mFailureReason = reader.readLine();     // Catch: Throwable -> L10
        reader.close();     // Catch: Exception -> L8
        return;
    L10:
        th = move-exception;
        reader.close();     // Catch: Throwable -> L13
    L15:
        throw th;     // Catch: Exception -> L8
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L8
    }

    private void markBootCompleted() {
        this.mApexManager.markBootCompleted();
    }

    void registerStagedApexObserver(final IStagedApexObserver observer) {
        if (observer != null) goto L5;
        return;
    L5:
        if (observer.asBinder() != null) goto L20;
    L10:
        List<IStagedApexObserver> r0 = this.mStagedApexObservers;
        monitor-enter(r0);
        this.mStagedApexObservers.add(observer);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L20:
        observer.asBinder().linkToDeath(new AnonymousClass1(this, observer), 0);     // Catch: RemoteException -> L8
    L8:
        re = move-exception;
        Slog.w(TAG, re.getMessage());
        goto L10
    }

    void unregisterStagedApexObserver(IStagedApexObserver observer) {
        List<IStagedApexObserver> r0 = this.mStagedApexObservers;
        monitor-enter(r0);
        this.mStagedApexObservers.remove(observer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void abortCheckpoint(String failureReason, boolean supportsCheckpoint, boolean needsCheckpoint) {
        Slog.e(TAG, failureReason);
        if (supportsCheckpoint == false) goto L38;
        if (needsCheckpoint == false) goto L39;
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.mFailureReasonFile));     // Catch: Exception -> L9
        writer.write(failureReason);     // Catch: Throwable -> L11
        writer.close();     // Catch: Exception -> L9
    L20:
        if (this.mApexManager.isApexSupported() == false) goto L24;
        this.mApexManager.revertActiveSessions();     // Catch: Exception -> L22
    L24:
        InstallLocationUtils.getStorageManager().abortChanges("abort-staged-install", false);     // Catch: Exception -> L22
        return;
    L11:
        th = move-exception;
        writer.close();     // Catch: Throwable -> L14
    L16:
        throw th;     // Catch: Exception -> L9
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Slog.w(TAG, "Failed to save failure reason: ", e);     // Catch: Exception -> L22
        goto L20
    L39:
        return;
    L22:
        e = move-exception;
        Slog.wtf(TAG, "Failed to abort checkpoint", e);
        if (this.mApexManager.isApexSupported() == false) goto L29;
        this.mApexManager.revertActiveSessions();
    L29:
        this.mPowerManager.reboot(null);
        return;
    }

    private List<StagedSession> extractApexSessions(StagedSession session) {
        List<StagedSession> apexSessions = new ArrayList();
        if (session.isMultiPackage() == false) goto L12;
        Iterator<StagedSession> r1 = session.getChildSessions().iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        StagedSession s = r1.next();
        if (s.containsApexSession() == false) goto L6;
        apexSessions.add(s);
    L13:
        return apexSessions;
    L12:
        apexSessions.add(session);
        goto L13
    }

    private void checkInstallationOfApkInApexSuccessful(StagedSession session) throws PackageManagerException {
        List<StagedSession> apexSessions = extractApexSessions(session);
        if (apexSessions.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<StagedSession> r1 = apexSessions.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        StagedSession apexSession = r1.next();
        String packageName = apexSession.getPackageName();
        String errorMsg = this.mApexManager.getApkInApexInstallError(packageName);
        if (errorMsg == null) goto L7;
        throw new PackageManagerException(UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION, "Failed to install apk-in-apex of " + packageName + " : " + errorMsg);
    }

    private void snapshotAndRestoreForApexSession(StagedSession session) {
        if ((session.sessionParams().installFlags & 262144) == 0) goto L5;
    L8:
        boolean doSnapshotOrRestore = true;
    L10:
        if (doSnapshotOrRestore == true) goto L12;
        return;
    L12:
        List<StagedSession> apexSessions = extractApexSessions(session);
        if (apexSessions.isEmpty() == false) goto L15;
        return;
    L15:
        UserManagerInternal um = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        int[] allUsers = um.getUserIds();
        RollbackManagerInternal rm = (RollbackManagerInternal) LocalServices.getService(RollbackManagerInternal.class);
        int i = 0;
        int sessionsSize = apexSessions.size();
    L16:
        if (i >= sessionsSize) goto L22;
        String packageName = apexSessions.get(i).getPackageName();
        snapshotAndRestoreApexUserData(packageName, allUsers, rm);
        List<String> apksInApex = this.mApexManager.getApksInApex(packageName);
        int j = 0;
        int apksSize = apksInApex.size();
    L18:
        if (j >= apksSize) goto L20;
        snapshotAndRestoreApkInApexUserData(apksInApex.get(j), allUsers, rm);
        j = j + 1;
        goto L18
    L20:
        i = i + 1;
        goto L16
    L22:
        return;
    L5:
        if (session.sessionParams().installReason == 5) goto L8;
        doSnapshotOrRestore = false;
        goto L10
    }

    private void snapshotAndRestoreApexUserData(String packageName, int[] allUsers, RollbackManagerInternal rm) {
        rm.snapshotAndRestoreUserData(packageName, UserHandle.toUserHandles(allUsers), 0, 0, null, 0);
    }

    private void snapshotAndRestoreApkInApexUserData(String packageName, int[] allUsers, RollbackManagerInternal rm) {
        PackageManagerInternal mPmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        AndroidPackage pkg = mPmi.getPackage(packageName);
        if (pkg != null) goto L6;
        Slog.e(TAG, "Could not find package: " + packageName + "for snapshotting/restoring user data.");
        return;
    L6:
        PackageStateInternal ps = mPmi.getPackageStateInternal(packageName);
        if (ps == null) goto L10;
        int appId = ps.getAppId();
        long ceDataInode = ps.getUserStateOrDefault(0).getCeDataInode();
        int[] installedUsers = PackageStateUtils.queryInstalledUsers(ps, allUsers, true);
        String seInfo = ps.getSeInfo();
        rm.snapshotAndRestoreUserData(packageName, UserHandle.toUserHandles(installedUsers), appId, ceDataInode, seInfo, 0);
        return;
    }

    private void prepareForLoggingApexdRevert(StagedSession session, String nativeFailureReason) {
        List<String> r0 = this.mFailedPackageNames;
        monitor-enter(r0);
        this.mNativeFailureReason = nativeFailureReason;     // Catch: Throwable -> L7
        if (session.getPackageName() == null) goto L9;
        this.mFailedPackageNames.add(session.getPackageName());     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void resumeSession(StagedSession session, boolean supportsCheckpoint, boolean needsCheckpoint) throws PackageManagerException {
        Slog.d(TAG, "Resuming session " + session.sessionId());
        boolean hasApex = session.containsApexSession();
        if (supportsCheckpoint == false) goto L10;
        if (needsCheckpoint == true) goto L10;
        String revertMsg = "Reverting back to safe state. Marking " + session.sessionId() + " as failed.";
        String reasonForRevert = getReasonForRevert();
        if (TextUtils.isEmpty(reasonForRevert) == true) goto L8;
        revertMsg = revertMsg + " Reason for revert: " + reasonForRevert;
    L8:
        Slog.d(TAG, revertMsg);
        session.setSessionFailed(-110, revertMsg);
        return;
    L10:
        if (hasApex == false) goto L12;
        checkInstallationOfApkInApexSuccessful(session);
        checkDuplicateApkInApex(session);
        snapshotAndRestoreForApexSession(session);
        Slog.i(TAG, "APEX packages in session " + session.sessionId() + " were successfully activated. Proceeding with APK packages, if any");
    L12:
        Slog.d(TAG, "Installing APK packages in session " + session.sessionId());
        TimingsTraceLog t = new TimingsTraceLog("StagingManagerTiming", 262144);
        t.traceBegin("installApksInSession");
        installApksInSession(session);
        t.traceEnd();
        if (hasApex == false) goto L27;
        if (supportsCheckpoint == false) goto L23;
        List<Integer> r2 = this.mSuccessfulStagedSessionIds;
        monitor-enter(r2);
        this.mSuccessfulStagedSessionIds.add(Integer.valueOf(session.sessionId()));     // Catch: Throwable -> L20
        monitor-exit(r2);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L23:
        this.mApexManager.markStagedSessionSuccessful(session.sessionId());
        return;
    }

    void onInstallationFailure(StagedSession session, PackageManagerException e, boolean supportsCheckpoint, boolean needsCheckpoint) {
        session.setSessionFailed(e.error, e.getMessage());
        abortCheckpoint("Failed to install sessionId: " + session.sessionId() + " Error: " + e.getMessage(), supportsCheckpoint, needsCheckpoint);
        if (session.containsApexSession() == true) goto L6;
        return;
    L6:
        if (this.mApexManager.revertActiveSessions() == true) goto L8;
        Slog.e(TAG, "Failed to abort APEXd session");
        return;
    L8:
        Slog.e(TAG, "Successfully aborted apexd session. Rebooting device in order to revert to the previous state of APEXd.");
        this.mPowerManager.reboot(null);
    }

    private String getReasonForRevert() {
        if (TextUtils.isEmpty(this.mFailureReason) == true) goto L7;
        return this.mFailureReason;
    L7:
        if (TextUtils.isEmpty(this.mNativeFailureReason) == false) goto L9;
        return "";
    L9:
        return "Session reverted due to crashing native process: " + this.mNativeFailureReason;
    }

    private void checkDuplicateApkInApex(StagedSession session) throws PackageManagerException {
        if (session.isMultiPackage() == true) goto L5;
        return;
    L5:
        Set<String> apkNames = new ArraySet();
        Iterator<StagedSession> r1 = session.getChildSessions().iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        StagedSession s = r1.next();
        if (s.isApexSession() == true) goto L7;
        apkNames.add(s.getPackageName());
        goto L7
    L12:
        List<StagedSession> apexSessions = extractApexSessions(session);
        Iterator<StagedSession> r2 = apexSessions.iterator();
    L14:
        if (r2.hasNext() == false) goto L24;
        StagedSession apexSession = r2.next();
        String packageName = apexSession.getPackageName();
        Iterator<String> r5 = this.mApexManager.getApksInApex(packageName).iterator();
    L17:
        if (r5.hasNext() == false) goto L14;
        String apkInApex = r5.next();
        if (apkNames.add(apkInApex) == true) goto L17;
        throw new PackageManagerException(UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION, "Package: " + packageName + " in session: " + apexSession.sessionId() + " has duplicate apk-in-apex: " + apkInApex, null);
    }

    private void installApksInSession(StagedSession session) throws PackageManagerException {
        session.installSession().get();     // Catch: ExecutionException -> L4 InterruptedException -> L6
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        ee = move-exception;
        throw ((PackageManagerException) ee.getCause());
    }

    void commitSession(StagedSession session) {
        createSession(session);
        handleCommittedSession(session);
    }

    private void handleCommittedSession(StagedSession session) {
        if (session.isSessionReady() == true) goto L5;
        return;
    L5:
        if (session.containsApexSession() == false) goto L9;
        notifyStagedApexObservers();
        return;
    }

    void createSession(StagedSession sessionInfo) {
        SparseArray<StagedSession> r0 = this.mStagedSessions;
        monitor-enter(r0);
        this.mStagedSessions.append(sessionInfo.sessionId(), sessionInfo);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void abortSession(StagedSession session) {
        SparseArray<StagedSession> r0 = this.mStagedSessions;
        monitor-enter(r0);
        this.mStagedSessions.remove(session.sessionId());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void abortCommittedSession(StagedSession session) {
        int sessionId = session.sessionId();
        if (session.isInTerminalState() == false) goto L7;
        Slog.w(TAG, "Cannot abort session in final state: " + sessionId);
        return;
    L7:
        if (session.isDestroyed() == false) goto L23;
        if (getStagedSession(sessionId) != null) goto L13;
        Slog.w(TAG, "Session " + sessionId + " has been abandoned already");
        return;
    L13:
        if (session.isSessionReady() == true) goto L15;
    L20:
        abortSession(session);
        return;
    L15:
        if (ensureActiveApexSessionIsAborted(session) == true) goto L18;
        Slog.e(TAG, "Failed to abort apex session " + session.sessionId());
    L18:
        if (session.containsApexSession() == false) goto L20;
        notifyStagedApexObservers();
        goto L20
    L23:
        throw new IllegalStateException("Committed session must be destroyed before aborting it from StagingManager");
    }

    private boolean ensureActiveApexSessionIsAborted(StagedSession session) {
        if (session.containsApexSession() == true) goto L5;
        return true;
    L5:
        ApexSessionInfo apexSession = this.mApexManager.getStagedSessionInfo(session.sessionId());
        if (apexSession != null) goto L8;
    L12:
        return true;
    L8:
        if (isApexSessionFinalized(apexSession) == true) goto L12;
        return this.mApexManager.abortStagedSession(session.sessionId());
    }

    private boolean isApexSessionFinalized(ApexSessionInfo session) {
        if (session.isUnknown == false) goto L5;
    L12:
        return true;
    L5:
        if (session.isActivationFailed == true) goto L12;
        if (session.isSuccess == true) goto L12;
        if (session.isReverted == true) goto L12;
        return false;
    }

    private static boolean isApexSessionFailed(ApexSessionInfo apexSessionInfo) {
        if (apexSessionInfo.isActivationFailed == false) goto L5;
    L14:
        return true;
    L5:
        if (apexSessionInfo.isUnknown == true) goto L14;
        if (apexSessionInfo.isReverted == true) goto L14;
        if (apexSessionInfo.isRevertInProgress == true) goto L14;
        if (apexSessionInfo.isRevertFailed == true) goto L14;
        return false;
    }

    private void handleNonReadyAndDestroyedSessions(List<StagedSession> sessions) {
        int j = sessions.size();
        int i = 0;
    L3:
        if (i >= j) goto L12;
        final StagedSession session = sessions.get(i);
        if (session.isDestroyed() == true) goto L6;
        if (session.isSessionReady() == false) goto L9;
        i = i + 1;
        goto L3
    L9:
        Slog.i(TAG, "Restart verification for session=" + session.sessionId());
        this.mBootCompleted.thenRun(new StagingManager$$ExternalSyntheticLambda1(session));
        StagedSession session2 = sessions.set(j + (-1), session);
        sessions.set(i, session2);
        j = j - 1;
        goto L3
    L6:
        session.abandon();
        StagedSession session3 = sessions.set(j - 1, session);
        sessions.set(i, session3);
        j = j - 1;
        goto L3
    L12:
        int i2 = sessions.size();
        sessions.subList(j, i2).clear();
    }

    private static /* synthetic */ void lambda$handleNonReadyAndDestroyedSessions$0(StagedSession session) {
        session.verifySession();
    }

    void restoreSessions(List<StagedSession> sessions, boolean isDeviceUpgrading) {
        TimingsTraceLog t = new TimingsTraceLog("StagingManagerTiming", 262144);
        t.traceBegin("restoreSessions");
        if (SystemProperties.getBoolean("sys.boot_completed", false) == false) goto L5;
        return;
    L5:
        int i = 0;
    L7:
        if (i >= sessions.size()) goto L10;
        StagedSession session = sessions.get(i);
        Preconditions.checkArgument(!session.hasParentSessionId(), session.sessionId() + " is a child session");
        Preconditions.checkArgument(session.isCommitted(), session.sessionId() + " is not committed");
        Preconditions.checkArgument(true ^ session.isInTerminalState(), session.sessionId() + " is in terminal state");
        createSession(session);
        i = i + 1;
        goto L7
    L10:
        if (isDeviceUpgrading == false) goto L92;
        int i2 = 0;
    L13:
        if (i2 >= sessions.size()) goto L16;
        sessions.get(i2).setSessionFailed(UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION, "Build fingerprint has changed");
        i2 = i2 + 1;
        goto L13
    L16:
        return;
    L92:
        boolean supportsCheckpoint = InstallLocationUtils.getStorageManager().supportsCheckpoint();     // Catch: RemoteException -> L89
        boolean needsCheckpoint = InstallLocationUtils.getStorageManager().needsCheckpoint();     // Catch: RemoteException -> L89
        if (sessions.size() <= 1) goto L25;
        if (supportsCheckpoint == true) goto L25;
        throw new IllegalStateException("Detected multiple staged sessions on a device without fs-checkpoint support");
    L25:
        handleNonReadyAndDestroyedSessions(sessions);
        SparseArray<ApexSessionInfo> apexSessions = this.mApexManager.getSessions();
        boolean hasFailedApexSession = false;
        boolean hasAppliedApexSession = false;
        int i3 = 0;
    L27:
        if (i3 >= sessions.size()) goto L61;
        StagedSession session2 = sessions.get(i3);
        if (session2.containsApexSession() == false) goto L59;
        ApexSessionInfo apexSession = apexSessions.get(session2.sessionId());
        if (apexSession != null) goto L34;
    L58:
        session2.setSessionFailed(UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION, "apexd did not know anything about a staged session supposed to be activated");
        hasFailedApexSession = true;
        goto L59
    L34:
        if (apexSession.isUnknown == true) goto L58;
        if (isApexSessionFailed(apexSession) == false) goto L49;
        hasFailedApexSession = true;
        if (TextUtils.isEmpty(apexSession.crashingNativeProcess) == true) goto L41;
        prepareForLoggingApexdRevert(session2, apexSession.crashingNativeProcess);
    L41:
        String errorMsg = "APEX activation failed.";
        String reasonForRevert = getReasonForRevert();
        if (TextUtils.isEmpty(reasonForRevert) == true) goto L45;
        errorMsg = "APEX activation failed. Reason: " + reasonForRevert;
    L47:
        Slog.d(TAG, errorMsg);
        session2.setSessionFailed(UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION, errorMsg);
        goto L59
    L45:
        if (TextUtils.isEmpty(apexSession.errorMessage) == true) goto L47;
        errorMsg = "APEX activation failed. Error: " + apexSession.errorMessage;
        goto L47
    L49:
        if (apexSession.isActivated == false) goto L51;
    L57:
        hasAppliedApexSession = true;
        goto L59
    L51:
        if (apexSession.isSuccess == true) goto L57;
        if (apexSession.isStaged == false) goto L56;
        session2.setSessionFailed(UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION, "Staged session " + session2.sessionId() + " at boot didn't activate nor fail. Marking it as failed anyway.");
        hasFailedApexSession = true;
        goto L59
    L56:
        Slog.w(TAG, "Apex session " + session2.sessionId() + " is in impossible state");
        session2.setSessionFailed(UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION, "Impossible state");
        hasFailedApexSession = true;
    L59:
        i3 = i3 + 1;
        goto L27
    L61:
        if (hasAppliedApexSession == false) goto L65;
        if (hasFailedApexSession == false) goto L65;
        abortCheckpoint("Found both applied and failed apex sessions", supportsCheckpoint, needsCheckpoint);
        return;
    L65:
        if (hasFailedApexSession == false) goto L76;
        int i4 = 0;
    L68:
        if (i4 >= sessions.size()) goto L75;
        StagedSession session3 = sessions.get(i4);
        if (session3.isSessionFailed() == true) goto L73;
        session3.setSessionFailed(UsbEndpointDescriptor.MASK_ENDPOINT_DIRECTION, "Another apex session failed");
    L73:
        i4 = i4 + 1;
        goto L68
    L75:
        return;
    L76:
        int i5 = 0;
    L78:
        if (i5 >= sessions.size()) goto L87;
        StagedSession session4 = sessions.get(i5);
        resumeSession(session4, supportsCheckpoint, needsCheckpoint);     // Catch: Exception -> L82 PackageManagerException -> L84
    L86:
        i5 = i5 + 1;
    L84:
        e = move-exception;
        onInstallationFailure(session4, e, supportsCheckpoint, needsCheckpoint);
    L82:
        e = move-exception;
        Slog.e(TAG, "Staged install failed due to unhandled exception", e);
        onInstallationFailure(session4, new PackageManagerException(-110, "Staged install failed due to unhandled exception: " + e), supportsCheckpoint, needsCheckpoint);
        goto L86
    L87:
        t.traceEnd();
        return;
    L89:
        e = move-exception;
        throw new IllegalStateException("Failed to get checkpoint status", e);
    }

    private void logFailedApexSessionsIfNecessary() {
        List<String> r0 = this.mFailedPackageNames;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mFailedPackageNames.isEmpty() == true) goto L9;
        ApexdRevertLogger.logApexdRevert(this.mContext, this.mFailedPackageNames, this.mNativeFailureReason);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void markStagedSessionsAsSuccessful() {
        List<Integer> r0 = this.mSuccessfulStagedSessionIds;
        monitor-enter(r0);
        int i = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mSuccessfulStagedSessionIds.size()) goto L11;
        this.mApexManager.markStagedSessionSuccessful(this.mSuccessfulStagedSessionIds.get(i).intValue());     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    void systemReady() {
        new Lifecycle(this.mContext).startService(this);
        this.mContext.registerReceiver(new AnonymousClass2(this), new IntentFilter("android.intent.action.BOOT_COMPLETED"));
        this.mFailureReasonFile.delete();
    }

    void onBootCompletedBroadcastReceived() {
        this.mBootCompleted.complete(null);
        BackgroundThread.getExecutor().execute(new StagingManager$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$onBootCompletedBroadcastReceived$1() {
        logFailedApexSessionsIfNecessary();
    }

    private StagedSession getStagedSession(int sessionId) {
        SparseArray<StagedSession> r0 = this.mStagedSessions;
        monitor-enter(r0);
        StagedSession session = this.mStagedSessions.get(sessionId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return session;
    L7:
        th = move-exception;
        throw th;
    }

    List<ApexInfo> getStagedApexInfos(StagedSession session) {
        if (session == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "Session is null");
        Preconditions.checkArgument(true ^ session.hasParentSessionId(), session.sessionId() + " session has parent session");
        Preconditions.checkArgument(session.containsApexSession(), session.sessionId() + " session does not contain apex");
        if (session.isSessionReady() == false) goto L23;
        if (session.isDestroyed() == true) goto L23;
        ApexSessionParams params = new ApexSessionParams();
        params.sessionId = session.sessionId();
        IntArray childSessionIds = new IntArray();
        if (session.isMultiPackage() == false) goto L20;
        Iterator<StagedSession> r2 = session.getChildSessions().iterator();
    L15:
        if (r2.hasNext() == false) goto L20;
        StagedSession s = r2.next();
        if (s.isApexSession() == false) goto L15;
        childSessionIds.add(s.sessionId());
    L20:
        params.childSessionIds = childSessionIds.toArray();
        return Arrays.asList(this.mApexManager.getStagedApexInfos(params));
    L23:
        return Collections.emptyList();
    L5:
        r1 = false;
        goto L6
    }

    List<StagedApexInfo> getStagedApexInfos() {
        final List<StagedApexInfo> result = new ArrayList();
        SparseArray<StagedSession> r1 = this.mStagedSessions;
        monitor-enter(r1);
        int i = 0;
    L25:
    L17:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mStagedSessions.size()) goto L21;
        StagedSession session = this.mStagedSessions.valueAt(i);     // Catch: Throwable -> L17
        if (session.isSessionReady() == false) goto L19;
        if (session.isDestroyed() == true) goto L19;
        if (session.hasParentSessionId() == true) goto L19;
        if (session.containsApexSession() == false) goto L19;
        getStagedApexInfos(session).stream().map(new StagingManager$$ExternalSyntheticLambda2()).forEach(new StagingManager$$ExternalSyntheticLambda3(result));     // Catch: Throwable -> L17
    L19:
        i = i + 1;     // Catch: Throwable -> L17
        goto L25
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L17
        return result;
    }

    private static /* synthetic */ StagedApexInfo lambda$getStagedApexInfos$2(ApexInfo ai) {
        StagedApexInfo info = new StagedApexInfo();
        info.moduleName = ai.moduleName;
        info.diskImagePath = ai.modulePath;
        info.versionCode = ai.versionCode;
        info.versionName = ai.versionName;
        info.hasClassPathJars = ai.hasClassPathJars;
        return info;
    }

    private void notifyStagedApexObservers() {
        List<IStagedApexObserver> r0 = this.mStagedApexObservers;
        monitor-enter(r0);
        List<StagedApexInfo> stagedApexInfos = getStagedApexInfos();     // Catch: Throwable -> L10
        ApexStagedEvent event = new ApexStagedEvent();     // Catch: Throwable -> L10
        event.stagedApexInfos = (StagedApexInfo[]) stagedApexInfos.toArray(new StagedApexInfo[stagedApexInfos.size()]);     // Catch: Throwable -> L10
        Iterator<IStagedApexObserver> r3 = this.mStagedApexObservers.iterator();     // Catch: Throwable -> L10
    L6:
        if (r3.hasNext() == false) goto L15;
        IStagedApexObserver observer = r3.next();     // Catch: Throwable -> L10
        observer.onApexStaged(event);     // Catch: Throwable -> L10 RemoteException -> L12
    L12:
        re = move-exception;
        Slog.w(TAG, "Failed to contact the observer " + re.getMessage());     // Catch: Throwable -> L10
        goto L6
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
