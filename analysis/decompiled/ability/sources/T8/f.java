package T8;

import h8.InterfaceC1503K;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final D8.f f1218a;
    public final ProtoBuf$Class b;
    public final D8.a c;
    public final InterfaceC1503K d;

    public f(D8.f nameResolver, ProtoBuf$Class classProto, D8.a aVar, InterfaceC1503K sourceElement) {
        kotlin.jvm.internal.k.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.k.f(classProto, "classProto");
        kotlin.jvm.internal.k.f(sourceElement, "sourceElement");
        this.f1218a = nameResolver;
        this.b = classProto;
        this.c = aVar;
        this.d = sourceElement;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kotlin.jvm.internal.k.b(this.f1218a, fVar.f1218a) && kotlin.jvm.internal.k.b(this.b, fVar.b) && kotlin.jvm.internal.k.b(this.c, fVar.c) && kotlin.jvm.internal.k.b(this.d, fVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.f1218a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ClassData(nameResolver=" + this.f1218a + ", classProto=" + this.b + ", metadataVersion=" + this.c + ", sourceElement=" + this.d + ')';
    }
}
