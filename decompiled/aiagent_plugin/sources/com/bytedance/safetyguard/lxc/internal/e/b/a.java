package com.bytedance.safetyguard.lxc.internal.e.b;

import com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation;
import d.h.b.o;

/* JADX INFO: compiled from: DefaultSafetyGuardSidecar.kt */
/* JADX INFO: loaded from: classes.dex */
final class a implements SidecarOperation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10544a;

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation
    public boolean cancel() {
        return false;
    }

    public a(String r2) {
        o.e(r2, "operationId");
        this.f10544a = r2;
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        SidecarOperation.DefaultImpls.close(this);
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation
    public String getOperationId() {
        return this.f10544a;
    }
}
