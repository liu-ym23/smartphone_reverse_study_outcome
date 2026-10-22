package b0;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final t f1387a;

    public w(t tVar) {
        this.f1387a = tVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof w) {
            return q7.k.a(this.f1387a, ((w) obj).f1387a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1387a.hashCode() * 31;
    }
}
