package sd;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class m implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public final c0 f11961a;

    public m(c0 delegate) {
        kotlin.jvm.internal.g.f(delegate, "delegate");
        this.f11961a = delegate;
    }

    @Override // sd.c0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f11961a.close();
    }

    @Override // sd.c0, java.io.Flushable
    public void flush() {
        this.f11961a.flush();
    }

    @Override // sd.c0
    public final f0 timeout() {
        return this.f11961a.timeout();
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.f11961a + ')';
    }
}
