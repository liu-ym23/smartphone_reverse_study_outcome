package com.stepos.ailauncher.task.space;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\n\b\u0000\u0018\u0000 B2\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010%\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010&\u001a\u00020\u001b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010#R\u0014\u0010'\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010#R\u0014\u0010(\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010#R\u0014\u0010)\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010#R\u0014\u0010*\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010-\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b-\u0010+R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00100R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010+R\u0016\u00106\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010+R\u0016\u00107\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010#R\u0016\u00108\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010#R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010=R\u0016\u0010>\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010#R\u0014\u0010A\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/stepos/ailauncher/task/space/RecordingWaveformView;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "w", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "LY8/t;", "onSizeChanged", "(IIII)V", "", com.stepos.ailauncher.foundation.appui.card.provider.didi.o0.TRACK_STATUS_PAUSED, "setPaused", "(Z)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", Const.INTENT_KEY_APIKEY, "()V", "", "centerY", "maxHalf", Const.INTENT_KEY_PKGNAME, "(Landroid/graphics/Canvas;FF)V", "c", "(Landroid/graphics/Canvas;F)V", "density", "F", "barWidthPx", "barGapPx", "maxHalfFraction", "minHalfPx", "playheadWidthPx", "playheadInsetPx", "recordedColor", "I", "unrecordedColor", "playheadColor", "Landroid/graphics/Paint;", "barPaint", "Landroid/graphics/Paint;", "playheadPaint", "", "amplitudes", "[F", "capacity", "centerIndex", "currentTarget", "displayValue", "", "lastCommitAtMs", "J", "animating", "Z", "adaptivePeak", "getPitchPx", "()F", "pitchPx", "Companion", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RecordingWaveformView extends View {
    private static final float ADAPTIVE_PEAK_DECAY = 0.984f;
    private static final float AMP_SOFT_FLOOR = 0.02f;
    private static final long COMMIT_INTERVAL_MS = 40;
    private static final float FRAME_EASE = 0.4f;
    private static final float GAMMA = 0.42f;
    private static final long MAX_CATCHUP_MS = 200;
    private float adaptivePeak;
    private float[] amplitudes;
    private boolean animating;
    private final float barGapPx;
    private final Paint barPaint;
    private final float barWidthPx;
    private int capacity;
    private int centerIndex;
    private float currentTarget;
    private final float density;
    private float displayValue;
    private long lastCommitAtMs;
    private final float maxHalfFraction;
    private final float minHalfPx;
    private boolean paused;
    private final int playheadColor;
    private final float playheadInsetPx;
    private final Paint playheadPaint;
    private final float playheadWidthPx;
    private final int recordedColor;
    private final int unrecordedColor;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecordingWaveformView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    private final float getPitchPx() {
        return this.barWidthPx + this.barGapPx;
    }

    public final void a() {
        int i10 = this.centerIndex;
        if (i10 <= 0) {
            return;
        }
        int i11 = 0;
        while (i11 < i10) {
            float[] fArr = this.amplitudes;
            int i12 = i11 + 1;
            fArr[i11] = fArr[i12];
            i11 = i12;
        }
        this.amplitudes[this.centerIndex] = this.displayValue;
    }

    public final void b(Canvas canvas, float centerY, float maxHalf) {
        float f10 = this.barWidthPx * 0.5f;
        float fE = C5685n.e(maxHalf - this.minHalfPx, 0.0f);
        int i10 = this.capacity;
        int i11 = 0;
        while (i11 < i10) {
            float fM = this.minHalfPx + (C5685n.m(this.amplitudes[i11], 0.0f, 1.0f) * fE);
            float pitchPx = (i11 * getPitchPx()) + f10;
            this.barPaint.setColor(i11 <= this.centerIndex ? this.recordedColor : this.unrecordedColor);
            canvas.drawRoundRect(pitchPx - f10, centerY - fM, pitchPx + f10, centerY + fM, f10, f10, this.barPaint);
            i11++;
        }
    }

    public final void c(Canvas canvas, float centerY) {
        float pitchPx = (this.centerIndex * getPitchPx()) + (this.barWidthPx * 0.5f);
        float fE = C5685n.e((getHeight() * 0.5f) - this.playheadInsetPx, 0.0f);
        float f10 = this.playheadWidthPx * 0.5f;
        canvas.drawRoundRect(pitchPx - f10, centerY - fE, pitchPx + f10, centerY + fE, f10, f10, this.playheadPaint);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        super.onDraw(canvas);
        if (this.capacity <= 0) {
            return;
        }
        boolean z10 = this.animating && !this.paused;
        if (z10) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (this.lastCommitAtMs == 0) {
                this.lastCommitAtMs = jUptimeMillis;
            }
            if (jUptimeMillis - this.lastCommitAtMs > 200) {
                this.lastCommitAtMs = jUptimeMillis - COMMIT_INTERVAL_MS;
            }
            while (jUptimeMillis - this.lastCommitAtMs >= COMMIT_INTERVAL_MS) {
                a();
                this.lastCommitAtMs += COMMIT_INTERVAL_MS;
            }
            float f10 = this.displayValue;
            float f11 = f10 + ((this.currentTarget - f10) * 0.4f);
            this.displayValue = f11;
            this.amplitudes[this.centerIndex] = f11;
        }
        float height = getHeight() * 0.5f;
        b(canvas, height, getHeight() * this.maxHalfFraction);
        c(canvas, height);
        if (z10) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        float pitchPx = getPitchPx();
        int iF = pitchPx > 0.0f ? C5685n.f((int) (w10 / pitchPx), 1) : 1;
        if (iF != this.capacity) {
            float[] fArr = this.amplitudes;
            int i10 = this.centerIndex;
            float[] fArr2 = new float[iF];
            int i11 = iF / 2;
            if (!(fArr.length == 0)) {
                int iMin = Math.min(i10 + 1, i11 + 1);
                for (int i12 = 0; i12 < iMin; i12++) {
                    fArr2[i11 - i12] = fArr[i10 - i12];
                }
            }
            this.amplitudes = fArr2;
            this.capacity = iF;
            this.centerIndex = i11;
        }
    }

    public final void setPaused(boolean paused) {
        if (this.paused == paused) {
            return;
        }
        this.paused = paused;
        if (paused) {
            this.currentTarget = 0.0f;
            invalidate();
        } else {
            this.lastCommitAtMs = SystemClock.uptimeMillis();
            if (this.animating) {
                postInvalidateOnAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordingWaveformView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        float f10 = context.getResources().getDisplayMetrics().density;
        this.density = f10;
        this.barWidthPx = f10 * 2.0f;
        this.barGapPx = f10 * 2.5f;
        this.maxHalfFraction = GAMMA;
        this.minHalfPx = 2.5f * f10;
        this.playheadWidthPx = 2.0f * f10;
        this.playheadInsetPx = f10 * 4.0f;
        this.recordedColor = -218103809;
        this.unrecordedColor = 1308622847;
        this.playheadColor = -34274;
        Paint paint = new Paint(1);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.barPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(style);
        paint2.setColor(-34274);
        this.playheadPaint = paint2;
        this.amplitudes = new float[0];
        this.adaptivePeak = AMP_SOFT_FLOOR;
    }

    public /* synthetic */ RecordingWaveformView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
