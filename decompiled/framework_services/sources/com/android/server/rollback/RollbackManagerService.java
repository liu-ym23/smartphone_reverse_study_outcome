package com.android.server.rollback;

import android.content.Context;
import com.android.server.LocalServices;
import com.android.server.SystemService;

/* JADX INFO: loaded from: classes3.dex */
public final class RollbackManagerService extends SystemService {
    private RollbackManagerServiceImpl mService;

    public RollbackManagerService(Context context) {
        super(context);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.mService = new RollbackManagerServiceImpl(getContext());
        publishBinderService("rollback", this.mService);
        LocalServices.addService(RollbackManagerInternal.class, this.mService);
    }

    @Override // com.android.server.SystemService
    public void onUserUnlocking(SystemService.TargetUser user) {
        this.mService.onUnlockUser(user.getUserIdentifier());
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 1000) goto L6;
        this.mService.onBootCompleted();
        return;
    }
}
