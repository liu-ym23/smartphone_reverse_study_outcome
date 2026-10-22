package gc;

import java.lang.invoke.VarHandle;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p implements Iterable, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4706c;

    /* renamed from: f, reason: collision with root package name */
    public Object f4707f;

    public /* synthetic */ p(int i) {
        this.f4706c = i;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f4706c) {
            case 0:
                return ((i) this.f4707f).iterator();
            default:
                kb.b bVarD = yb.k.d((Object[]) ((ab.e) this.f4707f).f393f);
                c cVar = new c(1);
                cVar.f4681f = bVarD;
                VarHandle.storeStoreFence();
                return cVar;
        }
    }
}
