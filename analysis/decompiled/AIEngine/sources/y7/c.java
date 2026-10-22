package y7;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends l.b {

    /* renamed from: e, reason: collision with root package name */
    public String f14171e;
    public String h;

    public static c g(String str) {
        s7.a.a("BasicStatus", "string to sub alias status start");
        s7.a.a("BasicStatus", "string to sub alias status start, statusText: " + str);
        try {
            c cVar = new c();
            JSONObject jSONObject = new JSONObject(str);
            l.b.d(jSONObject, cVar);
            if (!jSONObject.isNull("push_id")) {
                cVar.f14171e = jSONObject.getString("push_id");
            }
            if (!jSONObject.isNull("alias")) {
                cVar.h = jSONObject.getString("alias");
            }
            s7.a.b("BasicStatus", "string to sub alias status start success, SubAliasStatus: " + cVar);
            return cVar;
        } catch (JSONException e10) {
            s7.a.c("BasicStatus", "string to sub alias status start error, " + e10.getMessage());
            return null;
        }
    }

    @Override // l.b
    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SubAliasStatus(");
        sb2.append(super.toString());
        sb2.append(", pushId=");
        sb2.append(this.f14171e);
        sb2.append(", alias=");
        return ai.onnxruntime.a.o(sb2, this.h, ")");
    }
}
