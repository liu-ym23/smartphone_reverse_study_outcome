package com.bytedance.android.live.broadcastgame.opengame.test;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f61100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f61101b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f61100a, r101.f61100a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f61101b, r101.f61101b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f61100a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f61101b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GroupData(GroupName=" + this.f61100a + ", dataList=" + this.f61101b + ")";
    }

    public a(List r100) {
        Intrinsics.checkNotNullParameter("核心", "GroupName");
        Intrinsics.checkNotNullParameter(r100, "dataList");
        this.f61100a = "核心";
        this.f61101b = r100;
    }
}
