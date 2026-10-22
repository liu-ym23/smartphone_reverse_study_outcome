package com.bytedance.android.live.revenue.platform.hybrid.impl.util;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final HybridType a(IHybridComponent.HybridType r100) {
        Intrinsics.checkNotNullParameter(r100, "annieHybridType");
        int r101 = a.f91479a[r100.ordinal()];
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L8;
        return HybridType.LYNX;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return HybridType.H5;
    }
}
