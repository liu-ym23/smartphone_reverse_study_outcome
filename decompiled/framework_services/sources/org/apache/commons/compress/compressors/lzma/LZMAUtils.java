package org.apache.commons.compress.compressors.lzma;

import android.hardware.tv.mediaquality.ParameterName;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.compressors.FileNameUtil;

/* JADX INFO: loaded from: classes3.dex */
public class LZMAUtils {
    private static final byte[] HEADER_MAGIC = null;
    private static volatile CachedAvailability cachedLZMAAvailability;
    private static final FileNameUtil fileNameUtil = null;

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
        HEADER_MAGIC = new byte[]{ParameterName.DIGITAL_OUTPUT, 0, 0};
        Map<String, String> uncompressSuffix = new HashMap();
        uncompressSuffix.put(".lzma", "");
        uncompressSuffix.put("-lzma", "");
        fileNameUtil = new FileNameUtil(uncompressSuffix, ".lzma");
        cachedLZMAAvailability = CachedAvailability.DONT_CACHE;
        Class.forName("org.osgi.framework.BundleEvent");     // Catch: Exception -> L5
        return;
    L6:
        setCacheLZMAAvailablity(true);
    }

    private LZMAUtils() {
    }

    public static boolean matches(byte[] signature, int length) {
        if (length >= HEADER_MAGIC.length) goto L5;
        return false;
    L5:
        int i = 0;
    L7:
        if (i >= HEADER_MAGIC.length) goto L12;
        if (signature[i] != HEADER_MAGIC[i]) goto L10;
        i = i + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static boolean isLZMACompressionAvailable() {
        CachedAvailability cachedResult = cachedLZMAAvailability;
        if (cachedResult == CachedAvailability.DONT_CACHE) goto L10;
        if (cachedResult != CachedAvailability.CACHED_AVAILABLE) goto L7;
        return true;
    L7:
        return false;
    L10:
        return internalIsLZMACompressionAvailable();
    }

    private static boolean internalIsLZMACompressionAvailable() {
        LZMACompressorInputStream.matches(null, 0);     // Catch: NoClassDefFoundError -> L6
        return true;
    L7:
        return false;
    }

    public static boolean isCompressedFilename(String filename) {
        return fileNameUtil.isCompressedFilename(filename);
    }

    public static String getUncompressedFilename(String filename) {
        return fileNameUtil.getUncompressedFilename(filename);
    }

    public static String getCompressedFilename(String filename) {
        return fileNameUtil.getCompressedFilename(filename);
    }

    public static void setCacheLZMAAvailablity(boolean doCache) {
        if (doCache == true) goto L5;
        cachedLZMAAvailability = CachedAvailability.DONT_CACHE;
        return;
    L5:
        if (cachedLZMAAvailability != CachedAvailability.DONT_CACHE) goto L13;
        boolean hasLzma = internalIsLZMACompressionAvailable();
        if (hasLzma == false) goto L9;
        CachedAvailability r1 = CachedAvailability.CACHED_AVAILABLE;
    L10:
        cachedLZMAAvailability = r1;
        return;
    L9:
        r1 = CachedAvailability.CACHED_UNAVAILABLE;
        goto L10
    }

    static CachedAvailability getCachedLZMAAvailability() {
        return cachedLZMAAvailability;
    }
}
