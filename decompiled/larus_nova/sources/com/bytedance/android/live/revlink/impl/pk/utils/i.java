package com.bytedance.android.live.revlink.impl.pk.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f97094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f97095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f97096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f97097d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (this.f97094a == r101.f97094a) goto L8;
        return false;
    L8:
        if (this.f97095b == r101.f97095b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f97096c, r101.f97096c) == true) goto L12;
        return false;
    L12:
        if (this.f97097d == r101.f97097d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        int r100 = ((this.f97094a * 31) + this.f97095b) * 31;
        String r101 = this.f97096c;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (r100 + r102) * 31;
        boolean r104 = this.f97097d;
        ?? r105 = r104;
        if (r104 == false) goto L10;
        r105 = 1;
    L10:
        return r103 + r105;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ListExtraInfo(followSize=" + this.f97094a + ", originFollowSize=" + this.f97095b + ", requestID=" + this.f97096c + ", isFromRefresh=" + this.f97097d + ")";
    }

    public i(int r100, int r101, String r102, boolean r103) {
        this.f97094a = r100;
        this.f97095b = r101;
        this.f97096c = r102;
        this.f97097d = r103;
    }
}
