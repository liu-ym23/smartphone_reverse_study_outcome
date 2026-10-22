package com.bytedance.android.gamecp.common.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes44.dex */
public class CircleProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f56858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f56859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f56860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f56861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f56862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f56863f;

    public final void a() {
        this.f56860c = getResources().getDimension(R.dimen.gamecp_shortcut_border_width);
        this.f56861d = getResources().getColor(R.color.gamecp_border_shortcut_gift);
        Paint r100 = new Paint();
        this.f56858a = r100;
        r100.setAntiAlias(true);
        this.f56858a.setStyle(Paint.Style.STROKE);
        this.f56858a.setStrokeCap(Paint.Cap.ROUND);
        this.f56858a.setStrokeWidth(this.f56860c);
        this.f56858a.setColor(this.f56861d);
    }

    public float getProgress() {
        return this.f56863f;
    }

    public CircleProgressView(Context r100) {
        super(r100);
        this.f56859b = new RectF();
        this.f56862e = false;
        this.f56863f = 0.0f;
        a();
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);
        RectF r101 = this.f56859b;
        if (this.f56862e == false) goto L5;
        float r102 = -this.f56863f;
    L6:
        r100.drawArc(r101, -90.0f, r102, false, this.f56858a);
        return;
    L5:
        r102 = this.f56863f;
        goto L6
    }

    public void setBorderColor(int r100) {
        this.f56861d = r100;
        this.f56858a.setColor(r100);
    }

    public void setBorderWidth(float r100) {
        this.f56860c = r100;
        this.f56858a.setStrokeWidth(r100);
    }

    public void setCounterClockWise(boolean r100) {
        this.f56862e = r100;
    }

    public void setProgress(float r100) {
        this.f56863f = r100;
        invalidate();
    }

    public CircleProgressView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f56859b = new RectF();
        this.f56862e = false;
        this.f56863f = 0.0f;
        a();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public CircleProgressView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f56859b = new RectF();
        this.f56862e = false;
        this.f56863f = 0.0f;
        a();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        RectF r104 = this.f56859b;
        float r105 = this.f56860c;
        float r106 = r100;
        r104.set(r105 / 2.0f, r105 / 2.0f, r106 - (r105 / 2.0f), r106 - (r105 / 2.0f));
    }
}
