package v;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class b implements Cloneable {
    public static final SimpleDateFormat k = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /* renamed from: a, reason: collision with root package name */
    public long f6751a;
    public long b;
    public long c;
    public String d;
    public long e;
    public String f;
    public String g;
    public String h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public String f6752j;

    public b() {
        c(0L);
    }

    public final String a() {
        List listE = e();
        if (listE == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("create table if not exists ");
        sb.append(m());
        sb.append("(");
        for (int i = 0; i < listE.size(); i += 2) {
            sb.append((String) listE.get(i));
            sb.append(" ");
            sb.append((String) listE.get(i + 1));
            sb.append(",");
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append(")");
        return sb.toString();
    }

    public b b(JSONObject jSONObject) {
        this.b = jSONObject.optLong("local_time_ms", 0L);
        this.f6751a = 0L;
        this.c = 0L;
        this.i = 0;
        this.e = 0L;
        this.d = null;
        this.f = null;
        this.g = null;
        this.h = null;
        return this;
    }

    public final void c(long j5) {
        if (j5 == 0) {
            j5 = System.currentTimeMillis();
        }
        this.b = j5;
    }

    public void d(Cursor cursor) {
        this.f6751a = cursor.getLong(0);
        this.b = cursor.getLong(1);
        this.c = cursor.getLong(2);
        this.i = cursor.getInt(3);
        this.e = cursor.getLong(4);
        this.d = cursor.getString(5);
        this.f = cursor.getString(6);
        this.g = cursor.getString(7);
        this.h = cursor.getString(8);
    }

    public List e() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "tea_event_index", TypedValues.Custom.S_INT, "nt", TypedValues.Custom.S_INT, "user_id", TypedValues.Custom.S_INT, "session_id", "varchar", "user_unique_id", "varchar", "ssid", "varchar", "ab_sdk_version", "varchar");
    }

    public void f(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.b));
        contentValues.put("tea_event_index", Long.valueOf(this.c));
        contentValues.put("nt", Integer.valueOf(this.i));
        contentValues.put("user_id", Long.valueOf(this.e));
        contentValues.put("session_id", this.d);
        contentValues.put("user_unique_id", this.f);
        contentValues.put("ssid", this.g);
        contentValues.put("ab_sdk_version", this.h);
    }

    public String h() {
        return null;
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final b clone() {
        try {
            return (b) super.clone();
        } catch (CloneNotSupportedException e) {
            w.h.b(e);
            return null;
        }
    }

    public abstract String k();

    public abstract String m();

    public final JSONObject n() {
        try {
            this.f6752j = k.format(new Date(this.b));
            return o();
        } catch (JSONException e) {
            w.h.b(e);
            return null;
        }
    }

    public abstract JSONObject o();

    public final String toString() {
        String strM = m();
        if (!getClass().getSimpleName().equalsIgnoreCase(strM)) {
            StringBuilder sbX = androidx.appfunctions.metadata.a.x(strM, ", ");
            sbX.append(getClass().getSimpleName());
            strM = sbX.toString();
        }
        String strSubstring = this.d;
        if (strSubstring != null) {
            int iIndexOf = strSubstring.indexOf("-");
            if (iIndexOf >= 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
        } else {
            strSubstring = "-";
        }
        StringBuilder sbV = B7.a.v("{", strM, ", ");
        sbV.append(k());
        sbV.append(", ");
        sbV.append(strSubstring);
        sbV.append(", ");
        return androidx.constraintlayout.core.dsl.a.e(this.b, "}", sbV);
    }
}
