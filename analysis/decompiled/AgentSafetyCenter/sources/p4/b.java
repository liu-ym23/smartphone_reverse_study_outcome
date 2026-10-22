package p4;

import java.io.IOException;
import java.lang.invoke.VarHandle;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements o4.b {

    /* renamed from: c, reason: collision with root package name */
    public a1.g f9698c;

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        ((y4.c) this.f9698c.f19f).close();
    }

    @Override // o4.b
    public final Object m(boolean z10, p pVar, pb.c cVar) {
        y4.c cVar2 = (y4.c) this.f9698c.f19f;
        cVar2.getDatabaseName();
        z4.c cVarW = cVar2.w();
        cVarW.getClass();
        a aVar = new a();
        aVar.f9697c = cVarW;
        d dVar = new d();
        dVar.f9703a = aVar;
        VarHandle.storeStoreFence();
        return pVar.invoke(dVar, cVar);
    }
}
