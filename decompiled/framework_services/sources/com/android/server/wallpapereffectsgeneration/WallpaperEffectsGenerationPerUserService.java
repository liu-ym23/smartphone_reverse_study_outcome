package com.android.server.wallpapereffectsgeneration;

import android.app.AppGlobals;
import android.app.wallpapereffectsgeneration.CinematicEffectRequest;
import android.app.wallpapereffectsgeneration.CinematicEffectResponse;
import android.app.wallpapereffectsgeneration.ICinematicEffectListener;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.RemoteException;
import android.service.wallpapereffectsgeneration.IWallpaperEffectsGenerationService;
import android.util.Slog;
import com.android.server.infra.AbstractPerUserSystemService;

/* JADX INFO: loaded from: classes3.dex */
public class WallpaperEffectsGenerationPerUserService extends AbstractPerUserSystemService<WallpaperEffectsGenerationPerUserService, WallpaperEffectsGenerationManagerService> implements RemoteWallpaperEffectsGenerationService.RemoteWallpaperEffectsGenerationServiceCallback {
    private static final String TAG = null;
    private CinematicEffectListenerWrapper mCinematicEffectListenerWrapper;
    private RemoteWallpaperEffectsGenerationService mRemoteService;

    private static final class CinematicEffectListenerWrapper {
        private final ICinematicEffectListener mListener;
        private final String mTaskId;

        /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ ICinematicEffectListener m9550$$Nest$fgetmListener(CinematicEffectListenerWrapper r0) {
            return r0.mListener;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTaskId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m9551$$Nest$fgetmTaskId(CinematicEffectListenerWrapper r0) {
            return r0.mTaskId;
        }

        CinematicEffectListenerWrapper(String taskId, ICinematicEffectListener listener) {
            this.mTaskId = taskId;
            this.mListener = listener;
        }
    }

    public static /* synthetic */ void $r8$lambda$ec3SADV8WZpzTG93igQHaBaHtO8(CinematicEffectRequest r0, IWallpaperEffectsGenerationService r1) {
        lambda$onGenerateCinematicEffectLocked$0(r0, r1);
    }

    public /* bridge */ /* synthetic */ void onServiceDied(Object r1) {
        onServiceDied((RemoteWallpaperEffectsGenerationService) r1);
    }

    static {
        TAG = WallpaperEffectsGenerationPerUserService.class.getSimpleName();
    }

