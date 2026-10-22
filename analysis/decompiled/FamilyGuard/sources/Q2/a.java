package Q2;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f4905a = false;

    /* renamed from: b, reason: collision with root package name */
    public static String f4906b = "";

    /* renamed from: c, reason: collision with root package name */
    public static boolean f4907c = false;

    public a a(boolean z5) {
        return this;
    }

    public a b(boolean z5) {
        f4907c = z5;
        return this;
    }

    public String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("noBootUp", f4905a);
            jSONObject.put("replacePackage", f4906b);
            jSONObject.put("printLog", f4907c);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        return jSONObject.toString();
    }
}
