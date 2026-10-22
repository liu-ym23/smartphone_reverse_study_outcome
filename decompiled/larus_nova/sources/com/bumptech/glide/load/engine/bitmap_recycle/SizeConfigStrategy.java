package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes39.dex */
public class SizeConfigStrategy implements LruPoolStrategy {
    private static final Bitmap.Config[] ALPHA_8_IN_CONFIGS = null;
    private static final Bitmap.Config[] ARGB_4444_IN_CONFIGS = null;
    private static final Bitmap.Config[] ARGB_8888_IN_CONFIGS = null;
    private static final int MAX_SIZE_MULTIPLE = 8;
    private static final Bitmap.Config[] RGBA_F16_IN_CONFIGS = null;
    private static final Bitmap.Config[] RGB_565_IN_CONFIGS = null;
    private final GroupedLinkedMap<Key, Bitmap> groupedMap;
    private final KeyPool keyPool;
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> sortedSizes;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = null;

        static {
            int[] r100 = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = r100;
            r100[Bitmap.Config.ARGB_8888.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final class Key implements Poolable {
        private Bitmap.Config config;
        private final KeyPool pool;
        int size;

        public int hashCode() {
            int r100 = this.size * 31;
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
            return SizeConfigStrategy.getBitmapString(this.size, this.config);
        }

        public Key(KeyPool r100) {
            this.pool = r100;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof Key) == false) goto L10;
            Key r101 = (Key) r100;
            if (this.size == r101.size) goto L7;
            return false;
        L7:
            if (Util.bothNullOrEqual(this.config, r101.config) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public void init(int r100, Bitmap.Config r101) {
            this.size = r100;
            this.config = r101;
        }

        public Key(KeyPool r100, int r101, Bitmap.Config r102) {
            this(r100);
            init(r101, r102);
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

        public Key get(int r100, Bitmap.Config r101) {
            Key r102 = get();
            r102.init(r100, r101);
            return r102;
        }
    }

    static {
        Bitmap.Config[] r100 = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r100 = (Bitmap.Config[]) Arrays.copyOf(r100, 3);
        r100[r100.length - 1] = Bitmap.Config.RGBA_F16;
    L5:
        ARGB_8888_IN_CONFIGS = r100;
        RGBA_F16_IN_CONFIGS = r100;
        RGB_565_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        ARGB_4444_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        ALPHA_8_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        Bitmap r100 = this.groupedMap.removeLast();
        if (r100 == null) goto L5;
        decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(r100)), r100);
    L5:
        return r100;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append("SizeConfigStrategy{groupedMap=");
        r100.append(this.groupedMap);
        r100.append(", sortedSizes=(");
        Iterator<Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>>> r101 = this.sortedSizes.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> r102 = r101.next();
        r100.append(r102.getKey());
        r100.append('[');
        r100.append(r102.getValue());
        r100.append("], ");
        goto L4
    L7:
        if (this.sortedSizes.isEmpty() == true) goto L9;
        r100.replace(r100.length() - 2, r100.length(), "");
    L9:
        r100.append(")}");
        return r100.toString();
    }

    public SizeConfigStrategy() {
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap();
        this.sortedSizes = new HashMap();
    }

    private static Bitmap.Config[] getInConfigs(Bitmap.Config r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
    L8:
        int r101 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[r100.ordinal()];
        if (r101 == 1) goto L25;
        if (r101 == 2) goto L23;
        if (r101 == 3) goto L21;
        if (r101 == 4) goto L19;
        return new Bitmap.Config[]{r100};
    L19:
        return ALPHA_8_IN_CONFIGS;
    L21:
        return ARGB_4444_IN_CONFIGS;
    L23:
        return RGB_565_IN_CONFIGS;
    L25:
        return ARGB_8888_IN_CONFIGS;
    L5:
        if (Bitmap.Config.RGBA_F16.equals(r100) == false) goto L8;
        return RGBA_F16_IN_CONFIGS;
    }

    private NavigableMap<Integer, Integer> getSizesForConfig(Bitmap.Config r100) {
        NavigableMap<Integer, Integer> r101 = this.sortedSizes.get(r100);
        if (r101 != null) goto L6;
        TreeMap r102 = new TreeMap();
        this.sortedSizes.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap r100) {
        return Util.getBitmapByteSize(r100);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap r100) {
        return getBitmapString(Util.getBitmapByteSize(r100), r100.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap r100) {
        int r101 = Util.getBitmapByteSize(r100);
        Key r102 = this.keyPool.get(r101, r100.getConfig());
        this.groupedMap.put(r102, r100);
        NavigableMap<Integer, Integer> r103 = getSizesForConfig(r100.getConfig());
        Integer r104 = (Integer) r103.get(Integer.valueOf(r102.size));
        Integer r105 = Integer.valueOf(r102.size);
        int r106 = 1;
        if (r104 == null) goto L6;
        r106 = 1 + r104.intValue();
    L6:
        r103.put(r105, Integer.valueOf(r106));
    }

    private void decrementBitmapOfSize(Integer r100, Bitmap r101) {
        NavigableMap<Integer, Integer> r102 = getSizesForConfig(r101.getConfig());
        Integer r103 = (Integer) r102.get(r100);
        if (r103 == null) goto L10;
        if (r103.intValue() != 1) goto L7;
        r102.remove(r100);
        return;
    L7:
        r102.put(r100, Integer.valueOf(r103.intValue() - 1));
        return;
    L10:
        throw new NullPointerException("Tried to decrement empty size, size: " + r100 + ", removed: " + logBitmap(r101) + ", this: " + this);
    }

    private Key findBestKey(int r100, Bitmap.Config r110) {
        Key r101 = this.keyPool.get(r100, r110);
        Bitmap.Config[] r102 = getInConfigs(r110);
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L24;
        Bitmap.Config r105 = r102[r104];
        Integer r106 = getSizesForConfig(r105).ceilingKey(Integer.valueOf(r100));
        if (r106 == null) goto L16;
        if (r106.intValue() > (r100 * 8)) goto L16;
        if (r106.intValue() != r100) goto L15;
        if (r105 != null) goto L14;
        if (r110 != null) goto L15;
        return r101;
    L14:
        if (r105.equals(r110) == false) goto L15;
        return r101;
    L15:
        this.keyPool.offer(r101);
        return this.keyPool.get(r106.intValue(), r105);
    L16:
        r104 = r104 + 1;
        goto L3
    L24:
        return r101;
    }

    public static String getBitmapString(int r100, Bitmap.Config r101) {
        return "[" + r100 + "](" + r101 + ")";
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int r100, int r101, Bitmap.Config r102) {
        Key r103 = findBestKey(Util.getBitmapByteSize(r100, r101, r102), r102);
        Bitmap r104 = this.groupedMap.get(r103);
        if (r104 == null) goto L5;
        decrementBitmapOfSize(Integer.valueOf(r103.size), r104);
        r104.reconfigure(r100, r101, r102);
    L5:
        return r104;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int r100, int r101, Bitmap.Config r102) {
        return getBitmapString(Util.getBitmapByteSize(r100, r101, r102), r102);
    }
}
