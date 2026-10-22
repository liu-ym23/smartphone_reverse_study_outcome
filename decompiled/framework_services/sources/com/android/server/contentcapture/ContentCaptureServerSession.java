package com.android.server.contentcapture;

import android.app.assist.ActivityId;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.service.contentcapture.ContentCaptureService;
import android.service.contentcapture.SnapshotData;
import android.util.LocalLog;
import android.util.Slog;
import android.view.contentcapture.ContentCaptureContext;
import com.android.internal.os.IResultReceiver;
import com.android.internal.util.Preconditions;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import com.android.server.usb.descriptors.UsbACInterface;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
final class ContentCaptureServerSession {
    private static final String TAG = null;
    public final ComponentName appComponentName;
    final IBinder mActivityToken;
    private final ContentCaptureContext mContentCaptureContext;
    private final int mId;
    private final Object mLock;
    private final ContentCapturePerUserService mService;
    private final IResultReceiver mSessionStateReceiver;
    private final int mUid;

    /* JADX INFO: renamed from: $r8$lambda$EU9J6gm_m2xpBMPhpaTMVbMo-YE, reason: not valid java name */
    public static /* synthetic */ void m3227$r8$lambda$EU9J6gm_m2xpBMPhpaTMVbMoYE(ContentCaptureServerSession r0) {
        r0.lambda$new$0();
    }

    static {
        TAG = ContentCaptureServerSession.class.getSimpleName();
    }

    ContentCaptureServerSession(Object lock, IBinder activityToken, ActivityId activityId, ContentCapturePerUserService service, ComponentName appComponentName, IResultReceiver sessionStateReceiver, int taskId, int displayId, int sessionId, int uid, int flags) {
        if (sessionId == 0) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2);
        this.mLock = lock;
        this.mActivityToken = activityToken;
        this.appComponentName = appComponentName;
        this.mService = service;
        this.mId = sessionId;
        this.mUid = uid;
        this.mContentCaptureContext = new ContentCaptureContext(null, activityId, appComponentName, displayId, activityToken, flags);
        this.mSessionStateReceiver = sessionStateReceiver;
        sessionStateReceiver.asBinder().linkToDeath(new ContentCaptureServerSession$$ExternalSyntheticLambda0(this), 0);     // Catch: Exception -> L9
        return;
    L10:
        Slog.w(TAG, "could not register DeathRecipient for " + activityToken);
        return;
    L5:
        r2 = false;
        goto L6
    }

    private /* synthetic */ void lambda$new$0() {
        onClientDeath();
    }

    boolean isActivitySession(IBinder activityToken) {
        return this.mActivityToken.equals(activityToken);
    }

    public void notifySessionStartedLocked(IResultReceiver clientReceiver) {
        if (this.mService.mRemoteService != null) goto L6;
        Slog.w(TAG, "notifySessionStartedLocked(): no remote service");
        return;
    L6:
        this.mService.mRemoteService.onSessionStarted(this.mContentCaptureContext, this.mId, this.mUid, clientReceiver, 2);
    }

    public void setContentCaptureEnabledLocked(boolean enabled) {
        Bundle extras = new Bundle();     // Catch: RemoteException -> L8
        int r2 = 1;
        extras.putBoolean(ServiceConfigAccessor.PROVIDER_MODE_ENABLED, true);     // Catch: RemoteException -> L8
        IResultReceiver r1 = this.mSessionStateReceiver;     // Catch: RemoteException -> L8
        if (enabled == true) goto L6;
        r2 = 2;
    L6:
        r1.send(r2, extras);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        Slog.w(TAG, "Error async reporting result to client: " + e);
    }

    public void sendActivitySnapshotLocked(SnapshotData snapshotData) {
        LocalLog logHistory = this.mService.getMaster().mRequestsHistory;
        if (logHistory == null) goto L6;
        logHistory.log("snapshot: id=" + this.mId);
    L6:
        if (this.mService.mRemoteService != null) goto L9;
        Slog.w(TAG, "sendActivitySnapshotLocked(): no remote service");
        return;
    L9:
        this.mService.mRemoteService.onActivitySnapshotRequest(this.mId, snapshotData);
    }

    public void removeSelfLocked(boolean notifyRemoteService) {
        destroyLocked(notifyRemoteService);     // Catch: Throwable -> L5
        this.mService.removeSessionLocked(this.mId);
        return;
    L5:
        th = move-exception;
        this.mService.removeSessionLocked(this.mId);
        throw th;
    }

    public void destroyLocked(boolean notifyRemoteService) {
        if (this.mService.isVerbose() == false) goto L5;
        Slog.v(TAG, "destroy(notifyRemoteService=" + notifyRemoteService + ")");
    L5:
        if (notifyRemoteService == true) goto L7;
        return;
    L7:
        if (this.mService.mRemoteService != null) goto L10;
        Slog.w(TAG, "destroyLocked(): no remote service");
        return;
    L10:
        this.mService.mRemoteService.onSessionFinished(this.mId);
    }

    public void resurrectLocked() {
        RemoteContentCaptureService remoteService = this.mService.mRemoteService;
        if (remoteService != null) goto L7;
        Slog.w(TAG, "destroyLocked(: no remote service");
        return;
    L7:
        if (this.mService.isVerbose() == false) goto L9;
        Slog.v(TAG, "resurrecting " + this.mActivityToken + " on " + remoteService);
    L9:
        remoteService.onSessionStarted(new ContentCaptureContext(this.mContentCaptureContext, 4), this.mId, this.mUid, this.mSessionStateReceiver, UsbACInterface.FORMAT_II_AC3);
    }

    public void pauseLocked() {
        if (this.mService.isVerbose() == false) goto L5;
        Slog.v(TAG, "pausing " + this.mActivityToken);
    L5:
        ContentCaptureService.setClientState(this.mSessionStateReceiver, 2052, null);
    }

    private void onClientDeath() {
        if (this.mService.isVerbose() == false) goto L5;
        Slog.v(TAG, "onClientDeath(" + this.mActivityToken + "): removing session " + this.mId);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        removeSelfLocked(true);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void dumpLocked(String prefix, PrintWriter pw) {
        pw.print(prefix);
        pw.print("id: ");
        pw.print(this.mId);
        pw.println();
        pw.print(prefix);
        pw.print("uid: ");
        pw.print(this.mUid);
        pw.println();
        pw.print(prefix);
        pw.print("context: ");
        this.mContentCaptureContext.dump(pw);
        pw.println();
        pw.print(prefix);
        pw.print("activity token: ");
        pw.println(this.mActivityToken);
        pw.print(prefix);
        pw.print("app component: ");
        pw.println(this.appComponentName);
        pw.print(prefix);
        pw.print("has autofill callback: ");
    }

    String toShortString() {
        return this.mId + ":" + this.mActivityToken;
    }

    public String toString() {
        return "ContentCaptureSession[id=" + this.mId + ", act=" + this.mActivityToken + "]";
    }
}
