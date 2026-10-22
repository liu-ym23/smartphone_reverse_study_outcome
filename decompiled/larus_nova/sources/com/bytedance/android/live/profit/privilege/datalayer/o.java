package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.revenue.common.q0;
import com.bytedance.android.live.revenue.common.r0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f88408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Long f88409b;

    public o(d r100, Long r101) {
        this.f88408a = r100;
        this.f88409b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        com.bytedance.android.live.profit.privilege.e r102 = com.bytedance.android.live.profit.privilege.e.f88414a;
        String r103 = this.f88408a.f();
        long r104 = this.f88408a.d();
        Long r105 = this.f88409b;
        String r106 = q0.a(r101);
        if (r106 != null) goto L5;
        r106 = "";
    L5:
        int r107 = r0.a(r101);
        Intrinsics.checkNotNullParameter(r103, "userId");
        Intrinsics.checkNotNullParameter(r106, "errorMsg");
        JSONObject r108 = com.bytedance.android.live.profit.privilege.e.k(false, r106, Integer.valueOf(r107));
        JSONObject r109 = com.bytedance.android.live.profit.privilege.e.n(null);
        JSONObject r110 = com.bytedance.android.live.profit.privilege.e.m(r102, Long.valueOf(r104), 4);
        if (r105 == null) goto L8;
        long r111 = r105.longValue();
    L9:
        com.bytedance.android.live.profit.privilege.e.t(r110, "meta_id", Long.valueOf(r111));
        com.bytedance.android.live.profit.privilege.e.p("ttlive_privilege_ack_entrance_status_all", r108, r109, r110);
        return;
    L8:
        r111 = 0;
        goto L9
    }
}
