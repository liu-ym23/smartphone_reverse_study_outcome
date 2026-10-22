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

/* renamed from: p.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0909e extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private float f19268a;

    /* renamed from: b, reason: collision with root package name */
    private final Paint f19269b;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f19270c;

    /* renamed from: d, reason: collision with root package name */
    private final Rect f19271d;

    /* renamed from: e, reason: collision with root package name */
    private float f19272e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f19273f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f19274g;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f19275h;

    /* renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f19276i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f19277j;

    /* renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f19278k;

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f19275h = colorStateList;
        this.f19269b.setColor(colorStateList.getColorForState(getState(), this.f19275h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f19270c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f19271d.set(rect);
        if (this.f19273f) {
            this.f19271d.inset((int) Math.ceil(C0910f.a(this.f19272e, this.f19268a, this.f19274g)), (int) Math.ceil(C0910f.b(this.f19272e, this.f19268a, this.f19274g)));
            this.f19270c.set(this.f19271d);
        }
    }

    public ColorStateList b() {
        return this.f19275h;
    }

    float c() {
        return this.f19272e;
    }

    public float d() {
        return this.f19268a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z5;
        Paint paint = this.f19269b;
        if (this.f19276i == null || paint.getColorFilter() != null) {
            z5 = false;
        } else {
            paint.setColorFilter(this.f19276i);
            z5 = true;
        }
        RectF rectF = this.f19270c;
        float f5 = this.f19268a;
        canvas.drawRoundRect(rectF, f5, f5, paint);
        if (z5) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    void g(float f5, boolean z5, boolean z6) {
        if (f5 == this.f19272e && this.f19273f == z5 && this.f19274g == z6) {
            return;
        }
        this.f19272e = f5;
        this.f19273f = z5;
        this.f19274g = z6;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f19271d, this.f19268a);
    }

    void h(float f5) {
        if (f5 == this.f19268a) {
            return;
        }
        this.f19268a = f5;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f19277j;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f19275h;
        return (colorStateList2 != null && colorStateList2.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f19275h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z5 = colorForState != this.f19269b.getColor();
        if (z5) {
            this.f19269b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f19277j;
        if (colorStateList2 == null || (mode = this.f19278k) == null) {
            return z5;
        }
        this.f19276i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        this.f19269b.setAlpha(i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f19269b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f19277j = colorStateList;
        this.f19276i = a(colorStateList, this.f19278k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f19278k = mode;
        this.f19276i = a(this.f19277j, mode);
        invalidateSelf();
    }
}
