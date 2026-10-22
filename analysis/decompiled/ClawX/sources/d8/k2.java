package d8;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k2 implements a2 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2047a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2048b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2049c;
    public final long d;

    /* renamed from: e, reason: collision with root package name */
    public final DatagramChannel f2050e;

    /* renamed from: f, reason: collision with root package name */
    public final CompletableFuture f2051f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ l2 f2052g;

    public k2(l2 l2Var, int i8, byte[] bArr, int i9, long j4, DatagramChannel datagramChannel, CompletableFuture completableFuture) {
        this.f2052g = l2Var;
        this.f2047a = i8;
        this.f2048b = bArr;
        this.f2049c = i9;
        this.d = j4;
        this.f2050e = datagramChannel;
        this.f2051f = completableFuture;
    }

    @Override // d8.a2
    public final void a(SelectionKey selectionKey) throws IOException {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.f2052g.f2072p;
        boolean zIsReadable = selectionKey.isReadable();
        int i8 = this.f2047a;
        if (!zIsReadable) {
            b(new EOFException(a8.b.k(i8, "Key for transaction ", " is not readable")));
            concurrentLinkedQueue.remove(this);
            return;
        }
        DatagramChannel datagramChannel = (DatagramChannel) selectionKey.channel();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.f2049c);
        try {
            int i9 = datagramChannel.read(byteBufferAllocate);
            if (i9 <= 0) {
                throw new EOFException();
            }
            byteBufferAllocate.flip();
            byte[] bArr = new byte[i9];
            System.arraycopy(byteBufferAllocate.array(), 0, bArr, 0, i9);
            String strJ = a8.b.j(i8, "UDP read: transaction id=");
            datagramChannel.socket().getLocalSocketAddress();
            datagramChannel.socket().getRemoteSocketAddress();
            b2.c(strJ, bArr);
            DatagramChannel datagramChannel2 = this.f2050e;
            try {
                datagramChannel2.disconnect();
            } catch (IOException unused) {
            } catch (Throwable th) {
                l2.d(datagramChannel2);
                throw th;
            }
            l2.d(datagramChannel2);
            this.f2051f.complete(bArr);
            concurrentLinkedQueue.remove(this);
        } catch (IOException e9) {
            b(e9);
            concurrentLinkedQueue.remove(this);
        }
    }

    public final void b(IOException iOException) {
        DatagramChannel datagramChannel = this.f2050e;
        try {
            datagramChannel.disconnect();
        } catch (IOException unused) {
        } catch (Throwable th) {
            l2.d(datagramChannel);
            throw th;
        }
        l2.d(datagramChannel);
        this.f2051f.completeExceptionally(iOException);
    }

    public final void c() {
        byte[] bArr = this.f2048b;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        StringBuilder sb = new StringBuilder("UDP write: transaction id=");
        int i8 = this.f2047a;
        sb.append(i8);
        String string = sb.toString();
        DatagramChannel datagramChannel = this.f2050e;
        datagramChannel.socket().getLocalSocketAddress();
        datagramChannel.socket().getRemoteSocketAddress();
        b2.c(string, bArr);
        int iSend = datagramChannel.send(byteBufferWrap, datagramChannel.socket().getRemoteSocketAddress());
        if (iSend == 0) {
            throw new EOFException(a8.b.j(i8, "Insufficient room for the datagram in the underlying output buffer for transaction "));
        }
        if (iSend < bArr.length) {
            throw new EOFException(a8.b.j(i8, "Could not send all data for transaction "));
        }
    }
}
