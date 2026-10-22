package d2;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.j0;
import d2.i;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class d extends j0 {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends i.c {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c extends i.c {
    }

    @Override // androidx.fragment.app.j0
    public final void a(View view, Object obj) {
        ((i) obj).c(view);
    }

    @Override // androidx.fragment.app.j0
    public final void b(Object obj, ArrayList<View> arrayList) {
        i iVar = (i) obj;
        if (iVar == null) {
            return;
        }
        int i10 = 0;
        if (iVar instanceof n) {
            n nVar = (n) iVar;
            int size = nVar.E.size();
            while (i10 < size) {
                b((i10 < 0 || i10 >= nVar.E.size()) ? null : nVar.E.get(i10), arrayList);
                i10++;
            }
            return;
        }
        if (j0.h(iVar.f8286e) && j0.h(iVar.h)) {
            int size2 = arrayList.size();
            while (i10 < size2) {
                iVar.c(arrayList.get(i10));
                i10++;
            }
        }
    }

    @Override // androidx.fragment.app.j0
    public final void c(ViewGroup viewGroup, Object obj) {
        m.a(viewGroup, (i) obj);
    }

    @Override // androidx.fragment.app.j0
    public final boolean e(Object obj) {
        return obj instanceof i;
    }

    @Override // androidx.fragment.app.j0
    public final Object f(Object obj) {
        if (obj != null) {
            return ((i) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.j0
    public final Object i(Object obj, Object obj2, Object obj3) {
        i iVar = (i) obj;
        i iVar2 = (i) obj2;
        i iVar3 = (i) obj3;
        if (iVar != null && iVar2 != null) {
            n nVar = new n();
            nVar.J(iVar);
            nVar.J(iVar2);
            nVar.F = false;
            iVar = nVar;
        } else if (iVar == null) {
            iVar = iVar2 != null ? iVar2 : null;
        }
        if (iVar3 == null) {
            return iVar;
        }
        n nVar2 = new n();
        if (iVar != null) {
            nVar2.J(iVar);
        }
        nVar2.J(iVar3);
        return nVar2;
    }

    @Override // androidx.fragment.app.j0
    public final Object j(Object obj, Object obj2) {
        n nVar = new n();
        if (obj != null) {
            nVar.J((i) obj);
        }
        nVar.J((i) obj2);
        return nVar;
    }

    @Override // androidx.fragment.app.j0
    public final void k(Object obj, View view, ArrayList<View> arrayList) {
        ((i) obj).b(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.j0
    public final void l(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2) {
        ((i) obj).b(new e(this, obj2, arrayList, obj3, arrayList2));
    }

    @Override // androidx.fragment.app.j0
    public final void m(View view, Object obj) {
        if (view != null) {
            j0.g(view, new Rect());
            ((i) obj).C(new a());
        }
    }

    @Override // androidx.fragment.app.j0
    public final void n(Object obj, Rect rect) {
        ((i) obj).C(new c());
    }

    @Override // androidx.fragment.app.j0
    public final void o(Object obj, r0.c cVar, androidx.fragment.app.j jVar) {
        i iVar = (i) obj;
        cVar.a(new com.stepos.core.ota.downloader.b(iVar, jVar));
        iVar.b(new f(jVar));
    }

    @Override // androidx.fragment.app.j0
    public final void p(Object obj, View view, ArrayList<View> arrayList) {
        n nVar = (n) obj;
        ArrayList<View> arrayList2 = nVar.h;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            j0.d(arrayList2, arrayList.get(i10));
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(nVar, arrayList);
    }

    @Override // androidx.fragment.app.j0
    public final void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        n nVar = (n) obj;
        if (nVar != null) {
            ArrayList<View> arrayList3 = nVar.h;
            arrayList3.clear();
            arrayList3.addAll(arrayList2);
            s(nVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.j0
    public final Object r(Object obj) {
        if (obj == null) {
            return null;
        }
        n nVar = new n();
        nVar.J((i) obj);
        return nVar;
    }

    public final void s(Object obj, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList2) {
        i iVar = (i) obj;
        int i10 = 0;
        if (iVar instanceof n) {
            n nVar = (n) iVar;
            int size = nVar.E.size();
            while (i10 < size) {
                s((i10 < 0 || i10 >= nVar.E.size()) ? null : nVar.E.get(i10), arrayList, arrayList2);
                i10++;
            }
            return;
        }
        if (j0.h(iVar.f8286e)) {
            ArrayList<View> arrayList3 = iVar.h;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                int size2 = arrayList2 == null ? 0 : arrayList2.size();
                while (i10 < size2) {
                    iVar.c(arrayList2.get(i10));
                    i10++;
                }
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    iVar.y(arrayList.get(size3));
                }
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements i.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f8274a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8275b;

        public b(View view, ArrayList arrayList) {
            this.f8274a = view;
            this.f8275b = arrayList;
        }

        @Override // d2.i.d
        public final void a(i iVar) {
            iVar.x(this);
            iVar.b(this);
        }

        @Override // d2.i.d
        public final void c(i iVar) {
            iVar.x(this);
            this.f8274a.setVisibility(8);
            ArrayList arrayList = this.f8275b;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) arrayList.get(i10)).setVisibility(0);
            }
        }

        @Override // d2.i.d
        public final void b() {
        }

        @Override // d2.i.d
        public final void d() {
        }

        @Override // d2.i.d
        public final void e(i iVar) {
        }
    }
}
