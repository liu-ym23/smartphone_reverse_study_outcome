package com.stepos.alphame.utils.pool.bitmap;

import B0.g;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class SizeConfigStrategy implements LruPoolStrategy {
    private static final int MAX_SIZE_MULTIPLE = 8;
    private static final Bitmap.Config[] ARGB_8888_IN_CONFIGS = {Bitmap.Config.ARGB_8888, null};
    private static final Bitmap.Config[] RGB_565_IN_CONFIGS = {Bitmap.Config.RGB_565};
    private static final Bitmap.Config[] ARGB_4444_IN_CONFIGS = {Bitmap.Config.ARGB_4444};
    private static final Bitmap.Config[] ALPHA_8_IN_CONFIGS = {Bitmap.Config.ALPHA_8};
    private final KeyPool keyPool = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> sortedSizes = new HashMap();

    /* renamed from: com.stepos.alphame.utils.pool.bitmap.SizeConfigStrategy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class KeyPool extends BaseKeyPool<Key> {
        public Key get(int i4, Bitmap.Config config) {
            Key key = get();
            key.init(i4, config);
            return key;
        }

        @Override // com.stepos.alphame.utils.pool.bitmap.BaseKeyPool
        public Key create() {
            return new Key(this);
        }
    }

    private void decrementBitmapOfSize(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(bitmap.getConfig());
        Integer num2 = sizesForConfig.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                sizesForConfig.remove(num);
                return;
            } else {
                sizesForConfig.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new IllegalStateException("Tried to decrement empty size, size: " + num + ", removed: " + logBitmap(bitmap) + ", this: " + this);
    }

    private Key findBestKey(int i4, Bitmap.Config config) {
        Key key = this.keyPool.get(i4, config);
        for (Bitmap.Config config2 : getInConfigs(config)) {
            Integer numCeilingKey = getSizesForConfig(config2).ceilingKey(Integer.valueOf(i4));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i4 * 8) {
                if (numCeilingKey.intValue() == i4) {
                    if (config2 == null) {
                        if (config == null) {
                            return key;
                        }
                    } else if (config2.equals(config)) {
                        return key;
                    }
                }
                this.keyPool.offer(key);
                return this.keyPool.get(numCeilingKey.intValue(), config2);
            }
        }
        return key;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getBitmapString(int i4, Bitmap.Config config) {
        return "[" + i4 + "](" + config + ")";
    }

    private static Bitmap.Config[] getInConfigs(Bitmap.Config config) {
        int i4 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? new Bitmap.Config[]{config} : ALPHA_8_IN_CONFIGS : ARGB_4444_IN_CONFIGS : RGB_565_IN_CONFIGS : ARGB_8888_IN_CONFIGS;
    }

    private NavigableMap<Integer, Integer> getSizesForConfig(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.sortedSizes.put(config, treeMap);
        return treeMap;
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.LruPoolStrategy
    public Bitmap get(int i4, int i5, Bitmap.Config config) {
        Key keyFindBestKey = findBestKey(Util.getBitmapByteSize(i4, i5, config), config);
        Bitmap bitmap = this.groupedMap.get(keyFindBestKey);
        if (bitmap != null) {
            decrementBitmapOfSize(Integer.valueOf(keyFindBestKey.size), bitmap);
            try {
                bitmap.reconfigure(i4, i5, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
            } catch (IllegalArgumentException unused) {
                StringBuilder sbU = g.u("reconfigure failed.expecting w:", i4, " h:", i5, " config:");
                sbU.append(config);
                sbU.append(" got:");
                sbU.append(logBitmap(bitmap));
                Log.e("SizeConfigStragety", sbU.toString());
                return null;
            }
        }
        return bitmap;
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.LruPoolStrategy
    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.LruPoolStrategy
    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.LruPoolStrategy
    public void put(Bitmap bitmap) {
        Key key = this.keyPool.get(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
        this.groupedMap.put(key, bitmap);
        NavigableMap<Integer, Integer> sizesForConfig = getSizesForConfig(bitmap.getConfig());
        Integer num = sizesForConfig.get(Integer.valueOf(key.size));
        sizesForConfig.put(Integer.valueOf(key.size), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.LruPoolStrategy
    public Bitmap removeLast() {
        Bitmap bitmapRemoveLast = this.groupedMap.removeLast();
        if (bitmapRemoveLast != null) {
            decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(bitmapRemoveLast)), bitmapRemoveLast);
        }
        return bitmapRemoveLast;
    }

    public String toString() {
        StringBuilder sbS = g.s("SizeConfigStrategy{groupedMap=");
        sbS.append(this.groupedMap);
        sbS.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.sortedSizes.entrySet()) {
            sbS.append(entry.getKey());
            sbS.append('[');
            sbS.append(entry.getValue());
            sbS.append("], ");
        }
        if (!this.sortedSizes.isEmpty()) {
            sbS.replace(sbS.length() - 2, sbS.length(), "");
        }
        sbS.append(")}");
        return sbS.toString();
    }

    public static final class Key implements Poolable {
        private Bitmap.Config config;
        private final KeyPool pool;
        private int size;

        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.size == key.size && Util.bothNullOrEqual(this.config, key.config);
        }

        public int hashCode() {
            int i4 = this.size * 31;
            Bitmap.Config config = this.config;
            return i4 + (config != null ? config.hashCode() : 0);
        }

        public void init(int i4, Bitmap.Config config) {
            this.size = i4;
            this.config = config;
        }

        @Override // com.stepos.alphame.utils.pool.bitmap.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return SizeConfigStrategy.getBitmapString(this.size, this.config);
        }

        public Key(KeyPool keyPool, int i4, Bitmap.Config config) {
            this(keyPool);
            init(i4, config);
        }
    }

    @Override // com.stepos.alphame.utils.pool.bitmap.LruPoolStrategy
    public String logBitmap(int i4, int i5, Bitmap.Config config) {
        return getBitmapString(Util.getBitmapByteSize(i4, i5, config), config);
    }
}
