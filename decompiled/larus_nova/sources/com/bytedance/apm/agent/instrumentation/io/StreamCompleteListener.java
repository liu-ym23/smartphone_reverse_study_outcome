package com.bytedance.apm.agent.instrumentation.io;

/* JADX INFO: loaded from: classes14.dex */
public interface StreamCompleteListener {
    void streamComplete(StreamCompleteEvent r100);

    void streamError(StreamCompleteEvent r100);
}
