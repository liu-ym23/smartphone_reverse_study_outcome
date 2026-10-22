package W;

import W.a;
import j4.g;
import j4.k;

/* loaded from: classes.dex */
public final class b extends a {
    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // W.a
    public <T> T a(a.b<T> bVar) {
        k.g(bVar, "key");
        return (T) b().get(bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void c(a.b<T> bVar, T t5) {
        k.g(bVar, "key");
        b().put(bVar, t5);
    }

    public b(a aVar) {
        k.g(aVar, "initialExtras");
        b().putAll(aVar.b());
    }

    public /* synthetic */ b(a aVar, int i5, g gVar) {
        this((i5 & 1) != 0 ? a.C0085a.f5713b : aVar);
    }
}
