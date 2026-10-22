package com.bytedance.android.live.browser.jsbridge.newmethods;

/* JADX INFO: loaded from: classes45.dex */
public final class ud implements com.bytedance.android.annie.bridge.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zd f63687a;

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<?, ?> a() {
        zd r100 = this.f63687a;
        r100.getClass();
        return new td(r100);
    }

    @Override // com.bytedance.android.annie.bridge.q
    public final void release() {
        this.f63687a.getClass();
        zd.b("venue jsb release");
        zd.a(this.f63687a);
    }

    public ud(zd r100) {
        this.f63687a = r100;
    }
}
