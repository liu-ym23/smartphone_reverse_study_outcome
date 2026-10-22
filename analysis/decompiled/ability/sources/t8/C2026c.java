package t8;

import D7.q;
import D7.t;
import D7.v;
import G8.f;
import N9.j;
import W8.i;
import e8.n;
import i8.InterfaceC1556b;
import i8.InterfaceC1561g;
import i9.C1570e;
import i9.o;
import java.util.Iterator;
import kotlin.jvm.internal.k;
import r8.AbstractC1881c;
import x8.InterfaceC2119b;

/* renamed from: t8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2026c implements InterfaceC1561g {

    /* renamed from: a, reason: collision with root package name */
    public final K1.a f6680a;
    public final InterfaceC2119b b;
    public final boolean c;
    public final kotlin.reflect.jvm.internal.impl.storage.b d;

    public C2026c(K1.a c, InterfaceC2119b annotationOwner, boolean z10) {
        k.f(c, "c");
        k.f(annotationOwner, "annotationOwner");
        this.f6680a = c;
        this.b = annotationOwner;
        this.c = z10;
        this.d = ((i) ((C2024a) c.f903a).f6670a).d(new J4.b(this, 21));
    }

    @Override // i8.InterfaceC1561g
    public final boolean isEmpty() {
        return this.b.getAnnotations().isEmpty();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        InterfaceC2119b interfaceC2119b = this.b;
        o oVarM0 = kotlin.sequences.a.m0(v.s0(interfaceC2119b.getAnnotations()), this.d);
        f fVar = AbstractC1881c.f5681a;
        return new C1570e(kotlin.sequences.a.g0(kotlin.sequences.a.i0(q.M(new i9.i[]{oVarM0, new t(AbstractC1881c.a(n.m, interfaceC2119b, this.f6680a), 5)})), new com.uxsense.parse.b(21)));
    }

    @Override // i8.InterfaceC1561g
    public final boolean k(G8.c cVar) {
        return j.B(this, cVar);
    }

    @Override // i8.InterfaceC1561g
    public final InterfaceC1556b m(G8.c fqName) {
        InterfaceC1556b interfaceC1556b;
        k.f(fqName, "fqName");
        InterfaceC2119b interfaceC2119b = this.b;
        n8.d dVarA = interfaceC2119b.a(fqName);
        if (dVarA != null && (interfaceC1556b = (InterfaceC1556b) this.d.invoke(dVarA)) != null) {
            return interfaceC1556b;
        }
        f fVar = AbstractC1881c.f5681a;
        return AbstractC1881c.a(fqName, interfaceC2119b, this.f6680a);
    }
}
