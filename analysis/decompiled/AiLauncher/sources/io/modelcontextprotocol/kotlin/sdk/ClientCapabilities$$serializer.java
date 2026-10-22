package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.modelcontextprotocol.kotlin.sdk.ClientCapabilities;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import mb.C4931a;
import pb.I0;
import pb.T0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/ClientCapabilities.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/ClientCapabilities;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class ClientCapabilities$$serializer implements pb.M<ClientCapabilities> {
    public static final ClientCapabilities$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ClientCapabilities$$serializer clientCapabilities$$serializer = new ClientCapabilities$$serializer();
        INSTANCE = clientCapabilities$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.ClientCapabilities", clientCapabilities$$serializer, 4);
        i02.n("experimental", true);
        i02.n("sampling", true);
        i02.n("roots", true);
        i02.n("elicitation", true);
        descriptor = i02;
    }

    private ClientCapabilities$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        qb.E e10 = qb.E.f38623a;
        return new KSerializer[]{C4931a.t(e10), C4931a.t(e10), C4931a.t(ClientCapabilities$Roots$$serializer.INSTANCE), C4931a.t(e10)};
    }

    @Override // lb.InterfaceC4883a
    public final ClientCapabilities deserialize(Decoder decoder) {
        int i10;
        qb.D d10;
        qb.D d11;
        ClientCapabilities.Roots roots;
        qb.D d12;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        qb.D d13 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            qb.E e10 = qb.E.f38623a;
            qb.D d14 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, e10, null);
            qb.D d15 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, e10, null);
            ClientCapabilities.Roots roots2 = (ClientCapabilities.Roots) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ClientCapabilities$Roots$$serializer.INSTANCE, null);
            d12 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, e10, null);
            i10 = 15;
            roots = roots2;
            d11 = d15;
            d10 = d14;
        } else {
            boolean z10 = true;
            int i11 = 0;
            qb.D d16 = null;
            ClientCapabilities.Roots roots3 = null;
            qb.D d17 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    d13 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, qb.E.f38623a, d13);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    d16 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, qb.E.f38623a, d16);
                    i11 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    roots3 = (ClientCapabilities.Roots) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, ClientCapabilities$Roots$$serializer.INSTANCE, roots3);
                    i11 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    d17 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, qb.E.f38623a, d17);
                    i11 |= 8;
                }
            }
            i10 = i11;
            d10 = d13;
            d11 = d16;
            roots = roots3;
            d12 = d17;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new ClientCapabilities(i10, d10, d11, roots, d12, (T0) null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, ClientCapabilities value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        ClientCapabilities.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
