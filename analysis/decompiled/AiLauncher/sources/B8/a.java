package B8;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes4.dex */
public class a extends Drawable {

    /* renamed from: h, reason: collision with root package name */
    public static final C0010a f1456h = new C0010a(0.15277778f, 0.45833334f);

    /* renamed from: i, reason: collision with root package name */
    public static final C0010a f1457i = new C0010a(0.3888889f, 0.6944444f);

    /* renamed from: j, reason: collision with root package name */
    public static final C0010a f1458j = new C0010a(0.8472222f, 0.2638889f);

    /* renamed from: a, reason: collision with root package name */
    public final int f1459a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1460b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f1461c = new Paint(1);

    /* renamed from: d, reason: collision with root package name */
    public final RectF f1462d = new RectF();

    /* renamed from: e, reason: collision with root package name */
    public final Paint f1463e;

    /* renamed from: f, reason: collision with root package name */
    public final Path f1464f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1465g;

    /* renamed from: B8.a$a, reason: collision with other inner class name */
    public static class C0010a {

        /* renamed from: a, reason: collision with root package name */
        public final float f1466a;

        /* renamed from: b, reason: collision with root package name */
        public final float f1467b;

        public C0010a(float f10, float f11) {
            this.f1466a = f10;
            this.f1467b = f11;
        }

        public void a(Path path, float f10) {
            path.lineTo(this.f1466a * f10, f10 * this.f1467b);
        }

        public void b(Path path, float f10) {
            path.moveTo(this.f1466a * f10, f10 * this.f1467b);
        }
    }

    public a(int i10, int i11, int i12) {
        Paint paint = new Paint(1);
        this.f1463e = paint;
        this.f1464f = new Path();
        this.f1459a = i10;
        this.f1460b = i11;
        paint.setColor(i12);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint.Style style;
        int i10;
        if (this.f1465g) {
            style = Paint.Style.FILL_AND_STROKE;
            i10 = this.f1459a;
        } else {
            style = Paint.Style.STROKE;
            i10 = this.f1460b;
        }
        this.f1461c.setStyle(style);
        this.f1461c.setColor(i10);
        Rect bounds = getBounds();
        float fWidth = (bounds.width() - this.f1462d.width()) / 2.0f;
        float fHeight = (bounds.height() - this.f1462d.height()) / 2.0f;
        float fWidth2 = this.f1462d.width() / 8.0f;
        int iSave = canvas.save();
        try {
            canvas.translate(fWidth, fHeight);
            canvas.drawRoundRect(this.f1462d, fWidth2, fWidth2, this.f1461c);
            if (this.f1465g) {
                canvas.drawPath(this.f1464f, this.f1463e);
            }
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        float fMin = Math.min(rect.width(), rect.height());
        float f10 = fMin / 8.0f;
        float f11 = fMin - f10;
        this.f1462d.set(0.0f, 0.0f, f11, f11);
        this.f1461c.setStrokeWidth(f10);
        this.f1463e.setStrokeWidth(f10);
        this.f1464f.reset();
        f1456h.b(this.f1464f, f11);
        f1457i.a(this.f1464f, f11);
        f1458j.a(this.f1464f, f11);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        int length = iArr != null ? iArr.length : 0;
        if (length > 0) {
            for (int i10 = 0; i10 < length; i10++) {
                if (16842912 == iArr[i10]) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        } else {
            z10 = false;
        }
        boolean z11 = z10 != this.f1465g;
        if (z11) {
            invalidateSelf();
            this.f1465g = z10;
        }
        return z11;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f1461c.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1461c.setColorFilter(colorFilter);
    }
}
