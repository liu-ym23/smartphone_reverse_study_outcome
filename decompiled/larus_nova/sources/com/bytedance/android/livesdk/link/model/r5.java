package com.bytedance.android.livesdk.link.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class r5 {
    public static final b7 a(q5 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$multiChannelInfoEx");
        com.bytedance.android.livesdk.link.model.bridge.s1 r101 = r100.getMultiChannelInfo();
        if (r101 != null) goto L7;
        return null;
    L7:
        return (b7) r101.castTo(b7.class);
    }
}
