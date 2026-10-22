package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;
import java.util.NavigableMap;

/* JADX INFO: loaded from: classes39.dex */
final class SizeStrategy implements LruPoolStrategy {
    private static final int MAX_SIZE_MULTIPLE = 8;
    private final GroupedLinkedMap<Key, Bitmap> groupedMap;
    private final KeyPool keyPool;
    private final NavigableMap<Integer, Integer> sortedSizes;

    public static final class Key implements Poolable {
        private final KeyPool pool;
        int size;

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return SizeStrategy.getBitmapString(this.size);
        }

        public int hashCode() {
            return this.size;
        }

        public Key(KeyPool r100) {
            this.pool = r100;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof Key) == true) goto L5;
            return false;
        L5:
            if (this.size != ((Key) r100).size) goto L9;
            return true;
        L9:
            return false;
        }

        public void init(int r100) {
            this.size = r100;
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

        public Key get(int r100) {
            Key r101 = (Key) super.get();
            r101.init(r100);
            return r101;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        Bitmap r100 = this.groupedMap.removeLast();
        if (r100 == null) goto L5;
        decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(r100)));
    L5:
        return r100;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.groupedMap + "\n  SortedSizes" + this.sortedSizes;
    }

    public SizeStrategy() {
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap();
        this.sortedSizes = new PrettyPrintTreeMap();
    }

    private void decrementBitmapOfSize(Integer r100) {
        Integer r101 = (Integer) this.sortedSizes.get(r100);
        if (r101.intValue() != 1) goto L5;
        this.sortedSizes.remove(r100);
        return;
    L5:
        this.sortedSizes.put(r100, Integer.valueOf(r101.intValue() - 1));
    }

    public static String getBitmapString(int r100) {
        return "[" + r100 + "]";
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
        int r101 = Util.getBitmapByteSize(r100);
        Key r102 = this.keyPool.get(r101);
        this.groupedMap.put(r102, r100);
        Integer r103 = (Integer) this.sortedSizes.get(Integer.valueOf(r102.size));
        NavigableMap<Integer, Integer> r104 = this.sortedSizes;
        Integer r105 = Integer.valueOf(r102.size);
        int r106 = 1;
        if (r103 == null) goto L6;
        r106 = 1 + r103.intValue();
    L6:
        r104.put(r105, Integer.valueOf(r106));
    }

    private static String getBitmapString(Bitmap r100) {
        return getBitmapString(Util.getBitmapByteSize(r100));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int r100, int r101, Bitmap.Config r102) {
        int r103 = Util.getBitmapByteSize(r100, r101, r102);
        Key r104 = this.keyPool.get(r103);
        Integer r105 = this.sortedSizes.ceilingKey(Integer.valueOf(r103));
        if (r105 != null) goto L5;
    L9:
        Bitmap r106 = this.groupedMap.get(r104);
        if (r106 == null) goto L12;
        r106.reconfigure(r100, r101, r102);
        decrementBitmapOfSize(r105);
    L12:
        return r106;
    L5:
        if (r105.intValue() == r103) goto L9;
        if (r105.intValue() > (r103 * 8)) goto L9;
        this.keyPool.offer(r104);
        r104 = this.keyPool.get(r105.intValue());
        goto L9
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int r100, int r101, Bitmap.Config r102) {
        return getBitmapString(Util.getBitmapByteSize(r100, r101, r102));
    }
}
