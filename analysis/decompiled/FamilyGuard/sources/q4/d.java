package q4;

import V3.v;
import a4.C0428b;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class d<T> {
    public abstract Object c(T t5, Z3.e<? super v> eVar);

    public abstract Object g(Iterator<? extends T> it, Z3.e<? super v> eVar);

    public final Object i(InterfaceC0988b<? extends T> interfaceC0988b, Z3.e<? super v> eVar) {
        Object objG = g(interfaceC0988b.iterator(), eVar);
        return objG == C0428b.e() ? objG : v.f5542a;
    }
}
