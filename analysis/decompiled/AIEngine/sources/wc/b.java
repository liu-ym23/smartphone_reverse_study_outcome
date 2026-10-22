package wc;

import androidx.datastore.preferences.protobuf.f;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import rc.d;
import rc.e;
import rc.i;
import rc.j;
import vc.j;
import wc.a;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends f {

    /* renamed from: b, reason: collision with root package name */
    public final Map<ec.c<?>, a> f13675b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<ec.c<?>, Map<ec.c<?>, pc.a<?>>> f13676c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<ec.c<?>, l<?, pc.c<?>>> f13677d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<ec.c<?>, l<String, pc.a>> f13678e;

    public b(Map map, Map map2, Map map3, Map map4, Map map5) {
        this.f13675b = map;
        this.f13676c = map2;
        this.f13677d = map3;
        this.f13678e = map5;
    }

    @Override // androidx.datastore.preferences.protobuf.f
    public final void b(j jVar) {
        for (Map.Entry<ec.c<?>, a> entry : this.f13675b.entrySet()) {
            ec.c<?> key = entry.getKey();
            a value = entry.getValue();
            if (value instanceof a.C0166a) {
                g.d(key, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                g.d(null, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                g.f(null, "serializer");
                jVar.a(key, new o6.a(10));
            } else {
                if (!(value instanceof a.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                jVar.a(key, null);
            }
        }
        for (Map.Entry<ec.c<?>, Map<ec.c<?>, pc.a<?>>> entry2 : this.f13676c.entrySet()) {
            ec.c<?> key2 = entry2.getKey();
            for (Map.Entry<ec.c<?>, pc.a<?>> entry3 : entry2.getValue().entrySet()) {
                ec.c<?> key3 = entry3.getKey();
                pc.a<?> value2 = entry3.getValue();
                g.d(key2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                g.d(key3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                g.d(value2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                e eVarD = value2.d();
                i iVarD = eVarD.d();
                if ((iVarD instanceof rc.c) || g.b(iVarD, i.a.f11799a)) {
                    throw new IllegalArgumentException("Serializer for " + key3.c() + " can't be registered as a subclass for polymorphic serialization because its kind " + iVarD + " is not concrete. To work with multiple hierarchies, register it as a base class.");
                }
                if (g.b(iVarD, j.b.f11802a) || g.b(iVarD, j.c.f11803a) || (iVarD instanceof d) || (iVarD instanceof i.b)) {
                    throw new IllegalArgumentException("Serializer for " + key3.c() + " of kind " + iVarD + " cannot be serialized polymorphically with class discriminator.");
                }
                int iE = eVarD.e();
                for (int i10 = 0; i10 < iE; i10++) {
                    String strF = eVarD.f(i10);
                    if (g.b(strF, jVar.f13505a)) {
                        throw new IllegalArgumentException("Polymorphic serializer for " + key3 + " has property '" + strF + "' that conflicts with JSON class discriminator. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
                    }
                }
            }
        }
        for (Map.Entry<ec.c<?>, l<?, pc.c<?>>> entry4 : this.f13677d.entrySet()) {
            ec.c<?> key4 = entry4.getKey();
            l<?, pc.c<?>> value3 = entry4.getValue();
            g.d(key4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            g.d(value3, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"value\")] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>");
            k.c(1, value3);
        }
        for (Map.Entry<ec.c<?>, l<String, pc.a>> entry5 : this.f13678e.entrySet()) {
            ec.c<?> key5 = entry5.getKey();
            l<String, pc.a> value4 = entry5.getValue();
            g.d(key5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            g.d(value4, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"className\")] kotlin.String?, kotlinx.serialization.DeserializationStrategy<kotlin.Any>?>");
            k.c(1, value4);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.f
    public final <T> pc.a<T> c(ec.c<T> cVar, List<? extends pc.a<?>> typeArgumentsSerializers) {
        g.f(typeArgumentsSerializers, "typeArgumentsSerializers");
        a aVar = this.f13675b.get(cVar);
        pc.a<T> aVar2 = aVar != null ? (pc.a<T>) aVar.a(typeArgumentsSerializers) : null;
        if (aVar2 != null) {
            return aVar2;
        }
        return null;
    }

    @Override // androidx.datastore.preferences.protobuf.f
    public final <T> pc.c<T> e(ec.c<? super T> baseClass, T value) {
        g.f(baseClass, "baseClass");
        g.f(value, "value");
        if (baseClass.b(value)) {
            Map<ec.c<?>, pc.a<?>> map = this.f13676c.get(baseClass);
            pc.a<?> aVar = map != null ? map.get(kotlin.jvm.internal.i.a(value.getClass())) : null;
            if (aVar == null) {
                aVar = null;
            }
            if (aVar != null) {
                return aVar;
            }
            l<?, pc.c<?>> lVar = this.f13677d.get(baseClass);
            l<?, pc.c<?>> lVar2 = k.d(1, lVar) ? lVar : null;
            if (lVar2 != null) {
                return (pc.c) lVar2.invoke(value);
            }
        }
        return null;
    }
}
