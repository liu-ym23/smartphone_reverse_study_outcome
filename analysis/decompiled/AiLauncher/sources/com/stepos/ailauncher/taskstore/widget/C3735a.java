package com.stepos.ailauncher.taskstore.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.R$id;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/view/View;", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)V", "taskstore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.widget.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3735a {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.widget.a$a, reason: collision with other inner class name */
    public static final class RunnableC0343a implements Runnable {
        final /* synthetic */ View $this_doOnPreDraw;
        final /* synthetic */ View $this_playArtifactCardEnterOnce$inlined;

        public RunnableC0343a(View view, View view2) {
            this.$this_doOnPreDraw = view;
            this.$this_playArtifactCardEnterOnce$inlined = view2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c cVar = new c(this.$this_playArtifactCardEnterOnce$inlined);
            float height = this.$this_playArtifactCardEnterOnce$inlined.getHeight();
            if (height <= 0.0f) {
                cVar.invoke();
                return;
            }
            this.$this_playArtifactCardEnterOnce$inlined.setPivotX(r3.getWidth() / 2.0f);
            this.$this_playArtifactCardEnterOnce$inlined.setPivotY(r3.getHeight() / 2.0f);
            this.$this_playArtifactCardEnterOnce$inlined.setTranslationY(height);
            this.$this_playArtifactCardEnterOnce$inlined.setScaleX(0.88f);
            this.$this_playArtifactCardEnterOnce$inlined.setScaleY(0.88f);
            this.$this_playArtifactCardEnterOnce$inlined.setAlpha(0.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.$this_playArtifactCardEnterOnce$inlined, (Property<View, Float>) View.TRANSLATION_Y, height, 0.0f);
            objectAnimatorOfFloat.setDuration(500L);
            objectAnimatorOfFloat.setInterpolator(new PathInterpolator(0.03f, 0.13f, 0.07f, 1.0f));
            Y8.t tVar = Y8.t.f7040a;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.$this_playArtifactCardEnterOnce$inlined, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 0.88f, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 0.88f, 1.0f));
            objectAnimatorOfPropertyValuesHolder.setDuration(500L);
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new PathInterpolator(0.2f, 0.01f, 0.2f, 1.0f));
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.$this_playArtifactCardEnterOnce$inlined, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
            objectAnimatorOfFloat2.setDuration(500L);
            objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f));
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfPropertyValuesHolder, objectAnimatorOfFloat2);
            animatorSet.addListener(new b(cVar));
            animatorSet.start();
            View view = this.$this_playArtifactCardEnterOnce$inlined;
            if (view.isAttachedToWindow()) {
                view.addOnAttachStateChangeListener(new d(view, animatorSet));
            } else {
                animatorSet.cancel();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/widget/a$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.widget.a$b */
    public static final class b extends AnimatorListenerAdapter {
        final /* synthetic */ InterfaceC5063a<Y8.t> $settleToRest;

        public b(InterfaceC5063a<Y8.t> interfaceC5063a) {
            this.$settleToRest = interfaceC5063a;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            this.$settleToRest.invoke();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.widget.a$c */
    public static final class c implements InterfaceC5063a<Y8.t> {
        final /* synthetic */ View $this_playArtifactCardEnterOnce;

        public c(View view) {
            this.$this_playArtifactCardEnterOnce = view;
        }

        public final void a() {
            this.$this_playArtifactCardEnterOnce.setTranslationY(0.0f);
            this.$this_playArtifactCardEnterOnce.setScaleX(1.0f);
            this.$this_playArtifactCardEnterOnce.setScaleY(1.0f);
            this.$this_playArtifactCardEnterOnce.setAlpha(1.0f);
        }

        @Override // p9.InterfaceC5063a
        public /* bridge */ /* synthetic */ Y8.t invoke() {
            a();
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/taskstore/widget/a$d", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.widget.a$d */
    public static final class d implements View.OnAttachStateChangeListener {
        final /* synthetic */ AnimatorSet $anim$inlined;
        final /* synthetic */ View $this_doOnDetach;

        public d(View view, AnimatorSet animatorSet) {
            this.$this_doOnDetach = view;
            this.$anim$inlined = animatorSet;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.$this_doOnDetach.removeOnAttachStateChangeListener(this);
            this.$anim$inlined.cancel();
        }
    }

    public static final void a(View view) {
        kotlin.jvm.internal.p.i(view, "<this>");
        int i10 = R$id.taskstore_artifact_enter_played;
        Object tag = view.getTag(i10);
        Boolean bool = Boolean.TRUE;
        if (kotlin.jvm.internal.p.d(tag, bool)) {
            return;
        }
        view.setTag(i10, bool);
        androidx.core.view.D.a(view, new RunnableC0343a(view, view));
    }
}
