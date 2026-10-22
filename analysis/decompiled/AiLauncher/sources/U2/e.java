package U2;

import U2.k;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Property;
import com.google.android.material.R$attr;

/* loaded from: classes2.dex */
public final class e extends l<ObjectAnimator> {

    /* renamed from: k, reason: collision with root package name */
    public static final TimeInterpolator f6211k = E2.a.f2340b;

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f6212l = {0, 1500, 3000, 4500};

    /* renamed from: m, reason: collision with root package name */
    public static final float[] f6213m = {0.1f, 0.87f};

    /* renamed from: n, reason: collision with root package name */
    public static final Property<e, Float> f6214n = new c(Float.class, "animationFraction");

    /* renamed from: o, reason: collision with root package name */
    public static final Property<e, Float> f6215o = new d(Float.class, "completeEndFraction");

    /* renamed from: c, reason: collision with root package name */
    public ObjectAnimator f6216c;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f6217d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f6218e;

    /* renamed from: f, reason: collision with root package name */
    public final U2.b f6219f;

    /* renamed from: g, reason: collision with root package name */
    public int f6220g;

    /* renamed from: h, reason: collision with root package name */
    public float f6221h;

    /* renamed from: i, reason: collision with root package name */
    public float f6222i;

    /* renamed from: j, reason: collision with root package name */
    public q1.b f6223j;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            e eVar = e.this;
            eVar.f6220g = (eVar.f6220g + e.f6212l.length) % e.this.f6219f.f6174e.length;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            e.this.a();
            e eVar = e.this;
            q1.b bVar = eVar.f6223j;
            if (bVar != null) {
                bVar.b(eVar.f6282a);
            }
        }
    }

    public class c extends Property<e, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(e eVar) {
            return Float.valueOf(eVar.p());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, Float f10) {
            eVar.u(f10.floatValue());
        }
    }

    public class d extends Property<e, Float> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(e eVar) {
            return Float.valueOf(eVar.q());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, Float f10) {
            eVar.v(f10.floatValue());
        }
    }

    public e(Context context, f fVar) {
        super(1);
        this.f6220g = 0;
        this.f6223j = null;
        this.f6219f = fVar;
        this.f6218e = T2.h.g(context, R$attr.motionEasingStandardInterpolator, f6211k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p() {
        return this.f6221h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float q() {
        return this.f6222i;
    }

    private void r() {
        if (this.f6216c == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f6214n, 0.0f, 1.0f);
            this.f6216c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration((long) (this.f6219f.f6183n * 6000.0f));
            this.f6216c.setInterpolator(null);
            this.f6216c.setRepeatCount(-1);
            this.f6216c.addListener(new a());
        }
        if (this.f6217d == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f6215o, 0.0f, 1.0f);
            this.f6217d = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration((long) (this.f6219f.f6183n * 500.0f));
            this.f6217d.addListener(new b());
        }
    }

    private void s(int i10) {
        int i11 = 0;
        while (true) {
            int[] iArr = f6212l;
            if (i11 >= iArr.length) {
                return;
            }
            float fB = b(i10, iArr[i11], 100);
            if (fB >= 0.0f && fB <= 1.0f) {
                int i12 = i11 + this.f6220g;
                int[] iArr2 = this.f6219f.f6174e;
                int length = i12 % iArr2.length;
                int length2 = (length + 1) % iArr2.length;
                int i13 = iArr2[length];
                int i14 = iArr2[length2];
                this.f6283b.get(0).f6272c = E2.c.b().evaluate(this.f6218e.getInterpolation(fB), Integer.valueOf(i13), Integer.valueOf(i14)).intValue();
                return;
            }
            i11++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f10) {
        this.f6222i = f10;
    }

    private void w() {
        r();
        this.f6216c.setDuration((long) (this.f6219f.f6183n * 6000.0f));
        this.f6217d.setDuration((long) (this.f6219f.f6183n * 500.0f));
    }

    private void x(int i10) {
        k.a aVar = this.f6283b.get(0);
        float f10 = this.f6221h * 1080.0f;
        float interpolation = 0.0f;
        for (int i11 : f6212l) {
            interpolation += this.f6218e.getInterpolation(b(i10, i11, 500)) * 90.0f;
        }
        aVar.f6276g = f10 + interpolation;
        float interpolation2 = this.f6218e.getInterpolation(b(i10, 0, 3000)) - this.f6218e.getInterpolation(b(i10, 3000, 3000));
        aVar.f6270a = 0.0f;
        float[] fArr = f6213m;
        float fD = S2.a.d(fArr[0], fArr[1], interpolation2);
        aVar.f6271b = fD;
        float f11 = this.f6222i;
        if (f11 > 0.0f) {
            aVar.f6271b = fD * (1.0f - f11);
        }
    }

    @Override // U2.l
    public void a() {
        ObjectAnimator objectAnimator = this.f6216c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // U2.l
    public void c() {
        w();
        t();
    }

    @Override // U2.l
    public void d(q1.b bVar) {
        this.f6223j = bVar;
    }

    @Override // U2.l
    public void f() {
        ObjectAnimator objectAnimator = this.f6217d;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        if (this.f6282a.isVisible()) {
            this.f6217d.start();
        } else {
            a();
        }
    }

    @Override // U2.l
    public void g() {
        r();
        t();
        this.f6216c.start();
    }

    @Override // U2.l
    public void h() {
        this.f6223j = null;
    }

    public void t() {
        this.f6220g = 0;
        this.f6283b.get(0).f6272c = this.f6219f.f6174e[0];
        this.f6222i = 0.0f;
    }

    public void u(float f10) {
        this.f6221h = f10;
        int i10 = (int) (f10 * 6000.0f);
        x(i10);
        s(i10);
        this.f6282a.invalidateSelf();
    }
}
