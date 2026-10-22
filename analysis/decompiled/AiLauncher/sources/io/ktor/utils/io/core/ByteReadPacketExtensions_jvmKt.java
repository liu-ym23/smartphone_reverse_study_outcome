package io.ktor.utils.io.core;

import fb.C4074a;
import fb.o;
import fb.t;
import fb.v;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kb.C4845d;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.io.SourcesJvmKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ljava/nio/ByteBuffer;", "byteBuffer", "Lfb/v;", "ByteReadPacket", "(Ljava/nio/ByteBuffer;)Lfb/v;", "buffer", "", "readAvailable", "(Lfb/v;Ljava/nio/ByteBuffer;)I", "LY8/t;", "readFully", "(Lfb/v;Ljava/nio/ByteBuffer;)V", "Lkotlin/Function1;", "block", "read", "(Lfb/v;Lp9/l;)V", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteReadPacketExtensions_jvmKt {
    public static final v ByteReadPacket(ByteBuffer byteBuffer) {
        p.i(byteBuffer, "byteBuffer");
        C4074a c4074a = new C4074a();
        t.a(c4074a, byteBuffer);
        return c4074a;
    }

    public static final void read(v vVar, InterfaceC5074l<? super ByteBuffer, Y8.t> block) throws EOFException {
        p.i(vVar, "<this>");
        p.i(block, "block");
        C4845d c4845d = C4845d.f34666a;
        C4074a c4074aA = vVar.a();
        if (c4074aA.k()) {
            throw new IllegalArgumentException("Buffer is empty");
        }
        o head = c4074aA.getHead();
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
            c4074aA.skip(iPosition);
        }
    }

    public static final int readAvailable(v vVar, ByteBuffer buffer) {
        p.i(vVar, "<this>");
        p.i(buffer, "buffer");
        int iRemaining = buffer.remaining();
        SourcesJvmKt.d(vVar, buffer);
        return iRemaining - buffer.remaining();
    }

    public static final void readFully(v vVar, ByteBuffer buffer) {
        p.i(vVar, "<this>");
        p.i(buffer, "buffer");
        while (!vVar.k() && buffer.hasRemaining()) {
            SourcesJvmKt.d(vVar, buffer);
        }
    }
}