    protected WallpaperEffectsGenerationPerUserService(WallpaperEffectsGenerationManagerService master, Object lock, int userId) {
        super(master, lock, userId);
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected ServiceInfo newServiceInfoLocked(ComponentName serviceComponent) throws PackageManager.NameNotFoundException {
        ServiceInfo si = AppGlobals.getPackageManager().getServiceInfo(serviceComponent, 128, this.mUserId);     // Catch: RemoteException -> L8
        if ("android.permission.BIND_WALLPAPER_EFFECTS_GENERATION_SERVICE".equals(si.permission) == false) goto L6;
        return si;
    L6:
        Slog.w(TAG, "WallpaperEffectsGenerationService from '" + si.packageName + "' does not require permission android.permission.BIND_WALLPAPER_EFFECTS_GENERATION_SERVICE");
        throw new SecurityException("Service does not require permission android.permission.BIND_WALLPAPER_EFFECTS_GENERATION_SERVICE");
    L10:
        throw new PackageManager.NameNotFoundException("Could not get service for " + serviceComponent);
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected boolean updateLocked(boolean disabled) {
        boolean enabledChanged = super.updateLocked(disabled);
        updateRemoteServiceLocked();
        return enabledChanged;
    }

    public void onGenerateCinematicEffectLocked(final CinematicEffectRequest cinematicEffectRequest, ICinematicEffectListener cinematicEffectListener) {
        String newTaskId = cinematicEffectRequest.getTaskId();
        if (this.mCinematicEffectListenerWrapper != null) goto L5;
        RemoteWallpaperEffectsGenerationService remoteService = ensureRemoteServiceLocked();
        if (remoteService == null) goto L19;
        remoteService.executeOnResolvedService(new WallpaperEffectsGenerationPerUserService$$ExternalSyntheticLambda0(cinematicEffectRequest));
        this.mCinematicEffectListenerWrapper = new CinematicEffectListenerWrapper(newTaskId, cinematicEffectListener);
        return;
    L19:
        if (isDebug() == false) goto L29;
        Slog.d(TAG, "Remote service not found");
    L29:
        cinematicEffectListener.onCinematicEffectGenerated(createErrorCinematicEffectResponse(newTaskId));     // Catch: RemoteException -> L24
        return;
    L26:
        if (isDebug() == false) goto L35;
        Slog.d(TAG, "Failed to invoke cinematic effect listener for task [" + newTaskId + "]");
        return;
    L35:
        return;
    L5:
        if (CinematicEffectListenerWrapper.m9551$$Nest$fgetmTaskId(this.mCinematicEffectListenerWrapper).equals(newTaskId) == false) goto L7;
        CinematicEffectResponse cinematicEffectResponse = new CinematicEffectResponse.Builder(3, newTaskId).build();
    L31:
        cinematicEffectListener.onCinematicEffectGenerated(cinematicEffectResponse);     // Catch: RemoteException -> L10
        return;
    L12:
        if (isDebug() == false) goto L33;
        Slog.w(TAG, "RemoteException invoking cinematic effect listener for task[" + CinematicEffectListenerWrapper.m9551$$Nest$fgetmTaskId(this.mCinematicEffectListenerWrapper) + "]");
        return;
    L33:
        return;
    L7:
        cinematicEffectResponse = new CinematicEffectResponse.Builder(4, newTaskId).build();
        goto L31
    }

    private static /* synthetic */ void lambda$onGenerateCinematicEffectLocked$0(CinematicEffectRequest cinematicEffectRequest, IWallpaperEffectsGenerationService s) throws RemoteException {
        s.onGenerateCinematicEffect(cinematicEffectRequest);
    }

    public void onReturnCinematicEffectResponseLocked(CinematicEffectResponse cinematicEffectResponse) {
        invokeCinematicListenerAndCleanup(cinematicEffectResponse);
    }

    public boolean isCallingUidAllowed(int callingUid) {
        if (getServiceUidLocked() != callingUid) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateRemoteServiceLocked() {
        if (this.mRemoteService == null) goto L6;
        this.mRemoteService.destroy();
        this.mRemoteService = null;
    L6:
        if (this.mCinematicEffectListenerWrapper == null) goto L9;
        invokeCinematicListenerAndCleanup(createErrorCinematicEffectResponse(CinematicEffectListenerWrapper.m9551$$Nest$fgetmTaskId(this.mCinematicEffectListenerWrapper)));
        return;
    }

    void onPackageUpdatedLocked() {
        if (isDebug() == false) goto L5;
        Slog.v(TAG, "onPackageUpdatedLocked()");
    L5:
        destroyAndRebindRemoteService();
    }

    void onPackageRestartedLocked() {
        if (isDebug() == false) goto L5;
        Slog.v(TAG, "onPackageRestartedLocked()");
    L5:
        destroyAndRebindRemoteService();
    }

    private void destroyAndRebindRemoteService() {
        if (this.mRemoteService != null) goto L6;
        return;
    L6:
        if (isDebug() == false) goto L8;
        Slog.d(TAG, "Destroying the old remote service.");
    L8:
        this.mRemoteService.destroy();
        this.mRemoteService = null;
        this.mRemoteService = ensureRemoteServiceLocked();
        if (this.mRemoteService == null) goto L15;
        if (isDebug() == false) goto L13;
        Slog.d(TAG, "Rebinding to the new remote service.");
    L13:
        this.mRemoteService.reconnect();
    L15:
        if (this.mCinematicEffectListenerWrapper == null) goto L18;
        invokeCinematicListenerAndCleanup(createErrorCinematicEffectResponse(CinematicEffectListenerWrapper.m9551$$Nest$fgetmTaskId(this.mCinematicEffectListenerWrapper)));
        return;
    }

    private CinematicEffectResponse createErrorCinematicEffectResponse(String taskId) {
        return new CinematicEffectResponse.Builder(0, taskId).build();
    }

    private void invokeCinematicListenerAndCleanup(CinematicEffectResponse cinematicEffectResponse) {
    L8:
        th = move-exception;
        this.mCinematicEffectListenerWrapper = null;
        throw th;
    L4:
        if (this.mCinematicEffectListenerWrapper == null) goto L13;
        if (CinematicEffectListenerWrapper.m9550$$Nest$fgetmListener(this.mCinematicEffectListenerWrapper) == null) goto L13;
        CinematicEffectListenerWrapper.m9550$$Nest$fgetmListener(this.mCinematicEffectListenerWrapper).onCinematicEffectGenerated(cinematicEffectResponse);     // Catch: Throwable -> L8 RemoteException -> L10
    L26:
    L15:
        this.mCinematicEffectListenerWrapper = null;
        return;
    L13:
        if (isDebug() == false) goto L26;
        Slog.w(TAG, "Cinematic effect listener not found for task[" + CinematicEffectListenerWrapper.m9551$$Nest$fgetmTaskId(this.mCinematicEffectListenerWrapper) + "]");     // Catch: Throwable -> L8 RemoteException -> L10
    L18:
        if (isDebug() == false) goto L15;
        Slog.w(TAG, "Error invoking cinematic effect listener for task[" + CinematicEffectListenerWrapper.m9551$$Nest$fgetmTaskId(this.mCinematicEffectListenerWrapper) + "]");     // Catch: Throwable -> L8
        goto L15
    }

    private RemoteWallpaperEffectsGenerationService ensureRemoteServiceLocked() {
        if (this.mRemoteService != null) goto L12;
        ComponentName serviceComponent = updateServiceInfoLocked();
        if (serviceComponent == null) goto L7;
        WallpaperEffectsGenerationPerUserService r5 = this;
        r5.mRemoteService = new RemoteWallpaperEffectsGenerationService(getContext(), serviceComponent, this.mUserId, r5, ((WallpaperEffectsGenerationManagerService) this.mMaster).isBindInstantServiceAllowed(), ((WallpaperEffectsGenerationManagerService) this.mMaster).verbose);
    L14:
        return r5.mRemoteService;
    L7:
        if (((WallpaperEffectsGenerationManagerService) this.mMaster).verbose == false) goto L15;
        Slog.v(TAG, "ensureRemoteServiceLocked(): not set");
        return null;
    L15:
        return null;
    L12:
        r5 = this;
        goto L14
    }

    public void onServiceDied(RemoteWallpaperEffectsGenerationService service) {
        Slog.w(TAG, "remote wallpaper effects generation service died");
        updateRemoteServiceLocked();
    }

    @Override // com.android.server.wallpapereffectsgeneration.RemoteWallpaperEffectsGenerationService.RemoteWallpaperEffectsGenerationServiceCallback
    public void onConnectedStateChanged(boolean connected) {
        if (connected == true) goto L5;
        Slog.w(TAG, "remote wallpaper effects generation service disconnected");
        updateRemoteServiceLocked();
        return;
    }
}
