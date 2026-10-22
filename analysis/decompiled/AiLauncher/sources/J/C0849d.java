package J;

import J.B;

/* renamed from: J.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0849d extends B.a {

    /* renamed from: a, reason: collision with root package name */
    public final U.A<androidx.camera.core.i> f3619a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3620b;

    public C0849d(U.A<androidx.camera.core.i> a10, int i10) {
        if (a10 == null) {
            throw new NullPointerException("Null packet");
        }
        this.f3619a = a10;
        this.f3620b = i10;
    }

    @Override // J.B.a
    public int a() {
        return this.f3620b;
    }

    @Override // J.B.a
    public U.A<androidx.camera.core.i> b() {
        return this.f3619a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof B.a) {
            B.a aVar = (B.a) obj;
            if (this.f3619a.equals(aVar.b()) && this.f3620b == aVar.a()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f3620b ^ ((this.f3619a.hashCode() ^ 1000003) * 1000003);
    }

    public String toString() {
        return "In{packet=" + this.f3619a + ", jpegQuality=" + this.f3620b + "}";
    }
}
