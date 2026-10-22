package q9;

/* loaded from: classes4.dex */
public final class k implements H7.c, J7.b {

    /* renamed from: a, reason: collision with root package name */
    public final H7.c f5628a;
    public final H7.h b;

    public k(H7.h hVar, H7.c cVar) {
        this.f5628a = cVar;
        this.b = hVar;
    }

    @Override // J7.b
    public final J7.b getCallerFrame() {
        H7.c cVar = this.f5628a;
        if (cVar instanceof J7.b) {
            return (J7.b) cVar;
        }
        return null;
    }

    @Override // H7.c
    public final H7.h getContext() {
        return this.b;
    }

    @Override // H7.c
    public final void resumeWith(Object obj) {
        this.f5628a.resumeWith(obj);
    }
}
