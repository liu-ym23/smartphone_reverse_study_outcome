package com.android.server.contentcapture;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.service.contentcapture.ActivityEvent;
import android.service.contentcapture.IContentCaptureService;
import android.service.contentcapture.IContentCaptureServiceCallback;
import android.service.contentcapture.IDataShareCallback;
import android.service.contentcapture.SnapshotData;
import android.util.EventLog;
import android.util.Slog;
import android.view.contentcapture.ContentCaptureContext;
import android.view.contentcapture.ContentCaptureHelper;
import android.view.contentcapture.DataRemovalRequest;
import android.view.contentcapture.DataShareRequest;
import com.android.internal.infra.AbstractMultiplePendingRequestsRemoteService;
import com.android.internal.infra.AbstractRemoteService;
import com.android.internal.os.IResultReceiver;
import com.android.internal.util.CollectionUtils;

/* JADX INFO: loaded from: classes.dex */
final class RemoteContentCaptureService extends AbstractMultiplePendingRequestsRemoteService<RemoteContentCaptureService, IContentCaptureService> {
    private final int mIdleUnbindTimeoutMs;
    private final ContentCapturePerUserService mPerUserService;
    private final IBinder mServerCallback;

    public interface ContentCaptureServiceCallbacks extends AbstractRemoteService.VultureCallback<RemoteContentCaptureService> {
    }

