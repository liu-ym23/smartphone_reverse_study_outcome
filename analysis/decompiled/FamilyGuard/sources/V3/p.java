package V3;

import i4.InterfaceC0761a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
final class p<T> implements f<T>, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final a f5533d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<p<?>, Object> f5534e = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "b");

    /* renamed from: a, reason: collision with root package name */
    private volatile InterfaceC0761a<? extends T> f5535a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Object f5536b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f5537c;

    public static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    public p(InterfaceC0761a<? extends T> interfaceC0761a) {
        j4.k.g(interfaceC0761a, "initializer");
        this.f5535a = interfaceC0761a;
        t tVar = t.f5541a;
        this.f5536b = tVar;
        this.f5537c = tVar;
    }

    public boolean a() {
        return this.f5536b != t.f5541a;
    }

    @Override // V3.f
    public T getValue() {
        T t5 = (T) this.f5536b;
        t tVar = t.f5541a;
        if (t5 != tVar) {
            return t5;
        }
        InterfaceC0761a<? extends T> interfaceC0761a = this.f5535a;
        if (interfaceC0761a != null) {
            T tInvoke = interfaceC0761a.invoke();
            if (f5534e.compareAndSet(this, tVar, tInvoke)) {
                this.f5535a = null;
                return tInvoke;
            }
        }
        return (T) this.f5536b;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
