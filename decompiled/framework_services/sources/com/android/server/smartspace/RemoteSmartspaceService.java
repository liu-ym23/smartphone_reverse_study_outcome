package com.android.server.smartspace;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.service.smartspace.ISmartspaceService;
import com.android.internal.infra.AbstractMultiplePendingRequestsRemoteService;
import com.android.internal.infra.AbstractRemoteService;

/* JADX INFO: loaded from: classes3.dex */
public class RemoteSmartspaceService extends AbstractMultiplePendingRequestsRemoteService<RemoteSmartspaceService, ISmartspaceService> {
    private static final String TAG = "RemoteSmartspaceService";
    private static final long TIMEOUT_REMOTE_REQUEST_MILLIS = 2000;
    private final RemoteSmartspaceServiceCallbacks mCallback;

    public interface RemoteSmartspaceServiceCallbacks extends AbstractRemoteService.VultureCallback<RemoteSmartspaceService> {
        void onConnectedStateChanged(boolean r1);

        void onFailureOrTimeout(boolean r1);
    }

    protected /* bridge */ /* synthetic */ IInterface getServiceInterface(IBinder r1) {
        return m8168getServiceInterface(r1);
    }

    public RemoteSmartspaceService(Context context, String serviceInterface, ComponentName componentName, int userId, RemoteSmartspaceServiceCallbacks callback, boolean bindInstantServiceAllowed, boolean verbose) {
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
    protected ISmartspaceService m8168getServiceInterface(IBinder service) {
        return ISmartspaceService.Stub.asInterface(service);
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

    public void scheduleOnResolvedService(AbstractRemoteService.AsyncRequest<ISmartspaceService> request) {
        scheduleAsyncRequest(request);
    }

    public void executeOnResolvedService(AbstractRemoteService.AsyncRequest<ISmartspaceService> request) {
        executeAsyncRequest(request);
    }

    protected void handleOnConnectedStateChanged(boolean connected) {
        if (this.mCallback == null) goto L6;
        this.mCallback.onConnectedStateChanged(connected);
        return;
    }
}
