package s8;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v2 implements s1.f0 {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ float f12028a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ float f12029b;

    @Override // s1.f0
    public final s1.g0 c(s1.h0 h0Var, List list, long j10) {
        int size;
        h0Var.getClass();
        list.getClass();
        int iE0 = h0Var.e0(this.f12028a);
        int iE02 = h0Var.e0(this.f12029b);
        int i = o2.a.i(j10);
        int i3 = (int) (i * 0.58f);
        if (i3 < 1) {
            i3 = 1;
        }
        ArrayList arrayList = new ArrayList(kb.m.m0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((s1.e0) it.next()).q(o2.a.b(j10, 0, i3 > i ? i : i3, 0, 0, 12)));
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayList.size();
        int iMax = 0;
        int i10 = 0;
        int i11 = 0;
        while (i11 < size2) {
            Object obj = arrayList.get(i11);
            i11++;
            s1.o0 o0Var = (s1.o0) obj;
            int i12 = o0Var.f11277c + (arrayList3.isEmpty() ? 0 : iE0);
            if (!arrayList3.isEmpty() && i10 + i12 > i) {
                arrayList2.add(new u2(arrayList3, iMax));
                arrayList3 = new ArrayList();
                iMax = 0;
                i10 = 0;
            }
            arrayList3.add(o0Var);
            i10 += i12;
            iMax = Math.max(iMax, o0Var.f11278f);
        }
        if (!arrayList3.isEmpty()) {
            arrayList2.add(new u2(arrayList3, iMax));
        }
        if (arrayList2.isEmpty()) {
            size = 0;
        } else {
            int size3 = arrayList2.size();
            int i13 = 0;
            int i14 = 0;
            while (i14 < size3) {
                Object obj2 = arrayList2.get(i14);
                i14++;
                i13 += ((u2) obj2).f12010b;
            }
            size = ((arrayList2.size() - 1) * iE02) + i13;
        }
        int i15 = size >= 0 ? size : 0;
        d2.n nVar = new d2.n(1);
        nVar.f3147h = arrayList2;
        nVar.f3145f = iE02;
        nVar.f3146g = iE0;
        VarHandle.storeStoreFence();
        return h0Var.Y(i, i15, kb.t.f7405c, nVar);
    }
}
