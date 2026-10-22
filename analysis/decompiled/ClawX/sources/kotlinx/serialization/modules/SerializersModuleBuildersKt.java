package kotlinx.serialization.modules;

import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import p5.l;
import v5.c;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\u0080\u0004\u001a$\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\u0088\u0004\u001a&\u0010\b\u001a\u00020\u00012\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0086\u0088\u0004ø\u0001\u0000\u001a\n\u0010\u000e\u001a\u00020\u0001H\u0086\u0080\u0004\u001a(\u0010\u000f\u001a\u00020\f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\u0088\u0004\u001a\\\u0010\u0010\u001a\u00020\f\"\b\b\u0000\u0010\u0011*\u00020\u0003*\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0011\u0018\u00010\u00072\u001f\b\u0002\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"serializersModuleOf", "Lkotlinx/serialization/modules/SerializersModule;", "T", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "kClass", "Lkotlin/reflect/KClass;", "serializer", "Lkotlinx/serialization/KSerializer;", "SerializersModule", "builderAction", "Lkotlin/Function1;", "Lkotlinx/serialization/modules/SerializersModuleBuilder;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlin/ExtensionFunctionType;", "EmptySerializersModule", "contextual", "polymorphic", "Base", "baseClass", "baseSerializer", "Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SerializersModuleBuildersKt {
    public static final SerializersModule EmptySerializersModule() {
        return SerializersModuleKt.getEmptySerializersModule();
    }

    public static final SerializersModule SerializersModule(l builderAction) {
        p.e(builderAction, "builderAction");
        SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
        builderAction.invoke(serializersModuleBuilder);
        return serializersModuleBuilder.build();
    }

    public static final /* synthetic */ <T> void contextual(SerializersModuleBuilder serializersModuleBuilder, KSerializer<T> serializer) {
        p.e(serializersModuleBuilder, "<this>");
        p.e(serializer, "serializer");
        p.i();
        throw null;
    }

    public static final <Base> void polymorphic(SerializersModuleBuilder serializersModuleBuilder, c baseClass, KSerializer<Base> kSerializer, l builderAction) {
        p.e(serializersModuleBuilder, "<this>");
        p.e(baseClass, "baseClass");
        p.e(builderAction, "builderAction");
        PolymorphicModuleBuilder polymorphicModuleBuilder = new PolymorphicModuleBuilder(baseClass, kSerializer);
        builderAction.invoke(polymorphicModuleBuilder);
        polymorphicModuleBuilder.buildTo(serializersModuleBuilder);
    }

    public static /* synthetic */ void polymorphic$default(SerializersModuleBuilder serializersModuleBuilder, c baseClass, KSerializer kSerializer, l builderAction, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            kSerializer = null;
        }
        if ((i8 & 4) != 0) {
            builderAction = new l() { // from class: kotlinx.serialization.modules.SerializersModuleBuildersKt.polymorphic.1
                public final void invoke(PolymorphicModuleBuilder polymorphicModuleBuilder) {
                    p.e(polymorphicModuleBuilder, "<this>");
                }

                @Override // p5.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((PolymorphicModuleBuilder) obj2);
                    return a0.f883a;
                }
            };
        }
        p.e(serializersModuleBuilder, "<this>");
        p.e(baseClass, "baseClass");
        p.e(builderAction, "builderAction");
        PolymorphicModuleBuilder polymorphicModuleBuilder = new PolymorphicModuleBuilder(baseClass, kSerializer);
        builderAction.invoke(polymorphicModuleBuilder);
        polymorphicModuleBuilder.buildTo(serializersModuleBuilder);
    }

    public static final /* synthetic */ <T> SerializersModule serializersModuleOf(KSerializer<T> serializer) {
        p.e(serializer, "serializer");
        p.i();
        throw null;
    }

    public static final <T> SerializersModule serializersModuleOf(c kClass, KSerializer<T> serializer) {
        p.e(kClass, "kClass");
        p.e(serializer, "serializer");
        SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
        serializersModuleBuilder.contextual(kClass, serializer);
        return serializersModuleBuilder.build();
    }
}
