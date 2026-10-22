package m9;

/* renamed from: m9.s, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1726s {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5332a;
    public final InterfaceC1716i b;
    public final S7.o c;
    public final Object d;
    public final Throwable e;

    public C1726s(Object obj, InterfaceC1716i interfaceC1716i, S7.o oVar, Object obj2, Throwable th) {
        this.f5332a = obj;
        this.b = interfaceC1716i;
        this.c = oVar;
        this.d = obj2;
        this.e = th;
    }

    public static C1726s a(C1726s c1726s, InterfaceC1716i interfaceC1716i, Throwable th, int i) {
        Object obj = c1726s.f5332a;
        if ((i & 2) != 0) {
            interfaceC1716i = c1726s.b;
        }
        InterfaceC1716i interfaceC1716i2 = interfaceC1716i;
        S7.o oVar = c1726s.c;
        Object obj2 = c1726s.d;
        if ((i & 16) != 0) {
            th = c1726s.e;
        }
        c1726s.getClass();
        return new C1726s(obj, interfaceC1716i2, oVar, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1726s)) {
            return false;
        }
        C1726s c1726s = (C1726s) obj;
        return kotlin.jvm.internal.k.b(this.f5332a, c1726s.f5332a) && kotlin.jvm.internal.k.b(this.b, c1726s.b) && kotlin.jvm.internal.k.b(this.c, c1726s.c) && kotlin.jvm.internal.k.b(this.d, c1726s.d) && kotlin.jvm.internal.k.b(this.e, c1726s.e);
    }

    public final int hashCode() {
        Object obj = this.f5332a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        InterfaceC1716i interfaceC1716i = this.b;
        int iHashCode2 = (iHashCode + (interfaceC1716i == null ? 0 : interfaceC1716i.hashCode())) * 31;
        S7.o oVar = this.c;
        int iHashCode3 = (iHashCode2 + (oVar == null ? 0 : oVar.hashCode())) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f5332a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    public /* synthetic */ C1726s(Object obj, InterfaceC1716i interfaceC1716i, S7.o oVar, Throwable th, int i) {
        this(obj, (i & 2) != 0 ? null : interfaceC1716i, (i & 4) != 0 ? null : oVar, (Object) null, (i & 16) != 0 ? null : th);
    }
}
