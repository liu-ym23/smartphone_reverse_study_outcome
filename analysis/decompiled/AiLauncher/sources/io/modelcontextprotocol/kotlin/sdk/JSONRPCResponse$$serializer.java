package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import lb.InterfaceC4883a;
import mb.C4931a;
import pb.I0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/JSONRPCResponse.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCResponse;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/JSONRPCResponse;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/JSONRPCResponse;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class JSONRPCResponse$$serializer implements pb.M<JSONRPCResponse> {
    public static final JSONRPCResponse$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        JSONRPCResponse$$serializer jSONRPCResponse$$serializer = new JSONRPCResponse$$serializer();
        INSTANCE = jSONRPCResponse$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.JSONRPCResponse", jSONRPCResponse$$serializer, 4);
        i02.n("id", false);
        i02.n("jsonrpc", true);
        i02.n("result", true);
        i02.n("error", true);
        descriptor = i02;
    }

    private JSONRPCResponse$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{JSONRPCResponse.$childSerializers[0].getValue(), Y0.f38329a, C4931a.t(RequestResultPolymorphicSerializer.INSTANCE), C4931a.t(JSONRPCError$$serializer.INSTANCE)};
    }

    @Override // lb.InterfaceC4883a
    public final JSONRPCResponse deserialize(Decoder decoder) {
        int i10;
        RequestId requestId;
        String str;
        RequestResult requestResult;
        JSONRPCError jSONRPCError;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        Y8.h[] hVarArr = JSONRPCResponse.$childSerializers;
        RequestId requestId2 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            RequestId requestId3 = (RequestId) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 0, (InterfaceC4883a) hVarArr[0].getValue(), null);
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
            RequestResult requestResult2 = (RequestResult) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, RequestResultPolymorphicSerializer.INSTANCE, null);
            requestId = requestId3;
            str = strDecodeStringElement;
            jSONRPCError = (JSONRPCError) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, JSONRPCError$$serializer.INSTANCE, null);
            requestResult = requestResult2;
            i10 = 15;
        } else {
            boolean z10 = true;
            int i11 = 0;
            String strDecodeStringElement2 = null;
            RequestResult requestResult3 = null;
            JSONRPCError jSONRPCError2 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    requestId2 = (RequestId) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 0, (InterfaceC4883a) hVarArr[0].getValue(), requestId2);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                    i11 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    requestResult3 = (RequestResult) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, RequestResultPolymorphicSerializer.INSTANCE, requestResult3);
                    i11 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    jSONRPCError2 = (JSONRPCError) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, JSONRPCError$$serializer.INSTANCE, jSONRPCError2);
                    i11 |= 8;
                }
            }
            i10 = i11;
            requestId = requestId2;
            str = strDecodeStringElement2;
            requestResult = requestResult3;
            jSONRPCError = jSONRPCError2;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new JSONRPCResponse(i10, requestId, str, requestResult, jSONRPCError, (T0) null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, JSONRPCResponse value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        JSONRPCResponse.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
