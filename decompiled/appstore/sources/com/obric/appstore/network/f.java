package com.obric.appstore.network;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10969c;

    public f(String r10, String r11, String r12) {
        this.f10967a = r10;
        this.f10968b = r11;
        this.f10969c = r12;
    }

    public final String a() {
        return this.f10969c;
    }

    public final String b() {
        return this.f10968b;
    }

    public final String c() {
        return this.f10967a;
    }

    public final void d(String r10) {
        this.f10969c = r10;
    }

    public final void e(String r10) {
        this.f10968b = r10;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
        if (q.b(this.f10967a, r11.f10967a) == true) goto L12;
        return false;
    L12:
        if (q.b(this.f10968b, r11.f10968b) == true) goto L15;
        return false;
    L15:
        if (q.b(this.f10969c, r11.f10969c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final void f(String r10) {
        this.f10967a = r10;
    }

    public int hashCode() {
        String r10 = this.f10967a;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.f10968b;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f10969c;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return r16 + r11;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "CategoryEntity(title=" + this.f10967a + ", picture=" + this.f10968b + ", categoryId=" + this.f10969c + ')';
    }

    public /* synthetic */ f(String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
