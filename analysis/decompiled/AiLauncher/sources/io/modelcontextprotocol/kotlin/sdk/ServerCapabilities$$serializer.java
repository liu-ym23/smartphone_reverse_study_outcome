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
import pb.I0;
import pb.T0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/ServerCapabilities.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/ServerCapabilities;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class ServerCapabilities$$serializer implements pb.M<ServerCapabilities> {
    public static final ServerCapabilities$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ServerCapabilities$$serializer serverCapabilities$$serializer = new ServerCapabilities$$serializer();
        INSTANCE = serverCapabilities$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.ServerCapabilities", serverCapabilities$$serializer, 6);
        i02.n("experimental", true);
        i02.n("sampling", true);
        i02.n("logging", true);
        i02.n("prompts", true);
        i02.n("resources", true);
        i02.n("tools", true);
        descriptor = i02;
    }

    private ServerCapabilities$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        qb.E e10 = qb.E.f38623a;
        return new KSerializer[]{C4931a.t(e10), C4931a.t(e10), C4931a.t(e10), C4931a.t(ServerCapabilities$Prompts$$serializer.INSTANCE), C4931a.t(ServerCapabilities$Resources$$serializer.INSTANCE), C4931a.t(ServerCapabilities$Tools$$serializer.INSTANCE)};
    }

    @Override // lb.InterfaceC4883a
    public final ServerCapabilities deserialize(Decoder decoder) {
        int i10;
        qb.D d10;
        qb.D d11;
        qb.D d12;
        ServerCapabilities.Prompts prompts;
        ServerCapabilities.Resources resources;
        ServerCapabilities.Tools tools;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        int i11 = 5;
        qb.D d13 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            qb.E e10 = qb.E.f38623a;
            qb.D d14 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, e10, null);
            qb.D d15 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, e10, null);
            qb.D d16 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, e10, null);
            ServerCapabilities.Prompts prompts2 = (ServerCapabilities.Prompts) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ServerCapabilities$Prompts$$serializer.INSTANCE, null);
            ServerCapabilities.Resources resources2 = (ServerCapabilities.Resources) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ServerCapabilities$Resources$$serializer.INSTANCE, null);
            d12 = d16;
            tools = (ServerCapabilities.Tools) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, ServerCapabilities$Tools$$serializer.INSTANCE, null);
            prompts = prompts2;
            resources = resources2;
            i10 = 63;
            d11 = d15;
            d10 = d14;
        } else {
            boolean z10 = true;
            int i12 = 0;
            qb.D d17 = null;
            qb.D d18 = null;
            ServerCapabilities.Prompts prompts3 = null;
            ServerCapabilities.Resources resources3 = null;
            ServerCapabilities.Tools tools2 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                        i11 = 5;
                    case 0:
                        d13 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, qb.E.f38623a, d13);
                        i12 |= 1;
                        i11 = 5;
                    case 1:
                        d17 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, qb.E.f38623a, d17);
                        i12 |= 2;
                    case 2:
                        d18 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, qb.E.f38623a, d18);
                        i12 |= 4;
                    case 3:
                        prompts3 = (ServerCapabilities.Prompts) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, ServerCapabilities$Prompts$$serializer.INSTANCE, prompts3);
                        i12 |= 8;
                    case 4:
                        resources3 = (ServerCapabilities.Resources) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, ServerCapabilities$Resources$$serializer.INSTANCE, resources3);
                        i12 |= 16;
                    case 5:
                        tools2 = (ServerCapabilities.Tools) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, i11, ServerCapabilities$Tools$$serializer.INSTANCE, tools2);
                        i12 |= 32;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i10 = i12;
            d10 = d13;
            d11 = d17;
            d12 = d18;
            prompts = prompts3;
            resources = resources3;
            tools = tools2;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new ServerCapabilities(i10, d10, d11, d12, prompts, resources, tools, (T0) null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, ServerCapabilities value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        ServerCapabilities.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
