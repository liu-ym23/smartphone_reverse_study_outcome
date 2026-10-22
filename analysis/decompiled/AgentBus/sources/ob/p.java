package ob;

/* loaded from: classes.dex */
public abstract class p implements i0 {
    private final i0 delegate;

    public p(i0 i0Var) {
        q7.k.e(i0Var, "delegate");
        this.delegate = i0Var;
    }

    @c7.a
    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final i0 m23deprecated_delegate() {
        return this.delegate;
    }

    @Override // ob.i0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final i0 delegate() {
        return this.delegate;
    }

    @Override // ob.i0, java.io.Flushable
    public void flush() {
        this.delegate.flush();
    }

    @Override // ob.i0
    public m0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // ob.i0
    public void write(h hVar, long j2) {
        q7.k.e(hVar, "source");
        this.delegate.write(hVar, j2);
    }
}
