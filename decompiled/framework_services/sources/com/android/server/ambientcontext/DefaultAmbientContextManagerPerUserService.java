package com.android.server.ambientcontext;

import android.R;
import android.app.ambientcontext.AmbientContextEventRequest;
import android.app.ambientcontext.IAmbientContextObserver;
import android.content.ComponentName;
import android.os.RemoteCallback;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public class DefaultAmbientContextManagerPerUserService extends AmbientContextManagerPerUserService {
    private static final String TAG = null;
    private ComponentName mComponentName;
    DefaultRemoteAmbientContextDetectionService mRemoteService;
    private final String mServiceName;
    private final AmbientContextManagerPerUserService.ServiceType mServiceType;

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    public /* bridge */ /* synthetic */ void onQueryServiceStatus(int[] r1, String r2, RemoteCallback r3) {
        super.onQueryServiceStatus(r1, r2, r3);
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    public /* bridge */ /* synthetic */ void onRegisterObserver(AmbientContextEventRequest r1, String r2, IAmbientContextObserver r3) {
        super.onRegisterObserver(r1, r2, r3);
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    public /* bridge */ /* synthetic */ void onStartConsentActivity(int[] r1, String r2) {
        super.onStartConsentActivity(r1, r2);
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    public /* bridge */ /* synthetic */ void onUnregisterObserver(String r1) {
        super.onUnregisterObserver(r1);
    }

    static {
        TAG = DefaultAmbientContextManagerPerUserService.class.getSimpleName();
    }

    DefaultAmbientContextManagerPerUserService(AmbientContextManagerService master, Object lock, int userId, AmbientContextManagerPerUserService.ServiceType serviceType, String serviceName) {
        super(master, lock, userId);
        this.mServiceType = serviceType;
        this.mServiceName = serviceName;
        this.mComponentName = ComponentName.unflattenFromString(this.mServiceName);
        Slog.d(TAG, "Created DefaultAmbientContextManagerPerUserServiceand service type: " + this.mServiceType.name() + " and service name: " + serviceName);
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    protected void ensureRemoteServiceInitiated() {
        if (this.mRemoteService != null) goto L6;
        this.mRemoteService = new DefaultRemoteAmbientContextDetectionService(getContext(), this.mComponentName, getUserId());
        return;
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    ComponentName getComponentName() {
        return this.mComponentName;
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    protected void setComponentName(ComponentName componentName) {
        this.mComponentName = componentName;
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    protected RemoteAmbientDetectionService getRemoteService() {
        return this.mRemoteService;
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    protected String getProtectedBindPermission() {
        return "android.permission.BIND_AMBIENT_CONTEXT_DETECTION_SERVICE";
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    public AmbientContextManagerPerUserService.ServiceType getServiceType() {
        return this.mServiceType;
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    protected int getAmbientContextPackageNameExtraKeyConfig() {
        return R.string.config_defaultContextualSearchLegacyEnabled;
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    protected int getAmbientContextEventArrayExtraKeyConfig() {
        return R.string.config_defaultContextualSearchKey;
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    protected int getConsentComponentConfig() {
        return R.string.config_default_dns_server;
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    protected void clearRemoteService() {
        this.mRemoteService = null;
    }
}
