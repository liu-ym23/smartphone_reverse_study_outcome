package kotlinx.serialization;

import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.modules.SerializersModule;
import v5.i;

@Metadata(d1 = {"kotlinx/serialization/SerializersKt__SerializersJvmKt", "kotlinx/serialization/SerializersKt__SerializersKt"}, k = 4, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SerializersKt {
    public static final KSerializer<?> moduleThenPolymorphic(SerializersModule serializersModule, v5.c cVar) {
        return SerializersKt__SerializersKt.moduleThenPolymorphic(serializersModule, cVar);
    }

    public static final KSerializer<?> noCompiledSerializer(String str) {
        return SerializersKt__SerializersKt.noCompiledSerializer(str);
    }

    public static final KSerializer<? extends Object> parametrizedSerializerOrNull(v5.c cVar, List<? extends KSerializer<Object>> list, p5.a aVar) {
        return SerializersKt__SerializersKt.parametrizedSerializerOrNull(cVar, list, aVar);
    }

    public static final /* synthetic */ <T> KSerializer<T> serializer() {
        p.i();
        throw null;
    }

    public static final KSerializer<Object> serializerOrNull(Type type) {
        return SerializersKt__SerializersJvmKt.serializerOrNull(type);
    }

    public static final List<KSerializer<Object>> serializersForParameters(SerializersModule serializersModule, List<? extends i> list, boolean z) {
        return SerializersKt__SerializersKt.serializersForParameters(serializersModule, list, z);
    }

    public static final KSerializer<?> moduleThenPolymorphic(SerializersModule serializersModule, v5.c cVar, KSerializer<?>[] kSerializerArr) {
        return SerializersKt__SerializersKt.moduleThenPolymorphic(serializersModule, cVar, kSerializerArr);
    }

    public static final KSerializer<?> noCompiledSerializer(SerializersModule serializersModule, v5.c cVar) {
        return SerializersKt__SerializersKt.noCompiledSerializer(serializersModule, cVar);
    }

    public static final KSerializer<Object> serializer(Type type) {
        return SerializersKt__SerializersJvmKt.serializer(type);
    }

    public static final KSerializer<Object> serializerOrNull(SerializersModule serializersModule, Type type) {
        return SerializersKt__SerializersJvmKt.serializerOrNull(serializersModule, type);
    }

    public static final KSerializer<?> noCompiledSerializer(SerializersModule serializersModule, v5.c cVar, KSerializer<?>[] kSerializerArr) {
        return SerializersKt__SerializersKt.noCompiledSerializer(serializersModule, cVar, kSerializerArr);
    }

    public static final /* synthetic */ <T> KSerializer<T> serializer(SerializersModule serializersModule) {
        p.i();
        throw null;
    }

    public static final KSerializer<Object> serializerOrNull(SerializersModule serializersModule, i iVar) {
        return SerializersKt__SerializersKt.serializerOrNull(serializersModule, iVar);
    }

    public static final KSerializer<Object> serializer(SerializersModule serializersModule, Type type) {
        return SerializersKt__SerializersJvmKt.serializer(serializersModule, type);
    }

    @InternalSerializationApi
    public static final <T> KSerializer<T> serializerOrNull(v5.c cVar) {
        return SerializersKt__SerializersKt.serializerOrNull(cVar);
    }

    @ExperimentalSerializationApi
    public static final KSerializer<Object> serializer(SerializersModule serializersModule, v5.c cVar, List<? extends KSerializer<?>> list, boolean z) {
        return SerializersKt__SerializersKt.serializer(serializersModule, cVar, list, z);
    }

    public static final KSerializer<Object> serializerOrNull(i iVar) {
        return SerializersKt__SerializersKt.serializerOrNull(iVar);
    }

    public static final KSerializer<Object> serializer(SerializersModule serializersModule, i iVar) {
        return SerializersKt__SerializersKt.serializer(serializersModule, iVar);
    }

    @InternalSerializationApi
    public static final <T> KSerializer<T> serializer(v5.c cVar) {
        return SerializersKt__SerializersKt.serializer(cVar);
    }

    @ExperimentalSerializationApi
    public static final KSerializer<Object> serializer(v5.c cVar, List<? extends KSerializer<?>> list, boolean z) {
        return SerializersKt__SerializersKt.serializer(cVar, list, z);
    }

    public static final KSerializer<Object> serializer(i iVar) {
        return SerializersKt__SerializersKt.serializer(iVar);
    }
}
