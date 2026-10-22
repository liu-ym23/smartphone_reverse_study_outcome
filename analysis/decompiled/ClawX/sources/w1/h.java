package w1;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h extends t1.j {
    public static final /* synthetic */ int F = 0;
    public g E;

    @Override // t1.j
    public final void e(Canvas canvas) {
        if (this.E.f6098r.isEmpty()) {
            super.e(canvas);
            return;
        }
        canvas.save();
        canvas.clipOutRect(this.E.f6098r);
        super.e(canvas);
        canvas.restore();
    }

    @Override // t1.j, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.E = new g(this.E);
        return this;
    }

    public final void s(float f3, float f7, float f9, float f10) {
        RectF rectF = this.E.f6098r;
        if (f3 == rectF.left && f7 == rectF.top && f9 == rectF.right && f10 == rectF.bottom) {
            return;
        }
        rectF.set(f3, f7, f9, f10);
        invalidateSelf();
    }
}
