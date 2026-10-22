package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements com.bytedance.android.scope.o, com.bytedance.android.live.recharge.order.e {
    public a() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void c(com.bytedance.android.live.recharge.order.f.b r100) {
        Intrinsics.checkNotNullParameter(r100, "order");
        yz0.k r101 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        JSONObject r102 = r100.f90097g.f90127j;
        if (r102.has("multi_stream_log_pb") == true) goto L12;
        com.bytedance.android.livesdk.revenue.service.room.b r103 = (com.bytedance.android.livesdk.revenue.service.room.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class);
        if (r101 == null) goto L7;
        DataCenter r104 = r101.getDataCenter();
    L8:
        String r105 = r103.Ub(r104);
        if (r105 == null) goto L13;
        r102.put("multi_stream_log_pb", r105);
        return;
    L13:
        return;
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void a(Order r100, com.bytedance.android.live.recharge.order.f.b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "order");
        Intrinsics.checkNotNullParameter(r101, "handle");
        throw new UnsupportedOperationException();
    }
}
