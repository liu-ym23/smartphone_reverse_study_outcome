package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f79400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f79401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f79402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f79403d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L14;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f79400a, r101.f79400a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f79401b, r101.f79401b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f79402c, r101.f79402c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f79403d, r101.f79403d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        g r100 = this.f79400a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        c r104 = this.f79401b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        n r107 = this.f79402c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        o r110 = this.f79403d;
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
        return "RevenueDataWrapper(revenueService=" + this.f79400a + ", giftInfo=" + this.f79401b + ", mp4Info=" + this.f79402c + ", positionInfo=" + this.f79403d + ")";
    }

    public p(g r100, c r101, n r102, o r103) {
        Intrinsics.checkNotNullParameter(r101, "giftInfo");
        Intrinsics.checkNotNullParameter(r103, "positionInfo");
        this.f79400a = r100;
        this.f79401b = r101;
        this.f79402c = r102;
        this.f79403d = r103;
    }
}