    public static /* synthetic */ void $r8$lambda$KFQ8UODdQHxawz_tsVA735zNO34(int r0, SnapshotData r1, IContentCaptureService r2) {
        lambda$onActivitySnapshotRequest$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$cwxES5lLhvicrdrlEMnWnw61pZQ(ActivityEvent r0, IContentCaptureService r1) {
        lambda$onActivityLifecycleEvent$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$gIoNMlfyq0hOI7oj_UYmo2cG5JY(int r0, IContentCaptureService r1) {
        lambda$onSessionFinished$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$lcua0-OIyolP_kt7AOCHBSHhfWU, reason: not valid java name */
    public static /* synthetic */ void m3228$r8$lambda$lcua0OIyolP_kt7AOCHBSHhfWU(ContentCaptureContext r0, int r1, int r2, IResultReceiver r3, int r4, IContentCaptureService r5) {
        lambda$onSessionStarted$0(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$rsrZ5-uRNpCWTgoNnk-xmToy-IU, reason: not valid java name */
    public static /* synthetic */ void m3229$r8$lambda$rsrZ5uRNpCWTgoNnkxmToyIU(DataRemovalRequest r0, IContentCaptureService r1) {
        lambda$onDataRemovalRequest$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$suDnAP9zNCf2_DFQ0p1PWhB5Lkc(DataShareRequest r0, IDataShareCallback.Stub r1, IContentCaptureService r2) {
        lambda$onDataShareRequest$4(r0, r1, r2);
    }

    protected /* bridge */ /* synthetic */ IInterface getServiceInterface(IBinder r1) {
        return m3230getServiceInterface(r1);
    }

    RemoteContentCaptureService(Context context, String serviceInterface, ComponentName serviceComponentName, IContentCaptureServiceCallback callback, int userId, ContentCapturePerUserService perUserService, boolean bindInstantServiceAllowed, boolean verbose, int idleUnbindTimeoutMs) {
        Handler r6 = context.getMainThreadHandler();
        if (bindInstantServiceAllowed == false) goto L5;
        int r0 = 4194304;
    L6:
        super(context, serviceInterface, serviceComponentName, userId, perUserService, r6, r0 | 4096, verbose, 2);
        this.mPerUserService = perUserService;
        this.mServerCallback = callback.asBinder();
        this.mIdleUnbindTimeoutMs = idleUnbindTimeoutMs;
        ensureBoundLocked();
        return;
    L5:
        r0 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: getServiceInterface, reason: collision with other method in class */
    protected IContentCaptureService m3230getServiceInterface(IBinder service) {
        return IContentCaptureService.Stub.asInterface(service);
    }

    protected long getTimeoutIdleBindMillis() {
        return this.mIdleUnbindTimeoutMs;
    }

    protected void handleOnConnectedStateChanged(boolean connected) {
        if (connected == false) goto L19;
        if (getTimeoutIdleBindMillis() == 0) goto L19;
        scheduleUnbind();
    L19:
        if (connected == true) goto L20;
        ((AbstractMultiplePendingRequestsRemoteService) this).mService.onDisconnected();     // Catch: Exception -> L10
        ContentCaptureMetricsLogger.writeServiceEvent(2, ((AbstractMultiplePendingRequestsRemoteService) this).mComponentName);     // Catch: Exception -> L10
        EventLog.writeEvent(EventLogTags.CC_CONNECT_STATE_CHANGED, new Object[]{Integer.valueOf(this.mPerUserService.getUserId()), 2, 0});     // Catch: Exception -> L10
        return;
    L20:
        ((AbstractMultiplePendingRequestsRemoteService) this).mService.onConnected(this.mServerCallback, ContentCaptureHelper.sVerbose, ContentCaptureHelper.sDebug);     // Catch: Throwable -> L12
        ContentCaptureMetricsLogger.writeServiceEvent(1, ((AbstractMultiplePendingRequestsRemoteService) this).mComponentName);     // Catch: Throwable -> L12
        EventLog.writeEvent(EventLogTags.CC_CONNECT_STATE_CHANGED, new Object[]{Integer.valueOf(this.mPerUserService.getUserId()), 1, Integer.valueOf(CollectionUtils.size(this.mPerUserService.getContentCaptureAllowlist()))});     // Catch: Throwable -> L12
        this.mPerUserService.onConnected();     // Catch: Exception -> L10
        return;
    L12:
        th = move-exception;
        this.mPerUserService.onConnected();     // Catch: Exception -> L10
        throw th;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Slog.w(((AbstractMultiplePendingRequestsRemoteService) this).mTag, "Exception calling onConnectedStateChanged(" + connected + "): " + e);
    }

    public void ensureBoundLocked() {
        scheduleBind();
    }

    public void onSessionStarted(final ContentCaptureContext context, final int sessionId, final int uid, final IResultReceiver clientReceiver, final int initialState) {
        scheduleAsyncRequest(new RemoteContentCaptureService$$ExternalSyntheticLambda1(context, sessionId, uid, clientReceiver, initialState));
        ContentCaptureMetricsLogger.writeSessionEvent(sessionId, 1, initialState, getComponentName(), false);
    }

    private static /* synthetic */ void lambda$onSessionStarted$0(ContentCaptureContext context, int sessionId, int uid, IResultReceiver clientReceiver, int initialState, IContentCaptureService s) throws RemoteException {
        s.onSessionStarted(context, sessionId, uid, clientReceiver, initialState);
    }

    private static /* synthetic */ void lambda$onSessionFinished$1(int sessionId, IContentCaptureService s) throws RemoteException {
        s.onSessionFinished(sessionId);
    }

    public void onSessionFinished(final int sessionId) {
        scheduleAsyncRequest(new RemoteContentCaptureService$$ExternalSyntheticLambda0(sessionId));
        ContentCaptureMetricsLogger.writeSessionEvent(sessionId, 2, 0, getComponentName(), false);
    }

    private static /* synthetic */ void lambda$onActivitySnapshotRequest$2(int sessionId, SnapshotData snapshotData, IContentCaptureService s) throws RemoteException {
        s.onActivitySnapshot(sessionId, snapshotData);
    }

    public void onActivitySnapshotRequest(final int sessionId, final SnapshotData snapshotData) {
        scheduleAsyncRequest(new RemoteContentCaptureService$$ExternalSyntheticLambda4(sessionId, snapshotData));
    }

    private static /* synthetic */ void lambda$onDataRemovalRequest$3(DataRemovalRequest request, IContentCaptureService s) throws RemoteException {
        s.onDataRemovalRequest(request);
    }

    public void onDataRemovalRequest(final DataRemovalRequest request) {
        scheduleAsyncRequest(new RemoteContentCaptureService$$ExternalSyntheticLambda5(request));
        ContentCaptureMetricsLogger.writeServiceEvent(5, ((AbstractMultiplePendingRequestsRemoteService) this).mComponentName);
    }

    private static /* synthetic */ void lambda$onDataShareRequest$4(DataShareRequest request, IDataShareCallback.Stub dataShareCallback, IContentCaptureService s) throws RemoteException {
        s.onDataShared(request, dataShareCallback);
    }

    public void onDataShareRequest(final DataShareRequest request, final IDataShareCallback.Stub dataShareCallback) {
        scheduleAsyncRequest(new RemoteContentCaptureService$$ExternalSyntheticLambda3(request, dataShareCallback));
        ContentCaptureMetricsLogger.writeServiceEvent(6, ((AbstractMultiplePendingRequestsRemoteService) this).mComponentName);
    }

    private static /* synthetic */ void lambda$onActivityLifecycleEvent$5(ActivityEvent event, IContentCaptureService s) throws RemoteException {
        s.onActivityEvent(event);
    }

    public void onActivityLifecycleEvent(final ActivityEvent event) {
        scheduleAsyncRequest(new RemoteContentCaptureService$$ExternalSyntheticLambda2(event));
    }
}
