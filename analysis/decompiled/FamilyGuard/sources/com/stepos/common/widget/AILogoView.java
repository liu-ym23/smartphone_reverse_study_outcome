package com.stepos.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes.dex */
class AILogoView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f13769a;

    /* renamed from: b, reason: collision with root package name */
    private RectF f13770b;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuffXfermode f13771c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f13772d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f13773e;

    public AILogoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f13769a = paint;
        paint.setAntiAlias(true);
        this.f13769a.setStyle(Paint.Style.FILL);
        this.f13769a.setDither(true);
        this.f13769a.setFilterBitmap(true);
        this.f13771c = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        this.f13772d = androidx.core.content.a.e(getContext(), H1.g.f2185a);
        this.f13770b = new RectF(0.0f, 0.0f, N1.j.a(getContext(), 28.0d), N1.j.a(getContext(), 28.0d));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, this.f13770b.width(), this.f13770b.height(), this.f13769a, 31);
        this.f13772d.setBounds(0, 0, (int) this.f13770b.width(), (int) this.f13770b.height());
        this.f13772d.draw(canvas);
        this.f13769a.setXfermode(this.f13771c);
        if (!this.f13773e) {
            canvas.drawRect(this.f13770b, this.f13769a);
        }
        this.f13769a.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        setMeasuredDimension((int) this.f13770b.width(), (int) this.f13770b.height());
    }
}
