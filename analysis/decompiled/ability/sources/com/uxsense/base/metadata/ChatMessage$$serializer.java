package com.uxsense.base.metadata;

import A9.d;
import A9.e;
import B9.A;
import B9.C0180g;
import B9.L;
import B9.T;
import B9.V;
import B9.d0;
import B9.h0;
import C7.c;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.InterfaceC2123a;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/base/metadata/ChatMessage.$serializer", "LB9/A;", "Lcom/uxsense/base/metadata/ChatMessage;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/base/metadata/ChatMessage;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/base/metadata/ChatMessage;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class ChatMessage$$serializer implements A {
    public static final ChatMessage$$serializer INSTANCE;
    private static final g descriptor;

    static {
        ChatMessage$$serializer chatMessage$$serializer = new ChatMessage$$serializer();
        INSTANCE = chatMessage$$serializer;
        V v10 = new V("com.uxsense.base.metadata.ChatMessage", chatMessage$$serializer, 10);
        v10.j("messageId", false);
        v10.j("chatId", false);
        v10.j("senderId", false);
        v10.j("type", true);
        v10.j("text", true);
        v10.j("media", true);
        v10.j("sentAt", false);
        v10.j("status", true);
        v10.j("isRead", true);
        v10.j("userId", true);
        descriptor = v10;
    }

    private ChatMessage$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // B9.A
    public final b[] childSerializers() {
        f[] fVarArr = ChatMessage.$childSerializers;
        L l = L.f223a;
        return new b[]{l, l, l, fVarArr[3].getF4884a(), h0.f242a, AbstractC1451a.G((b) fVarArr[5].getF4884a()), l, fVarArr[7].getF4884a(), C0180g.f239a, l};
    }

    @Override // x9.InterfaceC2123a
    public final ChatMessage deserialize(e decoder) {
        int i;
        MessageStatus messageStatus;
        List list;
        MessageType messageType;
        boolean zDecodeBooleanElement;
        long j5;
        long j6;
        String str;
        long j10;
        long j11;
        long jDecodeLongElement;
        int i6;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        f[] fVarArr = ChatMessage.$childSerializers;
        int i10 = 9;
        int i11 = 3;
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 0);
            long jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(gVar, 1);
            long jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(gVar, 2);
            MessageType messageType2 = (MessageType) cVarBeginStructure.decodeSerializableElement(gVar, 3, (InterfaceC2123a) fVarArr[3].getF4884a(), null);
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 4);
            List list2 = (List) cVarBeginStructure.decodeNullableSerializableElement(gVar, 5, (InterfaceC2123a) fVarArr[5].getF4884a(), null);
            long jDecodeLongElement5 = cVarBeginStructure.decodeLongElement(gVar, 6);
            messageStatus = (MessageStatus) cVarBeginStructure.decodeSerializableElement(gVar, 7, (InterfaceC2123a) fVarArr[7].getF4884a(), null);
            messageType = messageType2;
            i = 1023;
            zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(gVar, 8);
            str = strDecodeStringElement;
            list = list2;
            j5 = jDecodeLongElement5;
            j6 = jDecodeLongElement3;
            j10 = jDecodeLongElement2;
            j11 = jDecodeLongElement4;
            jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 9);
        } else {
            long jDecodeLongElement6 = 0;
            boolean z10 = true;
            int i12 = 0;
            MessageStatus messageStatus2 = null;
            List list3 = null;
            String strDecodeStringElement2 = null;
            long jDecodeLongElement7 = 0;
            long jDecodeLongElement8 = 0;
            long jDecodeLongElement9 = 0;
            long jDecodeLongElement10 = 0;
            boolean zDecodeBooleanElement2 = false;
            MessageType messageType3 = null;
            while (z10) {
                int i13 = i11;
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                        i10 = 9;
                        i11 = 3;
                    case 0:
                        jDecodeLongElement8 = cVarBeginStructure.decodeLongElement(gVar, 0);
                        i12 |= 1;
                        i10 = 9;
                        i11 = 3;
                    case 1:
                        jDecodeLongElement7 = cVarBeginStructure.decodeLongElement(gVar, 1);
                        i12 |= 2;
                        i10 = 9;
                        i11 = 3;
                    case 2:
                        i6 = i13;
                        jDecodeLongElement9 = cVarBeginStructure.decodeLongElement(gVar, 2);
                        i12 |= 4;
                        i11 = i6;
                        i10 = 9;
                    case 3:
                        i6 = i13;
                        messageType3 = (MessageType) cVarBeginStructure.decodeSerializableElement(gVar, i6, (InterfaceC2123a) fVarArr[i13].getF4884a(), messageType3);
                        i12 |= 8;
                        i11 = i6;
                        i10 = 9;
                    case 4:
                        strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, 4);
                        i12 |= 16;
                        i11 = i13;
                    case 5:
                        list3 = (List) cVarBeginStructure.decodeNullableSerializableElement(gVar, 5, (InterfaceC2123a) fVarArr[5].getF4884a(), list3);
                        i12 |= 32;
                        i11 = i13;
                    case 6:
                        jDecodeLongElement6 = cVarBeginStructure.decodeLongElement(gVar, 6);
                        i12 |= 64;
                        i11 = i13;
                    case 7:
                        messageStatus2 = (MessageStatus) cVarBeginStructure.decodeSerializableElement(gVar, 7, (InterfaceC2123a) fVarArr[7].getF4884a(), messageStatus2);
                        i12 |= 128;
                        i11 = i13;
                    case 8:
                        zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(gVar, 8);
                        i12 |= 256;
                        i11 = i13;
                    case 9:
                        jDecodeLongElement10 = cVarBeginStructure.decodeLongElement(gVar, i10);
                        i12 |= 512;
                        i11 = i13;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i12;
            messageStatus = messageStatus2;
            list = list3;
            messageType = messageType3;
            zDecodeBooleanElement = zDecodeBooleanElement2;
            j5 = jDecodeLongElement6;
            j6 = jDecodeLongElement7;
            str = strDecodeStringElement2;
            j10 = jDecodeLongElement8;
            j11 = jDecodeLongElement9;
            jDecodeLongElement = jDecodeLongElement10;
        }
        cVarBeginStructure.endStructure(gVar);
        return new ChatMessage(i, j10, j6, j11, messageType, str, list, j5, messageStatus, zDecodeBooleanElement, jDecodeLongElement, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(A9.f encoder, ChatMessage value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        ChatMessage.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
