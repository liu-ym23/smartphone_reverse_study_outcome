package com.stepos.datacenter.vector;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import ob.c;
import ob.d;
import pb.I0;
import pb.M;
import pb.X;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/stepos/datacenter/vector/VectorRegistrySnapshot.$serializer", "Lpb/M;", "Lcom/stepos/datacenter/vector/VectorRegistrySnapshot;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lcom/stepos/datacenter/vector/VectorRegistrySnapshot;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lcom/stepos/datacenter/vector/VectorRegistrySnapshot;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public /* synthetic */ class VectorRegistrySnapshot$$serializer implements M<VectorRegistrySnapshot> {
    public static final VectorRegistrySnapshot$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        VectorRegistrySnapshot$$serializer vectorRegistrySnapshot$$serializer = new VectorRegistrySnapshot$$serializer();
        INSTANCE = vectorRegistrySnapshot$$serializer;
        I0 i02 = new I0("com.stepos.datacenter.vector.VectorRegistrySnapshot", vectorRegistrySnapshot$$serializer, 3);
        i02.n("formatVersion", false);
        i02.n("collections", false);
        i02.n("indexes", false);
        descriptor = i02;
    }

    private VectorRegistrySnapshot$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = VectorRegistrySnapshot.$childSerializers;
        return new KSerializer[]{X.f38325a, kSerializerArr[1], kSerializerArr[2]};
    }

    @Override // lb.InterfaceC4883a
    public final VectorRegistrySnapshot deserialize(Decoder decoder) {
        int iDecodeIntElement;
        int i10;
        List list;
        List list2;
        p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        KSerializer[] kSerializerArr = VectorRegistrySnapshot.$childSerializers;
        if (cVarBeginStructure.decodeSequentially()) {
            iDecodeIntElement = cVarBeginStructure.decodeIntElement(serialDescriptor, 0);
            List list3 = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            list2 = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            i10 = 7;
            list = list3;
        } else {
            boolean z10 = true;
            iDecodeIntElement = 0;
            List list4 = null;
            List list5 = null;
            int i11 = 0;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    iDecodeIntElement = cVarBeginStructure.decodeIntElement(serialDescriptor, 0);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    list4 = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], list4);
                    i11 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    list5 = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], list5);
                    i11 |= 4;
                }
            }
            i10 = i11;
            list = list4;
            list2 = list5;
        }
        int i12 = iDecodeIntElement;
        cVarBeginStructure.endStructure(serialDescriptor);
        return new VectorRegistrySnapshot(i10, i12, list, list2, null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, VectorRegistrySnapshot value) {
        p.i(encoder, "encoder");
        p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        VectorRegistrySnapshot.j(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return M.a.a(this);
    }
}
