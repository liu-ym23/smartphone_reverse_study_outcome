package w2;

import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class j extends DataOutputStream {
    public final void b() throws IOException {
        super.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
