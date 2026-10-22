package xa;

/* renamed from: xa.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5867j<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f43606a;

    /* renamed from: b, reason: collision with root package name */
    public final Thread f43607b = Thread.currentThread();

    public C5867j(T t10) {
        this.f43606a = t10;
    }

    public T a() {
        if (b()) {
            return this.f43606a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean b() {
        return this.f43607b == Thread.currentThread();
    }
}
