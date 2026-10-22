package com.smt.obric.appstore.domain.app;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f18022d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.smt.obric.appstore.domain.app.entity.a f18023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18025c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final i a(com.smt.obric.appstore.domain.app.entity.a r10, String r11) {
            q.g(r10, "task");
            q.g(r11, "actualMd5");
            return new i(r10, -99, "apk file md5 not match, expect=" + r10.x() + ", actual=" + r11);
        }

        public final i b(com.smt.obric.appstore.domain.app.entity.a r10) {
            q.g(r10, "task");
            return new i(r10, -99, "apk file not found");
        }

        public final i c(com.smt.obric.appstore.domain.app.entity.a r10) {
            q.g(r10, "task");
            return new i(r10, -99, "invalid taskId, taskId=" + r10.A());
        }

        public final i d(com.smt.obric.appstore.domain.app.entity.a r10) {
            q.g(r10, "task");
            return new i(r10, -990001, "user cancel install");
        }

        public a() {
        }
    }

    static {
        f18022d = new a(null);
    }

    public i(com.smt.obric.appstore.domain.app.entity.a r10, int r11, String r12) {
        q.g(r10, "task");
        this.f18023a = r10;
        this.f18024b = r11;
        this.f18025c = r12;
    }

    public final int a() {
        return this.f18024b;
    }

    public final String b() {
        return this.f18025c;
    }

    public final boolean c() {
        if (this.f18024b != (-990000)) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean d() {
        if (this.f18024b == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final com.smt.obric.appstore.domain.app.entity.a e() {
        return this.f18023a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof i) == true) goto L8;
        return false;
    L8:
        i r11 = (i) r10;
        if (q.b(this.f18023a, r11.f18023a) == true) goto L12;
        return false;
    L12:
        if (this.f18024b == r11.f18024b) goto L15;
        return false;
    L15:
        if (q.b(this.f18025c, r11.f18025c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final boolean f() {
        if (this.f18024b != (-990001)) goto L5;
        return true;
    L5:
        return false;
    }

    public final String g() {
        return "AppInstallResult(succ=" + d() + ", code=" + this.f18024b + ", errMsg=" + this.f18025c + ", taskId=" + this.f18023a.A() + ", dlId=" + this.f18023a.o() + ", task=" + this.f18023a.P() + ')';
    }

    public int hashCode() {
        int r10 = ((this.f18023a.hashCode() * 31) + Integer.hashCode(this.f18024b)) * 31;
        String r11 = this.f18025c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public String toString() {
        return "AppInstallResult(task=" + this.f18023a + ", code=" + this.f18024b + ", errMsg=" + this.f18025c + ')';
    }

    public /* synthetic */ i(com.smt.obric.appstore.domain.app.entity.a r10, int r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        this(r10, r11, r12);
    }
}
