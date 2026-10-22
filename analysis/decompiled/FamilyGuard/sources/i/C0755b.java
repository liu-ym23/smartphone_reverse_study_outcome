package i;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: i.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0755b extends Drawable {

    /* renamed from: m, reason: collision with root package name */
    private static final float f17600m = (float) Math.toRadians(45.0d);

    /* renamed from: a, reason: collision with root package name */
    private final Paint f17601a;

    /* renamed from: b, reason: collision with root package name */
    private float f17602b;

    /* renamed from: c, reason: collision with root package name */
    private float f17603c;

    /* renamed from: d, reason: collision with root package name */
    private float f17604d;

    /* renamed from: e, reason: collision with root package name */
    private float f17605e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f17606f;

    /* renamed from: g, reason: collision with root package name */
    private final Path f17607g;

    /* renamed from: h, reason: collision with root package name */
    private final int f17608h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f17609i;

    /* renamed from: j, reason: collision with root package name */
    private float f17610j;

    /* renamed from: k, reason: collision with root package name */
    private float f17611k;

    /* renamed from: l, reason: collision with root package name */
    private int f17612l;

    private static float a(float f5, float f6, float f7) {
        return f5 + ((f6 - f5) * f7);
    }

    public void b(float f5) {
        if (this.f17610j != f5) {
            this.f17610j = f5;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i5 = this.f17612l;
        boolean z5 = false;
        if (i5 != 0 && (i5 == 1 || (i5 == 3 ? androidx.core.graphics.drawable.a.f(this) == 0 : androidx.core.graphics.drawable.a.f(this) == 1))) {
            z5 = true;
        }
        float f5 = this.f17602b;
        float fA = a(this.f17603c, (float) Math.sqrt(f5 * f5 * 2.0f), this.f17610j);
        float fA2 = a(this.f17603c, this.f17604d, this.f17610j);
        float fRound = Math.round(a(0.0f, this.f17611k, this.f17610j));
        float fA3 = a(0.0f, f17600m, this.f17610j);
        float fA4 = a(z5 ? 0.0f : -180.0f, z5 ? 180.0f : 0.0f, this.f17610j);
        double d6 = fA;
        double d7 = fA3;
        boolean z6 = z5;
        float fRound2 = Math.round(Math.cos(d7) * d6);
        float fRound3 = Math.round(d6 * Math.sin(d7));
        this.f17607g.rewind();
        float fA5 = a(this.f17605e + this.f17601a.getStrokeWidth(), -this.f17611k, this.f17610j);
        float f6 = (-fA2) / 2.0f;
        this.f17607g.moveTo(f6 + fRound, 0.0f);
        this.f17607g.rLineTo(fA2 - (fRound * 2.0f), 0.0f);
        this.f17607g.moveTo(f6, fA5);
        this.f17607g.rLineTo(fRound2, fRound3);
        this.f17607g.moveTo(f6, -fA5);
        this.f17607g.rLineTo(fRound2, -fRound3);
        this.f17607g.close();
        canvas.save();
        float strokeWidth = this.f17601a.getStrokeWidth();
        float fHeight = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (fHeight - (r5 * 2.0f))) / 4) * 2) + (strokeWidth * 1.5f) + this.f17605e);
        if (this.f17606f) {
            canvas.rotate(fA4 * (this.f17609i ^ z6 ? -1 : 1));
        } else if (z6) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f17607g, this.f17601a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f17608h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f17608h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        if (i5 != this.f17601a.getAlpha()) {
            this.f17601a.setAlpha(i5);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f17601a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
