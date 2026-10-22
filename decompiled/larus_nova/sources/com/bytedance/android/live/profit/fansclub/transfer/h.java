package com.bytedance.android.live.profit.fansclub.transfer;

import com.bytedance.android.live.revenue.common.q0;
import com.bytedance.android.live.revenue.common.r0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f87387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f87388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f87389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f87390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.revenue.common.g f87391e;

    public h(b r100, String r101, String r102, long r103, com.bytedance.android.live.revenue.common.g r104) {
        this.f87387a = r100;
        this.f87388b = r101;
        this.f87389c = r102;
        this.f87390d = r103;
        this.f87391e = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        com.bytedance.android.live.profit.privilege.e r102 = com.bytedance.android.live.profit.privilege.e.f88414a;
        String r103 = this.f87388b;
        String r104 = this.f87389c;
        long r105 = this.f87390d;
        String r106 = q0.a(r101);
        if (r106 != null) goto L5;
        r106 = "";
    L5:
        com.bytedance.android.live.profit.privilege.e.q(r103, r104, r105, r106, r0.a(r101), this.f87387a.f87367a.c());
        this.f87391e.d("error " + r101);
    }
}
