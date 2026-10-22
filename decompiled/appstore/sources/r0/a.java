package r0;

import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f23673a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f23674b;

    /* JADX INFO: renamed from: r0.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0346a {
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: r0.a$b$a, reason: collision with other inner class name */
        public static class C0347a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f23675a = null;

            static {
                f23675a = new b(null);
            }

            public static /* synthetic */ b a() {
                return f23675a;
            }
        }

        public /* synthetic */ b(C0346a r10) {
            this();
        }

        public static b m() {
            return C0347a.a();
        }

        @Override // r0.a.c
        public void b(String r10, String r11) {
            Log.d(r10, r11);
        }

        @Override // r0.a.c
        public void c(String r10, String r11, Throwable r12) {
            Log.d(r10, r11, r12);
        }

        @Override // r0.a.c
        public void d(String r10, String r11) {
            Log.e(r10, r11);
        }

        @Override // r0.a.c
        public void e(String r10, String r11, Throwable r12) {
            Log.e(r10, r11, r12);
        }

        @Override // r0.a.c
        public void f(String r10, String r11) {
            Log.i(r10, r11);
        }

        @Override // r0.a.c
        public void g(String r10, String r11, Throwable r12) {
            Log.i(r10, r11, r12);
        }

        @Override // r0.a.c
        public void i(String r10, String r11) {
            Log.v(r10, r11);
        }

        @Override // r0.a.c
        public void j(String r10, String r11, Throwable r12) {
            Log.v(r10, r11, r12);
        }

        @Override // r0.a.c
        public void k(String r10, String r11) {
            Log.w(r10, r11);
        }

        @Override // r0.a.c
        public void l(String r10, String r11, Throwable r12) {
            Log.w(r10, r11, r12);
        }

        public b() {
        }
    }

    public static abstract class c {
        public c() {
        }

        public boolean a(int r10) {
            if (a.i() > r10) goto L5;
            return true;
        L5:
            return false;
        }

        public abstract void b(String r10, String r11);

        public abstract void c(String r10, String r11, Throwable r12);

        public abstract void d(String r10, String r11);

        public abstract void e(String r10, String r11, Throwable r12);

        public abstract void f(String r10, String r11);

        public abstract void g(String r10, String r11, Throwable r12);

        public void h(String r10, String r11) {
        }

        public abstract void i(String r10, String r11);

        public abstract void j(String r10, String r11, Throwable r12);

        public abstract void k(String r10, String r11);

        public abstract void l(String r10, String r11, Throwable r12);
    }

    static {
        f23674b = b.m();
    }

    public static void a(String r10) {
        if (e() == false) goto L6;
        f(Log.getStackTraceString(new IllegalStateException(r10)));
        return;
    }

    public static void b(String r10) {
        c("Logger", r10);
    }

    public static void c(String r10, String r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (f23674b.a(3) == false) goto L8;
        f23674b.b(r10, r11);
        return;
    }

    public static void d(String r10, String r11, Throwable r12) {
        if (r11 != null) goto L6;
        if (r12 != null) goto L6;
        return;
    L6:
        if (f23674b.a(3) == false) goto L9;
        f23674b.c(r10, r11, r12);
        return;
    }

    public static boolean e() {
        if (f23673a > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static void f(String r10) {
        g("Logger", r10);
    }

    public static void g(String r10, String r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (f23674b.a(6) == false) goto L8;
        f23674b.d(r10, r11);
        return;
    }

    public static void h(String r10, String r11, Throwable r12) {
        if (r11 != null) goto L6;
        if (r12 != null) goto L6;
        return;
    L6:
        if (f23674b.a(6) == false) goto L9;
        f23674b.e(r10, r11, r12);
        return;
    }

    public static int i() {
        return f23673a;
    }

    public static String j(String r10) {
        int r11 = r10.lastIndexOf(46);
        if (r11 >= 0) goto L6;
        return r10;
    L6:
        return r10.substring(r11 + 1);
    }

    public static void k(String r10) {
        l("Logger", r10);
    }

    public static void l(String r10, String r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (f23674b.a(4) == false) goto L8;
        f23674b.f(r10, r11);
        return;
    }

    public static void m(String r10, String r11, Throwable r12) {
        if (r11 != null) goto L6;
        if (r12 != null) goto L6;
        return;
    L6:
        if (f23674b.a(4) == false) goto L9;
        f23674b.g(r10, r11, r12);
        return;
    }

    public static void n(String r10) {
        o("Logger", r10);
    }

    public static void o(String r10, String r11) {
        if (f23674b.a(3) == false) goto L6;
        f23674b.h(r10, r11);
        return;
    }

    public static void p(c r10) {
        f23674b = r10;
    }

    public static void q(int r10) {
        f23673a = r10;
    }

    public static void r(String r10, int r11) {
    L4:
        e = move-exception;
        StackTraceElement[] r12 = e.getStackTrace();
        StringBuilder r13 = new StringBuilder();
        int r14 = 1;
    L7:
        if (r14 >= Math.min(r11, r12.length)) goto L11;
        if (r14 <= 1) goto L10;
        r13.append("\n");
    L10:
        r13.append(j(r12[r14].getClassName()));
        r13.append(LibrarianImpl.Constants.DOT);
        r13.append(r12[r14].getMethodName());
        r14 = r14 + 1;
        goto L7
    L11:
        u(r10, r13.toString());
        return;
    L3:
        throw new Exception();     // Catch: Exception -> L4
    }

    public static void s(Throwable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.printStackTrace();
        if (e() == false) goto L8;
        f(Log.getStackTraceString(new RuntimeException("Error! Now in debug, we alert to you to correct it !", r10)));
        return;
    }

    public static void t(String r10) {
        u("Logger", r10);
    }

    public static void u(String r10, String r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (f23674b.a(2) == false) goto L8;
        f23674b.i(r10, r11);
        return;
    }

    public static void v(String r10, String r11, Throwable r12) {
        if (r11 != null) goto L6;
        if (r12 != null) goto L6;
        return;
    L6:
        if (f23674b.a(2) == false) goto L9;
        f23674b.j(r10, r11, r12);
        return;
    }

    public static void w(String r10) {
        x("Logger", r10);
    }

    public static void x(String r10, String r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (f23674b.a(5) == false) goto L8;
        f23674b.k(r10, r11);
        return;
    }

    public static void y(String r10, String r11, Throwable r12) {
        if (r11 != null) goto L6;
        if (r12 != null) goto L6;
        return;
    L6:
        if (f23674b.a(5) == false) goto L9;
        f23674b.l(r10, r11, r12);
        return;
    }
}
