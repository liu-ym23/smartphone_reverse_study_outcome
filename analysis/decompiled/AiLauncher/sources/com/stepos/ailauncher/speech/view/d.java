package com.stepos.ailauncher.speech.view;

import Y8.t;
import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\"H\u0014¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010-R\u0018\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R0\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000e\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R*\u0010>\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u001e8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010!R*\u0010C\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010\u001dR\u0017\u0010I\u001a\u00020H8\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L¨\u0006M"}, d2 = {"Lcom/stepos/ailauncher/speech/view/d;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "LY8/t;", "onSizeChanged", "(IIII)V", "", "text", "Landroid/widget/TextView$BufferType;", "type", "setText", "(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V", "", ContentDisposition.Parameters.Size, "setTextPaintSize", "(F)V", "color", "setTextPaintColor", "(I)V", "", "isBold", "setPaintBoldText", "(Z)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "newFullText", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)V", "fullText", "Ljava/lang/String;", "textDrawOffsetX", "F", "currentScrollX", "Landroid/text/TextPaint;", "textPaint", "Landroid/text/TextPaint;", "availableWidth", "Landroid/animation/ValueAnimator;", "animator", "Landroid/animation/ValueAnimator;", "Lkotlin/Function1;", "callShowEllipsis", "Lp9/l;", "getCallShowEllipsis", "()Lp9/l;", "setCallShowEllipsis", "(Lp9/l;)V", UxipConstants.f30680s, "showAnimation", "Z", "getShowAnimation", "()Z", "setShowAnimation", "bgColor", "I", "getBgColor", "()I", "setBgColor", "Landroid/graphics/Paint;", "backgroundPaint", "Landroid/graphics/Paint;", "getBackgroundPaint", "()Landroid/graphics/Paint;", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d extends AppCompatTextView {
    private ValueAnimator animator;
    private float availableWidth;
    private final Paint backgroundPaint;
    private int bgColor;
    private InterfaceC5074l<? super Boolean, t> callShowEllipsis;
    private float currentScrollX;
    private String fullText;
    private boolean showAnimation;
    private float textDrawOffsetX;
    private final TextPaint textPaint;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "LY8/t;", "onAnimationRepeat", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Animator.AnimatorListener {
        final /* synthetic */ float $targetScrollX$inlined;

        public a(float f10) {
            this.$targetScrollX$inlined = f10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.currentScrollX = this.$targetScrollX$inlined;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        this.fullText = "";
        this.textPaint = new TextPaint(getPaint());
        this.showAnimation = true;
        setMaxLines(1);
        setSingleLine(true);
        setEllipsize(null);
        setTextColor(R.color.transparent);
        this.bgColor = Color.parseColor("#FFFFFF");
        Paint paint = new Paint();
        paint.setColor(this.bgColor);
        this.backgroundPaint = paint;
    }

    public static final void j(d dVar, String str) {
        dVar.i(str);
    }

    public static final void k(d dVar, ValueAnimator anim) {
        p.i(anim, "anim");
        Object animatedValue = anim.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        dVar.textDrawOffsetX = ((Float) animatedValue).floatValue();
        dVar.invalidate();
    }

    public final Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final InterfaceC5074l<Boolean, t> getCallShowEllipsis() {
        return this.callShowEllipsis;
    }

    public final boolean getShowAnimation() {
        return this.showAnimation;
    }

    public final void i(final String newFullText) {
        if (this.availableWidth <= 0.0f) {
            post(new Runnable() { // from class: com.stepos.ailauncher.speech.view.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.j(this.f28353a, newFullText);
                }
            });
            return;
        }
        this.fullText = newFullText;
        float fMeasureText = this.textPaint.measureText(newFullText);
        float f10 = this.availableWidth;
        float f11 = fMeasureText > f10 ? -(fMeasureText - f10) : 0.0f;
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.currentScrollX, f11);
        valueAnimatorOfFloat.setDuration(600L);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.speech.view.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                d.k(this.f28355a, valueAnimator2);
            }
        });
        p.f(valueAnimatorOfFloat);
        valueAnimatorOfFloat.addListener(new a(f11));
        valueAnimatorOfFloat.start();
        this.animator = valueAnimatorOfFloat;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        p.i(canvas, "canvas");
        if (!this.showAnimation) {
            super.onDraw(canvas);
            return;
        }
        if (this.fullText.length() == 0) {
            return;
        }
        float fMeasureText = this.textPaint.measureText(this.fullText);
        float paddingLeft = getPaddingLeft() + this.textDrawOffsetX;
        canvas.drawText(this.fullText, paddingLeft, ((((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2.0f) - ((this.textPaint.ascent() + this.textPaint.descent()) / 2.0f)) + getPaddingTop(), this.textPaint);
        boolean z10 = fMeasureText > this.availableWidth && paddingLeft < ((float) getPaddingLeft());
        InterfaceC5074l<? super Boolean, t> interfaceC5074l = this.callShowEllipsis;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        this.availableWidth = (w10 - getPaddingLeft()) - getPaddingRight();
    }

    public final void setBgColor(int i10) {
        this.bgColor = i10;
        this.backgroundPaint.setColor(i10);
    }

    public final void setCallShowEllipsis(InterfaceC5074l<? super Boolean, t> interfaceC5074l) {
        this.callShowEllipsis = interfaceC5074l;
    }

    public final void setPaintBoldText(boolean isBold) {
        this.textPaint.setFakeBoldText(isBold);
        invalidate();
    }

    public final void setShowAnimation(boolean z10) {
        InterfaceC5074l<? super Boolean, t> interfaceC5074l;
        this.showAnimation = z10;
        if (z10 || (interfaceC5074l = this.callShowEllipsis) == null) {
            return;
        }
        interfaceC5074l.invoke(Boolean.FALSE);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence text, TextView.BufferType type) {
        String string;
        if (!this.showAnimation) {
            super.setText(text, type);
            return;
        }
        if (text == null || (string = text.toString()) == null) {
            string = "";
        }
        i(string);
    }

    public final void setTextPaintColor(int color) {
        this.textPaint.setColor(color);
        invalidate();
    }

    public final void setTextPaintSize(float size) {
        this.textPaint.setTextSize(size);
        invalidate();
    }

    public /* synthetic */ d(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? R.attr.textViewStyle : i10);
    }
}
