package j8;

import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    public Drawable f9722a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f9723b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f9724c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f9725d;

    /* renamed from: e, reason: collision with root package name */
    public com.stepos.common.scrollbarview.a f9726e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public int f9727j;

    /* renamed from: k, reason: collision with root package name */
    public int f9728k;

    /* renamed from: l, reason: collision with root package name */
    public int f9729l;

    /* renamed from: m, reason: collision with root package name */
    public int f9730m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f9731n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f9732o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9733p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9734q;
    public int r = 255;

    /* renamed from: s, reason: collision with root package name */
    public boolean f9735s;

    /* renamed from: t, reason: collision with root package name */
    public ColorFilter f9736t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f9737u;

    public a(boolean z, com.stepos.common.scrollbarview.a aVar) {
        this.f9731n = z;
        this.f9726e = aVar;
    }

    public final void a() {
        if (this.f9734q || super.mutate() != this) {
            return;
        }
        Drawable drawable = this.f9722a;
        if (drawable != null) {
            drawable.mutate();
        }
        Drawable drawable2 = this.f9723b;
        if (drawable2 != null) {
            drawable2.mutate();
        }
        Drawable drawable3 = this.f9724c;
        if (drawable3 != null) {
            drawable3.mutate();
        }
        Drawable drawable4 = this.f9725d;
        if (drawable4 != null) {
            drawable4.mutate();
        }
        this.f9734q = true;
    }

    public final void b(Drawable drawable) {
        if (drawable != null) {
            if (this.f9734q) {
                drawable.mutate();
            }
            drawable.setState(getState());
            drawable.setCallback(this);
            if (this.f9735s) {
                drawable.setAlpha(this.r);
            }
            if (this.f9737u) {
                drawable.setColorFilter(this.f9736t);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r13) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j8.a.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f9736t;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f9722a;
        if (drawable != null && drawable.isStateful()) {
            return true;
        }
        Drawable drawable2 = this.f9723b;
        if (drawable2 != null && drawable2.isStateful()) {
            return true;
        }
        Drawable drawable3 = this.f9724c;
        if (drawable3 != null && drawable3.isStateful()) {
            return true;
        }
        Drawable drawable4 = this.f9725d;
        return (drawable4 != null && drawable4.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final /* bridge */ /* synthetic */ Drawable mutate() {
        a();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f9732o = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        Drawable drawable = this.f9722a;
        if (drawable != null) {
            zOnStateChange |= drawable.setState(iArr);
        }
        Drawable drawable2 = this.f9723b;
        if (drawable2 != null) {
            zOnStateChange |= drawable2.setState(iArr);
        }
        Drawable drawable3 = this.f9724c;
        if (drawable3 != null) {
            zOnStateChange |= drawable3.setState(iArr);
        }
        Drawable drawable4 = this.f9725d;
        return drawable4 != null ? drawable4.setState(iArr) | zOnStateChange : zOnStateChange;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        this.r = i10;
        this.f9735s = true;
        Drawable drawable = this.f9722a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        }
        Drawable drawable2 = this.f9723b;
        if (drawable2 != null) {
            drawable2.setAlpha(i10);
        }
        Drawable drawable3 = this.f9724c;
        if (drawable3 != null) {
            drawable3.setAlpha(i10);
        }
        Drawable drawable4 = this.f9725d;
        if (drawable4 != null) {
            drawable4.setAlpha(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f9736t = colorFilter;
        this.f9737u = true;
        Drawable drawable = this.f9722a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.f9723b;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
        Drawable drawable3 = this.f9724c;
        if (drawable3 != null) {
            drawable3.setColorFilter(colorFilter);
        }
        Drawable drawable4 = this.f9725d;
        if (drawable4 != null) {
            drawable4.setColorFilter(colorFilter);
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ScrollBarDrawable: range=");
        sb2.append(this.h);
        sb2.append(" offset=");
        sb2.append(this.f9727j);
        sb2.append(" extent=");
        sb2.append(this.f9728k);
        sb2.append(",direction:");
        sb2.append(this.f9731n ? "vertical" : "horizontal");
        return sb2.toString();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
