package com.google.common.escape;

/* JADX INFO: loaded from: classes2.dex */
final class Platform {
    private static final ThreadLocal<char[]> DEST_TL = null;

    private Platform() {
    }

    static char[] charBufferFromThreadLocal() {
        return DEST_TL.get();
    }

    static {
        DEST_TL = new AnonymousClass1();
    }
}
