package K9;

import Z8.C1173v;
import Z9.InterfaceC1178a;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: classes5.dex */
public final class B extends D implements Z9.v {

    /* renamed from: b, reason: collision with root package name */
    public final Class<?> f4142b;

    /* renamed from: c, reason: collision with root package name */
    public final Collection<InterfaceC1178a> f4143c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4144d;

    public B(Class<?> reflectType) {
        kotlin.jvm.internal.p.i(reflectType, "reflectType");
        this.f4142b = reflectType;
        this.f4143c = C1173v.m();
    }

    @Override // Z9.d
    public boolean A() {
        return this.f4144d;
    }

    @Override // K9.D
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public Class<?> M() {
        return this.f4142b;
    }

    @Override // Z9.d
    public Collection<InterfaceC1178a> getAnnotations() {
        return this.f4143c;
    }

    @Override // Z9.v
    public PrimitiveType getType() {
        if (kotlin.jvm.internal.p.d(M(), Void.TYPE)) {
            return null;
        }
        return JvmPrimitiveType.get(M().getName()).getPrimitiveType();
    }
}
