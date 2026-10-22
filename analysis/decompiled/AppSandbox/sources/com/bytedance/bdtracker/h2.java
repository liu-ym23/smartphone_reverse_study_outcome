package com.bytedance.bdtracker;

import android.content.Context;
import com.bytedance.applog.store.kv.IKVStore;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h2 extends p1 {
    public final u1 e;

    public h2(Context context, u1 u1Var, w1 w1Var) {
        super(true, false, false);
        this.e = u1Var;
    }

    @Override // com.bytedance.bdtracker.p1
    public String a() {
        return "ServerId";
    }

    @Override // com.bytedance.bdtracker.p1
    public boolean a(JSONObject jSONObject) throws JSONException {
        IKVStore iKVStore = this.e.f;
        String string = iKVStore.getString("device_id", null);
        w1.a(jSONObject, "device_id", string);
        String string2 = iKVStore.getString("bd_did", null);
        w1.a(jSONObject, "bd_did", string2);
        String string3 = iKVStore.getString("install_id", null);
        String string4 = iKVStore.getString(this.e.f(), null);
        w1.a(jSONObject, "install_id", string3);
        w1.a(jSONObject, "ssid", string4);
        long j = 0;
        long j2 = iKVStore.getLong("register_time", 0L);
        if ((r.a(string3) && ((r.a(string) || r.a(string2)) && r.a(string4))) || j2 == 0) {
            j = j2;
        } else {
            this.e.f.putLong("register_time", 0L);
        }
        jSONObject.put("register_time", j);
        return true;
    }
}
