package com.byted.cast.common.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes39.dex */
public interface Subject<T> {
    Subject addObserver(Observer<T> r100);

    void clearObservers();

    void dispose();

    void notifyException(Exception r100);

    void notifyObserver(T r100);

    void removeObserver(Observer<T> r100);

    Subject setExecutor(ExecutorService r100);

    Subject setTimeout(long r100, TimeUnit r101);
}
