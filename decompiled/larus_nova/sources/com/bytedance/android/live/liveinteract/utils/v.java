package com.bytedance.android.live.liveinteract.utils;

import android.graphics.PointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class v {
    public static final boolean a(EPointF r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isZeroPoint");
        if (((PointF) r100).x == 0.0f) goto L5;
    L7:
        return false;
    L5:
        if (((PointF) r100).y != 0.0f) goto L7;
        return true;
    }

    public static final EPointF b(PointF r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toEPoint");
        return new EPointF(r100.x, r100.y);
    }
}
