package com.stepos.alphame.listener;

/* loaded from: classes.dex */
public interface Future<T> {
    T get();

    boolean isDone();

    void waitDone();
}
