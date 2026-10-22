package com.bytedance.android.live.recharge.trace;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.recharge.utils.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import yz0.k;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f90392a = null;

    static {
        f90392a = (g) j.f90488y.getValue(null, j.f90464a[22]);
    }

    public static void a(RechargeTraceStep r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "step");
        Intrinsics.checkNotNullParameter(r101, "extra");
        JSONObject r102 = new JSONObject();
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        d60.b.a(r102, (String) r104.getKey(), String.valueOf(r104.getValue()));
        goto L4
    L6:
        String r105 = ExchangeTraceEvent.CLIENT_RECHARGE.getEventType();
        String r106 = r100.getValue();
        g r107 = f90392a;
        if (r107.a() == false) goto L27;
        List<String> r108 = r107.b();
        if (r108 == null) goto L27;
        if (r108.contains(r106) != true) goto L27;
        LiveTracingMonitor.EventModule r109 = LiveTracingMonitor.EventModule.RECHARGE;
        k r110 = (k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), k.class);
        String r111 = null;
        if (r110 == null) goto L16;
        IRoom r112 = r110.getRoom();
    L17:
        int r113 = com.bytedance.android.live.core.monitor.trace.e.f64997m;
        com.bytedance.android.live.core.monitor.trace.e.a r114 = com.bytedance.android.live.core.monitor.trace.e.b.a(r105, r109.getName());
        r114.f65010a = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId() + System.currentTimeMillis() + new SecureRandom().nextInt(1000);
        r114.f65012c = "webcast_client_recharge";
        r114.f65016g = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
        r114.f65017h = 0;
        r114.f65018i = "";
        r114.f65013d = r106;
        if (r112 == null) goto L22;
        IBaseUser r115 = r112.getOwner();
        if (r115 == null) goto L22;
        String r116 = r115.getIdString();
    L23:
        r114.f65015f = String.valueOf(r116);
        if (r112 == null) goto L26;
        r111 = r112.getIdStr();
    L26:
        r114.f65014e = r111;
        r114.f65011b = "";
        com.bytedance.android.live.core.monitor.trace.c.b(r114.a(), r102);
        return;
    L22:
        r116 = null;
        goto L23
    L16:
        r112 = null;
    L27:
        ALogger.e("RechargeTraceMonitor", "disable report trace. due to setting:" + r107);
    }

    public static void c(boolean r100, Throwable r101, Map r102) {
        Intrinsics.checkNotNullParameter(r102, "extra");
        Map r103 = MapsKt.toMutableMap(r102);
        if (r100 == false) goto L5;
        String r104 = "1";
    L6:
        r103.put("success", r104);
        if (r101 == null) goto L9;
        String r105 = r101.toString();
    L10:
        r103.put("error", r105);
        a(RechargeTraceStep.STEP_QUERY_ORDER, r103);
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = "0";
        goto L6
    }

    public static void b(boolean r100, com.bytedance.android.live.wallet.model.d r101, Throwable r102, Map r103) {
        Intrinsics.checkNotNullParameter(r103, "extra");
        Map r104 = MapsKt.toMutableMap(r103);
        if (r100 == false) goto L5;
        String r105 = "1";
    L6:
        r104.put("success", r105);
        String r106 = null;
        if (r101 == null) goto L9;
        String r107 = r101.toString();
    L10:
        r104.put("order_info", r107);
        if (r102 == null) goto L13;
        r106 = r102.toString();
    L13:
        r104.put("error", r106);
        a(RechargeTraceStep.STEP_DIAMOND_BUY, r104);
        return;
    L9:
        r107 = null;
        goto L10
    L5:
        r105 = "0";
        goto L6
    }
}
