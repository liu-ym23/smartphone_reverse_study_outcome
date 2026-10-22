package com.bytedance.android.livesdk.log;

import android.os.Bundle;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class d {
    public static void a(Bundle r100, String r101, String r102, HashMap<String, String> r103) {
        if (r100 == null) goto L24;
        if (r100.getBoolean("enter_from_effect_ad") == false) goto L24;
        JSONObject r104 = new JSONObject();
        if (r103.isEmpty() == false) goto L57;
    L14:
        Serializable r105 = r100.getSerializable(ILiveRoomPlayFragmentConstant.DATA_LIVE_EFFECT_AD_LOG_EXTRA_MAP);
        if ((r105 instanceof HashMap) == false) goto L24;
        HashMap r106 = (HashMap) r105;
        ILiveDouPlusService r107 = (ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class);
        HashMap r108 = new HashMap();
        r108.put("ad_extra_data", r104.toString());
        if (r106 != null) goto L19;
    L22:
        r107.logEvent(true, r101, r102, r108);
        goto L24
    L19:
        if (r106.isEmpty() == true) goto L22;
        r108.putAll(r106);
        goto L22
    L57:
        Iterator<String> r109 = r103.keySet().iterator();     // Catch: Exception -> L13
    L10:
        if (r109.hasNext() == false) goto L14;
        String r110 = r109.next();     // Catch: Exception -> L13
        r104.put(r110, r103.get(r110));     // Catch: Exception -> L13
    L24:
        if ("exit".equals(r102) == false) goto L26;
    L34:
        boolean r111 = false;
    L35:
        if (r111 == true) goto L65;
        if (r100 != null) goto L38;
        return;
    L38:
        if (r100.getBoolean("enter_from_hybrid_ad") == false) goto L67;
        JSONObject r112 = new JSONObject();
        if (r103.isEmpty() == false) goto L59;
    L47:
        Serializable r113 = r100.getSerializable("live_hybrid_ad_log_extra_map");
        if ((r113 instanceof HashMap) == false) goto L68;
        HashMap r114 = (HashMap) r113;
        ILiveDouPlusService r115 = (ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class);
        HashMap r116 = new HashMap();
        r116.put("ad_extra_data", r112.toString());
        if (r114 != null) goto L52;
    L55:
        r115.logEvent(true, r101, r102, r116);
        return;
    L52:
        if (r114.isEmpty() == true) goto L55;
        r116.putAll(r114);
        goto L55
    L68:
        return;
    L59:
        Iterator<String> r117 = r103.keySet().iterator();     // Catch: Exception -> L46
    L43:
        if (r117.hasNext() == false) goto L47;
        String r118 = r117.next();     // Catch: Exception -> L46
        r112.put(r118, r103.get(r118));     // Catch: Exception -> L46
    L67:
        return;
    L65:
        return;
    L26:
        if ("show_over".equals(r102) == true) goto L34;
        if ("show".equals(r102) == true) goto L34;
        if ("live_play".equals(r102) == true) goto L34;
        if ("enter".equals(r102) == true) goto L34;
        r111 = true;
        goto L35
    }

    public static void c(DataCenter r100, String r101, String r102, HashMap<String, String> r103) {
        if (c1.c(r100) == false) goto L22;
        JSONObject r104 = new JSONObject();
        if (r103.isEmpty() == false) goto L18;
    L12:
        ILiveDouPlusService r105 = (ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class);
        HashMap r106 = new HashMap();
        r106.put("ad_extra_data", r104.toString());
        Map<String, String> r107 = c1.f(r100);
        if (r107.isEmpty() == true) goto L16;
        r106.putAll(r107);
    L16:
        r105.logEvent(true, r101, r102, r106);
        return;
    L18:
        Iterator<String> r108 = r103.keySet().iterator();     // Catch: Exception -> L11
    L8:
        if (r108.hasNext() == false) goto L12;
        String r109 = r108.next();     // Catch: Exception -> L11
        r104.put(r109, r103.get(r109));     // Catch: Exception -> L11
    }

    public static void b(DataCenter r100, String r101, String r102, String r103, String r104) {
        HashMap r105 = new HashMap();
        r105.put("anchor_id", r103);
        r105.put("room_id", String.valueOf(r104));
        c(r100, r101, r102, r105);
    }
}
