package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.modelcontextprotocol.kotlin.sdk.RequestId;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import pb.I0;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/RequestId.StringId.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/RequestId$StringId;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/RequestId$StringId;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/RequestId$StringId;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class RequestId$StringId$$serializer implements pb.M<RequestId.StringId> {
    public static final RequestId$StringId$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        RequestId$StringId$$serializer requestId$StringId$$serializer = new RequestId$StringId$$serializer();
        INSTANCE = requestId$StringId$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.RequestId.StringId", requestId$StringId$$serializer, 1);
        i02.n(UxipConstants.f30680s, false);
        descriptor = i02;
    }

    private RequestId$StringId$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{Y0.f38329a};
    }

    @Override // lb.InterfaceC4883a
    public final RequestId.StringId deserialize(Decoder decoder) {
        String strDecodeStringElement;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        int i10 = 1;
        if (cVarBeginStructure.decodeSequentially()) {
            strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
        } else {
            boolean z10 = true;
            int i11 = 0;
            strDecodeStringElement = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else {
                    if (iDecodeElementIndex != 0) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i11 = 1;
                }
            }
            i10 = i11;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new RequestId.StringId(i10, strDecodeStringElement, null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, RequestId.StringId value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        dVarBeginStructure.w(serialDescriptor, 0, value.value);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
