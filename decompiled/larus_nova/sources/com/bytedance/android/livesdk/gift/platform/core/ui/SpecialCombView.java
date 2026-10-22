package com.bytedance.android.livesdk.gift.platform.core.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public class SpecialCombView extends View {
    private static final int ANGLE_360 = 360;
    private static final float PROGRESS_START_ANGLE = -90.0f;
    private int bgColor;
    private RectF bordRectF;
    private LinearGradient bordShader;
    private ValueAnimator borderAnimator;
    private float borderWidth;
    private Bitmap combBitmap;
    private Rect combBmRect;
    private RectF combDrawRectF;
    private Paint mPaint;
    private float progress;
    private float radius;
    private TextPaint textPaint;
    private int time;
    private String timeStr;
    private int totalTimeCount;
    private float viewHeight;
    private LinearGradient viewShader;
    private float viewWidth;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SpecialCombView f131926a;

        public a(SpecialCombView r100) {
            this.f131926a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            float r101 = r100.getAnimatedFraction();
            double r102 = r101;
            if (r102 > 0.1d) goto L6;
            float r103 = -r101;
            float r104 = 1.1f;
        L18:
            float r105 = r103 + r104;
            this.f131926a.setScaleX(r105);
            this.f131926a.setScaleY(r105);
            this.f131926a.invalidate();
            return;
        L6:
            if (r102 > 0.3333d) goto L9;
            r103 = r101 * 0.4286f;
            r104 = 0.9571f;
            goto L18
        L9:
            if (r102 > 0.4333d) goto L12;
            r103 = -r101;
            r104 = 1.4333f;
            goto L18
        L12:
            if (r102 > 0.6667d) goto L15;
            r103 = r101 * 0.4286f;
            r104 = 0.8143f;
            goto L18
        L15:
            if (r102 > 0.7667d) goto L17;
            r103 = -r101;
            r104 = 1.76667f;
            goto L18
        L17:
            r103 = r101 * 0.4286f;
            r104 = 0.6714f;
            goto L18
        }
    }

    private void init() {
        this.viewWidth = measureWidth();
        this.viewHeight = measureHeight();
        float r100 = getResources().getDimension(R.dimen.ttlive_special_comb_progress_border_width);
        this.borderWidth = r100;
        this.radius = (this.viewWidth - (r100 * 2.0f)) / 2.0f;
        float r101 = r100 / 2.0f;
        float r102 = this.viewWidth;
        this.bordRectF = new RectF(r101, r101, r102 - r101, r102 - r101);
        this.combBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ttlive_ic_combo);
        this.combBmRect = new Rect(0, 0, this.combBitmap.getWidth(), this.combBitmap.getHeight());
        float r103 = s1.f(11.0f);
        this.combDrawRectF = new RectF(r103, r103, this.viewWidth - r103, this.viewHeight - r103);
        this.mPaint = new Paint();
        TextPaint r104 = new TextPaint();
        this.textPaint = r104;
        r104.setAntiAlias(true);
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        this.textPaint.setColor(getResources().getColor(R.color.ttlive_special_comb_view_text_color));
        this.textPaint.setTextSize(getResources().getDimension(R.dimen.ttlive_special_comb_text_size));
        this.bordShader = new LinearGradient(0.0f, 0.0f, this.viewWidth, this.viewHeight, getResources().getColor(R.color.ttlive_special_comb_bord_start_color), getResources().getColor(R.color.ttlive_special_comb_bord_end_color), Shader.TileMode.CLAMP);
        this.viewShader = new LinearGradient(this.viewWidth, 0.0f, 0.0f, this.viewHeight, getResources().getColor(R.color.ttlive_special_comb_view_start_color), getResources().getColor(R.color.ttlive_special_comb_view_end_color), Shader.TileMode.CLAMP);
        this.bgColor = getResources().getColor(R.color.ttlive_special_comb_background_color);
    }

    public void endScaleAnim() {
        ValueAnimator r100 = this.borderAnimator;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRunning() == false) goto L9;
        this.borderAnimator.end();
        return;
    }

    public void release() {
        ValueAnimator r100 = this.borderAnimator;
        if (r100 == null) goto L6;
        r100.cancel();
        this.borderAnimator.removeAllUpdateListeners();
        this.borderAnimator.removeAllListeners();
        this.borderAnimator = null;
        return;
    }

    private float measureHeight() {
        return getResources().getDimension(R.dimen.ttlive_special_comb_view_height);
    }

    private float measureWidth() {
        return getResources().getDimension(R.dimen.ttlive_special_comb_view_width);
    }

    public float getProgress() {
        return this.progress;
    }

    public SpecialCombView(Context r100) {
        super(r100);
        this.timeStr = "1s";
        this.progress = 0.0f;
        init();
    }

    @Override // android.view.View
    public void draw(Canvas r110) {
        super.draw(r110);
        this.mPaint.reset();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.bgColor);
        float r100 = this.viewWidth;
        r110.drawCircle(r100 / 2.0f, this.viewHeight / 2.0f, r100 / 2.0f, this.mPaint);
        this.mPaint.reset();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setShader(this.bordShader);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setStrokeWidth(this.borderWidth);
        r110.drawArc(this.bordRectF, PROGRESS_START_ANGLE, -this.progress, false, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setShader(this.viewShader);
        r110.drawCircle(this.viewWidth / 2.0f, this.viewHeight / 2.0f, this.radius, this.mPaint);
        r110.drawBitmap(this.combBitmap, this.combBmRect, this.combDrawRectF, this.mPaint);
    }

    public void setCountDownTime(int r100) {
        this.totalTimeCount = r100;
    }

    public void setProgress(float r100) {
        this.progress = r100;
        this.time = ((int) ((r100 / 360.0f) * this.totalTimeCount)) + 1;
        this.timeStr = String.valueOf(this.time) + "s";
        invalidate();
    }

    public SpecialCombView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.timeStr = "1s";
        this.progress = 0.0f;
        init();
    }

    private void animateBorderView(long r100, Animator.AnimatorListener r101) {
        if (this.borderAnimator != null) goto L9;
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.borderAnimator = r102;
        if (r101 == null) goto L7;
        r102.addListener(r101);
    L7:
        this.borderAnimator.addUpdateListener(new a(this));
        this.borderAnimator.setDuration(r100);
    L9:
        if (this.borderAnimator.isRunning() == false) goto L11;
        this.borderAnimator.cancel();
        setScaleX(1.0f);
        setScaleY(1.0f);
    L11:
        this.borderAnimator.start();
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension((int) measureWidth(), (int) measureHeight());
    }

    public void setCircleBackgroundColor(int r110, int r111) {
        this.viewShader = new LinearGradient(this.viewWidth, 0.0f, 0.0f, this.viewHeight, r110, r111, Shader.TileMode.CLAMP);
    }

    public void setProgressColor(int r110, int r111) {
        this.bordShader = new LinearGradient(0.0f, 0.0f, this.viewWidth, this.viewHeight, r110, r111, Shader.TileMode.CLAMP);
    }

    public void startScaleAnim(long r100, Animator.AnimatorListener r101) {
        animateBorderView(r100, r101);
    }

    public SpecialCombView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.timeStr = "1s";
        this.progress = 0.0f;
        init();
    }
}
