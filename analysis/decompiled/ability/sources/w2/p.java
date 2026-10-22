package w2;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public final class p extends GZIPOutputStream {
    public final void b() throws IOException {
        super.close();
    }

    public final void c() throws IOException {
        super.finish();
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.util.zip.GZIPOutputStream, java.util.zip.DeflaterOutputStream
    public final void finish() {
    }
}
