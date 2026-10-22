package B9;

/* loaded from: classes4.dex */
public final class u0 implements x9.b {
    public static final u0 b = new u0();

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S f260a = new S("kotlin.Unit", C7.r.f317a);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        this.f260a.deserialize(decoder);
        return C7.r.f317a;
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return this.f260a.getDescriptor();
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        C7.r value = (C7.r) obj;
        kotlin.jvm.internal.k.f(value, "value");
        this.f260a.serialize(fVar, value);
    }
}
