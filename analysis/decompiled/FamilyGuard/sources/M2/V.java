package M2;

import L2.e;
import android.util.Log;
import i4.InterfaceC0772l;

/* loaded from: classes.dex */
final class V implements K2.s {

    /* renamed from: a, reason: collision with root package name */
    private final e.c f4035a;

    public V(e.c cVar) {
        j4.k.g(cVar, "token");
        this.f4035a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v d(C0378o c0378o, Object obj) {
        j4.k.g(obj, "d");
        L2.e eVar = L2.e.f3817a;
        eVar.g(obj, "setBlurRadius", new Class[]{eVar.l()}, Integer.valueOf((int) c0378o.h()));
        eVar.g(obj, "setColor", new Class[]{eVar.l()}, Integer.valueOf(c0378o.i()));
        eVar.g(obj, "setFrost", new Class[]{eVar.k()}, Float.valueOf(c0378o.f()));
        if (c0378o.g()) {
            eVar.g(obj, "setOverlay", new Class[]{eVar.k()}, Float.valueOf(c0378o.e()));
        } else {
            eVar.g(obj, "setDodge", new Class[]{eVar.k()}, Float.valueOf(c0378o.e()));
        }
        if (c0378o instanceof C) {
            C c6 = (C) c0378o;
            Log.d("MotionKitGradientBlur", "reflect setBlurGradient mode=" + c6.s().d() + " scale=" + c6.u());
            eVar.g(obj, "setBlurGradient", new Class[]{eVar.l(), eVar.l()}, Integer.valueOf(c6.s().d()), Integer.valueOf(c6.u()));
            eVar.g(obj, "setColorGradient", new Class[]{eVar.l(), eVar.l(), eVar.l(), eVar.k(), eVar.l()}, Integer.valueOf(c6.w()), Integer.valueOf(c6.v()), Integer.valueOf(c6.t()), Float.valueOf(c6.r()), Integer.valueOf(C0376m.b(c6)));
        } else {
            eVar.g(obj, "setBlurGradient", new Class[]{eVar.l(), eVar.l()}, 0, 0);
            eVar.g(obj, "setColorGradient", new Class[]{eVar.l(), eVar.l(), eVar.l(), eVar.k(), eVar.l()}, 0, 0, 0, Float.valueOf(0.5f), 0);
        }
        return V3.v.f5542a;
    }

    @Override // K2.s
    public void a() {
        e.c.d(this.f4035a, null, 1, null);
    }

    public void c(K2.E e6) {
        j4.k.g(e6, "params");
        final C0378o c0378o = e6 instanceof C0378o ? (C0378o) e6 : null;
        if (c0378o == null) {
            return;
        }
        this.f4035a.b(new InterfaceC0772l() { // from class: M2.U
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return V.d(c0378o, obj);
            }
        });
    }
}
