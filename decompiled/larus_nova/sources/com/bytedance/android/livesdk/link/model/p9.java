package com.bytedance.android.livesdk.link.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class p9 {
    public static final x6 a(o9 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$multiAnchorExtraEx");
        com.bytedance.android.livesdk.link.model.bridge.n1 r101 = r100.getMultiAnchorExtra();
        if (r101 != null) goto L7;
        return null;
    L7:
        return (x6) r101.castTo(x6.class);
    }

    public static final boolean b(o9 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSwitchChannel");
        if (r100.getToLinkerId() <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
