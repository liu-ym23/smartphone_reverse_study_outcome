package ab;

import a4.t;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Set;
import kb.l;
import m.w;
import p5.u;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends w {

    /* renamed from: h, reason: collision with root package name */
    public u f400h;
    public c i;

    /* renamed from: j, reason: collision with root package name */
    public f f401j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f402k;

    /* renamed from: l, reason: collision with root package name */
    public a f403l;

    /* renamed from: m, reason: collision with root package name */
    public int f404m;

    /* renamed from: n, reason: collision with root package name */
    public t f405n;

    /* renamed from: o, reason: collision with root package name */
    public d f406o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f407p;

    /* renamed from: q, reason: collision with root package name */
    public float f408q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f409r;

    /* renamed from: s, reason: collision with root package name */
    public y9.b f410s;

    /* renamed from: t, reason: collision with root package name */
    public Drawable f411t;

    public final void a() {
        this.i.e();
        this.f401j = null;
        invalidate();
    }

    public final void b() {
        if (this.f407p && isAttachedToWindow() && !this.f402k) {
            this.f402k = true;
            post(this.f405n);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableHotspotChanged(float f5, float f10) {
        Drawable drawable;
        super.drawableHotspotChanged(f5, f10);
        u uVar = this.f400h;
        if (uVar != null && (drawable = (Drawable) uVar.f9808g) != null) {
            drawable.setHotspot(f5, f10);
        }
        Drawable foreground = getForeground();
        if (foreground != null) {
            foreground.setHotspot(f5, f10);
        }
    }

    @Override // m.w, android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        Drawable drawable;
        super.drawableStateChanged();
        u uVar = this.f400h;
        if (uVar == null || (drawable = (Drawable) uVar.f9808g) == null || !drawable.isStateful() || !drawable.setState(((g) uVar.f9807f).getDrawableState())) {
            return;
        }
        invalidate();
    }

    public final Set<String> getGlassActiveIds() {
        return l.O0((Set) this.i.f385d);
    }

    public final float getGlassCornerRadius() {
        return this.f408q;
    }

    public final y9.b getGlassEffect() {
        return this.f410s;
    }

    public final Drawable getSurfaceDrawable() {
        return this.f411t;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        Drawable drawable;
        super.jumpDrawablesToCurrentState();
        u uVar = this.f400h;
        if (uVar == null || (drawable = (Drawable) uVar.f9808g) == null) {
            return;
        }
        drawable.jumpToCurrentState();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) throws Exception {
        configuration.getClass();
        super.onConfigurationChanged(configuration);
        d dVar = this.f406o;
        dVar.getClass();
        boolean z10 = (configuration.uiMode & 48) == 32;
        if (z10 == dVar.f388c) {
            return;
        }
        dVar.f388c = z10;
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j10 = jUptimeMillis - dVar.f389d;
        if (j10 >= 300) {
            dVar.f389d = jUptimeMillis;
            dVar.f387b.invoke();
        } else {
            if (dVar.f390e) {
                return;
            }
            dVar.f390e = true;
            dVar.f386a.postDelayed(dVar.f391f, 300 - j10);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f405n);
        this.f402k = false;
        d dVar = this.f406o;
        dVar.f386a.removeCallbacks(dVar.f391f);
        dVar.f390e = false;
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        u uVar;
        canvas.getClass();
        if (!this.i.f382a && (uVar = this.f400h) != null) {
            Drawable drawable = (Drawable) uVar.f9808g;
            g gVar = (g) uVar.f9807f;
            if (drawable != null) {
                drawable.setBounds(0, 0, gVar.getWidth(), gVar.getHeight());
                drawable.draw(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        Drawable drawable;
        super.onRtlPropertiesChanged(i);
        u uVar = this.f400h;
        if (uVar == null || (drawable = (Drawable) uVar.f9808g) == null) {
            return;
        }
        drawable.setLayoutDirection(i);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i3, int i10, int i11) {
        super.onSizeChanged(i, i3, i10, i11);
        b();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        int i = z10 ? 255 : 77;
        this.f404m = i;
        setImageAlpha(i);
    }

    public final void setGlassCornerRadius(float f5) {
        if (f5 < 0.0f) {
            throw new IllegalArgumentException(("glassCornerRadius must be >= 0 but was " + f5).toString());
        }
        if (this.f408q == f5) {
            return;
        }
        this.f408q = f5;
        a();
        b();
    }

    public final void setGlassCrossWindow(boolean z10) {
        if (this.f409r == z10) {
            return;
        }
        this.f409r = z10;
        a();
        b();
    }

    public final void setGlassEffect(y9.b bVar) {
        bVar.getClass();
        boolean z10 = this.f403l != null;
        this.f403l = null;
        if (!k.a(this.f410s, bVar) || z10) {
            this.f410s = bVar;
            a();
            b();
        }
    }

    public final void setGlassEnabled(boolean z10) {
        if (this.f407p == z10) {
            return;
        }
        this.f407p = z10;
        if (z10) {
            b();
        } else {
            a();
        }
    }

    @Override // m.w, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        setImageAlpha(this.f404m);
    }

    public final void setSurfaceDrawable(Drawable drawable) {
        this.f411t = drawable;
        u uVar = this.f400h;
        if (uVar != null) {
            Drawable drawable2 = (Drawable) uVar.f9808g;
            g gVar = (g) uVar.f9807f;
            if (drawable2 == drawable) {
                drawable = drawable2;
            } else {
                if (drawable2 != null) {
                    drawable2.setCallback(null);
                }
                if (drawable != null) {
                    drawable.setCallback(gVar);
                    drawable.setLayoutDirection(gVar.getLayoutDirection());
                    if (drawable.isStateful()) {
                        drawable.setState(gVar.getDrawableState());
                    }
                    drawable.setVisible(gVar.getVisibility() == 0, true);
                }
                gVar.invalidate();
            }
            uVar.f9808g = drawable;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        drawable.getClass();
        u uVar = this.f400h;
        return (uVar != null && drawable == ((Drawable) uVar.f9808g)) || super.verifyDrawable(drawable);
    }
}
