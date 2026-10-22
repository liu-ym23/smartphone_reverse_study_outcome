package P;

import android.net.Uri;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a implements N.b {

    /* renamed from: a, reason: collision with root package name */
    public long f1053a;
    public long b;
    public String c;
    public String d;
    public int e;
    public JSONObject f;

    @Override // N.b
    public final JSONObject a() {
        String str = this.d;
        if (TextUtils.isEmpty("network")) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", "network");
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, "network");
            jSONObject.put(TypedValues.TransitionType.S_DURATION, this.f1053a);
            jSONObject.put("uri", Uri.parse(this.c));
            long j5 = this.b;
            if (j5 > 0) {
                jSONObject.put("timestamp", j5);
            }
            jSONObject.put("status", this.e);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("ip", str);
            }
            if (TextUtils.isEmpty("")) {
                jSONObject.put("trace_code", "");
                return jSONObject;
            }
            jSONObject.put("trace_code", "");
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // N.b
    public final boolean b() {
        return false;
    }

    @Override // N.b
    public final String d() {
        return null;
    }

    @Override // N.b
    public final String g() {
        return null;
    }
}
