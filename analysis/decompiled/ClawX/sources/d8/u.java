package d8;

import java.nio.ByteBuffer;
import org.bouncycastle.crypto.hpke.HPKE;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f2171a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2172b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2173c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f2174e;

    public u(byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.f2171a = byteBufferWrap;
        this.f2172b = byteBufferWrap.position();
        this.f2173c = byteBufferWrap.limit();
        this.d = -1;
        this.f2174e = -1;
    }

    public final byte[] a() {
        ByteBuffer byteBuffer = this.f2171a;
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.get(bArr, 0, iRemaining);
        return bArr;
    }

    public final byte[] b(int i8) throws l4 {
        g(i8);
        byte[] bArr = new byte[i8];
        this.f2171a.get(bArr, 0, i8);
        return bArr;
    }

    public final byte[] c() {
        return b(f());
    }

    public final int d() throws l4 {
        g(2);
        return this.f2171a.getShort() & HPKE.aead_EXPORT_ONLY;
    }

    public final long e() throws l4 {
        g(4);
        return this.f2171a.getInt() & 4294967295L;
    }

    public final int f() throws l4 {
        g(1);
        return this.f2171a.get() & 255;
    }

    public final void g(int i8) throws l4 {
        if (i8 > this.f2171a.remaining()) {
            throw new l4("end of input");
        }
    }
}
