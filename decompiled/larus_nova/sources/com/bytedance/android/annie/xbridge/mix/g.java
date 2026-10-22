package com.bytedance.android.annie.xbridge.mix;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IStatefulToXBridge f40163a;

    public g(IStatefulToXBridge r100) {
        this.f40163a = r100;
    }

    @Override // com.bytedance.android.annie.xbridge.mix.l
    public final void a(com.bytedance.ies.web.jsbridge2.f<Object, Object> r100) {
        this.f40163a.f40132c.remove(r100);
    }
}
