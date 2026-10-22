package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.modelcontextprotocol.kotlin.sdk.ServerCapabilities;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import mb.C4931a;
import pb.C5100i;
import pb.I0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/ServerCapabilities.Resources.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Resources;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Resources;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities$Resources;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class ServerCapabilities$Resources$$serializer implements pb.M<ServerCapabilities.Resources> {
    public static final ServerCapabilities$Resources$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ServerCapabilities$Resources$$serializer serverCapabilities$Resources$$serializer = new ServerCapabilities$Resources$$serializer();
        INSTANCE = serverCapabilities$Resources$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.ServerCapabilities.Resources", serverCapabilities$Resources$$serializer, 2);
        i02.n("subscribe", false);
        i02.n("listChanged", false);
        descriptor = i02;
    }

    private ServerCapabilities$Resources$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        C5100i c5100i = C5100i.f38363a;
        return new KSerializer[]{C4931a.t(c5100i), C4931a.t(c5100i)};
    }

    @Override // lb.InterfaceC4883a
    public final ServerCapabilities.Resources deserialize(Decoder decoder) {
        Boolean bool;
        int i10;
        Boolean bool2;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        if (cVarBeginStructure.decodeSequentially()) {
            C5100i c5100i = C5100i.f38363a;
            bool2 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, c5100i, null);
            bool = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, c5100i, null);
            i10 = 3;
        } else {
            boolean z10 = true;
            int i11 = 0;
            bool = null;
            Boolean bool3 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    bool3 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, C5100i.f38363a, bool3);
                    i11 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    bool = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, C5100i.f38363a, bool);
                    i11 |= 2;
                }
            }
            i10 = i11;
            bool2 = bool3;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new ServerCapabilities.Resources(i10, bool2, bool, null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, ServerCapabilities.Resources value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        ServerCapabilities.Resources.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
