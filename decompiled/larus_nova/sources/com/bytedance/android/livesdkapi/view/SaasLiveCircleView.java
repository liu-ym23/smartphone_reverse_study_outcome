package com.bytedance.android.livesdkapi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes12.dex */
public class SaasLiveCircleView extends View {

    /* JADX INFO: renamed from: cx, reason: collision with root package name */
    private int f162656cx;

    /* JADX INFO: renamed from: cy, reason: collision with root package name */
    private int f162657cy;
    public boolean isCatonFuncOptEnabled;
    private int mCircleAlpha;
    private Paint mCirclePaint;
    private float mCircleRadius;
    private float mCircleStrokeWidth;
    private Context mContext;
    private int mInterval;
    private Paint mPaint;
    private float mStrokeWidth;
    private float radius;

    public SaasLiveCircleView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
        r100.drawCircle(this.f162656cx, this.f162657cy, this.radius, this.mPaint);
        r100.drawCircle(this.f162656cx, this.f162657cy, this.mCircleRadius, this.mCirclePaint);
    }

    public void setFraction(float r100) {
        float r101 = this.radius + (this.mInterval * r100);
        float r102 = this.mStrokeWidth * (1.0f - r100);
        if (this.isCatonFuncOptEnabled == true) goto L5;
    L9:
        this.mCircleRadius = r101;
        this.mCircleStrokeWidth = r102;
        this.mCirclePaint.setStrokeWidth(r102);
        postInvalidate();
        return;
    L5:
        if (Math.abs(r101 - this.mCircleRadius) >= 0.5f) goto L9;
        if (Math.abs(this.mCircleStrokeWidth - r102) >= 0.5f) goto L9;
    }

    public void setStrokeWidth(int r100) {
        this.mStrokeWidth = r100;
    }

    public SaasLiveCircleView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public void init(Context r110, AttributeSet r111) {
        TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{R.attr.live_strokeWidth});
        this.mStrokeWidth = (int) r112.getDimension(0, UIUtils.dip2Px(r110, 1.5f));
        r112.recycle();
        this.mContext = r110;
        this.mPaint = new Paint();
        this.mPaint.setShader(new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, ColorProtector.parseColor("#FF1764"), ColorProtector.parseColor("#ED3495"), Shader.TileMode.MIRROR));
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(UIUtils.dip2Px(r110, 1.5f));
        this.mCirclePaint = new Paint(this.mPaint);
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f162656cx = getMeasuredWidth() / 2;
        this.f162657cy = getMeasuredHeight() / 2;
        float r102 = (getMeasuredHeight() / 2) - getPaddingBottom();
        this.radius = r102;
        this.mCircleRadius = r102;
        this.mInterval = getPaddingBottom();
    }

    public void setColors(int r110, int r111) {
        LinearGradient r100 = new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, r110, r111, Shader.TileMode.MIRROR);
        this.mPaint.setShader(r100);
        this.mCirclePaint.setShader(r100);
    }

    public SaasLiveCircleView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mCircleAlpha = 255;
        this.isCatonFuncOptEnabled = false;
        init(r100, r101);
    }
}
