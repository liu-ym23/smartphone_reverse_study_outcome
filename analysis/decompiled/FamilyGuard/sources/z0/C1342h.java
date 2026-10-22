package z0;

import java.security.MessageDigest;
import q.C0933a;

/* renamed from: z0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1342h implements InterfaceC1340f {

    /* renamed from: b, reason: collision with root package name */
    private final C0933a<C1341g<?>, Object> f24051b = new X0.b();

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void f(C1341g<T> c1341g, Object obj, MessageDigest messageDigest) {
        c1341g.g(obj, messageDigest);
    }

    @Override // z0.InterfaceC1340f
    public void b(MessageDigest messageDigest) {
        for (int i5 = 0; i5 < this.f24051b.size(); i5++) {
            f(this.f24051b.f(i5), this.f24051b.j(i5), messageDigest);
        }
    }

    public <T> T c(C1341g<T> c1341g) {
        return this.f24051b.containsKey(c1341g) ? (T) this.f24051b.get(c1341g) : c1341g.c();
    }

    public void d(C1342h c1342h) {
        this.f24051b.g(c1342h.f24051b);
    }

    public <T> C1342h e(C1341g<T> c1341g, T t5) {
        this.f24051b.put(c1341g, t5);
        return this;
    }

    @Override // z0.InterfaceC1340f
    public boolean equals(Object obj) {
        if (obj instanceof C1342h) {
            return this.f24051b.equals(((C1342h) obj).f24051b);
        }
        return false;
    }

    @Override // z0.InterfaceC1340f
    public int hashCode() {
        return this.f24051b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f24051b + '}';
    }
}
