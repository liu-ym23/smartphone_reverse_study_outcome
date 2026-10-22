package io.ktor.utils.io.core.internal;

import Y8.t;
import fb.C4074a;
import fb.o;
import fb.q;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kb.C4845d;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a-\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\t\u001a\u00020\u0005*\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lfb/a;", "", "min", "Lkotlin/Function1;", "Ljava/nio/ByteBuffer;", "LY8/t;", "block", "writeDirect", "(Lfb/a;ILp9/l;)V", "readDirect", "(Lfb/a;Lp9/l;)V", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChunkBufferJvmKt {
    public static final void readDirect(C4074a c4074a, InterfaceC5074l<? super ByteBuffer, t> block) throws EOFException {
        p.i(c4074a, "<this>");
        p.i(block, "block");
        C4845d c4845d = C4845d.f34666a;
        C4074a bufferField = c4074a.getBufferField();
        if (bufferField.k()) {
            throw new IllegalArgumentException("Buffer is empty");
        }
        o head = bufferField.getHead();
        p.f(head);
        byte[] bArrB = head.b(true);
        int pos = head.getPos();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArrB, pos, head.getLimit() - pos);
        p.f(byteBufferWrap);
        block.invoke(byteBufferWrap);
        int iPosition = byteBufferWrap.position() - pos;
        if (iPosition != 0) {
            if (iPosition < 0) {
                throw new IllegalStateException("Returned negative read bytes count");
            }
            if (iPosition > head.j()) {
                throw new IllegalStateException("Returned too many bytes");
            }
            bufferField.skip(iPosition);
        }
    }

    public static final void writeDirect(C4074a c4074a, int i10, InterfaceC5074l<? super ByteBuffer, t> block) {
        p.i(c4074a, "<this>");
        p.i(block, "block");
        C4845d c4845d = C4845d.f34666a;
        C4074a bufferField = c4074a.getBufferField();
        o oVarK0 = bufferField.k0(i10);
        byte[] bArrB = oVarK0.b(false);
        int limit = oVarK0.getLimit();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArrB, limit, bArrB.length - limit);
        p.f(byteBufferWrap);
        block.invoke(byteBufferWrap);
        int iPosition = byteBufferWrap.position() - limit;
        if (iPosition == i10) {
            oVarK0.D(bArrB, iPosition);
            oVarK0.s(oVarK0.getLimit() + iPosition);
            bufferField.Y(bufferField.getSizeMut() + iPosition);
            return;
        }
        if (iPosition < 0 || iPosition > oVarK0.h()) {
            throw new IllegalStateException(("Invalid number of bytes written: " + iPosition + ". Should be in 0.." + oVarK0.h()).toString());
        }
        if (iPosition != 0) {
            oVarK0.D(bArrB, iPosition);
            oVarK0.s(oVarK0.getLimit() + iPosition);
            bufferField.Y(bufferField.getSizeMut() + iPosition);
        } else if (q.b(oVarK0)) {
            bufferField.U();
        }
    }
}
