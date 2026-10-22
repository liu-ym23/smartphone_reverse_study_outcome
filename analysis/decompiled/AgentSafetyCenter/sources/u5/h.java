package u5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements nc.h, yb.g {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ l f14058c;

    @Override // yb.g
    public final jb.b a() {
        return new yb.a(2, 4, l.class, this.f14058c, "updateState", "updateState(Lcoil/compose/AsyncImagePainter$State;)V");
    }

    @Override // nc.h
    public final Object emit(Object obj, nb.c cVar) {
        this.f14058c.k((g) obj);
        ob.a aVar = ob.a.f9351c;
        return jb.v.f6774a;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof nc.h) && (obj instanceof yb.g)) {
            return a().equals(((yb.g) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }
}
