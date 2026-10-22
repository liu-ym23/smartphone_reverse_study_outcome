package x5;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import f6.f;
import java.util.ArrayList;
import t.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: c, reason: collision with root package name */
    public f f15574c;

    /* renamed from: f, reason: collision with root package name */
    public int f15575f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15576g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f15577h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f15578j;

    /* renamed from: k, reason: collision with root package name */
    public long f15579k;

    /* renamed from: l, reason: collision with root package name */
    public int f15580l;

    /* renamed from: m, reason: collision with root package name */
    public int f15581m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f15582n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f15583o;

    public final int a(Integer num, Integer num2) {
        if (num != null && num.intValue() == -1) {
            return -1;
        }
        if (num2 != null && num2.intValue() == -1) {
            return -1;
        }
        return Math.max(num != null ? num.intValue() : -1, num2 != null ? num2.intValue() : -1);
    }

    public final void b() {
        this.f15581m = 2;
        this.f15582n = null;
        ArrayList arrayList = this.f15577h;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ColorStateList colorStateList = ((w6.a) arrayList.get(i)).f15268b.f15279s;
            if (colorStateList != null) {
                setTintList(colorStateList);
            }
        }
    }

    public final void c(Drawable drawable, Rect rect) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(rect);
            return;
        }
        int iWidth = rect.width();
        int iHeight = rect.height();
        double dF = c1.f(intrinsicWidth, intrinsicHeight, iWidth, iHeight, this.f15574c);
        double d7 = 2;
        int iP = ac.a.P((iWidth - (intrinsicWidth * dF)) / d7);
        int iP2 = ac.a.P((iHeight - (dF * intrinsicHeight)) / d7);
        drawable.setBounds(rect.left + iP, rect.top + iP2, rect.right - iP, rect.bottom - iP2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int iSave;
        Drawable drawable;
        Drawable drawable2 = this.f15583o;
        int i = this.f15581m;
        if (i == 0) {
            Drawable drawable3 = this.f15582n;
            if (drawable3 != null) {
                drawable3.setAlpha(this.f15580l);
                iSave = canvas.save();
                try {
                    drawable3.draw(canvas);
                    return;
                } finally {
                }
            }
            return;
        }
        if (i == 2) {
            if (drawable2 != null) {
                drawable2.setAlpha(this.f15580l);
                iSave = canvas.save();
                try {
                    drawable2.draw(canvas);
                    return;
                } finally {
                }
            }
            return;
        }
        double dUptimeMillis = (SystemClock.uptimeMillis() - this.f15579k) / this.f15575f;
        double dO = p5.f.o(dUptimeMillis, 0.0d, 1.0d);
        int i3 = this.f15580l;
        int i10 = (int) (dO * i3);
        if (this.f15576g) {
            i3 -= i10;
        }
        boolean z10 = dUptimeMillis >= 1.0d;
        if (!z10 && (drawable = this.f15582n) != null) {
            drawable.setAlpha(i3);
            iSave = canvas.save();
            try {
                drawable.draw(canvas);
            } finally {
            }
        }
        if (drawable2 != null) {
            drawable2.setAlpha(i10);
            iSave = canvas.save();
            try {
                drawable2.draw(canvas);
            } finally {
            }
        }
        if (z10) {
            b();
        } else {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f15580l;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        ColorFilter colorFilter;
        Drawable drawable = this.f15583o;
        int i = this.f15581m;
        if (i == 0) {
            Drawable drawable2 = this.f15582n;
            if (drawable2 != null) {
                return drawable2.getColorFilter();
            }
            return null;
        }
        if (i != 1) {
            if (i == 2 && drawable != null) {
                return drawable.getColorFilter();
            }
            return null;
        }
        if (drawable != null && (colorFilter = drawable.getColorFilter()) != null) {
            return colorFilter;
        }
        Drawable drawable3 = this.f15582n;
        if (drawable3 != null) {
            return drawable3.getColorFilter();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f15578j;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f15582n;
        Drawable drawable2 = this.f15583o;
        int i = this.f15581m;
        if (i == 0) {
            if (drawable != null) {
                return drawable.getOpacity();
            }
            return -2;
        }
        if (i == 2) {
            if (drawable2 != null) {
                return drawable2.getOpacity();
            }
            return -2;
        }
        if (drawable != null && drawable2 != null) {
            return Drawable.resolveOpacity(drawable.getOpacity(), drawable2.getOpacity());
        }
        if (drawable != null) {
            return drawable.getOpacity();
        }
        if (drawable2 != null) {
            return drawable2.getOpacity();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f15581m == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f15582n;
        if (drawable != null) {
            c(drawable, rect);
        }
        Drawable drawable2 = this.f15583o;
        if (drawable2 != null) {
            c(drawable2, rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.f15582n;
        boolean level = drawable != null ? drawable.setLevel(i) : false;
        Drawable drawable2 = this.f15583o;
        return level || (drawable2 != null ? drawable2.setLevel(i) : false);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f15582n;
        boolean state = drawable != null ? drawable.setState(iArr) : false;
        Drawable drawable2 = this.f15583o;
        return state || (drawable2 != null ? drawable2.setState(iArr) : false);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        scheduleSelf(runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (i < 0 || i >= 256) {
            od.f.c(k0.a.j(i, "Invalid alpha: "));
        } else {
            this.f15580l = i;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f15582n;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.f15583o;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.f15582n;
        if (drawable != null) {
            drawable.setTint(i);
        }
        Drawable drawable2 = this.f15583o;
        if (drawable2 != null) {
            drawable2.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintBlendMode(BlendMode blendMode) {
        Drawable drawable = this.f15582n;
        if (drawable != null) {
            drawable.setTintBlendMode(blendMode);
        }
        Drawable drawable2 = this.f15583o;
        if (drawable2 != null) {
            drawable2.setTintBlendMode(blendMode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f15582n;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
        Drawable drawable2 = this.f15583o;
        if (drawable2 != null) {
            drawable2.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f15582n;
        if (drawable != null) {
            drawable.setTintMode(mode);
        }
        Drawable drawable2 = this.f15583o;
        if (drawable2 != null) {
            drawable2.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Object obj = this.f15582n;
        Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
        if (animatable != null) {
            animatable.start();
        }
        Object obj2 = this.f15583o;
        Animatable animatable2 = obj2 instanceof Animatable ? (Animatable) obj2 : null;
        if (animatable2 != null) {
            animatable2.start();
        }
        if (this.f15581m != 0) {
            return;
        }
        this.f15581m = 1;
        this.f15579k = SystemClock.uptimeMillis();
        ArrayList arrayList = this.f15577h;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((w6.a) arrayList.get(i)).a(this);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Object obj = this.f15582n;
        Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
        if (animatable != null) {
            animatable.stop();
        }
        Object obj2 = this.f15583o;
        Animatable animatable2 = obj2 instanceof Animatable ? (Animatable) obj2 : null;
        if (animatable2 != null) {
            animatable2.stop();
        }
        if (this.f15581m != 2) {
            b();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
