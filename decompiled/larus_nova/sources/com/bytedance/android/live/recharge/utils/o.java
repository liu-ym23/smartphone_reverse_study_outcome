package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.revenue.common.r0;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f90493a = 0;

    static {
    }

    public static void a(boolean r100, long r101, Throwable r110) {
        String r102 = RechargeMonitorService.TTLIVE_CHARGE_CHARGE_PACKAGE_API.getServiceName();
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "extra");
        Intrinsics.checkNotNullParameter(r104, "metric");
        int r106 = !r100 ? 1 : 0;
        r104.put("status_code", String.valueOf(r106));
        r105.put("status_code", String.valueOf(r106));
        Intrinsics.checkNotNullParameter(r105, "map");
        Long r107 = Long.valueOf(r101);
        Intrinsics.checkNotNullParameter("duration", "key");
        Intrinsics.checkNotNullParameter(r107, "value");
        r105.put("duration", r107);
        if (r110 == null) goto L8;
        Integer r108 = Integer.valueOf(r0.a(r110));
        Intrinsics.checkNotNullParameter("error_code", "key");
        Intrinsics.checkNotNullParameter(r108, "value");
        r105.put("error_code", r108);
        String r109 = r110.getMessage();
        if (r109 != null) goto L7;
        r109 = r110.toString();
    L7:
        Intrinsics.checkNotNullParameter("error_msg", "key");
        Intrinsics.checkNotNullParameter(r109, "value");
        r105.put("error_msg", r109);
    L8:
        cy0.e.f465759a.getClass();
        cy0.j r111 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r112 = com.bytedance.android.scope.m.b(r111).b(n97.a.class);
        Intrinsics.checkNotNull(r112);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r112)).g(r102, "revenue", "bussiness_api_call", r103, r104, r105);
    }

    public static void b(boolean r100, RechargeMonitorService r110, Map r111, Throwable r112) {
        Intrinsics.checkNotNullParameter(r110, "service");
        Intrinsics.checkNotNullParameter(r111, "extra");
        if (r111 == null) goto L11;
        if (r112 == null) goto L11;
        r111.put("error_code", Integer.valueOf(r0.a(r112)));
        String r101 = r112.getMessage();
        if (r101 != null) goto L10;
        r101 = r112.toString();
    L10:
        r111.put("error_msg", r101);
    L11:
        String r102 = r110.getServiceName();
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r105, "extra");
        Intrinsics.checkNotNullParameter(r104, "metric");
        int r106 = !r100 ? 1 : 0;
        r104.put("status_code", String.valueOf(r106));
        r105.put("status_code", String.valueOf(r106));
        Intrinsics.checkNotNullParameter(r105, "map");
        Iterator r107 = r111.entrySet().iterator();
    L13:
        if (r107.hasNext() == false) goto L15;
        Map.Entry r113 = (Map.Entry) r107.next();
        String r114 = (String) r113.getKey();
        String r115 = r113.getValue().toString();
        Intrinsics.checkNotNullParameter(r114, "key");
        Intrinsics.checkNotNullParameter(r115, "value");
        r105.put(r114, r115);
        goto L13
    L15:
        cy0.e.f465759a.getClass();
        cy0.j r116 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r108 = com.bytedance.android.scope.m.b(r116).b(n97.a.class);
        Intrinsics.checkNotNull(r108);
        ((n97.a) ((com.bytedance.live.kmp.core.c) r108)).g(r102, "revenue", "bussiness_api_call", r103, r104, r105);
    }
}
