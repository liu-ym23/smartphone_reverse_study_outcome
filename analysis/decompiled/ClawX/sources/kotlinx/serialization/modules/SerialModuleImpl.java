package kotlinx.serialization.modules;

import a6.w;
import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.modules.ContextualProvider;
import p5.l;
import v5.c;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001Bð\u0001\bF\u0012\u0016\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012*\u0010\u0006\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003\u0012.\u0010\b\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\n0\tj\u0006\u0012\u0002\b\u0003`\u000b0\u0003\u0012&\u0010\f\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003\u0012A\u0010\u000e\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00120\tj\u0006\u0012\u0002\b\u0003`\u00130\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u001b\u0018\u00010\n\"\b\b\u0000\u0010\u001b*\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u001b0\u00042\u0006\u0010\u001e\u001a\u0002H\u001bH\u0096\u0080\u0004¢\u0006\u0002\u0010\u001fJ6\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u001b\u0018\u00010\u0012\"\b\b\u0000\u0010\u001b*\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u001b0\u00042\b\u0010 \u001a\u0004\u0018\u00010\rH\u0096\u0080\u0004J<\u0010!\u001a\n\u0012\u0004\u0012\u0002H\u001b\u0018\u00010\u0007\"\b\b\u0000\u0010\u001b*\u00020\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00042\u0010\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070$H\u0096\u0080\u0004J\u0012\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0096\u0080\u0004R\u001f\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R5\u0010\u0006\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u00038\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R7\u0010\b\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\n0\tj\u0006\u0012\u0002\b\u0003`\u000b0\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R/\u0010\f\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000RJ\u0010\u000e\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00120\tj\u0006\u0012\u0002\b\u0003`\u00130\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0014\u001a\u00020\u0015X\u0090\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lkotlinx/serialization/modules/SerialModuleImpl;", "Lkotlinx/serialization/modules/SerializersModule;", "class2ContextualFactory", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/modules/ContextualProvider;", "polyBase2Serializers", "Lkotlinx/serialization/KSerializer;", "polyBase2DefaultSerializerProvider", "Lkotlin/Function1;", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicSerializerProvider;", "polyBase2NamedSerializers", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "polyBase2DefaultDeserializerProvider", "Lkotlin/ParameterName;", "name", "className", "Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicDeserializerProvider;", "hasInterfaceContextualSerializers", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Z)V", "getHasInterfaceContextualSerializers$kotlinx_serialization_core", "()Z", "getPolymorphic", "T", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "serializedClassName", "getContextual", "kClass", "typeArgumentsSerializers", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "dumpTo", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "collector", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SerialModuleImpl extends SerializersModule {
    private final Map<c, ContextualProvider> class2ContextualFactory;
    private final boolean hasInterfaceContextualSerializers;
    private final Map<c, l> polyBase2DefaultDeserializerProvider;
    private final Map<c, l> polyBase2DefaultSerializerProvider;
    private final Map<c, Map<String, KSerializer<?>>> polyBase2NamedSerializers;
    public final Map<c, Map<c, KSerializer<?>>> polyBase2Serializers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SerialModuleImpl(Map<c, ? extends ContextualProvider> class2ContextualFactory, Map<c, ? extends Map<c, ? extends KSerializer<?>>> polyBase2Serializers, Map<c, ? extends l> polyBase2DefaultSerializerProvider, Map<c, ? extends Map<String, ? extends KSerializer<?>>> polyBase2NamedSerializers, Map<c, ? extends l> polyBase2DefaultDeserializerProvider, boolean z) {
        super(null);
        p.e(class2ContextualFactory, "class2ContextualFactory");
        p.e(polyBase2Serializers, "polyBase2Serializers");
        p.e(polyBase2DefaultSerializerProvider, "polyBase2DefaultSerializerProvider");
        p.e(polyBase2NamedSerializers, "polyBase2NamedSerializers");
        p.e(polyBase2DefaultDeserializerProvider, "polyBase2DefaultDeserializerProvider");
        this.class2ContextualFactory = class2ContextualFactory;
        this.polyBase2Serializers = polyBase2Serializers;
        this.polyBase2DefaultSerializerProvider = polyBase2DefaultSerializerProvider;
        this.polyBase2NamedSerializers = polyBase2NamedSerializers;
        this.polyBase2DefaultDeserializerProvider = polyBase2DefaultDeserializerProvider;
        this.hasInterfaceContextualSerializers = z;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public void dumpTo(SerializersModuleCollector collector) {
        p.e(collector, "collector");
        for (Map.Entry<c, ContextualProvider> entry : this.class2ContextualFactory.entrySet()) {
            c key = entry.getKey();
            ContextualProvider value = entry.getValue();
            if (value instanceof ContextualProvider.Argless) {
                p.c(key, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                KSerializer<?> serializer = ((ContextualProvider.Argless) value).getSerializer();
                p.c(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                collector.contextual(key, serializer);
            } else {
                if (!(value instanceof ContextualProvider.WithTypeArguments)) {
                    throw new w();
                }
                collector.contextual(key, ((ContextualProvider.WithTypeArguments) value).getProvider());
            }
        }
        for (Map.Entry<c, Map<c, KSerializer<?>>> entry2 : this.polyBase2Serializers.entrySet()) {
            c key2 = entry2.getKey();
            for (Map.Entry<c, KSerializer<?>> entry3 : entry2.getValue().entrySet()) {
                c key3 = entry3.getKey();
                KSerializer<?> value2 = entry3.getValue();
                p.c(key2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                p.c(key3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                p.c(value2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                collector.polymorphic(key2, key3, value2);
            }
        }
        for (Map.Entry<c, l> entry4 : this.polyBase2DefaultSerializerProvider.entrySet()) {
            c key4 = entry4.getKey();
            l value3 = entry4.getValue();
            p.c(key4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            p.c(value3, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"value\")] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>");
            d0.a(1, value3);
            collector.polymorphicDefaultSerializer(key4, value3);
        }
        for (Map.Entry<c, l> entry5 : this.polyBase2DefaultDeserializerProvider.entrySet()) {
            c key5 = entry5.getKey();
            l value4 = entry5.getValue();
            p.c(key5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            p.c(value4, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"className\")] kotlin.String?, kotlinx.serialization.DeserializationStrategy<kotlin.Any>?>");
            d0.a(1, value4);
            collector.polymorphicDefaultDeserializer(key5, value4);
        }
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public <T> KSerializer<T> getContextual(c kClass, List<? extends KSerializer<?>> typeArgumentsSerializers) {
        p.e(kClass, "kClass");
        p.e(typeArgumentsSerializers, "typeArgumentsSerializers");
        ContextualProvider contextualProvider = this.class2ContextualFactory.get(kClass);
        KSerializer<T> kSerializer = contextualProvider != null ? (KSerializer<T>) contextualProvider.invoke(typeArgumentsSerializers) : null;
        if (kSerializer instanceof KSerializer) {
            return kSerializer;
        }
        return null;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    /* renamed from: getHasInterfaceContextualSerializers$kotlinx_serialization_core, reason: from getter */
    public boolean getHasInterfaceContextualSerializers() {
        return this.hasInterfaceContextualSerializers;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public <T> SerializationStrategy<T> getPolymorphic(c baseClass, T value) {
        p.e(baseClass, "baseClass");
        p.e(value, "value");
        if (((h) baseClass).c(value)) {
            Map<c, KSerializer<?>> map = this.polyBase2Serializers.get(baseClass);
            KSerializer<?> kSerializer = map != null ? map.get(z.a(value.getClass())) : null;
            KSerializer<?> kSerializer2 = kSerializer instanceof SerializationStrategy ? kSerializer : null;
            if (kSerializer2 != null) {
                return kSerializer2;
            }
            l lVar = this.polyBase2DefaultSerializerProvider.get(baseClass);
            l lVar2 = d0.b(1, lVar) ? lVar : null;
            if (lVar2 != null) {
                return (SerializationStrategy) lVar2.invoke(value);
            }
        }
        return null;
    }

    @Override // kotlinx.serialization.modules.SerializersModule
    public <T> DeserializationStrategy<T> getPolymorphic(c baseClass, String str) {
        p.e(baseClass, "baseClass");
        Map<String, KSerializer<?>> map = this.polyBase2NamedSerializers.get(baseClass);
        KSerializer<?> kSerializer = map != null ? map.get(str) : null;
        if (!(kSerializer instanceof KSerializer)) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        l lVar = this.polyBase2DefaultDeserializerProvider.get(baseClass);
        l lVar2 = d0.b(1, lVar) ? lVar : null;
        if (lVar2 != null) {
            return (DeserializationStrategy) lVar2.invoke(str);
        }
        return null;
    }
}
