package B9;

import z9.C2203e;

/* renamed from: B9.z, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0198z implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final C0198z f264a = new C0198z();
    public static final Z b = new Z("kotlin.Float", C2203e.g);

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        return Float.valueOf(decoder.decodeFloat());
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        fVar.encodeFloat(((Number) obj).floatValue());
    }
}
