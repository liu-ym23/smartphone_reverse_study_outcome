package com.stepos.datacenter.core.storage;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import ob.d;
import pb.C5101i0;
import pb.I0;
import pb.M;
import pb.T0;
import pb.X;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/datacenter/core/storage/ComponentEpoch.$serializer", "Lpb/M;", "Lcom/stepos/datacenter/core/storage/ComponentEpoch;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/stepos/datacenter/core/storage/ComponentEpoch;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/stepos/datacenter/core/storage/ComponentEpoch;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public /* synthetic */ class ComponentEpoch$$serializer implements M<ComponentEpoch> {
    public static final ComponentEpoch$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ComponentEpoch$$serializer componentEpoch$$serializer = new ComponentEpoch$$serializer();
        INSTANCE = componentEpoch$$serializer;
        I0 i02 = new I0("com.stepos.datacenter.core.storage.ComponentEpoch", componentEpoch$$serializer, 6);
        i02.n("subEpoch", false);
        i02.n("relativePath", false);
        i02.n("sizeBytes", false);
        i02.n("crcHex", true);
        i02.n("formatVersion", true);
        i02.n("extra", true);
        descriptor = i02;
    }

    private ComponentEpoch$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializer = ComponentEpoch.$childSerializers[5];
        C5101i0 c5101i0 = C5101i0.f38365a;
        Y0 y02 = Y0.f38329a;
        return new KSerializer[]{c5101i0, y02, c5101i0, y02, X.f38325a, kSerializer};
    }

    @Override // lb.InterfaceC4883a
    public final ComponentEpoch deserialize(Decoder decoder) {
        int i10;
        int i11;
        long j10;
        String str;
        String str2;
        Map map;
        long j11;
        p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = ComponentEpoch.$childSerializers;
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(serialDescriptor, 0);
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(serialDescriptor, 2);
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 3);
            int iDecodeIntElement = cVarBeginStructure.decodeIntElement(serialDescriptor, 4);
            map = (Map) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], null);
            str = strDecodeStringElement;
            str2 = strDecodeStringElement2;
            i10 = iDecodeIntElement;
            i11 = 63;
            j10 = jDecodeLongElement2;
            j11 = jDecodeLongElement;
        } else {
            long jDecodeLongElement3 = 0;
            boolean z10 = true;
            int iDecodeIntElement2 = 0;
            String strDecodeStringElement3 = null;
            String strDecodeStringElement4 = null;
            Map map2 = null;
            long jDecodeLongElement4 = 0;
            int i12 = 0;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                        continue;
                    case 0:
                        jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(serialDescriptor, 0);
                        i12 |= 1;
                        continue;
                    case 1:
                        strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i12 |= 2;
                        break;
                    case 2:
                        jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(serialDescriptor, 2);
                        i12 |= 4;
                        break;
                    case 3:
                        strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(serialDescriptor, 3);
                        i12 |= 8;
                        break;
                    case 4:
                        iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(serialDescriptor, 4);
                        i12 |= 16;
                        break;
                    case 5:
                        map2 = (Map) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 5, kSerializerArr[5], map2);
                        i12 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i10 = iDecodeIntElement2;
            i11 = i12;
            j10 = jDecodeLongElement3;
            str = strDecodeStringElement3;
            str2 = strDecodeStringElement4;
            map = map2;
            j11 = jDecodeLongElement4;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new ComponentEpoch(i11, j11, str, j10, str2, i10, map, (T0) null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, ComponentEpoch value) {
        p.i(encoder, "encoder");
        p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        ComponentEpoch.p(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return M.a.a(this);
    }
}
