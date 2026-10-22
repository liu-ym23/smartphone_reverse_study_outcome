package aa;

import F9.g;
import Z8.C1173v;
import java.util.Iterator;

/* renamed from: aa.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1259g implements F9.g {

    /* renamed from: a, reason: collision with root package name */
    public final ga.c f8133a;

    public C1259g(ga.c fqNameToMatch) {
        kotlin.jvm.internal.p.i(fqNameToMatch, "fqNameToMatch");
        this.f8133a = fqNameToMatch;
    }

    @Override // F9.g
    public /* bridge */ boolean E(ga.c cVar) {
        return g.b.b(this, cVar);
    }

    @Override // F9.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1258f d(ga.c fqName) {
        kotlin.jvm.internal.p.i(fqName, "fqName");
        if (kotlin.jvm.internal.p.d(fqName, this.f8133a)) {
            return C1258f.f8128a;
        }
        return null;
    }

    @Override // F9.g
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<F9.c> iterator() {
        return C1173v.m().iterator();
    }
}
