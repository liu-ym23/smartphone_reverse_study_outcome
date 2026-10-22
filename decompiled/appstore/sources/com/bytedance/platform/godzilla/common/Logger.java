package com.bytedance.platform.godzilla.common;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Level f7864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f7865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ILog f7866c;

    public static final enum Level extends Enum<Level> {
        private static final /* synthetic */ Level[] $VALUES = null;
        public static final Level DEBUG = null;
        public static final Level ERROR = null;
        public static final Level INFO = null;
        public static final Level NONE = null;
        public static final Level WARNING = null;

        static {
            Level r10 = new Level("DEBUG", 0);
            DEBUG = r10;
            Level r11 = new Level("INFO", 1);
            INFO = r11;
            Level r12 = new Level("WARNING", 2);
            WARNING = r12;
            Level r13 = new Level("ERROR", 3);
            ERROR = r13;
            Level r14 = new Level("NONE", 4);
            NONE = r14;
            $VALUES = new Level[]{r10, r11, r12, r13, r14};
        }

        private Level(String r10, int r11) {
            super(r10, r11);
        }

        public static Level valueOf(String r10) {
            return (Level) Enum.valueOf(Level.class, r10);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }
    }

    public static class a implements ILog {
        public a() {
        }

        public final int a(Level r10) {
            int r11 = b.f7867a[r10.ordinal()];
            if (r11 != 1) goto L5;
            return 3;
        L5:
            if (r11 == 2) goto L13;
            if (r11 != 3) goto L8;
            return 5;
        L8:
            if (r11 == 4) goto L10;
            return 2;
        L10:
            return 4;
        L13:
            return 6;
        }

        @Override // com.bytedance.platform.godzilla.common.ILog
        public void println(String r10, String r11, Level r12) {
            Log.println(a(r12), r10, r11);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7867a = null;

        static {
            int[] r10 = new int[Level.values().length];
            f7867a = r10;
            r10[Level.DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f7867a[Level.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f7867a[Level.WARNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f7867a[Level.INFO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        f7864a = Level.INFO;
        f7865b = false;
        f7866c = new a();
    }

    public static void a(String r10, String r11) {
        e(r10, r11, Level.DEBUG);
    }

    public static boolean b() {
        return f7865b;
    }

    public static void c(String r10, String r11) {
        e(r10, r11, Level.ERROR);
    }

    public static void d(String r10, String r11) {
        e(r10, r11, Level.INFO);
    }

    public static void e(String r10, String r11, Level r12) {
        if (r12.ordinal() < f7864a.ordinal()) goto L6;
        f7866c.println(r10, r11, r12);
        return;
    }

    public static void f(ILog r10) {
        f7866c = r10;
    }

    public static void g(Level r10) {
        f7864a = r10;
        if (r10 != Level.DEBUG) goto L6;
        f7865b = true;
        return;
    }
}
