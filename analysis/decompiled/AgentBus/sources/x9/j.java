package x9;

import java.util.Collection;
import java.util.Set;
import q7.k;

/* loaded from: classes.dex */
public final class j extends e {
    @Override // x9.e, o9.n
    public final /* bridge */ /* synthetic */ Collection a(e9.f fVar, n8.c cVar) {
        a(fVar, cVar);
        throw null;
    }

    @Override // x9.e, o9.q
    public final f8.g b(e9.f fVar, n8.a aVar) {
        k.e(fVar, "name");
        k.e(aVar, "location");
        throw new IllegalStateException(this.f11291b + ", required name: " + fVar);
    }

    @Override // x9.e, o9.n
    public final Set c() {
        throw new IllegalStateException();
    }

    @Override // x9.e, o9.n
    public final Set d() {
        throw new IllegalStateException();
    }

    @Override // x9.e, o9.q
    public final Collection e(o9.f fVar, p7.k kVar) {
        k.e(fVar, "kindFilter");
        k.e(kVar, "nameFilter");
        throw new IllegalStateException(this.f11291b);
    }

    @Override // x9.e, o9.q
    public final /* bridge */ /* synthetic */ Collection f(e9.f fVar, n8.a aVar) {
        f(fVar, aVar);
        throw null;
    }

    @Override // x9.e, o9.n
    public final Set g() {
        throw new IllegalStateException();
    }

    @Override // x9.e
    /* renamed from: h */
    public final Set f(e9.f fVar, n8.a aVar) {
        k.e(fVar, "name");
        throw new IllegalStateException(this.f11291b + ", required name: " + fVar);
    }

    @Override // x9.e
    /* renamed from: i */
    public final Set a(e9.f fVar, n8.c cVar) {
        k.e(fVar, "name");
        throw new IllegalStateException(this.f11291b + ", required name: " + fVar);
    }

    @Override // x9.e
    public final String toString() {
        return a1.a.l(new StringBuilder("ThrowingScope{"), this.f11291b, '}');
    }
}
