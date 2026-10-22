package E3;

import x3.InterfaceC1287c;
import x3.s;

/* loaded from: classes.dex */
public enum c implements G3.b, A3.c {
    INSTANCE,
    NEVER;

    public static void d(InterfaceC1287c interfaceC1287c) {
        interfaceC1287c.b(INSTANCE);
        interfaceC1287c.a();
    }

    public static void e(Throwable th, s<?> sVar) {
        sVar.b(INSTANCE);
        sVar.onError(th);
    }

    @Override // G3.f
    public void clear() {
    }

    @Override // A3.c
    public void dispose() {
    }

    @Override // A3.c
    public boolean g() {
        return this == INSTANCE;
    }

    @Override // G3.f
    public boolean isEmpty() {
        return true;
    }

    @Override // G3.f
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // G3.f
    public Object poll() {
        return null;
    }
}
