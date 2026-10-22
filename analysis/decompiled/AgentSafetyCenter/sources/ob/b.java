package ob;

import od.f;
import pb.g;
import xb.p;
import yb.x;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends g {

    /* renamed from: c, reason: collision with root package name */
    public int f9355c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ p f9356f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ nb.c f9357g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(nb.c cVar, nb.c cVar2, p pVar) {
        super(cVar);
        this.f9356f = pVar;
        this.f9357g = cVar2;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f9355c;
        if (i != 0) {
            if (i != 1) {
                f.e("This coroutine had already completed");
                return null;
            }
            this.f9355c = 2;
            id.c.I(obj);
            return obj;
        }
        this.f9355c = 1;
        id.c.I(obj);
        p pVar = this.f9356f;
        pVar.getClass();
        x.c(2, pVar);
        return pVar.invoke(this.f9357g, this);
    }
}
