package com.android.server.wallpapereffectsgeneration;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.service.wallpapereffectsgeneration.IWallpaperEffectsGenerationService;
import com.android.internal.infra.AbstractMultiplePendingRequestsRemoteService;
import com.android.internal.infra.AbstractRemoteService;

/* JADX INFO: loaded from: classes3.dex */
public class RemoteWallpaperEffectsGenerationService extends AbstractMultiplePendingRequestsRemoteService<RemoteWallpaperEffectsGenerationService, IWallpaperEffectsGenerationService> {
    private static final String TAG = null;
    private static final long TIMEOUT_IDLE_BIND_MILLIS = 120000;
    private static final long TIMEOUT_REMOTE_REQUEST_MILLIS = 2000;
    private final RemoteWallpaperEffectsGenerationServiceCallback mCallback;

    public interface RemoteWallpaperEffectsGenerationServiceCallback extends AbstractRemoteService.VultureCallback<RemoteWallpaperEffectsGenerationService> {
        void onConnectedStateChanged(boolean r1);
    }

    protected /* bridge */ /* synthetic */ IInterface getServiceInterface(IBinder r1) {
        return m9546getServiceInterface(r1);
    }

    static {
        TAG = RemoteWallpaperEffectsGenerationService.class.getSimpleName();
    }

    public RemoteWallpaperEffectsGenerationService(Context context, ComponentName componentName, int userId, RemoteWallpaperEffectsGenerationServiceCallback callback, boolean bindInstantServiceAllowed, boolean verbose) {
        Handler r6 = context.getMainThreadHandler();
        if (bindInstantServiceAllowed == false) goto L6;
        int r0 = 4194304;
    L7:
        super(context, "android.service.wallpapereffectsgeneration.WallpaperEffectsGenerationService", componentName, userId, callback, r6, r0, verbose, 1);
        this.mCallback = callback;
        return;
    L6:
        r0 = 0;
        goto L7
    }

    /* JADX INFO: renamed from: getServiceInterface, reason: collision with other method in class */
    protected IWallpaperEffectsGenerationService m9546getServiceInterface(IBinder service) {
        return IWallpaperEffectsGenerationService.Stub.asInterface(service);
    }

    protected long getTimeoutIdleBindMillis() {
        return 120000;
    }

    protected long getRemoteRequestMillis() {
        return 2000;
    }

    public void reconnect() {
        super.scheduleBind();
    }

    public void scheduleOnResolvedService(AbstractRemoteService.AsyncRequest<IWallpaperEffectsGenerationService> request) {
        scheduleAsyncRequest(request);
    }

    public void executeOnResolvedService(AbstractRemoteService.AsyncRequest<IWallpaperEffectsGenerationService> request) {
        executeAsyncRequest(request);
    }

    protected void handleOnConnectedStateChanged(boolean connected) {
        if (this.mCallback == null) goto L6;
        this.mCallback.onConnectedStateChanged(connected);
        return;
    }
}
