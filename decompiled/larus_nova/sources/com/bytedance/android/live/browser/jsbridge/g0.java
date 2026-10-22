package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.ies.xbridge.XBridgeMethod;

/* JADX INFO: loaded from: classes45.dex */
public final class g0 implements com.bytedance.ies.xbridge.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XBridgeMethod f63200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g66.c f63201b;

    @Override // com.bytedance.ies.xbridge.n
    public final XBridgeMethod a() {
        this.f63200a.setProviderFactory(this.f63201b);
        return this.f63200a;
    }

    public g0(XBridgeMethod r100, g66.c r101) {
        this.f63200a = r100;
        this.f63201b = r101;
    }
}
