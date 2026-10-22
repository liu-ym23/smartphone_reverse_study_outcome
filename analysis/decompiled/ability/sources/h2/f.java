package h2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public long f4557a;
    public long b;
    public long c;
    public int d;
    public int e;
    public long f;
    public long g;
    public String h;

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, g.a(this.h));
            jSONObject.put("cpuDuration", this.g);
            jSONObject.put(TypedValues.TransitionType.S_DURATION, this.f);
            jSONObject.put("type", this.d);
            jSONObject.put("count", this.e);
            jSONObject.put("messageCount", this.e);
            jSONObject.put("lastDuration", this.b - this.c);
            jSONObject.put("start", this.f4557a);
            jSONObject.put("end", this.b);
            jSONObject.put("block_uuid", (Object) null);
            jSONObject.put("sblock_uuid", (Object) null);
            jSONObject.put("belong_frame", false);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
