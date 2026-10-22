package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

/* JADX INFO: loaded from: classes.dex */
public class DrawableCrossFadeTransition implements Transition<Drawable> {
    private final int duration;
    private final boolean isCrossFadeEnabled;

    public DrawableCrossFadeTransition(int r10, boolean r11) {
        this.duration = r10;
        this.isCrossFadeEnabled = r11;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public /* bridge */ /* synthetic */ boolean transition(Drawable r10, Transition.ViewAdapter r11) {
        return transition2(r10, r11);
    }

    /* JADX INFO: renamed from: transition, reason: avoid collision after fix types in other method */
    public boolean transition2(Drawable r10, Transition.ViewAdapter r11) {
        Drawable r12 = r11.getCurrentDrawable();
        if (r12 != null) goto L5;
        r12 = new ColorDrawable(0);
    L5:
        TransitionDrawable r13 = new TransitionDrawable(new Drawable[]{r12, r10});
        r13.setCrossFadeEnabled(this.isCrossFadeEnabled);
        r13.startTransition(this.duration);
        r11.setDrawable(r13);
        return true;
    }
}
