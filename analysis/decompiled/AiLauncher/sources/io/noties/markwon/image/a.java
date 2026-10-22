package io.noties.markwon.image;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

/* loaded from: classes4.dex */
public class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final String f34267a;

    /* renamed from: b, reason: collision with root package name */
    public final b f34268b;

    /* renamed from: c, reason: collision with root package name */
    public final h f34269c;

    /* renamed from: d, reason: collision with root package name */
    public final i f34270d;

    /* renamed from: e, reason: collision with root package name */
    public final Drawable f34271e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f34272f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable.Callback f34273g;

    /* renamed from: h, reason: collision with root package name */
    public int f34274h;

    /* renamed from: i, reason: collision with root package name */
    public float f34275i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f34276j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f34277k = false;

    /* renamed from: io.noties.markwon.image.a$a, reason: collision with other inner class name */
    public class C0418a implements Drawable.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.Callback f34278a;

        public C0418a(Drawable.Callback callback) {
            this.f34278a = callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            this.f34278a.invalidateDrawable(a.this);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            this.f34278a.scheduleDrawable(a.this, runnable, j10);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.f34278a.unscheduleDrawable(a.this, runnable);
        }
    }

    public a(String str, b bVar, i iVar, h hVar) {
        this.f34267a = str;
        this.f34268b = bVar;
        this.f34270d = iVar;
        this.f34269c = hVar;
        Drawable drawableD = bVar.d(this);
        this.f34271e = drawableD;
        if (drawableD != null) {
            o(drawableD);
        }
    }

    public static Rect l(Drawable drawable) {
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            if (!bounds.isEmpty()) {
                return bounds;
            }
            Rect rectB = f.b(drawable);
            if (!rectB.isEmpty()) {
                return rectB;
            }
        }
        return new Rect(0, 0, 1, 1);
    }

    public void a() {
        Drawable drawable = this.f34272f;
        if (drawable != null) {
            drawable.setCallback(null);
            this.f34272f = null;
            setBounds(0, 0, 0, 0);
        }
    }

    public String b() {
        return this.f34267a;
    }

    public h c() {
        return this.f34269c;
    }

    public i d() {
        return this.f34270d;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (h()) {
            this.f34272f.draw(canvas);
        }
    }

    public float e() {
        return this.f34275i;
    }

    public int f() {
        return this.f34274h;
    }

    public Drawable g() {
        return this.f34272f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (h()) {
            return this.f34272f.getIntrinsicHeight();
        }
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (h()) {
            return this.f34272f.getIntrinsicWidth();
        }
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (h()) {
            return this.f34272f.getOpacity();
        }
        return -2;
    }

    public boolean h() {
        return this.f34272f != null;
    }

    public final void i() {
        if (this.f34274h == 0) {
            this.f34276j = true;
            setBounds(l(this.f34272f));
            return;
        }
        this.f34276j = false;
        Rect rectM = m();
        this.f34272f.setBounds(rectM);
        this.f34272f.setCallback(this.f34273g);
        setBounds(rectM);
        invalidateSelf();
    }

    public void j(int i10, float f10) {
        this.f34274h = i10;
        this.f34275i = f10;
        if (this.f34276j) {
            i();
        }
    }

    public boolean k() {
        return getCallback() != null;
    }

    public final Rect m() {
        return this.f34270d.a(this);
    }

    public void n(Drawable.Callback callback) {
        this.f34273g = callback == null ? null : new C0418a(callback);
        super.setCallback(callback);
        if (this.f34273g == null) {
            Drawable drawable = this.f34272f;
            if (drawable != null) {
                drawable.setCallback(null);
                Object obj = this.f34272f;
                if (obj instanceof Animatable) {
                    Animatable animatable = (Animatable) obj;
                    boolean zIsRunning = animatable.isRunning();
                    this.f34277k = zIsRunning;
                    if (zIsRunning) {
                        animatable.stop();
                    }
                }
            }
            this.f34268b.a(this);
            return;
        }
        Drawable drawable2 = this.f34272f;
        if (drawable2 != null && drawable2.getCallback() == null) {
            this.f34272f.setCallback(this.f34273g);
        }
        Drawable drawable3 = this.f34272f;
        boolean z10 = drawable3 == null || drawable3 == this.f34271e;
        if (drawable3 != null) {
            drawable3.setCallback(this.f34273g);
            Object obj2 = this.f34272f;
            if ((obj2 instanceof Animatable) && this.f34277k) {
                ((Animatable) obj2).start();
            }
        }
        if (z10) {
            this.f34268b.b(this);
        }
    }

    public void o(Drawable drawable) {
        Drawable drawable2 = this.f34272f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        Rect bounds = drawable.getBounds();
        if (!bounds.isEmpty()) {
            this.f34272f = drawable;
            drawable.setCallback(this.f34273g);
            setBounds(bounds);
            this.f34276j = false;
            return;
        }
        Rect rectB = f.b(drawable);
        if (rectB.isEmpty()) {
            drawable.setBounds(0, 0, 1, 1);
        } else {
            drawable.setBounds(rectB);
        }
        setBounds(drawable.getBounds());
        p(drawable);
    }

    public void p(Drawable drawable) {
        this.f34277k = false;
        Drawable drawable2 = this.f34272f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f34272f = drawable;
        i();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public String toString() {
        return "AsyncDrawable{destination='" + this.f34267a + "', imageSize=" + this.f34269c + ", result=" + this.f34272f + ", canvasWidth=" + this.f34274h + ", textSize=" + this.f34275i + ", waitingForDimensions=" + this.f34276j + '}';
    }
}
