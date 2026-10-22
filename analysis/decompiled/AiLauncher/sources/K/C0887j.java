package K;

import K.A0;

/* renamed from: K.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0887j extends A0.a {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f3986a;

    public C0887j(Throwable th) {
        if (th == null) {
            throw new NullPointerException("Null error");
        }
        this.f3986a = th;
    }

    @Override // K.A0.a
    public Throwable a() {
        return this.f3986a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof A0.a) {
            return this.f3986a.equals(((A0.a) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f3986a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ErrorWrapper{error=" + this.f3986a + "}";
    }
}
