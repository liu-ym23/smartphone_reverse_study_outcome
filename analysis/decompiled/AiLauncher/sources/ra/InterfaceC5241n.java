package ra;

import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import java.util.Collection;
import p9.InterfaceC5074l;

/* renamed from: ra.n, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC5241n {

    /* renamed from: ra.n$a */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection a(InterfaceC5241n interfaceC5241n, C5231d c5231d, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
            }
            if ((i10 & 1) != 0) {
                c5231d = C5231d.f38869o;
            }
            if ((i10 & 2) != 0) {
                interfaceC5074l = InterfaceC5238k.f38895a.c();
            }
            return interfaceC5241n.e(c5231d, interfaceC5074l);
        }
    }

    InterfaceC0799d d(ga.e eVar, M9.b bVar);

    Collection<InterfaceC0803h> e(C5231d c5231d, InterfaceC5074l<? super ga.e, Boolean> interfaceC5074l);
}
