package L8;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* loaded from: classes4.dex */
public class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f4312a;

    public a() {
        Paint paint = new Paint(1);
        this.f4312a = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    public void a(int i10, int i11) {
        this.f4312a.setStrokeWidth(i10);
        this.f4312a.setColor(i11);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f4312a.getStrokeWidth() > 0.0f) {
            canvas.drawRect(getBounds(), this.f4312a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
