package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u0002J\n\u0010\u0007\u001a\u00020\bH¦\u0080\u0004R\u0013\u0010\u0003\u001a\u00020\u0004X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkotlinx/serialization/json/JsonDecoder;", "Lkotlinx/serialization/encoding/Decoder;", "Lkotlinx/serialization/encoding/CompositeDecoder;", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "decodeJsonElement", "Lkotlinx/serialization/json/JsonElement;", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public interface JsonDecoder extends Decoder, CompositeDecoder {

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static int decodeCollectionSize(JsonDecoder jsonDecoder, SerialDescriptor descriptor) {
            p.e(descriptor, "descriptor");
            return JsonDecoder.super.decodeCollectionSize(descriptor);
        }

        @ExperimentalSerializationApi
        @Deprecated
        public static <T> T decodeNullableSerializableValue(JsonDecoder jsonDecoder, DeserializationStrategy<? extends T> deserializer) {
            p.e(deserializer, "deserializer");
            return (T) JsonDecoder.super.decodeNullableSerializableValue(deserializer);
        }

        @ExperimentalSerializationApi
        @Deprecated
        public static boolean decodeSequentially(JsonDecoder jsonDecoder) {
            return JsonDecoder.super.decodeSequentially();
        }

        @Deprecated
        public static <T> T decodeSerializableValue(JsonDecoder jsonDecoder, DeserializationStrategy<? extends T> deserializer) {
            p.e(deserializer, "deserializer");
            return (T) JsonDecoder.super.decodeSerializableValue(deserializer);
        }
    }

    JsonElement decodeJsonElement();

    Json getJson();
}
