package i8;

import D7.q;
import D7.v;
import h8.C1495C;
import i9.C1570e;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;
import y8.C2139b;

/* renamed from: i8.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1562h implements InterfaceC1561g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4612a;
    public final Object b;

    public C1562h(List delegates, int i) {
        this.f4612a = i;
        switch (i) {
            case 1:
                kotlin.jvm.internal.k.f(delegates, "delegates");
                this.b = delegates;
                break;
            default:
                this.b = delegates;
                break;
        }
    }

    @Override // i8.InterfaceC1561g
    public final boolean isEmpty() {
        switch (this.f4612a) {
            case 0:
                return ((List) this.b).isEmpty();
            case 1:
                List list = (List) this.b;
                if ((list instanceof Collection) && list.isEmpty()) {
                    return true;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (!((InterfaceC1561g) it.next()).isEmpty()) {
                        return false;
                    }
                }
                return true;
            default:
                return false;
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f4612a) {
            case 0:
                return ((List) this.b).iterator();
            case 1:
                return new C1570e(kotlin.sequences.a.h0(v.s0((List) this.b), C1564j.f4614a));
            default:
                return EmptyList.f4893a.iterator();
        }
    }

    @Override // i8.InterfaceC1561g
    public final boolean k(G8.c fqName) {
        switch (this.f4612a) {
            case 1:
                kotlin.jvm.internal.k.f(fqName, "fqName");
                Iterator it = ((Iterable) v.s0((List) this.b).b).iterator();
                while (it.hasNext()) {
                    if (((InterfaceC1561g) it.next()).k(fqName)) {
                        break;
                    }
                }
                break;
        }
        return N9.j.B(this, fqName);
    }

    @Override // i8.InterfaceC1561g
    public final InterfaceC1556b m(G8.c fqName) {
        switch (this.f4612a) {
            case 0:
                return N9.j.q(this, fqName);
            case 1:
                kotlin.jvm.internal.k.f(fqName, "fqName");
                C1570e c1570e = new C1570e(kotlin.sequences.a.n0(v.s0((List) this.b), new C1495C(fqName, 1)));
                return (InterfaceC1556b) (!c1570e.hasNext() ? null : c1570e.next());
            default:
                kotlin.jvm.internal.k.f(fqName, "fqName");
                if (fqName.equals((G8.c) this.b)) {
                    return C2139b.f6911a;
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f4612a) {
            case 0:
                return ((List) this.b).toString();
            default:
                return super.toString();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1562h(InterfaceC1561g[] interfaceC1561gArr) {
        this(q.I0(interfaceC1561gArr), 1);
        this.f4612a = 1;
    }

    public C1562h(G8.c fqNameToMatch) {
        this.f4612a = 2;
        kotlin.jvm.internal.k.f(fqNameToMatch, "fqNameToMatch");
        this.b = fqNameToMatch;
    }
}
