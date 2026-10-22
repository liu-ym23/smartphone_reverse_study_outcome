package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/chad/library/adapter/base/animation/SlideInBottomAnimation;", "Lcom/chad/library/adapter/base/animation/BaseAnimation;", "()V", "animators", "", "Landroid/animation/Animator;", "view", "Landroid/view/View;", "(Landroid/view/View;)[Landroid/animation/Animator;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
public final class SlideInBottomAnimation implements BaseAnimation {
    public SlideInBottomAnimation() {
    }

    @Override // com.chad.library.adapter.base.animation.BaseAnimation
    @NotNull
    public Animator[] animators(@NotNull View r10) {
        q.h(r10, "view");
        ObjectAnimator r11 = ObjectAnimator.ofFloat(r10, "translationY", new float[]{r10.getMeasuredHeight(), 0.0f});
        q.c(r11, "animator");
        r11.setDuration(400);
        r11.setInterpolator(new DecelerateInterpolator(1.3f));
        return new Animator[]{r11};
    }
}
