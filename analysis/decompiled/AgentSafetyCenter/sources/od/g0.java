package od;

import java.io.Closeable;
import java.io.Flushable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface g0 extends Closeable, Flushable {
    k0 b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void f(i iVar, long j10);

    void flush();
}
