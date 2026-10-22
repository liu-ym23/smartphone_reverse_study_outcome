package com.bytedance.apm.f;

/* JADX INFO: compiled from: LaunchInitConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f4620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4623e;
    private long f;
    private long g;

    /* JADX INFO: compiled from: LaunchInitConfig.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f4624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f4625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f4626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f4627d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f4628e;
        private long f;
        private long g;

        public a() {
            this.f4624a = false;
            this.f4625b = false;
            this.f4626c = false;
            this.f4627d = false;
            this.f4628e = false;
            this.f = -1;
            this.g = 1000;
        }

        public a a() {
            this.f4624a = true;
            return this;
        }

        public a b() {
            this.f4625b = true;
            return this;
        }

        public a c() {
            this.f4626c = true;
            return this;
        }

        public a d() {
            this.f4627d = true;
            return this;
        }

        public a e() {
            this.f4628e = true;
            return this;
        }

        public a a(long r1) {
            this.g = r1;
            return this;
        }

        public c f() {
            return new c(this.f4624a, this.f4625b, this.f4626c, this.f, this.f4627d, this.g, this.f4628e);
        }
    }

    public c(boolean r1, boolean r2, boolean r3, long r4, boolean r6, long r7, boolean r9) {
        this.f4619a = r1;
        this.f4620b = r2;
        this.f4621c = r3;
        this.f = r4;
        this.f4622d = r6;
        this.g = r7;
        this.f4623e = r9;
    }

    public boolean a() {
        return this.f4619a;
    }

    public boolean b() {
        return this.f4620b;
    }

    public boolean c() {
        return this.f4622d;
    }

    public long d() {
        return this.f;
    }
}
