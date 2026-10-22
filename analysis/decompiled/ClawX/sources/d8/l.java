package d8;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l extends d0 {

    /* renamed from: b, reason: collision with root package name */
    public int f2057b;

    /* renamed from: c, reason: collision with root package name */
    public int f2058c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public InetAddress f2059e;

    @Override // d8.d0
    public final void a(u uVar) throws l4, UnknownHostException {
        int iD = uVar.d();
        this.f2057b = iD;
        int i8 = 2;
        if (iD != 1 && iD != 2) {
            throw new l4("unknown address family");
        }
        int iF = uVar.f();
        this.f2058c = iF;
        if (iF > a.a.b(this.f2057b) * 8) {
            throw new l4("invalid source netmask");
        }
        int iF2 = uVar.f();
        this.d = iF2;
        if (iF2 > a.a.b(this.f2057b) * 8) {
            throw new l4("invalid scope netmask");
        }
        byte[] bArrA = uVar.a();
        if (bArrA.length != (this.f2058c + 7) / 8) {
            throw new l4("invalid address");
        }
        byte[] bArr = new byte[a.a.b(this.f2057b)];
        System.arraycopy(bArrA, 0, bArr, 0, bArrA.length);
        try {
            InetAddress byAddress = InetAddress.getByAddress(bArr);
            this.f2059e = byAddress;
            int i9 = this.f2058c;
            if (byAddress instanceof Inet4Address) {
                i8 = 1;
            } else if (!(byAddress instanceof Inet6Address)) {
                throw new IllegalArgumentException("unknown address family");
            }
            int iB = a.a.b(i8) * 8;
            if (i9 < 0 || i9 > iB) {
                throw new IllegalArgumentException("invalid mask length");
            }
            if (i9 != iB) {
                byte[] address = byAddress.getAddress();
                int i10 = i9 / 8;
                for (int i11 = i10 + 1; i11 < address.length; i11++) {
                    address[i11] = 0;
                }
                int i12 = 0;
                for (int i13 = 0; i13 < i9 % 8; i13++) {
                    i12 |= 1 << (7 - i13);
                }
                address[i10] = (byte) (address[i10] & ((byte) i12));
                try {
                    byAddress = InetAddress.getByAddress(address);
                } catch (UnknownHostException unused) {
                    throw new IllegalArgumentException("invalid address");
                }
            }
            if (!byAddress.equals(this.f2059e)) {
                throw new l4("invalid padding");
            }
        } catch (UnknownHostException e9) {
            throw new l4("invalid address", e9);
        }
    }

    @Override // d8.d0
    public final String b() {
        return this.f2059e.getHostAddress() + "/" + this.f2058c + ", scope netmask " + this.d;
    }

    @Override // d8.d0
    public final void c(b0.j jVar) {
        jVar.j(this.f2057b);
        jVar.m(this.f2058c);
        jVar.m(this.d);
        jVar.g(0, (this.f2058c + 7) / 8, this.f2059e.getAddress());
    }
}
