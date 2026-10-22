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
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class AILogoView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f6772a;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f6773b;

    /* renamed from: c, reason: collision with root package name */
    public final PorterDuffXfermode f6774c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f6775d;

    public AILogoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f6772a = paint;
        paint.setAntiAlias(true);
        this.f6772a.setStyle(Paint.Style.FILL);
        this.f6772a.setDither(true);
        this.f6772a.setFilterBitmap(true);
        this.f6774c = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        this.f6775d = getContext().getDrawable(R.drawable.ai_loading_icon);
        this.f6773b = new RectF(0.0f, 0.0f, l8.g.a(getContext(), 28.0d), l8.g.a(getContext(), 28.0d));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, this.f6773b.width(), this.f6773b.height(), this.f6772a, 31);
        this.f6775d.setBounds(0, 0, (int) this.f6773b.width(), (int) this.f6773b.height());
        this.f6775d.draw(canvas);
        this.f6772a.setXfermode(this.f6774c);
        canvas.drawRect(this.f6773b, this.f6772a);
        this.f6772a.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        setMeasuredDimension((int) this.f6773b.width(), (int) this.f6773b.height());
    }
}
