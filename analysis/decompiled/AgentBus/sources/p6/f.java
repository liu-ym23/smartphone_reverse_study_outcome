package p6;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class f extends g6.a {

    /* renamed from: e, reason: collision with root package name */
    public boolean f8499e;

    public static f i(String str) {
        j6.a.a("BasicStatus", "string to unregister status start");
        j6.a.a("BasicStatus", "string to unregister status start, statusText: " + str);
        try {
            f fVar = new f(1);
            JSONObject jSONObject = new JSONObject(str);
            g6.a.e(jSONObject, fVar);
            if (!jSONObject.isNull("is_unregister_success")) {
                fVar.f8499e = jSONObject.getBoolean("is_unregister_success");
            }
            j6.a.b("BasicStatus", "string to unregister status success, UnRegisterStatus=" + fVar);
            return fVar;
        } catch (JSONException e10) {
            j6.a.c("BasicStatus", "string to unregister status error, " + e10.getMessage());
            return null;
        }
    }

    @Override // g6.a
    public final String toString() {
        return "UnRegisterStatus(" + super.toString() + ", isUnRegisterSuccess=" + this.f8499e + ")";
    }
}
