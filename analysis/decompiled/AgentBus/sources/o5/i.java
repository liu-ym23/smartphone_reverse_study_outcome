package o5;

import m.x;
import n7.o;

/* loaded from: classes.dex */
public final class i extends o {

    /* renamed from: b, reason: collision with root package name */
    public final String f7763b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7764c;

    /* renamed from: d, reason: collision with root package name */
    public final j f7765d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(String str, long j2, j jVar) {
        super(2);
        q7.k.e(jVar, "retryHint");
        this.f7763b = str;
        this.f7764c = j2;
        this.f7765d = jVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return q7.k.a(this.f7763b, iVar.f7763b) && this.f7764c == iVar.f7764c && this.f7765d == iVar.f7765d;
    }

    @Override // n7.o
    public final int hashCode() {
        return this.f7765d.hashCode() + x.f(this.f7764c, this.f7763b.hashCode() * 31, 31);
    }

    @Override // n7.o
    public final String toString() {
        return "Unavailable(reason=" + this.f7763b + ", sinceMs=" + this.f7764c + ", retryHint=" + this.f7765d + ")";
    }
}
