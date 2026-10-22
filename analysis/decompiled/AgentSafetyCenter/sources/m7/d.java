package m7;

import p7.c0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class d extends c0 {

    /* renamed from: a, reason: collision with root package name */
    public n f8249a = null;

    @Override // p7.c0
    public final n a() {
        n nVar = this.f8249a;
        if (nVar != null) {
            return nVar;
        }
        od.f.e("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        return null;
    }

    @Override // m7.n
    public final Object read(u7.a aVar) {
        n nVar = this.f8249a;
        if (nVar != null) {
            return nVar.read(aVar);
        }
        od.f.e("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        return null;
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        n nVar = this.f8249a;
        if (nVar != null) {
            nVar.write(cVar, obj);
        } else {
            od.f.e("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
    }
}
