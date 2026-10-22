package v;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e extends b {
    public String l;
    public String m;
    public String n;
    public String o;
    public long p;

    /* renamed from: q, reason: collision with root package name */
    public long f6754q;

    @Override // v.b
    public final b b(JSONObject jSONObject) {
        super.b(jSONObject);
        this.c = jSONObject.optLong("tea_event_index", 0L);
        this.l = jSONObject.optString(QueryAlgorithmBundle.KEY_CATEGORY, null);
        this.m = jSONObject.optString("tag", null);
        this.p = jSONObject.optLong("value", 0L);
        this.f6754q = jSONObject.optLong("ext_value", 0L);
        this.o = jSONObject.optString("params", null);
        this.n = jSONObject.optString("label", null);
        return this;
    }

    @Override // v.b
    public final void d(Cursor cursor) {
        super.d(cursor);
        this.l = cursor.getString(9);
        this.m = cursor.getString(10);
        this.p = cursor.getLong(11);
        this.f6754q = cursor.getLong(12);
        this.o = cursor.getString(13);
        this.n = cursor.getString(14);
    }

    @Override // v.b
    public final List e() {
        List listE = super.e();
        ArrayList arrayList = new ArrayList(listE.size());
        arrayList.addAll(listE);
        arrayList.addAll(Arrays.asList(QueryAlgorithmBundle.KEY_CATEGORY, "varchar", "tag", "varchar", "value", TypedValues.Custom.S_INT, "ext_value", TypedValues.Custom.S_INT, "params", "varchar", "label", "varchar"));
        return arrayList;
    }

    @Override // v.b
    public final void f(ContentValues contentValues) {
        super.f(contentValues);
        contentValues.put(QueryAlgorithmBundle.KEY_CATEGORY, this.l);
        contentValues.put("tag", this.m);
        contentValues.put("value", Long.valueOf(this.p));
        contentValues.put("ext_value", Long.valueOf(this.f6754q));
        contentValues.put("params", this.o);
        contentValues.put("label", this.n);
    }

    @Override // v.b
    public final String h() {
        return this.o;
    }

    @Override // v.b
    public final String k() {
        StringBuilder sbF = M.a.f("");
        sbF.append(this.m);
        sbF.append(", ");
        sbF.append(this.n);
        return sbF.toString();
    }

    @Override // v.b
    public final String m() {
        return NotificationCompat.CATEGORY_EVENT;
    }

    @Override // v.b
    public final JSONObject o() throws JSONException {
        JSONObject jSONObject = !TextUtils.isEmpty(this.o) ? new JSONObject(this.o) : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        jSONObject.put("local_time_ms", this.b);
        jSONObject.put("tea_event_index", this.c);
        jSONObject.put("session_id", this.d);
        long j5 = this.e;
        if (j5 > 0) {
            jSONObject.put("user_id", j5);
        }
        int i = this.i;
        if (i != -1) {
            jSONObject.put("nt", i);
        }
        if (!TextUtils.isEmpty(this.f)) {
            jSONObject.put("user_unique_id", this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            jSONObject.put("ssid", this.g);
        }
        jSONObject.put(QueryAlgorithmBundle.KEY_CATEGORY, this.l);
        jSONObject.put("tag", this.m);
        jSONObject.put("value", this.p);
        jSONObject.put("ext_value", this.f6754q);
        jSONObject.put("label", this.n);
        jSONObject.put("datetime", this.f6752j);
        if (!TextUtils.isEmpty(this.h)) {
            jSONObject.put("ab_sdk_version", this.h);
        }
        return jSONObject;
    }
}
