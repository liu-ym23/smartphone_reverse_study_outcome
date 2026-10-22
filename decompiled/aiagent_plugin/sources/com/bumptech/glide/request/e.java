package com.bumptech.glide.request;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RequestCoordinator.java */
/* JADX INFO: loaded from: classes.dex */
public interface e {

    /* JADX INFO: compiled from: RequestCoordinator.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3918a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f3919b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f3920c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f3921d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f3922e = null;
        private static final /* synthetic */ a[] g = null;
        private final boolean f;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(g.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("RUNNING", 0, false);
            f3918a = r0;
            a r1 = new a("PAUSED", 1, false);
            f3919b = r1;
            a r3 = new a("CLEARED", 2, false);
            f3920c = r3;
            a r5 = new a("SUCCESS", 3, true);
            f3921d = r5;
            a r7 = new a("FAILED", 4, true);
            f3922e = r7;
            g = new a[]{r0, r1, r3, r5, r7};
        }

        private a(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.f = r3;
        }

        boolean a() {
            return this.f;
        }
    }

    boolean b(d r1);

    boolean c(d r1);

    boolean d(d r1);

    void e(d r1);

    void f(d r1);

    boolean g();

    e h();
}
