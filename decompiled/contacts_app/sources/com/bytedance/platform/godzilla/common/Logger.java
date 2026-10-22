package com.bytedance.platform.godzilla.common;

/* JADX INFO: loaded from: classes2.dex */
public final class Logger {
    public static boolean isDebug;
    private static Level sLevel;
    private static ILog sLogImpl;

    /* JADX INFO: renamed from: com.bytedance.platform.godzilla.common.Logger$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$platform$godzilla$common$Logger$Level = null;

        static {
            int[] r0 = new int[Level.values().length];
            $SwitchMap$com$bytedance$platform$godzilla$common$Logger$Level = r0;
            r0[Level.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$platform$godzilla$common$Logger$Level[Level.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$bytedance$platform$godzilla$common$Logger$Level[Level.WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$bytedance$platform$godzilla$common$Logger$Level[Level.INFO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum Level extends Enum<Level> {
        private static final /* synthetic */ Level[] $VALUES = null;
        public static final Level DEBUG = null;
        public static final Level ERROR = null;
        public static final Level INFO = null;
        public static final Level NONE = null;
        public static final Level WARNING = null;

        private Level(String r1, int r2) {
            super(r1, r2);
        }

        public static Level valueOf(String r1) {
            return (Level) Enum.valueOf(Level.class, r1);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }

        static {
            Level r0 = new Level("DEBUG", 0);
            DEBUG = r0;
            Level r1 = new Level("INFO", 1);
            INFO = r1;
            Level r3 = new Level("WARNING", 2);
            WARNING = r3;
            Level r5 = new Level("ERROR", 3);
            ERROR = r5;
            Level r7 = new Level("NONE", 4);
            NONE = r7;
            $VALUES = new Level[]{r0, r1, r3, r5, r7};
        }
    }

    private Logger() {
    }

    static {
        sLevel = Level.INFO;
        isDebug = false;
        sLogImpl = new AnonymousClass1();
    }

    public static boolean debug() {
        return isDebug;
    }

    public static void setLogLevel(Level r1) {
        sLevel = r1;
        if (r1 != Level.DEBUG) goto L6;
        isDebug = true;
        return;
    }

    public static void setLog(ILog r0) {
        sLogImpl = r0;
    }

    public static void e(String r0, String r1, Object... r2) {
        println(r0, String.format(r1, r2), Level.ERROR);
    }

    public static void e(String r1, String r2) {
        println(r1, r2, Level.ERROR);
    }

    public static void w(String r0, String r1, Object... r2) {
        println(r0, String.format(r1, r2), Level.WARNING);
    }

    public static void w(String r1, String r2) {
        println(r1, r2, Level.WARNING);
    }

    public static void i(String r0, String r1, Object... r2) {
        println(r0, String.format(r1, r2), Level.INFO);
    }

    public static void i(String r1, String r2) {
        println(r1, r2, Level.INFO);
    }

    public static void d(String r0, String r1, Object... r2) {
        println(r0, String.format(r1, r2), Level.DEBUG);
    }

    public static void d(String r1, String r2) {
        println(r1, r2, Level.DEBUG);
    }

    public static void println(String r2, String r3, Level r4) {
        if (r4.ordinal() < sLevel.ordinal()) goto L6;
        sLogImpl.println(r2, r3, r4);
        return;
    }

    public static void printStackTrace(String r1, Throwable r2) {
        printStackTrace(r1, r2, null);
    }

    public static void printStackTrace(String r3, Throwable r4, String r5) {
        StringBuilder r0 = new StringBuilder();
        if (r5 != null) goto L5;
        String r6 = "";
    L6:
        println(r3, r0.append(r6).append(r4.getMessage()).append("\n").append(getStackTraceString(r4)).toString(), Level.ERROR);
        return;
    L5:
        r6 = r5 + "\n";
        goto L6
    }

    private static String getStackTraceString(Throwable r5) {
        String r0 = "";
        if (r5 != null) goto L5;
        return "";
    L5:
        StackTraceElement[] r6 = r5.getStackTrace();
        if (r6 == null) goto L10;
        int r1 = r6.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L10;
        r0 = r0 + r6[r2].toString() + "\n";
        r2 = r2 + 1;
    L10:
        return r0;
    }
}
