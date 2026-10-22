package y7;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends l.b {

    /* renamed from: e, reason: collision with root package name */
    public boolean f14175e;

    public static e g(String str) {
        s7.a.a("BasicStatus", "string to unregister status start");
        s7.a.a("BasicStatus", "string to unregister status start, statusText: " + str);
        try {
            e eVar = new e();
            JSONObject jSONObject = new JSONObject(str);
            l.b.d(jSONObject, eVar);
            if (!jSONObject.isNull("is_unregister_success")) {
                eVar.f14175e = jSONObject.getBoolean("is_unregister_success");
            }
            s7.a.b("BasicStatus", "string to unregister status success, UnRegisterStatus=" + eVar);
            return eVar;
        } catch (JSONException e10) {
            s7.a.c("BasicStatus", "string to unregister status error, " + e10.getMessage());
            return null;
        }
    }

    @Override // l.b
    public final String toString() {
        StringBuilder sb2 = new StringBuilder("UnRegisterStatus(");
        sb2.append(super.toString());
        sb2.append(", isUnRegisterSuccess=");
        return a0.a.m(sb2, this.f14175e, ")");
    }
}
