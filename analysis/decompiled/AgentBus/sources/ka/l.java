package ka;

/* loaded from: classes.dex */
public final class l extends m {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f5710a;

    public l(Throwable th) {
        this.f5710a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            return q7.k.a(this.f5710a, ((l) obj).f5710a);
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f5710a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // ka.m
    public final String toString() {
        return "Closed(" + this.f5710a + ')';
    }
}
