package d2;

import a2.AbstractC0155a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class g extends AbstractC0536a {

    /* renamed from: d, reason: collision with root package name */
    public boolean f12431d;

    public static g c(String str) {
        AbstractC0155a.a("BasicStatus", "string to unregister status start");
        AbstractC0155a.a("BasicStatus", "string to unregister status start, statusText: " + str);
        try {
            g gVar = new g();
            JSONObject jSONObject = new JSONObject(str);
            AbstractC0536a.b(jSONObject, gVar);
            if (!jSONObject.isNull("is_unregister_success")) {
                gVar.f12431d = jSONObject.getBoolean("is_unregister_success");
            }
            AbstractC0155a.b("BasicStatus", "string to unregister status success, UnRegisterStatus=" + gVar);
            return gVar;
        } catch (JSONException e4) {
            AbstractC0155a.c("BasicStatus", "string to unregister status error, " + e4.getMessage());
            return null;
        }
    }

    @Override // d2.AbstractC0536a
    public final String toString() {
        return "UnRegisterStatus(" + super.toString() + ", isUnRegisterSuccess=" + this.f12431d + ")";
    }
}
