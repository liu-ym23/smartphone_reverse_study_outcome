package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import pb.I0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/InitializeResult.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/InitializeResult;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/InitializeResult;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/InitializeResult;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class InitializeResult$$serializer implements pb.M<InitializeResult> {
    public static final InitializeResult$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        InitializeResult$$serializer initializeResult$$serializer = new InitializeResult$$serializer();
        INSTANCE = initializeResult$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.InitializeResult", initializeResult$$serializer, 4);
        i02.n(Constants.PARAM_PROTOCOL_VERSION, true);
        i02.n("capabilities", true);
        i02.n("serverInfo", false);
        i02.n("_meta", true);
        descriptor = i02;
    }

    private InitializeResult$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{Y0.f38329a, ServerCapabilities$$serializer.INSTANCE, Implementation$$serializer.INSTANCE, qb.E.f38623a};
    }

    @Override // lb.InterfaceC4883a
    public final InitializeResult deserialize(Decoder decoder) {
        int i10;
        String str;
        ServerCapabilities serverCapabilities;
        Implementation implementation;
        qb.D d10;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        String strDecodeStringElement = null;
        if (cVarBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
            ServerCapabilities serverCapabilities2 = (ServerCapabilities) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 1, ServerCapabilities$$serializer.INSTANCE, null);
            Implementation implementation2 = (Implementation) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, Implementation$$serializer.INSTANCE, null);
            str = strDecodeStringElement2;
            d10 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, qb.E.f38623a, null);
            implementation = implementation2;
            serverCapabilities = serverCapabilities2;
            i10 = 15;
        } else {
            boolean z10 = true;
            int i11 = 0;
            ServerCapabilities serverCapabilities3 = null;
            Implementation implementation3 = null;
            qb.D d11 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    serverCapabilities3 = (ServerCapabilities) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 1, ServerCapabilities$$serializer.INSTANCE, serverCapabilities3);
                    i11 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    implementation3 = (Implementation) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, Implementation$$serializer.INSTANCE, implementation3);
                    i11 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    d11 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, qb.E.f38623a, d11);
                    i11 |= 8;
                }
            }
            i10 = i11;
            str = strDecodeStringElement;
            serverCapabilities = serverCapabilities3;
            implementation = implementation3;
            d10 = d11;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new InitializeResult(i10, str, serverCapabilities, implementation, d10, (T0) null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, InitializeResult value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        InitializeResult.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
