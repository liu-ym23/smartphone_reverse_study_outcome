package r;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o implements s1.f0 {

    /* renamed from: a, reason: collision with root package name */
    public t f10323a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10324b;

    @Override // s1.f0
    public final s1.g0 c(s1.h0 h0Var, List list, long j10) {
        Object obj;
        t tVar = this.f10323a;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((s1.e0) list.get(i)).q(j10));
        }
        Object obj2 = null;
        if (arrayList.isEmpty()) {
            obj = null;
        } else {
            obj = arrayList.get(0);
            int i3 = ((s1.o0) obj).f11277c;
            int size2 = arrayList.size() - 1;
            if (1 <= size2) {
                int i10 = 1;
                while (true) {
                    Object obj3 = arrayList.get(i10);
                    int i11 = ((s1.o0) obj3).f11277c;
                    if (i3 < i11) {
                        obj = obj3;
                        i3 = i11;
                    }
                    if (i10 == size2) {
                        break;
                    }
                    i10++;
                }
            }
        }
        s1.o0 o0Var = (s1.o0) obj;
        int i12 = o0Var != null ? o0Var.f11277c : 0;
        if (!arrayList.isEmpty()) {
            obj2 = arrayList.get(0);
            int i13 = ((s1.o0) obj2).f11278f;
            int size3 = arrayList.size() - 1;
            if (1 <= size3) {
                int i14 = 1;
                while (true) {
                    Object obj4 = arrayList.get(i14);
                    int i15 = ((s1.o0) obj4).f11278f;
                    if (i13 < i15) {
                        obj2 = obj4;
                        i13 = i15;
                    }
                    if (i14 == size3) {
                        break;
                    }
                    i14++;
                }
            }
        }
        s1.o0 o0Var2 = (s1.o0) obj2;
        int i16 = o0Var2 != null ? o0Var2.f11278f : 0;
        if (h0Var.V()) {
            this.f10324b = true;
            tVar.f10342a.setValue(o2.k.a(ac.a.b(i12, i16)));
        } else if (!this.f10324b) {
            tVar.f10342a.setValue(o2.k.a(ac.a.b(i12, i16)));
        }
        return h0Var.Y(i12, i16, kb.t.f7405c, new b0.a(arrayList, 1));
    }
}
