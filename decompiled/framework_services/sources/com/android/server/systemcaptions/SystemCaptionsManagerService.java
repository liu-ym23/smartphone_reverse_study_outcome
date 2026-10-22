package com.android.server.systemcaptions;

import android.R;
import android.content.Context;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.infra.FrameworkResourcesServiceNameResolver;

/* JADX INFO: loaded from: classes3.dex */
public final class SystemCaptionsManagerService extends AbstractMasterSystemService<SystemCaptionsManagerService, SystemCaptionsManagerPerUserService> {
    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ void onServiceRemoved(AbstractPerUserSystemService r1, int r2) {
        onServiceRemoved((SystemCaptionsManagerPerUserService) r1, r2);
    }

    public SystemCaptionsManagerService(Context context) {
        super(context, new FrameworkResourcesServiceNameResolver(context, R.string.config_help_url_action_disabled_by_advanced_protection), null, 68);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected SystemCaptionsManagerPerUserService newServiceLocked(int resolvedUserId, boolean disabled) {
        SystemCaptionsManagerPerUserService perUserService = new SystemCaptionsManagerPerUserService(this, this.mLock, disabled, resolvedUserId);
        perUserService.initializeLocked();
        return perUserService;
    }

    protected void onServiceRemoved(SystemCaptionsManagerPerUserService service, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        service.destroyLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
