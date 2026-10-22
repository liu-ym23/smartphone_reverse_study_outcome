package J0;

import C0.v;
import X0.j;

/* loaded from: classes.dex */
public class a<T> implements v<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final T f3196a;

    public a(T t5) {
        this.f3196a = (T) j.d(t5);
    }

    @Override // C0.v
    public void b() {
    }

    @Override // C0.v
    public final int c() {
        return 1;
    }

    @Override // C0.v
    public Class<T> d() {
        return (Class<T>) this.f3196a.getClass();
    }

    @Override // C0.v
    public final T get() {
        return this.f3196a;
    }
}
