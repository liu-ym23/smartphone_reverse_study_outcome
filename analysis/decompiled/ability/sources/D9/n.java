package D9;

import z9.AbstractC2202d;

/* loaded from: classes4.dex */
public class n implements E9.f {

    /* renamed from: a, reason: collision with root package name */
    public String f443a;
    public boolean b;

    @Override // E9.f
    public void a(Z7.d kClass, S7.k kVar) {
        kotlin.jvm.internal.k.f(kClass, "kClass");
    }

    @Override // E9.f
    public void b(Z7.d dVar, Z7.d dVar2, x9.b bVar) {
        boolean z10 = this.b;
        z9.g descriptor = bVar.getDescriptor();
        H4.o kind = descriptor.getKind();
        if ((kind instanceof AbstractC2202d) || kotlin.jvm.internal.k.b(kind, z9.i.c)) {
            throw new IllegalArgumentException("Serializer for " + dVar2.m() + " can't be registered as a subclass for polymorphic serialization because its kind " + kind + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if (z10 && (kotlin.jvm.internal.k.b(kind, z9.k.d) || kotlin.jvm.internal.k.b(kind, z9.k.e) || (kind instanceof z9.f) || (kind instanceof z9.j))) {
            throw new IllegalArgumentException("Serializer for " + dVar2.m() + " of kind " + kind + " cannot be serialized polymorphically with class discriminator.");
        }
        if (z10) {
            int iD = descriptor.d();
            for (int i = 0; i < iD; i++) {
                String strE = descriptor.e(i);
                if (kotlin.jvm.internal.k.b(strE, this.f443a)) {
                    throw new IllegalArgumentException("Polymorphic serializer for " + dVar2 + " has property '" + strE + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
                }
            }
        }
    }

    @Override // E9.f
    public void h(Z7.d dVar, S7.k kVar) {
    }

    @Override // E9.f
    public void i(Z7.d dVar, S7.k kVar) {
    }
}
