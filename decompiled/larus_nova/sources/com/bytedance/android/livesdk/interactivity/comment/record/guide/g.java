package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveHighlightRecordGuideDialog f136130a;

    public g(LiveHighlightRecordGuideDialog r100) {
        this.f136130a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        LiveHighlightRecordGuideDialog r101 = this.f136130a;
        boolean r102 = ((Boolean) r100).booleanValue();
        View r103 = r101.H;
        if (r103 == null) goto L28;
        if (r102 == false) goto L16;
        UtilityKotlinExtentionsKt.w(r103);
        if (r101.f136111J != null) goto L9;
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        r104.setDuration(400);
        r104.setInterpolator(new LinearInterpolator());
        r104.setRepeatCount(-1);
        r104.addUpdateListener(new e(r103));
        r101.f136111J = r104;
    L9:
        Animator r105 = r101.f136111J;
        if (r105 != null) goto L12;
        return;
    L12:
        if (r105.isRunning() == true) goto L24;
        Animator r106 = r101.f136111J;
        if (r106 == null) goto L25;
        r106.start();
        return;
    L25:
        return;
    L24:
        return;
    L16:
        Animator r107 = r101.f136111J;
        if (r107 == null) goto L19;
        r107.cancel();
    L19:
        View r108 = r101.H;
        if (r108 == null) goto L27;
        UtilityKotlinExtentionsKt.t(r108);
        return;
    L27:
        return;
    }
}
