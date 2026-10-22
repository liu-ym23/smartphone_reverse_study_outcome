package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.common;

import com.bytedance.android.live.base.model.message.n5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f {
    public static final long a(n5 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$showDuration");
        n5.e r101 = r100.getDynamicConfig();
        if (r101 != null) goto L6;
        return 5000;
    L6:
        if (r101.endTimestamp > 0) goto L8;
        int r102 = r101.duration;
        if (r102 > 0) goto L15;
        return 5000;
    L15:
        return ((long) r102) * 1000;
    L8:
        if (r100.getShowTimestamp() <= 0) goto L10;
        long r103 = r101.endTimestamp;
        long r104 = r100.getShowTimestamp();
    L16:
        return r103 - r104;
    L10:
        r103 = r101.endTimestamp;
        r104 = System.currentTimeMillis();
        goto L16
    }
}
