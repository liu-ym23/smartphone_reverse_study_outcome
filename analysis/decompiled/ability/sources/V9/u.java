package V9;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: classes4.dex */
public interface u extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    y timeout();

    void write(g gVar, long j5);
}
