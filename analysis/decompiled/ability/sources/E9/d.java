package E9;

import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.p;

/* loaded from: classes4.dex */
public final class d extends e {

    /* renamed from: a, reason: collision with root package name */
    public final Map f498a;
    public final Map b;
    public final Map c;
    public final Map d;
    public final Map e;

    public d(Map class2ContextualFactory, Map polyBase2Serializers, Map polyBase2DefaultSerializerProvider, Map polyBase2NamedSerializers, Map polyBase2DefaultDeserializerProvider, boolean z10) {
        k.f(class2ContextualFactory, "class2ContextualFactory");
        k.f(polyBase2Serializers, "polyBase2Serializers");
        k.f(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        k.f(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        k.f(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        this.f498a = class2ContextualFactory;
        this.b = polyBase2Serializers;
        this.c = polyBase2DefaultSerializerProvider;
        this.d = polyBase2NamedSerializers;
        this.e = polyBase2DefaultDeserializerProvider;
    }

    @Override // E9.e
    public final void a(f fVar) {
        for (Map.Entry entry : this.f498a.entrySet()) {
            Z7.d dVar = (Z7.d) entry.getKey();
            c cVar = (c) entry.getValue();
            if (cVar instanceof a) {
                k.d(dVar, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                x9.b bVar = ((a) cVar).f496a;
                k.d(bVar, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                fVar.o(dVar, bVar);
            } else {
                if (!(cVar instanceof b)) {
                    throw new NoWhenBranchMatchedException();
                }
                fVar.a(dVar, ((b) cVar).f497a);
            }
        }
        for (Map.Entry entry2 : this.b.entrySet()) {
            Z7.d dVar2 = (Z7.d) entry2.getKey();
            for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                Z7.d dVar3 = (Z7.d) entry3.getKey();
                x9.b bVar2 = (x9.b) entry3.getValue();
                k.d(dVar2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                k.d(dVar3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                k.d(bVar2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                fVar.b(dVar2, dVar3, bVar2);
            }
        }
        for (Map.Entry entry4 : this.c.entrySet()) {
            Z7.d dVar4 = (Z7.d) entry4.getKey();
            S7.k kVar = (S7.k) entry4.getValue();
            k.d(dVar4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            k.d(kVar, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"value\")] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>");
            p.e(1, kVar);
            fVar.h(dVar4, kVar);
        }
        for (Map.Entry entry5 : this.e.entrySet()) {
            Z7.d dVar5 = (Z7.d) entry5.getKey();
            S7.k kVar2 = (S7.k) entry5.getValue();
            k.d(dVar5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            k.d(kVar2, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"className\")] kotlin.String?, kotlinx.serialization.DeserializationStrategy<kotlin.Any>?>");
            p.e(1, kVar2);
            fVar.i(dVar5, kVar2);
        }
    }

    @Override // E9.e
    public final x9.b b(Z7.d dVar, List typeArgumentsSerializers) {
        k.f(typeArgumentsSerializers, "typeArgumentsSerializers");
        c cVar = (c) this.f498a.get(dVar);
        x9.b bVarA = cVar != null ? cVar.a(typeArgumentsSerializers) : null;
        if (bVarA instanceof x9.b) {
            return bVarA;
        }
        return null;
    }
}
