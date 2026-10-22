package l2;

import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: l2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0763b extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    public Drawable f13468a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f13469b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f13470c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f13471d;

    /* renamed from: e, reason: collision with root package name */
    public C0762a f13472e;

    /* renamed from: f, reason: collision with root package name */
    public int f13473f;

    /* renamed from: g, reason: collision with root package name */
    public int f13474g;

    /* renamed from: h, reason: collision with root package name */
    public int f13475h;

    /* renamed from: i, reason: collision with root package name */
    public int f13476i;

    /* renamed from: j, reason: collision with root package name */
    public int f13477j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f13478k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f13479l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f13480m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f13481n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f13482o;

    /* renamed from: p, reason: collision with root package name */
    public int f13483p = 255;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13484q;

    /* renamed from: r, reason: collision with root package name */
    public ColorFilter f13485r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f13486s;

    public C0763b(boolean z4, C0762a c0762a) {
        this.f13478k = z4;
        this.f13472e = c0762a;
    }

    public final void a() {
        if (this.f13482o || super.mutate() != this) {
            return;
        }
        Drawable drawable = this.f13468a;
        if (drawable != null) {
            drawable.mutate();
        }
        Drawable drawable2 = this.f13469b;
        if (drawable2 != null) {
            drawable2.mutate();
        }
        Drawable drawable3 = this.f13470c;
        if (drawable3 != null) {
            drawable3.mutate();
        }
        Drawable drawable4 = this.f13471d;
        if (drawable4 != null) {
            drawable4.mutate();
        }
        this.f13482o = true;
    }

    public final void b(Drawable drawable) {
        if (drawable != null) {
            if (this.f13482o) {
                drawable.mutate();
            }
            drawable.setState(getState());
            drawable.setCallback(this);
            if (this.f13484q) {
                drawable.setAlpha(this.f13483p);
            }
            if (this.f13486s) {
                drawable.setColorFilter(this.f13485r);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r13) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.C0763b.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f13483p;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f13485r;
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
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4 = this.f13468a;
        return (drawable4 != null && drawable4.isStateful()) || ((drawable = this.f13469b) != null && drawable.isStateful()) || (((drawable2 = this.f13470c) != null && drawable2.isStateful()) || (((drawable3 = this.f13471d) != null && drawable3.isStateful()) || super.isStateful()));
    }

    @Override // android.graphics.drawable.Drawable
    public final /* bridge */ /* synthetic */ Drawable mutate() {
        a();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f13479l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        Drawable drawable = this.f13468a;
        if (drawable != null) {
            zOnStateChange |= drawable.setState(iArr);
        }
        Drawable drawable2 = this.f13469b;
        if (drawable2 != null) {
            zOnStateChange |= drawable2.setState(iArr);
        }
        Drawable drawable3 = this.f13470c;
        if (drawable3 != null) {
            zOnStateChange |= drawable3.setState(iArr);
        }
        Drawable drawable4 = this.f13471d;
        return drawable4 != null ? zOnStateChange | drawable4.setState(iArr) : zOnStateChange;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j4) {
        scheduleSelf(runnable, j4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        this.f13483p = i4;
        this.f13484q = true;
        Drawable drawable = this.f13468a;
        if (drawable != null) {
            drawable.setAlpha(i4);
        }
        Drawable drawable2 = this.f13469b;
        if (drawable2 != null) {
            drawable2.setAlpha(i4);
        }
        Drawable drawable3 = this.f13470c;
        if (drawable3 != null) {
            drawable3.setAlpha(i4);
        }
        Drawable drawable4 = this.f13471d;
        if (drawable4 != null) {
            drawable4.setAlpha(i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f13485r = colorFilter;
        this.f13486s = true;
        Drawable drawable = this.f13468a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.f13469b;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
        Drawable drawable3 = this.f13470c;
        if (drawable3 != null) {
            drawable3.setColorFilter(colorFilter);
        }
        Drawable drawable4 = this.f13471d;
        if (drawable4 != null) {
            drawable4.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i4, int i5, int i6, int i7) {
        super.setHotspotBounds(i4, i5, i6, i7);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ScrollBarDrawable: range=");
        sb.append(this.f13473f);
        sb.append(" offset=");
        sb.append(this.f13474g);
        sb.append(" extent=");
        sb.append(this.f13475h);
        sb.append(",direction:");
        sb.append(this.f13478k ? "vertical" : "horizontal");
        return sb.toString();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
