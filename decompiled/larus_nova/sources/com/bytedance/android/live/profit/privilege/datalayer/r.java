package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.revenue.common.q0;
import com.bytedance.android.live.revenue.common.r0;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f88413a;

    public r(d r100) {
        this.f88413a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        com.bytedance.android.live.profit.privilege.e r102 = com.bytedance.android.live.profit.privilege.e.f88414a;
        String r103 = this.f88413a.f();
        long r104 = this.f88413a.d();
        String r105 = q0.a(r101);
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        int r106 = r0.a(r101);
        Intrinsics.checkNotNullParameter(r103, "userId");
        Intrinsics.checkNotNullParameter(r105, "errorMsg");
        JSONObject r107 = com.bytedance.android.live.profit.privilege.e.k(false, r105, Integer.valueOf(r106));
        JSONObject r108 = com.bytedance.android.live.profit.privilege.e.n(null);
        JSONObject r109 = com.bytedance.android.live.profit.privilege.e.m(r102, Long.valueOf(r104), 4);
        com.bytedance.android.live.profit.privilege.e.p("ttlive_privilege_pay_grade_status_all", r107, r108, r109);
        com.bytedance.android.live.profit.privilege.e.p("ttlive_privilege_pay_grade_status_error", r107, r108, r109);
    }
}
