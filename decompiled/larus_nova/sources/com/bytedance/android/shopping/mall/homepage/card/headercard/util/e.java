package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {
    public static /* synthetic */ void b(com.bytedance.android.shopping.mall.homepage.card.headercard.a r100, String r101, String r102, Map r103, Map r110) {
        a(r100, r101, r102, r103, r110, null);
    }

    public static final void a(final com.bytedance.android.shopping.mall.homepage.card.headercard.a r100, final String r101, final String r110, final Map r111, final Map r112, final Map r113) {
        Intrinsics.checkNotNullParameter(r100, "$this$reportEvent");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        Intrinsics.checkNotNullParameter(r110, "btm");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "globalProps");
        kk.d.c(new ReporterKt$reportEvent$1(r100, r101, r110, r111, r112, r113));
    }
}
