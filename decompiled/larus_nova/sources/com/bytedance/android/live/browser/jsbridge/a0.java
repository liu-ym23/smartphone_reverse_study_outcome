package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.ies.xbridge.XBridgeMethod;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class a0 implements com.bytedance.ies.xbridge.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XBridgeMethod f62921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f62922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g66.c f62923c;

    @Override // com.bytedance.ies.xbridge.n
    public final XBridgeMethod a() {
        this.f62921a.setProviderFactory(this.f62923c);
        return this.f62921a;
    }

    public a0(XBridgeMethod r100, List r101, g66.c r102) {
        this.f62921a = r100;
        this.f62922b = r101;
        this.f62923c = r102;
    }
}
