package com.bumptech.glide.request;

/* JADX INFO: loaded from: classes39.dex */
public interface Request {
    void begin();

    void clear();

    boolean isAnyResourceSet();

    boolean isCleared();

    boolean isComplete();

    boolean isEquivalentTo(Request r100);

    boolean isRunning();

    void pause();
}
