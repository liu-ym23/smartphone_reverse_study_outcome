package d8;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.CompletableFuture;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h2 {

    /* renamed from: a, reason: collision with root package name */
    public final j1 f2009a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2010b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2011c;
    public final SocketChannel d;

    /* renamed from: e, reason: collision with root package name */
    public final CompletableFuture f2012e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBuffer f2013f;

    /* renamed from: g, reason: collision with root package name */
    public long f2014g = 0;

    public h2(j1 j1Var, byte[] bArr, long j4, SocketChannel socketChannel, CompletableFuture completableFuture) {
        this.f2009a = j1Var;
        this.f2010b = bArr;
        this.f2011c = j4;
        this.d = socketChannel;
        this.f2012e = completableFuture;
    }

    public final boolean a() {
        long j4 = this.f2014g;
        byte[] bArr = this.f2010b;
        if (j4 == bArr.length + 2) {
            return true;
        }
        if (this.f2013f == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 2);
            this.f2013f = byteBufferAllocate;
            byteBufferAllocate.put((byte) (bArr.length >>> 8));
            this.f2013f.put((byte) (bArr.length & 255));
            this.f2013f.put(bArr);
            this.f2013f.flip();
        }
        StringBuilder sb = new StringBuilder("TCP write: transaction id=");
        j1 j1Var = this.f2009a;
        sb.append(j1Var.f2031a.f2175a);
        String string = sb.toString();
        SocketChannel socketChannel = this.d;
        socketChannel.socket().getLocalSocketAddress();
        socketChannel.socket().getRemoteSocketAddress();
        ByteBuffer byteBuffer = this.f2013f;
        if (b2.f1952a.p()) {
            byte[] bArr2 = new byte[byteBuffer.remaining()];
            int iPosition = byteBuffer.position();
            byteBuffer.get(bArr2, 0, byteBuffer.remaining());
            byteBuffer.position(iPosition);
            b2.c(string, bArr2);
        }
        while (this.f2013f.hasRemaining()) {
            long jWrite = socketChannel.write(this.f2013f);
            long j8 = this.f2014g + jWrite;
            this.f2014g = j8;
            if (jWrite == 0) {
                i2.f2022n.l(Integer.valueOf(j1Var.f2031a.f2175a), "Insufficient room for the data in the underlying output buffer for transaction {}, retrying");
                return false;
            }
            if (j8 < bArr.length) {
                i2.f2022n.a("Wrote {} of {} bytes data for transaction {}", Long.valueOf(j8), Integer.valueOf(bArr.length), Integer.valueOf(j1Var.f2031a.f2175a));
            }
        }
        i2.f2022n.c("Send for transaction {} is complete, wrote {} bytes", Integer.valueOf(j1Var.f2031a.f2175a), Long.valueOf(this.f2014g));
        return true;
    }
}
