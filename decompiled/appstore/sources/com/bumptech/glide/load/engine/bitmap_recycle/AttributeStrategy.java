package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import com.tmall.wireless.tangram.structure.card.FixCard;

/* JADX INFO: loaded from: classes.dex */
class AttributeStrategy implements LruPoolStrategy {
    private final GroupedLinkedMap<Key, Bitmap> groupedMap;
    private final KeyPool keyPool;

    @VisibleForTesting
    public static class Key implements Poolable {
        private Bitmap.Config config;
        private int height;
        private final KeyPool pool;
        private int width;

        public Key(KeyPool r10) {
            this.pool = r10;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof Key) == false) goto L12;
            Key r11 = (Key) r10;
            if (this.width == r11.width) goto L7;
            return false;
        L7:
            if (this.height == r11.height) goto L9;
            return false;
        L9:
            if (this.config != r11.config) goto L15;
            return true;
        L15:
            return false;
        L12:
            return false;
        }

        public int hashCode() {
            int r10 = ((this.width * 31) + this.height) * 31;
            Bitmap.Config r11 = this.config;
            if (r11 == null) goto L5;
            int r12 = r11.hashCode();
        L7:
            return r10 + r12;
        L5:
            r12 = 0;
            goto L7
        }

        public void init(int r10, int r11, Bitmap.Config r12) {
            this.width = r10;
            this.height = r11;
            this.config = r12;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return AttributeStrategy.getBitmapString(this.width, this.height, this.config);
        }
    }

    @VisibleForTesting
    public static class KeyPool extends BaseKeyPool<Key> {
        public KeyPool() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public /* bridge */ /* synthetic */ Poolable create() {
            return create();
        }

        public Key get(int r10, int r11, Bitmap.Config r12) {
            Key r13 = get();
            r13.init(r10, r11, r12);
            return r13;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }
    }

    public AttributeStrategy() {
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap();
    }

    private static String getBitmapString(Bitmap r10) {
        return getBitmapString(r10.getWidth(), r10.getHeight(), r10.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int r10, int r11, Bitmap.Config r12) {
        Key r13 = this.keyPool.get(r10, r11, r12);
        return this.groupedMap.get(r13);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap r10) {
        return Util.getBitmapByteSize(r10);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap r10) {
        return getBitmapString(r10);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap r10) {
        Key r11 = this.keyPool.get(r10.getWidth(), r10.getHeight(), r10.getConfig());
        this.groupedMap.put(r11, r10);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        return this.groupedMap.removeLast();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.groupedMap;
    }

    public static String getBitmapString(int r10, int r11, Bitmap.Config r12) {
        return "[" + r10 + FixCard.FixStyle.KEY_X + r11 + "], " + r12;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int r10, int r11, Bitmap.Config r12) {
        return getBitmapString(r10, r11, r12);
    }
}
