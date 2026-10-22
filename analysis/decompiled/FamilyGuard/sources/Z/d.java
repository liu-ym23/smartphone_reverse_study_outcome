package Z;

import d0.InterfaceC0651f;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class d<T> extends l {
    public d(g gVar) {
        super(gVar);
    }

    protected abstract void g(InterfaceC0651f interfaceC0651f, T t5);

    public final void h(Iterable<T> iterable) {
        InterfaceC0651f interfaceC0651fA = a();
        try {
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                g(interfaceC0651fA, it.next());
                interfaceC0651fA.t0();
            }
        } finally {
            f(interfaceC0651fA);
        }
    }

    public final void i(T t5) {
        InterfaceC0651f interfaceC0651fA = a();
        try {
            g(interfaceC0651fA, t5);
            interfaceC0651fA.t0();
        } finally {
            f(interfaceC0651fA);
        }
    }

    public final long j(T t5) {
        InterfaceC0651f interfaceC0651fA = a();
        try {
            g(interfaceC0651fA, t5);
            return interfaceC0651fA.t0();
        } finally {
            f(interfaceC0651fA);
        }
    }
}
