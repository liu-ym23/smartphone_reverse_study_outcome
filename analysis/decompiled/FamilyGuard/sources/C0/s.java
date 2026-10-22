package C0;

import java.util.HashMap;
import java.util.Map;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
final class s {

    /* renamed from: a, reason: collision with root package name */
    private final Map<InterfaceC1340f, l<?>> f480a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<InterfaceC1340f, l<?>> f481b = new HashMap();

    s() {
    }

    private Map<InterfaceC1340f, l<?>> b(boolean z5) {
        return z5 ? this.f481b : this.f480a;
    }

    l<?> a(InterfaceC1340f interfaceC1340f, boolean z5) {
        return b(z5).get(interfaceC1340f);
    }

    void c(InterfaceC1340f interfaceC1340f, l<?> lVar) {
        b(lVar.p()).put(interfaceC1340f, lVar);
    }

    void d(InterfaceC1340f interfaceC1340f, l<?> lVar) {
        Map<InterfaceC1340f, l<?>> mapB = b(lVar.p());
        if (lVar.equals(mapB.get(interfaceC1340f))) {
            mapB.remove(interfaceC1340f);
        }
    }
}
