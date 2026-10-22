package J3;

/* loaded from: classes.dex */
public final class p<T> extends x3.f<T> implements G3.d<T> {

    /* renamed from: b, reason: collision with root package name */
    private final T f3402b;

    public p(T t5) {
        this.f3402b = t5;
    }

    @Override // x3.f
    protected void W(Q4.b<? super T> bVar) {
        bVar.e(new Q3.e(bVar, this.f3402b));
    }

    @Override // G3.d, java.util.concurrent.Callable
    public T call() {
        return this.f3402b;
    }
}
