package com.bytedance.android.live.browser.jsbridge;

import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class x implements com.bytedance.android.annie.bridge.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f64142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f64143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y6.c f64144c;

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f a() {
        return new w(this);
    }

    @Override // com.bytedance.android.annie.bridge.q
    public final void release() {
        ((com.bytedance.ies.xbridge.n) this.f64143b.getValue()).a().release();
    }

    public x(String r100, Map.Entry r101, y6.c r102) {
        this.f64142a = r100;
        this.f64143b = r101;
        this.f64144c = r102;
    }
}
