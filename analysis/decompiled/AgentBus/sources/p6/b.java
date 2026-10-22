package p6;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b extends g6.a {

    /* renamed from: e, reason: collision with root package name */
    public String f8490e;

    /* renamed from: f, reason: collision with root package name */
    public int f8491f;

    /* renamed from: g, reason: collision with root package name */
    public String f8492g;

    public static b i(String str) {
        j6.a.a("BasicStatus", "string to register status start");
        j6.a.a("BasicStatus", "string to register status start: " + str);
        try {
            b bVar = new b(1);
            JSONObject jSONObject = new JSONObject(str);
            g6.a.e(jSONObject, bVar);
            if (!jSONObject.isNull("push_id")) {
                bVar.f8490e = jSONObject.getString("push_id");
            }
            if (!jSONObject.isNull("expire_time")) {
                bVar.f8491f = jSONObject.getInt("expire_time");
            }
            if (!jSONObject.isNull("server")) {
                bVar.f8492g = jSONObject.getString("server");
            }
            j6.a.b("BasicStatus", "string to register status success, RegisterStatus: " + bVar);
            return bVar;
        } catch (JSONException e10) {
            j6.a.c("BasicStatus", "string to register status error, " + e10.getMessage());
            return null;
        }
    }

    @Override // g6.a
    public final String toString() {
        return "RegisterStatus(" + super.toString() + ", pushId='" + this.f8490e + "', Become invalid after " + this.f8491f + " seconds )";
    }
}
