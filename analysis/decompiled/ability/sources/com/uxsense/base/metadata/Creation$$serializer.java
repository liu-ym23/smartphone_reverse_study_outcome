package com.uxsense.base.metadata;

import A9.d;
import A9.e;
import B9.A;
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

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/base/metadata/Creation.$serializer", "LB9/A;", "Lcom/uxsense/base/metadata/Creation;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/base/metadata/Creation;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/base/metadata/Creation;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class Creation$$serializer implements A {
    public static final Creation$$serializer INSTANCE;
    private static final g descriptor;

    static {
        Creation$$serializer creation$$serializer = new Creation$$serializer();
        INSTANCE = creation$$serializer;
        V v10 = new V("com.uxsense.base.metadata.Creation", creation$$serializer, 23);
        v10.j("creationId", false);
        v10.j("postId", true);
        v10.j("userId", false);
        v10.j("uuid", true);
        v10.j("authorNickname", true);
        v10.j("cover", true);
        v10.j("images", true);
        v10.j("videos", true);
        v10.j("type", true);
        v10.j("title", true);
        v10.j("content", true);
        v10.j("group", true);
        v10.j("tags", true);
        v10.j("mentionedUsers", true);
        v10.j("location", true);
        v10.j("extra", true);
        v10.j("createdAt", true);
        v10.j("publishedAt", true);
        v10.j("lastEditedAt", true);
        v10.j("visibility", true);
        v10.j("interactionStats", true);
        v10.j("commentIndex", true);
        v10.j("screenshots", true);
        descriptor = v10;
    }

    private Creation$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // B9.A
    public final b[] childSerializers() {
        f[] fVarArr = Creation.$childSerializers;
        L l = L.f223a;
        h0 h0Var = h0.f242a;
        return new b[]{l, h0Var, l, h0Var, h0Var, h0Var, fVarArr[6].getF4884a(), fVarArr[7].getF4884a(), fVarArr[8].getF4884a(), h0Var, h0Var, h0Var, fVarArr[12].getF4884a(), fVarArr[13].getF4884a(), h0Var, h0Var, l, l, l, fVarArr[19].getF4884a(), InteractionStats$$serializer.INSTANCE, CommentIndex$$serializer.INSTANCE, fVarArr[22].getF4884a()};
    }

    @Override // x9.InterfaceC2123a
    public final Creation deserialize(e decoder) {
        int i;
        List list;
        String str;
        InteractionStats interactionStats;
        List list2;
        String str2;
        Visibility visibility;
        List list3;
        CommentIndex commentIndex;
        List list4;
        CreationType creationType;
        List list5;
        long j5;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        long j6;
        long j10;
        long j11;
        long j12;
        int i6;
        int i10;
        int i11;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        f[] fVarArr = Creation.$childSerializers;
        int i12 = 10;
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 0);
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 1);
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 2);
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, 3);
            String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(gVar, 4);
            String strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(gVar, 5);
            List list6 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 6, (InterfaceC2123a) fVarArr[6].getF4884a(), null);
            List list7 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 7, (InterfaceC2123a) fVarArr[7].getF4884a(), null);
            CreationType creationType2 = (CreationType) cVarBeginStructure.decodeSerializableElement(gVar, 8, (InterfaceC2123a) fVarArr[8].getF4884a(), null);
            String strDecodeStringElement5 = cVarBeginStructure.decodeStringElement(gVar, 9);
            String strDecodeStringElement6 = cVarBeginStructure.decodeStringElement(gVar, 10);
            String strDecodeStringElement7 = cVarBeginStructure.decodeStringElement(gVar, 11);
            List list8 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 12, (InterfaceC2123a) fVarArr[12].getF4884a(), null);
            List list9 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 13, (InterfaceC2123a) fVarArr[13].getF4884a(), null);
            String strDecodeStringElement8 = cVarBeginStructure.decodeStringElement(gVar, 14);
            String strDecodeStringElement9 = cVarBeginStructure.decodeStringElement(gVar, 15);
            long jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(gVar, 16);
            long jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(gVar, 17);
            long jDecodeLongElement5 = cVarBeginStructure.decodeLongElement(gVar, 18);
            Visibility visibility2 = (Visibility) cVarBeginStructure.decodeSerializableElement(gVar, 19, (InterfaceC2123a) fVarArr[19].getF4884a(), null);
            InteractionStats interactionStats2 = (InteractionStats) cVarBeginStructure.decodeSerializableElement(gVar, 20, InteractionStats$$serializer.INSTANCE, null);
            CommentIndex commentIndex2 = (CommentIndex) cVarBeginStructure.decodeSerializableElement(gVar, 21, CommentIndex$$serializer.INSTANCE, null);
            i = 8388607;
            str8 = strDecodeStringElement8;
            list2 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 22, (InterfaceC2123a) fVarArr[22].getF4884a(), null);
            list = list6;
            creationType = creationType2;
            str9 = strDecodeStringElement9;
            str6 = strDecodeStringElement6;
            str5 = strDecodeStringElement5;
            str4 = strDecodeStringElement4;
            str = strDecodeStringElement2;
            list5 = list7;
            str3 = strDecodeStringElement3;
            str7 = strDecodeStringElement7;
            str2 = strDecodeStringElement;
            j6 = jDecodeLongElement4;
            list3 = list8;
            j10 = jDecodeLongElement3;
            j11 = jDecodeLongElement5;
            j12 = jDecodeLongElement2;
            j5 = jDecodeLongElement;
            visibility = visibility2;
            list4 = list9;
            interactionStats = interactionStats2;
            commentIndex = commentIndex2;
        } else {
            String strDecodeStringElement10 = null;
            long jDecodeLongElement6 = 0;
            i = 0;
            List list10 = null;
            String strDecodeStringElement11 = null;
            Visibility visibility3 = null;
            List list11 = null;
            List list12 = null;
            CreationType creationType3 = null;
            String strDecodeStringElement12 = null;
            String strDecodeStringElement13 = null;
            String strDecodeStringElement14 = null;
            String strDecodeStringElement15 = null;
            String strDecodeStringElement16 = null;
            String strDecodeStringElement17 = null;
            String strDecodeStringElement18 = null;
            int i13 = 8;
            int i14 = 7;
            boolean z10 = true;
            long jDecodeLongElement7 = 0;
            long jDecodeLongElement8 = 0;
            long jDecodeLongElement9 = 0;
            long jDecodeLongElement10 = 0;
            InteractionStats interactionStats3 = null;
            List list13 = null;
            CommentIndex commentIndex3 = null;
            List list14 = null;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                        i12 = 10;
                        i14 = 7;
                        i13 = 8;
                    case 0:
                        jDecodeLongElement6 = cVarBeginStructure.decodeLongElement(gVar, 0);
                        i |= 1;
                        i12 = 10;
                        i14 = 7;
                        i13 = 8;
                    case 1:
                        i |= 2;
                        strDecodeStringElement11 = cVarBeginStructure.decodeStringElement(gVar, 1);
                        i12 = 10;
                        i14 = 7;
                        i13 = 8;
                    case 2:
                        jDecodeLongElement10 = cVarBeginStructure.decodeLongElement(gVar, 2);
                        i |= 4;
                        i12 = 10;
                        i14 = 7;
                        i13 = 8;
                    case 3:
                        i |= 8;
                        strDecodeStringElement10 = cVarBeginStructure.decodeStringElement(gVar, 3);
                        i12 = 10;
                        i14 = 7;
                        i13 = 8;
                    case 4:
                        strDecodeStringElement12 = cVarBeginStructure.decodeStringElement(gVar, 4);
                        i |= 16;
                        i12 = 10;
                        i14 = 7;
                        i13 = 8;
                    case 5:
                        strDecodeStringElement13 = cVarBeginStructure.decodeStringElement(gVar, 5);
                        i |= 32;
                        i12 = 10;
                        i14 = 7;
                        i13 = 8;
                    case 6:
                        list10 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 6, (InterfaceC2123a) fVarArr[6].getF4884a(), list10);
                        i |= 64;
                        i12 = 10;
                        i14 = 7;
                        i13 = 8;
                    case 7:
                        list14 = (List) cVarBeginStructure.decodeSerializableElement(gVar, i14, (InterfaceC2123a) fVarArr[i14].getF4884a(), list14);
                        i |= 128;
                        i12 = 10;
                        i13 = 8;
                    case 8:
                        creationType3 = (CreationType) cVarBeginStructure.decodeSerializableElement(gVar, i13, (InterfaceC2123a) fVarArr[i13].getF4884a(), creationType3);
                        i |= 256;
                        i12 = 10;
                    case 9:
                        strDecodeStringElement14 = cVarBeginStructure.decodeStringElement(gVar, 9);
                        i |= 512;
                        i12 = 10;
                    case 10:
                        strDecodeStringElement15 = cVarBeginStructure.decodeStringElement(gVar, i12);
                        i |= 1024;
                    case 11:
                        strDecodeStringElement16 = cVarBeginStructure.decodeStringElement(gVar, 11);
                        i |= 2048;
                        i12 = 10;
                    case 12:
                        list11 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 12, (InterfaceC2123a) fVarArr[12].getF4884a(), list11);
                        i |= 4096;
                        i12 = 10;
                    case 13:
                        list12 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 13, (InterfaceC2123a) fVarArr[13].getF4884a(), list12);
                        i |= 8192;
                        i12 = 10;
                    case 14:
                        strDecodeStringElement17 = cVarBeginStructure.decodeStringElement(gVar, 14);
                        i |= 16384;
                        i12 = 10;
                    case 15:
                        strDecodeStringElement18 = cVarBeginStructure.decodeStringElement(gVar, 15);
                        i6 = 32768;
                        i |= i6;
                        i12 = 10;
                    case 16:
                        jDecodeLongElement8 = cVarBeginStructure.decodeLongElement(gVar, 16);
                        i6 = 65536;
                        i |= i6;
                        i12 = 10;
                    case 17:
                        jDecodeLongElement7 = cVarBeginStructure.decodeLongElement(gVar, 17);
                        i6 = 131072;
                        i |= i6;
                        i12 = 10;
                    case 18:
                        jDecodeLongElement9 = cVarBeginStructure.decodeLongElement(gVar, 18);
                        i10 = 262144;
                        i |= i10;
                        i12 = 10;
                    case 19:
                        visibility3 = (Visibility) cVarBeginStructure.decodeSerializableElement(gVar, 19, (InterfaceC2123a) fVarArr[19].getF4884a(), visibility3);
                        i10 = 524288;
                        i |= i10;
                        i12 = 10;
                    case 20:
                        interactionStats3 = (InteractionStats) cVarBeginStructure.decodeSerializableElement(gVar, 20, InteractionStats$$serializer.INSTANCE, interactionStats3);
                        i11 = 1048576;
                        i |= i11;
                        i12 = 10;
                    case 21:
                        commentIndex3 = (CommentIndex) cVarBeginStructure.decodeSerializableElement(gVar, 21, CommentIndex$$serializer.INSTANCE, commentIndex3);
                        i11 = 2097152;
                        i |= i11;
                        i12 = 10;
                    case 22:
                        list13 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 22, (InterfaceC2123a) fVarArr[22].getF4884a(), list13);
                        i11 = 4194304;
                        i |= i11;
                        i12 = 10;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            list = list10;
            str = strDecodeStringElement10;
            interactionStats = interactionStats3;
            list2 = list13;
            str2 = strDecodeStringElement11;
            visibility = visibility3;
            list3 = list11;
            commentIndex = commentIndex3;
            list4 = list12;
            creationType = creationType3;
            list5 = list14;
            j5 = jDecodeLongElement6;
            str3 = strDecodeStringElement12;
            str4 = strDecodeStringElement13;
            str5 = strDecodeStringElement14;
            str6 = strDecodeStringElement15;
            str7 = strDecodeStringElement16;
            str8 = strDecodeStringElement17;
            str9 = strDecodeStringElement18;
            j6 = jDecodeLongElement7;
            j10 = jDecodeLongElement8;
            j11 = jDecodeLongElement9;
            j12 = jDecodeLongElement10;
        }
        int i15 = i;
        cVarBeginStructure.endStructure(gVar);
        return new Creation(i15, j5, str2, j12, str, str3, str4, list, list5, creationType, str5, str6, str7, list3, list4, str8, str9, j10, j6, j11, visibility, interactionStats, commentIndex, list2, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(A9.f encoder, Creation value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        Creation.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
