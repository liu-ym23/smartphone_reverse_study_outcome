package com.bytedance.android.gamecp.common.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f57211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f57212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f57213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f57214d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c0) == false) goto L14;
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f57211a, r101.f57211a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f57212b, r101.f57212b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f57213c, r101.f57213c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f57214d, r101.f57214d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f57211a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f57212b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Object r107 = this.f57213c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Object r110 = this.f57214d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "JsonDiff(path=" + this.f57211a + ", type=" + this.f57212b + ", oldValue=" + this.f57213c + ", newValue=" + this.f57214d + ")";
    }

    public final String getType() {
        return this.f57212b;
    }

    public c0(String r100, String r101, Object r102, Object r103) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f57211a = r100;
        this.f57212b = r101;
        this.f57213c = r102;
        this.f57214d = r103;
    }
}
