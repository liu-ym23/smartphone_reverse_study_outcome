package L4;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: classes.dex */
public interface w extends Closeable, Flushable {
    z b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    void y0(e eVar, long j5);
}
