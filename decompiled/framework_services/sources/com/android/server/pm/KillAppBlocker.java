package com.android.server.pm;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.IActivityManager;
import android.app.IUidObserver;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
final class KillAppBlocker {
    private static final int MAX_WAIT_TIMEOUT_MS = 1000;
    private List mActiveUids;
    private boolean mRegistered;
    private final IUidObserver mUidObserver;
    private CountDownLatch mUidsGoneCountDownLatch;

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m6692$$Nest$fgetmActiveUids(KillAppBlocker r0) {
        return r0.mActiveUids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUidsGoneCountDownLatch, reason: not valid java name */
    static /* bridge */ /* synthetic */ CountDownLatch m6693$$Nest$fgetmUidsGoneCountDownLatch(KillAppBlocker r0) {
        return r0.mUidsGoneCountDownLatch;
    }

    KillAppBlocker() {
        this.mUidsGoneCountDownLatch = new CountDownLatch(1);
        this.mActiveUids = new ArrayList();
        this.mRegistered = false;
        this.mUidObserver = new AnonymousClass1(this);
    }

    void register() {
        if (this.mRegistered == true) goto L12;
        IActivityManager am = ActivityManager.getService();
        if (am == null) goto L13;
        am.registerUidObserver(this.mUidObserver, 2, -1, "pm");     // Catch: RemoteException -> L8
        this.mRegistered = true;     // Catch: RemoteException -> L8
        return;
    L9:
        return;
    L13:
        return;
    }

    void unregister() {
        if (this.mRegistered == false) goto L13;
        IActivityManager am = ActivityManager.getService();
        if (am != null) goto L11;
        return;
    L11:
        this.mRegistered = false;     // Catch: RemoteException -> L9
        am.unregisterUidObserver(this.mUidObserver);     // Catch: RemoteException -> L9
        return;
    L10:
        return;
    }

    void waitAppProcessGone(ActivityManagerInternal ami, Computer snapshot, UserManagerService userManager, String packageName) {
        if (this.mRegistered == true) goto L5;
        return;
    L5:
        monitor-enter(this);
        if (ami == null) goto L25;
        int[] users = userManager.getUserIds();     // Catch: Throwable -> L20
        int i = 0;
    L9:
        if (i >= users.length) goto L25;
        int userId = users[i];     // Catch: Throwable -> L20
        Computer snapshot2 = snapshot;
        String packageName2 = packageName;
        int uid = snapshot2.getPackageUidInternal(packageName2, 131072, userId, 1000);     // Catch: Throwable -> L17
        if (uid == (-1)) goto L19;
        if (ami.getUidProcessState(uid) == 20) goto L19;
        this.mActiveUids.add(Integer.valueOf(uid));     // Catch: Throwable -> L17
    L19:
        i = i + 1;     // Catch: Throwable -> L17
        snapshot = snapshot2;
        packageName = packageName2;
    L20:
        th = move-exception;
        Throwable r11 = th;
    L33:
        monitor-exit(this);     // Catch: Throwable -> L17
        throw r11;
    L25:
        if (this.mActiveUids.size() != 0) goto L28;
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L28:
        monitor-exit(this);     // Catch: Throwable -> L17
        this.mUidsGoneCountDownLatch.await(1000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L31
        return;
    L32:
        return;
    L17:
        th = move-exception;
        r11 = th;
        goto L33
    }
}
