package V9;

import java.io.IOException;

/* loaded from: classes4.dex */
public abstract class k implements w {

    /* renamed from: a, reason: collision with root package name */
    public final w f1419a;

    public k(w delegate) {
        kotlin.jvm.internal.k.f(delegate, "delegate");
        this.f1419a = delegate;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1419a.close();
    }

    @Override // V9.w
    public final y timeout() {
        return this.f1419a.timeout();
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.f1419a + ')';
    }
}
