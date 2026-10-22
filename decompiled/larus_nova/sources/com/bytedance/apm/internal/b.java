package com.bytedance.apm.internal;

import com.bytedance.apm.impl.LaunchTraceImpl;
import com.bytedance.services.apm.api.ILaunchTrace;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements f37.a<ILaunchTrace> {
    @Override // f37.a
    public final ILaunchTrace create() {
        return new LaunchTraceImpl();
    }

    public b() {
    }
}
