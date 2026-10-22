package s;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e extends c {
    public final /* synthetic */ int d;
    public final g e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g gVar, int i) {
        super(true, false);
        this.d = i;
        switch (i) {
            case 1:
                this.b = true;
                this.c = false;
                this.e = gVar;
                break;
            default:
                this.e = gVar;
                break;
        }
    }

    @Override // s.c
    public final boolean a(JSONObject jSONObject) throws JSONException {
        int i = this.d;
        g gVar = this.e;
        switch (i) {
            case 0:
                try {
                    SharedPreferences sharedPreferences = gVar.e;
                    x.d dVar = x.f.f6862a;
                    SystemClock.elapsedRealtime();
                    String str = (String) Z6.k.g.b(sharedPreferences);
                    SystemClock.elapsedRealtime();
                    if (TextUtils.isEmpty(str)) {
                        jSONObject.put("cdid", "");
                    } else {
                        jSONObject.put("cdid", str);
                    }
                    break;
                } catch (Throwable unused) {
                    break;
                }
            default:
                SharedPreferences sharedPreferences2 = gVar.e;
                String string = sharedPreferences2.getString("bd_did", null);
                h.b("bd_did", jSONObject, string);
                String string2 = sharedPreferences2.getString("install_id", null);
                StringBuilder sbF = M.a.f("ssid_");
                sbF.append(gVar.b.f4335a);
                String string3 = sharedPreferences2.getString(sbF.toString(), null);
                h.b("install_id", jSONObject, string2);
                h.b("ssid", jSONObject, string3);
                long j5 = 0;
                long j6 = sharedPreferences2.getLong("register_time", 0L);
                if ((U7.a.l(string2) && (U7.a.l(null) || U7.a.l(string))) || j6 == 0) {
                    j5 = j6;
                } else {
                    gVar.e.edit().putLong("register_time", 0L).apply();
                }
                jSONObject.put("register_time", j5);
                break;
        }
        return true;
        return true;
    }
}
