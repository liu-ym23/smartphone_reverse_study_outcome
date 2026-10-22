package com.bytedance.android.live.profit.redpacket;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RedPacketState f88648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RedPacketAction f88649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RedPacketState f88650c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k1) == false) goto L12;
        k1 r101 = (k1) r100;
        if (Intrinsics.areEqual(this.f88648a, r101.f88648a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f88649b, r101.f88649b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f88650c, r101.f88650c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        RedPacketState r100 = this.f88648a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        RedPacketAction r104 = this.f88649b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        RedPacketState r107 = this.f88650c;
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
        return "StateChangeEvent(from=" + this.f88648a + ", action=" + this.f88649b + ", to=" + this.f88650c + ")";
    }

    public k1(RedPacketState r100, RedPacketAction r101, RedPacketState r102) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.TO);
        this.f88648a = r100;
        this.f88649b = r101;
        this.f88650c = r102;
    }
}
