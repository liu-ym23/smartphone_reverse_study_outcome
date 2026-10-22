package com.bytedance.android.live.profit.lottery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ParticipateStatus f88186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f88187b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L10;
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f88186a, r101.f88186a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f88187b, r101.f88187b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        ParticipateStatus r100 = this.f88186a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f88187b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LocalCandidateInfo(localParticipatedStatus=" + this.f88186a + ", extra=" + this.f88187b + ")";
    }

    public s(ParticipateStatus r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "localParticipatedStatus");
        Intrinsics.checkNotNullParameter(r101, "extra");
        this.f88186a = r100;
        this.f88187b = r101;
    }
}
