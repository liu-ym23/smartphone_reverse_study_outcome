package Z8;

import h8.InterfaceC1524g;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;

/* loaded from: classes4.dex */
public final class j extends f {
    @Override // Z8.f, Q8.o
    public final Set a() {
        throw new IllegalStateException();
    }

    @Override // Z8.f, Q8.q
    public final InterfaceC1524g b(G8.f name, p8.a location) {
        k.f(name, "name");
        k.f(location, "location");
        throw new IllegalStateException(this.b + ", required name: " + name);
    }

    @Override // Z8.f, Q8.q
    public final Collection c(Q8.f kindFilter, S7.k kVar) {
        k.f(kindFilter, "kindFilter");
        throw new IllegalStateException(this.b);
    }

    @Override // Z8.f, Q8.o
    public final /* bridge */ /* synthetic */ Collection d(G8.f fVar, NoLookupLocation noLookupLocation) {
        d(fVar, noLookupLocation);
        throw null;
    }

    @Override // Z8.f, Q8.o
    public final Set e() {
        throw new IllegalStateException();
    }

    @Override // Z8.f, Q8.o
    public final /* bridge */ /* synthetic */ Collection f(G8.f fVar, p8.a aVar) {
        f(fVar, (NoLookupLocation) aVar);
        throw null;
    }

    @Override // Z8.f
    /* renamed from: g */
    public final Set f(G8.f name, NoLookupLocation noLookupLocation) {
        k.f(name, "name");
        throw new IllegalStateException(this.b + ", required name: " + name);
    }

    @Override // Z8.f, Q8.o
    public final Set getVariableNames() {
        throw new IllegalStateException();
    }

    @Override // Z8.f
    /* renamed from: h */
    public final Set d(G8.f name, NoLookupLocation noLookupLocation) {
        k.f(name, "name");
        throw new IllegalStateException(this.b + ", required name: " + name);
    }

    @Override // Z8.f
    public final String toString() {
        return B7.a.g('}', this.b, new StringBuilder("ThrowingScope{"));
    }
}
