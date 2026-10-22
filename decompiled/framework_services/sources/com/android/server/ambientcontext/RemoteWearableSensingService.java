package com.android.server.ambientcontext;

import android.app.ambientcontext.AmbientContextEventRequest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteCallback;
import android.service.wearable.IWearableSensingService;
import android.util.Slog;
import com.android.internal.infra.ServiceConnector;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
final class RemoteWearableSensingService extends ServiceConnector.Impl<IWearableSensingService> implements RemoteAmbientDetectionService {
    private static final String TAG = null;

    /* JADX INFO: renamed from: $r8$lambda$78viJEdbMZeaa9x-f8VV5ivADiE, reason: not valid java name */
    public static /* synthetic */ void m1617$r8$lambda$78viJEdbMZeaa9xf8VV5ivADiE(String r0, IWearableSensingService r1) {
        lambda$stopDetection$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$7lWrVbrBTcvtbPYMtHP0pAsqK0I(AmbientContextEventRequest r0, String r1, RemoteCallback r2, RemoteCallback r3, IWearableSensingService r4) {
        lambda$startDetection$0(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$OaVy2yFZ9Nf_FCHOj04qm1h8d9g(int[] r0, String r1, RemoteCallback r2, IWearableSensingService r3) {
        lambda$queryServiceStatus$2(r0, r1, r2, r3);
    }

    static {
        TAG = RemoteWearableSensingService.class.getSimpleName();
    }

    RemoteWearableSensingService(Context context, ComponentName serviceName, int userId) {
        super(context, new Intent("android.service.wearable.WearableSensingService").setComponent(serviceName), 67112960, userId, new RemoteWearableSensingService$$ExternalSyntheticLambda1());
        connect();
    }

    protected long getAutoDisconnectTimeoutMs() {
        return -1;
    }

    @Override // com.android.server.ambientcontext.RemoteAmbientDetectionService
    public void startDetection(final AmbientContextEventRequest request, final String packageName, final RemoteCallback detectionResultCallback, final RemoteCallback statusCallback) {
        Slog.i(TAG, "Start detection for " + request.getEventTypes());
        post(new RemoteWearableSensingService$$ExternalSyntheticLambda0(request, packageName, detectionResultCallback, statusCallback));
    }

    private static /* synthetic */ void lambda$startDetection$0(AmbientContextEventRequest request, String packageName, RemoteCallback detectionResultCallback, RemoteCallback statusCallback, IWearableSensingService service) throws Exception {
        service.startDetection(request, packageName, detectionResultCallback, statusCallback);
    }

    @Override // com.android.server.ambientcontext.RemoteAmbientDetectionService
    public void stopDetection(final String packageName) {
        Slog.i(TAG, "Stop detection for " + packageName);
        post(new RemoteWearableSensingService$$ExternalSyntheticLambda3(packageName));
    }

    private static /* synthetic */ void lambda$stopDetection$1(String packageName, IWearableSensingService service) throws Exception {
        service.stopDetection(packageName);
    }

    @Override // com.android.server.ambientcontext.RemoteAmbientDetectionService
    public void queryServiceStatus(final int[] eventTypes, final String packageName, final RemoteCallback callback) {
        Slog.i(TAG, "Query status for " + packageName);
        post(new RemoteWearableSensingService$$ExternalSyntheticLambda2(eventTypes, packageName, callback));
    }

    private static /* synthetic */ void lambda$queryServiceStatus$2(int[] eventTypes, String packageName, RemoteCallback callback, IWearableSensingService service) throws Exception {
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
