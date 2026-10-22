package U2;

import U2.b;
import U2.k;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import com.google.android.material.R$attr;
import w0.C5715a;

/* loaded from: classes2.dex */
public final class i<S extends b> extends j {

    /* renamed from: C, reason: collision with root package name */
    public static final androidx.dynamicanimation.animation.f<i<?>> f6234C = new a("indicatorLevel");

    /* renamed from: A, reason: collision with root package name */
    public TimeInterpolator f6235A;

    /* renamed from: B, reason: collision with root package name */
    public TimeInterpolator f6236B;

    /* renamed from: r, reason: collision with root package name */
    public k<S> f6237r;

    /* renamed from: s, reason: collision with root package name */
    public final androidx.dynamicanimation.animation.j f6238s;

    /* renamed from: t, reason: collision with root package name */
    public final androidx.dynamicanimation.animation.i f6239t;

    /* renamed from: u, reason: collision with root package name */
    public final k.a f6240u;

    /* renamed from: v, reason: collision with root package name */
    public float f6241v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f6242w;

    /* renamed from: x, reason: collision with root package name */
    public final ValueAnimator f6243x;

    /* renamed from: y, reason: collision with root package name */
    public ValueAnimator f6244y;

    /* renamed from: z, reason: collision with root package name */
    public TimeInterpolator f6245z;

    public class a extends androidx.dynamicanimation.animation.f<i<?>> {
        public a(String str) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(i<?> iVar) {
            return iVar.D() * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(i<?> iVar, float f10) {
            iVar.J(f10 / 10000.0f);
            iVar.F((int) f10);
        }
    }

