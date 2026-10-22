package androidx.cardview.widget;

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

/* JADX INFO: loaded from: classes.dex */
public class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f1168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f1169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f1170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f1171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f1172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorStateList f1175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f1176i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f1177j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f1178k;

    public b(ColorStateList r10, float r11) {
        this.f1173f = false;
        this.f1174g = true;
        this.f1178k = PorterDuff.Mode.SRC_IN;
        this.f1168a = r11;
        this.f1169b = new Paint(5);
        e(r10);
        this.f1170c = new RectF();
        this.f1171d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList r10, PorterDuff.Mode r11) {
        if (r10 == null) goto L7;
        if (r11 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r10.getColorForState(getState(), 0), r11);
    L7:
        return null;
    }

    public ColorStateList b() {
        return this.f1175h;
    }

    public float c() {
        return this.f1172e;
    }

    public float d() {
        return this.f1168a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        Paint r11 = this.f1169b;
        if (this.f1176i != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        RectF r13 = this.f1170c;
        float r14 = this.f1168a;
        r10.drawRoundRect(r13, r14, r14, r11);
        if (r12 == false) goto L12;
        r11.setColorFilter(null);
        return;
    L12:
        return;
    L5:
        if (r11.getColorFilter() != null) goto L7;
        r11.setColorFilter(this.f1176i);
        r12 = true;
        goto L8
    }

    public final void e(ColorStateList r10) {
        if (r10 != null) goto L4;
        r10 = ColorStateList.valueOf(0);
    L4:
        this.f1175h = r10;
        this.f1169b.setColor(r10.getColorForState(getState(), this.f1175h.getDefaultColor()));
    }

    public void f(ColorStateList r10) {
        e(r10);
        invalidateSelf();
    }

    public void g(float r10, boolean r11, boolean r12) {
        if (r10 == this.f1172e) goto L5;
    L9:
        this.f1172e = r10;
        this.f1173f = r11;
        this.f1174g = r12;
        i(null);
        invalidateSelf();
        return;
    L5:
        if (this.f1173f != r11) goto L9;
        if (this.f1174g != r12) goto L9;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r10) {
        r10.setRoundRect(this.f1171d, this.f1168a);
    }

    public void h(float r10) {
        if (r10 != this.f1168a) goto L5;
        return;
    L5:
        this.f1168a = r10;
        i(null);
        invalidateSelf();
    }

    public final void i(Rect r10) {
        if (r10 != null) goto L4;
        r10 = getBounds();
    L4:
        this.f1170c.set(r10.left, r10.top, r10.right, r10.bottom);
        this.f1171d.set(r10);
        if (this.f1173f == false) goto L8;
        float r11 = RoundRectDrawableWithShadow.b(this.f1172e, this.f1168a, this.f1174g);
        this.f1171d.inset((int) Math.ceil(RoundRectDrawableWithShadow.a(this.f1172e, this.f1168a, this.f1174g)), (int) Math.ceil(r11));
        this.f1170c.set(this.f1171d);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList r10 = this.f1177j;
        if (r10 != null) goto L5;
    L6:
        ColorStateList r11 = this.f1175h;
        if (r11 == null) goto L11;
        if (r11.isStateful() == false) goto L11;
    L12:
        return true;
    L11:
        if (super.isStateful() == true) goto L12;
        return false;
    L5:
        if (r10.isStateful() == true) goto L12;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r10) {
        super.onBoundsChange(r10);
        i(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r10) {
        ColorStateList r11 = this.f1175h;
        int r12 = r11.getColorForState(r10, r11.getDefaultColor());
        if (r12 == this.f1169b.getColor()) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L8;
        this.f1169b.setColor(r12);
    L8:
        ColorStateList r14 = this.f1177j;
        if (r14 == null) goto L14;
        PorterDuff.Mode r15 = this.f1178k;
        if (r15 == null) goto L14;
        this.f1176i = a(r14, r15);
        return true;
    L14:
        return r13;
    L5:
        r13 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.f1169b.setAlpha(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        this.f1169b.setColorFilter(r10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r10) {
        this.f1177j = r10;
        this.f1176i = a(r10, this.f1178k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode r10) {
        this.f1178k = r10;
        this.f1176i = a(this.f1177j, r10);
        invalidateSelf();
    }
}
