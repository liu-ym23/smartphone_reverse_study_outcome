package org.apache.commons.compress.compressors.pack200;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.jar.JarInputStream;
import java.util.jar.Pack200;
import org.apache.commons.compress.compressors.CompressorOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class Pack200CompressorOutputStream extends CompressorOutputStream {
    private boolean finished;
    private final OutputStream originalOutput;
    private final Map<String, String> properties;
    private final StreamBridge streamBridge;

    public Pack200CompressorOutputStream(OutputStream out) throws IOException {
        this(out, Pack200Strategy.IN_MEMORY);
    }

    public Pack200CompressorOutputStream(OutputStream out, Pack200Strategy mode) throws IOException {
        this(out, mode, null);
    }

    public Pack200CompressorOutputStream(OutputStream out, Map<String, String> props) throws IOException {
        this(out, Pack200Strategy.IN_MEMORY, props);
    }

    public Pack200CompressorOutputStream(OutputStream out, Pack200Strategy mode, Map<String, String> props) throws IOException {
        this.finished = false;
        this.originalOutput = out;
        this.streamBridge = mode.newStreamBridge();
        this.properties = props;
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.streamBridge.write(b);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b) throws IOException {
        this.streamBridge.write(b);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int from, int length) throws IOException {
        this.streamBridge.write(b, from, length);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        finish();     // Catch: Throwable -> L9
        this.streamBridge.stop();     // Catch: Throwable -> L6
        this.originalOutput.close();
        return;
    L6:
        th = move-exception;
        this.originalOutput.close();
        throw th;
    L9:
        th = move-exception;
        this.streamBridge.stop();     // Catch: Throwable -> L13
        this.originalOutput.close();
        throw th;
    L13:
        th = move-exception;
        this.originalOutput.close();
        throw th;
    }

    public void finish() throws IOException {
        if (this.finished == true) goto L16;
        this.finished = true;
        Pack200.Packer p = Pack200.newPacker();
        if (this.properties == null) goto L7;
        p.properties().putAll(this.properties);
    L7:
        JarInputStream ji = new JarInputStream(this.streamBridge.getInput());
        p.pack(ji, this.originalOutput);     // Catch: Throwable -> L10
        ji.close();
        return;
    L10:
        th = move-exception;
        ji.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }
}