    public i(Context context, final b bVar, k<S> kVar) {
        super(context, bVar);
        this.f6242w = false;
        H(kVar);
        k.a aVar = new k.a();
        this.f6240u = aVar;
        aVar.f6277h = true;
        androidx.dynamicanimation.animation.j jVar = new androidx.dynamicanimation.animation.j();
        this.f6238s = jVar;
        jVar.f(1.0f);
        jVar.h(50.0f);
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(this, f6234C);
        this.f6239t = iVar;
        iVar.B(jVar);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f6243x = valueAnimator;
        valueAnimator.setDuration(1000L);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: U2.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                i.v(this.f6232a, bVar, valueAnimator2);
            }
        });
        if (bVar.b(true) && bVar.f6182m != 0) {
            valueAnimator.start();
        }
        p(1.0f);
    }

    public static i<f> A(Context context, f fVar, c cVar) {
        return new i<>(context, fVar, cVar);
    }

    public static /* synthetic */ void v(i iVar, b bVar, ValueAnimator valueAnimator) {
        iVar.getClass();
        if (bVar.b(true) && bVar.f6182m != 0 && iVar.isVisible()) {
            iVar.invalidateSelf();
        }
    }

    public final float B(int i10) {
        float f10 = i10;
        return (f10 < 1000.0f || f10 > 9000.0f) ? 0.0f : 1.0f;
    }

    public k<S> C() {
        return this.f6237r;
    }

    public final float D() {
        return this.f6240u.f6271b;
    }

    public final void E() {
        if (this.f6244y != null) {
            return;
        }
        Context context = this.f6247a;
        int i10 = R$attr.motionEasingStandardInterpolator;
        TimeInterpolator timeInterpolator = E2.a.f2339a;
        this.f6235A = T2.h.g(context, i10, timeInterpolator);
        this.f6236B = T2.h.g(this.f6247a, R$attr.motionEasingEmphasizedAccelerateInterpolator, timeInterpolator);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f6244y = valueAnimator;
        valueAnimator.setDuration(500L);
        this.f6244y.setFloatValues(0.0f, 1.0f);
        this.f6244y.setInterpolator(null);
        this.f6244y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: U2.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                i iVar = this.f6231a;
                iVar.f6240u.f6274e = iVar.f6245z.getInterpolation(iVar.f6244y.getAnimatedFraction());
            }
        });
    }

    public final void F(int i10) {
        if (this.f6248b.b(true)) {
            E();
            float fB = B(i10);
            if (fB == this.f6241v) {
                if (this.f6244y.isRunning()) {
                    return;
                }
                G(fB);
                return;
            }
            if (this.f6244y.isRunning()) {
                this.f6244y.cancel();
            }
            this.f6241v = fB;
            if (fB == 1.0f) {
                this.f6245z = this.f6235A;
                this.f6244y.start();
            } else {
                this.f6245z = this.f6236B;
                this.f6244y.reverse();
            }
        }
    }

    public final void G(float f10) {
        this.f6240u.f6274e = f10;
        invalidateSelf();
    }

    public void H(k<S> kVar) {
        this.f6237r = kVar;
    }

    public void I(boolean z10) {
        if (z10 && !this.f6243x.isRunning()) {
            this.f6243x.start();
        } else {
            if (z10 || !this.f6243x.isRunning()) {
                return;
            }
            this.f6243x.cancel();
        }
    }

    public final void J(float f10) {
        this.f6240u.f6271b = f10;
        invalidateSelf();
    }

    public void K(float f10) {
        setLevel((int) (f10 * 10000.0f));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(this.f6262p)) {
            canvas.save();
            this.f6237r.h(canvas, getBounds(), h(), m(), l());
            this.f6240u.f6275f = i();
            this.f6260n.setStyle(Paint.Style.FILL);
            this.f6260n.setAntiAlias(true);
            k.a aVar = this.f6240u;
            b bVar = this.f6248b;
            aVar.f6272c = bVar.f6174e[0];
            int i10 = bVar.f6178i;
            if (i10 > 0) {
                this.f6237r.d(canvas, this.f6260n, D(), 1.0f, this.f6248b.f6175f, getAlpha(), (int) ((i10 * C5715a.a(D(), 0.0f, 0.01f)) / 0.01f));
            } else {
                this.f6237r.d(canvas, this.f6260n, 0.0f, 1.0f, bVar.f6175f, getAlpha(), 0);
            }
            this.f6237r.c(canvas, this.f6260n, this.f6240u, getAlpha());
            this.f6237r.b(canvas, this.f6260n, this.f6248b.f6174e[0], getAlpha());
            canvas.restore();
        }
    }

    @Override // U2.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f6237r.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f6237r.f();
    }

    @Override // U2.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // U2.j, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // U2.j
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f6239t.C();
        J(getLevel() / 10000.0f);
    }

    @Override // U2.j
    public /* bridge */ /* synthetic */ boolean l() {
        return super.l();
    }

    @Override // U2.j
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // U2.j
    public /* bridge */ /* synthetic */ void o(q1.b bVar) {
        super.o(bVar);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        float fB = B(i10);
        if (!this.f6242w) {
            this.f6239t.q(D() * 10000.0f);
            this.f6239t.w(i10);
            return true;
        }
        this.f6239t.C();
        J(i10 / 10000.0f);
        G(fB);
        return true;
    }

    @Override // U2.j
    public /* bridge */ /* synthetic */ boolean s(boolean z10, boolean z11, boolean z12) {
        return super.s(z10, z11, z12);
    }

    @Override // U2.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    @Override // U2.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // U2.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11);
    }

    @Override // U2.j, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // U2.j, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // U2.j
    public boolean t(boolean z10, boolean z11, boolean z12) {
        boolean zT = super.t(z10, z11, z12);
        float fA = this.f6249c.a(this.f6247a.getContentResolver());
        if (fA == 0.0f) {
            this.f6242w = true;
            return zT;
        }
        this.f6242w = false;
        this.f6238s.h(50.0f / fA);
        return zT;
    }

    @Override // U2.j
    public /* bridge */ /* synthetic */ boolean u(q1.b bVar) {
        return super.u(bVar);
    }
}
