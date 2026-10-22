package com.bytedance.android.live.browser.service;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ttnet.TTNetInit;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements y8.c {
    public i() {
    }

    @Override // y8.c
    public final float getScreenFps() {
        IPerformanceManager r100 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r100 != null) goto L7;
        return -1.0f;
    L7:
        return r100.getFps();
    }

    @Override // y8.c
    public final float v0() {
        IPerformanceManager r100 = (IPerformanceManager) jc1.k.f(IPerformanceManager.class);
        if (r100 != null) goto L7;
        return -1.0f;
    L7:
        return r100.getFpsInMin();
    }

    @Override // y8.c
    public final int getEffectiveConnectionType() {
        return TTNetInit.getEffectiveConnectionType();
    }
}
