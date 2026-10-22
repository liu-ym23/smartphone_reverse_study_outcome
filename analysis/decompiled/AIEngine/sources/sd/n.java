package sd;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class n implements e0 {
    private final e0 delegate;

    public n(e0 delegate) {
        kotlin.jvm.internal.g.f(delegate, "delegate");
        this.delegate = delegate;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final e0 m178deprecated_delegate() {
        return this.delegate;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final e0 delegate() {
        return this.delegate;
    }

    @Override // sd.e0
    public long read(e sink, long j10) {
        kotlin.jvm.internal.g.f(sink, "sink");
        return this.delegate.read(sink, j10);
    }

    @Override // sd.e0
    public f0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
