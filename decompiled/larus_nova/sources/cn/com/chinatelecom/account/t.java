package cn.com.chinatelecom.account;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static u f24451a;

    static {
        f24451a = new a0();
    }

    public static String a() {
        return f24451a.a(false);
    }

    public static String a(Context r100, String r110, String r111, String r112, long r113, String r114) {
        return f24451a.a(r100, r110, r111, r112, r113, false, r114);
    }

    public static String a(String r100, String r101) {
        return f24451a.a(r100, r101);
    }

    public static String b() {
        return f24451a.a(true);
    }

    public static String b(Context r100, String r110, String r111, String r112, long r113, String r114) {
        return f24451a.a(r100, r110, r111, r112, r113, true, r114);
    }
}
