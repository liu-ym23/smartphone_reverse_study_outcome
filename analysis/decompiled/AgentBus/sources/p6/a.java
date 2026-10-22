package p6;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a extends g6.a {

    /* renamed from: e, reason: collision with root package name */
    public boolean f8487e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8488f;

    /* renamed from: g, reason: collision with root package name */
    public String f8489g;

    public static a i(String str) {
        j6.a.a("BasicStatus", "string to switch status start");
        j6.a.a("BasicStatus", "string to switch status start, statusText: " + str);
        try {
            a aVar = new a(1);
            JSONObject jSONObject = new JSONObject(str);
            g6.a.e(jSONObject, aVar);
            if (!jSONObject.isNull("push_id")) {
                aVar.f8489g = jSONObject.getString("push_id");
            }
            if (!jSONObject.isNull("is_switch_notification")) {
                aVar.f8487e = jSONObject.getBoolean("is_switch_notification");
            }
            if (!jSONObject.isNull("is_switch_through")) {
                aVar.f8488f = jSONObject.getBoolean("is_switch_through");
            }
            j6.a.b("BasicStatus", "string to switch status success, PushSwitchStatus: " + aVar);
            return aVar;
        } catch (JSONException e10) {
            j6.a.c("BasicStatus", "string to switch status error, " + e10.getMessage());
            return null;
        }
    }

    @Override // g6.a
    public final String toString() {
        StringBuilder sb2 = new StringBuilder("PushSwitchStatus(");
        sb2.append(super.toString());
        sb2.append(", switchNotificationMessage=");
        sb2.append(this.f8487e);
        sb2.append(", switchThroughMessage=");
        sb2.append(this.f8488f);
        sb2.append(", pushId=");
        return a1.a.m(sb2, this.f8489g, " )");
    }
}
