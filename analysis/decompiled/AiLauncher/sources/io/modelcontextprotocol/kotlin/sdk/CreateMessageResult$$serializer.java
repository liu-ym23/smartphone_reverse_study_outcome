package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.ability.converter.BundleContentBridge;
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

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/CreateMessageResult.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/CreateMessageResult;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/CreateMessageResult;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/CreateMessageResult;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class CreateMessageResult$$serializer implements pb.M<CreateMessageResult> {
    public static final CreateMessageResult$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CreateMessageResult$$serializer createMessageResult$$serializer = new CreateMessageResult$$serializer();
        INSTANCE = createMessageResult$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.CreateMessageResult", createMessageResult$$serializer, 5);
        i02.n(AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, false);
        i02.n("stopReason", true);
        i02.n(BundleContentBridge.KEY_ROLE, false);
        i02.n(SkillStoreKt.SKILL_DOC_TYPE_CONTENT, false);
        i02.n("_meta", true);
        descriptor = i02;
    }

    private CreateMessageResult$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{Y0.f38329a, C4931a.t(StopReasonSerializer.INSTANCE), CreateMessageResult.$childSerializers[2].getValue(), PromptMessageContentMultimodalPolymorphicSerializer.INSTANCE, qb.E.f38623a};
    }

    @Override // lb.InterfaceC4883a
    public final CreateMessageResult deserialize(Decoder decoder) {
        int i10;
        String str;
        StopReason stopReason;
        Role role;
        PromptMessageContentMultimodal promptMessageContentMultimodal;
        qb.D d10;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        Y8.h[] hVarArr = CreateMessageResult.$childSerializers;
        String strDecodeStringElement = null;
        if (cVarBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
            StopReason stopReason2 = (StopReason) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StopReasonSerializer.INSTANCE, null);
            role = (Role) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, (InterfaceC4883a) hVarArr[2].getValue(), null);
            str = strDecodeStringElement2;
            promptMessageContentMultimodal = (PromptMessageContentMultimodal) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, PromptMessageContentMultimodalPolymorphicSerializer.INSTANCE, null);
            d10 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 4, qb.E.f38623a, null);
            i10 = 31;
            stopReason = stopReason2;
        } else {
            boolean z10 = true;
            int i11 = 0;
            StopReason stopReason3 = null;
            Role role2 = null;
            PromptMessageContentMultimodal promptMessageContentMultimodal2 = null;
            qb.D d11 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    strDecodeStringElement = cVarBeginStructure.decodeStringElement(serialDescriptor, 0);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    stopReason3 = (StopReason) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StopReasonSerializer.INSTANCE, stopReason3);
                    i11 |= 2;
                } else if (iDecodeElementIndex == 2) {
                    role2 = (Role) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, (InterfaceC4883a) hVarArr[2].getValue(), role2);
                    i11 |= 4;
                } else if (iDecodeElementIndex == 3) {
                    promptMessageContentMultimodal2 = (PromptMessageContentMultimodal) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, PromptMessageContentMultimodalPolymorphicSerializer.INSTANCE, promptMessageContentMultimodal2);
                    i11 |= 8;
                } else {
                    if (iDecodeElementIndex != 4) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    d11 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 4, qb.E.f38623a, d11);
                    i11 |= 16;
                }
            }
            i10 = i11;
            str = strDecodeStringElement;
            stopReason = stopReason3;
            role = role2;
            promptMessageContentMultimodal = promptMessageContentMultimodal2;
            d10 = d11;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new CreateMessageResult(i10, str, stopReason, role, promptMessageContentMultimodal, d10, (T0) null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, CreateMessageResult value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        CreateMessageResult.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
