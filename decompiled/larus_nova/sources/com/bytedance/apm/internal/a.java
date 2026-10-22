package com.bytedance.apm.internal;

import com.bytedance.apm.impl.ApmAgentServiceImpl;
import com.bytedance.services.apm.api.IApmAgent;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements f37.a<IApmAgent> {
    @Override // f37.a
    public final IApmAgent create() {
        return new ApmAgentServiceImpl();
    }

    public a() {
    }
}
