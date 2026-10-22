package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public class CircleProgressViewV3 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f160789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f160790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f160791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f160792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f160793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f160794f;

    public final void a() {
        this.f160791c = getResources().getDimension(R.dimen.ttlive_shortcut_border_width);
        this.f160792d = getResources().getColor(R.color.ttlive_border_shortcut_gift_v3_douyin);
        Paint r100 = new Paint();
        this.f160789a = r100;
        r100.setAntiAlias(true);
        this.f160789a.setStyle(Paint.Style.STROKE);
        this.f160789a.setStrokeCap(Paint.Cap.ROUND);
        this.f160789a.setStrokeWidth(this.f160791c);
        this.f160789a.setColor(this.f160792d);
    }

    public float getProgress() {
        return this.f160794f;
    }

    public CircleProgressViewV3(Context r100) {
        super(r100);
        this.f160790b = new RectF();
        this.f160793e = true;
        this.f160794f = 0.0f;
        a();
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
        RectF r101 = this.f160790b;
        if (this.f160793e == false) goto L5;
        float r102 = -this.f160794f;
    L6:
        r100.drawArc(r101, -90.0f, r102, false, this.f160789a);
        return;
    L5:
        r102 = this.f160794f;
        goto L6
    }

    public void setBorderColor(int r100) {
        this.f160792d = r100;
        this.f160789a.setColor(r100);
    }

    public void setBorderWidth(float r100) {
        this.f160791c = r100;
        this.f160789a.setStrokeWidth(r100);
    }

    public void setCounterClockWise(boolean r100) {
        this.f160793e = r100;
    }

    public void setProgress(float r100) {
        this.f160794f = r100;
        invalidate();
    }

    public CircleProgressViewV3(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f160790b = new RectF();
        this.f160793e = true;
        this.f160794f = 0.0f;
        a();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public CircleProgressViewV3(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f160790b = new RectF();
        this.f160793e = true;
        this.f160794f = 0.0f;
        a();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        RectF r104 = this.f160790b;
        float r105 = this.f160791c;
        float r106 = r100;
        r104.set(r105 / 2.0f, r105 / 2.0f, r106 - (r105 / 2.0f), r106 - (r105 / 2.0f));
    }
}
