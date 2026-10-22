package com.bytedance.android.live.profit.fansclub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f87288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f87289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f87290c;

    public e() {
        long r100 = 0;
        this(r100, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (this.f87288a == r101.f87288a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f87289b, r101.f87289b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f87290c, r101.f87290c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f87288a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f87289b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f87290c;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        return r105 + r103;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "FansClubParticipateIncentive(goldCoinsCount=" + this.f87288a + ", awardUnit=" + this.f87289b + ", popupData=" + this.f87290c + ")";
    }

    public /* synthetic */ e(long r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101, null);
    }

    public e(long r100, String r101, String r102) {
        this.f87288a = r100;
        this.f87289b = r101;
        this.f87290c = r102;
    }
}
