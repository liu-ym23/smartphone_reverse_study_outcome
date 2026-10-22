package p;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;

/* renamed from: p.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0905a extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f19261f = {R.attr.colorBackground};

    /* renamed from: g, reason: collision with root package name */
    private static final InterfaceC0908d f19262g;

    /* renamed from: a, reason: collision with root package name */
    private boolean f19263a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f19264b;

    /* renamed from: c, reason: collision with root package name */
    int f19265c;

    /* renamed from: d, reason: collision with root package name */
    int f19266d;

    /* renamed from: e, reason: collision with root package name */
    final Rect f19267e;

    static {
        C0906b c0906b = new C0906b();
        f19262g = c0906b;
        c0906b.j();
    }

    public ColorStateList getCardBackgroundColor() {
        return f19262g.b(null);
    }

    public float getCardElevation() {
        return f19262g.d(null);
    }

    public int getContentPaddingBottom() {
        return this.f19267e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f19267e.left;
    }

    public int getContentPaddingRight() {
        return this.f19267e.right;
    }

    public int getContentPaddingTop() {
        return this.f19267e.top;
    }

    public float getMaxCardElevation() {
        return f19262g.e(null);
    }

    public boolean getPreventCornerOverlap() {
        return this.f19264b;
    }

    public float getRadius() {
        return f19262g.h(null);
    }

    public boolean getUseCompatPadding() {
        return this.f19263a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        if (f19262g instanceof C0906b) {
            super.onMeasure(i5, i6);
            return;
        }
        int mode = View.MeasureSpec.getMode(i5);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i5 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.k(null)), View.MeasureSpec.getSize(i5)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i6);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i6 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.c(null)), View.MeasureSpec.getSize(i6)), mode2);
        }
        super.onMeasure(i5, i6);
    }

    public void setCardBackgroundColor(int i5) {
        f19262g.a(null, ColorStateList.valueOf(i5));
    }

    public void setCardElevation(float f5) {
        f19262g.f(null, f5);
    }

    public void setMaxCardElevation(float f5) {
        f19262g.l(null, f5);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i5) {
        this.f19266d = i5;
        super.setMinimumHeight(i5);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i5) {
        this.f19265c = i5;
        super.setMinimumWidth(i5);
    }

    @Override // android.view.View
    public void setPadding(int i5, int i6, int i7, int i8) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i5, int i6, int i7, int i8) {
    }

    public void setPreventCornerOverlap(boolean z5) {
        if (z5 != this.f19264b) {
            this.f19264b = z5;
            f19262g.g(null);
        }
    }

    public void setRadius(float f5) {
        f19262g.m(null, f5);
    }

    public void setUseCompatPadding(boolean z5) {
        if (this.f19263a != z5) {
            this.f19263a = z5;
            f19262g.i(null);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f19262g.a(null, colorStateList);
    }
}
