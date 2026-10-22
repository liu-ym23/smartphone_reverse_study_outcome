package com.stepos.taskrobot.llmapi.stepfun.view.blur;

import A6.j;
import C7.r;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.MotionKit;
import com.stepos.motionkit.fx.material.MaterialHandle;
import com.stepos.motionkit.fx.material.Materials;
import com.stepos.motionkit.fx.material.MotionMaterialExtKt;
import com.stepos.motionkit.fx.material.capability.BlurParams;
import com.stepos.taskrobot.llmapi.stepfun.g;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u0012\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0019\u0010\fJ\u001f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010(\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001a8\u0006@BX\u0086.¢\u0006\f\n\u0004\b(\u0010 \u001a\u0004\b)\u0010*R\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010+R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010,¨\u0006-"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/blur/BlurCardView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LC7/r;", "commitBlurIfNeeded", "()V", "contentLayout", "blurTargetId", "blurRadiusPx", "", "cornerRadiusPx", "setUp", "(IIIF)V", "", "durationMs", "Landroid/animation/Animator;", "createBlurFadeOutAnimator", "(J)Landroid/animation/Animator;", "onAttachedToWindow", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "blurTarget", "Landroid/view/View;", "Landroid/graphics/drawable/Drawable;", "blurDrawable", "Landroid/graphics/drawable/Drawable;", "Lcom/stepos/motionkit/fx/material/MaterialHandle;", "motionHandle", "Lcom/stepos/motionkit/fx/material/MaterialHandle;", "value", "contentView", "getContentView", "()Landroid/view/View;", "I", "F", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BlurCardView extends FrameLayout {
    private Drawable blurDrawable;
    private int blurRadiusPx;
    private View blurTarget;
    private View contentView;
    private float cornerRadiusPx;
    private MaterialHandle motionHandle;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BlurCardView(Context context) {
        this(context, null, 0, 6, null);
        k.f(context, "context");
    }

    private final void commitBlurIfNeeded() {
        View view;
        Drawable drawable;
        if (this.motionHandle == null && (view = this.blurTarget) != null) {
            this.motionHandle = MotionMaterialExtKt.material(MotionKit.INSTANCE, view).crossWindow(true).cornerRadius(this.cornerRadiusPx).apply(Materials.INSTANCE.getBlur(), new g(this, 3)).commit();
            this.blurDrawable = view.getBackground();
            if (isShown() || (drawable = this.blurDrawable) == null) {
                return;
            }
            BlurDrawableHandle.INSTANCE.setBlurRadius(drawable, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r commitBlurIfNeeded$lambda$0(BlurCardView blurCardView, BlurParams apply) {
        k.f(apply, "$this$apply");
        apply.setRadius(blurCardView.blurRadiusPx);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createBlurFadeOutAnimator$lambda$0$0(Drawable drawable, ValueAnimator it) {
        k.f(it, "it");
        BlurDrawableHandle blurDrawableHandle = BlurDrawableHandle.INSTANCE;
        Object animatedValue = it.getAnimatedValue();
        k.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        blurDrawableHandle.setBlurRadius(drawable, ((Integer) animatedValue).intValue());
    }

    public final Animator createBlurFadeOutAnimator(long durationMs) {
        Drawable drawable = this.blurDrawable;
        if (drawable == null) {
            return null;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.blurRadiusPx, 0);
        valueAnimatorOfInt.setDuration(durationMs);
        valueAnimatorOfInt.addUpdateListener(new j(drawable, 6));
        valueAnimatorOfInt.start();
        return valueAnimatorOfInt;
    }

    public final View getContentView() {
        View view = this.contentView;
        if (view != null) {
            return view;
        }
        k.n("contentView");
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        commitBlurIfNeeded();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        k.f(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        Drawable drawable = this.blurDrawable;
        if (drawable == null) {
            return;
        }
        if (visibility == 0 && isShown()) {
            BlurDrawableHandle.INSTANCE.setBlurRadius(drawable, this.blurRadiusPx);
        } else {
            BlurDrawableHandle.INSTANCE.setBlurRadius(drawable, 0);
        }
    }

    public final void setUp(@LayoutRes int contentLayout, @IdRes int blurTargetId, int blurRadiusPx, float cornerRadiusPx) {
        if (this.contentView != null) {
            throw new IllegalStateException("setUp must be called once");
        }
        this.blurRadiusPx = blurRadiusPx;
        this.cornerRadiusPx = cornerRadiusPx;
        View viewInflate = LayoutInflater.from(getContext()).inflate(contentLayout, (ViewGroup) this, false);
        k.e(viewInflate, "inflate(...)");
        this.contentView = viewInflate;
        addView(getContentView());
        setClipChildren(false);
        this.blurTarget = getContentView().findViewById(blurTargetId);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BlurCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlurCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k.f(context, "context");
    }

    public /* synthetic */ BlurCardView(Context context, AttributeSet attributeSet, int i, int i6, e eVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 0 : i);
    }
}
