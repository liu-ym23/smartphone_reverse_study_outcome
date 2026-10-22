package V3;

import i4.InterfaceC0761a;
import java.io.Serializable;

/* loaded from: classes.dex */
final class q<T> implements f<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0761a<? extends T> f5538a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Object f5539b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f5540c;

    public q(InterfaceC0761a<? extends T> interfaceC0761a, Object obj) {
        j4.k.g(interfaceC0761a, "initializer");
        this.f5538a = interfaceC0761a;
        this.f5539b = t.f5541a;
        this.f5540c = obj == null ? this : obj;
    }

    public boolean a() {
        return this.f5539b != t.f5541a;
    }

    @Override // V3.f
    public T getValue() {
        T tInvoke;
        T t5 = (T) this.f5539b;
        t tVar = t.f5541a;
        if (t5 != tVar) {
            return t5;
        }
        synchronized (this.f5540c) {
            tInvoke = (T) this.f5539b;
            if (tInvoke == tVar) {
                InterfaceC0761a<? extends T> interfaceC0761a = this.f5538a;
                j4.k.d(interfaceC0761a);
                tInvoke = interfaceC0761a.invoke();
                this.f5539b = tInvoke;
                this.f5538a = null;
            }
        }
        return tInvoke;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ q(InterfaceC0761a interfaceC0761a, Object obj, int i5, j4.g gVar) {
        this(interfaceC0761a, (i5 & 2) != 0 ? null : obj);
    }
}
