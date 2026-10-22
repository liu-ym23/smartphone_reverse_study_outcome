package tc;

import rc.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a1 implements pc.a<Short> {

    /* renamed from: a, reason: collision with root package name */
    public static final a1 f12961a = new a1();

    /* renamed from: b, reason: collision with root package name */
    public static final v0 f12962b = new v0("kotlin.Short", d.h.f11784a);

    @Override // pc.c
    public final void a(vc.k kVar, Object obj) {
        kVar.m(((Number) obj).shortValue());
    }

    @Override // pc.a
    public final Object b(sc.d dVar) {
        return Short.valueOf(dVar.l());
    }

    @Override // pc.c
    public final rc.e d() {
        return f12962b;
    }
}
