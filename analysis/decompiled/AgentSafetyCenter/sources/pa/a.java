package pa;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f9926a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9927b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9928c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9929d;

    public a(String str, boolean z10, boolean z11, boolean z12) {
        this.f9926a = str;
        this.f9927b = z10;
        this.f9928c = z11;
        this.f9929d = z12;
    }

    public final String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("e_name", this.f9926a);
            jSONObject.put("e_active", this.f9927b);
            jSONObject.put("e_realtime", this.f9928c);
            jSONObject.put("e_neartime", this.f9929d);
            return jSONObject.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
