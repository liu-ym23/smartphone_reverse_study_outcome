package d2;

import a2.AbstractC0155a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d extends AbstractC0536a {

    /* renamed from: d, reason: collision with root package name */
    public String f12425d;

    /* renamed from: e, reason: collision with root package name */
    public String f12426e;

    public static d c(String str) {
        AbstractC0155a.a("BasicStatus", "string to sub alias status start");
        AbstractC0155a.a("BasicStatus", "string to sub alias status start, statusText: " + str);
        try {
            d dVar = new d();
            JSONObject jSONObject = new JSONObject(str);
            AbstractC0536a.b(jSONObject, dVar);
            if (!jSONObject.isNull("push_id")) {
                dVar.f12425d = jSONObject.getString("push_id");
            }
            if (!jSONObject.isNull("alias")) {
                dVar.f12426e = jSONObject.getString("alias");
            }
            AbstractC0155a.b("BasicStatus", "string to sub alias status start success, SubAliasStatus: " + dVar);
            return dVar;
        } catch (JSONException e4) {
            AbstractC0155a.c("BasicStatus", "string to sub alias status start error, " + e4.getMessage());
            return null;
        }
    }

    @Override // d2.AbstractC0536a
    public final String toString() {
        StringBuilder sb = new StringBuilder("SubAliasStatus(");
        sb.append(super.toString());
        sb.append(", pushId=");
        sb.append(this.f12425d);
        sb.append(", alias=");
        return B0.g.r(sb, this.f12426e, ")");
    }
}
