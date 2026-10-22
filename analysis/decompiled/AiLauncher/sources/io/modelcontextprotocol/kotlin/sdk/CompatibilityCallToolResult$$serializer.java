package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import lb.InterfaceC4883a;
import mb.C4931a;
import pb.C5100i;
import pb.I0;
import pb.T0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/CompatibilityCallToolResult.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/CompatibilityCallToolResult;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/CompatibilityCallToolResult;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/CompatibilityCallToolResult;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class CompatibilityCallToolResult$$serializer implements pb.M<CompatibilityCallToolResult> {
    public static final CompatibilityCallToolResult$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CompatibilityCallToolResult$$serializer compatibilityCallToolResult$$serializer = new CompatibilityCallToolResult$$serializer();
        INSTANCE = compatibilityCallToolResult$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.CompatibilityCallToolResult", compatibilityCallToolResult$$serializer, 5);
        i02.n(SkillStoreKt.SKILL_DOC_TYPE_CONTENT, false);
        i02.n("structuredContent", true);
        i02.n("isError", true);
        i02.n("_meta", true);
        i02.n("toolResult", true);
        descriptor = i02;
    }

    private CompatibilityCallToolResult$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        qb.E e10 = qb.E.f38623a;
        return new KSerializer[]{CompatibilityCallToolResult.$childSerializers[0].getValue(), C4931a.t(e10), C4931a.t(C5100i.f38363a), e10, e10};
    }

    @Override // lb.InterfaceC4883a
    public final CompatibilityCallToolResult deserialize(Decoder decoder) {
        int i10;
        List list;
        qb.D d10;
        Boolean bool;
        qb.D d11;
        qb.D d12;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        Y8.h[] hVarArr = CompatibilityCallToolResult.$childSerializers;
        int i11 = 0;
        List list2 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            List list3 = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 0, (InterfaceC4883a) hVarArr[0].getValue(), null);
            qb.E e10 = qb.E.f38623a;
            qb.D d13 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, e10, null);
            Boolean bool2 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, C5100i.f38363a, null);
            qb.D d14 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, e10, null);
            list = list3;
            d12 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 4, e10, null);
            d11 = d14;
            i10 = 31;
            bool = bool2;
            d10 = d13;
        } else {
            int i12 = 1;
            int i13 = 0;
            qb.D d15 = null;
            Boolean bool3 = null;
            qb.D d16 = null;
            qb.D d17 = null;
            while (i12 != 0) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                int i14 = i11;
                if (iDecodeElementIndex == -1) {
                    i11 = i14;
                    i12 = i11;
                } else if (iDecodeElementIndex != 0) {
                    if (iDecodeElementIndex == 1) {
                        d15 = (qb.D) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, qb.E.f38623a, d15);
                        i13 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        bool3 = (Boolean) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, C5100i.f38363a, bool3);
                        i13 |= 4;
                    } else if (iDecodeElementIndex == 3) {
                        d16 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, qb.E.f38623a, d16);
                        i13 |= 8;
                    } else {
                        if (iDecodeElementIndex != 4) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        d17 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 4, qb.E.f38623a, d17);
                        i13 |= 16;
                    }
                    i11 = i14;
                } else {
                    list2 = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, i14, (InterfaceC4883a) hVarArr[i14].getValue(), list2);
                    i13 |= 1;
                    i11 = i14;
                }
            }
            i10 = i13;
            list = list2;
            d10 = d15;
            bool = bool3;
            d11 = d16;
            d12 = d17;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new CompatibilityCallToolResult(i10, list, d10, bool, d11, d12, (T0) null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, CompatibilityCallToolResult value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        CompatibilityCallToolResult.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
