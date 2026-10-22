package lb;

import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import p9.InterfaceC5063a;
import sb.AbstractC5465c;
import w9.InterfaceC5745d;
import w9.InterfaceC5746e;
import w9.InterfaceC5755n;

@Metadata(d1 = {"lb/w"}, d2 = {}, k = 4, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class u {
    public static final KSerializer<? extends Object> a(InterfaceC5745d<Object> interfaceC5745d, List<? extends KSerializer<Object>> list, InterfaceC5063a<? extends InterfaceC5746e> interfaceC5063a) {
        return w.e(interfaceC5745d, list, interfaceC5063a);
    }

    public static final KSerializer<Object> b(AbstractC5465c abstractC5465c, InterfaceC5755n interfaceC5755n) {
        return w.f(abstractC5465c, interfaceC5755n);
    }

    public static final <T> KSerializer<T> c(InterfaceC5745d<T> interfaceC5745d) {
        return w.g(interfaceC5745d);
    }

    public static final KSerializer<Object> d(InterfaceC5755n interfaceC5755n) {
        return w.h(interfaceC5755n);
    }

    public static final KSerializer<Object> e(AbstractC5465c abstractC5465c, InterfaceC5755n interfaceC5755n) {
        return w.k(abstractC5465c, interfaceC5755n);
    }

    public static final <T> KSerializer<T> f(InterfaceC5745d<T> interfaceC5745d) {
        return w.l(interfaceC5745d);
    }

    public static final List<KSerializer<Object>> g(AbstractC5465c abstractC5465c, List<? extends InterfaceC5755n> list, boolean z10) {
        return w.m(abstractC5465c, list, z10);
    }
}
