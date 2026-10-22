package com.stepos.agentframework.chatui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$styleable;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0014J\u000f\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u0014J\u000f\u0010\u001c\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001c\u0010\u0014J\u0017\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010'\u001a\u00020\u001d8\u0002X\u0082D¢\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010%R\u001c\u0010.\u001a\n -*\u0004\u0018\u00010,0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/stepos/agentframework/chatui/view/LoadingDotsView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "LY8/t;", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", Const.INTENT_KEY_UMID, "e", "f", "", UxipConstants.f30680s, "c", "(F)F", "dotCount", "I", "dotColor", "dotRadiusPx", "F", "dotGapPx", "minAlpha", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "phase", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "animator", "Landroid/animation/ValueAnimator;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoadingDotsView extends View {
    private final ValueAnimator animator;
    private final int dotColor;
    private final int dotCount;
    private final float dotGapPx;
    private final float dotRadiusPx;
    private final float minAlpha;
    private final Paint paint;
    private float phase;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadingDotsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final void b(LoadingDotsView loadingDotsView, ValueAnimator it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        loadingDotsView.phase = ((Float) animatedValue).floatValue();
        loadingDotsView.invalidate();
    }

    public final float c(float value) {
        return value * getResources().getDisplayMetrics().density;
    }

    public final void d() {
        if (this.animator.isStarted()) {
            return;
        }
        this.animator.start();
    }

    public final void e() {
        if (this.animator.isStarted()) {
            this.animator.cancel();
        }
    }

    public final void f() {
        if (isAttachedToWindow() && isShown()) {
            d();
        } else {
            e();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        e();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        float height = getHeight() / 2.0f;
        float f10 = this.dotRadiusPx;
        int i10 = this.dotCount;
        for (int i11 = 0; i11 < i10; i11++) {
            float f11 = this.phase;
            int i12 = this.dotCount;
            float fSin = (((float) Math.sin((((f11 + (((i12 - 1) - i11) / i12)) % 1.0f) * r7) * 3.141592653589793d)) + 1.0f) / 2.0f;
            Paint paint = this.paint;
            float f12 = this.minAlpha;
            paint.setAlpha((int) ((f12 + ((1.0f - f12) * fSin)) * 255));
            canvas.drawCircle(f10, height, this.dotRadiusPx, this.paint);
            f10 += (this.dotRadiusPx * 2) + this.dotGapPx;
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float f10 = this.dotRadiusPx;
        float f11 = 2;
        setMeasuredDimension(View.resolveSize(Math.max((int) ((f10 * f11 * this.dotCount) + (this.dotGapPx * (r3 - 1))), getSuggestedMinimumWidth()), widthMeasureSpec), View.resolveSize(Math.max((int) (f10 * f11), getSuggestedMinimumHeight()), heightMeasureSpec));
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        kotlin.jvm.internal.p.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingDotsView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.dotCount = 3;
        this.dotColor = -1;
        this.minAlpha = 0.3f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LoadingDotsView);
        kotlin.jvm.internal.p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.dotRadiusPx = typedArrayObtainStyledAttributes.getDimension(R$styleable.LoadingDotsView_dotDiameter, c(7.0f)) / 2.0f;
        this.dotGapPx = typedArrayObtainStyledAttributes.getDimension(R$styleable.LoadingDotsView_dotGap, c(6.0f));
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        paint.setColor(-1);
        this.paint = paint;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(1000L);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.agentframework.chatui.view.r
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LoadingDotsView.b(this.f23136a, valueAnimator);
            }
        });
        this.animator = valueAnimatorOfFloat;
    }

    public /* synthetic */ LoadingDotsView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
