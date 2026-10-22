package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.f;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public final class c {
    public static Map<String, String> a(Context r110) {
        com.alipay.sdk.m.a0.b r100 = com.alipay.sdk.m.a0.b.a(APSecuritySdk.getInstance(r110));
        HashMap r101 = new HashMap();
        f r102 = com.alipay.apmobilesecuritysdk.e.e.a(r110);
        String r103 = r100.a(r110);
        String r104 = r100.d(r110);
        if (r102 != null) goto L5;
    L10:
        f r105 = new f("", r103, "", "", r104);
        if (r110 != null) goto L28;
    L26:
        r101.put("AD1", "");
        r101.put("AD2", r103);
        r101.put("AD3", com.alipay.sdk.m.a0.b.h(r110));
        r101.put("AD5", com.alipay.sdk.m.a0.b.j(r110));
        r101.put("AD6", com.alipay.sdk.m.a0.b.k(r110));
        r101.put("AD7", com.alipay.sdk.m.a0.b.l(r110));
        r101.put("AD9", r100.c(r110));
        r101.put("AD10", r104);
        r101.put("AD11", com.alipay.sdk.m.a0.b.d());
        r101.put("AD12", r100.a());
        r101.put("AD13", com.alipay.sdk.m.a0.b.e());
        r101.put("AD14", com.alipay.sdk.m.a0.b.g());
        r101.put("AD15", com.alipay.sdk.m.a0.b.h());
        r101.put("AD16", com.alipay.sdk.m.a0.b.i());
        r101.put("AD17", "");
        r101.put("AD19", com.alipay.sdk.m.a0.b.m(r110));
        r101.put("AD20", com.alipay.sdk.m.a0.b.j());
        r101.put("AD22", "");
        r101.put("AD23", com.alipay.sdk.m.a0.b.n(r110));
        r101.put("AD24", com.alipay.sdk.m.z.a.g(com.alipay.sdk.m.a0.b.i(r110)));
        r101.put("AD26", r100.b(r110));
        r101.put("AD27", com.alipay.sdk.m.a0.b.o());
        r101.put("AD28", com.alipay.sdk.m.a0.b.q());
        r101.put("AD29", com.alipay.sdk.m.a0.b.s());
        r101.put("AD30", com.alipay.sdk.m.a0.b.p());
        r101.put("AD31", com.alipay.sdk.m.a0.b.r());
        r101.put("AD32", com.alipay.sdk.m.a0.b.m());
        r101.put("AD33", com.alipay.sdk.m.a0.b.n());
        r101.put("AD34", com.alipay.sdk.m.a0.b.o(r110));
        r101.put("AD35", com.alipay.sdk.m.a0.b.p(r110));
        r101.put("AD36", r100.e(r110));
        r101.put("AD37", com.alipay.sdk.m.a0.b.l());
        r101.put("AD38", com.alipay.sdk.m.a0.b.k());
        r101.put("AD39", com.alipay.sdk.m.a0.b.f(r110));
        r101.put("AD40", com.alipay.sdk.m.a0.b.g(r110));
        r101.put("AD41", com.alipay.sdk.m.a0.b.b());
        r101.put("AD42", com.alipay.sdk.m.a0.b.c());
        return r101;
    L28:
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L24
        r106.put("imei", r105.a());     // Catch: Exception -> L24
        r106.put("imsi", r105.b());     // Catch: Exception -> L24
        r106.put("mac", r105.c());     // Catch: Exception -> L24
        r106.put("bluetoothmac", r105.d());     // Catch: Exception -> L24
        r106.put("gsi", r105.e());     // Catch: Exception -> L24
        String r107 = r106.toString();     // Catch: Exception -> L24
        com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key", r107);     // Catch: Exception -> L24
        com.alipay.apmobilesecuritysdk.f.a.a(r110, "device_feature_prefs_name", "device_feature_prefs_key", r107);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        com.alipay.apmobilesecuritysdk.c.a.a(e);
        goto L26
    L5:
        if (com.alipay.sdk.m.z.a.a(r103) == false) goto L8;
        r103 = r102.b();
    L8:
        if (com.alipay.sdk.m.z.a.a(r104) == false) goto L10;
        r104 = r102.e();
        goto L10
    }
}
