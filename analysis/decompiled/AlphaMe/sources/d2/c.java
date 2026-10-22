package d2;

import a2.AbstractC0155a;
import org.json.JSONException;
import org.json.JSONObject;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class c extends AbstractC0536a {

    /* renamed from: d, reason: collision with root package name */
    public String f12422d;

    /* renamed from: e, reason: collision with root package name */
    public int f12423e;

    /* renamed from: f, reason: collision with root package name */
    public String f12424f;

    public static c c(String str) {
        AbstractC0155a.a("BasicStatus", "string to register status start");
        AbstractC0155a.a("BasicStatus", "string to register status start: " + str);
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            AbstractC0536a.b(jSONObject, cVar);
            if (!jSONObject.isNull("push_id")) {
                cVar.f12422d = jSONObject.getString("push_id");
            }
            if (!jSONObject.isNull("expire_time")) {
                cVar.f12423e = jSONObject.getInt("expire_time");
            }
            if (!jSONObject.isNull("server")) {
                cVar.f12424f = jSONObject.getString("server");
            }
            AbstractC0155a.b("BasicStatus", "string to register status success, RegisterStatus: " + cVar);
            return cVar;
        } catch (JSONException e4) {
            AbstractC0155a.c("BasicStatus", "string to register status error, " + e4.getMessage());
            return null;
        }
    }

    @Override // d2.AbstractC0536a
    public final String toString() {
        StringBuilder sb = new StringBuilder("RegisterStatus(");
        sb.append(super.toString());
        sb.append(", pushId='");
        sb.append(this.f12422d);
        sb.append("', Become invalid after ");
        return AbstractC0831a.d(sb, this.f12423e, " seconds )");
    }
}
