package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.shopping.api.mall.IECNativeHomeService;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.ECStageTriggerSource;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class k extends qf3.e {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "mall.deliveryRecord";
    }

    public k(qf3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        super(r100);
    }

    public static Map h(Map r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("code", 1);
        r101.put("msg", "success");
        if (r100 != null) goto L13;
    L12:
        return r101;
    L13:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L10
        Iterator r104 = r100.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r104.hasNext() == false) goto L8;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L10
        r103.putOpt((String) r105.getKey(), r105.getValue());     // Catch: Throwable -> L10
        goto L6
    L8:
        LinkedHashMap r106 = new LinkedHashMap();     // Catch: Throwable -> L10
        r106.put("deliveryInfo", r103);     // Catch: Throwable -> L10
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L10
        Result.m9449constructorimpl(r101.put("data", r106));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final Map<String, Object> g(String r100) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 0), TuplesKt.to("msg", r100)});
    }

    @Override // qf3.e, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r110, Map<String, ? extends Object> r111, IDLXBridgeMethod.a r112) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        IECNativeHomeService r113 = (IECNativeHomeService) ServiceManager.get().getService(IECNativeHomeService.class);
        Map<String, Object> r100 = null;
        if (r113 == null) goto L5;
        y93.b r114 = r113.a();
    L6:
        Object r101 = r111.get(ReportConstant.COMMON_ACTION_TYPE);
        if ((r101 instanceof String) == true) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        Object r103 = r111.get("sessionID");
        if ((r103 instanceof String) == true) goto L12;
        r103 = null;
    L12:
        String r104 = (String) r103;
        if (r102 == null) goto L91;
        if (r104 == null) goto L91;
        Object r105 = r111.get("deliveryRecord");
        if ((r105 instanceof Map) == true) goto L19;
        r105 = null;
    L19:
        Map<String, ? extends Object> r106 = (Map) r105;
        switch(r102.hashCode()) {
            case -1246914851: goto L56;
            case -235365105: goto L44;
            case 96417: goto L36;
            case 102230: goto L31;
            case 1919834714: goto L23;
            default: goto L89;
        };
    L89:
        r112.invoke(g("actionType is not support"));
        return;
    L23:
        if (r102.equals("publishTTI") == false) goto L89;
        if (r106 == null) goto L27;
        if (r114 == null) goto L27;
        r114.e(r104, r106);
    L27:
        if (r114 == null) goto L29;
        r100 = r114.h(r104);
    L29:
        r112.invoke(h(r100));
        return;
    L31:
        if (r102.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L89;
        if (r114 == null) goto L34;
        r100 = r114.h(r104);
    L34:
        r112.invoke(h(r100));
        return;
    L36:
        if (r102.equals("add") == false) goto L89;
        if (r106 == null) goto L40;
        if (r114 == null) goto L40;
        r114.a(r104, r106);
    L40:
        if (r114 == null) goto L42;
        r100 = r114.h(r104);
    L42:
        r112.invoke(h(r100));
        return;
    L44:
        if (r102.equals("publish") == false) goto L89;
        Object r115 = r111.get("isSuccess");
        if ((r115 instanceof Boolean) == true) goto L48;
        r115 = null;
    L48:
        Boolean r116 = (Boolean) r115;
        if (r106 == null) goto L52;
        if (r114 == null) goto L52;
        r114.g(r104, Intrinsics.areEqual(r116, Boolean.TRUE), r106);
    L52:
        if (r114 == null) goto L54;
        r100 = r114.h(r104);
    L54:
        r112.invoke(h(r100));
        return;
    L56:
        if (r102.equals("addStage") == false) goto L89;
        Object r107 = r111.get("deliveryStage");
        if ((r107 instanceof String) == true) goto L60;
        r107 = null;
    L60:
        String r108 = (String) r107;
        if (r108 != null) goto L63;
        r108 = "";
    L63:
        String r109 = r108;
        if (r109.length() != 0) goto L66;
        boolean r117 = true;
    L67:
        if (r117 == false) goto L70;
        r112.invoke(g("deliveryStage is empty"));
        return;
    L70:
        Object r118 = r111.get("timestamp");
        if ((r118 instanceof Long) == true) goto L73;
        r118 = null;
    L73:
        Long r119 = (Long) r118;
        if (r119 == null) goto L76;
        long r120 = r119.longValue();
    L77:
        LinkedHashMap r121 = new LinkedHashMap();
        if (r106 == null) goto L85;
        Iterator<Map.Entry<String, ? extends Object>> r122 = r106.entrySet().iterator();
    L81:
        if (r122.hasNext() == false) goto L85;
        Map.Entry<String, ? extends Object> r123 = r122.next();
        Object r124 = r123.getValue();
        if (r124 == null) goto L81;
        r121.put(r123.getKey(), r124);
    L85:
        r121.put("delivery_session_id", r104);
        CopyOnWriteArrayList<WeakReference<com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c>> r125 = com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.a.f170351a;
        com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.a.a(r109, "", r120, ECStageTriggerSource.MALL_DELIVERYRECORD_BRIDGE.getType(), r121);
        if (r114 == null) goto L88;
        r100 = r114.h(r104);
    L88:
        r112.invoke(h(r100));
        return;
    L76:
        r120 = System.currentTimeMillis();
        goto L77
    L66:
        r117 = false;
    L91:
        r112.invoke(g("actionType or sessionId is null"));
        return;
    L5:
        r114 = null;
        goto L6
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r100, IBDXBridgeContext r101, Map<String, ? extends Object> r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "result");
        return TuplesKt.to(Boolean.TRUE, null);
    }
}
