package y7;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends l.b {

    /* renamed from: e, reason: collision with root package name */
    public String f14169e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public String f14170j;

    public static b g(String str) {
        s7.a.a("BasicStatus", "string to register status start");
        s7.a.a("BasicStatus", "string to register status start: " + str);
        try {
            b bVar = new b();
            JSONObject jSONObject = new JSONObject(str);
            l.b.d(jSONObject, bVar);
            if (!jSONObject.isNull("push_id")) {
                bVar.f14169e = jSONObject.getString("push_id");
            }
            if (!jSONObject.isNull("expire_time")) {
                bVar.h = jSONObject.getInt("expire_time");
            }
            if (!jSONObject.isNull("server")) {
                bVar.f14170j = jSONObject.getString("server");
            }
            s7.a.b("BasicStatus", "string to register status success, RegisterStatus: " + bVar);
            return bVar;
        } catch (JSONException e10) {
            s7.a.c("BasicStatus", "string to register status error, " + e10.getMessage());
            return null;
        }
    }

    @Override // l.b
    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RegisterStatus(");
        sb2.append(super.toString());
        sb2.append(", pushId='");
        sb2.append(this.f14169e);
        sb2.append("', Become invalid after ");
        return ai.onnxruntime.a.j(" seconds )", this.h, sb2);
    }
}
