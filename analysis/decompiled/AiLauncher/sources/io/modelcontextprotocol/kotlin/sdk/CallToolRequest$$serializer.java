package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import pb.I0;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/CallToolRequest.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/CallToolRequest;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/CallToolRequest;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/CallToolRequest;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class CallToolRequest$$serializer implements pb.M<CallToolRequest> {
    public static final CallToolRequest$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CallToolRequest$$serializer callToolRequest$$serializer = new CallToolRequest$$serializer();
        INSTANCE = callToolRequest$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.CallToolRequest", callToolRequest$$serializer, 4);
        i02.n("name", false);
        i02.n("arguments", true);
        i02.n("_meta", true);
        i02.n("method", true);
        descriptor = i02;
    }

    private CallToolRequest$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        qb.E e10 = qb.E.f38623a;
        return new KSerializer[]{Y0.f38329a, e10, e10, RequestMethodSerializer.INSTANCE};
    }

    @Override // lb.InterfaceC4883a
    public final CallToolRequest deserialize(Decoder decoder) {
        int i10;
        String str;
        qb.D d10;
        qb.D d11;
        Method method;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        String strDecodeStringElement = null;
        if (cVarBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
            qb.E e10 = qb.E.f38623a;
            qb.D d12 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 1, e10, null);
            qb.D d13 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, e10, null);
            str = strDecodeStringElement2;
            method = (Method) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, RequestMethodSerializer.INSTANCE, null);
            d11 = d13;
            d10 = d12;
            i10 = 15;
        } else {
            boolean z10 = true;
            int i11 = 0;
            qb.D d14 = null;
            qb.D d15 = null;
            Method method2 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    d14 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 1, qb.E.f38623a, d14);
                    i11 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    d15 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, qb.E.f38623a, d15);
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
            str = strDecodeStringElement;
            d10 = d14;
            d11 = d15;
            method = method2;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new CallToolRequest(i10, str, d10, d11, method, null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, CallToolRequest value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        CallToolRequest.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
