package g;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import u0.C5566a;

/* loaded from: classes.dex */
public class b extends Drawable {

    /* renamed from: m, reason: collision with root package name */
    public static final float f32657m = (float) Math.toRadians(45.0d);

    /* renamed from: a, reason: collision with root package name */
    public final Paint f32658a;

    /* renamed from: b, reason: collision with root package name */
    public float f32659b;

    /* renamed from: c, reason: collision with root package name */
    public float f32660c;

    /* renamed from: d, reason: collision with root package name */
    public float f32661d;

    /* renamed from: e, reason: collision with root package name */
    public float f32662e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f32663f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f32664g;

    /* renamed from: h, reason: collision with root package name */
    public final int f32665h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f32666i;

    /* renamed from: j, reason: collision with root package name */
    public float f32667j;

    /* renamed from: k, reason: collision with root package name */
    public float f32668k;

    /* renamed from: l, reason: collision with root package name */
    public int f32669l;

    public static float a(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    public void b(float f10) {
        if (this.f32667j != f10) {
            this.f32667j = f10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i10 = this.f32669l;
        boolean z10 = false;
        if (i10 != 0 && (i10 == 1 || (i10 == 3 ? C5566a.f(this) == 0 : C5566a.f(this) == 1))) {
            z10 = true;
        }
        float f10 = this.f32659b;
        float fA = a(this.f32660c, (float) Math.sqrt(f10 * f10 * 2.0f), this.f32667j);
        float fA2 = a(this.f32660c, this.f32661d, this.f32667j);
        float fRound = Math.round(a(0.0f, this.f32668k, this.f32667j));
        float fA3 = a(0.0f, f32657m, this.f32667j);
        float fA4 = a(z10 ? 0.0f : -180.0f, z10 ? 180.0f : 0.0f, this.f32667j);
        double d10 = fA;
        double d11 = fA3;
        boolean z11 = z10;
        float fRound2 = Math.round(Math.cos(d11) * d10);
        float fRound3 = Math.round(d10 * Math.sin(d11));
        this.f32664g.rewind();
        float fA5 = a(this.f32662e + this.f32658a.getStrokeWidth(), -this.f32668k, this.f32667j);
        float f11 = (-fA2) / 2.0f;
        this.f32664g.moveTo(f11 + fRound, 0.0f);
        this.f32664g.rLineTo(fA2 - (fRound * 2.0f), 0.0f);
        this.f32664g.moveTo(f11, fA5);
        this.f32664g.rLineTo(fRound2, fRound3);
        this.f32664g.moveTo(f11, -fA5);
        this.f32664g.rLineTo(fRound2, -fRound3);
        this.f32664g.close();
        canvas.save();
        float strokeWidth = this.f32658a.getStrokeWidth();
        float fHeight = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (fHeight - (r5 * 2.0f))) / 4) * 2) + (strokeWidth * 1.5f) + this.f32662e);
        if (this.f32663f) {
            canvas.rotate(fA4 * (this.f32666i ^ z11 ? -1 : 1));
        } else if (z11) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f32664g, this.f32658a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f32665h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f32665h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (i10 != this.f32658a.getAlpha()) {
            this.f32658a.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f32658a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
