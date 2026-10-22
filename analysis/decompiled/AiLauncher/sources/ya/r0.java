package ya;

import E9.InterfaceC0803h;

/* loaded from: classes5.dex */
public interface r0 {

    public static final class a {
        public static /* synthetic */ s0 a(r0 r0Var, F9.g gVar, v0 v0Var, InterfaceC0803h interfaceC0803h, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toAttributes");
            }
            if ((i10 & 2) != 0) {
                v0Var = null;
            }
            if ((i10 & 4) != 0) {
                interfaceC0803h = null;
            }
            return r0Var.a(gVar, v0Var, interfaceC0803h);
        }
    }

    s0 a(F9.g gVar, v0 v0Var, InterfaceC0803h interfaceC0803h);
}
