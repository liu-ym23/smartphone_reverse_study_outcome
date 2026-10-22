package com.bytedance.android.shopping.sku.common.monitor.chain;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.core.monitor.listener.a;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.outer.business.cart.repo.SkuOuterAddToCartResponse;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import th3.c;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuYataAddCartChain {
    public static void a() {
        Lazy r100 = SkuCommonLog.f182771a;
        SkuCommonLog.a("SkuYataAddCartChain", SkuYataAddCartChain$destroy$1.INSTANCE);
        Set<String> r101 = ECProcessMonitor.f45118a;
        ECProcessMonitor.d("ec_sku").f45176j.invoke();
    }

    public SkuYataAddCartChain(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "baseParams");
        Lazy r101 = SkuCommonLog.f182771a;
        SkuCommonLog.a("SkuYataAddCartChain", AnonymousClass1.INSTANCE);
        Set<String> r102 = ECProcessMonitor.f45118a;
        ActionRateListener.c(ECProcessMonitor.d("ec_sku"), r100, null, true, 2);
    }

    public static void b(final c r100, final Throwable r101) {
        Lazy r102 = SkuCommonLog.f182771a;
        SkuCommonLog.a("SkuYataAddCartChain", new SkuYataAddCartChain$onAddCartRequestEndForNew$1(r100, r101));
        Set<String> r103 = ECProcessMonitor.f45118a;
        a r104 = ECProcessMonitor.d("ec_sku");
        JSONObject r105 = new JSONObject();
        r105.put("use_new_api", true);
        if (r100 == null) goto L5;
        String r106 = r100.f545931d;
    L6:
        r105.put("log_id", r106);
        Unit r107 = Unit.INSTANCE;
        r104.a(r105);
        if (r101 != null) goto L12;
        if (r100 == null) goto L12;
        if (r100.f545928a != 0) goto L12;
        r104.g();
        return;
    L12:
        if (r100 == null) goto L14;
        a.k(r104, r100.f545928a, r100.f545929b, null, null, 12);
    L14:
        if (r101 == null) goto L18;
        a.k(r104, -5, null, null, null, 14);
        return;
    L18:
        return;
    L5:
        r106 = null;
        goto L6
    }

    public static void c(final SkuOuterAddToCartResponse r100, final Throwable r101) {
        Lazy r102 = SkuCommonLog.f182771a;
        SkuCommonLog.a("SkuYataAddCartChain", new SkuYataAddCartChain$onAddCartRequestEndForOld$1(r100, r101));
        Set<String> r103 = ECProcessMonitor.f45118a;
        a r104 = ECProcessMonitor.d("ec_sku");
        JSONObject r105 = new JSONObject();
        r105.put("use_new_api", false);
        if (r100 == null) goto L5;
        String r106 = r100.getLogId();
    L6:
        r105.put("log_id", r106);
        Unit r107 = Unit.INSTANCE;
        r104.a(r105);
        if (r101 != null) goto L12;
        if (r100 == null) goto L12;
        if (r100.getStatusCode() != 0) goto L12;
        r104.g();
        return;
    L12:
        if (r100 == null) goto L14;
        a.k(r104, r100.getStatusCode(), r100.getStatusMsg(), null, null, 12);
    L14:
        if (r101 == null) goto L18;
        a.k(r104, -5, null, null, null, 14);
        return;
    L18:
        return;
    L5:
        r106 = null;
        goto L6
    }

    public static void d(final boolean r100, final int r101) {
        Lazy r102 = SkuCommonLog.f182771a;
        SkuCommonLog.a("SkuYataAddCartChain", new SkuYataAddCartChain$onAddCartStart$1(r100, r101));
        Set<String> r103 = ECProcessMonitor.f45118a;
        ECProcessMonitor.d("ec_sku").j(r100, r101);
        ECProcessMonitor.d("ec_sku").d();
    }
}
