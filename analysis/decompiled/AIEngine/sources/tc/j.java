package tc;

import rc.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j implements pc.a<Byte> {

    /* renamed from: a, reason: collision with root package name */
    public static final j f12996a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static final v0 f12997b = new v0("kotlin.Byte", d.b.f11778a);

    @Override // pc.c
    public final void a(vc.k kVar, Object obj) {
        kVar.d(((Number) obj).byteValue());
    }

    @Override // pc.a
    public final Object b(sc.d dVar) {
        return Byte.valueOf(dVar.A());
    }

    @Override // pc.c
    public final rc.e d() {
        return f12997b;
    }
}
