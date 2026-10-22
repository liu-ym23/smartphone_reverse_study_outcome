package com.bytedance.android.livesdk.jsbridge.methods;

import android.text.TextUtils;
import com.bytedance.android.live.core.ILiveCoreService;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "uploadFullLinkMonitor")
public final class p3 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, LiveTracingMonitor.EventModule> f142175a = null;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    static {
        HashMap r100 = new HashMap();
        f142175a = r100;
        r100.put("ttlive_real_name", LiveTracingMonitor.EventModule.REAL_NAME);
        r100.put("ttlive_activity", LiveTracingMonitor.EventModule.ACTIVITY);
        r100.put("cooperation_partner", LiveTracingMonitor.EventModule.GAME_PROMOTE);
        r100.put("subscribe_vip", LiveTracingMonitor.EventModule.SUBSCRIBE_VIP);
        r100.put("paid_linkmic", LiveTracingMonitor.EventModule.PAID_LINK_MIC);
        LiveTracingMonitor.EventModule r101 = LiveTracingMonitor.EventModule.PREDICTOR_PLAYING;
        r100.put(r101.getName(), r101);
        LiveTracingMonitor.EventModule r102 = LiveTracingMonitor.EventModule.EXCHANGE;
        r100.put(r102.getName(), r102);
        r100.put("team_fight", LiveTracingMonitor.EventModule.TEAM_FIGHT);
        r100.put("room_battle", LiveTracingMonitor.EventModule.ROOM_BATTLE);
        r100.put("guest_battle", LiveTracingMonitor.EventModule.GUEST_BATTLE);
    }

    public p3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r110, CallContext r111) throws Exception {
        JSONObject r112 = r110;
        String r100 = JSONObjectProtectorUtils.getString(r112, "serviceName");
        String r113 = JSONObjectProtectorUtils.getString(r112, "event_module");
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(r112, "category");
        JSONObject r102 = JSONObjectProtectorUtils.getJSONObject(r112, "extra");
        String r114 = JSONObjectProtectorUtils.getString(r112, "event_type");
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L39:
        finishWithFailure(new Throwable("请求参数错误，serviceName is null  or eventModule is null"));
        return;
    L5:
        if (TextUtils.isEmpty(r113) == true) goto L39;
        HashMap r103 = (HashMap) f142175a;
        if (r103.containsKey(r113) == false) goto L10;
        LiveTracingMonitor.EventModule r104 = (LiveTracingMonitor.EventModule) r103.get(r113);
    L11:
        if (r104 != null) goto L14;
        finishWithFailure(new Throwable("请求参数错误，eventModule = " + r113 + "类型未在客户端注册"));
        return;
    L14:
        if (TextUtils.isEmpty(r114) == true) goto L27;
        LiveTracingMonitor.EventType[] r105 = LiveTracingMonitor.EventType.values();
        if (r105 == null) goto L27;
        if (r105.length == 0) goto L27;
        int r106 = r105.length;
        int r107 = 0;
    L22:
        if (r107 >= r106) goto L27;
        LiveTracingMonitor.EventType r108 = r105[r107];
        if (r108.getName().equals(r114) == true) goto L25;
        r107 = r107 + 1;
        goto L22
    L25:
        LiveTracingMonitor.EventType r109 = r108;
    L28:
        if (r109 != null) goto L30;
        finishWithFailure(new Throwable("请求参数错误，eventType = " + r114 + " 类型未在客户端注册"));
        return;
    L30:
        ILiveCoreService r115 = (ILiveCoreService) jc1.k.f(ILiveCoreService.class);
        if (TextUtils.equals(r113, "ttlive_real_name") == true) goto L33;
    L37:
        LiveTracingMonitor.e(r100, r104, r109, r101, null, r102);
    L38:
        finishWithSuccess();
        return;
    L33:
        if (r115.realNameUseTracePlatform() == false) goto L37;
        if (com.bytedance.android.live.core.monitor.trace.c.a() == false) goto L37;
        r115.reportUseTrace(r100, r101, null, r102);
    L27:
        r109 = null;
        goto L28
    L10:
        r104 = null;
        goto L11
    }
}
