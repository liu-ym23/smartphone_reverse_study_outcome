package K2;

import K2.D;
import M2.C0374k;
import M2.C0378o;
import M2.M;
import M2.T;
import M2.a0;
import W3.C0403n;
import android.content.Context;
import android.util.Log;
import android.view.View;
import i4.InterfaceC0761a;
import i4.InterfaceC0772l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class A {

    /* renamed from: i, reason: collision with root package name */
    private static final a f3584i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final View f3585a;

    /* renamed from: b, reason: collision with root package name */
    private final List<b<?>> f3586b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3587c;

    /* renamed from: d, reason: collision with root package name */
    private float f3588d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3589e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3590f;

    /* renamed from: g, reason: collision with root package name */
    private i4.p<? super M2.A, ? super Float, V3.v> f3591g;

    /* renamed from: h, reason: collision with root package name */
    private float f3592h;

    private static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    private static final class b<P extends E> {

        /* renamed from: a, reason: collision with root package name */
        private final B<P> f3593a;

        /* renamed from: b, reason: collision with root package name */
        private final P f3594b;

        public b(B<P> b6, P p5) {
            j4.k.g(b6, "capability");
            j4.k.g(p5, "params");
            this.f3593a = b6;
            this.f3594b = p5;
        }

        public final s a(View view, boolean z5, float f5) {
            j4.k.g(view, "view");
            this.f3594b.d(z5);
            this.f3594b.c(f5);
            return this.f3593a.c(view, this.f3594b);
        }

        public final String b() {
            return this.f3593a.getId();
        }

        public final boolean c(View view) {
            j4.k.g(view, "view");
            B<P> b6 = this.f3593a;
            Context context = view.getContext();
            j4.k.f(context, "getContext(...)");
            return b6.a(context);
        }
    }

    public A(View view) {
        j4.k.g(view, "view");
        this.f3585a = view;
        this.f3586b = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v j(o oVar, float f5, C0378o c0378o) {
        j4.k.g(c0378o, "$this$apply");
        oVar.w().invoke(c0378o, Float.valueOf(f5));
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v k(o oVar, float f5, a0 a0Var) {
        j4.k.g(a0Var, "$this$apply");
        oVar.B().invoke(a0Var, Float.valueOf(f5));
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v l(o oVar, float f5, M m5) {
        j4.k.g(m5, "$this$apply");
        oVar.z().invoke(m5, Float.valueOf(f5));
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v m(o oVar, float f5, T t5) {
        j4.k.g(t5, "$this$apply");
        oVar.A().invoke(t5, Float.valueOf(f5));
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v n(o oVar, float f5, C0374k c0374k) {
        j4.k.g(c0374k, "$this$apply");
        oVar.v().invoke(c0374k, Float.valueOf(f5));
        return V3.v.f5542a;
    }

    private final D o() {
        s sVarA;
        ArrayList arrayList = new ArrayList();
        for (b<?> bVar : this.f3586b) {
            if (bVar.c(this.f3585a)) {
                J2.e eVar = J2.e.f3219a;
                try {
                    sVarA = bVar.a(this.f3585a, this.f3587c, this.f3588d);
                } catch (Exception e6) {
                    eVar.a(new J2.f(J2.c.f3213b, "FX operation failed", e6));
                    sVarA = null;
                }
                if (sVarA == null) {
                    Log.w("MotionKitMaterial", "能力 " + bVar.b() + " 绑定失败，静默降级跳过");
                } else {
                    arrayList.add(new D.a(bVar.b(), sVarA));
                }
            } else {
                Log.i("MotionKitMaterial", "能力 " + bVar.b() + " 当前设备不支持，静默降级跳过");
            }
        }
        this.f3586b.clear();
        if (this.f3587c) {
            L2.e.f3817a.q(this.f3585a, this.f3588d);
        } else {
            L2.j.f3840a.A(this.f3585a, this.f3588d);
        }
        if (this.f3587c) {
            L2.e.f3817a.s(this.f3585a, this.f3592h);
        } else {
            L2.j.f3840a.C(this.f3585a, this.f3592h);
        }
        Log.i("MotionKitMaterial", "commit: 完成，生效能力数=" + arrayList.size() + " [" + C0403n.I(arrayList, ",", null, null, 0, null, new InterfaceC0772l() { // from class: K2.z
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return A.p((D.a) obj);
            }
        }, 30, null) + "]");
        return new D(this.f3585a, this.f3587c, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence p(D.a aVar) {
        j4.k.g(aVar, "it");
        return aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final D r(A a6) {
        return a6.o();
    }

    private final void u() {
        if (this.f3590f) {
            String id = F.f3603a.c().getId();
            List<b<?>> list = this.f3586b;
            if (list == null || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (j4.k.b(((b) it.next()).b(), id)) {
                        Log.i("MotionKitMaterial", "commit: 已登记 " + id + "，跳过入口注入(避免绑两份)");
                        return;
                    }
                }
            }
            float f5 = this.f3585a.getResources().getDisplayMetrics().density;
            F f6 = F.f3603a;
            M2.A a6 = (M2.A) f6.c().b();
            i4.p<? super M2.A, ? super Float, V3.v> pVar = this.f3591g;
            if (pVar != null) {
                pVar.invoke(a6, Float.valueOf(f5));
            }
            a6.h(v());
            this.f3586b.add(new b<>(f6.c(), a6));
        }
    }

    private final boolean v() {
        if (this.f3586b.isEmpty()) {
            return false;
        }
        List<b<?>> list = this.f3586b;
        if (list != null && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!j4.k.b(((b) it.next()).b(), F.f3603a.a().getId())) {
                List<b<?>> list2 = this.f3586b;
                if (list2 == null || !list2.isEmpty()) {
                    Iterator<T> it2 = list2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if (j4.k.b(((b) it2.next()).b(), F.f3603a.a().getId())) {
                            Log.w("MotionKitMaterial", "commit: Blend 与其他能力共存，文字走 SDF 玻璃路径（纯混色未启用）");
                            break;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    public final A h(final o oVar) {
        j4.k.g(oVar, "effect");
        final float f5 = this.f3585a.getResources().getDisplayMetrics().density;
        if (!this.f3589e) {
            this.f3588d = oVar.x() * f5;
        }
        F f6 = F.f3603a;
        i(f6.b(), new InterfaceC0772l() { // from class: K2.t
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return A.j(oVar, f5, (C0378o) obj);
            }
        });
        i(f6.f(), new InterfaceC0772l() { // from class: K2.u
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return A.k(oVar, f5, (a0) obj);
            }
        });
        i(f6.d(), new InterfaceC0772l() { // from class: K2.v
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return A.l(oVar, f5, (M) obj);
            }
        });
        i(f6.e(), new InterfaceC0772l() { // from class: K2.w
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return A.m(oVar, f5, (T) obj);
            }
        });
        i(f6.a(), new InterfaceC0772l() { // from class: K2.x
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return A.n(oVar, f5, (C0374k) obj);
            }
        });
        this.f3591g = oVar.y();
        return this;
    }

    public final <P extends E> A i(B<P> b6, InterfaceC0772l<? super P, V3.v> interfaceC0772l) {
        j4.k.g(b6, "capability");
        j4.k.g(interfaceC0772l, "block");
        E eB = b6.b();
        interfaceC0772l.invoke(eB);
        this.f3586b.add(new b<>(b6, eB));
        return this;
    }

    public final D q() {
        u();
        return this.f3587c ? o() : (D) L2.j.f3840a.o(new InterfaceC0761a() { // from class: K2.y
            @Override // i4.InterfaceC0761a
            public final Object invoke() {
                return A.r(this.f3666a);
            }
        });
    }

    public final A s(float f5) {
        this.f3588d = f5;
        this.f3589e = true;
        return this;
    }

    public final A t(boolean z5) {
        this.f3587c = z5;
        return this;
    }
}
