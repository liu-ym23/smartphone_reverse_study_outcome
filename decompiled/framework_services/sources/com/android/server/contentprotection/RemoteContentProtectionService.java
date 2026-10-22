package com.android.server.contentprotection;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ParceledListSlice;
import android.os.IInterface;
import android.service.contentcapture.IContentProtectionAllowlistCallback;
import android.service.contentcapture.IContentProtectionService;
import android.util.Slog;
import android.view.contentcapture.ContentCaptureEvent;
import com.android.internal.infra.ServiceConnector;

/* JADX INFO: loaded from: classes.dex */
public class RemoteContentProtectionService extends ServiceConnector.Impl<IContentProtectionService> {
    private static final String TAG = null;
    private final long mAutoDisconnectTimeoutMs;
    private final ComponentName mComponentName;

    public static /* synthetic */ void $r8$lambda$4pJFpBHXwZcyXLAFde7jBJeRrJg(IContentProtectionAllowlistCallback r0, IContentProtectionService r1) {
        lambda$onUpdateAllowlistRequest$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$T0-cgXoXI5IFkEYd-ja6ndBR-5Y, reason: not valid java name */
    public static /* synthetic */ void m3237$r8$lambda$T0cgXoXI5IFkEYdja6ndBR5Y(ParceledListSlice r0, IContentProtectionService r1) {
        lambda$onLoginDetected$0(r0, r1);
    }

    protected /* bridge */ /* synthetic */ void onServiceConnectionStatusChanged(IInterface r1, boolean r2) {
        onServiceConnectionStatusChanged((IContentProtectionService) r1, r2);
    }

    static {
        TAG = RemoteContentProtectionService.class.getSimpleName();
    }

    public RemoteContentProtectionService(Context context, ComponentName componentName, int userId, boolean bindAllowInstant, long autoDisconnectTimeoutMs) {
        Intent r4 = new Intent("android.service.contentcapture.ContentProtectionService").setComponent(componentName);
        if (bindAllowInstant == false) goto L6;
        int r0 = 4194304;
    L5:
        int r5 = r0;
        super(context, r4, r5, userId, new RemoteContentProtectionService$$ExternalSyntheticLambda0());
        this.mComponentName = componentName;
        this.mAutoDisconnectTimeoutMs = autoDisconnectTimeoutMs;
        return;
    L6:
        r0 = 0;
        goto L5
    }

    protected long getAutoDisconnectTimeoutMs() {
        return this.mAutoDisconnectTimeoutMs;
    }

    protected void onServiceConnectionStatusChanged(IContentProtectionService service, boolean isConnected) {
        String r0 = TAG;
        StringBuilder r1 = new StringBuilder();
        r1.append("Connection status for: ");
        r1.append(this.mComponentName);
        r1.append(" changed to: ");
        if (isConnected == false) goto L5;
        String r2 = "connected";
    L6:
        r1.append(r2);
        Slog.i(r0, r1.toString());
        return;
    L5:
        r2 = "disconnected";
        goto L6
    }

    private static /* synthetic */ void lambda$onLoginDetected$0(ParceledListSlice events, IContentProtectionService service) throws Exception {
        service.onLoginDetected(events);
    }

    public void onLoginDetected(final ParceledListSlice<ContentCaptureEvent> events) {
        run(new RemoteContentProtectionService$$ExternalSyntheticLambda2(events));
    }

    private static /* synthetic */ void lambda$onUpdateAllowlistRequest$1(IContentProtectionAllowlistCallback callback, IContentProtectionService service) throws Exception {
        service.onUpdateAllowlistRequest(callback.asBinder());
    }

    public void onUpdateAllowlistRequest(final IContentProtectionAllowlistCallback callback) {
        run(new RemoteContentProtectionService$$ExternalSyntheticLambda1(callback));
    }
}
