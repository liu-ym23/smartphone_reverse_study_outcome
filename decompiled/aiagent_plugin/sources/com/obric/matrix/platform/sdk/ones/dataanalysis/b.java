package com.obric.matrix.platform.sdk.ones.dataanalysis;

import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: MatrixTeaConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f33663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f33664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f33665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f33666d;

    /* JADX INFO: compiled from: MatrixTeaConfig.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f33667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f33668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f33669c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f33670d;

        public a() {
            this.f33667a = "";
            this.f33669c = "";
        }

        public final a a(String r2) {
            o.e(r2, "pkgName");
            this.f33667a = r2;
            return this;
        }

        public final a a(int r1) {
            this.f33668b = r1;
            return this;
        }

        public final a b(String r2) {
            o.e(r2, "versionName");
            this.f33669c = r2;
            return this;
        }

        public final a a(boolean r1) {
            this.f33670d = r1;
            return this;
        }

        public final b a() {
            return new b(this.f33667a, this.f33668b, this.f33669c, this.f33670d, null);
        }
    }

    public /* synthetic */ b(String r1, int r2, String r3, boolean r4, h r5) {
        this(r1, r2, r3, r4);
    }

    private b(String r1, int r2, String r3, boolean r4) {
        this.f33663a = r1;
        this.f33664b = r2;
        this.f33665c = r3;
        this.f33666d = r4;
    }

    public final String a() {
        return this.f33663a;
    }

    public final int b() {
        return this.f33664b;
    }

    public final String c() {
        return this.f33665c;
    }

    public final boolean d() {
        return this.f33666d;
    }
}
