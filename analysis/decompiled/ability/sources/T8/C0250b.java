package T8;

import h8.InterfaceC1540w;
import i8.C1557c;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;

/* renamed from: T8.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0250b extends A8.b implements InterfaceC0249a {
    public final C0252d b;

    public C0250b(InterfaceC1540w module, u1.d dVar, S8.a protocol) {
        kotlin.jvm.internal.k.f(module, "module");
        kotlin.jvm.internal.k.f(protocol, "protocol");
        kotlin.jvm.internal.k.f(protocol, "protocol");
        this.f160a = protocol;
        this.b = new C0252d(module, dVar);
    }

    public final C1557c P0(ProtoBuf$Annotation proto, D8.f nameResolver) {
        kotlin.jvm.internal.k.f(proto, "proto");
        kotlin.jvm.internal.k.f(nameResolver, "nameResolver");
        return this.b.a(proto, nameResolver);
    }

    @Override // T8.InterfaceC0249a
    public final Object W(J5.b bVar, ProtoBuf$Property proto, X8.w wVar) {
        kotlin.jvm.internal.k.f(proto, "proto");
        return null;
    }

    @Override // T8.InterfaceC0249a
    public final Object n0(J5.b bVar, ProtoBuf$Property proto, X8.w wVar) {
        kotlin.jvm.internal.k.f(proto, "proto");
        ProtoBuf$Annotation.Argument.Value value = (ProtoBuf$Annotation.Argument.Value) D8.h.a(proto, ((S8.a) this.f160a).i);
        if (value == null) {
            return null;
        }
        return this.b.c(wVar, value, (D8.f) bVar.b);
    }
}
