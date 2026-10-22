package B9;

import z9.C2203e;

/* renamed from: B9.j, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0183j implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final C0183j f244a = new C0183j();
    public static final Z b = new Z("kotlin.Byte", C2203e.d);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        return Byte.valueOf(decoder.decodeByte());
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        fVar.encodeByte(((Number) obj).byteValue());
    }
}
