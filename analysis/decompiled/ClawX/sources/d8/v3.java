package d8;

import java.io.EOFException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class v3 implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final long f2186a = System.nanoTime();

    /* renamed from: b, reason: collision with root package name */
    public final Duration f2187b;

    /* renamed from: c, reason: collision with root package name */
    public final SelectionKey f2188c;

    public v3(Duration duration) throws Throwable {
        Selector selectorOpen;
        this.f2187b = duration;
        SocketChannel socketChannelOpen = SocketChannel.open();
        try {
            selectorOpen = Selector.open();
        } catch (Throwable th) {
            th = th;
            selectorOpen = null;
        }
        try {
            socketChannelOpen.configureBlocking(false);
            this.f2188c = socketChannelOpen.register(selectorOpen, 1);
        } catch (Throwable th2) {
            th = th2;
            if (selectorOpen != null) {
                selectorOpen.close();
            }
            socketChannelOpen.close();
            throw th;
        }
    }

    public final void a(SelectionKey selectionKey) throws SocketTimeoutException {
        long millis = this.f2187b.minus(System.nanoTime() - this.f2186a, ChronoUnit.NANOS).toMillis();
        if ((millis > 0 ? selectionKey.selector().select(millis) : millis == 0 ? selectionKey.selector().selectNow() : 0) == 0) {
            throw new SocketTimeoutException();
        }
    }

    public final byte[] b(int i8) {
        SelectionKey selectionKey = this.f2188c;
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        byte[] bArr = new byte[i8];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        selectionKey.interestOps(1);
        int i9 = 0;
        while (i9 < i8) {
            try {
                if (selectionKey.isReadable()) {
                    long j4 = socketChannel.read(byteBufferWrap);
                    if (j4 < 0) {
                        throw new EOFException();
                    }
                    i9 += (int) j4;
                    if (i9 < i8 && System.nanoTime() - this.f2186a >= this.f2187b.toNanos()) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(selectionKey);
                }
            } catch (Throwable th) {
                if (selectionKey.isValid()) {
                    selectionKey.interestOps(0);
                }
                throw th;
            }
        }
        if (selectionKey.isValid()) {
            selectionKey.interestOps(0);
        }
        return bArr;
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        SelectionKey selectionKey = this.f2188c;
        selectionKey.selector().close();
        selectionKey.channel().close();
    }
}
