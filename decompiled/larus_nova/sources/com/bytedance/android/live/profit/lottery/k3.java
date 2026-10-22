package com.bytedance.android.live.profit.lottery;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LotteryState f88131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LotteryAction f88132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LotteryState f88133c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k3) == false) goto L12;
        k3 r101 = (k3) r100;
        if (Intrinsics.areEqual(this.f88131a, r101.f88131a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f88132b, r101.f88132b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f88133c, r101.f88133c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        LotteryState r100 = this.f88131a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        LotteryAction r104 = this.f88132b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LotteryState r107 = this.f88133c;
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
        return "StateChangeEvent(from=" + this.f88131a + ", action=" + this.f88132b + ", to=" + this.f88133c + ")";
    }

    public k3(LotteryState r100, LotteryAction r101, LotteryState r102) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.TO);
        this.f88131a = r100;
        this.f88132b = r101;
        this.f88133c = r102;
    }
}
