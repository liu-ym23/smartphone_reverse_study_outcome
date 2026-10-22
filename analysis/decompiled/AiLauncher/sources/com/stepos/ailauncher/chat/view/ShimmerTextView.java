package com.stepos.ailauncher.chat.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 F2\u00020\u0001:\u0001GB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0010\u0010\u000fJ\u001f\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ/\u0010#\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u0014¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020%H\u0014¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u000bH\u0002¢\u0006\u0004\b)\u0010\u000fJ\u000f\u0010*\u001a\u00020\u000bH\u0002¢\u0006\u0004\b*\u0010\u000fJ\u000f\u0010+\u001a\u00020\u000bH\u0002¢\u0006\u0004\b+\u0010\u000fJ\u000f\u0010,\u001a\u00020\u000bH\u0002¢\u0006\u0004\b,\u0010\u000fJ\u000f\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u0002012\u0006\u00100\u001a\u00020-H\u0002¢\u0006\u0004\b2\u00103R\u0016\u00104\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00107\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010@\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010<R\u0016\u0010C\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010<¨\u0006H"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ShimmerTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "playing", com.stepos.ailauncher.foundation.appui.card.provider.didi.o0.TRACK_STATUS_PAUSED, "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(ZZ)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "Landroid/view/View;", "changedView", "", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "onWindowVisibilityChanged", "(I)V", "", "text", "start", "lengthBefore", "lengthAfter", "onTextChanged", "(Ljava/lang/CharSequence;III)V", "w", "oldw", "oldh", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "o", "k", Const.INTENT_KEY_BACKGROUND_COMMAND, "m", "", "n", "()F", "sweep", "Landroid/graphics/LinearGradient;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(F)Landroid/graphics/LinearGradient;", "desiredPlaying", "Z", "callerPaused", "shimmering", "Landroid/animation/ValueAnimator;", "animator", "Landroid/animation/ValueAnimator;", "progress", "F", "Landroid/graphics/Matrix;", "shimmerMatrix", "Landroid/graphics/Matrix;", "gradient", "Landroid/graphics/LinearGradient;", "gradientSweepWidth", "gradientBaseColor", "I", "cachedSweepWidth", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ShimmerTextView extends AppCompatTextView {

    @Deprecated
    public static final float BAND_RATIO = 0.35f;
    private static final a Companion = new a(null);

    @Deprecated
    public static final float DIM_ALPHA_RATIO = 0.4f;

    @Deprecated
    public static final long DURATION_MS = 1500;
    private ValueAnimator animator;
    private float cachedSweepWidth;
    private boolean callerPaused;
    private boolean desiredPlaying;
    private LinearGradient gradient;
    private int gradientBaseColor;
    private float gradientSweepWidth;
    private float progress;
    private final Matrix shimmerMatrix;
    private boolean shimmering;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/chat/view/ShimmerTextView$a;", "", "<init>", "()V", "", "DURATION_MS", "J", "", "BAND_RATIO", "F", "DIM_ALPHA_RATIO", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShimmerTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.shimmerMatrix = new Matrix();
    }

    public static /* synthetic */ void i(ShimmerTextView shimmerTextView, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        shimmerTextView.h(z10, z11);
    }

    public static final void l(ShimmerTextView shimmerTextView, ValueAnimator it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        shimmerTextView.progress = ((Float) animatedValue).floatValue();
        shimmerTextView.invalidate();
    }

    public final void g() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            if (!valueAnimator.isStarted()) {
                valueAnimator = null;
            }
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
        this.animator = null;
    }

    public final void h(boolean playing, boolean paused) {
        if (this.desiredPlaying == playing && this.callerPaused == paused) {
            return;
        }
        this.desiredPlaying = playing;
        this.callerPaused = paused;
        o();
    }

    public final LinearGradient j(float sweep) {
        float f10 = sweep * 0.35f;
        int currentTextColor = getCurrentTextColor();
        LinearGradient linearGradient = this.gradient;
        if (linearGradient == null || this.gradientSweepWidth != sweep || this.gradientBaseColor != currentTextColor) {
            int iArgb = Color.argb((int) (Color.alpha(currentTextColor) * 0.4f), Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor));
            linearGradient = new LinearGradient(0.0f, 0.0f, f10, 0.0f, new int[]{iArgb, currentTextColor, iArgb}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
            this.gradient = linearGradient;
            this.gradientSweepWidth = sweep;
            this.gradientBaseColor = currentTextColor;
        }
        this.shimmerMatrix.setTranslate((getPaddingLeft() - f10) + (this.progress * (sweep + (f10 * 2))), 0.0f);
        linearGradient.setLocalMatrix(this.shimmerMatrix);
        return linearGradient;
    }

    public final void k() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator == null || !valueAnimator.isStarted()) {
            this.shimmering = true;
            float f10 = this.progress;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setDuration(1500L);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.view.r8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    ShimmerTextView.l(this.f26321a, valueAnimator2);
                }
            });
            valueAnimatorOfFloat.start();
            if (f10 > 0.0f) {
                valueAnimatorOfFloat.setCurrentPlayTime((long) (f10 * 1500));
            }
            this.animator = valueAnimatorOfFloat;
        }
    }

    public final void m() {
        boolean z10 = this.shimmering;
        this.shimmering = false;
        this.progress = 0.0f;
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            if (!valueAnimator.isStarted()) {
                valueAnimator = null;
            }
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
        this.animator = null;
        if (z10) {
            invalidate();
        }
    }

    public final float n() {
        float fMin = 0.0f;
        if (this.cachedSweepWidth <= 0.0f) {
            float width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            if (width > 0.0f) {
                TextPaint paint = getPaint();
                CharSequence text = getText();
                String string = text != null ? text.toString() : null;
                if (string == null) {
                    string = "";
                }
                fMin = Math.min(paint.measureText(string), width);
            }
            this.cachedSweepWidth = fMin;
        }
        return this.cachedSweepWidth;
    }

    public final void o() {
        if (!this.desiredPlaying) {
            m();
        } else if (!this.callerPaused && isAttachedToWindow() && isShown()) {
            k();
        } else {
            g();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        o();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        float fN = this.shimmering ? n() : 0.0f;
        if (fN > 0.0f) {
            getPaint().setShader(j(fN));
        } else if (getPaint().getShader() != null) {
            getPaint().setShader(null);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        this.cachedSweepWidth = 0.0f;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        this.cachedSweepWidth = 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        kotlin.jvm.internal.p.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        o();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        o();
    }

    public final void setShimmerPlaying(boolean z10) {
        i(this, z10, false, 2, null);
    }
}
