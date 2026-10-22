package com.bytedance.apm.agent.instrumentation.io;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes14.dex */
public final class CountingOutputStream extends OutputStream implements StreamCompleteListenerSource {
    private long count;
    private final OutputStream impl;
    private final StreamCompleteListenerManager listenerManager;

    private void notifyStreamComplete() {
        if (this.listenerManager.isComplete() == true) goto L6;
        this.listenerManager.notifyStreamComplete(new StreamCompleteEvent(this, this.count));
        return;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.impl.close();     // Catch: IOException -> L4
        notifyStreamComplete();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        notifyStreamError(e);
        throw e;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.impl.flush();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        notifyStreamError(e);
        throw e;
    }

    public long getCount() {
        return this.count;
    }

    public CountingOutputStream(OutputStream r100) {
        this.count = 0;
        this.listenerManager = new StreamCompleteListenerManager();
        this.impl = r100;
    }

    private void notifyStreamError(Exception r100) {
        if (this.listenerManager.isComplete() == true) goto L6;
        this.listenerManager.notifyStreamError(new StreamCompleteEvent(this, this.count, r100));
        return;
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void addStreamCompleteListener(StreamCompleteListener r100) {
        this.listenerManager.addStreamCompleteListener(r100);
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void removeStreamCompleteListener(StreamCompleteListener r100) {
        this.listenerManager.removeStreamCompleteListener(r100);
    }

    @Override // java.io.OutputStream
    public void write(int r100) throws IOException {
        this.impl.write(r100);     // Catch: IOException -> L4
        this.count++;     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        notifyStreamError(e);
        throw e;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100) throws IOException {
        this.impl.write(r100);     // Catch: IOException -> L4
        this.count += (long) r100.length;     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        notifyStreamError(e);
        throw e;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        this.impl.write(r100, r101, r102);     // Catch: IOException -> L4
        this.count += (long) r102;     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        notifyStreamError(e);
        throw e;
    }
}
