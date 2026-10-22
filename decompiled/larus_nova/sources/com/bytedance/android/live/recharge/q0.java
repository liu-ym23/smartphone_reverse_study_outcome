package com.bytedance.android.live.recharge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f90339a;

    public q0(String r100, int r101) {
        String r102 = "";
        if ((r101 & 4) == 0) goto L5;
        String r103 = "";
    L7:
        if ((r101 & 16) != 0) goto L10;
        r102 = null;
    L10:
        Intrinsics.checkNotNullParameter(r100, "chargeReason");
        Intrinsics.checkNotNullParameter(r103, "chargeScene");
        Intrinsics.checkNotNullParameter(r102, "showType");
        this.f90339a = r100;
        return;
    L5:
        r103 = "gift_recharge";
        goto L7
    }
}
