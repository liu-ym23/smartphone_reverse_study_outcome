package com.stepos.agentframework.screeneffect;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.animation.LinearInterpolator;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.speech.tts.l;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5678g;
import v9.C5685n;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001-J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u0012R\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010%R\u0016\u0010*\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010%R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010+¨\u0006."}, d2 = {"Lcom/stepos/agentframework/screeneffect/d;", "Lcom/stepos/agentframework/screeneffect/b;", "", "", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "LY8/t;", "onSizeChanged", "(IIII)V", "", "timeValue", Const.INTENT_KEY_PKGNAME, "(F)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "isRecording", "setVoiceIsRecording", "(Z)V", "onDetachedFromWindow", "()V", "n", "o", "m", "Landroid/graphics/Paint;", "wavePaint", "Landroid/graphics/Paint;", "Landroid/graphics/Path;", "wavePath", "Landroid/graphics/Path;", "waveDx", "I", "waveStartY", "F", "Landroid/animation/ValueAnimator;", "waveAnimator", "Landroid/animation/ValueAnimator;", "currentWaveHeight", "targetWaveHeight", "Z", "Companion", Const.INTENT_KEY_APIKEY, "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class d extends b {
    private static final float WAVE_ALPHA = 0.35f;
    private static final float WAVE_BASELINE_RATIO = 0.97f;
    private static final int WAVE_LENGTH = 1500;
    private static final float WAVE_SMOOTHING_FACTOR = 0.2f;
    private float currentWaveHeight;
    private volatile boolean isRecording;
    private float targetWaveHeight;
    private ValueAnimator waveAnimator;
    private int waveDx;
    private final Paint wavePaint;
    private final Path wavePath;
    private float waveStartY;
    private static int WAVE_HEIGHT = 10;

    public static final void p(d dVar, ValueAnimator animation) {
        p.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        p.g(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        dVar.waveDx = ((Integer) animatedValue).intValue();
        dVar.invalidate();
    }

    @Override // com.stepos.agentframework.screeneffect.b, com.stepos.agentframework.screeneffect.f
    public void b(float timeValue) {
        super.b(timeValue);
        n();
    }

    public final void m(Canvas canvas) {
        this.wavePath.reset();
        this.wavePath.moveTo(this.waveDx - 1500.0f, this.waveStartY);
        C5678g c5678gR = C5685n.r(C5685n.s(-1500, getWidth() + 1500), 1500);
        int first = c5678gR.getFirst();
        int last = c5678gR.getLast();
        int step = c5678gR.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                this.wavePath.rQuadTo(375.0f, -this.currentWaveHeight, 750.0f, 0.0f);
                this.wavePath.rQuadTo(375.0f, this.currentWaveHeight, 750.0f, 0.0f);
                if (first == last) {
                    break;
                } else {
                    first += step;
                }
            }
        }
        this.wavePath.lineTo(getWidth(), getHeight());
        this.wavePath.lineTo(0.0f, getHeight());
        this.wavePath.close();
        float f10 = 255;
        this.wavePaint.setColor(Color.argb(89, (int) (getCurrentMixColor()[0] * f10), (int) (getCurrentMixColor()[1] * f10), (int) (getCurrentMixColor()[2] * f10)));
        canvas.drawPath(this.wavePath, this.wavePaint);
    }

    public final void n() {
        float f10 = this.targetWaveHeight - this.currentWaveHeight;
        if (Math.abs(f10) > 0.1f) {
            this.currentWaveHeight += f10 * 0.2f;
            invalidate();
        }
    }

    public final void o() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 1500);
        valueAnimatorOfInt.setDuration(l.SAFE_CLOSE_LEAD_MS);
        valueAnimatorOfInt.setRepeatCount(-1);
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.agentframework.screeneffect.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.p(this.f23299a, valueAnimator);
            }
        });
        valueAnimatorOfInt.start();
        this.waveAnimator = valueAnimatorOfInt;
    }

    @Override // com.stepos.agentframework.screeneffect.f, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.waveAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // com.stepos.agentframework.screeneffect.b, com.stepos.agentframework.screeneffect.f, android.view.View
    public void onDraw(Canvas canvas) {
        p.i(canvas, "canvas");
        m(canvas);
        super.onDraw(canvas);
    }

    @Override // com.stepos.agentframework.screeneffect.b, com.stepos.agentframework.screeneffect.f, android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        this.waveStartY = h10 * WAVE_BASELINE_RATIO;
        o();
    }

    public void setVoiceIsRecording(boolean isRecording) {
        this.isRecording = isRecording;
        if (isRecording) {
            return;
        }
        this.targetWaveHeight = WAVE_HEIGHT;
    }
}
