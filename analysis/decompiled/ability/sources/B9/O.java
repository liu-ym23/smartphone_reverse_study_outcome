package B9;

import kotlinx.serialization.SerializationException;

/* loaded from: classes4.dex */
public final class O implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public static final O f226a = new O();
    public static final N b = N.f225a;

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        throw new SerializationException("'kotlin.Nothing' does not have instances");
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return b;
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        Void value = (Void) obj;
        kotlin.jvm.internal.k.f(value, "value");
        throw new SerializationException("'kotlin.Nothing' cannot be serialized");
    }
}
