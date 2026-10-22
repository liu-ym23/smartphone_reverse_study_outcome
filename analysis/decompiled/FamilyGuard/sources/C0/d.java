package C0;

import java.security.MessageDigest;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
final class d implements InterfaceC1340f {

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC1340f f313b;

    /* renamed from: c, reason: collision with root package name */
    private final InterfaceC1340f f314c;

    d(InterfaceC1340f interfaceC1340f, InterfaceC1340f interfaceC1340f2) {
        this.f313b = interfaceC1340f;
        this.f314c = interfaceC1340f2;
    }

    @Override // z0.InterfaceC1340f
    public void b(MessageDigest messageDigest) {
        this.f313b.b(messageDigest);
        this.f314c.b(messageDigest);
    }

    @Override // z0.InterfaceC1340f
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f313b.equals(dVar.f313b) && this.f314c.equals(dVar.f314c)) {
                return true;
            }
        }
        return false;
    }

    @Override // z0.InterfaceC1340f
    public int hashCode() {
        return (this.f313b.hashCode() * 31) + this.f314c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f313b + ", signature=" + this.f314c + '}';
    }
}
