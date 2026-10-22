package com.android.server.autofill;

import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.os.IInterface;
import android.os.SystemClock;
import android.service.assist.classification.FieldClassificationRequest;
import android.service.assist.classification.FieldClassificationResponse;
import android.service.assist.classification.IFieldClassificationService;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.infra.ServiceConnector;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class RemoteFieldClassificationService extends ServiceConnector.Impl<IFieldClassificationService> {
    private static final String TAG = null;
    private static final long TIMEOUT_IDLE_UNBIND_MS = 0;
    private final ComponentName mComponentName;

    public interface FieldClassificationServiceCallbacks {
        void logFieldClassificationEvent(long r1, FieldClassificationResponse r3, int r4);

        void onClassificationRequestFailure(int r1, CharSequence r2);

        void onClassificationRequestSuccess(FieldClassificationResponse r1);

        void onClassificationRequestTimeout(int r1);

        void onServiceDied(RemoteFieldClassificationService r1);
    }

    public static /* synthetic */ void $r8$lambda$SRGK7lE3fDCJBYUKsKeafRaSEQ0(RemoteFieldClassificationService r0, FieldClassificationRequest r1, WeakReference r2, long r3, IFieldClassificationService r5) {
        r0.lambda$onFieldClassificationRequest$0(r1, r2, r3, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mlogFieldClassificationEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2323$$Nest$mlogFieldClassificationEvent(RemoteFieldClassificationService r0, long r1, FieldClassificationServiceCallbacks r3, int r4, FieldClassificationResponse r5) {
        r0.logFieldClassificationEvent(r1, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2324$$Nest$sfgetTAG() {
        return TAG;
    }

    protected /* bridge */ /* synthetic */ void onServiceConnectionStatusChanged(IInterface r1, boolean r2) {
        onServiceConnectionStatusChanged((IFieldClassificationService) r1, r2);
    }

    static {
        TAG = "Autofill" + RemoteFieldClassificationService.class.getSimpleName();
    }

    RemoteFieldClassificationService(Context context, ComponentName serviceName, int serviceUid, int userId) {
        super(context, new Intent("android.service.assist.classification.FieldClassificationService").setComponent(serviceName), 0, userId, new RemoteFieldClassificationService$$ExternalSyntheticLambda0());
        this.mComponentName = serviceName;
        if (Helper.sDebug == false) goto L5;
        Slog.d(TAG, "About to connect to serviceName: " + serviceName);
    L5:
        connect();
    }

    static Pair<ServiceInfo, ComponentName> getComponentName(String serviceName, int userId, boolean isTemporary) {
        int flags = 128;
        if (isTemporary == true) goto L16;
        flags = 128 | 1048576;
    L16:
        ComponentName serviceComponent = ComponentName.unflattenFromString(serviceName);     // Catch: Exception -> L10
        ServiceInfo serviceInfo = AppGlobals.getPackageManager().getServiceInfo(serviceComponent, flags, userId);     // Catch: Exception -> L10
        if (serviceInfo != null) goto L13;
        Slog.e(TAG, "Bad service name for flags " + flags + ": " + serviceName);     // Catch: Exception -> L10
        return null;
    L13:
        return new Pair(serviceInfo, serviceComponent);
    L10:
        e = move-exception;
        Slog.e(TAG, "Error getting service info for '" + serviceName + "': " + e);
        return null;
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    protected void onServiceConnectionStatusChanged(IFieldClassificationService service, boolean connected) {
        if (connected == true) goto L4;
        service.onDisconnected();     // Catch: Exception -> L5
    L11:
        return;
    L4:
        service.onConnected(false, false);     // Catch: Exception -> L5
    L5:
        e = move-exception;
        Slog.w(TAG, "Exception calling onServiceConnectionStatusChanged(" + connected + "): ", e);
    }

    protected long getAutoDisconnectTimeoutMs() {
        return 0;
    }

    public void onFieldClassificationRequest(final FieldClassificationRequest request, final WeakReference<FieldClassificationServiceCallbacks> fieldClassificationServiceCallbacksWeakRef) {
        final long startTime = SystemClock.elapsedRealtime();
        if (Helper.sVerbose == false) goto L5;
        Slog.v(TAG, "onFieldClassificationRequest request:" + request);
    L5:
        run(new RemoteFieldClassificationService$$ExternalSyntheticLambda1(this, request, fieldClassificationServiceCallbacksWeakRef, startTime));
    }

    private /* synthetic */ void lambda$onFieldClassificationRequest$0(FieldClassificationRequest request, final WeakReference fieldClassificationServiceCallbacksWeakRef, final long startTime, IFieldClassificationService s) throws Exception {
        s.onFieldClassificationRequest(request, new AnonymousClass1(this, fieldClassificationServiceCallbacksWeakRef, startTime));
    }

    private void logFieldClassificationEvent(long startTime, FieldClassificationServiceCallbacks fieldClassificationServiceCallbacks, int status, FieldClassificationResponse response) {
        if (fieldClassificationServiceCallbacks != null) goto L4;
        FieldClassificationEventLogger logger = FieldClassificationEventLogger.createLogger();
        logger.startNewLogForRequest();
        logger.maybeSetLatencyMillis(SystemClock.elapsedRealtime() - startTime);
        logger.maybeSetSessionGc(true);
        logger.maybeSetRequestStatus(status);
        logger.logAndEndEvent();
        return;
    L4:
        fieldClassificationServiceCallbacks.logFieldClassificationEvent(startTime, response, status);
    }
}
