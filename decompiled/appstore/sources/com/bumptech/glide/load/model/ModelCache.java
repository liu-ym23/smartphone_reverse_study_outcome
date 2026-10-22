package com.bumptech.glide.load.model;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final LruCache<ModelKey<A>, B> cache;

    @VisibleForTesting
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

        public static <A> ModelKey<A> get(A r10, int r11, int r12) {
            Queue<ModelKey<?>> r13 = KEY_QUEUE;
            monitor-enter(r13);
            ModelKey<A> r14 = (ModelKey) r13.poll();     // Catch: Throwable -> L10
            monitor-exit(r13);     // Catch: Throwable -> L10
            if (r14 != null) goto L8;
            r14 = new ModelKey();
        L8:
            r14.init(r10, r11, r12);
            return r14;
        L10:
            th = move-exception;
            throw th;
        }

        private void init(A r10, int r11, int r12) {
            this.model = r10;
            this.width = r11;
            this.height = r12;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof ModelKey) == false) goto L12;
            ModelKey r11 = (ModelKey) r10;
            if (this.width == r11.width) goto L7;
            return false;
        L7:
            if (this.height == r11.height) goto L9;
            return false;
        L9:
            if (this.model.equals(r11.model) == false) goto L15;
            return true;
        L15:
            return false;
        L12:
            return false;
        }

        public int hashCode() {
            return (((this.height * 31) + this.width) * 31) + this.model.hashCode();
        }

        public void release() {
            Queue<ModelKey<?>> r10 = KEY_QUEUE;
            monitor-enter(r10);
            r10.offer(this);     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public ModelCache() {
        this(250);
    }

    public void clear() {
        this.cache.clearMemory();
    }

    @Nullable
    public B get(A r10, int r11, int r12) {
        ModelKey<A> r13 = ModelKey.get(r10, r11, r12);
        B r14 = this.cache.get(r13);
        r13.release();
        return r14;
    }

    public void put(A r10, int r11, int r12, B r13) {
        ModelKey<A> r14 = ModelKey.get(r10, r11, r12);
        this.cache.put(r14, r13);
    }

    public ModelCache(final long r10) {
        this.cache = new AnonymousClass1(this, r10);
    }
}
