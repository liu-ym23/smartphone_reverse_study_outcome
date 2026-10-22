package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import java.util.NavigableMap;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
final class SizeStrategy implements LruPoolStrategy {
    private static final int MAX_SIZE_MULTIPLE = 8;
    private final GroupedLinkedMap<Key, Bitmap> groupedMap;
    private final KeyPool keyPool;
    private final NavigableMap<Integer, Integer> sortedSizes;

    @VisibleForTesting
    public static final class Key implements Poolable {
        private final KeyPool pool;
        int size;

        public Key(KeyPool r10) {
            this.pool = r10;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof Key) == true) goto L5;
            return false;
        L5:
            if (this.size != ((Key) r10).size) goto L9;
            return true;
        L9:
            return false;
        }

        public int hashCode() {
            return this.size;
        }

        public void init(int r10) {
            this.size = r10;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return SizeStrategy.getBitmapString(this.size);
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

        public Key get(int r10) {
            Key r11 = (Key) super.get();
            r11.init(r10);
            return r11;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }
    }

    public SizeStrategy() {
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap();
        this.sortedSizes = new PrettyPrintTreeMap();
    }

    private void decrementBitmapOfSize(Integer r10) {
        Integer r11 = (Integer) this.sortedSizes.get(r10);
        if (r11.intValue() != 1) goto L5;
        this.sortedSizes.remove(r10);
        return;
    L5:
        this.sortedSizes.put(r10, Integer.valueOf(r11.intValue() - 1));
    }

    private static String getBitmapString(Bitmap r10) {
        return getBitmapString(Util.getBitmapByteSize(r10));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    @Nullable
    public Bitmap get(int r10, int r11, Bitmap.Config r12) {
        int r13 = Util.getBitmapByteSize(r10, r11, r12);
        Key r14 = this.keyPool.get(r13);
        Integer r15 = this.sortedSizes.ceilingKey(Integer.valueOf(r13));
        if (r15 != null) goto L5;
    L9:
        Bitmap r16 = this.groupedMap.get(r14);
        if (r16 == null) goto L12;
        r16.reconfigure(r10, r11, r12);
        decrementBitmapOfSize(r15);
    L12:
        return r16;
    L5:
        if (r15.intValue() == r13) goto L9;
        if (r15.intValue() > (r13 * 8)) goto L9;
        this.keyPool.offer(r14);
        r14 = this.keyPool.get(r15.intValue());
        goto L9
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
        int r11 = Util.getBitmapByteSize(r10);
        Key r12 = this.keyPool.get(r11);
        this.groupedMap.put(r12, r10);
        Integer r13 = (Integer) this.sortedSizes.get(Integer.valueOf(r12.size));
        NavigableMap<Integer, Integer> r14 = this.sortedSizes;
        Integer r15 = Integer.valueOf(r12.size);
        int r16 = 1;
        if (r13 == null) goto L6;
        r16 = 1 + r13.intValue();
    L6:
        r14.put(r15, Integer.valueOf(r16));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    @Nullable
    public Bitmap removeLast() {
        Bitmap r10 = this.groupedMap.removeLast();
        if (r10 == null) goto L5;
        decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(r10)));
    L5:
        return r10;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.groupedMap + "\n  SortedSizes" + this.sortedSizes;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int r10, int r11, Bitmap.Config r12) {
        return getBitmapString(Util.getBitmapByteSize(r10, r11, r12));
    }

    public static String getBitmapString(int r10) {
        return "[" + r10 + "]";
    }
}
