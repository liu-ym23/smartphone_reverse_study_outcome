package y7;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends l.b {

    /* renamed from: e, reason: collision with root package name */
    public boolean f14167e;
    public boolean h;

    /* renamed from: j, reason: collision with root package name */
    public String f14168j;

    public static a g(String str) {
        s7.a.a("BasicStatus", "string to switch status start");
        s7.a.a("BasicStatus", "string to switch status start, statusText: " + str);
        try {
            a aVar = new a();
            JSONObject jSONObject = new JSONObject(str);
            l.b.d(jSONObject, aVar);
            if (!jSONObject.isNull("push_id")) {
                aVar.f14168j = jSONObject.getString("push_id");
            }
            if (!jSONObject.isNull("is_switch_notification")) {
                aVar.f14167e = jSONObject.getBoolean("is_switch_notification");
            }
            if (!jSONObject.isNull("is_switch_through")) {
                aVar.h = jSONObject.getBoolean("is_switch_through");
            }
            s7.a.b("BasicStatus", "string to switch status success, PushSwitchStatus: " + aVar);
            return aVar;
        } catch (JSONException e10) {
            s7.a.c("BasicStatus", "string to switch status error, " + e10.getMessage());
            return null;
        }
    }

    @Override // l.b
    public final String toString() {
        StringBuilder sb2 = new StringBuilder("PushSwitchStatus(");
        sb2.append(super.toString());
        sb2.append(", switchNotificationMessage=");
        sb2.append(this.f14167e);
        sb2.append(", switchThroughMessage=");
        sb2.append(this.h);
        sb2.append(", pushId=");
        return ai.onnxruntime.a.o(sb2, this.f14168j, " )");
    }
}
