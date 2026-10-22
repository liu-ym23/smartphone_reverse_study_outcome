package kotlinx.serialization.modules;

import c5.m;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.modules.ContextualProvider;
import p5.l;
import v5.c;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\t\bA¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0018\u001a\u00020\u0019\"\b\b\u0000\u0010\u001a*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001a0\tH\u0096\u0080\u0004JS\u0010\u0018\u001a\u00020\u0019\"\b\b\u0000\u0010\u001a*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00062/\u0010\u001e\u001a+\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u001f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b( \u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000bH\u0096\u0080\u0004JH\u0010!\u001a\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001b\"\b\b\u0001\u0010#*\u0002H\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\"0\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H#0\tH\u0096\u0080\u0004JM\u0010'\u001a\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\"0\u00062)\u0010(\u001a%\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b()\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\f0\u000bH\u0096\u0080\u0004JO\u0010*\u001a\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\"0\u00062+\u0010+\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\u00140\u000bH\u0096\u0080\u0004J\u0012\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.H\u0086\u0080\u0004J4\u0010/\u001a\u00020\u0019\"\b\b\u0000\u0010\u001a*\u00020\u001b2\f\u00100\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00062\u0006\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u00101\u001a\u00020\u0017H\u0081\u0080\u0004JU\u00102\u001a\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\"0\u00062)\u0010(\u001a%\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b()\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\f0\u000b2\u0006\u00101\u001a\u00020\u0017H\u0081\u0080\u0004JW\u00103\u001a\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\"0\u00062+\u0010+\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\u00140\u000b2\u0006\u00101\u001a\u00020\u0017H\u0081\u0080\u0004JR\u00104\u001a\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001b\"\b\b\u0001\u0010#*\u0002H\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\"0\u00062\f\u00105\u001a\b\u0012\u0004\u0012\u0002H#0\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u0002H#0\t2\b\b\u0002\u00101\u001a\u00020\u0017H\u0081\u0080\u0004J\n\u00107\u001a\u00020.H\u0081\u0080\u0004R\u001f\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R3\u0010\b\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00050\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R7\u0010\n\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\f0\u000bj\u0006\u0012\u0002\b\u0003`\r0\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R/\u0010\u000e\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00050\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000RJ\u0010\u0010\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00140\u000bj\u0006\u0012\u0002\b\u0003`\u00150\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0016\u001a\u00020\u0017X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lkotlinx/serialization/modules/SerializersModuleBuilder;", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "<init>", "()V", "class2ContextualProvider", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/reflect/KClass;", "Lkotlinx/serialization/modules/ContextualProvider;", "polyBase2Serializers", "Lkotlinx/serialization/KSerializer;", "polyBase2DefaultSerializerProvider", "Lkotlin/Function1;", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicSerializerProvider;", "polyBase2NamedSerializers", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "polyBase2DefaultDeserializerProvider", "Lkotlin/ParameterName;", "name", "className", "Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/PolymorphicDeserializerProvider;", "hasInterfaceContextualSerializers", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "contextual", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "T", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "kClass", "serializer", ConfigIpcContract.KEY_PROVIDER, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "typeArgumentsSerializers", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "polymorphicDefaultSerializer", "defaultSerializerProvider", "value", "polymorphicDefaultDeserializer", "defaultDeserializerProvider", "include", "module", "Lkotlinx/serialization/modules/SerializersModule;", "registerSerializer", "forClass", "allowOverwrite", "registerDefaultPolymorphicSerializer", "registerDefaultPolymorphicDeserializer", "registerPolymorphicSerializer", "concreteClass", "concreteSerializer", "build", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SerializersModuleBuilder implements SerializersModuleCollector {
    private boolean hasInterfaceContextualSerializers;
    private final Map<c, ContextualProvider> class2ContextualProvider = new HashMap();
    private final Map<c, Map<c, KSerializer<?>>> polyBase2Serializers = new HashMap();
    private final Map<c, l> polyBase2DefaultSerializerProvider = new HashMap();
    private final Map<c, Map<String, KSerializer<?>>> polyBase2NamedSerializers = new HashMap();
    private final Map<c, l> polyBase2DefaultDeserializerProvider = new HashMap();

    public static /* synthetic */ void registerPolymorphicSerializer$default(SerializersModuleBuilder serializersModuleBuilder, c cVar, c cVar2, KSerializer kSerializer, boolean z, int i8, Object obj) {
        if ((i8 & 8) != 0) {
            z = false;
        }
        serializersModuleBuilder.registerPolymorphicSerializer(cVar, cVar2, kSerializer, z);
    }

    public static /* synthetic */ void registerSerializer$default(SerializersModuleBuilder serializersModuleBuilder, c cVar, ContextualProvider contextualProvider, boolean z, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            z = false;
        }
        serializersModuleBuilder.registerSerializer(cVar, contextualProvider, z);
    }

    public final SerializersModule build() {
        return new SerialModuleImpl(this.class2ContextualProvider, this.polyBase2Serializers, this.polyBase2DefaultSerializerProvider, this.polyBase2NamedSerializers, this.polyBase2DefaultDeserializerProvider, this.hasInterfaceContextualSerializers);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <T> void contextual(c kClass, KSerializer<T> serializer) {
        p.e(kClass, "kClass");
        p.e(serializer, "serializer");
        registerSerializer$default(this, kClass, new ContextualProvider.Argless(serializer), false, 4, null);
    }

    public final void include(SerializersModule module) {
        p.e(module, "module");
        module.dumpTo(this);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base, Sub extends Base> void polymorphic(c baseClass, c actualClass, KSerializer<Sub> actualSerializer) {
        p.e(baseClass, "baseClass");
        p.e(actualClass, "actualClass");
        p.e(actualSerializer, "actualSerializer");
        registerPolymorphicSerializer$default(this, baseClass, actualClass, actualSerializer, false, 8, null);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public /* bridge */ <Base> void polymorphicDefault(c cVar, l lVar) {
        super.polymorphicDefault(cVar, lVar);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base> void polymorphicDefaultDeserializer(c baseClass, l defaultDeserializerProvider) {
        p.e(baseClass, "baseClass");
        p.e(defaultDeserializerProvider, "defaultDeserializerProvider");
        registerDefaultPolymorphicDeserializer(baseClass, defaultDeserializerProvider, false);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base> void polymorphicDefaultSerializer(c baseClass, l defaultSerializerProvider) {
        p.e(baseClass, "baseClass");
        p.e(defaultSerializerProvider, "defaultSerializerProvider");
        registerDefaultPolymorphicSerializer(baseClass, defaultSerializerProvider, false);
    }

    public final <Base> void registerDefaultPolymorphicDeserializer(c baseClass, l defaultDeserializerProvider, boolean z) {
        p.e(baseClass, "baseClass");
        p.e(defaultDeserializerProvider, "defaultDeserializerProvider");
        l lVar = this.polyBase2DefaultDeserializerProvider.get(baseClass);
        if (lVar == null || lVar.equals(defaultDeserializerProvider) || z) {
            this.polyBase2DefaultDeserializerProvider.put(baseClass, defaultDeserializerProvider);
            return;
        }
        throw new IllegalArgumentException("Default deserializers provider for " + baseClass + " is already registered: " + lVar);
    }

    public final <Base> void registerDefaultPolymorphicSerializer(c baseClass, l defaultSerializerProvider, boolean z) {
        p.e(baseClass, "baseClass");
        p.e(defaultSerializerProvider, "defaultSerializerProvider");
        l lVar = this.polyBase2DefaultSerializerProvider.get(baseClass);
        if (lVar == null || lVar.equals(defaultSerializerProvider) || z) {
            this.polyBase2DefaultSerializerProvider.put(baseClass, defaultSerializerProvider);
            return;
        }
        throw new IllegalArgumentException("Default serializers provider for " + baseClass + " is already registered: " + lVar);
    }

    public final <Base, Sub extends Base> void registerPolymorphicSerializer(c baseClass, c concreteClass, KSerializer<Sub> concreteSerializer, boolean z) {
        Object next;
        c cVar;
        p.e(baseClass, "baseClass");
        p.e(concreteClass, "concreteClass");
        p.e(concreteSerializer, "concreteSerializer");
        String serialName = concreteSerializer.getDescriptor().getSerialName();
        Map<c, Map<c, KSerializer<?>>> map = this.polyBase2Serializers;
        Map<c, KSerializer<?>> map2 = map.get(baseClass);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(baseClass, map2);
        }
        Map<c, KSerializer<?>> map3 = map2;
        Map<c, Map<String, KSerializer<?>>> map4 = this.polyBase2NamedSerializers;
        Map<String, KSerializer<?>> map5 = map4.get(baseClass);
        if (map5 == null) {
            map5 = new HashMap<>();
            map4.put(baseClass, map5);
        }
        Map<String, KSerializer<?>> map6 = map5;
        KSerializer<?> kSerializer = map3.get(concreteClass);
        if (kSerializer != null && !kSerializer.equals(concreteSerializer)) {
            if (!z) {
                throw new SerializerAlreadyRegisteredException(baseClass, concreteClass);
            }
            map6.remove(kSerializer.getDescriptor().getSerialName());
        }
        KSerializer<?> kSerializer2 = map6.get(serialName);
        if (kSerializer2 != null && !kSerializer2.equals(concreteSerializer)) {
            Iterator it = ((Iterable) m.q0(map3.entrySet()).f1090b).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((Map.Entry) next).getValue() == kSerializer2) {
                        break;
                    }
                }
            }
            Map.Entry entry = (Map.Entry) next;
            if (entry == null || (cVar = (c) entry.getKey()) == null) {
                throw new IllegalStateException(("Name " + serialName + " is registered in the module but no Kotlin class is associated with it.").toString());
            }
            if (!z) {
                throw new IllegalArgumentException("Multiple polymorphic serializers in a scope of '" + baseClass + "' have the same serial name '" + serialName + "': " + concreteSerializer + " for '" + concreteClass + "' and " + kSerializer2 + " for '" + cVar + '\'');
            }
            map3.remove(cVar);
        }
        map3.put(concreteClass, concreteSerializer);
        map6.put(serialName, concreteSerializer);
    }

    public final <T> void registerSerializer(c forClass, ContextualProvider provider, boolean z) {
        ContextualProvider contextualProvider;
        p.e(forClass, "forClass");
        p.e(provider, "provider");
        if (!z && (contextualProvider = this.class2ContextualProvider.get(forClass)) != null && !contextualProvider.equals(provider)) {
            throw new SerializerAlreadyRegisteredException("Contextual serializer or serializer provider for " + forClass + " already registered in this module");
        }
        this.class2ContextualProvider.put(forClass, provider);
        if (PlatformKt.isInterface(forClass)) {
            this.hasInterfaceContextualSerializers = true;
        }
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <T> void contextual(c kClass, l provider) {
        p.e(kClass, "kClass");
        p.e(provider, "provider");
        registerSerializer$default(this, kClass, new ContextualProvider.WithTypeArguments(provider), false, 4, null);
    }
}
