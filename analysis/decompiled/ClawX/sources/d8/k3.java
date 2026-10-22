package d8;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.bouncycastle.crypto.hpke.HPKE;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k3 extends i3 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2053a = new ArrayList();

    @Override // d8.i3
    public final void a(byte[] bArr) throws l4 {
        ArrayList arrayList = this.f2053a;
        arrayList.clear();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.position();
        byteBufferWrap.limit();
        while (byteBufferWrap.remaining() >= 2) {
            if (2 > byteBufferWrap.remaining()) {
                throw new l4("end of input");
            }
            arrayList.add(Integer.valueOf(byteBufferWrap.getShort() & HPKE.aead_EXPORT_ONLY));
        }
        if (byteBufferWrap.remaining() > 0) {
            throw new l4("Unexpected number of bytes in mandatory parameter");
        }
    }

    @Override // d8.i3
    public final byte[] b() {
        b0.j jVar = new b0.j(2);
        ArrayList arrayList = this.f2053a;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            jVar.j(((Integer) obj).intValue());
        }
        return jVar.f();
    }

    @Override // d8.i3
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = this.f2053a;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            Integer num = (Integer) obj;
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(o3.f2102j.d(num.intValue()));
        }
        return sb.toString();
    }
}
