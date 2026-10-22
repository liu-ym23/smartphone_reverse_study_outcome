package w9;

import android.text.TextUtils;
import org.json.JSONObject;
import w0.c;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f25388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f25389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f25390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f25391f;

    public a() {
    }

    public static a a(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L16;
        return null;
    L16:
        a r11 = new a();     // Catch: Exception -> L8
        JSONObject r12 = new JSONObject(r10);     // Catch: Exception -> L8
        r11.f25389d = r12.optString("command_id");     // Catch: Exception -> L8
        r11.f25387b = r12.optString("type");     // Catch: Exception -> L8
        String r13 = r12.optString("params");     // Catch: Exception -> L8
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r13) == true) goto L10;
        r14 = new JSONObject(r13);     // Catch: Exception -> L8
    L10:
        r11.f25386a = r13;     // Catch: Exception -> L8
        r11.f25390e = r14;     // Catch: Exception -> L8
        r11.f25391f = r10;     // Catch: Exception -> L8
        return r11;
    L8:
        e = move-exception;
        if (c.B() == false) goto L15;
        s1.c.f("cloudmessage", e, new String[]{"Parse CloudMessage Error."});
    L15:
        return null;
    }

    public String b() {
        return this.f25389d;
    }

    public String c() {
        return this.f25386a;
    }

    public JSONObject d() {
        return this.f25390e;
    }

    public String e() {
        return this.f25387b;
    }

    public boolean f() {
        return this.f25390e.optBoolean("wifiOnly");
    }

    public String toString() {
        return "CloudMessage{mParams='" + this.f25386a + "', mType=" + this.f25387b + ", send_time=" + this.f25388c + ", command_id='" + this.f25389d + "'}";
    }
}
