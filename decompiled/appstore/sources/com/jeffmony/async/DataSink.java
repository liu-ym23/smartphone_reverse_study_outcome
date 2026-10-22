package com.jeffmony.async;

import com.jeffmony.async.callback.CompletedCallback;
import com.jeffmony.async.callback.WritableCallback;

/* JADX INFO: loaded from: classes3.dex */
public interface DataSink {
    void end();

    CompletedCallback getClosedCallback();

    AsyncServer getServer();

    WritableCallback getWriteableCallback();

    boolean isOpen();

    void setClosedCallback(CompletedCallback r10);

    void setWriteableCallback(WritableCallback r10);

    void write(b r10);
}
