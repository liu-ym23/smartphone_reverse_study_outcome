package k4;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i0 implements KSerializer {

    /* renamed from: a, reason: collision with root package name */
    public static final i0 f3622a = new i0();

    /* renamed from: b, reason: collision with root package name */
    public static final SerialDescriptor f3623b = SerialDescriptorsKt.PrimitiveSerialDescriptor("io.ktor.http.Url", PrimitiveKind.STRING.INSTANCE);

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        kotlin.jvm.internal.p.e(decoder, "decoder");
        return v.b(decoder.decodeString());
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return f3623b;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        h0 value = (h0) obj;
        kotlin.jvm.internal.p.e(encoder, "encoder");
        kotlin.jvm.internal.p.e(value, "value");
        encoder.encodeString(value.f3616e);
    }
}
