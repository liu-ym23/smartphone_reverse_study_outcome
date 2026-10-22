package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.order.Order;
import com.bytedance.android.livesdk.utils.e4;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements com.bytedance.android.scope.o, com.bytedance.android.live.recharge.order.e {
    public c() {
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
        if (((Boolean) com.bytedance.android.live.recharge.utils.j.f90484u.getValue(null, com.bytedance.android.live.recharge.utils.j.f90464a[18])).booleanValue() == true) goto L5;
        return;
    L5:
        if (((dr2.j) vh6.c.b(dr2.j.class)).isFinancialVisible() == true) goto L9;
        r100.b(this);
        return;
    }

    @Override // com.bytedance.android.live.recharge.order.e
    public final void a(Order r100, com.bytedance.android.live.recharge.order.f.b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "order");
        Intrinsics.checkNotNullParameter(r101, "handle");
        r101.d(new PayService.b(s1.C(R.string.ttlive_go_to_douyin_recharge, new Object[]{e4.a()})));
    }
}
