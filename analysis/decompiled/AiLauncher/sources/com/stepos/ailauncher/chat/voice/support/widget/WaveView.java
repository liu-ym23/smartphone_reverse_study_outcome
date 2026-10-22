package com.stepos.ailauncher.chat.voice.support.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import r9.C5227b;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 B2\u00020\u0001:\u0001CB!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0011¢\u0006\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010$\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010!R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010!R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010!R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010!R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010!R\u0016\u0010*\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010!R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010!R\u0016\u0010,\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010!R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00105R\u0014\u00107\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00105R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010:R\u0018\u0010<\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010/¨\u0006D"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/support/widget/WaveView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getWaveHeightRealTime", "()I", "getWaveHeight2RealTime", "getWaveHeight3RealTime", "Landroid/graphics/Canvas;", "canvas", "LY8/t;", "onDraw", "(Landroid/graphics/Canvas;)V", "m", "()V", "delay", "Landroid/animation/Animator;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Landroid/animation/Animator;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroid/animation/Animator;", "volume", "k", "(I)V", "q", "waveWidth", "I", "waveHeight", "moveDistance1", "moveDistance2", "moveDistance3", "waveWidth2", "waveHeight2", "waveWidth3", "waveHeight3", "pathOffset1", "pathOffset2", "lineY", "", "closeSpirit", "F", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "Landroid/graphics/Path;", "path1", "Landroid/graphics/Path;", "path2", "path3", "Landroid/view/animation/PathInterpolator;", "openPathInterpolator", "Landroid/view/animation/PathInterpolator;", "closePathInterpolator", "waveAnim", "Landroid/animation/Animator;", "Landroid/animation/ValueAnimator;", "volumeChangeAnim", "Landroid/animation/ValueAnimator;", "currHeightPercent", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WaveView extends View {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PathInterpolator closePathInterpolator;
    private float closeSpirit;
    private float currHeightPercent;
    private int lineY;
    private int moveDistance1;
    private int moveDistance2;
    private int moveDistance3;
    private final PathInterpolator openPathInterpolator;
    private final Paint paint;
    private final Path path1;
    private final Path path2;
    private final Path path3;
    private int pathOffset1;
    private int pathOffset2;
    private ValueAnimator volumeChangeAnim;
    private Animator waveAnim;
    private final int waveHeight;
    private int waveHeight2;
    private int waveHeight3;
    private final int waveWidth;
    private int waveWidth2;
    private int waveWidth3;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/support/widget/WaveView$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "dp", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;I)I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.support.widget.WaveView$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final int a(Context context, int dp) {
            p.i(context, "context");
            return Math.round(dp * context.getResources().getDisplayMetrics().density);
        }

        public Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaveView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        this.waveWidth = Const.I_TILE_TINY;
        this.waveHeight = 50;
        this.waveWidth2 = 500;
        this.waveHeight2 = 80;
        this.waveWidth3 = 300;
        this.waveHeight3 = 30;
        this.pathOffset1 = 6;
        this.pathOffset2 = 8;
        Companion companion = INSTANCE;
        Context context2 = getContext();
        p.h(context2, "getContext(...)");
        this.lineY = companion.a(context2, 106);
        this.closeSpirit = 1.0f;
        this.paint = new Paint(1);
        this.path1 = new Path();
        this.path2 = new Path();
        this.path3 = new Path();
        this.openPathInterpolator = new PathInterpolator(0.2f, 0.0f, 0.6f, 1.0f);
        this.closePathInterpolator = new PathInterpolator(0.2f, 0.0f, 0.4f, 1.0f);
        this.currHeightPercent = 1.0f;
    }

    private final int getWaveHeight2RealTime() {
        return C5227b.b(this.waveHeight2 * this.currHeightPercent);
    }

    private final int getWaveHeight3RealTime() {
        return C5227b.b(this.waveHeight3 * this.currHeightPercent);
    }

    private final int getWaveHeightRealTime() {
        return C5227b.b(this.waveHeight * this.currHeightPercent);
    }

    public static final void h(WaveView waveView, ValueAnimator animation) {
        p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        waveView.closeSpirit = ((Float) animatedValue).floatValue();
        waveView.invalidate();
    }

    public static final void j(WaveView waveView, ValueAnimator animation) {
        p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        waveView.closeSpirit = ((Float) animatedValue).floatValue();
        waveView.invalidate();
    }

    public static final void l(WaveView waveView, ValueAnimator animation) {
        p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        waveView.currHeightPercent = ((Float) animatedValue).floatValue();
    }

    public static final void n(WaveView waveView, ValueAnimator animation) {
        p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        waveView.moveDistance1 = ((Integer) animatedValue).intValue();
        waveView.invalidate();
    }

    public static final void o(WaveView waveView, ValueAnimator animation) {
        p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        waveView.moveDistance2 = ((Integer) animatedValue).intValue();
        waveView.invalidate();
    }

    public static final void p(WaveView waveView, ValueAnimator animation) {
        p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        waveView.moveDistance3 = ((Integer) animatedValue).intValue();
        waveView.invalidate();
    }

    public final Animator g() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(350L);
        valueAnimatorOfFloat.setInterpolator(this.closePathInterpolator);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.voice.support.widget.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WaveView.h(this.f26576a, valueAnimator);
            }
        });
        p.h(valueAnimatorOfFloat, "apply(...)");
        return valueAnimatorOfFloat;
    }

    public final Animator i(int delay) {
        this.currHeightPercent = 1.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.setStartDelay(delay);
        valueAnimatorOfFloat.setInterpolator(this.openPathInterpolator);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.voice.support.widget.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WaveView.j(this.f26580a, valueAnimator);
            }
        });
        p.h(valueAnimatorOfFloat, "apply(...)");
        return valueAnimatorOfFloat;
    }

    public final void k(int volume) {
        if (volume < 1) {
            return;
        }
        float f10 = (1 > volume || volume >= 10) ? 0.5f : 0.75f;
        ValueAnimator valueAnimator = this.volumeChangeAnim;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, f10, 1.0f);
            valueAnimatorOfFloat.setDuration(160L);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.voice.support.widget.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    WaveView.l(this.f26575a, valueAnimator2);
                }
            });
            this.volumeChangeAnim = valueAnimatorOfFloat;
            valueAnimatorOfFloat.start();
        }
    }

    public final void m() {
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.waveWidth * 4);
        valueAnimatorOfInt.setDuration(1000L);
        valueAnimatorOfInt.setRepeatCount(-1);
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.voice.support.widget.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WaveView.n(this.f26577a, valueAnimator);
            }
        });
        arrayList.add(valueAnimatorOfInt);
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(0, this.waveWidth2 * 4);
        valueAnimatorOfInt2.setDuration(1200L);
        valueAnimatorOfInt2.setRepeatCount(-1);
        valueAnimatorOfInt2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.voice.support.widget.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WaveView.o(this.f26578a, valueAnimator);
            }
        });
        arrayList.add(valueAnimatorOfInt2);
        ValueAnimator valueAnimatorOfInt3 = ValueAnimator.ofInt(0, this.waveWidth3 * 4);
        valueAnimatorOfInt3.setDuration(700L);
        valueAnimatorOfInt3.setRepeatCount(-1);
        valueAnimatorOfInt3.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.voice.support.widget.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WaveView.p(this.f26579a, valueAnimator);
            }
        });
        arrayList.add(valueAnimatorOfInt3);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.waveAnim = animatorSet;
        animatorSet.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        p.i(canvas, "canvas");
        super.onDraw(canvas);
        this.paint.reset();
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.paint.setColor(-14652161);
        this.path1.reset();
        this.path1.moveTo((this.waveWidth * (-4)) - this.moveDistance1, this.lineY);
        for (int i10 = 1; i10 < 5; i10++) {
            this.path1.rQuadTo(this.waveWidth, getWaveHeightRealTime() * (-1) * this.closeSpirit, this.waveWidth * 2, 0.0f);
            this.path1.rQuadTo(this.waveWidth, getWaveHeightRealTime() * this.closeSpirit, this.waveWidth * 2, 0.0f);
        }
        this.path2.reset();
        this.path2.moveTo((getWaveHeight2RealTime() * (-this.pathOffset1)) - this.moveDistance2, this.lineY);
        for (int i11 = 1; i11 < 5; i11++) {
            this.path2.rQuadTo(this.waveWidth2, getWaveHeight2RealTime() * (-1) * this.closeSpirit, this.waveWidth2 * 2, 0.0f);
            this.path2.rQuadTo(this.waveWidth2, getWaveHeight2RealTime() * this.closeSpirit, this.waveWidth2 * 2, 0.0f);
        }
        this.path3.reset();
        this.path3.moveTo((getWaveHeight3RealTime() * (-this.pathOffset2)) - this.moveDistance3, this.lineY);
        for (int i12 = 1; i12 < 5; i12++) {
            this.path3.rQuadTo(this.waveWidth3, getWaveHeight3RealTime() * (-1) * this.closeSpirit, this.waveWidth3 * 2, 0.0f);
            this.path3.rQuadTo(this.waveWidth3, getWaveHeight3RealTime() * this.closeSpirit, this.waveWidth3 * 2, 0.0f);
        }
        this.paint.setStrokeWidth(5.0f);
        canvas.drawPath(this.path1, this.paint);
        this.paint.setStrokeWidth(4.0f);
        this.paint.setAlpha(180);
        canvas.drawPath(this.path2, this.paint);
        this.paint.setStrokeWidth(3.0f);
        this.paint.setAlpha(100);
        canvas.drawPath(this.path3, this.paint);
    }

    public final void q() {
        ValueAnimator valueAnimator;
        Animator animator;
        Animator animator2 = this.waveAnim;
        if (animator2 != null && animator2.isRunning() && (animator = this.waveAnim) != null) {
            animator.cancel();
        }
        ValueAnimator valueAnimator2 = this.volumeChangeAnim;
        if (valueAnimator2 == null || !valueAnimator2.isRunning() || (valueAnimator = this.volumeChangeAnim) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.i(context, "context");
    }
}
