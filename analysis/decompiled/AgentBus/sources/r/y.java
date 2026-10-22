package r;

import b0.o1;

/* loaded from: classes.dex */
public final class y implements n0.k {

    /* renamed from: a, reason: collision with root package name */
    public final o0 f8950a;

    /* renamed from: b, reason: collision with root package name */
    public final o1 f8951b;

    /* renamed from: c, reason: collision with root package name */
    public final o1 f8952c;

    public y(a aVar) {
        this.f8950a = aVar;
        this.f8951b = b0.b.n(aVar);
        this.f8952c = b0.b.n(aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            return q7.k.a(((y) obj).f8950a, this.f8950a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f8950a.hashCode();
    }
}
