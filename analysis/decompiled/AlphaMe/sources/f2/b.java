package f2;

import B0.g;
import a2.AbstractC0155a;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public int f12542a;

    /* renamed from: b, reason: collision with root package name */
    public String f12543b;

    /* renamed from: c, reason: collision with root package name */
    public String f12544c;

    public static b a(String str) throws JSONException {
        b bVar = new b();
        bVar.f12542a = 0;
        try {
        } catch (Exception e4) {
            AbstractC0155a.c("NotificationCoreData", "create error " + e4.getMessage());
        }
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        JSONObject jSONObject = new JSONObject(str).getJSONObject("data").getJSONObject("extra");
        bVar.f12544c = jSONObject.getString("se");
        if (jSONObject.has("no")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("no");
            bVar.f12542a = jSONObject2.optInt("ni");
            bVar.f12543b = jSONObject2.optString("nk");
        }
        AbstractC0155a.b("NotificationCoreData", "current notify option is " + bVar);
        return bVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NotificationCoreData(notifyId=");
        sb.append(this.f12542a);
        sb.append(", notifyKey=");
        sb.append(this.f12543b);
        sb.append(", securityEncryption=");
        return g.r(sb, this.f12544c, ")");
    }
}
