package H8;

/* renamed from: H8.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0246g {

    /* renamed from: a, reason: collision with root package name */
    public final Object f771a;
    public final int b;

    public C0246g(Object obj, int i) {
        this.f771a = obj;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0246g)) {
            return false;
        }
        C0246g c0246g = (C0246g) obj;
        return this.f771a == c0246g.f771a && this.b == c0246g.b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f771a) * 65535) + this.b;
    }
}
