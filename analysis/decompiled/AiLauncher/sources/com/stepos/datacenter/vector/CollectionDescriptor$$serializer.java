package com.stepos.datacenter.vector;

import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import mb.C4931a;
import ob.c;
import ob.d;
import pb.C5100i;
import pb.C5101i0;
import pb.I0;
import pb.M;
import pb.T0;
import pb.X;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/datacenter/vector/CollectionDescriptor.$serializer", "Lpb/M;", "Lcom/stepos/datacenter/vector/CollectionDescriptor;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/stepos/datacenter/vector/CollectionDescriptor;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/stepos/datacenter/vector/CollectionDescriptor;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public /* synthetic */ class CollectionDescriptor$$serializer implements M<CollectionDescriptor> {
    public static final CollectionDescriptor$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CollectionDescriptor$$serializer collectionDescriptor$$serializer = new CollectionDescriptor$$serializer();
        INSTANCE = collectionDescriptor$$serializer;
        I0 i02 = new I0("com.stepos.datacenter.vector.CollectionDescriptor", collectionDescriptor$$serializer, 14);
        i02.n("id", false);
        i02.n("rawDim", false);
        i02.n("storageDim", true);
        i02.n("metric", false);
        i02.n("dtype", true);
        i02.n("embeddingModel", false);
        i02.n("inputNormalized", true);
        i02.n("createdAtNs", true);
        i02.n("formatVersion", true);
        i02.n("primaryIndexId", true);
        i02.n("activeIndexIds", true);
        i02.n("indexRetention", true);
        i02.n("extra", true);
        i02.n("capacityPolicy", true);
        descriptor = i02;
    }

    private CollectionDescriptor$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = CollectionDescriptor.$childSerializers;
        Y0 y02 = Y0.f38329a;
        KSerializer<?> kSerializer = kSerializerArr[3];
        KSerializer<?> kSerializer2 = kSerializerArr[4];
        KSerializer<?> kSerializerT = C4931a.t(y02);
        KSerializer<?> kSerializer3 = kSerializerArr[10];
        KSerializer<?> kSerializer4 = kSerializerArr[12];
        X x10 = X.f38325a;
        return new KSerializer[]{y02, x10, x10, kSerializer, kSerializer2, y02, C5100i.f38363a, C5101i0.f38365a, x10, kSerializerT, kSerializer3, x10, kSerializer4, CapacityPolicy$$serializer.INSTANCE};
    }

    @Override // lb.InterfaceC4883a
    public final CollectionDescriptor deserialize(Decoder decoder) {
        DistanceMetric distanceMetric;
        int i10;
        int i11;
        StorageDType storageDType;
        CapacityPolicy capacityPolicy;
        String str;
        List list;
        Map map;
        String str2;
        String str3;
        int i12;
        boolean z10;
        int i13;
        int i14;
        long j10;
        p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = CollectionDescriptor.$childSerializers;
        int i15 = 9;
        int i16 = 7;
        if (cVarBeginStructure.decodeSequentially()) {
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
            int iDecodeIntElement = cVarBeginStructure.decodeIntElement(serialDescriptor, 1);
            int iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(serialDescriptor, 2);
            distanceMetric = (DistanceMetric) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
            StorageDType storageDType2 = (StorageDType) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 5);
            boolean zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(serialDescriptor, 6);
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(serialDescriptor, 7);
            int iDecodeIntElement3 = cVarBeginStructure.decodeIntElement(serialDescriptor, 8);
            String str4 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 9, Y0.f38329a, null);
            List list2 = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 10, kSerializerArr[10], null);
            int iDecodeIntElement4 = cVarBeginStructure.decodeIntElement(serialDescriptor, 11);
            i10 = 16383;
            map = (Map) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 12, kSerializerArr[12], null);
            capacityPolicy = (CapacityPolicy) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 13, CapacityPolicy$$serializer.INSTANCE, null);
            str2 = strDecodeStringElement;
            i11 = iDecodeIntElement;
            str = str4;
            i12 = iDecodeIntElement3;
            z10 = zDecodeBooleanElement;
            str3 = strDecodeStringElement2;
            list = list2;
            i13 = iDecodeIntElement2;
            i14 = iDecodeIntElement4;
            storageDType = storageDType2;
            j10 = jDecodeLongElement;
        } else {
            boolean z11 = true;
            StorageDType storageDType3 = null;
            CapacityPolicy capacityPolicy2 = null;
            String str5 = null;
            String strDecodeStringElement3 = null;
            int iDecodeIntElement5 = 0;
            int iDecodeIntElement6 = 0;
            boolean zDecodeBooleanElement2 = false;
            int iDecodeIntElement7 = 0;
            int iDecodeIntElement8 = 0;
            int i17 = 4;
            long jDecodeLongElement2 = 0;
            distanceMetric = null;
            List list3 = null;
            Map map2 = null;
            String strDecodeStringElement4 = null;
            i10 = 0;
            while (z11) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z11 = false;
                        i15 = 9;
                        i17 = 4;
                    case 0:
                        strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i10 |= 1;
                        i15 = 9;
                        i16 = 7;
                        i17 = 4;
                    case 1:
                        i10 |= 2;
                        iDecodeIntElement5 = cVarBeginStructure.decodeIntElement(serialDescriptor, 1);
                        i15 = 9;
                        i16 = 7;
                        i17 = 4;
                    case 2:
                        iDecodeIntElement7 = cVarBeginStructure.decodeIntElement(serialDescriptor, 2);
                        i10 |= 4;
                        i15 = 9;
                        i16 = 7;
                        i17 = 4;
                    case 3:
                        distanceMetric = (DistanceMetric) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], distanceMetric);
                        i10 |= 8;
                        i15 = 9;
                        i16 = 7;
                        i17 = 4;
                    case 4:
                        storageDType3 = (StorageDType) cVarBeginStructure.decodeSerializableElement(serialDescriptor, i17, kSerializerArr[i17], storageDType3);
                        i10 |= 16;
                        i15 = 9;
                        i16 = 7;
                    case 5:
                        strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(serialDescriptor, 5);
                        i10 |= 32;
                        i15 = 9;
                    case 6:
                        zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(serialDescriptor, 6);
                        i10 |= 64;
                        i15 = 9;
                    case 7:
                        jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(serialDescriptor, i16);
                        i10 |= 128;
                    case 8:
                        iDecodeIntElement6 = cVarBeginStructure.decodeIntElement(serialDescriptor, 8);
                        i10 |= 256;
                        i16 = 7;
                    case 9:
                        str5 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, i15, Y0.f38329a, str5);
                        i10 |= 512;
                        i16 = 7;
                    case 10:
                        list3 = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 10, kSerializerArr[10], list3);
                        i10 |= 1024;
                        i16 = 7;
                    case 11:
                        iDecodeIntElement8 = cVarBeginStructure.decodeIntElement(serialDescriptor, 11);
                        i10 |= 2048;
                        i16 = 7;
                    case 12:
                        map2 = (Map) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 12, kSerializerArr[12], map2);
                        i10 |= 4096;
                        i16 = 7;
                    case 13:
                        capacityPolicy2 = (CapacityPolicy) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 13, CapacityPolicy$$serializer.INSTANCE, capacityPolicy2);
                        i10 |= b.THRESHOLD;
                        i16 = 7;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i11 = iDecodeIntElement5;
            storageDType = storageDType3;
            capacityPolicy = capacityPolicy2;
            str = str5;
            list = list3;
            map = map2;
            str2 = strDecodeStringElement4;
            str3 = strDecodeStringElement3;
            i12 = iDecodeIntElement6;
            z10 = zDecodeBooleanElement2;
            i13 = iDecodeIntElement7;
            i14 = iDecodeIntElement8;
            j10 = jDecodeLongElement2;
        }
        int i18 = i10;
        DistanceMetric distanceMetric2 = distanceMetric;
        cVarBeginStructure.endStructure(serialDescriptor);
        return new CollectionDescriptor(i18, str2, i11, i13, distanceMetric2, storageDType, str3, z10, j10, i12, str, list, i14, map, capacityPolicy, (T0) null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, CollectionDescriptor value) {
        p.i(encoder, "encoder");
        p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        CollectionDescriptor.write$Self$vector_release(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return M.a.a(this);
    }
}
