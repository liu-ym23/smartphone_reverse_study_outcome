package com.bytedance.apm.agent.instrumentation.io;

import java.util.EventObject;

/* JADX INFO: loaded from: classes14.dex */
public final class StreamCompleteEvent extends EventObject {
    private static final long serialVersionUID = 1;
    private final long bytes;
    private final Exception exception;

    public boolean isError() {
        if (this.exception == null) goto L5;
        return true;
    L5:
        return false;
    }

    public long getBytes() {
        return this.bytes;
    }

    public Exception getException() {
        return this.exception;
    }

    public StreamCompleteEvent(Object r100, long r101) {
        this(r100, r101, null);
    }

    public StreamCompleteEvent(Object r100, long r101, Exception r102) {
        super(r100);
        this.bytes = r101;
        this.exception = r102;
    }
}
