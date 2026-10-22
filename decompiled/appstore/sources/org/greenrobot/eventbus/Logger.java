package org.greenrobot.eventbus;

import android.util.Log;
import java.io.PrintStream;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes4.dex */
public interface Logger {

    public static class AndroidLogger implements Logger {
        static final boolean ANDROID_LOG_AVAILABLE = false;
        private final String tag;

        static {
            Class.forName("android.util.Log");     // Catch: ClassNotFoundException -> L4
            boolean r10 = true;
        L5:
            ANDROID_LOG_AVAILABLE = r10;
            return;
        L4:
            r10 = false;
            goto L5
        }

        public AndroidLogger(String r10) {
            this.tag = r10;
        }

        public static boolean isAndroidLogAvailable() {
            return ANDROID_LOG_AVAILABLE;
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level r10, String r11) {
            if (r10 == Level.OFF) goto L6;
            Log.println(mapLevel(r10), this.tag, r11);
            return;
        }

        public int mapLevel(Level r10) {
            int r11 = r10.intValue();
            if (r11 >= 800) goto L11;
            if (r11 >= 500) goto L8;
            return 2;
        L8:
            return 3;
        L11:
            if (r11 >= 900) goto L15;
            return 4;
        L15:
            if (r11 >= 1000) goto L18;
            return 5;
        L18:
            return 6;
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level r10, String r11, Throwable r12) {
            if (r10 == Level.OFF) goto L6;
            Log.println(mapLevel(r10), this.tag, r11 + "\n" + Log.getStackTraceString(r12));
            return;
        }
    }

    public static class JavaLogger implements Logger {
        protected final java.util.logging.Logger logger;

        public JavaLogger(String r10) {
            this.logger = java.util.logging.Logger.getLogger(r10);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level r10, String r11) {
            this.logger.log(r10, r11);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level r10, String r11, Throwable r12) {
            this.logger.log(r10, r11, r12);
        }
    }

    public static class SystemOutLogger implements Logger {
        public SystemOutLogger() {
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level r10, String r11) {
            System.out.println("[" + r10 + "] " + r11);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level r10, String r11, Throwable r12) {
            PrintStream r13 = System.out;
            r13.println("[" + r10 + "] " + r11);
            r12.printStackTrace(r13);
        }
    }

    void log(Level r10, String r11);

    void log(Level r10, String r11, Throwable r12);
}
