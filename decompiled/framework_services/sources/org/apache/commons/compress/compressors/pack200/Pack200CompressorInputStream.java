package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.jar.JarOutputStream;
import java.util.jar.Pack200;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
public class Pack200CompressorInputStream extends CompressorInputStream {
    private static final byte[] CAFE_DOOD = null;
    private static final int SIG_LENGTH = 0;
    private final InputStream originalInput;
    private final StreamBridge streamBridge;

    public Pack200CompressorInputStream(InputStream in) throws IOException {
        this(in, Pack200Strategy.IN_MEMORY);
    }

    public Pack200CompressorInputStream(InputStream in, Pack200Strategy mode) throws IOException {
        this(in, null, mode, null);
    }

    public Pack200CompressorInputStream(InputStream in, Map<String, String> props) throws IOException {
        this(in, Pack200Strategy.IN_MEMORY, props);
    }

    public Pack200CompressorInputStream(InputStream in, Pack200Strategy mode, Map<String, String> props) throws IOException {
        this(in, null, mode, props);
    }

    public Pack200CompressorInputStream(File f) throws IOException {
        this(f, Pack200Strategy.IN_MEMORY);
    }

    public Pack200CompressorInputStream(File f, Pack200Strategy mode) throws IOException {
        this(null, f, mode, null);
    }

    public Pack200CompressorInputStream(File f, Map<String, String> props) throws IOException {
        this(f, Pack200Strategy.IN_MEMORY, props);
    }

    public Pack200CompressorInputStream(File f, Pack200Strategy mode, Map<String, String> props) throws IOException {
        this(null, f, mode, props);
    }

    private Pack200CompressorInputStream(final InputStream in, File f, Pack200Strategy mode, Map<String, String> props) throws IOException {
        this.originalInput = in;
        this.streamBridge = mode.newStreamBridge();
        JarOutputStream jarOut = new JarOutputStream(this.streamBridge);
        Pack200.Unpacker u = Pack200.newUnpacker();     // Catch: Throwable -> L6
        if (props == null) goto L8;
        u.properties().putAll(props);     // Catch: Throwable -> L6
    L8:
        if (f != null) goto L10;
        u.unpack(new AnonymousClass1(this, in), jarOut);     // Catch: Throwable -> L6
    L11:
        jarOut.close();
        return;
    L10:
        u.unpack(f, jarOut);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        jarOut.close();     // Catch: Throwable -> L15
    L17:
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.streamBridge.getInput().read();
    }

    @Override // java.io.InputStream
    public int read(byte[] b) throws IOException {
        return this.streamBridge.getInput().read(b);
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int count) throws IOException {
        return this.streamBridge.getInput().read(b, off, count);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.streamBridge.getInput().available();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.streamBridge.getInput().markSupported();
    L5:
        return false;
    }

    @Override // java.io.InputStream
    public void mark(int limit) {
        this.streamBridge.getInput().mark(limit);     // Catch: IOException -> L4
        return;
    L4:
        ex = move-exception;
        throw new RuntimeException(ex);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.streamBridge.getInput().reset();
    }

    @Override // java.io.InputStream
    public long skip(long count) throws IOException {
        return IOUtils.skip(this.streamBridge.getInput(), count);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.streamBridge.stop();     // Catch: Throwable -> L7
        if (this.originalInput == null) goto L14;
        this.originalInput.close();
        return;
    L14:
        return;
    L7:
        th = move-exception;
        if (this.originalInput == null) goto L11;
        this.originalInput.close();
    L11:
        throw th;
    }

    static {
        CAFE_DOOD = new byte[]{-54, -2, -48, 13};
        SIG_LENGTH = CAFE_DOOD.length;
    }

    public static boolean matches(byte[] signature, int length) {
        if (length >= SIG_LENGTH) goto L5;
        return false;
    L5:
        int i = 0;
    L7:
        if (i >= SIG_LENGTH) goto L12;
        if (signature[i] != CAFE_DOOD[i]) goto L10;
        i = i + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }
}
