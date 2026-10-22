package com.obric.matrix.platform.sdk.ones.init;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f11911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11913e;

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.init.a$a, reason: collision with other inner class name */
    public static final class C0186a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f11916c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f11917d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f11918e;

        public C0186a() {
            this.f11917d = "";
            this.f11918e = "";
        }

        public final a a() {
            String r10 = null;
            return new a(this.f11914a, this.f11915b, this.f11916c, this.f11917d, r10, 16, null);
        }

        public final C0186a b(int r10) {
            this.f11914a = r10;
            return this;
        }

        public final C0186a c(boolean r10) {
            this.f11915b = r10;
            return this;
        }
    }

    public a(int r10, boolean r11, long r12, String r13, String r14) {
        this.f11909a = r10;
        this.f11910b = r11;
        this.f11911c = r12;
        this.f11912d = r13;
        this.f11913e = r14;
    }

    public final int a() {
        return this.f11909a;
    }

    public final String b() {
        return this.f11913e;
    }

    public final String c() {
        return this.f11912d;
    }

    public final boolean d() {
        return this.f11910b;
    }

    public /* synthetic */ a(int r10, boolean r11, long r12, String r13, String r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 4) == 0) goto L5;
        r12 = 0;
    L5:
        long r17 = r12;
        if ((r15 & 8) == 0) goto L8;
        String r18 = "";
    L10:
        if ((r15 & 16) == 0) goto L12;
        String r19 = "";
    L13:
        this(r10, r11, r17, r18, r19);
        return;
    L12:
        r19 = r14;
        goto L13
    L8:
        r18 = r13;
        goto L10
    }
}
