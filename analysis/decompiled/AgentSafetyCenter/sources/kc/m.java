package kc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Object f7451a;

    /* renamed from: b, reason: collision with root package name */
    public final e f7452b;

    /* renamed from: c, reason: collision with root package name */
    public final xb.q f7453c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f7454d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f7455e;

    public /* synthetic */ m(Object obj, e eVar, xb.q qVar, Throwable th, int i) {
        this(obj, (i & 2) != 0 ? null : eVar, (i & 4) != 0 ? null : qVar, (Object) null, (i & 16) != 0 ? null : th);
    }

    public static m a(m mVar, e eVar, Throwable th, int i) {
        Object obj = mVar.f7451a;
        if ((i & 2) != 0) {
            eVar = mVar.f7452b;
        }
        e eVar2 = eVar;
        xb.q qVar = mVar.f7453c;
        Object obj2 = mVar.f7454d;
        if ((i & 16) != 0) {
            th = mVar.f7455e;
        }
        return new m(obj, eVar2, qVar, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return yb.k.a(this.f7451a, mVar.f7451a) && yb.k.a(this.f7452b, mVar.f7452b) && yb.k.a(this.f7453c, mVar.f7453c) && yb.k.a(this.f7454d, mVar.f7454d) && yb.k.a(this.f7455e, mVar.f7455e);
    }

    public final int hashCode() {
        Object obj = this.f7451a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        e eVar = this.f7452b;
        int iHashCode2 = (iHashCode + (eVar == null ? 0 : eVar.hashCode())) * 31;
        xb.q qVar = this.f7453c;
        int iHashCode3 = (iHashCode2 + (qVar == null ? 0 : qVar.hashCode())) * 31;
        Object obj2 = this.f7454d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f7455e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f7451a + ", cancelHandler=" + this.f7452b + ", onCancellation=" + this.f7453c + ", idempotentResume=" + this.f7454d + ", cancelCause=" + this.f7455e + ')';
    }

    public m(Object obj, e eVar, xb.q qVar, Object obj2, Throwable th) {
        this.f7451a = obj;
        this.f7452b = eVar;
        this.f7453c = qVar;
        this.f7454d = obj2;
        this.f7455e = th;
    }
}
