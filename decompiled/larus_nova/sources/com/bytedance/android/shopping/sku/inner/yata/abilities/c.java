package com.bytedance.android.shopping.sku.inner.yata.abilities;

import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements v96.c {
    public c() {
    }

    @Override // v96.c
    public final void a(com.bytedance.kmp.ec.yata.common.error.d r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Lazy r101 = SkuCommonLog.f182771a;
        SkuCommonLog.b("SkuYataErrorHandler", "onError   code:" + r100.f251398a + "  msg:" + r100.f251399b);
    }
}
