package com.android.server.ambientcontext;

import android.R;
import android.app.ambientcontext.AmbientContextEventRequest;
import android.app.ambientcontext.IAmbientContextObserver;
import android.content.ComponentName;
import android.os.RemoteCallback;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public class WearableAmbientContextManagerPerUserService extends AmbientContextManagerPerUserService {
    private static final String TAG = null;
    private ComponentName mComponentName;
    RemoteWearableSensingService mRemoteService;
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
        TAG = WearableAmbientContextManagerPerUserService.class.getSimpleName();
    }

    WearableAmbientContextManagerPerUserService(AmbientContextManagerService master, Object lock, int userId, AmbientContextManagerPerUserService.ServiceType serviceType, String serviceName) {
        super(master, lock, userId);
        this.mServiceType = serviceType;
        this.mServiceName = serviceName;
        this.mComponentName = ComponentName.unflattenFromString(this.mServiceName);
        Slog.d(TAG, "Created WearableAmbientContextManagerPerUserServiceand service type: " + this.mServiceType.name() + " and service name: " + serviceName);
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    protected void ensureRemoteServiceInitiated() {
        if (this.mRemoteService != null) goto L6;
        this.mRemoteService = new RemoteWearableSensingService(getContext(), this.mComponentName, getUserId());
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
        return "android.permission.BIND_WEARABLE_SENSING_SERVICE";
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    public AmbientContextManagerPerUserService.ServiceType getServiceType() {
        return this.mServiceType;
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    protected int getAmbientContextPackageNameExtraKeyConfig() {
        return R.string.date_picker_dialog_title;
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    protected int getAmbientContextEventArrayExtraKeyConfig() {
        return R.string.date_picker_decrement_year_button;
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    protected int getConsentComponentConfig() {
        return R.string.config_inputEventCompatProcessorOverrideClassName;
    }

    @Override // com.android.server.ambientcontext.AmbientContextManagerPerUserService
    protected void clearRemoteService() {
        this.mRemoteService = null;
    }
}
