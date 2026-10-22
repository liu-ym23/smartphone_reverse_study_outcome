package gc;

import java.lang.invoke.VarHandle;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4704a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4705b;

    public /* synthetic */ n(int i) {
        this.f4704a = i;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [pb.h, xb.p] */
    @Override // gc.k
    public final Iterator iterator() {
        switch (this.f4704a) {
            case 0:
                return td.h.A((pb.h) this.f4705b);
            case 1:
                return (Iterator) this.f4705b;
            case 2:
                String str = (String) this.f4705b;
                hc.c cVar = new hc.c();
                cVar.f5455c = str;
                VarHandle.storeStoreFence();
                return cVar;
            default:
                return ((Iterable) this.f4705b).iterator();
        }
    }
}
