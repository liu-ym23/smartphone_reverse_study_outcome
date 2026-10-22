package v;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class k extends b {
    public String l;
    public String m;

    @Override // v.b
    public final b b(JSONObject jSONObject) {
        super.b(jSONObject);
        this.m = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null);
        this.l = jSONObject.optString("params", null);
        return this;
    }

    @Override // v.b
    public final void d(Cursor cursor) {
        super.d(cursor);
        this.m = cursor.getString(9);
        this.l = cursor.getString(10);
    }

    @Override // v.b
    public final List e() {
        List listE = super.e();
        ArrayList arrayList = new ArrayList(listE.size());
        arrayList.addAll(listE);
        arrayList.addAll(Arrays.asList(NotificationCompat.CATEGORY_EVENT, "varchar", "params", "varchar"));
        return arrayList;
    }

    @Override // v.b
    public final void f(ContentValues contentValues) {
        super.f(contentValues);
        contentValues.put(NotificationCompat.CATEGORY_EVENT, this.m);
        contentValues.put("params", this.l);
    }

    @Override // v.b
    public final String h() {
        return this.l;
    }

    @Override // v.b
    public final String k() {
        return this.m;
    }

    @Override // v.b
    public final String m() {
        return "profile";
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
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.m);
        if (!TextUtils.isEmpty(this.l)) {
            jSONObject.put("params", new JSONObject(this.l));
        }
        int i = this.i;
        if (i != -1) {
            jSONObject.put("nt", i);
        }
        jSONObject.put("datetime", this.f6752j);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("ab_sdk_version", this.h);
        }
        return jSONObject;
    }
}
