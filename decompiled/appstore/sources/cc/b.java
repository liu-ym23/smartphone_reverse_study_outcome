package cc;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6130a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f6131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f6132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f6133d;

    static {
        f6130a = new b();
        f6133d = -1;
    }

    public b() {
    }

    public final long a() {
        return f6133d;
    }

    public final String b() {
        return f6132c;
    }

    public final int c() {
        return f6131b;
    }

    public final void d() {
        f6133d = SystemClock.elapsedRealtime();
    }

    public final boolean e() {
        if (f6131b == 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean f() {
        if (f6131b != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void g(String r10) {
        f6132c = r10;
    }

    public final void h(int r10) {
        f6131b = r10;
    }
}
