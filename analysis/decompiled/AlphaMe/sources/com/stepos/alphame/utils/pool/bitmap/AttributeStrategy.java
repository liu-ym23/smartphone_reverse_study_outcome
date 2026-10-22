package com.stepos.alphame.utils.pool.bitmap;

import B0.g;
import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class AttributeStrategy implements LruPoolStrategy {
    private final KeyPool keyPool = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap<>();

    public static class Key implements Poolable {
        private Bitmap.Config config;
        private int height;
        private final KeyPool pool;
        private int width;

        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.width == key.width && this.height == key.height && this.config == key.config;
        }

        public int hashCode() {
            int i4 = ((this.width * 31) + this.height) * 31;
            Bitmap.Config config = this.config;
            return i4 + (config != null ? config.hashCode() : 0);
        }

        public void init(int i4, int i5, Bitmap.Config config) {
            this.width = i4;
            this.height = i5;
            this.config = config;
        }

        @Override // com.stepos.alphame.utils.pool.bitmap.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return AttributeStrategy.getBitmapString(this.width, this.height, this.config);
        }
    }

    public static class KeyPool extends BaseKeyPool<Key> {
        public Key get(int i4, int i5, Bitmap.Config config) {
            Key key = get();
            key.init(i4, i5, config);
            return key;
        }

        @Override // com.stepos.alphame.utils.pool.bitmap.BaseKeyPool
        public Key create() {
            return new Key(this);
        }
    }

    private static String getBitmapString(Bitmap bitmap) {
        return getBitmapString(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.LruPoolStrategy
    public Bitmap get(int i4, int i5, Bitmap.Config config) {
        return this.groupedMap.get(this.keyPool.get(i4, i5, config));
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.LruPoolStrategy
    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.LruPoolStrategy
    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(bitmap);
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.LruPoolStrategy
    public void put(Bitmap bitmap) {
        this.groupedMap.put(this.keyPool.get(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.LruPoolStrategy
    public Bitmap removeLast() {
        return this.groupedMap.removeLast();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.groupedMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getBitmapString(int i4, int i5, Bitmap.Config config) {
        StringBuilder sbU = g.u("[", i4, "x", i5, "], ");
        sbU.append(config);
        return sbU.toString();
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.LruPoolStrategy
    public String logBitmap(int i4, int i5, Bitmap.Config config) {
        return getBitmapString(i4, i5, config);
    }
}
