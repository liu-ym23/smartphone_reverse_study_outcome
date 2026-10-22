package ma;

/* loaded from: classes.dex */
public final class v implements g7.d, i7.d {

    /* renamed from: f, reason: collision with root package name */
    public final g7.d f6515f;

    /* renamed from: g, reason: collision with root package name */
    public final g7.l f6516g;

    public v(g7.d dVar, g7.l lVar) {
        this.f6515f = dVar;
        this.f6516g = lVar;
    }

    @Override // i7.d
    public final i7.d getCallerFrame() {
        g7.d dVar = this.f6515f;
        if (dVar instanceof i7.d) {
            return (i7.d) dVar;
        }
        return null;
    }

    @Override // g7.d
    public final g7.l getContext() {
        return this.f6516g;
    }

    @Override // g7.d
    public final void resumeWith(Object obj) {
        this.f6515f.resumeWith(obj);
    }
}
