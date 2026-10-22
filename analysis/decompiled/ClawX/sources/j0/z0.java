package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class z0 implements f5.f {

    /* renamed from: a, reason: collision with root package name */
    public final z0 f3471a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f3472b;

    public z0(z0 z0Var, c0 c0Var) {
        this.f3471a = z0Var;
        this.f3472b = c0Var;
    }

    public final void b(c0 c0Var) {
        if (this.f3472b == c0Var) {
            throw new IllegalStateException("Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.");
        }
        z0 z0Var = this.f3471a;
        if (z0Var != null) {
            z0Var.b(c0Var);
        }
    }

    @Override // f5.f
    public final f5.g getKey() {
        return y0.f3469a;
    }

    @Override // f5.h
    public final f5.f o(f5.g gVar) {
        return b8.h.o(this, gVar);
    }

    @Override // f5.h
    public final f5.h s(f5.g gVar) {
        return b8.h.y(this, gVar);
    }

    @Override // f5.h
    public final f5.h t(f5.h hVar) {
        return b8.h.I(this, hVar);
    }

    @Override // f5.h
    public final Object z(Object obj, p5.p pVar) {
        return pVar.invoke(obj, this);
    }
}
