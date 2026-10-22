package U;

/* renamed from: U.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1038t<T> implements B0.a<T> {

    /* renamed from: a, reason: collision with root package name */
    public B0.a<T> f6140a;

    public void a(B0.a<T> aVar) {
        this.f6140a = aVar;
    }

    @Override // B0.a
    public void accept(T t10) {
        kotlin.jvm.internal.p.g(this.f6140a, "Listener is not set.");
        this.f6140a.accept(t10);
    }
}
