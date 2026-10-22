package com.bytedance.android.shopping.sku.common.monitor.chain;

import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.inner.repo.a;
import com.bytedance.kmp.ec.yata.common.protocol.data.f;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pi.b;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuYataPageShowChain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f182740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f182741b;

    public final void a() {
        Lazy r100 = SkuCommonLog.f182771a;
        SkuCommonLog.a("SkuYataPageShowChain", SkuYataPageShowChain$onSkuPageStart$1.INSTANCE);
        int r101 = ECSdk.f48106a;
        b r102 = (b) ECSdk.a(b.class);
        if (r102 == null) goto L6;
        r102.monitorEvent("ec_perf_page_start_sku_panel", this.f182741b, null, null);
        return;
    }

    public SkuYataPageShowChain(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "baseParams");
        this.f182741b = r100;
    }

    public final void b(ph3.b r100, a r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Lazy r103 = SkuCommonLog.f182771a;
        SkuCommonLog.a("SkuYataPageShowChain", SkuYataPageShowChain$onSkuRequestEnd$1.INSTANCE);
        int r104 = this.f182740a + 1;
        this.f182740a = r104;
        if (r104 <= 1) goto L6;
        return;
    L6:
        if (r102 != null) goto L13;
        if (r101 == null) goto L13;
        if (f.d(r101) != true) goto L13;
        int r105 = ECSdk.f48106a;
        b r106 = (b) ECSdk.a(b.class);
        if (r106 == null) goto L17;
        JSONObject r107 = x0.a(this.f182741b);
        r107.put("status", "0");
        Unit r108 = Unit.INSTANCE;
        r106.monitorEvent("ec_perf_page_show_sku_panel", r107, null, null);
        return;
    L17:
        return;
    L13:
        int r109 = ECSdk.f48106a;
        b r110 = (b) ECSdk.a(b.class);
        if (r110 == null) goto L19;
        JSONObject r111 = x0.a(this.f182741b);
        r111.put("status", "1");
        Unit r112 = Unit.INSTANCE;
        r110.monitorEvent("ec_perf_page_show_sku_panel", r111, null, null);
        return;
    }
}
