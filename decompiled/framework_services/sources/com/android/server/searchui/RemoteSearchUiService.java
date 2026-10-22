package com.android.server.searchui;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.service.search.ISearchUiService;
import com.android.internal.infra.AbstractMultiplePendingRequestsRemoteService;
import com.android.internal.infra.AbstractRemoteService;

/* JADX INFO: loaded from: classes3.dex */
public class RemoteSearchUiService extends AbstractMultiplePendingRequestsRemoteService<RemoteSearchUiService, ISearchUiService> {
    private static final String TAG = "RemoteSearchUiService";
    private static final long TIMEOUT_REMOTE_REQUEST_MILLIS = 2000;
    private final RemoteSearchUiServiceCallbacks mCallback;

    public interface RemoteSearchUiServiceCallbacks extends AbstractRemoteService.VultureCallback<RemoteSearchUiService> {
        void onConnectedStateChanged(boolean r1);

        void onFailureOrTimeout(boolean r1);
    }

    protected /* bridge */ /* synthetic */ IInterface getServiceInterface(IBinder r1) {
        return m8013getServiceInterface(r1);
    }

    public RemoteSearchUiService(Context context, String serviceInterface, ComponentName componentName, int userId, RemoteSearchUiServiceCallbacks callback, boolean bindInstantServiceAllowed, boolean verbose) {
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
    protected ISearchUiService m8013getServiceInterface(IBinder service) {
        return ISearchUiService.Stub.asInterface(service);
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

    public void scheduleOnResolvedService(AbstractRemoteService.AsyncRequest<ISearchUiService> request) {
        scheduleAsyncRequest(request);
    }

    public void executeOnResolvedService(AbstractRemoteService.AsyncRequest<ISearchUiService> request) {
        executeAsyncRequest(request);
    }

    protected void handleOnConnectedStateChanged(boolean connected) {
        if (this.mCallback == null) goto L6;
        this.mCallback.onConnectedStateChanged(connected);
        return;
    }
}
