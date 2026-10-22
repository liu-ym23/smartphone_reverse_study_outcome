package com.stepos.ailauncher.speech.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.o0;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import j6.C4771a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.random.Random;
import v9.C5685n;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\u000eJ\u0017\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R.\u00106\u001a\u0004\u0018\u00010\u00062\b\u00105\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010=R\u0014\u0010?\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010@R\u0016\u0010B\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010=R\u0016\u0010E\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010CR\u0014\u0010F\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010@R\u0014\u0010G\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010@R\u0014\u0010H\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010@R\u0014\u0010I\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010@R\u0016\u0010J\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010=R\u0016\u0010K\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010=R\u0016\u0010L\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010=R\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010*¨\u0006Q"}, d2 = {"Lcom/stepos/ailauncher/speech/view/WaveformBarsView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "level", "LY8/t;", "setLevel", "(F)V", "", "pause", "setPaused", "(Z)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "getFrequencyBands", "()[F", "index", Const.INTENT_KEY_APIKEY, "(I)F", "c", "availableWidth", Const.INTENT_KEY_PKGNAME, "v", Const.INTENT_KEY_UMID, "(F)F", "Landroid/graphics/LinearGradient;", "gradient", "Landroid/graphics/LinearGradient;", "Lj6/a;", "audioProcessor", "Lj6/a;", "barCount", "I", "getBarCount", "()I", "setBarCount", "(I)V", "barHorizontalMarginPx", "Ljava/lang/Float;", "getBarHorizontalMarginPx", "()Ljava/lang/Float;", "setBarHorizontalMarginPx", "(Ljava/lang/Float;)V", UxipConstants.f30680s, "barColor", "Ljava/lang/Integer;", "getBarColor", "()Ljava/lang/Integer;", "setBarColor", "(Ljava/lang/Integer;)V", "barWidthPx", "F", "barGapPx", "frequencyBands", "[F", "displayBands", "isAudioMode", "Z", "currentLevel", o0.TRACK_STATUS_PAUSED, "waveAmplitudes", "waveFrequencies", "wavePhases", "baseResponsiveness", "peakShift", "peakIntensity", "timeCounter", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "gradientWidth", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WaveformBarsView extends View {
    private final C4771a audioProcessor;
    private Integer barColor;
    private int barCount;
    private float barGapPx;
    private Float barHorizontalMarginPx;
    private float barWidthPx;
    private final float[] baseResponsiveness;
    private float currentLevel;
    private final float[] displayBands;
    private final float[] frequencyBands;
    private LinearGradient gradient;
    private int gradientWidth;
    private boolean isAudioMode;
    private final Paint paint;
    private boolean paused;
    private float peakIntensity;
    private float peakShift;
    private float timeCounter;
    private final float[] waveAmplitudes;
    private final float[] waveFrequencies;
    private final float[] wavePhases;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WaveformBarsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    public final float a(int index) {
        float height = getHeight() / 2.0f;
        float f10 = this.displayBands[index];
        if (f10 <= 0.01f) {
            return 2.0f;
        }
        return Math.max(2.0f, height * 0.3f * C5685n.m(C5685n.m(f10 / 50.0f, 0.0f, 1.0f), 0.02f, 1.0f));
    }

    public final void b(float availableWidth) {
        int i10 = this.barCount;
        int i11 = i10 - 1;
        float f10 = (0.4f * availableWidth) / i10;
        this.barWidthPx = f10;
        this.barGapPx = i11 > 0 ? (availableWidth * 0.6f) / i11 : 0.0f;
        this.barWidthPx = Math.max(f10, 1.0f);
        this.barGapPx = Math.max(this.barGapPx, 0.5f);
    }

    public final float c(int index) {
        float height = getHeight() / 2.0f;
        float f10 = this.currentLevel * this.baseResponsiveness[index];
        float fSin = ((float) Math.sin(this.wavePhases[index] + (this.timeCounter * this.waveFrequencies[index]))) * this.waveAmplitudes[index];
        float f11 = (this.barCount - 1) / 2.0f;
        float fAbs = Math.abs(index - f11) / f11;
        return Math.max(2.0f, height * C5685n.m((f10 + fSin + (this.peakIntensity * (1.0f - fAbs) * ((float) Math.sin(this.peakShift + (r9 * 0.2f))) * 0.3f)) * (1.0f - (fAbs * 0.3f)), 0.05f, 1.2f));
    }

    public final float d(float v10) {
        return v10 * getResources().getDisplayMetrics().density;
    }

    public final Integer getBarColor() {
        return this.barColor;
    }

    public final int getBarCount() {
        return this.barCount;
    }

    public final Float getBarHorizontalMarginPx() {
        return this.barHorizontalMarginPx;
    }

    public final float[] getFrequencyBands() {
        float[] fArr = this.frequencyBands;
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        p.h(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        p.i(canvas, "canvas");
        super.onDraw(canvas);
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        float height = getHeight() / 2.0f;
        Float f10 = this.barHorizontalMarginPx;
        float fFloatValue = f10 != null ? f10.floatValue() : d(90.0f);
        b(getWidth() - (2 * fFloatValue));
        int i10 = this.barCount;
        for (int i11 = 0; i11 < i10; i11++) {
            float f11 = fFloatValue + (i11 * (this.barWidthPx + this.barGapPx));
            float fA = this.isAudioMode ? a(i11) : c(i11);
            float f12 = this.barWidthPx;
            canvas.drawRoundRect(f11, height - fA, f11 + f12, height + fA, f12 / 2.0f, f12 / 2.0f, this.paint);
        }
    }

    public final void setBarColor(Integer num) {
        this.barColor = num;
        if (num != null) {
            this.paint.setColor(num.intValue());
        }
    }

    public final void setBarCount(int i10) {
        this.barCount = i10;
    }

    public final void setBarHorizontalMarginPx(Float f10) {
        this.barHorizontalMarginPx = f10;
    }

    public final void setLevel(float level) {
        this.isAudioMode = false;
        float fM = C5685n.m(level, 0.0f, 1.0f);
        this.currentLevel = fM;
        this.peakIntensity = (0.8f * fM) + 0.2f;
        this.peakShift += 0.1f * fM;
        this.timeCounter += fM * 0.05f;
        if (this.paused) {
            return;
        }
        invalidate();
    }

    public final void setPaused(boolean pause) {
        this.paused = pause;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaveformBarsView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        this.audioProcessor = new C4771a();
        this.barCount = 24;
        this.frequencyBands = new float[24];
        this.displayBands = new float[24];
        float[] fArr = new float[24];
        for (int i11 = 0; i11 < 24; i11++) {
            fArr[i11] = (Random.INSTANCE.e() * 0.3f) + 0.1f;
        }
        this.waveAmplitudes = fArr;
        int i12 = this.barCount;
        float[] fArr2 = new float[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            fArr2[i13] = (Random.INSTANCE.e() * 0.5f) + 0.3f;
        }
        this.waveFrequencies = fArr2;
        int i14 = this.barCount;
        float[] fArr3 = new float[i14];
        for (int i15 = 0; i15 < i14; i15++) {
            fArr3[i15] = Random.INSTANCE.e() * 6.2831855f;
        }
        this.wavePhases = fArr3;
        int i16 = this.barCount;
        float[] fArr4 = new float[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            fArr4[i17] = (Random.INSTANCE.e() * 0.6f) + 0.7f;
        }
        this.baseResponsiveness = fArr4;
        Paint paint = new Paint(1);
        Integer num = this.barColor;
        paint.setColor(num != null ? num.intValue() : Color.parseColor("#FFFFFF"));
        this.paint = paint;
    }

    public /* synthetic */ WaveformBarsView(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
