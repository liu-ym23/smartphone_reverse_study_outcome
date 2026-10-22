package kotlinx.serialization;

import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.CachingKt;
import kotlinx.serialization.internal.ParametrizedSerializerCache;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.SerializerCache;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;
import p5.l;
import p5.p;
import v5.i;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0080\u0080\u0004\u001aC\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n0\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0080\u0080\u0004¢\u0006\u0002\u0010\u0014\u001a\u001c\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u0016*\u0006\u0012\u0002\b\u00030\fH\u0080\u0088\u0004\"\u001f\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00018\u0000X\u0081\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018\u0002X\u0083\u0084\b¢\u0006\u0002\n\u0000\"\u0019\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00078\u0002X\u0083\u0084\b¢\u0006\u0002\n\u0000\"\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00078\u0002X\u0083\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"SERIALIZERS_CACHE", "Lkotlinx/serialization/internal/SerializerCache;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getSERIALIZERS_CACHE", "()Lkotlinx/serialization/internal/SerializerCache;", "SERIALIZERS_CACHE_NULLABLE", "PARAMETRIZED_SERIALIZERS_CACHE", "Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE", "findCachedSerializer", "Lkotlinx/serialization/KSerializer;", "clazz", "Lkotlin/reflect/KClass;", "isNullable", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "findParametrizedCachedSerializer", "Lkotlin/Result;", "types", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KClass;Ljava/util/List;Z)Ljava/lang/Object;", "polymorphicIfInterface", "Lkotlinx/serialization/PolymorphicSerializer;", "kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SerializersCacheKt {
    private static final ParametrizedSerializerCache<? extends Object> PARAMETRIZED_SERIALIZERS_CACHE;
    private static final ParametrizedSerializerCache<Object> PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE;
    private static final SerializerCache<? extends Object> SERIALIZERS_CACHE;
    private static final SerializerCache<Object> SERIALIZERS_CACHE_NULLABLE;

    static {
        final int i8 = 0;
        SERIALIZERS_CACHE = CachingKt.createCache(new l() { // from class: kotlinx.serialization.c
            @Override // p5.l
            public final Object invoke(Object obj) {
                v5.c cVar = (v5.c) obj;
                switch (i8) {
                    case 0:
                        return SerializersCacheKt.SERIALIZERS_CACHE$lambda$0(cVar);
                    default:
                        return SerializersCacheKt.SERIALIZERS_CACHE_NULLABLE$lambda$0(cVar);
                }
            }
        });
        final int i9 = 1;
        SERIALIZERS_CACHE_NULLABLE = CachingKt.createCache(new l() { // from class: kotlinx.serialization.c
            @Override // p5.l
            public final Object invoke(Object obj) {
                v5.c cVar = (v5.c) obj;
                switch (i9) {
                    case 0:
                        return SerializersCacheKt.SERIALIZERS_CACHE$lambda$0(cVar);
                    default:
                        return SerializersCacheKt.SERIALIZERS_CACHE_NULLABLE$lambda$0(cVar);
                }
            }
        });
        final int i10 = 0;
        PARAMETRIZED_SERIALIZERS_CACHE = CachingKt.createParametrizedCache(new p() { // from class: kotlinx.serialization.d
            @Override // p5.p
            public final Object invoke(Object obj, Object obj2) {
                v5.c cVar = (v5.c) obj;
                List list = (List) obj2;
                switch (i10) {
                    case 0:
                        return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE$lambda$0(cVar, list);
                    default:
                        return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$0(cVar, list);
                }
            }
        });
        final int i11 = 1;
        PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE = CachingKt.createParametrizedCache(new p() { // from class: kotlinx.serialization.d
            @Override // p5.p
            public final Object invoke(Object obj, Object obj2) {
                v5.c cVar = (v5.c) obj;
                List list = (List) obj2;
                switch (i11) {
                    case 0:
                        return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE$lambda$0(cVar, list);
                    default:
                        return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$0(cVar, list);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer PARAMETRIZED_SERIALIZERS_CACHE$lambda$0(v5.c clazz, List types) {
        kotlin.jvm.internal.p.e(clazz, "clazz");
        kotlin.jvm.internal.p.e(types, "types");
        List<KSerializer<Object>> listSerializersForParameters = SerializersKt.serializersForParameters(SerializersModuleBuildersKt.EmptySerializersModule(), types, true);
        kotlin.jvm.internal.p.b(listSerializersForParameters);
        return SerializersKt.parametrizedSerializerOrNull(clazz, listSerializersForParameters, new e(0, types));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v5.d PARAMETRIZED_SERIALIZERS_CACHE$lambda$0$0(List list) {
        return ((i) list.get(0)).getClassifier();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$0(v5.c clazz, List types) {
        KSerializer nullable;
        kotlin.jvm.internal.p.e(clazz, "clazz");
        kotlin.jvm.internal.p.e(types, "types");
        List<KSerializer<Object>> listSerializersForParameters = SerializersKt.serializersForParameters(SerializersModuleBuildersKt.EmptySerializersModule(), types, true);
        kotlin.jvm.internal.p.b(listSerializersForParameters);
        KSerializer<? extends Object> kSerializerParametrizedSerializerOrNull = SerializersKt.parametrizedSerializerOrNull(clazz, listSerializersForParameters, new e(1, types));
        if (kSerializerParametrizedSerializerOrNull == null || (nullable = BuiltinSerializersKt.getNullable(kSerializerParametrizedSerializerOrNull)) == null) {
            return null;
        }
        return nullable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v5.d PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$0$0(List list) {
        return ((i) list.get(0)).getClassifier();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer SERIALIZERS_CACHE$lambda$0(v5.c it) {
        kotlin.jvm.internal.p.e(it, "it");
        KSerializer kSerializerSerializerOrNull = SerializersKt.serializerOrNull(it);
        if (kSerializerSerializerOrNull != null) {
            return kSerializerSerializerOrNull;
        }
        if (PlatformKt.isInterface(it)) {
            return new PolymorphicSerializer(it);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KSerializer SERIALIZERS_CACHE_NULLABLE$lambda$0(v5.c it) {
        KSerializer nullable;
        kotlin.jvm.internal.p.e(it, "it");
        KSerializer kSerializerSerializerOrNull = SerializersKt.serializerOrNull(it);
        if (kSerializerSerializerOrNull == null) {
            kSerializerSerializerOrNull = PlatformKt.isInterface(it) ? new PolymorphicSerializer(it) : null;
        }
        if (kSerializerSerializerOrNull == null || (nullable = BuiltinSerializersKt.getNullable(kSerializerSerializerOrNull)) == null) {
            return null;
        }
        return nullable;
    }

    public static final KSerializer<Object> findCachedSerializer(v5.c clazz, boolean z) {
        kotlin.jvm.internal.p.e(clazz, "clazz");
        if (z) {
            return SERIALIZERS_CACHE_NULLABLE.get(clazz);
        }
        KSerializer<? extends Object> kSerializer = SERIALIZERS_CACHE.get(clazz);
        if (kSerializer != null) {
            return kSerializer;
        }
        return null;
    }

    public static final Object findParametrizedCachedSerializer(v5.c clazz, List<? extends i> types, boolean z) {
        kotlin.jvm.internal.p.e(clazz, "clazz");
        kotlin.jvm.internal.p.e(types, "types");
        return !z ? PARAMETRIZED_SERIALIZERS_CACHE.mo0getgIAlus(clazz, types) : PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE.mo0getgIAlus(clazz, types);
    }

    public static final SerializerCache<? extends Object> getSERIALIZERS_CACHE() {
        return SERIALIZERS_CACHE;
    }

    public static final PolymorphicSerializer<? extends Object> polymorphicIfInterface(v5.c cVar) {
        kotlin.jvm.internal.p.e(cVar, "<this>");
        if (PlatformKt.isInterface(cVar)) {
            return new PolymorphicSerializer<>(cVar);
        }
        return null;
    }
}
