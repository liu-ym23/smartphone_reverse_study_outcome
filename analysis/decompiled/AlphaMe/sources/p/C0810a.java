package p;

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

/* renamed from: p.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0810a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public float f13828a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f13829b;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f13830c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f13831d;

    /* renamed from: e, reason: collision with root package name */
    public float f13832e;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f13835h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f13836i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f13837j;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13833f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13834g = true;

    /* renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f13838k = PorterDuff.Mode.SRC_IN;

    public C0810a(float f4, ColorStateList colorStateList) {
        this.f13828a = f4;
        Paint paint = new Paint(5);
        this.f13829b = paint;
        colorStateList = colorStateList == null ? ColorStateList.valueOf(0) : colorStateList;
        this.f13835h = colorStateList;
        paint.setColor(colorStateList.getColorForState(getState(), this.f13835h.getDefaultColor()));
        this.f13830c = new RectF();
        this.f13831d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void b(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        RectF rectF = this.f13830c;
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
        Rect rect2 = this.f13831d;
        rect2.set(rect);
        if (this.f13833f) {
            rect2.inset((int) Math.ceil(b.a(this.f13832e, this.f13828a, this.f13834g)), (int) Math.ceil(b.b(this.f13832e, this.f13828a, this.f13834g)));
            rectF.set(rect2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z4;
        Paint paint = this.f13829b;
        if (this.f13836i == null || paint.getColorFilter() != null) {
            z4 = false;
        } else {
            paint.setColorFilter(this.f13836i);
            z4 = true;
        }
        RectF rectF = this.f13830c;
        float f4 = this.f13828a;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        if (z4) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.f13831d, this.f13828a);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f13837j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f13835h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        b(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f13835h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        Paint paint = this.f13829b;
        boolean z4 = colorForState != paint.getColor();
        if (z4) {
            paint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f13837j;
        if (colorStateList2 == null || (mode = this.f13838k) == null) {
            return z4;
        }
        this.f13836i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        this.f13829b.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f13829b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f13837j = colorStateList;
        this.f13836i = a(colorStateList, this.f13838k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f13838k = mode;
        this.f13836i = a(this.f13837j, mode);
        invalidateSelf();
    }
}
