package com.bytedance.apm6.hub;

import com.bytedance.services.apm.api.IMonitorLogManager;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements f37.a<IMonitorLogManager> {
    public o() {
    }

    @Override // f37.a
    public final IMonitorLogManager create() {
        return new Apm$23$1(this);
    }
}
