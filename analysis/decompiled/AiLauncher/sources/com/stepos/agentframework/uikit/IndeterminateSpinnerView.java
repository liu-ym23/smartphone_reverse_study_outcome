package com.stepos.agentframework.uikit;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001e\u0010\rJ/\u0010#\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0014¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%H\u0014¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u000bH\u0002¢\u0006\u0004\b)\u0010\u0014J\u001f\u0010*\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010.R\u0016\u00100\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00106R\u0016\u00108\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00106R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006@"}, d2 = {"Lcom/stepos/agentframework/uikit/IndeterminateSpinnerView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "color", "LY8/t;", "setColor", "(I)V", "setBackgroundCircleColor", "", "dp", "setRingPaddingDp", "(F)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "", "isVisible", "onVisibilityAggregated", "(Z)V", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "onWindowVisibilityChanged", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "(II)V", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "bgPaint", "drawBackground", "Z", "Landroid/graphics/RectF;", "bounds", "Landroid/graphics/RectF;", "ringWidthDp", "F", "ringPaddingDp", "gapAngleDeg", "", "cycleDurationMs", "J", "rotationDeg", "Landroid/animation/ValueAnimator;", "rotateAnim", "Landroid/animation/ValueAnimator;", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IndeterminateSpinnerView extends View {
    private final Paint bgPaint;
    private final RectF bounds;
    private long cycleDurationMs;
    private boolean drawBackground;
    private float gapAngleDeg;
    private final Paint paint;
    private float ringPaddingDp;
    private float ringWidthDp;
    private final ValueAnimator rotateAnim;
    private float rotationDeg;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IndeterminateSpinnerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final void c(IndeterminateSpinnerView indeterminateSpinnerView, ValueAnimator it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        indeterminateSpinnerView.rotationDeg = ((Float) animatedValue).floatValue();
        indeterminateSpinnerView.invalidate();
    }

    public final void b(int w10, int h10) {
        if (w10 == 0 || h10 == 0) {
            return;
        }
        float f10 = this.ringWidthDp * getResources().getDisplayMetrics().density;
        this.paint.setStrokeWidth(f10);
        float f11 = (f10 / 2.0f) + (this.ringPaddingDp * getResources().getDisplayMetrics().density);
        float fMin = Math.min(w10, h10);
        float f12 = ((w10 - fMin) / 2.0f) + f11;
        float f13 = ((h10 - fMin) / 2.0f) + f11;
        float f14 = f11 * 2.0f;
        this.bounds.set(f12, f13, (f12 + fMin) - f14, (fMin + f13) - f14);
    }

    public final void d() {
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
        d();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.rotateAnim.cancel();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (this.drawBackground) {
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, Math.min(getWidth(), getHeight()) / 2.0f, this.bgPaint);
        }
        canvas.drawArc(this.bounds, this.rotationDeg - 90.0f, 360.0f - this.gapAngleDeg, false, this.paint);
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        b(w10, h10);
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        d();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        kotlin.jvm.internal.p.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (isAttachedToWindow()) {
            d();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        d();
    }

    public final void setBackgroundCircleColor(int color) {
        if (this.bgPaint.getColor() != color) {
            this.bgPaint.setColor(color);
            this.drawBackground = Color.alpha(color) != 0;
            invalidate();
        }
    }

    public final void setColor(int color) {
        if (this.paint.getColor() != color) {
            this.paint.setColor(color);
            invalidate();
        }
    }

    public final void setRingPaddingDp(float dp) {
        if (this.ringPaddingDp == dp) {
            return;
        }
        this.ringPaddingDp = dp;
        b(getWidth(), getHeight());
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndeterminateSpinnerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(-1);
        this.paint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(0);
        this.bgPaint = paint2;
        this.bounds = new RectF();
        this.ringWidthDp = 2.5f;
        this.gapAngleDeg = 90.0f;
        this.cycleDurationMs = 900L;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        valueAnimatorOfFloat.setDuration(this.cycleDurationMs);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.agentframework.uikit.B
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                IndeterminateSpinnerView.c(this.f23303a, valueAnimator);
            }
        });
        kotlin.jvm.internal.p.h(valueAnimatorOfFloat, "apply(...)");
        this.rotateAnim = valueAnimatorOfFloat;
    }

    public /* synthetic */ IndeterminateSpinnerView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
