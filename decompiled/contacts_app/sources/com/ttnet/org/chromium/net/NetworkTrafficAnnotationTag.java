package com.ttnet.org.chromium.net;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkTrafficAnnotationTag {
    public static final NetworkTrafficAnnotationTag MISSING_TRAFFIC_ANNOTATION = null;
    public static final NetworkTrafficAnnotationTag NO_TRAFFIC_ANNOTATION_YET = null;
    public static final NetworkTrafficAnnotationTag TRAFFIC_ANNOTATION_FOR_TESTS = null;
    private final int mHashCode;

    static {
        NO_TRAFFIC_ANNOTATION_YET = createComplete("undefined", "Nothing here yet.");
        MISSING_TRAFFIC_ANNOTATION = createComplete("undefined", "Function called without traffic annotation.");
        TRAFFIC_ANNOTATION_FOR_TESTS = createComplete("test", "Traffic annotation for unit, browser and other tests");
    }

    public static NetworkTrafficAnnotationTag createComplete(String r0, String r1) {
        return new NetworkTrafficAnnotationTag(r0);
    }

    public int getHashCode() {
        return this.mHashCode;
    }

    private NetworkTrafficAnnotationTag(String r1) {
        this.mHashCode = iterativeHash(r1);
    }

    static int iterativeHash(String r7) {
        byte[] r8 = r7.getBytes(StandardCharsets.UTF_8);
        int r0 = r8.length;
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1 = ((r1 * 31) + ((long) r8[r3])) % 138003713;
        r3 = r3 + 1;
        goto L3
    L6:
        return (int) r1;
    }
}
