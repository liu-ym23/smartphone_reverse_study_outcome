package R0;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c implements N0.b {

    /* renamed from: a, reason: collision with root package name */
    public JSONArray f1139a;

    @Override // N0.b
    public final boolean a() {
        return true;
    }

    @Override // N0.b
    public final JSONObject b() {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("wrapper_array_data", this.f1139a);
            jSONObjectPut.put("log_type", "tracing");
            jSONObjectPut.put("wrapper_type_description", 1);
            return jSONObjectPut;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // N0.b
    public final String c() {
        return "tracing";
    }
}
