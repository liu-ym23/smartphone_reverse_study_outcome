package B9;

import z9.C2203e;

/* loaded from: classes4.dex */
public final class g0 implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final g0 f240a = new g0();
    public static final Z b = new Z("kotlin.Short", C2203e.f6994j);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        return Short.valueOf(decoder.decodeShort());
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        fVar.encodeShort(((Number) obj).shortValue());
    }
}
