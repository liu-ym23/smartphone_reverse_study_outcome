package L4;

/* loaded from: classes.dex */
public abstract class j implements y {

    /* renamed from: a, reason: collision with root package name */
    private final y f3948a;

    public j(y yVar) {
        j4.k.h(yVar, "delegate");
        this.f3948a = yVar;
    }

    public final y a() {
        return this.f3948a;
    }

    @Override // L4.y
    public z b() {
        return this.f3948a.b();
    }

    @Override // L4.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3948a.close();
    }

    @Override // L4.y
    public long e(e eVar, long j5) {
        j4.k.h(eVar, "sink");
        return this.f3948a.e(eVar, j5);
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f3948a + ')';
    }
}
