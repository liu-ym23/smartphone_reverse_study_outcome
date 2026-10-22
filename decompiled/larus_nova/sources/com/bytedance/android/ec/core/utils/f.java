package com.bytedance.android.ec.core.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {
    public static final void a(Animator r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$doOnEnd");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r100.addListener(new c(r101));
    }

    public static final void b(ViewPropertyAnimator r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$doOnEnd");
        Intrinsics.checkNotNullParameter(r101, "callback");
        r100.setListener(new d(r101));
    }

    public static final AnimatorSet c(View r100, float... r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "values");
        AnimatorSet r102 = new AnimatorSet();
        r102.playTogether(new Animator[]{ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_X, Arrays.copyOf(r101, r101.length)), ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_Y, Arrays.copyOf(r101, r101.length))});
        return r102;
    }
}
