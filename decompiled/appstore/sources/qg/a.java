package qg;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b[] f23663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f23664b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile b[] f23665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f23666d = null;

    /* JADX INFO: renamed from: qg.a$a, reason: collision with other inner class name */
    public static class C0344a extends b {
        public C0344a() {
        }

        @Override // qg.a.b
        public void a(String r10, Object... r11) {
            b[] r12 = a.f23665c;
            int r13 = r12.length;
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L5;
            r12[r14].a(r10, r11);
            r14 = r14 + 1;
            goto L3
        }

        @Override // qg.a.b
        public void b(String r10, Object... r11) {
            b[] r12 = a.f23665c;
            int r13 = r12.length;
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L5;
            r12[r14].b(r10, r11);
            r14 = r14 + 1;
            goto L3
        }

        @Override // qg.a.b
        public void c(Throwable r10) {
            b[] r11 = a.f23665c;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r11[r13].c(r10);
            r13 = r13 + 1;
            goto L3
        }

        @Override // qg.a.b
        public void d(String r10, Object... r11) {
            b[] r12 = a.f23665c;
            int r13 = r12.length;
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L5;
            r12[r14].d(r10, r11);
            r14 = r14 + 1;
            goto L3
        }

        @Override // qg.a.b
        public void e(String r10, Object... r11) {
            b[] r12 = a.f23665c;
            int r13 = r12.length;
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L5;
            r12[r14].e(r10, r11);
            r14 = r14 + 1;
            goto L3
        }

        @Override // qg.a.b
        public void f(String r10, Object... r11) {
            b[] r12 = a.f23665c;
            int r13 = r12.length;
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L5;
            r12[r14].f(r10, r11);
            r14 = r14 + 1;
            goto L3
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadLocal f23667a;

        public b() {
            this.f23667a = new ThreadLocal();
        }

        public abstract void a(String r10, Object... r11);

        public abstract void b(String r10, Object... r11);

        public abstract void c(Throwable r10);

        public abstract void d(String r10, Object... r11);

        public abstract void e(String r10, Object... r11);

        public abstract void f(String r10, Object... r11);
    }

    static {
        b[] r10 = new b[0];
        f23663a = r10;
        f23664b = new ArrayList();
        f23665c = r10;
        f23666d = new C0344a();
    }

    public static void a(Throwable r10) {
        f23666d.c(r10);
    }

    public static b b(String r10) {
        b[] r11 = f23665c;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L6;
        r11[r13].f23667a.set(r10);
        r13 = r13 + 1;
        goto L3
    L6:
        return f23666d;
    }
}
