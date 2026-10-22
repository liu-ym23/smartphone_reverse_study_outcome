package r6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final u f5210a;

    /* renamed from: b, reason: collision with root package name */
    public final u f5211b;

    /* renamed from: c, reason: collision with root package name */
    public final Throwable f5212c;

    public /* synthetic */ t(u uVar, Throwable th, int i8) {
        this(uVar, (c) null, (i8 & 4) != 0 ? null : th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return kotlin.jvm.internal.p.a(this.f5210a, tVar.f5210a) && kotlin.jvm.internal.p.a(this.f5211b, tVar.f5211b) && kotlin.jvm.internal.p.a(this.f5212c, tVar.f5212c);
    }

    public final int hashCode() {
        int iHashCode = this.f5210a.hashCode() * 31;
        u uVar = this.f5211b;
        int iHashCode2 = (iHashCode + (uVar == null ? 0 : uVar.hashCode())) * 31;
        Throwable th = this.f5212c;
        return iHashCode2 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "ConnectResult(plan=" + this.f5210a + ", nextPlan=" + this.f5211b + ", throwable=" + this.f5212c + ')';
    }

    public t(u uVar, c cVar, Throwable th) {
        this.f5210a = uVar;
        this.f5211b = cVar;
        this.f5212c = th;
    }
}
