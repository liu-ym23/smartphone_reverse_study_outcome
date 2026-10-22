package com.android.server.utils;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import android.text.TextUtils;
import android.text.format.TimeMigrationUtils;
import android.util.ArrayMap;
import android.util.CloseGuard;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.android.internal.util.RingBuffer;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AnrTimer<V> implements AutoCloseable {
    private static boolean DEBUG = false;
    static final String TAG = "AnrTimer";
    private static final long TRACE_TAG = 64;
    private static final String TRACK = "AnrTimerTrack";
    private static final LongSparseArray<WeakReference<AnrTimer>> sAnrTimerList = null;
    private static final Comparator<AnrTimer> sComparator = null;
    private static final Injector sDefaultInjector = null;
    private static final RingBuffer<Error> sErrors = null;
    private final Args mArgs;
    private final AnrTimer<V>.FeatureSwitch mFeature;
    private final Handler mHandler;
    private final String mLabel;
    private final Object mLock;
    private int mMaxStarted;
    private final SparseArray<V> mTimerArgMap;
    private final ArrayMap<V, Integer> mTimerIdMap;
    private int mTotalErrors;
    private int mTotalExpired;
    private int mTotalStarted;
    private final int mWhat;

    public static class Args {
        private boolean mExtend;
        boolean mFreeze;
        private Injector mInjector;

        /* JADX INFO: renamed from: -$$Nest$fgetmExtend, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m9252$$Nest$fgetmExtend(Args r0) {
            return r0.mExtend;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
        static /* bridge */ /* synthetic */ Injector m9253$$Nest$fgetmInjector(Args r0) {
            return r0.mInjector;
        }

        public Args() {
            this.mInjector = AnrTimer.m9242$$Nest$sfgetsDefaultInjector();
            this.mExtend = false;
            this.mFreeze = false;
        }

        Args injector(Injector injector) {
            this.mInjector = injector;
            return this;
        }

        public Args extend(boolean flag) {
            this.mExtend = flag;
            return this;
        }

        public Args freeze(boolean enable) {
            this.mFreeze = enable;
            return this;
        }
    }

    private static final class Error {
        final String arg;
        final String issue;
        final String operation;
        final StackTraceElement[] stack;
        final String tag;
        final long timestamp;

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9254$$Nest$mdump(Error r0, IndentingPrintWriter r1, int r2) {
            r0.dump(r1, r2);
        }

        Error(String issue, String operation, String tag, StackTraceElement[] stack, String arg) {
            this.issue = issue;
            this.operation = operation;
            this.tag = tag;
            this.stack = stack;
            this.arg = arg;
            this.timestamp = SystemClock.elapsedRealtime();
        }

        private void dump(IndentingPrintWriter ipw, int seq) {
            ipw.format("%2d: op:%s tag:%s issue:%s arg:%s\n", new Object[]{Integer.valueOf(seq), this.operation, this.tag, this.issue, this.arg});
            long offset = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            long etime = this.timestamp + offset;
            ipw.println("    date:" + TimeMigrationUtils.formatMillisWithFixedFormat(etime));
            ipw.increaseIndent();
            int i = 0;
        L4:
            if (i >= this.stack.length) goto L6;
            ipw.println("    " + this.stack[i].toString());
            i = i + 1;
            goto L4
        L6:
            ipw.decreaseIndent();
        }
    }

    private class FeatureDisabled extends AnrTimer<V>.FeatureSwitch {
        final /* synthetic */ AnrTimer this$0;

        /* synthetic */ FeatureDisabled(AnrTimer r1, AnrTimerIA r2) {
            this(r1);
        }

        private FeatureDisabled(AnrTimer r2) {
            this.this$0 = r2;
            super(r2, null);
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        void start(V arg, int pid, int uid, long timeoutMs) {
            Message msg = AnrTimer.m9225$$Nest$fgetmHandler(this.this$0).obtainMessage(AnrTimer.m9234$$Nest$fgetmWhat(this.this$0), arg);
            AnrTimer.m9225$$Nest$fgetmHandler(this.this$0).sendMessageDelayed(msg, timeoutMs);
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        boolean cancel(V arg) {
            AnrTimer.m9225$$Nest$fgetmHandler(this.this$0).removeMessages(AnrTimer.m9234$$Nest$fgetmWhat(this.this$0), arg);
            return true;
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        AnrTimer<V>.TimerLock accept(V arg) {
            return null;
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        boolean discard(V arg) {
            return true;
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        void release(AnrTimer<V>.TimerLock timer) {
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        boolean enabled() {
            return false;
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        void dump(IndentingPrintWriter pw, boolean verbose) {
            Object r0 = AnrTimer.m9227$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            pw.format("started=%d maxStarted=%d running=%d expired=%d errors=%d\n", new Object[]{Integer.valueOf(AnrTimer.m9233$$Nest$fgetmTotalStarted(this.this$0)), Integer.valueOf(AnrTimer.m9228$$Nest$fgetmMaxStarted(this.this$0)), Integer.valueOf(AnrTimer.m9230$$Nest$fgetmTimerIdMap(this.this$0).size()), Integer.valueOf(AnrTimer.m9232$$Nest$fgetmTotalExpired(this.this$0)), Integer.valueOf(AnrTimer.m9231$$Nest$fgetmTotalErrors(this.this$0))});     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        void close() {
        }
    }

    private class FeatureEnabled extends AnrTimer<V>.FeatureSwitch {
        private long mNative;
        private int mTotalRestarted;
        final /* synthetic */ AnrTimer this$0;

        FeatureEnabled(AnrTimer r7) {
            this.this$0 = r7;
            super(r7, null);
            this.mNative = 0;
            boolean r2 = false;
            this.mTotalRestarted = 0;
            String r3 = AnrTimer.m9226$$Nest$fgetmLabel(r7);
            boolean r4 = Args.m9252$$Nest$fgetmExtend(AnrTimer.m9224$$Nest$fgetmArgs(r7));
            if (AnrTimer.m9224$$Nest$fgetmArgs(r7).mFreeze == true) goto L5;
        L8:
            this.mNative = AnrTimer.m9237$$Nest$mnativeAnrTimerCreate(r7, r3, r4, r2);
            if (this.mNative == 0) goto L19;
            LongSparseArray r0 = AnrTimer.m9241$$Nest$sfgetsAnrTimerList();
            monitor-enter(r0);
            AnrTimer.m9241$$Nest$sfgetsAnrTimerList().put(this.mNative, new WeakReference(r7));     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        L19:
            throw new IllegalArgumentException("unable to create native timer");
        L5:
            if (Args.m9253$$Nest$fgetmInjector(AnrTimer.m9224$$Nest$fgetmArgs(r7)).freezerEnabled() == false) goto L8;
            r2 = true;
            goto L8
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        void start(V arg, int pid, int uid, long timeoutMs) {
            Object r1 = AnrTimer.m9227$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L17:
            th = th;
        L23:
            monitor-exit(r1);     // Catch: Throwable -> L17
            throw th;
        L21:
            th = th;
            goto L23
        L5:
            if (cancel(arg) == true) goto L26;
        L10:
            int timerId = AnrTimer.m9251$$Nest$smnativeAnrTimerStart(this.mNative, pid, uid, timeoutMs);     // Catch: Throwable -> L17
            if (timerId <= 0) goto L20;
            AnrTimer.m9230$$Nest$fgetmTimerIdMap(this.this$0).put(arg, Integer.valueOf(timerId));     // Catch: Throwable -> L17
            AnrTimer.m9229$$Nest$fgetmTimerArgMap(this.this$0).put(timerId, arg);     // Catch: Throwable -> L17
            AnrTimer r11 = this.this$0;     // Catch: Throwable -> L17
            AnrTimer.m9236$$Nest$fputmTotalStarted(r11, AnrTimer.m9233$$Nest$fgetmTotalStarted(r11) + 1);     // Catch: Throwable -> L17
            AnrTimer.m9235$$Nest$fputmMaxStarted(this.this$0, Math.max(AnrTimer.m9228$$Nest$fgetmMaxStarted(this.this$0), AnrTimer.m9230$$Nest$fgetmTimerIdMap(this.this$0).size()));     // Catch: Throwable -> L17
            monitor-exit(r1);     // Catch: Throwable -> L17
            return;
        L20:
            throw new RuntimeException("unable to start timer");     // Catch: Throwable -> L17
        L26:
            this.mTotalRestarted++;     // Catch: Throwable -> L8
        L8:
            th = th;
            goto L23
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        boolean cancel(V arg) {
            Object r0 = AnrTimer.m9227$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            Integer timer = removeLocked(arg);     // Catch: Throwable -> L8
            if (timer != null) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L11:
            if (AnrTimer.m9246$$Nest$smnativeAnrTimerCancel(this.mNative, timer.intValue()) == true) goto L15;
            AnrTimer.m9225$$Nest$fgetmHandler(this.this$0).removeMessages(AnrTimer.m9234$$Nest$fgetmWhat(this.this$0), arg);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return true;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        AnrTimer<V>.TimerLock accept(V arg) {
            Object r0 = AnrTimer.m9227$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            Integer timer = removeLocked(arg);     // Catch: Throwable -> L9
            AnrTimer<V>.TimerLock r2 = null;
            if (timer != null) goto L11;
            AnrTimer.m9238$$Nest$mnotFoundLocked(this.this$0, "accept", arg);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return null;
        L11:
            boolean accepted = AnrTimer.m9245$$Nest$smnativeAnrTimerAccept(this.mNative, timer.intValue());     // Catch: Throwable -> L9
            AnrTimer.m9240$$Nest$mtrace(this.this$0, "accept", timer.intValue());     // Catch: Throwable -> L9
            if (accepted == false) goto L14;
            r2 = new TimerLock(this.this$0, timer.intValue());     // Catch: Throwable -> L9
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L9:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        boolean discard(V arg) {
            Object r0 = AnrTimer.m9227$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            Integer timer = removeLocked(arg);     // Catch: Throwable -> L10
            if (timer != null) goto L12;
            AnrTimer.m9238$$Nest$mnotFoundLocked(this.this$0, "discard", arg);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return false;
        L12:
            AnrTimer.m9248$$Nest$smnativeAnrTimerDiscard(this.mNative, timer.intValue());     // Catch: Throwable -> L10
            AnrTimer.m9240$$Nest$mtrace(this.this$0, "discard", timer.intValue());     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return true;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        void release(AnrTimer<V>.TimerLock t) {
            if (t.mTimerId != 0) goto L6;
            return;
        L6:
            if (AnrTimer.m9250$$Nest$smnativeAnrTimerRelease(this.mNative, t.mTimerId) == true) goto L9;
            Log.e(AnrTimer.TAG, "failed to release id=" + t.mTimerId, new Exception(AnrTimer.TAG));
            return;
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        boolean enabled() {
            return true;
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        void dump(IndentingPrintWriter pw, boolean verbose) {
            Object r0 = AnrTimer.m9227$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mNative != 0) goto L11;
            pw.println("closed");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L11:
            String[] nativeDump = AnrTimer.m9249$$Nest$smnativeAnrTimerDump(this.mNative);     // Catch: Throwable -> L9
            if (nativeDump != null) goto L16;
            pw.println("no-data");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L16:
            int r2 = nativeDump.length;     // Catch: Throwable -> L9
            int r3 = 0;
        L17:
            if (r3 >= r2) goto L19;
            String s = nativeDump[r3];     // Catch: Throwable -> L9
            pw.println(s);     // Catch: Throwable -> L9
            r3 = r3 + 1;     // Catch: Throwable -> L9
            goto L17
        L19:
            pw.println("restarted:" + this.mTotalRestarted);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
        }

        @Override // com.android.server.utils.AnrTimer.FeatureSwitch
        void close() {
            LongSparseArray r0 = AnrTimer.m9241$$Nest$sfgetsAnrTimerList();
            monitor-enter(r0);
            AnrTimer.m9241$$Nest$sfgetsAnrTimerList().remove(this.mNative);     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
            Object r1 = AnrTimer.m9227$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L9:
            if (this.mNative == 0) goto L13;
            AnrTimer.m9247$$Nest$smnativeAnrTimerClose(this.mNative);     // Catch: Throwable -> L11
        L13:
            this.mNative = 0;     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L18:
            th = move-exception;
            throw th;
        }

        private Integer removeLocked(V arg) {
            Integer r = (Integer) AnrTimer.m9230$$Nest$fgetmTimerIdMap(this.this$0).remove(arg);
            if (r == null) goto L5;
            AnrTimer.m9229$$Nest$fgetmTimerArgMap(this.this$0).remove(r.intValue());
        L5:
            return r;
        }
    }

    private abstract class FeatureSwitch {
        /* synthetic */ FeatureSwitch(AnrTimer r1, AnrTimerIA r2) {
            this(r1);
        }

        abstract AnrTimer<V>.TimerLock accept(V r1);

        abstract boolean cancel(V r1);

        abstract void close();

        abstract boolean discard(V r1);

        abstract void dump(IndentingPrintWriter r1, boolean r2);

        abstract boolean enabled();

        abstract void release(AnrTimer<V>.TimerLock r1);

        abstract void start(V r1, int r2, int r3, long r4);

        private FeatureSwitch(AnrTimer r1) {
        }
    }

    static class Injector {
        Injector() {
        }

        boolean serviceEnabled() {
            return AnrTimer.m9243$$Nest$smanrTimerServiceEnabled();
        }

        boolean freezerEnabled() {
            return AnrTimer.m9244$$Nest$smfreezerFeatureEnabled();
        }

        boolean traceEnabled() {
            return AnrTimer.traceFeatureEnabled();
        }
    }

    private class TimerLock implements AutoCloseable {
        private boolean mClosed;
        private final CloseGuard mGuard;
        private final Object mLock;
        final int mTimerId;
        final /* synthetic */ AnrTimer this$0;

        TimerLock(AnrTimer r2, int timerId) {
            this.this$0 = r2;
            this.mGuard = new CloseGuard();
            this.mLock = new Object();
            this.mClosed = false;
            this.mTimerId = timerId;
            this.mGuard.open("AnrTimer.release");
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mClosed == true) goto L9;
            AnrTimer.m9239$$Nest$mrelease(this.this$0, this);     // Catch: Throwable -> L7
            this.mGuard.close();     // Catch: Throwable -> L7
            this.mClosed = true;     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        protected void finalize() throws Throwable {
        L5:
            th = move-exception;
            super.finalize();
            throw th;
        L3:
            if (this.mGuard == null) goto L7;
            this.mGuard.warnIfOpen();     // Catch: Throwable -> L5
        L7:
            close();     // Catch: Throwable -> L5
            super.finalize();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmArgs, reason: not valid java name */
    static /* bridge */ /* synthetic */ Args m9224$$Nest$fgetmArgs(AnrTimer r0) {
        return r0.mArgs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m9225$$Nest$fgetmHandler(AnrTimer r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLabel, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9226$$Nest$fgetmLabel(AnrTimer r0) {
        return r0.mLabel;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9227$$Nest$fgetmLock(AnrTimer r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMaxStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9228$$Nest$fgetmMaxStarted(AnrTimer r0) {
        return r0.mMaxStarted;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTimerArgMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m9229$$Nest$fgetmTimerArgMap(AnrTimer r0) {
        return r0.mTimerArgMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTimerIdMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m9230$$Nest$fgetmTimerIdMap(AnrTimer r0) {
        return r0.mTimerIdMap;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTotalErrors, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9231$$Nest$fgetmTotalErrors(AnrTimer r0) {
        return r0.mTotalErrors;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTotalExpired, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9232$$Nest$fgetmTotalExpired(AnrTimer r0) {
        return r0.mTotalExpired;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTotalStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9233$$Nest$fgetmTotalStarted(AnrTimer r0) {
        return r0.mTotalStarted;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWhat, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9234$$Nest$fgetmWhat(AnrTimer r0) {
        return r0.mWhat;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMaxStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9235$$Nest$fputmMaxStarted(AnrTimer r0, int r1) {
        r0.mMaxStarted = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTotalStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9236$$Nest$fputmTotalStarted(AnrTimer r0, int r1) {
        r0.mTotalStarted = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mnativeAnrTimerCreate, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m9237$$Nest$mnativeAnrTimerCreate(AnrTimer r0, String r1, boolean r2, boolean r3) {
        return r0.nativeAnrTimerCreate(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotFoundLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9238$$Nest$mnotFoundLocked(AnrTimer r0, String r1, Object r2) {
        r0.notFoundLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mrelease, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9239$$Nest$mrelease(AnrTimer r0, TimerLock r1) {
        r0.release(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mtrace, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9240$$Nest$mtrace(AnrTimer r0, String r1, int r2) {
        r0.trace(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsAnrTimerList, reason: not valid java name */
    static /* bridge */ /* synthetic */ LongSparseArray m9241$$Nest$sfgetsAnrTimerList() {
        return sAnrTimerList;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsDefaultInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m9242$$Nest$sfgetsDefaultInjector() {
        return sDefaultInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$smanrTimerServiceEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9243$$Nest$smanrTimerServiceEnabled() {
        return anrTimerServiceEnabled();
    }

    /* JADX INFO: renamed from: -$$Nest$smfreezerFeatureEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9244$$Nest$smfreezerFeatureEnabled() {
        return freezerFeatureEnabled();
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeAnrTimerAccept, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9245$$Nest$smnativeAnrTimerAccept(long r0, int r2) {
        return nativeAnrTimerAccept(r0, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeAnrTimerCancel, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9246$$Nest$smnativeAnrTimerCancel(long r0, int r2) {
        return nativeAnrTimerCancel(r0, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeAnrTimerClose, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9247$$Nest$smnativeAnrTimerClose(long r0) {
        return nativeAnrTimerClose(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeAnrTimerDiscard, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9248$$Nest$smnativeAnrTimerDiscard(long r0, int r2) {
        return nativeAnrTimerDiscard(r0, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeAnrTimerDump, reason: not valid java name */
    static /* bridge */ /* synthetic */ String[] m9249$$Nest$smnativeAnrTimerDump(long r0) {
        return nativeAnrTimerDump(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeAnrTimerRelease, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9250$$Nest$smnativeAnrTimerRelease(long r0, int r2) {
        return nativeAnrTimerRelease(r0, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smnativeAnrTimerStart, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9251$$Nest$smnativeAnrTimerStart(long r0, int r2, int r3, long r4) {
        return nativeAnrTimerStart(r0, r2, r3, r4);
    }

    private static native boolean nativeAnrTimerAccept(long r0, int r2);

    private static native boolean nativeAnrTimerCancel(long r0, int r2);

    private static native int nativeAnrTimerClose(long r0);

    private native long nativeAnrTimerCreate(String r1, boolean r2, boolean r3);

    private static native boolean nativeAnrTimerDiscard(long r0, int r2);

    private static native String[] nativeAnrTimerDump(long r0);

    private static native boolean nativeAnrTimerRelease(long r0, int r2);

    private static native int nativeAnrTimerStart(long r0, int r2, int r3, long r4);

    private static native boolean nativeAnrTimerSupported();

    private static native String nativeAnrTimerTrace(String[] r0);

    public abstract int getPid(V r1);

    public abstract int getUid(V r1);

    static {
        DEBUG = false;
        sDefaultInjector = new Injector();
        sErrors = new RingBuffer(Error.class, 20);
        sAnrTimerList = new LongSparseArray();
        sComparator = Comparator.nullsLast(new AnonymousClass1());
    }

    private static boolean anrTimerServiceEnabled() {
        return true;
    }

    private static boolean freezerFeatureEnabled() {
        return false;
    }

    public static boolean traceFeatureEnabled() {
        anrTimerServiceEnabled();
        return false;
    }

    public AnrTimer(Handler handler, int what, String label, Args args) {
        this.mLock = new Object();
        this.mTimerIdMap = new ArrayMap();
        this.mTimerArgMap = new SparseArray();
        boolean enabled = false;
        this.mMaxStarted = 0;
        this.mTotalStarted = 0;
        this.mTotalErrors = 0;
        this.mTotalExpired = 0;
        this.mHandler = handler;
        this.mWhat = what;
        this.mLabel = label;
        this.mArgs = args;
        if (Args.m9253$$Nest$fgetmInjector(args).serviceEnabled() == true) goto L5;
    L7:
        this.mFeature = createFeatureSwitch(enabled);
        return;
    L5:
        if (nativeTimersSupported() == false) goto L7;
        enabled = true;
        goto L7
    }

    private AnrTimer<V>.FeatureSwitch createFeatureSwitch(boolean enabled) {
        AnrTimerIA r0 = null;
        if (enabled == false) goto L5;
        return new FeatureEnabled(this);
    L8:
        e = move-exception;
        Log.e(TAG, e.toString());
        return new FeatureDisabled(this, r0);
    L5:
        return new FeatureDisabled(this, r0);
    }

    public AnrTimer(Handler handler, int what, String label) {
        this(handler, what, label, new Args());
    }

    public boolean serviceEnabled() {
        return this.mFeature.enabled();
    }

    private void trace(String op, int timerId, int pid, int uid, long milliseconds) {
        String label = TextUtils.formatSimple("%s(%d,%d,%d,%s,%d)", new Object[]{op, Integer.valueOf(timerId), Integer.valueOf(pid), Integer.valueOf(uid), this.mLabel, Long.valueOf(milliseconds)});
        Trace.instantForTrack(64, TRACK, label);
        if (DEBUG == false) goto L6;
        Log.i(TAG, label);
        return;
    }

    private void trace(String op, int timerId) {
        String label = TextUtils.formatSimple("%s(%d)", new Object[]{op, Integer.valueOf(timerId)});
        Trace.instantForTrack(64, TRACK, label);
        if (DEBUG == false) goto L6;
        Log.i(TAG, label);
        return;
    }

    private static void trace(String op, int pid, int uid) {
        String label = TextUtils.formatSimple("%s(%d,%d)", new Object[]{op, Integer.valueOf(pid), Integer.valueOf(uid)});
        Trace.instantForTrack(64, TRACK, label);
        if (DEBUG == false) goto L6;
        Log.i(TAG, label);
        return;
    }

    public void start(V arg, long timeoutMs) {
        if (timeoutMs >= 0) goto L5;
        timeoutMs = 0;
    L5:
        AnrTimer<V>.FeatureSwitch r0 = this.mFeature;
        int r2 = getPid(arg);
        int r3 = getUid(arg);
        r0.start(arg, r2, r3, timeoutMs);
    }

    public boolean cancel(V arg) {
        return this.mFeature.cancel(arg);
    }

    public AnrTimer<V>.TimerLock accept(V arg) {
        return this.mFeature.accept(arg);
    }

    public boolean discard(V arg) {
        return this.mFeature.discard(arg);
    }

    private void release(AnrTimer<V>.TimerLock t) {
        this.mFeature.release(t);
    }

    private boolean expire(int timerId, int pid, int uid, long elapsedMs) {
        trace("expired", timerId, pid, uid, elapsedMs);
        Object r10 = this.mLock;
        monitor-enter(r10);
        V arg = this.mTimerArgMap.get(timerId);     // Catch: Throwable -> L10
        if (arg != null) goto L12;
        Log.e(TAG, TextUtils.formatSimple("failed to expire timer %s:%d : arg not found", new Object[]{this.mLabel, Integer.valueOf(timerId)}));     // Catch: Throwable -> L10
        this.mTotalErrors++;     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return false;
    L12:
        this.mTotalExpired++;     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        this.mHandler.sendMessage(Message.obtain(this.mHandler, this.mWhat, arg));
        return true;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.mFeature.close();
    }

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    private void dump(IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.format("timer: %s\n", new Object[]{this.mLabel});     // Catch: Throwable -> L7
        pw.increaseIndent();     // Catch: Throwable -> L7
        this.mFeature.dump(pw, false);     // Catch: Throwable -> L7
        pw.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static void debug(boolean f) {
        DEBUG = f;
    }

    private static long now() {
        return SystemClock.uptimeMillis();
    }

    private static void dumpErrors(IndentingPrintWriter ipw) {
        RingBuffer<Error> r0 = sErrors;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (sErrors.size() != 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Error[] errors = (Error[]) sErrors.toArray();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        ipw.println("Errors");
        ipw.increaseIndent();
        int i = 0;
    L14:
        if (i >= errors.length) goto L19;
        if (errors[i] == null) goto L18;
        Error.m9254$$Nest$mdump(errors[i], ipw, i);
    L18:
        i = i + 1;
        goto L14
    L19:
        ipw.decreaseIndent();
    }

    private void recordErrorLocked(String operation, String errorMsg, Object arg) {
        StackTraceElement[] s = Thread.currentThread().getStackTrace();
        String what = Objects.toString(arg);
        StackTraceElement[] location = (StackTraceElement[]) Arrays.copyOfRange(s, 6, 9);
        RingBuffer<Error> r8 = sErrors;
        monitor-enter(r8);
        sErrors.append(new Error(errorMsg, operation, this.mLabel, location, what));     // Catch: Throwable -> L13
        monitor-exit(r8);     // Catch: Throwable -> L13
        if (DEBUG == false) goto L11;
        Log.w(TAG, operation + " " + errorMsg + " " + this.mLabel + " timer " + what);
    L11:
        this.mTotalErrors++;
        return;
    L15:
        th = move-exception;
        Throwable r10 = th;
    L17:
        monitor-exit(r8);     // Catch: Throwable -> L13
        throw r10;
    L13:
        th = move-exception;
        r10 = th;
        goto L17
    }

    private void notFoundLocked(String operation, Object arg) {
        recordErrorLocked(operation, "notFound", arg);
    }

    static void dump(PrintWriter pw, boolean verbose, Injector injector) {
        if (injector.serviceEnabled() == true) goto L5;
        return;
    L5:
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw);
        ipw.println("AnrTimer statistics");
        ipw.increaseIndent();
        LongSparseArray<WeakReference<AnrTimer>> r1 = sAnrTimerList;
        monitor-enter(r1);
        int size = sAnrTimerList.size();     // Catch: Throwable -> L12
        AnrTimer[] active = new AnrTimer[size];     // Catch: Throwable -> L12
        int valid = 0;
        int i = 0;
    L8:
        if (i >= size) goto L15;
        AnrTimer a = sAnrTimerList.valueAt(i).get();     // Catch: Throwable -> L12
        if (a == null) goto L14;
        active[valid] = a;     // Catch: Throwable -> L12
        valid = valid + 1;     // Catch: Throwable -> L12
    L14:
        i = i + 1;     // Catch: Throwable -> L12
        goto L8
    L15:
        Arrays.sort(active, 0, valid, sComparator);     // Catch: Throwable -> L12
        int i2 = 0;
    L16:
        if (i2 >= valid) goto L22;
        if (active[i2] == null) goto L20;
        active[i2].dump(ipw);     // Catch: Throwable -> L12
    L20:
        i2 = i2 + 1;     // Catch: Throwable -> L12
        goto L16
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L12
        if (verbose == false) goto L25;
        dumpErrors(ipw);
    L25:
        ipw.format("AnrTimerEnd\n", new Object[0]);
        ipw.decreaseIndent();
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void dump(PrintWriter pw, boolean verbose) {
        dump(pw, verbose, sDefaultInjector);
    }

    public static String traceTimers(String[] spec) {
        return nativeAnrTimerTrace(spec);
    }

    public static boolean nativeTimersSupported() {
        return nativeAnrTimerSupported();
    L5:
        return false;
    }
}
