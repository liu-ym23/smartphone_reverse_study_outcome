package com.apm.insight.entity;

import A5.c;
import D2.b;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.apm.insight.ICommonParams;
import com.apm.insight.g;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import u1.d;

/* loaded from: classes2.dex */
public final class Header {
    public static final String[] b = {"version_code", "manifest_version_code", "aid", "update_version_code"};
    public static String c = null;
    public static int d = -1;
    public static int e = -1;

    /* renamed from: a, reason: collision with root package name */
    public final JSONObject f2158a = new JSONObject();

    public static Header a() {
        Header header = new Header();
        JSONObject jSONObject = header.f2158a;
        try {
            jSONObject.put("sdk_version", 1050090);
            jSONObject.put("sdk_version_name", "1.5.0");
        } catch (Exception unused) {
        }
        return header;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(32:4|(2:108|5)|(4:(1:7)(3:9|(1:15)(1:14)|(1:17)(35:18|(1:20)|21|(1:23)|24|(1:26)|27|106|28|(2:30|(2:32|(1:34)(1:35))(1:36))(1:37)|38|100|39|(1:41)|42|(1:44)|45|(1:47)|48|(1:50)|51|102|52|(1:54)(1:55)|56|(1:58)(1:(1:62))|65|(4:67|68|(1:70)(1:72)|71)|73|74|(1:76)(1:78)|77|110|81|(2:83|94)(4:84|(4:87|(3:104|92|117)|115|85)|112|121)))|110|81|(0)(0))|8|24|(0)|27|106|28|(0)(0)|38|100|39|(0)|42|(0)|45|(0)|48|(0)|51|102|52|(0)(0)|56|(0)(0)|65|(0)|73|74|(0)(0)|77) */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0154, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ad, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059 A[Catch: all -> 0x006b, TryCatch #4 {all -> 0x006b, blocks: (B:5:0x000a, B:8:0x0012, B:24:0x004e, B:26:0x0059, B:27:0x0062, B:9:0x0016, B:11:0x0020, B:18:0x0033, B:20:0x003d, B:21:0x0042, B:23:0x0048), top: B:108:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cb A[Catch: Exception -> 0x00fe, TryCatch #0 {Exception -> 0x00fe, blocks: (B:39:0x00b5, B:41:0x00cb, B:42:0x00d0, B:44:0x00de, B:45:0x00e3, B:51:0x00f9), top: B:100:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00de A[Catch: Exception -> 0x00fe, TryCatch #0 {Exception -> 0x00fe, blocks: (B:39:0x00b5, B:41:0x00cb, B:42:0x00d0, B:44:0x00de, B:45:0x00e3, B:51:0x00f9), top: B:100:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011f A[Catch: all -> 0x0154, TryCatch #1 {all -> 0x0154, blocks: (B:52:0x00fe, B:56:0x0125, B:65:0x0156, B:67:0x0183, B:70:0x0189, B:71:0x018d, B:72:0x0191, B:73:0x019c, B:77:0x01a6, B:60:0x0139, B:62:0x013f, B:55:0x011f), top: B:102:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0183 A[Catch: all -> 0x0154, TRY_LEAVE, TryCatch #1 {all -> 0x0154, blocks: (B:52:0x00fe, B:56:0x0125, B:65:0x0156, B:67:0x0183, B:70:0x0189, B:71:0x018d, B:72:0x0191, B:73:0x019c, B:77:0x01a6, B:60:0x0139, B:62:0x013f, B:55:0x011f), top: B:102:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b8 A[Catch: all -> 0x01dd, TryCatch #5 {all -> 0x01dd, blocks: (B:81:0x01b0, B:84:0x01b8, B:85:0x01bc, B:87:0x01c2, B:90:0x01d1, B:92:0x01d9), top: B:110:0x01b0 }] */
    @androidx.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void addOtherHeader(org.json.JSONObject r5) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.entity.Header.addOtherHeader(org.json.JSONObject):void");
    }

    public static void addRuntimeHeader(JSONObject jSONObject) {
        try {
            jSONObject.put("access", b.b(b.c(g.f2160a)));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) g.f2160a.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put("carrier", networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e9) {
            e9.printStackTrace();
        }
    }

    public static Header b(long j5) {
        Header headerA;
        d dVarB = d.B();
        if (j5 == 0) {
            j5 = System.currentTimeMillis();
        }
        JSONObject jSONObjectR = dVarB.r(j5);
        if (jSONObjectR == null || jSONObjectR.length() == 0) {
            Context context = g.f2160a;
            headerA = a();
            headerA.h();
            try {
                headerA.f2158a.put("errHeader", 1);
            } catch (Throwable unused) {
            }
        } else {
            Context context2 = g.f2160a;
            headerA = new Header();
        }
        f(headerA);
        headerA.d(jSONObjectR);
        return headerA;
    }

    public static boolean e() {
        if (d == -1) {
            d = l().contains("64") ? 1 : 0;
        }
        return d == 1;
    }

    public static void f(Header header) {
        if (header == null) {
            return;
        }
        addOtherHeader(header.f2158a);
    }

    public static boolean g() {
        if (e == -1) {
            e = l().contains("86") ? 1 : 0;
        }
        return e == 1;
    }

    public static boolean i(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return true;
        }
        return (jSONObject.opt("app_version") == null && jSONObject.opt("version_name") == null) || jSONObject.opt("version_code") == null || jSONObject.opt("update_version_code") == null;
    }

