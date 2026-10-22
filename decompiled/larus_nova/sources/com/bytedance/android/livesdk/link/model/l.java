package com.bytedance.android.livesdk.link.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class l {
    public static final y6 a(com.bytedance.android.livesdk.link.model.bridge.f r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$rtcLiveCoreDataEx");
        com.bytedance.android.livesdk.link.model.bridge.q1 r101 = r100.getRtcLiveCoreData();
        if (r101 != null) goto L7;
        return null;
    L7:
        return (y6) r101.castTo(y6.class);
    }
}
