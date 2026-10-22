package com.android.server.pm;

import android.content.pm.PackageInstaller;
import android.content.pm.verify.domain.DomainSet;
import com.android.internal.util.IndentingPrintWriter;
import java.io.CharArrayWriter;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class PackageInstallerHistoricalSession {
    private final int mBridges;
    private final int[] mChildSessionIds;
    private final float mClientProgress;
    private final boolean mCommitted;
    private final long mCommittedMillis;
    private final long mCreatedMillis;
    private final boolean mDestroyed;
    private final int mFds;
    private final String mFinalMessage;
    private final int mFinalStatus;
    private final InstallSource mInstallSource;
    private final int mInstallerUid;
    private final String mOriginalInstallerPackageName;
    private final int mOriginalInstallerUid;
    private final String mPackageName;
    private final String mParams;
    private final int mParentSessionId;
    private final boolean mPermissionsManuallyAccepted;
    private final String mPreVerifiedDomains;
    private final String mPreapprovalDetails;
    private final boolean mPreapprovalRequested;
    private final float mProgress;
    private final boolean mSealed;
    private final boolean mSessionApplied;
    private final int mSessionErrorCode;
    private final String mSessionErrorMessage;
    private final boolean mSessionFailed;
    private final boolean mSessionReady;
    private final String mStageCid;
    private final File mStageDir;
    private final boolean mStageDirInUse;
    private final long mUpdatedMillis;
    public final int sessionId;
    public final int userId;

    PackageInstallerHistoricalSession(int sessionId, int userId, int originalInstallerUid, String originalInstallerPackageName, InstallSource installSource, int installerUid, long createdMillis, long updatedMillis, long committedMillis, File stageDir, String stageCid, float clientProgress, float progress, boolean committed, boolean preapprovalRequested, boolean sealed, boolean permissionsManuallyAccepted, boolean stageDirInUse, boolean destroyed, int fds, int bridges, int finalStatus, String finalMessage, PackageInstaller.SessionParams params, int parentSessionId, int[] childSessionIds, boolean sessionApplied, boolean sessionFailed, boolean sessionReady, int sessionErrorCode, String sessionErrorMessage, PackageInstaller.PreapprovalDetails preapprovalDetails, DomainSet preVerifiedDomains, String packageNameFromApk) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.mOriginalInstallerUid = originalInstallerUid;
        this.mOriginalInstallerPackageName = originalInstallerPackageName;
        this.mInstallSource = installSource;
        this.mInstallerUid = installerUid;
        this.mCreatedMillis = createdMillis;
        this.mUpdatedMillis = updatedMillis;
        this.mCommittedMillis = committedMillis;
        this.mStageDir = stageDir;
        this.mStageCid = stageCid;
        this.mClientProgress = clientProgress;
        this.mProgress = progress;
        this.mCommitted = committed;
        this.mPreapprovalRequested = preapprovalRequested;
        this.mSealed = sealed;
        this.mPermissionsManuallyAccepted = permissionsManuallyAccepted;
        this.mStageDirInUse = stageDirInUse;
        this.mDestroyed = destroyed;
        this.mFds = fds;
        this.mBridges = bridges;
        this.mFinalStatus = finalStatus;
        this.mFinalMessage = finalMessage;
        CharArrayWriter writer = new CharArrayWriter();
        IndentingPrintWriter pw = new IndentingPrintWriter(writer, "    ");
        params.dump(pw);
        this.mParams = writer.toString();
        this.mParentSessionId = parentSessionId;
        this.mChildSessionIds = childSessionIds;
        this.mSessionApplied = sessionApplied;
        this.mSessionFailed = sessionFailed;
        this.mSessionReady = sessionReady;
        this.mSessionErrorCode = sessionErrorCode;
        this.mSessionErrorMessage = sessionErrorMessage;
        if (preapprovalDetails == null) goto L5;
        this.mPreapprovalDetails = preapprovalDetails.toString();
        String r2 = null;
    L6:
        if (preVerifiedDomains == null) goto L8;
        this.mPreVerifiedDomains = String.join(",", preVerifiedDomains.getDomains());
    L9:
        if (preapprovalDetails == null) goto L11;
        String r3 = preapprovalDetails.getPackageName();
    L14:
        this.mPackageName = r3;
        return;
    L11:
        if (packageNameFromApk == null) goto L13;
        r3 = packageNameFromApk;
        goto L14
    L13:
        r3 = params.appPackageName;
        goto L14
    L8:
        this.mPreVerifiedDomains = r2;
        goto L9
    L5:
        r2 = null;
        this.mPreapprovalDetails = null;
        goto L6
    }

    void dump(IndentingPrintWriter pw) {
        pw.println("Session " + this.sessionId + ":");
        pw.increaseIndent();
        pw.printPair("userId", Integer.valueOf(this.userId));
        pw.printPair("mOriginalInstallerUid", Integer.valueOf(this.mOriginalInstallerUid));
        pw.printPair("mOriginalInstallerPackageName", this.mOriginalInstallerPackageName);
        pw.printPair("installerPackageName", this.mInstallSource.mInstallerPackageName);
        pw.printPair("installInitiatingPackageName", this.mInstallSource.mInitiatingPackageName);
        pw.printPair("installOriginatingPackageName", this.mInstallSource.mOriginatingPackageName);
        pw.printPair("mInstallerUid", Integer.valueOf(this.mInstallerUid));
        pw.printPair("createdMillis", Long.valueOf(this.mCreatedMillis));
        pw.printPair("updatedMillis", Long.valueOf(this.mUpdatedMillis));
        pw.printPair("committedMillis", Long.valueOf(this.mCommittedMillis));
        pw.printPair("stageDir", this.mStageDir);
        pw.printPair("stageCid", this.mStageCid);
        pw.println();
        pw.print(this.mParams);
        pw.printPair("mClientProgress", Float.valueOf(this.mClientProgress));
        pw.printPair("mProgress", Float.valueOf(this.mProgress));
        pw.printPair("mCommitted", Boolean.valueOf(this.mCommitted));
        pw.printPair("mPreapprovalRequested", Boolean.valueOf(this.mPreapprovalRequested));
        pw.printPair("mSealed", Boolean.valueOf(this.mSealed));
        pw.printPair("mPermissionsManuallyAccepted", Boolean.valueOf(this.mPermissionsManuallyAccepted));
        pw.printPair("mStageDirInUse", Boolean.valueOf(this.mStageDirInUse));
        pw.printPair("mDestroyed", Boolean.valueOf(this.mDestroyed));
        pw.printPair("mFds", Integer.valueOf(this.mFds));
        pw.printPair("mBridges", Integer.valueOf(this.mBridges));
        pw.printPair("mFinalStatus", Integer.valueOf(this.mFinalStatus));
        pw.printPair("mFinalMessage", this.mFinalMessage);
        pw.printPair("mParentSessionId", Integer.valueOf(this.mParentSessionId));
        pw.printPair("mChildSessionIds", this.mChildSessionIds);
        pw.printPair("mSessionApplied", Boolean.valueOf(this.mSessionApplied));
        pw.printPair("mSessionFailed", Boolean.valueOf(this.mSessionFailed));
        pw.printPair("mSessionReady", Boolean.valueOf(this.mSessionReady));
        pw.printPair("mSessionErrorCode", Integer.valueOf(this.mSessionErrorCode));
        pw.printPair("mSessionErrorMessage", this.mSessionErrorMessage);
        pw.printPair("mPreapprovalDetails", this.mPreapprovalDetails);
        pw.printPair("mPreVerifiedDomains", this.mPreVerifiedDomains);
        pw.printPair("mAppPackageName", this.mPackageName);
        pw.println();
        pw.decreaseIndent();
    }

    public PackageInstaller.SessionInfo generateInfo() {
        PackageInstaller.SessionInfo info = new PackageInstaller.SessionInfo();
        info.sessionId = this.sessionId;
        info.userId = this.userId;
        info.installerPackageName = this.mInstallSource.mInstallerPackageName;
        info.installerAttributionTag = this.mInstallSource.mInstallerAttributionTag;
        info.progress = this.mProgress;
        info.sealed = this.mSealed;
        info.isCommitted = this.mCommitted;
        info.isPreapprovalRequested = this.mPreapprovalRequested;
        info.parentSessionId = this.mParentSessionId;
        info.childSessionIds = this.mChildSessionIds;
        info.isSessionApplied = this.mSessionApplied;
        info.isSessionReady = this.mSessionReady;
        info.isSessionFailed = this.mSessionFailed;
        info.setSessionErrorCode(this.mSessionErrorCode, this.mSessionErrorMessage);
        info.createdMillis = this.mCreatedMillis;
        info.updatedMillis = this.mUpdatedMillis;
        info.installerUid = this.mInstallerUid;
        info.appPackageName = this.mPackageName;
        return info;
    }
}
