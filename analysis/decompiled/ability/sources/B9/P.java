package B9;

/* loaded from: classes4.dex */
public final class P implements x9.b {

    /* renamed from: a, reason: collision with root package name */
    public final x9.b f227a;
    public final c0 b;

    public P(x9.b serializer) {
        kotlin.jvm.internal.k.f(serializer, "serializer");
        this.f227a = serializer;
        this.b = new c0(serializer.getDescriptor());
    }

    @Override // x9.InterfaceC2123a
    public final Object deserialize(A9.e decoder) {
        kotlin.jvm.internal.k.f(decoder, "decoder");
        return decoder.decodeNotNullMark() ? decoder.decodeSerializableValue(this.f227a) : decoder.decodeNull();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && P.class == obj.getClass() && kotlin.jvm.internal.k.b(this.f227a, ((P) obj).f227a);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final z9.g getDescriptor() {
        return this.b;
    }

    public final int hashCode() {
        return this.f227a.hashCode();
    }

    @Override // x9.f
    public final void serialize(A9.f fVar, Object obj) {
        if (obj == null) {
            fVar.encodeNull();
        } else {
            fVar.encodeNotNullMark();
            fVar.encodeSerializableValue(this.f227a, obj);
        }
    }
}
