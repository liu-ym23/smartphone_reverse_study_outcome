package u0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.stepos.ailauncher.chat.wake.circle.F;

/* loaded from: classes.dex */
public abstract class c extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap f42387a;

    /* renamed from: b, reason: collision with root package name */
    public int f42388b;

    /* renamed from: e, reason: collision with root package name */
    public final BitmapShader f42391e;

    /* renamed from: g, reason: collision with root package name */
    public float f42393g;

    /* renamed from: k, reason: collision with root package name */
    public boolean f42397k;

    /* renamed from: l, reason: collision with root package name */
    public int f42398l;

    /* renamed from: m, reason: collision with root package name */
    public int f42399m;

    /* renamed from: c, reason: collision with root package name */
    public int f42389c = 119;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f42390d = new Paint(3);

    /* renamed from: f, reason: collision with root package name */
    public final Matrix f42392f = new Matrix();

    /* renamed from: h, reason: collision with root package name */
    public final Rect f42394h = new Rect();

    /* renamed from: i, reason: collision with root package name */
    public final RectF f42395i = new RectF();

    /* renamed from: j, reason: collision with root package name */
    public boolean f42396j = true;

    public c(Resources resources, Bitmap bitmap) {
        this.f42388b = F.LOOP_END_FRAME;
        if (resources != null) {
            this.f42388b = resources.getDisplayMetrics().densityDpi;
        }
        this.f42387a = bitmap;
        if (bitmap != null) {
            a();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f42391e = new BitmapShader(bitmap, tileMode, tileMode);
        } else {
            this.f42399m = -1;
            this.f42398l = -1;
            this.f42391e = null;
        }
    }

    public static boolean d(float f10) {
        return f10 > 0.05f;
    }

    public final void a() {
        this.f42398l = this.f42387a.getScaledWidth(this.f42388b);
        this.f42399m = this.f42387a.getScaledHeight(this.f42388b);
    }

    public float b() {
        return this.f42393g;
    }

    public abstract void c(int i10, int i11, int i12, Rect rect, Rect rect2);

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f42387a;
        if (bitmap == null) {
            return;
        }
        g();
        if (this.f42390d.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f42394h, this.f42390d);
            return;
        }
        RectF rectF = this.f42395i;
        float f10 = this.f42393g;
        canvas.drawRoundRect(rectF, f10, f10, this.f42390d);
    }

    public void e(float f10) {
        if (this.f42393g == f10) {
            return;
        }
        this.f42397k = false;
        if (d(f10)) {
            this.f42390d.setShader(this.f42391e);
        } else {
            this.f42390d.setShader(null);
        }
        this.f42393g = f10;
        invalidateSelf();
    }

    public final void f() {
        this.f42393g = Math.min(this.f42399m, this.f42398l) / 2;
    }

    public void g() {
        c cVar;
        if (this.f42396j) {
            if (this.f42397k) {
                int iMin = Math.min(this.f42398l, this.f42399m);
                cVar = this;
                cVar.c(this.f42389c, iMin, iMin, getBounds(), this.f42394h);
                int iMin2 = Math.min(cVar.f42394h.width(), cVar.f42394h.height());
                cVar.f42394h.inset(Math.max(0, (cVar.f42394h.width() - iMin2) / 2), Math.max(0, (cVar.f42394h.height() - iMin2) / 2));
                cVar.f42393g = iMin2 * 0.5f;
            } else {
                cVar = this;
                cVar.c(cVar.f42389c, cVar.f42398l, cVar.f42399m, cVar.getBounds(), cVar.f42394h);
            }
            cVar.f42395i.set(cVar.f42394h);
            if (cVar.f42391e != null) {
                Matrix matrix = cVar.f42392f;
                RectF rectF = cVar.f42395i;
                matrix.setTranslate(rectF.left, rectF.top);
                cVar.f42392f.preScale(cVar.f42395i.width() / cVar.f42387a.getWidth(), cVar.f42395i.height() / cVar.f42387a.getHeight());
                cVar.f42391e.setLocalMatrix(cVar.f42392f);
                cVar.f42390d.setShader(cVar.f42391e);
            }
            cVar.f42396j = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f42390d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f42390d.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f42399m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f42398l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.f42389c != 119 || this.f42397k || (bitmap = this.f42387a) == null || bitmap.hasAlpha() || this.f42390d.getAlpha() < 255 || d(this.f42393g)) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f42397k) {
            f();
        }
        this.f42396j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (i10 != this.f42390d.getAlpha()) {
            this.f42390d.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f42390d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        this.f42390d.setDither(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f42390d.setFilterBitmap(z10);
        invalidateSelf();
    }
}
