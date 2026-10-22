package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class StackLeakChecker {
    public static final long CHECK_INTERVAL_10_SEC = 10000000;
    private static final int LEAK_THREAD_THRESHOLD = 10;
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mCheckerEnabled = false;
    private static ArrayList<StackLeakItem> mLeakList = null;
    private static int mLeakThreadThreshold = 10;
    private static ArrayList<StackLeakListener> mListeners = null;
    private static long mStackCheckInterval = 60000000;

    public interface StackLeakListener {
        void onLeakReport(ArrayList<StackLeakItem> r10);
    }

    static {
        mLeakList = new ArrayList();
        mListeners = new ArrayList();
    }

    private StackLeakChecker() {
    }

    private static void addLeakItem(int r12, long r13, long r15, long r17, String r19, String r20) {
        mLeakList.add(new StackLeakItem(r12, r13, r15, r17, r19, r20));
    }

    public static synchronized void disableChecker() {
        monitor-enter(StackLeakChecker.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (mCheckerEnabled == false) goto L10;
        setEnable(false, 0, 0, 0, null);     // Catch: Throwable -> L8
    L10:
        monitor-exit(StackLeakChecker.class);
    }

    public static synchronized boolean enableChecker(Context r10, String[] r11) {
        monitor-enter(StackLeakChecker.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (mCheckerEnabled == false) goto L11;
        monitor-exit(StackLeakChecker.class);
        return true;
    L11:
        if (loadOptimizerOnNeed(r10) == true) goto L26;
        monitor-exit(StackLeakChecker.class);
        return false;
    L26:
        boolean r12 = setEnable(true, Build.VERSION.SDK_INT, mLeakThreadThreshold, mStackCheckInterval, r11);     // Catch: Throwable -> L15 UnsatisfiedLinkError -> L17
        mCheckerEnabled = r12;     // Catch: Throwable -> L15 UnsatisfiedLinkError -> L17
        monitor-exit(StackLeakChecker.class);
        return r12;
    L17:
        e = move-exception;
        Log.e(TAG, "UnsatisfiedLinkError", e);     // Catch: Throwable -> L15
        return false;
    }

    private static boolean loadOptimizerOnNeed(Context r10) {
        return false;
    }

    public static synchronized void registerStackLeakListener(StackLeakListener r10) {
        monitor-enter(StackLeakChecker.class);
        if (r10 != null) goto L11;
    L9:
        monitor-exit(StackLeakChecker.class);
        return;
    L11:
        mListeners.add(r10);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private static void reportLeak() {
        Iterator<StackLeakListener> r10 = mListeners.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().onLeakReport(mLeakList);
        goto L4
    L6:
        mLeakList.clear();
    }

    private static native boolean setEnable(boolean r10, int r11, int r12, long r13, String[] r14);

    public static synchronized void setInterval(int r10, long r11) {
        monitor-enter(StackLeakChecker.class);
        if (r10 <= 0) goto L6;
    L5:
        int r12 = r10;
        mLeakThreadThreshold = r12;     // Catch: Throwable -> L10
        if (r11 <= CHECK_INTERVAL_10_SEC) goto L12;
        long r13 = (r11 / CHECK_INTERVAL_10_SEC) * CHECK_INTERVAL_10_SEC;     // Catch: Throwable -> L10
    L13:
        mStackCheckInterval = r13;     // Catch: Throwable -> L10
        if (mCheckerEnabled == false) goto L16;
        setEnable(true, 0, r12, r13, null);     // Catch: Throwable -> L10
    L16:
        monitor-exit(StackLeakChecker.class);
        return;
    L12:
        r13 = 10000000;
    L10:
        th = move-exception;
        throw th;
    L6:
        r10 = 10;
        goto L5
    }
}
