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
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
class AILogoView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f11437a;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f11438b;

    /* renamed from: c, reason: collision with root package name */
    public final PorterDuffXfermode f11439c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f11440d;

    public AILogoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f11437a = paint;
        paint.setAntiAlias(true);
        this.f11437a.setStyle(Paint.Style.FILL);
        this.f11437a.setDither(true);
        this.f11437a.setFilterBitmap(true);
        this.f11439c = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        this.f11440d = androidx.core.content.a.b(getContext(), R.drawable.ai_loading_icon);
        this.f11438b = new RectF(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, m2.o.b(getContext(), 28.0d), m2.o.b(getContext(), 28.0d));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iSaveLayer = canvas.saveLayer(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, this.f11438b.width(), this.f11438b.height(), this.f11437a, 31);
        this.f11440d.setBounds(0, 0, (int) this.f11438b.width(), (int) this.f11438b.height());
        this.f11440d.draw(canvas);
        this.f11437a.setXfermode(this.f11439c);
        canvas.drawRect(this.f11438b, this.f11437a);
        this.f11437a.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        setMeasuredDimension((int) this.f11438b.width(), (int) this.f11438b.height());
    }
}
