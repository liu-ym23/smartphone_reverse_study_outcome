package v;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class j extends b {
    public long l;
    public String m;
    public String n;
    public int o;
    public String p;

    @Override // v.b
    public final b b(JSONObject jSONObject) {
        super.b(jSONObject);
        this.n = jSONObject.optString("page_key", null);
        this.m = jSONObject.optString("refer_page_key", null);
        this.l = jSONObject.optLong(TypedValues.TransitionType.S_DURATION, 0L);
        this.o = jSONObject.optInt("is_back", 0);
        return this;
    }

    @Override // v.b
    public final void d(Cursor cursor) {
        super.d(cursor);
        this.n = cursor.getString(9);
        this.m = cursor.getString(10);
        this.l = cursor.getLong(11);
        this.o = cursor.getInt(12);
        this.p = cursor.getString(13);
    }

    @Override // v.b
    public final List e() {
        List listE = super.e();
        ArrayList arrayList = new ArrayList(listE.size());
        arrayList.addAll(listE);
        arrayList.addAll(Arrays.asList("page_key", "varchar", "refer_page_key", "varchar", TypedValues.TransitionType.S_DURATION, TypedValues.Custom.S_INT, "is_back", TypedValues.Custom.S_INT, "last_session", "varchar"));
        return arrayList;
    }

    @Override // v.b
    public final void f(ContentValues contentValues) {
        super.f(contentValues);
        contentValues.put("page_key", this.n);
        contentValues.put("refer_page_key", this.m);
        contentValues.put(TypedValues.TransitionType.S_DURATION, Long.valueOf(this.l));
        contentValues.put("is_back", Integer.valueOf(this.o));
        contentValues.put("last_session", this.p);
    }

    @Override // v.b
    public final String k() {
        return this.n + ", " + this.l;
    }

    @Override // v.b
    public final String m() {
        return "page";
    }

    @Override // v.b
    public final JSONObject o() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("local_time_ms", this.b);
        jSONObject.put("tea_event_index", this.c);
        jSONObject.put("session_id", this.d);
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
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, "bav2b_page");
        jSONObject.put("is_bav", 1);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("page_key", this.n);
        jSONObject2.put("refer_page_key", this.m);
        jSONObject2.put("is_back", this.o);
        jSONObject2.put(TypedValues.TransitionType.S_DURATION, this.l);
        jSONObject.put("params", jSONObject2);
        jSONObject.put("datetime", this.f6752j);
        return jSONObject;
    }
}
