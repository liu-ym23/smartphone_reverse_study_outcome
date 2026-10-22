package D4;

/* loaded from: classes.dex */
public abstract class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    protected final String f1203a;

    public b(String str, Object... objArr) {
        this.f1203a = e.q(str, objArr);
    }

    protected abstract void k();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f1203a);
        try {
            k();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
