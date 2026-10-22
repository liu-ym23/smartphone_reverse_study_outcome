package o4;

/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f7378a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7379b;

    public h0(int i2, String str) {
        this.f7378a = i2;
        this.f7379b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        return this.f7378a == h0Var.f7378a && q7.k.a(this.f7379b, h0Var.f7379b);
    }

    public final int hashCode() {
        return this.f7379b.hashCode() + (Integer.hashCode(this.f7378a) * 31);
    }

    public final String toString() {
        return "CloseInfo(code=" + this.f7378a + ", reason=" + this.f7379b + ")";
    }
}
