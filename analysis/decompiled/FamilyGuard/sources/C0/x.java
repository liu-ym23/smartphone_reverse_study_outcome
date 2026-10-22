package C0;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import z0.C1342h;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
final class x implements InterfaceC1340f {

    /* renamed from: j, reason: collision with root package name */
    private static final X0.g<Class<?>, byte[]> f501j = new X0.g<>(50);

    /* renamed from: b, reason: collision with root package name */
    private final D0.b f502b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC1340f f503c;

    /* renamed from: d, reason: collision with root package name */
    private final InterfaceC1340f f504d;

    /* renamed from: e, reason: collision with root package name */
    private final int f505e;

    /* renamed from: f, reason: collision with root package name */
    private final int f506f;

    /* renamed from: g, reason: collision with root package name */
    private final Class<?> f507g;

    /* renamed from: h, reason: collision with root package name */
    private final C1342h f508h;

    /* renamed from: i, reason: collision with root package name */
    private final z0.k<?> f509i;

    x(D0.b bVar, InterfaceC1340f interfaceC1340f, InterfaceC1340f interfaceC1340f2, int i5, int i6, z0.k<?> kVar, Class<?> cls, C1342h c1342h) {
        this.f502b = bVar;
        this.f503c = interfaceC1340f;
        this.f504d = interfaceC1340f2;
        this.f505e = i5;
        this.f506f = i6;
        this.f509i = kVar;
        this.f507g = cls;
        this.f508h = c1342h;
    }

    private byte[] c() {
        X0.g<Class<?>, byte[]> gVar = f501j;
        byte[] bArrG = gVar.g(this.f507g);
        if (bArrG != null) {
            return bArrG;
        }
        byte[] bytes = this.f507g.getName().getBytes(InterfaceC1340f.f24045a);
        gVar.k(this.f507g, bytes);
        return bytes;
    }

    @Override // z0.InterfaceC1340f
    public void b(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f502b.c(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f505e).putInt(this.f506f).array();
        this.f504d.b(messageDigest);
        this.f503c.b(messageDigest);
        messageDigest.update(bArr);
        z0.k<?> kVar = this.f509i;
        if (kVar != null) {
            kVar.b(messageDigest);
        }
        this.f508h.b(messageDigest);
        messageDigest.update(c());
        this.f502b.put(bArr);
    }

    @Override // z0.InterfaceC1340f
    public boolean equals(Object obj) {
        if (obj instanceof x) {
            x xVar = (x) obj;
            if (this.f506f == xVar.f506f && this.f505e == xVar.f505e && X0.k.d(this.f509i, xVar.f509i) && this.f507g.equals(xVar.f507g) && this.f503c.equals(xVar.f503c) && this.f504d.equals(xVar.f504d) && this.f508h.equals(xVar.f508h)) {
                return true;
            }
        }
        return false;
    }

    @Override // z0.InterfaceC1340f
    public int hashCode() {
        int iHashCode = (((((this.f503c.hashCode() * 31) + this.f504d.hashCode()) * 31) + this.f505e) * 31) + this.f506f;
        z0.k<?> kVar = this.f509i;
        if (kVar != null) {
            iHashCode = (iHashCode * 31) + kVar.hashCode();
        }
        return (((iHashCode * 31) + this.f507g.hashCode()) * 31) + this.f508h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f503c + ", signature=" + this.f504d + ", width=" + this.f505e + ", height=" + this.f506f + ", decodedResourceClass=" + this.f507g + ", transformation='" + this.f509i + "', options=" + this.f508h + '}';
    }
}
