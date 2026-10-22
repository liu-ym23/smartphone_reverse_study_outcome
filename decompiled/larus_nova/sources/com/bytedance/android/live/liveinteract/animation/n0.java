package com.bytedance.android.live.liveinteract.animation;

import android.graphics.PointF;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n0 {
    public static final float a(EPointF r100, EPointF r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        Intrinsics.checkNotNullParameter(r101, "p2");
        double r102 = 360;
        return (float) ((((((double) (((float) Math.atan2(((PointF) r100).y - ((PointF) r101).y, ((PointF) r100).x - ((PointF) r101).x)) * 180)) / 3.141592653589793d) - ((double) 90)) + r102) % r102);
    }
}
