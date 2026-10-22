package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.modelcontextprotocol.kotlin.sdk.CreateMessageRequest;
import java.util.List;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import lb.InterfaceC4883a;
import mb.C4931a;
import pb.C5083B;
import pb.I0;
import pb.X;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/CreateMessageRequest.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/CreateMessageRequest;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class CreateMessageRequest$$serializer implements pb.M<CreateMessageRequest> {
    public static final CreateMessageRequest$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        CreateMessageRequest$$serializer createMessageRequest$$serializer = new CreateMessageRequest$$serializer();
        INSTANCE = createMessageRequest$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.CreateMessageRequest", createMessageRequest$$serializer, 10);
        i02.n("messages", false);
        i02.n("systemPrompt", false);
        i02.n("includeContext", false);
        i02.n(LlmRuntimeArgsBundle.KEY_TEMPERATURE, false);
        i02.n("maxTokens", false);
        i02.n("stopSequences", false);
        i02.n("metadata", true);
        i02.n("modelPreferences", false);
        i02.n("_meta", true);
        i02.n("method", true);
        descriptor = i02;
    }

    private CreateMessageRequest$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        Y8.h[] hVarArr = CreateMessageRequest.$childSerializers;
        qb.E e10 = qb.E.f38623a;
        return new KSerializer[]{hVarArr[0].getValue(), C4931a.t(Y0.f38329a), C4931a.t((KSerializer) hVarArr[2].getValue()), C4931a.t(C5083B.f38260a), X.f38325a, C4931a.t((KSerializer) hVarArr[5].getValue()), e10, C4931a.t(ModelPreferences$$serializer.INSTANCE), e10, RequestMethodSerializer.INSTANCE};
    }

    @Override // lb.InterfaceC4883a
    public final CreateMessageRequest deserialize(Decoder decoder) {
        int i10;
        Method method;
        qb.D d10;
        List list;
        qb.D d11;
        ModelPreferences modelPreferences;
        Double d12;
        CreateMessageRequest.IncludeContext includeContext;
        String str;
        int i11;
        List list2;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        Y8.h[] hVarArr = CreateMessageRequest.$childSerializers;
        int i12 = 9;
        if (cVarBeginStructure.decodeSequentially()) {
            List list3 = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 0, (InterfaceC4883a) hVarArr[0].getValue(), null);
            String str2 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Y0.f38329a, null);
            CreateMessageRequest.IncludeContext includeContext2 = (CreateMessageRequest.IncludeContext) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (InterfaceC4883a) hVarArr[2].getValue(), null);
            Double d13 = (Double) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, C5083B.f38260a, null);
            int iDecodeIntElement = cVarBeginStructure.decodeIntElement(serialDescriptor, 4);
            List list4 = (List) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 5, (InterfaceC4883a) hVarArr[5].getValue(), null);
            qb.E e10 = qb.E.f38623a;
            qb.D d14 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 6, e10, null);
            ModelPreferences modelPreferences2 = (ModelPreferences) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, ModelPreferences$$serializer.INSTANCE, null);
            qb.D d15 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 8, e10, null);
            list = list4;
            list2 = list3;
            method = (Method) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 9, RequestMethodSerializer.INSTANCE, null);
            modelPreferences = modelPreferences2;
            d11 = d14;
            d12 = d13;
            d10 = d15;
            i10 = iDecodeIntElement;
            i11 = 1023;
            includeContext = includeContext2;
            str = str2;
        } else {
            int i13 = 5;
            int i14 = 2;
            boolean z10 = true;
            int iDecodeIntElement2 = 0;
            Method method2 = null;
            qb.D d16 = null;
            List list5 = null;
            qb.D d17 = null;
            ModelPreferences modelPreferences3 = null;
            Double d18 = null;
            CreateMessageRequest.IncludeContext includeContext3 = null;
            List list6 = null;
            int i15 = 0;
            String str3 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                        i14 = 2;
                        i13 = 5;
                    case 0:
                        list6 = (List) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 0, (InterfaceC4883a) hVarArr[0].getValue(), list6);
                        i15 |= 1;
                        i12 = 9;
                        i14 = 2;
                        i13 = 5;
                    case 1:
                        str3 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Y0.f38329a, str3);
                        i15 |= 2;
                        i12 = 9;
                        i14 = 2;
                        i13 = 5;
                    case 2:
                        includeContext3 = (CreateMessageRequest.IncludeContext) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, i14, (InterfaceC4883a) hVarArr[i14].getValue(), includeContext3);
                        i15 |= 4;
                        i12 = 9;
                        i13 = 5;
                    case 3:
                        d18 = (Double) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, C5083B.f38260a, d18);
                        i15 |= 8;
                        i12 = 9;
                        i13 = 5;
                    case 4:
                        iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(serialDescriptor, 4);
                        i15 |= 16;
                        i12 = 9;
                    case 5:
                        list5 = (List) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, i13, (InterfaceC4883a) hVarArr[i13].getValue(), list5);
                        i15 |= 32;
                        i12 = 9;
                    case 6:
                        d17 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 6, qb.E.f38623a, d17);
                        i15 |= 64;
                        i12 = 9;
                    case 7:
                        modelPreferences3 = (ModelPreferences) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 7, ModelPreferences$$serializer.INSTANCE, modelPreferences3);
                        i15 |= 128;
                        i12 = 9;
                    case 8:
                        d16 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 8, qb.E.f38623a, d16);
                        i15 |= 256;
                        i12 = 9;
                    case 9:
                        method2 = (Method) cVarBeginStructure.decodeSerializableElement(serialDescriptor, i12, RequestMethodSerializer.INSTANCE, method2);
                        i15 |= 512;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i10 = iDecodeIntElement2;
            method = method2;
            d10 = d16;
            list = list5;
            d11 = d17;
            modelPreferences = modelPreferences3;
            d12 = d18;
            includeContext = includeContext3;
            str = str3;
            i11 = i15;
            list2 = list6;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new CreateMessageRequest(i11, list2, str, includeContext, d12, i10, list, d11, modelPreferences, d10, method, null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, CreateMessageRequest value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        CreateMessageRequest.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
