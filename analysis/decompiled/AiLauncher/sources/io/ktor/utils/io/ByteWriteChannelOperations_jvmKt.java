package io.ktor.utils.io;

import Y8.t;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import fb.C4074a;
import fb.o;
import fb.q;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import java.nio.ByteBuffer;
import kb.C4845d;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0006\u0010\u0005\u001a2\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\tH\u0086@¢\u0006\u0004\b\u000b\u0010\f\u001a/\u0010\r\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "Ljava/nio/ByteBuffer;", UxipConstants.f30680s, "LY8/t;", "writeByteBuffer", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/ByteBuffer;Le9/c;)Ljava/lang/Object;", "writeFully", "", "min", "Lkotlin/Function1;", "block", "write", "(Lio/ktor/utils/io/ByteWriteChannel;ILp9/l;Le9/c;)Ljava/lang/Object;", "writeAvailable", "(Lio/ktor/utils/io/ByteWriteChannel;ILp9/l;)I", "buffer", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/ByteBuffer;)V", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteWriteChannelOperations_jvmKt {
    public static final Object write(ByteWriteChannel byteWriteChannel, int i10, InterfaceC5074l<? super ByteBuffer, t> interfaceC5074l, InterfaceC4014c<? super t> interfaceC4014c) {
        C4845d c4845d = C4845d.f34666a;
        C4074a bufferField = byteWriteChannel.getWriteBuffer().getBufferField();
        o oVarK0 = bufferField.k0(i10);
        byte[] bArrB = oVarK0.b(false);
        int limit = oVarK0.getLimit();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArrB, limit, bArrB.length - limit);
        p.f(byteBufferWrap);
        interfaceC5074l.invoke(byteBufferWrap);
        int iPosition = byteBufferWrap.position() - limit;
        if (iPosition == i10) {
            oVarK0.D(bArrB, iPosition);
            oVarK0.s(oVarK0.getLimit() + iPosition);
            bufferField.Y(bufferField.getSizeMut() + iPosition);
        } else {
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
        Object objFlush = byteWriteChannel.flush(interfaceC4014c);
        return objFlush == C4063a.g() ? objFlush : t.f7040a;
    }

    public static /* synthetic */ Object write$default(ByteWriteChannel byteWriteChannel, int i10, InterfaceC5074l interfaceC5074l, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return write(byteWriteChannel, i10, interfaceC5074l, interfaceC4014c);
    }

    public static final int writeAvailable(ByteWriteChannel byteWriteChannel, int i10, InterfaceC5074l<? super ByteBuffer, t> block) {
        p.i(byteWriteChannel, "<this>");
        p.i(block, "block");
        if (i10 <= 0) {
            throw new IllegalArgumentException("min should be positive");
        }
        if (i10 > 1048576) {
            throw new IllegalArgumentException(("Min(" + i10 + ") shouldn't be greater than 1048576").toString());
        }
        if (byteWriteChannel.isClosedForWrite()) {
            return -1;
        }
        C4845d c4845d = C4845d.f34666a;
        C4074a bufferField = byteWriteChannel.getWriteBuffer().getBufferField();
        o oVarK0 = bufferField.k0(i10);
        byte[] bArrB = oVarK0.b(false);
        int limit = oVarK0.getLimit();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArrB, limit, bArrB.length - limit);
        p.f(byteBufferWrap);
        block.invoke(byteBufferWrap);
        int iPosition = byteBufferWrap.position() - limit;
        int iPosition2 = byteBufferWrap.position() - limit;
        if (iPosition2 == i10) {
            oVarK0.D(bArrB, iPosition2);
            oVarK0.s(oVarK0.getLimit() + iPosition2);
            bufferField.Y(bufferField.getSizeMut() + iPosition2);
            return iPosition;
        }
        if (iPosition2 < 0 || iPosition2 > oVarK0.h()) {
            throw new IllegalStateException(("Invalid number of bytes written: " + iPosition2 + ". Should be in 0.." + oVarK0.h()).toString());
        }
        if (iPosition2 == 0) {
            if (q.b(oVarK0)) {
                bufferField.U();
            }
            return iPosition;
        }
        oVarK0.D(bArrB, iPosition2);
        oVarK0.s(oVarK0.getLimit() + iPosition2);
        bufferField.Y(bufferField.getSizeMut() + iPosition2);
        return iPosition;
    }

    public static /* synthetic */ int writeAvailable$default(ByteWriteChannel byteWriteChannel, int i10, InterfaceC5074l interfaceC5074l, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        return writeAvailable(byteWriteChannel, i10, interfaceC5074l);
    }

    public static final Object writeByteBuffer(ByteWriteChannel byteWriteChannel, ByteBuffer byteBuffer, InterfaceC4014c<? super t> interfaceC4014c) {
        OutputArraysJVMKt.writeByteBuffer(byteWriteChannel.getWriteBuffer(), byteBuffer);
        Object objFlush = byteWriteChannel.flush(interfaceC4014c);
        return objFlush == C4063a.g() ? objFlush : t.f7040a;
    }

    public static final Object writeFully(ByteWriteChannel byteWriteChannel, ByteBuffer byteBuffer, InterfaceC4014c<? super t> interfaceC4014c) {
        OutputArraysJVMKt.writeByteBuffer(byteWriteChannel.getWriteBuffer(), byteBuffer);
        Object objFlush = byteWriteChannel.flush(interfaceC4014c);
        return objFlush == C4063a.g() ? objFlush : t.f7040a;
    }

    public static final void writeAvailable(ByteWriteChannel byteWriteChannel, ByteBuffer buffer) {
        p.i(byteWriteChannel, "<this>");
        p.i(buffer, "buffer");
        fb.t.a(byteWriteChannel.getWriteBuffer(), buffer);
    }
}
