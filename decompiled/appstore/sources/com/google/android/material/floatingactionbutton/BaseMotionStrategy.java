package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.e;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class BaseMotionStrategy implements MotionStrategy {
    private final Context context;

    @Nullable
    private MotionSpec defaultMotionSpec;

    @NonNull
    private final ExtendedFloatingActionButton fab;
    private final ArrayList<Animator.AnimatorListener> listeners;

    @Nullable
    private MotionSpec motionSpec;
    private final AnimatorTracker tracker;

    public BaseMotionStrategy(@NonNull ExtendedFloatingActionButton r10, AnimatorTracker r11) {
        this.listeners = new ArrayList();
        this.fab = r10;
        this.context = r10.getContext();
        this.tracker = r11;
    }

    public static /* synthetic */ ExtendedFloatingActionButton access$000(BaseMotionStrategy r10) {
        return r10.fab;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void addAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.listeners.add(r10);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public AnimatorSet createAnimator() {
        return createAnimator(getCurrentMotionSpec());
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final MotionSpec getCurrentMotionSpec() {
        MotionSpec r10 = this.motionSpec;
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (this.defaultMotionSpec != null) goto L9;
        this.defaultMotionSpec = MotionSpec.createFromResource(this.context, getDefaultMotionSpecResource());
    L9:
        return (MotionSpec) e.g(this.defaultMotionSpec);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @NonNull
    public final List<Animator.AnimatorListener> getListeners() {
        return this.listeners;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @Nullable
    public MotionSpec getMotionSpec() {
        return this.motionSpec;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @CallSuper
    public void onAnimationCancel() {
        this.tracker.clear();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @CallSuper
    public void onAnimationEnd() {
        this.tracker.clear();
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    @CallSuper
    public void onAnimationStart(Animator r10) {
        this.tracker.onNextAnimationStart(r10);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void removeAnimationListener(@NonNull Animator.AnimatorListener r10) {
        this.listeners.remove(r10);
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public final void setMotionSpec(@Nullable MotionSpec r10) {
        this.motionSpec = r10;
    }

    @NonNull
    public AnimatorSet createAnimator(@NonNull MotionSpec r10) {
        ArrayList r11 = new ArrayList();
        if (r10.hasPropertyValues("opacity") == false) goto L6;
        r11.add(r10.getAnimator("opacity", this.fab, View.ALPHA));
    L6:
        if (r10.hasPropertyValues("scale") == false) goto L9;
        r11.add(r10.getAnimator("scale", this.fab, View.SCALE_Y));
        r11.add(r10.getAnimator("scale", this.fab, View.SCALE_X));
    L9:
        if (r10.hasPropertyValues(Style.KEY_WIDTH) == false) goto L12;
        r11.add(r10.getAnimator(Style.KEY_WIDTH, this.fab, ExtendedFloatingActionButton.WIDTH));
    L12:
        if (r10.hasPropertyValues(Style.KEY_HEIGHT) == false) goto L15;
        r11.add(r10.getAnimator(Style.KEY_HEIGHT, this.fab, ExtendedFloatingActionButton.HEIGHT));
    L15:
        if (r10.hasPropertyValues("paddingStart") == false) goto L18;
        r11.add(r10.getAnimator("paddingStart", this.fab, ExtendedFloatingActionButton.PADDING_START));
    L18:
        if (r10.hasPropertyValues("paddingEnd") == false) goto L21;
        r11.add(r10.getAnimator("paddingEnd", this.fab, ExtendedFloatingActionButton.PADDING_END));
    L21:
        if (r10.hasPropertyValues("labelOpacity") == false) goto L23;
        final Class<Float> r12 = Float.class;
        final String r13 = "LABEL_OPACITY_PROPERTY";
        r11.add(r10.getAnimator("labelOpacity", this.fab, new AnonymousClass1(this, r12, r13)));
    L23:
        AnimatorSet r14 = new AnimatorSet();
        AnimatorSetCompat.playTogether(r14, r11);
        return r14;
    }
}
