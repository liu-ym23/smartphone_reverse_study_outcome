package com.stepos.datacenter.vector;

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

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/datacenter/vector/CapacityPolicy.$serializer", "Lpb/M;", "Lcom/stepos/datacenter/vector/CapacityPolicy;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/stepos/datacenter/vector/CapacityPolicy;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/stepos/datacenter/vector/CapacityPolicy;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public /* synthetic */ class CapacityPolicy$$serializer implements M<CapacityPolicy> {
    public static final CapacityPolicy$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CapacityPolicy$$serializer capacityPolicy$$serializer = new CapacityPolicy$$serializer();
        INSTANCE = capacityPolicy$$serializer;
        I0 i02 = new I0("com.stepos.datacenter.vector.CapacityPolicy", capacityPolicy$$serializer, 3);
        i02.n("initialBytes", true);
        i02.n("stepBytes", true);
        i02.n("maxBytes", true);
        descriptor = i02;
    }

    private CapacityPolicy$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        C5101i0 c5101i0 = C5101i0.f38365a;
        return new KSerializer[]{c5101i0, c5101i0, c5101i0};
    }

    @Override // lb.InterfaceC4883a
    public final CapacityPolicy deserialize(Decoder decoder) {
        int i10;
        long jDecodeLongElement;
        long j10;
        long j11;
        p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(serialDescriptor, 0);
            long jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(serialDescriptor, 1);
            jDecodeLongElement = cVarBeginStructure.decodeLongElement(serialDescriptor, 2);
            i10 = 7;
            j10 = jDecodeLongElement2;
            j11 = jDecodeLongElement3;
        } else {
            long jDecodeLongElement4 = 0;
            boolean z10 = true;
            int i11 = 0;
            long jDecodeLongElement5 = 0;
            long jDecodeLongElement6 = 0;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    jDecodeLongElement5 = cVarBeginStructure.decodeLongElement(serialDescriptor, 0);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    jDecodeLongElement6 = cVarBeginStructure.decodeLongElement(serialDescriptor, 1);
                    i11 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(serialDescriptor, 2);
                    i11 |= 4;
                }
            }
            i10 = i11;
            jDecodeLongElement = jDecodeLongElement4;
            j10 = jDecodeLongElement5;
            j11 = jDecodeLongElement6;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new CapacityPolicy(i10, j10, j11, jDecodeLongElement, (T0) null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, CapacityPolicy value) {
        p.i(encoder, "encoder");
        p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        CapacityPolicy.j(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return M.a.a(this);
    }
}
