package com.jeffmony.async;

import com.jeffmony.async.callback.CompletedCallback;
import com.jeffmony.async.callback.DataCallback;

/* JADX INFO: loaded from: classes3.dex */
public interface DataEmitter {
    String charset();

    void close();

    DataCallback getDataCallback();

    CompletedCallback getEndCallback();

    AsyncServer getServer();

    boolean isChunked();

    boolean isPaused();

    void pause();

    void resume();

    void setDataCallback(DataCallback r10);

    void setEndCallback(CompletedCallback r10);
}
