package m2;

import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm6.monitor.Monitorable;
import org.json.JSONObject;
import r3.e;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Monitorable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f22055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f22056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f22057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f22058f;

    public a(String r10, int r11, JSONObject r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        this.f22053a = r10;
        this.f22054b = r11;
        this.f22055c = r12;
        this.f22056d = r13;
        this.f22057e = r14;
        this.f22058f = r15;
    }

    public void a() {
        this.f22055c = e.l(this.f22055c);
        this.f22056d = e.l(this.f22056d);
        this.f22057e = e.l(this.f22057e);
        this.f22058f = e.l(this.f22058f);
    }

    public JSONObject b() {
        return this.f22056d;
    }

    public JSONObject c() {
        return this.f22058f;
    }

    public JSONObject d() {
        return this.f22057e;
    }

    public String e() {
        return this.f22053a;
    }

    public int f() {
        return this.f22054b;
    }

    public JSONObject g() {
        return this.f22055c;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "service_monitor";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return !TextUtils.isEmpty(this.f22053a);
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
        JSONObject r10 = c();     // Catch: Exception -> L5
        if (r10 != null) goto L7;
        r10 = new JSONObject();     // Catch: Exception -> L5
    L7:
        r10.put("log_type", "service_monitor");     // Catch: Exception -> L5
        r10.put("service", e());     // Catch: Exception -> L5
        r10.put("status", f());     // Catch: Exception -> L5
        if (g() == null) goto L11;
        r10.put(CommonKey.KEY_VALUE, g());     // Catch: Exception -> L5
    L11:
        if (b() == null) goto L14;
        r10.put("category", b());     // Catch: Exception -> L5
    L14:
        if (d() == null) goto L16;
        r10.put(CommonKey.KEY_METRIC, d());     // Catch: Exception -> L5
    L16:
        return r10;
    L5:
        e = move-exception;
        if (r3.a.c() == false) goto L24;
        s3.a.g("APM-CommonEvent", "toJsonObject Error.", e);
        return null;
    L24:
        return null;
    }

    public String toString() {
        return "CommonEvent{serviceName='" + this.f22053a + "'}";
    }
}
