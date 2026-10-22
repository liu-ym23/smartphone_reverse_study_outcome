package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vg3.x;

/* JADX INFO: loaded from: classes13.dex */
public abstract class e implements d {
    public e() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.d
    public final void a(Map<String, ? extends Object> r100, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "completion");
        com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.b r102 = (com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.b) this;
        Intrinsics.checkNotNullParameter(r100, "params");
        Object r103 = r100.get("refresh_req_params");     // Catch: Throwable -> L12
        if ((r103 instanceof Map) == true) goto L6;
        r103 = null;
    L6:
        Map<String, ? extends Object> r104 = (Map) r103;     // Catch: Throwable -> L12
        if (r104 == null) goto L14;
        x r105 = (x) r102.f182129a.N1(x.class);     // Catch: Throwable -> L12
        if (r105 == null) goto L14;
        r105.c1(r104);     // Catch: Throwable -> L12
    L14:
        x r106 = r102.f182129a.c2();
        if (r106 == null) goto L17;
        x.a.a(r106, false, "jsb_trigger_refresh", MapsKt.mapOf(TuplesKt.to("jsb_name", "updateGoodsDetail")), 24);
    L17:
        int r107 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        r101.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L12:
        th = move-exception;
        ECExceptionMonitor.e(th);
        goto L14
    }
}
