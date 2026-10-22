package com.android.server.utils;

import android.os.Handler;
import android.os.IBinder;
import android.os.TokenWatcher;
import android.util.SparseArray;
import com.android.internal.util.IndentingPrintWriter;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public final class UserTokenWatcher {
    private final Callback mCallback;
    private final Handler mHandler;
    private final String mTag;
    private final SparseArray<TokenWatcher> mWatchers;

    public interface Callback {
        void acquired(int r1);

        void released(int r1);
    }

    private final class InnerTokenWatcher extends TokenWatcher {
        private final int mUserId;
        final /* synthetic */ UserTokenWatcher this$0;

        /* synthetic */ InnerTokenWatcher(UserTokenWatcher r1, int r2, Handler r3, String r4, UserTokenWatcherIA r5) {
            this(r1, r2, r3, r4);
        }

        private InnerTokenWatcher(UserTokenWatcher r1, int userId, Handler handler, String tag) {
            this.this$0 = r1;
            super(handler, tag);
            this.mUserId = userId;
        }

        @Override // android.os.TokenWatcher
        public void acquired() {
            UserTokenWatcher.m9271$$Nest$fgetmCallback(this.this$0).acquired(this.mUserId);
        }

        @Override // android.os.TokenWatcher
        public void released() {
            UserTokenWatcher.m9271$$Nest$fgetmCallback(this.this$0).released(this.mUserId);
            SparseArray r0 = UserTokenWatcher.m9272$$Nest$fgetmWatchers(this.this$0);
            monitor-enter(r0);
            TokenWatcher watcher = (TokenWatcher) UserTokenWatcher.m9272$$Nest$fgetmWatchers(this.this$0).get(this.mUserId);     // Catch: Throwable -> L9
            if (watcher != null) goto L7;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L7:
            if (watcher.isAcquired() == true) goto L11;
            UserTokenWatcher.m9272$$Nest$fgetmWatchers(this.this$0).remove(this.mUserId);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ Callback m9271$$Nest$fgetmCallback(UserTokenWatcher r0) {
        return r0.mCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWatchers, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m9272$$Nest$fgetmWatchers(UserTokenWatcher r0) {
        return r0.mWatchers;
    }

    public UserTokenWatcher(Callback callback, Handler handler, String tag) {
        this.mWatchers = new SparseArray(1);
        this.mCallback = callback;
        this.mHandler = handler;
        this.mTag = tag;
    }

    public void acquire(IBinder token, String tag, int userId) {
        SparseArray<TokenWatcher> r1 = this.mWatchers;
        monitor-enter(r1);
        TokenWatcher watcher = this.mWatchers.get(userId);     // Catch: Throwable -> L11
        if (watcher != null) goto L14;
        watcher = new InnerTokenWatcher(this, userId, this.mHandler, this.mTag, null);     // Catch: Throwable -> L9
        this.mWatchers.put(userId, watcher);     // Catch: Throwable -> L9
    L14:
        watcher.acquire(token, tag);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Throwable r11 = th;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r11;
    L11:
        th = move-exception;
        r11 = th;
        goto L17
    }

    public void release(IBinder token, int userId) {
        SparseArray<TokenWatcher> r0 = this.mWatchers;
        monitor-enter(r0);
        TokenWatcher watcher = this.mWatchers.get(userId);     // Catch: Throwable -> L7
        if (watcher == null) goto L9;
        watcher.release(token);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isAcquired(int userId) {
        SparseArray<TokenWatcher> r0 = this.mWatchers;
        monitor-enter(r0);
        TokenWatcher watcher = this.mWatchers.get(userId);     // Catch: Throwable -> L9
        if (watcher != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (watcher.isAcquired() == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    public void dump(PrintWriter pw) {
        SparseArray<TokenWatcher> r0 = this.mWatchers;
        monitor-enter(r0);
        int i = 0;
    L18:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mWatchers.size()) goto L14;
        int userId = this.mWatchers.keyAt(i);     // Catch: Throwable -> L10
        TokenWatcher watcher = this.mWatchers.valueAt(i);     // Catch: Throwable -> L10
        if (watcher.isAcquired() == false) goto L12;
        pw.print("User ");     // Catch: Throwable -> L10
        pw.print(userId);     // Catch: Throwable -> L10
        pw.println(":");     // Catch: Throwable -> L10
        watcher.dump(new IndentingPrintWriter(pw, " "));     // Catch: Throwable -> L10
    L12:
        i = i + 1;     // Catch: Throwable -> L10
        goto L18
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }
}
