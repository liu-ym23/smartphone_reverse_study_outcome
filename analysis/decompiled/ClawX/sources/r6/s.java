package r6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s implements u {

    /* renamed from: a, reason: collision with root package name */
    public final p f5209a;

    public s(p connection) {
        kotlin.jvm.internal.p.e(connection, "connection");
        this.f5209a = connection;
    }

    @Override // r6.u
    public final u a() {
        throw new IllegalStateException("unexpected retry");
    }

    @Override // r6.u
    public final t c() {
        throw new IllegalStateException("already connected");
    }

    @Override // r6.u, s6.e
    public final void cancel() {
        throw new IllegalStateException("unexpected cancel");
    }

    @Override // r6.u
    public final p d() {
        return this.f5209a;
    }

    @Override // r6.u
    public final t f() {
        throw new IllegalStateException("already connected");
    }

    @Override // r6.u
    public final boolean isReady() {
        return true;
    }
}
