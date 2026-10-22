package com.android.server.pm;

import android.content.pm.PackageManagerInternal;
import android.util.ArraySet;

/* JADX INFO: loaded from: classes2.dex */
class PackageObserverHelper {
    private ArraySet<PackageManagerInternal.PackageListObserver> mActiveSnapshot;
    private final Object mLock;

    PackageObserverHelper() {
        this.mLock = new Object();
        this.mActiveSnapshot = new ArraySet();
    }

    public void addObserver(PackageManagerInternal.PackageListObserver observer) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArraySet<PackageManagerInternal.PackageListObserver> set = new ArraySet(this.mActiveSnapshot);     // Catch: Throwable -> L7
        set.add(observer);     // Catch: Throwable -> L7
        this.mActiveSnapshot = set;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeObserver(PackageManagerInternal.PackageListObserver observer) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArraySet<PackageManagerInternal.PackageListObserver> set = new ArraySet(this.mActiveSnapshot);     // Catch: Throwable -> L7
        set.remove(observer);     // Catch: Throwable -> L7
        this.mActiveSnapshot = set;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyAdded(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArraySet<PackageManagerInternal.PackageListObserver> observers = this.mActiveSnapshot;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        int size = observers.size();
        int index = 0;
    L7:
        if (index >= size) goto L10;
        observers.valueAt(index).onPackageAdded(packageName, uid);
        index = index + 1;
        goto L7
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void notifyChanged(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArraySet<PackageManagerInternal.PackageListObserver> observers = this.mActiveSnapshot;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        int size = observers.size();
        int index = 0;
    L7:
        if (index >= size) goto L10;
        observers.valueAt(index).onPackageChanged(packageName, uid);
        index = index + 1;
        goto L7
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void notifyRemoved(String packageName, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArraySet<PackageManagerInternal.PackageListObserver> observers = this.mActiveSnapshot;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        int size = observers.size();
        int index = 0;
    L7:
        if (index >= size) goto L10;
        observers.valueAt(index).onPackageRemoved(packageName, uid);
        index = index + 1;
        goto L7
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
