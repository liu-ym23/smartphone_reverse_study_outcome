package com.bytedance.android.gamecp.business.gamedetail.component.orderbutton;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f54896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f54897d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L14;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f54894a, r101.f54894a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54895b, r101.f54895b) == true) goto L10;
        return false;
    L10:
        if (this.f54896c == r101.f54896c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f54897d, r101.f54897d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        String r100 = this.f54894a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f54895b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f54896c;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f54897d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        return r109 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderTrackInfo(enterFrom=" + this.f54894a + ", gameAdType=" + this.f54895b + ", hasPlatformGift=" + this.f54896c + ", giftNum=" + this.f54897d + ")";
    }

    public r(String r100, String r101, boolean r102, Integer r103) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        this.f54894a = r100;
        this.f54895b = r101;
        this.f54896c = r102;
        this.f54897d = r103;
    }
}
