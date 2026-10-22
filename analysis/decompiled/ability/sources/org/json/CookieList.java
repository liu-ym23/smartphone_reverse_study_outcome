package org.json;

import java.io.IOException;

/* loaded from: classes4.dex */
public class CookieList {
    public static JSONObject toJSONObject(String str) throws JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        JSONTokener jSONTokener = new JSONTokener(str);
        while (jSONTokener.more()) {
            String strUnescape = Cookie.unescape(jSONTokener.nextTo('='));
            jSONTokener.next('=');
            jSONObject.put(strUnescape, Cookie.unescape(jSONTokener.nextTo(';')));
            jSONTokener.next();
        }
        return jSONObject;
    }

    public static String toString(JSONObject jSONObject) throws JSONException {
        StringBuilder sb = new StringBuilder();
        boolean z10 = false;
        for (String str : jSONObject.keySet()) {
            Object objOpt = jSONObject.opt(str);
            if (!JSONObject.NULL.equals(objOpt)) {
                if (z10) {
                    sb.append(';');
                }
                sb.append(Cookie.escape(str));
                sb.append("=");
                sb.append(Cookie.escape(objOpt.toString()));
                z10 = true;
            }
        }
        return sb.toString();
    }
}
