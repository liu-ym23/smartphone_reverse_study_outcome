package com.bytedance.android.shopping.anchorv3.matchpurchase.presenter;

/* JADX INFO: loaded from: classes12.dex */
public final class f implements o63.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f165151a;

    @Override // o63.a
    public final void a() {
        o63.i r100 = new o63.i();
        r100.f522194d = "video";
        r100.post(null, null);
    }

    public f(g r100) {
        this.f165151a = r100;
    }

    @Override // o63.a
    public final void b(String r100) {
        jd3.s r101 = new jd3.s();
        r101.f498435f = "matching_product_middle";
        r101.C = "matching_product_icon";
        r101.f498453t = r100;
        r101.f498437g1 = i.d0(this.f165151a.f165152a).obtainEventBtmParams();
        r101.post(null, null);
    }

    @Override // o63.a
    public final void c(String r100) {
        jd3.u r101 = new jd3.u();
        r101.f498499g = "matching_product_middle";
        r101.f498509q = "matching_product_icon";
        r101.f498504l = r100;
        r101.L = i.d0(this.f165151a.f165152a).obtainEventBtmParams();
        r101.post(null, null);
    }
}
