package com.bytedance.android.live.profit.lottery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class x extends com.bytedance.android.live.core.utils.rxutils.l.a {
    public x() {
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.l.a
    public final boolean a(Throwable r100, int r101) {
        v.c r102 = v.f88217a;
        if (r100 != null) goto L5;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == true) goto L15;
        return true;
    L15:
        return super.a(r100, r101);
    L5:
        if (com.bytedance.android.live.revenue.common.r0.a(r100) != 10001) goto L7;
    L10:
        r103 = true;
        goto L12
    L7:
        if (com.bytedance.android.live.revenue.common.r0.a(r100) == 10002) goto L10;
        if (Intrinsics.areEqual(com.bytedance.android.live.revenue.common.q0.a(r100), "unknown") == false) goto L11;
        goto L10
    }
}
