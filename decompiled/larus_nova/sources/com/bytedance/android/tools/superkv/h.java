package com.bytedance.android.tools.superkv;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements g.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int[] f187642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f187643b;

    @Override // com.bytedance.android.tools.superkv.g.d
    public final void a(String r100) {
        this.f187643b.f187624d.remove(r100);
        int[] r101 = this.f187642a;
        r101[0] = r101[0] + 1;
    }

    public h(g r100, int[] r101) {
        this.f187643b = r100;
        this.f187642a = r101;
    }

    @Override // com.bytedance.android.tools.superkv.g.d
    public final void b(String r100, g.c r101) {
        this.f187643b.f187624d.put(r100, r101);
        int[] r102 = this.f187642a;
        r102[0] = r102[0] + 1;
    }
}
