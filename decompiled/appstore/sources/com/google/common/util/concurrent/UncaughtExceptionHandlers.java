package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.PrintStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final class UncaughtExceptionHandlers {

    @VisibleForTesting
    public static final class Exiter implements Thread.UncaughtExceptionHandler {
        private static final Logger logger = null;
        private final Runtime runtime;

        static {
            logger = Logger.getLogger(Exiter.class.getName());
        }

        public Exiter(Runtime r10) {
            this.runtime = r10;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread r10, Throwable r11) {
            logger.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", new Object[]{r10}), r11);     // Catch: Throwable -> L5
        L4:
            this.runtime.exit(1);
            return;
        L5:
            th = move-exception;
            PrintStream r12 = System.err;     // Catch: Throwable -> L9
            r12.println(r11.getMessage());     // Catch: Throwable -> L9
            r12.println(th.getMessage());     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            this.runtime.exit(1);
            throw th;
        }
    }

    private UncaughtExceptionHandlers() {
    }

    public static Thread.UncaughtExceptionHandler systemExit() {
        return new Exiter(Runtime.getRuntime());
    }
}
