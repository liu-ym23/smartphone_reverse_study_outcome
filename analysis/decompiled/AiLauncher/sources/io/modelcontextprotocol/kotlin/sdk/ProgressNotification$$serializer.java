package io.modelcontextprotocol.kotlin.sdk;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
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

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/ProgressNotification.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/ProgressNotification;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/ProgressNotification;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/ProgressNotification;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class ProgressNotification$$serializer implements pb.M<ProgressNotification> {
    public static final ProgressNotification$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        ProgressNotification$$serializer progressNotification$$serializer = new ProgressNotification$$serializer();
        INSTANCE = progressNotification$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.ProgressNotification", progressNotification$$serializer, 6);
        i02.n("progress", false);
        i02.n("progressToken", false);
        i02.n("_meta", true);
        i02.n("total", false);
        i02.n("message", false);
        i02.n("method", true);
        descriptor = i02;
    }

    private ProgressNotification$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{X.f38325a, ProgressNotification.$childSerializers[1].getValue(), qb.E.f38623a, C4931a.t(C5083B.f38260a), C4931a.t(Y0.f38329a), RequestMethodSerializer.INSTANCE};
    }

    @Override // lb.InterfaceC4883a
    public final ProgressNotification deserialize(Decoder decoder) {
        int iDecodeIntElement;
        int i10;
        RequestId requestId;
        qb.D d10;
        Double d11;
        String str;
        Method method;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        Y8.h[] hVarArr = ProgressNotification.$childSerializers;
        if (cVarBeginStructure.decodeSequentially()) {
            iDecodeIntElement = cVarBeginStructure.decodeIntElement(serialDescriptor, 0);
            RequestId requestId2 = (RequestId) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 1, (InterfaceC4883a) hVarArr[1].getValue(), null);
            qb.D d12 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, qb.E.f38623a, null);
            Double d13 = (Double) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, C5083B.f38260a, null);
            String str2 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, Y0.f38329a, null);
            requestId = requestId2;
            method = (Method) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 5, RequestMethodSerializer.INSTANCE, null);
            d11 = d13;
            str = str2;
            d10 = d12;
            i10 = 63;
        } else {
            boolean z10 = true;
            iDecodeIntElement = 0;
            RequestId requestId3 = null;
            qb.D d14 = null;
            Double d15 = null;
            String str3 = null;
            Method method2 = null;
            int i11 = 0;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                        continue;
                    case 0:
                        iDecodeIntElement = cVarBeginStructure.decodeIntElement(serialDescriptor, 0);
                        i11 |= 1;
                        continue;
                    case 1:
                        requestId3 = (RequestId) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 1, (InterfaceC4883a) hVarArr[1].getValue(), requestId3);
                        i11 |= 2;
                        break;
                    case 2:
                        d14 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, qb.E.f38623a, d14);
                        i11 |= 4;
                        break;
                    case 3:
                        d15 = (Double) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 3, C5083B.f38260a, d15);
                        i11 |= 8;
                        break;
                    case 4:
                        str3 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 4, Y0.f38329a, str3);
                        i11 |= 16;
                        break;
                    case 5:
                        method2 = (Method) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 5, RequestMethodSerializer.INSTANCE, method2);
                        i11 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i10 = i11;
            requestId = requestId3;
            d10 = d14;
            d11 = d15;
            str = str3;
            method = method2;
        }
        int i12 = iDecodeIntElement;
        cVarBeginStructure.endStructure(serialDescriptor);
        return new ProgressNotification(i10, i12, requestId, d10, d11, str, method, null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, ProgressNotification value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        ProgressNotification.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
