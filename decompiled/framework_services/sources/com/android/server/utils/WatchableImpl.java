package com.android.server.utils;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class WatchableImpl implements Watchable {
    protected final ArrayList<Watcher> mObservers;
    private boolean mSealed;

    public WatchableImpl() {
        this.mObservers = new ArrayList();
        this.mSealed = false;
    }

    @Override // com.android.server.utils.Watchable
    public void registerObserver(Watcher observer) {
        observer.getClass();
        ArrayList<Watcher> r0 = this.mObservers;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mObservers.contains(observer) == true) goto L9;
        this.mObservers.add(observer);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    @Override // com.android.server.utils.Watchable
    public void unregisterObserver(Watcher observer) {
        observer.getClass();
        ArrayList<Watcher> r0 = this.mObservers;
        monitor-enter(r0);
        this.mObservers.remove(observer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.utils.Watchable
    public boolean isRegisteredObserver(Watcher observer) {
        ArrayList<Watcher> r0 = this.mObservers;
        monitor-enter(r0);
        boolean r1 = this.mObservers.contains(observer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int registeredObserverCount() {
        ArrayList<Watcher> r0 = this.mObservers;
        monitor-enter(r0);
        int r1 = this.mObservers.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.utils.Watchable
    public void dispatchChange(Watchable what) {
        ArrayList<Watcher> r0 = this.mObservers;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mSealed == true) goto L15;
        int end = this.mObservers.size();     // Catch: Throwable -> L9
        int i = 0;
    L7:
        if (i >= end) goto L12;
        this.mObservers.get(i).onChange(what);     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L15:
        throw new IllegalStateException("attempt to change a sealed object");     // Catch: Throwable -> L9
    }

    public void seal() {
        ArrayList<Watcher> r0 = this.mObservers;
        monitor-enter(r0);
        this.mSealed = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isSealed() {
        ArrayList<Watcher> r0 = this.mObservers;
        monitor-enter(r0);
        boolean r1 = this.mSealed;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
