package y2;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public int f6891a = -1;
    public int b = -1;

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("start", this.f6891a);
            jSONObject.put("end", this.b);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
