package com.stepos.common.widget;

import O6.t;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.common.R$drawable;

/* loaded from: classes3.dex */
class AILogoView extends View {
    private static final int BIG_SIZE = 28;
    private static final int SMALL_SIZE = 24;
    private Drawable drawable;
    private boolean mIsColorfulStyle;
    private PorterDuffXfermode mXfermode;
    private Paint paint;
    private RectF rectF;

    public AILogoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
        this.mXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        this.drawable = androidx.core.content.a.e(getContext(), R$drawable.ai_loading_icon);
        this.rectF = new RectF(0.0f, 0.0f, t.a(getContext(), 28.0d), t.a(getContext(), 28.0d));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, this.rectF.width(), this.rectF.height(), this.paint, 31);
        this.drawable.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
        this.drawable.draw(canvas);
        this.paint.setXfermode(this.mXfermode);
        if (!this.mIsColorfulStyle) {
            canvas.drawRect(this.rectF, this.paint);
        }
        this.paint.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension((int) this.rectF.width(), (int) this.rectF.height());
    }
}
