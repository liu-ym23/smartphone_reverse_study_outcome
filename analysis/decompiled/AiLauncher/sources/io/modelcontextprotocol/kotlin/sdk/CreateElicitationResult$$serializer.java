package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.modelcontextprotocol.kotlin.sdk.CreateElicitationResult;
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

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/CreateElicitationResult.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/CreateElicitationResult;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class CreateElicitationResult$$serializer implements pb.M<CreateElicitationResult> {
    public static final CreateElicitationResult$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CreateElicitationResult$$serializer createElicitationResult$$serializer = new CreateElicitationResult$$serializer();
        INSTANCE = createElicitationResult$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.CreateElicitationResult", createElicitationResult$$serializer, 3);
        i02.n("action", false);
        i02.n(SkillStoreKt.SKILL_DOC_TYPE_CONTENT, true);
        i02.n("_meta", true);
        descriptor = i02;
    }

    private CreateElicitationResult$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        qb.E e10 = qb.E.f38623a;
        return new KSerializer[]{CreateElicitationResult.$childSerializers[0].getValue(), C4931a.t(e10), e10};
    }

    @Override // lb.InterfaceC4883a
    public final CreateElicitationResult deserialize(Decoder decoder) {
        int i10;
        CreateElicitationResult.Action action;
        qb.D d10;
        qb.D d11;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        Y8.h[] hVarArr = CreateElicitationResult.$childSerializers;
        CreateElicitationResult.Action action2 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            CreateElicitationResult.Action action3 = (CreateElicitationResult.Action) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 0, (InterfaceC4883a) hVarArr[0].getValue(), null);
            qb.E e10 = qb.E.f38623a;
            qb.D d12 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, e10, null);
            action = action3;
            d11 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, e10, null);
            i10 = 7;
            d10 = d12;
        } else {
            boolean z10 = true;
            int i11 = 0;
            qb.D d13 = null;
            qb.D d14 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z10 = false;
                } else if (iDecodeElementIndex == 0) {
                    action2 = (CreateElicitationResult.Action) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 0, (InterfaceC4883a) hVarArr[0].getValue(), action2);
                    i11 |= 1;
                } else if (iDecodeElementIndex == 1) {
                    d13 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, qb.E.f38623a, d13);
                    i11 |= 2;
                } else {
                    if (iDecodeElementIndex != 2) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    d14 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, qb.E.f38623a, d14);
                    i11 |= 4;
                }
            }
            i10 = i11;
            action = action2;
            d10 = d13;
            d11 = d14;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new CreateElicitationResult(i10, action, d10, d11, (T0) null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, CreateElicitationResult value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        CreateElicitationResult.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
