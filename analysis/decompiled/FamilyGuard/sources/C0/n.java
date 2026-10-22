package C0;

import java.security.MessageDigest;
import java.util.Map;
import z0.C1342h;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
class n implements InterfaceC1340f {

    /* renamed from: b, reason: collision with root package name */
    private final Object f455b;

    /* renamed from: c, reason: collision with root package name */
    private final int f456c;

    /* renamed from: d, reason: collision with root package name */
    private final int f457d;

    /* renamed from: e, reason: collision with root package name */
    private final Class<?> f458e;

    /* renamed from: f, reason: collision with root package name */
    private final Class<?> f459f;

    /* renamed from: g, reason: collision with root package name */
    private final InterfaceC1340f f460g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<Class<?>, z0.k<?>> f461h;

    /* renamed from: i, reason: collision with root package name */
    private final C1342h f462i;

    /* renamed from: j, reason: collision with root package name */
    private int f463j;

    n(Object obj, InterfaceC1340f interfaceC1340f, int i5, int i6, Map<Class<?>, z0.k<?>> map, Class<?> cls, Class<?> cls2, C1342h c1342h) {
        this.f455b = X0.j.d(obj);
        this.f460g = (InterfaceC1340f) X0.j.e(interfaceC1340f, "Signature must not be null");
        this.f456c = i5;
        this.f457d = i6;
        this.f461h = (Map) X0.j.d(map);
        this.f458e = (Class) X0.j.e(cls, "Resource class must not be null");
        this.f459f = (Class) X0.j.e(cls2, "Transcode class must not be null");
        this.f462i = (C1342h) X0.j.d(c1342h);
    }

    @Override // z0.InterfaceC1340f
    public void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // z0.InterfaceC1340f
    public boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.f455b.equals(nVar.f455b) && this.f460g.equals(nVar.f460g) && this.f457d == nVar.f457d && this.f456c == nVar.f456c && this.f461h.equals(nVar.f461h) && this.f458e.equals(nVar.f458e) && this.f459f.equals(nVar.f459f) && this.f462i.equals(nVar.f462i)) {
                return true;
            }
        }
        return false;
    }

    @Override // z0.InterfaceC1340f
    public int hashCode() {
        if (this.f463j == 0) {
            int iHashCode = this.f455b.hashCode();
            this.f463j = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.f460g.hashCode()) * 31) + this.f456c) * 31) + this.f457d;
            this.f463j = iHashCode2;
            int iHashCode3 = (iHashCode2 * 31) + this.f461h.hashCode();
            this.f463j = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.f458e.hashCode();
            this.f463j = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f459f.hashCode();
            this.f463j = iHashCode5;
            this.f463j = (iHashCode5 * 31) + this.f462i.hashCode();
        }
        return this.f463j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f455b + ", width=" + this.f456c + ", height=" + this.f457d + ", resourceClass=" + this.f458e + ", transcodeClass=" + this.f459f + ", signature=" + this.f460g + ", hashCode=" + this.f463j + ", transformations=" + this.f461h + ", options=" + this.f462i + '}';
    }
}
