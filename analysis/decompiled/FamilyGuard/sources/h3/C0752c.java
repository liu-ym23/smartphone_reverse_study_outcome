package h3;

import org.libpag.BuildConfig;

/* renamed from: h3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0752c {
    public static String a(String str) {
        try {
            Class<?> clsB = C0751b.a().b("android.os.SystemProperties");
            return (String) C0751b.a().d(clsB, "get", String.class).invoke(clsB, str);
        } catch (IllegalArgumentException e6) {
            throw e6;
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }

    public static String b(String str, String str2) {
        try {
            Class<?> clsB = C0751b.a().b("android.os.SystemProperties");
            return (String) C0751b.a().d(clsB, "get", String.class, String.class).invoke(clsB, str, str2);
        } catch (IllegalArgumentException e6) {
            throw e6;
        } catch (Exception unused) {
            return str2;
        }
    }

    public static Integer c(String str, int i5) {
        try {
            Class<?> clsB = C0751b.a().b("android.os.SystemProperties");
            return (Integer) C0751b.a().d(clsB, "getInt", String.class, Integer.TYPE).invoke(clsB, str, Integer.valueOf(i5));
        } catch (IllegalArgumentException e6) {
            throw e6;
        } catch (Exception unused) {
            return Integer.valueOf(i5);
        }
    }
}
