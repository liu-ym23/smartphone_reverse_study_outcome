package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.revenue.common.q0;
import com.bytedance.android.live.revenue.common.r0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f88404a;

    public l(d r100) {
        this.f88404a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        com.bytedance.android.live.profit.privilege.e r102 = com.bytedance.android.live.profit.privilege.e.f88414a;
        String r103 = this.f88404a.f();
        long r104 = this.f88404a.d();
        String r105 = q0.a(r101);
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        int r106 = r0.a(r101);
        Intrinsics.checkNotNullParameter(r103, "userId");
        Intrinsics.checkNotNullParameter(r105, "errorMsg");
        com.bytedance.android.live.profit.privilege.e.p("ttlive_privilege_info_growth_status_all", com.bytedance.android.live.profit.privilege.e.k(false, r105, Integer.valueOf(r106)), com.bytedance.android.live.profit.privilege.e.n(null), com.bytedance.android.live.profit.privilege.e.m(r102, Long.valueOf(r104), 4));
        d.a(this.f88404a, null);
    }
}
