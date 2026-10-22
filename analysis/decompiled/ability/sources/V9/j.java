package V9;

import java.io.IOException;

/* loaded from: classes4.dex */
public abstract class j implements u {
    private final u delegate;

    public j(u delegate) {
        kotlin.jvm.internal.k.f(delegate, "delegate");
        this.delegate = delegate;
    }

    @C7.c
    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final u m2deprecated_delegate() {
        return this.delegate;
    }

    @Override // V9.u, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final u delegate() {
        return this.delegate;
    }

    @Override // V9.u, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // V9.u
    public y timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // V9.u
    public void write(g source, long j5) {
        kotlin.jvm.internal.k.f(source, "source");
        this.delegate.write(source, j5);
    }
}
