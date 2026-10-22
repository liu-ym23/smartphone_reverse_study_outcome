package okhttp3.internal.cache;

import fg.e;
import java.io.IOException;
import okio.Buffer;
import okio.Sink;

/* JADX INFO: loaded from: classes4.dex */
class FaultHidingSink extends e {
    private boolean hasErrors;

    public FaultHidingSink(Sink r10) {
        super(r10);
    }

    @Override // fg.e, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.hasErrors == false) goto L10;
        return;
    L10:
        super.close();     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        this.hasErrors = true;
        onException(e);
    }

    @Override // fg.e, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.hasErrors == false) goto L10;
        return;
    L10:
        super.flush();     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        this.hasErrors = true;
        onException(e);
    }

    public void onException(IOException r10) {
    }

    @Override // fg.e, okio.Sink
    public void write(Buffer r10, long r11) throws IOException {
        if (this.hasErrors == false) goto L11;
        r10.skip(r11);
        return;
    L11:
        super.write(r10, r11);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        this.hasErrors = true;
        onException(e);
    }
}
