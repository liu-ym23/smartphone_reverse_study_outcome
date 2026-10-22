package com.bytedance.android.live.profit.dress;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class m extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.profit.dress.config.j.b f87154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.profit.dress.config.j.e f87155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final py.k f87156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final py.k f87157d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L14;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f87154a, r101.f87154a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f87155b, r101.f87155b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f87156c, r101.f87156c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f87157d, r101.f87157d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.live.profit.dress.config.j.b r100 = this.f87154a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.live.profit.dress.config.j.e r104 = this.f87155b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        py.k r107 = this.f87156c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        py.k r110 = this.f87157d;
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
        return "GuestBattleDress(firstConfig=" + this.f87154a + ", stragglerConfig=" + this.f87155b + ", roomBackground=" + this.f87156c + ", playRuleImage=" + this.f87157d + ")";
    }

    public m(com.bytedance.android.live.profit.dress.config.j.b r100, com.bytedance.android.live.profit.dress.config.j.e r101, py.k r102, py.k r103) {
        this.f87154a = r100;
        this.f87155b = r101;
        this.f87156c = r102;
        this.f87157d = r103;
    }
}
