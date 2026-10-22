package kotlinx.serialization;

import a6.w;
import b5.l;
import c5.o;
import com.stepos.stepclaw.SecurePrefs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;
import v5.i;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\u0086\u0088\u0004\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\u0088\u0004\u001a\u001a\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0080\u0004\u001a8\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0080\u0004\u001a\u001c\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0080\u0004\u001a\u001e\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0080\u0004\u001a<\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001*\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0080\u0004\u001a \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0080\u0004\u001a-\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\fH\u0082\u0080\u0004¢\u0006\u0002\b\u0010\u001aI\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0001*\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0082\u0080\u0004¢\u0006\u0002\b\u0013\u001a4\u0010\u0014\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001\u0018\u00010\n*\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u000f\u001a\u00020\fH\u0080\u0080\u0004\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\u0080\u0004\u001a&\u0010\r\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\u0080\u0004\u001aD\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00040\b2\u0014\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\n2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0080\u0080\u0004\u001a9\u0010\u001b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00040\b2\u0014\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\nH\u0082\u0080\u0004¢\u0006\u0002\b\u001c\u001aI\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00040\b2\u0014\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\n2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0082\u0080\u0004¢\u0006\u0002\b\u001e\u001a3\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010 \u001a\u00020\fH\u0082\u0080\u0004¢\u0006\u0002\b!\u001a\u0016\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010#\u001a\u00020$H\u0081\u0080\u0004\u001a\"\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010%\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0081\u0080\u0004\u001a9\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010%\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010'H\u0081\u0080\u0004¢\u0006\u0002\u0010(\u001a\"\u0010)\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010%\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0081\u0080\u0004\u001a9\u0010)\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010%\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010'H\u0081\u0080\u0004¢\u0006\u0002\u0010(¨\u0006*"}, d2 = {"serializer", "Lkotlinx/serialization/KSerializer;", "T", "Lkotlinx/serialization/modules/SerializersModule;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "type", "Lkotlin/reflect/KType;", "kClass", "Lkotlin/reflect/KClass;", "typeArgumentsSerializers", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isNullable", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "serializerOrNull", "serializerByKTypeImpl", "failOnMissingTypeArgSerializer", "serializerByKTypeImpl$SerializersKt__SerializersKt", "serializerByKClassImpl", "rootClass", "serializerByKClassImpl$SerializersKt__SerializersKt", "serializersForParameters", "typeArguments", "parametrizedSerializerOrNull", "serializers", "elementClassifierIfArray", "Lkotlin/Function0;", "Lkotlin/reflect/KClassifier;", "compiledParametrizedSerializer", "compiledParametrizedSerializer$SerializersKt__SerializersKt", "builtinParametrizedSerializer", "builtinParametrizedSerializer$SerializersKt__SerializersKt", "nullable", "shouldBeNullable", "nullable$SerializersKt__SerializersKt", "noCompiledSerializer", "forClass", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "module", "argSerializers", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "(Lkotlinx/serialization/modules/SerializersModule;Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "moduleThenPolymorphic", "kotlinx-serialization-core"}, k = 5, mv = {2, 3, 0}, xi = 48, xs = "kotlinx/serialization/SerializersKt")
/* loaded from: classes.dex */
final /* synthetic */ class SerializersKt__SerializersKt {
    private static final KSerializer<? extends Object> builtinParametrizedSerializer$SerializersKt__SerializersKt(v5.c cVar, List<? extends KSerializer<Object>> list, p5.a aVar) {
        if (p.a(cVar, z.a(Collection.class)) || p.a(cVar, z.a(List.class)) || p.a(cVar, z.a(List.class)) || p.a(cVar, z.a(ArrayList.class))) {
            return new ArrayListSerializer(list.get(0));
        }
        if (p.a(cVar, z.a(HashSet.class))) {
            return new HashSetSerializer(list.get(0));
        }
        if (p.a(cVar, z.a(Set.class)) || p.a(cVar, z.a(Set.class)) || p.a(cVar, z.a(LinkedHashSet.class))) {
            return new LinkedHashSetSerializer(list.get(0));
        }
        if (p.a(cVar, z.a(HashMap.class))) {
            return new HashMapSerializer(list.get(0), list.get(1));
        }
        if (p.a(cVar, z.a(Map.class)) || p.a(cVar, z.a(Map.class)) || p.a(cVar, z.a(LinkedHashMap.class))) {
            return new LinkedHashMapSerializer(list.get(0), list.get(1));
        }
        if (p.a(cVar, z.a(Map.Entry.class))) {
            return BuiltinSerializersKt.MapEntrySerializer(list.get(0), list.get(1));
        }
        if (p.a(cVar, z.a(b5.g.class))) {
            return BuiltinSerializersKt.PairSerializer(list.get(0), list.get(1));
        }
        if (p.a(cVar, z.a(l.class))) {
            return BuiltinSerializersKt.TripleSerializer(list.get(0), list.get(1), list.get(2));
        }
        if (!PlatformKt.isReferenceArray(cVar)) {
            return null;
        }
        Object objInvoke = aVar.invoke();
        p.c(objInvoke, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        return BuiltinSerializersKt.ArraySerializer((v5.c) objInvoke, list.get(0));
    }

    private static final KSerializer<? extends Object> compiledParametrizedSerializer$SerializersKt__SerializersKt(v5.c cVar, List<? extends KSerializer<Object>> list) {
        KSerializer[] kSerializerArr = (KSerializer[]) list.toArray(new KSerializer[0]);
        return PlatformKt.constructSerializerForGivenTypeArgs(cVar, (KSerializer<Object>[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    public static final KSerializer<?> moduleThenPolymorphic(SerializersModule module, v5.c kClass) {
        p.e(module, "module");
        p.e(kClass, "kClass");
        KSerializer<?> contextual$default = SerializersModule.getContextual$default(module, kClass, null, 2, null);
        return contextual$default == null ? new PolymorphicSerializer(kClass) : contextual$default;
    }

    public static final KSerializer<?> noCompiledSerializer(String forClass) {
        p.e(forClass, "forClass");
        throw new SerializationException(Platform_commonKt.notRegisteredMessage(forClass));
    }

    private static final <T> KSerializer<T> nullable$SerializersKt__SerializersKt(KSerializer<T> kSerializer, boolean z) {
        if (z) {
            return BuiltinSerializersKt.getNullable(kSerializer);
        }
        p.c(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return kSerializer;
    }

    public static final KSerializer<? extends Object> parametrizedSerializerOrNull(v5.c cVar, List<? extends KSerializer<Object>> serializers, p5.a elementClassifierIfArray) {
        p.e(cVar, "<this>");
        p.e(serializers, "serializers");
        p.e(elementClassifierIfArray, "elementClassifierIfArray");
        KSerializer<? extends Object> kSerializerBuiltinParametrizedSerializer$SerializersKt__SerializersKt = builtinParametrizedSerializer$SerializersKt__SerializersKt(cVar, serializers, elementClassifierIfArray);
        return kSerializerBuiltinParametrizedSerializer$SerializersKt__SerializersKt == null ? compiledParametrizedSerializer$SerializersKt__SerializersKt(cVar, serializers) : kSerializerBuiltinParametrizedSerializer$SerializersKt__SerializersKt;
    }

    public static final /* synthetic */ <T> KSerializer<T> serializer() {
        p.i();
        throw null;
    }

    private static final KSerializer<Object> serializerByKClassImpl$SerializersKt__SerializersKt(SerializersModule serializersModule, v5.c cVar, List<? extends KSerializer<Object>> list, boolean z) {
        KSerializer<? extends Object> contextual;
        if (list.isEmpty()) {
            contextual = SerializersKt.serializerOrNull(cVar);
            if (contextual == null) {
                contextual = SerializersModule.getContextual$default(serializersModule, cVar, null, 2, null);
            }
        } else {
            try {
                KSerializer<? extends Object> kSerializerParametrizedSerializerOrNull = SerializersKt.parametrizedSerializerOrNull(cVar, list, new f());
                contextual = kSerializerParametrizedSerializerOrNull == null ? serializersModule.getContextual(cVar, list) : kSerializerParametrizedSerializerOrNull;
            } catch (IndexOutOfBoundsException e9) {
                throw new SerializationException("Unable to retrieve a serializer, the number of passed type serializers differs from the actual number of generic parameters", e9);
            }
        }
        if (contextual != null) {
            return nullable$SerializersKt__SerializersKt(contextual, z);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v5.d serializerByKClassImpl$lambda$0$SerializersKt__SerializersKt() {
        throw new SerializationException("It is not possible to retrieve an array serializer using KClass alone, use KType instead or ArraySerializer factory");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlinx.serialization.KSerializer<java.lang.Object> serializerByKTypeImpl$SerializersKt__SerializersKt(kotlinx.serialization.modules.SerializersModule r6, v5.i r7, boolean r8) {
        /*
            v5.c r0 = kotlinx.serialization.internal.Platform_commonKt.kclass(r7)
            boolean r1 = r7.isMarkedNullable()
            java.util.List r7 = r7.getArguments()
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = c5.o.n0(r7, r3)
            r2.<init>(r3)
            java.util.Iterator r7 = r7.iterator()
        L1b:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L2f
            java.lang.Object r3 = r7.next()
            v5.k r3 = (v5.k) r3
            v5.i r3 = kotlinx.serialization.internal.Platform_commonKt.typeOrThrow(r3)
            r2.add(r3)
            goto L1b
        L2f:
            boolean r7 = r2.isEmpty()
            r3 = 2
            r4 = 0
            if (r7 == 0) goto L4a
            boolean r7 = kotlinx.serialization.internal.PlatformKt.isInterface(r0)
            if (r7 == 0) goto L45
            kotlinx.serialization.KSerializer r7 = kotlinx.serialization.modules.SerializersModule.getContextual$default(r6, r0, r4, r3, r4)
            if (r7 == 0) goto L45
        L43:
            r7 = r4
            goto L5c
        L45:
            kotlinx.serialization.KSerializer r7 = kotlinx.serialization.SerializersCacheKt.findCachedSerializer(r0, r1)
            goto L5c
        L4a:
            boolean r7 = r6.getHasInterfaceContextualSerializers$kotlinx_serialization_core()
            if (r7 == 0) goto L51
            goto L43
        L51:
            java.lang.Object r7 = kotlinx.serialization.SerializersCacheKt.findParametrizedCachedSerializer(r0, r2, r1)
            boolean r5 = r7 instanceof b5.h
            if (r5 == 0) goto L5a
            r7 = r4
        L5a:
            kotlinx.serialization.KSerializer r7 = (kotlinx.serialization.KSerializer) r7
        L5c:
            if (r7 == 0) goto L5f
            return r7
        L5f:
            boolean r7 = r2.isEmpty()
            if (r7 == 0) goto L80
            kotlinx.serialization.KSerializer r7 = kotlinx.serialization.SerializersKt.serializerOrNull(r0)
            if (r7 != 0) goto La6
            kotlinx.serialization.KSerializer r7 = kotlinx.serialization.modules.SerializersModule.getContextual$default(r6, r0, r4, r3, r4)
            if (r7 != 0) goto La6
            boolean r6 = kotlinx.serialization.internal.PlatformKt.isInterface(r0)
            if (r6 == 0) goto L7e
            kotlinx.serialization.PolymorphicSerializer r6 = new kotlinx.serialization.PolymorphicSerializer
            r6.<init>(r0)
        L7c:
            r7 = r6
            goto La6
        L7e:
            r7 = r4
            goto La6
        L80:
            java.util.List r7 = kotlinx.serialization.SerializersKt.serializersForParameters(r6, r2, r8)
            if (r7 != 0) goto L87
            goto Lad
        L87:
            kotlinx.serialization.g r8 = new kotlinx.serialization.g
            r3 = 0
            r8.<init>(r3, r2)
            kotlinx.serialization.KSerializer r8 = kotlinx.serialization.SerializersKt.parametrizedSerializerOrNull(r0, r7, r8)
            if (r8 != 0) goto La5
            kotlinx.serialization.KSerializer r7 = r6.getContextual(r0, r7)
            if (r7 != 0) goto La6
            boolean r6 = kotlinx.serialization.internal.PlatformKt.isInterface(r0)
            if (r6 == 0) goto L7e
            kotlinx.serialization.PolymorphicSerializer r6 = new kotlinx.serialization.PolymorphicSerializer
            r6.<init>(r0)
            goto L7c
        La5:
            r7 = r8
        La6:
            if (r7 == 0) goto Lad
            kotlinx.serialization.KSerializer r6 = nullable$SerializersKt__SerializersKt(r7, r1)
            return r6
        Lad:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.SerializersKt__SerializersKt.serializerByKTypeImpl$SerializersKt__SerializersKt(kotlinx.serialization.modules.SerializersModule, v5.i, boolean):kotlinx.serialization.KSerializer");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v5.d serializerByKTypeImpl$lambda$0$SerializersKt__SerializersKt(List list) {
        return ((i) list.get(0)).getClassifier();
    }

    public static final KSerializer<Object> serializerOrNull(i type) {
        p.e(type, "type");
        return SerializersKt.serializerOrNull(SerializersModuleBuildersKt.EmptySerializersModule(), type);
    }

    public static final List<KSerializer<Object>> serializersForParameters(SerializersModule serializersModule, List<? extends i> typeArguments, boolean z) {
        p.e(serializersModule, "<this>");
        p.e(typeArguments, "typeArguments");
        if (z) {
            ArrayList arrayList = new ArrayList(o.n0(typeArguments, 10));
            Iterator<T> it = typeArguments.iterator();
            while (it.hasNext()) {
                arrayList.add(SerializersKt.serializer(serializersModule, (i) it.next()));
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(o.n0(typeArguments, 10));
        Iterator<T> it2 = typeArguments.iterator();
        while (it2.hasNext()) {
            KSerializer<Object> kSerializerSerializerOrNull = SerializersKt.serializerOrNull(serializersModule, (i) it2.next());
            if (kSerializerSerializerOrNull == null) {
                return null;
            }
            arrayList2.add(kSerializerSerializerOrNull);
        }
        return arrayList2;
    }

    public static final KSerializer<?> moduleThenPolymorphic(SerializersModule module, v5.c kClass, KSerializer<?>[] argSerializers) {
        p.e(module, "module");
        p.e(kClass, "kClass");
        p.e(argSerializers, "argSerializers");
        KSerializer<?> contextual = module.getContextual(kClass, c5.l.S(argSerializers));
        return contextual == null ? new PolymorphicSerializer(kClass) : contextual;
    }

    public static final KSerializer<?> noCompiledSerializer(SerializersModule module, v5.c kClass) {
        p.e(module, "module");
        p.e(kClass, "kClass");
        KSerializer<?> contextual$default = SerializersModule.getContextual$default(module, kClass, null, 2, null);
        if (contextual$default != null) {
            return contextual$default;
        }
        Platform_commonKt.serializerNotRegistered(kClass);
        throw new w();
    }

    public static final /* synthetic */ <T> KSerializer<T> serializer(SerializersModule serializersModule) {
        p.e(serializersModule, "<this>");
        p.i();
        throw null;
    }

    public static final KSerializer<Object> serializerOrNull(SerializersModule serializersModule, i type) {
        p.e(serializersModule, "<this>");
        p.e(type, "type");
        return serializerByKTypeImpl$SerializersKt__SerializersKt(serializersModule, type, false);
    }

    public static final KSerializer<Object> serializer(i type) {
        p.e(type, "type");
        return SerializersKt.serializer(SerializersModuleBuildersKt.EmptySerializersModule(), type);
    }

    @InternalSerializationApi
    public static final <T> KSerializer<T> serializerOrNull(v5.c cVar) {
        p.e(cVar, "<this>");
        KSerializer<T> kSerializerCompiledSerializerImpl = PlatformKt.compiledSerializerImpl(cVar);
        return kSerializerCompiledSerializerImpl == null ? PrimitivesKt.builtinSerializerOrNull(cVar) : kSerializerCompiledSerializerImpl;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<Object> serializer(v5.c kClass, List<? extends KSerializer<?>> typeArgumentsSerializers, boolean z) {
        p.e(kClass, "kClass");
        p.e(typeArgumentsSerializers, "typeArgumentsSerializers");
        return SerializersKt.serializer(SerializersModuleBuildersKt.EmptySerializersModule(), kClass, typeArgumentsSerializers, z);
    }

    public static final KSerializer<?> noCompiledSerializer(SerializersModule module, v5.c kClass, KSerializer<?>[] argSerializers) {
        p.e(module, "module");
        p.e(kClass, "kClass");
        p.e(argSerializers, "argSerializers");
        KSerializer<?> contextual = module.getContextual(kClass, c5.l.S(argSerializers));
        if (contextual != null) {
            return contextual;
        }
        Platform_commonKt.serializerNotRegistered(kClass);
        throw new w();
    }

    public static final KSerializer<Object> serializer(SerializersModule serializersModule, i type) {
        p.e(serializersModule, "<this>");
        p.e(type, "type");
        KSerializer<Object> kSerializerSerializerByKTypeImpl$SerializersKt__SerializersKt = serializerByKTypeImpl$SerializersKt__SerializersKt(serializersModule, type, true);
        if (kSerializerSerializerByKTypeImpl$SerializersKt__SerializersKt != null) {
            return kSerializerSerializerByKTypeImpl$SerializersKt__SerializersKt;
        }
        PlatformKt.platformSpecificSerializerNotRegistered(Platform_commonKt.kclass(type));
        throw new w();
    }

    @ExperimentalSerializationApi
    public static final KSerializer<Object> serializer(SerializersModule serializersModule, v5.c kClass, List<? extends KSerializer<?>> typeArgumentsSerializers, boolean z) {
        p.e(serializersModule, "<this>");
        p.e(kClass, "kClass");
        p.e(typeArgumentsSerializers, "typeArgumentsSerializers");
        KSerializer<Object> kSerializerSerializerByKClassImpl$SerializersKt__SerializersKt = serializerByKClassImpl$SerializersKt__SerializersKt(serializersModule, kClass, typeArgumentsSerializers, z);
        if (kSerializerSerializerByKClassImpl$SerializersKt__SerializersKt != null) {
            return kSerializerSerializerByKClassImpl$SerializersKt__SerializersKt;
        }
        PlatformKt.platformSpecificSerializerNotRegistered(kClass);
        throw new w();
    }

    @InternalSerializationApi
    public static final <T> KSerializer<T> serializer(v5.c cVar) {
        p.e(cVar, "<this>");
        KSerializer<T> kSerializerSerializerOrNull = SerializersKt.serializerOrNull(cVar);
        if (kSerializerSerializerOrNull != null) {
            return kSerializerSerializerOrNull;
        }
        Platform_commonKt.serializerNotRegistered(cVar);
        throw new w();
    }
}
