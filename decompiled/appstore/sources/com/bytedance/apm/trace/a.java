package com.bytedance.apm.trace;

import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.launch.evil.b;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TraceStats f6554a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f6555b = false;

    /* JADX INFO: renamed from: com.bytedance.apm.trace.a$a, reason: collision with other inner class name */
    public static class C0075a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f6557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6559d;

        /* JADX INFO: renamed from: com.bytedance.apm.trace.a$a$a, reason: collision with other inner class name */
        public static class C0076a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f6560a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f6561b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f6562c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f6563d;

            public C0076a() {
            }

            public static /* synthetic */ boolean a(C0076a r10) {
                return r10.f6560a;
            }

            public static /* synthetic */ boolean b(C0076a r10) {
                return r10.f6561b;
            }

            public static /* synthetic */ boolean c(C0076a r10) {
                return r10.f6562c;
            }

            public static /* synthetic */ boolean d(C0076a r10) {
                return r10.f6563d;
            }

            public C0075a e() {
                return new C0075a(this, null);
            }
        }

        public /* synthetic */ C0075a(C0076a r10, e2.a r11) {
            this(r10);
        }

        public boolean a() {
            return this.f6558c;
        }

        public boolean b() {
            return this.f6557b;
        }

        public C0075a(C0076a r10) {
            this.f6556a = C0076a.a(r10);
            this.f6557b = C0076a.b(r10);
            this.f6558c = C0076a.c(r10);
            this.f6559d = C0076a.d(r10);
        }
    }

    static {
    }

    public static void a() {
        if (f6555b == false) goto L5;
        b.c();
    L5:
        TraceStats r10 = f6554a;
        if (r10 == null) goto L9;
        r10.d();
        f6554a = null;
        return;
    }

    public static void b(String r10, String r11) {
        TraceStats r12 = f6554a;
        if (r12 == null) goto L6;
        r12.e(r10, r11);
        return;
    }

    public static void c(int r10, String r11, long r12) {
        d(r10, r11, r12, 0);
    }

    public static void d(int r10, String r11, long r12, long r13) {
        if (f6555b == false) goto L5;
        b.c();
    L5:
        TraceStats r14 = f6554a;
        if (r14 == null) goto L9;
        r14.f(r10, r11, r12, r13);
        return;
    }

    public static long e() {
        TraceStats r10 = f6554a;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.h();
    }

    public static void f(int r10) {
        boolean r11 = true;
        if ((r10 & 1) != 0) goto L5;
    L8:
        l1.b.H(r11);
        return;
    L5:
        if (r1.a.b().a().c() == true) goto L8;
        r11 = false;
        goto L8
    }

    public static void g(long r10) {
        l1.b.I(r10);
    }

    public static void h(String r10, String r11) {
        TraceStats r12 = f6554a;
        if (r12 == null) goto L6;
        r12.l(r10, r11);
        return;
    }

    public static void i() {
        TraceStats r10 = new TraceStats("start_trace", TraceStatsConsts.START_STATS_NAME);
        f6554a = r10;
        r10.n();
        if (c.G() == false) goto L8;
        boolean r11 = EvilMethodSwitcher.isOpenLaunchEvilMethod();
        f6555b = r11;
        if (r11 == false) goto L9;
        b.b();
        return;
    L9:
        return;
    }
}
