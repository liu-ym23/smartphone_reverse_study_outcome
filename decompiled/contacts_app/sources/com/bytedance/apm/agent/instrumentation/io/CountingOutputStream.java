package com.bytedance.apm.agent.instrumentation.io;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class CountingOutputStream extends OutputStream implements StreamCompleteListenerSource {
    private long count;
    private final OutputStream impl;
    private final StreamCompleteListenerManager listenerManager;

    public CountingOutputStream(OutputStream r3) {
        this.count = 0;
        this.listenerManager = new StreamCompleteListenerManager();
        this.impl = r3;
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void addStreamCompleteListener(StreamCompleteListener r1) {
        this.listenerManager.addStreamCompleteListener(r1);
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void removeStreamCompleteListener(StreamCompleteListener r1) {
        this.listenerManager.removeStreamCompleteListener(r1);
    }

    public long getCount() {
        return this.count;
    }

    @Override // java.io.OutputStream
    public void write(int r5) throws IOException {
        this.impl.write(r5);     // Catch: IOException -> L4
        this.count++;     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        notifyStreamError(e);
        throw e;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r5) throws IOException {
        this.impl.write(r5);     // Catch: IOException -> L4
        this.count += (long) r5.length;     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        notifyStreamError(e);
        throw e;
    }

    @Override // java.io.OutputStream
    public void write(byte[] r3, int r4, int r5) throws IOException {
        this.impl.write(r3, r4, r5);     // Catch: IOException -> L4
        this.count += (long) r5;     // Catch: IOException -> L4
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

    private void notifyStreamComplete() {
        if (this.listenerManager.isComplete() == true) goto L6;
        this.listenerManager.notifyStreamComplete(new StreamCompleteEvent(this, this.count));
        return;
    }

    private void notifyStreamError(Exception r5) {
        if (this.listenerManager.isComplete() == true) goto L6;
        this.listenerManager.notifyStreamError(new StreamCompleteEvent(this, this.count, r5));
        return;
    }
}
