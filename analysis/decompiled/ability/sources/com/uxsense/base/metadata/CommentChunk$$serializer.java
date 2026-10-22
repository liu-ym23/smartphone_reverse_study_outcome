package com.uxsense.base.metadata;

import A9.d;
import A9.e;
import B9.A;
import B9.C0180g;
import B9.L;
import B9.T;
import B9.V;
import B9.d0;
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

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"com/uxsense/base/metadata/CommentChunk.$serializer", "LB9/A;", "Lcom/uxsense/base/metadata/CommentChunk;", AppAgent.CONSTRUCT, "()V", "LA9/f;", "encoder", "value", "LC7/r;", "serialize", "(LA9/f;Lcom/uxsense/base/metadata/CommentChunk;)V", "LA9/e;", "decoder", "deserialize", "(LA9/e;)Lcom/uxsense/base/metadata/CommentChunk;", "", "Lx9/b;", "childSerializers", "()[Lx9/b;", "Lz9/g;", "descriptor", "Lz9/g;", "getDescriptor", "()Lz9/g;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@c
/* loaded from: classes3.dex */
public /* synthetic */ class CommentChunk$$serializer implements A {
    public static final CommentChunk$$serializer INSTANCE;
    private static final g descriptor;

    static {
        CommentChunk$$serializer commentChunk$$serializer = new CommentChunk$$serializer();
        INSTANCE = commentChunk$$serializer;
        V v10 = new V("com.uxsense.base.metadata.CommentChunk", commentChunk$$serializer, 6);
        v10.j("chunkId", false);
        v10.j("creationId", false);
        v10.j("rootCommentId", true);
        v10.j("comments", false);
        v10.j("hasMore", true);
        v10.j("fetchedAt", false);
        descriptor = v10;
    }

    private CommentChunk$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // B9.A
    public final b[] childSerializers() {
        f[] fVarArr = CommentChunk.$childSerializers;
        L l = L.f223a;
        return new b[]{l, l, l, fVarArr[3].getF4884a(), C0180g.f239a, l};
    }

    @Override // x9.InterfaceC2123a
    public final CommentChunk deserialize(e decoder) {
        boolean zDecodeBooleanElement;
        int i;
        long jDecodeLongElement;
        long j5;
        List list;
        long j6;
        long j10;
        k.f(decoder, "decoder");
        g gVar = descriptor;
        A9.c cVarBeginStructure = decoder.beginStructure(gVar);
        f[] fVarArr = CommentChunk.$childSerializers;
        if (cVarBeginStructure.decodeSequentially()) {
            long jDecodeLongElement2 = cVarBeginStructure.decodeLongElement(gVar, 0);
            long jDecodeLongElement3 = cVarBeginStructure.decodeLongElement(gVar, 1);
            long jDecodeLongElement4 = cVarBeginStructure.decodeLongElement(gVar, 2);
            List list2 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 3, (InterfaceC2123a) fVarArr[3].getF4884a(), null);
            zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(gVar, 4);
            list = list2;
            jDecodeLongElement = cVarBeginStructure.decodeLongElement(gVar, 5);
            i = 63;
            j5 = jDecodeLongElement3;
            j6 = jDecodeLongElement2;
            j10 = jDecodeLongElement4;
        } else {
            long jDecodeLongElement5 = 0;
            boolean z10 = true;
            zDecodeBooleanElement = false;
            List list3 = null;
            long jDecodeLongElement6 = 0;
            long jDecodeLongElement7 = 0;
            long jDecodeLongElement8 = 0;
            int i6 = 0;
            while (z10) {
                int iDecodeElementIndex = cVarBeginStructure.decodeElementIndex(gVar);
                switch (iDecodeElementIndex) {
                    case -1:
                        z10 = false;
                        continue;
                    case 0:
                        jDecodeLongElement7 = cVarBeginStructure.decodeLongElement(gVar, 0);
                        i6 |= 1;
                        continue;
                    case 1:
                        jDecodeLongElement6 = cVarBeginStructure.decodeLongElement(gVar, 1);
                        i6 |= 2;
                        break;
                    case 2:
                        jDecodeLongElement8 = cVarBeginStructure.decodeLongElement(gVar, 2);
                        i6 |= 4;
                        break;
                    case 3:
                        list3 = (List) cVarBeginStructure.decodeSerializableElement(gVar, 3, (InterfaceC2123a) fVarArr[3].getF4884a(), list3);
                        i6 |= 8;
                        break;
                    case 4:
                        zDecodeBooleanElement = cVarBeginStructure.decodeBooleanElement(gVar, 4);
                        i6 |= 16;
                        break;
                    case 5:
                        jDecodeLongElement5 = cVarBeginStructure.decodeLongElement(gVar, 5);
                        i6 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i6;
            jDecodeLongElement = jDecodeLongElement5;
            j5 = jDecodeLongElement6;
            list = list3;
            j6 = jDecodeLongElement7;
            j10 = jDecodeLongElement8;
        }
        boolean z11 = zDecodeBooleanElement;
        cVarBeginStructure.endStructure(gVar);
        return new CommentChunk(i, j6, j5, j10, list, z11, jDecodeLongElement, (d0) null);
    }

    @Override // x9.f, x9.InterfaceC2123a
    public final g getDescriptor() {
        return descriptor;
    }

    @Override // x9.f
    public final void serialize(A9.f encoder, CommentChunk value) {
        k.f(encoder, "encoder");
        k.f(value, "value");
        g gVar = descriptor;
        d dVarBeginStructure = encoder.beginStructure(gVar);
        CommentChunk.write$Self$uxsense_release(value, dVarBeginStructure, gVar);
        dVarBeginStructure.endStructure(gVar);
    }

    @Override // B9.A
    public /* bridge */ /* synthetic */ b[] typeParametersSerializers() {
        return T.b;
    }
}
