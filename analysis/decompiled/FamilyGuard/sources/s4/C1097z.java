package s4;

import i4.InterfaceC0772l;

/* renamed from: s4.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1097z {

    /* renamed from: a, reason: collision with root package name */
    public final Object f20399a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0772l<Throwable, V3.v> f20400b;

    /* JADX WARN: Multi-variable type inference failed */
    public C1097z(Object obj, InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l) {
        this.f20399a = obj;
        this.f20400b = interfaceC0772l;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1097z)) {
            return false;
        }
        C1097z c1097z = (C1097z) obj;
        return j4.k.b(this.f20399a, c1097z.f20399a) && j4.k.b(this.f20400b, c1097z.f20400b);
    }

    public int hashCode() {
        Object obj = this.f20399a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f20400b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f20399a + ", onCancellation=" + this.f20400b + ')';
    }
}
