package com.bytedance.android.shopping.orderlist.common.utils;

import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.host.api.service.IECHostService;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {
    public static final b a(IECHostService r100, OrderAppletPageScene r101) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        Boolean r102 = null;
        if (r100 == null) goto L5;
        IECAIHostService r103 = r100.getECHostAIService();
    L7:
        if (r103 == null) goto L9;
        r102 = Boolean.valueOf(r103.isInApplet());
    L9:
        int r104 = d.f179961a[r101.ordinal()];
        boolean r105 = false;
        if (r104 != 1) goto L12;
        if (r103 != null) goto L21;
    L24:
        return new b(r102, r105);
    L21:
        if (r103.isLandingPage() != true) goto L24;
    L22:
        r105 = true;
        goto L24
    L12:
        if (r104 != 2) goto L18;
        if (r103 == null) goto L24;
        if (r103.isGoToLandingPage() != true) goto L24;
    L18:
        throw new NoWhenBranchMatchedException();
    L5:
        r103 = null;
        goto L7
    }
}
