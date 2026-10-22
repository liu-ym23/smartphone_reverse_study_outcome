package androidx.work;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Logger {
    private static final int MAX_PREFIXED_TAG_LENGTH = 20;
    private static final int MAX_TAG_LENGTH = 23;
    private static final String TAG_PREFIX = "WM-";
    private static Logger sLogger;

    public static class LogcatLogger extends Logger {
        private int mLoggingLevel;

        public LogcatLogger(int r100) {
            super(r100);
            this.mLoggingLevel = r100;
        }

        @Override // androidx.work.Logger
        public void debug(String r100, String r101, Throwable... r102) {
            if (this.mLoggingLevel > 3) goto L9;
            if (r102 != null) goto L6;
            return;
        L6:
            if (r102.length < 1) goto L11;
            Throwable r103 = r102[0];
            return;
        L11:
            return;
        }

        @Override // androidx.work.Logger
        public void error(String r100, String r101, Throwable... r102) {
            if (this.mLoggingLevel > 6) goto L9;
            if (r102 != null) goto L6;
            return;
        L6:
            if (r102.length < 1) goto L11;
            Throwable r103 = r102[0];
            return;
        L11:
            return;
        }

        @Override // androidx.work.Logger
        public void info(String r100, String r101, Throwable... r102) {
            if (this.mLoggingLevel > 4) goto L9;
            if (r102 != null) goto L6;
            return;
        L6:
            if (r102.length < 1) goto L11;
            Throwable r103 = r102[0];
            return;
        L11:
            return;
        }

        @Override // androidx.work.Logger
        public void verbose(String r100, String r101, Throwable... r102) {
            if (this.mLoggingLevel > 2) goto L9;
            if (r102 != null) goto L6;
            return;
        L6:
            if (r102.length < 1) goto L11;
            Throwable r103 = r102[0];
            return;
        L11:
            return;
        }

        @Override // androidx.work.Logger
        public void warning(String r100, String r101, Throwable... r102) {
            if (this.mLoggingLevel > 5) goto L9;
            if (r102 != null) goto L6;
            return;
        L6:
            if (r102.length < 1) goto L11;
            Throwable r103 = r102[0];
            return;
        L11:
            return;
        }
    }

    public abstract void debug(String r100, String r101, Throwable... r102);

    public abstract void error(String r100, String r101, Throwable... r102);

    public abstract void info(String r100, String r101, Throwable... r102);

    public abstract void verbose(String r100, String r101, Throwable... r102);

    public abstract void warning(String r100, String r101, Throwable... r102);

    public static synchronized Logger get() {
        monitor-enter(Logger.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sLogger != null) goto L7;
        sLogger = new LogcatLogger(3);     // Catch: Throwable -> L10
    L7:
        Logger r100 = sLogger;     // Catch: Throwable -> L10
        monitor-exit(Logger.class);
        return r100;
    }

    public Logger(int r100) {
    }

    public static synchronized void setLogger(Logger r100) {
        monitor-enter(Logger.class);
        sLogger = r100;     // Catch: Throwable -> L7
        monitor-exit(Logger.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static String tagWithPrefix(String r100) {
        int r101 = r100.length();
        StringBuilder r102 = new StringBuilder(23);
        r102.append(TAG_PREFIX);
        int r103 = MAX_PREFIXED_TAG_LENGTH;
        if (r101 < r103) goto L5;
        r102.append(r100.substring(0, r103));
    L7:
        return r102.toString();
    L5:
        r102.append(r100);
        goto L7
    }
}
