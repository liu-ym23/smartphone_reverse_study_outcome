package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f88402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f88403b;

    public k(d r100, long r101) {
        this.f88402a = r100;
        this.f88403b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.live.kmp.util.c r101 = com.bytedance.live.kmp.util.c.f255167a;
        long r102 = System.currentTimeMillis() - this.f88403b;
        com.bytedance.android.live.profit.privilege.e r103 = com.bytedance.android.live.profit.privilege.e.f88414a;
        String r104 = this.f88402a.f();
        long r105 = this.f88402a.d();
        Intrinsics.checkNotNullParameter(r104, "userId");
        com.bytedance.android.live.profit.privilege.e.p("ttlive_privilege_info_growth_status_all", com.bytedance.android.live.profit.privilege.e.k(true, null, null), com.bytedance.android.live.profit.privilege.e.n(Long.valueOf(r102)), com.bytedance.android.live.profit.privilege.e.m(r103, Long.valueOf(r105), 4));
        d.a(this.f88402a, ((com.bytedance.android.live.profit.privilege.model.touch.j) ((ExtraResponse) r100).data).getTouchPositionMap());
    }
}
