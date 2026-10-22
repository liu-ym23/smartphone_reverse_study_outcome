package com.stepos.widget.dialog;

import Y8.t;
import Z8.C1174w;
import Z8.M;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.D;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.view.GlassAttachment;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.glass.GlassDelegate;
import com.stepos.widget.glass.GlassRebuildScheduler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import n9.C4946a;
import p9.InterfaceC5063a;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\fJ\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\fJ\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\nH\u0014¢\u0006\u0004\b%\u0010\fJ\u000f\u0010&\u001a\u00020\nH\u0014¢\u0006\u0004\b&\u0010\fJ/\u0010+\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0014¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020\n2\u0006\u0010.\u001a\u00020-H\u0014¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\n2\u0006\u00102\u001a\u000201H\u0014¢\u0006\u0004\b3\u00104J\u001f\u00105\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0014¢\u0006\u0004\b5\u0010$R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R$\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010IR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR*\u0010R\u001a\u00020\u001a2\u0006\u0010Q\u001a\u00020\u001a8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bR\u0010T\"\u0004\bU\u0010VR.\u0010W\u001a\u0004\u0018\u00010\r2\b\u0010Q\u001a\u0004\u0018\u00010\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010\u000f\"\u0004\bZ\u0010[R,\u0010\\\u001a\u00020\u00062\b\b\u0001\u0010Q\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010C\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010a\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\ba\u0010C\u001a\u0004\bb\u0010^\"\u0004\bc\u0010`R\"\u0010d\u001a\u00020\u001a8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bd\u0010S\u001a\u0004\be\u0010T\"\u0004\bf\u0010V¨\u0006g"}, d2 = {"Lcom/stepos/widget/dialog/StepOSAlertDialogLayout;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "refreshGlass", "()V", "Ly7/o;", "resolvedGlassEffect", "()Ly7/o;", "reapplyGlass", "requestGlass", "cancelGlassRefresh", "protectBackgroundUntilAfterEntry", "", "backgroundProtectionDuration", "()J", "resetBackgroundProtection", "widthMeasureSpec", "heightMeasureSpec", "", "tryOnMeasure", "(II)Z", "Landroid/view/View;", "child", "parentWidthMeasureSpec", "childWidthMeasureSpec", "(Landroid/view/View;I)I", "count", "forceUniformWidth", "(II)V", "onAttachedToWindow", "onDetachedFromWindow", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "onMeasure", "Lcom/stepos/widget/glass/GlassDelegate;", GlassAttachment.GPU_KIND, "Lcom/stepos/widget/glass/GlassDelegate;", "Landroid/graphics/drawable/Drawable;", "fallback", "Landroid/graphics/drawable/Drawable;", "Lkotlin/Pair;", "appliedSize", "Lkotlin/Pair;", "Landroidx/core/view/D;", "pendingGlassRefresh", "Landroidx/core/view/D;", "fallbackAlpha", "I", "Landroid/animation/ValueAnimator;", "fallbackAnimator", "Landroid/animation/ValueAnimator;", "Ljava/lang/Runnable;", "pendingBackgroundFrame", "Ljava/lang/Runnable;", "Landroid/view/ViewTreeObserver;", "backgroundFrameObserver", "Landroid/view/ViewTreeObserver;", "revealBackground", "Lcom/stepos/widget/glass/GlassRebuildScheduler;", "glassRebuild", "Lcom/stepos/widget/glass/GlassRebuildScheduler;", UxipConstants.f30680s, "isGlassEnabled", "Z", "()Z", "setGlassEnabled", "(Z)V", "glassEffect", "Ly7/o;", "getGlassEffect", "setGlassEffect", "(Ly7/o;)V", "maxHeight", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "bottomWindowMargin", "getBottomWindowMargin$StepOSWidget_release", "setBottomWindowMargin$StepOSWidget_release", "fitInputMethod", "getFitInputMethod$StepOSWidget_release", "setFitInputMethod$StepOSWidget_release", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSAlertDialogLayout extends LinearLayoutCompat {
    private Pair<Integer, Integer> appliedSize;
    private ViewTreeObserver backgroundFrameObserver;
    private int bottomWindowMargin;
    private Drawable fallback;
    private int fallbackAlpha;
    private ValueAnimator fallbackAnimator;
    private boolean fitInputMethod;
    private final GlassDelegate glass;
    private y7.o glassEffect;
    private final GlassRebuildScheduler glassRebuild;
    private boolean isGlassEnabled;
    private int maxHeight;
    private Runnable pendingBackgroundFrame;
    private D pendingGlassRefresh;
    private final Runnable revealBackground;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSAlertDialogLayout(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long backgroundProtectionDuration() throws Exception {
        long integer = getResources().getInteger(R.integer.stepos_dialog_enter_duration_short);
        ViewGroup.LayoutParams layoutParams = getRootView().getLayoutParams();
        Float f10 = null;
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        int i10 = layoutParams2 != null ? layoutParams2.windowAnimations : 0;
        long jComputeDurationHint = 0;
        if (i10 != 0) {
            try {
                TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(i10, new int[]{android.R.attr.windowEnterAnimation});
                try {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
                    C4946a.a(typedArrayObtainStyledAttributes, null);
                    if (resourceId != 0) {
                        jComputeDurationHint = AnimationUtils.loadAnimation(getContext(), resourceId).computeDurationHint();
                    }
                } finally {
                }
            } catch (Resources.NotFoundException unused) {
                jComputeDurationHint = integer;
            }
        }
        float fFloatValue = 1.0f;
        try {
            Float fValueOf = Float.valueOf(Settings.Global.getFloat(getContext().getContentResolver(), "window_animation_scale", 1.0f));
            float fFloatValue2 = fValueOf.floatValue();
            if (!Float.isInfinite(fFloatValue2) && !Float.isNaN(fFloatValue2) && fFloatValue2 >= 0.0f) {
                f10 = fValueOf;
            }
            if (f10 != null) {
                fFloatValue = f10.floatValue();
            }
        } catch (SecurityException unused2) {
        }
        return Math.max(integer, (long) (jComputeDurationHint * fFloatValue));
    }

    private final void cancelGlassRefresh() {
        D d10 = this.pendingGlassRefresh;
        if (d10 != null) {
            d10.b();
        }
        this.pendingGlassRefresh = null;
    }

    private final int childWidthMeasureSpec(View child, int parentWidthMeasureSpec) {
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return ViewGroup.getChildMeasureSpec(parentWidthMeasureSpec, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void forceUniformWidth(int r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.getMeasuredWidth()
            r1 = 1073741824(0x40000000, float:2.0)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r0 = 0
        Lb:
            if (r0 >= r10) goto L42
            android.view.View r3 = r9.getChildAt(r0)
            int r1 = r3.getVisibility()
            r2 = 8
            if (r1 == r2) goto L3b
            android.view.ViewGroup$LayoutParams r1 = r3.getLayoutParams()
            java.lang.String r2 = "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams"
            kotlin.jvm.internal.p.g(r1, r2)
            androidx.appcompat.widget.LinearLayoutCompat$a r1 = (androidx.appcompat.widget.LinearLayoutCompat.a) r1
            int r2 = r1.width
            r5 = -1
            if (r2 != r5) goto L3b
            int r8 = r1.height
            int r2 = r3.getMeasuredHeight()
            r1.height = r2
            r5 = 0
            r7 = 0
            r2 = r9
            r6 = r11
            r2.measureChildWithMargins(r3, r4, r5, r6, r7)
            r1.height = r8
            goto L3d
        L3b:
            r2 = r9
            r6 = r11
        L3d:
            int r0 = r0 + 1
            r9 = r2
            r11 = r6
            goto Lb
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.dialog.StepOSAlertDialogLayout.forceUniformWidth(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t glassRebuild$lambda$3(StepOSAlertDialogLayout stepOSAlertDialogLayout, Context context) {
        Drawable drawableE = androidx.core.content.a.e(context, R.drawable.stepos_bg_dialog);
        stepOSAlertDialogLayout.fallback = drawableE != null ? drawableE.mutate() : null;
        stepOSAlertDialogLayout.reapplyGlass();
        return t.f7040a;
    }

    private final void protectBackgroundUntilAfterEntry() {
        if (isHardwareAccelerated()) {
            final WeakReference weakReference = new WeakReference(this);
            Runnable runnable = new Runnable() { // from class: com.stepos.widget.dialog.StepOSAlertDialogLayout$protectBackgroundUntilAfterEntry$callback$1
                @Override // java.lang.Runnable
                public void run() {
                    StepOSAlertDialogLayout stepOSAlertDialogLayout = weakReference.get();
                    if (stepOSAlertDialogLayout != null && stepOSAlertDialogLayout.pendingBackgroundFrame == this) {
                        stepOSAlertDialogLayout.pendingBackgroundFrame = null;
                        stepOSAlertDialogLayout.backgroundFrameObserver = null;
                        if (stepOSAlertDialogLayout.isAttachedToWindow() && stepOSAlertDialogLayout.getIsGlassEnabled() && stepOSAlertDialogLayout.glass.getHasRealGlass$StepOSWidget_release()) {
                            stepOSAlertDialogLayout.postOnAnimationDelayed(stepOSAlertDialogLayout.revealBackground, stepOSAlertDialogLayout.backgroundProtectionDuration());
                        }
                    }
                }
            };
            this.pendingBackgroundFrame = runnable;
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            viewTreeObserver.registerFrameCommitCallback(runnable);
            this.backgroundFrameObserver = viewTreeObserver;
        }
    }

    private final void reapplyGlass() {
        cancelGlassRefresh();
        resetBackgroundProtection();
        this.glass.release$StepOSWidget_release();
        this.appliedSize = null;
        if (this.isGlassEnabled) {
            requestGlass();
        }
        invalidate();
    }

    private final void refreshGlass() {
        if (!isAttachedToWindow() || !this.isGlassEnabled || getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        Pair<Integer, Integer> pairA = Y8.j.a(Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        if (kotlin.jvm.internal.p.d(pairA, this.appliedSize)) {
            return;
        }
        if (!this.glass.getHasHandle$StepOSWidget_release()) {
            this.glass.apply$StepOSWidget_release(1, getResources().getDimension(R.dimen.stepos_dialog_corner_radius), resolvedGlassEffect());
            if (this.glass.retainOnlyIfRealGlass$StepOSWidget_release()) {
                protectBackgroundUntilAfterEntry();
            }
        }
        this.appliedSize = pairA;
        invalidate();
    }

    private final void requestGlass() {
        if (this.isGlassEnabled && isAttachedToWindow() && this.pendingGlassRefresh == null) {
            this.pendingGlassRefresh = D.a(this, new Runnable() { // from class: com.stepos.widget.dialog.k
                @Override // java.lang.Runnable
                public final void run() {
                    StepOSAlertDialogLayout.requestGlass$lambda$4(this.f31186a);
                }
            });
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestGlass$lambda$4(StepOSAlertDialogLayout stepOSAlertDialogLayout) {
        stepOSAlertDialogLayout.pendingGlassRefresh = null;
        stepOSAlertDialogLayout.refreshGlass();
    }

    private final void resetBackgroundProtection() {
        ViewTreeObserver viewTreeObserver;
        Runnable runnable = this.pendingBackgroundFrame;
        if (runnable != null && (viewTreeObserver = this.backgroundFrameObserver) != null) {
            if (!viewTreeObserver.isAlive()) {
                viewTreeObserver = null;
            }
            if (viewTreeObserver != null) {
                viewTreeObserver.unregisterFrameCommitCallback(runnable);
            }
        }
        this.pendingBackgroundFrame = null;
        this.backgroundFrameObserver = null;
        removeCallbacks(this.revealBackground);
        ValueAnimator valueAnimator = this.fallbackAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.cancel();
        }
        this.fallbackAnimator = null;
        this.fallbackAlpha = 255;
    }

    private final y7.o resolvedGlassEffect() {
        y7.o oVar = this.glassEffect;
        return oVar == null ? getResources().getBoolean(R.bool.stepos_dialog_glass_light) ? y7.o.INSTANCE.j() : y7.o.INSTANCE.h() : oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void revealBackground$lambda$2(final StepOSAlertDialogLayout stepOSAlertDialogLayout) {
        if (stepOSAlertDialogLayout.isAttachedToWindow() && stepOSAlertDialogLayout.isGlassEnabled && stepOSAlertDialogLayout.glass.getHasRealGlass$StepOSWidget_release()) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, 0);
            valueAnimatorOfInt.setDuration(stepOSAlertDialogLayout.getResources().getInteger(android.R.integer.config_shortAnimTime));
            valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
            valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.widget.dialog.l
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    StepOSAlertDialogLayout.revealBackground$lambda$2$lambda$1$lambda$0(this.f31187a, valueAnimator);
                }
            });
            valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.stepos.widget.dialog.StepOSAlertDialogLayout$revealBackground$1$animator$1$2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    kotlin.jvm.internal.p.i(animation, "animation");
                    this.this$0.fallbackAnimator = null;
                }
            });
            stepOSAlertDialogLayout.fallbackAnimator = valueAnimatorOfInt;
            valueAnimatorOfInt.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void revealBackground$lambda$2$lambda$1$lambda$0(StepOSAlertDialogLayout stepOSAlertDialogLayout, ValueAnimator it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        stepOSAlertDialogLayout.fallbackAlpha = ((Integer) animatedValue).intValue();
        stepOSAlertDialogLayout.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private final boolean tryOnMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Object next;
        View next2;
        View next3;
        Integer num;
        C5680i c5680iS = C5685n.s(0, getChildCount());
        ArrayList arrayList = new ArrayList(C1174w.x(c5680iS, 10));
        Iterator<Integer> it = c5680iS.iterator();
        while (it.hasNext()) {
            arrayList.add(getChildAt(((M) it).nextInt()));
        }
        ArrayList<View> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((View) obj).getVisibility() != 8) {
                arrayList2.add(obj);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            if (((View) next).getId() == R.id.stepos_dialog_top_panel) {
                break;
            }
        }
        View view = (View) next;
        Iterator it3 = arrayList2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                next2 = 0;
                break;
            }
            next2 = it3.next();
            if (((View) next2).getId() == R.id.stepos_dialog_button_panel) {
                break;
            }
        }
        View view2 = next2;
        Iterator it4 = arrayList2.iterator();
        while (true) {
            if (!it4.hasNext()) {
                next3 = 0;
                break;
            }
            next3 = it4.next();
            if (((View) next3).getId() == R.id.stepos_dialog_middle_panel) {
                break;
            }
        }
        View view3 = next3;
        if (!arrayList2.isEmpty()) {
            for (View view4 : arrayList2) {
                if (view4 != view && view4 != view2 && view4 != view3) {
                    return false;
                }
            }
        }
        Iterator it5 = arrayList2.iterator();
        int i10 = 0;
        while (it5.hasNext()) {
            ViewGroup.LayoutParams layoutParams = ((View) it5.next()).getLayoutParams();
            kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i10 += marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        }
        int iF = C5685n.f(((View.MeasureSpec.getSize(heightMeasureSpec) - getPaddingTop()) - getPaddingBottom()) - i10, 0);
        tryOnMeasure$measure(this, widthMeasureSpec, view, 0, 0);
        tryOnMeasure$measure(this, widthMeasureSpec, view2, 0, 0);
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        int measuredHeight2 = view2 != null ? view2.getMeasuredHeight() : 0;
        Resources resources = getResources();
        int i11 = R.dimen.stepos_dialog_button_height;
        int iMin = Math.min(iF / 4, resources.getDimensionPixelSize(i11));
        int i12 = measuredHeight2;
        tryOnMeasure$measure$default(this, widthMeasureSpec, view3, iMin, 0, 16, null);
        int iMin2 = Math.min(view3 != null ? view3.getMeasuredHeight() : 0, iMin);
        int iJ = C5685n.j(i12, iF);
        if (measuredHeight + i12 + iMin2 > iF) {
            iJ = Math.min(i12, C5685n.j(Math.max(iF / 3, getResources().getDimensionPixelSize(i11)), iF));
        }
        tryOnMeasure$measure$default(this, widthMeasureSpec, view2, iJ, 0, 16, null);
        tryOnMeasure$measure$default(this, widthMeasureSpec, view, C5685n.f((iF - (view2 != null ? view2.getMeasuredHeight() : 0)) - iMin2, 0), 0, 16, null);
        tryOnMeasure$measure$default(this, widthMeasureSpec, view3, (iF - (view != null ? view.getMeasuredHeight() : 0)) - (view2 != null ? view2.getMeasuredHeight() : 0), 0, 16, null);
        int paddingTop = getPaddingTop() + getPaddingBottom() + i10;
        Iterator it6 = arrayList2.iterator();
        int measuredHeight3 = 0;
        while (it6.hasNext()) {
            measuredHeight3 += ((View) it6.next()).getMeasuredHeight();
        }
        int i13 = paddingTop + measuredHeight3;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        Iterator it7 = arrayList2.iterator();
        if (it7.hasNext()) {
            View view5 = (View) it7.next();
            ViewGroup.LayoutParams layoutParams2 = view5.getLayoutParams();
            kotlin.jvm.internal.p.g(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
            Integer numValueOf = Integer.valueOf(view5.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin);
            loop9: while (true) {
                num = numValueOf;
                while (it7.hasNext()) {
                    View view6 = (View) it7.next();
                    ViewGroup.LayoutParams layoutParams3 = view6.getLayoutParams();
                    kotlin.jvm.internal.p.g(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                    numValueOf = Integer.valueOf(view6.getMeasuredWidth() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin);
                    if (num.compareTo(numValueOf) < 0) {
                        break;
                    }
                }
            }
        } else {
            num = null;
        }
        int iIntValue = paddingLeft + (num != null ? num.intValue() : 0);
        Iterator it8 = arrayList2.iterator();
        int iCombineMeasuredStates = 0;
        while (it8.hasNext()) {
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, ((View) it8.next()).getMeasuredState());
        }
        setMeasuredDimension(View.resolveSizeAndState(iIntValue, widthMeasureSpec, iCombineMeasuredStates), View.resolveSizeAndState(i13, heightMeasureSpec, 0));
        if (View.MeasureSpec.getMode(widthMeasureSpec) == 1073741824) {
            return true;
        }
        forceUniformWidth(getChildCount(), heightMeasureSpec);
        return true;
    }

    private static final void tryOnMeasure$measure(StepOSAlertDialogLayout stepOSAlertDialogLayout, int i10, View view, int i11, int i12) {
        if (view != null) {
            view.measure(stepOSAlertDialogLayout.childWidthMeasureSpec(view, i10), View.MeasureSpec.makeMeasureSpec(C5685n.f(i11, 0), i12));
        }
    }

    public static /* synthetic */ void tryOnMeasure$measure$default(StepOSAlertDialogLayout stepOSAlertDialogLayout, int i10, View view, int i11, int i12, int i13, Object obj) {
        if ((i13 & 16) != 0) {
            i12 = Integer.MIN_VALUE;
        }
        tryOnMeasure$measure(stepOSAlertDialogLayout, i10, view, i11, i12);
    }

    /* renamed from: getBottomWindowMargin$StepOSWidget_release, reason: from getter */
    public final int getBottomWindowMargin() {
        return this.bottomWindowMargin;
    }

    /* renamed from: getFitInputMethod$StepOSWidget_release, reason: from getter */
    public final boolean getFitInputMethod() {
        return this.fitInputMethod;
    }

    public final y7.o getGlassEffect() {
        return this.glassEffect;
    }

    public final int getMaxHeight() {
        return this.maxHeight;
    }

    /* renamed from: isGlassEnabled, reason: from getter */
    public final boolean getIsGlassEnabled() {
        return this.isGlassEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetBackgroundProtection();
        requestGlass();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.p.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.glassRebuild.onConfigurationChanged$StepOSWidget_release(newConfig);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        cancelGlassRefresh();
        this.glassRebuild.cancel$StepOSWidget_release();
        resetBackgroundProtection();
        this.glass.cancelCover$StepOSWidget_release();
        this.glass.release$StepOSWidget_release();
        this.appliedSize = null;
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        int i10 = this.glass.getHasRealGlass$StepOSWidget_release() ? this.fallbackAlpha : 255;
        if (i10 > 0) {
            Drawable drawable = this.fallback;
            if (drawable != null) {
                drawable.setAlpha(i10);
            }
            Drawable drawable2 = this.fallback;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getWidth(), getHeight());
            }
            Drawable drawable3 = this.fallback;
            if (drawable3 != null) {
                drawable3.draw(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iMin = this.maxHeight;
        if (this.bottomWindowMargin > 0) {
            WindowMetrics currentWindowMetrics = ((WindowManager) getContext().getSystemService(WindowManager.class)).getCurrentWindowMetrics();
            kotlin.jvm.internal.p.h(currentWindowMetrics, "getCurrentWindowMetrics(...)");
            WindowInsets windowInsets = currentWindowMetrics.getWindowInsets();
            kotlin.jvm.internal.p.h(windowInsets, "getWindowInsets(...)");
            iMin = Math.min(iMin, StepOSDialogLayoutPolicy.INSTANCE.availableHeight$StepOSWidget_release(currentWindowMetrics.getBounds().height(), windowInsets.getInsets(WindowInsets.Type.statusBars() | WindowInsets.Type.captionBar() | WindowInsets.Type.displayCutout()).top, this.fitInputMethod ? windowInsets.getInsets(WindowInsets.Type.ime()).bottom : 0, this.bottomWindowMargin));
        }
        if (View.MeasureSpec.getMode(heightMeasureSpec) != 0) {
            iMin = Math.min(iMin, View.MeasureSpec.getSize(heightMeasureSpec));
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        if (tryOnMeasure(widthMeasureSpec, iMakeMeasureSpec)) {
            return;
        }
        super.onMeasure(widthMeasureSpec, iMakeMeasureSpec);
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        requestGlass();
    }

    public final void setBottomWindowMargin$StepOSWidget_release(int i10) {
        this.bottomWindowMargin = i10;
    }

    public final void setFitInputMethod$StepOSWidget_release(boolean z10) {
        this.fitInputMethod = z10;
    }

    public final void setGlassEffect(y7.o oVar) {
        if (kotlin.jvm.internal.p.d(this.glassEffect, oVar)) {
            return;
        }
        this.glassEffect = oVar;
        reapplyGlass();
    }

    public final void setGlassEnabled(boolean z10) {
        if (this.isGlassEnabled == z10) {
            return;
        }
        this.isGlassEnabled = z10;
        reapplyGlass();
    }

    public final void setMaxHeight(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException(("maxHeight must be > 0 but was " + i10).toString());
        }
        if (this.maxHeight == i10) {
            return;
        }
        this.maxHeight = i10;
        requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSAlertDialogLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ StepOSAlertDialogLayout(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSAlertDialogLayout(final Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.glass = new GlassDelegate(this);
        Drawable drawableE = androidx.core.content.a.e(context, R.drawable.stepos_bg_dialog);
        this.fallback = drawableE != null ? drawableE.mutate() : null;
        this.fallbackAlpha = 255;
        this.revealBackground = new Runnable() { // from class: com.stepos.widget.dialog.m
            @Override // java.lang.Runnable
            public final void run() {
                StepOSAlertDialogLayout.revealBackground$lambda$2(this.f31188a);
            }
        };
        this.glassRebuild = new GlassRebuildScheduler(this, new InterfaceC5063a() { // from class: com.stepos.widget.dialog.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return StepOSAlertDialogLayout.glassRebuild$lambda$3(this.f31189a, context);
            }
        });
        this.isGlassEnabled = true;
        setWillNotDraw(false);
        setClipToOutline(true);
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.stepos.widget.dialog.StepOSAlertDialogLayout.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                kotlin.jvm.internal.p.i(view, "view");
                kotlin.jvm.internal.p.i(outline, "outline");
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), StepOSAlertDialogLayout.this.getResources().getDimension(R.dimen.stepos_dialog_corner_radius));
            }
        });
        this.maxHeight = Integer.MAX_VALUE;
    }
}
