package kotlinx.serialization.modules;

import b5.g;
import com.stepos.stepclaw.SecurePrefs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.descriptors.PolymorphicKind;
import p5.l;
import v5.c;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0002B)\bA\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0012\u001a\u00020\u0013\"\n\b\u0001\u0010\u0014\u0018\u0001*\u00028\u0000H\u0087\u0088\u0004J\"\u0010\u0012\u001a\u00020\u0013\"\b\b\u0001\u0010\u0014*\u00028\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0006H\u0087\u0080\u0004J0\u0010\u0016\u001a\u00020\u0013\"\b\b\u0001\u0010\u0014*\u00028\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0006H\u0086\u0080\u0004J7\u0010\u0017\u001a\u00020\u00132+\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00110\rH\u0086\u0080\u0004J7\u0010\u001b\u001a\u00020\u00132+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00110\rH\u0087\u0080\u0004J\u0012\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0081\u0080\u0004R\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000R1\u0010\t\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00060\u000b0\nX\u0082\u0084\b¢\u0006\u0002\n\u0000R%\u0010\f\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\u0018\u00010\rX\u0082\u008e\b¢\u0006\u0002\n\u0000R'\u0010\u000f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011\u0018\u00010\rX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "Base", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "baseClass", "Lkotlin/reflect/KClass;", "baseSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "subclasses", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/Pair;", "defaultSerializerProvider", "Lkotlin/Function1;", "Lkotlinx/serialization/SerializationStrategy;", "defaultDeserializerProvider", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlinx/serialization/DeserializationStrategy;", "subclassesOfSealed", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "T", "serializer", "subclass", "defaultDeserializer", "Lkotlin/ParameterName;", "name", "className", "default", "buildTo", "builder", "Lkotlinx/serialization/modules/SerializersModuleBuilder;", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolymorphicModuleBuilder<Base> {
    private final c baseClass;
    private final KSerializer<Base> baseSerializer;
    private l defaultDeserializerProvider;
    private l defaultSerializerProvider;
    private final List<g> subclasses;

    public PolymorphicModuleBuilder(c baseClass, KSerializer<Base> kSerializer) {
        p.e(baseClass, "baseClass");
        this.baseClass = baseClass;
        this.baseSerializer = kSerializer;
        this.subclasses = new ArrayList();
    }

    public final void buildTo(SerializersModuleBuilder builder) {
        p.e(builder, "builder");
        KSerializer<Base> kSerializer = this.baseSerializer;
        if (kSerializer != null) {
            c cVar = this.baseClass;
            SerializersModuleBuilder.registerPolymorphicSerializer$default(builder, cVar, cVar, kSerializer, false, 8, null);
        }
        for (g gVar : this.subclasses) {
            c cVar2 = (c) gVar.f892a;
            KSerializer kSerializer2 = (KSerializer) gVar.f893b;
            c cVar3 = this.baseClass;
            p.c(cVar2, "null cannot be cast to non-null type kotlin.reflect.KClass<Base of kotlinx.serialization.modules.PolymorphicModuleBuilder>");
            p.c(kSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            SerializersModuleBuilder.registerPolymorphicSerializer$default(builder, cVar3, cVar2, kSerializer2, false, 8, null);
        }
        l lVar = this.defaultSerializerProvider;
        if (lVar != null) {
            builder.registerDefaultPolymorphicSerializer(this.baseClass, lVar, false);
        }
        l lVar2 = this.defaultDeserializerProvider;
        if (lVar2 != null) {
            builder.registerDefaultPolymorphicDeserializer(this.baseClass, lVar2, false);
        }
    }

    /* renamed from: default, reason: not valid java name */
    public final void m44default(l defaultSerializerProvider) {
        p.e(defaultSerializerProvider, "defaultSerializerProvider");
        defaultDeserializer(defaultSerializerProvider);
    }

    public final void defaultDeserializer(l defaultDeserializerProvider) {
        p.e(defaultDeserializerProvider, "defaultDeserializerProvider");
        if (this.defaultDeserializerProvider == null) {
            this.defaultDeserializerProvider = defaultDeserializerProvider;
            return;
        }
        throw new IllegalArgumentException(("Default deserializer provider is already registered for class " + this.baseClass + ": " + this.defaultDeserializerProvider).toString());
    }

    public final <T extends Base> void subclass(c subclass, KSerializer<T> serializer) {
        p.e(subclass, "subclass");
        p.e(serializer, "serializer");
        this.subclasses.add(new g(subclass, serializer));
    }

    @ExperimentalSerializationApi
    public final /* synthetic */ <T extends Base> void subclassesOfSealed() {
        p.i();
        throw null;
    }

    @ExperimentalSerializationApi
    public final <T extends Base> void subclassesOfSealed(KSerializer<T> serializer) {
        p.e(serializer, "serializer");
        if (!(serializer instanceof SealedClassSerializer)) {
            throw new IllegalArgumentException("subclassesOfSealed only supports automatic adding of subclasses of sealed types with standard serializers.");
        }
        SealedClassSerializer sealedClassSerializer = (SealedClassSerializer) serializer;
        for (Map.Entry entry : sealedClassSerializer.getClass2Serializer$kotlinx_serialization_core().entrySet()) {
            c cVar = (c) entry.getKey();
            KSerializer<T> kSerializer = (KSerializer) entry.getValue();
            if (p.a(kSerializer.getDescriptor().getKind(), PolymorphicKind.OPEN.INSTANCE)) {
                throw new IllegalArgumentException(("It is not possible to register subclasses (" + sealedClassSerializer.getDescriptor().getSerialName() + ") of sealed types when those subclasses themselves are (open) polymorphic, as this would represent an incomplete hierarchy.").toString());
            }
            p.c(cVar, "null cannot be cast to non-null type kotlin.reflect.KClass<T of kotlinx.serialization.modules.PolymorphicModuleBuilder.subclassesOfSealed>");
            subclass(cVar, kSerializer);
        }
    }

    public /* synthetic */ PolymorphicModuleBuilder(c cVar, KSerializer kSerializer, int i8, i iVar) {
        this(cVar, (i8 & 2) != 0 ? null : kSerializer);
    }
}
