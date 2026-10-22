package B9;

/* loaded from: classes4.dex */
public final class q0 implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final q0 f253a = new q0();
    public static final B b = T.a("kotlin.ULong", L.f223a);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        return new C7.m(decoder.decodeInline(b).decodeLong());
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        fVar.encodeInline(b).encodeLong(((C7.m) obj).f312a);
    }
}
