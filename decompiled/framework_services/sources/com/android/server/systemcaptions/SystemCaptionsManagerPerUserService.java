package com.android.server.systemcaptions;

import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.util.Slog;
import com.android.server.infra.AbstractPerUserSystemService;

/* JADX INFO: loaded from: classes3.dex */
final class SystemCaptionsManagerPerUserService extends AbstractPerUserSystemService<SystemCaptionsManagerPerUserService, SystemCaptionsManagerService> {
    private static final String TAG = null;
    private RemoteSystemCaptionsManagerService mRemoteService;

    static {
        TAG = SystemCaptionsManagerPerUserService.class.getSimpleName();
    }

    SystemCaptionsManagerPerUserService(SystemCaptionsManagerService master, Object lock, boolean disabled, int userId) {
        super(master, lock, userId);
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected ServiceInfo newServiceInfoLocked(ComponentName serviceComponent) throws PackageManager.NameNotFoundException {
        return AppGlobals.getPackageManager().getServiceInfo(serviceComponent, 128, this.mUserId);
    L6:
        throw new PackageManager.NameNotFoundException("Could not get service for " + serviceComponent);
    }

    void initializeLocked() {
        if (((SystemCaptionsManagerService) this.mMaster).verbose == false) goto L5;
        Slog.v(TAG, "initialize()");
    L5:
        RemoteSystemCaptionsManagerService service = getRemoteServiceLocked();
        if (service == null) goto L8;
        return;
    L8:
        if (((SystemCaptionsManagerService) this.mMaster).verbose == false) goto L12;
        Slog.v(TAG, "initialize(): Failed to init remote server");
        return;
    }

    void destroyLocked() {
        if (((SystemCaptionsManagerService) this.mMaster).verbose == false) goto L6;
        Slog.v(TAG, "destroyLocked()");
    L6:
        if (this.mRemoteService == null) goto L9;
        this.mRemoteService.destroy();
        this.mRemoteService = null;
        return;
    }

    private RemoteSystemCaptionsManagerService getRemoteServiceLocked() {
        if (this.mRemoteService != null) goto L16;
        String serviceName = getComponentNameLocked();
        if (serviceName == null) goto L7;
        ComponentName serviceComponent = ComponentName.unflattenFromString(serviceName);
        this.mRemoteService = new RemoteSystemCaptionsManagerService(getContext(), serviceComponent, this.mUserId, ((SystemCaptionsManagerService) this.mMaster).verbose);
        if (((SystemCaptionsManagerService) this.mMaster).verbose == false) goto L14;
        Slog.v(TAG, "getRemoteServiceLocked(): initialize for user " + this.mUserId);
    L14:
        this.mRemoteService.initialize();
        goto L16
    L7:
        if (((SystemCaptionsManagerService) this.mMaster).verbose == false) goto L17;
        Slog.v(TAG, "getRemoteServiceLocked(): Not set");
        return null;
    L17:
        return null;
    L16:
        return this.mRemoteService;
    }
}
