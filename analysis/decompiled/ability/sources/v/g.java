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
public final class g extends b {
    public String l;
    public boolean m = false;
    public String n;

    public g(String str, String str2) {
        this.n = str;
        this.l = str2;
    }

    @Override // v.b
    public final b b(JSONObject jSONObject) {
        super.b(jSONObject);
        this.n = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, null);
        this.l = jSONObject.optString("params", null);
        this.m = jSONObject.optBoolean("is_bav", false);
        return this;
    }

    @Override // v.b
    public final void d(Cursor cursor) {
        super.d(cursor);
        this.n = cursor.getString(9);
        this.l = cursor.getString(10);
        this.m = cursor.getInt(11) == 1;
    }

    @Override // v.b
    public final List e() {
        List listE = super.e();
        ArrayList arrayList = new ArrayList(listE.size());
        arrayList.addAll(listE);
        arrayList.addAll(Arrays.asList(NotificationCompat.CATEGORY_EVENT, "varchar", "params", "varchar", "is_bav", TypedValues.Custom.S_INT));
        return arrayList;
    }

    @Override // v.b
    public final void f(ContentValues contentValues) {
        super.f(contentValues);
        contentValues.put(NotificationCompat.CATEGORY_EVENT, this.n);
        contentValues.put("params", this.l);
        contentValues.put("is_bav", Integer.valueOf(this.m ? 1 : 0));
    }

    @Override // v.b
    public final String h() {
        return this.l;
    }

    @Override // v.b
    public final String k() {
        return this.n;
    }

    @Override // v.b
    public final String m() {
        return "eventv3";
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
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.n);
        if (this.m) {
            jSONObject.put("is_bav", 1);
        }
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
