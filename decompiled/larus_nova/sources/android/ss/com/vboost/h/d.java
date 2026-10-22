package android.ss.com.vboost.h;

import android.content.Context;
import android.ss.com.vboost.utils.LogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4630a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f4631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static e.a f4632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f4633d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4634a = null;

        static {
            int[] r100 = new int[e.a.values().length];
            f4634a = r100;
            r100[e.a.f4639c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f4634a[e.a.f4638b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f4634a[e.a.f4640d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f4632c = e.a.f4642f;
        f4633d = false;
    }

    public static e.a a() {
        return f4632c;
    }

    public static void a(long r100) {
        f4631b.a(r100);
    }

    public static boolean a(Context r100) {
        f4632c = e.b();
        int r101 = a.f4634a[f4632c.ordinal()];
        if (r101 != 1) goto L5;
        c r102 = new f();
    L12:
        f4631b = r102;
    L13:
        c r103 = f4631b;
        if (r103 != null) goto L16;
        return false;
    L16:
        if (r103.a(r100) == false) goto L21;
        f4633d = true;
        return true;
    L21:
        return false;
    L5:
        if (r101 != 2) goto L7;
        r102 = new i();
        goto L12
    L7:
        if (r101 == 3) goto L9;
        LogUtil.error(f4630a, "Platform " + f4632c + " not support!");
        goto L13
    L9:
        r102 = new b();
        goto L12
    }

    public static void b(long r100) {
        f4631b.b(r100);
    }

    public static boolean b() {
        return f4633d;
    }

    public static void c() {
        f4631b.a();
    }

    public static void c(long r100) {
        f4631b.c(r100);
    }

    public static void d() {
        f4631b.b();
    }
}
