package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

/* JADX INFO: loaded from: classes39.dex */
public class DrawableCrossFadeTransition implements Transition<Drawable> {
    private final int duration;
    private final boolean isCrossFadeEnabled;

    public DrawableCrossFadeTransition(int r100, boolean r101) {
        this.duration = r100;
        this.isCrossFadeEnabled = r101;
    }

    /* JADX INFO: renamed from: transition, reason: avoid collision after fix types in other method */
    public boolean transition2(Drawable r100, Transition.ViewAdapter r101) {
        Drawable r102 = r101.getCurrentDrawable();
        if (r102 != null) goto L5;
        r102 = new ColorDrawable(0);
    L5:
        TransitionDrawable r103 = new TransitionDrawable(new Drawable[]{r102, r100});
        r103.setCrossFadeEnabled(this.isCrossFadeEnabled);
        r103.startTransition(this.duration);
        r101.setDrawable(r103);
        return true;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public /* bridge */ /* synthetic */ boolean transition(Drawable r100, Transition.ViewAdapter r101) {
        return transition2(r100, r101);
    }
}
