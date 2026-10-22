package io.ktor.websocket.internals;

import Y8.t;
import Z8.C1168p;
import fb.C4074a;
import fb.s;
import fb.x;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a+\u0010\u000f\u001a\u00020\u000e*\u00020\b2\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\"\u0014\u0010\u0011\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0013\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Ljava/util/zip/Deflater;", "", "data", "deflateFully", "(Ljava/util/zip/Deflater;[B)[B", "Ljava/util/zip/Inflater;", "inflateFully", "(Ljava/util/zip/Inflater;[B)[B", "Lfb/s;", "deflater", "Ljava/nio/ByteBuffer;", "buffer", "", "flush", "", "deflateTo", "(Lfb/s;Ljava/util/zip/Deflater;Ljava/nio/ByteBuffer;Z)I", "PADDED_EMPTY_CHUNK", "[B", "EMPTY_CHUNK", "ktor-websockets"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DeflaterUtilsKt {
    private static final byte[] PADDED_EMPTY_CHUNK = {0, 0, 0, -1, -1};
    private static final byte[] EMPTY_CHUNK = {0, 0, -1, -1};

    public static final byte[] deflateFully(Deflater deflater, byte[] data) {
        p.i(deflater, "<this>");
        p.i(data, "data");
        deflater.setInput(data);
        C4074a c4074a = new C4074a();
        ObjectPool<ByteBuffer> ktorDefaultPool = ByteBufferPoolKt.getKtorDefaultPool();
        ByteBuffer byteBufferBorrow = ktorDefaultPool.borrow();
        try {
            ByteBuffer byteBuffer = byteBufferBorrow;
            while (!deflater.needsInput()) {
                deflateTo(c4074a, deflater, byteBuffer, false);
            }
            while (deflateTo(c4074a, deflater, byteBuffer, true) != 0) {
            }
            t tVar = t.f7040a;
            ktorDefaultPool.recycle(byteBufferBorrow);
            if (BytePacketUtilsKt.endsWith(c4074a, PADDED_EMPTY_CHUNK)) {
                byte[] bArrD = x.d(c4074a, ((int) ByteReadPacketKt.getRemaining(c4074a)) - EMPTY_CHUNK.length);
                c4074a.close();
                return bArrD;
            }
            C4074a c4074a2 = new C4074a();
            BytePacketBuilderKt.writePacket(c4074a2, c4074a);
            c4074a2.H0((byte) 0);
            return x.c(c4074a2);
        } catch (Throwable th) {
            ktorDefaultPool.recycle(byteBufferBorrow);
            throw th;
        }
    }

    private static final int deflateTo(s sVar, Deflater deflater, ByteBuffer byteBuffer, boolean z10) {
        byteBuffer.clear();
        int iDeflate = z10 ? deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit(), 2) : deflater.deflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
        if (iDeflate == 0) {
            return 0;
        }
        byteBuffer.position(byteBuffer.position() + iDeflate);
        byteBuffer.flip();
        BytePacketBuilderExtensions_jvmKt.writeFully(sVar, byteBuffer);
        return iDeflate;
    }

    public static final byte[] inflateFully(Inflater inflater, byte[] data) {
        p.i(inflater, "<this>");
        p.i(data, "data");
        inflater.setInput(C1168p.E(data, EMPTY_CHUNK));
        C4074a c4074a = new C4074a();
        ObjectPool<ByteBuffer> ktorDefaultPool = ByteBufferPoolKt.getKtorDefaultPool();
        ByteBuffer byteBufferBorrow = ktorDefaultPool.borrow();
        try {
            ByteBuffer byteBuffer = byteBufferBorrow;
            long length = r9.length + inflater.getBytesRead();
            while (inflater.getBytesRead() < length) {
                byteBuffer.clear();
                byteBuffer.position(byteBuffer.position() + inflater.inflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit()));
                byteBuffer.flip();
                BytePacketBuilderExtensions_jvmKt.writeFully(c4074a, byteBuffer);
            }
            t tVar = t.f7040a;
            ktorDefaultPool.recycle(byteBufferBorrow);
            return x.c(c4074a);
        } catch (Throwable th) {
            ktorDefaultPool.recycle(byteBufferBorrow);
            throw th;
        }
    }
}
