package com.bytedance.android.shopping.orderlist.common.monitor.error;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.larus.bmhome.instruction.monitor.SuggestPromptErrorType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class OrderCommonErrorUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f179893a = 0;

    static {
    }

    public static void a(a r100, final String r101, final String r110, Map r111) {
        Intrinsics.checkNotNullParameter(r111, "extraParams");
        Lazy r102 = OrderCommonLog.f179948a;
        OrderCommonLog.b("OrderCommonErrorUtils", new OrderCommonErrorUtils$logForError$1(r101, r110));
        JSONObject r103 = new JSONObject();
        if (r100 == null) goto L10;
        Map<String, Object> r104 = r100.c();
        if (r104 == null) goto L10;
        Iterator<Map.Entry<String, Object>> r105 = r104.entrySet().iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        Map.Entry<String, Object> r106 = r105.next();
        r103.put(r106.getKey(), r106.getValue());
    L10:
        Iterator r112 = r111.entrySet().iterator();
    L12:
        if (r112.hasNext() == false) goto L15;
        Map.Entry r107 = (Map.Entry) r112.next();
        r103.put((String) r107.getKey(), r107.getValue());
        goto L12
    L15:
        if (r100 == null) goto L21;
        Map<String, ? extends Object> r108 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r109 = ig3.b.f489726a.entrySet().iterator();
    L18:
        if (r109.hasNext() == false) goto L20;
        Map.Entry<String, String> r113 = r109.next();
        r108.put(r113.getKey(), r113.getValue());
        goto L18
    L20:
        r108.put("error_type", r101);
        r108.put("error_msg", r110);
        r108.put("extra", r103);
        Unit r114 = Unit.INSTANCE;
        r100.b("yata_order_list_monitor", r108);
        return;
    L21:
        g r115 = g.f48122a;
        JSONObject r116 = new JSONObject();
        Iterator<Map.Entry<String, String>> r117 = ig3.b.f489726a.entrySet().iterator();
    L23:
        if (r117.hasNext() == false) goto L25;
        Map.Entry<String, String> r118 = r117.next();
        r116.put(r118.getKey(), r118.getValue());
        goto L23
    L25:
        r116.put("error_type", r101);
        r116.put("error_msg", r110);
        r116.put("extra", r103);
        Unit r119 = Unit.INSTANCE;
        r115.logV3("yata_order_list_monitor", r116);
    }

    public static void b(a r100, String r101, Function0 r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r101, "errorTag");
        Intrinsics.checkNotNullParameter(r102, "originTask");
        Intrinsics.checkNotNullParameter(r103, "errorCatchTask");
        if (ECAppInfoService.f48114e.i() == false) goto L10;
        r102.invoke();
        return;
    L10:
        r102.invoke();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        a(r100, SuggestPromptErrorType.ERROR_TYPE_CRASH, r101 + ": " + th.getMessage(), MapsKt.emptyMap());
        StringBuilder r104 = new StringBuilder("Yata订单列表组件化-");
        r104.append(r101);
        ECExceptionMonitor.f(th, r104.toString());
        r103.invoke();
    }
}
