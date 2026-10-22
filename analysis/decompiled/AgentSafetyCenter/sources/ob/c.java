package ob;

import nb.g;
import od.f;
import xb.p;
import yb.x;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public int f9358c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ p f9359f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ nb.c f9360g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(nb.c cVar, g gVar, p pVar, nb.c cVar2) {
        super(cVar, gVar);
        this.f9359f = pVar;
        this.f9360g = cVar2;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f9358c;
        if (i != 0) {
            if (i != 1) {
                f.e("This coroutine had already completed");
                return null;
            }
            this.f9358c = 2;
            id.c.I(obj);
            return obj;
        }
        this.f9358c = 1;
        id.c.I(obj);
        p pVar = this.f9359f;
        pVar.getClass();
        x.c(2, pVar);
        return pVar.invoke(this.f9360g, this);
    }
}
