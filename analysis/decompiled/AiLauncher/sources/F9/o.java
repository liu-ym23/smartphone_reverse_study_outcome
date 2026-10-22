package F9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final class o implements g {

    /* renamed from: a, reason: collision with root package name */
    public final g f2622a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2623b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC5074l<ga.c, Boolean> f2624c;

    /* JADX WARN: Multi-variable type inference failed */
    public o(g delegate, boolean z10, InterfaceC5074l<? super ga.c, Boolean> fqNameFilter) {
        p.i(delegate, "delegate");
        p.i(fqNameFilter, "fqNameFilter");
        this.f2622a = delegate;
        this.f2623b = z10;
        this.f2624c = fqNameFilter;
    }

    @Override // F9.g
    public boolean E(ga.c fqName) {
        p.i(fqName, "fqName");
        if (this.f2624c.invoke(fqName).booleanValue()) {
            return this.f2622a.E(fqName);
        }
        return false;
    }

    public final boolean b(c cVar) {
        ga.c cVarF = cVar.f();
        return cVarF != null && this.f2624c.invoke(cVarF).booleanValue();
    }

    @Override // F9.g
    public c d(ga.c fqName) {
        p.i(fqName, "fqName");
        if (this.f2624c.invoke(fqName).booleanValue()) {
            return this.f2622a.d(fqName);
        }
        return null;
    }

    @Override // F9.g
    public boolean isEmpty() {
        boolean z10;
        g gVar = this.f2622a;
        if ((gVar instanceof Collection) && ((Collection) gVar).isEmpty()) {
            z10 = false;
        } else {
            Iterator<c> it = gVar.iterator();
            while (it.hasNext()) {
                if (b(it.next())) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        }
        return this.f2623b ? !z10 : z10;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        g gVar = this.f2622a;
        ArrayList arrayList = new ArrayList();
        for (c cVar : gVar) {
            if (b(cVar)) {
                arrayList.add(cVar);
            }
        }
        return arrayList.iterator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(g delegate, InterfaceC5074l<? super ga.c, Boolean> fqNameFilter) {
        this(delegate, false, fqNameFilter);
        p.i(delegate, "delegate");
        p.i(fqNameFilter, "fqNameFilter");
    }
}
