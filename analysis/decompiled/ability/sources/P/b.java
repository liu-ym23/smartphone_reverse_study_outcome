package P;

import H.h;
import androidx.core.app.NotificationCompat;
import g1.AbstractC1451a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b implements N.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1054a;
    public final String b;
    public final JSONObject c;

    public /* synthetic */ b(int i, String str, JSONObject jSONObject) {
        this.f1054a = i;
        this.b = str;
        this.c = jSONObject;
    }

    @Override // N.b
    public final JSONObject a() {
        JSONObject jSONObject;
        switch (this.f1054a) {
            case 0:
                JSONObject jSONObject2 = this.c;
                if (jSONObject2 != null) {
                    try {
                        jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, this.b);
                        break;
                    } catch (JSONException unused) {
                        return jSONObject2;
                    }
                }
                break;
            default:
                jSONObject = this.c;
                if (jSONObject != null) {
                    try {
                        jSONObject.put("timestamp", System.currentTimeMillis());
                        jSONObject.put("crash_time", System.currentTimeMillis());
                        jSONObject.put("is_main_process", h.g());
                        jSONObject.put("process_name", h.c());
                        jSONObject.put("log_type", this.b);
                        break;
                    } catch (JSONException unused2) {
                        return jSONObject;
                    }
                }
                break;
        }
        return jSONObject;
    }

    @Override // N.b
    public final boolean b() {
        switch (this.f1054a) {
            case 0:
                return AbstractC1451a.f4474w.getLogTypeSwitch(this.b);
            default:
                return AbstractC1451a.f4474w.a(this.b);
        }
    }

    @Override // N.b
    public final String d() {
        switch (this.f1054a) {
            case 0:
                return "common_log";
            default:
                return this.b;
        }
    }

    @Override // N.b
    public final String g() {
        switch (this.f1054a) {
            case 0:
                return "common_log";
            default:
                return this.b;
        }
    }
}
