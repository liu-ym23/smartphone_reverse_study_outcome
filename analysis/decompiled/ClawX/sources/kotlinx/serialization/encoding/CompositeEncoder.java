package kotlinx.serialization.encoding;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦\u0080\u0004J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0097\u0080\u0004J\"\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH¦\u0080\u0004J\"\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0011H¦\u0080\u0004J\"\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0013H¦\u0080\u0004J\"\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0015H¦\u0080\u0004J\"\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH¦\u0080\u0004J\"\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0018H¦\u0080\u0004J\"\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001aH¦\u0080\u0004J\"\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001cH¦\u0080\u0004J\"\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u001eH¦\u0080\u0004J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH¦\u0080\u0004JA\u0010!\u001a\u00020\u0007\"\n\b\u0000\u0010\"*\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$2\u0006\u0010\u000f\u001a\u0002H\"H¦\u0080\u0004¢\u0006\u0002\u0010%JA\u0010&\u001a\u00020\u0007\"\b\b\u0000\u0010\"*\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0$2\b\u0010\u000f\u001a\u0004\u0018\u0001H\"H§\u0080\u0004¢\u0006\u0002\u0010%R\u0013\u0010\u0002\u001a\u00020\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006'À\u0006\u0003"}, d2 = {"Lkotlinx/serialization/encoding/CompositeEncoder;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "endStructure", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "shouldEncodeElementDefault", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "index", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeBooleanElement", "value", "encodeByteElement", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeShortElement", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeCharElement", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeIntElement", "encodeLongElement", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeFloatElement", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeDoubleElement", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeStringElement", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encodeInlineElement", "Lkotlinx/serialization/encoding/Encoder;", "encodeSerializableElement", "T", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeNullableSerializableElement", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public interface CompositeEncoder {

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @ExperimentalSerializationApi
        @Deprecated
        public static boolean shouldEncodeElementDefault(CompositeEncoder compositeEncoder, SerialDescriptor descriptor, int i8) {
            p.e(descriptor, "descriptor");
            return CompositeEncoder.super.shouldEncodeElementDefault(descriptor, i8);
        }
    }

    void encodeBooleanElement(SerialDescriptor descriptor, int index, boolean value);

    void encodeByteElement(SerialDescriptor descriptor, int index, byte value);

    void encodeCharElement(SerialDescriptor descriptor, int index, char value);

    void encodeDoubleElement(SerialDescriptor descriptor, int index, double value);

    void encodeFloatElement(SerialDescriptor descriptor, int index, float value);

    Encoder encodeInlineElement(SerialDescriptor descriptor, int index);

    void encodeIntElement(SerialDescriptor descriptor, int index, int value);

    void encodeLongElement(SerialDescriptor descriptor, int index, long value);

    @ExperimentalSerializationApi
    <T> void encodeNullableSerializableElement(SerialDescriptor descriptor, int index, SerializationStrategy<? super T> serializer, T value);

    <T> void encodeSerializableElement(SerialDescriptor descriptor, int index, SerializationStrategy<? super T> serializer, T value);

    void encodeShortElement(SerialDescriptor descriptor, int index, short value);

    void encodeStringElement(SerialDescriptor descriptor, int index, String value);

    void endStructure(SerialDescriptor descriptor);

    SerializersModule getSerializersModule();

    @ExperimentalSerializationApi
    default boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int index) {
        p.e(descriptor, "descriptor");
        return true;
    }
}
