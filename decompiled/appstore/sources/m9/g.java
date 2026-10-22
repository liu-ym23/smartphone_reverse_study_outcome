package m9;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public static String a() {
        if (f() == true) goto L5;
        return "";
    L5:
        return e("ro.build.version.emui", "");
    }

    public static String b() {
        return e("ro.build.display.id", "");
    }

    public static String c() {
        if (j() == true) goto L5;
        return "";
    L5:
        return e("ro.build.display.id", "");
    }

    public static String d() {
        if (l() == true) goto L5;
        return "";
    L5:
        return e("ro.miui.ui.version.name", "");
    }

    public static String e(String r10, String r11) {
        Class<?> r12 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L5
        return (String) r12.getMethod("get", new Class[]{String.class, String.class}).invoke(r12, new Object[]{r10, r11});
    L5:
        e = move-exception;
        e.printStackTrace();
        return r11;
    }

    public static boolean f() {
        return !TextUtils.isEmpty(e("ro.build.version.emui", ""));
    }

    public static boolean g() {
        if (a().contains("EmotionUI_3.0") == false) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean h() {
        String r10 = a();
        if ("EmotionUI 3".equals(r10) == false) goto L5;
        return true;
    L5:
        if (r10.contains("EmotionUI_3.1") == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean i() {
        if (g() == false) goto L5;
    L8:
        return true;
    L5:
        if (h() == true) goto L8;
        return false;
    }

    public static boolean j() {
        return b().toLowerCase().contains("flyme");
    }

    public static boolean k() {
        String r10 = c();
        if (r10.isEmpty() == true) goto L14;
        if (r10.toLowerCase().contains("os") == false) goto L7;
        int r11 = Integer.valueOf(r10.substring(9, 10)).intValue();     // Catch: NumberFormatException -> L12
    L9:
        if (r11 < 4) goto L15;
        return true;
    L15:
        return false;
    L7:
        r11 = Integer.valueOf(r10.substring(6, 7)).intValue();     // Catch: NumberFormatException -> L12
        goto L9
    L16:
        return false;
    L14:
        return false;
    }

    public static boolean l() {
        return !TextUtils.isEmpty(e("ro.miui.ui.version.name", ""));
    }

    public static boolean m() {
        String r10 = d();
        if (r10.isEmpty() == false) goto L11;
        return false;
    L11:
        if (Integer.valueOf(r10.substring(1)).intValue() >= 6) goto L9;
        return false;
    L9:
        return true;
    L15:
        return false;
    }
}
