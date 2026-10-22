package ch.qos.logback.classic.turbo;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
class LRUMessageCache extends LinkedHashMap<String, Integer> {
    private static final long serialVersionUID = 1;
    final int cacheSize;

    public LRUMessageCache(int i4) {
        super((int) (i4 * 1.3333334f), 0.75f, true);
        if (i4 < 1) {
            throw new IllegalArgumentException("Cache size cannot be smaller than 1");
        }
        this.cacheSize = i4;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public synchronized void clear() {
        super.clear();
    }

    public int getMessageCountAndThenIncrement(String str) {
        Integer numValueOf;
        if (str == null) {
            return 0;
        }
        synchronized (this) {
            try {
                Integer num = (Integer) super.get(str);
                numValueOf = num == null ? 0 : Integer.valueOf(num.intValue() + 1);
                super.put(str, numValueOf);
            } catch (Throwable th) {
                throw th;
            }
        }
        return numValueOf.intValue();
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, Integer> entry) {
        return size() > this.cacheSize;
    }
}
