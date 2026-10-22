package com.apm.insight.log.a;

import java.io.File;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static a f2192a;

    public static void a(a aVar) {
        f2192a = aVar;
        a.a(aVar == null ? 0L : aVar.e());
    }

    public static void b() {
        a aVar = f2192a;
        if (aVar != null) {
            aVar.b();
        }
    }

    public static void c(String str, String str2) {
        a(2, str, str2);
    }

    public static void d(String str, String str2) {
        a(3, str, str2);
    }

    public static void e(String str, String str2) {
        a(4, str, str2);
    }

    public static HashMap<String, String> c() {
        if (f2192a != null) {
            return a.d();
        }
        return null;
    }

    public static void b(String str, String str2) {
        a(1, str, str2);
    }

    public static void a() {
        a.a(0L);
        f2192a.a();
        f2192a = null;
    }

    private static void a(int i, String str, String str2) {
        a aVar = f2192a;
        if (aVar != null) {
            aVar.a(i, str, str2);
        }
    }

    public static void a(int i, String str, String str2, long j5, long j6) {
        a aVar = f2192a;
        if (aVar != null) {
            aVar.a(i, str, str2, j5, j6);
        }
    }

    public static void a(int i) {
        a aVar = f2192a;
        if (aVar != null) {
            aVar.b(i);
        }
    }

    public static void a(String str, String str2) {
        a(0, str, str2);
    }

    public static File[] a(String str, String str2, long j5, long j6) {
        a aVar = f2192a;
        if (aVar != null) {
            return aVar.a((String) null, (String) null, j5, j6);
        }
        return new File[0];
    }

    public static File[] a(boolean z10, long j5, long j6, int i) {
        a aVar = f2192a;
        if (aVar != null) {
            return aVar.a(z10, j5, j6, i);
        }
        return new File[0];
    }
}
