package Z4;

import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public final class b extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    public Drawable f1585a;
    public Drawable b;
    public Drawable c;
    public Drawable d;
    public a e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f1586j;
    public final boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o = 255;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public ColorFilter f1587q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1588r;

    public b(boolean z10, a aVar) {
        this.k = z10;
        this.e = aVar;
    }

    public final void a() {
        if (this.n || super.mutate() != this) {
            return;
        }
        Drawable drawable = this.f1585a;
        if (drawable != null) {
            drawable.mutate();
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.mutate();
        }
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            drawable3.mutate();
        }
        Drawable drawable4 = this.d;
        if (drawable4 != null) {
            drawable4.mutate();
        }
        this.n = true;
    }

    public final void b(Drawable drawable) {
        if (drawable != null) {
            if (this.n) {
                drawable.mutate();
            }
            drawable.setState(getState());
            drawable.setCallback(this);
            if (this.p) {
                drawable.setAlpha(this.o);
            }
            if (this.f1588r) {
                drawable.setColorFilter(this.f1587q);
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
        throw new UnsupportedOperationException("Method not decompiled: Z4.b.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f1587q;
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
        Drawable drawable = this.f1585a;
        if (drawable != null && drawable.isStateful()) {
            return true;
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null && drawable2.isStateful()) {
            return true;
        }
        Drawable drawable3 = this.c;
        if (drawable3 != null && drawable3.isStateful()) {
            return true;
        }
        Drawable drawable4 = this.d;
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
        this.l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        Drawable drawable = this.f1585a;
        if (drawable != null) {
            zOnStateChange |= drawable.setState(iArr);
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            zOnStateChange |= drawable2.setState(iArr);
        }
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            zOnStateChange |= drawable3.setState(iArr);
        }
        Drawable drawable4 = this.d;
        return drawable4 != null ? drawable4.setState(iArr) | zOnStateChange : zOnStateChange;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        scheduleSelf(runnable, j5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.o = i;
        this.p = true;
        Drawable drawable = this.f1585a;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.setAlpha(i);
        }
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            drawable3.setAlpha(i);
        }
        Drawable drawable4 = this.d;
        if (drawable4 != null) {
            drawable4.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f1587q = colorFilter;
        this.f1588r = true;
        Drawable drawable = this.f1585a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
        Drawable drawable3 = this.c;
        if (drawable3 != null) {
            drawable3.setColorFilter(colorFilter);
        }
        Drawable drawable4 = this.d;
        if (drawable4 != null) {
            drawable4.setColorFilter(colorFilter);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ScrollBarDrawable: range=");
        sb.append(this.f);
        sb.append(" offset=");
        sb.append(this.g);
        sb.append(" extent=");
        sb.append(this.h);
        sb.append(",direction:");
        sb.append(this.k ? "vertical" : "horizontal");
        return sb.toString();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
