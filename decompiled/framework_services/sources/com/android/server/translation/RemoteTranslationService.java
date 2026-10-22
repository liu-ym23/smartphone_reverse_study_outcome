package com.android.server.translation;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.ResultReceiver;
import android.service.translation.ITranslationService;
import android.util.Slog;
import android.view.translation.TranslationContext;
import com.android.internal.infra.ServiceConnector;
import com.android.internal.os.IResultReceiver;

/* JADX INFO: loaded from: classes3.dex */
final class RemoteTranslationService extends ServiceConnector.Impl<ITranslationService> {
    private static final String TAG = null;
    private static final long TIMEOUT_IDLE_UNBIND_MS = 0;
    private static final int TIMEOUT_REQUEST_MS = 5000;
    private final ComponentName mComponentName;
    private final long mIdleUnbindTimeoutMs;
    private final IBinder mRemoteCallback;
    private final int mRequestTimeoutMs;

    public static /* synthetic */ void $r8$lambda$f662Wsp3V9LljanqJLsUCpRaz3A(int r0, int r1, ResultReceiver r2, ITranslationService r3) {
        lambda$onTranslationCapabilitiesRequest$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$qqZ6Lw_Qwb70hbIAD99d3CNYrq4(TranslationContext r0, int r1, IResultReceiver r2, ITranslationService r3) {
        lambda$onSessionCreated$0(r0, r1, r2, r3);
    }

    protected /* bridge */ /* synthetic */ void onServiceConnectionStatusChanged(IInterface r1, boolean r2) {
        onServiceConnectionStatusChanged((ITranslationService) r1, r2);
    }

    static {
        TAG = RemoteTranslationService.class.getSimpleName();
    }

    RemoteTranslationService(Context context, ComponentName serviceName, int userId, boolean bindInstantServiceAllowed, IBinder callback) {
        Intent r4 = new Intent("android.service.translation.TranslationService").setComponent(serviceName);
        if (bindInstantServiceAllowed == false) goto L6;
        int r0 = 4194304;
    L5:
        int r5 = r0;
        super(context, r4, r5, userId, new RemoteTranslationService$$ExternalSyntheticLambda0());
        this.mIdleUnbindTimeoutMs = 0;
        this.mRequestTimeoutMs = 5000;
        this.mComponentName = serviceName;
        this.mRemoteCallback = callback;
        connect();
        return;
    L6:
        r0 = 0;
        goto L5
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    protected void onServiceConnectionStatusChanged(ITranslationService service, boolean connected) {
        if (connected == false) goto L6;
        service.onConnected(this.mRemoteCallback);     // Catch: Exception -> L4
    L10:
        return;
    L6:
        service.onDisconnected();     // Catch: Exception -> L4
    L4:
        e = move-exception;
        Slog.w(TAG, "Exception calling onServiceConnectionStatusChanged(" + connected + "): ", e);
    }

    protected long getAutoDisconnectTimeoutMs() {
        return this.mIdleUnbindTimeoutMs;
    }

    private static /* synthetic */ void lambda$onSessionCreated$0(TranslationContext translationContext, int sessionId, IResultReceiver resultReceiver, ITranslationService s) throws Exception {
        s.onCreateTranslationSession(translationContext, sessionId, resultReceiver);
    }

    public void onSessionCreated(final TranslationContext translationContext, final int sessionId, final IResultReceiver resultReceiver) {
        run(new RemoteTranslationService$$ExternalSyntheticLambda1(translationContext, sessionId, resultReceiver));
    }

    private static /* synthetic */ void lambda$onTranslationCapabilitiesRequest$1(int sourceFormat, int targetFormat, ResultReceiver resultReceiver, ITranslationService s) throws Exception {
        s.onTranslationCapabilitiesRequest(sourceFormat, targetFormat, resultReceiver);
    }

    public void onTranslationCapabilitiesRequest(final int sourceFormat, final int targetFormat, final ResultReceiver resultReceiver) {
        run(new RemoteTranslationService$$ExternalSyntheticLambda2(sourceFormat, targetFormat, resultReceiver));
    }
}
