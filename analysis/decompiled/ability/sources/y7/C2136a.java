package y7;

/* renamed from: y7.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2136a implements InterfaceC2137b {
    public static final Object c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile InterfaceC2137b f6909a;
    public volatile Object b;

    public static InterfaceC2137b a(InterfaceC2137b interfaceC2137b) {
        interfaceC2137b.getClass();
        if (interfaceC2137b instanceof C2136a) {
            return interfaceC2137b;
        }
        C2136a c2136a = new C2136a();
        c2136a.b = c;
        c2136a.f6909a = interfaceC2137b;
        return c2136a;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Object obj;
        Object obj2 = this.b;
        Object obj3 = c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            obj = this.b;
            if (obj == obj3) {
                obj = this.f6909a.get();
                Object obj4 = this.b;
                if (obj4 != obj3 && obj4 != obj) {
                    throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                }
                this.b = obj;
                this.f6909a = null;
            }
        }
        return obj;
    }
}
