package E9;

import java.util.Collection;
import java.util.List;
import p9.InterfaceC5074l;

/* renamed from: E9.y, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC0819y extends InterfaceC0803h {

    /* renamed from: E9.y$a */
    public static final class a {
        public static <R, D> R a(InterfaceC0819y interfaceC0819y, InterfaceC0805j<R, D> visitor, D d10) {
            kotlin.jvm.internal.p.i(visitor, "visitor");
            return visitor.b(interfaceC0819y, d10);
        }

        public static InterfaceC0803h b(InterfaceC0819y interfaceC0819y) {
            return null;
        }
    }

    L f0(ga.c cVar);

    C9.j g();

    Collection<ga.c> k(ga.c cVar, InterfaceC5074l<? super ga.e, Boolean> interfaceC5074l);

    <T> T q0(C0818x<T> c0818x);

    boolean u(InterfaceC0819y interfaceC0819y);

    List<InterfaceC0819y> u0();
}
