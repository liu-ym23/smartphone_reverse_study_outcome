package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* JADX INFO: loaded from: classes39.dex */
public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final LruCache<ModelKey<A>, B> cache;

    public static final class ModelKey<A> {
        private static final Queue<ModelKey<?>> KEY_QUEUE = null;
        private int height;
        private A model;
        private int width;

        static {
            KEY_QUEUE = Util.createQueue(0);
        }

        private ModelKey() {
        }

        public int hashCode() {
            return (((this.height * 31) + this.width) * 31) + this.model.hashCode();
        }

        public void release() {
            Queue<ModelKey<?>> r100 = KEY_QUEUE;
            monitor-enter(r100);
            r100.offer(this);     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof ModelKey) == false) goto L12;
            ModelKey r101 = (ModelKey) r100;
            if (this.width == r101.width) goto L7;
            return false;
        L7:
            if (this.height == r101.height) goto L9;
            return false;
        L9:
            if (this.model.equals(r101.model) == false) goto L15;
            return true;
        L15:
            return false;
        L12:
            return false;
        }

        public static <A> ModelKey<A> get(A r100, int r101, int r102) {
            Queue<ModelKey<?>> r103 = KEY_QUEUE;
            monitor-enter(r103);
            ModelKey<A> r104 = (ModelKey) r103.poll();     // Catch: Throwable -> L10
            monitor-exit(r103);     // Catch: Throwable -> L10
            if (r104 != null) goto L8;
            r104 = new ModelKey();
        L8:
            r104.init(r100, r101, r102);
            return r104;
        L10:
            th = move-exception;
            throw th;
        }

        private void init(A r100, int r101, int r102) {
            this.model = r100;
            this.width = r101;
            this.height = r102;
        }
    }

    public ModelCache() {
        this(250);
    }

    public void clear() {
        this.cache.clearMemory();
    }

    public ModelCache(final long r100) {
        this.cache = new AnonymousClass1(this, r100);
    }

    public B get(A r100, int r101, int r102) {
        ModelKey<A> r103 = ModelKey.get(r100, r101, r102);
        B r104 = this.cache.get(r103);
        r103.release();
        return r104;
    }

    public void put(A r100, int r101, int r102, B r103) {
        ModelKey<A> r104 = ModelKey.get(r100, r101, r102);
        this.cache.put(r104, r103);
    }
}
