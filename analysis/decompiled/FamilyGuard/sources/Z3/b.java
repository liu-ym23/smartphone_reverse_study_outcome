package Z3;

import Z3.i;
import Z3.i.b;
import i4.InterfaceC0772l;
import j4.k;

/* loaded from: classes.dex */
public abstract class b<B extends i.b, E extends B> implements i.c<E> {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0772l<i.b, E> f6650a;

    /* renamed from: b, reason: collision with root package name */
    private final i.c<?> f6651b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [Z3.i$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [i4.l<? super Z3.i$b, ? extends E extends B>, i4.l<Z3.i$b, E extends B>, java.lang.Object] */
    public b(i.c<B> cVar, InterfaceC0772l<? super i.b, ? extends E> interfaceC0772l) {
        k.g(cVar, "baseKey");
        k.g(interfaceC0772l, "safeCast");
        this.f6650a = interfaceC0772l;
        this.f6651b = cVar instanceof b ? (i.c<B>) ((b) cVar).f6651b : cVar;
    }

    public final boolean a(i.c<?> cVar) {
        k.g(cVar, "key");
        return cVar == this || this.f6651b == cVar;
    }

    /* JADX WARN: Incorrect return type in method signature: (LZ3/i$b;)TE; */
    public final i.b b(i.b bVar) {
        k.g(bVar, "element");
        return (i.b) this.f6650a.invoke(bVar);
    }
}
