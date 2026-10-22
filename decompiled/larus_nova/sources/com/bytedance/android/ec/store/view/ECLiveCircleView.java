package com.bytedance.android.ec.store.view;

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

/* JADX INFO: loaded from: classes44.dex */
public class ECLiveCircleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f48712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f48713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f48714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f48715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f48716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f48717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f48718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f48719h;

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public ECLiveCircleView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        r100.drawCircle(this.f48714c, this.f48715d, this.f48716e, this.f48712a);
        r100.drawCircle(this.f48714c, this.f48715d, this.f48717f, this.f48719h);
    }

    public void setFraction(float r100) {
        float r101 = this.f48716e + (this.f48718g * r100);
        float r102 = this.f48713b * (1.0f - r100);
        this.f48717f = r101;
        this.f48719h.setStrokeWidth(r102);
        postInvalidate();
    }

    public void setStrokeWidth(int r100) {
        this.f48713b = r100;
    }

    public ECLiveCircleView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f48714c = getMeasuredWidth() / 2.0f;
        this.f48715d = getMeasuredHeight() / 2.0f;
        float r102 = (getMeasuredHeight() / 2.0f) - getPaddingBottom();
        this.f48716e = r102;
        this.f48717f = r102;
        this.f48718g = getPaddingBottom();
    }

    public ECLiveCircleView(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111);
        TypedArray r112 = r100.obtainStyledAttributes(r110, new int[]{R.attr.live_strokeWidth});
        this.f48713b = (int) r112.getDimension(0, UIUtils.dip2Px(r100, 1.5f));
        r112.recycle();
        this.f48712a = new Paint();
        this.f48712a.setShader(new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, ColorProtector.parseColor("#FF3B52"), ColorProtector.parseColor("#FF3B52"), Shader.TileMode.MIRROR));
        this.f48712a.setAntiAlias(true);
        this.f48712a.setDither(true);
        this.f48712a.setStyle(Paint.Style.STROKE);
        this.f48712a.setStrokeWidth(UIUtils.dip2Px(r100, 1.0f));
        this.f48719h = new Paint(this.f48712a);
    }
}
