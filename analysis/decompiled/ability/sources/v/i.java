package v;

import M9.y;
import a.AbstractC0291a;
import android.content.ContentValues;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import e2.C1404a;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class i extends b {
    public byte[] l;
    public int m;
    public JSONArray n;
    public long o;
    public JSONArray p;

    /* renamed from: q, reason: collision with root package name */
    public long f6756q;

    /* renamed from: r, reason: collision with root package name */
    public h f6757r;

    /* renamed from: s, reason: collision with root package name */
    public JSONArray f6758s;

    /* renamed from: t, reason: collision with root package name */
    public m f6759t;
    public JSONObject u;

    /* renamed from: v, reason: collision with root package name */
    public JSONArray f6760v;

    /* renamed from: w, reason: collision with root package name */
    public long f6761w;

    /* renamed from: x, reason: collision with root package name */
    public JSONArray f6762x;

    @Override // v.b
    public final b b(JSONObject jSONObject) {
        w.h.b(null);
        return null;
    }

    @Override // v.b
    public final void d(Cursor cursor) {
        this.f6751a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.l = cursor.getBlob(2);
        this.m = cursor.getInt(3);
        this.d = "";
        this.u = null;
        this.f6757r = null;
        this.f6759t = null;
        this.f6758s = null;
        this.n = null;
        this.p = null;
        this.f6760v = null;
        this.f6762x = null;
    }

    @Override // v.b
    public final List e() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "_data", "blob", "_fail", TypedValues.Custom.S_INT);
    }

    @Override // v.b
    public final void f(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.b));
        contentValues.put("_data", q());
    }

    @Override // v.b
    public final String k() {
        return String.valueOf(this.f6751a);
    }

    @Override // v.b
    public final String m() {
        return "pack";
    }

    @Override // v.b
    public final JSONObject o() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.u);
        jSONObject.put("time_sync", AbstractC0291a.g);
        jSONObject.put("local_time", System.currentTimeMillis() / 1000);
        if (this.f6757r != null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.f6757r.n());
            jSONObject.put("launch", jSONArray);
        }
        m mVar = this.f6759t;
        if (mVar != null) {
            JSONObject jSONObjectN = mVar.n();
            JSONArray jSONArray2 = this.f6758s;
            int length = jSONArray2 != null ? jSONArray2.length() : 0;
            JSONArray jSONArray3 = new JSONArray();
            for (int i = 0; i < length; i++) {
                JSONArray jSONArray4 = new JSONArray();
                JSONObject jSONObject2 = new JSONObject(new JSONObject(this.f6758s.optString(i)).optString("params"));
                jSONArray4.put(0, jSONObject2.optString("page_key", ""));
                jSONArray4.put(1, (jSONObject2.optInt(TypedValues.TransitionType.S_DURATION, 0) + 999) / 1000);
                jSONArray3.put(jSONArray4);
            }
            if (length > 0) {
                jSONObjectN.put("activites", jSONArray3);
            }
            int i6 = C1404a.e;
            if (i6 > 0) {
                jSONObjectN.put("launch_from", i6);
                C1404a.e = 0;
            }
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(jSONObjectN);
            jSONObject.put("terminate", jSONArray5);
        }
        JSONArray jSONArray6 = this.n;
        int length2 = jSONArray6 != null ? jSONArray6.length() : 0;
        if (length2 > 0) {
            jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.n);
        }
        JSONArray jSONArray7 = this.f6758s;
        int length3 = jSONArray7 != null ? jSONArray7.length() : 0;
        JSONArray jSONArray8 = this.p;
        int length4 = jSONArray8 != null ? jSONArray8.length() : 0;
        if (length4 > 0) {
            jSONObject.put("event_v3", this.p);
        }
        JSONArray jSONArray9 = this.f6760v;
        int length5 = jSONArray9 != null ? jSONArray9.length() : 0;
        if (length5 > 0) {
            jSONObject.put("log_data", this.f6760v);
        }
        JSONArray jSONArray10 = this.f6762x;
        int length6 = jSONArray10 != null ? jSONArray10.length() : 0;
        if (length6 > 0) {
            jSONObject.put("item_impression", this.f6762x);
        }
        StringBuilder sb = new StringBuilder("pack {ts:");
        sb.append(this.b);
        sb.append(", la:");
        Object obj = this.f6757r;
        if (obj == null) {
            obj = "0";
        }
        sb.append(obj);
        sb.append(", te:");
        m mVar2 = this.f6759t;
        sb.append(mVar2 != null ? mVar2 : "0");
        sb.append(", p:");
        sb.append(length3);
        sb.append(", v1:");
        androidx.constraintlayout.core.dsl.a.y(sb, length2, ", v3:", length4, ", m:");
        sb.append(length5);
        sb.append(", imp:");
        sb.append(length6);
        sb.append("}");
        w.h.a(sb.toString(), null);
        return jSONObject;
    }

    public final void p(JSONObject jSONObject, h hVar, m mVar, JSONArray jSONArray, JSONArray[] jSONArrayArr, long[] jArr, JSONArray jSONArray2) {
        c(0L);
        this.u = jSONObject;
        this.f6757r = hVar;
        this.f6759t = mVar;
        this.f6758s = jSONArray;
        this.n = jSONArrayArr[0];
        this.o = jArr[0];
        this.p = jSONArrayArr[1];
        this.f6756q = jArr[1];
        this.f6760v = jSONArrayArr[2];
        this.f6761w = jArr[2];
        this.f6762x = jSONArray2;
    }

    public final byte[] q() {
        this.l = null;
        try {
            byte[] bArrF = com.stepos.statsrpk.d.f(n().toString());
            this.l = bArrF;
            return bArrF;
        } catch (OutOfMemoryError e) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                y[] yVarArr = d.f;
                if (i >= yVarArr.length) {
                    throw new RuntimeException(sb.toString(), e);
                }
                y yVar = yVarArr[i];
                if (yVar != null) {
                    sb.append(yVar.toString());
                    sb.append(";");
                }
                i++;
            }
        }
    }
}
