package com.bytedance.android.live.profit.fansclub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FansClubUserStatus f87319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GuardStatus f87320b;

    public j() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f87319a, r101.f87319a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f87320b, r101.f87320b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        FansClubUserStatus r100 = this.f87319a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        GuardStatus r104 = this.f87320b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FansClubStatus(fansClubUserStatus=" + this.f87319a + ", guardStatus=" + this.f87320b + ")";
    }

    public /* synthetic */ j(int r100) {
        this(FansClubUserStatus.Unknown, GuardStatus.NoGuard);
    }

    public j(FansClubUserStatus r100, GuardStatus r101) {
        Intrinsics.checkNotNullParameter(r100, "fansClubUserStatus");
        Intrinsics.checkNotNullParameter(r101, "guardStatus");
        this.f87319a = r100;
        this.f87320b = r101;
    }
}
