package androidx.work;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f5421a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile i f5422b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5423c = 20;

    public static class a extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f5424d;

        public a(int r10) {
            super(r10);
            this.f5424d = r10;
        }

        @Override // androidx.work.i
        public void a(String r10, String r11) {
            if (this.f5424d > 3) goto L6;
            Log.d(r10, r11);
            return;
        }

        @Override // androidx.work.i
        public void b(String r10, String r11, Throwable r12) {
            if (this.f5424d > 3) goto L6;
            Log.d(r10, r11, r12);
            return;
        }

        @Override // androidx.work.i
        public void c(String r10, String r11) {
            if (this.f5424d > 6) goto L6;
            Log.e(r10, r11);
            return;
        }

        @Override // androidx.work.i
        public void d(String r10, String r11, Throwable r12) {
            if (this.f5424d > 6) goto L6;
            Log.e(r10, r11, r12);
            return;
        }

        @Override // androidx.work.i
        public void f(String r10, String r11) {
            if (this.f5424d > 4) goto L6;
            Log.i(r10, r11);
            return;
        }

        @Override // androidx.work.i
        public void g(String r10, String r11, Throwable r12) {
            if (this.f5424d > 4) goto L6;
            Log.i(r10, r11, r12);
            return;
        }

        @Override // androidx.work.i
        public void j(String r10, String r11) {
            if (this.f5424d > 2) goto L6;
            Log.v(r10, r11);
            return;
        }

        @Override // androidx.work.i
        public void k(String r10, String r11) {
            if (this.f5424d > 5) goto L6;
            Log.w(r10, r11);
            return;
        }

        @Override // androidx.work.i
        public void l(String r10, String r11, Throwable r12) {
            if (this.f5424d > 5) goto L6;
            Log.w(r10, r11, r12);
            return;
        }
    }

    static {
        f5421a = new Object();
    }

    public i(int r10) {
    }

    public static i e() {
        Object r10 = f5421a;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f5422b != null) goto L9;
        f5422b = new a(3);     // Catch: Throwable -> L7
    L9:
        i r11 = f5422b;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    }

    public static void h(i r10) {
        Object r11 = f5421a;
        monitor-enter(r11);
        f5422b = r10;     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static String i(String r10) {
        int r11 = r10.length();
        StringBuilder r12 = new StringBuilder(23);
        r12.append("WM-");
        int r13 = f5423c;
        if (r11 < r13) goto L5;
        r12.append(r10.substring(0, r13));
    L7:
        return r12.toString();
    L5:
        r12.append(r10);
        goto L7
    }

    public abstract void a(String r10, String r11);

    public abstract void b(String r10, String r11, Throwable r12);

    public abstract void c(String r10, String r11);

    public abstract void d(String r10, String r11, Throwable r12);

    public abstract void f(String r10, String r11);

    public abstract void g(String r10, String r11, Throwable r12);

    public abstract void j(String r10, String r11);

    public abstract void k(String r10, String r11);

    public abstract void l(String r10, String r11, Throwable r12);
}
