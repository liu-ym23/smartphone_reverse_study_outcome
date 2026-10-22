package com.bytedance.android.live.recharge.balance;

import com.bytedance.android.live.revenue.common.u0;
import com.hihonor.honorid.core.data.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f89652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f89653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u0 f89654c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (this.f89652a == r101.f89652a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f89653b, r101.f89653b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f89654c, r101.f89654c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f89652a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        f r102 = this.f89653b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        u0 r106 = this.f89654c;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        return r105 + r103;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "BalanceInfo(diamondBalance=" + this.f89652a + ", updateRequest=" + this.f89653b + ", updateTime=" + this.f89654c + ")";
    }

    public c(long r100, f r101, u0 r102) {
        Intrinsics.checkNotNullParameter(r101, "updateRequest");
        Intrinsics.checkNotNullParameter(r102, UserInfo.UPDATE_TIME);
        this.f89652a = r100;
        this.f89653b = r101;
        this.f89654c = r102;
    }
}
