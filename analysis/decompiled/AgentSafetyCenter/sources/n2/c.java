package n2;

import d1.f0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements o {

    /* renamed from: a, reason: collision with root package name */
    public long f8647a;

    @Override // n2.o
    public final long a() {
        return this.f8647a;
    }

    @Override // n2.o
    public final f0 b() {
        return null;
    }

    @Override // n2.o
    public final float c() {
        return d1.p.e(this.f8647a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && d1.p.d(this.f8647a, ((c) obj).f8647a);
    }

    public final int hashCode() {
        long j10 = this.f8647a;
        int i = d1.p.f3025h;
        return Long.hashCode(j10);
    }

    public final String toString() {
        return "ColorStyle(value=" + ((Object) d1.p.j(this.f8647a)) + ')';
    }
}
