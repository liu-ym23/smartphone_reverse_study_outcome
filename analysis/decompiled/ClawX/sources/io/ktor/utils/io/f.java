package io.ktor.utils.io;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f implements e {

    /* renamed from: b, reason: collision with root package name */
    public final a6.m f3187b;

    /* renamed from: c, reason: collision with root package name */
    public final Throwable f3188c;

    public f(a6.m mVar) {
        this.f3187b = mVar;
        String property = System.getProperty("io.ktor.development");
        if (property == null || !Boolean.parseBoolean(property)) {
            return;
        }
        int iHashCode = mVar.hashCode();
        x.f.r(16);
        String string = Integer.toString(iHashCode, 16);
        kotlin.jvm.internal.p.d(string, "toString(...)");
        Throwable th = new Throwable("WriteTask 0x".concat(string));
        a.a.b0(th);
        this.f3188c = th;
    }

    @Override // io.ktor.utils.io.e
    public final void a(Throwable th) {
        Object objO;
        f5.c cVarD = d();
        if (th != null) {
            objO = a.a.o(th);
        } else {
            g.f3192a.getClass();
            objO = b5.a0.f883a;
        }
        ((a6.m) cVarD).resumeWith(objO);
    }

    @Override // io.ktor.utils.io.e
    public final Throwable b() {
        return this.f3188c;
    }

    @Override // io.ktor.utils.io.e
    public final void c() {
        f5.c cVarD = d();
        g.f3192a.getClass();
        ((a6.m) cVarD).resumeWith(b5.a0.f883a);
    }

    public final f5.c d() {
        return this.f3187b;
    }
}
