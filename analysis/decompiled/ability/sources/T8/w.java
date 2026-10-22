package T8;

import h8.InterfaceC1503K;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;

/* loaded from: classes4.dex */
public final class w extends J5.b {
    public final ProtoBuf$Class e;
    public final w f;
    public final G8.b g;
    public final ProtoBuf$Class.Kind h;
    public final boolean i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(ProtoBuf$Class classProto, D8.f nameResolver, D8.j jVar, InterfaceC1503K interfaceC1503K, w wVar) {
        super(nameResolver, jVar, interfaceC1503K);
        kotlin.jvm.internal.k.f(classProto, "classProto");
        kotlin.jvm.internal.k.f(nameResolver, "nameResolver");
        this.e = classProto;
        this.f = wVar;
        this.g = N9.j.s(nameResolver, classProto.e);
        ProtoBuf$Class.Kind kind = (ProtoBuf$Class.Kind) D8.e.f.c(classProto.d);
        this.h = kind == null ? ProtoBuf$Class.Kind.CLASS : kind;
        this.i = D8.e.g.c(classProto.d).booleanValue();
        D8.e.h.getClass();
    }

    @Override // J5.b
    public final G8.c a() {
        return this.g.a();
    }
}
