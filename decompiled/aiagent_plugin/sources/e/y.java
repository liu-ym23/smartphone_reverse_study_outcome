package e;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: compiled from: Sink.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface y extends Closeable, Flushable {
    ab a();

    void a_(e r1, long r2);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();
}
