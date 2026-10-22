package com.bytedance.vmsdk.worker;

import com.bytedance.vmsdk.jsbridge.JSModuleManager;

/* JADX INFO: compiled from: InitParams.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JsWorker.EngineType f11784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f11786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f11787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f11788e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final JSModuleManager j;
    private final boolean k;

    /* JADX INFO: renamed from: com.bytedance.vmsdk.worker.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: InitParams.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: InitParams.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JsWorker.EngineType f11789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f11790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f11791c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f11792d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f11793e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private JSModuleManager j;
        private boolean k;
        private boolean l;

        static /* synthetic */ JsWorker.EngineType a(a r0) {
            return r0.f11789a;
        }

        static /* synthetic */ String b(a r0) {
            return r0.f11790b;
        }

        static /* synthetic */ String c(a r0) {
            return r0.f11791c;
        }

        static /* synthetic */ String d(a r0) {
            return r0.f11792d;
        }

        static /* synthetic */ boolean e(a r0) {
            return r0.f;
        }

        static /* synthetic */ boolean f(a r0) {
            return r0.g;
        }

        static /* synthetic */ boolean g(a r0) {
            return r0.h;
        }

        static /* synthetic */ boolean h(a r0) {
            return r0.i;
        }

        static /* synthetic */ JSModuleManager i(a r0) {
            return r0.j;
        }

        static /* synthetic */ boolean j(a r0) {
            return r0.l;
        }

        static /* synthetic */ boolean k(a r0) {
            return r0.k;
        }

        public a() {
            this.f11789a = JsWorker.EngineType.QUICKJS;
            this.f11790b = JsWorker.DEFAULT_BIZ_NAME;
            this.f11791c = "";
            this.f11792d = null;
            this.f11793e = "";
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = null;
            this.k = false;
            this.l = false;
        }

        public a a(JsWorker.EngineType r1) {
            this.f11789a = r1;
            return this;
        }

        public a a(String r1) {
            this.f11790b = r1;
            return this;
        }

        public a b(String r1) {
            this.f11792d = r1;
            return this;
        }

        public a a(boolean r1) {
            this.g = r1;
            return this;
        }

        public a b(boolean r1) {
            this.i = r1;
            return this;
        }

        public a a(JSModuleManager r1) {
            this.j = r1;
            return this;
        }

        public c a() {
            return new c(this, null);
        }
    }

    /* synthetic */ c(a r1, AnonymousClass1 r2) {
        this(r1);
    }

    private c(a r2) {
        this.f11784a = a.a(r2);
        this.f11785b = a.b(r2);
        this.f11786c = a.c(r2);
        this.f11787d = a.d(r2);
        this.f11788e = a.e(r2);
        this.g = a.f(r2);
        this.h = a.g(r2);
        this.f = a.h(r2);
        this.j = a.i(r2);
        this.i = a.j(r2);
        this.k = a.k(r2);
    }

    public JsWorker.EngineType a() {
        return this.f11784a;
    }

    public String b() {
        return this.f11785b;
    }

    public String c() {
        return this.f11787d;
    }

    public boolean d() {
        return this.f;
    }

    public boolean e() {
        return this.g;
    }

    public JSModuleManager f() {
        return this.j;
    }

    public boolean g() {
        return this.i;
    }

    public boolean h() {
        return this.k;
    }
}
