package p6;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c extends g6.a {

    /* renamed from: e, reason: collision with root package name */
    public String f8493e;

    /* renamed from: f, reason: collision with root package name */
    public String f8494f;

    public static c i(String str) {
        j6.a.a("BasicStatus", "string to sub alias status start");
        j6.a.a("BasicStatus", "string to sub alias status start, statusText: " + str);
        try {
            c cVar = new c(1);
            JSONObject jSONObject = new JSONObject(str);
            g6.a.e(jSONObject, cVar);
            if (!jSONObject.isNull("push_id")) {
                cVar.f8493e = jSONObject.getString("push_id");
            }
            if (!jSONObject.isNull("alias")) {
                cVar.f8494f = jSONObject.getString("alias");
            }
            j6.a.b("BasicStatus", "string to sub alias status start success, SubAliasStatus: " + cVar);
            return cVar;
        } catch (JSONException e10) {
            j6.a.c("BasicStatus", "string to sub alias status start error, " + e10.getMessage());
            return null;
        }
    }

    @Override // g6.a
    public final String toString() {
        StringBuilder sb2 = new StringBuilder("SubAliasStatus(");
        sb2.append(super.toString());
        sb2.append(", pushId=");
        sb2.append(this.f8493e);
        sb2.append(", alias=");
        return a1.a.m(sb2, this.f8494f, ")");
    }
}
