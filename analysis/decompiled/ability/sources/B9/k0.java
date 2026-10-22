package B9;

/* loaded from: classes4.dex */
public final class k0 implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final k0 f245a = new k0();
    public static final B b = T.a("kotlin.UByte", C0183j.f244a);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        return new C7.h(decoder.decodeInline(b).decodeByte());
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        fVar.encodeInline(b).encodeByte(((C7.h) obj).f307a);
    }
}
