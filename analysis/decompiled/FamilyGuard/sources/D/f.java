package D;

import j4.k;

/* loaded from: classes.dex */
public class f<T> implements e<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f1001a;

    /* renamed from: b, reason: collision with root package name */
    private int f1002b;

    public f(int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f1001a = new Object[i5];
    }

    private final boolean c(T t5) {
        int i5 = this.f1002b;
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.f1001a[i6] == t5) {
                return true;
            }
        }
        return false;
    }

    @Override // D.e
    public boolean a(T t5) {
        k.g(t5, "instance");
        if (c(t5)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i5 = this.f1002b;
        Object[] objArr = this.f1001a;
        if (i5 >= objArr.length) {
            return false;
        }
        objArr[i5] = t5;
        this.f1002b = i5 + 1;
        return true;
    }

    @Override // D.e
    public T b() {
        int i5 = this.f1002b;
        if (i5 <= 0) {
            return null;
        }
        int i6 = i5 - 1;
        T t5 = (T) this.f1001a[i6];
        k.e(t5, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        this.f1001a[i6] = null;
        this.f1002b--;
        return t5;
    }
}
