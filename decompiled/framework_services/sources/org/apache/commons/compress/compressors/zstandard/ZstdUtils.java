package org.apache.commons.compress.compressors.zstandard;

import android.hardware.tv.mediaquality.ParameterName;

/* JADX INFO: loaded from: classes3.dex */
public class ZstdUtils {
    private static final byte[] SKIPPABLE_FRAME_MAGIC = null;
    private static final byte[] ZSTANDARD_FRAME_MAGIC = null;
    private static volatile CachedAvailability cachedZstdAvailability;

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
        ZSTANDARD_FRAME_MAGIC = new byte[]{ParameterName.COLOR_TEMPERATURE_RED_OFFSET, -75, ParameterName.LD_MODE, -3};
        SKIPPABLE_FRAME_MAGIC = new byte[]{42, ParameterName.COLOR_TUNER_LUMINANCE_YELLOW, ParameterName.GLOBE_DIMMING};
        cachedZstdAvailability = CachedAvailability.DONT_CACHE;
        Class.forName("org.osgi.framework.BundleEvent");     // Catch: Exception -> L5
        return;
    L6:
        setCacheZstdAvailablity(true);
    }

    private ZstdUtils() {
    }

    public static boolean isZstdCompressionAvailable() {
        CachedAvailability cachedResult = cachedZstdAvailability;
        if (cachedResult == CachedAvailability.DONT_CACHE) goto L10;
        if (cachedResult != CachedAvailability.CACHED_AVAILABLE) goto L7;
        return true;
    L7:
        return false;
    L10:
        return internalIsZstdCompressionAvailable();
    }

    private static boolean internalIsZstdCompressionAvailable() {
        Class.forName("com.github.luben.zstd.ZstdInputStream");     // Catch: Throwable -> L5
        return true;
    L6:
        return false;
    }

    public static void setCacheZstdAvailablity(boolean doCache) {
        if (doCache == true) goto L5;
        cachedZstdAvailability = CachedAvailability.DONT_CACHE;
        return;
    L5:
        if (cachedZstdAvailability != CachedAvailability.DONT_CACHE) goto L13;
        boolean hasZstd = internalIsZstdCompressionAvailable();
        if (hasZstd == false) goto L9;
        CachedAvailability r1 = CachedAvailability.CACHED_AVAILABLE;
    L10:
        cachedZstdAvailability = r1;
        return;
    L9:
        r1 = CachedAvailability.CACHED_UNAVAILABLE;
        goto L10
    }

    public static boolean matches(byte[] signature, int length) {
        if (length >= ZSTANDARD_FRAME_MAGIC.length) goto L5;
        return false;
    L5:
        boolean isZstandard = true;
        int i = 0;
    L7:
        if (i >= ZSTANDARD_FRAME_MAGIC.length) goto L13;
        if (signature[i] != ZSTANDARD_FRAME_MAGIC[i]) goto L10;
        i = i + 1;
        goto L7
    L10:
        isZstandard = false;
    L13:
        if (isZstandard == false) goto L16;
        return true;
    L16:
        if (80 != (signature[0] & 240)) goto L26;
        int i2 = 0;
    L19:
        if (i2 >= SKIPPABLE_FRAME_MAGIC.length) goto L25;
        if (signature[i2 + 1] != SKIPPABLE_FRAME_MAGIC[i2]) goto L22;
        i2 = i2 + 1;
        goto L19
    L22:
        return false;
    L25:
        return true;
    L26:
        return false;
    }

    static CachedAvailability getCachedZstdAvailability() {
        return cachedZstdAvailability;
    }
}
