package h3;

import n3.InterfaceC4938b;

/* renamed from: h3.r, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C4142r<T> implements InterfaceC4938b<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f32940c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f32941a = f32940c;

    /* renamed from: b, reason: collision with root package name */
    public volatile InterfaceC4938b<T> f32942b;

    public C4142r(InterfaceC4938b<T> interfaceC4938b) {
        this.f32942b = interfaceC4938b;
    }

    @Override // n3.InterfaceC4938b
    public T get() {
        T t10;
        T t11 = (T) this.f32941a;
        Object obj = f32940c;
        if (t11 != obj) {
            return t11;
        }
        synchronized (this) {
            try {
                t10 = (T) this.f32941a;
                if (t10 == obj) {
                    t10 = this.f32942b.get();
                    this.f32941a = t10;
                    this.f32942b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t10;
    }
}
