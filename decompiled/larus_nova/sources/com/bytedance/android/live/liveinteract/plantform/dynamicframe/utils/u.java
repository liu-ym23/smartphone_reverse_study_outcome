package com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f77148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f77149b = 0;

    static {
    }

    public static void c(String r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r210, "lynxUrl");
        Intrinsics.checkNotNullParameter(r211, "cardType");
        Intrinsics.checkNotNullParameter(r212, "bizId");
        ALogger.i("MultiLinkDynamicWidget-Time", "start load card:" + r211 + "_biz:" + r212);
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("action_type", "card_create");
        r100.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r211);
        r100.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r212);
        j0.l().sendLog("livesdk_multilink_dynamic_element", r100, new Object[]{IRoom.class, am2.x.class});
        int r101 = s.f77144a;
        Intrinsics.checkNotNullParameter(r210, "lynxUrl");
        Intrinsics.checkNotNullParameter(r212, "bizId");
        Intrinsics.checkNotNullParameter(r211, "cardType");
        ALogger.i("MultiLinkDynamicFullLinkMonitor", "hybridCardLoadStart, bizId: " + r212 + ", cardType: " + r211 + ", lynxUrl: " + r210);
        if (s.a() == false) goto L7;
        JSONObject r102 = new JSONObject();
        r102.put(SendClosePdpEventParam.KEY_LYNX_URL, r210);
        r102.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r212);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r211);
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        ALogger.d("MultiLinkDynamicFullLinkMonitor", String.format("hybridCardLoadStart, extra: %s", Arrays.copyOf(new Object[]{r102}, 1)));
        int r104 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.MultiLinkDynamic, "multilink_dynamic_element_load_start", 0, null, r102, 88);
        return;
    }

    public static void d(String r210, String r211, String r212, long r213) {
        Intrinsics.checkNotNullParameter(r210, "lynxUrl");
        Intrinsics.checkNotNullParameter(r211, "cardType");
        Intrinsics.checkNotNullParameter(r212, "bizId");
        ALogger.i("MultiLinkDynamicWidget-Time", "success load card:" + r211 + "_biz:" + r212 + " useTime:" + r213);
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("action_type", "card_load_success");
        r100.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r211);
        r100.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r212);
        r100.put("duration", String.valueOf(r213));
        r100.put("loaded_element", r211 + '_' + r212 + "_load_suc");
        StringBuilder r110 = new StringBuilder("dynamic load ");
        r110.append(r211);
        r110.append(" card suc: ");
        r110.append(System.currentTimeMillis() - f77148a);
        ALogger.i("MultiLinkDynamicWidget-Time", r110.toString());
        j0.l().sendLog("livesdk_multilink_dynamic_element", r100, new Object[]{IRoom.class, am2.x.class});
        int r101 = s.f77144a;
        Intrinsics.checkNotNullParameter(r210, "lynxUrl");
        Intrinsics.checkNotNullParameter(r212, "bizId");
        Intrinsics.checkNotNullParameter(r211, "cardType");
        ALogger.i("MultiLinkDynamicFullLinkMonitor", "hybridCardLoadSuccess, bizId: " + r212 + ", cardType: " + r211 + ", duration: " + r213 + ", lynxUrl: " + r210);
        if (s.a() == false) goto L7;
        JSONObject r102 = new JSONObject();
        r102.put(SendClosePdpEventParam.KEY_LYNX_URL, r210);
        r102.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r212);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r211);
        r102.put("duration", r213);
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        ALogger.d("MultiLinkDynamicFullLinkMonitor", String.format("hybridCardLoadSuccess, extra: %s", Arrays.copyOf(new Object[]{r102}, 1)));
        int r104 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.MultiLinkDynamic, "multilink_dynamic_element_load_success", 0, null, r102, 88);
        return;
    }

    public static void e(String r110, String r111, String r112, long r113) {
        Intrinsics.checkNotNullParameter(r110, "lynxUrl");
        Intrinsics.checkNotNullParameter(r111, "cardType");
        Intrinsics.checkNotNullParameter(r112, "bizId");
        ALogger.i("MultiLinkDynamicWidget-Time", "card:" + r111 + "_biz:" + r112 + " unload");
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r111);
        r100.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r112);
        r100.put("duration", String.valueOf(r113));
        int r101 = s.f77144a;
        Intrinsics.checkNotNullParameter(r110, "lynxUrl");
        Intrinsics.checkNotNullParameter(r112, "bizId");
        Intrinsics.checkNotNullParameter(r111, "cardType");
        ALogger.i("MultiLinkDynamicFullLinkMonitor", "hybridCardUnload, bizId: " + r112 + ", cardType: " + r111 + ", lynxUrl: " + r110);
        if (s.a() == false) goto L7;
        JSONObject r114 = new JSONObject();
        r114.put(SendClosePdpEventParam.KEY_LYNX_URL, r110);
        r114.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r112);
        r114.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r111);
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        ALogger.d("MultiLinkDynamicFullLinkMonitor", String.format("hybridCardInnerError, extra: %s", Arrays.copyOf(new Object[]{r114}, 1)));
        int r103 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.MultiLinkDynamic, "multilink_dynamic_element_unload", 0, null, r114, 88);
        return;
    }

    public static void b(String r210, String r211, String r212, long r213, String r310) {
        Intrinsics.checkNotNullParameter(r210, "lynxUrl");
        Intrinsics.checkNotNullParameter(r211, "cardType");
        Intrinsics.checkNotNullParameter(r212, "bizId");
        ALogger.i("MultiLinkDynamicWidget-Time", "fail load card:" + r211 + "_biz:" + r212 + " useTime:" + r213);
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("action_type", "card_load_fail");
        r100.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r211);
        r100.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r212);
        r100.put("duration", String.valueOf(r213));
        j0.l().sendLog("livesdk_multilink_dynamic_element", r100, new Object[]{IRoom.class, am2.x.class});
        int r101 = s.f77144a;
        Intrinsics.checkNotNullParameter(r210, "lynxUrl");
        Intrinsics.checkNotNullParameter(r212, "bizId");
        Intrinsics.checkNotNullParameter(r211, "cardType");
        ALogger.i("MultiLinkDynamicFullLinkMonitor", "hybridCardLoadFail, bizId: " + r212 + ", cardType: " + r211 + ", duration: " + r213 + ", lynxUrl: " + r210 + ", reason: " + r310);
        if (s.a() == false) goto L7;
        JSONObject r102 = new JSONObject();
        r102.put(SendClosePdpEventParam.KEY_LYNX_URL, r210);
        r102.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r212);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r211);
        r102.put("duration", r213);
        r102.put("reason", r310);
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        ALogger.d("MultiLinkDynamicFullLinkMonitor", String.format("hybridCardLoadFail, extra: %s", Arrays.copyOf(new Object[]{r102}, 1)));
        int r104 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.MultiLinkDynamic, "multilink_dynamic_element_load_fail", 0, null, r102, 88);
        return;
    }

    public static void a(String r110, String r111, String r112, String r113, int r210, String r211, long r212) {
        Intrinsics.checkNotNullParameter(r110, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r111, "lynxUrl");
        Intrinsics.checkNotNullParameter(r112, "cardType");
        Intrinsics.checkNotNullParameter(r113, "bizId");
        Intrinsics.checkNotNullParameter(r211, "errorMessage");
        ALogger.e("MultiLinkDynamicWidget-Time", "card:" + r112 + "_biz:" + r113 + " inner error errorCode:" + r210 + " errMsg:" + r211);
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("action_type", r110);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r112);
        r100.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r113);
        r100.put("duration", String.valueOf(r212));
        r100.put("error_code", String.valueOf(r210));
        j0.l().sendLog("livesdk_multilink_dynamic_element", r100, new Object[]{IRoom.class, am2.x.class});
        int r101 = s.f77144a;
        Integer r102 = Integer.valueOf(r210);
        Intrinsics.checkNotNullParameter(r111, "lynxUrl");
        Intrinsics.checkNotNullParameter(r113, "bizId");
        Intrinsics.checkNotNullParameter(r112, "cardType");
        ALogger.i("MultiLinkDynamicFullLinkMonitor", "hybridCardInnerError, bizId: " + r113 + ", cardType: " + r112 + ", lynxUrl: " + r111 + ", errorCode: " + r102 + ", errorMessage: " + r211);
        if (s.a() == false) goto L7;
        JSONObject r103 = new JSONObject();
        r103.put(SendClosePdpEventParam.KEY_LYNX_URL, r111);
        r103.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r113);
        r103.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r112);
        r103.put("error_code", r102);
        r103.put("error_message", r211);
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        ALogger.d("MultiLinkDynamicFullLinkMonitor", String.format("hybridCardInnerError, extra: %s", Arrays.copyOf(new Object[]{r103}, 1)));
        int r105 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.MultiLinkDynamic, "multilink_dynamic_element_inner_error", 0, null, r103, 88);
        return;
    }
}
