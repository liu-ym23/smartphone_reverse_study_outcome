package Z;

import d0.InterfaceC0651f;

/* loaded from: classes.dex */
public abstract class c<T> extends l {
    public c(g gVar) {
        super(gVar);
    }

    protected abstract void g(InterfaceC0651f interfaceC0651f, T t5);

    public final int h(T t5) {
        InterfaceC0651f interfaceC0651fA = a();
        try {
            g(interfaceC0651fA, t5);
            return interfaceC0651fA.n();
        } finally {
            f(interfaceC0651fA);
        }
    }
}
