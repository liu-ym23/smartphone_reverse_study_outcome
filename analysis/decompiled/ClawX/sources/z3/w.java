package z3;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class w implements f4.b {

    /* renamed from: a, reason: collision with root package name */
    public final k4.w f6520a;

    /* renamed from: b, reason: collision with root package name */
    public final k4.h0 f6521b;

    /* renamed from: c, reason: collision with root package name */
    public final r4.d f6522c;
    public final k4.q d;

    public w(f4.c cVar) {
        this.f6520a = cVar.f2592b;
        this.f6521b = cVar.f2591a.b();
        this.f6522c = cVar.f2595f;
        this.d = cVar.f2593c.n();
    }

    @Override // f4.b
    public final k4.w C() {
        return this.f6520a;
    }

    @Override // k4.u
    public final k4.o a() {
        return this.d;
    }

    @Override // f4.b, a6.f0
    public final f5.h b() {
        throw new IllegalStateException("Call is not initialized");
    }

    @Override // f4.b
    public final r4.d getAttributes() {
        return this.f6522c;
    }

    @Override // f4.b
    public final k4.h0 u() {
        return this.f6521b;
    }
}
