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
import mb.C4931a;
import ob.d;
import pb.C5101i0;
import pb.I0;
import pb.M;
import pb.T0;
import pb.X;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/datacenter/core/storage/DataCenterManifest.$serializer", "Lpb/M;", "Lcom/stepos/datacenter/core/storage/DataCenterManifest;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/stepos/datacenter/core/storage/DataCenterManifest;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/stepos/datacenter/core/storage/DataCenterManifest;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public /* synthetic */ class DataCenterManifest$$serializer implements M<DataCenterManifest> {
    public static final DataCenterManifest$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        DataCenterManifest$$serializer dataCenterManifest$$serializer = new DataCenterManifest$$serializer();
        INSTANCE = dataCenterManifest$$serializer;
        I0 i02 = new I0("com.stepos.datacenter.core.storage.DataCenterManifest", dataCenterManifest$$serializer, 7);
        i02.n("epoch", false);
        i02.n("createdAtNs", false);
        i02.n("engineVersion", false);
        i02.n("formatVersion", true);
        i02.n("components", true);
        i02.n("previousEpoch", true);
        i02.n("extra", true);
        descriptor = i02;
    }

    private DataCenterManifest$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = DataCenterManifest.$childSerializers;
        C5101i0 c5101i0 = C5101i0.f38365a;
        return new KSerializer[]{c5101i0, c5101i0, Y0.f38329a, X.f38325a, kSerializerArr[4], C4931a.t(c5101i0), kSerializerArr[6]};
    }

    @Override // lb.InterfaceC4883a
    public final DataCenterManifest deserialize(Decoder decoder) {
        int i10;
        Map map;
        Long l10;
        int i11;
        long j10;
        String str;
        Map map2;
        long j11;
        p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = DataCenterManifest.$childSerializers;
        int i12 = 5;
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(serialDescriptor, 0);
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(serialDescriptor, 1);
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 2);
            int iDecodeIntElement = cVarBeginStructure.decodeIntElement(serialDescriptor, 3);
            Map map3 = (Map) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            Long l11 = (Long) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, C5101i0.f38365a, null);
            map = (Map) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], null);
            str = strDecodeStringElement;
            l10 = l11;
            i10 = iDecodeIntElement;
            map2 = map3;
            i11 = 127;
            j10 = jDecodeLongElement2;
            j11 = jDecodeLongElement;
        } else {
            long jDecodeLongElement3 = 0;
            boolean z10 = true;
            int iDecodeIntElement2 = 0;
            Map map4 = null;
            String strDecodeStringElement2 = null;
            Map map5 = null;
            long jDecodeLongElement4 = 0;
            int i13 = 0;
            Long l12 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                        i12 = 5;
                    case 0:
                        jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(serialDescriptor, 0);
                        i13 |= 1;
                        i12 = 5;
                    case 1:
                        i13 |= 2;
                        jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(serialDescriptor, 1);
                    case 2:
                        strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 2);
                        i13 |= 4;
                    case 3:
                        iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(serialDescriptor, 3);
                        i13 |= 8;
                    case 4:
                        map5 = (Map) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], map5);
                        i13 |= 16;
                    case 5:
                        l12 = (Long) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, i12, C5101i0.f38365a, l12);
                        i13 |= 32;
                    case 6:
                        map4 = (Map) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 6, kSerializerArr[6], map4);
                        i13 |= 64;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i10 = iDecodeIntElement2;
            map = map4;
            l10 = l12;
            i11 = i13;
            j10 = jDecodeLongElement3;
            str = strDecodeStringElement2;
            map2 = map5;
            j11 = jDecodeLongElement4;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new DataCenterManifest(i11, j11, j10, str, i10, map2, l10, map, (T0) null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, DataCenterManifest value) {
        p.i(encoder, "encoder");
        p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        DataCenterManifest.r(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return M.a.a(this);
    }
}
