package com.stepos.common.scrollbarview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* loaded from: classes.dex */
class b extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f13741a;

    /* renamed from: b, reason: collision with root package name */
    private Drawable f13742b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f13743c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f13744d;

    /* renamed from: e, reason: collision with root package name */
    private a f13745e;

    /* renamed from: f, reason: collision with root package name */
    private int f13746f;

    /* renamed from: g, reason: collision with root package name */
    private int f13747g;

    /* renamed from: h, reason: collision with root package name */
    private int f13748h;

    /* renamed from: i, reason: collision with root package name */
    private int f13749i;

    /* renamed from: j, reason: collision with root package name */
    private int f13750j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f13751k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f13752l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f13753m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f13754n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f13755o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f13756p;

    /* renamed from: q, reason: collision with root package name */
    private int f13757q = 255;

    /* renamed from: r, reason: collision with root package name */
    private boolean f13758r;

    /* renamed from: s, reason: collision with root package name */
    private ColorFilter f13759s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f13760t;

    public b(boolean z5, a aVar) {
        this.f13751k = z5;
        this.f13745e = aVar;
    }

    private void a(Canvas canvas, Rect rect, int i5) {
        boolean z5 = this.f13753m || this.f13752l;
        boolean z6 = this.f13751k;
        Drawable drawable = z6 ? this.f13742b : this.f13744d;
        if (drawable == null) {
            return;
        }
        if (z5) {
            if (z6) {
                int i6 = rect.left;
                int i7 = rect.top;
                int i8 = this.f13749i;
                drawable.setBounds(i6, i7 + i8, rect.right, i7 + i8 + i5);
            } else {
                int i9 = rect.left;
                int i10 = this.f13749i;
                drawable.setBounds(i9 + i10, rect.top, i9 + i10 + i5, rect.bottom);
            }
            if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setCornerRadius(this.f13751k ? drawable.getBounds().width() / 2 : drawable.getBounds().height() / 2);
            }
        }
        drawable.draw(canvas);
    }

    private void b(Canvas canvas, Rect rect) {
        Drawable drawable = this.f13751k ? this.f13741a : this.f13743c;
        if (drawable != null) {
            if (this.f13752l) {
                drawable.setBounds(rect);
            }
            if (drawable instanceof GradientDrawable) {
                ((GradientDrawable) drawable).setCornerRadius(this.f13751k ? drawable.getBounds().width() / 2 : drawable.getBounds().height() / 2);
            }
            drawable.draw(canvas);
        }
    }

    private void f(Drawable drawable) {
        if (drawable != null) {
            if (this.f13756p) {
                drawable.mutate();
            }
            drawable.setState(getState());
            drawable.setCallback(this);
            if (this.f13758r) {
                drawable.setAlpha(this.f13757q);
            }
            if (this.f13760t) {
                drawable.setColorFilter(this.f13759s);
            }
        }
    }

    public Drawable c() {
        return this.f13751k ? this.f13742b : this.f13744d;
    }

    public int d() {
        return this.f13749i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z5;
        boolean z6;
        int i5 = this.f13748h;
        int i6 = this.f13746f;
        if (i5 <= 0 || i6 <= this.f13745e.a() * i5) {
            z5 = this.f13751k ? this.f13754n : this.f13755o;
            z6 = false;
        } else {
            z5 = true;
            z6 = true;
        }
        Rect bounds = getBounds();
        if (canvas.quickReject(bounds.left, bounds.top, bounds.right, bounds.bottom)) {
            return;
        }
        if (z5) {
            b(canvas, bounds);
        }
        if (z6) {
            int iHeight = this.f13751k ? bounds.height() : bounds.width();
            int iC = this.f13745e.c(iHeight, this.f13751k ? bounds.width() : bounds.height(), i5, i6, this.f13750j);
            this.f13749i = this.f13745e.d(iHeight, iC, i5, i6, this.f13747g, this.f13750j);
            a(canvas, bounds, iC);
        }
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b mutate() {
        if (!this.f13756p && super.mutate() == this) {
            Drawable drawable = this.f13741a;
            if (drawable != null) {
                drawable.mutate();
            }
            Drawable drawable2 = this.f13742b;
            if (drawable2 != null) {
                drawable2.mutate();
            }
            Drawable drawable3 = this.f13743c;
            if (drawable3 != null) {
                drawable3.mutate();
            }
            Drawable drawable4 = this.f13744d;
            if (drawable4 != null) {
                drawable4.mutate();
            }
            this.f13756p = true;
        }
        return this;
    }

    public void g(boolean z5) {
        this.f13754n = z5;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f13757q;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f13759s;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(int i5, int i6, int i7, int i8) {
        if (this.f13746f == i5 && this.f13747g == i6 && this.f13748h == i7 && this.f13750j == i8) {
            return;
        }
        this.f13746f = i5;
        this.f13747g = i6;
        this.f13748h = i7;
        this.f13750j = i8;
        this.f13753m = true;
    }

    public void i(a aVar) {
        this.f13745e = aVar;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f13741a;
        if (drawable != null && drawable.isStateful()) {
            return true;
        }
        Drawable drawable2 = this.f13742b;
        if (drawable2 != null && drawable2.isStateful()) {
            return true;
        }
        Drawable drawable3 = this.f13743c;
        if (drawable3 != null && drawable3.isStateful()) {
            return true;
        }
        Drawable drawable4 = this.f13744d;
        return (drawable4 != null && drawable4.isStateful()) || super.isStateful();
    }

    public void j(int i5) {
        Rect bounds = getBounds();
        if (this.f13751k) {
            int i6 = bounds.right;
            setBounds(i6 - i5, bounds.top, i6, bounds.bottom);
        } else {
            int i7 = bounds.left;
            int i8 = bounds.bottom;
            setBounds(i7, i8 - i5, bounds.right, i8);
        }
    }

    public void k(Drawable drawable) {
        if (this.f13751k) {
            Drawable drawable2 = this.f13742b;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            f(drawable);
            this.f13742b = drawable;
            return;
        }
        Drawable drawable3 = this.f13744d;
        if (drawable3 != null) {
            drawable3.setCallback(null);
        }
        f(drawable);
        this.f13744d = drawable;
    }

    public void l(Drawable drawable) {
        if (this.f13751k) {
            Drawable drawable2 = this.f13741a;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            f(drawable);
            this.f13741a = drawable;
            return;
        }
        Drawable drawable3 = this.f13743c;
        if (drawable3 != null) {
            drawable3.setCallback(null);
        }
        f(drawable);
        this.f13743c = drawable;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f13752l = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        Drawable drawable = this.f13741a;
        if (drawable != null) {
            zOnStateChange |= drawable.setState(iArr);
        }
        Drawable drawable2 = this.f13742b;
        if (drawable2 != null) {
            zOnStateChange |= drawable2.setState(iArr);
        }
        Drawable drawable3 = this.f13743c;
        if (drawable3 != null) {
            zOnStateChange |= drawable3.setState(iArr);
        }
        Drawable drawable4 = this.f13744d;
        return drawable4 != null ? drawable4.setState(iArr) | zOnStateChange : zOnStateChange;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        scheduleSelf(runnable, j5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        this.f13757q = i5;
        this.f13758r = true;
        Drawable drawable = this.f13741a;
        if (drawable != null) {
            drawable.setAlpha(i5);
        }
        Drawable drawable2 = this.f13742b;
        if (drawable2 != null) {
            drawable2.setAlpha(i5);
        }
        Drawable drawable3 = this.f13743c;
        if (drawable3 != null) {
            drawable3.setAlpha(i5);
        }
        Drawable drawable4 = this.f13744d;
        if (drawable4 != null) {
            drawable4.setAlpha(i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f13759s = colorFilter;
        this.f13760t = true;
        Drawable drawable = this.f13741a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.f13742b;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
        Drawable drawable3 = this.f13743c;
        if (drawable3 != null) {
            drawable3.setColorFilter(colorFilter);
        }
        Drawable drawable4 = this.f13744d;
        if (drawable4 != null) {
            drawable4.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i5, int i6, int i7, int i8) {
        super.setHotspotBounds(i5, i6, i7, i8);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ScrollBarDrawable: range=");
        sb.append(this.f13746f);
        sb.append(" offset=");
        sb.append(this.f13747g);
        sb.append(" extent=");
        sb.append(this.f13748h);
        sb.append(",direction:");
        sb.append(this.f13751k ? "vertical" : "horizontal");
        return sb.toString();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
