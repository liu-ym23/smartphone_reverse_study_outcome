package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class VolleyLog {
    public static boolean DEBUG = false;
    public static String TAG = "Volley";

    public static class MarkerLog {
        public static final boolean ENABLED = false;
        private static final long MIN_DURATION_FOR_LOGGING_MS = 0;
        private boolean mFinished;
        private final List<Marker> mMarkers;

        public static class Marker {
            public final String name;
            public final long thread;
            public final long time;

            public Marker(String r10, long r11, long r12) {
                this.name = r10;
                this.thread = r11;
                this.time = r12;
            }
        }

        static {
            ENABLED = VolleyLog.DEBUG;
        }

        public MarkerLog() {
            this.mMarkers = new ArrayList();
            this.mFinished = false;
        }

        private long getTotalDuration() {
            if (this.mMarkers.size() != 0) goto L6;
            return 0;
        L6:
            long r10 = this.mMarkers.get(0).time;
            List<Marker> r11 = this.mMarkers;
            return r11.get(r11.size() - 1).time - r10;
        }

        public synchronized void add(String r10, long r11) {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mFinished == true) goto L11;
            this.mMarkers.add(new Marker(r10, r11, SystemClock.elapsedRealtime()));     // Catch: Throwable -> L8
            monitor-exit(this);
            return;
        L11:
            throw new IllegalStateException("Marker added to finished log");     // Catch: Throwable -> L8
        }

        public void finalize() throws Throwable {
            if (this.mFinished == true) goto L6;
            finish("Request on the loose");
            VolleyLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            return;
        }

        public synchronized void finish(String r10) {
            monitor-enter(this);
            this.mFinished = true;     // Catch: Throwable -> L14
            long r11 = getTotalDuration();     // Catch: Throwable -> L14
            if (r11 > 0) goto L9;
            monitor-exit(this);
            return;
        L9:
            long r12 = this.mMarkers.get(0).time;     // Catch: Throwable -> L14
            VolleyLog.d("(%-4d ms) %s", new Object[]{Long.valueOf(r11), r10});     // Catch: Throwable -> L14
            Iterator<Marker> r13 = this.mMarkers.iterator();     // Catch: Throwable -> L14
        L11:
            if (r13.hasNext() == false) goto L16;
            Marker r14 = r13.next();     // Catch: Throwable -> L14
            long r15 = r14.time;     // Catch: Throwable -> L14
            VolleyLog.d("(+%-4d) [%2d] %s", new Object[]{Long.valueOf(r15 - r12), Long.valueOf(r14.thread), r14.name});     // Catch: Throwable -> L14
            r12 = r15;
            goto L11
        L16:
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    static {
        DEBUG = Log.isLoggable("Volley", 2);
    }

    public VolleyLog() {
    }

    private static String buildMessage(String r10, Object... r11) {
        if (r11 == null) goto L5;
        r10 = String.format(Locale.US, r10, r11);
    L5:
        StackTraceElement[] r12 = new Throwable().fillInStackTrace().getStackTrace();
        int r13 = 2;
    L7:
        if (r13 >= r12.length) goto L12;
        if (r12[r13].getClass().equals(VolleyLog.class) == false) goto L10;
        r13 = r13 + 1;
        goto L7
    L10:
        String r14 = r12[r13].getClassName();
        String r15 = r14.substring(r14.lastIndexOf(46) + 1);
        String r16 = String.valueOf(r15.substring(r15.lastIndexOf(36) + 1));
        String r17 = String.valueOf(r12[r13].getMethodName());
        StringBuilder r18 = new StringBuilder((r16.length() + 1) + r17.length());
        r18.append(r16);
        r18.append(LibrarianImpl.Constants.DOT);
        r18.append(r17);
        String r19 = r18.toString();
    L14:
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), r19, r10});
    L12:
        r19 = "<unknown>";
        goto L14
    }

    public static void d(String r10, Object... r11) {
        Log.d(TAG, buildMessage(r10, r11));
    }

    public static void e(String r10, Object... r11) {
        Log.e(TAG, buildMessage(r10, r11));
    }

    public static void setTag(String r10) {
        d("Changing log tag to %s", new Object[]{r10});
        TAG = r10;
        DEBUG = Log.isLoggable(r10, 2);
    }

    public static void v(String r10, Object... r11) {
        if (DEBUG == false) goto L6;
        Log.v(TAG, buildMessage(r10, r11));
        return;
    }

    public static void wtf(String r10, Object... r11) {
        Log.wtf(TAG, buildMessage(r10, r11));
    }

    public static void e(Throwable r10, String r11, Object... r12) {
        Log.e(TAG, buildMessage(r11, r12), r10);
    }

    public static void wtf(Throwable r10, String r11, Object... r12) {
        Log.wtf(TAG, buildMessage(r11, r12), r10);
    }
}
