package W;

import androidx.lifecycle.T;
import androidx.lifecycle.U;
import h4.C0753a;
import j4.k;
import p4.InterfaceC0929b;

/* loaded from: classes.dex */
public final class e {
    public static final <VM extends T> VM a(U.c cVar, InterfaceC0929b<VM> interfaceC0929b, a aVar) {
        k.g(cVar, "factory");
        k.g(interfaceC0929b, "modelClass");
        k.g(aVar, "extras");
        try {
            try {
                return (VM) cVar.b(interfaceC0929b, aVar);
            } catch (AbstractMethodError unused) {
                return (VM) cVar.a(C0753a.a(interfaceC0929b));
            }
        } catch (AbstractMethodError unused2) {
            return (VM) cVar.c(C0753a.a(interfaceC0929b), aVar);
        }
    }
}
