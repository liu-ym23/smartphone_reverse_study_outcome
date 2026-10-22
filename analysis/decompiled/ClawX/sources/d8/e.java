package d8;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f1979f;

    /* JADX WARN: Type inference failed for: r3v2, types: [byte[], java.io.Serializable, java.lang.Object] */
    @Override // d8.w2
    public final void j(u uVar) throws l4, UnknownHostException {
        d dVar;
        this.f1979f = new ArrayList(1);
        while (uVar.f2171a.remaining() != 0) {
            int iD = uVar.d();
            int iF = uVar.f();
            int iF2 = uVar.f();
            boolean z = (iF2 & 128) != 0;
            ?? B = uVar.b(iF2 & (-129));
            if (iF >= 0 && iF < 256 && (iD != 1 || iF <= 32)) {
                int i8 = 2;
                if (iD != 2 || iF <= 128) {
                    if (iD == 1 || iD == 2) {
                        int iB = a.a.b(iD);
                        if (B.length > iB) {
                            throw new l4("invalid address length");
                        }
                        int length = B.length;
                        byte[] bArr = B;
                        if (length != iB) {
                            byte[] bArr2 = new byte[iB];
                            System.arraycopy(B, 0, bArr2, 0, B.length);
                            bArr = bArr2;
                        }
                        InetAddress byAddress = InetAddress.getByAddress(bArr);
                        if (byAddress instanceof Inet4Address) {
                            i8 = 1;
                        } else if (!(byAddress instanceof Inet6Address)) {
                            throw new IllegalArgumentException("unknown address family");
                        }
                        dVar = new d(i8, z, byAddress, iF);
                    } else {
                        dVar = new d(iD, z, B, iF);
                    }
                    this.f1979f.add(dVar);
                }
            }
            throw new l4("invalid prefix length");
        }
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.f1979f.iterator();
        while (it.hasNext()) {
            sb.append((d) it.next());
            if (it.hasNext()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        byte[] address;
        int length;
        ArrayList arrayList = this.f1979f;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            d dVar = (d) obj;
            int i9 = dVar.f1973a;
            Object obj2 = dVar.d;
            if (i9 == 1 || i9 == 2) {
                address = ((InetAddress) obj2).getAddress();
                int length2 = address.length - 1;
                while (true) {
                    if (length2 < 0) {
                        length = 0;
                        break;
                    } else {
                        if (address[length2] != 0) {
                            length = length2 + 1;
                            break;
                        }
                        length2--;
                    }
                }
            } else {
                address = (byte[]) obj2;
                length = address.length;
            }
            int i10 = dVar.f1974b ? length | 128 : length;
            jVar.j(dVar.f1973a);
            jVar.m(dVar.f1975c);
            jVar.m(i10);
            jVar.g(0, length, address);
        }
    }
}
