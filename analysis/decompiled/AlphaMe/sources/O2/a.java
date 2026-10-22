package O2;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f1538a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1539b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1540c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1541d;

    public a(String str, boolean z4, boolean z5, boolean z6) {
        this.f1538a = str;
        this.f1539b = z4;
        this.f1540c = z5;
        this.f1541d = z6;
    }

    public final String toString() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("e_name", this.f1538a);
            jSONObject.put("e_active", this.f1539b);
            jSONObject.put("e_realtime", this.f1540c);
            jSONObject.put("e_neartime", this.f1541d);
            return jSONObject.toString();
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
