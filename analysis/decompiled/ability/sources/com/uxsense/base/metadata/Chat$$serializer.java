package com.uxsense.base.metadata;

import A9.d;
import A9.e;
import B9.A;
import B9.C0180g;
import B9.F;
import B9.L;
import B9.T;
import B9.V;
import B9.d0;
import B9.h0;
import C7.c;
import C7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlinx.serialization.UnknownFieldException;
import x9.InterfaceC2123a;
import x9.b;
import z9.g;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/base/metadata/Chat.$serializer", "LB9/A;", "Lcom/uxsense/base/metadata/Chat;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/base/metadata/Chat;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/base/metadata/Chat;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class Chat$$serializer implements A {
    public static final Chat$$serializer INSTANCE;
    private static final g descriptor;

    static {
        Chat$$serializer chat$$serializer = new Chat$$serializer();
        INSTANCE = chat$$serializer;
        V v10 = new V("com.uxsense.base.metadata.Chat", chat$$serializer, 12);
        v10.j("chatId", false);
        v10.j("userId", false);
        v10.j("nickname", true);
        v10.j("avatar", true);
        v10.j("lastMessage", true);
        v10.j("lastMessageAt", true);
        v10.j("unreadCount", true);
        v10.j("isPinned", true);
        v10.j("isMuted", true);
        v10.j("pageIds", true);
        v10.j("lastViewedAt", false);
        v10.j("screenshots", true);
        descriptor = v10;
    }

    private Chat$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // B9.A
    public final b[] childSerializers() {
        f[] fVarArr = Chat.$childSerializers;
        L l = L.f223a;
        h0 h0Var = h0.f242a;
        C0180g c0180g = C0180g.f239a;
        return new b[]{l, l, h0Var, h0Var, h0Var, l, F.f218a, c0180g, c0180g, fVarArr[9].getF4884a(), l, fVarArr[11].getF4884a()};
    }

    @Override // x9.InterfaceC2123a
    public final Chat deserialize(e decoder) {
        int i;
        boolean z10;
        List list;
        List list2;
        int i6;
        boolean z11;
        String str;
        String str2;
        String str3;
        long j5;
        long j6;
        long j10;
        long j11;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        f[] fVarArr = Chat.$childSerializers;
        int i10 = 10;
        int i11 = 3;
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 0);
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 1);
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 2);
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, 3);
            String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(gVar, 4);
            long jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(gVar, 5);
            int iDecodeIntElement = cVarBeginStructure.decodeIntElement(gVar, 6);
            boolean zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(gVar, 7);
            boolean zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(gVar, 8);
            List list3 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 9, (InterfaceC2123a) fVarArr[9].getF4884a(), null);
            long jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(gVar, 10);
            list = (List) cVarBeginStructure.decodeSerializableElement(gVar, 11, (InterfaceC2123a) fVarArr[11].getF4884a(), null);
            str = strDecodeStringElement;
            i = 4095;
            z10 = zDecodeBooleanElement;
            i6 = iDecodeIntElement;
            z11 = zDecodeBooleanElement2;
            str2 = strDecodeStringElement2;
            list2 = list3;
            str3 = strDecodeStringElement3;
            j5 = jDecodeLongElement4;
            j6 = jDecodeLongElement;
            j10 = jDecodeLongElement2;
            j11 = jDecodeLongElement3;
        } else {
            String strDecodeStringElement4 = null;
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            boolean z12 = true;
            int i12 = 0;
            long jDecodeLongElement5 = 0;
            long jDecodeLongElement6 = 0;
            long jDecodeLongElement7 = 0;
            long jDecodeLongElement8 = 0;
            List list4 = null;
            List list5 = null;
            boolean zDecodeBooleanElement3 = false;
            int iDecodeIntElement2 = 0;
            boolean zDecodeBooleanElement4 = false;
            while (z12) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                switch (iDecodeElementIndex) {
                    case -1:
                        z12 = false;
                        i10 = 10;
                    case 0:
                        jDecodeLongElement6 = cVarBeginStructure.decodeLongElement(gVar, 0);
                        i12 |= 1;
                        i10 = 10;
                    case 1:
                        jDecodeLongElement7 = cVarBeginStructure.decodeLongElement(gVar, 1);
                        i12 |= 2;
                        i10 = 10;
                    case 2:
                        strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(gVar, 2);
                        i12 |= 4;
                        i10 = 10;
                    case 3:
                        strDecodeStringElement5 = cVarBeginStructure.decodeStringElement(gVar, i11);
                        i12 |= 8;
                    case 4:
                        strDecodeStringElement6 = cVarBeginStructure.decodeStringElement(gVar, 4);
                        i12 |= 16;
                        i11 = 3;
                    case 5:
                        jDecodeLongElement8 = cVarBeginStructure.decodeLongElement(gVar, 5);
                        i12 |= 32;
                        i11 = 3;
                    case 6:
                        iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(gVar, 6);
                        i12 |= 64;
                        i11 = 3;
                    case 7:
                        zDecodeBooleanElement3 = cVarBeginStructure.decodeBooleanElement(gVar, 7);
                        i12 |= 128;
                        i11 = 3;
                    case 8:
                        zDecodeBooleanElement4 = cVarBeginStructure.decodeBooleanElement(gVar, 8);
                        i12 |= 256;
                        i11 = 3;
                    case 9:
                        list5 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 9, (InterfaceC2123a) fVarArr[9].getF4884a(), list5);
                        i12 |= 512;
                        i11 = 3;
                    case 10:
                        jDecodeLongElement5 = cVarBeginStructure.decodeLongElement(gVar, i10);
                        i12 |= 1024;
                        i11 = 3;
                    case 11:
                        list4 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 11, (InterfaceC2123a) fVarArr[11].getF4884a(), list4);
                        i12 |= 2048;
                        i11 = 3;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i12;
            z10 = zDecodeBooleanElement3;
            list = list4;
            list2 = list5;
            i6 = iDecodeIntElement2;
            z11 = zDecodeBooleanElement4;
            str = strDecodeStringElement4;
            str2 = strDecodeStringElement5;
            str3 = strDecodeStringElement6;
            j5 = jDecodeLongElement5;
            j6 = jDecodeLongElement6;
            j10 = jDecodeLongElement7;
            j11 = jDecodeLongElement8;
        }
        cVarBeginStructure.endStructure(gVar);
        return new Chat(i, j6, j10, str, str2, str3, j11, i6, z10, z11, list2, j5, list, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(A9.f encoder, Chat value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        Chat.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
