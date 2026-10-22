package o3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class e implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream[] f5421a;

    public e(InputStream[] inputStreamArr) {
        this.f5421a = inputStreamArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        for (InputStream inputStream : this.f5421a) {
            i.a(inputStream);
        }
    }
}
