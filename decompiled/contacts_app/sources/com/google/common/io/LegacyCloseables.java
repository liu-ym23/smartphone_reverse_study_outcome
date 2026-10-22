package com.google.common.io;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class LegacyCloseables {
    private static final Logger logger = null;

    static {
        logger = Logger.getLogger(LegacyCloseables.class.getName());
    }

    private LegacyCloseables() {
    }

    @Deprecated
    public static void closeQuietly(@Nullable Closeable r3) {
        if (r3 != null) goto L9;
        return;
    L9:
        r3.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        logger.log(Level.WARNING, "IOException thrown while closing Closeable.", e);
    }
}
