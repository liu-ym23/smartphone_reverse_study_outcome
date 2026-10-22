package b0;

import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import s1.e0;
import s1.f0;
import s1.g0;
import s1.h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1798a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1799b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1800c;

    public /* synthetic */ y(int i) {
        this.f1798a = i;
    }

    @Override // s1.f0
    public final g0 c(h0 h0Var, List list, long j10) {
        ArrayList arrayList;
        ArrayList arrayList2;
        List list2;
        jb.g gVar;
        switch (this.f1798a) {
            case 0:
                ArrayList arrayList3 = new ArrayList(list.size());
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Object obj = list.get(i);
                    if (!(((e0) obj).v() instanceof a0)) {
                        arrayList3.add(obj);
                    }
                }
                List list3 = (List) ((xb.a) this.f1800c).invoke();
                if (list3 != null) {
                    ArrayList arrayList4 = new ArrayList(list3.size());
                    int size2 = list3.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        c1.c cVar = (c1.c) list3.get(i3);
                        if (cVar != null) {
                            float f5 = cVar.f2168b;
                            float f10 = cVar.f2167a;
                            e0 e0Var = (e0) arrayList3.get(i3);
                            int iFloor = (int) Math.floor(cVar.f2169c - f10);
                            float f11 = cVar.f2170d - f5;
                            arrayList2 = arrayList3;
                            list2 = list3;
                            gVar = new jb.g(e0Var.q(o2.b.b(iFloor, (int) Math.floor(f11), 5)), o2.i.a(td.h.c(Math.round(f10), Math.round(f5))));
                        } else {
                            arrayList2 = arrayList3;
                            list2 = list3;
                            gVar = null;
                        }
                        if (gVar != null) {
                            arrayList4.add(gVar);
                        }
                        i3++;
                        arrayList3 = arrayList2;
                        list3 = list2;
                    }
                    arrayList = arrayList4;
                } else {
                    arrayList = null;
                }
                ArrayList arrayList5 = new ArrayList(list.size());
                int size3 = list.size();
                for (int i10 = 0; i10 < size3; i10++) {
                    Object obj2 = list.get(i10);
                    if (((e0) obj2).v() instanceof a0) {
                        arrayList5.add(obj2);
                    }
                }
                return h0Var.Y(o2.a.i(j10), o2.a.h(j10), kb.t.f7405c, new n(2, arrayList, td.h.g(arrayList5, (xb.a) this.f1799b)));
            default:
                r2.q qVar = (r2.q) this.f1799b;
                int childCount = qVar.getChildCount();
                kb.t tVar = kb.t.f7405c;
                if (childCount == 0) {
                    return h0Var.Y(o2.a.k(j10), o2.a.j(j10), tVar, r2.c.f10371g);
                }
                if (o2.a.k(j10) != 0) {
                    qVar.getChildAt(0).setMinimumWidth(o2.a.k(j10));
                }
                if (o2.a.j(j10) != 0) {
                    qVar.getChildAt(0).setMinimumHeight(o2.a.j(j10));
                }
                int iK = o2.a.k(j10);
                int i11 = o2.a.i(j10);
                ViewGroup.LayoutParams layoutParams = qVar.getLayoutParams();
                layoutParams.getClass();
                int iD = r2.h.d(qVar, iK, i11, layoutParams.width);
                int iJ = o2.a.j(j10);
                int iH = o2.a.h(j10);
                ViewGroup.LayoutParams layoutParams2 = qVar.getLayoutParams();
                layoutParams2.getClass();
                qVar.measure(iD, r2.h.d(qVar, iJ, iH, layoutParams2.height));
                return h0Var.Y(qVar.getMeasuredWidth(), qVar.getMeasuredHeight(), tVar, new r2.d(qVar, (u1.g0) this.f1800c, 1));
        }
    }
}
