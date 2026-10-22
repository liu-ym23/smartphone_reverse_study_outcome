package com.bytedance.android.live.profile.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f86075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f86076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f86077c;

    public final int hashCode() {
        return (((this.f86075a * 31) + this.f86076b) * 31) + this.f86077c;
    }

    public final String toString() {
        return "visitType-" + this.f86075a + ",targetType-" + this.f86076b + ",specialType-" + this.f86077c;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(d.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L24;
        d r102 = (d) r100;
        if (this.f86075a == r102.f86075a) goto L17;
        return false;
    L17:
        if (this.f86076b == r102.f86076b) goto L20;
        return false;
    L20:
        if (this.f86077c == r102.f86077c) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profile.model.NewUserPageType");
    L8:
        r101 = null;
        goto L10
    }

    public d(int r100, int r101, int r102) {
        this.f86075a = r100;
        this.f86076b = r101;
        this.f86077c = r102;
    }
}
