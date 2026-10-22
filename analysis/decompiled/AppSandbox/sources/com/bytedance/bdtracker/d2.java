package com.bytedance.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.DynamicValueCallback;
import com.bytedance.applog.log.GlobalLoggerImpl;
import com.bytedance.applog.store.kv.IKVStore;
import com.stepos.pps.logpull.LogPullAuthActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d2 extends p1 {
    public final Context e;
    public final u1 f;

    public d2(Context context, u1 u1Var) {
        super(true, false);
        this.e = context;
        this.f = u1Var;
    }

    @Override // com.bytedance.bdtracker.p1
    public String a() {
        return "Oaid";
    }

    @Override // com.bytedance.bdtracker.p1
    public boolean a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        u1 u1Var = this.f;
        IKVStore iKVStore = u1Var.f;
        if (!u1Var.l()) {
            return true;
        }
        DynamicValueCallback<String> customOaidCallback = this.f.c.getCustomOaidCallback();
        if (customOaidCallback == null || TextUtils.isEmpty(customOaidCallback.get())) {
            GlobalLoggerImpl.global().debug("use default oaid", new Object[0]);
            Map mapA = y5.a(this.e);
            if (mapA == null) {
                return false;
            }
            jSONObject2 = new JSONObject(mapA);
        } else {
            GlobalLoggerImpl.global().debug("use custom oaid", new Object[0]);
            HashMap map = new HashMap();
            map.put("id", customOaidCallback.get());
            map.put("req_id", UUID.randomUUID().toString());
            map.put("take_ms", "1");
            map.put("time", "" + System.currentTimeMillis());
            map.put("query_times", "1");
            map.put("is_track_limited", "false");
            jSONObject2 = new JSONObject(map);
        }
        jSONObject.put(LogPullAuthActivity.EXTRA_OAID, jSONObject2);
        return true;
    }
}
