package b0;

/* loaded from: classes.dex */
public interface c {
    void a(int i2, Object obj);

    void c(Object obj);

    void d();

    void e(int i2, Object obj);

    void f(int i2, int i10, int i11);

    void g(int i2, int i10);

    Object getCurrent();

    default void h(Object obj, p7.n nVar) {
        nVar.invoke(getCurrent(), obj);
    }

    void j();
}
