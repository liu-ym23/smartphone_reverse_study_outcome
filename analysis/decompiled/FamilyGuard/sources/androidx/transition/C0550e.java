package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.c;
import androidx.fragment.app.ComponentCallbacksC0511f;
import androidx.fragment.app.J;
import androidx.transition.k;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.transition.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0550e extends J {

    /* renamed from: androidx.transition.e$a */
    class a extends k.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f11401a;

        a(Rect rect) {
            this.f11401a = rect;
        }
    }

    /* renamed from: androidx.transition.e$b */
    class b implements k.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f11403a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f11404b;

        b(View view, ArrayList arrayList) {
            this.f11403a = view;
            this.f11404b = arrayList;
        }

        @Override // androidx.transition.k.f
        public void a(k kVar) {
            kVar.X(this);
            kVar.b(this);
        }

        @Override // androidx.transition.k.f
        public void b(k kVar) {
        }

        @Override // androidx.transition.k.f
        public void d(k kVar) {
            kVar.X(this);
            this.f11403a.setVisibility(8);
            int size = this.f11404b.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((View) this.f11404b.get(i5)).setVisibility(0);
            }
        }

        @Override // androidx.transition.k.f
        public void e(k kVar) {
        }

        @Override // androidx.transition.k.f
        public void g(k kVar) {
        }
    }

    /* renamed from: androidx.transition.e$c */
    class c extends q {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f11406a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f11407b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f11408c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f11409d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f11410e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f11411f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f11406a = obj;
            this.f11407b = arrayList;
            this.f11408c = obj2;
            this.f11409d = arrayList2;
            this.f11410e = obj3;
            this.f11411f = arrayList3;
        }

        @Override // androidx.transition.q, androidx.transition.k.f
        public void a(k kVar) {
            Object obj = this.f11406a;
            if (obj != null) {
                C0550e.this.x(obj, this.f11407b, null);
            }
            Object obj2 = this.f11408c;
            if (obj2 != null) {
                C0550e.this.x(obj2, this.f11409d, null);
            }
            Object obj3 = this.f11410e;
            if (obj3 != null) {
                C0550e.this.x(obj3, this.f11411f, null);
            }
        }

        @Override // androidx.transition.k.f
        public void d(k kVar) {
            kVar.X(this);
        }
    }

    /* renamed from: androidx.transition.e$d */
    class d implements k.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f11413a;

        d(Runnable runnable) {
            this.f11413a = runnable;
        }

        @Override // androidx.transition.k.f
        public void a(k kVar) {
        }

        @Override // androidx.transition.k.f
        public void b(k kVar) {
        }

        @Override // androidx.transition.k.f
        public void d(k kVar) {
            this.f11413a.run();
        }

        @Override // androidx.transition.k.f
        public void e(k kVar) {
        }

        @Override // androidx.transition.k.f
        public void g(k kVar) {
        }
    }

    /* renamed from: androidx.transition.e$e, reason: collision with other inner class name */
    class C0148e extends k.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f11415a;

        C0148e(Rect rect) {
            this.f11415a = rect;
        }
    }

    public static /* synthetic */ void v(Runnable runnable, k kVar, Runnable runnable2) {
        if (runnable != null) {
            runnable.run();
        } else {
            kVar.cancel();
            runnable2.run();
        }
    }

    private static boolean w(k kVar) {
        return (J.i(kVar.F()) && J.i(kVar.G()) && J.i(kVar.H())) ? false : true;
    }

    @Override // androidx.fragment.app.J
    public void a(Object obj, View view) {
        if (obj != null) {
            ((k) obj).d(view);
        }
    }

    @Override // androidx.fragment.app.J
    public void b(Object obj, ArrayList<View> arrayList) {
        k kVar = (k) obj;
        if (kVar == null) {
            return;
        }
        int i5 = 0;
        if (kVar instanceof t) {
            t tVar = (t) kVar;
            int iP0 = tVar.p0();
            while (i5 < iP0) {
                b(tVar.o0(i5), arrayList);
                i5++;
            }
            return;
        }
        if (w(kVar) || !J.i(kVar.I())) {
            return;
        }
        int size = arrayList.size();
        while (i5 < size) {
            kVar.d(arrayList.get(i5));
            i5++;
        }
    }

    @Override // androidx.fragment.app.J
    public void c(ViewGroup viewGroup, Object obj) {
        r.a(viewGroup, (k) obj);
    }

    @Override // androidx.fragment.app.J
    public boolean e(Object obj) {
        return obj instanceof k;
    }

    @Override // androidx.fragment.app.J
    public Object f(Object obj) {
        if (obj != null) {
            return ((k) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.J
    public Object j(Object obj, Object obj2, Object obj3) {
        k kVarU0 = (k) obj;
        k kVar = (k) obj2;
        k kVar2 = (k) obj3;
        if (kVarU0 != null && kVar != null) {
            kVarU0 = new t().m0(kVarU0).m0(kVar).u0(1);
        } else if (kVarU0 == null) {
            kVarU0 = kVar != null ? kVar : null;
        }
        if (kVar2 == null) {
            return kVarU0;
        }
        t tVar = new t();
        if (kVarU0 != null) {
            tVar.m0(kVarU0);
        }
        tVar.m0(kVar2);
        return tVar;
    }

    @Override // androidx.fragment.app.J
    public Object k(Object obj, Object obj2, Object obj3) {
        t tVar = new t();
        if (obj != null) {
            tVar.m0((k) obj);
        }
        if (obj2 != null) {
            tVar.m0((k) obj2);
        }
        if (obj3 != null) {
            tVar.m0((k) obj3);
        }
        return tVar;
    }

    @Override // androidx.fragment.app.J
    public void m(Object obj, View view, ArrayList<View> arrayList) {
        ((k) obj).b(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.J
    public void n(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((k) obj).b(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.J
    public void o(Object obj, Rect rect) {
        if (obj != null) {
            ((k) obj).d0(new C0148e(rect));
        }
    }

    @Override // androidx.fragment.app.J
    public void p(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            h(view, rect);
            ((k) obj).d0(new a(rect));
        }
    }

    @Override // androidx.fragment.app.J
    public void q(ComponentCallbacksC0511f componentCallbacksC0511f, Object obj, androidx.core.os.c cVar, Runnable runnable) {
        y(componentCallbacksC0511f, obj, cVar, null, runnable);
    }

    @Override // androidx.fragment.app.J
    public void s(Object obj, View view, ArrayList<View> arrayList) {
        t tVar = (t) obj;
        List<View> listI = tVar.I();
        listI.clear();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            J.d(listI, arrayList.get(i5));
        }
        listI.add(view);
        arrayList.add(view);
        b(tVar, arrayList);
    }

    @Override // androidx.fragment.app.J
    public void t(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        t tVar = (t) obj;
        if (tVar != null) {
            tVar.I().clear();
            tVar.I().addAll(arrayList2);
            x(tVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.J
    public Object u(Object obj) {
        if (obj == null) {
            return null;
        }
        t tVar = new t();
        tVar.m0((k) obj);
        return tVar;
    }

    public void x(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        k kVar = (k) obj;
        int i5 = 0;
        if (kVar instanceof t) {
            t tVar = (t) kVar;
            int iP0 = tVar.p0();
            while (i5 < iP0) {
                x(tVar.o0(i5), arrayList, arrayList2);
                i5++;
            }
            return;
        }
        if (w(kVar)) {
            return;
        }
        List<View> listI = kVar.I();
        if (listI.size() == arrayList.size() && listI.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i5 < size) {
                kVar.d(arrayList2.get(i5));
                i5++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                kVar.Y(arrayList.get(size2));
            }
        }
    }

    public void y(ComponentCallbacksC0511f componentCallbacksC0511f, Object obj, androidx.core.os.c cVar, final Runnable runnable, final Runnable runnable2) {
        final k kVar = (k) obj;
        cVar.b(new c.a() { // from class: androidx.transition.d
            @Override // androidx.core.os.c.a
            public final void onCancel() {
                C0550e.v(runnable, kVar, runnable2);
            }
        });
        kVar.b(new d(runnable2));
    }
}
