package kotlinx.serialization.json;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u0012\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH¦\u0080\u0004R\u0013\u0010\u0003\u001a\u00020\u0004X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkotlinx/serialization/json/JsonEncoder;", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "encodeJsonElement", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "element", "Lkotlinx/serialization/json/JsonElement;", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public interface JsonEncoder extends Encoder, CompositeEncoder {

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static CompositeEncoder beginCollection(JsonEncoder jsonEncoder, SerialDescriptor descriptor, int i8) {
            p.e(descriptor, "descriptor");
            return JsonEncoder.super.beginCollection(descriptor, i8);
        }

        @ExperimentalSerializationApi
        @Deprecated
        public static void encodeNotNullMark(JsonEncoder jsonEncoder) {
            JsonEncoder.super.encodeNotNullMark();
        }

        @ExperimentalSerializationApi
        @Deprecated
        public static <T> void encodeNullableSerializableValue(JsonEncoder jsonEncoder, SerializationStrategy<? super T> serializer, T t8) {
            p.e(serializer, "serializer");
            JsonEncoder.super.encodeNullableSerializableValue(serializer, t8);
        }

        @Deprecated
        public static <T> void encodeSerializableValue(JsonEncoder jsonEncoder, SerializationStrategy<? super T> serializer, T t8) {
            p.e(serializer, "serializer");
            JsonEncoder.super.encodeSerializableValue(serializer, t8);
        }

        @ExperimentalSerializationApi
        @Deprecated
        public static boolean shouldEncodeElementDefault(JsonEncoder jsonEncoder, SerialDescriptor descriptor, int i8) {
            p.e(descriptor, "descriptor");
            return JsonEncoder.super.shouldEncodeElementDefault(descriptor, i8);
        }
    }

    void encodeJsonElement(JsonElement element);

    Json getJson();
}
