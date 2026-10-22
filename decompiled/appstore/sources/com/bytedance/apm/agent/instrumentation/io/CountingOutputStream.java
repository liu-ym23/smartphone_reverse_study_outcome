package com.bytedance.apm.agent.instrumentation.io;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class CountingOutputStream extends OutputStream implements StreamCompleteListenerSource {
    private long count;
    private final OutputStream impl;
    private final StreamCompleteListenerManager listenerManager;

    public CountingOutputStream(OutputStream r10) {
        this.count = 0;
        this.listenerManager = new StreamCompleteListenerManager();
        this.impl = r10;
    }

    private void notifyStreamComplete() {
        if (this.listenerManager.isComplete() == true) goto L6;
        this.listenerManager.notifyStreamComplete(new StreamCompleteEvent(this, this.count));
        return;
    }

    private void notifyStreamError(Exception r10) {
        if (this.listenerManager.isComplete() == true) goto L6;
        this.listenerManager.notifyStreamError(new StreamCompleteEvent(this, this.count, r10));
        return;
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void addStreamCompleteListener(StreamCompleteListener r10) {
        this.listenerManager.addStreamCompleteListener(r10);
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

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void removeStreamCompleteListener(StreamCompleteListener r10) {
        this.listenerManager.removeStreamCompleteListener(r10);
    }

    @Override // java.io.OutputStream
    public void write(int r10) throws IOException {
        this.impl.write(r10);     // Catch: IOException -> L4
        this.count++;     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        notifyStreamError(e);
        throw e;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r10) throws IOException {
        this.impl.write(r10);     // Catch: IOException -> L4
        this.count += (long) r10.length;     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        notifyStreamError(e);
        throw e;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r10, int r11, int r12) throws IOException {
        this.impl.write(r10, r11, r12);     // Catch: IOException -> L4
        this.count += (long) r12;     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        notifyStreamError(e);
        throw e;
    }
}
