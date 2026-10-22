package k3;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: classes2.dex */
public interface z extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    C0683E timeout();

    void write(C0694i c0694i, long j4);
}
