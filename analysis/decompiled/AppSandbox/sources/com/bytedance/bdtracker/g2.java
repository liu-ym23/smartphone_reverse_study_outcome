package com.bytedance.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.ISensitiveInfoProvider;
import com.bytedance.applog.store.kv.IKVStore;
import com.bytedance.applog.util.SensitiveUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g2 extends p1 {
    public final ISensitiveInfoProvider e;
    public final Context f;
    public final u1 g;
    public final w1 h;

    public g2(Context context, u1 u1Var, w1 w1Var, ISensitiveInfoProvider iSensitiveInfoProvider) {
        super(true, false);
        this.e = iSensitiveInfoProvider;
        this.f = context;
        this.g = u1Var;
        this.h = w1Var;
    }

    @Override // com.bytedance.bdtracker.p1
    public String a() {
        return "SensitiveLoader";
    }

    @Override // com.bytedance.bdtracker.p1
    public boolean a(JSONObject jSONObject) throws JSONException {
        String[] strArrE;
        w1.a(jSONObject, SensitiveUtils.KEY_ALIYUN_UUID, this.g.c.getAliyunUdid());
        u1 u1Var = this.g;
        if (u1Var.c.isMacEnable() && !u1Var.a("mac")) {
            String macAddress = SensitiveUtils.getMacAddress(this.e, this.f);
            IKVStore iKVStore = this.g.f;
            String string = iKVStore.getString(SensitiveUtils.KEY_MAC, null);
            if (!TextUtils.isEmpty(macAddress)) {
                if (!TextUtils.equals(string, macAddress)) {
                    iKVStore.putString(SensitiveUtils.KEY_MAC, macAddress);
                }
                jSONObject.put(SensitiveUtils.KEY_MC, macAddress);
            } else if (!TextUtils.isEmpty(string)) {
                jSONObject.put(SensitiveUtils.KEY_MC, string);
            }
        }
        w1.a(jSONObject, "udid", this.h.h.f());
        JSONArray jSONArrayG = this.h.h.g();
        if (SensitiveUtils.validMultiImei(jSONArrayG)) {
            jSONObject.put("udid_list", jSONArrayG);
        }
        if (this.g.c.isSerialNumberEnable()) {
            jSONObject.put(SensitiveUtils.KEY_BUILD_SERIAL, SensitiveUtils.getSerialNumber(this.f));
            w1.a(jSONObject, "serial_number", this.h.h.d());
        }
        u1 u1Var2 = this.g;
        if (!u1Var2.c.isIccIdEnabled() || u1Var2.a("ICCID") || !this.h.r() || (strArrE = this.h.h.e()) == null) {
            return true;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : strArrE) {
            jSONArray.put(new JSONObject().put("sim_serial_number", str));
        }
        jSONObject.put("sim_serial_number", jSONArray);
        return true;
    }
}
