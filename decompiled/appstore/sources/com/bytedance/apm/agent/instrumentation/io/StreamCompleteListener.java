package com.bytedance.apm.agent.instrumentation.io;

/* JADX INFO: loaded from: classes.dex */
public interface StreamCompleteListener {
    void streamComplete(StreamCompleteEvent r10);

    void streamError(StreamCompleteEvent r10);
}
