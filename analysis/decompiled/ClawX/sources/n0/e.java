package n0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.Choreographer;
import androidx.emoji2.text.p;
import java.util.ArrayList;
import k4.v;
import t1.x;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: m, reason: collision with root package name */
    public static final d f3948m = new d(1);

    /* renamed from: n, reason: collision with root package name */
    public static final d f3949n = new d(2);

    /* renamed from: o, reason: collision with root package name */
    public static final d f3950o = new d(3);

    /* renamed from: p, reason: collision with root package name */
    public static final d f3951p = new d(4);

    /* renamed from: q, reason: collision with root package name */
    public static final d f3952q = new d(5);

    /* renamed from: r, reason: collision with root package name */
    public static final d f3953r = new d(0);

    /* renamed from: c, reason: collision with root package name */
    public final x f3956c;
    public final v d;

    /* renamed from: g, reason: collision with root package name */
    public final float f3959g;

    /* renamed from: j, reason: collision with root package name */
    public f f3962j;

    /* renamed from: k, reason: collision with root package name */
    public float f3963k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3964l;

    /* renamed from: a, reason: collision with root package name */
    public float f3954a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    public float f3955b = Float.MAX_VALUE;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3957e = false;

    /* renamed from: f, reason: collision with root package name */
    public long f3958f = 0;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f3960h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f3961i = new ArrayList();

    public e(x xVar, v vVar) {
        this.f3956c = xVar;
        this.d = vVar;
        if (vVar == f3950o || vVar == f3951p || vVar == f3952q) {
            this.f3959g = 0.1f;
        } else if (vVar == f3953r) {
            this.f3959g = 0.00390625f;
        } else if (vVar == f3948m || vVar == f3949n) {
            this.f3959g = 0.002f;
        } else {
            this.f3959g = 1.0f;
        }
        this.f3962j = null;
        this.f3963k = Float.MAX_VALUE;
        this.f3964l = false;
    }

    public static c b() {
        ThreadLocal threadLocal = c.f3939i;
        if (threadLocal.get() == null) {
            threadLocal.set(new c(new p(11)));
        }
        return (c) threadLocal.get();
    }

    /* JADX WARN: Type inference failed for: r1v19, types: [java.lang.Object, n0.a] */
    public final void a(float f3) {
        if (this.f3957e) {
            this.f3963k = f3;
            return;
        }
        if (this.f3962j == null) {
            this.f3962j = new f(f3);
        }
        f fVar = this.f3962j;
        double d = f3;
        fVar.f3972i = d;
        double d9 = (float) d;
        if (d9 > Float.MAX_VALUE) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (d9 < -3.4028235E38f) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
        double dAbs = Math.abs(this.f3959g * 0.75f);
        fVar.d = dAbs;
        fVar.f3968e = dAbs * 62.5d;
        p pVar = b().f3943e;
        pVar.getClass();
        if (Thread.currentThread() != ((Looper) pVar.f624c).getThread()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        boolean z = this.f3957e;
        if (z || z) {
            return;
        }
        this.f3957e = true;
        float fR = this.d.R(this.f3956c);
        this.f3955b = fR;
        if (fR > Float.MAX_VALUE || fR < -3.4028235E38f) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        c cVarB = b();
        ArrayList arrayList = cVarB.f3941b;
        if (arrayList.size() == 0) {
            ((Choreographer) cVarB.f3943e.f623b).postFrameCallback(new b(cVarB.d, 0));
            if (Build.VERSION.SDK_INT >= 33) {
                cVarB.f3945g = ValueAnimator.getDurationScale();
                if (cVarB.f3946h == null) {
                    cVarB.f3946h = new p(10, cVarB);
                }
                final p pVar2 = cVarB.f3946h;
                if (((a) pVar2.f623b) == null) {
                    ?? r12 = new ValueAnimator.DurationScaleChangeListener() { // from class: n0.a
                        @Override // android.animation.ValueAnimator.DurationScaleChangeListener
                        public final void onChanged(float f7) {
                            ((c) pVar2.f624c).f3945g = f7;
                        }
                    };
                    pVar2.f623b = r12;
                    ValueAnimator.registerDurationScaleChangeListener(r12);
                }
            }
        }
        if (arrayList.contains(this)) {
            return;
        }
        arrayList.add(this);
    }

    public final void c(float f3) {
        this.d.l0(this.f3956c, f3);
        int i8 = 0;
        while (true) {
            ArrayList arrayList = this.f3961i;
            if (i8 >= arrayList.size()) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (arrayList.get(size) == null) {
                        arrayList.remove(size);
                    }
                }
                return;
            }
            if (arrayList.get(i8) != null) {
                arrayList.get(i8).getClass();
                throw new ClassCastException();
            }
            i8++;
        }
    }

    public final void d() {
        if (this.f3962j.f3966b <= 0.0d) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        p pVar = b().f3943e;
        pVar.getClass();
        if (Thread.currentThread() != ((Looper) pVar.f624c).getThread()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        if (this.f3957e) {
            this.f3964l = true;
        }
    }
}
