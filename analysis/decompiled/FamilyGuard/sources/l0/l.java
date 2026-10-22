package l0;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import q0.e0;

/* loaded from: classes.dex */
public class l implements Closeable, Flushable {

    /* renamed from: a, reason: collision with root package name */
    private e0 f18138a;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18138a.close();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f18138a.flush();
    }
}
