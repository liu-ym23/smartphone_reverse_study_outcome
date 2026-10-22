package d8;

import java.nio.ByteBuffer;
import org.bouncycastle.crypto.hpke.HPKE;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class n3 extends i3 {

    /* renamed from: a, reason: collision with root package name */
    public int f2095a;

    @Override // d8.i3
    public final void a(byte[] bArr) throws l4 {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.position();
        byteBufferWrap.limit();
        if (2 > byteBufferWrap.remaining()) {
            throw new l4("end of input");
        }
        this.f2095a = byteBufferWrap.getShort() & HPKE.aead_EXPORT_ONLY;
        if (byteBufferWrap.remaining() > 0) {
            throw new l4("Unexpected number of bytes in port parameter");
        }
    }

    @Override // d8.i3
    public final byte[] b() {
        b0.j jVar = new b0.j(2);
        jVar.j(this.f2095a);
        return jVar.f();
    }

    @Override // d8.i3
    public final String toString() {
        return Integer.toString(this.f2095a);
    }
}
