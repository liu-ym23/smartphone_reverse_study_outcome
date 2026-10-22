package io.ktor.utils.io.jvm.javaio;

import Ua.C1058h;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.g;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/coroutines/g;", "parent", "Ljava/io/InputStream;", "toInputStream", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/coroutines/g;)Ljava/io/InputStream;", "Lio/ktor/utils/io/ByteWriteChannel;", "Ljava/io/OutputStream;", "toOutputStream", "(Lio/ktor/utils/io/ByteWriteChannel;)Ljava/io/OutputStream;", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BlockingKt {
    public static final InputStream toInputStream(final ByteReadChannel byteReadChannel, g gVar) {
        p.i(byteReadChannel, "<this>");
        return new InputStream() { // from class: io.ktor.utils.io.jvm.javaio.BlockingKt.toInputStream.1
            private final void blockingWait() throws InterruptedException {
                C1058h.b(null, new BlockingKt$toInputStream$1$blockingWait$1(byteReadChannel, null), 1, null);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                ByteReadChannelKt.cancel(byteReadChannel);
            }

            @Override // java.io.InputStream
            public int read() throws InterruptedException {
                if (byteReadChannel.isClosedForRead()) {
                    return -1;
                }
                if (byteReadChannel.getReadBuffer().k()) {
                    blockingWait();
                }
                if (byteReadChannel.isClosedForRead()) {
                    return -1;
                }
                return byteReadChannel.getReadBuffer().readByte() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] b10, int off, int len) throws InterruptedException {
                p.i(b10, "b");
                if (byteReadChannel.isClosedForRead()) {
                    return -1;
                }
                if (byteReadChannel.getReadBuffer().k()) {
                    blockingWait();
                }
                int iG0 = byteReadChannel.getReadBuffer().G0(b10, off, Math.min(ByteReadChannelOperationsKt.getAvailableForRead(byteReadChannel), len) + off);
                return iG0 >= 0 ? iG0 : byteReadChannel.isClosedForRead() ? -1 : 0;
            }
        };
    }

    public static /* synthetic */ InputStream toInputStream$default(ByteReadChannel byteReadChannel, g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = null;
        }
        return toInputStream(byteReadChannel, gVar);
    }

    public static final OutputStream toOutputStream(final ByteWriteChannel byteWriteChannel) {
        p.i(byteWriteChannel, "<this>");
        return new OutputStream() { // from class: io.ktor.utils.io.jvm.javaio.BlockingKt.toOutputStream.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws InterruptedException {
                C1058h.b(null, new BlockingKt$toOutputStream$1$close$1(byteWriteChannel, null), 1, null);
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() throws InterruptedException {
                C1058h.b(null, new BlockingKt$toOutputStream$1$flush$1(byteWriteChannel, null), 1, null);
            }

            @Override // java.io.OutputStream
            public void write(int b10) throws InterruptedException {
                C1058h.b(null, new BlockingKt$toOutputStream$1$write$1(byteWriteChannel, b10, null), 1, null);
            }

            @Override // java.io.OutputStream
            public void write(byte[] b10, int off, int len) throws InterruptedException {
                p.i(b10, "b");
                C1058h.b(null, new BlockingKt$toOutputStream$1$write$2(byteWriteChannel, b10, off, len, null), 1, null);
            }
        };
    }
}
