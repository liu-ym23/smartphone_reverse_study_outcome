package com.stepos.ailauncher.chat.view.input;

import Y8.t;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.view.LineCappedScrollView;
import com.stepos.ailauncher.chat.view.input.InputBarMotionSpec;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v5.C5659a;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0013J'\u0010\u001b\u001a\u00020\u000f2\u0018\u0010\u001a\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0019\u0012\u0004\u0012\u00020\u000f0\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u000f¢\u0006\u0004\b\u001d\u0010\u0013J#\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010'R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010'R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010'R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00103R\u0016\u0010:\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/stepos/ailauncher/chat/view/input/h;", "", "Landroid/view/View;", "btnVoice", "btnMore", "btnSend", "Lcom/stepos/ailauncher/chat/view/LineCappedScrollView;", "inputScroll", "<init>", "(Landroid/view/View;Landroid/view/View;Landroid/view/View;Lcom/stepos/ailauncher/chat/view/LineCappedScrollView;)V", "", "visible", "animated", "", "durationMs", "LY8/t;", "m", "(ZZLjava/lang/Long;)V", "o", "()V", "hideOverflowLine", "s", "(Z)V", "k", "Lkotlin/Function1;", "Lkotlin/Function0;", "registerTransitionEnd", "y", "(Lp9/l;)V", "v", "toVisible", "t", "(ZLjava/lang/Long;)V", "scroll", "C", "(Lcom/stepos/ailauncher/chat/view/LineCappedScrollView;)V", "r", "(Lcom/stepos/ailauncher/chat/view/LineCappedScrollView;)Z", "B", "Landroid/view/View;", "Lcom/stepos/ailauncher/chat/view/LineCappedScrollView;", "Landroid/animation/TimeInterpolator;", "easeOutCubic", "Landroid/animation/TimeInterpolator;", "Landroid/animation/ValueAnimator;", "heightAnimator", "Landroid/animation/ValueAnimator;", "", "heightAnimationTarget", "Ljava/lang/Integer;", "heightAnimationGeneration", "J", "Ljava/lang/Runnable;", "releaseHeightTask", "Ljava/lang/Runnable;", "formSettlePending", "Z", "formSettleGeneration", "realOverflowActive", "runningTargetVisible", "Ljava/lang/Boolean;", "", "q", "()F", "plusShiftPx", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h {
    private final View btnMore;
    private final View btnSend;
    private final View btnVoice;
    private long formSettleGeneration;
    private boolean formSettlePending;
    private long heightAnimationGeneration;
    private Integer heightAnimationTarget;
    private ValueAnimator heightAnimator;
    private final LineCappedScrollView inputScroll;
    private boolean realOverflowActive;
    private Boolean runningTargetVisible;
    private final TimeInterpolator easeOutCubic = new TimeInterpolator() { // from class: com.stepos.ailauncher.chat.view.input.c
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f10) {
            return h.p(f10);
        }
    };
    private final Runnable releaseHeightTask = new Runnable() { // from class: com.stepos.ailauncher.chat.view.input.d
        @Override // java.lang.Runnable
        public final void run() {
            h.x(this.f26183a);
        }
    };

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/ailauncher/chat/view/input/h$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "onAnimationCancel", Const.INTENT_KEY_APIKEY, "()V", "", "finished", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AnimatorListenerAdapter {
        final /* synthetic */ long $generation;
        private boolean finished;
        final /* synthetic */ h this$0;

        public a(long j10, h hVar) {
            this.$generation = j10;
            this.this$0 = hVar;
        }

        public final void a() {
            if (this.finished || this.$generation != this.this$0.heightAnimationGeneration) {
                return;
            }
            this.finished = true;
            this.this$0.heightAnimator = null;
            this.this$0.heightAnimationTarget = null;
            this.this$0.v();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            p.i(animation, "animation");
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            p.i(animation, "animation");
            a();
        }
    }

    public h(View view, View view2, View view3, LineCappedScrollView lineCappedScrollView) {
        this.btnVoice = view;
        this.btnMore = view2;
        this.btnSend = view3;
        this.inputScroll = lineCappedScrollView;
    }

    public static final void A(long j10, h hVar, LineCappedScrollView lineCappedScrollView) {
        if (j10 == hVar.formSettleGeneration && lineCappedScrollView.isAttachedToWindow()) {
            hVar.formSettlePending = false;
            int height = lineCappedScrollView.getHeight();
            ViewGroup.LayoutParams layoutParams = lineCappedScrollView.getLayoutParams();
            C4148a.k("InputFormSettleProbe", "settle generation=" + j10 + " height=" + height + " lpHeight=" + (layoutParams != null ? Integer.valueOf(layoutParams.height) : null), false, 4, null);
            hVar.k();
        }
    }

    public static final void l(ViewGroup.LayoutParams layoutParams, LineCappedScrollView lineCappedScrollView, ValueAnimator animator) {
        p.i(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        lineCappedScrollView.setLayoutParams(layoutParams);
    }

    public static /* synthetic */ void n(h hVar, boolean z10, boolean z11, Long l10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            l10 = null;
        }
        hVar.m(z10, z11, l10);
    }

    public static final float p(float f10) {
        return InputBarMotionSpec.INSTANCE.c(f10);
    }

    public static final void u(h hVar, boolean z10) {
        hVar.B(z10);
    }

    public static final void w(h hVar, LineCappedScrollView lineCappedScrollView) {
        hVar.realOverflowActive = hVar.r(lineCappedScrollView);
    }

    public static final void x(h hVar) {
        hVar.v();
    }

    public static final t z(final LineCappedScrollView lineCappedScrollView, final long j10, final h hVar) {
        lineCappedScrollView.postOnAnimation(new Runnable() { // from class: com.stepos.ailauncher.chat.view.input.g
            @Override // java.lang.Runnable
            public final void run() {
                h.A(j10, hVar, lineCappedScrollView);
            }
        });
        return t.f7040a;
    }

    public final void B(boolean visible) {
        this.runningTargetVisible = null;
        View view = this.btnMore;
        if (view != null) {
            view.setTranslationX(0.0f);
        }
        View view2 = this.btnSend;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(visible ? 0 : 8);
        view2.setAlpha(1.0f);
        view2.setScaleX(1.0f);
        view2.setScaleY(1.0f);
    }

    public final void C(LineCappedScrollView scroll) {
        boolean zR = r(scroll);
        if (zR) {
            this.realOverflowActive = true;
            return;
        }
        scroll.setSuppressScrollForGrowth(true);
        if (InputBarMotionSpec.INSTANCE.i(zR, this.realOverflowActive)) {
            scroll.scrollTo(0, 0);
        }
    }

    public final void k() {
        final ViewGroup.LayoutParams layoutParams;
        final LineCappedScrollView lineCappedScrollView = this.inputScroll;
        if (lineCappedScrollView == null || this.formSettlePending || (layoutParams = lineCappedScrollView.getLayoutParams()) == null) {
            return;
        }
        lineCappedScrollView.removeCallbacks(this.releaseHeightTask);
        if (lineCappedScrollView.getWidth() <= 0) {
            v();
            return;
        }
        int height = layoutParams.height;
        if (height <= 0) {
            height = lineCappedScrollView.getHeight();
        }
        lineCappedScrollView.measure(View.MeasureSpec.makeMeasureSpec(lineCappedScrollView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = lineCappedScrollView.getMeasuredHeight();
        ValueAnimator valueAnimator = this.heightAnimator;
        if (valueAnimator != null && valueAnimator.isRunning() && InputBarMotionSpec.INSTANCE.l(this.heightAnimationTarget, measuredHeight)) {
            C(lineCappedScrollView);
            return;
        }
        this.heightAnimationGeneration++;
        ValueAnimator valueAnimator2 = this.heightAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.heightAnimator = null;
        this.heightAnimationTarget = null;
        if (height <= 0 || height == measuredHeight) {
            v();
            return;
        }
        long j10 = this.heightAnimationGeneration;
        this.heightAnimationTarget = Integer.valueOf(measuredHeight);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(height, measuredHeight);
        valueAnimatorOfInt.setDuration(100L);
        valueAnimatorOfInt.setInterpolator(this.easeOutCubic);
        C(lineCappedScrollView);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.view.input.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                h.l(layoutParams, lineCappedScrollView, valueAnimator3);
            }
        });
        valueAnimatorOfInt.addListener(new a(j10, this));
        valueAnimatorOfInt.start();
        this.heightAnimator = valueAnimatorOfInt;
    }

    public final void m(boolean visible, boolean animated, Long durationMs) {
        View view = this.btnSend;
        if (view == null) {
            return;
        }
        Boolean bool = this.runningTargetVisible;
        if (InputBarMotionSpec.INSTANCE.h(bool != null ? bool.booleanValue() : view.getVisibility() == 0, visible) == InputBarMotionSpec.SendTransition.NONE) {
            return;
        }
        if (animated) {
            t(visible, durationMs);
        } else {
            B(visible);
        }
    }

    public final void o() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAnimate2;
        ValueAnimator valueAnimator = this.heightAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.formSettleGeneration++;
        boolean zBooleanValue = false;
        this.formSettlePending = false;
        LineCappedScrollView lineCappedScrollView = this.inputScroll;
        if (lineCappedScrollView != null) {
            lineCappedScrollView.removeCallbacks(this.releaseHeightTask);
        }
        Boolean bool = this.runningTargetVisible;
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            View view = this.btnSend;
            if (view != null && view.getVisibility() == 0) {
                zBooleanValue = true;
            }
        }
        View view2 = this.btnMore;
        if (view2 != null && (viewPropertyAnimatorAnimate2 = view2.animate()) != null) {
            viewPropertyAnimatorAnimate2.cancel();
        }
        View view3 = this.btnSend;
        if (view3 != null && (viewPropertyAnimatorAnimate = view3.animate()) != null) {
            viewPropertyAnimatorAnimate.cancel();
        }
        B(zBooleanValue);
        v();
    }

    public final float q() {
        View view = this.btnMore;
        if (view == null) {
            return 0.0f;
        }
        C5659a c5659a = C5659a.INSTANCE;
        Context context = view.getContext();
        p.h(context, "getContext(...)");
        float fA = c5659a.a(context, 44);
        return view.getLayoutDirection() == 1 ? -fA : fA;
    }

    public final boolean r(LineCappedScrollView scroll) {
        View childAt = scroll.getChildAt(0);
        TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
        return textView != null && textView.getLineCount() > scroll.getMaxVisibleLines();
    }

    public final void s(boolean hideOverflowLine) {
        LineCappedScrollView lineCappedScrollView = this.inputScroll;
        if (lineCappedScrollView == null) {
            return;
        }
        lineCappedScrollView.setHideOverflowLine(hideOverflowLine);
        int height = lineCappedScrollView.getHeight();
        if (height <= 0) {
            return;
        }
        ValueAnimator valueAnimator = this.heightAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.heightAnimator = null;
        this.heightAnimationTarget = null;
        lineCappedScrollView.removeCallbacks(this.releaseHeightTask);
        C(lineCappedScrollView);
        ViewGroup.LayoutParams layoutParams = lineCappedScrollView.getLayoutParams();
        if (layoutParams == null || layoutParams.height != height) {
            ViewGroup.LayoutParams layoutParams2 = lineCappedScrollView.getLayoutParams();
            layoutParams2.height = height;
            lineCappedScrollView.setLayoutParams(layoutParams2);
        }
    }

    public final void t(final boolean toVisible, Long durationMs) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorTranslationX;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator viewPropertyAnimatorAnimate2;
        View view = this.btnSend;
        if (view == null) {
            return;
        }
        View view2 = this.btnMore;
        boolean z10 = view.getVisibility() == 0;
        if (view2 != null && (viewPropertyAnimatorAnimate2 = view2.animate()) != null) {
            viewPropertyAnimatorAnimate2.cancel();
        }
        view.animate().cancel();
        this.runningTargetVisible = Boolean.valueOf(toVisible);
        if (toVisible) {
            view.setVisibility(0);
        }
        float alpha = z10 ? view.getAlpha() : 0.0f;
        float scaleX = z10 ? view.getScaleX() : 0.6f;
        float translationX = z10 ? view2 != null ? view2.getTranslationX() : 0.0f : q();
        float f10 = toVisible ? 1.0f : 0.0f;
        float f11 = toVisible ? 1.0f : 0.6f;
        float fQ = toVisible ? 0.0f : q();
        view.setAlpha(alpha);
        view.setScaleX(scaleX);
        view.setScaleY(scaleX);
        if (view2 != null) {
            view2.setTranslationX(translationX);
        }
        if (view2 != null && (viewPropertyAnimatorAnimate = view2.animate()) != null && (viewPropertyAnimatorTranslationX = viewPropertyAnimatorAnimate.translationX(fQ)) != null) {
            ViewPropertyAnimator duration = viewPropertyAnimatorTranslationX.setDuration(durationMs != null ? durationMs.longValue() : 150L);
            if (duration != null && (interpolator = duration.setInterpolator(this.easeOutCubic)) != null) {
                interpolator.start();
            }
        }
        view.animate().alpha(f10).scaleX(f11).scaleY(f11).setDuration(durationMs != null ? durationMs.longValue() : 150L).setInterpolator(this.easeOutCubic).withEndAction(new Runnable() { // from class: com.stepos.ailauncher.chat.view.input.b
            @Override // java.lang.Runnable
            public final void run() {
                h.u(this.f26181a, toVisible);
            }
        }).start();
    }

    public final void v() {
        final LineCappedScrollView lineCappedScrollView = this.inputScroll;
        if (lineCappedScrollView == null) {
            return;
        }
        lineCappedScrollView.setSuppressScrollForGrowth(false);
        lineCappedScrollView.setHideOverflowLine(false);
        if (InputBarMotionSpec.INSTANCE.i(r(lineCappedScrollView), this.realOverflowActive)) {
            lineCappedScrollView.scrollTo(0, 0);
        }
        lineCappedScrollView.post(new Runnable() { // from class: com.stepos.ailauncher.chat.view.input.a
            @Override // java.lang.Runnable
            public final void run() {
                h.w(this.f26179a, lineCappedScrollView);
            }
        });
        ViewGroup.LayoutParams layoutParams = lineCappedScrollView.getLayoutParams();
        if (layoutParams == null || layoutParams.height != -2) {
            ViewGroup.LayoutParams layoutParams2 = lineCappedScrollView.getLayoutParams();
            layoutParams2.height = -2;
            lineCappedScrollView.setLayoutParams(layoutParams2);
        }
    }

    public final void y(InterfaceC5074l<? super InterfaceC5063a<t>, t> registerTransitionEnd) {
        p.i(registerTransitionEnd, "registerTransitionEnd");
        final LineCappedScrollView lineCappedScrollView = this.inputScroll;
        if (lineCappedScrollView == null) {
            return;
        }
        this.formSettlePending = true;
        lineCappedScrollView.removeCallbacks(this.releaseHeightTask);
        final long j10 = this.formSettleGeneration + 1;
        this.formSettleGeneration = j10;
        int height = lineCappedScrollView.getHeight();
        ViewGroup.LayoutParams layoutParams = lineCappedScrollView.getLayoutParams();
        C4148a.k("InputFormSettleProbe", "register generation=" + j10 + " height=" + height + " lpHeight=" + (layoutParams != null ? Integer.valueOf(layoutParams.height) : null), false, 4, null);
        registerTransitionEnd.invoke(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.input.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return h.z(lineCappedScrollView, j10, this);
            }
        });
    }
}
