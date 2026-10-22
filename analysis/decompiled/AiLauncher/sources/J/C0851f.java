package J;

import android.util.Size;

/* renamed from: J.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0851f extends K {

    /* renamed from: a, reason: collision with root package name */
    public final Size f3624a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3625b;

    public C0851f(Size size, int i10) {
        if (size == null) {
            throw new NullPointerException("Null resolution");
        }
        this.f3624a = size;
        this.f3625b = i10;
    }

    @Override // J.K
    public int b() {
        return this.f3625b;
    }

    @Override // J.K
    public Size c() {
        return this.f3624a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof K) {
            K k10 = (K) obj;
            if (this.f3624a.equals(k10.c()) && this.f3625b == k10.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f3625b ^ ((this.f3624a.hashCode() ^ 1000003) * 1000003);
    }

    public String toString() {
        return "PostviewSettings{resolution=" + this.f3624a + ", inputFormat=" + this.f3625b + "}";
    }
}
