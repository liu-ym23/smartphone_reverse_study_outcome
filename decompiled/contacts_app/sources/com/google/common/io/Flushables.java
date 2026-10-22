package com.google.common.io;

import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class Flushables {
    private static final Logger logger = null;

    static {
        logger = Logger.getLogger(Flushables.class.getName());
    }

    private Flushables() {
    }

    public static void flush(Flushable r2, boolean r3) throws IOException {
        r2.flush();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        if (r3 == false) goto L8;
        logger.log(Level.WARNING, "IOException thrown while flushing Flushable.", e);
        return;
    L8:
        throw e;
    }

    public static void flushQuietly(Flushable r3) {
        flush(r3, true);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        logger.log(Level.SEVERE, "IOException should not have been thrown.", e);
    }
}
