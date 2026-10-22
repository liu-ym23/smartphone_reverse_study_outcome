package com.android.server.pm;

import android.content.pm.IPackageInstallObserver2;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.Trace;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.Slog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class MultiPackageVerifyingSession {
    private final List<VerifyingSession> mChildVerifyingSessions;
    private final IPackageInstallObserver2 mObserver;
    private final UserHandle mUser;
    private final Set<VerifyingSession> mVerificationState;

    MultiPackageVerifyingSession(VerifyingSession parent, List<VerifyingSession> children) throws PackageManagerException {
        this.mUser = parent.getUser();
        if (children.size() == 0) goto L11;
        this.mChildVerifyingSessions = children;
        int i = 0;
    L6:
        if (i >= children.size()) goto L8;
        VerifyingSession childVerifyingSession = children.get(i);
        childVerifyingSession.mParentVerifyingSession = this;
        i = i + 1;
        goto L6
    L8:
        this.mVerificationState = new ArraySet(this.mChildVerifyingSessions.size());
        this.mObserver = parent.mObserver;
        return;
    L11:
        throw PackageManagerException.ofInternalError("No child sessions found!", -21);
    }

    public void start() {
        Trace.asyncTraceEnd(262144, "queueVerify", System.identityHashCode(this));
        Trace.traceBegin(262144, "startVerify");
        Iterator<VerifyingSession> r0 = this.mChildVerifyingSessions.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        VerifyingSession childVerifyingSession = r0.next();
        childVerifyingSession.handleStartVerify();
        goto L4
    L6:
        Iterator<VerifyingSession> r1 = this.mChildVerifyingSessions.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        VerifyingSession childVerifyingSession2 = r1.next();
        childVerifyingSession2.handleReturnCode();
        goto L8
    L10:
        Trace.traceEnd(262144);
    }

    public void trySendVerificationCompleteNotification(VerifyingSession child) {
        this.mVerificationState.add(child);
        if (this.mVerificationState.size() == this.mChildVerifyingSessions.size()) goto L5;
        return;
    L5:
        int completeStatus = 1;
        String errorMsg = null;
        Iterator<VerifyingSession> r2 = this.mVerificationState.iterator();
    L7:
        if (r2.hasNext() == false) goto L17;
        VerifyingSession childVerifyingSession = r2.next();
        int status = childVerifyingSession.getRet();
        if (status == 1) goto L7;
        completeStatus = status;
        errorMsg = childVerifyingSession.getErrorMessage();
    L17:
        this.mObserver.onPackageInstalled(null, completeStatus, errorMsg, new Bundle());     // Catch: RemoteException -> L14
        return;
    L15:
        Slog.i(PackageManagerServiceMonitorEx.TAG, "Observer no longer exists.");
    }

    public String toString() {
        return "MultiPackageVerifyingSession{" + Integer.toHexString(System.identityHashCode(this)) + "}";
    }
}
