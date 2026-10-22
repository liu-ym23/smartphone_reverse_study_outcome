package kotlinx.serialization.builtins;

import a8.b;
import b5.a0;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.gateway.d;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.LongSerializer;
import y5.e;
import y5.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\bB¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/builtins/InstantComponentSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlin/time/Instant;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InstantComponentSerializer implements KSerializer<f> {
    public static final InstantComponentSerializer INSTANCE = new InstantComponentSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlinx.serialization.InstantComponentSerializer", new SerialDescriptor[0], new d(24));

    private InstantComponentSerializer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 descriptor$lambda$0(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
        p.e(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        LongSerializer longSerializer = LongSerializer.INSTANCE;
        SerialDescriptor descriptor2 = longSerializer.getDescriptor();
        s sVar = s.f1092a;
        buildClassSerialDescriptor.element("epochSeconds", descriptor2, sVar, false);
        buildClassSerialDescriptor.element("nanosecondsOfSecond", longSerializer.getDescriptor(), sVar, true);
        return a0.f883a;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public f deserialize(Decoder decoder) {
        p.e(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor2);
        long jDecodeLongElement = 0;
        boolean z = true;
        int iDecodeIntElement = 0;
        while (true) {
            InstantComponentSerializer instantComponentSerializer = INSTANCE;
            int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(instantComponentSerializer.getDescriptor());
            if (iDecodeElementIndex == -1) {
                if (z) {
                    throw new MissingFieldException("epochSeconds", instantComponentSerializer.getDescriptor().getSerialName());
                }
                e eVar = f.f6347c;
                f fVarA = e.a(iDecodeIntElement, jDecodeLongElement);
                compositeDecoderBeginStructure.endStructure(descriptor2);
                return fVarA;
            }
            if (iDecodeElementIndex == 0) {
                jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(instantComponentSerializer.getDescriptor(), 0);
                z = false;
            } else {
                if (iDecodeElementIndex != 1) {
                    throw new SerializationException(b.j(iDecodeElementIndex, "Unexpected index: "));
                }
                iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(instantComponentSerializer.getDescriptor(), 1);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, f value) {
        p.e(encoder, "encoder");
        p.e(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(descriptor2);
        InstantComponentSerializer instantComponentSerializer = INSTANCE;
        compositeEncoderBeginStructure.encodeLongElement(instantComponentSerializer.getDescriptor(), 0, value.f6349a);
        int i8 = value.f6350b;
        if (i8 != 0 || compositeEncoderBeginStructure.shouldEncodeElementDefault(instantComponentSerializer.getDescriptor(), 1)) {
            compositeEncoderBeginStructure.encodeIntElement(instantComponentSerializer.getDescriptor(), 1, i8);
        }
        compositeEncoderBeginStructure.endStructure(descriptor2);
    }
}
