package v;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class h extends b {
    public int l;
    public String m;
    public boolean n;
    public String o;
    public int p;

    /* renamed from: q, reason: collision with root package name */
    public final JSONObject f6755q = new JSONObject();

    @Override // v.b
    public final b b(JSONObject jSONObject) {
        w.h.b(null);
        return null;
    }

    @Override // v.b
    public final void d(Cursor cursor) {
        super.d(cursor);
        this.m = cursor.getString(9);
        this.l = cursor.getInt(10);
        this.o = cursor.getString(11);
        this.p = cursor.getInt(12);
    }

    @Override // v.b
    public final List e() {
        List listE = super.e();
        ArrayList arrayList = new ArrayList(listE.size());
        arrayList.addAll(listE);
        arrayList.addAll(Arrays.asList("ver_name", "varchar", "ver_code", TypedValues.Custom.S_INT, "last_session", "varchar", "is_first_time", TypedValues.Custom.S_INT));
        return arrayList;
    }

    @Override // v.b
    public final void f(ContentValues contentValues) {
        super.f(contentValues);
        contentValues.put("ver_name", this.m);
        contentValues.put("ver_code", Integer.valueOf(this.l));
        contentValues.put("last_session", this.o);
        contentValues.put("is_first_time", Integer.valueOf(this.p));
    }

    @Override // v.b
    public final String k() {
        return this.n ? "bg" : "fg";
    }

    @Override // v.b
    public final String m() {
        return "launch";
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
        boolean z10 = this.n;
        if (z10) {
            jSONObject.put("is_background", z10);
        }
        jSONObject.put("datetime", this.f6752j);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("ab_sdk_version", this.h);
        }
        if (!TextUtils.isEmpty(this.o)) {
            jSONObject.put("uuid_changed", true);
            jSONObject.put("original_session_id", this.o);
        }
        if (this.p == 1) {
            jSONObject.put("$is_first_time", "true");
        }
        JSONObject jSONObject2 = this.f6755q;
        if (jSONObject2 != null) {
            jSONObject.put("pv_filters", jSONObject2);
        }
        return jSONObject;
    }
}
