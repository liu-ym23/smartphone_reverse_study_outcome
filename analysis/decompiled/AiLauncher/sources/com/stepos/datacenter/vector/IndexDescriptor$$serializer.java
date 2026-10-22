package com.stepos.datacenter.vector;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
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
import ob.c;
import ob.d;
import pb.C5101i0;
import pb.I0;
import pb.M;
import pb.T0;
import pb.X;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/datacenter/vector/IndexDescriptor.$serializer", "Lpb/M;", "Lcom/stepos/datacenter/vector/IndexDescriptor;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/stepos/datacenter/vector/IndexDescriptor;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/stepos/datacenter/vector/IndexDescriptor;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public /* synthetic */ class IndexDescriptor$$serializer implements M<IndexDescriptor> {
    public static final IndexDescriptor$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        IndexDescriptor$$serializer indexDescriptor$$serializer = new IndexDescriptor$$serializer();
        INSTANCE = indexDescriptor$$serializer;
        I0 i02 = new I0("com.stepos.datacenter.vector.IndexDescriptor", indexDescriptor$$serializer, 12);
        i02.n("id", false);
        i02.n("collectionId", false);
        i02.n("type", false);
        i02.n("dtype", true);
        i02.n(VoiceWakeupReceiver.EXTRA_STATE, true);
        i02.n("createdAtNs", true);
        i02.n("readyAtNs", true);
        i02.n("promotedAtNs", true);
        i02.n("builtFromEpoch", true);
        i02.n("progressPermille", true);
        i02.n("params", true);
        i02.n("failReason", true);
        descriptor = i02;
    }

    private IndexDescriptor$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = IndexDescriptor.$childSerializers;
        Y0 y02 = Y0.f38329a;
        KSerializer<?> kSerializer = kSerializerArr[2];
        KSerializer<?> kSerializer2 = kSerializerArr[3];
        KSerializer<?> kSerializer3 = kSerializerArr[4];
        C5101i0 c5101i0 = C5101i0.f38365a;
        return new KSerializer[]{y02, y02, kSerializer, kSerializer2, kSerializer3, c5101i0, C4931a.t(c5101i0), C4931a.t(c5101i0), C4931a.t(c5101i0), X.f38325a, kSerializerArr[10], C4931a.t(y02)};
    }

    @Override // lb.InterfaceC4883a
    public final IndexDescriptor deserialize(Decoder decoder) {
        Long l10;
        int i10;
        String str;
        String str2;
        String str3;
        Map map;
        Long l11;
        Long l12;
        IndexLifecycle indexLifecycle;
        StorageDType storageDType;
        IndexType indexType;
        int i11;
        long j10;
        p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = IndexDescriptor.$childSerializers;
        int i12 = 10;
        String strDecodeStringElement = null;
        if (cVarBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
            IndexType indexType2 = (IndexType) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            StorageDType storageDType2 = (StorageDType) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
            IndexLifecycle indexLifecycle2 = (IndexLifecycle) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(serialDescriptor, 5);
            C5101i0 c5101i0 = C5101i0.f38365a;
            Long l13 = (Long) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, c5101i0, null);
            Long l14 = (Long) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, c5101i0, null);
            l10 = (Long) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, c5101i0, null);
            int iDecodeIntElement = cVarBeginStructure.decodeIntElement(serialDescriptor, 9);
            i10 = 4095;
            map = (Map) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 10, kSerializerArr[10], null);
            str2 = strDecodeStringElement2;
            str3 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, Y0.f38329a, null);
            i11 = iDecodeIntElement;
            l12 = l14;
            l11 = l13;
            storageDType = storageDType2;
            indexLifecycle = indexLifecycle2;
            indexType = indexType2;
            str = strDecodeStringElement3;
            j10 = jDecodeLongElement;
        } else {
            String strDecodeStringElement4 = null;
            String str4 = null;
            Map map2 = null;
            l10 = null;
            int i13 = 3;
            int i14 = 4;
            boolean z10 = true;
            i10 = 0;
            int iDecodeIntElement2 = 0;
            long jDecodeLongElement2 = 0;
            Long l15 = null;
            Long l16 = null;
            StorageDType storageDType3 = null;
            IndexType indexType3 = null;
            IndexLifecycle indexLifecycle3 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                        i13 = 3;
                        i14 = 4;
                    case 0:
                        i10 |= 1;
                        strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                        i12 = 10;
                        i13 = 3;
                        i14 = 4;
                    case 1:
                        strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                        i10 |= 2;
                        i12 = 10;
                        i13 = 3;
                        i14 = 4;
                    case 2:
                        indexType3 = (IndexType) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], indexType3);
                        i10 |= 4;
                        i12 = 10;
                        i13 = 3;
                        i14 = 4;
                    case 3:
                        storageDType3 = (StorageDType) cVarBeginStructure.decodeSerializableElement(serialDescriptor, i13, kSerializerArr[i13], storageDType3);
                        i10 |= 8;
                        i12 = 10;
                        i14 = 4;
                    case 4:
                        indexLifecycle3 = (IndexLifecycle) cVarBeginStructure.decodeSerializableElement(serialDescriptor, i14, kSerializerArr[i14], indexLifecycle3);
                        i10 |= 16;
                        i12 = 10;
                    case 5:
                        jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(serialDescriptor, 5);
                        i10 |= 32;
                        i12 = 10;
                    case 6:
                        l15 = (Long) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 6, C5101i0.f38365a, l15);
                        i10 |= 64;
                        i12 = 10;
                    case 7:
                        l16 = (Long) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, C5101i0.f38365a, l16);
                        i10 |= 128;
                        i12 = 10;
                    case 8:
                        l10 = (Long) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 8, C5101i0.f38365a, l10);
                        i10 |= 256;
                        i12 = 10;
                    case 9:
                        iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(serialDescriptor, 9);
                        i10 |= 512;
                    case 10:
                        int i15 = i12;
                        i12 = i15;
                        map2 = (Map) cVarBeginStructure.decodeSerializableElement(serialDescriptor, i12, kSerializerArr[i15], map2);
                        i10 |= 1024;
                    case 11:
                        str4 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 11, Y0.f38329a, str4);
                        i10 |= 2048;
                        i12 = i12;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = strDecodeStringElement4;
            str2 = strDecodeStringElement;
            str3 = str4;
            map = map2;
            l11 = l15;
            l12 = l16;
            indexLifecycle = indexLifecycle3;
            storageDType = storageDType3;
            indexType = indexType3;
            i11 = iDecodeIntElement2;
            j10 = jDecodeLongElement2;
        }
        Long l17 = l10;
        int i16 = i10;
        cVarBeginStructure.endStructure(serialDescriptor);
        return new IndexDescriptor(i16, str2, str, indexType, storageDType, indexLifecycle, j10, l11, l12, l17, i11, map, str3, (T0) null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, IndexDescriptor value) {
        p.i(encoder, "encoder");
        p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        IndexDescriptor.write$Self$vector_release(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return M.a.a(this);
    }
}
