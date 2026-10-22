package com.android.server.incident;

import android.os.Handler;
import android.os.IBinder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class RequestQueue {
    private final Handler mHandler;
    private ArrayList<Rec> mPending;
    private boolean mStarted;
    private final Runnable mWorker;

    private class Rec {
        public final IBinder key;
        public final Runnable runnable;
        public final boolean value;

        Rec(RequestQueue r1, IBinder key, boolean value, Runnable runnable) {
            this.key = key;
            this.value = value;
            this.runnable = runnable;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPending, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m4455$$Nest$fgetmPending(RequestQueue r0) {
        return r0.mPending;
    }

    RequestQueue(Handler handler) {
        this.mPending = new ArrayList();
        this.mWorker = new AnonymousClass1(this);
        this.mHandler = handler;
    }

    public void start() {
        ArrayList<Rec> r0 = this.mPending;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == false) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (this.mPending.size() <= 0) goto L11;
        this.mHandler.post(this.mWorker);     // Catch: Throwable -> L9
    L11:
        this.mStarted = true;     // Catch: Throwable -> L9
        goto L12
    }

    public void enqueue(IBinder key, boolean value, Runnable runnable) {
        ArrayList<Rec> r0 = this.mPending;
        monitor-enter(r0);
        boolean skip = false;
        if (value == false) goto L25;
    L16:
        if (skip == true) goto L19;
        this.mPending.add(new Rec(this, key, value, runnable));     // Catch: Throwable -> L13
    L19:
        if (this.mStarted == false) goto L21;
        this.mHandler.post(this.mWorker);     // Catch: Throwable -> L13
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L25:
        int i = this.mPending.size() - 1;     // Catch: Throwable -> L13
    L7:
        if (i < 0) goto L16;
        Rec r = this.mPending.get(i);     // Catch: Throwable -> L13
        if (r.key != key) goto L15;
        if (r.value == false) goto L15;
        skip = true;
        this.mPending.remove(i);     // Catch: Throwable -> L13
    L15:
        i = i - 1;     // Catch: Throwable -> L13
        goto L7
    }
}
