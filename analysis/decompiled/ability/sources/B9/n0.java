package B9;

/* loaded from: classes4.dex */
public final class n0 implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final n0 f249a = new n0();
    public static final B b = T.a("kotlin.UInt", F.f218a);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        return new C7.k(decoder.decodeInline(b).decodeInt());
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        fVar.encodeInline(b).encodeInt(((C7.k) obj).f310a);
    }
}
