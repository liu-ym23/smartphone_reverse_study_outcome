package com.stepos.alphame.utils.pool.bitmap;

import com.stepos.alphame.utils.pool.bitmap.Poolable;
import java.util.Queue;

/* loaded from: classes.dex */
abstract class BaseKeyPool<T extends Poolable> {
    private static final int MAX_SIZE = 20;
    private final Queue<T> keyPool = Util.createQueue(20);

    public abstract T create();

    public T get() {
        T tPoll = this.keyPool.poll();
        return tPoll == null ? (T) create() : tPoll;
    }

    public void offer(T t4) {
        if (this.keyPool.size() < 20) {
            this.keyPool.offer(t4);
        }
    }
}
