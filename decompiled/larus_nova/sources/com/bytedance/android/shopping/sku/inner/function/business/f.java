package com.bytedance.android.shopping.sku.inner.function.business;

import android.content.Context;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f extends com.bytedance.kmp.ec.yata.event.common.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.sku.inner.container.b f182927a;

    public f(com.bytedance.android.shopping.sku.inner.container.b r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f182927a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.a
    public final void c(com.bytedance.kmp.ec.yata.event.core.a r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "chainNextCallback");
        SkuCommonLog.c("SkuSelfFun-selfClickConfirmButton", "selfClickConfirmButton");
        Context r102 = this.f182927a.context();
        if (r102 != null) goto L6;
        int r103 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r101.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "localContext_is_null", null, null, 57));
        return;
    L6:
        Map<String, ? extends Object> r104 = r100.q();
        if (r104 != null) goto L9;
        r104 = MapsKt.emptyMap();
    L9:
        com.bytedance.android.shopping.sku.common.ability.c r105 = this.f182927a.zJ();
        if (r105 == null) goto L12;
        r105.i(r102, this.f182927a.tS(), r104);
    L12:
        int r106 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r101.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
    }
}
