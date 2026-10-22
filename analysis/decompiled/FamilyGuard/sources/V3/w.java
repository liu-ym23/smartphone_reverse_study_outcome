package V3;

import i4.InterfaceC0761a;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class w<T> implements f<T>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0761a<? extends T> f5543a;

    /* renamed from: b, reason: collision with root package name */
    private Object f5544b;

    public w(InterfaceC0761a<? extends T> interfaceC0761a) {
        j4.k.g(interfaceC0761a, "initializer");
        this.f5543a = interfaceC0761a;
        this.f5544b = t.f5541a;
    }

    public boolean a() {
        return this.f5544b != t.f5541a;
    }

    @Override // V3.f
    public T getValue() {
        if (this.f5544b == t.f5541a) {
            InterfaceC0761a<? extends T> interfaceC0761a = this.f5543a;
            j4.k.d(interfaceC0761a);
            this.f5544b = interfaceC0761a.invoke();
            this.f5543a = null;
        }
        return (T) this.f5544b;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
