package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.activity.ActivityHybridMonitor$ContainerType;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f114391a = 0;

    public a() {
    }

    static {
    }

    public static void a(int r100, Integer r101, String r110, String r111) {
        if (ActivityMonitor.a() == false) goto L17;
        JSONObject r102 = new JSONObject();
        r102.put("url", r111);
        r102.put("room_id", r110);
        r102.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r101);
        r102.put("msg", "onFallback");
        com.bytedance.android.livesdk.log.filter.o r103 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if (r103 == null) goto L10;
        Map<String, String> r104 = r103.getMap();
        if (r104 == null) goto L10;
        String r105 = r104.get("enter_from_merge");
        if (r105 == null) goto L10;
    L12:
        if (x40.e.a(r105) == false) goto L14;
        String r106 = r105;
    L15:
        ActivityMonitor.d("ttlive_activity_downgrade_webView", r100, r102, "", r106, null, 64);
        return;
    L14:
        r106 = "";
    L10:
        r105 = "";
        goto L12
    }

    public static /* synthetic */ void c(int r110, String r111, ActivityHybridMonitor$ContainerType r112, int r113, String r114, String r115) {
        b(r110, r111, r112, "-1", r113, r114, r115, null, 0);
    }

    public static void b(int r110, String r111, ActivityHybridMonitor$ContainerType r112, String r113, int r114, String r210, String r211, String r212, long r213) {
        String r100 = r211;
        String r101 = "";
        if (ActivityMonitor.a() == false) goto L25;
        JSONObject r102 = new JSONObject();
        r102.put("url", r100);
        r102.put("room_id", r210);
        r102.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r114);
        r102.put("msg", r111);
        r102.put("live_activity", r212);
        com.bytedance.android.livesdk.log.filter.o r103 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if (r103 == null) goto L10;
        Map<String, String> r104 = r103.getMap();
        if (r104 == null) goto L10;
        String r105 = r104.get("enter_method");
        if (r105 == null) goto L10;
    L12:
        if (r103 == null) goto L17;
        Map<String, String> r106 = r103.getMap();
        if (r106 == null) goto L17;
        String r107 = r106.get("enter_from_merge");
        if (r107 == null) goto L17;
    L18:
        JSONObject r115 = new JSONObject();
        r115.put("status_code", r110);
        if (r112 == null) goto L21;
        String r116 = r112.getType();
    L22:
        r115.put("category_1", r116);
        r115.put("category_2", r113);
        r115.put("enter_method", r105);
        r115.put("enter_from_merge", r107);
        r115.put("short_touch_type", r114);
        ActivityMonitor.c("ttlive_activity_short_touch_container_show", r115, null, r102);
        goto L25
    L21:
        r116 = null;
    L17:
        r107 = "";
    L10:
        r105 = "";
    L25:
        if (ActivityMonitor.f64743a.booleanValue() == false) goto L37;
        HashMap r108 = new HashMap();
        if (r100 != null) goto L29;
        r100 = "";
    L29:
        r108.put("url", r100);
        r108.put("icon_name", String.valueOf(r114));
        r108.put("status_code", String.valueOf(r110));
        r108.put("tti", String.valueOf(r213));
        if (r112 == null) goto L35;
        String r109 = r112.getType();
        if (r109 == null) goto L35;
        r101 = r109;
    L35:
        r108.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, r101);
        com.bytedance.android.livesdk.log.j0.l().sendLog("short_touch_icon_show", r108, new Object[]{IRoom.class, am2.x.class});
        return;
    }
}
