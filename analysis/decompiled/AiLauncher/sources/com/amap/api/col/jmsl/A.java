package com.amap.api.col.jmsl;

import android.os.Build;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class A {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, I> f15917a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static String f15918b = "";

    public static void a(String str, String str2) {
        Map<String, I> map;
        I i10;
        String str3 = f15918b;
        try {
            String str4 = str + str2;
            if (!C1605t.f16953a || (map = f15917a) == null || (i10 = map.get("normal")) == null) {
                return;
            }
            i10.a(1, str3, str4);
        } catch (Throwable unused) {
        }
    }

    public static void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean zContains = false;
            boolean zU = C1602s0.u(jSONObject.optString("able", ""), false);
            boolean zU2 = C1602s0.u(jSONObject.optString("mobile", ""), false);
            boolean zU3 = C1602s0.u(jSONObject.optString("debugupload", ""), false);
            boolean zU4 = C1602s0.u(jSONObject.optString("debugwrite", ""), false);
            boolean zU5 = C1602s0.u(jSONObject.optString("forcedUpload", ""), false);
            C1605t.f16953a = zU;
            boolean zU6 = C1602s0.u(jSONObject.optString("di", ""), false);
            String strOptString = jSONObject.optString("dis", "");
            if (zU6) {
                String[] strArr = C1604s2.f16918a;
                if (!TextUtils.isEmpty(strOptString)) {
                    try {
                        zContains = C1604s2.n(C1568j1.b(strOptString)).contains(Build.MODEL + Build.VERSION.SDK_INT);
                    } catch (Throwable unused) {
                    }
                }
                if (!zContains) {
                    return;
                }
            }
            W2.c(C1570k.c()).g(zU, zU2, zU4, zU3, Arrays.asList(jSONObject.optString("filter", "").split(Const.STR_MART_ADD)));
            if (zU5) {
                W2.c(C1570k.c()).n(zU5);
            }
        } catch (Throwable unused2) {
        }
    }
}
