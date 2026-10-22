package com.bytedance.android.livesdk.reddot;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f157083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f157084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f157085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f157086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f157087e;

    public final int hashCode() {
        return (((this.f157083a.hashCode() * 31) + this.f157084b) * 31) + this.f157085c;
    }

    public final int getType() {
        return this.f157085c;
    }

    public final int a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if (Intrinsics.areEqual(this, r100) == false) goto L6;
        return 0;
    L6:
        int r101 = r100.f157087e;
        int r102 = this.f157087e;
        if (r101 != r102) goto L9;
        int r103 = this.f157086d - r100.f157086d;
    L10:
        if (r103 != 0) goto L13;
        return -1;
    L13:
        return r103;
    L9:
        r103 = r102 - r101;
        goto L10
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(a r100) {
        return a(r100);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        a r102 = (a) r100;
        if ((!Intrinsics.areEqual(this.f157083a, r102.f157083a)) == false) goto L17;
        return false;
    L17:
        if (this.f157084b == r102.f157084b) goto L20;
        return false;
    L20:
        if (this.f157085c == r102.f157085c) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.reddot.RedDot");
    L8:
        r101 = null;
        goto L10
    }

    public /* synthetic */ a(String r100, int r101, int r102, int r110) {
        this(r100, r101, r102, r110, r101);
    }

    public a(String r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f157083a = r100;
        this.f157084b = r101;
        this.f157085c = r102;
        this.f157086d = r103;
        this.f157087e = r104;
    }
}
