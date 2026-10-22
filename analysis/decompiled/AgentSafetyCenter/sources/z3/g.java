package z3;

import android.animation.ValueAnimator;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.Choreographer;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import p.p0;
import p5.u;
import t.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: n, reason: collision with root package name */
    public static final c f16352n = new c(1);

    /* renamed from: o, reason: collision with root package name */
    public static final c f16353o = new c(2);

    /* renamed from: p, reason: collision with root package name */
    public static final c f16354p = new c(3);

    /* renamed from: q, reason: collision with root package name */
    public static final c f16355q = new c(4);

    /* renamed from: r, reason: collision with root package name */
    public static final c f16356r = new c(5);

    /* renamed from: s, reason: collision with root package name */
    public static final c f16357s = new c(6);

    /* renamed from: t, reason: collision with root package name */
    public static final c f16358t = new c(7);

    /* renamed from: u, reason: collision with root package name */
    public static final c f16359u = new c(0);

    /* renamed from: a, reason: collision with root package name */
    public float f16360a;

    /* renamed from: b, reason: collision with root package name */
    public float f16361b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16362c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f16363d;

    /* renamed from: e, reason: collision with root package name */
    public final c1 f16364e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16365f;

    /* renamed from: g, reason: collision with root package name */
    public long f16366g;

    /* renamed from: h, reason: collision with root package name */
    public float f16367h;
    public final ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f16368j;

    /* renamed from: k, reason: collision with root package name */
    public h f16369k;

    /* renamed from: l, reason: collision with root package name */
    public float f16370l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f16371m;

    public g(Object obj, c1 c1Var) {
        this.f16360a = 0.0f;
        this.f16361b = Float.MAX_VALUE;
        this.f16362c = false;
        this.f16365f = false;
        this.f16366g = 0L;
        this.i = new ArrayList();
        this.f16368j = new ArrayList();
        this.f16363d = obj;
        this.f16364e = c1Var;
        if (c1Var == f16356r || c1Var == f16357s || c1Var == f16358t) {
            this.f16367h = 0.1f;
        } else if (c1Var == f16359u) {
            this.f16367h = 0.00390625f;
        } else if (c1Var == f16354p || c1Var == f16355q) {
            this.f16367h = 0.002f;
        } else {
            this.f16367h = 1.0f;
        }
        this.f16369k = null;
        this.f16370l = Float.MAX_VALUE;
        this.f16371m = false;
    }

    public static b d() {
        ThreadLocal threadLocal = b.i;
        if (threadLocal.get() == null) {
            n6.a aVar = new n6.a();
            aVar.f8776c = Choreographer.getInstance();
            aVar.f8777f = Looper.myLooper();
            VarHandle.storeStoreFence();
            b bVar = new b();
            bVar.f16342a = new p0(0);
            bVar.f16343b = new ArrayList();
            sa.c cVar = new sa.c(16, false);
            cVar.f12170f = bVar;
            VarHandle.storeStoreFence();
            bVar.f16344c = cVar;
            y0.a aVar2 = new y0.a(1);
            aVar2.f15846f = bVar;
            VarHandle.storeStoreFence();
            bVar.f16345d = aVar2;
            bVar.f16347f = false;
            bVar.f16348g = 1.0f;
            bVar.f16346e = aVar;
            VarHandle.storeStoreFence();
            threadLocal.set(bVar);
        }
        return (b) threadLocal.get();
    }

    public final void a(f fVar) {
        if (this.f16365f) {
            g5.f.o("Error: Update listeners must be added beforethe animation.");
            return;
        }
        ArrayList arrayList = this.f16368j;
        if (arrayList.contains(fVar)) {
            return;
        }
        arrayList.add(fVar);
    }

    public final void b() {
        if (!d().a()) {
            throw new AndroidRuntimeException("Animations may only be canceled from the same thread as the animation handler");
        }
        if (this.f16365f) {
            c(true);
        }
        float f5 = this.f16370l;
        if (f5 != Float.MAX_VALUE) {
            h hVar = this.f16369k;
            if (hVar == null) {
                this.f16369k = new h(f5);
            } else {
                hVar.i = f5;
            }
            this.f16370l = Float.MAX_VALUE;
        }
    }

    public final void c(boolean z10) {
        ArrayList arrayList;
        int i = 0;
        this.f16365f = false;
        b bVarD = d();
        bVarD.f16342a.remove(this);
        ArrayList arrayList2 = bVarD.f16343b;
        int iIndexOf = arrayList2.indexOf(this);
        if (iIndexOf >= 0) {
            arrayList2.set(iIndexOf, null);
            bVarD.f16347f = true;
        }
        this.f16366g = 0L;
        this.f16362c = false;
        while (true) {
            arrayList = this.i;
            if (i >= arrayList.size()) {
                break;
            }
            if (arrayList.get(i) != null) {
                ((e) arrayList.get(i)).a(z10);
            }
            i++;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public final void e(float f5) {
        ArrayList arrayList;
        this.f16364e.m(f5, this.f16363d);
        int i = 0;
        while (true) {
            arrayList = this.f16368j;
            if (i >= arrayList.size()) {
                break;
            }
            if (arrayList.get(i) != null) {
                ((f) arrayList.get(i)).a(this.f16361b);
            }
            i++;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public final void f() {
        if (this.f16369k.f16373b <= 0.0d) {
            g5.f.o("Spring animations can only come to an end when there is damping");
        } else {
            if (!d().a()) {
                throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
            }
            if (this.f16365f) {
                this.f16371m = true;
            }
        }
    }

    public final void g() {
        h hVar = this.f16369k;
        if (hVar == null) {
            g5.f.o("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
            return;
        }
        double d7 = (float) hVar.i;
        if (d7 > Float.MAX_VALUE) {
            g5.f.o("Final position of the spring cannot be greater than the max value.");
            return;
        }
        if (d7 < -3.4028235E38f) {
            g5.f.o("Final position of the spring cannot be less than the min value.");
            return;
        }
        double dAbs = Math.abs(this.f16367h * 0.75f);
        hVar.f16375d = dAbs;
        hVar.f16376e = dAbs * 62.5d;
        if (!d().a()) {
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        boolean z10 = this.f16365f;
        if (z10 || z10) {
            return;
        }
        int i = 1;
        this.f16365f = true;
        if (!this.f16362c) {
            this.f16361b = this.f16364e.i(this.f16363d);
        }
        float f5 = this.f16361b;
        if (f5 > Float.MAX_VALUE || f5 < -3.4028235E38f) {
            g5.f.s("Starting value need to be in between min value and max value");
            return;
        }
        b bVarD = d();
        ArrayList arrayList = bVarD.f16343b;
        if (arrayList.size() == 0) {
            n6.a aVar = bVarD.f16346e;
            y0.a aVar2 = bVarD.f16345d;
            Choreographer choreographer = (Choreographer) aVar.f8776c;
            m4.g gVar = new m4.g(i);
            gVar.f8227f = aVar2;
            VarHandle.storeStoreFence();
            choreographer.postFrameCallback(gVar);
            bVarD.f16348g = ValueAnimator.getDurationScale();
            if (bVarD.f16349h == null) {
                u uVar = new u(12);
                uVar.f9808g = bVarD;
                VarHandle.storeStoreFence();
                bVarD.f16349h = uVar;
            }
            u uVar2 = bVarD.f16349h;
            if (((a) uVar2.f9807f) == null) {
                a aVar3 = new a();
                aVar3.f16341a = uVar2;
                VarHandle.storeStoreFence();
                uVar2.f9807f = aVar3;
                ValueAnimator.registerDurationScaleChangeListener(aVar3);
            }
        }
        if (arrayList.contains(this)) {
            return;
        }
        arrayList.add(this);
    }

    public g(w.d dVar) {
        this.f16360a = 0.0f;
        this.f16361b = Float.MAX_VALUE;
        this.f16362c = false;
        this.f16365f = false;
        this.f16366g = 0L;
        this.i = new ArrayList();
        this.f16368j = new ArrayList();
        this.f16363d = null;
        d dVar2 = new d();
        dVar2.f16351a = dVar;
        VarHandle.storeStoreFence();
        this.f16364e = dVar2;
        this.f16367h = 1.0f;
        this.f16369k = null;
        this.f16370l = Float.MAX_VALUE;
        this.f16371m = false;
    }
}
