package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class OpenPanel$performPanelAnimation$1 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpenPanel f60654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IntEvaluator f60655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f60656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f60657d;

    public OpenPanel$performPanelAnimation$1(OpenPanel r100, IntEvaluator r101, int r102, int r103) {
        this.f60654a = r100;
        this.f60655b = r101;
        this.f60656c = r102;
        this.f60657d = r103;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(final ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Window r101 = this.f60654a.getWindow();
        if (r101 == null) goto L13;
        final WindowManager.LayoutParams r102 = r101.getAttributes();
        if (r102 == null) goto L14;
        float r103 = r100.getAnimatedFraction();
        r102.y = this.f60655b.evaluate(r103, Integer.valueOf(this.f60656c), Integer.valueOf(this.f60657d)).intValue();
        View r104 = this.f60654a.f60631a;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L9:
        Function0<Unit> r105 = new OpenPanel$performPanelAnimation$1$$special$$inlined$let$lambda$1(r102, this, r100);
        if (ViewCompat.isAttachedToWindow(r104) == false) goto L15;
        r105.invoke();
        return;
    L15:
        return;
    L14:
        return;
    }
}
