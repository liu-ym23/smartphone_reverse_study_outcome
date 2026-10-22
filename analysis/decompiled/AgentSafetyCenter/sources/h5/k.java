package h5;

import java.lang.invoke.VarHandle;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface k {
    static p5.c a() {
        e6.n nVar = new e6.n();
        nVar.f3587c = new LinkedHashMap();
        VarHandle.storeStoreFence();
        p5.c cVar = new p5.c(6);
        cVar.f9717f = nVar;
        cVar.f9718g = new Object();
        VarHandle.storeStoreFence();
        return cVar;
    }
}
