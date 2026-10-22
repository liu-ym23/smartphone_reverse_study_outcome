package s4;

import i4.InterfaceC0772l;

/* renamed from: s4.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C1095x {

    /* renamed from: a, reason: collision with root package name */
    public final Object f20392a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC1078j f20393b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC0772l<Throwable, V3.v> f20394c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f20395d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f20396e;

    /* JADX WARN: Multi-variable type inference failed */
    public C1095x(Object obj, InterfaceC1078j interfaceC1078j, InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l, Object obj2, Throwable th) {
        this.f20392a = obj;
        this.f20393b = interfaceC1078j;
        this.f20394c = interfaceC0772l;
        this.f20395d = obj2;
        this.f20396e = th;
    }

    public static /* synthetic */ C1095x b(C1095x c1095x, Object obj, InterfaceC1078j interfaceC1078j, InterfaceC0772l interfaceC0772l, Object obj2, Throwable th, int i5, Object obj3) {
        if ((i5 & 1) != 0) {
            obj = c1095x.f20392a;
        }
        if ((i5 & 2) != 0) {
            interfaceC1078j = c1095x.f20393b;
        }
        if ((i5 & 4) != 0) {
            interfaceC0772l = c1095x.f20394c;
        }
        if ((i5 & 8) != 0) {
            obj2 = c1095x.f20395d;
        }
        if ((i5 & 16) != 0) {
            th = c1095x.f20396e;
        }
        Throwable th2 = th;
        InterfaceC0772l interfaceC0772l2 = interfaceC0772l;
        return c1095x.a(obj, interfaceC1078j, interfaceC0772l2, obj2, th2);
    }

    public final C1095x a(Object obj, InterfaceC1078j interfaceC1078j, InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l, Object obj2, Throwable th) {
        return new C1095x(obj, interfaceC1078j, interfaceC0772l, obj2, th);
    }

    public final boolean c() {
        return this.f20396e != null;
    }

    public final void d(C1082l<?> c1082l, Throwable th) {
        InterfaceC1078j interfaceC1078j = this.f20393b;
        if (interfaceC1078j != null) {
            c1082l.n(interfaceC1078j, th);
        }
        InterfaceC0772l<Throwable, V3.v> interfaceC0772l = this.f20394c;
        if (interfaceC0772l != null) {
            c1082l.o(interfaceC0772l, th);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1095x)) {
            return false;
        }
        C1095x c1095x = (C1095x) obj;
        return j4.k.b(this.f20392a, c1095x.f20392a) && j4.k.b(this.f20393b, c1095x.f20393b) && j4.k.b(this.f20394c, c1095x.f20394c) && j4.k.b(this.f20395d, c1095x.f20395d) && j4.k.b(this.f20396e, c1095x.f20396e);
    }

    public int hashCode() {
        Object obj = this.f20392a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        InterfaceC1078j interfaceC1078j = this.f20393b;
        int iHashCode2 = (iHashCode + (interfaceC1078j == null ? 0 : interfaceC1078j.hashCode())) * 31;
        InterfaceC0772l<Throwable, V3.v> interfaceC0772l = this.f20394c;
        int iHashCode3 = (iHashCode2 + (interfaceC0772l == null ? 0 : interfaceC0772l.hashCode())) * 31;
        Object obj2 = this.f20395d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f20396e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f20392a + ", cancelHandler=" + this.f20393b + ", onCancellation=" + this.f20394c + ", idempotentResume=" + this.f20395d + ", cancelCause=" + this.f20396e + ')';
    }

    public /* synthetic */ C1095x(Object obj, InterfaceC1078j interfaceC1078j, InterfaceC0772l interfaceC0772l, Object obj2, Throwable th, int i5, j4.g gVar) {
        this(obj, (i5 & 2) != 0 ? null : interfaceC1078j, (i5 & 4) != 0 ? null : interfaceC0772l, (i5 & 8) != 0 ? null : obj2, (i5 & 16) != 0 ? null : th);
    }
}
