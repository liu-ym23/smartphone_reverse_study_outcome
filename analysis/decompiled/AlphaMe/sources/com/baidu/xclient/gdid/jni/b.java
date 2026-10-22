package com.baidu.xclient.gdid.jni;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.xclient.gdid.e;
import com.baidu.xclient.gdid.j.d;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile b f9554a;

    /* renamed from: b, reason: collision with root package name */
    public c f9555b;

    /* renamed from: c, reason: collision with root package name */
    public Context f9556c;

    public b(Context context) {
        this.f9556c = context;
        this.f9555b = c.a(context);
    }

    public static b a(Context context) {
        if (f9554a == null) {
            synchronized (b.class) {
                try {
                    if (f9554a == null) {
                        f9554a = new b(context);
                    }
                } finally {
                }
            }
        }
        return f9554a;
    }

    public final void b(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (a.a(this.f9556c, jSONObject2, "2", 0, 1, jSONObject2.optInt("4", 0))) {
                String[] strArrSplit = this.f9555b.e(Environment.getDataDirectory().getAbsolutePath()).split("\\|");
                if (TextUtils.isEmpty(strArrSplit[0])) {
                    jSONObject.put(String.valueOf(12), 0);
                } else {
                    jSONObject.put(String.valueOf(12), Long.valueOf(strArrSplit[0]));
                }
                if (!TextUtils.isEmpty(strArrSplit[1])) {
                    jSONObject.put(String.valueOf(13), Long.valueOf(strArrSplit[1]));
                    return;
                }
            } else {
                jSONObject.put(String.valueOf(12), 0);
            }
            jSONObject.put(String.valueOf(13), 0);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void c(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (a.a(this.f9556c, jSONObject2, "s", 1, 1, jSONObject2.optInt("4", 0))) {
                String strC = com.baidu.xclient.gdid.d.a().c("sl");
                if (TextUtils.isEmpty(strC)) {
                    jSONObject.put(String.valueOf(57), 0);
                } else if (TextUtils.isEmpty(strC)) {
                    jSONObject.put(String.valueOf(57), 0);
                } else {
                    jSONObject.put(String.valueOf(57), com.baidu.mshield.b.f.c.a(strC));
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject(e.e().k());
            JSONObject jSONObject2 = new JSONObject();
            a(jSONObject2);
            a(jSONObject2, jSONObject);
            b(jSONObject2, jSONObject);
            a(this.f9556c, jSONObject2, jSONObject);
            c(jSONObject2, jSONObject);
            a(this.f9556c, jSONObject2, true);
            a(this.f9556c, jSONObject2, false);
            a(jSONObject2, true);
            a(jSONObject2, false);
            byte[] bArrA = this.f9555b.a(jSONObject2.toString().getBytes());
            return bArrA == null ? "" : Base64.encodeToString(bArrA, 10);
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public final JSONObject a(Context context, JSONObject jSONObject, int i4, int i5) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            int i6 = 1;
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (i6 < i4) {
                    i6++;
                } else {
                    if (i6 >= i4 + i5) {
                        break;
                    }
                    i6++;
                    String strOptString = jSONObject.optString(next);
                    if (!TextUtils.isEmpty(strOptString)) {
                        PackageInfo packageInfoA = com.baidu.mshield.b.e.c.a(context, strOptString, 0);
                        JSONObject jSONObject3 = new JSONObject();
                        if (packageInfoA == null) {
                            jSONObject3.put("0", -1);
                            jSONObject3.put("1", "");
                            jSONObject3.put("2", 0);
                            jSONObject3.put("3", 0);
                        } else {
                            jSONObject3.put("0", 0);
                            jSONObject3.put("1", packageInfoA.versionName);
                            jSONObject3.put("2", packageInfoA.firstInstallTime);
                            jSONObject3.put("3", packageInfoA.lastUpdateTime);
                        }
                        jSONObject2.put(next, jSONObject3);
                    }
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return jSONObject2;
    }

    public final JSONObject a(JSONObject jSONObject, int i4, int i5) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            int i6 = 1;
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (i6 < i4) {
                    i6++;
                } else {
                    if (i6 >= i4 + i5) {
                        break;
                    }
                    i6++;
                    String strOptString = jSONObject.optString(next);
                    if (!TextUtils.isEmpty(strOptString)) {
                        jSONObject2.put(next, new JSONObject(this.f9555b.a(strOptString)));
                    }
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
        return jSONObject2;
    }

    public final void a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        PackageInfo packageInfoA;
        try {
            if (!a.a(this.f9556c, jSONObject2, "1", 0, 1, jSONObject2.optInt("4", 0)) || (packageInfoA = com.baidu.mshield.b.e.c.a(context, com.baidu.xclient.gdid.d.a().a(context), 0)) == null) {
                jSONObject.put(String.valueOf(20), 0);
            } else {
                jSONObject.put(String.valueOf(20), packageInfoA.firstInstallTime);
            }
            a(jSONObject, 52, this.f9555b.d());
            jSONObject.put(String.valueOf(54), this.f9555b.c());
            a(jSONObject, 58, this.f9555b.b());
            String[] strArrA = a.a(this.f9555b.b("/proc/cpuinfo"));
            a(jSONObject, 60, strArrA[0]);
            a(jSONObject, 61, strArrA[1]);
            jSONObject.put(String.valueOf(62), d.c());
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(Context context, JSONObject jSONObject, boolean z4) {
        String strR;
        int iOptInt;
        int iZ;
        int i4;
        try {
            JSONObject jSONObject2 = new JSONObject(e.e().k());
            int i5 = 20;
            if (z4) {
                strR = jSONObject2.optString("9");
                iOptInt = jSONObject2.optInt("x", 20);
                iZ = e.e().A();
                i4 = 22;
            } else {
                strR = e.e().r();
                iOptInt = jSONObject2.optInt("y", 20);
                iZ = e.e().z();
                i4 = 21;
            }
            String strD = strR;
            int i6 = iZ;
            int i7 = i4;
            if (iOptInt <= 20 && iOptInt != 0) {
                i5 = iOptInt;
            }
            if (a.a(this.f9556c, jSONObject2, "", 0, 1, jSONObject2.optInt("4", 0))) {
                if (!TextUtils.isEmpty(strD)) {
                    strD = this.f9555b.d(strD);
                }
                if (TextUtils.isEmpty(strD)) {
                    jSONObject.put(String.valueOf(i7), new JSONObject());
                    return;
                }
                JSONObject jSONObject3 = new JSONObject(strD);
                int length = jSONObject3.length();
                Pair<Integer, Integer> pairA = a.a(i6, length, i5);
                int iIntValue = ((Integer) pairA.first).intValue();
                int iIntValue2 = ((Integer) pairA.second).intValue();
                jSONObject.put(String.valueOf(i7), a(context, jSONObject3, iIntValue, iIntValue2));
                int i8 = iIntValue + iIntValue2;
                if (i8 <= length) {
                    length = i8;
                }
                if (z4) {
                    e.e().h(length);
                } else {
                    e.e().g(length);
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            a(jSONObject, 3, this.f9555b.f());
            a(jSONObject, 4, com.baidu.xclient.gdid.d.a().c("mod"));
            a(jSONObject, 5, this.f9555b.k());
            a(jSONObject, 6, this.f9555b.j());
            a(jSONObject, 7, this.f9555b.i());
            a(jSONObject, 8, this.f9555b.h());
            a(jSONObject, 9, this.f9555b.g());
            a(jSONObject, 50, this.f9555b.c("ro.build.fingerprint"));
            a(jSONObject, 53, com.baidu.xclient.gdid.d.a().c("arv"));
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(JSONObject jSONObject, int i4, String str) {
        try {
            String strValueOf = String.valueOf(i4);
            if (str == null) {
                str = "";
            }
            jSONObject.put(strValueOf, str);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (a.a(this.f9556c, jSONObject2, "2", 0, 1, jSONObject2.optInt("4", 0))) {
                String[] strArrSplit = this.f9555b.e(Environment.getExternalStorageDirectory().getAbsolutePath()).split("\\|");
                if (TextUtils.isEmpty(strArrSplit[0])) {
                    jSONObject.put(String.valueOf(10), 0);
                } else {
                    jSONObject.put(String.valueOf(10), Long.valueOf(strArrSplit[0]));
                }
                if (!TextUtils.isEmpty(strArrSplit[1])) {
                    jSONObject.put(String.valueOf(11), Long.valueOf(strArrSplit[1]));
                    return;
                }
            } else {
                jSONObject.put(String.valueOf(10), 0);
            }
            jSONObject.put(String.valueOf(11), 0);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public final void a(JSONObject jSONObject, boolean z4) {
        boolean zA;
        String strS;
        int iOptInt;
        int iA;
        int i4;
        try {
            JSONObject jSONObject2 = new JSONObject(e.e().k());
            int iOptInt2 = jSONObject2.optInt("4", 0);
            int i5 = 20;
            if (z4) {
                zA = a.a(this.f9556c, jSONObject2, "", 0, 1, iOptInt2);
                strS = jSONObject2.optString("10");
                iOptInt = jSONObject2.optInt("u", 20);
                iA = e.e().b();
                i4 = 59;
            } else {
                zA = a.a(this.f9556c, jSONObject2, "", 0, 1, iOptInt2);
                strS = e.e().s();
                iOptInt = jSONObject2.optInt(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, 20);
                iA = e.e().a();
                i4 = 56;
            }
            if (iOptInt <= 20 && iOptInt != 0) {
                i5 = iOptInt;
            }
            if (zA) {
                if (!TextUtils.isEmpty(strS)) {
                    strS = this.f9555b.d(strS);
                }
                if (TextUtils.isEmpty(strS)) {
                    jSONObject.put(String.valueOf(i4), new JSONObject());
                    return;
                }
                JSONObject jSONObject3 = new JSONObject(strS);
                int length = jSONObject3.length();
                Pair<Integer, Integer> pairA = a.a(iA, length, i5);
                int iIntValue = ((Integer) pairA.first).intValue();
                int iIntValue2 = ((Integer) pairA.second).intValue();
                jSONObject.put(String.valueOf(i4), a(jSONObject3, iIntValue, iIntValue2));
                int i6 = iIntValue + iIntValue2;
                if (i6 <= length) {
                    length = i6;
                }
                if (z4) {
                    e.e().j(length);
                } else {
                    e.e().i(length);
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
