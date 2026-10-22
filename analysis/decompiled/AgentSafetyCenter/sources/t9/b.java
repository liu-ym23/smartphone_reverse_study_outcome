package t9;

import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends Drawable implements Drawable.Callback {

    /* renamed from: c, reason: collision with root package name */
    public Drawable f13258c;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f13259f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f13260g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f13261h;
    public a i;

    /* renamed from: j, reason: collision with root package name */
    public int f13262j;

    /* renamed from: k, reason: collision with root package name */
    public int f13263k;

    /* renamed from: l, reason: collision with root package name */
    public int f13264l;

    /* renamed from: m, reason: collision with root package name */
    public int f13265m;

    /* renamed from: n, reason: collision with root package name */
    public int f13266n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f13267o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f13268p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13269q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f13270r;

    /* renamed from: s, reason: collision with root package name */
    public int f13271s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f13272t;

    /* renamed from: u, reason: collision with root package name */
    public ColorFilter f13273u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f13274v;

    public final void a() {
        if (this.f13270r || super.mutate() != this) {
            return;
        }
        Drawable drawable = this.f13258c;
        if (drawable != null) {
            drawable.mutate();
        }
        Drawable drawable2 = this.f13259f;
        if (drawable2 != null) {
            drawable2.mutate();
        }
        Drawable drawable3 = this.f13260g;
        if (drawable3 != null) {
            drawable3.mutate();
        }
        Drawable drawable4 = this.f13261h;
        if (drawable4 != null) {
            drawable4.mutate();
        }
        this.f13270r = true;
    }

    public final void b(Drawable drawable) {
        if (drawable != null) {
            if (this.f13270r) {
                drawable.mutate();
            }
            drawable.setState(getState());
            drawable.setCallback(this);
            if (this.f13272t) {
                drawable.setAlpha(this.f13271s);
            }
            if (this.f13274v) {
                drawable.setColorFilter(this.f13273u);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r13) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t9.b.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f13271s;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f13273u;
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
        Drawable drawable = this.f13258c;
        if (drawable != null && drawable.isStateful()) {
            return true;
        }
        Drawable drawable2 = this.f13259f;
        if (drawable2 != null && drawable2.isStateful()) {
            return true;
        }
        Drawable drawable3 = this.f13260g;
        if (drawable3 != null && drawable3.isStateful()) {
            return true;
        }
        Drawable drawable4 = this.f13261h;
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
        this.f13268p = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        Drawable drawable = this.f13258c;
        if (drawable != null) {
            zOnStateChange |= drawable.setState(iArr);
        }
        Drawable drawable2 = this.f13259f;
        if (drawable2 != null) {
            zOnStateChange |= drawable2.setState(iArr);
        }
        Drawable drawable3 = this.f13260g;
        if (drawable3 != null) {
            zOnStateChange |= drawable3.setState(iArr);
        }
        Drawable drawable4 = this.f13261h;
        return drawable4 != null ? drawable4.setState(iArr) | zOnStateChange : zOnStateChange;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f13271s = i;
        this.f13272t = true;
        Drawable drawable = this.f13258c;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        Drawable drawable2 = this.f13259f;
        if (drawable2 != null) {
            drawable2.setAlpha(i);
        }
        Drawable drawable3 = this.f13260g;
        if (drawable3 != null) {
            drawable3.setAlpha(i);
        }
        Drawable drawable4 = this.f13261h;
        if (drawable4 != null) {
            drawable4.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f13273u = colorFilter;
        this.f13274v = true;
        Drawable drawable = this.f13258c;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.f13259f;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
        Drawable drawable3 = this.f13260g;
        if (drawable3 != null) {
            drawable3.setColorFilter(colorFilter);
        }
        Drawable drawable4 = this.f13261h;
        if (drawable4 != null) {
            drawable4.setColorFilter(colorFilter);
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ScrollBarDrawable: range=");
        sb2.append(this.f13262j);
        sb2.append(" offset=");
        sb2.append(this.f13263k);
        sb2.append(" extent=");
        sb2.append(this.f13264l);
        sb2.append(",direction:");
        sb2.append(this.f13267o ? "vertical" : "horizontal");
        return sb2.toString();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
