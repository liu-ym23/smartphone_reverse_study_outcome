package ob;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: classes.dex */
public interface i0 extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    m0 timeout();

    void write(h hVar, long j2);
}
