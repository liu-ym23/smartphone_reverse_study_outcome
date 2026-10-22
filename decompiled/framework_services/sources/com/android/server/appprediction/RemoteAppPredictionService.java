package com.android.server.appprediction;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.service.appprediction.IPredictionService;
import com.android.internal.infra.AbstractMultiplePendingRequestsRemoteService;
import com.android.internal.infra.AbstractRemoteService;

/* JADX INFO: loaded from: classes.dex */
public class RemoteAppPredictionService extends AbstractMultiplePendingRequestsRemoteService<RemoteAppPredictionService, IPredictionService> {
    private static final String TAG = "RemoteAppPredictionService";
    private static final long TIMEOUT_REMOTE_REQUEST_MILLIS = 2000;
    private final RemoteAppPredictionServiceCallbacks mCallback;

    public interface RemoteAppPredictionServiceCallbacks extends AbstractRemoteService.VultureCallback<RemoteAppPredictionService> {
        void onConnectedStateChanged(boolean r1);

        void onFailureOrTimeout(boolean r1);
    }

    protected /* bridge */ /* synthetic */ IInterface getServiceInterface(IBinder r1) {
        return m1845getServiceInterface(r1);
    }

    public RemoteAppPredictionService(Context context, String serviceInterface, ComponentName componentName, int userId, RemoteAppPredictionServiceCallbacks callback, boolean bindInstantServiceAllowed, boolean verbose) {
        Handler r6 = context.getMainThreadHandler();
        if (bindInstantServiceAllowed == false) goto L6;
        int r0 = 4194304;
    L7:
        super(context, serviceInterface, componentName, userId, callback, r6, r0, verbose, 1);
        this.mCallback = callback;
        return;
    L6:
        r0 = 0;
        goto L7
    }

    /* JADX INFO: renamed from: getServiceInterface, reason: collision with other method in class */
    protected IPredictionService m1845getServiceInterface(IBinder service) {
        return IPredictionService.Stub.asInterface(service);
    }

    protected long getTimeoutIdleBindMillis() {
        return 0;
    }

    protected long getRemoteRequestMillis() {
        return 2000;
    }

    public void reconnect() {
        super.scheduleBind();
    }

    public void scheduleOnResolvedService(AbstractRemoteService.AsyncRequest<IPredictionService> request) {
        scheduleAsyncRequest(request);
    }

    public void executeOnResolvedService(AbstractRemoteService.AsyncRequest<IPredictionService> request) {
        executeAsyncRequest(request);
    }

    protected void handleOnConnectedStateChanged(boolean connected) {
        if (this.mCallback == null) goto L6;
        this.mCallback.onConnectedStateChanged(connected);
        return;
    }
}
