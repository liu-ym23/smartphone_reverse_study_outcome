package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.modelcontextprotocol.kotlin.sdk.CompleteRequest;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import pb.I0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/CompleteRequest.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/CompleteRequest;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class CompleteRequest$$serializer implements pb.M<CompleteRequest> {
    public static final CompleteRequest$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CompleteRequest$$serializer completeRequest$$serializer = new CompleteRequest$$serializer();
        INSTANCE = completeRequest$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.CompleteRequest", completeRequest$$serializer, 4);
        i02.n("ref", false);
        i02.n("argument", false);
        i02.n("_meta", true);
        i02.n("method", true);
        descriptor = i02;
    }

    private CompleteRequest$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ReferencePolymorphicSerializer.INSTANCE, CompleteRequest$Argument$$serializer.INSTANCE, qb.E.f38623a, RequestMethodSerializer.INSTANCE};
    }

    @Override // lb.InterfaceC4883a
    public final CompleteRequest deserialize(Decoder decoder) {
        int i10;
        Reference reference;
        CompleteRequest.Argument argument;
        qb.D d10;
        Method method;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        Reference reference2 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            Reference reference3 = (Reference) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 0, ReferencePolymorphicSerializer.INSTANCE, null);
            CompleteRequest.Argument argument2 = (CompleteRequest.Argument) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 1, CompleteRequest$Argument$$serializer.INSTANCE, null);
            qb.D d11 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, qb.E.f38623a, null);
            reference = reference3;
            method = (Method) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, RequestMethodSerializer.INSTANCE, null);
            d10 = d11;
            argument = argument2;
            i10 = 15;
        } else {
            boolean z10 = true;
            int i11 = 0;
            CompleteRequest.Argument argument3 = null;
            qb.D d12 = null;
            Method method2 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    reference2 = (Reference) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 0, ReferencePolymorphicSerializer.INSTANCE, reference2);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    argument3 = (CompleteRequest.Argument) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 1, CompleteRequest$Argument$$serializer.INSTANCE, argument3);
                    i11 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    d12 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, qb.E.f38623a, d12);
                    i11 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    method2 = (Method) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, RequestMethodSerializer.INSTANCE, method2);
                    i11 |= 8;
                }
            }
            i10 = i11;
            reference = reference2;
            argument = argument3;
            d10 = d12;
            method = method2;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new CompleteRequest(i10, reference, argument, d10, method, null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, CompleteRequest value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        CompleteRequest.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
