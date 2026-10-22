package m3;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static JSONObject a(JSONObject r10, String r11) {
        if (r10 != null) goto L8;
        return null;
    L8:
        return r10.optJSONObject("performance_modules").optJSONObject(r11);
    L7:
        return null;
    }
}
