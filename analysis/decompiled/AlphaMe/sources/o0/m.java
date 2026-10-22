package o0;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.m0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class m extends m0 {
    @Override // androidx.fragment.app.m0
    public final void a(View view, Object obj) {
        ((s) obj).b(view);
    }

    @Override // androidx.fragment.app.m0
    public final void b(Object obj, ArrayList arrayList) {
        s sVar = (s) obj;
        if (sVar == null) {
            return;
        }
        int i4 = 0;
        if (sVar instanceof y) {
            y yVar = (y) sVar;
            int size = yVar.f13776B.size();
            while (i4 < size) {
                b((i4 < 0 || i4 >= yVar.f13776B.size()) ? null : (s) yVar.f13776B.get(i4), arrayList);
                i4++;
            }
            return;
        }
        if (m0.h(sVar.f13747e) && m0.h(null) && m0.h(null) && m0.h(sVar.f13748f)) {
            int size2 = arrayList.size();
            while (i4 < size2) {
                sVar.b((View) arrayList.get(i4));
                i4++;
            }
        }
    }

    @Override // androidx.fragment.app.m0
    public final void c(ViewGroup viewGroup, Object obj) {
        w.a(viewGroup, (s) obj);
    }

    @Override // androidx.fragment.app.m0
    public final boolean e(Object obj) {
        return obj instanceof s;
    }

    @Override // androidx.fragment.app.m0
    public final Object f(Object obj) {
        if (obj != null) {
            return ((s) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.m0
    public final Object i(Object obj, Object obj2, Object obj3) {
        s sVar = (s) obj;
        s sVar2 = (s) obj2;
        s sVar3 = (s) obj3;
        if (sVar != null && sVar2 != null) {
            y yVar = new y();
            yVar.K(sVar);
            yVar.K(sVar2);
            yVar.f13777C = false;
            sVar = yVar;
        } else if (sVar == null) {
            sVar = sVar2 != null ? sVar2 : null;
        }
        if (sVar3 == null) {
            return sVar;
        }
        y yVar2 = new y();
        if (sVar != null) {
            yVar2.K(sVar);
        }
        yVar2.K(sVar3);
        return yVar2;
    }

    @Override // androidx.fragment.app.m0
    public final Object j(Object obj, Object obj2) {
        y yVar = new y();
        if (obj != null) {
            yVar.K((s) obj);
        }
        yVar.K((s) obj2);
        return yVar;
    }

    @Override // androidx.fragment.app.m0
    public final void k(Object obj, View view, ArrayList arrayList) {
        ((s) obj).a(new C0804j(view, arrayList));
    }

    @Override // androidx.fragment.app.m0
    public final void l(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2) {
        ((s) obj).a(new C0805k(this, obj2, arrayList, obj3, arrayList2));
    }

    @Override // androidx.fragment.app.m0
    public final void m(View view, Object obj) {
        if (view != null) {
            m0.g(view, new Rect());
            ((s) obj).D(new C0803i());
        }
    }

    @Override // androidx.fragment.app.m0
    public final void n(Object obj, Rect rect) {
        ((s) obj).D(new C0803i());
    }

    @Override // androidx.fragment.app.m0
    public final void o(Object obj, G.c cVar, final H.a aVar) {
        final s sVar = (s) obj;
        cVar.b(new G.b() { // from class: o0.h

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f13713a = null;

            @Override // G.b
            public final void onCancel() {
                Runnable runnable = this.f13713a;
                if (runnable != null) {
                    runnable.run();
                } else {
                    sVar.cancel();
                    aVar.run();
                }
            }
        });
        sVar.a(new l(aVar));
    }

    @Override // androidx.fragment.app.m0
    public final void p(Object obj, View view, ArrayList arrayList) {
        y yVar = (y) obj;
        ArrayList arrayList2 = yVar.f13748f;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            m0.d((View) arrayList.get(i4), arrayList2);
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(yVar, arrayList);
    }

    @Override // androidx.fragment.app.m0
    public final void q(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        y yVar = (y) obj;
        if (yVar != null) {
            ArrayList arrayList3 = yVar.f13748f;
            arrayList3.clear();
            arrayList3.addAll(arrayList2);
            s(yVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.m0
    public final Object r(Object obj) {
        if (obj == null) {
            return null;
        }
        y yVar = new y();
        yVar.K((s) obj);
        return yVar;
    }

    public final void s(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        s sVar = (s) obj;
        int i4 = 0;
        if (sVar instanceof y) {
            y yVar = (y) sVar;
            int size = yVar.f13776B.size();
            while (i4 < size) {
                s((i4 < 0 || i4 >= yVar.f13776B.size()) ? null : (s) yVar.f13776B.get(i4), arrayList, arrayList2);
                i4++;
            }
            return;
        }
        if (m0.h(sVar.f13747e) && m0.h(null) && m0.h(null)) {
            ArrayList arrayList3 = sVar.f13748f;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                int size2 = arrayList2 == null ? 0 : arrayList2.size();
                while (i4 < size2) {
                    sVar.b((View) arrayList2.get(i4));
                    i4++;
                }
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    sVar.z((View) arrayList.get(size3));
                }
            }
        }
    }
}
