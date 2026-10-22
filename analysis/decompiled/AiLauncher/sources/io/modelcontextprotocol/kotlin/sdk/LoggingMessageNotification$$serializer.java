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
import pb.I0;
import pb.Y0;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification.$serializer", "Lpb/M;", "Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification;", "<init>", "()V", "Lkotlinx/serialization/encoding/Encoder;", "encoder", UxipConstants.f30680s, "LY8/t;", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification;)V", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/modelcontextprotocol/kotlin/sdk/LoggingMessageNotification;", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class LoggingMessageNotification$$serializer implements pb.M<LoggingMessageNotification> {
    public static final LoggingMessageNotification$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        LoggingMessageNotification$$serializer loggingMessageNotification$$serializer = new LoggingMessageNotification$$serializer();
        INSTANCE = loggingMessageNotification$$serializer;
        I0 i02 = new I0("io.modelcontextprotocol.kotlin.sdk.LoggingMessageNotification", loggingMessageNotification$$serializer, 5);
        i02.n("level", false);
        i02.n("logger", true);
        i02.n("data", true);
        i02.n("_meta", true);
        i02.n("method", true);
        descriptor = i02;
    }

    private LoggingMessageNotification$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pb.M
    public final KSerializer<?>[] childSerializers() {
        qb.E e10 = qb.E.f38623a;
        return new KSerializer[]{LoggingMessageNotification.$childSerializers[0].getValue(), C4931a.t(Y0.f38329a), e10, e10, RequestMethodSerializer.INSTANCE};
    }

    @Override // lb.InterfaceC4883a
    public final LoggingMessageNotification deserialize(Decoder decoder) {
        int i10;
        LoggingLevel loggingLevel;
        String str;
        qb.D d10;
        qb.D d11;
        Method method;
        kotlin.jvm.internal.p.i(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        ob.c cVarBeginStructure = decoder.beginStructure(serialDescriptor);
        Y8.h[] hVarArr = LoggingMessageNotification.$childSerializers;
        int i11 = 0;
        LoggingLevel loggingLevel2 = null;
        if (cVarBeginStructure.decodeSequentially()) {
            LoggingLevel loggingLevel3 = (LoggingLevel) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 0, (InterfaceC4883a) hVarArr[0].getValue(), null);
            String str2 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Y0.f38329a, null);
            qb.E e10 = qb.E.f38623a;
            qb.D d12 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, e10, null);
            loggingLevel = loggingLevel3;
            str = str2;
            d11 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, e10, null);
            method = (Method) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 4, RequestMethodSerializer.INSTANCE, null);
            d10 = d12;
            i10 = 31;
        } else {
            int i12 = 1;
            int i13 = 0;
            String str3 = null;
            qb.D d13 = null;
            qb.D d14 = null;
            Method method2 = null;
            while (i12 != 0) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(serialDescriptor);
                int i14 = i11;
                if (iDecodeElementIndex == -1) {
                    i11 = i14;
                    i12 = i11;
                } else if (iDecodeElementIndex != 0) {
                    if (iDecodeElementIndex == 1) {
                        str3 = (String) cVarBeginStructure.decodeNullableSerializableElement(serialDescriptor, 1, Y0.f38329a, str3);
                        i13 |= 2;
                    } else if (iDecodeElementIndex == 2) {
                        d13 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 2, qb.E.f38623a, d13);
                        i13 |= 4;
                    } else if (iDecodeElementIndex == 3) {
                        d14 = (qb.D) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 3, qb.E.f38623a, d14);
                        i13 |= 8;
                    } else {
                        if (iDecodeElementIndex != 4) {
                            throw new UnknownFieldException(iDecodeElementIndex);
                        }
                        method2 = (Method) cVarBeginStructure.decodeSerializableElement(serialDescriptor, 4, RequestMethodSerializer.INSTANCE, method2);
                        i13 |= 16;
                    }
                    i11 = i14;
                } else {
                    loggingLevel2 = (LoggingLevel) cVarBeginStructure.decodeSerializableElement(serialDescriptor, i14, (InterfaceC4883a) hVarArr[i14].getValue(), loggingLevel2);
                    i13 |= 1;
                    i11 = i14;
                }
            }
            i10 = i13;
            loggingLevel = loggingLevel2;
            str = str3;
            d10 = d13;
            d11 = d14;
            method = method2;
        }
        cVarBeginStructure.endStructure(serialDescriptor);
        return new LoggingMessageNotification(i10, loggingLevel, str, d10, d11, method, null);
    }

    @Override // kotlinx.serialization.KSerializer, lb.m, lb.InterfaceC4883a
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // lb.m
    public final void serialize(Encoder encoder, LoggingMessageNotification value) {
        kotlin.jvm.internal.p.i(encoder, "encoder");
        kotlin.jvm.internal.p.i(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        ob.d dVarBeginStructure = encoder.beginStructure(serialDescriptor);
        LoggingMessageNotification.write$Self$kotlin_sdk(value, dVarBeginStructure, serialDescriptor);
        dVarBeginStructure.endStructure(serialDescriptor);
    }

    @Override // pb.M
    public KSerializer<?>[] typeParametersSerializers() {
        return super.typeParametersSerializers();
    }
}
