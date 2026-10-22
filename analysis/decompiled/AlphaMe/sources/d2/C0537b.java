package d2;

import a2.AbstractC0155a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: d2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0537b extends AbstractC0536a {

    /* renamed from: d, reason: collision with root package name */
    public boolean f12419d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12420e;

    /* renamed from: f, reason: collision with root package name */
    public String f12421f;

    public static C0537b c(String str) {
        AbstractC0155a.a("BasicStatus", "string to switch status start");
        AbstractC0155a.a("BasicStatus", "string to switch status start, statusText: " + str);
        try {
            C0537b c0537b = new C0537b();
            JSONObject jSONObject = new JSONObject(str);
            AbstractC0536a.b(jSONObject, c0537b);
            if (!jSONObject.isNull("push_id")) {
                c0537b.f12421f = jSONObject.getString("push_id");
            }
            if (!jSONObject.isNull("is_switch_notification")) {
                c0537b.f12419d = jSONObject.getBoolean("is_switch_notification");
            }
            if (!jSONObject.isNull("is_switch_through")) {
                c0537b.f12420e = jSONObject.getBoolean("is_switch_through");
            }
            AbstractC0155a.b("BasicStatus", "string to switch status success, PushSwitchStatus: " + c0537b);
            return c0537b;
        } catch (JSONException e4) {
            AbstractC0155a.c("BasicStatus", "string to switch status error, " + e4.getMessage());
            return null;
        }
    }

    @Override // d2.AbstractC0536a
    public final String toString() {
        StringBuilder sb = new StringBuilder("PushSwitchStatus(");
        sb.append(super.toString());
        sb.append(", switchNotificationMessage=");
        sb.append(this.f12419d);
        sb.append(", switchThroughMessage=");
        sb.append(this.f12420e);
        sb.append(", pushId=");
        return B0.g.r(sb, this.f12421f, " )");
    }
}
