package com.bytedance.apm.trace;

import com.bytedance.apm.block.evil.EvilMethodSwitcher;
import com.bytedance.monitor.collector.LockMonitorManager;
import com.bytedance.monitor.collector.k;

/* JADX INFO: compiled from: LaunchTrace.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static final String TAG = "AppStartStats";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f4888a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4889b = false;

    /* JADX INFO: renamed from: com.bytedance.apm.trace.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: LaunchTrace.java */
    static class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f4890a;

        @Override // java.lang.Runnable
        public void run() {
            if (k.a().c() == false) goto L6;
            LockMonitorManager.startLockDetect(this.f4890a);
            return;
        }
    }

    /* JADX INFO: compiled from: LaunchTrace.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f4891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f4892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f4893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f4894d;

        /* JADX INFO: renamed from: com.bytedance.apm.trace.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: LaunchTrace.java */
        public static class C0119a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f4895a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f4896b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private boolean f4897c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f4898d;

            public C0119a() {
            }

            static /* synthetic */ boolean a(C0119a r0) {
                return r0.f4895a;
            }

            static /* synthetic */ boolean b(C0119a r0) {
                return r0.f4896b;
            }

            static /* synthetic */ boolean c(C0119a r0) {
                return r0.f4897c;
            }

            static /* synthetic */ boolean d(C0119a r0) {
                return r0.f4898d;
            }

            public a a() {
                return new a(this, null);
            }
        }

        /* synthetic */ a(C0119a r1, AnonymousClass1 r2) {
            this(r1);
        }

        private a(C0119a r2) {
            this.f4891a = C0119a.a(r2);
            this.f4892b = C0119a.b(r2);
            this.f4893c = C0119a.c(r2);
            this.f4894d = C0119a.d(r2);
        }

        public boolean a() {
            return this.f4892b;
        }

        public boolean b() {
            return this.f4893c;
        }
    }

    static {
    }

    public static void a() {
        e r0 = new e("start_trace", "launch_stats");
        f4888a = r0;
        r0.b();
        if (com.bytedance.apm.c.e() == false) goto L8;
        boolean r1 = EvilMethodSwitcher.isOpenLaunchEvilMethod();
        f4889b = r1;
        if (r1 == false) goto L9;
        com.bytedance.apm.f.a.b.a();
        return;
    L9:
        return;
    }

    public static void a(String r1, String r2) {
        e r0 = f4888a;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public static void b(String r1, String r2) {
        e r0 = f4888a;
        if (r0 == null) goto L6;
        r0.b(r1, r2);
        return;
    }

    public static void a(int r6, String r7, long r8) {
        a(r6, r7, r8, 0);
    }

    public static void a(int r8, String r9, long r10, long r12) {
        if (f4889b == false) goto L5;
        com.bytedance.apm.f.a.b.b();
    L5:
        e r1 = f4888a;
        if (r1 == null) goto L9;
        r1.a(r8, r9, r10, r12);
        return;
    }

    public static void b() {
        if (f4889b == false) goto L5;
        com.bytedance.apm.f.a.b.b();
    L5:
        e r0 = f4888a;
        if (r0 == null) goto L9;
        r0.c();
        f4888a = null;
        return;
    }

    public static long c() {
        e r0 = f4888a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.a();
    }

    @Deprecated
    public static void a(long r0) {
        com.bytedance.apm.d.a.d.a(r0);
    }

    @Deprecated
    public static void a(int r1) {
        boolean r0 = true;
        if ((r1 & 1) != 0) goto L5;
    L8:
        com.bytedance.apm.d.a.d.c(r0);
        return;
    L5:
        if (com.bytedance.apm.f.a.a().b().b() == true) goto L8;
        r0 = false;
        goto L8
    }
}
