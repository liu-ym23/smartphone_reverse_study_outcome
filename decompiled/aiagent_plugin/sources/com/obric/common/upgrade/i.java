package com.obric.common.upgrade;

import d.h.b.o;

/* JADX INFO: compiled from: UpgradeConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f32638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f32639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f32640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f32641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f32642e;
    private final boolean f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private int k;
    private int l;

    /* JADX INFO: compiled from: UpgradeConfig.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f32643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f32644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f32645c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f32646d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f32647e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private int k;
        private int l;

        public a() {
            this.f32643a = "";
            this.f32644b = "";
            this.f32645c = 1;
            this.f32646d = "";
            this.f = "";
            this.g = "";
            this.h = "";
            this.i = "";
            this.j = "";
            this.k = 60;
            this.l = 60;
        }

        public final a a(int r1) {
            this.l = r1;
            return this;
        }

        public final a b(int r1) {
            this.k = r1;
            return this;
        }

        public final a a(String r2) {
            o.e(r2, "versionName");
            this.j = r2;
            return this;
        }

        public final a a(boolean r1) {
            this.f32647e = r1;
            return this;
        }

        public final a b(String r2) {
            o.e(r2, "accesskey");
            this.h = r2;
            return this;
        }

        public final a c(String r2) {
            o.e(r2, "secretKey");
            this.i = r2;
            return this;
        }

        public final a d(String r2) {
            o.e(r2, "osVersion");
            this.f = r2;
            return this;
        }

        public final a e(String r2) {
            o.e(r2, "appId");
            this.g = r2;
            return this;
        }

        public final a f(String r2) {
            o.e(r2, "did");
            this.f32643a = r2;
            return this;
        }

        public final a g(String r2) {
            o.e(r2, "deviceModel");
            this.f32644b = r2;
            return this;
        }

        public final a a(long r1) {
            this.f32645c = r1;
            return this;
        }

        public final a h(String r2) {
            o.e(r2, "packageName");
            this.f32646d = r2;
            return this;
        }

        public final i a() {
            return new i(this.f32643a, this.f32644b, this.f32645c, this.j, this.f32646d, this.f32647e, this.f, this.g, this.h, this.i, this.k, this.l);
        }
    }

    public i(String r2, String r3, long r4, String r6, String r7, boolean r8, String r9, String r10, String r11, String r12, int r13, int r14) {
        o.e(r2, "did");
        o.e(r3, "deviceModel");
        o.e(r6, "versionName");
        o.e(r7, "packageName");
        o.e(r9, "osVersion");
        o.e(r10, "appId");
        o.e(r11, "accesskey");
        o.e(r12, "secretKey");
        this.f32638a = r2;
        this.f32639b = r3;
        this.f32640c = r4;
        this.f32641d = r6;
        this.f32642e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r13;
        this.l = r14;
    }

    public final String a() {
        return this.f32638a;
    }

    public final String b() {
        return this.f32639b;
    }

    public final long c() {
        return this.f32640c;
    }

    public final String d() {
        return this.f32641d;
    }

    public final String e() {
        return this.f32642e;
    }

    public final boolean f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public final String i() {
        return this.i;
    }

    public final String j() {
        return this.j;
    }

    public final int k() {
        return this.k;
    }

    public final int l() {
        return this.l;
    }
}
