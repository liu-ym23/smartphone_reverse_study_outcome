package com.bytedance.android.live.profit.dress;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class t extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f87171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f87172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.android.live.profit.dress.config.n> f87173c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L12;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f87171a, r101.f87171a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f87172b, r101.f87172b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f87173c, r101.f87173c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.f87171a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f87172b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<com.bytedance.android.live.profit.dress.config.n> r107 = this.f87173c;
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
        return "LinkmicRealTimeChorusDress(globalValid=" + this.f87171a + ", allowListId=" + this.f87172b + ", stageList=" + this.f87173c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(Boolean r100, Long r101, List<? extends com.bytedance.android.live.profit.dress.config.n> r102) {
        this.f87171a = r100;
        this.f87172b = r101;
        this.f87173c = r102;
    }
}
