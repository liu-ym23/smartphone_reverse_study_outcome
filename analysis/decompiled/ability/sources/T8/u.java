package T8;

import H8.AbstractC0241b;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;

/* loaded from: classes4.dex */
public final class u implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final v f1234a;
    public final J5.b b;
    public final AbstractC0241b c;
    public final AnnotatedCallableKind d;
    public final int e;
    public final ProtoBuf$ValueParameter f;

    public u(v vVar, J5.b bVar, AbstractC0241b abstractC0241b, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        this.f1234a = vVar;
        this.b = bVar;
        this.c = abstractC0241b;
        this.d = annotatedCallableKind;
        this.e = i;
        this.f = protoBuf$ValueParameter;
    }

    @Override // S7.a
    public final Object invoke() {
        return D7.v.f1(this.f1234a.f1235a.f1228a.e.Z(this.b, this.c, this.d, this.e, this.f));
    }
}
