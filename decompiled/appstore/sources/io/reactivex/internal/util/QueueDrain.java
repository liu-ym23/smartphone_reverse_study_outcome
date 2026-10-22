package io.reactivex.internal.util;

import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public interface QueueDrain<T, U> {
    boolean accept(Subscriber<? super U> r10, T r11);

    boolean cancelled();

    boolean done();

    boolean enter();

    Throwable error();

    int leave(int r10);

    long produced(long r10);

    long requested();
}
