package u4;

import kotlin.jvm.internal.p;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements GeneratedSerializer {

    /* renamed from: a, reason: collision with root package name */
    public static final b f5641a;
    private static final SerialDescriptor descriptor;

    static {
        b bVar = new b();
        f5641a = bVar;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.ktor.util.date.GMTDate", bVar, 9);
        pluginGeneratedSerialDescriptor.addElement("seconds", false);
        pluginGeneratedSerialDescriptor.addElement("minutes", false);
        pluginGeneratedSerialDescriptor.addElement("hours", false);
        pluginGeneratedSerialDescriptor.addElement("dayOfWeek", false);
        pluginGeneratedSerialDescriptor.addElement("dayOfMonth", false);
        pluginGeneratedSerialDescriptor.addElement("dayOfYear", false);
        pluginGeneratedSerialDescriptor.addElement("month", false);
        pluginGeneratedSerialDescriptor.addElement("year", false);
        pluginGeneratedSerialDescriptor.addElement("timestamp", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        b5.e[] eVarArr = d.f5642k;
        IntSerializer intSerializer = IntSerializer.INSTANCE;
        return new KSerializer[]{intSerializer, intSerializer, intSerializer, eVarArr[3].getValue(), intSerializer, intSerializer, eVarArr[6].getValue(), intSerializer, LongSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        int iDecodeIntElement;
        e eVar;
        f fVar;
        int iDecodeIntElement2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        long jDecodeLongElement;
        p.e(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(serialDescriptor);
        b5.e[] eVarArr = d.f5642k;
        int i13 = 7;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
            int iDecodeIntElement3 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 1);
            int iDecodeIntElement4 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 2);
            f fVar2 = (f) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) eVarArr[3].getValue(), null);
            int iDecodeIntElement5 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 4);
            int iDecodeIntElement6 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 5);
            eVar = (e) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) eVarArr[6].getValue(), null);
            iDecodeIntElement2 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 7);
            i8 = iDecodeIntElement6;
            i9 = 511;
            i10 = iDecodeIntElement5;
            i11 = iDecodeIntElement4;
            fVar = fVar2;
            i12 = iDecodeIntElement3;
            jDecodeLongElement = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 8);
        } else {
            boolean z = true;
            iDecodeIntElement = 0;
            int iDecodeIntElement7 = 0;
            int iDecodeIntElement8 = 0;
            int iDecodeIntElement9 = 0;
            e eVar2 = null;
            long jDecodeLongElement2 = 0;
            int iDecodeIntElement10 = 0;
            int iDecodeIntElement11 = 0;
            int i14 = 0;
            f fVar3 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                    case 0:
                        i14 |= 1;
                        iDecodeIntElement = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 0);
                        i13 = 7;
                    case 1:
                        iDecodeIntElement9 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 1);
                        i14 |= 2;
                        i13 = 7;
                    case 2:
                        iDecodeIntElement8 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 2);
                        i14 |= 4;
                    case 3:
                        fVar3 = (f) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) eVarArr[3].getValue(), fVar3);
                        i14 |= 8;
                    case 4:
                        iDecodeIntElement7 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 4);
                        i14 |= 16;
                    case 5:
                        iDecodeIntElement11 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, 5);
                        i14 |= 32;
                    case 6:
                        eVar2 = (e) compositeDecoderBeginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) eVarArr[6].getValue(), eVar2);
                        i14 |= 64;
                    case 7:
                        iDecodeIntElement10 = compositeDecoderBeginStructure.decodeIntElement(serialDescriptor, i13);
                        i14 |= 128;
                    case 8:
                        jDecodeLongElement2 = compositeDecoderBeginStructure.decodeLongElement(serialDescriptor, 8);
                        i14 |= 256;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            eVar = eVar2;
            fVar = fVar3;
            iDecodeIntElement2 = iDecodeIntElement10;
            i8 = iDecodeIntElement11;
            i9 = i14;
            i10 = iDecodeIntElement7;
            i11 = iDecodeIntElement8;
            i12 = iDecodeIntElement9;
            jDecodeLongElement = jDecodeLongElement2;
        }
        int i15 = iDecodeIntElement;
        compositeDecoderBeginStructure.endStructure(serialDescriptor);
        return new d(i9, i15, i12, i11, fVar, i10, i8, eVar, iDecodeIntElement2, jDecodeLongElement);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        d value = (d) obj;
        p.e(encoder, "encoder");
        p.e(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(serialDescriptor);
        b5.e[] eVarArr = d.f5642k;
        compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 0, value.f5643a);
        compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 1, value.f5644b);
        compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 2, value.f5645c);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 3, (SerializationStrategy) eVarArr[3].getValue(), value.d);
        compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 4, value.f5646e);
        compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 5, value.f5647f);
        compositeEncoderBeginStructure.encodeSerializableElement(serialDescriptor, 6, (SerializationStrategy) eVarArr[6].getValue(), value.f5648g);
        compositeEncoderBeginStructure.encodeIntElement(serialDescriptor, 7, value.f5649h);
        compositeEncoderBeginStructure.encodeLongElement(serialDescriptor, 8, value.f5650j);
        compositeEncoderBeginStructure.endStructure(serialDescriptor);
    }
}
