package com.amap.api.col.jmsl;

import android.content.Context;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes.dex */
public class A0 {

    /* renamed from: a, reason: collision with root package name */
    public static int f15919a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static String f15920b = "";

    /* renamed from: c, reason: collision with root package name */
    public static C1569j2 f15921c;

    public static Map<String, String> a(Context context) {
        HashMap map = new HashMap();
        try {
            map.put("resType", "json");
            map.put("encode", "UTF-8");
            String strB = J0.b();
            map.put("ts", strB);
            map.put("key", C1567j0.n(context));
            map.put("scode", J0.d(context, strB, C1604s2.r("resType=json&encode=UTF-8&key=" + C1567j0.n(context))));
            return map;
        } catch (Throwable th) {
            C1611u1.b(th, "Auth", "gParams");
            return map;
        }
    }

    public static void b(String str) {
        C1567j0.d(str);
    }

    public static boolean c(Context context, C1569j2 c1569j2) {
        f15921c = c1569j2;
        try {
            HashMap map = new HashMap();
            map.put("Content-Type", "application/x-www-form-urlencoded");
            map.put("Accept-Encoding", "gzip");
            map.put(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30851j, com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30858q);
            map.put(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30853l, f15921c.f());
            map.put("X-INFO", J0.c(context));
            map.put("logversion", "2.1");
            map.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", f15921c.h(), f15921c.g()));
            C1540c1 c1540c1B = C1540c1.b();
            J2 j22 = new J2();
            j22.setProxy(L1.d(context));
            j22.c(map);
            j22.e(a(context));
            j22.d("http://apiinit.amap.com/v3/log/init");
            return d(c1540c1B.k(j22));
        } catch (Throwable th) {
            C1611u1.b(th, "Auth", "getAuth");
            return true;
        }
    }

    public static boolean d(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(C1604s2.n(bArr));
            if (jSONObject.has("status")) {
                int i10 = jSONObject.getInt("status");
                if (i10 == 1) {
                    f15919a = 1;
                } else if (i10 == 0) {
                    f15919a = 0;
                }
            }
            if (jSONObject.has("info")) {
                f15920b = jSONObject.getString("info");
            }
            if (f15919a == 0) {
                Log.i("AuthFailure", f15920b);
            }
            return f15919a == 1;
        } catch (JSONException e10) {
            C1611u1.b(e10, "Auth", "lData");
            return false;
        } catch (Throwable th) {
            C1611u1.b(th, "Auth", "lData");
            return false;
        }
    }

    @Deprecated
    public static synchronized boolean e(Context context, C1569j2 c1569j2) {
        return c(context, c1569j2);
    }
}
