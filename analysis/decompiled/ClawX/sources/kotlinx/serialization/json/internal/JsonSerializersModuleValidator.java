package kotlinx.serialization.json.internal;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.modules.SerializersModuleCollector;
import p5.l;
import v5.c;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JS\u0010\t\u001a\u00020\n\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e2/\u0010\u000f\u001a+\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0011¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0010H\u0096\u0080\u0004JH\u0010\u0016\u001a\u00020\n\"\b\b\u0000\u0010\u0017*\u00020\f\"\b\b\u0001\u0010\u0018*\u0002H\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0012H\u0096\u0080\u0004J\u001e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0082\u0080\u0004JM\u0010\u001f\u001a\u00020\n\"\b\b\u0000\u0010\u0017*\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000e2)\u0010 \u001a%\u0012\u0013\u0012\u0011H\u0017¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(!\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010\"0\u0010H\u0096\u0080\u0004JO\u0010#\u001a\u00020\n\"\b\b\u0000\u0010\u0017*\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000e2+\u0010$\u001a'\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(&\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0017\u0018\u00010'0\u0010H\u0096\u0080\u0004R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lkotlinx/serialization/json/internal/JsonSerializersModuleValidator;", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;)V", "useArrayPolymorphism", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isDiscriminatorRequired", "contextual", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "T", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "kClass", "Lkotlin/reflect/KClass;", ConfigIpcContract.KEY_PROVIDER, "Lkotlin/Function1;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlinx/serialization/KSerializer;", "Lkotlin/ParameterName;", "name", "typeArgumentsSerializers", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "checkKind", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "polymorphicDefaultSerializer", "defaultSerializerProvider", "value", "Lkotlinx/serialization/SerializationStrategy;", "polymorphicDefaultDeserializer", "defaultDeserializerProvider", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "className", "Lkotlinx/serialization/DeserializationStrategy;", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsonSerializersModuleValidator implements SerializersModuleCollector {
    private final boolean isDiscriminatorRequired;
    private final boolean useArrayPolymorphism;

    public JsonSerializersModuleValidator(JsonConfiguration configuration) {
        p.e(configuration, "configuration");
        this.useArrayPolymorphism = configuration.getUseArrayPolymorphism();
        this.isDiscriminatorRequired = configuration.getClassDiscriminatorMode() != ClassDiscriminatorMode.NONE;
    }

    private final void checkKind(SerialDescriptor serialDescriptor, c cVar) {
        SerialKind kind = serialDescriptor.getKind();
        if ((kind instanceof PolymorphicKind) || p.a(kind, SerialKind.CONTEXTUAL.INSTANCE)) {
            throw new IllegalArgumentException("Serializer for " + ((h) cVar).b() + " can't be registered as a subclass for polymorphic serialization because its kind " + kind + " is not concrete. To work with multiple hierarchies, register it as a base class.");
        }
        if (!this.useArrayPolymorphism && this.isDiscriminatorRequired) {
            if (p.a(kind, StructureKind.LIST.INSTANCE) || p.a(kind, StructureKind.MAP.INSTANCE) || (kind instanceof PrimitiveKind) || (kind instanceof SerialKind.ENUM)) {
                throw new IllegalArgumentException("Serializer for " + ((h) cVar).b() + " of kind " + kind + " cannot be serialized polymorphically with class discriminator.");
            }
        }
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <T> void contextual(c kClass, l provider) {
        p.e(kClass, "kClass");
        p.e(provider, "provider");
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base, Sub extends Base> void polymorphic(c baseClass, c actualClass, KSerializer<Sub> actualSerializer) {
        p.e(baseClass, "baseClass");
        p.e(actualClass, "actualClass");
        p.e(actualSerializer, "actualSerializer");
        checkKind(actualSerializer.getDescriptor(), actualClass);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public /* bridge */ <Base> void polymorphicDefault(c cVar, l lVar) {
        super.polymorphicDefault(cVar, lVar);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base> void polymorphicDefaultDeserializer(c baseClass, l defaultDeserializerProvider) {
        p.e(baseClass, "baseClass");
        p.e(defaultDeserializerProvider, "defaultDeserializerProvider");
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public <Base> void polymorphicDefaultSerializer(c baseClass, l defaultSerializerProvider) {
        p.e(baseClass, "baseClass");
        p.e(defaultSerializerProvider, "defaultSerializerProvider");
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public /* bridge */ <T> void contextual(c cVar, KSerializer<T> kSerializer) {
        super.contextual(cVar, kSerializer);
    }
}
