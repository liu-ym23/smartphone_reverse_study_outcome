package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;

/* JADX INFO: loaded from: classes14.dex */
public abstract class p extends f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f189622j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WindowV2ProductItemVO f189623k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f189624l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f189625m;

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final String b() {
        WindowV2ProductItemVO r100 = this.f189623k;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f49463a;
    }

    public p(e r100, tq3.c r101, boolean r102, boolean r103, int r104) {
        super(r104);
        this.f189622j = r100;
        this.f189623k = r101;
        this.f189624l = r102;
        this.f189625m = r103;
        if (r101 == null) goto L8;
        fo.b r105 = r101.C;
        if (r105 == null) goto L9;
        fo.a<Integer> r106 = wn.a.f560409f;
        int r107 = com.bytedance.android.window.shop.b.f187760a;
        Integer r108 = (Integer) r105.b(r106, Integer.valueOf((-1073741825) & r104));
        return;
    L9:
        return;
    }
}
