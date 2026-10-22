package x9;

import B9.AbstractC0175b;
import i9.l;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import z9.g;

/* loaded from: classes4.dex */
public final class c extends AbstractC0175b {

    /* renamed from: a, reason: collision with root package name */
    public final Z7.d f6883a;
    public final EmptyList b;
    public final Object c;

    public c(Z7.d baseClass) {
        k.f(baseClass, "baseClass");
        this.f6883a = baseClass;
        this.b = EmptyList.f4893a;
        this.c = kotlin.a.b(LazyThreadSafetyMode.b, new l(this, 6));
    }

    @Override // B9.AbstractC0175b
    public final Z7.d c() {
        return this.f6883a;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [C7.f, java.lang.Object] */
    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return (g) this.c.getF4884a();
    }

    public final String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + this.f6883a + ')';
    }
}
