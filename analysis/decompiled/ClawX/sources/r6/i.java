package r6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i implements u {

    /* renamed from: a, reason: collision with root package name */
    public final t f5144a;

    public i(Throwable th) {
        this.f5144a = new t(this, th, 2);
    }

    @Override // r6.u
    public final u a() {
        throw new IllegalStateException("unexpected retry");
    }

    @Override // r6.u
    public final t c() {
        return this.f5144a;
    }

    @Override // r6.u, s6.e
    public final void cancel() {
        throw new IllegalStateException("unexpected cancel");
    }

    @Override // r6.u
    public final p d() {
        throw new IllegalStateException("unexpected call");
    }

    @Override // r6.u
    public final t f() {
        return this.f5144a;
    }

    @Override // r6.u
    public final boolean isReady() {
        return false;
    }
}
