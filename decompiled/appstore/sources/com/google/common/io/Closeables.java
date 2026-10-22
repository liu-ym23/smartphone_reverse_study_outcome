package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class Closeables {

    @VisibleForTesting
    static final Logger logger = null;

    static {
        logger = Logger.getLogger(Closeables.class.getName());
    }

    private Closeables() {
    }

    public static void close(@NullableDecl Closeable r10, boolean r11) throws IOException {
        if (r10 != null) goto L11;
        return;
    L11:
        r10.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        if (r11 == false) goto L10;
        logger.log(Level.WARNING, "IOException thrown while closing Closeable.", e);
        return;
    L10:
        throw e;
    }

    public static void closeQuietly(@NullableDecl InputStream r10) {
        close(r10, true);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static void closeQuietly(@NullableDecl Reader r10) {
        close(r10, true);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }
}
