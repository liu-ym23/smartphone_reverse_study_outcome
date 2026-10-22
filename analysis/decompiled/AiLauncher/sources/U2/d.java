package U2;

import U2.k;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;

/* loaded from: classes2.dex */
public final class d extends l<ObjectAnimator> {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f6196k = {0, 1350, 2700, 4050};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f6197l = {667, 2017, 3367, 4717};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f6198m = {1000, 2350, 3700, 5050};

    /* renamed from: n, reason: collision with root package name */
    public static final Property<d, Float> f6199n = new c(Float.class, "animationFraction");

    /* renamed from: o, reason: collision with root package name */
    public static final Property<d, Float> f6200o = new C0106d(Float.class, "completeEndFraction");

    /* renamed from: c, reason: collision with root package name */
    public ObjectAnimator f6201c;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f6202d;

    /* renamed from: e, reason: collision with root package name */
    public final T0.b f6203e;

    /* renamed from: f, reason: collision with root package name */
    public final U2.b f6204f;

    /* renamed from: g, reason: collision with root package name */
    public int f6205g;

    /* renamed from: h, reason: collision with root package name */
    public float f6206h;

    /* renamed from: i, reason: collision with root package name */
    public float f6207i;

    /* renamed from: j, reason: collision with root package name */
    public q1.b f6208j;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            d dVar = d.this;
            dVar.f6205g = (dVar.f6205g + 4) % d.this.f6204f.f6174e.length;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            d.this.a();
            d dVar = d.this;
            q1.b bVar = dVar.f6208j;
            if (bVar != null) {
                bVar.b(dVar.f6282a);
            }
        }
    }

    public class c extends Property<d, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.o());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f10) {
            dVar.t(f10.floatValue());
        }
    }

    /* renamed from: U2.d$d, reason: collision with other inner class name */
    public class C0106d extends Property<d, Float> {
        public C0106d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.p());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f10) {
            dVar.u(f10.floatValue());
        }
    }

    public d(f fVar) {
        super(1);
        this.f6205g = 0;
        this.f6208j = null;
        this.f6204f = fVar;
        this.f6203e = new T0.b();
    }

    @Override // U2.l
    public void a() {
        ObjectAnimator objectAnimator = this.f6201c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // U2.l
    public void c() {
        v();
        s();
    }

    @Override // U2.l
    public void d(q1.b bVar) {
        this.f6208j = bVar;
    }

    @Override // U2.l
    public void f() {
        ObjectAnimator objectAnimator = this.f6202d;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        if (this.f6282a.isVisible()) {
            this.f6202d.start();
        } else {
            a();
        }
    }

    @Override // U2.l
    public void g() {
        q();
        s();
        this.f6201c.start();
    }

    @Override // U2.l
    public void h() {
        this.f6208j = null;
    }

    public final float o() {
        return this.f6206h;
    }

    public final float p() {
        return this.f6207i;
    }

    public final void q() {
        if (this.f6201c == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f6199n, 0.0f, 1.0f);
            this.f6201c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration((long) (this.f6204f.f6183n * 5400.0f));
            this.f6201c.setInterpolator(null);
            this.f6201c.setRepeatCount(-1);
            this.f6201c.addListener(new a());
        }
        if (this.f6202d == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f6200o, 0.0f, 1.0f);
            this.f6202d = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration((long) (this.f6204f.f6183n * 333.0f));
            this.f6202d.setInterpolator(this.f6203e);
            this.f6202d.addListener(new b());
        }
    }

    public final void r(int i10) {
        for (int i11 = 0; i11 < 4; i11++) {
            float fB = b(i10, f6198m[i11], 333);
            if (fB > 0.0f && fB < 1.0f) {
                int i12 = i11 + this.f6205g;
                int[] iArr = this.f6204f.f6174e;
                int length = i12 % iArr.length;
                int length2 = (length + 1) % iArr.length;
                int i13 = iArr[length];
                int i14 = iArr[length2];
                this.f6283b.get(0).f6272c = E2.c.b().evaluate(this.f6203e.getInterpolation(fB), Integer.valueOf(i13), Integer.valueOf(i14)).intValue();
                return;
            }
        }
    }

    public void s() {
        this.f6205g = 0;
        this.f6283b.get(0).f6272c = this.f6204f.f6174e[0];
        this.f6207i = 0.0f;
    }

    public void t(float f10) {
        this.f6206h = f10;
        int i10 = (int) (f10 * 5400.0f);
        w(i10);
        r(i10);
        this.f6282a.invalidateSelf();
    }

    public final void u(float f10) {
        this.f6207i = f10;
    }

    public final void v() {
        q();
        this.f6201c.setDuration((long) (this.f6204f.f6183n * 5400.0f));
        this.f6202d.setDuration((long) (this.f6204f.f6183n * 333.0f));
    }

    public final void w(int i10) {
        k.a aVar = this.f6283b.get(0);
        float f10 = this.f6206h;
        aVar.f6270a = (f10 * 1520.0f) - 20.0f;
        aVar.f6271b = f10 * 1520.0f;
        for (int i11 = 0; i11 < 4; i11++) {
            aVar.f6271b += this.f6203e.getInterpolation(b(i10, f6196k[i11], 667)) * 250.0f;
            aVar.f6270a += this.f6203e.getInterpolation(b(i10, f6197l[i11], 667)) * 250.0f;
        }
        float f11 = aVar.f6270a;
        float f12 = aVar.f6271b;
        aVar.f6270a = (f11 + ((f12 - f11) * this.f6207i)) / 360.0f;
        aVar.f6271b = f12 / 360.0f;
    }
}
