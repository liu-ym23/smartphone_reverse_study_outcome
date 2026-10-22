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
import androidx.core.content.ContextCompat;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
class AILogoView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f3622a;
    public final RectF b;
    public final PorterDuffXfermode c;
    public final Drawable d;

    public AILogoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f3622a = paint;
        paint.setAntiAlias(true);
        this.f3622a.setStyle(Paint.Style.FILL);
        this.f3622a.setDither(true);
        this.f3622a.setFilterBitmap(true);
        this.c = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        this.d = ContextCompat.getDrawable(getContext(), R.drawable.ai_loading_icon);
        this.b = new RectF(0.0f, 0.0f, a5.l.b(getContext(), 28.0d), a5.l.b(getContext(), 28.0d));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, this.b.width(), this.b.height(), this.f3622a, 31);
        this.d.setBounds(0, 0, (int) this.b.width(), (int) this.b.height());
        this.d.draw(canvas);
        this.f3622a.setXfermode(this.c);
        canvas.drawRect(this.b, this.f3622a);
        this.f3622a.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        setMeasuredDimension((int) this.b.width(), (int) this.b.height());
    }
}
