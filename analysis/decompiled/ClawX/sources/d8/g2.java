package d8;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.bouncycastle.crypto.digests.Blake2xsDigest;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g2 implements a2 {

    /* renamed from: a, reason: collision with root package name */
    public final SocketChannel f2002a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue f2003b = new ConcurrentLinkedQueue();

    /* renamed from: c, reason: collision with root package name */
    public final ByteBuffer f2004c = ByteBuffer.allocate(2);
    public final ByteBuffer d = ByteBuffer.allocate(Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);

    /* renamed from: e, reason: collision with root package name */
    public int f2005e = 0;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ i2 f2006f;

    public g2(i2 i2Var, SocketChannel socketChannel) {
        this.f2006f = i2Var;
        this.f2002a = socketChannel;
    }

    @Override // d8.a2
    public final void a(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isValid()) {
            boolean zIsConnectable = selectionKey.isConnectable();
            SocketChannel socketChannel = this.f2002a;
            if (zIsConnectable) {
                try {
                    socketChannel.finishConnect();
                    selectionKey.interestOps(4);
                    return;
                } catch (IOException e9) {
                    b(e9);
                    return;
                }
            }
            boolean zIsWritable = selectionKey.isWritable();
            ConcurrentLinkedQueue concurrentLinkedQueue = this.f2003b;
            if (zIsWritable) {
                Iterator it = concurrentLinkedQueue.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        selectionKey.interestOps(1);
                        break;
                    }
                    h2 h2Var = (h2) it.next();
                    try {
                    } catch (IOException e10) {
                        h2Var.f2012e.completeExceptionally(e10);
                        it.remove();
                    }
                    if (!h2Var.a()) {
                        selectionKey.interestOps(4);
                        break;
                    }
                    continue;
                }
            }
            if (selectionKey.isReadable()) {
                ByteBuffer byteBuffer = this.f2004c;
                try {
                    int i8 = this.f2005e;
                    ByteBuffer byteBuffer2 = this.d;
                    if (i8 == 0) {
                        if (socketChannel.read(byteBuffer) < 0) {
                            b(new EOFException());
                            return;
                        } else if (byteBuffer.position() == 2) {
                            int i9 = ((byteBuffer.get(0) & 255) << 8) + (byteBuffer.get(1) & 255);
                            byteBuffer.flip();
                            byteBuffer2.limit(i9);
                            this.f2005e = 1;
                        }
                    }
                    if (socketChannel.read(byteBuffer2) < 0) {
                        b(new EOFException());
                        return;
                    }
                    if (byteBuffer2.hasRemaining()) {
                        return;
                    }
                    this.f2005e = 0;
                    byteBuffer2.flip();
                    int iLimit = byteBuffer2.limit();
                    byte[] bArr = new byte[iLimit];
                    System.arraycopy(byteBuffer2.array(), byteBuffer2.arrayOffset(), bArr, 0, byteBuffer2.limit());
                    if (iLimit < 2) {
                        socketChannel.socket().getLocalSocketAddress();
                        socketChannel.socket().getRemoteSocketAddress();
                        b2.c("TCP read: response too short for a valid reply, discarding", bArr);
                        return;
                    }
                    int i10 = ((bArr[0] & 255) << 8) + (bArr[1] & 255);
                    String strJ = a8.b.j(i10, "TCP read: transaction id=");
                    socketChannel.socket().getLocalSocketAddress();
                    socketChannel.socket().getRemoteSocketAddress();
                    b2.c(strJ, bArr);
                    Iterator it2 = concurrentLinkedQueue.iterator();
                    while (it2.hasNext()) {
                        h2 h2Var2 = (h2) it2.next();
                        if (i10 == h2Var2.f2009a.f2031a.f2175a) {
                            h2Var2.f2012e.complete(bArr);
                            it2.remove();
                            return;
                        }
                    }
                    i2.f2022n.k(Integer.valueOf(i10), "Transaction for answer to id {} not found");
                } catch (IOException e11) {
                    b(e11);
                }
            }
        }
    }

    public final void b(IOException iOException) {
        Iterator it = this.f2003b.iterator();
        while (it.hasNext()) {
            ((h2) it.next()).f2012e.completeExceptionally(iOException);
            it.remove();
        }
        ConcurrentHashMap concurrentHashMap = this.f2006f.f2024m;
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            if (entry.getValue() == this) {
                concurrentHashMap.remove(entry.getKey());
                try {
                    this.f2002a.close();
                    return;
                } catch (IOException e9) {
                    z7.b bVar = i2.f2022n;
                    ((f2) entry.getKey()).getClass();
                    bVar.r(null, ((f2) entry.getKey()).f1991a, e9);
                    return;
                }
            }
        }
    }
}
