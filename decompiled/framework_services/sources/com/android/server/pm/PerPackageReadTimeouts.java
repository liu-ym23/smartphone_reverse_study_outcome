package com.android.server.pm;

import android.text.TextUtils;
import com.android.internal.util.HexDump;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class PerPackageReadTimeouts {
    public final String packageName;
    public final byte[] sha256certificate;
    public final Timeouts timeouts;
    public final VersionCodes versionCodes;

    static class Timeouts {
        public static final Timeouts DEFAULT = null;
        public final long maxPendingTimeUs;
        public final long minPendingTimeUs;
        public final long minTimeUs;

        static {
            DEFAULT = new Timeouts(3600000000L, 3600000000L, 3600000000L);
        }

        private Timeouts(long minTimeUs, long minPendingTimeUs, long maxPendingTimeUs) {
            this.minTimeUs = minTimeUs;
            this.minPendingTimeUs = minPendingTimeUs;
            this.maxPendingTimeUs = maxPendingTimeUs;
        }

        static Timeouts parse(String timeouts) {
            String[] splits = timeouts.split(":", 3);
            if (splits.length != 3) goto L5;
            long minTimeUs = PerPackageReadTimeouts.tryParseLong(splits[0], DEFAULT.minTimeUs);
            long minPendingTimeUs = PerPackageReadTimeouts.tryParseLong(splits[1], DEFAULT.minPendingTimeUs);
            long maxPendingTimeUs = PerPackageReadTimeouts.tryParseLong(splits[2], DEFAULT.maxPendingTimeUs);
            if (0 > minTimeUs) goto L15;
            if (minTimeUs > minPendingTimeUs) goto L15;
            if (minPendingTimeUs > maxPendingTimeUs) goto L15;
            return new Timeouts(minTimeUs, minPendingTimeUs, maxPendingTimeUs);
        L15:
            return DEFAULT;
        L5:
            return DEFAULT;
        }
    }

    static class VersionCodes {
        public static final VersionCodes ALL_VERSION_CODES = null;
        public final long maxVersionCode;
        public final long minVersionCode;

        static {
            ALL_VERSION_CODES = new VersionCodes(Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private VersionCodes(long minVersionCode, long maxVersionCode) {
            this.minVersionCode = minVersionCode;
            this.maxVersionCode = maxVersionCode;
        }

        static VersionCodes parse(String codes) {
            if (TextUtils.isEmpty(codes) == true) goto L5;
            String[] splits = codes.split("-", 2);
            switch(splits.length) {
                case 1: goto L20;
                case 2: goto L9;
                default: goto L14;
            };
        L9:
            long minVersionCode = PerPackageReadTimeouts.tryParseLong(splits[0], ALL_VERSION_CODES.minVersionCode);
            long maxVersionCode = PerPackageReadTimeouts.tryParseLong(splits[1], ALL_VERSION_CODES.maxVersionCode);
            if (minVersionCode > maxVersionCode) goto L14;
            return new VersionCodes(minVersionCode, maxVersionCode);
        L20:
            long versionCode = Long.parseLong(splits[0]);     // Catch: NumberFormatException -> L17
            return new VersionCodes(versionCode, versionCode);
        L19:
            return ALL_VERSION_CODES;
        L14:
            return ALL_VERSION_CODES;
        L5:
            return ALL_VERSION_CODES;
        }
    }

    static long tryParseLong(String str, long defaultValue) {
        return Long.parseLong(str);
    L5:
        return defaultValue;
    }

    static byte[] tryParseSha256(String str) {
        if (TextUtils.isEmpty(str) == false) goto L9;
        return null;
    L9:
        return HexDump.hexStringToByteArray(str);
    L8:
        return null;
    }

    private PerPackageReadTimeouts(String packageName, byte[] sha256certificate, VersionCodes versionCodes, Timeouts timeouts) {
        this.packageName = packageName;
        this.sha256certificate = sha256certificate;
        this.versionCodes = versionCodes;
        this.timeouts = timeouts;
    }

    static PerPackageReadTimeouts parse(String timeoutsStr, VersionCodes defaultVersionCodes, Timeouts defaultTimeouts) {
        byte[] sha256certificate = null;
        VersionCodes versionCodes = defaultVersionCodes;
        Timeouts timeouts = defaultTimeouts;
        String[] splits = timeoutsStr.split(":", 4);
        switch(splits.length) {
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L5;
            default: goto L4;
        };
    L4:
        return null;
    L5:
        timeouts = Timeouts.parse(splits[3]);
    L6:
        versionCodes = VersionCodes.parse(splits[2]);
    L7:
        sha256certificate = tryParseSha256(splits[1]);
    L8:
        String packageName = splits[0];
        if (TextUtils.isEmpty(packageName) == false) goto L12;
        return null;
    L12:
        return new PerPackageReadTimeouts(packageName, sha256certificate, versionCodes, timeouts);
    }

    static List<PerPackageReadTimeouts> parseDigestersList(String defaultTimeoutsStr, String knownDigestersList) {
        if (TextUtils.isEmpty(knownDigestersList) == true) goto L5;
        VersionCodes defaultVersionCodes = VersionCodes.ALL_VERSION_CODES;
        Timeouts defaultTimeouts = Timeouts.parse(defaultTimeoutsStr);
        String[] packages = knownDigestersList.split(",");
        List<PerPackageReadTimeouts> result = new ArrayList(packages.length);
        int i = 0;
        int size = packages.length;
    L7:
        if (i >= size) goto L13;
        PerPackageReadTimeouts timeouts = parse(packages[i], defaultVersionCodes, defaultTimeouts);
        if (timeouts == null) goto L11;
        result.add(timeouts);
    L11:
        i = i + 1;
        goto L7
    L13:
        return result;
    L5:
        return Collections.emptyList();
    }
}
