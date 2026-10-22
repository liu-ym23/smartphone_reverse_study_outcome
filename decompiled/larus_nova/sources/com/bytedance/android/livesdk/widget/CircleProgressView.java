package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public class CircleProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f160783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f160784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f160785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f160786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f160787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f160788f;

    public final void a() {
        this.f160785c = getResources().getDimension(R.dimen.ttlive_shortcut_border_width);
        this.f160786d = getResources().getColor(R.color.ttlive_border_shortcut_gift);
        Paint r100 = new Paint();
        this.f160783a = r100;
        r100.setAntiAlias(true);
        this.f160783a.setStyle(Paint.Style.STROKE);
        this.f160783a.setStrokeCap(Paint.Cap.ROUND);
        this.f160783a.setStrokeWidth(this.f160785c);
        this.f160783a.setColor(this.f160786d);
    }

    public float getProgress() {
        return this.f160788f;
    }

    public CircleProgressView(Context r100) {
        super(r100);
        this.f160784b = new RectF();
        this.f160787e = false;
        this.f160788f = 0.0f;
        a();
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
        RectF r101 = this.f160784b;
        if (this.f160787e == false) goto L5;
        float r102 = -this.f160788f;
    L6:
        r100.drawArc(r101, -90.0f, r102, false, this.f160783a);
        return;
    L5:
        r102 = this.f160788f;
        goto L6
    }

    public void setBorderColor(int r100) {
        this.f160786d = r100;
        this.f160783a.setColor(r100);
    }

    public void setBorderWidth(float r100) {
        this.f160785c = r100;
        this.f160783a.setStrokeWidth(r100);
    }

    public void setCounterClockWise(boolean r100) {
        this.f160787e = r100;
    }

    public void setProgress(float r100) {
        this.f160788f = r100;
        invalidate();
    }

    public CircleProgressView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f160784b = new RectF();
        this.f160787e = false;
        this.f160788f = 0.0f;
        a();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public CircleProgressView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f160784b = new RectF();
        this.f160787e = false;
        this.f160788f = 0.0f;
        a();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        RectF r104 = this.f160784b;
        float r105 = this.f160785c;
        float r106 = r100;
        r104.set(r105 / 2.0f, r105 / 2.0f, r106 - (r105 / 2.0f), r106 - (r105 / 2.0f));
    }
}
