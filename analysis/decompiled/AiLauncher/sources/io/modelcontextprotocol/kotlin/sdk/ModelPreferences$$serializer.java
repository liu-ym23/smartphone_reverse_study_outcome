package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import lb.InterfaceC4883a;
import mb.C4931a;
import pb.C5083B;
import pb.I0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/ModelPreferences.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/ModelPreferences;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/ModelPreferences;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/ModelPreferences;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class ModelPreferences$$serializer implements pb.M<ModelPreferences> {
    public static final ModelPreferences$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ModelPreferences$$serializer modelPreferences$$serializer = new ModelPreferences$$serializer();
        INSTANCE = modelPreferences$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.ModelPreferences", modelPreferences$$serializer, 4);
        i02.n("hints", false);
        i02.n("costPriority", false);
        i02.n("speedPriority", false);
        i02.n("intelligencePriority", false);
        descriptor = i02;
    }

    private ModelPreferences$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerT = C4931a.t((KSerializer) ModelPreferences.$childSerializers[0].getValue());
        C5083B c5083b = C5083B.f38260a;
        return new KSerializer[]{kSerializerT, C4931a.t(c5083b), C4931a.t(c5083b), C4931a.t(c5083b)};
    }

    @Override // lb.InterfaceC4883a
    public final ModelPreferences deserialize(Decoder decoder) {
        int i10;
        List list;
        Double d10;
        Double d11;
        Double d12;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        Y8.h[] hVarArr = ModelPreferences.$childSerializers;
        List list2 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            List list3 = (List) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (InterfaceC4883a) hVarArr[0].getValue(), null);
            C5083B c5083b = C5083B.f38260a;
            Double d13 = (Double) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, c5083b, null);
            Double d14 = (Double) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, c5083b, null);
            list = list3;
            d12 = (Double) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, c5083b, null);
            i10 = 15;
            d11 = d14;
            d10 = d13;
        } else {
            boolean z10 = true;
            int i11 = 0;
            Double d15 = null;
            Double d16 = null;
            Double d17 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    list2 = (List) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, (InterfaceC4883a) hVarArr[0].getValue(), list2);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    d15 = (Double) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, C5083B.f38260a, d15);
                    i11 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    d16 = (Double) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, C5083B.f38260a, d16);
                    i11 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    d17 = (Double) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, C5083B.f38260a, d17);
                    i11 |= 8;
                }
            }
            i10 = i11;
            list = list2;
            d10 = d15;
            d11 = d16;
            d12 = d17;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new ModelPreferences(i10, list, d10, d11, d12, null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, ModelPreferences value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        ModelPreferences.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
