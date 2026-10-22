package com.google.common.util.concurrent;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class UncaughtExceptionHandlers {

    static final class Exiter implements Thread.UncaughtExceptionHandler {
        private static final Logger logger = null;
        private final Runtime runtime;

        static {
            logger = Logger.getLogger(Exiter.class.getName());
        }

        Exiter(Runtime r1) {
            this.runtime = r1;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread r7, Throwable r8) {
            logger.log(Level.SEVERE, String.format("Caught an exception in %s.  Shutting down.", new Object[]{r7}), r8);     // Catch: Throwable -> L5
        L4:
            this.runtime.exit(1);
            return;
        L5:
            th = move-exception;
            System.err.println(r8.getMessage());     // Catch: Throwable -> L9
            System.err.println(th.getMessage());     // Catch: Throwable -> L9
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
