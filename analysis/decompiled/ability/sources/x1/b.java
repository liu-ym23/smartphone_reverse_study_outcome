package x1;

import android.content.ContentValues;
import android.database.Cursor;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import m0.C1667a;
import m0.C1669c;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b extends a {
    public final /* synthetic */ int h;

    public b(int i) {
        this.h = i;
        this.f = -1L;
    }

    @Override // w1.a
    public final Object a(O2.a aVar) {
        int i;
        switch (this.h) {
            case 0:
                long j5 = aVar.j("_id");
                String strK = aVar.k("type");
                long j6 = aVar.j("version_id");
                String strK2 = aVar.k(SettingsConfig.KEY_DATA);
                try {
                    i = ((Cursor) aVar.b).getInt(aVar.i("hit_rules"));
                } catch (Throwable unused) {
                    i = -1;
                }
                try {
                    JSONObject jSONObject = new JSONObject(strK2);
                    jSONObject.put("hit_rules", i);
                    C1667a c1667a = new C1667a();
                    c1667a.f5294a = j5;
                    c1667a.b = strK;
                    c1667a.d = jSONObject;
                    c1667a.e = j6;
                    return c1667a;
                } catch (JSONException unused2) {
                    return new C1667a(j5, j6, strK, strK2);
                }
            default:
                long j10 = aVar.j("_id");
                String strK3 = aVar.k("type");
                long j11 = aVar.j("version_id");
                String strK4 = aVar.k(SettingsConfig.KEY_DATA);
                String strK5 = aVar.k("type2");
                C1669c c1669c = new C1669c(j10, j11, strK3, strK4);
                c1669c.c = strK5;
                return c1669c;
        }
    }

    @Override // w1.b
    public final ContentValues d(C1669c c1669c) {
        switch (this.h) {
            case 0:
                C1667a c1667a = (C1667a) c1669c;
                ContentValues contentValues = new ContentValues();
                contentValues.put("type", c1667a.b);
                contentValues.put("type2", c1667a.c);
                contentValues.put("timestamp", (Long) 0L);
                contentValues.put("version_id", Long.valueOf(c1667a.e));
                JSONObject jSONObject = c1667a.d;
                contentValues.put(SettingsConfig.KEY_DATA, jSONObject == null ? "" : jSONObject.toString());
                contentValues.put("is_sampled", (Integer) 0);
                contentValues.put("hit_rules", (Integer) 0);
                contentValues.put("front", (Integer) 0);
                contentValues.put("sid", (Long) 0L);
                contentValues.put("network_type", (Integer) 0);
                contentValues.put("traffic_value", (Long) 0L);
                return contentValues;
            default:
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("type", c1669c.b);
                contentValues2.put("type2", c1669c.c);
                contentValues2.put("timestamp", (Long) 0L);
                contentValues2.put("version_id", Long.valueOf(c1669c.e));
                contentValues2.put(SettingsConfig.KEY_DATA, c1669c.d.toString());
                contentValues2.put("is_sampled", (Integer) 0);
                return contentValues2;
        }
    }

    @Override // w1.b
    public final String[] h() {
        switch (this.h) {
            case 0:
                return new String[]{"_id", "type", "version_id", SettingsConfig.KEY_DATA, "hit_rules"};
            default:
                return new String[]{"_id", "type", "type2", "version_id", SettingsConfig.KEY_DATA, "delete_flag"};
        }
    }

    @Override // w1.b
    public final String i() {
        switch (this.h) {
            case 0:
                return "t_apiall";
            default:
                return "local_monitor_log";
        }
    }
}
