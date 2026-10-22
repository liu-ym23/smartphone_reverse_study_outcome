package tc;

import kotlinx.serialization.SerializationException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m0 implements pc.a {

    /* renamed from: a, reason: collision with root package name */
    public static final m0 f13013a = new m0();

    /* renamed from: b, reason: collision with root package name */
    public static final l0 f13014b = l0.f13007a;

    @Override // pc.c
    public final void a(vc.k kVar, Object obj) {
        Void value = (Void) obj;
        kotlin.jvm.internal.g.f(value, "value");
        throw new SerializationException("'kotlin.Nothing' cannot be serialized");
    }

    @Override // pc.a
    public final Object b(sc.d dVar) {
        throw new SerializationException("'kotlin.Nothing' does not have instances");
    }

    @Override // pc.c
    public final rc.e d() {
        return f13014b;
    }
}
