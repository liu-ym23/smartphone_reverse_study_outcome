package i8;

import X8.C0288t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: i8.k, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1565k implements InterfaceC1561g {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1561g f4615a;
    public final C0288t b;

    public C1565k(InterfaceC1561g interfaceC1561g, C0288t c0288t) {
        this.f4615a = interfaceC1561g;
        this.b = c0288t;
    }

    @Override // i8.InterfaceC1561g
    public final boolean isEmpty() {
        InterfaceC1561g interfaceC1561g = this.f4615a;
        if ((interfaceC1561g instanceof Collection) && ((Collection) interfaceC1561g).isEmpty()) {
            return false;
        }
        Iterator it = interfaceC1561g.iterator();
        while (it.hasNext()) {
            G8.c cVarB = ((InterfaceC1556b) it.next()).b();
            if (cVarB != null && ((Boolean) this.b.invoke(cVarB)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f4615a) {
            G8.c cVarB = ((InterfaceC1556b) obj).b();
            if (cVarB != null && ((Boolean) this.b.invoke(cVarB)).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList.iterator();
    }

    @Override // i8.InterfaceC1561g
    public final boolean k(G8.c fqName) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        if (((Boolean) this.b.invoke(fqName)).booleanValue()) {
            return this.f4615a.k(fqName);
        }
        return false;
    }

    @Override // i8.InterfaceC1561g
    public final InterfaceC1556b m(G8.c fqName) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        if (((Boolean) this.b.invoke(fqName)).booleanValue()) {
            return this.f4615a.m(fqName);
        }
        return null;
    }
}
