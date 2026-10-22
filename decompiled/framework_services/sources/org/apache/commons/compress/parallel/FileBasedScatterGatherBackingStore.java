package org.apache.commons.compress.parallel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;

/* JADX INFO: loaded from: classes3.dex */
public class FileBasedScatterGatherBackingStore implements ScatterGatherBackingStore {
    private boolean closed;
    private final OutputStream os;
    private final File target;

    public FileBasedScatterGatherBackingStore(File target) throws FileNotFoundException {
        this.target = target;
        this.os = Files.newOutputStream(target.toPath(), new OpenOption[0]);     // Catch: IOException -> L5 FileNotFoundException -> L7
        return;
    L7:
        ex = move-exception;
        throw ex;
    L5:
        ex = move-exception;
        throw new RuntimeException(ex);
    }

    @Override // org.apache.commons.compress.parallel.ScatterGatherBackingStore
    public InputStream getInputStream() throws IOException {
        return Files.newInputStream(this.target.toPath(), new OpenOption[0]);
    }

    @Override // org.apache.commons.compress.parallel.ScatterGatherBackingStore
    public void closeForWriting() throws IOException {
        if (this.closed == true) goto L6;
        this.os.close();
        this.closed = true;
        return;
    }

    @Override // org.apache.commons.compress.parallel.ScatterGatherBackingStore
    public void writeOut(byte[] data, int offset, int length) throws IOException {
        this.os.write(data, offset, length);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        closeForWriting();     // Catch: Throwable -> L5
        this.target.delete();
        return;
    L5:
        th = move-exception;
        this.target.delete();
        throw th;
    }
}
