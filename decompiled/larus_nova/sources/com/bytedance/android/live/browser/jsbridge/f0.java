package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;

/* JADX INFO: loaded from: classes45.dex */
public final class f0 implements p56.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IJsBridgeManager f63196a;

    @Override // p56.b
    public final String provideContainerID() {
        ILiveHybridContainer r100 = this.f63196a.getContainer();
        if (r100 == null) goto L7;
        String r101 = r100.getContainerId();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return this.f63196a.getJsBridge2().toString();
    }

    public f0(IJsBridgeManager r100) {
        this.f63196a = r100;
    }
}
