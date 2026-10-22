package com.bytedance.android.live.profit.vote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f89199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f89200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f89201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f89202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final py.k f89203e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L16;
        g r101 = (g) r100;
        if (this.f89199a == r101.f89199a) goto L8;
        return false;
    L8:
        if (this.f89200b == r101.f89200b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f89201c, r101.f89201c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f89202d, r101.f89202d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f89203e, r101.f89203e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f89199a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f89200b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.f89201c;
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = r104.hashCode();
    L6:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f89202d;
        if (r108 == null) goto L9;
        int r109 = r108.hashCode();
    L10:
        int r110 = (r107 + r109) * 31;
        py.k r111 = this.f89203e;
        if (r111 == null) goto L14;
        r105 = r111.hashCode();
    L14:
        return r110 + r105;
    L9:
        r109 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }

    public final String toString() {
        return "VoteItem(count=" + this.f89199a + ", giftId=" + this.f89200b + ", giftName=" + this.f89201c + ", text=" + this.f89202d + ", icon=" + this.f89203e + ")";
    }

    public g(long r100, long r101, String r102, String r103, py.k r104) {
        Intrinsics.checkNotNullParameter(r102, "giftName");
        Intrinsics.checkNotNullParameter(r103, "text");
        this.f89199a = r100;
        this.f89200b = r101;
        this.f89201c = r102;
        this.f89202d = r103;
        this.f89203e = r104;
    }
}
