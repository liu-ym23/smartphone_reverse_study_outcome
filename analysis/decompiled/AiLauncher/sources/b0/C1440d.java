package b0;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: b0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1440d extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public float f15225a;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f15227c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f15228d;

    /* renamed from: e, reason: collision with root package name */
    public float f15229e;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f15232h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f15233i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f15234j;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15230f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15231g = true;

    /* renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f15235k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f15226b = new Paint(5);

    public C1440d(ColorStateList colorStateList, float f10) {
        this.f15225a = f10;
        e(colorStateList);
        this.f15227c = new RectF();
        this.f15228d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public ColorStateList b() {
        return this.f15232h;
    }

    public float c() {
        return this.f15229e;
    }

    public float d() {
        return this.f15225a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f15226b;
        if (this.f15233i == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f15233i);
            z10 = true;
        }
        RectF rectF = this.f15227c;
        float f10 = this.f15225a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (z10) {
            paint.setColorFilter(null);
        }
    }

    public final void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f15232h = colorStateList;
        this.f15226b.setColor(colorStateList.getColorForState(getState(), this.f15232h.getDefaultColor()));
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    public void g(float f10, boolean z10, boolean z11) {
        if (f10 == this.f15229e && this.f15230f == z10 && this.f15231g == z11) {
            return;
        }
        this.f15229e = f10;
        this.f15230f = z10;
        this.f15231g = z11;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f15228d, this.f15225a);
    }

    public void h(float f10) {
        if (f10 == this.f15225a) {
            return;
        }
        this.f15225a = f10;
        i(null);
        invalidateSelf();
    }

    public final void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f15227c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f15228d.set(rect);
        if (this.f15230f) {
            this.f15228d.inset((int) Math.ceil(C1441e.a(this.f15229e, this.f15225a, this.f15231g)), (int) Math.ceil(C1441e.b(this.f15229e, this.f15225a, this.f15231g)));
            this.f15227c.set(this.f15228d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f15234j;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f15232h;
        return (colorStateList2 != null && colorStateList2.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f15232h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z10 = colorForState != this.f15226b.getColor();
        if (z10) {
            this.f15226b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f15234j;
        if (colorStateList2 == null || (mode = this.f15235k) == null) {
            return z10;
        }
        this.f15233i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f15226b.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f15226b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f15234j = colorStateList;
        this.f15233i = a(colorStateList, this.f15235k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f15235k = mode;
        this.f15233i = a(this.f15234j, mode);
        invalidateSelf();
    }
}
