package com.bytedance.apm.config;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActivityLeakDetectConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.apm.perf.memory.b f4468e;

    /* JADX INFO: renamed from: com.bytedance.apm.config.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActivityLeakDetectConfig.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.apm.config.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActivityLeakDetectConfig.java */
    public static final class C0113a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f4469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f4470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f4471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f4472d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.bytedance.apm.perf.memory.b f4473e;

        /* synthetic */ C0113a(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ boolean a(C0113a r0) {
            return r0.f4469a;
        }

        static /* synthetic */ long b(C0113a r2) {
            return r2.f4470b;
        }

        static /* synthetic */ boolean c(C0113a r0) {
            return r0.f4471c;
        }

        static /* synthetic */ boolean d(C0113a r0) {
            return r0.f4472d;
        }

        static /* synthetic */ com.bytedance.apm.perf.memory.b e(C0113a r0) {
            return r0.f4473e;
        }

        private C0113a() {
            this.f4469a = false;
            this.f4470b = 60000;
            this.f4471c = false;
            this.f4472d = true;
        }

        public C0113a a(boolean r1) {
            this.f4469a = r1;
            return this;
        }

        public C0113a a(long r1) {
            this.f4470b = r1;
            return this;
        }

        public C0113a b(boolean r1) {
            this.f4471c = r1;
            return this;
        }

        public C0113a c(boolean r1) {
            this.f4472d = r1;
            return this;
        }

        public C0113a a(com.bytedance.apm.perf.memory.b r3) {
            this.f4473e = (com.bytedance.apm.perf.memory.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.apm.perf.memory.b.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    public boolean a() {
        return this.f4464a;
    }

    public long b() {
        return this.f4465b;
    }

    public boolean c() {
        return this.f4466c;
    }

    public boolean d() {
        return this.f4467d;
    }

    public com.bytedance.apm.perf.memory.b e() {
        return this.f4468e;
    }

    public static C0113a f() {
        return new C0113a(null);
    }

    public a(C0113a r3) {
        this.f4464a = C0113a.a(r3);
        this.f4465b = C0113a.b(r3);
        this.f4466c = C0113a.c(r3);
        this.f4467d = C0113a.d(r3);
        this.f4468e = C0113a.e(r3);
    }
}
