package com.stepos.ailauncher.chat.widget;

import Y8.t;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.a;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$color;
import com.stepos.ailauncher.chat.widget.FigmaSwitch;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\"R\u0014\u0010&\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010,R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R*\u00102\u001a\u00020\n2\u0006\u00101\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u000eR0\u00107\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010\"R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006A"}, d2 = {"Lcom/stepos/ailauncher/chat/widget/FigmaSwitch;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "checked", "LY8/t;", "setCheckedSilent", "(Z)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "performClick", "()Z", Const.INTENT_KEY_PKGNAME, "()V", "from", "to", "", "fraction", "e", "(IIF)I", "density", "F", "trackWidth", "trackHeight", "thumbRadius", "thumbPadding", "trackColorOn", "I", "trackColorOff", "Landroid/graphics/Paint;", "trackPaint", "Landroid/graphics/Paint;", "thumbPaint", "Landroid/graphics/RectF;", "trackRect", "Landroid/graphics/RectF;", UxipConstants.f30680s, "isChecked", "Z", Const.INTENT_KEY_UMID, "setChecked", "Lkotlin/Function1;", "onCheckedChangeListener", "Lp9/l;", "getOnCheckedChangeListener", "()Lp9/l;", "setOnCheckedChangeListener", "(Lp9/l;)V", "thumbPosition", "Landroid/animation/ValueAnimator;", "animator", "Landroid/animation/ValueAnimator;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FigmaSwitch extends View {
    private ValueAnimator animator;
    private final float density;
    private boolean isChecked;
    private InterfaceC5074l<? super Boolean, t> onCheckedChangeListener;
    private final float thumbPadding;
    private final Paint thumbPaint;
    private float thumbPosition;
    private final float thumbRadius;
    private final int trackColorOff;
    private final int trackColorOn;
    private final float trackHeight;
    private final Paint trackPaint;
    private final RectF trackRect;
    private final float trackWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FigmaSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    public static final void c(FigmaSwitch figmaSwitch, ValueAnimator it) {
        p.i(it, "it");
        Object animatedValue = it.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        figmaSwitch.thumbPosition = ((Float) animatedValue).floatValue();
        figmaSwitch.invalidate();
    }

    public final void b() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.thumbPosition, this.isChecked ? 1.0f : 0.0f);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: y5.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                FigmaSwitch.c(this.f43859a, valueAnimator2);
            }
        });
        valueAnimatorOfFloat.start();
        this.animator = valueAnimatorOfFloat;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public final int e(int from, int to, float fraction) {
        return Color.argb((int) (Color.alpha(from) + ((Color.alpha(to) - r4) * fraction)), (int) (Color.red(from) + ((Color.red(to) - r0) * fraction)), (int) (Color.green(from) + ((Color.green(to) - r1) * fraction)), (int) (Color.blue(from) + ((Color.blue(to) - r5) * fraction)));
    }

    public final InterfaceC5074l<Boolean, t> getOnCheckedChangeListener() {
        return this.onCheckedChangeListener;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        p.i(canvas, "canvas");
        float width = getWidth();
        float height = getHeight();
        float f10 = height / 2.0f;
        this.trackRect.set(0.0f, 0.0f, width, height);
        this.trackPaint.setColor(e(this.trackColorOff, this.trackColorOn, this.thumbPosition));
        canvas.drawRoundRect(this.trackRect, f10, f10, this.trackPaint);
        float f11 = this.thumbPadding;
        float f12 = this.thumbRadius;
        float f13 = f11 + f12;
        canvas.drawCircle(f13 + ((((width - f11) - f12) - f13) * this.thumbPosition), f10, f12, this.thumbPaint);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension((int) this.trackWidth, (int) this.trackHeight);
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        setChecked(!this.isChecked);
        return true;
    }

    public final void setChecked(boolean z10) {
        if (this.isChecked == z10) {
            return;
        }
        this.isChecked = z10;
        b();
        InterfaceC5074l<? super Boolean, t> interfaceC5074l = this.onCheckedChangeListener;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(z10));
        }
    }

    public final void setCheckedSilent(boolean checked) {
        if (this.isChecked == checked) {
            return;
        }
        setChecked(checked);
        this.thumbPosition = checked ? 1.0f : 0.0f;
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        invalidate();
    }

    public final void setOnCheckedChangeListener(InterfaceC5074l<? super Boolean, t> interfaceC5074l) {
        this.onCheckedChangeListener = interfaceC5074l;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FigmaSwitch(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        float f10 = getResources().getDisplayMetrics().density;
        this.density = f10;
        this.trackWidth = 40.0f * f10;
        this.trackHeight = 22.0f * f10;
        this.thumbRadius = 7.0f * f10;
        this.thumbPadding = f10 * 4.0f;
        this.trackColorOn = a.c(context, R$color.figma_switch_track_on);
        this.trackColorOff = a.c(context, R$color.figma_switch_track_off);
        this.trackPaint = new Paint(1);
        Paint paint = new Paint(1);
        paint.setColor(a.c(context, R$color.figma_switch_thumb));
        this.thumbPaint = paint;
        this.trackRect = new RectF();
    }

    public /* synthetic */ FigmaSwitch(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
