package com.bumptech.glide.util.pool;

/* JADX INFO: loaded from: classes.dex */
public final class GlideTrace {
    private static final int MAX_LENGTH = 127;
    private static final boolean TRACING_ENABLED = false;

    private GlideTrace() {
    }

    public static void beginSection(String r10) {
    }

    public static void beginSectionFormat(String r10, Object r11) {
    }

    public static void endSection() {
    }

    private static String truncateTag(String r10) {
        if (r10.length() > MAX_LENGTH) goto L5;
        return r10;
    L5:
        return r10.substring(0, 126);
    }

    public static void beginSectionFormat(String r10, Object r11, Object r12) {
    }

    public static void beginSectionFormat(String r10, Object r11, Object r12, Object r13) {
    }
}
