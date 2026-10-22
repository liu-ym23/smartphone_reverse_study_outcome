package tc;

import kotlin.LazyThreadSafetyMode;
import kotlin.collections.EmptyList;
import kotlinx.serialization.SerializationException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o0<T> implements pc.a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f13023a;

    /* renamed from: b, reason: collision with root package name */
    public final EmptyList f13024b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f13025c;

    /* JADX WARN: Multi-variable type inference failed */
    public o0(Object objectInstance) {
        kotlin.jvm.internal.g.f(objectInstance, "objectInstance");
        this.f13023a = objectInstance;
        this.f13024b = EmptyList.f10001a;
        this.f13025c = kotlin.b.a(LazyThreadSafetyMode.f9983a, new b6.g(this, 18));
    }

    @Override // pc.c
    public final void a(vc.k kVar, Object value) {
        kotlin.jvm.internal.g.f(value, "value");
        kVar.b(d()).a(d());
    }

    @Override // pc.a
    public final T b(sc.d dVar) {
        rc.e eVarD = d();
        sc.b bVarB = dVar.b(eVarD);
        int iF = bVarB.f(d());
        if (iF != -1) {
            throw new SerializationException(ai.onnxruntime.providers.a.a(iF, "Unexpected index "));
        }
        lb.n nVar = lb.n.f10413a;
        bVarB.a(eVarD);
        return this.f13023a;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, lb.d] */
    @Override // pc.c
    public final rc.e d() {
        return (rc.e) this.f13025c.getValue();
    }
}
