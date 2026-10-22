package com.bumptech.glide.util.pool;

/* JADX INFO: loaded from: classes39.dex */
public final class GlideTrace {
    private static final int MAX_LENGTH = 127;
    private static final boolean TRACING_ENABLED = false;

    public static void beginSection(String r100) {
    }

    public static void beginSectionFormat(String r100, Object r101) {
    }

    public static void beginSectionFormat(String r100, Object r101, Object r102) {
    }

    public static void beginSectionFormat(String r100, Object r101, Object r102, Object r103) {
    }

    public static void endSection() {
    }

    private GlideTrace() {
    }

    private static String truncateTag(String r100) {
        if (r100.length() > 127) goto L5;
        return r100;
    L5:
        return r100.substring(0, 126);
    }
}
