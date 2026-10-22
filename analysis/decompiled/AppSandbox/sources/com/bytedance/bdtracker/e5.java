package com.bytedance.bdtracker;

import android.accounts.Account;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.store.kv.IKVStore;
import com.bytedance.applog.util.HardwareUtils;
import com.bytedance.applog.util.SensitiveUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e5 {
    public static String h;
    public static String i;
    public static String j;
    public static JSONArray k;
    public static volatile String l;
    public static String[] m;
    public static String n;
    public final Context a;
    public f4 b;
    public final d4 c;
    public final String d;
    public final d e;
    public final u1 f;
    public final List<String> g = Collections.singletonList("DeviceParamsProvider");

    public e5(d dVar, Context context, u1 u1Var, d4 d4Var) {
        this.e = dVar;
        this.f = u1Var;
        this.d = u1Var.c.getLocalTest() ? "_local" : "";
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        d5 d5Var = new d5();
        this.c = d4Var;
        q4 q4Var = new q4(u1Var.c, applicationContext, "snssdk_openudid", u1Var.c.getSpName());
        this.b = q4Var;
        q4Var.a = d4Var;
        if (!u1Var.c.getAnonymous()) {
            new Thread(new c5(d5Var)).start();
        }
        a(u1Var.c.getAccount());
    }

    public void a(Account account) {
        d4 d4Var = this.c;
        if (d4Var != null) {
            d4Var.a(account);
        }
    }

    public void a(String str) {
        this.b.a(str);
        this.e.D.debug(this.g, "DeviceParamsProvider#clear clearKey=" + str + " sDeviceId=" + l, new Object[0]);
    }

    public String b() {
        if (!TextUtils.isEmpty(l)) {
            return l;
        }
        l = this.b.c("", "");
        return l;
    }

    public void b(String str) {
        if (!r.a(str) || r.a(str, l)) {
            return;
        }
        l = this.b.c(str, l);
    }

    public String c() {
        String secureAndroidId;
        boolean z;
        if (!TextUtils.isEmpty(h)) {
            return h;
        }
        u1 u1Var = this.f;
        if (!u1Var.c.isAndroidIdEnabled() || u1Var.a("openudid")) {
            secureAndroidId = "";
            z = false;
        } else {
            secureAndroidId = HardwareUtils.getSecureAndroidId(this.a);
            z = true;
        }
        String strA = a(secureAndroidId, z);
        if (!TextUtils.isEmpty(strA)) {
            StringBuilder sbA = a.a(strA);
            sbA.append(this.d);
            strA = sbA.toString();
        }
        if (!TextUtils.isEmpty(strA)) {
            h = strA;
        }
        return strA;
    }

    public String d() {
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        try {
            String strE = this.b.e(null, SensitiveUtils.getSerialNumber(this.a));
            if (!TextUtils.isEmpty(strE)) {
                strE = strE + this.d;
            }
            n = strE;
            return strE;
        } catch (Throwable th) {
            this.e.D.error(this.g, "getSerialNumber failed", th, new Object[0]);
            return null;
        }
    }

    public String[] e() {
        String[] strArr = m;
        if (strArr != null && strArr.length > 0) {
            return strArr;
        }
        try {
            String[] strArrA = this.b.a((String[]) null, SensitiveUtils.getSimSerialNumbers(this.a));
            if (strArrA == null) {
                strArrA = new String[0];
            }
            for (int i2 = 0; i2 < strArrA.length; i2++) {
                strArrA[i2] = strArrA[i2] + this.d;
            }
            m = strArrA;
            return strArrA;
        } catch (Throwable th) {
            this.e.D.error(this.g, "getSimSerialNumbers failed", th, new Object[0]);
            return null;
        }
    }

    public String f() {
        if (!TextUtils.isEmpty(j)) {
            return j;
        }
        try {
            u1 u1Var = this.f;
            String strF = this.b.f(null, (!u1Var.c.isImeiEnable() || u1Var.a("IMEI")) ? this.f.c.getAppImei() : SensitiveUtils.getDeviceId(this.a));
            if (!TextUtils.isEmpty(strF)) {
                strF = strF + this.d;
            }
            j = strF;
            return strF;
        } catch (Throwable th) {
            this.e.D.error(this.g, "getUdId failed", th, new Object[0]);
            return null;
        }
    }

    public JSONArray g() {
        JSONArray jSONArray = k;
        if (jSONArray != null) {
            return jSONArray;
        }
        try {
            u1 u1Var = this.f;
            if (!u1Var.c.isImeiEnable() || u1Var.a("IMEI")) {
                return new JSONArray();
            }
            JSONArray multiImeiFromSystem = SensitiveUtils.getMultiImeiFromSystem(this.a);
            if (multiImeiFromSystem == null) {
                multiImeiFromSystem = SensitiveUtils.getMultiImeiFallback(this.a);
            }
            if (multiImeiFromSystem == null) {
                multiImeiFromSystem = new JSONArray();
            }
            JSONArray jSONArray2 = new JSONArray(this.b.g(null, multiImeiFromSystem.toString()));
            if (!TextUtils.isEmpty(this.d)) {
                String str = this.d;
                if (jSONArray2.length() != 0) {
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i2);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString = jSONObjectOptJSONObject.optString("id");
                            if (!TextUtils.isEmpty(strOptString)) {
                                jSONObjectOptJSONObject.remove("id");
                                jSONObjectOptJSONObject.put("id", strOptString + str);
                            }
                        }
                    }
                }
            }
            k = jSONArray2;
            return jSONArray2;
        } catch (Throwable th) {
            this.e.D.error(this.g, "getUdIdList failed", th, new Object[0]);
            return null;
        }
    }

    public String a() {
        if (!TextUtils.isEmpty(i)) {
            return i;
        }
        try {
            IKVStore iKVStoreA = v4.a(this.f.c, this.a, "snssdk_openudid");
            String string = iKVStoreA.getString("clientudid", null);
            if (r.e(string)) {
                this.c.b(string, null);
            } else {
                string = UUID.randomUUID().toString();
                iKVStoreA.putString("clientudid", string);
            }
            if (!TextUtils.isEmpty(string)) {
                string = string + this.d;
            }
            i = string;
            return string;
        } catch (Throwable th) {
            this.e.D.error(this.g, "getClientUDID failed", th, new Object[0]);
            return "";
        }
    }

    public final String a(String str, boolean z) {
        try {
            if (r.e(str) && !"9774d56d682e549c".equals(str)) {
                return this.b.d(null, str);
            }
            IKVStore iKVStoreA = v4.a(this.f.c, this.a, "snssdk_openudid");
            String str2 = "openudid";
            String string = iKVStoreA.getString(z ? "openudid" : "openudid_uuid", null);
            if (r.e(string)) {
                this.c.d(string, null);
                return string;
            }
            String string2 = new BigInteger(80, new SecureRandom()).toString(16);
            if (string2.charAt(0) == '-') {
                string2 = string2.substring(1);
            }
            int length = 13 - string2.length();
            if (length > 0) {
                StringBuilder sb = new StringBuilder();
                while (length > 0) {
                    sb.append('F');
                    length--;
                }
                sb.append(string2);
                string2 = sb.toString();
            }
            if (!z) {
                str2 = "openudid_uuid";
            }
            iKVStoreA.putString(str2, string2);
            return string2;
        } catch (Throwable th) {
            this.e.D.error(this.g, "getOpenUdid failed", th, new Object[0]);
            return str;
        }
    }
}
