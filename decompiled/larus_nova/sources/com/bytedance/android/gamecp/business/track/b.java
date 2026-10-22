package com.bytedance.android.gamecp.business.track;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f56423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f56424c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f56422a, r101.f56422a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f56423b, r101.f56423b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f56424c, r101.f56424c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f56422a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f56423b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f56424c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TeamPlayTrackCommonParams(promoteGameId=" + this.f56422a + ", anchorId=" + this.f56423b + ", roomId=" + this.f56424c + ")";
    }

    public b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "promoteGameId");
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        Intrinsics.checkNotNullParameter(r102, "roomId");
        this.f56422a = r100;
        this.f56423b = r101;
        this.f56424c = r102;
    }
}
