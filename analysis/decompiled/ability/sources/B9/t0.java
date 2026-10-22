package B9;

/* loaded from: classes4.dex */
public final class t0 implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final t0 f258a = new t0();
    public static final B b = T.a("kotlin.UShort", g0.f240a);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        return new C7.p(decoder.decodeInline(b).decodeShort());
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        fVar.encodeInline(b).encodeShort(((C7.p) obj).f315a);
    }
}
