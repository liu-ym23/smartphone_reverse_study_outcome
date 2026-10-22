package com.jeffmony.async.future;

/* JADX INFO: loaded from: classes3.dex */
public interface Cancellable {
    boolean cancel();

    boolean isCancelled();

    boolean isDone();
}
