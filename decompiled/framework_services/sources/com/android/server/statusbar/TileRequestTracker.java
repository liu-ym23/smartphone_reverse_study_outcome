package com.android.server.statusbar;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.SparseArrayMap;
import com.android.server.pm.Settings;
import java.io.FileDescriptor;

/* JADX INFO: loaded from: classes3.dex */
public class TileRequestTracker {
    static final int MAX_NUM_DENIALS = 3;
    private final ArraySet<ComponentName> mComponentsToRemove;
    private final Context mContext;
    private final Object mLock;
    private final SparseArrayMap<ComponentName, Integer> mTrackingMap;
    private final BroadcastReceiver mUninstallReceiver;

    /* JADX INFO: renamed from: $r8$lambda$a6r2fq-pg1Ki7hg9Ok5_2Tn97TA, reason: not valid java name */
    public static /* synthetic */ void m8413$r8$lambda$a6r2fqpg1Ki7hg9Ok5_2Tn97TA(IndentingPrintWriter r0, int r1, ComponentName r2, Integer r3) {
        lambda$dump$0(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmComponentsToRemove, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m8414$$Nest$fgetmComponentsToRemove(TileRequestTracker r0) {
        return r0.mComponentsToRemove;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8415$$Nest$fgetmLock(TileRequestTracker r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTrackingMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArrayMap m8416$$Nest$fgetmTrackingMap(TileRequestTracker r0) {
        return r0.mTrackingMap;
    }

    TileRequestTracker(Context context) {
        this.mLock = new Object();
        this.mTrackingMap = new SparseArrayMap();
        this.mComponentsToRemove = new ArraySet();
        this.mUninstallReceiver = new AnonymousClass1(this);
        this.mContext = context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        intentFilter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mContext.registerReceiverAsUser(this.mUninstallReceiver, UserHandle.ALL, intentFilter, null, null);
    }

    boolean shouldBeDenied(int userId, ComponentName componentName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = false;
        if (((Integer) this.mTrackingMap.getOrDefault(userId, componentName, 0)).intValue() < 3) goto L7;
        r2 = true;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    void addDenial(int userId, ComponentName componentName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int current = ((Integer) this.mTrackingMap.getOrDefault(userId, componentName, 0)).intValue();     // Catch: Throwable -> L7
        this.mTrackingMap.add(userId, componentName, Integer.valueOf(current + 1));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void resetRequests(int userId, ComponentName componentName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTrackingMap.delete(userId, componentName);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void dump(FileDescriptor fd, final IndentingPrintWriter pw, String[] args) {
        pw.println("TileRequestTracker:");
        pw.increaseIndent();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTrackingMap.forEach(new TileRequestTracker$$ExternalSyntheticLambda0(pw));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        pw.decreaseIndent();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$dump$0(IndentingPrintWriter pw, int user, ComponentName componentName, Integer value) {
        pw.println("user=" + user + ", " + componentName.toShortString() + ": " + value);
    }
}
