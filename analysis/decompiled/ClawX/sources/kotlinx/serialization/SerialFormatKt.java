package kotlinx.serialization;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.internal.InternalHexConverter;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\u001a#\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0086\u0088\u0004¢\u0006\u0002\u0010\u0005\u001a#\u0010\u0006\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\u0088\u0004¢\u0006\u0002\u0010\b\u001a/\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\u0004\u001a\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\r\u001a/\u0010\u000e\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0012\u001a#\u0010\t\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0004\u001a\u0002H\u0002H\u0086\u0088\u0004¢\u0006\u0002\u0010\u0013\u001a#\u0010\u000e\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0001H\u0086\u0088\u0004¢\u0006\u0002\u0010\u0014\u001a#\u0010\u0015\u001a\u00020\u0016\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0004\u001a\u0002H\u0002H\u0086\u0088\u0004¢\u0006\u0002\u0010\u0017\u001a#\u0010\u0018\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0016H\u0086\u0088\u0004¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"encodeToString", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "T", "Lkotlinx/serialization/StringFormat;", "value", "(Lkotlinx/serialization/StringFormat;Ljava/lang/Object;)Ljava/lang/String;", "decodeFromString", "string", "(Lkotlinx/serialization/StringFormat;Ljava/lang/String;)Ljava/lang/Object;", "encodeToHexString", "Lkotlinx/serialization/BinaryFormat;", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/BinaryFormat;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "decodeFromHexString", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "hex", "(Lkotlinx/serialization/BinaryFormat;Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/String;)Ljava/lang/Object;", "encodeToByteArray", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/Object;)[B", "decodeFromByteArray", "bytes", "(Lkotlinx/serialization/BinaryFormat;[B)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SerialFormatKt {
    public static final /* synthetic */ <T> T decodeFromByteArray(BinaryFormat binaryFormat, byte[] bytes) {
        p.e(binaryFormat, "<this>");
        p.e(bytes, "bytes");
        binaryFormat.getSerializersModule();
        p.i();
        throw null;
    }

    public static final <T> T decodeFromHexString(BinaryFormat binaryFormat, DeserializationStrategy<? extends T> deserializer, String hex) {
        p.e(binaryFormat, "<this>");
        p.e(deserializer, "deserializer");
        p.e(hex, "hex");
        return (T) binaryFormat.decodeFromByteArray(deserializer, InternalHexConverter.INSTANCE.parseHexBinary(hex));
    }

    public static final /* synthetic */ <T> T decodeFromString(StringFormat stringFormat, String string) {
        p.e(stringFormat, "<this>");
        p.e(string, "string");
        stringFormat.getSerializersModule();
        p.i();
        throw null;
    }

    public static final /* synthetic */ <T> byte[] encodeToByteArray(BinaryFormat binaryFormat, T t8) {
        p.e(binaryFormat, "<this>");
        binaryFormat.getSerializersModule();
        p.i();
        throw null;
    }

    public static final <T> String encodeToHexString(BinaryFormat binaryFormat, SerializationStrategy<? super T> serializer, T t8) {
        p.e(binaryFormat, "<this>");
        p.e(serializer, "serializer");
        return InternalHexConverter.INSTANCE.printHexBinary(binaryFormat.encodeToByteArray(serializer, t8), true);
    }

    public static final /* synthetic */ <T> String encodeToString(StringFormat stringFormat, T t8) {
        p.e(stringFormat, "<this>");
        stringFormat.getSerializersModule();
        p.i();
        throw null;
    }

    public static final /* synthetic */ <T> T decodeFromHexString(BinaryFormat binaryFormat, String hex) {
        p.e(binaryFormat, "<this>");
        p.e(hex, "hex");
        binaryFormat.getSerializersModule();
        p.i();
        throw null;
    }

    public static final /* synthetic */ <T> String encodeToHexString(BinaryFormat binaryFormat, T t8) {
        p.e(binaryFormat, "<this>");
        binaryFormat.getSerializersModule();
        p.i();
        throw null;
    }
}
