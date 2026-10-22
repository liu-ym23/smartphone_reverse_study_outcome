package v;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class m extends b {
    public long l;
    public long m;
    public String n;

    @Override // v.b
    public final b b(JSONObject jSONObject) {
        w.h.b(null);
        return this;
    }

    @Override // v.b
    public final void d(Cursor cursor) {
        w.h.b(null);
    }

    @Override // v.b
    public final List e() {
        return null;
    }

    @Override // v.b
    public final void f(ContentValues contentValues) {
        w.h.b(null);
    }

    @Override // v.b
    public final String k() {
        return String.valueOf(this.l);
    }

    @Override // v.b
    public final String m() {
        return "terminate";
    }

    @Override // v.b
    public final JSONObject o() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.b);
        jSONObject.put("tea_event_index", this.c);
        jSONObject.put("session_id", this.d);
        jSONObject.put("stop_timestamp", this.m / 1000);
        jSONObject.put(TypedValues.TransitionType.S_DURATION, this.l / 1000);
        jSONObject.put("datetime", this.f6752j);
        long j5 = this.e;
        if (j5 > 0) {
            jSONObject.put("user_id", j5);
        }
        if (!TextUtils.isEmpty(this.f)) {
            jSONObject.put("user_unique_id", this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            jSONObject.put("ssid", this.g);
        }
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("ab_sdk_version", this.h);
        }
        if (!TextUtils.isEmpty(this.n)) {
            jSONObject.put("uuid_changed", true);
            if (!TextUtils.equals(this.n, this.d)) {
                jSONObject.put("original_session_id", this.n);
            }
        }
        return jSONObject;
    }
}
