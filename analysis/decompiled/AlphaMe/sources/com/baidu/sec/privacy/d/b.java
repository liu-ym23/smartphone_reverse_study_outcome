package com.baidu.sec.privacy.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mshield.ac.F;
import com.baidu.sec.privacy.f.c;
import com.stepos.alphame.common.CommonContractKt;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f9419a = false;

    /* renamed from: b, reason: collision with root package name */
    public static String f9420b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f9421c = "";

    public static boolean a() {
        try {
            SharedPreferences sharedPreferencesC = c();
            if (sharedPreferencesC == null) {
                sharedPreferencesC = com.baidu.sec.privacy.b.b.a().getSharedPreferences("leroadcfg", 0);
            }
            return sharedPreferencesC.getBoolean("s_a_pl", false);
        } catch (Throwable th) {
            c.a(th);
            return false;
        }
    }

    public static boolean b(String str) {
        Method method;
        try {
        } catch (Throwable th) {
            c.a(th);
        }
        if (f9419a) {
            return true;
        }
        if (com.baidu.sec.privacy.b.b.d()) {
            com.baidu.sec.privacy.c cVarC = com.baidu.sec.privacy.b.b.c();
            if (cVarC != null) {
                f9419a = cVarC.a();
            }
            return f9419a;
        }
        com.baidu.sec.privacy.a aVarB = com.baidu.sec.privacy.b.b.b();
        if (aVarB != null) {
            boolean zA = aVarB.a();
            f9419a = zA;
            return zA;
        }
        try {
            Class<?> cls = Class.forName("com.baidu." + str + ".ac.F");
            Object objInvoke = cls.getDeclaredMethod(CommonContractKt.METHOD_NAME_GET_INSTANCE, new Class[0]).invoke(cls, new Object[0]);
            Method[] declaredMethods = Class.forName("com.baidu." + str + ".ac.FI").getDeclaredMethods();
            int length = declaredMethods.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    method = null;
                    break;
                }
                method = declaredMethods[i4];
                if ("cp".equals(method.getName())) {
                    break;
                }
                i4++;
            }
            if (method == null) {
                f9419a = a();
            } else {
                f9419a = ((Boolean) method.invoke(objInvoke, com.baidu.sec.privacy.b.b.a())).booleanValue();
            }
        } catch (Throwable unused) {
            f9419a = a();
        }
        return f9419a;
    }

    public static SharedPreferences c() {
        return a("getPlatformSharedSharedPreferences");
    }

    public static String a(String str, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        try {
            SharedPreferences sharedPreferencesB = b();
            if (sharedPreferencesB == null) {
                sharedPreferencesB = com.baidu.sec.privacy.b.b.a().getSharedPreferences(f9421c, 0);
            }
            sharedPreferencesB.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            return sharedPreferencesB.getString(f9420b, "");
        } catch (Throwable th) {
            c.a(th);
            return "";
        }
    }

    public static void a(String str, boolean z4, com.baidu.sec.privacy.c cVar) {
        try {
            if (!z4) {
                if ("sofire".equals(str)) {
                    str = "";
                }
                f9421c = "leroad" + str + "cfg";
                f9420b = "p_s_p_c";
            } else {
                if (cVar == null) {
                    return;
                }
                f9421c = cVar.b();
                f9420b = cVar.c();
            }
        } catch (Throwable th) {
            c.a(th);
        }
    }

    public static SharedPreferences a(String str) {
        try {
            return (SharedPreferences) F.class.getDeclaredMethod(str, Context.class).invoke(F.class.getDeclaredMethod(CommonContractKt.METHOD_NAME_GET_INSTANCE, new Class[0]).invoke(F.class, new Object[0]), com.baidu.sec.privacy.b.b.a());
        } catch (Throwable th) {
            c.a(th);
            return null;
        }
    }

    public static SharedPreferences b() {
        return a("getPlatformPrivateSharedPreferences");
    }
}