    public static String l() {
        if (c == null) {
            try {
                StringBuilder sb = new StringBuilder();
                if (Build.SUPPORTED_ABIS.length > 0) {
                    int i = 0;
                    while (true) {
                        String[] strArr = Build.SUPPORTED_ABIS;
                        if (i >= strArr.length) {
                            break;
                        }
                        sb.append(strArr[i]);
                        if (i != strArr.length - 1) {
                            sb.append(", ");
                        }
                        i++;
                    }
                } else {
                    sb = new StringBuilder(Build.CPU_ABI);
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    c = EnvironmentCompat.MEDIA_UNKNOWN;
                }
                c = sb.toString();
            } catch (Exception e6) {
                S0.b.p0(e6);
                c = EnvironmentCompat.MEDIA_UNKNOWN;
            }
        }
        return c;
    }

    public final JSONObject c(Map map) {
        JSONObject jSONObject = this.f2158a;
        if (map == null) {
            return jSONObject;
        }
        try {
            for (Map.Entry entry : map.entrySet()) {
                if (!jSONObject.has((String) entry.getKey())) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            }
            String[] strArr = b;
            for (int i = 0; i < 4; i++) {
                String str = strArr[i];
                if (map.containsKey(str)) {
                    try {
                        jSONObject.put(str, Integer.parseInt(String.valueOf(map.get(str))));
                    } catch (Throwable unused) {
                        jSONObject.put(str, map.get(str));
                    }
                }
            }
            if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
                try {
                    jSONObject.put("manifest_version_code", Integer.parseInt(String.valueOf(map.get("version_code"))));
                } catch (Throwable unused2) {
                }
            }
            if (map.containsKey("iid")) {
                jSONObject.put("udid", map.get("iid"));
                jSONObject.remove("iid");
            }
            if (map.containsKey("version_name")) {
                jSONObject.put("app_version", map.get("version_name"));
                jSONObject.remove("version_name");
            }
        } catch (Throwable unused3) {
        }
        return jSONObject;
    }

    public final void d(JSONObject jSONObject) {
        JSONObject jSONObject2 = this.f2158a;
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                jSONObject2.put(next, jSONObject.opt(next));
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        }
    }

    public final void h() {
        c(g.a().h());
    }

    public final void j() {
        try {
            this.f2158a.put("device_id", g.e().h());
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }

    public final void k() {
        long userId;
        JSONObject jSONObject = this.f2158a;
        try {
            c cVarA = g.a();
            cVarA.getClass();
            try {
                userId = ((ICommonParams) cVarA.c).getUserId();
            } catch (Throwable unused) {
                userId = 0;
            }
            if (userId > 0) {
                jSONObject.put("user_id", userId);
            }
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
    }
}
