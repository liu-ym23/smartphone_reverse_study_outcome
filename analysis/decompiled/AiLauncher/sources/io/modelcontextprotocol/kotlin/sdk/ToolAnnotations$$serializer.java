package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import mb.C4931a;
import pb.C5100i;
import pb.I0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/ToolAnnotations.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/ToolAnnotations;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class ToolAnnotations$$serializer implements pb.M<ToolAnnotations> {
    public static final ToolAnnotations$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ToolAnnotations$$serializer toolAnnotations$$serializer = new ToolAnnotations$$serializer();
        INSTANCE = toolAnnotations$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.ToolAnnotations", toolAnnotations$$serializer, 5);
        i02.n("title", false);
        i02.n("readOnlyHint", true);
        i02.n("destructiveHint", true);
        i02.n("idempotentHint", true);
        i02.n("openWorldHint", true);
        descriptor = i02;
    }

    private ToolAnnotations$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?> kSerializerT = C4931a.t(Y0.f38329a);
        C5100i c5100i = C5100i.f38363a;
        return new KSerializer[]{kSerializerT, C4931a.t(c5100i), C4931a.t(c5100i), C4931a.t(c5100i), C4931a.t(c5100i)};
    }

    @Override // lb.InterfaceC4883a
    public final ToolAnnotations deserialize(Decoder decoder) {
        int i10;
        String str;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        String str2 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            String str3 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Y0.f38329a, null);
            C5100i c5100i = C5100i.f38363a;
            Boolean bool5 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, c5100i, null);
            Boolean bool6 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, c5100i, null);
            str = str3;
            bool3 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, c5100i, null);
            bool4 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, c5100i, null);
            bool2 = bool6;
            bool = bool5;
            i10 = 31;
        } else {
            boolean z10 = true;
            int i11 = 0;
            Boolean bool7 = null;
            Boolean bool8 = null;
            Boolean bool9 = null;
            Boolean bool10 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    str2 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 0, Y0.f38329a, str2);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    bool7 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, C5100i.f38363a, bool7);
                    i11 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    bool8 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, C5100i.f38363a, bool8);
                    i11 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    bool9 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, C5100i.f38363a, bool9);
                    i11 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    bool10 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, C5100i.f38363a, bool10);
                    i11 |= 16;
                }
            }
            i10 = i11;
            str = str2;
            bool = bool7;
            bool2 = bool8;
            bool3 = bool9;
            bool4 = bool10;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new ToolAnnotations(i10, str, bool, bool2, bool3, bool4, (T0) null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, ToolAnnotations value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        ToolAnnotations.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
