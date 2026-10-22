package com.bytedance.android.anniex.scene.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f41186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f41187c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f41185a, r101.f41185a) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.f41186b, r101.f41186b) == 0) goto L15;
        return false;
    L15:
        if (this.f41187c == r101.f41187c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f41185a.hashCode() * 31;
        long r101 = Double.doubleToLongBits(this.f41186b);
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f41187c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "UrlEntry(url=" + this.f41185a + ", count=" + this.f41186b + ", lastVisitTs=" + this.f41187c + ')';
    }

    public c(String r100, double r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f41185a = r100;
        this.f41186b = r101;
        this.f41187c = r102;
    }
}
