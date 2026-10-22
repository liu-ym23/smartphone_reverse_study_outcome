package com.android.server.power.stats;

import android.util.IntArray;
import android.util.Slog;
import android.util.SparseIntArray;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PowerStatsUidResolver {
    private static final String TAG = "PowerStatsUidResolver";
    private final SparseIntArray mIsolatedUidRefCounts;
    private final SparseIntArray mIsolatedUids;
    private volatile List<Listener> mListeners;

    public interface Listener {
        void onAfterIsolatedUidRemoved(int r1, int r2);

        void onBeforeIsolatedUidRemoved(int r1, int r2);

        void onIsolatedUidAdded(int r1, int r2);
    }

    public PowerStatsUidResolver() {
        this.mIsolatedUids = new SparseIntArray();
        this.mIsolatedUidRefCounts = new SparseIntArray();
        this.mListeners = Collections.emptyList();
    }

    public void addListener(Listener listener) {
        monitor-enter(this);
        List<Listener> newList = new ArrayList(this.mListeners);     // Catch: Throwable -> L6
        newList.add(listener);     // Catch: Throwable -> L6
        this.mListeners = Collections.unmodifiableList(newList);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void removeListener(Listener listener) {
        monitor-enter(this);
        List<Listener> newList = new ArrayList(this.mListeners);     // Catch: Throwable -> L6
        newList.remove(listener);     // Catch: Throwable -> L6
        this.mListeners = Collections.unmodifiableList(newList);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void noteIsolatedUidAdded(int isolatedUid, int parentUid) {
        monitor-enter(this);
        this.mIsolatedUids.put(isolatedUid, parentUid);     // Catch: Throwable -> L10
        this.mIsolatedUidRefCounts.put(isolatedUid, 1);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        List<Listener> listeners = this.mListeners;
        int i = listeners.size() - 1;
    L6:
        if (i < 0) goto L9;
        listeners.get(i).onIsolatedUidAdded(isolatedUid, parentUid);
        i = i - 1;
        goto L6
    L9:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void noteIsolatedUidRemoved(int isolatedUid, int parentUid) {
        monitor-enter(this);
        int curUid = this.mIsolatedUids.get(isolatedUid, -1);     // Catch: Throwable -> L8
        if (curUid == parentUid) goto L11;
        Slog.wtf(TAG, "Attempt to remove an isolated UID " + isolatedUid + " with the parent UID " + parentUid + ". The registered parent UID is " + curUid);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L8
        List<Listener> listeners = this.mListeners;
        int i = listeners.size() - 1;
    L13:
        if (i < 0) goto L15;
        listeners.get(i).onBeforeIsolatedUidRemoved(isolatedUid, parentUid);
        i = i - 1;
        goto L13
    L15:
        releaseIsolatedUid(isolatedUid);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void retainIsolatedUid(int uid) {
        monitor-enter(this);
        int refCount = this.mIsolatedUidRefCounts.get(uid, 0);     // Catch: Throwable -> L8
        if (refCount > 0) goto L10;
        Slog.w(TAG, "Attempted to increment ref counted of untracked isolated uid (" + uid + ")");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        this.mIsolatedUidRefCounts.put(uid, refCount + 1);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void releaseIsolatedUid(int isolatedUid) {
        monitor-enter(this);
        int refCount = this.mIsolatedUidRefCounts.get(isolatedUid, 0) - 1;     // Catch: Throwable -> L8
        if (refCount <= 0) goto L10;
        this.mIsolatedUidRefCounts.put(isolatedUid, refCount);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        int idx = this.mIsolatedUids.indexOfKey(isolatedUid);     // Catch: Throwable -> L8
        if (idx < 0) goto L19;
        int parentUid = this.mIsolatedUids.valueAt(idx);     // Catch: Throwable -> L8
        this.mIsolatedUids.removeAt(idx);     // Catch: Throwable -> L8
        this.mIsolatedUidRefCounts.delete(isolatedUid);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        List<Listener> listeners = this.mListeners;
        int i = listeners.size() - 1;
    L15:
        if (i < 0) goto L18;
        listeners.get(i).onAfterIsolatedUidRemoved(isolatedUid, parentUid);
        i = i - 1;
        goto L15
    L18:
        return;
    L19:
        Slog.w(TAG, "Attempted to remove untracked child uid (" + isolatedUid + ")");     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void releaseUidsInRange(int startUid, int endUid) {
        monitor-enter(this);
        int startIndex = this.mIsolatedUids.indexOfKey(startUid);     // Catch: Throwable -> L11
        int endIndex = this.mIsolatedUids.indexOfKey(endUid);     // Catch: Throwable -> L11
        if (startIndex >= 0) goto L6;
        startIndex = ~startIndex;     // Catch: Throwable -> L11
    L6:
        if (endIndex >= 0) goto L8;
        endIndex = (~endIndex) - 1;     // Catch: Throwable -> L11
    L8:
        if (startIndex <= endIndex) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L13:
        IntArray toRelease = new IntArray(endIndex - startIndex);     // Catch: Throwable -> L11
        int i = startIndex;
    L14:
        if (i > endIndex) goto L17;
        toRelease.add(this.mIsolatedUids.keyAt(i));     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
        goto L14
    L17:
        monitor-exit(this);     // Catch: Throwable -> L11
        int i2 = toRelease.size() - 1;
    L19:
        if (i2 < 0) goto L22;
        releaseIsolatedUid(toRelease.get(i2));
        i2 = i2 - 1;
        goto L19
    L22:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public int mapUid(int uid) {
        monitor-enter(this);
        int r0 = this.mIsolatedUids.get(uid, uid);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter pw) {
        pw.println("Currently mapped isolated uids:");
        monitor-enter(this);
        int numIsolatedUids = this.mIsolatedUids.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= numIsolatedUids) goto L10;
        int isolatedUid = this.mIsolatedUids.keyAt(i);     // Catch: Throwable -> L7
        int ownerUid = this.mIsolatedUids.valueAt(i);     // Catch: Throwable -> L7
        int refs = this.mIsolatedUidRefCounts.get(isolatedUid);     // Catch: Throwable -> L7
        pw.println("  " + isolatedUid + "->" + ownerUid + " (ref count = " + refs + ")");     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
