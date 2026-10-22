package com.bytedance.android.livesdk.gamesticker.t01.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gamesticker.t01.T01GameLiveView;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class d extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AnimatorSet f125762d;

    @Override // com.bytedance.android.livesdk.gamesticker.t01.anim.b
    public final void a() {
        AnimatorSet r100 = this.f125762d;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.f125762d = null;
    }

    public d() {
    }

    public static boolean g(View... r100) {
        Intrinsics.checkNotNullParameter(r100, "views");
        if (r100.length != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return false;
    L8:
        int r102 = r100.length;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        if (r100[r103].getVisibility() == 0) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return true;
    L14:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    public final ValueAnimator h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        i r101 = this.f125759c;
        if (r101 == null) goto L5;
        float r102 = r101.getHeight();
    L7:
        return ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r102, 0.0f});
    L5:
        r102 = s1.f(28.0f);
        goto L7
    }

    public final ValueAnimator i(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        i r101 = this.f125759c;
        if (r101 == null) goto L5;
        float r102 = r101.getHeight();
    L7:
        return ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, -r102});
    L5:
        r102 = s1.f(28.0f);
        goto L7
    }

    public static Object f(Object[] r100, Object r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "views");
        int r103 = 0;
        if (r100.length != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        return r101;
    L8:
        int r105 = r100.length;
    L9:
        if (r103 >= r105) goto L16;
        Object r106 = r100[r103];
        if ((r106 instanceof View) == false) goto L15;
        if (((View) r106).getVisibility() != r102) goto L15;
        return r106;
    L15:
        r103 = r103 + 1;
        goto L9
    L16:
        return r101;
    L5:
        r104 = false;
        goto L6
    }

    public final void k(View r100, View r110, Function0<Unit> r111, Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, "inView");
        Intrinsics.checkNotNullParameter(r110, "outView");
        Intrinsics.checkNotNullParameter(r111, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r112, "onEnd");
        j(r100, r110, null, null, r111, r112);
    }

    public final void j(View r100, View r101, T01GameLiveView r102, T01GameLiveView r103, Function0 r104, Function0 r105) {
        Intrinsics.checkNotNullParameter(r100, "inView");
        Intrinsics.checkNotNullParameter(r101, "outView");
        Intrinsics.checkNotNullParameter(r104, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r105, "onEnd");
        List r106 = CollectionsKt.mutableListOf(new ValueAnimator[]{h(r100), i(r101)});
        if (r102 == null) goto L6;
        if (r103 == null) goto L6;
        r106.add(h(r102));
        r106.add(i(r103));
        r100.toString();
        r101.toString();
        r102.toString();
        r103.toString();
    L6:
        AnimatorSet r107 = new AnimatorSet();
        this.f125762d = r107;
        r107.playTogether(CollectionsKt.toList(r106));
        AnimatorSet r108 = this.f125762d;
        if (r108 == null) goto L9;
        r108.setDuration(500);
    L9:
        AnimatorSet r109 = this.f125762d;
        if (r109 == null) goto L12;
        r109.addListener(new c(r104, r105));
    L12:
        AnimatorSet r110 = this.f125762d;
        if (r110 == null) goto L16;
        r110.start();
        return;
    }
}
