package com.bytedance.safetyguard.lxc.api.sidecar;

import d.h.b.o;

/* JADX INFO: compiled from: SidecarModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SidecarOperationException extends IllegalStateException {
    private final SidecarResult result;

    public final SidecarResult getResult() {
        return this.result;
    }

    public SidecarOperationException(SidecarResult r2) {
        o.e(r2, "result");
        super(r2.getMessage());
        this.result = r2;
    }
}
