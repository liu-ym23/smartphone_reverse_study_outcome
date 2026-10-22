package com.android.server.wm;

import android.app.ActivityOptions;
import android.os.Handler;
import android.os.IBinder;
import android.util.ArrayMap;
import android.view.RemoteAnimationAdapter;

/* JADX INFO: loaded from: classes3.dex */
class PendingRemoteAnimationRegistry {
    static final long TIMEOUT_MS = 3000;
    private final ArrayMap<String, Entry> mEntries;
    private final Handler mHandler;
    private final WindowManagerGlobalLock mLock;

    private class Entry {
        final RemoteAnimationAdapter adapter;
        final IBinder launchCookie;
        final String packageName;
        final /* synthetic */ PendingRemoteAnimationRegistry this$0;

        public static /* synthetic */ void $r8$lambda$7b7K_tF1GgqxuvfF0SqaYWXxBTk(Entry r0, String r1) {
            r0.lambda$new$0(r1);
        }

        Entry(PendingRemoteAnimationRegistry r4, final String packageName, RemoteAnimationAdapter adapter, IBinder launchCookie) {
            this.this$0 = r4;
            this.packageName = packageName;
            this.adapter = adapter;
            this.launchCookie = launchCookie;
            PendingRemoteAnimationRegistry.m10076$$Nest$fgetmHandler(r4).postDelayed(new PendingRemoteAnimationRegistry$Entry$$ExternalSyntheticLambda0(this, packageName), 3000);
        }

        private /* synthetic */ void lambda$new$0(String packageName) {
            WindowManagerGlobalLock r0 = PendingRemoteAnimationRegistry.m10077$$Nest$fgetmLock(this.this$0);
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            Entry entry = (Entry) PendingRemoteAnimationRegistry.m10075$$Nest$fgetmEntries(this.this$0).get(packageName);     // Catch: Throwable -> L7
            if (entry != this) goto L9;
            PendingRemoteAnimationRegistry.m10075$$Nest$fgetmEntries(this.this$0).remove(packageName);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L7:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEntries, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m10075$$Nest$fgetmEntries(PendingRemoteAnimationRegistry r0) {
        return r0.mEntries;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m10076$$Nest$fgetmHandler(PendingRemoteAnimationRegistry r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerGlobalLock m10077$$Nest$fgetmLock(PendingRemoteAnimationRegistry r0) {
        return r0.mLock;
    }

    PendingRemoteAnimationRegistry(WindowManagerGlobalLock lock, Handler handler) {
        this.mEntries = new ArrayMap();
        this.mLock = lock;
        this.mHandler = handler;
    }

    void addPendingAnimation(String packageName, RemoteAnimationAdapter adapter, IBinder launchCookie) {
        this.mEntries.put(packageName, new Entry(this, packageName, adapter, launchCookie));
    }

    ActivityOptions overrideOptionsIfNeeded(String callingPackage, ActivityOptions options) {
        Entry entry = this.mEntries.get(callingPackage);
        if (entry != null) goto L5;
        return options;
    L5:
        if (options != null) goto L7;
        options = ActivityOptions.makeRemoteAnimation(entry.adapter);
    L8:
        IBinder launchCookie = entry.launchCookie;
        if (launchCookie == null) goto L11;
        options.setLaunchCookie(launchCookie);
    L11:
        this.mEntries.remove(callingPackage);
        return options;
    L7:
        options.setRemoteAnimationAdapter(entry.adapter);
        goto L8
    }
}
