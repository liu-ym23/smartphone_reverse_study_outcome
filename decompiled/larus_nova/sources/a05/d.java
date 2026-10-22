package a05;

import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class d {
    public static void b(String r100) {
        Object r101 = ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).f("ccm_battery_extra", "ccm_battery_jsb_extra");     // Catch: Exception -> L12
        if ((r101 instanceof HashMap) == true) goto L6;
        return;
    L6:
        if ("".equals(((HashMap) r101).get("jsb_state")) == false) goto L8;
        return;
    L8:
        if ("".equals(((HashMap) r101).get("jsb_webview_id")) == true) goto L17;
        ((HashMap) r101).put("jsb_state", r100);     // Catch: Exception -> L12
        return;
    L17:
        return;
    }

    public static void a(String r100, String r101, String r102) {
        if (r100 == null) goto L13;
        if (r102 == null) goto L15;
        Object r103 = ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).f("ccm_battery_extra", "ccm_battery_extra".concat(r100));     // Catch: Exception -> L10
        if ((r103 instanceof JSONObject) == false) goto L14;
        ((JSONObject) r103).put(r101, r102);     // Catch: Exception -> L10
        return;
    L14:
        return;
    L16:
        return;
    L15:
        return;
    }
}
