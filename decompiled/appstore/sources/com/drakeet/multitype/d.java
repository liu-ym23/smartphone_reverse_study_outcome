package com.drakeet.multitype;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f10267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f10268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Linker f10269c;

    public d(Class r10, c r11, Linker r12) {
        q.h(r10, "clazz");
        q.h(r11, "delegate");
        q.h(r12, "linker");
        this.f10267a = r10;
        this.f10268b = r11;
        this.f10269c = r12;
    }

    public final Class a() {
        return this.f10267a;
    }

    public final c b() {
        return this.f10268b;
    }

    public final Linker c() {
        return this.f10269c;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof d) == false) goto L12;
        d r11 = (d) r10;
        if (q.b(this.f10267a, r11.f10267a) == true) goto L8;
        return false;
    L8:
        if (q.b(this.f10268b, r11.f10268b) == true) goto L10;
        return false;
    L10:
        if (q.b(this.f10269c, r11.f10269c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Class r10 = this.f10267a;
        int r11 = 0;
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        int r13 = r12 * 31;
        c r14 = this.f10268b;
        if (r14 == null) goto L9;
        int r15 = r14.hashCode();
    L10:
        int r16 = (r13 + r15) * 31;
        Linker r17 = this.f10269c;
        if (r17 == null) goto L14;
        r11 = r17.hashCode();
    L14:
        return r16 + r11;
    L9:
        r15 = 0;
        goto L10
    L5:
        r12 = 0;
        goto L6
    }

    public String toString() {
        return "Type(clazz=" + this.f10267a + ", delegate=" + this.f10268b + ", linker=" + this.f10269c + ")";
    }
}
