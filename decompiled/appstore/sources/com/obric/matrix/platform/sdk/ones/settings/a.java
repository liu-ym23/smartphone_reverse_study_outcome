package com.obric.matrix.platform.sdk.ones.settings;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11953e;

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.settings.a$a, reason: collision with other inner class name */
    public static final class C0188a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f11956c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f11957d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f11958e;

        public C0188a() {
            this.f11954a = "";
            this.f11956c = "";
            this.f11958e = "";
        }

        public final a a() {
            return new a(this.f11954a, this.f11955b, this.f11956c, this.f11957d, this.f11958e, null);
        }

        public final C0188a b(boolean r10) {
            this.f11957d = r10;
            return this;
        }

        public final C0188a c(String r10) {
            q.g(r10, "pkgName");
            this.f11954a = r10;
            return this;
        }

        public final C0188a d(int r10) {
            this.f11955b = r10;
            return this;
        }

        public final C0188a e(String r10) {
            q.g(r10, "versionName");
            this.f11956c = r10;
            return this;
        }
    }

    public /* synthetic */ a(String r10, int r11, String r12, boolean r13, String r14, DefaultConstructorMarker r15) {
        this(r10, r11, r12, r13, r14);
    }

    public final String a() {
        return this.f11949a;
    }

    public final String b() {
        return this.f11953e;
    }

    public a(String r10, int r11, String r12, boolean r13, String r14) {
        this.f11949a = r10;
        this.f11950b = r11;
        this.f11951c = r12;
        this.f11952d = r13;
        this.f11953e = r14;
    }
}
