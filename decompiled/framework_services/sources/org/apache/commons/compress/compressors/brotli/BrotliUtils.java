package org.apache.commons.compress.compressors.brotli;

/* JADX INFO: loaded from: classes3.dex */
public class BrotliUtils {
    private static volatile CachedAvailability cachedBrotliAvailability;

    static final enum CachedAvailability extends Enum<CachedAvailability> {
        private static final /* synthetic */ CachedAvailability[] $VALUES = null;
        public static final CachedAvailability CACHED_AVAILABLE = null;
        public static final CachedAvailability CACHED_UNAVAILABLE = null;
        public static final CachedAvailability DONT_CACHE = null;

        private static /* synthetic */ CachedAvailability[] $values() {
            return new CachedAvailability[]{DONT_CACHE, CACHED_AVAILABLE, CACHED_UNAVAILABLE};
        }

        private CachedAvailability(String r1, int r2) {
            super(r1, r2);
        }

        public static CachedAvailability valueOf(String name) {
            return (CachedAvailability) Enum.valueOf(CachedAvailability.class, name);
        }

        public static CachedAvailability[] values() {
            return (CachedAvailability[]) $VALUES.clone();
        }

        static {
            DONT_CACHE = new CachedAvailability("DONT_CACHE", 0);
            CACHED_AVAILABLE = new CachedAvailability("CACHED_AVAILABLE", 1);
            CACHED_UNAVAILABLE = new CachedAvailability("CACHED_UNAVAILABLE", 2);
            $VALUES = $values();
        }
    }

    static {
        cachedBrotliAvailability = CachedAvailability.DONT_CACHE;
        Class.forName("org.osgi.framework.BundleEvent");     // Catch: Exception -> L5
        return;
    L6:
        setCacheBrotliAvailablity(true);
    }

    private BrotliUtils() {
    }

    public static boolean isBrotliCompressionAvailable() {
        CachedAvailability cachedResult = cachedBrotliAvailability;
        if (cachedResult == CachedAvailability.DONT_CACHE) goto L10;
        if (cachedResult != CachedAvailability.CACHED_AVAILABLE) goto L7;
        return true;
    L7:
        return false;
    L10:
        return internalIsBrotliCompressionAvailable();
    }

    private static boolean internalIsBrotliCompressionAvailable() {
        Class.forName("org.brotli.dec.BrotliInputStream");     // Catch: Throwable -> L5
        return true;
    L6:
        return false;
    }

    public static void setCacheBrotliAvailablity(boolean doCache) {
        if (doCache == true) goto L5;
        cachedBrotliAvailability = CachedAvailability.DONT_CACHE;
        return;
    L5:
        if (cachedBrotliAvailability != CachedAvailability.DONT_CACHE) goto L13;
        boolean hasBrotli = internalIsBrotliCompressionAvailable();
        if (hasBrotli == false) goto L9;
        CachedAvailability r1 = CachedAvailability.CACHED_AVAILABLE;
    L10:
        cachedBrotliAvailability = r1;
        return;
    L9:
        r1 = CachedAvailability.CACHED_UNAVAILABLE;
        goto L10
    }

    static CachedAvailability getCachedBrotliAvailability() {
        return cachedBrotliAvailability;
    }
}
