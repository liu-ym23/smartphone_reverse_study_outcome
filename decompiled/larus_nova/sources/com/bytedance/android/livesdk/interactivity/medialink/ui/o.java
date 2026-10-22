package com.bytedance.android.livesdk.interactivity.medialink.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f138315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f138316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f138317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f138318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f138319e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L16;
        o r101 = (o) r100;
        if (this.f138315a == r101.f138315a) goto L8;
        return false;
    L8:
        if (this.f138316b == r101.f138316b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f138317c, r101.f138317c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f138318d, r101.f138318d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f138319e, r101.f138319e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean r100 = this.f138315a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((r101 * 31) + this.f138316b) * 31;
        Integer r103 = this.f138317c;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        Integer r107 = this.f138318d;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f138319e;
        if (r110 == null) goto L17;
        r104 = r110.hashCode();
    L17:
        return r109 + r104;
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "MediaTitleLayoutParams(isFloat=" + this.f138315a + ", floatDistanceFromBase=" + this.f138316b + ", backgroundResId=" + this.f138317c + ", backgroundHeight=" + this.f138318d + ", backgroundMinWidth=" + this.f138319e + ")";
    }

    public o(boolean r100, int r101, Integer r102, Integer r103, Integer r104) {
        this.f138315a = r100;
        this.f138316b = r101;
        this.f138317c = r102;
        this.f138318d = r103;
        this.f138319e = r104;
    }
}
