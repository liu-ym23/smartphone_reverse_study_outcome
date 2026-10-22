package com.stepos.datacenter.ame;

import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import ob.c;
import ob.d;
import pb.C5101i0;
import pb.I0;
import pb.M;
import pb.T0;
import pb.X;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/datacenter/ame/VectorMetadataRecord.$serializer", "Lpb/M;", "Lcom/stepos/datacenter/ame/VectorMetadataRecord;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/stepos/datacenter/ame/VectorMetadataRecord;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/stepos/datacenter/ame/VectorMetadataRecord;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public /* synthetic */ class VectorMetadataRecord$$serializer implements M<VectorMetadataRecord> {
    public static final VectorMetadataRecord$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        VectorMetadataRecord$$serializer vectorMetadataRecord$$serializer = new VectorMetadataRecord$$serializer();
        INSTANCE = vectorMetadataRecord$$serializer;
        I0 i02 = new I0("com.stepos.datacenter.ame.VectorMetadataRecord", vectorMetadataRecord$$serializer, 5);
        i02.n("vectorId", false);
        i02.n("entityId", true);
        i02.n("entityClassName", true);
        i02.n("label", true);
        i02.n(QueryAlgorithmBundle.KEY_CATEGORY, true);
        descriptor = i02;
    }

    private VectorMetadataRecord$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        C5101i0 c5101i0 = C5101i0.f38365a;
        Y0 y02 = Y0.f38329a;
        return new KSerializer[]{c5101i0, c5101i0, y02, y02, X.f38325a};
    }

    @Override // lb.InterfaceC4883a
    public final VectorMetadataRecord deserialize(Decoder decoder) {
        String strDecodeStringElement;
        String strDecodeStringElement2;
        int iDecodeIntElement;
        int i10;
        long j10;
        long j11;
        p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(serialDescriptor, 0);
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(serialDescriptor, 1);
            strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 2);
            strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 3);
            iDecodeIntElement = cVarBeginStructure.decodeIntElement(serialDescriptor, 4);
            i10 = 31;
            j10 = jDecodeLongElement;
            j11 = jDecodeLongElement2;
        } else {
            strDecodeStringElement = null;
            boolean z10 = true;
            int i11 = 0;
            long jDecodeLongElement3 = 0;
            long jDecodeLongElement4 = 0;
            String strDecodeStringElement3 = null;
            int iDecodeIntElement2 = 0;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(serialDescriptor, 0);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(serialDescriptor, 1);
                    i11 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 2);
                    i11 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(serialDescriptor, 3);
                    i11 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(serialDescriptor, 4);
                    i11 |= 16;
                }
            }
            strDecodeStringElement2 = strDecodeStringElement3;
            iDecodeIntElement = iDecodeIntElement2;
            i10 = i11;
            j10 = jDecodeLongElement3;
            j11 = jDecodeLongElement4;
        }
        String str = strDecodeStringElement;
        cVarBeginStructure.endStructure(serialDescriptor);
        return new VectorMetadataRecord(i10, j10, j11, str, strDecodeStringElement2, iDecodeIntElement, (T0) null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, VectorMetadataRecord value) {
        p.i(encoder, "encoder");
        p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        VectorMetadataRecord.m(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return M.a.a(this);
    }
}
