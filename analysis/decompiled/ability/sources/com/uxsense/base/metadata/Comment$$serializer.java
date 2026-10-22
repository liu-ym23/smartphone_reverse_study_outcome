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

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/base/metadata/Comment.$serializer", "LB9/A;", "Lcom/uxsense/base/metadata/Comment;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/base/metadata/Comment;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/base/metadata/Comment;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class Comment$$serializer implements A {
    public static final Comment$$serializer INSTANCE;
    private static final g descriptor;

    static {
        Comment$$serializer comment$$serializer = new Comment$$serializer();
        INSTANCE = comment$$serializer;
        V v10 = new V("com.uxsense.base.metadata.Comment", comment$$serializer, 17);
        v10.j("commentId", false);
        v10.j("creationId", false);
        v10.j("rootCommentId", false);
        v10.j("parentCommentId", true);
        v10.j("isAuthor", true);
        v10.j("nickname", true);
        v10.j("avatar", true);
        v10.j("userId", false);
        v10.j("content", true);
        v10.j("commentedAt", true);
        v10.j("hasReply", true);
        v10.j("replyCount", true);
        v10.j("likeCount", true);
        v10.j("status", true);
        v10.j("deleted", true);
        v10.j("ip", true);
        v10.j("screenshots", true);
        descriptor = v10;
    }

    private Comment$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // B9.A
    public final b[] childSerializers() {
        f[] fVarArr = Comment.$childSerializers;
        L l = L.f223a;
        C0180g c0180g = C0180g.f239a;
        h0 h0Var = h0.f242a;
        return new b[]{l, l, l, l, c0180g, h0Var, h0Var, l, h0Var, l, c0180g, F.f218a, l, fVarArr[13].getF4884a(), c0180g, h0Var, fVarArr[16].getF4884a()};
    }

    @Override // x9.InterfaceC2123a
    public final Comment deserialize(e decoder) {
        int i;
        CommentStatus commentStatus;
        List list;
        long j5;
        long j6;
        boolean z10;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z11;
        int i6;
        boolean z12;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        f[] fVarArr = Comment.$childSerializers;
        int i10 = 3;
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 0);
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 1);
            long jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(gVar, 2);
            long jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(gVar, 3);
            boolean zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(gVar, 4);
            String strDecodeStringElement = cVarBeginStructure.decodeStringElement(gVar, 5);
            String strDecodeStringElement2 = cVarBeginStructure.decodeStringElement(gVar, 6);
            long jDecodeLongElement5 = cVarBeginStructure.decodeLongElement(gVar, 7);
            String strDecodeStringElement3 = cVarBeginStructure.decodeStringElement(gVar, 8);
            long jDecodeLongElement6 = cVarBeginStructure.decodeLongElement(gVar, 9);
            boolean zDecodeBooleanElement2 = cVarBeginStructure.decodeBooleanElement(gVar, 10);
            int iDecodeIntElement = cVarBeginStructure.decodeIntElement(gVar, 11);
            long jDecodeLongElement7 = cVarBeginStructure.decodeLongElement(gVar, 12);
            CommentStatus commentStatus2 = (CommentStatus) cVarBeginStructure.decodeSerializableElement(gVar, 13, (InterfaceC2123a) fVarArr[13].getF4884a(), null);
            boolean zDecodeBooleanElement3 = cVarBeginStructure.decodeBooleanElement(gVar, 14);
            String strDecodeStringElement4 = cVarBeginStructure.decodeStringElement(gVar, 15);
            i = 131071;
            commentStatus = commentStatus2;
            list = (List) cVarBeginStructure.decodeSerializableElement(gVar, 16, (InterfaceC2123a) fVarArr[16].getF4884a(), null);
            z10 = zDecodeBooleanElement3;
            str4 = strDecodeStringElement4;
            z11 = zDecodeBooleanElement2;
            i6 = iDecodeIntElement;
            str3 = strDecodeStringElement3;
            str2 = strDecodeStringElement2;
            str = strDecodeStringElement;
            z12 = zDecodeBooleanElement;
            j10 = jDecodeLongElement6;
            j11 = jDecodeLongElement7;
            j12 = jDecodeLongElement;
            j13 = jDecodeLongElement4;
            j14 = jDecodeLongElement5;
            j5 = jDecodeLongElement2;
            j6 = jDecodeLongElement3;
        } else {
            long jDecodeLongElement8 = 0;
            i = 0;
            boolean zDecodeBooleanElement4 = false;
            boolean zDecodeBooleanElement5 = false;
            int iDecodeIntElement2 = 0;
            boolean zDecodeBooleanElement6 = false;
            boolean z13 = true;
            CommentStatus commentStatus3 = null;
            List list2 = null;
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            String strDecodeStringElement7 = null;
            String strDecodeStringElement8 = null;
            long jDecodeLongElement9 = 0;
            long jDecodeLongElement10 = 0;
            long jDecodeLongElement11 = 0;
            long jDecodeLongElement12 = 0;
            long jDecodeLongElement13 = 0;
            long jDecodeLongElement14 = 0;
            while (z13) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                switch (iDecodeElementIndex) {
                    case -1:
                        z13 = false;
                        i10 = 3;
                    case 0:
                        jDecodeLongElement12 = cVarBeginStructure.decodeLongElement(gVar, 0);
                        i |= 1;
                        i10 = 3;
                    case 1:
                        i |= 2;
                        jDecodeLongElement9 = cVarBeginStructure.decodeLongElement(gVar, 1);
                        i10 = 3;
                    case 2:
                        jDecodeLongElement8 = cVarBeginStructure.decodeLongElement(gVar, 2);
                        i |= 4;
                        i10 = 3;
                    case 3:
                        int i11 = i10;
                        jDecodeLongElement13 = cVarBeginStructure.decodeLongElement(gVar, i11);
                        i |= 8;
                        i10 = i11;
                    case 4:
                        zDecodeBooleanElement6 = cVarBeginStructure.decodeBooleanElement(gVar, 4);
                        i |= 16;
                        i10 = 3;
                    case 5:
                        strDecodeStringElement5 = cVarBeginStructure.decodeStringElement(gVar, 5);
                        i |= 32;
                        i10 = 3;
                    case 6:
                        strDecodeStringElement6 = cVarBeginStructure.decodeStringElement(gVar, 6);
                        i |= 64;
                        i10 = 3;
                    case 7:
                        jDecodeLongElement14 = cVarBeginStructure.decodeLongElement(gVar, 7);
                        i |= 128;
                        i10 = 3;
                    case 8:
                        strDecodeStringElement7 = cVarBeginStructure.decodeStringElement(gVar, 8);
                        i |= 256;
                        i10 = 3;
                    case 9:
                        jDecodeLongElement10 = cVarBeginStructure.decodeLongElement(gVar, 9);
                        i |= 512;
                        i10 = 3;
                    case 10:
                        zDecodeBooleanElement5 = cVarBeginStructure.decodeBooleanElement(gVar, 10);
                        i |= 1024;
                        i10 = 3;
                    case 11:
                        iDecodeIntElement2 = cVarBeginStructure.decodeIntElement(gVar, 11);
                        i |= 2048;
                        i10 = 3;
                    case 12:
                        jDecodeLongElement11 = cVarBeginStructure.decodeLongElement(gVar, 12);
                        i |= 4096;
                        i10 = 3;
                    case 13:
                        commentStatus3 = (CommentStatus) cVarBeginStructure.decodeSerializableElement(gVar, 13, (InterfaceC2123a) fVarArr[13].getF4884a(), commentStatus3);
                        i |= 8192;
                        i10 = 3;
                    case 14:
                        zDecodeBooleanElement4 = cVarBeginStructure.decodeBooleanElement(gVar, 14);
                        i |= 16384;
                        i10 = 3;
                    case 15:
                        strDecodeStringElement8 = cVarBeginStructure.decodeStringElement(gVar, 15);
                        i |= 32768;
                        i10 = 3;
                    case 16:
                        list2 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 16, (InterfaceC2123a) fVarArr[16].getF4884a(), list2);
                        i |= 65536;
                        i10 = 3;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            commentStatus = commentStatus3;
            list = list2;
            j5 = jDecodeLongElement9;
            j6 = jDecodeLongElement8;
            z10 = zDecodeBooleanElement4;
            str = strDecodeStringElement5;
            str2 = strDecodeStringElement6;
            str3 = strDecodeStringElement7;
            str4 = strDecodeStringElement8;
            z11 = zDecodeBooleanElement5;
            i6 = iDecodeIntElement2;
            z12 = zDecodeBooleanElement6;
            j10 = jDecodeLongElement10;
            j11 = jDecodeLongElement11;
            j12 = jDecodeLongElement12;
            j13 = jDecodeLongElement13;
            j14 = jDecodeLongElement14;
        }
        int i12 = i;
        cVarBeginStructure.endStructure(gVar);
        return new Comment(i12, j12, j5, j6, j13, z12, str, str2, j14, str3, j10, z11, i6, j11, commentStatus, z10, str4, list, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(A9.f encoder, Comment value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        Comment.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
