package com.bytedance.android.live.recharge.deal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {
    public static final int a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$cashAmount");
        if ((r100 instanceof n) == true) goto L5;
        r100 = null;
    L5:
        n r101 = (n) r100;
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.f89730f;
    }

    public static final int b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$goldAmount");
        if ((r100 instanceof n) == true) goto L5;
        r100 = null;
    L5:
        n r101 = (n) r100;
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.f89731g;
    }

    public static final com.bytedance.android.live.recharge.platform.business.model.diamond.g c(f r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$panelExtraInfo");
        return r100.c().getPanelExtraInfo().get(Long.valueOf(r100.g()));
    }
}
