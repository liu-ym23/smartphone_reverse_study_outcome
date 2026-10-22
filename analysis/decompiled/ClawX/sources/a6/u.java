package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final Object f216a;

    /* renamed from: b, reason: collision with root package name */
    public final j f217b;

    /* renamed from: c, reason: collision with root package name */
    public final p5.q f218c;
    public final Object d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f219e;

    public u(Object obj, j jVar, p5.q qVar, Object obj2, Throwable th) {
        this.f216a = obj;
        this.f217b = jVar;
        this.f218c = qVar;
        this.d = obj2;
        this.f219e = th;
    }

    public static u a(u uVar, j jVar, Throwable th, int i8) {
        Object obj = uVar.f216a;
        if ((i8 & 2) != 0) {
            jVar = uVar.f217b;
        }
        j jVar2 = jVar;
        p5.q qVar = uVar.f218c;
        Object obj2 = uVar.d;
        if ((i8 & 16) != 0) {
            th = uVar.f219e;
        }
        return new u(obj, jVar2, qVar, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return kotlin.jvm.internal.p.a(this.f216a, uVar.f216a) && kotlin.jvm.internal.p.a(this.f217b, uVar.f217b) && kotlin.jvm.internal.p.a(this.f218c, uVar.f218c) && kotlin.jvm.internal.p.a(this.d, uVar.d) && kotlin.jvm.internal.p.a(this.f219e, uVar.f219e);
    }

    public final int hashCode() {
        Object obj = this.f216a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        j jVar = this.f217b;
        int iHashCode2 = (iHashCode + (jVar == null ? 0 : jVar.hashCode())) * 31;
        p5.q qVar = this.f218c;
        int iHashCode3 = (iHashCode2 + (qVar == null ? 0 : qVar.hashCode())) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f219e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f216a + ", cancelHandler=" + this.f217b + ", onCancellation=" + this.f218c + ", idempotentResume=" + this.d + ", cancelCause=" + this.f219e + ')';
    }

    public /* synthetic */ u(Object obj, j jVar, p5.q qVar, Throwable th, int i8) {
        this(obj, (i8 & 2) != 0 ? null : jVar, (i8 & 4) != 0 ? null : qVar, (Object) null, (i8 & 16) != 0 ? null : th);
    }
}
