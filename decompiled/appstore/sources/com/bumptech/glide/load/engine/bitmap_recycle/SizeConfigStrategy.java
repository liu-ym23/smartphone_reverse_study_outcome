package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
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
            int[] r10 = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = r10;
            r10[Bitmap.Config.ARGB_8888.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    @VisibleForTesting
    public static final class Key implements Poolable {
        private Bitmap.Config config;
        private final KeyPool pool;
        int size;

        public Key(KeyPool r10) {
            this.pool = r10;
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof Key) == false) goto L10;
            Key r11 = (Key) r10;
            if (this.size == r11.size) goto L7;
            return false;
        L7:
            if (Util.bothNullOrEqual(this.config, r11.config) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r10 = this.size * 31;
            Bitmap.Config r11 = this.config;
            if (r11 == null) goto L5;
            int r12 = r11.hashCode();
        L7:
            return r10 + r12;
        L5:
            r12 = 0;
            goto L7
        }

        public void init(int r10, Bitmap.Config r11) {
            this.size = r10;
            this.config = r11;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return SizeConfigStrategy.getBitmapString(this.size, this.config);
        }

        @VisibleForTesting
        public Key(KeyPool r10, int r11, Bitmap.Config r12) {
            this(r10);
            init(r11, r12);
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

        public Key get(int r10, Bitmap.Config r11) {
            Key r12 = get();
            r12.init(r10, r11);
            return r12;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }
    }

    static {
        Bitmap.Config[] r10 = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        r10[r10.length - 1] = Bitmap.Config.RGBA_F16;
        ARGB_8888_IN_CONFIGS = r10;
        RGBA_F16_IN_CONFIGS = r10;
        RGB_565_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        ARGB_4444_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        ALPHA_8_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public SizeConfigStrategy() {
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap();
        this.sortedSizes = new HashMap();
    }

    private void decrementBitmapOfSize(Integer r10, Bitmap r11) {
        NavigableMap<Integer, Integer> r12 = getSizesForConfig(r11.getConfig());
        Integer r13 = (Integer) r12.get(r10);
        if (r13 == null) goto L10;
        if (r13.intValue() != 1) goto L7;
        r12.remove(r10);
        return;
    L7:
        r12.put(r10, Integer.valueOf(r13.intValue() - 1));
        return;
    L10:
        throw new NullPointerException("Tried to decrement empty size, size: " + r10 + ", removed: " + logBitmap(r11) + ", this: " + this);
    }

    private Key findBestKey(int r10, Bitmap.Config r11) {
        Key r12 = this.keyPool.get(r10, r11);
        Bitmap.Config[] r13 = getInConfigs(r11);
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L24;
        Bitmap.Config r16 = r13[r15];
        Integer r17 = getSizesForConfig(r16).ceilingKey(Integer.valueOf(r10));
        if (r17 == null) goto L16;
        if (r17.intValue() > (r10 * 8)) goto L16;
        if (r17.intValue() != r10) goto L15;
        if (r16 != null) goto L14;
        if (r11 != null) goto L15;
        return r12;
    L14:
        if (r16.equals(r11) == false) goto L15;
        return r12;
    L15:
        this.keyPool.offer(r12);
        return this.keyPool.get(r17.intValue(), r16);
    L16:
        r15 = r15 + 1;
        goto L3
    L24:
        return r12;
    }

    public static String getBitmapString(int r10, Bitmap.Config r11) {
        return "[" + r10 + "](" + r11 + ")";
    }

    private static Bitmap.Config[] getInConfigs(Bitmap.Config r10) {
        if (Bitmap.Config.RGBA_F16.equals(r10) == true) goto L5;
        int r11 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[r10.ordinal()];
        if (r11 == 1) goto L23;
        if (r11 == 2) goto L21;
        if (r11 == 3) goto L19;
        if (r11 == 4) goto L17;
        return new Bitmap.Config[]{r10};
    L17:
        return ALPHA_8_IN_CONFIGS;
    L19:
        return ARGB_4444_IN_CONFIGS;
    L21:
        return RGB_565_IN_CONFIGS;
    L23:
        return ARGB_8888_IN_CONFIGS;
    L5:
        return RGBA_F16_IN_CONFIGS;
    }

    private NavigableMap<Integer, Integer> getSizesForConfig(Bitmap.Config r10) {
        NavigableMap<Integer, Integer> r11 = this.sortedSizes.get(r10);
        if (r11 != null) goto L6;
        TreeMap r12 = new TreeMap();
        this.sortedSizes.put(r10, r12);
        return r12;
    L6:
        return r11;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    @Nullable
    public Bitmap get(int r10, int r11, Bitmap.Config r12) {
        Key r13 = findBestKey(Util.getBitmapByteSize(r10, r11, r12), r12);
        Bitmap r14 = this.groupedMap.get(r13);
        if (r14 == null) goto L5;
        decrementBitmapOfSize(Integer.valueOf(r13.size), r14);
        r14.reconfigure(r10, r11, r12);
    L5:
        return r14;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap r10) {
        return Util.getBitmapByteSize(r10);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap r10) {
        return getBitmapString(Util.getBitmapByteSize(r10), r10.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap r10) {
        int r11 = Util.getBitmapByteSize(r10);
        Key r12 = this.keyPool.get(r11, r10.getConfig());
        this.groupedMap.put(r12, r10);
        NavigableMap<Integer, Integer> r13 = getSizesForConfig(r10.getConfig());
        Integer r14 = (Integer) r13.get(Integer.valueOf(r12.size));
        Integer r15 = Integer.valueOf(r12.size);
        int r16 = 1;
        if (r14 == null) goto L6;
        r16 = 1 + r14.intValue();
    L6:
        r13.put(r15, Integer.valueOf(r16));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    @Nullable
    public Bitmap removeLast() {
        Bitmap r10 = this.groupedMap.removeLast();
        if (r10 == null) goto L5;
        decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(r10)), r10);
    L5:
        return r10;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append("SizeConfigStrategy{groupedMap=");
        r10.append(this.groupedMap);
        r10.append(", sortedSizes=(");
        Iterator<Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>>> r11 = this.sortedSizes.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> r12 = r11.next();
        r10.append(r12.getKey());
        r10.append('[');
        r10.append(r12.getValue());
        r10.append("], ");
        goto L4
    L7:
        if (this.sortedSizes.isEmpty() == true) goto L9;
        r10.replace(r10.length() - 2, r10.length(), "");
    L9:
        r10.append(")}");
        return r10.toString();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int r10, int r11, Bitmap.Config r12) {
        return getBitmapString(Util.getBitmapByteSize(r10, r11, r12), r12);
    }
}
