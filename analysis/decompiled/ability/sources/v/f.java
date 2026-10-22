package v;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f extends b {
    public String l;
    public String m;

    @Override // v.b
    public final b b(JSONObject jSONObject) {
        super.b(jSONObject);
        this.l = jSONObject.optString("params", null);
        this.m = jSONObject.optString("log_type", null);
        return this;
    }

    @Override // v.b
    public final void d(Cursor cursor) {
        super.d(cursor);
        this.l = cursor.getString(9);
        this.m = cursor.getString(10);
    }

    @Override // v.b
    public final List e() {
        List listE = super.e();
        ArrayList arrayList = new ArrayList(listE.size());
        arrayList.addAll(listE);
        arrayList.addAll(Arrays.asList("params", "varchar", "log_type", "varchar"));
        return arrayList;
    }

    @Override // v.b
    public final void f(ContentValues contentValues) {
        super.f(contentValues);
        contentValues.put("params", this.l);
        contentValues.put("log_type", this.m);
    }

    @Override // v.b
    public final String h() {
        return this.l;
    }

    @Override // v.b
    public final String k() {
        StringBuilder sbF = M.a.f("param:");
        sbF.append(this.l);
        sbF.append(" logType:");
        sbF.append(this.m);
        return sbF.toString();
    }

    @Override // v.b
    public final String m() {
        return "event_misc";
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
        jSONObject.put("log_type", this.m);
        try {
            JSONObject jSONObject2 = new JSONObject(this.l);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject2.get(next);
                if (jSONObject.opt(next) != null) {
                    w.h.a("misc事件存在重复的key", null);
                }
                jSONObject.put(next, obj);
            }
            return jSONObject;
        } catch (Exception e) {
            w.h.a("解析 event misc 失败", e);
            return jSONObject;
        }
    }
}
