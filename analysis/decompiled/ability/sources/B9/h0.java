package B9;

import z9.C2203e;

/* loaded from: classes4.dex */
public final class h0 implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final h0 f242a = new h0();
    public static final Z b = new Z("kotlin.String", C2203e.k);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        return decoder.decodeString();
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        String value = (String) obj;
        kotlin.jvm.internal.k.f(value, "value");
        fVar.encodeString(value);
    }
}
