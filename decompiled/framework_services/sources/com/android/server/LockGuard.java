package com.android.server;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class LockGuard {
    public static final int INDEX_ACTIVITY = 7;
    public static final int INDEX_APP_OPS = 0;
    public static final int INDEX_DPMS = 8;
    public static final int INDEX_PACKAGES = 3;
    public static final int INDEX_POWER = 1;
    public static final int INDEX_PROC = 6;
    public static final int INDEX_STORAGE = 4;
    public static final int INDEX_USER = 2;
    public static final int INDEX_WINDOW = 5;
    private static final String TAG = "LockGuard";
    private static ArrayMap<Object, LockInfo> sKnown;
    private static Object[] sKnownFixed;

    private static class LockInfo {
        public ArraySet<Object> children;
        public boolean doWtf;
        public String label;

        /* synthetic */ LockInfo(LockGuardIA r1) {
            this();
        }

        private LockInfo() {
            this.children = new ArraySet(0, true);
        }
    }

    public static /* synthetic */ void $r8$lambda$UCrAYBl1NxDkd0re75B8LQ3Nen4(Throwable r0) {
        lambda$doLog$0(r0);
    }

    public LockGuard() {
    }

    static {
        sKnownFixed = new Object[9];
        sKnown = new ArrayMap(0, true);
    }

    private static LockInfo findOrCreateLockInfo(Object lock) {
        LockInfo info = sKnown.get(lock);
        if (info != null) goto L6;
        LockInfo info2 = new LockInfo(null);
        info2.label = "0x" + Integer.toHexString(System.identityHashCode(lock)) + " [" + new Throwable().getStackTrace()[2].toString() + "]";
        sKnown.put(lock, info2);
        return info2;
    L6:
        return info;
    }

    public static Object guard(Object lock) {
        if (lock != null) goto L4;
    L30:
        return lock;
    L4:
        if (Thread.holdsLock(lock) == true) goto L30;
        boolean triggered = false;
        LockInfo info = findOrCreateLockInfo(lock);
        int i = 0;
    L8:
        if (i >= info.children.size()) goto L17;
        Object child = info.children.valueAt(i);
        if (child == null) goto L15;
        if (Thread.holdsLock(child) == false) goto L15;
        doLog(lock, "Calling thread " + Thread.currentThread().getName() + " is holding " + lockToString(child) + " while trying to acquire " + lockToString(lock));
        triggered = true;
    L15:
        i = i + 1;
        goto L8
    L17:
        if (triggered == true) goto L29;
        int i2 = 0;
    L20:
        if (i2 >= sKnown.size()) goto L29;
        Object test = sKnown.keyAt(i2);
        if (test == null) goto L28;
        if (test == lock) goto L28;
        if (Thread.holdsLock(test) == false) goto L28;
        sKnown.valueAt(i2).children.add(lock);
    L28:
        i2 = i2 + 1;
    L29:
        return lock;
    }

    public static void guard(int index) {
        int i = 0;
    L3:
        if (i >= index) goto L11;
        Object lock = sKnownFixed[i];
        if (lock == null) goto L9;
        if (Thread.holdsLock(lock) == false) goto L9;
        Object targetMayBeNull = sKnownFixed[index];
        doLog(targetMayBeNull, "Calling thread " + Thread.currentThread().getName() + " is holding " + lockToString(i) + " while trying to acquire " + lockToString(index));
    L9:
        i = i + 1;
        goto L3
    }

    private static void doLog(Object lock, String message) {
        if (lock != null) goto L4;
    L7:
        Slog.w(TAG, message, new Throwable());
        return;
    L4:
        if (findOrCreateLockInfo(lock).doWtf == false) goto L7;
        final Throwable stackTrace = new RuntimeException(message);
        new Thread(new LockGuard$$ExternalSyntheticLambda0(stackTrace)).start();
    }

    private static /* synthetic */ void lambda$doLog$0(Throwable stackTrace) {
        Slog.wtf(TAG, stackTrace);
    }

    public static Object installLock(Object lock, String label) {
        LockInfo info = findOrCreateLockInfo(lock);
        info.label = label;
        return lock;
    }

    public static Object installLock(Object lock, int index) {
        return installLock(lock, index, false);
    }

    public static Object installLock(Object lock, int index, boolean doWtf) {
        sKnownFixed[index] = lock;
        LockInfo info = findOrCreateLockInfo(lock);
        info.doWtf = doWtf;
        info.label = "Lock-" + lockToString(index);
        return lock;
    }

    public static Object installNewLock(int index) {
        return installNewLock(index, false);
    }

    public static Object installNewLock(int index, boolean doWtf) {
        Object lock = new Object();
        installLock(lock, index, doWtf);
        return lock;
    }

    private static String lockToString(Object lock) {
        LockInfo info = sKnown.get(lock);
        if (info == null) goto L9;
        if (TextUtils.isEmpty(info.label) == true) goto L9;
        return info.label;
    L9:
        return "0x" + Integer.toHexString(System.identityHashCode(lock));
    }

    private static String lockToString(int index) {
        switch(index) {
            case 0: goto L21;
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L5;
            default: goto L4;
        };
    L5:
        return "DPMS";
    L7:
        return "ACTIVITY";
    L9:
        return "PROCESS";
    L11:
        return "WINDOW";
    L13:
        return "STORAGE";
    L15:
        return "PACKAGES";
    L17:
        return "USER";
    L19:
        return "POWER";
    L21:
        return "APP_OPS";
    L4:
        return Integer.toString(index);
    }

    public static void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        int i = 0;
    L4:
        if (i >= sKnown.size()) goto L11;
        Object lock = sKnown.keyAt(i);
        LockInfo info = sKnown.valueAt(i);
        pw.println("Lock " + lockToString(lock) + ":");
        int j = 0;
    L7:
        if (j >= info.children.size()) goto L9;
        pw.println("  Child " + lockToString(info.children.valueAt(j)));
        j = j + 1;
        goto L7
    L9:
        pw.println();
        i = i + 1;
        goto L4
    }
}
