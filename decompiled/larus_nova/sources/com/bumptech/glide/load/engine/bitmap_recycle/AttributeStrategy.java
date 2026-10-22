package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;

/* JADX INFO: loaded from: classes39.dex */
class AttributeStrategy implements LruPoolStrategy {
    private final GroupedLinkedMap<Key, Bitmap> groupedMap;
    private final KeyPool keyPool;

    public static class Key implements Poolable {
        private Bitmap.Config config;
        private int height;
        private final KeyPool pool;
        private int width;

        public int hashCode() {
            int r100 = ((this.width * 31) + this.height) * 31;
            Bitmap.Config r101 = this.config;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return AttributeStrategy.getBitmapString(this.width, this.height, this.config);
        }

        public Key(KeyPool r100) {
            this.pool = r100;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof Key) == false) goto L12;
            Key r101 = (Key) r100;
            if (this.width == r101.width) goto L7;
            return false;
        L7:
            if (this.height == r101.height) goto L9;
            return false;
        L9:
            if (this.config != r101.config) goto L15;
            return true;
        L15:
            return false;
        L12:
            return false;
        }

        public void init(int r100, int r101, Bitmap.Config r102) {
            this.width = r100;
            this.height = r101;
            this.config = r102;
        }
    }

    public static class KeyPool extends BaseKeyPool<Key> {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }

        public KeyPool() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public /* bridge */ /* synthetic */ Poolable create() {
            return create();
        }

        public Key get(int r100, int r101, Bitmap.Config r102) {
            Key r103 = get();
            r103.init(r100, r101, r102);
            return r103;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        return this.groupedMap.removeLast();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.groupedMap;
    }

    public AttributeStrategy() {
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap();
    }

    private static String getBitmapString(Bitmap r100) {
        return getBitmapString(r100.getWidth(), r100.getHeight(), r100.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap r100) {
        return Util.getBitmapByteSize(r100);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap r100) {
        return getBitmapString(r100);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap r100) {
        Key r101 = this.keyPool.get(r100.getWidth(), r100.getHeight(), r100.getConfig());
        this.groupedMap.put(r101, r100);
    }

    public static String getBitmapString(int r100, int r101, Bitmap.Config r102) {
        return "[" + r100 + "x" + r101 + "], " + r102;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int r100, int r101, Bitmap.Config r102) {
        Key r103 = this.keyPool.get(r100, r101, r102);
        return this.groupedMap.get(r103);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int r100, int r101, Bitmap.Config r102) {
        return getBitmapString(r100, r101, r102);
    }
}
