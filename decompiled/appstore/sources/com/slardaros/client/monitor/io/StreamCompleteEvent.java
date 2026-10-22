package com.slardaros.client.monitor.io;

import java.util.EventObject;

/* JADX INFO: loaded from: classes4.dex */
public final class StreamCompleteEvent extends EventObject {
    private static final long serialVersionUID = 1;
    private final long bytes;
    private final Exception exception;

    public StreamCompleteEvent(Object r10, long r11, Exception r12) {
        super(r10);
        this.bytes = r11;
        this.exception = r12;
    }

    public long getBytes() {
        return this.bytes;
    }

    public Exception getException() {
        return this.exception;
    }

    public boolean isError() {
        if (this.exception == null) goto L5;
        return true;
    L5:
        return false;
    }

    public StreamCompleteEvent(Object r10, long r11) {
        this(r10, r11, null);
    }
}
