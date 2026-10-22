package D;

import j4.k;

/* loaded from: classes.dex */
public class g<T> extends f<T> {

    /* renamed from: c, reason: collision with root package name */
    private final Object f1003c;

    public g(int i5) {
        super(i5);
        this.f1003c = new Object();
    }

    @Override // D.f, D.e
    public boolean a(T t5) {
        boolean zA;
        k.g(t5, "instance");
        synchronized (this.f1003c) {
            zA = super.a(t5);
        }
        return zA;
    }

    @Override // D.f, D.e
    public T b() {
        T t5;
        synchronized (this.f1003c) {
            t5 = (T) super.b();
        }
        return t5;
    }
}
