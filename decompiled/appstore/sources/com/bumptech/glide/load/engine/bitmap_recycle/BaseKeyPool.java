package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseKeyPool<T extends Poolable> {
    private static final int MAX_SIZE = 20;
    private final Queue<T> keyPool;

    public BaseKeyPool() {
        this.keyPool = Util.createQueue(20);
    }

    public abstract T create();

    public T get() {
        T r10 = this.keyPool.poll();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return (T) create();
    }

    public void offer(T r10) {
        if (this.keyPool.size() >= 20) goto L6;
        this.keyPool.offer(r10);
        return;
    }
}
