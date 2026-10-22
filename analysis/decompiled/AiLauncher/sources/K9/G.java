package K9;

import K9.D;
import Z8.C1173v;
import Z9.InterfaceC1178a;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

/* loaded from: classes5.dex */
public final class G extends D implements Z9.C {

    /* renamed from: b, reason: collision with root package name */
    public final WildcardType f4152b;

    /* renamed from: c, reason: collision with root package name */
    public final Collection<InterfaceC1178a> f4153c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4154d;

    public G(WildcardType reflectType) {
        kotlin.jvm.internal.p.i(reflectType, "reflectType");
        this.f4152b = reflectType;
        this.f4153c = C1173v.m();
    }

    @Override // Z9.d
    public boolean A() {
        return this.f4154d;
    }

    @Override // Z9.C
    public boolean I() {
        kotlin.jvm.internal.p.h(M().getUpperBounds(), "getUpperBounds(...)");
        return !kotlin.jvm.internal.p.d(Z8.r.Z(r1), Object.class);
    }

    @Override // Z9.C
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public D getBound() {
        Type[] upperBounds = M().getUpperBounds();
        Type[] lowerBounds = M().getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + M());
        }
        if (lowerBounds.length == 1) {
            D.a aVar = D.f4146a;
            kotlin.jvm.internal.p.f(lowerBounds);
            Object objE0 = Z8.r.E0(lowerBounds);
            kotlin.jvm.internal.p.h(objE0, "single(...)");
            return aVar.a((Type) objE0);
        }
        if (upperBounds.length == 1) {
            kotlin.jvm.internal.p.f(upperBounds);
            Type type = (Type) Z8.r.E0(upperBounds);
            if (!kotlin.jvm.internal.p.d(type, Object.class)) {
                D.a aVar2 = D.f4146a;
                kotlin.jvm.internal.p.f(type);
                return aVar2.a(type);
            }
        }
        return null;
    }

    @Override // K9.D
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public WildcardType M() {
        return this.f4152b;
    }

    @Override // Z9.d
    public Collection<InterfaceC1178a> getAnnotations() {
        return this.f4153c;
    }
}
