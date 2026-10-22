package com.bytedance.safetyguard.lxc.api.sidecar;

import d.h.b.o;

/* JADX INFO: compiled from: SafetyGuardSidecar.kt */
/* JADX INFO: loaded from: classes.dex */
final class CompletedSidecarOperation implements SidecarOperation {
    private final String operationId;

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation
    public boolean cancel() {
        return false;
    }

    public CompletedSidecarOperation(String r2) {
        o.e(r2, "operationId");
        this.operationId = r2;
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        SidecarOperation.DefaultImpls.close(this);
    }

    @Override // com.bytedance.safetyguard.lxc.api.sidecar.SidecarOperation
    public String getOperationId() {
        return this.operationId;
    }
}
