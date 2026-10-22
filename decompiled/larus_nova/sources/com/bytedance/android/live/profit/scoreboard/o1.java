package com.bytedance.android.live.profit.scoreboard;

import android.graphics.Rect;
import android.view.View;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes47.dex */
public final class o1 {
    public static final String a(Pair<? extends RegionId, j80.d> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$formatEventTrackerParam");
        return r100.getFirst().getId() + '-' + j80.a.a(r100.getSecond().a().floatValue(), 3) + '-' + j80.a.a(r100.getSecond().b().floatValue(), 3);
    }

    public static final void b(View r100, Rect r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getSizeStableHitRect");
        Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
        int r102 = MathKt.roundToInt(r100.getTranslationX());
        int r103 = MathKt.roundToInt(r100.getTranslationY());
        r101.set(r100.getLeft() + r102, r100.getTop() + r103, r100.getRight() + r102, r100.getBottom() + r103);
    }
}
