package R5;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f1152a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    public a(String str, boolean z10, boolean z11, boolean z12) {
        this.f1152a = str;
        this.b = z10;
        this.c = z11;
        this.d = z12;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("e_name", this.f1152a);
            jSONObject.put("e_active", this.b);
            jSONObject.put("e_realtime", this.c);
            jSONObject.put("e_neartime", this.d);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
