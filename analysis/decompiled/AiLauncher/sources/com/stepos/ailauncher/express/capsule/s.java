package com.stepos.ailauncher.express.capsule;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0012\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/express/capsule/s;", "Landroid/view/View;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "widthMeasureSpec", "heightMeasureSpec", "LY8/t;", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "", "v", "c", "(F)F", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "phase", "F", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "animator", "Landroid/animation/ValueAnimator;", "Companion", Const.INTENT_KEY_APIKEY, "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class s extends View {
    private static final float BOUNCE_DP = 2.0f;
    private static final long CYCLE_MS = 600;
    private static final int DOT_COUNT = 3;
    private static final float DOT_DP = 3.0f;
    private static final float GAP_DP = 4.0f;
    private static final float GROUP_ALPHA = 0.9f;
    private static final float SLOT_DP = 24.0f;
    private final ValueAnimator animator;
    private final Paint paint;
    private float phase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(Context context) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setAlpha(229);
        this.paint = paint;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(CYCLE_MS);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.express.capsule.r
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                s.b(this.f27112a, valueAnimator);
            }
        });
        this.animator = valueAnimatorOfFloat;
    }

    public static final void b(s sVar, ValueAnimator it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        sVar.phase = ((Float) animatedValue).floatValue();
        sVar.invalidate();
    }

    public final float c(float v10) {
        return TypedValue.applyDimension(1, v10, getResources().getDisplayMetrics());
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            this.animator.start();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.animator.cancel();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        float fC = c(3.0f);
        float fC2 = c(4.0f);
        float fC3 = c(2.0f);
        float f10 = fC / 2.0f;
        float f11 = 3;
        float width = ((getWidth() - ((fC * f11) + (2 * fC2))) / 2.0f) + f10;
        float height = getHeight() / 2.0f;
        for (int i10 = 0; i10 < 3; i10++) {
            float f12 = i10;
            float f13 = (this.phase - (f12 / f11)) % 1.0f;
            if (f13 != 0.0f && Math.signum(f13) != Math.signum(1.0f)) {
                f13 += 1.0f;
            }
            float f14 = (-((float) Math.sin(f13 * 2.0d * 3.141592653589793d))) * fC3;
            this.paint.setAlpha(229);
            canvas.drawCircle((f12 * (fC + fC2)) + width, f14 + height, f10, this.paint);
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iC = (int) c(24.0f);
        setMeasuredDimension(iC, iC);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        kotlin.jvm.internal.p.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (isAttachedToWindow() && isShown()) {
            if (this.animator.isStarted()) {
                return;
            }
            this.animator.start();
        } else if (this.animator.isStarted()) {
            this.animator.cancel();
        }
    }
}
