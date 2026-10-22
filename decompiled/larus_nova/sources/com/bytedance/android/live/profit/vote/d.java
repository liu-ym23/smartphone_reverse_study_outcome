package com.bytedance.android.live.profit.vote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {
    public static final boolean a(com.bytedance.android.live.profit.vote.model.c r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isActive");
        VoteState r101 = r100.f89243a.f267520d;
        int r102 = c.f89195a[r101.ordinal()];
        if (r102 == 1) goto L8;
        if (r102 == 2) goto L8;
    L10:
        return false;
    L8:
        if (r100.a() <= 0) goto L10;
        return true;
    }
}
