package com.bytedance.android.live.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;

/* JADX INFO: loaded from: classes45.dex */
public class LiveCircleView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f66533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f66534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f66535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f66536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f66537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f66538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f66539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f66540h;

    public LiveCircleView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        r100.drawCircle(this.f66535c, this.f66536d, this.f66537e, this.f66533a);
        r100.drawCircle(this.f66535c, this.f66536d, this.f66538f, this.f66540h);
    }

    public void setFraction(float r100) {
        this.f66538f = this.f66537e + (this.f66539g * r100);
        this.f66540h.setStrokeWidth(this.f66534b * (1.0f - r100));
        postInvalidate();
    }

    public void setStrokeWidth(int r100) {
        this.f66534b = r100;
    }

    public LiveCircleView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        this.f66535c = getMeasuredWidth() / 2;
        this.f66536d = getMeasuredHeight() / 2;
        float r102 = (getMeasuredHeight() / 2) - getPaddingBottom();
        this.f66537e = r102;
        this.f66538f = r102;
        this.f66539g = getPaddingBottom();
    }

    public LiveCircleView(Context r100, AttributeSet r110, int r111) {
        super(r100, r110, r111);
        this.f66534b = (int) UIUtils.dip2Px(r100, 1.0f);
        this.f66533a = new Paint();
        this.f66533a.setShader(new LinearGradient(0.0f, 0.0f, 100.0f, 100.0f, ColorProtector.parseColor("#FF1764"), ColorProtector.parseColor("#ED3495"), Shader.TileMode.MIRROR));
        this.f66533a.setAntiAlias(true);
        this.f66533a.setDither(true);
        this.f66533a.setStyle(Paint.Style.STROKE);
        this.f66533a.setStrokeWidth(UIUtils.dip2Px(r100, 1.0f));
        this.f66540h = new Paint(this.f66533a);
    }
}
