package com.android.server.permission.access.permission;

import android.os.Build;
import com.android.server.permission.PermissionManagerLocal;
import com.android.server.permission.access.AccessCheckingService;
import com.android.server.permission.access.SchemePolicy;
import com.android.server.permission.jarjar.kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionManagerLocalImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionManagerLocalImpl implements PermissionManagerLocal {
    private final AppIdPermissionPolicy policy;
    private final AccessCheckingService service;

    public PermissionManagerLocalImpl(AccessCheckingService service) {
        this.service = service;
        SchemePolicy r0 = this.service.getSchemePolicy$frameworks__base__services__permission__android_common__services_permission_pre_jarjar("uid", "permission");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.android.server.permission.access.permission.AppIdPermissionPolicy");
        this.policy = (AppIdPermissionPolicy) r0;
    }

    @Override // com.android.server.permission.PermissionManagerLocal
    public boolean isSignaturePermissionAllowlistForceEnforced() {
        if (Build.isDebuggable() == false) goto L7;
        return this.policy.isSignaturePermissionAllowlistForceEnforced();
    L7:
        throw new IllegalStateException("Check failed.");
    }

    @Override // com.android.server.permission.PermissionManagerLocal
    public void setSignaturePermissionAllowlistForceEnforced(boolean forceEnforced) {
        if (Build.isDebuggable() == false) goto L7;
        this.policy.setSignaturePermissionAllowlistForceEnforced(forceEnforced);
        return;
    L7:
        throw new IllegalStateException("Check failed.");
    }
}
