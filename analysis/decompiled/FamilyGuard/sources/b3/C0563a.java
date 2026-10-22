package b3;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: b3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0563a {

    /* renamed from: a, reason: collision with root package name */
    private String f11813a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f11814b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f11815c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11816d;

    public C0563a(String str, boolean z5, boolean z6, boolean z7) {
        this.f11813a = str;
        this.f11814b = z5;
        this.f11815c = z6;
        this.f11816d = z7;
    }

    public static C0563a a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new C0563a(jSONObject.getString("e_name"), jSONObject.getBoolean("e_active"), jSONObject.getBoolean("e_realtime"), jSONObject.getBoolean("e_neartime"));
        } catch (JSONException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public String b() {
        return this.f11813a;
    }

    public boolean c() {
        return this.f11814b;
    }

    public boolean d() {
        return this.f11816d;
    }

    public boolean e() {
        return this.f11815c;
    }

    public String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("e_name", this.f11813a);
            jSONObject.put("e_active", this.f11814b);
            jSONObject.put("e_realtime", this.f11815c);
            jSONObject.put("e_neartime", this.f11816d);
            return jSONObject.toString();
        } catch (JSONException e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
