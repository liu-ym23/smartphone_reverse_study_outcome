package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompositeImagePreviewDialog f139922a;

    public b(CompositeImagePreviewDialog r100) {
        this.f139922a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        CompositeImagePreviewDialog r111 = this.f139922a;
        if (r111.Y == false) goto L22;
        r111.Y = false;
        View r100 = r111.N;
        if (r100 == null) goto L8;
        UtilityKotlinExtentionsKt.A(r100, false);
    L8:
        TextView r101 = r111.f139887J;
        if (r101 == null) goto L11;
        UtilityKotlinExtentionsKt.A(r101, true);
    L11:
        TextView r102 = r111.K;
        if (r102 == null) goto L14;
        UtilityKotlinExtentionsKt.A(r102, true);
    L14:
        Animator r103 = r111.W;
        if (r103 == null) goto L17;
        r103.cancel();
    L17:
        HSImageView r104 = r111.I;
        if (r104 == null) goto L21;
        float r105 = r104.getScaleX();
        float r106 = r104.getTranslationY();
        float r107 = r104.getTranslationX();
        AnimatorSet r108 = new AnimatorSet();
        AnimatorSet.Builder r109 = r108.play(ObjectAnimator.ofFloat(r104, View.TRANSLATION_Y, new float[]{r106, 0.0f}));
        r109.with(ObjectAnimator.ofFloat(r104, View.TRANSLATION_X, new float[]{r107, 0.0f}));
        r109.with(ObjectAnimator.ofFloat(r104, View.SCALE_X, new float[]{r105, 1.0f}));
        r109.with(ObjectAnimator.ofFloat(r104, View.SCALE_Y, new float[]{r105, 1.0f}));
        r109.with(ObjectAnimator.ofFloat(r111.M, View.ALPHA, new float[]{1.0f, 0.0f}));
        r109.with(ObjectAnimator.ofFloat(r111.f139887J, View.ALPHA, new float[]{0.0f, 1.0f}));
        r109.with(ObjectAnimator.ofFloat(r111.K, View.ALPHA, new float[]{0.0f, 1.0f}));
        r108.setDuration(500);
        r108.setInterpolator(new DecelerateInterpolator());
        r108.addListener(new i(r104, r111));
        r108.start();
        Unit r112 = Unit.INSTANCE;
        r111.W = r108;
        return;
    L21:
        return;
    }
}
