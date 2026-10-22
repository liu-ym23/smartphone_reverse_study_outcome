package com.bytedance.android.shopping.anchorv4.voavhs.head.base;

/* JADX INFO: loaded from: classes13.dex */
public class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f168522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f168523b;

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.i
    public final void a(String r100) {
        d r101 = this.f168522a;
        if (r101 == null) goto L8;
        c63.d r102 = r101.t();
        if (r102 == null) goto L9;
        r102.p(com.bytedance.android.shopping.extensions.k.j(r100));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.i
    public void b(int r100) {
        d r101 = this.f168522a;
        if (r101 == null) goto L6;
        r101.s(this.f168523b, r100);
        return;
    }

    public c(d r100, Integer r101) {
        this.f168522a = r100;
        this.f168523b = r101;
    }
}
