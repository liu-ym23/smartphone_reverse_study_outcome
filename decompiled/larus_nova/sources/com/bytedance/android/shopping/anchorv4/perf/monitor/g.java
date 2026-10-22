package com.bytedance.android.shopping.anchorv4.perf.monitor;

/* JADX INFO: loaded from: classes12.dex */
public final class g implements com.bytedance.android.shopping.anchorv3.compat.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f167240a;

    @Override // com.bytedance.android.shopping.anchorv3.compat.d
    public final void a() {
        c r100 = this.f167240a;
        if (r100.f167224d == false) goto L21;
        r100.f167224d = false;
        long r101 = System.currentTimeMillis();
        int r102 = r100.f167227g;
        if (r102 != 0) goto L12;
        i r103 = r100.f167221a;
        r103.f167247f = Long.valueOf(r101);
        if (r100.f167221a.f167248g == null) goto L10;
        r100.f(Long.valueOf(r101));
    L10:
        if (r100.f167221a.f167259r == null) goto L22;
        c.g(r100, Long.valueOf(r101), false, 2);
        return;
    L22:
        return;
    L12:
        i r104 = r100.f167221a;
        if (r104.f167247f != null) goto L16;
        r104.f167247f = r104.f167246e;
    L16:
        if (r102 != 1) goto L18;
        r104.f167260s = Long.valueOf(r101);
        return;
    L18:
        if (r102 != 2) goto L25;
        r104.f167251j = Long.valueOf(r101);
        r100.f167228h = null;
        return;
    L25:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv3.compat.d
    public final void b() {
        c r100 = this.f167240a;
        if (r100.f167224d == true) goto L5;
        return;
    L5:
        if (r100.f167227g != 2) goto L11;
        i r101 = r100.f167221a;
        if (r101.f167250i != null) goto L12;
        r101.f167250i = Long.valueOf(System.currentTimeMillis());
        return;
    L12:
        return;
    }

    public g(c r100) {
        this.f167240a = r100;
    }
}
