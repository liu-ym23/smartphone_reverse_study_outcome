package com.bytedance.android.shopping.sku.inner.ultimate;

import com.bytedance.android.ec.core.sku.SkuPerformanceOpt;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Pair<String, String> f182982a;

    static {
    }

    public static boolean a(SkuParams r100) {
        Intrinsics.checkNotNullParameter(r100, "skuParams");
        String r101 = r100.getDiffTag();
        if (r101 != null) goto L5;
    L10:
        return false;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 != true) goto L10;
        return true;
    L7:
        r102 = false;
        goto L8
    }

    public static void b(SkuParams r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "skuParams");
        Intrinsics.checkNotNullParameter(r101, "dataString");
        Map r102 = SkuPerformanceOpt.b();
        if (r102 == null) goto L5;
        Object r103 = r102.get("iesec_enable_schema_diff_report");
    L7:
        if (Intrinsics.areEqual(r103, 1) == false) goto L40;
        String r104 = r100.getDiffTag();
        if (r104 != null) goto L11;
        return;
    L11:
        if (r104.length() <= 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L17;
        r104 = null;
    L17:
        if (r104 == null) goto L42;
        Pair<String, String> r106 = f182982a;
        if (r106 == null) goto L21;
        String r107 = r106.getFirst();
    L23:
        if (Intrinsics.areEqual(r107, r104) == true) goto L25;
        f182982a = TuplesKt.to(r104, r101);
        return;
    L25:
        if (ECAppInfoService.f48114e.getCurrentActivity() == null) goto L37;
        cl.d.f24079a.getClass();
        cl.d r108 = cl.d.a.b();
        if (r108 == null) goto L29;
        r108.b();
    L29:
        int r109 = ECSdk.f48106a;
        pi.b r110 = (pi.b) ECSdk.a(pi.b.class);
        if (r110 == null) goto L37;
        Pair[] r111 = new Pair[4];
        Pair<String, String> r112 = f182982a;
        if (r112 == null) goto L35;
        String r113 = r112.getSecond();
        if (r113 == null) goto L35;
    L36:
        r111[0] = TuplesKt.to("in_schema", r113);
        r111[1] = TuplesKt.to("out_schema", r101);
        r111[2] = TuplesKt.to("location", "ultimateBuyPanel");
        r111[3] = TuplesKt.to("business", "ultimateBuy");
        r110.monitorEvent("schema_report", k.b(MapsKt.mapOf(r111)), null, null);
    L35:
        r113 = "";
    L37:
        SkuCommonLog.c("UltimateBuyDiffTest", "diff success");
        f182982a = null;
        return;
    L21:
        r107 = null;
        goto L23
    L42:
        return;
    L13:
        r105 = false;
        goto L14
    L40:
        return;
    L5:
        r103 = null;
        goto L7
    }
}
