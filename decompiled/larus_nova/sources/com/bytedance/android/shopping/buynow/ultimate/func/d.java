package com.bytedance.android.shopping.buynow.ultimate.func;

import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends com.bytedance.kmp.ec.yata.event.common.a {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.a
    public final void c(com.bytedance.kmp.ec.yata.event.core.a r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "chainNextCallback");
        BuyNowLog.d("selfDoNothing", "selfDoNothing");
        int r102 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r101.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
