package o9;

/* renamed from: o9.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1780f extends C1781g {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f5456a;

    public C1780f(Throwable th) {
        this.f5456a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1780f) {
            return kotlin.jvm.internal.k.b(this.f5456a, ((C1780f) obj).f5456a);
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f5456a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // o9.C1781g
    public final String toString() {
        return "Closed(" + this.f5456a + ')';
    }
}
