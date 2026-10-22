package com.bytedance.android.live.broadcastgame.opengame.view;

import com.bytedance.android.live.broadcastgame.opengame.network.m0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f61291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.broadcastgame.opengame.network.f f61292b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f0) == false) goto L10;
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f61291a, r101.f61291a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f61292b, r101.f61292b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        m0 r100 = this.f61291a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.live.broadcastgame.opengame.network.f r104 = this.f61292b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ZipResponse(totalDiamondResponse=" + this.f61291a + ", diamondRankListResponse=" + this.f61292b + ")";
    }

    public f0(m0 r100, com.bytedance.android.live.broadcastgame.opengame.network.f r101) {
        Intrinsics.checkNotNullParameter(r100, "totalDiamondResponse");
        Intrinsics.checkNotNullParameter(r101, "diamondRankListResponse");
        this.f61291a = r100;
        this.f61292b = r101;
    }
}
