package b67;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static void b(String r100) {
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L7
        r101.put("pkgName", r100);     // Catch: JSONException -> L7
        y57.a r102 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a.f266636b;     // Catch: JSONException -> L7
        if (r102 == null) goto L12;
        r102.onEvent("evaluate_jump_market", r101);     // Catch: JSONException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public static void a(String r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L7
        r102.put("trigger", r101);     // Catch: JSONException -> L7
        y57.a r103 = com.bytedance.praisedialoglib.manager.a.C3729a.f266645a.f266636b;     // Catch: JSONException -> L7
        if (r103 == null) goto L12;
        r103.onEvent(r100, r102);     // Catch: JSONException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }
}
