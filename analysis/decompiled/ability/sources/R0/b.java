package R0;

import android.text.TextUtils;
import android.util.Log;
import g1.AbstractC1451a;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b implements N0.b {

    /* renamed from: a, reason: collision with root package name */
    public final String f1138a;
    public final JSONObject b;

    public b(String str, JSONObject jSONObject) {
        this.f1138a = str;
        this.b = jSONObject;
    }

    @Override // N0.b
    public final boolean a() {
        return !TextUtils.isEmpty(this.f1138a);
    }

    @Override // N0.b
    public final JSONObject b() {
        try {
            JSONObject jSONObject = this.b;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jSONObject.put("log_type", this.f1138a);
            return jSONObject;
        } catch (Exception e) {
            boolean z10 = AbstractC1451a.f4467a;
            if (!z10 || !z10) {
                return null;
            }
            Log.w("APM-CommonEvent", "toJsonObject Error.", e);
            return null;
        }
    }

    @Override // N0.b
    public final String c() {
        return this.f1138a;
    }

    public final String toString() {
        return B7.a.q(new StringBuilder("Apm5LegacyEvent{logType='"), this.f1138a, "'}");
    }
}
