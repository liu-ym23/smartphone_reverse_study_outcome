package com.stepos.ailauncher.agent.skill.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.skill.widget.IndeterminateSpinnerView;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0019\u0010\rJ/\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 H\u0014¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0004\b$\u0010\u000fR\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010-R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/widget/IndeterminateSpinnerView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "color", "LY8/t;", "setColor", "(I)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "", "isVisible", "onVisibilityAggregated", "(Z)V", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "onWindowVisibilityChanged", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "c", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "Landroid/graphics/RectF;", "bounds", "Landroid/graphics/RectF;", "", "ringWidthDp", "F", "gapAngleDeg", "", "cycleDurationMs", "J", "rotationDeg", "Landroid/animation/ValueAnimator;", "rotateAnim", "Landroid/animation/ValueAnimator;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class IndeterminateSpinnerView extends View {
    private final RectF bounds;
    private long cycleDurationMs;
    private float gapAngleDeg;
    private final Paint paint;
    private float ringWidthDp;
    private final ValueAnimator rotateAnim;
    private float rotationDeg;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IndeterminateSpinnerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    public static final void b(IndeterminateSpinnerView indeterminateSpinnerView, ValueAnimator it) {
        p.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        indeterminateSpinnerView.rotationDeg = ((Float) animatedValue).floatValue();
        indeterminateSpinnerView.invalidate();
    }

    public final void c() {
        if (!isAttachedToWindow() || getWindowVisibility() != 0 || !isShown()) {
            this.rotateAnim.cancel();
        } else {
            if (this.rotateAnim.isStarted()) {
                return;
            }
            this.rotateAnim.start();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.rotateAnim.cancel();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        p.i(canvas, "canvas");
        canvas.drawArc(this.bounds, this.rotationDeg - 90.0f, 360.0f - this.gapAngleDeg, false, this.paint);
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        float f10 = this.ringWidthDp * getResources().getDisplayMetrics().density;
        this.paint.setStrokeWidth(f10);
        float f11 = f10 / 2.0f;
        float fMin = Math.min(w10, h10);
        float f12 = ((w10 - fMin) / 2.0f) + f11;
        float f13 = ((h10 - fMin) / 2.0f) + f11;
        this.bounds.set(f12, f13, (f12 + fMin) - f10, (fMin + f13) - f10);
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        c();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        p.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (isAttachedToWindow()) {
            c();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        c();
    }

    public final void setColor(int color) {
        if (this.paint.getColor() != color) {
            this.paint.setColor(color);
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndeterminateSpinnerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(-1);
        this.paint = paint;
        this.bounds = new RectF();
        this.ringWidthDp = 2.5f;
        this.gapAngleDeg = 90.0f;
        this.cycleDurationMs = 900L;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        valueAnimatorOfFloat.setDuration(this.cycleDurationMs);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: e5.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                IndeterminateSpinnerView.b(this.f32293a, valueAnimator);
            }
        });
        p.h(valueAnimatorOfFloat, "apply(...)");
        this.rotateAnim = valueAnimatorOfFloat;
    }

    public /* synthetic */ IndeterminateSpinnerView(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
