package com.bytedance.android.shopping.sku.inner.function.base;

import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j extends com.bytedance.kmp.ec.yata.event.common.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.sku.inner.container.b f182912a;

    public j(com.bytedance.android.shopping.sku.inner.container.b r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f182912a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.a
    public final void c(com.bytedance.kmp.ec.yata.event.core.a r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "chainNextCallback");
        Map<String, Object> r102 = r100.q();
        if (r102 != null) goto L5;
        r102 = MapsKt.emptyMap();
    L5:
        Object r103 = r102.get("close_type");
        if ((r103 instanceof Integer) == true) goto L8;
        r103 = null;
    L8:
        Integer r104 = (Integer) r103;
        if (r104 == null) goto L11;
        int r105 = r104.intValue();
    L12:
        this.f182912a.close(r105);
        int r106 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r101.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L11:
        r105 = 0;
        goto L12
    }
}
