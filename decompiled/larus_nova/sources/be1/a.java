package be1;

import android.graphics.PointF;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static AnimationSet a(View r100, Pair r101, Pair r102, Interpolator r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$applyAnimation");
        AnimationSet r104 = new AnimationSet(true);
        r104.setDuration(500);
        r104.setInterpolator(r103);
        r104.setFillAfter(false);
        if (r101 == null) goto L5;
        r104.addAnimation(new AlphaAnimation(((Number) r101.getFirst()).floatValue(), ((Number) r101.getSecond()).floatValue()));
    L5:
        if (r102 == null) goto L7;
        r104.addAnimation(new TranslateAnimation(((PointF) r102.getFirst()).x, ((PointF) r102.getSecond()).x, ((PointF) r102.getFirst()).y, ((PointF) r102.getSecond()).y));
    L7:
        return r104;
    }
}
