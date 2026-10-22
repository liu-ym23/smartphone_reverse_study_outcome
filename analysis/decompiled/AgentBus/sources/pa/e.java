package pa;

/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: i, reason: collision with root package name */
    public static final e f8558i;

    static {
        int i2 = k.f8566c;
        int i10 = k.f8567d;
        long j2 = k.f8568e;
        String str = k.f8564a;
        e eVar = new e();
        eVar.f8560h = new c(i2, i10, j2, str);
        f8558i = eVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // ia.x
    public final String toString() {
        return "Dispatchers.Default";
    }
}
