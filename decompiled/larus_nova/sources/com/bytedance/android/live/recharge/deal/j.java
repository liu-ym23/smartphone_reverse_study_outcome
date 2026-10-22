package com.bytedance.android.live.recharge.deal;

import com.bytedance.android.livesdkapi.depend.model.IOneKeyPay;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j {
    public static final boolean b(i r100) {
        if (r100 == null) goto L8;
        IOneKeyPay r101 = r100.f();
        if (r101 == null) goto L8;
        if (r101.getSupportOneKeyPay() != true) goto L8;
        return true;
    L8:
        return false;
    }

    public static d a(i r100, long r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = false;
    L5:
        Intrinsics.checkNotNullParameter(r100, "$this$createCustomDeal");
        d r104 = e.a(r100.k(), r101, r102, false);
        if (r104 == null) goto L8;
        r104.a(r100);
        return r104;
    L8:
        return null;
    }
}
