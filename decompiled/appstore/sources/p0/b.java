package p0;

import com.bytedance.android.alog.Alog;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Alog f23264a;

    static {
    }

    public static void a() {
        Alog r10 = f23264a;
        if (r10 == null) goto L6;
        r10.h();
        return;
    }

    public static void b(String r10, String r11) {
        h(4, r10, r11);
    }

    public static long c() {
        Alog r10 = f23264a;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.l();
    }

    public static File[] d(String r10, String r11, long r12, long r13) {
        Alog r14 = f23264a;
        if (r14 == null) goto L7;
        return r14.m(r10, r11, r12, r13);
    L7:
        return new File[0];
    }

    public static void e(String r10, String r11) {
        h(2, r10, r11);
    }

    public static void f(Alog r10) {
        f23264a = r10;
        if (r10 != null) goto L5;
        long r11 = 0;
    L6:
        Alog.nativeSetDefaultInstance(r11);
        return;
    L5:
        r11 = r10.n();
        goto L6
    }

    public static void g(boolean r10) {
        Alog r11 = f23264a;
        if (r11 == null) goto L6;
        r11.q(r10);
        return;
    }

    public static void h(int r10, String r11, String r12) {
        Alog r13 = f23264a;
        if (r13 == null) goto L6;
        r13.t(r10, r11, r12);
        return;
    }

    public static void i(int r10, String r11, String r12, long r13, long r14) {
        Alog r15 = f23264a;
        if (r15 == null) goto L6;
        r15.u(r10, r11, r12, r13, r14);
        return;
    }
}
