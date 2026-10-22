package com.android.server.inputmethod;

import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.inputmethod.ImeTracker;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.inputmethod.IImeTracker;
import com.android.internal.inputmethod.InputMethodDebug;
import com.android.internal.util.FrameworkStatsLog;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Locale;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class ImeTrackerService extends IImeTracker.Stub {
    private static final String TAG = "ImeTracker";
    private static final long TIMEOUT_MS = 10000;
    private final Handler mHandler;
    private final History mHistory;
    private final Object mLock;

    private static final class History {
        private static final int CAPACITY = 100;
        private static final AtomicInteger sSequenceNumber = null;
        private final ArrayDeque<Entry> mEntries;
        private final WeakHashMap<IBinder, Entry> mLiveEntries;

        private static final class Entry {
            private long mDuration;
            private final boolean mFromUser;
            private final int mOrigin;
            private int mPhase;
            private final int mReason;
            private String mRequestWindowName;
            private final int mSequenceNumber;
            private final long mStartTime;
            private int mStatus;
            private final String mTag;
            private final int mType;
            private final int mUid;

            /* JADX INFO: renamed from: -$$Nest$fgetmDuration, reason: not valid java name */
            static /* bridge */ /* synthetic */ long m4649$$Nest$fgetmDuration(Entry r2) {
                return r2.mDuration;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmFromUser, reason: not valid java name */
            static /* bridge */ /* synthetic */ boolean m4650$$Nest$fgetmFromUser(Entry r0) {
                return r0.mFromUser;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmOrigin, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m4651$$Nest$fgetmOrigin(Entry r0) {
                return r0.mOrigin;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmPhase, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m4652$$Nest$fgetmPhase(Entry r0) {
                return r0.mPhase;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmReason, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m4653$$Nest$fgetmReason(Entry r0) {
                return r0.mReason;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmRequestWindowName, reason: not valid java name */
            static /* bridge */ /* synthetic */ String m4654$$Nest$fgetmRequestWindowName(Entry r0) {
                return r0.mRequestWindowName;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmSequenceNumber, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m4655$$Nest$fgetmSequenceNumber(Entry r0) {
                return r0.mSequenceNumber;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmStartTime, reason: not valid java name */
            static /* bridge */ /* synthetic */ long m4656$$Nest$fgetmStartTime(Entry r2) {
                return r2.mStartTime;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmStatus, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m4657$$Nest$fgetmStatus(Entry r0) {
                return r0.mStatus;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmTag, reason: not valid java name */
            static /* bridge */ /* synthetic */ String m4658$$Nest$fgetmTag(Entry r0) {
                return r0.mTag;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmType, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m4659$$Nest$fgetmType(Entry r0) {
                return r0.mType;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmUid, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m4660$$Nest$fgetmUid(Entry r0) {
                return r0.mUid;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmDuration, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m4661$$Nest$fputmDuration(Entry r0, long r1) {
                r0.mDuration = r1;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmPhase, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m4662$$Nest$fputmPhase(Entry r0, int r1) {
                r0.mPhase = r1;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmRequestWindowName, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m4663$$Nest$fputmRequestWindowName(Entry r0, String r1) {
                r0.mRequestWindowName = r1;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmStatus, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m4664$$Nest$fputmStatus(Entry r0, int r1) {
                r0.mStatus = r1;
            }

            /* synthetic */ Entry(String r1, int r2, int r3, int r4, int r5, int r6, boolean r7, ImeTrackerServiceIA r8) {
                this(r1, r2, r3, r4, r5, r6, r7);
            }

            private Entry(String tag, int uid, int type, int status, int origin, int reason, boolean fromUser) {
                this.mSequenceNumber = History.m4648$$Nest$sfgetsSequenceNumber().getAndIncrement();
                this.mStartTime = System.currentTimeMillis();
                this.mDuration = 0;
                this.mPhase = 0;
                this.mRequestWindowName = "not set";
                this.mTag = tag;
                this.mUid = uid;
                this.mType = type;
                this.mStatus = status;
                this.mOrigin = origin;
                this.mReason = reason;
                this.mFromUser = fromUser;
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLiveEntries, reason: not valid java name */
        static /* bridge */ /* synthetic */ WeakHashMap m4643$$Nest$fgetmLiveEntries(History r0) {
            return r0.mLiveEntries;
        }

        /* JADX INFO: renamed from: -$$Nest$maddEntry, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4644$$Nest$maddEntry(History r0, IBinder r1, Entry r2) {
            r0.addEntry(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4645$$Nest$mdump(History r0, PrintWriter r1, String r2) {
            r0.dump(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetEntry, reason: not valid java name */
        static /* bridge */ /* synthetic */ Entry m4646$$Nest$mgetEntry(History r0, IBinder r1) {
            return r0.getEntry(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetFinished, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4647$$Nest$msetFinished(History r0, ImeTracker.Token r1, int r2, int r3) {
            r0.setFinished(r1, r2, r3);
        }

        /* JADX INFO: renamed from: -$$Nest$sfgetsSequenceNumber, reason: not valid java name */
        static /* bridge */ /* synthetic */ AtomicInteger m4648$$Nest$sfgetsSequenceNumber() {
            return sSequenceNumber;
        }

        /* synthetic */ History(ImeTrackerServiceIA r1) {
            this();
        }

        private History() {
            this.mEntries = new ArrayDeque(100);
            this.mLiveEntries = new WeakHashMap();
        }

        static {
            sSequenceNumber = new AtomicInteger(0);
        }

        private void addEntry(IBinder binder, Entry entry) {
            this.mLiveEntries.put(binder, entry);
        }

        private Entry getEntry(IBinder binder) {
            return this.mLiveEntries.get(binder);
        }

        private void setFinished(ImeTracker.Token statsToken, int status, int phase) {
            Entry entry = this.mLiveEntries.remove(statsToken.getBinder());
            if (entry != null) goto L7;
            if (status == 5) goto L19;
            Log.i(ImeTrackerService.TAG, statsToken.getTag() + ": setFinished on previously finished token at " + ImeTracker.Debug.phaseToString(phase) + " with " + ImeTracker.Debug.statusToString(status));
            return;
        L19:
            return;
        L7:
            Entry.m4661$$Nest$fputmDuration(entry, System.currentTimeMillis() - Entry.m4656$$Nest$fgetmStartTime(entry));
            Entry.m4664$$Nest$fputmStatus(entry, status);
            if (phase == 0) goto L10;
            Entry.m4662$$Nest$fputmPhase(entry, phase);
        L10:
            if (status != 5) goto L13;
            Log.i(ImeTrackerService.TAG, statsToken.getTag() + ": setFinished at " + ImeTracker.Debug.phaseToString(Entry.m4652$$Nest$fgetmPhase(entry)) + " with " + ImeTracker.Debug.statusToString(status));
        L13:
            if (this.mEntries.size() < 100) goto L15;
            this.mEntries.remove();
            goto L13
        L15:
            this.mEntries.offer(entry);
            FrameworkStatsLog.write(FrameworkStatsLog.IME_REQUEST_FINISHED, Entry.m4660$$Nest$fgetmUid(entry), Entry.m4649$$Nest$fgetmDuration(entry), Entry.m4659$$Nest$fgetmType(entry), Entry.m4657$$Nest$fgetmStatus(entry), Entry.m4653$$Nest$fgetmReason(entry), Entry.m4651$$Nest$fgetmOrigin(entry), Entry.m4652$$Nest$fgetmPhase(entry), Entry.m4650$$Nest$fgetmFromUser(entry));
        }

        private void dump(PrintWriter pw, String prefix) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).withZone(ZoneId.systemDefault());
            pw.print(prefix);
            pw.println("mLiveEntries: " + this.mLiveEntries.size() + " elements");
            Iterator<Entry> r1 = this.mLiveEntries.values().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            Entry entry = r1.next();
            dumpEntry(entry, pw, prefix + "  ", formatter);
            goto L4
        L6:
            pw.print(prefix);
            pw.println("mEntries: " + this.mEntries.size() + " elements");
            Iterator<Entry> r2 = this.mEntries.iterator();
        L8:
            if (r2.hasNext() == false) goto L10;
            Entry entry2 = r2.next();
            dumpEntry(entry2, pw, prefix + "  ", formatter);
            goto L8
        }

        private void dumpEntry(Entry entry, PrintWriter pw, String prefix, DateTimeFormatter formatter) {
            pw.print(prefix);
            pw.print("#" + Entry.m4655$$Nest$fgetmSequenceNumber(entry));
            pw.print(" " + ImeTracker.Debug.typeToString(Entry.m4659$$Nest$fgetmType(entry)));
            pw.print(" - " + ImeTracker.Debug.statusToString(Entry.m4657$$Nest$fgetmStatus(entry)));
            pw.print(" - " + Entry.m4658$$Nest$fgetmTag(entry));
            pw.println(" (" + Entry.m4649$$Nest$fgetmDuration(entry) + "ms):");
            pw.print(prefix);
            pw.print("  startTime=" + formatter.format(Instant.ofEpochMilli(Entry.m4656$$Nest$fgetmStartTime(entry))));
            pw.println(" " + ImeTracker.Debug.originToString(Entry.m4651$$Nest$fgetmOrigin(entry)));
            pw.print(prefix);
            pw.print("  reason=" + InputMethodDebug.softInputDisplayReasonToString(Entry.m4653$$Nest$fgetmReason(entry)));
            pw.println(" " + ImeTracker.Debug.phaseToString(Entry.m4652$$Nest$fgetmPhase(entry)));
            pw.print(prefix);
            pw.println("  requestWindowName=" + Entry.m4654$$Nest$fgetmRequestWindowName(entry));
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$as-auvynjuukEdh6H7yFFRfTTOk, reason: not valid java name */
    public static /* synthetic */ void m4642$r8$lambda$asauvynjuukEdh6H7yFFRfTTOk(ImeTrackerService r0, ImeTracker.Token r1) {
        r0.lambda$onStart$0(r1);
    }

    ImeTrackerService(Handler handler) {
        this.mHistory = new History(null);
        this.mLock = new Object();
        this.mHandler = handler;
    }

    public ImeTracker.Token onStart(String tag, int uid, int type, int origin, int reason, boolean fromUser) {
        Binder binder = new Binder();
        final ImeTracker.Token token = new ImeTracker.Token(binder, tag);
        History.Entry entry = new History.Entry(tag, uid, type, 1, origin, reason, fromUser, null);
        Object r4 = this.mLock;
        monitor-enter(r4);
        History.m4644$$Nest$maddEntry(this.mHistory, binder, entry);     // Catch: Throwable -> L7
        this.mHandler.postDelayed(new ImeTrackerService$$ExternalSyntheticLambda0(this, token), 10000);     // Catch: Throwable -> L7
        monitor-exit(r4);     // Catch: Throwable -> L7
        return token;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onStart$0(ImeTracker.Token token) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        History.m4647$$Nest$msetFinished(this.mHistory, token, 5, 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onProgress(IBinder binder, int phase) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        History.Entry entry = History.m4646$$Nest$mgetEntry(this.mHistory, binder);     // Catch: Throwable -> L8
        if (entry != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        History.Entry.m4662$$Nest$fputmPhase(entry, phase);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void onFailed(ImeTracker.Token statsToken, int phase) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        History.m4647$$Nest$msetFinished(this.mHistory, statsToken, 3, phase);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onCancelled(ImeTracker.Token statsToken, int phase) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        History.m4647$$Nest$msetFinished(this.mHistory, statsToken, 2, phase);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onShown(ImeTracker.Token statsToken) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        History.m4647$$Nest$msetFinished(this.mHistory, statsToken, 4, 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onHidden(ImeTracker.Token statsToken) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        History.m4647$$Nest$msetFinished(this.mHistory, statsToken, 4, 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onDispatched(ImeTracker.Token statsToken) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        History.m4647$$Nest$msetFinished(this.mHistory, statsToken, 4, 0);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onImmsUpdate(ImeTracker.Token statsToken, String requestWindowName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        History.Entry entry = History.m4646$$Nest$mgetEntry(this.mHistory, statsToken.getBinder());     // Catch: Throwable -> L8
        if (entry != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        History.Entry.m4663$$Nest$fputmRequestWindowName(entry, requestWindowName);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter pw, String prefix) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        History.m4645$$Nest$mdump(this.mHistory, pw, prefix);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean hasPendingImeVisibilityRequests() {
        super.hasPendingImeVisibilityRequests_enforcePermission();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (History.m4643$$Nest$fgetmLiveEntries(this.mHistory).isEmpty() == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public void finishTrackingPendingImeVisibilityRequests(AndroidFuture completionSignal) {
        super.finishTrackingPendingImeVisibilityRequests_enforcePermission();
        Object r1 = this.mLock;     // Catch: Throwable -> L10
        monitor-enter(r1);     // Catch: Throwable -> L10
        History.m4643$$Nest$fgetmLiveEntries(this.mHistory).clear();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
    L8:
        completionSignal.complete(null);     // Catch: Throwable -> L10
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        e = move-exception;
        completionSignal.completeExceptionally(e);
    }
}
