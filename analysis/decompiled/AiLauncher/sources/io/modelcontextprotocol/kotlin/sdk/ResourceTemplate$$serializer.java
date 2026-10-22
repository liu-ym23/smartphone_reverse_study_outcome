package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import mb.C4931a;
import pb.I0;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/ResourceTemplate.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/ResourceTemplate;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/ResourceTemplate;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/ResourceTemplate;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class ResourceTemplate$$serializer implements pb.M<ResourceTemplate> {
    public static final ResourceTemplate$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ResourceTemplate$$serializer resourceTemplate$$serializer = new ResourceTemplate$$serializer();
        INSTANCE = resourceTemplate$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.ResourceTemplate", resourceTemplate$$serializer, 4);
        i02.n("uriTemplate", false);
        i02.n("name", false);
        i02.n("description", false);
        i02.n("mimeType", false);
        descriptor = i02;
    }

    private ResourceTemplate$$serializer() {
    }

    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        Y0 y02 = Y0.f38329a;
        return new KSerializer[]{y02, y02, C4931a.t(y02), C4931a.t(y02)};
    }

    @Override // lb.InterfaceC4883a
    public final ResourceTemplate deserialize(Decoder decoder) {
        int i10;
        String str;
        String str2;
        String str3;
        String str4;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        String strDecodeStringElement = null;
        if (cVarBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
            String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
            Y0 y02 = Y0.f38329a;
            String str5 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, y02, null);
            str = strDecodeStringElement2;
            str4 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, y02, null);
            str3 = str5;
            str2 = strDecodeStringElement3;
            i10 = 15;
        } else {
            boolean z10 = true;
            int i11 = 0;
            String strDecodeStringElement4 = null;
            String str6 = null;
            String str7 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(serialDescriptor, 1);
                    i11 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    str6 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, Y0.f38329a, str6);
                    i11 |= 4;
                } else {
                    if (iDecodeElementIndex != 3) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    str7 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Y0.f38329a, str7);
                    i11 |= 8;
                }
            }
            i10 = i11;
            str = strDecodeStringElement;
            str2 = strDecodeStringElement4;
            str3 = str6;
            str4 = str7;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new ResourceTemplate(i10, str, str2, str3, str4, null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, ResourceTemplate value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        ResourceTemplate.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
