package com.bytedance.android.live.multilink.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f83541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f83542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f83543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f83544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f83545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f83546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f83547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f83548h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof w2) == false) goto L22;
        w2 r101 = (w2) r100;
        if (this.f83541a == r101.f83541a) goto L8;
        return false;
    L8:
        if (this.f83542b == r101.f83542b) goto L10;
        return false;
    L10:
        if (this.f83543c == r101.f83543c) goto L12;
        return false;
    L12:
        if (this.f83544d == r101.f83544d) goto L14;
        return false;
    L14:
        if (this.f83545e == r101.f83545e) goto L16;
        return false;
    L16:
        if (this.f83546f == r101.f83546f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f83547g, r101.f83547g) == true) goto L20;
        return false;
    L20:
        if (this.f83548h == r101.f83548h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f83541a * 31) + this.f83542b) * 31) + this.f83543c) * 31) + this.f83544d) * 31) + this.f83545e) * 31) + this.f83546f) * 31;
        String r101 = this.f83547g;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((r100 + r102) * 31) + this.f83548h;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "LinkResult(layout=" + this.f83541a + ", scene=" + this.f83542b + ", finalScene=" + this.f83543c + ", source=" + this.f83544d + ", uiLayout=" + this.f83545e + ", initType=" + this.f83546f + ", openSource=" + this.f83547g + ", playMode=" + this.f83548h + ")";
    }

    public w2(int r100, int r101, int r102, int r103, int r104, int r105, String r106, int r107) {
        Intrinsics.checkNotNullParameter(r106, "openSource");
        this.f83541a = r100;
        this.f83542b = r101;
        this.f83543c = r102;
        this.f83544d = r103;
        this.f83545e = r104;
        this.f83546f = r105;
        this.f83547g = r106;
        this.f83548h = r107;
    }
}
