package ia;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5003a;

    /* renamed from: b, reason: collision with root package name */
    public final i f5004b;

    /* renamed from: c, reason: collision with root package name */
    public final p7.o f5005c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f5006d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f5007e;

    public u(Object obj, i iVar, p7.o oVar, Object obj2, Throwable th) {
        this.f5003a = obj;
        this.f5004b = iVar;
        this.f5005c = oVar;
        this.f5006d = obj2;
        this.f5007e = th;
    }

    public static u a(u uVar, i iVar, Throwable th, int i2) {
        Object obj = uVar.f5003a;
        if ((i2 & 2) != 0) {
            iVar = uVar.f5004b;
        }
        i iVar2 = iVar;
        p7.o oVar = uVar.f5005c;
        Object obj2 = uVar.f5006d;
        if ((i2 & 16) != 0) {
            th = uVar.f5007e;
        }
        return new u(obj, iVar2, oVar, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return q7.k.a(this.f5003a, uVar.f5003a) && q7.k.a(this.f5004b, uVar.f5004b) && q7.k.a(this.f5005c, uVar.f5005c) && q7.k.a(this.f5006d, uVar.f5006d) && q7.k.a(this.f5007e, uVar.f5007e);
    }

    public final int hashCode() {
        Object obj = this.f5003a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        i iVar = this.f5004b;
        int iHashCode2 = (iHashCode + (iVar == null ? 0 : iVar.hashCode())) * 31;
        p7.o oVar = this.f5005c;
        int iHashCode3 = (iHashCode2 + (oVar == null ? 0 : oVar.hashCode())) * 31;
        Object obj2 = this.f5006d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f5007e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f5003a + ", cancelHandler=" + this.f5004b + ", onCancellation=" + this.f5005c + ", idempotentResume=" + this.f5006d + ", cancelCause=" + this.f5007e + ')';
    }

    public /* synthetic */ u(Object obj, i iVar, p7.o oVar, Object obj2, Throwable th, int i2) {
        this(obj, (i2 & 2) != 0 ? null : iVar, (i2 & 4) != 0 ? null : oVar, (i2 & 8) != 0 ? null : obj2, (i2 & 16) != 0 ? null : th);
    }
}
