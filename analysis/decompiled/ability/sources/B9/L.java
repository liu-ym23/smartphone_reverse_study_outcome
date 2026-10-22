package B9;

import z9.C2203e;

/* loaded from: classes4.dex */
public final class L implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final L f223a = new L();
    public static final Z b = new Z("kotlin.Long", C2203e.i);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        return Long.valueOf(decoder.decodeLong());
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        fVar.encodeLong(((Number) obj).longValue());
    }
}
