package B9;

import z9.C2203e;

/* renamed from: B9.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0180g implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final C0180g f239a = new C0180g();
    public static final Z b = new Z("kotlin.Boolean", C2203e.c);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        return Boolean.valueOf(decoder.decodeBoolean());
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        fVar.encodeBoolean(((Boolean) obj).booleanValue());
    }
}
