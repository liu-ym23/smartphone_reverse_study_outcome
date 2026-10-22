package com.android.server.ambientcontext;

import android.app.ambientcontext.AmbientContextEventRequest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteCallback;
import android.service.ambientcontext.IAmbientContextDetectionService;
import android.util.Slog;
import com.android.internal.infra.ServiceConnector;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
final class DefaultRemoteAmbientContextDetectionService extends ServiceConnector.Impl<IAmbientContextDetectionService> implements RemoteAmbientDetectionService {
    private static final String TAG = null;

    public static /* synthetic */ void $r8$lambda$1cEQHgctYqqlrtnlb5EewmchcAo(AmbientContextEventRequest r0, String r1, RemoteCallback r2, RemoteCallback r3, IAmbientContextDetectionService r4) {
        lambda$startDetection$0(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$GWFlsOdLOz1QwBNFc-51BY9lx3M, reason: not valid java name */
    public static /* synthetic */ void m1615$r8$lambda$GWFlsOdLOz1QwBNFc51BY9lx3M(String r0, IAmbientContextDetectionService r1) {
        lambda$stopDetection$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$VBJusTS-iYWfVTHM0GyVK5oYvWA, reason: not valid java name */
    public static /* synthetic */ void m1616$r8$lambda$VBJusTSiYWfVTHM0GyVK5oYvWA(int[] r0, String r1, RemoteCallback r2, IAmbientContextDetectionService r3) {
        lambda$queryServiceStatus$2(r0, r1, r2, r3);
    }

    static {
        TAG = DefaultRemoteAmbientContextDetectionService.class.getSimpleName();
    }

    DefaultRemoteAmbientContextDetectionService(Context context, ComponentName serviceName, int userId) {
        super(context, new Intent("android.service.ambientcontext.AmbientContextDetectionService").setComponent(serviceName), 67112960, userId, new DefaultRemoteAmbientContextDetectionService$$ExternalSyntheticLambda0());
        connect();
    }

    protected long getAutoDisconnectTimeoutMs() {
        return -1;
    }

    @Override // com.android.server.ambientcontext.RemoteAmbientDetectionService
    public void startDetection(final AmbientContextEventRequest request, final String packageName, final RemoteCallback detectionResultCallback, final RemoteCallback statusCallback) {
        Slog.i(TAG, "Start detection for " + request.getEventTypes());
        post(new DefaultRemoteAmbientContextDetectionService$$ExternalSyntheticLambda1(request, packageName, detectionResultCallback, statusCallback));
    }

    private static /* synthetic */ void lambda$startDetection$0(AmbientContextEventRequest request, String packageName, RemoteCallback detectionResultCallback, RemoteCallback statusCallback, IAmbientContextDetectionService service) throws Exception {
        service.startDetection(request, packageName, detectionResultCallback, statusCallback);
    }

    @Override // com.android.server.ambientcontext.RemoteAmbientDetectionService
    public void stopDetection(final String packageName) {
        Slog.i(TAG, "Stop detection for " + packageName);
        post(new DefaultRemoteAmbientContextDetectionService$$ExternalSyntheticLambda2(packageName));
    }

    private static /* synthetic */ void lambda$stopDetection$1(String packageName, IAmbientContextDetectionService service) throws Exception {
        service.stopDetection(packageName);
    }

    @Override // com.android.server.ambientcontext.RemoteAmbientDetectionService
    public void queryServiceStatus(final int[] eventTypes, final String packageName, final RemoteCallback callback) {
        Slog.i(TAG, "Query status for " + packageName);
        post(new DefaultRemoteAmbientContextDetectionService$$ExternalSyntheticLambda3(eventTypes, packageName, callback));
    }

    private static /* synthetic */ void lambda$queryServiceStatus$2(int[] eventTypes, String packageName, RemoteCallback callback, IAmbientContextDetectionService service) throws Exception {
        service.queryServiceStatus(eventTypes, packageName, callback);
    }

    @Override // com.android.server.ambientcontext.RemoteAmbientDetectionService
    public void dump(String prefix, PrintWriter pw) {
        super.dump(prefix, pw);
    }

    @Override // com.android.server.ambientcontext.RemoteAmbientDetectionService
    public void unbind() {
        super.unbind();
    }
}
