package com.bytedance.android.livesdk.interactivity.zdanmaku;

import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.PrivilegeDanmakuType;
import com.bytedance.live.artist.render.RenderEntity;

/* JADX INFO: loaded from: classes9.dex */
public final class i extends h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public uc2.b f141635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f141636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f141637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f141638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f141639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f141640j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f141641k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f141642l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f141643m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f141644n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int[] f141645o;

    public final int i() {
        nf6.a r100 = new tc2.b(0);
        nf6.a r101 = b().e(tc2.b.class);
        if (r101 == null) goto L7;
        r100 = r101;
    L7:
        return ((tc2.b) r100).f545377a;
    }

    public final int j() {
        nf6.a r100 = new tc2.c(-1);
        nf6.a r101 = b().e(tc2.c.class);
        if (r101 == null) goto L7;
        r100 = r101;
    L7:
        return ((tc2.c) r100).f545378a;
    }

    public i() {
        this.f141636f = -1;
        this.f141639i = 6.0f;
        this.f141640j = 5000;
    }

    public final int k() {
        tc2.i r100 = (tc2.i) b().e(tc2.i.class);
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f545389a;
    }

    public final boolean l() {
        if (((PrivilegeDanmakuType) b().e(PrivilegeDanmakuType.class)) != PrivilegeDanmakuType.MultiLine) goto L5;
        return true;
    L5:
        return false;
    }

    public final void m(float r100, boolean r101) {
        if (r101 == false) goto L10;
        f r102 = this.f141637g;
        if (r102 == null) goto L8;
        e r103 = r102.a(r100, this);
        if (r103 == null) goto L8;
    L9:
        RenderEntity r104 = b();
        tc2.g r105 = new tc2.g(r103.f141633a);
        r104.getClass();
        r104.a(tc2.g.class, r105);
        d(-r103.f141633a, 0.0f);
        return;
    L8:
        r103 = new e(0.0f);
        goto L9
    L10:
        f r106 = this.f141637g;
        if (r106 == null) goto L14;
        e r107 = r106.a(r100, this);
        if (r107 == null) goto L14;
    L15:
        RenderEntity r108 = b();
        tc2.g r109 = new tc2.g(r107.f141633a);
        r108.getClass();
        r108.a(tc2.g.class, r109);
        d(r107.f141633a, 0.0f);
        return;
    L14:
        r107 = new e(0.0f);
        goto L15
    }
}
