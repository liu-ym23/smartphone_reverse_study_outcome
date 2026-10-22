package L8;

import h8.InterfaceC1540w;

/* loaded from: classes4.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public final Object f939a;

    public g(Object obj) {
        this.f939a = obj;
    }

    public abstract X8.w a(InterfaceC1540w interfaceC1540w);

    public Object b() {
        return this.f939a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Object objB = b();
        g gVar = obj instanceof g ? (g) obj : null;
        return kotlin.jvm.internal.k.b(objB, gVar != null ? gVar.b() : null);
    }

    public final int hashCode() {
        Object objB = b();
        if (objB != null) {
            return objB.hashCode();
        }
        return 0;
    }

    public String toString() {
        return String.valueOf(b());
    }
}
