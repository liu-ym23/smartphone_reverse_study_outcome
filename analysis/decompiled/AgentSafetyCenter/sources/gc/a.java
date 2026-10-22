package gc;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements k {

    /* renamed from: a, reason: collision with root package name */
    public AtomicReference f4677a;

    @Override // gc.k
    public final Iterator iterator() {
        k kVar = (k) this.f4677a.getAndSet(null);
        if (kVar != null) {
            return kVar.iterator();
        }
        od.f.e("This sequence can be consumed only once.");
        return null;
    }
}
