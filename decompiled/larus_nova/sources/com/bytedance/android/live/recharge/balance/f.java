package com.bytedance.android.live.recharge.balance;

import com.bytedance.android.live.recharge.utils.u;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f89657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f89658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f89659c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f89658b, r101.f89658b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f89659c, r101.f89659c) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f89658b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f89659c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UpdateBalanceRequest(entrance=" + this.f89658b + ", extra=" + this.f89659c + ")";
    }

    public final u getContext() {
        return this.f89657a;
    }

    public f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        this.f89658b = r100;
        this.f89659c = r101;
        this.f89657a = new u();
    }
}
