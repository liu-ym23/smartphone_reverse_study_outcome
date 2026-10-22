package dg;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f19200i = null;

    static {
        f19200i = new b();
    }

    public b() {
        super(j.f19213c, j.f19214d, j.f19215e, j.f19211a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Default";
    }
}
