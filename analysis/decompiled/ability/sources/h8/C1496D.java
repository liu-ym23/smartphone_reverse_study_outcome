package h8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import k8.AbstractC1629B;

/* renamed from: h8.D, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1496D implements InterfaceC1497E {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4575a;

    public C1496D(ArrayList arrayList) {
        this.f4575a = arrayList;
    }

    @Override // h8.InterfaceC1497E
    public final void a(G8.c fqName, ArrayList arrayList) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        for (Object obj : this.f4575a) {
            if (kotlin.jvm.internal.k.b(((AbstractC1629B) ((InterfaceC1494B) obj)).e, fqName)) {
                arrayList.add(obj);
            }
        }
    }

    @Override // h8.InterfaceC1497E
    public final boolean b(G8.c fqName) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        ArrayList arrayList = this.f4575a;
        if (arrayList.isEmpty()) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.k.b(((AbstractC1629B) ((InterfaceC1494B) it.next())).e, fqName)) {
                return false;
            }
        }
        return true;
    }

    @Override // h8.InterfaceC1497E
    public final Collection f(G8.c fqName, S7.k kVar) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        return kotlin.sequences.a.o0(kotlin.sequences.a.f0(kotlin.sequences.a.m0(D7.v.s0(this.f4575a), C1534q.c), new C1495C(fqName, 0)));
    }
}
