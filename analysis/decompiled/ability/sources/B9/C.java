package B9;

/* loaded from: classes4.dex */
public final class C implements A {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x9.b f216a;

    public C(x9.b bVar) {
        this.f216a = bVar;
    }

    @Override // B9.A
    public final x9.b[] childSerializers() {
        return new x9.b[]{this.f216a};
    }

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        throw new IllegalStateException("unsupported");
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        throw new IllegalStateException("unsupported");
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        throw new IllegalStateException("unsupported");
    }
}
