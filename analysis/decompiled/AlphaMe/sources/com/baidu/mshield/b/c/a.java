package com.baidu.mshield.b.c;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f8266a = -1;

    static {
        new ThreadLocal();
    }

    public static void a(int i4, String str) {
    }

    public static void b(String str) {
        int i4 = f8266a;
        if (i4 == -1 || i4 == 0 || i4 == 1) {
            a(1, str);
        }
    }

    public static void c(String str) {
        int i4 = f8266a;
        if (i4 == -1 || i4 == 0 || i4 == 1 || i4 == 2) {
            a(2, str);
        }
    }

    public static void a(Throwable th) {
    }

    public static void a(String str) {
        b(str);
    }
}
