package w0;

import java.lang.invoke.VarHandle;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface m {
    boolean a(xb.l lVar);

    Object c(Object obj, p pVar);

    default m d(m mVar) {
        if (mVar == j.f15113c) {
            return this;
        }
        g gVar = new g();
        gVar.f15109c = this;
        gVar.f15110f = mVar;
        VarHandle.storeStoreFence();
        return gVar;
    }
}
