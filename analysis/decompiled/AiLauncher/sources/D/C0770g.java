package D;

import D.r0;

/* renamed from: D.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0770g extends r0.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f2104a;

    /* renamed from: b, reason: collision with root package name */
    public final r0 f2105b;

    public C0770g(int i10, r0 r0Var) {
        this.f2104a = i10;
        if (r0Var == null) {
            throw new NullPointerException("Null surfaceOutput");
        }
        this.f2105b = r0Var;
    }

    @Override // D.r0.b
    public int a() {
        return this.f2104a;
    }

    @Override // D.r0.b
    public r0 b() {
        return this.f2105b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r0.b) {
            r0.b bVar = (r0.b) obj;
            if (this.f2104a == bVar.a() && this.f2105b.equals(bVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f2105b.hashCode() ^ ((this.f2104a ^ 1000003) * 1000003);
    }

    public String toString() {
        return "Event{eventCode=" + this.f2104a + ", surfaceOutput=" + this.f2105b + "}";
    }
}
