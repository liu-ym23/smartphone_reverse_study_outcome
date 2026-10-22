package kotlinx.serialization.modules;

import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import v5.c;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\bD¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\u0087\u0080\u0004J>\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\b2\u0012\b\u0002\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u000bH§\u0080\u0004J9\u0010\f\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\r\"\b\b\u0000\u0010\u0006*\u00020\u00012\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00060\b2\u0006\u0010\u000f\u001a\u0002H\u0006H§\u0080\u0004¢\u0006\u0002\u0010\u0010J6\u0010\f\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0011\"\b\b\u0000\u0010\u0006*\u00020\u00012\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00060\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H§\u0080\u0004J\u0012\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H§\u0080\u0004R\u001b\u0010\u0018\u001a\u00020\u00198 X¡\u0084\b¢\u0006\f\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\u001c\u0082\u0001\u0001\u001d¨\u0006\u001e"}, d2 = {"Lkotlinx/serialization/modules/SerializersModule;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "getContextual", "Lkotlinx/serialization/KSerializer;", "T", "kclass", "Lkotlin/reflect/KClass;", "kClass", "typeArgumentsSerializers", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getPolymorphic", "Lkotlinx/serialization/SerializationStrategy;", "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/DeserializationStrategy;", "serializedClassName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "dumpTo", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "collector", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "hasInterfaceContextualSerializers", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "getHasInterfaceContextualSerializers$kotlinx_serialization_core$annotations", "getHasInterfaceContextualSerializers$kotlinx_serialization_core", "()Z", "Lkotlinx/serialization/modules/SerialModuleImpl;", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SerializersModule {
    public /* synthetic */ SerializersModule(i iVar) {
        this();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KSerializer getContextual$default(SerializersModule serializersModule, c cVar, List list, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
        }
        if ((i8 & 2) != 0) {
            list = s.f1092a;
        }
        return serializersModule.getContextual(cVar, list);
    }

    @ExperimentalSerializationApi
    public abstract void dumpTo(SerializersModuleCollector collector);

    @ExperimentalSerializationApi
    public final /* synthetic */ KSerializer getContextual(c kclass) {
        p.e(kclass, "kclass");
        return getContextual(kclass, s.f1092a);
    }

    @ExperimentalSerializationApi
    public abstract <T> KSerializer<T> getContextual(c cVar, List<? extends KSerializer<?>> list);

    public abstract boolean getHasInterfaceContextualSerializers$kotlinx_serialization_core();

    @ExperimentalSerializationApi
    public abstract <T> DeserializationStrategy<T> getPolymorphic(c cVar, String str);

    @ExperimentalSerializationApi
    public abstract <T> SerializationStrategy<T> getPolymorphic(c cVar, T t8);

    private SerializersModule() {
    }

    @InternalSerializationApi
    public static /* synthetic */ void getHasInterfaceContextualSerializers$kotlinx_serialization_core$annotations() {
    }
}
