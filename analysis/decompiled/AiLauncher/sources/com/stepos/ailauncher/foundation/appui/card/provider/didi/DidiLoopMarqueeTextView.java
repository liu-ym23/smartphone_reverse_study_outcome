package com.stepos.ailauncher.foundation.appui.card.provider.didi;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 <2\u00020\u0001:\u0001=B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0015\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\nH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\r2\u0006\u0010$\u001a\u00020#H\u0014¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0014¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020'H\u0014¢\u0006\u0004\b*\u0010)J\u000f\u0010\u0018\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u001eJ\u000f\u0010+\u001a\u00020\nH\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\nH\u0002¢\u0006\u0004\b-\u0010,J\u000f\u0010.\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020'H\u0002¢\u0006\u0004\b0\u0010)J\u0017\u00102\u001a\u00020'2\u0006\u00101\u001a\u00020'H\u0002¢\u0006\u0004\b2\u00103R\u0016\u00104\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010\f\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00106R\u0016\u00107\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00106R\u0016\u00108\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiLoopMarqueeTextView;", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", x5.d.EXTRA_ENABLED, "gapPx", "LY8/t;", "e", "(ZI)V", "", "text", "start", "lengthBefore", "lengthAfter", "onTextChanged", "(Ljava/lang/CharSequence;III)V", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "isVisible", "onVisibilityAggregated", "(Z)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "getLeftFadingEdgeStrength", "()F", "getRightFadingEdgeStrength", "f", "()Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "c", "()I", Const.INTENT_KEY_PKGNAME, "valueDp", Const.INTENT_KEY_UMID, "(F)F", "loopMarqueeEnabled", "Z", "F", "offsetPx", "textWidthPx", "Landroid/animation/ValueAnimator;", "animator", "Landroid/animation/ValueAnimator;", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DidiLoopMarqueeTextView extends TextView {
    private static final a Companion = new a(null);

    @Deprecated
    public static final float MARQUEE_SPEED_DP_PER_SECOND = 30.0f;
    private ValueAnimator animator;
    private float gapPx;
    private boolean loopMarqueeEnabled;
    private float offsetPx;
    private float textWidthPx;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/DidiLoopMarqueeTextView$a;", "", "<init>", "()V", "", "MARQUEE_SPEED_DP_PER_SECOND", "F", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DidiLoopMarqueeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final void i(DidiLoopMarqueeTextView didiLoopMarqueeTextView, ValueAnimator it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        didiLoopMarqueeTextView.offsetPx = ((Float) animatedValue).floatValue();
        didiLoopMarqueeTextView.invalidate();
    }

    public final float b() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (getPaddingTop() + (((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2.0f)) - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f);
    }

    public final int c() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public final float d(float valueDp) {
        return TypedValue.applyDimension(1, valueDp, getResources().getDisplayMetrics());
    }

    public final void e(boolean enabled, int gapPx) {
        this.loopMarqueeEnabled = enabled;
        this.gapPx = gapPx;
        setHorizontalFadingEdgeEnabled(enabled);
        setSingleLine(true);
        h();
    }

    public final boolean f() {
        return this.loopMarqueeEnabled && getVisibility() == 0 && isShown() && isAttachedToWindow() && ValueAnimator.areAnimatorsEnabled() && this.textWidthPx > ((float) c());
    }

    public final boolean g() {
        return this.loopMarqueeEnabled && this.textWidthPx > ((float) c());
    }

    @Override // android.widget.TextView, android.view.View
    public float getLeftFadingEdgeStrength() {
        return g() ? 1.0f : 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public float getRightFadingEdgeStrength() {
        return g() ? 1.0f : 0.0f;
    }

    public final void h() {
        TextPaint paint = getPaint();
        CharSequence text = getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        this.textWidthPx = paint.measureText(string);
        if (!f()) {
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            this.animator = null;
            this.offsetPx = 0.0f;
            invalidate();
            return;
        }
        float f10 = this.textWidthPx + this.gapPx;
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, f10);
            valueAnimatorOfFloat.setDuration((long) ((f10 / d(30.0f)) * 1000));
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.didi.M
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    DidiLoopMarqueeTextView.i(this.f27373a, valueAnimator3);
                }
            });
            valueAnimatorOfFloat.start();
            this.animator = valueAnimatorOfFloat;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        if (!g()) {
            super.onDraw(canvas);
            return;
        }
        CharSequence text = getText();
        String string = text != null ? text.toString() : null;
        if (string == null) {
            string = "";
        }
        float paddingLeft = getPaddingLeft();
        float fB = b();
        int color = getPaint().getColor();
        getPaint().setColor(getCurrentTextColor());
        int iSave = canvas.save();
        canvas.clipRect(paddingLeft, getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        canvas.drawText(string, paddingLeft - this.offsetPx, fB, getPaint());
        canvas.drawText(string, (paddingLeft - this.offsetPx) + this.textWidthPx + this.gapPx, fB, getPaint());
        canvas.restoreToCount(iSave);
        getPaint().setColor(color);
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        h();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        h();
    }

    @Override // android.widget.TextView, android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DidiLoopMarqueeTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ DidiLoopMarqueeTextView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
