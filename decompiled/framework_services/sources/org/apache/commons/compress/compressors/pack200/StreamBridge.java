package org.apache.commons.compress.compressors.pack200;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
abstract class StreamBridge extends FilterOutputStream {
    private InputStream input;
    private final Object inputLock;

    abstract InputStream getInputView() throws IOException;

    protected StreamBridge(OutputStream out) {
        super(out);
        this.inputLock = new Object();
    }

    protected StreamBridge() {
        this(null);
    }

    InputStream getInput() throws IOException {
        Object r0 = this.inputLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.input != null) goto L9;
        this.input = getInputView();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return this.input;
    }

    void stop() throws IOException {
        close();
        Object r0 = this.inputLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.input == null) goto L9;
        this.input.close();     // Catch: Throwable -> L7
        this.input = null;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }
}
