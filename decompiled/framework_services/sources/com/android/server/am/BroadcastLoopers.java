package com.android.server.am;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.ArraySet;
import android.util.Slog;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes.dex */
public class BroadcastLoopers {
    private static final String TAG = "BroadcastLoopers";
    private static final ArraySet<Looper> sLoopers = null;

    /* JADX INFO: renamed from: $r8$lambda$27Bh_FLEzO8BtN-IYP8CP4CBSmE, reason: not valid java name */
    public static /* synthetic */ boolean m1427$r8$lambda$27Bh_FLEzO8BtNIYP8CP4CBSmE(CountDownLatch r0) {
        return lambda$waitForIdle$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$A2_CfiacArHZQJuYXNQ2IMURYOQ(CountDownLatch r0) {
        lambda$waitForBarrier$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$UyojhGe6Qfb4i3J9e4_peV567S0(Looper r0, CountDownLatch r1) {
        lambda$waitForBarrier$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$fAfZe6hhLlLJsQiwd_u6A62iAyM(Looper r0, CountDownLatch r1) {
        lambda$waitForIdle$1(r0, r1);
    }

    public BroadcastLoopers() {
    }

    static {
        sLoopers = new ArraySet();
    }

    public static void addLooper(Looper looper) {
        ArraySet<Looper> r0 = sLoopers;
        monitor-enter(r0);
        ArraySet<Looper> r1 = sLoopers;     // Catch: Throwable -> L7
        looper.getClass();     // Catch: Throwable -> L7
        r1.add(looper);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void addMyLooper() {
        Looper looper = Looper.myLooper();
        if (looper == null) goto L15;
        ArraySet<Looper> r1 = sLoopers;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sLoopers.add(looper) == false) goto L11;
        Slog.w(TAG, "Found previously unknown looper " + looper.getThread());     // Catch: Throwable -> L9
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    }

    public static void waitForIdle(PrintWriter pw) {
        waitForCondition(pw, new BroadcastLoopers$$ExternalSyntheticLambda1());
    }

    private static /* synthetic */ void lambda$waitForIdle$1(Looper looper, final CountDownLatch latch) {
        MessageQueue queue = looper.getQueue();
        queue.addIdleHandler(new BroadcastLoopers$$ExternalSyntheticLambda0(latch));
    }

    private static /* synthetic */ boolean lambda$waitForIdle$0(CountDownLatch latch) {
        latch.countDown();
        return false;
    }

    public static void waitForBarrier(PrintWriter pw) {
        waitForCondition(pw, new BroadcastLoopers$$ExternalSyntheticLambda2());
    }

    private static /* synthetic */ void lambda$waitForBarrier$3(Looper looper, final CountDownLatch latch) {
        new Handler(looper).post(new BroadcastLoopers$$ExternalSyntheticLambda3(latch));
    }

    private static /* synthetic */ void lambda$waitForBarrier$2(CountDownLatch latch) {
        latch.countDown();
    }

    private static void waitForCondition(PrintWriter pw, BiConsumer<Looper, CountDownLatch> condition) {
        ArraySet<Looper> r0 = sLoopers;
        monitor-enter(r0);
        int N = sLoopers.size();     // Catch: Throwable -> L9
        CountDownLatch latch = new CountDownLatch(N);     // Catch: Throwable -> L9
        int i = 0;
    L5:
        if (i >= N) goto L14;
        Looper looper = sLoopers.valueAt(i);     // Catch: Throwable -> L9
        MessageQueue queue = looper.getQueue();     // Catch: Throwable -> L9
        if (queue.isIdle() == false) goto L11;
        latch.countDown();     // Catch: Throwable -> L9
    L12:
        i = i + 1;     // Catch: Throwable -> L9
        goto L5
    L11:
        condition.accept(looper, latch);     // Catch: Throwable -> L9
        goto L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
        long lastPrint = 0;
    L17:
        if (latch.getCount() <= 0) goto L22;
        long now = SystemClock.uptimeMillis();
        if (now < (1000 + lastPrint)) goto L21;
        lastPrint = now;
        pw.println("Waiting for " + latch.getCount() + " loopers to drain...");
        pw.flush();
    L21:
        SystemClock.sleep(100);
        goto L17
    L22:
        pw.println("Loopers drained!");
        pw.flush();
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
