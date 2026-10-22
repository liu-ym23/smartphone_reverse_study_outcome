package W0;

import android.content.SharedPreferences;
import android.text.TextUtils;
import cc.dd.ee.dd.cc.ff.c$b;
import g1.AbstractC1451a;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f1475a;
    public JSONArray b;
    public volatile boolean c;
    public String d;
    public long e;

    public final synchronized void a() {
        if (this.c) {
            return;
        }
        this.c = true;
        SharedPreferences sharedPreferences = AbstractC1451a.b.getSharedPreferences(AbstractC1451a.A() + "_drop_message", 0);
        this.f1475a = sharedPreferences;
        String string = sharedPreferences.getString("drop_data_items", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                this.b = new JSONArray(string);
            } catch (Exception unused) {
            }
        }
    }

    public final void b(long j5, long j6, long j10) {
        c$b c_b = c$b.SERVER_DROP;
        a();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_type", "server_drop_data");
            jSONObject.put("timestamp", j10);
            jSONObject.put("drop_data_count", j5);
            jSONObject.put("drop_data_bytes", j6);
            jSONObject.put("x-tt-logid", this.d);
            jSONObject.put("drop_timestamp", this.e);
            jSONObject.put("drop_reason", c_b);
            this.b.put(jSONObject);
            if (AbstractC1451a.f4467a) {
                H4.o.f(S0.a.f1163a, "monitorDropLog:" + this.b.toString());
            }
            this.f1475a.edit().putString("drop_data_items", this.b.toString()).commit();
        } catch (Exception e) {
            H4.o.g(S0.a.f1163a, "monitorDropLog:", e);
        }
    }

    public final JSONArray c() {
        a();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < this.b.length(); i++) {
            try {
                if (i < 10) {
                    jSONArray.put(this.b.get(i));
                } else {
                    jSONArray2.put(this.b.get(i));
                }
            } catch (Exception unused) {
            }
        }
        this.b = jSONArray2;
        this.f1475a.edit().putString("drop_data_items", this.b.toString()).commit();
        return jSONArray;
    }
}
