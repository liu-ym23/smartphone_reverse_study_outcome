package p1;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.N;
import java.util.ArrayList;
import java.util.List;
import p1.j;
import x0.d;

/* renamed from: p1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5044e extends N {

    /* renamed from: p1.e$a */
    public class a extends j.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f38119a;

        public a(Rect rect) {
            this.f38119a = rect;
        }
    }

    /* renamed from: p1.e$b */
    public class b implements j.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f38121a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f38122b;

        public b(View view, ArrayList arrayList) {
            this.f38121a = view;
            this.f38122b = arrayList;
        }

        @Override // p1.j.h
        public void c(j jVar) {
        }

        @Override // p1.j.h
        public void e(j jVar) {
            jVar.g0(this);
            jVar.f(this);
        }

        @Override // p1.j.h
        public void f(j jVar) {
            jVar.g0(this);
            this.f38121a.setVisibility(8);
            int size = this.f38122b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f38122b.get(i10)).setVisibility(0);
            }
        }

        @Override // p1.j.h
        public void i(j jVar) {
        }

        @Override // p1.j.h
        public void k(j jVar) {
        }
    }

    /* renamed from: p1.e$c */
    public class c extends q {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f38124a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f38125b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f38126c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f38127d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f38128e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f38129f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f38124a = obj;
            this.f38125b = arrayList;
            this.f38126c = obj2;
            this.f38127d = arrayList2;
            this.f38128e = obj3;
            this.f38129f = arrayList3;
        }

        @Override // p1.q, p1.j.h
        public void e(j jVar) {
            Object obj = this.f38124a;
            if (obj != null) {
                C5044e.this.E(obj, this.f38125b, null);
            }
            Object obj2 = this.f38126c;
            if (obj2 != null) {
                C5044e.this.E(obj2, this.f38127d, null);
            }
            Object obj3 = this.f38128e;
            if (obj3 != null) {
                C5044e.this.E(obj3, this.f38129f, null);
            }
        }

        @Override // p1.q, p1.j.h
        public void f(j jVar) {
            jVar.g0(this);
        }
    }

    /* renamed from: p1.e$d */
    public class d implements j.h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f38131a;

        public d(Runnable runnable) {
            this.f38131a = runnable;
        }

        @Override // p1.j.h
        public void c(j jVar) {
        }

        @Override // p1.j.h
        public void e(j jVar) {
        }

        @Override // p1.j.h
        public void f(j jVar) {
            this.f38131a.run();
        }

        @Override // p1.j.h
        public void i(j jVar) {
        }

        @Override // p1.j.h
        public void k(j jVar) {
        }
    }

    /* renamed from: p1.e$e, reason: collision with other inner class name */
    public class C0494e extends j.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f38133a;

        public C0494e(Rect rect) {
            this.f38133a = rect;
        }
    }

    public static /* synthetic */ void C(Runnable runnable, j jVar, Runnable runnable2) {
        if (runnable != null) {
            runnable.run();
        } else {
            jVar.cancel();
            runnable2.run();
        }
    }

    public static boolean D(j jVar) {
        return (N.l(jVar.K()) && N.l(jVar.L()) && N.l(jVar.M())) ? false : true;
    }

    @Override // androidx.fragment.app.N
    public void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        u uVar = (u) obj;
        if (uVar != null) {
            uVar.N().clear();
            uVar.N().addAll(arrayList2);
            E(uVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.N
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        u uVar = new u();
        uVar.w0((j) obj);
        return uVar;
    }

    public void E(Object obj, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList2) {
        j jVar = (j) obj;
        int i10 = 0;
        if (jVar instanceof u) {
            u uVar = (u) jVar;
            int iZ0 = uVar.z0();
            while (i10 < iZ0) {
                E(uVar.y0(i10), arrayList, arrayList2);
                i10++;
            }
            return;
        }
        if (D(jVar)) {
            return;
        }
        List<View> listN = jVar.N();
        if (listN.size() == arrayList.size() && listN.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i10 < size) {
                jVar.g(arrayList2.get(i10));
                i10++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                jVar.h0(arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.N
    public void a(Object obj, View view) {
        if (obj != null) {
            ((j) obj).g(view);
        }
    }

    @Override // androidx.fragment.app.N
    public void b(Object obj, ArrayList<View> arrayList) {
        j jVar = (j) obj;
        if (jVar == null) {
            return;
        }
        int i10 = 0;
        if (jVar instanceof u) {
            u uVar = (u) jVar;
            int iZ0 = uVar.z0();
            while (i10 < iZ0) {
                b(uVar.y0(i10), arrayList);
                i10++;
            }
            return;
        }
        if (D(jVar) || !N.l(jVar.N())) {
            return;
        }
        int size = arrayList.size();
        while (i10 < size) {
            jVar.g(arrayList.get(i10));
            i10++;
        }
    }

    @Override // androidx.fragment.app.N
    public void c(Object obj) {
        ((t) obj).a();
    }

    @Override // androidx.fragment.app.N
    public void d(Object obj, Runnable runnable) {
        ((t) obj).j(runnable);
    }

    @Override // androidx.fragment.app.N
    public void e(ViewGroup viewGroup, Object obj) {
        r.a(viewGroup, (j) obj);
    }

    @Override // androidx.fragment.app.N
    public boolean g(Object obj) {
        return obj instanceof j;
    }

    @Override // androidx.fragment.app.N
    public Object h(Object obj) {
        if (obj != null) {
            return ((j) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.N
    public Object j(ViewGroup viewGroup, Object obj) {
        return r.b(viewGroup, (j) obj);
    }

    @Override // androidx.fragment.app.N
    public boolean m() {
        return true;
    }

    @Override // androidx.fragment.app.N
    public boolean n(Object obj) {
        boolean zS = ((j) obj).S();
        if (!zS) {
            Log.v("FragmentManager", "Predictive back not available for AndroidX Transition " + obj + ". Please enable seeking support for the designated transition by overriding isSeekingSupported().");
        }
        return zS;
    }

    @Override // androidx.fragment.app.N
    public Object o(Object obj, Object obj2, Object obj3) {
        j jVarF0 = (j) obj;
        j jVar = (j) obj2;
        j jVar2 = (j) obj3;
        if (jVarF0 != null && jVar != null) {
            jVarF0 = new u().w0(jVarF0).w0(jVar).F0(1);
        } else if (jVarF0 == null) {
            jVarF0 = jVar != null ? jVar : null;
        }
        if (jVar2 == null) {
            return jVarF0;
        }
        u uVar = new u();
        if (jVarF0 != null) {
            uVar.w0(jVarF0);
        }
        uVar.w0(jVar2);
        return uVar;
    }

    @Override // androidx.fragment.app.N
    public Object p(Object obj, Object obj2, Object obj3) {
        u uVar = new u();
        if (obj != null) {
            uVar.w0((j) obj);
        }
        if (obj2 != null) {
            uVar.w0((j) obj2);
        }
        if (obj3 != null) {
            uVar.w0((j) obj3);
        }
        return uVar;
    }

    @Override // androidx.fragment.app.N
    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((j) obj).f(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.N
    public void s(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((j) obj).f(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.N
    public void t(Object obj, float f10) {
        t tVar = (t) obj;
        if (tVar.isReady()) {
            long jD = (long) (f10 * tVar.d());
            if (jD == 0) {
                jD = 1;
            }
            if (jD == tVar.d()) {
                jD = tVar.d() - 1;
            }
            tVar.h(jD);
        }
    }

    @Override // androidx.fragment.app.N
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((j) obj).n0(new C0494e(rect));
        }
    }

    @Override // androidx.fragment.app.N
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((j) obj).n0(new a(rect));
        }
    }

    @Override // androidx.fragment.app.N
    public void w(Fragment fragment, Object obj, x0.d dVar, Runnable runnable) {
        x(fragment, obj, dVar, null, runnable);
    }

    @Override // androidx.fragment.app.N
    public void x(Fragment fragment, Object obj, x0.d dVar, final Runnable runnable, final Runnable runnable2) {
        final j jVar = (j) obj;
        dVar.c(new d.a() { // from class: p1.d
            @Override // x0.d.a
            public final void onCancel() {
                C5044e.C(runnable, jVar, runnable2);
            }
        });
        jVar.f(new d(runnable2));
    }

    @Override // androidx.fragment.app.N
    public void z(Object obj, View view, ArrayList<View> arrayList) {
        u uVar = (u) obj;
        List<View> listN = uVar.N();
        listN.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            N.f(listN, arrayList.get(i10));
        }
        listN.add(view);
        arrayList.add(view);
        b(uVar, arrayList);
    }
}
