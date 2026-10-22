package com.bytedance.android.ec.core.monitor;

import com.bytedance.android.ec.sdk.ECSdk;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f45162a = null;

    public k() {
    }

    static {
        f45162a = new LinkedHashMap();
    }

    public static com.bytedance.android.ec.monitor.duration.d a() {
        Intrinsics.checkNotNullParameter("ec_perf_duration_anchor_v3_detail", "business");
        String r100 = b("ec_perf_duration_anchor_v3_detail");
        if (r100 != null) goto L7;
        return null;
    L7:
        return com.bytedance.android.ec.monitor.duration.i.f47987a.get(r100);
    }

    public static String b(String r100) {
        Map<String, String> r101 = f45162a;
        String r102 = (String) ((LinkedHashMap) r101).get(r100);
        if (r102 != null) goto L5;
        r102 = com.bytedance.android.ec.monitor.duration.i.f47987a.create(r100);
    L5:
        r101.put(r100, r102);
        return (String) ((LinkedHashMap) r101).get(r100);
    }

    public static void c(JSONObject r100) {
        int r101 = ECSdk.f48106a;
        pi.b r102 = (pi.b) ECSdk.a(pi.b.class);
        if (r102 == null) goto L6;
        r102.monitorEvent("ec_perf_page_show_sku_panel", r100, null, null);
        return;
    }

    public static void d(JSONObject r100) {
        int r101 = ECSdk.f48106a;
        pi.b r102 = (pi.b) ECSdk.a(pi.b.class);
        if (r102 == null) goto L6;
        r102.monitorEvent("ec_perf_page_start_sku_panel", r100, null, null);
        return;
    }

    public static void e(String r100) {
        Intrinsics.checkNotNullParameter("ec_perf_duration_sku_panel", "business");
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = b("ec_perf_duration_sku_panel");
        if (r101 == null) goto L8;
        com.bytedance.android.ec.monitor.duration.d r102 = com.bytedance.android.ec.monitor.duration.i.f47987a.get(r101);
        if (r102 == null) goto L9;
        r102.a(r100);
        return;
    L9:
        return;
    }

    public static void f(String r100, com.bytedance.android.ec.monitor.duration.h r101) {
        Intrinsics.checkNotNullParameter(r100, "business");
        String r102 = b(r100);
        if (r102 == null) goto L11;
        com.bytedance.android.ec.monitor.duration.d r103 = com.bytedance.android.ec.monitor.duration.i.f47987a.get(r102);
        if (r103 == null) goto L9;
        if (r101 == null) goto L8;
        r103.e(r101);
    L8:
        r103.report();
    L9:
        String r104 = f45162a.remove(r100);
        return;
    }
}
