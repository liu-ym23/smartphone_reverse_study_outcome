package com.android.ttcjpaysdk.thirdparty.voiceprint.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.thirdparty.voiceprint.common.CommonKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0012\u0018\u0000 E2\u00020\u0001:\u0001EB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010!\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020\u0007H\u0002J\u001a\u0010$\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u000bH\u0002J\u0006\u0010&\u001a\u00020\"J\b\u0010'\u001a\u00020\u000bH\u0007J\u0006\u0010(\u001a\u00020\rJ\b\u0010)\u001a\u00020\"H\u0014J\u0010\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,H\u0014J(\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0014J\u0010\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u000bH\u0002J\u0010\u00106\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020\u0007J\u0010\u00107\u001a\u00020\"2\u0006\u00108\u001a\u00020\u000bH\u0007J\u0018\u00109\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u000bJ\u0016\u0010 \u001a\u00020\"2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bJ\b\u0010<\u001a\u00020\"H\u0002J\u0006\u0010=\u001a\u00020\"J\u0006\u0010>\u001a\u00020\"J\"\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u00020\u000b2\b\b\u0002\u0010A\u001a\u00020\u000b2\b\b\u0002\u0010B\u001a\u00020\u000bJ\u000e\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u00020\u000bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoiceBlurCircleAmplitudeView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "amplitudeWindow", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "animating", "", "blurRadius", "centerXLocal", "centerYLocal", "circleColor", "circleRadiusLocal", "circleScaleLocal", "highlightCenterX", "highlightCenterY", "highlightColor", "highlightPaint", "Landroid/graphics/Paint;", "highlightRadius", "paint", "pendingStart", "playingAnimator", "Landroid/animation/Animator;", "radiusWidthRatio", "showHeight", "showHighlight", "applyCircleColor", "", "color", "applyHighlightColor", "radius", "dismissHighlight", "getCircleScale", "isAnimating", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "optAmplitude", "before", "", "popMaxAmplitude", "setCircleColor", "setCircleScale", "scale", "setHighlightStyle", "centerX", "centerY", "startAnimOnce", "startWaveAnim", "stopWaveAnim", "updateByDb", "db", "minDb", "maxDb", "updateVolume", "amplitude01", "Companion", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoiceBlurCircleAmplitudeView extends View {
    private static final int AMPLITUDE_WINDOW = 10;
    public static final Companion Companion = null;
    private static final float ENVELOPE_SMOOTH_ALPHA = 0.35f;
    private static final long ROUND_DURATION_MS = 400;
    private static final float ROUND_SCALE_MAX_DELTA = 0.08f;
    private static final float SILENCE_THRESHOLD = 0.12f;
    private final CopyOnWriteArrayList<Float> amplitudeWindow;
    private boolean animating;
    private final float blurRadius;
    private float centerXLocal;
    private float centerYLocal;
    private int circleColor;
    private float circleRadiusLocal;
    private float circleScaleLocal;
    private float highlightCenterX;
    private float highlightCenterY;
    private int highlightColor;
    private final Paint highlightPaint;
    private float highlightRadius;
    private final Paint paint;
    private boolean pendingStart;
    private Animator playingAnimator;
    private final float radiusWidthRatio;
    private final float showHeight;
    private boolean showHighlight;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/voiceprint/ui/VoiceBlurCircleAmplitudeView$Companion;", "", "()V", "AMPLITUDE_WINDOW", "", "ENVELOPE_SMOOTH_ALPHA", "", "ROUND_DURATION_MS", "", "ROUND_SCALE_MAX_DELTA", "SILENCE_THRESHOLD", "bdpay-voiceprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public VoiceBlurCircleAmplitudeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public VoiceBlurCircleAmplitudeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    public final void stopWaveAnim() {
        this.pendingStart = false;
        this.animating = false;
        Animator r100 = this.playingAnimator;
        if (r100 == null) goto L5;
        r100.removeAllListeners();
        r100.cancel();
    L5:
        this.playingAnimator = null;
        this.amplitudeWindow.clear();
        this.showHighlight = false;
        setCircleScale(1.0f);
    }

    private final float popMaxAmplitude() {
        if (this.amplitudeWindow.isEmpty() == false) goto L5;
        return 0.0f;
    L5:
        Iterator<Float> r100 = this.amplitudeWindow.iterator();
        float r101 = 0.0f;
    L7:
        if (r100.hasNext() == false) goto L10;
        r101 = (r101 * 0.65f) + (r100.next().floatValue() * ENVELOPE_SMOOTH_ALPHA);
        goto L7
    L10:
        return RangesKt.coerceIn(r101, 0.0f, 1.0f);
    }

    private final void startAnimOnce() {
        Animator r100 = this.playingAnimator;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this, "circleScale", new float[]{getCircleScale(), (popMaxAmplitude() * 0.08f) + 1.0f, 1.0f});
        r101.setDuration(400);
        r101.addListener(new VoiceBlurCircleAmplitudeView$startAnimOnce$anim$1$1(this));
        r101.start();
        this.playingAnimator = r101;
    }

    public final void dismissHighlight() {
        if (this.showHighlight == true) goto L5;
        return;
    L5:
        this.showHighlight = false;
        invalidate();
    }

    public final boolean isAnimating() {
        if (this.animating == false) goto L5;
    L8:
        return true;
    L5:
        if (this.pendingStart == true) goto L8;
        return false;
    }

    public final void startWaveAnim() {
        if (this.animating == false) goto L5;
        return;
    L5:
        if (this.pendingStart == false) goto L8;
        return;
    L8:
        if (getWidth() != 0) goto L10;
    L14:
        this.pendingStart = true;
        return;
    L10:
        if (getHeight() == 0) goto L14;
        this.animating = true;
        startAnimOnce();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopWaveAnim();
    }

    public final float getCircleScale() {
        return this.circleScaleLocal;
    }

    public static final /* synthetic */ boolean access$getAnimating$p(VoiceBlurCircleAmplitudeView r100) {
        return r100.animating;
    }

    public static final /* synthetic */ void access$startAnimOnce(VoiceBlurCircleAmplitudeView r100) {
        r100.startAnimOnce();
    }

    private final void applyCircleColor(int r100) {
        this.paint.setColor(r100);
        float r101 = this.blurRadius * this.circleScaleLocal;
        Paint r102 = this.paint;
        if (r101 <= 0.0f) goto L5;
        BlurMaskFilter r103 = new BlurMaskFilter(r101, BlurMaskFilter.Blur.NORMAL);
    L6:
        r102.setMaskFilter(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    private final float optAmplitude(double r100) {
        double r101 = RangesKt.coerceIn(r100, AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d);
        if (r101 >= 0.11999999731779099d) goto L6;
        return 0.0f;
    L6:
        return RangesKt.coerceIn(((float) Math.pow((r101 - ((double) 0.12f)) / 0.880000002682209d, 0.7d)) * 0.85f, 0.0f, 1.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        if (this.paint.getColor() != 0) goto L5;
        return;
    L5:
        float r101 = Math.max(0.0f, this.circleRadiusLocal);
        if (this.showHighlight == true) goto L8;
    L12:
        r100.drawCircle(this.centerXLocal, this.centerYLocal, r101, this.paint);
        return;
    L8:
        if (this.highlightRadius <= 0.0f) goto L12;
        int r102 = r100.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        r100.drawCircle(this.centerXLocal, this.centerYLocal, r101, this.paint);
        r100.drawCircle(this.highlightCenterX, this.highlightCenterY, this.highlightRadius, this.highlightPaint);
        r100.restoreToCount(r102);
    }

    public final void setCircleColor(int r100) {
        this.circleColor = r100;
        applyCircleColor(r100);
        invalidate();
    }

    public final void setCircleScale(float r100) {
        this.circleScaleLocal = r100;
        this.circleRadiusLocal = (getWidth() * this.radiusWidthRatio) * this.circleScaleLocal;
        applyCircleColor(this.circleColor);
        invalidate();
    }

    public final void updateVolume(float r100) {
        if (this.animating == true) goto L5;
        return;
    L5:
        float r101 = optAmplitude(RangesKt.coerceIn(r100, 0.0f, 1.0f));
        if (this.amplitudeWindow.size() < 10) goto L8;
        this.amplitudeWindow.remove(0);
    L8:
        this.amplitudeWindow.add(Float.valueOf(r101));
    }

    public static final /* synthetic */ void access$setPlayingAnimator$p(VoiceBlurCircleAmplitudeView r100, Animator r101) {
        r100.playingAnimator = r101;
    }

    private final void applyHighlightColor(int r100, float r101) {
        this.highlightPaint.setColor(r100);
        Paint r102 = this.highlightPaint;
        if (r101 <= 0.0f) goto L5;
        BlurMaskFilter r103 = new BlurMaskFilter(r101, BlurMaskFilter.Blur.NORMAL);
    L6:
        r102.setMaskFilter(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final void setHighlightStyle(int r100, float r101) {
        this.highlightColor = r100;
        float r102 = Math.max(0.0f, r101);
        this.highlightRadius = r102;
        applyHighlightColor(this.highlightColor, r102);
        invalidate();
    }

    public final void showHighlight(float r100, float r101) {
        if (this.highlightRadius > 0.0f) goto L5;
        return;
    L5:
        this.highlightCenterX = r100;
        this.highlightCenterY = r101;
        this.showHighlight = true;
        invalidate();
    }

    public VoiceBlurCircleAmplitudeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.paint = new Paint(1);
        this.blurRadius = CommonKt.dp2px(this, 144.0f);
        this.radiusWidthRatio = 0.8f;
        this.showHeight = CommonKt.dp2px(this, 210.0f);
        this.circleColor = ContextCompat.getColor(r100, R.color.voice_print_color_467BFB);
        this.circleScaleLocal = 1.0f;
        this.amplitudeWindow = new CopyOnWriteArrayList();
        Paint r103 = new Paint(1);
        r103.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.highlightPaint = r103;
        this.highlightColor = -14846990;
        this.highlightRadius = CommonKt.dp2px(this, 40.0f);
        this.highlightCenterX = -1.0f;
        this.highlightCenterY = -1.0f;
        applyCircleColor(this.circleColor);
        applyHighlightColor(this.highlightColor, this.highlightRadius);
    }

    public final void updateByDb(float r100, float r101, float r102) {
        if (r102 > r101) goto L5;
        return;
    L5:
        updateVolume(RangesKt.coerceIn((r100 - r101) / (r102 - r101), 0.0f, 1.0f));
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = r100;
        float r105 = this.radiusWidthRatio;
        this.circleRadiusLocal = (r104 * r105) * this.circleScaleLocal;
        this.centerXLocal = r104 / 2.0f;
        this.centerYLocal = (r101 - this.showHeight) + (r104 * r105);
        if (this.pendingStart == false) goto L6;
        this.pendingStart = false;
        this.animating = true;
        startAnimOnce();
        return;
    }

    public /* synthetic */ VoiceBlurCircleAmplitudeView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    public static /* synthetic */ void updateByDb$default(VoiceBlurCircleAmplitudeView r100, float r101, float r102, float r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 60.0f;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = 90.0f;
    L8:
        r100.updateByDb(r101, r102, r103);
    }
}
