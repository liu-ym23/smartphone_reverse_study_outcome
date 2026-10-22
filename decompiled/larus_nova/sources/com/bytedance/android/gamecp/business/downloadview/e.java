package com.bytedance.android.gamecp.business.downloadview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f53018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f53019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f53020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f53021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f53022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f53023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f53024g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L20;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f53018a, r101.f53018a) == true) goto L8;
        return false;
    L8:
        if (this.f53019b == r101.f53019b) goto L10;
        return false;
    L10:
        if (this.f53020c == r101.f53020c) goto L12;
        return false;
    L12:
        if (this.f53021d == r101.f53021d) goto L14;
        return false;
    L14:
        if (this.f53022e == r101.f53022e) goto L16;
        return false;
    L16:
        if (this.f53023f == r101.f53023f) goto L18;
        return false;
    L18:
        if (this.f53024g == r101.f53024g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f53018a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((((((((r101 * 31) + this.f53019b) * 31) + this.f53020c) * 31) + this.f53021d) * 31) + this.f53022e) * 31) + this.f53023f) * 31) + this.f53024g;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "DownloadIconInfo(icon=" + this.f53018a + ", width=" + this.f53019b + ", height=" + this.f53020c + ", rightMargin=" + this.f53021d + ", leftMargin=" + this.f53022e + ", topMargin=" + this.f53023f + ", bottomMargin=" + this.f53024g + ")";
    }

    public e() {
        this("", 0, 0, 0, 0, 0, 0);
    }

    public e(String r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        this.f53018a = r100;
        this.f53019b = r101;
        this.f53020c = r102;
        this.f53021d = r103;
        this.f53022e = r104;
        this.f53023f = r105;
        this.f53024g = r106;
    }
}
