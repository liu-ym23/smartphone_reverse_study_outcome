package com.android.server.am;

import android.os.SystemClock;
import android.os.UserHandle;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes.dex */
public class FgsTempAllowList<E> {
    private static final int DEFAULT_MAX_SIZE = 100;
    private final Object mLock;
    private int mMaxSize;
    private final SparseArray<Pair<Long, E>> mTempAllowList;

    public FgsTempAllowList() {
        this.mTempAllowList = new SparseArray();
        this.mMaxSize = 100;
        this.mLock = new Object();
    }

    public FgsTempAllowList(int maxSize) {
        this.mTempAllowList = new SparseArray();
        this.mMaxSize = 100;
        this.mLock = new Object();
        if (maxSize > 0) goto L5;
        Slog.e("ActivityManager", "Invalid FgsTempAllowList maxSize:" + maxSize + ", force default maxSize:100");
        this.mMaxSize = 100;
        return;
    L5:
        this.mMaxSize = maxSize;
    }

    public void add(int uid, long durationMs, E entry) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (durationMs > 0) goto L11;
        Slog.e("ActivityManager", "FgsTempAllowList bad duration:" + durationMs + " key: " + uid);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        int size = this.mTempAllowList.size();     // Catch: Throwable -> L9
        if (size <= this.mMaxSize) goto L19;
        Slog.w("ActivityManager", "FgsTempAllowList length:" + size + " exceeds maxSize" + this.mMaxSize);     // Catch: Throwable -> L9
        int index = size + (-1);     // Catch: Throwable -> L9
    L14:
        if (index < 0) goto L19;
        if (((Long) this.mTempAllowList.valueAt(index).first).longValue() >= now) goto L18;
        this.mTempAllowList.removeAt(index);     // Catch: Throwable -> L9
    L18:
        index = index - 1;     // Catch: Throwable -> L9
    L19:
        Pair<Long, E> existing = this.mTempAllowList.get(uid);     // Catch: Throwable -> L9
        long expirationTime = now + durationMs;     // Catch: Throwable -> L9
        if (existing != null) goto L22;
    L23:
        this.mTempAllowList.put(uid, new Pair(Long.valueOf(expirationTime), entry));     // Catch: Throwable -> L9
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L22:
        if (((Long) existing.first).longValue() >= expirationTime) goto L24;
    L9:
        th = move-exception;
        throw th;
    }

    public Pair<Long, E> get(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int index = this.mTempAllowList.indexOfKey(uid);     // Catch: Throwable -> L8
        if (index >= 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L10:
        long timeNow = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
        if (((Long) this.mTempAllowList.valueAt(index).first).longValue() >= timeNow) goto L15;
        this.mTempAllowList.removeAt(index);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L15:
        Pair<Long, E> r2 = this.mTempAllowList.valueAt(index);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isAllowed(int uid) {
        Pair<Long, E> entry = get(uid);
        if (entry == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void removeUid(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTempAllowList.remove(uid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeAppId(int appId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = this.mTempAllowList.size() - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L13;
        int uid = this.mTempAllowList.keyAt(i);     // Catch: Throwable -> L9
        if (UserHandle.getAppId(uid) != appId) goto L11;
        this.mTempAllowList.removeAt(i);     // Catch: Throwable -> L9
    L11:
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void forEach(BiConsumer<Integer, Pair<Long, E>> callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L18:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mTempAllowList.size()) goto L14;
        int uid = this.mTempAllowList.keyAt(i);     // Catch: Throwable -> L10
        Pair<Long, E> entry = this.mTempAllowList.valueAt(i);     // Catch: Throwable -> L10
        if (entry == null) goto L12;
        callback.accept(Integer.valueOf(uid), entry);     // Catch: Throwable -> L10
    L12:
        i = i + 1;     // Catch: Throwable -> L10
        goto L18
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }
}
