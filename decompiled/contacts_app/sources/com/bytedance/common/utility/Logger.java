package com.bytedance.common.utility;

import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;

/* JADX INFO: loaded from: classes2.dex */
public class Logger {
    private static final String TAG = "Logger";
    private static int mLevel = 4;
    private static ILogWritter sLogWriter;

    /* JADX INFO: renamed from: com.bytedance.common.utility.Logger$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class DefaultLogHandler extends ILogWritter {

        private static class SingletonHolder {
            private static final DefaultLogHandler INSTANCE = null;

            private SingletonHolder() {
            }

            static /* synthetic */ DefaultLogHandler access$000() {
                return INSTANCE;
            }

            static {
                INSTANCE = new DefaultLogHandler(null);
            }
        }

        /* synthetic */ DefaultLogHandler(AnonymousClass1 r1) {
            this();
        }

        private DefaultLogHandler() {
        }

        static DefaultLogHandler getInstance() {
            return SingletonHolder.access$000();
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logV(String r1, String r2) {
            Log.v(r1, r2);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logV(String r1, String r2, Throwable r3) {
            Log.v(r1, r2, r3);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logD(String r1, String r2) {
            Log.d(r1, r2);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logD(String r1, String r2, Throwable r3) {
            Log.d(r1, r2, r3);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logI(String r1, String r2) {
            Log.i(r1, r2);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logI(String r1, String r2, Throwable r3) {
            Log.i(r1, r2, r3);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logE(String r1, String r2, Throwable r3) {
            Log.e(r1, r2, r3);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logE(String r1, String r2) {
            Log.e(r1, r2);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logW(String r1, String r2) {
            Log.w(r1, r2);
        }

        @Override // com.bytedance.common.utility.Logger.ILogWritter
        public void logW(String r1, String r2, Throwable r3) {
            Log.w(r1, r2, r3);
        }
    }

    public static abstract class ILogWritter {
        public void logD(String r1, String r2) {
        }

        public void logD(String r1, String r2, Throwable r3) {
        }

        public void logE(String r1, String r2) {
        }

        public void logE(String r1, String r2, Throwable r3) {
        }

        public void logI(String r1, String r2) {
        }

        public void logI(String r1, String r2, Throwable r3) {
        }

        public void logK(String r1, String r2) {
        }

        public void logV(String r1, String r2) {
        }

        public void logV(String r1, String r2, Throwable r3) {
        }

        public void logW(String r1, String r2) {
        }

        public void logW(String r1, String r2, Throwable r3) {
        }

        public ILogWritter() {
        }

        public boolean isLoggable(int r1) {
            if (Logger.getLogLevel() > r1) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public Logger() {
    }

    public static void setLogLevel(int r0) {
        mLevel = r0;
    }

    public static int getLogLevel() {
        return mLevel;
    }

    public static boolean debug() {
        if (mLevel > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static void v(String r1) {
        v("Logger", r1);
    }

    public static void v(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (sLogWriter.isLoggable(2) == false) goto L8;
        sLogWriter.logV(r2, r3);
        return;
    }

    public static void v(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (sLogWriter.isLoggable(2) == false) goto L9;
        sLogWriter.logV(r2, r3, r4);
        return;
    }

    public static void d(String r1) {
        d("Logger", r1);
    }

    public static void d(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (sLogWriter.isLoggable(3) == false) goto L8;
        sLogWriter.logD(r2, r3);
        return;
    }

    public static void d(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (sLogWriter.isLoggable(3) == false) goto L9;
        sLogWriter.logD(r2, r3, r4);
        return;
    }

    public static void i(String r1) {
        i("Logger", r1);
    }

    public static void i(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (sLogWriter.isLoggable(4) == false) goto L8;
        sLogWriter.logI(r2, r3);
        return;
    }

    public static void i(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (sLogWriter.isLoggable(4) == false) goto L9;
        sLogWriter.logI(r2, r3, r4);
        return;
    }

    public static void w(String r1) {
        w("Logger", r1);
    }

    public static void w(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (sLogWriter.isLoggable(5) == false) goto L8;
        sLogWriter.logW(r2, r3);
        return;
    }

    public static void w(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (sLogWriter.isLoggable(5) == false) goto L9;
        sLogWriter.logW(r2, r3, r4);
        return;
    }

    public static void e(String r1) {
        e("Logger", r1);
    }

    public static void e(String r2, String r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (sLogWriter.isLoggable(6) == false) goto L8;
        sLogWriter.logE(r2, r3);
        return;
    }

    public static void e(String r2, String r3, Throwable r4) {
        if (r3 != null) goto L6;
        if (r4 != null) goto L6;
        return;
    L6:
        if (sLogWriter.isLoggable(6) == false) goto L9;
        sLogWriter.logE(r2, r3, r4);
        return;
    }

    @Deprecated
    public static void k(String r1) {
        k("Logger", r1);
    }

    @Deprecated
    public static void k(String r2, String r3) {
        if (sLogWriter.isLoggable(3) == false) goto L6;
        sLogWriter.logK(r2, r3);
        return;
    }

    public static void st(String r5, int r6) {
    L4:
        e = move-exception;
        StackTraceElement[] r0 = e.getStackTrace();
        StringBuilder r1 = new StringBuilder();
        int r3 = 1;
    L7:
        if (r3 >= Math.min(r6, r0.length)) goto L11;
        if (r3 <= 1) goto L10;
        r1.append("\n");
    L10:
        r1.append(getSimpleClassName(r0[r3].getClassName()));
        r1.append(LibrarianImpl.Constants.DOT);
        r1.append(r0[r3].getMethodName());
        r3 = r3 + 1;
        goto L7
    L11:
        v(r5, r1.toString());
        return;
    L3:
        throw new Exception();     // Catch: Exception -> L4
    }

    private static String getSimpleClassName(String r1) {
        int r0 = r1.lastIndexOf(46);
        if (r0 >= 0) goto L6;
        return r1;
    L6:
        return r1.substring(r0 + 1);
    }

    public static void throwException(Throwable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.printStackTrace();
        if (debug() == true) goto L8;
        return;
    L8:
        throw new RuntimeException("Error! Now in debug, we alert to you to correct it !", r2);
    }

    public static void alertErrorInfo(String r1) {
        if (debug() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(r1);
    }

    static {
        sLogWriter = DefaultLogHandler.getInstance();
    }

    public static void registerLogHandler(ILogWritter r0) {
        sLogWriter = r0;
    }
}
